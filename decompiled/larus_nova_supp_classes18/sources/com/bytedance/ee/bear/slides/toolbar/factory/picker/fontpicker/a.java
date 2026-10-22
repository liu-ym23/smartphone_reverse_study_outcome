package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends DiffUtil.ItemCallback<FontItem> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final boolean areContentsTheSame(Object r2, Object r3) {
        FontItem r4 = (FontItem) r2;
        FontItem r5 = (FontItem) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        return Intrinsics.areEqual(r4, r5);
    }

    public final boolean areItemsTheSame(Object r2, Object r3) {
        FontItem r4 = (FontItem) r2;
        FontItem r5 = (FontItem) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        return Intrinsics.areEqual(r4.getKey(), r5.getKey());
    }
}
