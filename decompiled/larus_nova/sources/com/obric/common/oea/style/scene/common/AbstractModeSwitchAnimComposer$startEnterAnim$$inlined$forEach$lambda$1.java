package com.obric.common.oea.style.scene.common;

import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.lynx.tasm.LynxError;
import com.obric.common.oea.foundation.animation.builder.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED, "", LynxError.LYNX_THROWABLE, "", AbsMethodDelegate.TAG_INVOKE, "com/obric/common/oea/style/scene/common/AbstractModeSwitchAnimComposer$startEnterAnim$1$1"}, k = 3, mv = {1, 4, 3})
final class AbstractModeSwitchAnimComposer$startEnterAnim$$inlined$forEach$lambda$1 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ int $animCount$inlined;
    final /* synthetic */ Ref.IntRef $finishedCount$inlined;
    final /* synthetic */ Ref.BooleanRef $finishedSuccess$inlined;
    final /* synthetic */ b.a $it;
    final /* synthetic */ Function1 $onEnd$inlined;
    final /* synthetic */ Function2 $onSingleEnd$inlined;
    final /* synthetic */ a this$0;

    public AbstractModeSwitchAnimComposer$startEnterAnim$$inlined$forEach$lambda$1(b.a r100, a r101, Ref.BooleanRef r102, Ref.IntRef r103, Function2 r104, int r105, Function1 r106) {
        this.$it = r100;
        this.this$0 = r101;
        this.$finishedSuccess$inlined = r102;
        this.$finishedCount$inlined = r103;
        this.$onSingleEnd$inlined = r104;
        this.$animCount$inlined = r105;
        this.$onEnd$inlined = r106;
        super(2);
    }

    public final void invoke(boolean r100, Throwable r101) {
        if (r100 == true) goto L4;
        this.$finishedSuccess$inlined.element = false;
    L4:
        this.$finishedCount$inlined.element++;
        this.$onSingleEnd$inlined.invoke(this.$it.f396373f, Boolean.valueOf(r100));
        if (this.$finishedCount$inlined.element != this.$animCount$inlined) goto L8;
        mja.a.C6822a r102 = mja.a.f514263a;
        String r103 = this.this$0.f396655a;
        StringBuilder r104 = new StringBuilder("startEnterAnim, anim complete, finishedSuccess? ");
        r104.append(this.$finishedSuccess$inlined.element);
        r104.append(", time cost: ");
        long r105 = System.currentTimeMillis();
        this.this$0.getClass();
        r104.append(r105 - 0);
        r104.append(" ms");
        mja.a.a(r103, r104.toString());
        this.$onEnd$inlined.invoke(Boolean.valueOf(this.$finishedSuccess$inlined.element));
        ((ArrayList) this.this$0.f396656b).clear();
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, Throwable r101) {
        invoke(r100.booleanValue(), r101);
        return Unit.INSTANCE;
    }
}
