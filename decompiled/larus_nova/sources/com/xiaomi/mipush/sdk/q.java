package com.xiaomi.mipush.sdk;

import com.huawei.hms.android.SystemUtils;
import com.larus.dora.api.model.FlowDoraWifiScene;

/* JADX INFO: loaded from: classes41.dex */
public final enum q extends Enum<q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f463077a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final /* synthetic */ q[] f185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f463078b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f463079c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f463080d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q f463081e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q f463082f = null;

    static {
        q r100 = new q(SystemUtils.PRODUCT_HUAWEI, 0);
        f463077a = r100;
        q r101 = new q("MEIZU", 1);
        f463078b = r101;
        q r102 = new q("FCM", 2);
        f463079c = r102;
        q r103 = new q("OPPO", 3);
        f463080d = r103;
        q r104 = new q("VIVO", 4);
        f463081e = r104;
        q r105 = new q(FlowDoraWifiScene.OTHER, 5);
        f463082f = r105;
        f185a = new q[]{r100, r101, r102, r103, r104, r105};
    }

    public static q[] values() {
        return (q[]) f185a.clone();
    }

    public static q valueOf(String r100) {
        return (q) r27.a.a(q.class, r100);
    }

    private q(String r100, int r101) {
        super(r100, r101);
    }
}
