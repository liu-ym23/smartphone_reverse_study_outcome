package com.larus.bmhome.view.actionbar.custom;

import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class x1 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f316011a;

    public /* synthetic */ x1(String r100) {
        this.f316011a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String r100 = this.f316011a;
        int r101 = CustomActionBarNormalHolder.f315764v;
        return Integer.valueOf(ColorProtector.parseColor(r100));
    }
}
