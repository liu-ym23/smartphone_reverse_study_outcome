package com.larus.extension.chat_extension.impl.ltm;

import com.larus.extension.chat_extension.impl.ltm.view.ChatLtmBaseHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f342870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f342871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ChatLtmStatus f342872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f342873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f342874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f342875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f342876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f342877h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f342870a, r101.f342870a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f342871b, r101.f342871b) == true) goto L15;
        return false;
    L15:
        if (this.f342872c == r101.f342872c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f342873d, r101.f342873d) == true) goto L21;
        return false;
    L21:
        if (this.f342874e == r101.f342874e) goto L24;
        return false;
    L24:
        if (this.f342875f == r101.f342875f) goto L27;
        return false;
    L27:
        if (this.f342876g == r101.f342876g) goto L30;
        return false;
    L30:
        if (this.f342877h == r101.f342877h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f342870a.hashCode() * 31) + this.f342871b.hashCode()) * 31) + this.f342872c.hashCode()) * 31) + this.f342873d.hashCode()) * 31) + this.f342874e) * 31;
        int r101 = 1231;
        if (this.f342875f == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f342876g == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f342877h == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatLtmItemData(id=" + this.f342870a + ", content=" + this.f342871b + ", status=" + this.f342872c + ", date=" + this.f342873d + ", viewType=" + this.f342874e + ", isLast=" + this.f342875f + ", isFirst=" + this.f342876g + ", needHighLight=" + this.f342877h + ')';
    }

    public r(String r100, String r101, ChatLtmStatus r102, String r103, int r104, boolean r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "status");
        Intrinsics.checkNotNullParameter(r103, "date");
        this.f342870a = r100;
        this.f342871b = r101;
        this.f342872c = r102;
        this.f342873d = r103;
        this.f342874e = r104;
        this.f342875f = r105;
        this.f342876g = r106;
        this.f342877h = r107;
    }

    public /* synthetic */ r(String r110, String r111, ChatLtmStatus r112, String r113, int r114, boolean r115, boolean r116, boolean r117, int r210) {
        if ((r210 & 8) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r210 & 16) == 0) goto L9;
        int r101 = ChatLtmBaseHolder.Companion.ChatItemViewType.NORMAL.getValue();
    L11:
        if ((r210 & 32) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r210 & 64) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r210 & 128) == 0) goto L21;
        boolean r118 = false;
    L22:
        this(r110, r111, r112, r100, r101, r102, r103, r118);
        return;
    L21:
        r118 = r117;
        goto L22
    L17:
        r103 = r116;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
