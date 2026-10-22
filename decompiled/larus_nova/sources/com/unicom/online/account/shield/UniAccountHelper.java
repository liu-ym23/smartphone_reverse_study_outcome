package com.unicom.online.account.shield;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.unicom.online.account.kernel.a;
import com.unicom.online.account.kernel.ac;
import com.unicom.online.account.kernel.b;
import com.unicom.online.account.kernel.h;
import com.unicom.online.account.kernel.i;
import com.unicom.online.account.kernel.j;
import com.unicom.online.account.kernel.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class UniAccountHelper {
    private static final int CU_GET_TOKEN_GM = 3;
    private static final int CU_GET_TOKEN_IT = 2;
    private static final int CU_GET_TOKEN_LOOP = 32;
    private static final int CU_GET_UAID_GM = 25;
    private static final int CU_GET_UAID_IT = 24;
    private static final int CU_GET_UAID_LOOP = 33;
    private static final int CU_MOBILE_AUTH_GM = 5;
    private static final int CU_MOBILE_AUTH_IT = 4;
    private static final int ID_0_STOP_ONCE_SUCCESS = 0;
    private static final int ID_1_STOP_ALL_SEND = 1;
    private static final int LOOP_TYPE_TOKEN = 1;
    private static final int LOOP_TYPE_UAID = 2;
    private static final int LoopMaxNum = 5;
    private static int LoopTypeFlag = 0;
    private static final int SUCCESS = 100;
    private static final boolean enableToken = true;
    private static final boolean enableUAID = false;
    private static int loopNumCommon;
    private static int loopNumToken;
    private static int loopNumUaid;
    private static volatile UniAccountHelper s_instance;
    private Context mContext;
    Handler mainHandler;

    private UniAccountHelper() {
        this.mContext = null;
    }

    public static /* synthetic */ void access$000(UniAccountHelper r100) {
        r100.loopNumCommonMinus();
    }

    public static /* synthetic */ void access$100() {
        cuResetLoopSrc();
    }

    public static /* synthetic */ int access$200() {
        return loopNumCommon;
    }

    public static /* synthetic */ void access$300(UniAccountHelper r100, int r101, int r102, int r103, ResultListener r104) {
        r100.cuGetTokenUaidLoopCommon(r101, r102, r103, r104);
    }

    public static /* synthetic */ Context access$400(UniAccountHelper r100) {
        return r100.mContext;
    }

    private UniAccountHelper clearCache_one(int r100) {
        if (this.mContext != null) goto L6;
        a.a("clearCache sdk未初始化 ---> " + System.currentTimeMillis());
        return null;
    L6:
        b.a();
        i.a().a(this.mContext, r100);
        return s_instance;
    }

    private static int clrLoopTypeFlag() {
        LoopTypeFlag = 0;
        return 0;
    }

    private void cuGetTokenLoop(int r100, int r101, int r110, ResultListener r111) {
        a.a("cuGetTokenLoop ---> " + System.currentTimeMillis());
        if (isInUaidLoop() == false) goto L7;
        initFail(r101, r111, 410023, "取号服务中，勿重复调用", r110);
        return;
    L7:
        if (isInTokenLoop() == false) goto L10;
        initFail(r101, r111, 410023, "取号服务中，勿重复调用", r110);
        return;
    L10:
        setLoopTypeFlag(1);
        int r102 = loopNumToken + loopNumAdd(r100);
        loopNumToken = r102;
        loopNumCommon = r102;
        cuGetTokenUaidLoopCommon(0, r101, r110, r111);
    }

    private void cuGetTokenUaidLoopCommon(final int r100, final int r110, final int r111, final ResultListener r112) {
        if (loopNumCommon != 0) goto L7;
        cuResetLoopSrc();
        return;
    L7:
        if (r100 == 1) goto L11;
        ResultListener r101 = new AnonymousClass1(this, r110, r112, r100, r111);
    L9:
        cuPreGetToken(r111, r110, "cuPreGetToken", r101);
        return;
    L11:
        r101 = new AnonymousClass2(this, r110, r112, r100, r111);
        goto L9
    }

    private void cuGetUaid(int r100, ResultListener r101) {
        initFail(0, r101, 410022, "不支持该服务", r100);
    }

    private void cuGetUaidLoop(int r100, int r101, int r102, ResultListener r110) {
        initFail(r101, r110, 410022, "不支持该服务", r102);
    }

    private void cuGetUaidLoop(int r100, int r101, ResultListener r102) {
        initFail(0, r102, 410022, "不支持该服务", r101);
    }

    private static boolean cuIsToken(int r100) {
        return ac.a(r100);
    }

    private static boolean cuIsUaid(int r100) {
        return ac.b(r100);
    }

    private void cuPreGetToken(final int r110, final int r111, final String r112, final ResultListener r113) {
        Context r100 = this.mContext;
        if (r100 != null) goto L7;
        initFail(r111, r113, "sdk未初始化", r110);
        return;
    L7:
        if (i.b(r100.getApplicationContext()) == true) goto L9;
        initFail(r111, r113, 410004, "数据网络未开启", r110);
        return;
    L9:
        if (getUseCacheFlag() == false) goto L36;
        i r101 = i.a();
        Context r102 = this.mContext;
        if (r112.equals(r101.f462055b) == false) goto L13;
        String r103 = j.a(r102, i.a(r111), r112 + r101.f462056c);
    L15:
        if (b.e(r103).booleanValue() == false) goto L36;
        JSONObject r104 = new JSONObject(r103);     // Catch: Exception -> L35
        int r105 = JSONObjectProtectorUtils.getInt(r104, "resultCode");     // Catch: Exception -> L35
        JSONObjectProtectorUtils.getInt(r104, "type");     // Catch: Exception -> L67
    L20:
        if (cuIsToken(2) == false) goto L28;
        long r106 = JSONObjectProtectorUtils.getLong(JSONObjectProtectorUtils.getJSONObject(r104, OnekeyLoginConstants.CU_KEY_RESULT_DATA), OnekeyLoginConstants.CU_KEY_TOKEN_EXPIRES);     // Catch: Exception -> L35
        if (r105 != 100) goto L36;
        if (r106 <= System.currentTimeMillis()) goto L36;
        r113.onResult(r103);     // Catch: Exception -> L35
        return;
    L28:
        if (cuIsUaid(2) == false) goto L36;
        long r107 = JSONObjectProtectorUtils.getLong(r104, OnekeyLoginConstants.CU_KEY_TOKEN_EXPIRES);     // Catch: Exception -> L35
        if (r105 != 100) goto L36;
        if (r107 <= System.currentTimeMillis()) goto L36;
        r113.onResult(r103);     // Catch: Exception -> L35
        return;
    L13:
        r103 = "";
    L36:
        i.a();
        if (i.a(this.mContext) == true) goto L41;
        initFail(r111, r113, 410025, "操作频繁,请稍后再试", r110);
        return;
    L41:
        if (r112.equals("cuPreGetToken") == true) goto L44;
        initFail(r111, r113, "sdk参数错误", r110);
        return;
    L44:
        if (r111 != 2) goto L46;
    L61:
        i r108 = i.a();
        h r109 = new AnonymousClass4(this, r111, r112, r110, r113);
        if (r108.a("cuPreGetToken", r110, r111, r109) == false) goto L72;
        new x().a(r108.f462054a, r110, r111, r109);
        return;
    L72:
        return;
    L46:
        if (r111 == 3) goto L61;
        if (r111 == 4) goto L61;
        if (r111 == 5) goto L61;
        if (r111 != 24) goto L54;
    L57:
        i r114 = i.a();
        h r115 = new AnonymousClass3(this, r111, r112, r113);
        if (r114.a("cuPreGetUAID", r110, r111, r115) == false) goto L71;
        new x().a(r114.f462054a, r110, r111, r115);
        return;
    L71:
        return;
    L54:
        if (r111 == 25) goto L57;
        initFail(r111, r113, "sdk type 参数错误", r110);
    }

    private static void cuResetLoopSrc() {
        loopNumCommon = 0;
        loopNumToken = 0;
        loopNumUaid = 0;
        clrLoopTypeFlag();
    }

    public static String getCertFingerType() {
        return ac.f461953e;
    }

    private String getHostName() {
        i.a();
        return i.d();
    }

    public static UniAccountHelper getInstance() {
        if (s_instance != null) goto L15;
        monitor-enter(UniAccountHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (s_instance != null) goto L9;
        s_instance = new UniAccountHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(UniAccountHelper.class);     // Catch: Throwable -> L11
    L15:
        return s_instance;
    }

    private static int getLoopTypeFlag() {
        return LoopTypeFlag;
    }

    private String getSdkVersion() {
        i.a();
        return i.b();
    }

    private UniAccountHelper initCustmType(int r100) {
        i.a();
        i.b(r100);
        return s_instance;
    }

    private void initFail(int r100, ResultListener r101, int r110, String r111, int r112) {
        a.b("type:" + r100 + "\nmsg:" + r111);
        String r102 = i.g();     // Catch: Exception -> L10
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L10
        r103.put("resultCode", r110);     // Catch: Exception -> L10
        r103.put("resultMsg", r111);     // Catch: Exception -> L10
        r103.put(OnekeyLoginConstants.CU_KEY_RESULT_DATA, "");     // Catch: Exception -> L10
        r103.put(OnekeyLoginConstants.CU_KEY_SEQ, r102);     // Catch: Exception -> L10
        cuResetLoopSrc();     // Catch: Exception -> L10
        if (r101 == null) goto L6;
        r101.onResult(r103.toString());     // Catch: Exception -> L10
    L6:
        i.a();     // Catch: Exception -> L10
        if (i.c() == false) goto L15;
        i.a();     // Catch: Exception -> L10
        i.a().b(i.a(1, 1, r102, r110, r112, r110, r111));     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        a.a(e);
    }

    private void initFail(int r100, ResultListener r101, String r102, int r110) {
        initFail(r100, r101, 410021, r102, r110);
    }

    private UniAccountHelper initHostName(String r100) {
        i.a();
        if (i.c(r100) == true) goto L7;
        a.b("初始化参数错误");
        return null;
    L7:
        return s_instance;
    }

    private static boolean isInTokenLoop() {
        if ((LoopTypeFlag & 1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isInUaidLoop() {
        if ((LoopTypeFlag & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private int loopNumAdd(int r100) {
        if (r100 < 5) goto L6;
        return 5;
    L6:
        if (r100 > 1) goto L10;
        return 1;
    L10:
        return r100;
    }

    private void loopNumCommonMinus() {
        int r100 = loopNumCommon;
        if (r100 <= 5) goto L7;
        int r101 = 4;
    L5:
        loopNumCommon = r101;
        return;
    L7:
        if (r100 <= 0) goto L9;
        r101 = r100 - 1;
        goto L5
    L9:
        r101 = 0;
        goto L5
    }

    private static int setLoopTypeFlag(int r100) {
        int r101 = r100 | LoopTypeFlag;
        LoopTypeFlag = r101;
        return r101;
    }

    public UniAccountHelper clearCache() {
        if (this.mContext != null) goto L6;
        a.a("clearCache sdk未初始化 ---> " + System.currentTimeMillis());
        return null;
    L6:
        b.a();
        i.a();
        i.c(this.mContext);
        return s_instance;
    }

    public String cuDebugInfo(String r100) {
        if (this.mContext != null) goto L7;
        return "sdk 未初始化, context 为空";
    L7:
        return i.a().a(r100);
    }

    public void cuGetToken(int r100, ResultListener r101) {
        if (ac.f461949a == false) goto L5;
        int r102 = 3;
    L6:
        cuPreGetToken(r100, r102, "cuPreGetToken", r101);
        return;
    L5:
        r102 = 2;
        goto L6
    }

    public void cuGetTokenLoop(int r100, int r101, ResultListener r102) {
        if (ac.f461949a == false) goto L5;
        int r103 = 3;
    L6:
        cuGetTokenLoop(r100, r103, r101, r102);
        return;
    L5:
        r103 = 2;
        goto L6
    }

    public void cuMobileAuth(int r100, ResultListener r101) {
        if (ac.f461949a == false) goto L5;
        int r102 = 5;
    L6:
        cuPreGetToken(r100, r102, "cuPreGetToken", r101);
        return;
    L5:
        r102 = 4;
        goto L6
    }

    public boolean getUseCacheFlag() {
        return ac.f461952d;
    }

    public UniAccountHelper init(Context r100, String r101) {
        return init(r100, r101, false);
    }

    public UniAccountHelper init(Context r100, String r101, boolean r102) {
        if (r100 != null) goto L5;
    L19:
        String r103 = "初始化参数不能为空";
    L12:
        a.b(r103);
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        if (TextUtils.isEmpty(r101) == true) goto L19;
        if (this.mContext == null) goto L14;
        r103 = "重复初始化";
        goto L12
    L14:
        this.mContext = r100.getApplicationContext();
        if (i.a().a(r100, r101, r101, r102) == true) goto L17;
        r103 = "UniAuthHelper.getInstance().init 初始化错误";
        goto L12
    L17:
        b.f462020a = r101;
        this.mainHandler = new Handler(Looper.getMainLooper());
        return s_instance;
    }

    public void releaseNetwork() {
        i.a();
        i.f();
    }

    public UniAccountHelper setCBinMainThread(boolean r100) {
        ac.f461954f = r100;
        return s_instance;
    }

    public UniAccountHelper setCertFingerType(String r100) {
        if (r100.equalsIgnoreCase("MD5") == false) goto L5;
    L13:
        ac.f461953e = r100.toLowerCase();
        return s_instance;
    L5:
        if (r100.equalsIgnoreCase("SHA1") == true) goto L13;
        if (r100.equalsIgnoreCase("SHA256") == true) goto L13;
        if (r100.equalsIgnoreCase("sm3") == true) goto L13;
        return null;
    }

    public UniAccountHelper setCryptoGM(boolean r100) {
        ac.f461949a = r100;
        return s_instance;
    }

    public void setLogEnable(boolean r100) {
        a.a(r100);
        i.a();
        i.a(r100);
    }

    public UniAccountHelper setUseCacheFlag(boolean r100) {
        ac.f461952d = r100;
        return s_instance;
    }
}
