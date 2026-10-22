package com.bytedance.android.shopping.mall.homepage.card.video;

import com.bytedance.android.shopping.api.mall.common.tools.b0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "p2", "", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class NativeVideoBigCard$playVideo$1 extends FunctionReferenceImpl implements Function2<String, Map<String, ? extends Object>, Unit> {
    public NativeVideoBigCard$playVideo$1(NativeVideoBigCard r8) {
        super(2, r8, NativeVideoBigCard.class, "onVideoStateChange", "onVideoStateChange(Ljava/lang/String;Ljava/util/Map;)V", 0);
    }

    public final void invoke(String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        Intrinsics.checkNotNullParameter(r5, "p2");
        NativeVideoBigCard r0 = (NativeVideoBigCard) ((CallableReference) this).receiver;
        int r1 = NativeVideoBigCard.C;
        r0.getClass();
        Object r2 = null;
        switch(r4.hashCode()) {
            case -1581427716: goto L24;
            case -1433717972: goto L21;
            case -1349867671: goto L10;
            case -1138330660: goto L7;
            case -1013054029: goto L5;
            default: goto L48;
        };
    L5:
        r4.equals("onPlay");
        return;
    L48:
        return;
    L7:
        if (r4.equals("onFirstFrame") == false) goto L38;
        r0.z = System.currentTimeMillis();
        g.c(r0, 1, 0, null, 14);
        return;
    L38:
        return;
    L10:
        if (r4.equals("onError") == false) goto L40;
        r0.q4();
        String r3 = "";
        Object r6 = b0.d(r5, "message", "");
        if ((r6 instanceof String) == false) goto L15;
        r2 = r6;
    L15:
        String r7 = (String) r2;
        if (r7 == null) goto L19;
        r3 = r7;
    L19:
        g.c(r0, 2, -1, r3, 8);
        return;
    L40:
        return;
    L21:
        if (r4.equals("onCompleted") == false) goto L42;
        r0.K();
        return;
    L42:
        return;
    L24:
        if (r4.equals("onProgressChange") == false) goto L44;
        Object r8 = r5.get("progress");
        if ((r8 instanceof Integer) == false) goto L29;
        r2 = r8;
    L29:
        Integer r9 = (Integer) r2;
        if (r9 == null) goto L45;
        int r10 = r9.intValue();
        VideoCardModel r11 = r0.u;
        if (r11 == null) goto L46;
        int r12 = r11.getVideo().getSeconds() * 1000;
        if (r12 <= 0) goto L47;
        r0.r.setProgress((r10 * 100) / r12);
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (Map) r2);
        return Unit.INSTANCE;
    }
}
