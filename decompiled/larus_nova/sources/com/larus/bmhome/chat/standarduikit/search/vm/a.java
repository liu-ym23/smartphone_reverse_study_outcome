package com.larus.bmhome.chat.standarduikit.search.vm;

import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.SearchVideoItem;
import java.util.List;
import kc8.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SearchVideoItem> f309759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExpandCardViewMode f309760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0 f309761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f309762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f309763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f309764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Message f309765g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f309759a, r101.f309759a) == true) goto L12;
        return false;
    L12:
        if (this.f309760b == r101.f309760b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309761c, r101.f309761c) == true) goto L18;
        return false;
    L18:
        if (this.f309762d == r101.f309762d) goto L21;
        return false;
    L21:
        if (this.f309763e == r101.f309763e) goto L24;
        return false;
    L24:
        if (this.f309764f == r101.f309764f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f309765g, r101.f309765g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f309759a.hashCode() * 31) + this.f309760b.hashCode()) * 31;
        j0 r101 = this.f309761c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f309762d == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f309763e) * 31;
        if (this.f309764f == true) goto L14;
        r105 = 1237;
    L14:
        int r108 = (r107 + r105) * 31;
        Message r109 = this.f309765g;
        if (r109 == null) goto L19;
        r102 = r109.hashCode();
    L19:
        return r108 + r102;
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PureVideoVMData(videoList=" + this.f309759a + ", videoCardMode=" + this.f309760b + ", columnGridDecorationConfig=" + this.f309761c + ", isOversea=" + this.f309762d + ", columnSize=" + this.f309763e + ", videoInfinite=" + this.f309764f + ", message=" + this.f309765g + ')';
    }

    public a(List r100, ExpandCardViewMode r101, j0 r102, boolean r103, boolean r104, Message r105) {
        Intrinsics.checkNotNullParameter(r100, "videoList");
        Intrinsics.checkNotNullParameter(r101, "videoCardMode");
        this.f309759a = r100;
        this.f309760b = r101;
        this.f309761c = r102;
        this.f309762d = r103;
        this.f309763e = 2;
        this.f309764f = r104;
        this.f309765g = r105;
    }
}
