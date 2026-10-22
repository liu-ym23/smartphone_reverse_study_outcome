package com.bytedance.ee.bear.doc.follow.event;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/doc/follow/event/OpenImageWhiteboard;", "Lcom/bytedance/ee/bear/doc/follow/event/ContentEvent;", "imageToken", "", "crop", "", "matrix", "Landroid/graphics/Matrix;", "<init>", "(Ljava/lang/String;[FLandroid/graphics/Matrix;)V", "getImageToken", "()Ljava/lang/String;", "getCrop", "()[F", "getMatrix", "()Landroid/graphics/Matrix;", "docs-follow-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenImageWhiteboard implements ContentEvent {
    private final transient float[] crop;
    private final String imageToken;
    private final transient Matrix matrix;

    public final float[] getCrop() {
        return this.crop;
    }

    public final String getImageToken() {
        return this.imageToken;
    }

    public final Matrix getMatrix() {
        return this.matrix;
    }

    public OpenImageWhiteboard(String r2, float[] r3, Matrix r4) {
        Intrinsics.checkNotNullParameter(r2, "imageToken");
        Intrinsics.checkNotNullParameter(r4, "matrix");
        this.imageToken = r2;
        this.crop = r3;
        this.matrix = r4;
    }
}
