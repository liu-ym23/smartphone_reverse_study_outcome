package com.bytedance.common.wschannel;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.utils.Utils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import f06.b;
import f06.c;
import f06.d;
import g06.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelMultiProcessSharedProvider extends ContentProvider {
    public static Uri sBaseUri;
    private static MultiProcessShared sInstance;
    private static boolean sIsRegisterInMainProcess;
    private static volatile boolean sLoadValuesInit;
    private static UriMatcher sMatcher;
    public static String sShareAuthority;
    private Map<String, Object> mContentValues;
    private SharedPreferences mSharedPreferences;
    private final Object sLoadValuesInitLock;

    public static class Editor {
        Context mContext;
        private ContentValues mValues;

        public synchronized void apply() {
            monitor-enter(this);
            com_bytedance_common_wschannel_WsChannelMultiProcessSharedProvider$Editor_android_content_ContentResolver_insert(this.mContext.getContentResolver(), WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, "key", "type"), this.mValues);     // Catch: Throwable -> L6
        L4:
            monitor-exit(this);
        }

        public synchronized void commit() {
            monitor-enter(this);
            apply();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private Editor(Context r100) {
            this.mValues = new ContentValues();
            this.mContext = r100.getApplicationContext();
        }

        public /* synthetic */ Editor(Context r100, AnonymousClass1 r101) {
            this(r100);
        }

        public Editor putBoolean(String r100, boolean r101) {
            this.mValues.put(r100, Boolean.valueOf(r101));
            return this;
        }

        public Editor putLong(String r100, long r101) {
            this.mValues.put(r100, Long.valueOf(r101));
            return this;
        }

        public Editor putString(String r100, String r101) {
            this.mValues.put(r100, r101);
            return this;
        }

        private static Uri com_bytedance_common_wschannel_WsChannelMultiProcessSharedProvider$Editor_android_content_ContentResolver_insert(ContentResolver r110, Uri r111, ContentValues r210) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111, r210};
            b r112 = new b();
            a r102 = ApiHookConfig.f245611b.get(240017);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L21;
            return (Uri) r107.f474983b;
        L21:
            return r110.insert(r111, r210);
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    public static class MultiProcessShared {
        private Context mContext;
        private boolean mIsMainProcess;
        private SharedPreferences mSharedPreferences;

        public Editor edit() {
            return new Editor(this.mContext, null);
        }

        private MultiProcessShared(Context r100) {
            boolean r101 = false;
            this.mIsMainProcess = false;
            if (Utils.isMainProcess(r100) == true) goto L5;
        L7:
            this.mIsMainProcess = r101;
            Context r102 = r100.getApplicationContext();
            this.mContext = r102;
            this.mSharedPreferences = r102.getApplicationContext().getSharedPreferences("wschannel_multi_process_config", 4);
            if (Logger.debug() == false) goto L11;
            Logger.v("PushService", "MultiProcessShared create");
            return;
        L11:
            return;
        L5:
            if (WsChannelMultiProcessSharedProvider.access$300() == false) goto L7;
            r101 = true;
            goto L7
        }

        public /* synthetic */ MultiProcessShared(Context r100, AnonymousClass1 r101) {
            this(r100);
        }

        public boolean getBoolean(String r100, boolean r101) {
        L8:
            return r101;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getBoolean(r100, r101);
        L7:
            return WsChannelMultiProcessSharedProvider.access$700(com_bytedance_common_wschannel_WsChannelMultiProcessSharedProvider$MultiProcessShared_android_content_ContentResolver_query(this.mContext.getContentResolver(), WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, r100, "boolean"), null, null, null, null), r101);
        }

        public long getLong(String r100, long r101) {
        L8:
            return r101;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getLong(r100, r101);
        L7:
            return WsChannelMultiProcessSharedProvider.access$500(com_bytedance_common_wschannel_WsChannelMultiProcessSharedProvider$MultiProcessShared_android_content_ContentResolver_query(this.mContext.getContentResolver(), WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, r100, "long"), null, null, null, null), r101);
        }

        public String getString(String r100, String r101) {
        L8:
            return r101;
        L3:
            if (this.mIsMainProcess == false) goto L7;
            return this.mSharedPreferences.getString(r100, r101);
        L7:
            return WsChannelMultiProcessSharedProvider.access$400(com_bytedance_common_wschannel_WsChannelMultiProcessSharedProvider$MultiProcessShared_android_content_ContentResolver_query(this.mContext.getContentResolver(), WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, r100, "string"), null, null, null, null), r101);
        }

        private static Cursor com_bytedance_common_wschannel_WsChannelMultiProcessSharedProvider$MultiProcessShared_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
            c r100 = new c();
            Object[] r101 = {r111, r112, r113, r114, r115};
            b r116 = new b();
            d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
            if (r117.f474982a == false) goto L6;
            r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
            return (Cursor) r117.f474983b;
        L6:
            Cursor r118 = r110.query(r111, r112, r113, r114, r115);
            r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
            return r118;
        }
    }

    private synchronized SharedPreferences getMultiProcessSharedPreferences() {
        monitor-enter(this);
        SharedPreferences r100 = this.mSharedPreferences;     // Catch: Throwable -> L10
        if (r100 != null) goto L8;
        SharedPreferences r101 = getContext().getApplicationContext().getSharedPreferences("wschannel_multi_process_config", 4);     // Catch: Throwable -> L10
        this.mSharedPreferences = r101;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    L8:
        monitor-exit(this);
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    private void loadValues() {
        if (sLoadValuesInit == true) goto L23;
        Object r100 = this.sLoadValuesInitLock;
        monitor-enter(r100);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (sLoadValuesInit == true) goto L18;
        SharedPreferences r101 = getMultiProcessSharedPreferences();     // Catch: Throwable -> L20
        if (r101 != null) goto L13;
        sLoadValuesInit = true;     // Catch: Throwable -> L20
        monitor-exit(r100);     // Catch: Throwable -> L20
        return;
    L13:
        Iterator<Map.Entry<String, ?>> r102 = r101.getAll().entrySet().iterator();     // Catch: Throwable -> L20
    L15:
        if (r102.hasNext() == false) goto L17;
        Map.Entry<String, ?> r103 = r102.next();     // Catch: Throwable -> L20
        String r104 = r103.getKey();     // Catch: Throwable -> L20
        Object r105 = r103.getValue();     // Catch: Throwable -> L20
        this.mContentValues.put(r104, r105);     // Catch: Throwable -> L20
        goto L15
    L17:
        sLoadValuesInit = true;     // Catch: Throwable -> L20
    L18:
        monitor-exit(r100);     // Catch: Throwable -> L20
        return;
    }

    public WsChannelMultiProcessSharedProvider() {
        this.mContentValues = new ConcurrentHashMap();
        this.sLoadValuesInitLock = new Object();
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (Utils.isMainProcess(getContext()) == false) goto L5;
        sIsRegisterInMainProcess = true;
    L5:
        WsChannelSdk2.monitorLifeCycle(getContext());
        if (sMatcher == null) goto L16;
    L15:
        return true;
    L16:
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.v("MultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L12
    L10:
        init(getContext());     // Catch: Exception -> L12
        goto L15
    }

    public static /* synthetic */ boolean access$300() {
        return sIsRegisterInMainProcess;
    }

    public static synchronized MultiProcessShared getMultiprocessShared(Context r100) {
        monitor-enter(WsChannelMultiProcessSharedProvider.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new MultiProcessShared(r100, null);     // Catch: Throwable -> L10
    L7:
        MultiProcessShared r101 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(WsChannelMultiProcessSharedProvider.class);
        return r101;
    }

    private static void init(Context r100) throws IllegalStateException {
        if (TextUtils.isEmpty(sShareAuthority) == false) goto L6;
        sShareAuthority = getProviderAuthority(r100, WsChannelMultiProcessSharedProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(sShareAuthority) == true) goto L13;
        if (Logger.debug() == false) goto L10;
        Logger.v("MultiProcessSharedProvider", sShareAuthority);
    L10:
        UriMatcher r101 = new UriMatcher(-1);
        sMatcher = r101;
        r101.addURI(sShareAuthority, "*/*", 65536);
        sBaseUri = UriProtector.parse("content://" + sShareAuthority);
        return;
    L13:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    private void notifyContentChanged(Uri r100) {
        getContext().getContentResolver().notifyChange(r100, null);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return "vnd.android.cursor.item/vnd." + sShareAuthority + ".item";
    }

    public static /* synthetic */ void access$000(WsChannelMultiProcessSharedProvider r100, Uri r101) {
        r100.notifyContentChanged(r101);
    }

    public static /* synthetic */ String access$400(Cursor r100, String r101) {
        return getStringValue(r100, r101);
    }

    public static /* synthetic */ long access$500(Cursor r100, long r101) {
        return getLongValue(r100, r101);
    }

    public static /* synthetic */ boolean access$700(Cursor r100, boolean r101) {
        return getBooleanValue(r100, r101);
    }

    private Runnable createNotifyRunnable(final String r100, final String r101) {
        return new AnonymousClass1(this, r100, r101);
    }

    private static boolean getBooleanValue(Cursor r100, boolean r101) {
        if (r100 != null) goto L14;
        return r101;
    L14:
        if (r100.moveToFirst() == false) goto L16;
        if (r100.getInt(0) <= 0) goto L9;
        r101 = true;
        goto L16
    L9:
        r101 = false;
    L16:
        r100.close();     // Catch: Exception -> L13
    L11:
        return r101;
    }

    private static long getLongValue(Cursor r100, long r101) {
        if (r100 != null) goto L11;
        return r101;
    L11:
        if (r100.moveToFirst() == false) goto L13;
        r101 = r100.getLong(0);     // Catch: Throwable -> L9
    L13:
        r100.close();     // Catch: Exception -> L10
    L8:
        return r101;
    }

    public static String getProviderAuthority(Context r100, String r101) {
        if (r100 != null) goto L5;
    L14:
        return null;
    L5:
        if (StringUtils.isEmpty(r101) == true) goto L14;
        ProviderInfo[] r102 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 8).providers;     // Catch: Exception -> L15
        int r103 = r102.length;     // Catch: Exception -> L15
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L14;
        ProviderInfo r105 = r102[r104];     // Catch: Exception -> L15
        if (r101.equals(r105.name) == true) goto L11;
        r104 = r104 + 1;
        goto L8
    L11:
        return r105.authority;
    }

    private static String getStringValue(Cursor r100, String r101) {
        if (r100 != null) goto L11;
        return r101;
    L11:
        if (r100.moveToFirst() == false) goto L13;
        r101 = r100.getString(0);     // Catch: Throwable -> L9
    L13:
        r100.close();     // Catch: Exception -> L10
    L8:
        return r101;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r100, ProviderInfo r101) {
        if (r101 == null) goto L4;
        sShareAuthority = r101.authority;
    L4:
        super.attachInfo(r100, r101);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r110, ContentValues r111) {
        if (sMatcher.match(r110) != 65536) goto L62;
        loadValues();     // Catch: Exception -> L63
        ArrayList r100 = new ArrayList();     // Catch: Exception -> L63
        Iterator<Map.Entry<String, Object>> r112 = r111.valueSet().iterator();     // Catch: Exception -> L63
        SharedPreferences.Editor r101 = null;
    L7:
        if (r112.hasNext() == false) goto L53;
        Map.Entry<String, Object> r102 = r112.next();     // Catch: Exception -> L63
        Object r103 = r102.getValue();     // Catch: Exception -> L63
        String r104 = r102.getKey();     // Catch: Exception -> L63
        if (Logger.debug() == false) goto L12;
        Logger.v("PushService", "MultiProcessShareProvider insert key = " + r104 + " value = " + r103.toString());     // Catch: Exception -> L63
    L12:
        boolean r105 = true;
        if (r103 != null) goto L15;
        this.mContentValues.remove(r104);     // Catch: Exception -> L63
    L22:
        if (r105 == false) goto L7;
        if (Logger.debug() == true) goto L26;
    L30:
        if (r101 != null) goto L32;
        r101 = getMultiProcessSharedPreferences().edit();     // Catch: Exception -> L63
    L32:
        if (r103 != null) goto L35;
        r101.remove(r104);     // Catch: Exception -> L63
        Runnable r106 = null;
    L49:
        if (r106 == null) goto L7;
        r100.add(r106);     // Catch: Exception -> L63
        goto L7
    L35:
        if ((r103 instanceof String) == false) goto L38;
        r101.putString(r104, (String) r103);     // Catch: Exception -> L63
        r106 = createNotifyRunnable(r104, "string");     // Catch: Exception -> L63
        goto L49
    L38:
        if ((r103 instanceof Boolean) == false) goto L41;
        r101.putBoolean(r104, ((Boolean) r103).booleanValue());     // Catch: Exception -> L63
        r106 = createNotifyRunnable(r104, "boolean");     // Catch: Exception -> L63
        goto L49
    L41:
        if ((r103 instanceof Long) == false) goto L44;
        r101.putLong(r104, ((Long) r103).longValue());     // Catch: Exception -> L63
        r106 = createNotifyRunnable(r104, "long");     // Catch: Exception -> L63
        goto L49
    L44:
        if ((r103 instanceof Integer) == false) goto L47;
        r101.putInt(r104, ((Integer) r103).intValue());     // Catch: Exception -> L63
        r106 = createNotifyRunnable(r104, "integer");     // Catch: Exception -> L63
        goto L49
    L47:
        if ((r103 instanceof Float) == false) goto L52;
        r101.putFloat(r104, ((Float) r103).floatValue());     // Catch: Exception -> L63
        r106 = createNotifyRunnable(r104, "float");     // Catch: Exception -> L63
        goto L49
    L52:
        throw new IllegalArgumentException("Unsupported type " + r110);     // Catch: Exception -> L63
    L26:
        if (("MultiProcessShareProvider reallly insert key = " + r104 + " value = " + r103) == null) goto L28;
        String r107 = r103.toString();     // Catch: Exception -> L63
    L29:
        Logger.v("PushService", r107);     // Catch: Exception -> L63
        goto L30
    L28:
        r107 = "null";
        goto L29
    L15:
        Object r108 = this.mContentValues.get(r104);     // Catch: Exception -> L63
        if (r108 != null) goto L18;
    L21:
        this.mContentValues.put(r104, r103);     // Catch: Exception -> L63
        goto L22
    L18:
        if (r108.equals(r103) == false) goto L21;
        r105 = false;
        goto L22
    L53:
        if (r101 != null) goto L55;
        return null;
    L55:
        r101.apply();     // Catch: Exception -> L63
        Iterator r113 = r100.iterator();     // Catch: Exception -> L63
    L57:
        if (r113.hasNext() == false) goto L60;
        ((Runnable) r113.next()).run();     // Catch: Exception -> L63
    L60:
        return null;
    L62:
        throw new IllegalArgumentException("Unsupported uri " + r110);
    }

    public static final synchronized Uri getContentUri(Context r100, String r101, String r102) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider> r0 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.class
            monitor-enter(r0)
            android.net.Uri r1 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.sBaseUri     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L1f
            boolean r1 = com.bytedance.common.utility.Logger.debug()     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            if (r1 == 0) goto L14
            java.lang.String r1 = "MultiProcessSharedProvider"
            java.lang.String r2 = "init form getContentUri"
            com.bytedance.common.utility.Logger.d(r1, r2)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
        L14:
            init(r3)     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L33
            goto L1f
        L18:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L33
            monitor-exit(r0)
            r3 = 0
            return r3
        L1f:
            android.net.Uri r3 = com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.sBaseUri     // Catch: java.lang.Throwable -> L33
            android.net.Uri$Builder r3 = r3.buildUpon()     // Catch: java.lang.Throwable -> L33
            android.net.Uri$Builder r3 = r3.appendPath(r4)     // Catch: java.lang.Throwable -> L33
            android.net.Uri$Builder r3 = r3.appendPath(r5)     // Catch: java.lang.Throwable -> L33
            android.net.Uri r3 = r3.build()     // Catch: java.lang.Throwable -> L33
            monitor-exit(r0)
            return r3
        L33:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.getContentUri(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        if (sMatcher.match(r100) != 65536) goto L8;
        getMultiProcessSharedPreferences().edit().clear().commit();     // Catch: Exception -> L9
        this.mContentValues.clear();     // Catch: Exception -> L9
        notifyContentChanged(getContentUri(getContext(), "key", "type"));     // Catch: Exception -> L9
        return 0;
    L12:
        return 0;
    L8:
        throw new IllegalArgumentException("Unsupported uri " + r100);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        if (sMatcher.match(r100) != 65536) goto L54;
        ?? r105 = 0;
        int r106 = 1;
        if ("all".equals((String) ListProtector.get(r100.getPathSegments(), 1)) == false) goto L34;
        Map<String, ?> r107 = getMultiProcessSharedPreferences().getAll();     // Catch: Exception -> L55
        MatrixCursor r108 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L55
        Iterator<Map.Entry<String, ?>> r109 = r107.entrySet().iterator();     // Catch: Exception -> L33
    L9:
        boolean r110 = r109.hasNext();     // Catch: Exception -> L33
        r105 = r110;
        if (r110 == false) goto L56;
        Map.Entry<String, ?> r111 = r109.next();     // Catch: Exception -> L33
        String r112 = r111.getKey();     // Catch: Exception -> L33
        Object r113 = r111.getValue();     // Catch: Exception -> L33
        MatrixCursor.RowBuilder r114 = r108.newRow();     // Catch: Exception -> L33
        String r115 = "string";
        if ((r113 instanceof String) == true) goto L31;
        if ((r113 instanceof Boolean) == false) goto L23;
        r115 = "boolean";
        if (((Boolean) r113).booleanValue() == false) goto L20;
        int r116 = 1;
    L21:
        r113 = Integer.valueOf(r116);     // Catch: Exception -> L33
        goto L31
    L20:
        r116 = 0;
        goto L21
    L23:
        if ((r113 instanceof Integer) == false) goto L26;
        r115 = "integer";
        goto L31
    L26:
        if ((r113 instanceof Long) == false) goto L29;
        r115 = "long";
        goto L31
    L29:
        if ((r113 instanceof Float) == false) goto L31;
        r115 = "float";
    L31:
        r114.add(r112);     // Catch: Exception -> L33
        r114.add(r113);     // Catch: Exception -> L33
        r114.add(r115);     // Catch: Exception -> L33
    L56:
        return r108;
    L33:
        r105 = r108;
        goto L69
    L34:
        String r117 = (String) ListProtector.get(r100.getPathSegments(), 0);     // Catch: Exception -> L55
        loadValues();     // Catch: Exception -> L55
        if (this.mContentValues.containsKey(r117) == true) goto L37;
        return null;
    L37:
        MatrixCursor r118 = new MatrixCursor(new String[]{r117});     // Catch: Exception -> L55
        Object r119 = this.mContentValues.get(r117);     // Catch: Exception -> L50
        MatrixCursor.RowBuilder r120 = r118.newRow();     // Catch: Exception -> L50
        boolean r121 = r119 instanceof Boolean;     // Catch: Exception -> L50
        Object r122 = r119;
        if (r121 == false) goto L46;
        if (((Boolean) r119).booleanValue() == true) goto L44;
        r106 = 0;
    L44:
        r122 = Integer.valueOf(r106);     // Catch: Exception -> L50
    L46:
        if (Logger.debug() == false) goto L48;
        Logger.v("PushService", "MultiProcessShareProvider reallly get key = " + r117 + " value = " + r122.toString());     // Catch: Exception -> L50
    L48:
        r120.add(r122);     // Catch: Exception -> L50
        r108 = r118;
        r105 = r122;
    L50:
        r105 = r118;
    L69:
        return r105;
    L54:
        throw new IllegalArgumentException("Unsupported uri " + r100);
    }
}
