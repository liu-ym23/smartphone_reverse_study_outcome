package com.bytedance.bdturing;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import qb4.k;
import qb4.l;
import qb4.m;
import qb4.s;

/* JADX INFO: loaded from: classes3.dex */
public class BdTuringConfig {
    public static final int DEFAULT_EVENT_COUNT = 6000;
    private static final int MAX_LOCAL_PARAMS = 2;
    private static final int OS_TYPE = 0;
    private static final String TAG = "BdTuringConfig";
    private m bdTuringDepend;
    private k eventClient;
    private ec4.b httpClient;
    private String mAppId;
    private qb4.a mAppInfoProvider;
    private String mAppKey;
    private String mAppName;
    private l mAppSateProvider;
    private String mAppVersion;
    private String mAppVersionCode;
    private boolean mBypassBdTuring;
    private vb4.c mByteNNDepend;
    private int mChallengeCode;
    private String mChannel;
    private Context mContext;
    private JSONObject mDOWNSMSTheme;
    private String mDeviceBrand;
    private String mDeviceId;
    private String mDeviceModel;
    private JSONObject mECAFTheme;
    private JSONObject mEMAILTheme;
    private int mEmailDigits;
    private boolean mEnableTTNetProcessor;
    private boolean mFullScreen;
    private JSONObject mIDENTIFYTheme;
    private JSONObject mIMGTheme;
    private JSONObject mINFOVERIFYTheme;
    private ub4.b mIdentityVerifyDepend;
    private boolean mInjectHeader;
    private String mInstallId;
    private String mLanguage;
    private boolean mLiveDebugMode;
    private String mLocale;
    private zb4.a mLoginVerifyDepend;
    private boolean mMaskCancel;
    private String mOpenUdid;
    private String mOsName;
    private String mOsVersion;
    private JSONObject mPASSWORDTheme;
    private JSONObject mQATheme;
    private RegionType mRegionType;
    private String mRiskInfo;
    private JSONObject mSMARTERTheme;
    private JSONObject mSMSTheme;
    private JSONObject mSMSVOICETheme;
    private String mScene;
    private String mSdkVersion;
    private cc4.a mSecDepend;
    private com.bytedance.bdturing.setting.b mServiceInterceptor;
    private String mSessionId;
    private boolean mShowToastSuccess;
    private int mSmsDigits;
    private dc4.a mThemeConfig;
    private ConcurrentHashMap<Integer, JSONObject> mThemeMap;
    private JSONObject mUPSMSTheme;
    private gc4.a mUcTwiceVerifyDepend;
    private JSONObject mVOICETheme;
    private HashMap<Integer, Pair<String, String>> testConfig;
    private String ticket;
    private fc4.a twiceVerifyDepend;

    public static final enum RegionType extends Enum<RegionType> {
        public static final RegionType REGION_BOE = null;
        public static final RegionType REGION_CN = null;
        public static final RegionType REGION_INDIA = null;
        public static final RegionType REGION_SINGAPOER = null;
        public static final RegionType REGION_USA_EAST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RegionType[] f201615a = null;
        private String mName;

        static {
            RegionType r100 = new RegionType("REGION_CN", 0, "cn");
            REGION_CN = r100;
            RegionType r101 = new RegionType("REGION_SINGAPOER", 1, EnvConst$GEO.SG);
            REGION_SINGAPOER = r101;
            RegionType r102 = new RegionType("REGION_USA_EAST", 2, "va");
            REGION_USA_EAST = r102;
            RegionType r103 = new RegionType("REGION_INDIA", 3, "in");
            REGION_INDIA = r103;
            RegionType r104 = new RegionType("REGION_BOE", 4, "boe");
            REGION_BOE = r104;
            f201615a = new RegionType[]{r100, r101, r102, r103, r104};
        }

        public static RegionType[] values() {
            return (RegionType[]) f201615a.clone();
        }

        public String getName() {
            return this.mName;
        }

        public static RegionType valueOf(String r100) {
            return (RegionType) r27.a.a(RegionType.class, r100);
        }

        public RegionType(String r100, int r101, String r102) {
            super(r100, r101);
            this.mName = r102;
        }
    }

    /* JADX INFO: loaded from: classes12.dex */
    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RegionType f201616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f201617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f201618c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f201619d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f201620e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f201621f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f201622g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f201623h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Context f201624i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f201625j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f201626k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f201627l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f201628m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public k f201629n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public fc4.a f201630o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public m f201631p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f201632q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f201633r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final boolean f201634s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public ub4.b f201635t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public qb4.a f201636u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public zb4.a f201637v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public gc4.a f201638w;

