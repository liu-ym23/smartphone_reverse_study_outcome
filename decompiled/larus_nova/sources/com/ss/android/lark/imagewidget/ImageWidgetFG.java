package com.ss.android.lark.imagewidget;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes36.dex */
public final class ImageWidgetFG {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f426672a = null;

    static {
        f426672a = LazyKt.lazy(ImageWidgetFG$enableBigScreenCompat$2.INSTANCE);
    }

    public static final boolean a() {
        return ((Boolean) f426672a.getValue()).booleanValue();
    }
}
