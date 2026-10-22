package com.bytedance.kmp.image.utils;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/kmp/image/utils/EmptyPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "<init>", "()V", "kmpimage_release"}, k = 1, mv = {1, 7, 0})
public final class EmptyPainter extends Painter {
    static {
        new EmptyPainter();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(DrawScope r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo5530getIntrinsicSizeNHjbRc() {
        return Size.Companion.m4659getUnspecifiedNHjbRc();
    }

    private EmptyPainter() {
    }
}
