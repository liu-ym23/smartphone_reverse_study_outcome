package com.ss.android.lark.compose.chat_member_list;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements PopupPositionProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f417334a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f417335a = null;

        static {
            int[] r100 = new int[LayoutDirection.values().length];
            r100[LayoutDirection.Ltr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[LayoutDirection.Rtl.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f417335a = r100;
        }
    }

    static {
        f417334a = new b();
    }

    public b() {
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public final long mo340calculatePositionllwVHH4(IntRect r100, long r101, LayoutDirection r102, long r110) {
        Intrinsics.checkNotNullParameter(r100, "anchorBounds");
        Intrinsics.checkNotNullParameter(r102, "layoutDirection");
        int r103 = a.f417335a[r102.ordinal()];
        if (r103 != 1) goto L5;
        int r104 = r100.getRight() - ((int) (r110 >> 32));
    L10:
        int r105 = RangesKt.coerceIn(r104, 0, RangesKt.coerceAtLeast(((int) (r101 >> 32)) - ((int) (r110 >> 32)), 0));
        int r106 = RangesKt.coerceIn(r100.getBottom(), 0, RangesKt.coerceAtLeast(((int) (r101 & BodyPartID.bodyIdMax)) - ((int) (r110 & BodyPartID.bodyIdMax)), 0));
        return IntOffset.m7670constructorimpl((((long) r105) << 32) | (((long) r106) & BodyPartID.bodyIdMax));
    L5:
        if (r103 != 2) goto L8;
        r104 = r100.getLeft();
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
