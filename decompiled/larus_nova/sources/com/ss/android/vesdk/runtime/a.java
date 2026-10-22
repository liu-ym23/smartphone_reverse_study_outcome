package com.ss.android.vesdk.runtime;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.ttve.common.TECloudCtrlInvoker;
import com.ss.android.ttve.common.TESpdLogManager;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.runtime.persistence.VESP;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f455891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f455892e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f455893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TECloudCtrlInvoker f455894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f455895c;

    public static a b() {
        if (f455891d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f455891d != null) goto L9;
        f455891d = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f455891d;
    }

    static {
        f455892e = new String[]{"vesdk_log_command"};
    }

    public a() {
        this.f455893a = false;
        this.f455894b = new TECloudCtrlInvoker();
    }

    public final void a(String r210) {
        this.f455895c = r210;
        String[] r100 = f455892e;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L83;
        String r103 = r100[r102];
        String r104 = (String) VESP.b().a(r103, "");
        if (r104.isEmpty() == false) goto L84;
        String[] r110 = r100;
    L82:
        r102 = r102 + 1;
        r100 = r110;
        goto L3
    L84:
        JSONObject r105 = new JSONObject(r104);     // Catch: Exception -> L78
        r110 = r100;
        byte r111 = -1;
        if (r103.hashCode() == 2043549244) goto L86;
    L14:
        byte r106 = -1;
    L15:
        if (r106 == 0) goto L19;
        VELogUtil.e("VECloudCtrlManager", " json contail invalid command ");     // Catch: Exception -> L41
        goto L82
    L19:
        if (r105.has("enable") == false) goto L21;
        String r107 = JSONObjectProtectorUtils.getString(r105, "enable");     // Catch: Exception -> L41
    L23:
        String r112 = "2018-12-08 00:00:00";
        if (r105.has("starttime") == false) goto L26;
        String r113 = JSONObjectProtectorUtils.getString(r105, "starttime");     // Catch: Exception -> L41
    L28:
        if (r105.has("endtime") == false) goto L30;
        r112 = JSONObjectProtectorUtils.getString(r105, "endtime");     // Catch: Exception -> L41
    L30:
        String r114 = r112;
        if (r105.has("level") == false) goto L33;
        String r108 = JSONObjectProtectorUtils.getString(r105, "level");     // Catch: Exception -> L41
    L35:
        if (r105.has("sign") == false) goto L37;
        String r109 = JSONObjectProtectorUtils.getString(r105, "sign");     // Catch: Exception -> L41
    L39:
        if (this.f455894b.a(r103 + r107 + r113 + r114 + r108, r109) == true) goto L43;
        VESP.b().d(r103, "", false);     // Catch: Exception -> L41
        VELogUtil.e("VECloudCtrlManager", "Cloud Ctrl Command Json is doctored");     // Catch: Exception -> L41
        goto L82
    L43:
        SimpleDateFormat r115 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // Catch: Exception -> L41
        long r116 = r115.parse(r113).getTime();     // Catch: Exception -> L41
        long r117 = r115.parse(r114).getTime();     // Catch: Exception -> L41
        long r211 = System.currentTimeMillis();     // Catch: Exception -> L41
        TESpdLogManager.InfoLevel r118 = TESpdLogManager.InfoLevel.LEVEL0;     // Catch: Exception -> L41
        if (r108.hashCode() == 68) goto L47;
    L49:
        if (r111 == 0) goto L51;
        TESpdLogManager.InfoLevel r119 = TESpdLogManager.InfoLevel.LEVEL3;     // Catch: Exception -> L41
    L53:
        if (this.f455893a == true) goto L68;
        if (r107.equals("true") == false) goto L68;
        if (r211 < r116) goto L68;
        if (r211 >= r117) goto L68;
        String r120 = this.f455895c + "/vesdklog";     // Catch: Exception -> L41
        VELogUtil.d("VECloudCtrlManager", r120);     // Catch: Exception -> L41
        TESpdLogManager r121 = TESpdLogManager.a();     // Catch: Exception -> L41
        int r122 = r119.ordinal();     // Catch: Exception -> L41
        r121.getClass();     // Catch: Exception -> L41
        int r123 = r121.f449830a.initSpdLog(r120, r122, 3);     // Catch: Exception -> L41
        if (r123 < 0) goto L64;
        r123 = 0;
    L64:
        if (r123 >= 0) goto L66;
        VELogUtil.e("VECloudCtrlManager", " TESpdLog init fail " + r123);     // Catch: Exception -> L41
        goto L82
    L66:
        TESpdLogManager.a().f449830a.setLevel(r119.ordinal());     // Catch: Exception -> L41
        this.f455893a = true;     // Catch: Exception -> L41
    L68:
        if (r107.equals("false") == true) goto L74;
        if (r211 >= r116) goto L82;
        if (r211 < r117) goto L82;
    L74:
        if (this.f455893a == false) goto L76;
        TESpdLogManager.a().f449830a.close();     // Catch: Exception -> L41
        this.f455893a = false;     // Catch: Exception -> L41
    L76:
        VELogUtil.d("VECloudCtrlManager", r103.concat(" expired"));     // Catch: Exception -> L41
        VESP.b().d(r103, "", false);     // Catch: Exception -> L41
        goto L82
    L51:
        r119 = TESpdLogManager.InfoLevel.LEVEL0;     // Catch: Exception -> L41
        goto L53
    L47:
        if (r108.equals("D") == false) goto L49;
        r111 = 0;
        goto L49
    L37:
        r109 = "";
        goto L39
    L33:
        r108 = "";
        goto L35
    L26:
        r113 = "2018-12-08 00:00:00";
        goto L28
    L21:
        r107 = "false";
        goto L23
    L86:
        if (r103.equals("vesdk_log_command") == false) goto L14;
        r106 = 0;
    L41:
        e = e;
    L80:
        VELogUtil.e("VECloudCtrlManager", " json parse failed " + e.toString());
        VESP.b().d(r103, "", false);
    L78:
        e = e;
        r110 = r100;
        goto L80
    }
}
