package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements ItemIdV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f238596a = null;

    static {
        f238596a = new c();
    }

    public c() {
    }

    @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
    public final ItemIdV2[] children() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
    public final String name() {
        return "fontSize";
    }

    @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
    public final ItemIdV2.DisplayMode displayMode() {
        return ItemIdV2.DisplayMode.NoDisplay;
    }
}
