package com.ss.android.lark.compose.chatterselector;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f417534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f417535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f417536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f417537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<d> f417538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.ss.android.lark.compose.chat_member_list.a f417539f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f417534a, r101.f417534a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f417535b, r101.f417535b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f417536c, r101.f417536c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f417537d, r101.f417537d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f417538e, r101.f417538e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f417539f, r101.f417539f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f417534a.hashCode() * 31) + this.f417535b.hashCode()) * 31) + this.f417536c.hashCode()) * 31) + this.f417537d.hashCode()) * 31) + this.f417538e.hashCode()) * 31) + this.f417539f.hashCode();
    }

    public final String toString() {
        return "ChatterSelectorChatter(id=" + this.f417534a + ", name=" + this.f417535b + ", nickname=" + this.f417536c + ", avatarKey=" + this.f417537d + ", udTagParams=" + this.f417538e + ", statusTag=" + this.f417539f + ')';
    }

    public static a a(a r100, List r101) {
        String r102 = r100.f417534a;
        String r103 = r100.f417535b;
        String r104 = r100.f417536c;
        String r105 = r100.f417537d;
        com.ss.android.lark.compose.chat_member_list.a r106 = r100.f417539f;
        Intrinsics.checkNotNullParameter(r102, "id");
        Intrinsics.checkNotNullParameter(r103, "name");
        Intrinsics.checkNotNullParameter(r104, InstantPlayContext.NICKNAME);
        Intrinsics.checkNotNullParameter(r105, "avatarKey");
        Intrinsics.checkNotNullParameter(r101, "udTagParams");
        Intrinsics.checkNotNullParameter(r106, "statusTag");
        return new a(r102, r103, r104, r105, r101, r106);
    }

    public a(String r100, String r101, String r102, String r103, List<d> r104, com.ss.android.lark.compose.chat_member_list.a r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, InstantPlayContext.NICKNAME);
        Intrinsics.checkNotNullParameter(r103, "avatarKey");
        Intrinsics.checkNotNullParameter(r104, "udTagParams");
        Intrinsics.checkNotNullParameter(r105, "statusTag");
        this.f417534a = r100;
        this.f417535b = r101;
        this.f417536c = r102;
        this.f417537d = r103;
        this.f417538e = r104;
        this.f417539f = r105;
    }
}
