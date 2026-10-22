package com.bytedance.android.window.shop.repository.tab.datasource.impl;

import com.bytedance.android.window.shop.repository.dto.WindowExtensionDataListResponseDTO;
import com.bytedance.android.window.shop.repository.tab.datasource.mapping.WindowDataMapper;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T, R> implements Function {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r2) {
        WindowExtensionDataListResponseDTO r3 = (WindowExtensionDataListResponseDTO) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        Map<Integer, com.bytedance.android.window.shop.repository.tab.datasource.mapping.f> r0 = WindowDataMapper.a;
        return TuplesKt.to(r3, WindowDataMapper.c(r3.getMixFullCards()));
    }
}
