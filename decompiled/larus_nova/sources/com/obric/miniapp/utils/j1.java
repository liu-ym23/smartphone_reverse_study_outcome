package com.obric.miniapp.utils;

import com.bytedance.ai.widget.contianer.WidgetContainer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WidgetContainer f398494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<ot8.a, Function1<WidgetContainer, Unit>> f398495b;

    public j1(WidgetContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetContainer");
        this.f398494a = r100;
        this.f398495b = new LinkedHashMap();
    }
}
