package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements ItemIdV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f238702a = null;

    static {
        f238702a = new b();
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
    public final ItemIdV2[] children() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
    public final String name() {
        return "fontName";
    }

    @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
    public final ItemIdV2.DisplayMode displayMode() {
        return ItemIdV2.DisplayMode.NoDisplay;
    }
}
