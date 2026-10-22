package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<wc9.e> f345389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Message> f345390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f345391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f345392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f345393e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (Intrinsics.areEqual(this.f345389a, r101.f345389a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f345390b, r101.f345390b) == true) goto L15;
        return false;
    L15:
        if (this.f345391c == r101.f345391c) goto L18;
        return false;
    L18:
        if (this.f345392d == r101.f345392d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f345393e, r101.f345393e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f345389a.hashCode() * 31) + this.f345390b.hashCode()) * 31;
        if (this.f345391c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        long r103 = this.f345392d;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f345393e.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SideBarProjectConversationPage(conversations=" + this.f345389a + ", briefMessages=" + this.f345390b + ", hasMore=" + this.f345391c + ", nextCursor=" + this.f345392d + ", nextCursorId=" + this.f345393e + ')';
    }

    public t0(List<wc9.e> r100, Map<String, Message> r101, boolean r102, long r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "conversations");
        Intrinsics.checkNotNullParameter(r101, "briefMessages");
        Intrinsics.checkNotNullParameter(r104, "nextCursorId");
        this.f345389a = r100;
        this.f345390b = r101;
        this.f345391c = r102;
        this.f345392d = r103;
        this.f345393e = r104;
    }
}
