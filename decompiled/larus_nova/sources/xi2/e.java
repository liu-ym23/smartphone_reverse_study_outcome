package xi2;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lxi2/e;", "", "", "Lxi2/f;", "contents", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lxi2/m0;", GXTemplateKey.GAIAX_TRACK, "Lxi2/m0;", "c", "()Lxi2/m0;", "Lxi2/g;", GXTemplateKey.GAIAX_ANIMATION, "Lxi2/g;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lxi2/g;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName(GXTemplateKey.GAIAX_ANIMATION)
    private final g animation;

    @SerializedName("contents")
    private final List<f> contents;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    private final m0 track;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.contents, r101.contents) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.track, r101.track) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.animation, r101.animation) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<f> r100 = this.contents;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        m0 r104 = this.track;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        g r107 = this.animation;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
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
