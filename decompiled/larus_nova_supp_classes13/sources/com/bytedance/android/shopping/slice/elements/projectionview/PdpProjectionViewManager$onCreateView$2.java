package com.bytedance.android.shopping.slice.elements.projectionview;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class PdpProjectionViewManager$onCreateView$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ a $bkgImageView;
    final /* synthetic */ Function1 $drawCallback;
    final /* synthetic */ Ref.ObjectRef $headView;
    final /* synthetic */ PdpProjectionViewManager this$0;

    public PdpProjectionViewManager$onCreateView$2(PdpProjectionViewManager r1, Ref.ObjectRef r2, Function1 r3, a r4) {
        this.this$0 = r1;
        this.$headView = r2;
        this.$drawCallback = r3;
        this.$bkgImageView = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2951invoke() {
        if (PdpProjectionViewManager.K1(this.this$0, (View) this.$headView.element, this.$drawCallback) == null) goto L6;
        this.this$0.getClass();
        this.$bkgImageView.setBackground(new BitmapDrawable(null));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2951invoke();
        return Unit.INSTANCE;
    }
}
