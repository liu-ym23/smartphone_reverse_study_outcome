package com.ss.android.lark.inline.ai.logic;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import slb.l;

/* JADX INFO: loaded from: classes36.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f427295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f427296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FeedBackChoice f427297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f427298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f427299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final slb.j f427300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f427301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<? extends slb.h> f427302h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f427303i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f427304j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f427305k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashMap<String, Object> f427306l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f427295a, r101.f427295a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f427296b, r101.f427296b) == true) goto L15;
        return false;
    L15:
        if (this.f427297c == r101.f427297c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f427298d, r101.f427298d) == true) goto L21;
        return false;
    L21:
        if (this.f427299e == r101.f427299e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f427300f, r101.f427300f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f427301g, r101.f427301g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f427302h, r101.f427302h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f427303i, r101.f427303i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f427304j, r101.f427304j) == true) goto L39;
        return false;
    L39:
        if (this.f427305k == r101.f427305k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f427306l, r101.f427306l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f427295a.hashCode() * 31;
        j r101 = this.f427296b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f427297c.hashCode()) * 31) + this.f427298d.hashCode()) * 31;
        if (this.f427299e == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((r104 + r105) * 31) + this.f427300f.hashCode()) * 31;
        l r107 = this.f427301g;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<? extends slb.h> r110 = this.f427302h;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((((((r109 + r111) * 31) + this.f427303i.hashCode()) * 31) + this.f427304j.hashCode()) * 31) + this.f427305k) * 31;
        HashMap<String, Object> r113 = this.f427306l;
        if (r113 == null) goto L23;
        r102 = r113.hashCode();
    L23:
        return r112 + r102;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InlineAITask(taskID='" + this.f427295a + "', userInputText=" + this.f427296b + ", feedBackChoice=" + this.f427297c + ", fullContent.length='" + this.f427298d.length() + "', prompt=" + this.f427300f + ", promptConfirmOptions=" + this.f427301g + ", operateButtons=" + this.f427302h + ", taskStatus='" + this.f427303i + "', aiMessageId='" + this.f427304j + "', finishType='" + this.f427305k + "')";
    }

    public static h a(h r110) {
        String r100 = r110.f427295a;
        j r101 = r110.f427296b;
        FeedBackChoice r102 = r110.f427297c;
        String r103 = r110.f427298d;
        boolean r104 = r110.f427299e;
        slb.j r105 = r110.f427300f;
        l r106 = r110.f427301g;
        List<? extends slb.h> r107 = r110.f427302h;
        String r108 = r110.f427303i;
        String r111 = r110.f427304j;
        int r112 = r110.f427305k;
        HashMap<String, Object> r113 = r110.f427306l;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276354d);
        Intrinsics.checkNotNullParameter(r102, "feedBackChoice");
        Intrinsics.checkNotNullParameter(r103, "fullContent");
        Intrinsics.checkNotNullParameter(r105, EventConstant.Key.RETAIN_PROMPT);
        Intrinsics.checkNotNullParameter(r108, "taskStatus");
        Intrinsics.checkNotNullParameter(r111, "aiMessageId");
        return new h(r100, r101, r102, r103, r104, r105, r106, r107, r108, r111, r112, r113);
    }

    public /* synthetic */ h(String r110, j r111, FeedBackChoice r112, boolean r113, slb.j r114, l r115) {
        this(r110, r111, r112, "", r113, r114, r115, null, "", "", 0, null);
    }

    public h(String r100, j r101, FeedBackChoice r102, String r103, boolean r104, slb.j r105, l r106, List<? extends slb.h> r107, String r110, String r111, int r112, HashMap<String, Object> r113) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276354d);
        Intrinsics.checkNotNullParameter(r102, "feedBackChoice");
        Intrinsics.checkNotNullParameter(r103, "fullContent");
        Intrinsics.checkNotNullParameter(r105, EventConstant.Key.RETAIN_PROMPT);
        Intrinsics.checkNotNullParameter(r110, "taskStatus");
        Intrinsics.checkNotNullParameter(r111, "aiMessageId");
        this.f427295a = r100;
        this.f427296b = r101;
        this.f427297c = r102;
        this.f427298d = r103;
        this.f427299e = r104;
        this.f427300f = r105;
        this.f427301g = r106;
        this.f427302h = r107;
        this.f427303i = r110;
        this.f427304j = r111;
        this.f427305k = r112;
        this.f427306l = r113;
    }
}
