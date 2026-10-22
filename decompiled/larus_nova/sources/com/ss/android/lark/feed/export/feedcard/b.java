package com.ss.android.lark.feed.export.feedcard;

import com.larksuite.component.ui.avatar.AvatarModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AvatarModel f421015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f421016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f421017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f421018d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f421015a, r101.f421015a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f421016b, r101.f421016b) == true) goto L15;
        return false;
    L15:
        if (this.f421017c == r101.f421017c) goto L18;
        return false;
    L18:
        if (this.f421018d == r101.f421018d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f421015a.hashCode() * 31;
        String r101 = this.f421016b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f421017c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f421018d == true) goto L15;
        r104 = 1237;
    L15:
        return r106 + r104;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FeedAvatar(avatarModel=" + this.f421015a + ", medalKey=" + this.f421016b + ", isUrgent=" + this.f421017c + ", isShowBadge=" + this.f421018d + ')';
    }

    public /* synthetic */ b(AvatarModel r100, boolean r101, int r102) {
        boolean r103 = false;
        if ((r102 & 4) == 0) goto L6;
        r101 = false;
    L6:
        if ((r102 & 8) == 0) goto L8;
        r103 = true;
    L8:
        this(r100, null, r101, r103);
    }

    public b(AvatarModel r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "avatarModel");
        this.f421015a = r100;
        this.f421016b = r101;
        this.f421017c = r102;
        this.f421018d = r103;
    }
}
