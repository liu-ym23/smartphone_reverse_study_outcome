package androidx.camera.video;

import android.util.Size;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_Quality_ConstantQuality extends Quality.ConstantQuality {
    private final String name;
    private final List<Size> typicalSizes;
    private final int value;

    public int hashCode() {
        return ((((this.value ^ 1000003) * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.typicalSizes.hashCode();
    }

    public String toString() {
        return "ConstantQuality{value=" + this.value + ", name=" + this.name + ", typicalSizes=" + this.typicalSizes + "}";
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    public String getName() {
        return this.name;
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    public List<Size> getTypicalSizes() {
        return this.typicalSizes;
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    public int getValue() {
        return this.value;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Quality.ConstantQuality) == false) goto L16;
        Quality.ConstantQuality r6 = (Quality.ConstantQuality) r5;
        if (this.value == r6.getValue()) goto L10;
    L14:
        return false;
    L10:
        if (this.name.equals(r6.getName()) == false) goto L14;
        if (this.typicalSizes.equals(r6.getTypicalSizes()) == false) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_Quality_ConstantQuality(int r1, String r2, List<Size> r3) {
        this.value = r1;
        if (r2 == null) goto L11;
        this.name = r2;
        if (r3 == null) goto L9;
        this.typicalSizes = r3;
        return;
    L9:
        throw new NullPointerException("Null typicalSizes");
    L11:
        throw new NullPointerException("Null name");
    }
}
