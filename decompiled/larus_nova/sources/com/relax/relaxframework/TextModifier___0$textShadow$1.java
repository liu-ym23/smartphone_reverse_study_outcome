package com.relax.relaxframework;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0004j\b\u0012\u0004\u0012\u00020\u0000`\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/relax/relaxframework/z;", MapController.ITEM_LAYER_TAG, "", RXScreenCaptureService.KEY_INDEX, "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "arr", "", "Lcom/relax/relaxframework/TextShadowParameterArray;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxframework/z;ILjava/util/ArrayList;)Ljava/util/ArrayList;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class TextModifier___0$textShadow$1 extends Lambda implements Function3<z, Integer, ArrayList<z>, ArrayList<Object>> {
    public static final TextModifier___0$textShadow$1 INSTANCE = null;

    static {
        INSTANCE = new TextModifier___0$textShadow$1();
    }

    public TextModifier___0$textShadow$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ ArrayList<Object> invoke(z r100, Integer r101, ArrayList<z> r102) {
        return invoke(r100, r101.intValue(), r102);
    }

    public final ArrayList<Object> invoke(z r100, int r101, ArrayList<z> r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "arr");
        return r100.a();
    }
}
