package com.larus.bmhome.chat.standarduikit.vlm.view;

import android.util.Size;
import com.larus.bmhome.chat.markdown.vlm.FlowVLMContainerViewType;
import com.larus.bmhome.chat.markdown.vlm.RenderType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f309916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f309917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Size f309918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f309919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f309920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f309921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f309922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RenderType f309923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f309924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FlowVLMContainerViewType f309925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f309926k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f309916a, r101.f309916a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309917b, r101.f309917b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309918c, r101.f309918c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309919d, r101.f309919d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f309920e, r101.f309920e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f309921f, r101.f309921f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f309922g, r101.f309922g) == true) goto L30;
        return false;
    L30:
        if (this.f309923h == r101.f309923h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f309924i, r101.f309924i) == true) goto L36;
        return false;
    L36:
        if (this.f309925j == r101.f309925j) goto L39;
        return false;
    L39:
        if (this.f309926k == r101.f309926k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f309916a.hashCode() * 31) + this.f309917b.hashCode()) * 31;
        Size r101 = this.f309918c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f309919d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f309920e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f309921f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f309922g;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        int r115 = (((((((r113 + r102) * 31) + this.f309923h.hashCode()) * 31) + this.f309924i.hashCode()) * 31) + this.f309925j.hashCode()) * 31;
        if (this.f309926k == false) goto L25;
        int r116 = 1231;
    L27:
        return r115 + r116;
    L25:
        r116 = 1237;
        goto L27
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VlmRenderInfo(messageId=" + this.f309916a + ", cardId=" + this.f309917b + ", itemViewSize=" + this.f309918c + ", descriptionTitle=" + this.f309919d + ", moreImageSize=" + this.f309920e + ", sourceIconUrl=" + this.f309921f + ", coverUrl=" + this.f309922g + ", renderType=" + this.f309923h + ", originData=" + this.f309924i + ", containerViewType=" + this.f309925j + ", isInVideoGroup=" + this.f309926k + ')';
    }

    public l(String r100, String r101, Size r102, String r103, Integer r104, String r105, String r106, RenderType r107, c r110, FlowVLMContainerViewType r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "cardId");
        Intrinsics.checkNotNullParameter(r107, "renderType");
        Intrinsics.checkNotNullParameter(r110, "originData");
        Intrinsics.checkNotNullParameter(r111, "containerViewType");
        this.f309916a = r100;
        this.f309917b = r101;
        this.f309918c = r102;
        this.f309919d = r103;
        this.f309920e = r104;
        this.f309921f = r105;
        this.f309922g = r106;
        this.f309923h = r107;
        this.f309924i = r110;
        this.f309925j = r111;
        this.f309926k = r112;
    }
}
