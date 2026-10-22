package com.ss.android.lark.inline.ai.logic;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import slb.m;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements com.larksuite.arch.jack.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InlineAIStatus f427288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f427289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<m> f427290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<h> f427291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f427292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f427293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f427294g;

    public f() {
        this(null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f427288a == r101.f427288a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f427289b, r101.f427289b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f427290c, r101.f427290c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f427291d, r101.f427291d) == true) goto L21;
        return false;
    L21:
        if (this.f427292e == r101.f427292e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f427293f, r101.f427293f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f427294g, r101.f427294g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f427288a.hashCode() * 31) + this.f427289b.hashCode()) * 31) + this.f427290c.hashCode()) * 31) + this.f427291d.hashCode()) * 31) + this.f427292e) * 31) + this.f427293f.hashCode()) * 31;
        Boolean r101 = this.f427294g;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "InlineAIState(status=" + this.f427288a + ", conversationId=" + this.f427289b + ", promptGroups=" + this.f427290c + ", taskHistory=" + this.f427291d + ", currentTaskIndex=" + this.f427292e + ", userInputText=" + this.f427293f + ", showKeyboard=" + this.f427294g + ')';
    }

    public /* synthetic */ f(InlineAIStatus r100, int r110) {
        if ((r110 & 1) == 0) goto L5;
        r100 = InlineAIStatus.Init;
    L5:
        InlineAIStatus r101 = r100;
        if ((r110 & 2) == 0) goto L8;
        String r102 = "";
    L10:
        if ((r110 & 4) == 0) goto L12;
        List r103 = CollectionsKt.emptyList();
    L14:
        if ((r110 & 8) == 0) goto L16;
        ArrayList r104 = new ArrayList();
    L18:
        if ((r110 & 16) == 0) goto L20;
        int r105 = -1;
    L22:
        if ((r110 & 32) == 0) goto L24;
        j.a r106 = new j.a("");
    L25:
        this(r101, r102, r103, r104, r105, r106, null);
        return;
    L24:
        r106 = null;
        goto L25
    L20:
        r105 = 0;
        goto L22
    L16:
        r104 = null;
        goto L18
    L12:
        r103 = null;
        goto L14
    L8:
        r102 = null;
        goto L10
    }

    public f(InlineAIStatus r100, String r101, List<m> r102, List<h> r103, int r104, j r105, Boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "promptGroups");
        Intrinsics.checkNotNullParameter(r103, "taskHistory");
        Intrinsics.checkNotNullParameter(r105, "userInputText");
        this.f427288a = r100;
        this.f427289b = r101;
        this.f427290c = r102;
        this.f427291d = r103;
        this.f427292e = r104;
        this.f427293f = r105;
        this.f427294g = r106;
    }

    public static f a(f r100, InlineAIStatus r101, List r110, List r111, int r112, j r113, Boolean r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        r101 = r100.f427288a;
    L5:
        InlineAIStatus r102 = r101;
        if ((r115 & 2) == 0) goto L8;
        String r103 = r100.f427289b;
    L9:
        String r104 = r103;
        if ((r115 & 4) == 0) goto L12;
        r110 = r100.f427290c;
    L12:
        List r105 = r110;
        if ((r115 & 8) == 0) goto L15;
        r111 = r100.f427291d;
    L15:
        List r106 = r111;
        if ((r115 & 16) == 0) goto L18;
        r112 = r100.f427292e;
    L18:
        int r107 = r112;
        if ((r115 & 32) == 0) goto L21;
        r113 = r100.f427293f;
    L21:
        j r108 = r113;
        if ((r115 & 64) == 0) goto L24;
        r114 = r100.f427294g;
    L24:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "status");
        Intrinsics.checkNotNullParameter(r104, "conversationId");
        Intrinsics.checkNotNullParameter(r105, "promptGroups");
        Intrinsics.checkNotNullParameter(r106, "taskHistory");
        Intrinsics.checkNotNullParameter(r108, "userInputText");
        return new f(r102, r104, r105, r106, r107, r108, r114);
    L8:
        r103 = null;
        goto L9
    }
}
