package ix8;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.camera.api.vlm.VLMFileDataType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f496384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VLMFileDataType f496385b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f496384a, r101.f496384a) == true) goto L12;
        return false;
    L12:
        if (this.f496385b == r101.f496385b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f496384a.hashCode() * 31) + this.f496385b.hashCode();
    }

    public final String toString() {
        return "VLMIntentDetectFile(bitmap=" + this.f496384a + ", type=" + this.f496385b + ')';
    }

    public final VLMFileDataType getType() {
        return this.f496385b;
    }

    public b(Bitmap r100, VLMFileDataType r101) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f496384a = r100;
        this.f496385b = r101;
    }
}
