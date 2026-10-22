package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.r;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "valid", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "result", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class MallPreDecode$cardDecode$1 extends Lambda implements Function4<Boolean, Throwable, String, byte[], Unit> {
    final /* synthetic */ String $url;
    final /* synthetic */ int $vmCount;
    final /* synthetic */ c this$0;

    public MallPreDecode$cardDecode$1(c r1, String r2, int r3) {
        this.$url = r2;
        this.$vmCount = r3;
        super(4);
    }

    public final void invoke(boolean r1, Throwable r2, String r3, byte[] r4) {
        if (r1 == true) goto L5;
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(r.c.b, "decode failed, timestamp = " + System.currentTimeMillis() + ", url = " + this.$url);
        return;
    L5:
        int r6 = com.bytedance.android.ec.hybrid.monitor.g.a;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        invoke(((Boolean) r1).booleanValue(), (Throwable) r2, (String) r3, (byte[]) r4);
        return Unit.INSTANCE;
    }
}
