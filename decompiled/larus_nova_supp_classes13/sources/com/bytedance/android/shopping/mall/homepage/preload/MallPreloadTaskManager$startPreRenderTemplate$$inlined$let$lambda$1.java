package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.shopping.api.mall.q;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/shopping/mall/homepage/preload/MallPreloadTaskManager$startPreRenderTemplate$1$1"}, k = 3, mv = {1, 4, 3})
final class MallPreloadTaskManager$startPreRenderTemplate$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List $cardList$inlined;
    final /* synthetic */ q $taskContext$inlined;
    final /* synthetic */ MallPreloadTaskManager this$0;

    public MallPreloadTaskManager$startPreRenderTemplate$$inlined$let$lambda$1(MallPreloadTaskManager r1, q r2, List r3) {
        this.this$0 = r1;
        this.$taskContext$inlined = r2;
        this.$cardList$inlined = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1405invoke() {
        MallPreloadTaskManager r0 = this.this$0;
        r0.f = Boolean.FALSE;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1405invoke();
        return Unit.INSTANCE;
    }
}
