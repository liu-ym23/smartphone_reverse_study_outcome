package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Xml;
import androidx.compose.material3.MenuKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class ActivityChooserModel extends DataSetObservable {
    static final String ATTRIBUTE_ACTIVITY = "activity";
    static final String ATTRIBUTE_TIME = "time";
    static final String ATTRIBUTE_WEIGHT = "weight";
    static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    static final String LOG_TAG = null;
    static final String TAG_HISTORICAL_RECORD = "historical-record";
    static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map<String, ActivityChooserModel> sDataModelRegistry = null;
    private static final Object sRegistryLock = null;
    private final List<ActivityResolveInfo> mActivities;
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter;
    boolean mCanReadHistoricalData;
    final Context mContext;
    private final List<HistoricalRecord> mHistoricalRecords;
    private boolean mHistoricalRecordsChanged;
    final String mHistoryFileName;
    private int mHistoryMaxSize;
    private final Object mInstanceLock;
    private Intent mIntent;
    private boolean mReadShareHistoryCalled;
    private boolean mReloadActivities;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel r1);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        public ActivityResolveInfo(ResolveInfo r1) {
            this.resolveInfo = r1;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ActivityResolveInfo r2) {
            return Float.floatToIntBits(r2.weight) - Float.floatToIntBits(this.weight);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (ActivityResolveInfo.class == r5.getClass()) goto L12;
            return false;
        L12:
            if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) r5).weight)) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ActivityResolveInfo r1) {
            return compareTo2(r1);
        }
    }

    public interface ActivitySorter {
        void sort(Intent r1, List<ActivityResolveInfo> r2, List<HistoricalRecord> r3);
    }

    public static final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<ComponentName, ActivityResolveInfo> mPackageNameToActivityMap;

        public DefaultSorter() {
            this.mPackageNameToActivityMap = new HashMap();
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent r7, List<ActivityResolveInfo> r8, List<HistoricalRecord> r9) {
            Map<ComponentName, ActivityResolveInfo> r10 = this.mPackageNameToActivityMap;
            r10.clear();
            int r0 = r8.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            ActivityResolveInfo r2 = (ActivityResolveInfo) ListProtector.get(r8, r1);
            r2.weight = MenuKt.ClosedAlphaTarget;
            ActivityInfo r4 = r2.resolveInfo.activityInfo;
            r10.put(new ComponentName(r4.packageName, r4.name), r2);
            r1 = r1 + 1;
            goto L3
        L5:
            int r3 = r9.size() - 1;
            float r5 = 1.0f;
        L6:
            if (r3 < 0) goto L11;
            HistoricalRecord r6 = (HistoricalRecord) ListProtector.get(r9, r3);
            ActivityResolveInfo r11 = r10.get(r6.activity);
            if (r11 == null) goto L10;
            r11.weight += r6.weight * r5;
            r5 = r5 * WEIGHT_DECAY_COEFFICIENT;
        L10:
            r3 = r3 - 1;
            goto L6
        L11:
            Collections.sort(r8);
        }
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public int hashCode() {
            ComponentName r0 = this.activity;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            long r2 = this.time;
            return ((((r1 + 31) * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if (r8 != null) goto L9;
            return false;
        L9:
            if (HistoricalRecord.class == r8.getClass()) goto L11;
            return false;
        L11:
            HistoricalRecord r9 = (HistoricalRecord) r8;
            ComponentName r2 = this.activity;
            if (r2 != null) goto L17;
            if (r9.activity == null) goto L20;
            return false;
        L20:
            if (this.time == r9.time) goto L23;
            return false;
        L23:
            if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(r9.weight)) goto L25;
            return false;
        L25:
            return true;
        L17:
            if (r2.equals(r9.activity) == true) goto L20;
            return false;
        }

        public HistoricalRecord(ComponentName r1, long r2, float r4) {
            this.activity = r1;
            this.time = r2;
            this.weight = r4;
        }

        public HistoricalRecord(String r1, long r2, float r4) {
            this(ComponentName.unflattenFromString(r1), r2, r4);
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel r1, Intent r2);
    }

    public final class PersistHistoryAsyncTask extends PthreadAsyncTask<Object, Void, Void> {
        final /* synthetic */ ActivityChooserModel this$0;

        public PersistHistoryAsyncTask(ActivityChooserModel r1) {
            this.this$0 = r1;
        }

        /* JADX INFO: renamed from: doInBackground, reason: collision with other method in class */
        public Void m71doInBackground(Object... r14) {
            List r3 = (List) r14[0];
            String r15 = (String) r14[1];
            FileOutputStream r16 = this.this$0.mContext.openFileOutput(r15, 0);     // Catch: FileNotFoundException -> L32
            XmlSerializer r6 = Xml.newSerializer();
            r6.setOutput(r16, null);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r6.startDocument("UTF-8", Boolean.TRUE);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r6.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            int r7 = r3.size();     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            int r8 = 0;
        L6:
            if (r8 >= r7) goto L8;
            HistoricalRecord r9 = (HistoricalRecord) r3.remove(0);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r6.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r6.attribute(null, ActivityChooserModel.ATTRIBUTE_ACTIVITY, r9.activity.flattenToString());     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r6.attribute(null, ActivityChooserModel.ATTRIBUTE_TIME, String.valueOf(r9.time));     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r6.attribute(null, ActivityChooserModel.ATTRIBUTE_WEIGHT, String.valueOf(r9.weight));     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r6.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r8 = r8 + 1;     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            goto L6
        L8:
            r6.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r6.endDocument();     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            this.this$0.mCanReadHistoricalData = true;
            if (r16 != null) goto L36;
        L27:
            return null;
        L36:
            r16.close();     // Catch: IOException -> L34
            goto L27
        L13:
            th = move-exception;
            this.this$0.mCanReadHistoricalData = true;
            if (r16 != null) goto L40;
        L31:
            throw th;
        L40:
            r16.close();     // Catch: IOException -> L35
        L15:
            String r0 = ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME;     // Catch: Throwable -> L13
            ActivityChooserModel r1 = this.this$0;     // Catch: Throwable -> L13
            String r2 = r1.mHistoryFileName;     // Catch: Throwable -> L13
            r1.mCanReadHistoricalData = true;
            if (r16 == null) goto L27;
        L23:
            String r4 = ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME;     // Catch: Throwable -> L13
            ActivityChooserModel r5 = this.this$0;     // Catch: Throwable -> L13
            String r10 = r5.mHistoryFileName;     // Catch: Throwable -> L13
            r5.mCanReadHistoricalData = true;
            if (r16 == null) goto L27;
        L19:
            String r11 = ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME;     // Catch: Throwable -> L13
            ActivityChooserModel r12 = this.this$0;     // Catch: Throwable -> L13
            String r13 = r12.mHistoryFileName;     // Catch: Throwable -> L13
            r12.mCanReadHistoricalData = true;
            if (r16 == null) goto L27;
        L32:
            String r17 = ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME;
            return null;
        }

        public /* bridge */ /* synthetic */ Object doInBackground(Object[] r1) {
            return m71doInBackground(r1);
        }
    }

    static {
        LOG_TAG = "ActivityChooserModel";
        sRegistryLock = new Object();
        sDataModelRegistry = new HashMap();
    }

    private boolean loadActivitiesIfNeeded() {
        int r1 = 0;
        if (this.mReloadActivities == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mIntent == null) goto L11;
        this.mReloadActivities = false;
        this.mActivities.clear();
        List<ResolveInfo> r0 = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int r2 = r0.size();
    L7:
        if (r1 >= r2) goto L9;
        ResolveInfo r3 = (ResolveInfo) ListProtector.get(r0, r1);
        this.mActivities.add(new ActivityResolveInfo(r3));
        r1 = r1 + 1;
        goto L7
    L9:
        return true;
    }

    private void persistHistoricalDataIfNeeded() {
        if (this.mReadShareHistoryCalled == false) goto L12;
        if (this.mHistoricalRecordsChanged == true) goto L7;
        return;
    L7:
        this.mHistoricalRecordsChanged = false;
        if (TextUtils.isEmpty(this.mHistoryFileName) == true) goto L13;
        new PersistHistoryAsyncTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.mHistoricalRecords), this.mHistoryFileName});
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("No preceding call to #readHistoricalData");
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int r0 = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (r0 > 0) goto L5;
        return;
    L5:
        this.mHistoricalRecordsChanged = true;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        HistoricalRecord r3 = (HistoricalRecord) ListProtector.remove(this.mHistoricalRecords, 0);
        r2 = r2 + 1;
        goto L6
    }

    private boolean readHistoricalDataIfNeeded() {
        if (this.mCanReadHistoricalData == true) goto L5;
    L10:
        return false;
    L5:
        if (this.mHistoricalRecordsChanged == false) goto L10;
        if (TextUtils.isEmpty(this.mHistoryFileName) == true) goto L10;
        this.mCanReadHistoricalData = false;
        this.mReadShareHistoryCalled = true;
        readHistoricalDataImpl();
        return true;
    }

    private void readHistoricalDataImpl() {
        FileInputStream r0 = this.mContext.openFileInput(this.mHistoryFileName);     // Catch: FileNotFoundException -> L41
        XmlPullParser r1 = Xml.newPullParser();     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
        r1.setInput(r0, "UTF-8");     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
        int r2 = 0;
    L5:
        if (r2 == 1) goto L10;
        if (r2 == 2) goto L10;
        r2 = r1.next();     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
    L10:
        if (TAG_HISTORICAL_RECORDS.equals(r1.getName()) == false) goto L28;
        List<HistoricalRecord> r3 = this.mHistoricalRecords;     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
        r3.clear();     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
    L12:
        int r4 = r1.next();     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
        if (r4 == 1) goto L14;
        if (r4 == 3) goto L12;
        if (r4 == 4) goto L12;
        if (TAG_HISTORICAL_RECORD.equals(r1.getName()) == false) goto L26;
        r3.add(new HistoricalRecord(r1.getAttributeValue(null, ATTRIBUTE_ACTIVITY), Long.parseLong(r1.getAttributeValue(null, ATTRIBUTE_TIME)), Float.parseFloat(r1.getAttributeValue(null, ATTRIBUTE_WEIGHT))));     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
        goto L12
    L26:
        throw new XmlPullParserException("Share records file not well-formed.");     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
    L14:
        if (r0 != null) goto L49;
        return;
    L49:
        r0.close();     // Catch: IOException -> L42
        return;
    L64:
        return;
    L28:
        throw new XmlPullParserException("Share records file does not start with historical-records tag.");     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
    L29:
        th = move-exception;
        if (r0 != null) goto L47;
    L40:
        throw th;
    L47:
        r0.close();     // Catch: IOException -> L43
        goto L40
    L32:
        if (r0 != null) goto L49;
        return;
    L35:
        if (r0 != null) goto L49;
        return;
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter != null) goto L5;
        return false;
    L5:
        if (this.mIntent != null) goto L7;
        return false;
    L7:
        if (this.mActivities.isEmpty() == false) goto L9;
        return false;
    L9:
        if (this.mHistoricalRecords.isEmpty() == true) goto L16;
        this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
        return true;
    L16:
        return false;
    }

    public int getActivityCount() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L7
        int r1 = this.mActivities.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public ResolveInfo getDefaultActivity() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L12
        if (this.mActivities.isEmpty() == true) goto L9;
        ResolveInfo r1 = this.mActivities.get(0).resolveInfo;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public int getHistoryMaxSize() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        int r1 = this.mHistoryMaxSize;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getHistorySize() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L7
        int r1 = this.mHistoricalRecords.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Intent getIntent() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        Intent r1 = this.mIntent;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void ensureConsistentState() {
        boolean r0 = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (r0 == false) goto L6;
        sortActivitiesIfNeeded();
        notifyChanged();
        return;
    }

    private boolean addHistoricalRecord(HistoricalRecord r2) {
        boolean r3 = this.mHistoricalRecords.add(r2);
        if (r3 == false) goto L5;
        this.mHistoricalRecordsChanged = true;
        pruneExcessiveHistoricalRecordsIfNeeded();
        persistHistoricalDataIfNeeded();
        sortActivitiesIfNeeded();
        notifyChanged();
    L5:
        return r3;
    }

    public Intent chooseActivity(int r7) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntent != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return null;
    L8:
        ensureConsistentState();     // Catch: Throwable -> L17
        ActivityInfo r8 = this.mActivities.get(r7).resolveInfo.activityInfo;     // Catch: Throwable -> L17
        ComponentName r1 = new ComponentName(r8.packageName, r8.name);     // Catch: Throwable -> L17
        Intent r9 = new Intent(this.mIntent);     // Catch: Throwable -> L17
        r9.setComponent(r1);     // Catch: Throwable -> L17
        if (this.mActivityChoserModelPolicy == null) goto L14;
        Intent r3 = new Intent(r9);     // Catch: Throwable -> L17
        if (this.mActivityChoserModelPolicy.onChooseActivity(this, r3) == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return null;
    L14:
        addHistoricalRecord(new HistoricalRecord(r1, System.currentTimeMillis(), 1.0f));     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r9;
    }

    public ResolveInfo getActivity(int r3) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L7
        ResolveInfo r4 = this.mActivities.get(r3).resolveInfo;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    public int getActivityIndex(ResolveInfo r6) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L14
        List<ActivityResolveInfo> r1 = this.mActivities;     // Catch: Throwable -> L14
        int r2 = r1.size();     // Catch: Throwable -> L14
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        if (r1.get(r3).resolveInfo == r6) goto L8;
        r3 = r3 + 1;     // Catch: Throwable -> L14
        goto L5
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r3;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return -1;
    L14:
        th = move-exception;
        throw th;
    }

    public void setActivitySorter(ActivitySorter r3) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mActivitySorter != r3) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        this.mActivitySorter = r3;     // Catch: Throwable -> L13
        if (sortActivitiesIfNeeded() == false) goto L11;
        notifyChanged();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public void setDefaultActivity(int r6) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L11
        ActivityResolveInfo r7 = this.mActivities.get(r6);     // Catch: Throwable -> L11
        ActivityResolveInfo r1 = this.mActivities.get(0);     // Catch: Throwable -> L11
        if (r1 == null) goto L7;
        float r2 = (r1.weight - r7.weight) + 5.0f;     // Catch: Throwable -> L11
    L8:
        ActivityInfo r8 = r7.resolveInfo.activityInfo;     // Catch: Throwable -> L11
        addHistoricalRecord(new HistoricalRecord(new ComponentName(r8.packageName, r8.name), System.currentTimeMillis(), r2));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        r2 = 1.0f;
    L11:
        th = move-exception;
        throw th;
    }

    public void setHistoryMaxSize(int r3) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mHistoryMaxSize != r3) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        this.mHistoryMaxSize = r3;     // Catch: Throwable -> L13
        pruneExcessiveHistoricalRecordsIfNeeded();     // Catch: Throwable -> L13
        if (sortActivitiesIfNeeded() == false) goto L11;
        notifyChanged();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public void setIntent(Intent r3) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntent != r3) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.mIntent = r3;     // Catch: Throwable -> L11
        this.mReloadActivities = true;     // Catch: Throwable -> L11
        ensureConsistentState();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void setOnChooseActivityListener(OnChooseActivityListener r2) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        this.mActivityChoserModelPolicy = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ActivityChooserModel(Context r3, String r4) {
        this.mInstanceLock = new Object();
        this.mActivities = new ArrayList();
        this.mHistoricalRecords = new ArrayList();
        this.mActivitySorter = new DefaultSorter();
        this.mHistoryMaxSize = 50;
        this.mCanReadHistoricalData = true;
        this.mReadShareHistoryCalled = false;
        this.mHistoricalRecordsChanged = true;
        this.mReloadActivities = false;
        this.mContext = r3.getApplicationContext();
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L7:
        this.mHistoryFileName = r4;
        return;
    L5:
        if (r4.endsWith(HISTORY_FILE_EXTENSION) == true) goto L7;
        this.mHistoryFileName = r4.concat(HISTORY_FILE_EXTENSION);
    }

    public static ActivityChooserModel get(Context r3, String r4) {
        Object r0 = sRegistryLock;
        monitor-enter(r0);
        Map<String, ActivityChooserModel> r1 = sDataModelRegistry;     // Catch: Throwable -> L9
        ActivityChooserModel r2 = r1.get(r4);     // Catch: Throwable -> L9
        if (r2 != null) goto L7;
        r2 = new ActivityChooserModel(r3, r4);     // Catch: Throwable -> L9
        r1.put(r4, r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }
}
