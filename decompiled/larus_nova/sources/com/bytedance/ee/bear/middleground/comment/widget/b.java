package com.bytedance.ee.bear.middleground.comment.widget;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f232318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f232319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BotAtHintActionType f232320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f232321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f232322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f232323f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f232318a == r101.f232318a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f232319b, r101.f232319b) == true) goto L15;
        return false;
    L15:
        if (this.f232320c == r101.f232320c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f232321d, r101.f232321d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f232322e, r101.f232322e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f232323f, r101.f232323f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f232318a;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f232319b.hashCode()) * 31) + this.f232320c.hashCode()) * 31;
        String r102 = this.f232321d;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f232322e;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        Long r109 = this.f232323f;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        return r108 + r103;
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotAtHintInfo(botId=" + this.f232318a + ", botName=" + this.f232319b + ", actionType=" + this.f232320c + ", actionUrl=" + this.f232321d + ", deviceCode=" + this.f232322e + ", deviceCodeExpireTime=" + this.f232323f + ')';
    }

    public b(long r100, String r101, BotAtHintActionType r102, String r103, String r104, Long r105) {
        Intrinsics.checkNotNullParameter(r101, "botName");
        Intrinsics.checkNotNullParameter(r102, ReportConstant.COMMON_ACTION_TYPE);
        this.f232318a = r100;
        this.f232319b = r101;
        this.f232320c = r102;
        this.f232321d = r103;
        this.f232322e = r104;
        this.f232323f = r105;
    }
}
