package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f230654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f230655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f230656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f230657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f230658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f230659f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f230654a, r101.f230654a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f230655b, r101.f230655b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f230656c, r101.f230656c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f230657d, r101.f230657d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f230658e, r101.f230658e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f230659f, r101.f230659f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f230654a.hashCode() * 31) + this.f230655b.hashCode()) * 31) + this.f230656c.hashCode()) * 31) + this.f230657d.hashCode()) * 31) + this.f230658e.hashCode()) * 31) + this.f230659f.hashCode();
    }

    public final String toString() {
        return "CommentUnifiedVoiceComponentSimpleProviderRequest(fragment=" + this.f230654a + ", psdaToken=" + this.f230655b + ", fileId=" + this.f230656c + ", fileType=" + this.f230657d + ", traceId=" + this.f230658e + ", callbacks=" + this.f230659f + ')';
    }

    public p(Fragment r100, String r101, String r102, String r103, String r104, m r105) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "psdaToken");
        Intrinsics.checkNotNullParameter(r102, "fileId");
        Intrinsics.checkNotNullParameter(r103, "fileType");
        Intrinsics.checkNotNullParameter(r104, "traceId");
        Intrinsics.checkNotNullParameter(r105, "callbacks");
        this.f230654a = r100;
        this.f230655b = r101;
        this.f230656c = r102;
        this.f230657d = r103;
        this.f230658e = r104;
        this.f230659f = r105;
    }
}
