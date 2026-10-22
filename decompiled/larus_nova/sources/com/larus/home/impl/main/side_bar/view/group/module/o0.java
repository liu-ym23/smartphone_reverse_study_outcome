package com.larus.home.impl.main.side_bar.view.group.module;

import androidx.core.app.NotificationCompat;
import com.larus.platform.model.SlashMentionConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class o0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f345515h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.render.z f345516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.render.z f345517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.render.z f345518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.render.z f345519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.render.z f345520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.render.z f345521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.render.z f345522g;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.f345516a, r101.f345516a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f345517b, r101.f345517b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f345518c, r101.f345518c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f345519d, r101.f345519d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f345520e, r101.f345520e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f345521f, r101.f345521f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f345522g, r101.f345522g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f345516a.hashCode() * 31) + this.f345517b.hashCode()) * 31) + this.f345518c.hashCode()) * 31) + this.f345519d.hashCode()) * 31) + this.f345520e.hashCode()) * 31) + this.f345521f.hashCode()) * 31) + this.f345522g.hashCode();
    }

    public final String toString() {
        return "GroupPagingConfigs(pin=" + this.f345516a + ", social=" + this.f345517b + ", project=" + this.f345518c + ", projectConversation=" + this.f345519d + ", deviceConversation=" + this.f345520e + ", chat=" + this.f345521f + ", archived=" + this.f345522g + ')';
    }

    public o0(com.larus.home.impl.main.side_bar.view.group.render.z r100, com.larus.home.impl.main.side_bar.view.group.render.z r101, com.larus.home.impl.main.side_bar.view.group.render.z r102, com.larus.home.impl.main.side_bar.view.group.render.z r103, com.larus.home.impl.main.side_bar.view.group.render.z r104, com.larus.home.impl.main.side_bar.view.group.render.z r105, com.larus.home.impl.main.side_bar.view.group.render.z r106) {
        Intrinsics.checkNotNullParameter(r100, "pin");
        Intrinsics.checkNotNullParameter(r101, NotificationCompat.CATEGORY_SOCIAL);
        Intrinsics.checkNotNullParameter(r102, SlashMentionConfig.SLASH_CONTENT_PROJECT);
        Intrinsics.checkNotNullParameter(r103, "projectConversation");
        Intrinsics.checkNotNullParameter(r104, "deviceConversation");
        Intrinsics.checkNotNullParameter(r105, "chat");
        Intrinsics.checkNotNullParameter(r106, "archived");
        this.f345516a = r100;
        this.f345517b = r101;
        this.f345518c = r102;
        this.f345519d = r103;
        this.f345520e = r104;
        this.f345521f = r105;
        this.f345522g = r106;
    }
}
