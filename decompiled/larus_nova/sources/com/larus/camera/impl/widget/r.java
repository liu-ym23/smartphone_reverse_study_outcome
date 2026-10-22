package com.larus.camera.impl.widget;

import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class r implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PickerLayoutManager f322922a;

    public /* synthetic */ r(PickerLayoutManager r100) {
        this.f322922a = r100;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object r100, Object r101, Object r102) {
        PickerLayoutManager r103 = this.f322922a;
        View r104 = (View) r100;
        ((Integer) r101).intValue();
        float r105 = ((Float) r102).floatValue();
        Intrinsics.checkNotNullParameter(r104, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        r103.f322874a.a(r104, r105);
        return Unit.INSTANCE;
    }
}
