package com.ss.android.lark.compose.chatsetting.main.viewmodel;

import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.pb.basic.v1.Chatter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Chatter> f417469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Chat.Type f417470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f417471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f417472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f417473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f417474f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f417469a, r101.f417469a) == true) goto L12;
        return false;
    L12:
        if (this.f417470b == r101.f417470b) goto L15;
        return false;
    L15:
        if (this.f417471c == r101.f417471c) goto L18;
        return false;
    L18:
        if (this.f417472d == r101.f417472d) goto L21;
        return false;
    L21:
        if (this.f417473e == r101.f417473e) goto L24;
        return false;
    L24:
        if (this.f417474f == r101.f417474f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f417469a.hashCode() * 31) + this.f417470b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f417471c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f417472d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f417473e) * 31;
        if (this.f417474f == true) goto L15;
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
        return "GroupMembersState(chatters=" + this.f417469a + ", chatType=" + this.f417470b + ", isOwner=" + this.f417471c + ", isAdmin=" + this.f417472d + ", userCount=" + this.f417473e + ", isUserCountVisible=" + this.f417474f + ')';
    }

    public c(List<Chatter> r100, Chat.Type r101, boolean r102, boolean r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "chatters");
        Intrinsics.checkNotNullParameter(r101, "chatType");
        this.f417469a = r100;
        this.f417470b = r101;
        this.f417471c = r102;
        this.f417472d = r103;
        this.f417473e = r104;
        this.f417474f = r105;
    }

    public static c a(c r100, List r101, Chat.Type r102, boolean r110, boolean r111, int r112, boolean r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r101 = r100.f417469a;
    L5:
        List r103 = r101;
        if ((r114 & 2) == 0) goto L8;
        r102 = r100.f417470b;
    L8:
        Chat.Type r104 = r102;
        if ((r114 & 4) == 0) goto L11;
        r110 = r100.f417471c;
    L11:
        boolean r105 = r110;
        if ((r114 & 8) == 0) goto L14;
        r111 = r100.f417472d;
    L14:
        boolean r106 = r111;
        if ((r114 & 16) == 0) goto L17;
        r112 = r100.f417473e;
    L17:
        int r107 = r112;
        if ((r114 & 32) == 0) goto L20;
        r113 = r100.f417474f;
    L20:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "chatters");
        Intrinsics.checkNotNullParameter(r104, "chatType");
        return new c(r103, r104, r105, r106, r107, r113);
    }
}
