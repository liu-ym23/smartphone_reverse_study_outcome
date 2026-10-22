package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f300231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f300232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f300233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f300234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UplinkFileEntity f300235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f300236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f300237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f300238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f300239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f300240j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f300231a, r101.f300231a) == true) goto L12;
        return false;
    L12:
        if (this.f300232b == r101.f300232b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f300233c, r101.f300233c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f300234d, r101.f300234d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f300235e, r101.f300235e) == true) goto L24;
        return false;
    L24:
        if (this.f300236f == r101.f300236f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f300237g, r101.f300237g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f300238h, r101.f300238h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f300239i, r101.f300239i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f300240j, r101.f300240j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f300231a.hashCode() * 31;
        int r101 = 1231;
        if (this.f300232b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((r100 + r102) * 31) + this.f300233c.hashCode()) * 31) + this.f300234d.hashCode()) * 31) + this.f300235e.hashCode()) * 31;
        if (this.f300236f == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        String r105 = this.f300237g;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f300238h;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f300239i;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f300240j;
        if (r115 == null) goto L27;
        r106 = r115.hashCode();
    L27:
        return r114 + r106;
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "TryFileUploadParam(conversationId=" + this.f300231a + ", isMultiFile=" + this.f300232b + ", listener=" + this.f300233c + ", fromScene=" + this.f300234d + ", entity=" + this.f300235e + ", skippedAttachment=" + this.f300236f + ", localSendMsgId=" + this.f300237g + ", botId=" + this.f300238h + ", sectionId=" + this.f300239i + ", uploadTaskShareTag=" + this.f300240j + ')';
    }

    public q(String r100, boolean r101, m r102, String r103, UplinkFileEntity r104, boolean r105, String r106, String r107, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "listener");
        Intrinsics.checkNotNullParameter(r103, "fromScene");
        Intrinsics.checkNotNullParameter(r104, "entity");
        this.f300231a = r100;
        this.f300232b = r101;
        this.f300233c = r102;
        this.f300234d = r103;
        this.f300235e = r104;
        this.f300236f = r105;
        this.f300237g = r106;
        this.f300238h = r107;
        this.f300239i = r110;
        this.f300240j = r111;
    }

    public /* synthetic */ q(String r110, boolean r111, m r112, String r113, UplinkFileEntity r114, boolean r115, String r210, String r211, String r212, String r213, int r214) {
        if ((r214 & 32) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r214 & 64) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r214 & 128) == 0) goto L13;
        String r116 = null;
    L15:
        if ((r214 & 256) == 0) goto L17;
        String r117 = null;
    L19:
        if ((r214 & 512) == 0) goto L21;
        String r118 = null;
    L22:
        this(r110, r111, r112, r113, r114, r100, r101, r116, r117, r118);
        return;
    L21:
        r118 = r213;
        goto L22
    L17:
        r117 = r212;
        goto L19
    L13:
        r116 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r115;
        goto L7
    }
}
