package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt07/a;", "invoke", "()Lt07/a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class PreloadLynxTemplate$lynxKitService$2 extends Lambda implements Function0<t07.a> {
    public static final PreloadLynxTemplate$lynxKitService$2 INSTANCE = null;

    static {
        INSTANCE = new PreloadLynxTemplate$lynxKitService$2();
    }

    public PreloadLynxTemplate$lynxKitService$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final t07.a m1416invoke() {
        IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.geIlynxKitService();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1416invoke();
    }
}
