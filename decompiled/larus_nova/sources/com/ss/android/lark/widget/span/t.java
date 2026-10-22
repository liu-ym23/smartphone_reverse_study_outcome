package com.ss.android.lark.widget.span;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public interface t {

    public static final class a {
        public static void a(t r100, Rect r101) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            r101.right += r100.getPaddingRight() + r100.getPaddingLeft();
            r101.bottom += r100.getPaddingBottom() + r100.getPaddingTop();
        }
    }

    int getPaddingBottom();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingTop();
}
