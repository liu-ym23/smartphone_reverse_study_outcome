package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<wc9.e> f345359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Message> f345360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f345361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wc9.f f345362d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.f345359a, r101.f345359a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f345360b, r101.f345360b) == true) goto L15;
        return false;
    L15:
        if (this.f345361c == r101.f345361c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f345362d, r101.f345362d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f345359a.hashCode() * 31) + this.f345360b.hashCode()) * 31;
        if (this.f345361c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        wc9.f r103 = this.f345362d;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SideBarConversationPage(conversations=" + this.f345359a + ", briefMessages=" + this.f345360b + ", hasMore=" + this.f345361c + ", nextAnchor=" + this.f345362d + ')';
    }

    public static l0 a(l0 r100, List r101) {
        Map<String, Message> r102 = r100.f345360b;
        boolean r103 = r100.f345361c;
        wc9.f r104 = r100.f345362d;
        Intrinsics.checkNotNullParameter(r101, "conversations");
        Intrinsics.checkNotNullParameter(r102, "briefMessages");
        return new l0(r101, r102, r103, r104);
    }

    public l0(List<wc9.e> r100, Map<String, Message> r101, boolean r102, wc9.f r103) {
        Intrinsics.checkNotNullParameter(r100, "conversations");
        Intrinsics.checkNotNullParameter(r101, "briefMessages");
        this.f345359a = r100;
        this.f345360b = r101;
        this.f345361c = r102;
        this.f345362d = r103;
    }

    public /* synthetic */ l0(List r100, Map r101, boolean r102, wc9.f r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = MapsKt.emptyMap();
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
