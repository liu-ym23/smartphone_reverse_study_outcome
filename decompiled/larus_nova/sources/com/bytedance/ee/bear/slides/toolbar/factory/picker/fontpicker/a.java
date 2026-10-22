package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends DiffUtil.ItemCallback<FontItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f238701a = null;

    static {
        f238701a = new a();
    }

    public a() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(FontItem r100, FontItem r101) {
        FontItem r102 = r100;
        FontItem r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        return Intrinsics.areEqual(r102, r103);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(FontItem r100, FontItem r101) {
        FontItem r102 = r100;
        FontItem r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        return Intrinsics.areEqual(r102.getKey(), r103.getKey());
    }
}
