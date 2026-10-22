package com.larus.bmhome.clarification;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.im.bean.message.block.InteractionAskBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f310514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f310515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f310516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f310517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InteractionAskBlock f310518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f310519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ClarificationSubmissionStatus f310520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f310521h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f2) == true) goto L8;
        return false;
    L8:
        f2 r101 = (f2) r100;
        if (Intrinsics.areEqual(this.f310514a, r101.f310514a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f310515b, r101.f310515b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f310516c, r101.f310516c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f310517d, r101.f310517d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f310518e, r101.f310518e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f310519f, r101.f310519f) == true) goto L27;
        return false;
    L27:
        if (this.f310520g == r101.f310520g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f310521h, r101.f310521h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f310514a.hashCode() * 31) + this.f310515b.hashCode()) * 31) + this.f310516c.hashCode()) * 31;
        String r101 = this.f310517d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((((r100 + r103) * 31) + this.f310518e.hashCode()) * 31) + this.f310519f.hashCode()) * 31) + this.f310520g.hashCode()) * 31;
        String r105 = this.f310521h;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ClarificationSubmission(conversationId=" + this.f310514a + ", messageId=" + this.f310515b + ", blockId=" + this.f310516c + ", clarifyId=" + this.f310517d + ", interactionAskBlock=" + this.f310518e + ", interactionAskBlockJson=" + this.f310519f + ", status=" + this.f310520g + ", reason=" + this.f310521h + ')';
    }

    public f2(String r100, String r101, String r102, String r103, InteractionAskBlock r104, String r105, ClarificationSubmissionStatus r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.BLOCK_ID);
        Intrinsics.checkNotNullParameter(r104, "interactionAskBlock");
        Intrinsics.checkNotNullParameter(r105, "interactionAskBlockJson");
        Intrinsics.checkNotNullParameter(r106, "status");
        this.f310514a = r100;
        this.f310515b = r101;
        this.f310516c = r102;
        this.f310517d = r103;
        this.f310518e = r104;
        this.f310519f = r105;
        this.f310520g = r106;
        this.f310521h = r107;
    }
}
