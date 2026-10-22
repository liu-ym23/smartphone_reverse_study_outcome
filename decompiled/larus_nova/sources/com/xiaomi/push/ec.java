package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;

/* JADX INFO: loaded from: classes41.dex */
public final enum ec extends Enum<ec> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ec f463424a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final /* synthetic */ ec[] f476a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ec f463425b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ec f463426c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ec f463427d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ec f463428e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ec f463429f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ec f463430g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ec f463431h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ec f463432i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ec f463433j = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f477a;

    static {
        ec r100 = new ec("COMMAND_REGISTER", 0, MiPushClient.COMMAND_REGISTER);
        f463424a = r100;
        ec r101 = new ec("COMMAND_UNREGISTER", 1, MiPushClient.COMMAND_UNREGISTER);
        f463425b = r101;
        ec r102 = new ec("COMMAND_SET_ALIAS", 2, MiPushClient.COMMAND_SET_ALIAS);
        f463426c = r102;
        ec r103 = new ec("COMMAND_UNSET_ALIAS", 3, MiPushClient.COMMAND_UNSET_ALIAS);
        f463427d = r103;
        ec r104 = new ec("COMMAND_SET_ACCOUNT", 4, MiPushClient.COMMAND_SET_ACCOUNT);
        f463428e = r104;
        ec r105 = new ec("COMMAND_UNSET_ACCOUNT", 5, MiPushClient.COMMAND_UNSET_ACCOUNT);
        f463429f = r105;
        ec r110 = new ec("COMMAND_SUBSCRIBE_TOPIC", 6, MiPushClient.COMMAND_SUBSCRIBE_TOPIC);
        f463430g = r110;
        ec r111 = new ec("COMMAND_UNSUBSCRIBE_TOPIC", 7, MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC);
        f463431h = r111;
        ec r112 = new ec("COMMAND_SET_ACCEPT_TIME", 8, MiPushClient.COMMAND_SET_ACCEPT_TIME);
        f463432i = r112;
        ec r113 = new ec("COMMAND_CHK_VDEVID", 9, "check-vdeviceid");
        f463433j = r113;
        f476a = new ec[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static ec[] values() {
        return (ec[]) f476a.clone();
    }

    public static int a(String r100) {
        int r101 = -1;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return -1;
    L5:
        ec[] r102 = values();
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        ec r105 = r102[r104];
        if (r105.f477a.equals(r100) == false) goto L10;
        r101 = dr.a(r105);
    L10:
        r104 = r104 + 1;
        goto L6
    L11:
        return r101;
    }

    public static ec valueOf(String r100) {
        return (ec) r27.a.a(ec.class, r100);
    }

    private ec(String r100, int r101, String r102) {
        super(r100, r101);
        this.f477a = r102;
    }
}
