package hda;

import com.obric.assistant.cocreationreview.modules.memory.MemoryReviewAudioTranscriptCode;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MemoryReviewAudioTranscriptCode f484626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f484628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f484629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f484630e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f484626a == r101.f484626a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f484627b, r101.f484627b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f484628c, r101.f484628c) == true) goto L18;
        return false;
    L18:
        if (this.f484629d == r101.f484629d) goto L21;
        return false;
    L21:
        if (this.f484630e == r101.f484630e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f484626a.hashCode() * 31) + this.f484627b.hashCode()) * 31;
        String r101 = this.f484628c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f484629d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        long r106 = this.f484630e;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewAudioTranscriptChunkDto(code=" + this.f484626a + ", chunk=" + this.f484627b + ", nextCursor=" + this.f484628c + ", hasMore=" + this.f484629d + ", totalBytes=" + this.f484630e + ')';
    }

    public /* synthetic */ a(MemoryReviewAudioTranscriptCode r100) {
        this(r100, "", null, false, 0);
    }

    public a(MemoryReviewAudioTranscriptCode r100, String r101, String r102, boolean r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, MonitorConstants.CHUNK);
        this.f484626a = r100;
        this.f484627b = r101;
        this.f484628c = r102;
        this.f484629d = r103;
        this.f484630e = r104;
    }
}
