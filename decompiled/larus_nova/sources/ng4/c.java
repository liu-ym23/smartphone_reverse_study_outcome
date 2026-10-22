package ng4;

import com.bytedance.component.lyric_v2.util.LyricType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f519062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f519063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f519064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f519065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public pg4.d f519066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f519067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LyricType f519068g;

    public final String toString() {
        return "DrawNode(index=" + this.f519064c + ", playTs=" + this.f519065d + ", lineInfo=" + this.f519066e + ", lineProgress=" + this.f519067f + ", lyricType=" + this.f519068g + ", lineWidth=" + this.f519062a + ", dynamicWidth=" + this.f519063b + ')';
    }

    public c(pg4.d r100, LyricType r101) {
        Intrinsics.checkNotNullParameter(r101, "lyricType");
        this.f519064c = 0;
        this.f519065d = 0;
        this.f519066e = r100;
        this.f519067f = 0.0f;
        this.f519068g = r101;
    }
}
