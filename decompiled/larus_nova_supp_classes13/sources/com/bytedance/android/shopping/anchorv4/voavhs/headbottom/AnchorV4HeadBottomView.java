package com.bytedance.android.shopping.anchorv4.voavhs.headbottom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.anchorv4.vm.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headbottom/AnchorV4HeadBottomView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv4/vm/c;", "getHeadViewStatusListener", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headbottom/AnchorV4HeadBottomHandler;", "b", "Lkotlin/Lazy;", "getHeadBottomHandler", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headbottom/AnchorV4HeadBottomHandler;", "headBottomHandler", "Ld83/b;", "c", "Ld83/b;", "getHeadViewAbility", "()Ld83/b;", "setHeadViewAbility", "(Ld83/b;)V", "headViewAbility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadBottomView extends FrameLayout {
    public final UnresponsiveRecyclerView a;
    public final Lazy b;
    public d83.b c;

    public AnchorV4HeadBottomView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4HeadBottomView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final AnchorV4HeadBottomHandler getHeadBottomHandler() {
        return (AnchorV4HeadBottomHandler) this.b.getValue();
    }

    public final c getHeadViewStatusListener() {
        return getHeadBottomHandler();
    }

    public final d83.b getHeadViewAbility() {
        return this.c;
    }

    public final void setHeadViewAbility(d83.b r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View, com.bytedance.android.shopping.anchorv4.voavhs.headbottom.UnresponsiveRecyclerView] */
    public AnchorV4HeadBottomView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        ?? r6 = new UnresponsiveRecyclerView(r3, null, 6, 0);
        this.a = r6;
        this.b = LazyKt.lazy(new AnchorV4HeadBottomView$headBottomHandler$2(this));
        addView(r6, -1, com.bytedance.android.shopping.extensions.b.b(12));
    }

    public /* synthetic */ AnchorV4HeadBottomView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
