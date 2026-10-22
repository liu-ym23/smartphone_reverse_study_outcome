package com.ss.android.lark.appcontext.applifecycle;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
public final class AppLifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f408778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f408779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<Activity> f408780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ActivityRecorder f408781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference<Activity> f408782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, WeakReference<Activity>> f408783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, WeakReference<Activity>> f408784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArrayList<y> f408785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.ss.android.lark.appcontext.applifecycle.a> f408786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public y.a f408787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f408788k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n f408789l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f408790m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f408791n;

    public static class LifecycleContentProvider extends ContentProvider {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static Uri f408792g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<ProcessRecord> f408793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ProcessRecord> f408794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<ProcessRecord> f408795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f408796d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f408797e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f408798f;

        /* JADX INFO: loaded from: classes34.dex */
        public class a implements Function1<ProcessRecord, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ProcessRecord f408799a;

            public a(ProcessRecord r100) {
                this.f408799a = r100;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ProcessRecord r100) {
                return Boolean.valueOf(this.f408799a.f408801b.equals(r100.f408801b));
            }
        }

        @Override // android.content.ContentProvider
        public final boolean onCreate() {
            this.f408797e = false;
            Context r100 = getContext();
            if (r100 != null) goto L6;
            Log.e("AppLifecycle", "onCreate get context is null, so return");
            return false;
        L6:
            Context r101 = r100.getApplicationContext();
            if (r101 != null) goto L10;
            Log.e("AppLifecycle", "getForegroundProcess: context is null, so return");
        L14:
            Log.i("AppLifecycle", "onCreate: init top process is " + this.f408796d);
            return true;
        L10:
            if (a.f408803a.f408790m == false) goto L14;
            if (com.larksuite.framework.utils.z.d(r101) == false) goto L14;
            this.f408796d = "foreground";
            goto L14
        }

        public LifecycleContentProvider() {
            this.f408793a = new ArrayList(2);
            this.f408794b = new ArrayList(2);
            this.f408795c = new ArrayList();
            this.f408798f = new b();
        }

        public static Uri a(Context r100) {
            if (f408792g != null) goto L6;
            f408792g = UriProtector.parse("content://" + r100.getPackageName() + ".provider.applifecycle");
        L6:
            return f408792g;
        }

        @Override // android.content.ContentProvider
        public String getType(Uri r100) {
            Log.e("AppLifecycle", "getType not support yet!");
            return null;
        }

        @Override // android.content.ContentProvider
        public Uri insert(Uri r100, ContentValues r101) {
            Log.e("AppLifecycle", "insert not support yet!");
            return r100;
        }

        public static Bundle c(Context r100, String r101, Bundle r102) {
            return r100.getContentResolver().call(a(r100), r101, "", r102);
        L4:
            e = move-exception;
            e.printStackTrace();
            Log.e("AppLifecycle", String.format("call method %s failed: %s", new Object[]{r101, e.getMessage()}));
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.ContentProvider
        public Bundle call(String r110, String r111, Bundle r112) {
            Bundle r113 = new Bundle();
            int r100 = 0;
            ProcessRecord r101 = null;
            if ("getAppState".equals(r110) == false) goto L20;
            ArrayList r114 = new ArrayList(3);
            if (this.f408797e == false) goto L7;
            r114.addAll(this.f408793a);
        L10:
            String[] r115 = new String[r114.size()];
            String[] r102 = new String[r114.size()];
            long r103 = 0;
        L12:
            if (r100 >= r114.size()) goto L15;
            ProcessRecord r104 = (ProcessRecord) ListProtector.get(r114, r100);
            r115[r100] = r104.f408800a;
            r102[r100] = r104.f408801b;
            r103 = Math.max(r103, r104.f408802c);
            r100 = r100 + 1;
            goto L12
        L15:
            if (r103 != 0) goto L17;
            r103 = SystemClock.elapsedRealtime();
        L17:
            r113.putStringArray("extra_top_process", r115);
            r113.putStringArray("extra_activity", r102);
            r113.putLong("extra_timestamp", r103);
            return r113;
        L7:
            if ("foreground".equals(this.f408796d) == false) goto L10;
            r114.add(new ProcessRecord(this.f408796d, null, SystemClock.elapsedRealtime()));
            goto L10
        L20:
            if ("getRecentStoppedActivity".equals(r110) == true) goto L22;
        L25:
            if (r112 != null) goto L27;
            return r113;
        L27:
            String r105 = r112.getString("extra_current_process");
            boolean r106 = r112.getBoolean("extra_is_front");
            String r107 = r112.getString("extra_activity");
            Lifecycle.Event r108 = Lifecycle.Event.values()[r112.getInt("extra_lifecycle_event")];
            ProcessRecord r116 = new ProcessRecord(r105, r107, r112.getLong("extra_timestamp"));
            if (TextUtils.isEmpty(r105) == false) goto L31;
            return r113;
        L31:
            if ("processToBackground".equals(r110) == false) goto L69;
            this.f408797e = true;
            List<ProcessRecord> r109 = this.f408793a;
        L33:
            ArrayList r117 = (ArrayList) r109;
            if (r100 >= r117.size()) goto L39;
            ProcessRecord r118 = (ProcessRecord) ListProtector.get(r117, r100);
            if (r105.equals(r118.f408800a) == true) goto L37;
            r100 = r100 + 1;
            goto L33
        L37:
            r101 = r118;
        L39:
            if (r101 == null) goto L43;
            if (r101.f408802c < r116.f408802c) goto L43;
        L56:
            if (r108 != Lifecycle.Event.ON_STOP) goto L59;
            ((ArrayList) this.f408795c).add(r116);
        L59:
            if (r108 != Lifecycle.Event.ON_DESTROY) goto L61;
        L62:
            int r119 = ((ArrayList) this.f408795c).size() - 1;
        L63:
            if (r119 < 0) goto L68;
            ProcessRecord r120 = (ProcessRecord) ListProtector.get(this.f408795c, r119);
            if (Objects.equals(r120.f408801b, r107) == true) goto L66;
            r119 = r119 - 1;
            goto L63
        L66:
            ((ArrayList) this.f408795c).remove(r120);
        L68:
            b r121 = this.f408798f;
            r121.f408805b = new o(this);
            r121.f408804a.removeCallbacks(r121);
            r121.f408804a.postDelayed(r121, 50);
            goto L69
        L61:
            if (r108 != Lifecycle.Event.ON_START) goto L68;
        L43:
            if (r108.compareTo(Lifecycle.Event.ON_START) > 0) goto L47;
            if (r106 == false) goto L47;
            ((ArrayList) this.f408793a).add(r116);
            Collections.sort(this.f408793a);
        L47:
            if (r108.compareTo(Lifecycle.Event.ON_STOP) < 0) goto L56;
            if (r101 == null) goto L56;
            List<ProcessRecord> r122 = this.f408793a;
            a r123 = new a(r116);
            Intrinsics.checkNotNullParameter(r122, "list");
            Intrinsics.checkNotNullParameter(r123, "predicate");
            ArrayList r124 = (ArrayList) r122;
            Iterator r125 = r124.iterator();
        L51:
            if (r125.hasNext() == false) goto L56;
            Object r126 = r125.next();
            if (((Boolean) r123.invoke(r126)).booleanValue() == false) goto L51;
            r124.remove(r126);
        L69:
            return r113;
        L22:
            if (((ArrayList) this.f408795c).isEmpty() == false) goto L24;
            return null;
        L24:
            r113.putParcelable("extra_recent_stopped_activity", (ProcessRecord) CollectionsKt.last(this.f408795c));
            goto L25
        }

        @Override // android.content.ContentProvider
        public int delete(Uri r100, String r101, String[] r102) {
            Log.e("AppLifecycle", "delete not support yet!");
            return 0;
        }

        @Override // android.content.ContentProvider
        public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
            Log.e("AppLifecycle", "update not support yet!");
            return 0;
        }

        @Override // android.content.ContentProvider
        public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
            Log.e("AppLifecycle", "query not support yet!");
            return null;
        }

        public static void b(final Context r100, final String r101, Activity r102, Lifecycle.Event r103, final boolean r104, long r105) {
            final Bundle r106 = new Bundle();
            r106.putString("extra_current_process", r101);
            r106.putBoolean("extra_is_front", r104);
            r106.putLong("extra_timestamp", r105);
            if (r102 == null) goto L5;
            r106.putString("extra_activity", r102.getClass().getName());
            r106.putInt("extra_lifecycle_event", r103.ordinal());
        L5:
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new p(r101, r104, r100, r106));
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class ProcessRecord implements Comparable<ProcessRecord>, Parcelable {
        public static final Parcelable.Creator<ProcessRecord> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f408801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f408802c;

        public class a implements Parcelable.Creator<ProcessRecord> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ProcessRecord createFromParcel(Parcel r100) {
                return new ProcessRecord(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final ProcessRecord[] newArray(int r100) {
                return new ProcessRecord[r100];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public final int hashCode() {
            String r100 = this.f408800a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f408801b;
            if (r104 == null) goto L9;
            r101 = r104.hashCode();
        L9:
            int r105 = (r103 + r101) * 31;
            long r106 = this.f408802c;
            return r105 + ((int) (r106 ^ (r106 >>> 32)));
        L5:
            r102 = 0;
            goto L6
        }

        public ProcessRecord(Parcel r100) {
            this.f408800a = r100.readString();
            this.f408801b = r100.readString();
            this.f408802c = r100.readLong();
        }

        @Override // java.lang.Comparable
        public final int compareTo(ProcessRecord r100) {
            long r101 = this.f408802c - r100.f408802c;
            if (r101 >= 0) goto L5;
            return 1;
        L5:
            if (r101 <= 0) goto L7;
            return -1;
        L7:
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L18:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L18;
            ProcessRecord r101 = (ProcessRecord) r100;
            if (this.f408802c == r101.f408802c) goto L14;
            return false;
        L14:
            if (Objects.equals(this.f408800a, r101.f408800a) == true) goto L17;
            return false;
        L17:
            return Objects.equals(this.f408801b, r101.f408801b);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.f408800a);
            r100.writeString(this.f408801b);
            r100.writeLong(this.f408802c);
        }

        public ProcessRecord(String r100, String r101, long r102) {
            this.f408800a = r100;
            this.f408801b = r101;
            this.f408802c = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AppLifecycle f408803a = null;

        static {
            f408803a = new AppLifecycle();
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f408804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f408805b;

        @Override // java.lang.Runnable
        public final void run() {
            Runnable r100 = this.f408805b;     // Catch: Throwable -> L7
            if (r100 == null) goto L5;
            r100.run();     // Catch: Throwable -> L7
        L5:
            this.f408805b = null;     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public b() {
            this.f408804a = new Handler(Looper.getMainLooper());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Activity e() {
        y.a r100 = this.f408787j;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        ActivityRecorder r102 = this.f408781d;
        final Function1 r103 = new d(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "accept");
        final Ref.ObjectRef r104 = new Ref.ObjectRef();
        r102.c(new ActivityRecorder$getFrontActivity$2(r103, r104));
        return (Activity) r104.element;
    L10:
        return null;
    L5:
        if (r100.f408861d == false) goto L7;
        r101 = true;
        goto L8
    }

    public final Activity f() {
        return this.f408781d.a();
    }

    public final boolean h() {
        y.a r100 = this.f408787j;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (this.f408781d.a() == null) goto L12;
        r101 = true;
    L12:
        if (com.larksuite.framework.utils.z.e(this.f408779b) == false) goto L20;
        if (r102 == r101) goto L20;
        Log.e("AppLifecycle", "isAppFront() app state not match, appFront:" + r102 + ", processFront:" + r101, new Throwable(), true);
        if (this.f408790m == true) goto L21;
        if (r101 == false) goto L20;
        return true;
    L21:
        return com.larksuite.framework.utils.z.d(this.f408779b);
    L20:
        return r102;
    L5:
        if (r100.f408860c == false) goto L7;
        r102 = true;
        goto L9
    }

    public AppLifecycle() {
        this.f408780c = new WeakReference(null);
        this.f408781d = new ActivityRecorder();
        this.f408782e = new WeakReference(null);
        this.f408783f = new HashMap();
        this.f408784g = new LinkedHashMap();
        this.f408787j = new y.a();
        this.f408790m = false;
        this.f408791n = false;
        this.f408785h = new CopyOnWriteArrayList();
        this.f408786i = new CopyOnWriteArrayList();
    }

    public final String g() {
        Activity r100 = f();
        if (r100 == null) goto L7;
        return r100.getClass().getName();
    L7:
        if (h() == false) goto L18;
        ActivityManager r101 = (ActivityManager) this.f408779b.getSystemService("activity");
        if (r101 == null) goto L20;
        List<ActivityManager.RunningTaskInfo> r102 = r101.getRunningTasks(1);
        if (r102 != null) goto L13;
        return "";
    L13:
        if (r102.isEmpty() == true) goto L22;
        ComponentName r103 = ((ActivityManager.RunningTaskInfo) ListProtector.get(r102, 0)).topActivity;
        if (r103 != null) goto L17;
        return "";
    L17:
        return r103.getClassName();
    L22:
        return "";
    L20:
        return "";
    L18:
        return "";
    }

    public final void b(com.ss.android.lark.appcontext.applifecycle.a r100) {
        if (this.f408786i.contains(r100) == true) goto L6;
        this.f408786i.add(r100);
        return;
    }

    public final void c(y r100) {
        this.f408785h.add(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v15, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final y.a d(Context r110) {
        String r100 = this.f408778a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "mCurrentProcessName");
        String r101 = null;
        Bundle r111 = LifecycleContentProvider.c(r110, "getAppState", null);
        if (r111 == null) goto L12;
        String[] r102 = r111.getStringArray("extra_top_process");
        String[] r103 = r111.getStringArray("extra_activity");
        long r104 = r111.getLong("extra_timestamp", r111.getLong("extra_timestamp"));
        if (r102 == null) goto L11;
        if (r103 == null) goto L11;
        ?? r112 = new ArrayList(r102.length);
        int r105 = 0;
    L9:
        if (r105 >= r102.length) goto L13;
        r112.add(new ProcessRecord(r102[r105], r103[r105], r104));
        r105 = r105 + 1;
    L13:
        Collection r106 = (Collection) r112;
        if (r106 != null) goto L16;
    L19:
        boolean r107 = true;
    L20:
        if (r107 == true) goto L56;
        Iterable r108 = (Iterable) r112;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r113 = r108.iterator();
    L24:
        if (r113.hasNext() == false) goto L26;
        r109.add(((ProcessRecord) r113.next()).f408800a);
        goto L24
    L26:
        String[] r114 = (String[]) r109.toArray(new String[0]);
        ProcessRecord r115 = (ProcessRecord) ListProtector.get(r112, 0);
        if (r115 == null) goto L29;
        String r116 = r115.f408801b;
    L30:
        ProcessRecord r117 = (ProcessRecord) ListProtector.get(r112, 0);
        if (r117 == null) goto L33;
        long r118 = r117.f408802c;
    L34:
        if (r114 == null) goto L50;
        if (r114.length != 0) goto L38;
        boolean r119 = true;
    L40:
        if ((!r119) == false) goto L50;
        if (r100 == null) goto L50;
        Iterator r120 = ArrayIteratorKt.iterator(r114);
    L44:
        if (r120.hasNext() == false) goto L48;
        if (Intrinsics.areEqual(r100, (String) r120.next()) == false) goto L44;
        r101 = r100;
        goto L50
    L48:
        r101 = r114[0];
        goto L50
    L38:
        r119 = false;
    L50:
        return y.a.a(r101, r116, r100, r118);
    L33:
        r118 = SystemClock.elapsedRealtime();
        goto L34
    L29:
        r116 = null;
        goto L30
    L56:
        return y.a.a(null, null, r100, SystemClock.elapsedRealtime());
    L16:
        if (r106.isEmpty() == true) goto L19;
        r107 = false;
    L11:
        r112 = Collections.emptyList();
        goto L13
    L12:
        r112 = 0;
        goto L13
    }

    public final void j(com.ss.android.lark.appcontext.applifecycle.a r100) {
        this.f408786i.remove(r100);
    }

    public static void a(AppLifecycle r100, y.a r101) {
        if (com.larksuite.framework.utils.z.e(r100.f408779b) == true) goto L5;
        return;
    L5:
        if (r100.f408791n == false) goto L9;
        Log.i("AppLifecycle", String.format("hotfixNotifyAppStateChangeImmediately, newState:{isFront:%s, time:%s, top:%s}", new Object[]{Boolean.valueOf(r101.f408860c), Long.valueOf(r101.f408862e), r101.f408858a}));
        r100.i(r100.f408787j, r101);
        return;
    }

    public final void i(y.a r100, y.a r101) {
        y.a r102 = this.f408787j;
        if (r102.f408862e < r101.f408862e) goto L5;
        return;
    L5:
        if (r102.equals(r101) == false) goto L7;
        return;
    L7:
        if (r101.f408860c == true) goto L12;
        if (this.f408781d.a() == null) goto L12;
        return;
    L12:
        if (com.larksuite.framework.utils.z.e(this.f408779b) == false) goto L22;
        boolean r103 = r101.f408860c;
        boolean r104 = false;
        if (this.f408781d.a() != null) goto L16;
        boolean r105 = true;
    L17:
        if (r103 != r105) goto L22;
        StringBuilder r106 = new StringBuilder("onAppStateChange() state not match, appFront:");
        r106.append(r101.f408860c);
        r106.append("，topActivity:");
        if (f() == null) goto L21;
        r104 = true;
    L21:
        r106.append(r104);
        Log.e("AppLifecycle", r106.toString(), new Throwable(), true);
        goto L22
    L16:
        r105 = false;
    L22:
        this.f408787j = r101;
        Log.i("AppLifecycle", "state changed, topProc:" + r101.f408858a + "，appFront:" + r101.f408860c + ", time:" + r101.f408862e);
        Iterator<y> r107 = this.f408785h.iterator();
    L24:
        if (r107.hasNext() == false) goto L29;
        r107.next().f(r100, r101);
        goto L24
    }
}
