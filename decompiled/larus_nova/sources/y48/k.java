package y48;

import android.graphics.Rect;
import com.larus.asr.config.builder.ChatSpeakerElementKey;
import com.larus.asr.config.builder.ChatSpeakerGesturePhase;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatSpeakerElementKey f566120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChatSpeakerGesturePhase f566121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f566122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Pair<Float, Float> f566123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Pair<Float, Float> f566124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f566125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f566126g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f566120a == r101.f566120a) goto L12;
        return false;
    L12:
        if (this.f566121b == r101.f566121b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566122c, r101.f566122c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f566123d, r101.f566123d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f566124e, r101.f566124e) == true) goto L24;
        return false;
    L24:
        if (this.f566125f == r101.f566125f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f566126g, r101.f566126g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f566120a.hashCode() * 31) + this.f566121b.hashCode()) * 31) + this.f566122c.hashCode()) * 31) + this.f566123d.hashCode()) * 31) + this.f566124e.hashCode()) * 31;
        if (this.f566125f == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        Rect r103 = this.f566126g;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatSpeakerElementGestureContext(elementKey=" + this.f566120a + ", phase=" + this.f566121b + ", uiState=" + this.f566122c + ", globalTouchPosition=" + this.f566123d + ", deltaPosition=" + this.f566124e + ", isVoiceGranted=" + this.f566125f + ", elementBounds=" + this.f566126g + ')';
    }

    public k(ChatSpeakerElementKey r100, ChatSpeakerGesturePhase r101, y r102, Pair<Float, Float> r103, Pair<Float, Float> r104, boolean r105, Rect r106) {
        Intrinsics.checkNotNullParameter(r100, "elementKey");
        Intrinsics.checkNotNullParameter(r101, "phase");
        Intrinsics.checkNotNullParameter(r102, "uiState");
        Intrinsics.checkNotNullParameter(r103, "globalTouchPosition");
        Intrinsics.checkNotNullParameter(r104, "deltaPosition");
        this.f566120a = r100;
        this.f566121b = r101;
        this.f566122c = r102;
        this.f566123d = r103;
        this.f566124e = r104;
        this.f566125f = r105;
        this.f566126g = r106;
    }
}
