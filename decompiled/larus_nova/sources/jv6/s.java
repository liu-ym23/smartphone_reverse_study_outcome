package jv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Ljv6/s;", "", "", "maxWidth", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "maxHeight", "d", "animationTranslateDistance", "b", "animationTranslateDuration", "c", "animationAlphaDuration", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("animation_alpha_duration")
    private final Integer animationAlphaDuration;

    @SerializedName("animation_translate_distance")
    private final Integer animationTranslateDistance;

    @SerializedName("animation_translate_duration")
    private final Integer animationTranslateDuration;

    @SerializedName("height")
    private final Integer maxHeight;

    @SerializedName("width")
    private final Integer maxWidth;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.maxWidth, r101.maxWidth) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxHeight, r101.maxHeight) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.animationTranslateDistance, r101.animationTranslateDistance) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.animationTranslateDuration, r101.animationTranslateDuration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.animationAlphaDuration, r101.animationAlphaDuration) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.maxWidth;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.maxHeight;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.animationTranslateDistance;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.animationTranslateDuration;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.animationAlphaDuration;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "StickerContainerSettings(maxWidth=" + this.maxWidth + ", maxHeight=" + this.maxHeight + ", animationTranslateDistance=" + this.animationTranslateDistance + ", animationTranslateDuration=" + this.animationTranslateDuration + ", animationAlphaDuration=" + this.animationAlphaDuration + ')';
    }

    public s() {
        this.maxWidth = null;
        this.maxHeight = null;
        this.animationTranslateDistance = null;
        this.animationTranslateDuration = null;
        this.animationAlphaDuration = null;
    }

    public final Integer a() {
        return this.animationAlphaDuration;
    }

    public final Integer b() {
        return this.animationTranslateDistance;
    }

    public final Integer c() {
        return this.animationTranslateDuration;
    }

    public final Integer d() {
        return this.maxHeight;
    }

    public final Integer e() {
        return this.maxWidth;
    }
}
