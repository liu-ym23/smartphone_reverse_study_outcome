package com.obric.assistant.live.island;

import android.os.Bundle;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f390092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f390093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f390094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f390095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f390096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f390097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f390098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f390099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Bundle f390100i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f390092a, r101.f390092a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f390093b, r101.f390093b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f390094c, r101.f390094c) == true) goto L18;
        return false;
    L18:
        if (this.f390095d == r101.f390095d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f390096e, r101.f390096e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f390097f, r101.f390097f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f390098g, r101.f390098g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f390099h, r101.f390099h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f390100i, r101.f390100i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f390092a.hashCode() * 31;
        String r101 = this.f390093b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f390094c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f390095d == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (((((((((r107 + r108) * 31) + this.f390096e.hashCode()) * 31) + this.f390097f.hashCode()) * 31) + this.f390098g.hashCode()) * 31) + this.f390099h.hashCode()) * 31;
        Bundle r110 = this.f390100i;
        if (r110 == null) goto L19;
        r102 = r110.hashCode();
    L19:
        return r109 + r102;
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CompletedCardInfo(taskId=" + this.f390092a + ", originQuery=" + this.f390093b + ", replyMessageId=" + this.f390094c + ", completeSuccess=" + this.f390095d + ", titleText=" + this.f390096e + ", contentText=" + this.f390097f + ", notificationContentText=" + this.f390098g + ", sceneContentText=" + this.f390099h + ", lockScreenAuthReportParams=" + this.f390100i + ')';
    }

    public a(String r100, String r101, String r102, boolean r103, String r104, String r105, String r106, String r107, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r104, "titleText");
        Intrinsics.checkNotNullParameter(r105, RXScreenCaptureService.KEY_CONTENT_TEXT);
        Intrinsics.checkNotNullParameter(r106, "notificationContentText");
        Intrinsics.checkNotNullParameter(r107, "sceneContentText");
        this.f390092a = r100;
        this.f390093b = r101;
        this.f390094c = r102;
        this.f390095d = r103;
        this.f390096e = r104;
        this.f390097f = r105;
        this.f390098g = r106;
        this.f390099h = r107;
        this.f390100i = r110;
    }
}
