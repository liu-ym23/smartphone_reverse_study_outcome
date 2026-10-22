package com.lynx.tasm;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.common.NullableConcurrentHashMap;
import com.lynx.tasm.core.LynxThreadPool;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class TemplateData {
    private static final String TAG = "LynxTemplateData";
    private final AtomicBoolean mConsumed;
    private volatile Map<String, Object> mData;
    private final Object mDataLock;
    private volatile boolean mEnableJSData;
    private final AtomicBoolean mIsConcurrent;
    volatile long mJsNativeData;
    private final Object mJsNativeDataLock;
    private volatile long mNativeData;
    private final Object mNativeDataLock;
    private String mProcessorName;
    List<UpdateAction> mUpdateActions;
    private final Object mUpdateActionsLock;
    private volatile boolean readOnly;
    private WeakReference<LynxContext> weakContext;

    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType BYTE_BUFFER = null;
        public static final ActionType NATIVE_DATA = null;
        public static final ActionType REMOVE_DATA = null;
        public static final ActionType STRING_DATA = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionType[] f381775a = null;

        static {
            ActionType r100 = new ActionType("STRING_DATA", 0);
            STRING_DATA = r100;
            ActionType r101 = new ActionType("BYTE_BUFFER", 1);
            BYTE_BUFFER = r101;
            ActionType r102 = new ActionType("NATIVE_DATA", 2);
            NATIVE_DATA = r102;
            ActionType r103 = new ActionType("REMOVE_DATA", 3);
            REMOVE_DATA = r103;
            f381775a = new ActionType[]{r100, r101, r102, r103};
        }

        public static ActionType[] values() {
            return (ActionType[]) f381775a.clone();
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) r27.a.a(ActionType.class, r100);
        }

        public ActionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class UpdateAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ActionType f381776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteBuffer f381777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f381778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f381779d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f381780e;

        public UpdateAction() {
            this.f381777b = null;
            this.f381778c = null;
            this.f381779d = null;
            this.f381780e = 0;
        }

        public final void finalize() throws Throwable {
            super.finalize();
            long r100 = this.f381780e;
            if (r100 == 0) goto L6;
            TemplateData.access$000(r100);
            return;
        }

        public long getNativeData() {
            return this.f381780e;
        }

        public ActionType getType() {
            return this.f381776a;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TemplateData f381781a;

        @Override // java.lang.Runnable
        public final void run() {
            TemplateData.access$100(this.f381781a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(TemplateData r100) {
            this.f381781a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TemplateData f381782a;

        @Override // java.lang.Runnable
        public final void run() {
            TemplateData.access$200(this.f381782a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(TemplateData r100) {
            this.f381782a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TemplateData f381783a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f381783a.getDataForJSThreadInner();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(TemplateData r100) {
            this.f381783a = r100;
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381784a = null;

        static {
            int[] r100 = new int[ActionType.values().length];
            f381784a = r100;
            r100[ActionType.STRING_DATA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f381784a[ActionType.NATIVE_DATA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f381784a[ActionType.BYTE_BUFFER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f381784a[ActionType.REMOVE_DATA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private static native long nativeClone(long r100);

    private static native long nativeCreateObject();

    private static native long nativeCreateTemplateData(long r100, boolean r101, String r102, Object r103);

    public static native Object nativeGetData(long r100);

    public static native void nativeMergeTemplateData(long r100, long r101);

    private static native long nativeParseData(ByteBuffer r100, int r101);

    private static native long nativeParseStringData(String r100);

    private static native void nativeReleaseData(long r100);

    private static native void nativeReleaseTemplateData(long r100);

    private static native void nativeRemoveData(long r100, String r101);

    private static native long nativeShallowCopy(long r100);

    private static native void nativeUpdateData(long r100, ByteBuffer r101, int r102);

    public void markReadOnly() {
        this.readOnly = true;
    }

    public static TemplateData empty() {
        return new TemplateData();
    }

    private void ensureInternalMap() {
        if (this.mData != null) goto L18;
        Object r100 = this.mDataLock;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.mData == null) goto L9;
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L9:
        if (this.mIsConcurrent.get() == false) goto L11;
        Map<String, Object> r101 = new NullableConcurrentHashMap();     // Catch: Throwable -> L15
    L12:
        this.mData = r101;     // Catch: Throwable -> L15
        goto L13
    L11:
        r101 = new HashMap();     // Catch: Throwable -> L15
        goto L12
    }

    private List<UpdateAction> obtainUpdateActions() {
        Object r100 = this.mUpdateActionsLock;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.mUpdateActions);     // Catch: Throwable -> L7
        this.mUpdateActions.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    private void releaseJsData() {
        if (this.mJsNativeData != 0) goto L5;
        return;
    L5:
        Object r100 = this.mJsNativeDataLock;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (checkIfEnvPrepared() == true) goto L10;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L10:
        if (this.mJsNativeData == 0) goto L12;
        nativeReleaseData(this.mJsNativeData);     // Catch: Throwable -> L14
        this.mJsNativeData = 0;     // Catch: Throwable -> L14
        goto L12
    }

    private void releaseNativeData() {
        if (this.mNativeData != 0) goto L5;
        return;
    L5:
        Object r100 = this.mNativeDataLock;
        monitor-enter(r100);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (checkIfEnvPrepared() == true) goto L12;
        monitor-exit(r100);     // Catch: Throwable -> L16
        return;
    L12:
        if (this.mNativeData == 0) goto L14;
        nativeReleaseData(this.mNativeData);     // Catch: Throwable -> L16
        this.mNativeData = 0;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L16
    }

    public boolean checkIsLegalData() {
        if (this.mNativeData == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long getDataForJSThreadInner() {
        if (this.mEnableJSData == true) goto L5;
        return 0;
    L5:
        List<UpdateAction> r100 = obtainUpdateActions();
        if (r100.isEmpty() == false) goto L15;
        Object r101 = this.mJsNativeDataLock;
        monitor-enter(r101);
        long r102 = this.mJsNativeData;     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L12:
        th = move-exception;
        throw th;
    L15:
        Object r103 = this.mJsNativeDataLock;
        monitor-enter(r103);
    L59:
        th = move-exception;
        throw th;
    L18:
        if (this.mJsNativeData != 0) goto L20;
        this.mJsNativeData = nativeCreateObject();     // Catch: Throwable -> L59
    L20:
        Iterator<UpdateAction> r104 = r100.iterator();     // Catch: Throwable -> L59
    L22:
        if (r104.hasNext() == false) goto L56;
        UpdateAction r105 = r104.next();     // Catch: Throwable -> L59
        int r106 = d.f381784a[r105.getType().ordinal()];     // Catch: Throwable -> L59
        if (r106 != 1) goto L26;
        String r107 = r105.f381778c;     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r107) == true) goto L22;
        long r108 = nativeParseStringData(r107);     // Catch: Throwable -> L50
        nativeMergeTemplateData(this.mJsNativeData, r108);     // Catch: Throwable -> L48
        if (r108 == 0) goto L22;
        nativeReleaseData(r108);     // Catch: Throwable -> L59
    L48:
        th = th;
    L53:
        if (r108 == 0) goto L55;
        nativeReleaseData(r108);     // Catch: Throwable -> L59
    L55:
        throw th;     // Catch: Throwable -> L59
    L50:
        th = th;
        r108 = 0;
        goto L53
    L26:
        if (r106 != 2) goto L28;
        nativeMergeTemplateData(this.mJsNativeData, r105.getNativeData());     // Catch: Throwable -> L59
        goto L22
    L28:
        if (r106 != 3) goto L30;
        ByteBuffer r109 = r105.f381777b;     // Catch: Throwable -> L59
        if (r109 == null) goto L22;
        if (r109.position() == 0) goto L22;
        nativeUpdateData(this.mJsNativeData, r109, r109.position());     // Catch: Throwable -> L59
        goto L22
    L30:
        if (r106 != 4) goto L31;
        nativeRemoveData(this.mJsNativeData, r105.f381779d);     // Catch: Throwable -> L59
        goto L22
    L31:
        LLog.e(TAG, "undefined action type: " + r105.getType());     // Catch: Throwable -> L59
        goto L22
    L56:
        long r110 = this.mJsNativeData;     // Catch: Throwable -> L59
        monitor-exit(r103);     // Catch: Throwable -> L59
        return r110;
    }

    public boolean isEmpty() {
        if (this.mNativeData != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void markConcurrent() {
        this.mIsConcurrent.set(true);
    }

    public void markConsumed() {
        this.mConsumed.set(true);
    }

    public void recycle() {
        WeakReference<LynxContext> r100 = this.weakContext;
        if (r100 == null) goto L8;
        LynxContext r101 = r100.get();
        if (r101 == null) goto L8;
        r101.runOnTasmThread(new a(this));
        return;
    L8:
        releaseNativeData();
    }

    public void recycleJsData() {
        WeakReference<LynxContext> r100 = this.weakContext;
        if (r100 == null) goto L8;
        LynxContext r101 = r100.get();
        if (r101 == null) goto L8;
        r101.runOnTasmThread(new b(this));
        return;
    L8:
        releaseJsData();
    }

    public TemplateData shallowClone() {
        TraceEvent.beginSection("TemplateData.ShallowClone");
        if (checkIfEnvPrepared() == true) goto L6;
        LLog.e(TAG, "shallowClone failed since env not ready!");
        TraceEvent.endSection("TemplateData.ShallowClone");
        return empty();
    L6:
        flush();
        TemplateData r100 = empty();
        if (this.mNativeData == 0) goto L9;
        r100.mNativeData = nativeShallowCopy(this.mNativeData);
    L9:
        r100.mProcessorName = this.mProcessorName;
        r100.readOnly = this.readOnly;
        r100.mIsConcurrent.set(this.mIsConcurrent.get());
        r100.addUpdateActions(copyUpdateActions(true));
        TraceEvent.endSection("TemplateData.ShallowClone");
        return r100;
    }

    public TemplateData() {
        this.mIsConcurrent = new AtomicBoolean(false);
        this.readOnly = false;
        this.mEnableJSData = true;
        this.mConsumed = new AtomicBoolean(false);
        this.mUpdateActionsLock = new Object();
        this.mDataLock = new Object();
        this.mJsNativeDataLock = new Object();
        this.mNativeDataLock = new Object();
        this.mUpdateActions = new ArrayList();
        LynxEnv.inst();
        this.mProcessorName = null;
    }

    private static boolean checkIfEnvPrepared() {
        return LynxEnv.inst().isNativeLibraryLoaded();
    }

    private void consumeUpdateActions() {
        LynxThreadPool.a().execute(new c(this));
    }

    public TemplateData deepClone() {
        if (checkIfEnvPrepared() == true) goto L6;
        LLog.e(TAG, "deepClone failed since env not ready!");
        return empty();
    L6:
        flush();
        TemplateData r100 = empty();
        if (this.mNativeData == 0) goto L9;
        r100.mNativeData = nativeClone(this.mNativeData);
    L9:
        r100.mProcessorName = this.mProcessorName;
        r100.readOnly = this.readOnly;
        r100.mIsConcurrent.set(this.mIsConcurrent.get());
        r100.addUpdateActions(copyUpdateActions(true));
        return r100;
    }

    public void finalize() throws Throwable {
        recycle();
        recycleJsData();
        super.finalize();
    }

    public void flush() {
        if (checkIfEnvPrepared() == true) goto L6;
        LLog.w(TAG, "Env not ready!");
        return;
    L6:
        Object r100 = this.mDataLock;
        monitor-enter(r100);
    L42:
        th = move-exception;
        throw th;
    L9:
        if (this.mData != null) goto L11;
    L31:
        Object r101 = this.mNativeDataLock;     // Catch: Throwable -> L42
        monitor-enter(r101);     // Catch: Throwable -> L42
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L34:
        if (this.mNativeData != 0) goto L36;
        this.mNativeData = nativeCreateObject();     // Catch: Throwable -> L39
    L36:
        monitor-exit(r101);     // Catch: Throwable -> L39
        monitor-exit(r100);     // Catch: Throwable -> L42
        return;
    L11:
        if (this.mData.isEmpty() == true) goto L31;
        HashMap r102 = new HashMap(this.mData);     // Catch: Throwable -> L42
        this.mData.clear();     // Catch: Throwable -> L42
        monitor-exit(r100);     // Catch: Throwable -> L42
        j7a.a.f497652a.getClass();
        ByteBuffer r103 = j7a.a.b(r102);
        if (r103 != null) goto L18;
        return;
    L18:
        if (r103.position() <= 0) goto L50;
        LLog.i(TAG, "flush data." + this);
        UpdateAction r104 = new UpdateAction();
        r104.f381776a = ActionType.BYTE_BUFFER;
        r104.f381777b = r103;
        addUpdateAction(r104);
        Object r105 = this.mNativeDataLock;
        monitor-enter(r105);
    L27:
        th = move-exception;
        throw th;
    L22:
        if (this.mNativeData != 0) goto L24;
        this.mNativeData = nativeParseData(r103, r103.position());     // Catch: Throwable -> L27
    L25:
        monitor-exit(r105);     // Catch: Throwable -> L27
        return;
    L24:
        nativeUpdateData(this.mNativeData, r103, r103.position());     // Catch: Throwable -> L27
        goto L25
    }

    public long getDataForJSThread() {
        return getDataForJSThreadInner();
    }

    public TemplateData getTemplateDataForJSThread() {
        TemplateData r100 = empty();
        r100.mEnableJSData = true;
        Object r101 = this.mJsNativeDataLock;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mJsNativeData == 0) goto L7;
        r100.mJsNativeData = nativeClone(this.mJsNativeData);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L10
        r100.addUpdateActions(copyUpdateActions(false));
        return r100;
    }

    public Map<Object, Object> toMap() {
        if (checkIfEnvPrepared() == true) goto L6;
        LLog.w(TAG, "toMap failed since env not ready.");
        return null;
    L6:
        flush();
        if (this.mNativeData != 0) goto L10;
        LLog.w(TAG, "toMap failed since mNativeData == 0.");
        return null;
    L10:
        Object r100 = nativeGetData(this.mNativeData);
        HashMap r101 = new HashMap();
        if ((r100 instanceof Map) == false) goto L13;
        r101.putAll((Map) r100);
    L13:
        return r101;
    }

    public long getNativePtr() {
        return this.mNativeData;
    }

    public long getNativeTemplateData() {
        return this.mNativeData;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public String processorName() {
        return this.mProcessorName;
    }

    private TemplateData(Map<String, Object> r100) {
        this.mIsConcurrent = new AtomicBoolean(false);
        this.readOnly = false;
        this.mEnableJSData = true;
        this.mConsumed = new AtomicBoolean(false);
        this.mUpdateActionsLock = new Object();
        this.mDataLock = new Object();
        this.mJsNativeDataLock = new Object();
        this.mNativeDataLock = new Object();
        this.mUpdateActions = new ArrayList();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L20;
        LynxEnv.inst();
        if (checkIfEnvPrepared() == true) goto L11;
        putSafely(r100);
        return;
    L11:
        j7a.a.f497652a.getClass();
        ByteBuffer r101 = j7a.a.b(r100);
        if (r101 != null) goto L14;
        return;
    L14:
        if (r101.position() <= 0) goto L21;
        this.mNativeData = nativeParseData(r101, r101.position());
        this.mProcessorName = null;
        UpdateAction r102 = new UpdateAction();
        r102.f381776a = ActionType.BYTE_BUFFER;
        r102.f381777b = r101;
        addUpdateAction(r102);
        return;
    L21:
        return;
    }

    public static /* synthetic */ void access$000(long r100) {
        nativeReleaseData(r100);
    }

    public static /* synthetic */ void access$100(TemplateData r100) {
        r100.releaseNativeData();
    }

    public static /* synthetic */ void access$200(TemplateData r100) {
        r100.releaseJsData();
    }

    private void addUpdateAction(UpdateAction r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mEnableJSData == true) goto L7;
        return;
    L7:
        Object r101 = this.mUpdateActionsLock;
        monitor-enter(r101);
        this.mUpdateActions.add(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void addUpdateActions(List<UpdateAction> r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mEnableJSData == true) goto L7;
        return;
    L7:
        Object r101 = this.mUpdateActionsLock;
        monitor-enter(r101);
        this.mUpdateActions.addAll(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private List<UpdateAction> copyUpdateActions(boolean r100) {
        if (this.mEnableJSData == true) goto L6;
        return null;
    L6:
        ArrayList r101 = new ArrayList();
        Object r102 = this.mJsNativeDataLock;
        monitor-enter(r102);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (this.mJsNativeData == 0) goto L13;
        long r103 = nativeShallowCopy(this.mJsNativeData);     // Catch: Throwable -> L11
        UpdateAction r104 = new UpdateAction();     // Catch: Throwable -> L11
        r104.f381776a = ActionType.NATIVE_DATA;     // Catch: Throwable -> L11
        r104.f381780e = r103;     // Catch: Throwable -> L11
        r101.add(r104);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L11
        Object r105 = this.mUpdateActionsLock;
        monitor-enter(r105);
        r101.addAll(this.mUpdateActions);     // Catch: Throwable -> L21
        monitor-exit(r105);     // Catch: Throwable -> L21
        if (r100 == false) goto L20;
        consumeUpdateActions();
    L20:
        return r101;
    L21:
        th = move-exception;
        throw th;
    }

    public static TemplateData createForStaticPage(Map<String, Object> r100) {
        return new y1(r100);
    }

    public static long createNativeTemplateData(TemplateData r100) {
        r100.flush();
        return nativeCreateTemplateData(r100.getNativePtr(), r100.isReadOnly(), r100.processorName(), r100);
    }

    private static Object decodeByteBuffer(ByteBuffer r100) {
        if (r100 == null) goto L5;
        j7a.a.f497652a.getClass();
        return j7a.a.a(r100);
    L5:
        return null;
    }

    public static TemplateData fromMap(Map<String, Object> r100) {
        TraceEvent.beginSection("TemplateData.FromMap");
        TemplateData r101 = new TemplateData(r100);
        TraceEvent.endSection("TemplateData.FromMap");
        return r101;
    }

    public static TemplateData fromNativeDataPtr(long r100) {
        return new TemplateData(r100);
    }

    public static TemplateData fromString(String r100) {
        TraceEvent.beginSection("TemplateData.FromString");
        TemplateData r101 = new TemplateData(r100);
        TraceEvent.endSection("TemplateData.FromString");
        return r101;
    }

    public static boolean isForStaticPage(TemplateData r100) {
        return r100 instanceof y1;
    }

    public static List<Object> jsonArrayToList(JSONArray r100) {
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L16;
        Object r103 = r100.get(r102);     // Catch: Throwable -> L13
        if ((r103 instanceof JSONObject) == false) goto L9;
        r103 = jsonToMap((JSONObject) r103);     // Catch: Throwable -> L13
    L11:
        r101.add(r103);     // Catch: Throwable -> L13
    L15:
        r102 = r102 + 1;
        goto L4
    L9:
        if ((r103 instanceof JSONArray) == false) goto L11;
        r103 = jsonArrayToList((JSONArray) r103);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        LLog.e(TAG, "Failed to parse JSONArray at index " + r102 + ": " + th.getMessage());
        goto L15
    L16:
        return r101;
    }

    public static Map<String, Object> jsonToMap(JSONObject r100) {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();     // Catch: Throwable -> L14
    L4:
        if (r102.hasNext() == false) goto L16;
        String r103 = r102.next();     // Catch: Throwable -> L14
        Object r104 = r100.get(r103);     // Catch: Throwable -> L14
        if ((r104 instanceof JSONObject) == false) goto L10;
        r104 = jsonToMap((JSONObject) r104);     // Catch: Throwable -> L14
    L12:
        r101.put(r103, r104);     // Catch: Throwable -> L14
        goto L4
    L10:
        if ((r104 instanceof JSONArray) == false) goto L12;
        r104 = jsonArrayToList((JSONArray) r104);     // Catch: Throwable -> L14
    L16:
        return r101;
    L14:
        th = move-exception;
        LLog.e(TAG, "Failed to parse JSONObject: " + th.getMessage());
        goto L16
    }

    private void putSafely(Map<String, Object> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L9;
        ensureInternalMap();
        this.mData.putAll(r100);
        return;
    }

    public static void releaseNativeTemplateData(long r100) {
        nativeReleaseTemplateData(r100);
    }

    public void bindContext(LynxContext r100) {
        this.weakContext = new WeakReference(r100);
    }

    public void markState(String r100) {
        this.mProcessorName = r100;
    }

    public void remove(String r100) {
        if (checkIfEnvPrepared() == true) goto L7;
        LLog.e(TAG, "remove failed since env not ready!");
        return;
    L7:
        if (this.readOnly == false) goto L11;
        LLog.w(TAG, "can not remove readOnly TemplateData");
        return;
    L11:
        if (this.mConsumed.get() == false) goto L13;
        LLog.w(TAG, "put data to consumed TemplateData,key:" + r100);
    L13:
        UpdateAction r101 = new UpdateAction();
        r101.f381776a = ActionType.REMOVE_DATA;
        r101.f381779d = r100;
        addUpdateAction(r101);
        if (this.mNativeData == 0) goto L17;
        nativeRemoveData(this.mNativeData, r100);
        return;
    }

    public void removeKey(String r100) {
        put(r100, null);
    }

    public void setEnableJSData(boolean r100) {
        this.mEnableJSData = r100;
    }

    public void updateData(Map<String, Object> r100) {
        if (this.readOnly == false) goto L7;
        LLog.e(TAG, "can not update readOnly TemplateData");
        return;
    L7:
        if (this.mConsumed.get() == false) goto L9;
        LLog.w(TAG, "updateData to consumed TemplateData, diff:" + r100.keySet());
    L9:
        putSafely(r100);
    }

    public void updateWithTemplateData(TemplateData r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (isForStaticPage(r100) == false) goto L8;
        LLog.e(TAG, "updateWithTemplateData is not supported for static-page data");
        return;
    L8:
        if (this != r100) goto L12;
        LLog.w(TAG, "can not update TemplateData with self");
        return;
    L12:
        if (this.readOnly == false) goto L16;
        LLog.w(TAG, "can not update readOnly TemplateData");
        return;
    L16:
        if (checkIfEnvPrepared() == true) goto L20;
        LLog.w(TAG, "updateWithTemplateData failed since env not ready.");
        return;
    L20:
        if (this.mConsumed.get() == false) goto L22;
        LLog.w(TAG, "updateWithTemplateData to consumed TemplateData, this:" + this + ",diff:" + r100);
    L22:
        flush();
        r100.flush();
        addUpdateActions(r100.copyUpdateActions(true));
        if (r100.getNativePtr() == 0) goto L26;
        nativeMergeTemplateData(getNativePtr(), r100.getNativePtr());
        return;
    }

    private TemplateData(String r100) {
        this.mIsConcurrent = new AtomicBoolean(false);
        this.readOnly = false;
        this.mEnableJSData = true;
        this.mConsumed = new AtomicBoolean(false);
        this.mUpdateActionsLock = new Object();
        this.mDataLock = new Object();
        this.mJsNativeDataLock = new Object();
        this.mNativeDataLock = new Object();
        this.mUpdateActions = new ArrayList();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        LynxEnv.inst();
        if (checkIfEnvPrepared() == false) goto L14;
        this.mNativeData = nativeParseStringData(r100);
        this.mProcessorName = null;
        UpdateAction r101 = new UpdateAction();
        r101.f381776a = ActionType.STRING_DATA;
        r101.f381778c = r100;
        addUpdateAction(r101);
        return;
    L14:
        putSafely(jsonToMap(new JSONObject(r100)));     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    private TemplateData(long r100) {
        this.mIsConcurrent = new AtomicBoolean(false);
        this.readOnly = false;
        this.mEnableJSData = true;
        this.mConsumed = new AtomicBoolean(false);
        this.mUpdateActionsLock = new Object();
        this.mDataLock = new Object();
        this.mJsNativeDataLock = new Object();
        this.mNativeDataLock = new Object();
        this.mUpdateActions = new ArrayList();
        LynxEnv.inst();
        this.mNativeData = r100;
        this.readOnly = true;
        this.mProcessorName = null;
        if (this.mNativeData == 0) goto L6;
        long r101 = nativeShallowCopy(this.mNativeData);
        UpdateAction r102 = new UpdateAction();
        r102.f381776a = ActionType.NATIVE_DATA;
        r102.f381780e = r101;
        addUpdateAction(r102);
        return;
    }

    private void putSafely(String r100, Object r101) {
        ensureInternalMap();
        this.mData.put(r100, r101);
    }

    public void put(String r100, Object r101) {
        if (this.readOnly == false) goto L7;
        LLog.w(TAG, "can not update readOnly TemplateData");
        return;
    L7:
        if (this.mConsumed.get() == false) goto L9;
        LLog.w(TAG, "put data to consumed TemplateData,key:" + r100);
    L9:
        putSafely(r100, r101);
    }

    public void updateData(String r100, Object r101) {
        put(r100, r101);
    }
}
