package com.obric.assistant.live.island;

import android.os.Bundle;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f390135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f390136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f390137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f390138d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f390135a, r101.f390135a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f390136b, r101.f390136b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f390137c, r101.f390137c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f390138d, r101.f390138d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f390135a.hashCode() * 31;
        String r101 = this.f390136b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f390137c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Bundle r108 = this.f390138d;
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
        return "OpenChatParams(taskId=" + this.f390135a + ", originQuery=" + this.f390136b + ", targetMessageId=" + this.f390137c + ", lockScreenAuthReportParams=" + this.f390138d + ')';
    }

    public r(String r100, String r101, String r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.f390135a = r100;
        this.f390136b = r101;
        this.f390137c = r102;
        this.f390138d = r103;
    }
}
