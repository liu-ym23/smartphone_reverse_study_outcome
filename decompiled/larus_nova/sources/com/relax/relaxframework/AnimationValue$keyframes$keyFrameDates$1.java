package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0004j\b\u0012\u0004\u0012\u00020\u0000`\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/relax/relaxframework/t1;", "keyframe", "", "idx_", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "arr", "Lcom/relax/relaxframework/c;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxframework/t1;ILjava/util/ArrayList;)Lcom/relax/relaxframework/c;", "<no name provided>"}, k = 3, mv = {1, 7, 1})
final class AnimationValue$keyframes$keyFrameDates$1 extends Lambda implements Function3<t1, Integer, ArrayList<t1>, c> {
    final /* synthetic */ f this$0;

    public AnimationValue$keyframes$keyFrameDates$1(f r100) {
        this.this$0 = r100;
        super(3);
    }

    public final c invoke(t1 r100, int r101, ArrayList<t1> r102) {
        Intrinsics.checkNotNullParameter(r100, "keyframe");
        Intrinsics.checkNotNullParameter(r102, "arr");
        c r103 = r100.a();
        String r104 = r103.f405030b + this.this$0.f405079g;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f405030b = r104;
        return r103;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ c invoke(t1 r100, Integer r101, ArrayList<t1> r102) {
        return invoke(r100, r101.intValue(), r102);
    }
}
