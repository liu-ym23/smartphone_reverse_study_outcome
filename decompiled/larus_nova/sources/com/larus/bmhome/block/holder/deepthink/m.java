package com.larus.bmhome.block.holder.deepthink;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.obric.assistant.spi.complextask.ComplexTaskFoldStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f296289a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f296290b = null;

        static {
            int[] r100 = new int[DeepThinkFoldStatus.values().length];
            r100[DeepThinkFoldStatus.CompleteFold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r100[DeepThinkFoldStatus.HalfFold.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[DeepThinkFoldStatus.CompleteExpand.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            f296289a = r100;
            int[] r101 = new int[ComplexTaskFoldStatus.values().length];
            r101[ComplexTaskFoldStatus.CompleteFold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r101[ComplexTaskFoldStatus.HalfFold.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r101[ComplexTaskFoldStatus.CompleteExpand.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            f296290b = r101;
        }
    }

    public static final ComplexTaskFoldStatus a(DeepThinkFoldStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f296289a[r100.ordinal()];
        if (r101 == 1) goto L12;
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L14;
        return ComplexTaskFoldStatus.None;
    L14:
        return ComplexTaskFoldStatus.CompleteExpand;
    L15:
        return ComplexTaskFoldStatus.HalfFold;
    L12:
        return ComplexTaskFoldStatus.CompleteFold;
    }

    public static final DeepThinkFoldStatus b(ComplexTaskFoldStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f296290b[r100.ordinal()];
        if (r101 == 1) goto L12;
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L14;
        return DeepThinkFoldStatus.CompleteFold;
    L14:
        return DeepThinkFoldStatus.CompleteExpand;
    L15:
        return DeepThinkFoldStatus.HalfFold;
    L12:
        return DeepThinkFoldStatus.CompleteFold;
    }
}
