package com.ss.android.lark.audio.config;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public final class DeviceMatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Function1<String, Boolean>> f408971a;

    public DeviceMatcher() {
        this.f408971a = MapsKt.mapOf(new Pair[]{TuplesKt.to("manufacturer", DeviceMatcher$propertyMatchers$1.INSTANCE), TuplesKt.to("brand", DeviceMatcher$propertyMatchers$2.INSTANCE), TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, DeviceMatcher$propertyMatchers$3.INSTANCE), TuplesKt.to("os_version", DeviceMatcher$propertyMatchers$4.INSTANCE)});
    }
}
