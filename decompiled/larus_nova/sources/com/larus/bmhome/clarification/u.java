package com.larus.bmhome.clarification;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.message.block.InteractionAskOption;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class u implements jc8.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f310605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f310606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f310607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f310608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f310609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<ResourceItemBean> f310610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f310611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f310612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function2<Integer, InteractionAskOption, Unit> f310613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BaseResourceViewHolder.a f310614j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.f310605a == r101.f310605a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f310606b, r101.f310606b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f310607c, r101.f310607c) == true) goto L18;
        return false;
    L18:
        if (this.f310608d == r101.f310608d) goto L21;
        return false;
    L21:
        if (this.f310609e == r101.f310609e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f310610f, r101.f310610f) == true) goto L27;
        return false;
    L27:
        if (this.f310611g == r101.f310611g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f310612h, r101.f310612h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f310613i, r101.f310613i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f310614j, r101.f310614j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f310605a * 31) + this.f310606b.hashCode()) * 31) + this.f310607c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f310608d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f310609e) * 31) + this.f310610f.hashCode()) * 31;
        if (this.f310611g == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (((((r103 + r101) * 31) + this.f310612h.hashCode()) * 31) + this.f310613i.hashCode()) * 31;
        BaseResourceViewHolder.a r105 = this.f310614j;
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
        return "ClarificationBlockPassData(pageIndex=" + this.f310605a + ", selectedOptionIds=" + this.f310606b + ", inputText=" + this.f310607c + ", hasAttachment=" + this.f310608d + ", attachmentCount=" + this.f310609e + ", attachmentItems=" + this.f310610f + ", showCloseButton=" + this.f310611g + ", onCloseClick=" + this.f310612h + ", onOptionClick=" + this.f310613i + ", attachmentCallback=" + this.f310614j + ')';
    }

    public u(int r100, List r101, String r102, boolean r103, int r104, List r105, Function0 r106, Function2 r107, BaseResourceViewHolder.a r110) {
        Intrinsics.checkNotNullParameter(r101, "selectedOptionIds");
        Intrinsics.checkNotNullParameter(r102, "inputText");
        Intrinsics.checkNotNullParameter(r105, "attachmentItems");
        Intrinsics.checkNotNullParameter(r106, "onCloseClick");
        Intrinsics.checkNotNullParameter(r107, "onOptionClick");
        this.f310605a = r100;
        this.f310606b = r101;
        this.f310607c = r102;
        this.f310608d = r103;
        this.f310609e = r104;
        this.f310610f = r105;
        this.f310611g = true;
        this.f310612h = r106;
        this.f310613i = r107;
        this.f310614j = r110;
    }
}
