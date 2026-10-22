package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.service.base.i0;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes19.dex */
public interface f extends i0 {
    void AL(BridgeRegistry r100, boolean r101);

    com.bytedance.ies.bullet.service.base.bridge.a B40(String r100);

    void Jt(Function1<? super com.bytedance.ies.bullet.service.base.bridge.a, Unit> r100);

    void LV(com.bytedance.ies.bullet.service.base.bridge.a r100);

    void UE(String r100, Object r101, com.bytedance.ies.bullet.service.base.bridge.a.InterfaceC3543a r102, Function1<? super Throwable, Unit> r103);

    void hS(Function2<? super String, ? super com.bytedance.ies.bullet.service.base.bridge.a, Unit> r100);

    boolean lp();

    Map<String, com.bytedance.ies.bullet.service.base.bridge.a> xu();
}
