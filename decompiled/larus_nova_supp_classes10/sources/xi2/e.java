package xi2;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lxi2/e;", "", "", "Lxi2/f;", "contents", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lxi2/m0;", "track", "Lxi2/m0;", "c", "()Lxi2/m0;", "Lxi2/g;", "animation", "Lxi2/g;", "a", "()Lxi2/g;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("animation")
    private final g animation;

    @SerializedName("contents")
    private final List<f> contents;

    @SerializedName("track")
    private final m0 track;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L12;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.contents, r4.contents) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.track, r4.track) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.animation, r4.animation) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<f> r0 = this.contents;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        m0 r4 = this.track;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        g r7 = this.animation;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECBackgroundBannerComponent(contents=" + this.contents + ", track=" + this.track + ", animation=" + this.animation + ")";
    }

    public e() {
        this.contents = null;
        this.track = null;
        this.animation = null;
    }

    public final g a() {
        return this.animation;
    }

    public final List<f> b() {
        return this.contents;
    }

    public final m0 c() {
        return this.track;
    }
}
