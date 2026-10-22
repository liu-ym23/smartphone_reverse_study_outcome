package esc;

import android.graphics.PathMeasure;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Path;
import io.github.alexzhirkevich.compottie.internal.platform.ExtendedPathMeasure;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements ExtendedPathMeasure {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PathMeasure f473824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f473825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f473826c;

    @Override // io.github.alexzhirkevich.compottie.internal.platform.ExtendedPathMeasure
    public final boolean a() {
        return this.f473824a.nextContour();
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public final float getLength() {
        return this.f473824a.getLength();
    }

    public a(PathMeasure r100) {
        Intrinsics.checkNotNullParameter(r100, "internalPathMeasure");
        this.f473824a = r100;
        this.f473825b = new float[2];
        this.f473826c = new float[2];
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    /* JADX INFO: renamed from: getPosition-tuRUvjQ */
    public final long mo4723getPositiontuRUvjQ(float r100) {
        if (this.f473824a.getPosTan(r100, this.f473825b, this.f473826c) == false) goto L6;
        float[] r101 = this.f473825b;
        float r102 = r101[0];
        float r103 = r101[1];
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (((long) Float.floatToRawIntBits(r103)) & BodyPartID.bodyIdMax));
    L6:
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    /* JADX INFO: renamed from: getTangent-tuRUvjQ */
    public final long mo4724getTangenttuRUvjQ(float r100) {
        if (this.f473824a.getPosTan(r100, this.f473825b, this.f473826c) == false) goto L6;
        float[] r101 = this.f473826c;
        float r102 = r101[0];
        float r103 = r101[1];
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (((long) Float.floatToRawIntBits(r103)) & BodyPartID.bodyIdMax));
    L6:
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public final void setPath(Path r100, boolean r101) {
        PathMeasure r102 = this.f473824a;
        if (r100 != null) goto L5;
        android.graphics.Path r103 = null;
    L10:
        r102.setPath(r103, r101);
        return;
    L5:
        if ((r100 instanceof AndroidPath) == false) goto L8;
        r103 = ((AndroidPath) r100).getInternalPath();
        goto L10
    L8:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public final boolean getSegment(float r100, float r101, Path r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        PathMeasure r104 = this.f473824a;
        if ((r102 instanceof AndroidPath) == false) goto L7;
        return r104.getSegment(r100, r101, ((AndroidPath) r102).getInternalPath(), r103);
    L7:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }
}
