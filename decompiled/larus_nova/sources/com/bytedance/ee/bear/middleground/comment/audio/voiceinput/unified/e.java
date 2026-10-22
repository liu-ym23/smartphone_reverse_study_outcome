package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.voiceinput.api.data.config.asr.resultConfig.VoiceAsrMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f230633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f230634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f230635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f230636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f230637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final VoiceAsrMode f230638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final dbc.c f230639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f230640h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f230633a, r101.f230633a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f230634b, r101.f230634b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f230635c, r101.f230635c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f230636d, r101.f230636d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f230637e, r101.f230637e) == true) goto L24;
        return false;
    L24:
        if (this.f230638f == r101.f230638f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f230639g, r101.f230639g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f230640h, r101.f230640h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f230633a.hashCode() * 31) + this.f230634b.hashCode()) * 31) + this.f230635c.hashCode()) * 31) + this.f230636d.hashCode()) * 31) + this.f230637e.hashCode()) * 31) + this.f230638f.hashCode()) * 31) + this.f230639g.hashCode()) * 31) + this.f230640h.hashCode();
    }

    public final String toString() {
        return "CommentUnifiedVoiceComponentAdvancedProviderRequest(fragment=" + this.f230633a + ", psdaToken=" + this.f230634b + ", fileId=" + this.f230635c + ", fileType=" + this.f230636d + ", traceId=" + this.f230637e + ", asrMode=" + this.f230638f + ", voiceView=" + this.f230639g + ", callbacks=" + this.f230640h + ')';
    }

    public e(Fragment r100, String r101, String r102, String r103, String r104, VoiceAsrMode r105, ebc.b r106, b r107) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "psdaToken");
        Intrinsics.checkNotNullParameter(r102, "fileId");
        Intrinsics.checkNotNullParameter(r103, "fileType");
        Intrinsics.checkNotNullParameter(r104, "traceId");
        Intrinsics.checkNotNullParameter(r105, "asrMode");
        Intrinsics.checkNotNullParameter(r106, "voiceView");
        Intrinsics.checkNotNullParameter(r107, "callbacks");
        this.f230633a = r100;
        this.f230634b = r101;
        this.f230635c = r102;
        this.f230636d = r103;
        this.f230637e = r104;
        this.f230638f = r105;
        this.f230639g = r106;
        this.f230640h = r107;
    }
}
