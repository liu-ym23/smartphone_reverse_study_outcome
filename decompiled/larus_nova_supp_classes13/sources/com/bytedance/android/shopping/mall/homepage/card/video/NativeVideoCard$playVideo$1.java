package com.bytedance.android.shopping.mall.homepage.card.video;

import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "p2", "", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class NativeVideoCard$playVideo$1 extends FunctionReferenceImpl implements Function2<String, Map<String, ? extends Object>, Unit> {
    public NativeVideoCard$playVideo$1(NativeVideoCard r8) {
        super(2, r8, NativeVideoCard.class, "onVideoStateChange", "onVideoStateChange(Ljava/lang/String;Ljava/util/Map;)V", 0);
    }

    public final void invoke(String r8, Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r8, "p1");
        Intrinsics.checkNotNullParameter(r9, "p2");
        NativeVideoCard r1 = (NativeVideoCard) ((CallableReference) this).receiver;
        int r0 = NativeVideoCard.T1;
        r1.getClass();
        Object r2 = null;
        String r3 = "";
        switch(r8.hashCode()) {
            case -1581427716: goto L38;
            case -1433717972: goto L36;
            case -1349867671: goto L25;
            case -1138330660: goto L22;
            case -1013054029: goto L11;
            case 1676109405: goto L6;
            default: goto L51;
        };
    L38:
        r8.equals("onProgressChange");
        return;
    L51:
        return;
    L6:
        if (r8.equals("onCompleteLoaded") == false) goto L40;
        Function0<Unit> r10 = r1.H1;
        if (r10 == null) goto L41;
        Unit r11 = (Unit) r10.invoke();
        return;
    L41:
        return;
    L40:
        return;
    L11:
        if (r8.equals("onPlay") == false) goto L43;
        Intrinsics.checkNotNullParameter(r1, "$this$reportPlayVideo");
        g.f(r1, "video_window_show_start");
        Intrinsics.checkNotNullParameter(r1, "$this$reportEcomCardAutoPlay");
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r12.put("ecom_type", "video");
        VideoCardData r13 = r1.O;
        if (r13 == null) goto L20;
        VideoCardData.Video r14 = r13.getVideo();
        if (r14 == null) goto L20;
        String r15 = r14.getItemId();
        if (r15 == null) goto L20;
        r3 = r15;
    L20:
        r12.put("group_id", r3);
        g.b(r1, r12);
        ToolsKt.x(r1, "ecom_card_auto_play", null, r12, null);
        return;
    L43:
        return;
    L22:
        if (r8.equals("onFirstFrame") == false) goto L45;
        r1.W = System.currentTimeMillis();
        g.d(r1, 1, 0, null, 0, 14);
        return;
    L45:
        return;
    L25:
        if (r8.equals("onError") == false) goto L47;
        r1.K4();
        Object r16 = b0.d(r9, "message", "");
        if ((r16 instanceof String) == false) goto L30;
        r2 = r16;
    L30:
        String r4 = (String) r2;
        if (r4 != null) goto L33;
        String r5 = "";
    L34:
        g.d(r1, 2, -1, r5, 0, 8);
        return;
    L33:
        r5 = r4;
        goto L34
    L47:
        return;
    L36:
        if (r8.equals("onCompleted") == false) goto L49;
        r1.K4();
        Intrinsics.checkNotNullParameter(r1, "$this$reportVideoPlayFinish");
        g.f(r1, "video_window_show_finish");
        r1.K();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (Map) r2);
        return Unit.INSTANCE;
    }
}
