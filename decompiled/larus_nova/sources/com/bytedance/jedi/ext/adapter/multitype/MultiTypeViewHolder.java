package com.bytedance.jedi.ext.adapter.multitype;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeViewHolder;", "ITEM", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public abstract class MultiTypeViewHolder<ITEM> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f251035d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f251036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ITEM f251037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f251038c;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiTypeViewHolder f251039a;

        public a(MultiTypeViewHolder r100) {
            this.f251039a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f251039a.T3();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            this.f251039a.V3();
        }
    }

    static {
        f251035d = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MultiTypeViewHolder.class), "itemViewMap", "getItemViewMap$ext_adapter_release()Landroid/util/SparseArray;"))};
    }

    public void T3() {
    }

    public void V3() {
    }

    public abstract void bind(ITEM r100, int r101);

    public final ITEM getItem() {
        ITEM r100 = this.f251037b;
        if (r100 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        return r100;
    }

    public MultiTypeViewHolder(View r100) {
        super(r100);
        this.f251036a = LazyKt.lazy(MultiTypeViewHolder$itemViewMap$2.INSTANCE);
        this.itemView.addOnAttachStateChangeListener(new a(this));
    }

    public void U3(ITEM r100, int r101, List<Object> r102) {
        this.f251038c = r101;
        this.f251037b = r100;
        bind(r100, r101);
    }
}
