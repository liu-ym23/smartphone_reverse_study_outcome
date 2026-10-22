package com.bytedance.android.shopping.anchorv4.voavhs.headgausee;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headgausee/HeadGaussRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "", "items", "", "setGaussItem", "Lcom/bytedance/android/shopping/anchorv4/vm/AnchorV4VM;", "a", "Lcom/bytedance/android/shopping/anchorv4/vm/AnchorV4VM;", "getAnchorV4VM", "()Lcom/bytedance/android/shopping/anchorv4/vm/AnchorV4VM;", "setAnchorV4VM", "(Lcom/bytedance/android/shopping/anchorv4/vm/AnchorV4VM;)V", "anchorV4VM", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headgausee/HeadGaussViewAdapter;", "b", "Lkotlin/Lazy;", "getCurrentAdapter", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headgausee/HeadGaussViewAdapter;", "currentAdapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadGaussRecyclerView extends RecyclerView {
    public AnchorV4VM a;
    public final Lazy b;

    public HeadGaussRecyclerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HeadGaussRecyclerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final HeadGaussViewAdapter getCurrentAdapter() {
        return (HeadGaussViewAdapter) this.b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r() {
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        setAdapter(getCurrentAdapter());
    }

    public final AnchorV4VM getAnchorV4VM() {
        return this.a;
    }

    public final void setAnchorV4VM(AnchorV4VM r1) {
        this.a = r1;
    }

    public final void setGaussItem(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        getCurrentAdapter().a = r2;
    }

    public HeadGaussRecyclerView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LazyKt.lazy(new HeadGaussRecyclerView$currentAdapter$2(r2));
    }

    public /* synthetic */ HeadGaussRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
