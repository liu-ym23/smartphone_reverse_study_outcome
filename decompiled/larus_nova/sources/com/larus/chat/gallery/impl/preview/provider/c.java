package com.larus.chat.gallery.impl.preview.provider;

import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.chat.gallery.providers.input.GalleryInputFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GalleryInputFragment f324493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f324494b;

    public c(GalleryInputFragment r100, m0 r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "onModeChanged");
        this.f324493a = r100;
        this.f324494b = r101;
    }
}
