package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.service.base.i0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface IBridgeScope extends i0 {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeScope$BridgeNotFoundException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "scope", "", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class BridgeNotFoundException extends Exception {
        public BridgeNotFoundException(String r100) {
            Intrinsics.checkNotNullParameter(r100, "scope");
            super(r100 + " not found");
        }
    }

    Map<String, IBridgeScope> B80();

    void RA(IBridgeScope r100, boolean r101);

    Map<String, com.bytedance.ies.bullet.service.base.bridge.a> W60();

    void Yc(List<String> r100, Object r101, com.bytedance.ies.bullet.service.base.bridge.a.InterfaceC3543a r102, Function1<? super Throwable, Unit> r103);

    void e80(Function2<? super List<? extends IBridgeScope>, ? super com.bytedance.ies.bullet.service.base.bridge.a, Unit> r100);

    String getName();
}