        public b() {
            this.f201616a = RegionType.REGION_CN;
            this.f201621f = "";
            this.f201623h = "";
            this.f201627l = true;
            this.f201628m = true;
            this.f201634s = true;
            this.f201632q = 6;
            this.f201633r = 4;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public l getAppSateProvider() {
        return null;
    }

    public int getOsType() {
        return 0;
    }

    public cc4.a getSecDepend() {
        return null;
    }

    public dc4.a getThemeConfig() {
        return null;
    }

    public boolean privacyPolicyAgree() {
        return false;
    }

    public void setAppSateProvider(l r100) {
    }

    public void setSecDepend(cc4.a r100) {
    }

    public void setThemeConfig(dc4.a r100) {
    }

    public String getAppVersionCode() {
        if (TextUtils.isEmpty(this.mAppVersionCode) == false) goto L7;
        return "";
    L7:
        return this.mAppVersionCode;
    }

    public String getDeviceId() {
        String r100 = this.mDeviceId;
        if (TextUtils.isEmpty(r100) == false) goto L9;
        qb4.a r101 = this.mAppInfoProvider;
        if (r101 != null) goto L10;
        return "";
    L10:
        return r101.a();
    L9:
        return r100;
    }

    public ub4.b getIdentityVerifyDepend() {
        if (this.mIdentityVerifyDepend != null) goto L9;
        this.mIdentityVerifyDepend = (ub4.b) INVOKESTATIC_com_bytedance_bdturing_BdTuringConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.bdturing.identity_verify_adapter.DefaultIdentityVerifyDepend").newInstance();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        return this.mIdentityVerifyDepend;
    }

    public String getInstallId() {
        String r100 = this.mInstallId;
        if (TextUtils.isEmpty(r100) == false) goto L9;
        qb4.a r101 = this.mAppInfoProvider;
        if (r101 != null) goto L10;
        return "";
    L10:
        return r101.b();
    L9:
        return r100;
    }

    public String getLocale() {
        String r100 = this.mLocale;
    L8:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = Locale.getDefault().toString();     // Catch: Throwable -> L8 Exception -> L10
    L6:
        if (r100 != null) goto L14;
        return "";
    L14:
        return r100;
    L11:
        if (r100 != null) goto L14;
        return "";
    }

    public String getOpenUdid() {
        String r100 = this.mOpenUdid;
        if (TextUtils.isEmpty(r100) == false) goto L9;
        qb4.a r101 = this.mAppInfoProvider;
        if (r101 != null) goto L10;
        return "";
    L10:
        return r101.c();
    L9:
        return r100;
    }

    public String getSessionId() {
        String r100 = this.mSessionId;
        if (TextUtils.isEmpty(r100) == false) goto L9;
        qb4.a r101 = this.mAppInfoProvider;
        if (r101 == null) goto L7;
        r101.getClass();
    L7:
        return "";
    L9:
        return r100;
    }

    public Activity getTopActivity() {
        m r100 = this.bdTuringDepend;
        if (r100 == null) goto L5;
        Activity r101 = r100.getActivity();
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return getTopActivityBlock();
    L5:
        r101 = null;
        goto L6
    }

    public String toString() {
        return "BdTuringConfig{mRegionType=" + this.mRegionType + ", mAppId='" + this.mAppId + "', mLanguage='" + this.mLanguage + "', mAppName='" + this.mAppName + "', mChannel='" + this.mChannel + "', mSdkVersion='" + this.mSdkVersion + "', mAppKey='" + this.mAppKey + "', mInstallId='" + this.mInstallId + "', mAppVersion='" + this.mAppVersion + "', mAppVersionCode='" + this.mAppVersionCode + "', mOsName='" + this.mOsName + "', mOsVersion='" + this.mOsVersion + "', mDeviceId='" + this.mDeviceId + "', mDeviceBrand='" + this.mDeviceBrand + "', mDeviceModel='" + this.mDeviceModel + "', mContext=" + this.mContext + ", testConfig=" + this.testConfig + ", mLocale='" + this.mLocale + "', mMaskCancel=" + this.mMaskCancel + ", mQATheme=" + this.mQATheme + ", mSMSTheme=" + this.mSMSTheme + ", mIMGTheme=" + this.mIMGTheme + ", mIDENTIFYTheme=" + this.mIDENTIFYTheme + ", mSMARTERTheme=" + this.mSMARTERTheme + ", mUPSMSTheme=" + this.mUPSMSTheme + ", mDOWNSMSTheme=" + this.mDOWNSMSTheme + ", mPASSWORDTheme=" + this.mPASSWORDTheme + ", mECAFTheme=" + this.mECAFTheme + ", mINFOVERIFYTheme=" + this.mINFOVERIFYTheme + ", mEMAILTheme=" + this.mEMAILTheme + ", mVOICETheme=" + this.mVOICETheme + ", mSMSVOICETheme=" + this.mSMSVOICETheme + ", eventClient=" + this.eventClient + ", httpClient=" + this.httpClient + ", twiceVerifyDepend=" + this.twiceVerifyDepend + ", mInjectHeader=" + this.mInjectHeader + ", mSmsDigits=" + this.mSmsDigits + ", mEmailDigits=" + this.mEmailDigits + ", mThemeMap=" + this.mThemeMap + ", ticket='" + this.ticket + "', mRiskInfo='" + this.mRiskInfo + "', mFullScreen=" + this.mFullScreen + ", mChallengeCode=" + this.mChallengeCode + ", mScene='" + this.mScene + "', mShowToastSuccess=" + this.mShowToastSuccess + ", mSessionId='" + this.mSessionId + "', mOpenUdid='" + this.mOpenUdid + "', bdTuringDepend=" + this.bdTuringDepend + ", mServiceInterceptor=" + this.mServiceInterceptor + ", mEnableTTNetProcessor=" + this.mEnableTTNetProcessor + ", mBypassBdTuring=" + this.mBypassBdTuring + ", mAppInfoProvider=" + this.mAppInfoProvider + ", mThemeConfig=null, mIdentityVerifyDepend=" + this.mIdentityVerifyDepend + ", mLoginVerifyDepend=" + this.mLoginVerifyDepend + ", mAppSateProvider=null, mLiveDebugMode=" + this.mLiveDebugMode + ", mUcTwiceVerifyDepend=" + this.mUcTwiceVerifyDepend + '}';
    }

    public Activity getTopActivityBlock() {
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
            this = this;
            qb4.s r0 = qb4.s.b()
            r0.getClass()
            r1 = 0
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch: java.lang.Exception -> L39
            java.lang.Thread r2 = com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy.getLooperThread(r2)     // Catch: java.lang.Exception -> L39
            java.lang.Thread r3 = com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy.currentThread()     // Catch: java.lang.Exception -> L39
            if (r2 != r3) goto L22
            java.lang.ref.WeakReference<android.app.Activity> r2 = r0.f532385b     // Catch: java.lang.Exception -> L39
            if (r2 == 0) goto L48
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Exception -> L39
            android.app.Activity r2 = (android.app.Activity) r2     // Catch: java.lang.Exception -> L39
            r1 = r2
            goto L48
        L22:
            java.lang.Object r2 = r0.f532386c     // Catch: java.lang.Exception -> L39
            monitor-enter(r2)     // Catch: java.lang.Exception -> L39
        L25:
            java.lang.ref.WeakReference<android.app.Activity> r3 = r0.f532385b     // Catch: java.lang.Throwable -> L36
            if (r3 != 0) goto L34
            java.lang.Object r3 = r0.f532386c     // Catch: java.lang.Throwable -> L36
            r4 = 200(0xc8, double:9.9E-322)
            r3.wait(r4)     // Catch: java.lang.Throwable -> L36
            java.lang.ref.WeakReference<android.app.Activity> r3 = r0.f532385b     // Catch: java.lang.Throwable -> L36
            if (r3 != 0) goto L25
        L34:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L36
            goto L3d
        L36:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L36
            throw r3     // Catch: java.lang.Exception -> L39
        L39:
            r2 = move-exception
            r2.printStackTrace()
        L3d:
            java.lang.ref.WeakReference<android.app.Activity> r0 = r0.f532385b
            if (r0 == 0) goto L48
            java.lang.Object r0 = r0.get()
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdturing.BdTuringConfig.getTopActivityBlock():android.app.Activity");
    }

    public String getAppId() {
        return this.mAppId;
    }

    public qb4.a getAppInfoProvider() {
        return this.mAppInfoProvider;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public m getBdTuringDepend() {
        return this.bdTuringDepend;
    }

    public vb4.c getByteNNDepend() {
        return this.mByteNNDepend;
    }

    public int getChallengeCode() {
        return this.mChallengeCode;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public String getDeviceBrand() {
        return this.mDeviceBrand;
    }

    public String getDeviceModel() {
        return this.mDeviceModel;
    }

    public int getEmailDigits() {
        return this.mEmailDigits;
    }

    public k getEventClient() {
        return this.eventClient;
    }

    public boolean getFullScreen() {
        return this.mFullScreen;
    }

    public ec4.b getHttpClient() {
        return this.httpClient;
    }

    public boolean getInjectHeader() {
        return this.mInjectHeader;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public zb4.a getLoginVerifyDepend() {
        return this.mLoginVerifyDepend;
    }

    public boolean getMaskCancel() {
        return this.mMaskCancel;
    }

    public String getOsName() {
        return this.mOsName;
    }

    public String getOsVersion() {
        return this.mOsVersion;
    }

    public RegionType getRegionType() {
        return this.mRegionType;
    }

    public String getRiskInfo() {
        return this.mRiskInfo;
    }

    public String getScene() {
        return this.mScene;
    }

    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public com.bytedance.bdturing.setting.b getServiceInterceptor() {
        return this.mServiceInterceptor;
    }

    public boolean getShowToastSuccess() {
        return this.mShowToastSuccess;
    }

    public int getSmsDigits() {
        return this.mSmsDigits;
    }

    public String getTicket() {
        return this.ticket;
    }

    public fc4.a getTwiceVerifyDepend() {
        return this.twiceVerifyDepend;
    }

    public gc4.a getUcTwiceVerifyDepend() {
        return this.mUcTwiceVerifyDepend;
    }

    public boolean isBypassBdTuring() {
        return this.mBypassBdTuring;
    }

    public boolean isLiveDebugMode() {
        return this.mLiveDebugMode;
    }

    public boolean isTTNetProcessorEnable() {
        return this.mEnableTTNetProcessor;
    }

    private BdTuringConfig(b r110) {
        this.mSdkVersion = "4.1.1.cn";
        this.mAppVersionCode = "";
        this.mOsName = "android";
        this.mOsVersion = "" + Build.VERSION.SDK_INT;
        String r100 = Build.BRAND;
        this.mDeviceBrand = r100;
        String r101 = Build.MODEL;
        this.mDeviceModel = r101;
        this.testConfig = new HashMap();
        this.mQATheme = null;
        this.mSMSTheme = null;
        this.mIMGTheme = null;
        this.mIDENTIFYTheme = null;
        this.mSMARTERTheme = null;
        this.mUPSMSTheme = null;
        this.mDOWNSMSTheme = null;
        this.mPASSWORDTheme = null;
        this.mECAFTheme = null;
        this.mINFOVERIFYTheme = null;
        this.mEMAILTheme = null;
        this.mVOICETheme = null;
        this.mSMSVOICETheme = null;
        this.mThemeMap = new ConcurrentHashMap();
        this.ticket = null;
        this.mRiskInfo = null;
        this.mFullScreen = true;
        this.mScene = null;
        this.mShowToastSuccess = false;
        this.mRegionType = r110.f201616a;
        this.mAppId = r110.f201617b;
        this.mLanguage = r110.f201618c;
        this.mAppName = r110.f201619d;
        this.mChannel = r110.f201620e;
        this.mAppKey = r110.f201621f;
        this.mAppVersion = r110.f201622g;
        this.mAppVersionCode = r110.f201623h;
        Locale r102 = Locale.getDefault();
        if (TextUtils.isEmpty(null) == false) goto L5;
        String r103 = r102.toString();
    L6:
        this.mLocale = r103;
        this.eventClient = r110.f201629n;
        this.httpClient = null;
        this.twiceVerifyDepend = r110.f201630o;
        this.mSmsDigits = r110.f201633r;
        this.mEmailDigits = r110.f201632q;
        this.bdTuringDepend = r110.f201631p;
        if (TextUtils.isEmpty(null) == false) goto L21;
        String r104 = this.mLocale;
        if (r104 == null) goto L21;
        String[] r105 = r104.split("_");
        if (r105 == null) goto L21;
        if (r105.length <= 2) goto L21;
        this.mLocale = r105[0] + "_" + r105[1];
    L21:
        this.mDeviceBrand = URLEncoder.encode(r100, XML.CHARSET_UTF8);     // Catch: UnsupportedEncodingException -> L17
        this.mDeviceModel = URLEncoder.encode(r101, XML.CHARSET_UTF8);     // Catch: UnsupportedEncodingException -> L17
    L19:
        this.mInstallId = r110.f201625j;
        this.mDeviceId = r110.f201626k;
        this.mSessionId = null;
        this.mOpenUdid = null;
        this.mContext = r110.f201624i;
        this.mMaskCancel = r110.f201627l;
        this.mInjectHeader = r110.f201628m;
        this.mServiceInterceptor = null;
        this.mEnableTTNetProcessor = r110.f201634s;
        this.mBypassBdTuring = false;
        this.mAppInfoProvider = r110.f201636u;
        this.mIdentityVerifyDepend = r110.f201635t;
        this.mLoginVerifyDepend = r110.f201637v;
        this.mUcTwiceVerifyDepend = r110.f201638w;
        this.mByteNNDepend = null;
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L5:
        r103 = null;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_bdturing_BdTuringConfig_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public void enableTTNetProcessor(boolean r100) {
        this.mEnableTTNetProcessor = r100;
    }

    public Pair<String, String> getTestConfig(int r100) {
        return this.testConfig.get(Integer.valueOf(r100));
    }

    public JSONObject getTheme(int r100) {
        return this.mThemeMap.get(Integer.valueOf(r100));
    }

    public BdTuringConfig removeTestConfig(int r100) {
        this.testConfig.remove(Integer.valueOf(r100));
        return this;
    }

    public BdTuringConfig setAppId(String r100) {
        this.mAppId = r100;
        return this;
    }

    public BdTuringConfig setAppInfoProvider(qb4.a r100) {
        this.mAppInfoProvider = r100;
        return this;
    }

    public BdTuringConfig setBypassBdTuring(boolean r100) {
        this.mBypassBdTuring = r100;
        return this;
    }

    public void setByteNNDepend(vb4.c r100) {
        this.mByteNNDepend = r100;
    }

    public BdTuringConfig setChallengeCode(int r100) {
        this.mChallengeCode = r100;
        return this;
    }

    public BdTuringConfig setDeviceId(String r100) {
        this.mDeviceId = r100;
        return this;
    }

    public BdTuringConfig setEmailDigits(int r100) {
        this.mEmailDigits = r100;
        return this;
    }

    public BdTuringConfig setFullScreen(boolean r100) {
        this.mFullScreen = r100;
        return this;
    }

    public void setHttpClient(ec4.b r100) {
        this.httpClient = r100;
    }

    public BdTuringConfig setIBdturingDepend(m r100) {
        this.bdTuringDepend = r100;
        return this;
    }

    public void setIdentityVerifyDepend(ub4.b r100) {
        this.mIdentityVerifyDepend = r100;
    }

    public BdTuringConfig setInstallId(String r100) {
        this.mInstallId = r100;
        return this;
    }

    public BdTuringConfig setLanguage(String r100) {
        this.mLanguage = r100;
        return this;
    }

    public void setLiveDebugMode(boolean r100) {
        this.mLiveDebugMode = r100;
    }

    public BdTuringConfig setLocale(String r100) {
        this.mLocale = r100;
        return this;
    }

    public void setLoginVerifyDepend(zb4.a r100) {
        this.mLoginVerifyDepend = r100;
    }

    public BdTuringConfig setMaskCancel(boolean r100) {
        this.mMaskCancel = r100;
        return this;
    }

    public BdTuringConfig setOpenUdid(String r100) {
        this.mOpenUdid = r100;
        return this;
    }

    public BdTuringConfig setRegionType(RegionType r100) {
        this.mRegionType = r100;
        return this;
    }

    public BdTuringConfig setRiskInfo(String r100) {
        this.mRiskInfo = r100;
        return this;
    }

    public BdTuringConfig setScene(String r100) {
        this.mScene = r100;
        return this;
    }

    public BdTuringConfig setServiceInterceptor(com.bytedance.bdturing.setting.b r100) {
        this.mServiceInterceptor = r100;
        return this;
    }

    public BdTuringConfig setSessionId(String r100) {
        this.mSessionId = r100;
        return this;
    }

    public BdTuringConfig setShowToastSuccess(boolean r100) {
        this.mShowToastSuccess = r100;
        return this;
    }

    public BdTuringConfig setSmsDigits(int r100) {
        this.mSmsDigits = r100;
        return this;
    }

    public BdTuringConfig setTicket(String r100) {
        this.ticket = r100;
        return this;
    }

    public /* synthetic */ BdTuringConfig(b r100, a r101) {
        this(r100);
    }

    public BdTuringConfig setTheme(JSONObject r100, int r101) {
        if (r100 != null) goto L9;
        return this;
    L9:
        this.mThemeMap.put(Integer.valueOf(r101), r100);     // Catch: Exception -> L6
    L8:
        return this;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public BdTuringConfig setTestConfig(int r100, String r101, String r102) {
        this.testConfig.put(Integer.valueOf(r100), new Pair(r101, r102));
        return this;
    }
}
