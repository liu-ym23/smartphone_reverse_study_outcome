package ff9;

import com.ss.bytertc.engine.data.AudioRenderType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioRenderType f476683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f476684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f476685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final he9.a f476686d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f476683a == r101.f476683a) goto L12;
        return false;
    L12:
        if (this.f476684b == r101.f476684b) goto L15;
        return false;
    L15:
        if (this.f476685c == r101.f476685c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f476686d, r101.f476686d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f476683a.hashCode() * 31) + this.f476684b) * 31) + this.f476685c) * 31;
        he9.a r101 = this.f476686d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AudioPlayConfig(renderType=" + this.f476683a + ", sampleRate=" + this.f476684b + ", channel=" + this.f476685c + ", transformer=" + this.f476686d + ')';
    }

    public c(AudioRenderType r100, int r101, int r102, he9.a r103) {
        Intrinsics.checkNotNullParameter(r100, "renderType");
        this.f476683a = r100;
        this.f476684b = r101;
        this.f476685c = r102;
        this.f476686d = r103;
    }
}
