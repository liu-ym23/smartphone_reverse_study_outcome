package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/livesdk/livecommerce/room/widgets/anim/BottomRightAnimController$executeAnim$1$2"}, k = 3, mv = {1, 4, 3})
final class BottomRightAnimController$executeAnim$$inlined$let$lambda$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b $it;
    final /* synthetic */ b $requestAnim$inlined;
    final /* synthetic */ BottomRightAnimController this$0;

    public BottomRightAnimController$executeAnim$$inlined$let$lambda$2(b r1, BottomRightAnimController r2, b r3) {
        this.$it = r1;
        this.this$0 = r2;
        this.$requestAnim$inlined = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1155invoke() {
        BottomRightAnimController r0 = this.this$0;
        int r1 = BottomRightAnimController.j;
        r0.getClass();
        this.$it.b();
        b r2 = this.$it;
        r2.e.invoke(r2.c, new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1155invoke();
        return Unit.INSTANCE;
    }
}
