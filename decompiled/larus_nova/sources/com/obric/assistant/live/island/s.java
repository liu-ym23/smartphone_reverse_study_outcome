package com.obric.assistant.live.island;

import android.os.Bundle;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f390139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f390140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f390141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f390142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f390143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f390144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f390145g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f390139a, r101.f390139a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f390140b, r101.f390140b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f390141c, r101.f390141c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f390142d, r101.f390142d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f390143e, r101.f390143e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f390144f, r101.f390144f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f390145g, r101.f390145g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f390139a.hashCode() * 31;
        String r101 = this.f390140b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f390141c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((((r104 + r106) * 31) + this.f390142d.hashCode()) * 31) + this.f390143e.hashCode()) * 31) + this.f390144f.hashCode()) * 31;
        Bundle r108 = this.f390145g;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "QueueingCardInfo(taskId=" + this.f390139a + ", originQuery=" + this.f390140b + ", replyMessageId=" + this.f390141c + ", titleText=" + this.f390142d + ", contentText=" + this.f390143e + ", sceneContentText=" + this.f390144f + ", lockScreenAuthReportParams=" + this.f390145g + ')';
    }

    public s(String r100, String r101, String r102, String r103, String r104, String r105, Bundle r106) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r103, "titleText");
        Intrinsics.checkNotNullParameter(r104, RXScreenCaptureService.KEY_CONTENT_TEXT);
        Intrinsics.checkNotNullParameter(r105, "sceneContentText");
        this.f390139a = r100;
        this.f390140b = r101;
        this.f390141c = r102;
        this.f390142d = r103;
        this.f390143e = r104;
        this.f390144f = r105;
        this.f390145g = r106;
    }
}
