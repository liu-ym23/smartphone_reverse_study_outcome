package com.xiaomi.push.service;

import com.huawei.hms.framework.common.ContainerUtils;
import com.ttnet.org.chromium.net.NetError;

/* JADX INFO: loaded from: classes41.dex */
public class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f464266a = 8;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f1066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f464267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f464268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f464269d;

    public static int a(byte r100) {
        if (r100 < 0) goto L5;
        return r100;
    L5:
        return r100 + 256;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte m9370a() {
        int r100 = (this.f464267b + 1) % 256;
        this.f464267b = r100;
        int r101 = (this.f464268c + a(this.f1066a[r100])) % 256;
        this.f464268c = r101;
        a(this.f1066a, this.f464267b, r101);
        byte[] r102 = this.f1066a;
        return r102[(a(r102[this.f464267b]) + a(this.f1066a[this.f464268c])) % 256];
    }

    public ar() {
        this.f464269d = NetError.ERR_TTNET_QPS_MONITOR_DEGRADED;
        this.f1066a = new byte[256];
        this.f464268c = 0;
        this.f464267b = 0;
    }

    private void a() {
        this.f464268c = 0;
        this.f464267b = 0;
    }

    private void a(byte[] r100) {
        a(256, r100, false);
    }

    public static byte[] a(String r100, String r101) {
        byte[] r102 = com.xiaomi.push.ax.m8829a(r100);
        byte[] r103 = r101.getBytes();
        byte[] r104 = new byte[(r102.length + 1) + r103.length];
        int r105 = 0;
        int r106 = 0;
    L4:
        if (r106 >= r102.length) goto L6;
        r104[r106] = r102[r106];
        r106 = r106 + 1;
        goto L4
    L6:
        r104[r102.length] = 95;
    L8:
        if (r105 >= r103.length) goto L10;
        r104[(r102.length + 1) + r105] = r103[r105];
        r105 = r105 + 1;
        goto L8
    L10:
        return r104;
    }

    public static byte[] a(byte[] r100, byte[] r101) {
        byte[] r102 = new byte[r101.length];
        ar r103 = new ar();
        r103.a(r100);
        r103.a();
        int r104 = 0;
    L4:
        if (r104 >= r101.length) goto L6;
        r102[r104] = (byte) (r101[r104] ^ r103.m9370a());
        r104 = r104 + 1;
        goto L4
    L6:
        return r102;
    }

    public static byte[] a(byte[] r100, String r101) {
        return a(r100, com.xiaomi.push.ax.m8829a(r101));
    }

    private void a(int r100, byte[] r101, boolean r110) {
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= 256) goto L6;
        this.f1066a[r104] = (byte) r104;
        r104 = r104 + 1;
        goto L4
    L6:
        this.f464268c = 0;
        this.f464267b = 0;
    L7:
        int r105 = this.f464267b;
        if (r105 >= r100) goto L10;
        int r106 = ((this.f464268c + a(this.f1066a[r105])) + a(r101[this.f464267b % r102])) % 256;
        this.f464268c = r106;
        a(this.f1066a, this.f464267b, r106);
        this.f464267b++;
        goto L7
    L10:
        if (r100 == 256) goto L12;
        this.f464269d = ((this.f464268c + a(this.f1066a[r100])) + a(r101[r100 % r102])) % 256;
    L12:
        if (r110 == false) goto L24;
        StringBuilder r107 = new StringBuilder("S_");
        int r111 = r100 - 1;
        r107.append(r111);
        r107.append(":");
    L14:
        if (r103 > r100) goto L16;
        r107.append(" ");
        r107.append(a(this.f1066a[r103]));
        r103 = r103 + 1;
        goto L14
    L16:
        r107.append("   j_");
        r107.append(r111);
        r107.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r107.append(this.f464268c);
        r107.append("   j_");
        r107.append(r100);
        r107.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r107.append(this.f464269d);
        r107.append("   S_");
        r107.append(r111);
        r107.append("[j_");
        r107.append(r111);
        r107.append("]=");
        r107.append(a(this.f1066a[this.f464268c]));
        r107.append("   S_");
        r107.append(r111);
        r107.append("[j_");
        r107.append(r100);
        r107.append("]=");
        r107.append(a(this.f1066a[this.f464269d]));
        if (this.f1066a[1] == 0) goto L19;
        r107.append("   S[1]!=0");
    L19:
        com.xiaomi.channel.commonutils.logger.b.m8718a(r107.toString());
        return;
    }

    private static void a(byte[] r100, int r101, int r102) {
        byte r103 = r100[r101];
        r100[r101] = r100[r102];
        r100[r102] = r103;
    }

    public static byte[] a(byte[] r100, byte[] r101, boolean r102, int r103, int r104) {
        if (r103 < 0) goto L16;
        if (r103 > r101.length) goto L16;
        if ((r103 + r104) > r101.length) goto L16;
        int r105 = 0;
        if (r102 == true) goto L10;
        byte[] r106 = new byte[r104];
        int r107 = 0;
    L11:
        ar r108 = new ar();
        r108.a(r100);
        r108.a();
    L12:
        if (r105 >= r104) goto L14;
        r106[r107 + r105] = (byte) (r101[r103 + r105] ^ r108.m9370a());
        r105 = r105 + 1;
        goto L12
    L14:
        return r106;
    L10:
        r106 = r101;
        r107 = r103;
    L16:
        throw new IllegalArgumentException("start = " + r103 + " len = " + r104);
    }
}
