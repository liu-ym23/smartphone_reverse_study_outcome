package com.larus.bmhome.chat.api;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public interface d0 {

    public static final class a {
        public static void a(SelectionRangeType r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "rangeType");
            Intrinsics.checkNotNullParameter(r101, "selectedText");
        }
    }

    void a(View r100, int r101, int r102);

    void b(SelectionRangeType r100, int r101, int r102, boolean r103, boolean r104, Rect r105, String r106);
}
