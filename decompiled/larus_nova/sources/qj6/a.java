package qj6;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomProfile;
import com.bytedance.live.livelink.kmp.impl.extend.subroom.RtcBusinessType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f533297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f533298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveWrappedRoomProfile f533299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f533300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f533301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f533302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f533303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f533304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RtcBusinessType f533305i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L24;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f533297a, r101.f533297a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f533298b, r101.f533298b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f533299c, r101.f533299c) == true) goto L12;
        return false;
    L12:
        if (this.f533300d == r101.f533300d) goto L14;
        return false;
    L14:
        if (this.f533301e == r101.f533301e) goto L16;
        return false;
    L16:
        if (this.f533302f == r101.f533302f) goto L18;
        return false;
    L18:
        if (this.f533303g == r101.f533303g) goto L20;
        return false;
    L20:
        if (this.f533304h == r101.f533304h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f533305i, r101.f533305i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f533297a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f533298b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LiveWrappedRoomProfile r107 = this.f533299c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f533300d;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (r109 + r112) * 31;
        boolean r114 = this.f533301e;
        ?? r115 = r114;
        if (r114 == false) goto L20;
        r115 = 1;
    L20:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.f533302f;
        ?? r118 = r117;
        if (r117 == false) goto L23;
        r118 = 1;
    L23:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.f533303g;
        ?? r121 = r120;
        if (r120 == false) goto L26;
        r121 = 1;
    L26:
        int r122 = (r119 + r121) * 31;
        boolean r123 = this.f533304h;
        if (r123 == true) goto L30;
        r111 = r123;
    L30:
        int r124 = (r122 + r111) * 31;
        RtcBusinessType r125 = this.f533305i;
        if (r125 == null) goto L34;
        r101 = r125.hashCode();
    L34:
        return r124 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RoomConfig(roomId=" + this.f533297a + ", token=" + this.f533298b + ", channelProfile=" + this.f533299c + ", isPublishAudio=" + this.f533300d + ", isPublishVideo=" + this.f533301e + ", isAutoSubscribeAudio=" + this.f533302f + ", isAutoSubscribeVideo=" + this.f533303g + ", selfVisibleToOther=" + this.f533304h + ", rtcBusinessType=" + this.f533305i + ")";
    }

    public static a a(a r110, int r111) {
        RtcBusinessType r100 = null;
        if ((r111 & 1) == 0) goto L5;
        String r101 = r110.f533297a;
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r102 = r110.f533298b;
    L11:
        if ((r111 & 4) == 0) goto L13;
        LiveWrappedRoomProfile r103 = r110.f533299c;
    L15:
        if ((r111 & 8) == 0) goto L17;
        boolean r104 = r110.f533300d;
    L19:
        if ((r111 & 16) == 0) goto L21;
        boolean r105 = r110.f533301e;
    L23:
        if ((r111 & 32) == 0) goto L25;
        boolean r106 = r110.f533302f;
    L27:
        if ((r111 & 64) == 0) goto L29;
        boolean r107 = r110.f533303g;
    L31:
        if ((r111 & 128) == 0) goto L33;
        boolean r112 = r110.f533304h;
    L35:
        if ((r111 & 256) == 0) goto L37;
        r100 = r110.f533305i;
    L37:
        RtcBusinessType r113 = r100;
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r103, "channelProfile");
        Intrinsics.checkNotNullParameter(r113, "rtcBusinessType");
        return new a(r101, r102, r103, r104, r105, r106, r107, r112, r113);
    L33:
        r112 = false;
        goto L35
    L29:
        r107 = false;
        goto L31
    L25:
        r106 = false;
        goto L27
    L21:
        r105 = false;
        goto L23
    L17:
        r104 = false;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public a(String r100, String r101, LiveWrappedRoomProfile r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, RtcBusinessType r110) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "channelProfile");
        Intrinsics.checkNotNullParameter(r110, "rtcBusinessType");
        this.f533297a = r100;
        this.f533298b = r101;
        this.f533299c = r102;
        this.f533300d = r103;
        this.f533301e = r104;
        this.f533302f = r105;
        this.f533303g = r106;
        this.f533304h = r107;
        this.f533305i = r110;
    }
}
