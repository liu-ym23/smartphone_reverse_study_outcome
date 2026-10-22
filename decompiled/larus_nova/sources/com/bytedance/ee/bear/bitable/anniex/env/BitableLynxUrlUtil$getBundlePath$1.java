package com.bytedance.ee.bear.bitable.anniex.env;

import com.bytedance.ee.bear.bitable.anniex.host.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class BitableLynxUrlUtil$getBundlePath$1 extends FunctionReferenceImpl implements Function1<Integer, d> {
    public BitableLynxUrlUtil$getBundlePath$1(Object r100) {
        super(1, r100, com.bytedance.ee.bear.bitable.anniex.host.c.class, "getSceneAvailability", "getSceneAvailability(I)Lcom/bytedance/ee/bear/bitable/anniex/host/BitableLynxSceneAvailability;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d invoke(Integer r100) {
        return invoke(r100.intValue());
    }

    public final d invoke(int r100) {
        return ((com.bytedance.ee.bear.bitable.anniex.host.c) this.receiver).c(r100);
    }
}
