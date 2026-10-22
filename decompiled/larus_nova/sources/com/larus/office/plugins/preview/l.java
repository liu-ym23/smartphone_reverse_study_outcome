package com.larus.office.plugins.preview;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wc9.e f363211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BotModel f363212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f363213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f363214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f363215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m0 f363216f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f363211a, r101.f363211a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f363212b, r101.f363212b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f363213c, r101.f363213c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f363214d, r101.f363214d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f363215e, r101.f363215e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f363216f, r101.f363216f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f363211a.hashCode() * 31;
        BotModel r101 = this.f363212b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f363213c.hashCode()) * 31;
        String r105 = this.f363214d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f363215e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        m0 r111 = this.f363216f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeDrivePreviewConversation(conversation=" + this.f363211a + ", botModel=" + this.f363212b + ", botId=" + this.f363213c + ", cacheResourceId=" + this.f363214d + ", sourceConversationId=" + this.f363215e + ", initialUnreadSnapshot=" + this.f363216f + ')';
    }

    public l(wc9.e r100, BotModel r101, String r102, String r103, String r104, m0 r105) {
        Intrinsics.checkNotNullParameter(r100, "conversation");
        Intrinsics.checkNotNullParameter(r102, "botId");
        this.f363211a = r100;
        this.f363212b = r101;
        this.f363213c = r102;
        this.f363214d = r103;
        this.f363215e = r104;
        this.f363216f = r105;
    }
}
