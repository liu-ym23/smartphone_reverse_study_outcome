package io.noties.markwon.ext.onetex;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lwsc/a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lwsc/a;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ReusableLatexMathPlugin$obtainDrawable$drawable$1 extends Lambda implements Function1<wsc.a, Boolean> {
    final /* synthetic */ boolean $isBlock;
    final /* synthetic */ String $latex;
    final /* synthetic */ Integer $texOrder;
    final /* synthetic */ Integer $textColor;
    final /* synthetic */ Float $textSize;

    public ReusableLatexMathPlugin$obtainDrawable$drawable$1(String r100, boolean r101, Integer r102, Integer r103, Float r104) {
        this.$latex = r100;
        this.$isBlock = r101;
        this.$texOrder = r102;
        this.$textColor = r103;
        this.$textSize = r104;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(wsc.a r100) {
        if ((r100 instanceof b) == false) goto L17;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(r101.f561116a, this.$latex) == false) goto L17;
        if (r101.f561118c != null) goto L17;
        if (r101.f492393m != this.$isBlock) goto L17;
        if (Intrinsics.areEqual(r101.f492395o, this.$texOrder) == false) goto L17;
        if (Intrinsics.areEqual(r101.f492396p, this.$textColor) == false) goto L17;
        if (Intrinsics.areEqual(r101.f492397q, this.$textSize) == false) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(wsc.a r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
