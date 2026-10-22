package com.bytedance.salamander.bdfoundation;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", BaseSwitches.V, "", RXScreenCaptureService.KEY_INDEX, "arr", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SLBaseColor$toArgbString$1 extends Lambda implements Function3<Integer, Integer, ArrayList<Integer>, String> {
    public static final SLBaseColor$toArgbString$1 INSTANCE = null;

    static {
        INSTANCE = new SLBaseColor$toArgbString$1();
    }

    public SLBaseColor$toArgbString$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ String invoke(Integer r100, Integer r101, ArrayList<Integer> r102) {
        return invoke(r100.intValue(), r101.intValue(), r102);
    }

    public final String invoke(int r100, int r101, ArrayList<Integer> r102) {
        Intrinsics.checkNotNullParameter(r102, "arr");
        return b.a(r100);
    }
}
