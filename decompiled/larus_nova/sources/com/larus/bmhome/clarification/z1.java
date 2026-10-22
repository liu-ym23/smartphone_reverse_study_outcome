package com.larus.bmhome.clarification;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f310644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f310645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f310646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f310647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f310648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f310649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f310650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f310651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f310652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f310653j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<ResourceItemBean> f310654k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f310655l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final hk9.a f310656m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z1) == true) goto L8;
        return false;
    L8:
        z1 r101 = (z1) r100;
        if (Intrinsics.areEqual(this.f310644a, r101.f310644a) == true) goto L12;
        return false;
    L12:
        if (this.f310645b == r101.f310645b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f310646c, r101.f310646c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f310647d, r101.f310647d) == true) goto L21;
        return false;
    L21:
        if (this.f310648e == r101.f310648e) goto L24;
        return false;
    L24:
        if (this.f310649f == r101.f310649f) goto L27;
        return false;
    L27:
        if (this.f310650g == r101.f310650g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f310651h, r101.f310651h) == true) goto L33;
        return false;
    L33:
        if (this.f310652i == r101.f310652i) goto L36;
        return false;
    L36:
        if (this.f310653j == r101.f310653j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f310654k, r101.f310654k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f310655l, r101.f310655l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f310656m, r101.f310656m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f310644a.hashCode() * 31) + this.f310645b) * 31) + this.f310646c.hashCode()) * 31) + this.f310647d.hashCode()) * 31) + this.f310648e) * 31) + this.f310649f) * 31;
        int r101 = 1231;
        if (this.f310650g == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f310651h.hashCode()) * 31;
        if (this.f310652i == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (((((((r103 + r101) * 31) + this.f310653j) * 31) + this.f310654k.hashCode()) * 31) + this.f310655l.hashCode()) * 31;
        hk9.a r105 = this.f310656m;
        if (r105 != null) goto L13;
        int r106 = 0;
    L15:
        return r104 + r106;
    L13:
        r106 = r105.hashCode();
        goto L15
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ClarificationPageState(questionId=" + this.f310644a + ", index=" + this.f310645b + ", inputText=" + this.f310646c + ", inputMethod=" + this.f310647d + ", selectionStart=" + this.f310648e + ", selectionEnd=" + this.f310649f + ", isSpeakMode=" + this.f310650g + ", attachmentLocalMsgId=" + this.f310651h + ", hasAttachment=" + this.f310652i + ", attachmentCount=" + this.f310653j + ", attachmentItems=" + this.f310654k + ", answerDraft=" + this.f310655l + ", blockContainer=" + this.f310656m + ')';
    }

    public static z1 a(z1 r110, String r111, String r210, int r211, int r212, boolean r213, boolean r214, int r215, List r216, i r217, hk9.a r218, int r219) {
        String r100 = null;
        if ((r219 & 1) == 0) goto L5;
        String r101 = r110.f310644a;
    L7:
        if ((r219 & 2) == 0) goto L9;
        int r102 = r110.f310645b;
    L11:
        if ((r219 & 4) == 0) goto L13;
        String r103 = r110.f310646c;
    L15:
        if ((r219 & 8) == 0) goto L17;
        String r104 = r110.f310647d;
    L19:
        if ((r219 & 16) == 0) goto L21;
        int r105 = r110.f310648e;
    L23:
        if ((r219 & 32) == 0) goto L25;
        int r112 = r110.f310649f;
    L27:
        if ((r219 & 64) == 0) goto L29;
        boolean r113 = r110.f310650g;
    L31:
        if ((r219 & 128) == 0) goto L33;
        r100 = r110.f310651h;
    L33:
        String r114 = r100;
        if ((r219 & 256) == 0) goto L36;
        boolean r115 = r110.f310652i;
    L38:
        if ((r219 & 512) == 0) goto L40;
        int r116 = r110.f310653j;
    L42:
        if ((r219 & 1024) == 0) goto L44;
        List r117 = r110.f310654k;
    L46:
        if ((r219 & 2048) == 0) goto L48;
        i r106 = r110.f310655l;
    L50:
        if ((r219 & 4096) == 0) goto L52;
        hk9.a r118 = r110.f310656m;
    L53:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "questionId");
        Intrinsics.checkNotNullParameter(r103, "inputText");
        Intrinsics.checkNotNullParameter(r104, "inputMethod");
        Intrinsics.checkNotNullParameter(r114, "attachmentLocalMsgId");
        Intrinsics.checkNotNullParameter(r117, "attachmentItems");
        Intrinsics.checkNotNullParameter(r106, "answerDraft");
        return new z1(r101, r102, r103, r104, r105, r112, r113, r114, r115, r116, r117, r106, r118);
    L52:
        r118 = r218;
        goto L53
    L48:
        r106 = r217;
        goto L50
    L44:
        r117 = r216;
        goto L46
    L40:
        r116 = r215;
        goto L42
    L36:
        r115 = r214;
        goto L38
    L29:
        r113 = r213;
        goto L31
    L25:
        r112 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = 0;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public z1(String r100, int r101, String r102, String r103, int r104, int r105, boolean r106, String r107, boolean r110, int r111, List<ResourceItemBean> r112, i r113, hk9.a r114) {
        Intrinsics.checkNotNullParameter(r100, "questionId");
        Intrinsics.checkNotNullParameter(r102, "inputText");
        Intrinsics.checkNotNullParameter(r103, "inputMethod");
        Intrinsics.checkNotNullParameter(r107, "attachmentLocalMsgId");
        Intrinsics.checkNotNullParameter(r112, "attachmentItems");
        Intrinsics.checkNotNullParameter(r113, "answerDraft");
        this.f310644a = r100;
        this.f310645b = r101;
        this.f310646c = r102;
        this.f310647d = r103;
        this.f310648e = r104;
        this.f310649f = r105;
        this.f310650g = r106;
        this.f310651h = r107;
        this.f310652i = r110;
        this.f310653j = r111;
        this.f310654k = r112;
        this.f310655l = r113;
        this.f310656m = r114;
    }
}
