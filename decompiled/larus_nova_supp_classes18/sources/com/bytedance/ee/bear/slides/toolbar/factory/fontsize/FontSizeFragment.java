package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/FontSizeFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "backClickListener", "Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/OnBackClickListener;", "onProgressListener", "Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/onProgressListener;", "fontSizeAdapter", "Lcom/bytedance/ee/bear/slides/toolbar/factory/fontsize/FontSizeAdapter;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "setOnBackClickListener", "listener", "setOnProgressListener", "Companion", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontSizeFragment extends BaseFragment {
    public static final /* synthetic */ int j = 0;
    public RecyclerView e;
    public h f;
    public i g;
    public FontSizeAdapter h;
    public final Lazy i;

    public static final class a {
    }

    public static final class b implements i {
        public final /* synthetic */ FontSizeFragment a;

        public b(FontSizeFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.slides.toolbar.factory.fontsize.i
        public final void a(int r2) {
            i r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }
    }

    static {
    }

    public FontSizeFragment() {
        this.i = LazyKt.lazy(FontSizeFragment$gson$2.INSTANCE);
    }

    public final void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        RecyclerView r6 = r4.findViewById(2131384952);
        this.e = r6;
        FontSizeAdapter r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r6 = null;
    L5:
        final Context r1 = r6.getContext();
        r6.setLayoutManager(new FontSizeFragment$onViewCreated$1$1(r1));
        String r7 = requireArguments().getString("fontSizeData");
        if (r7 == null) goto L9;
        FontSizeItem r8 = (FontSizeItem) GsonProtectorUtils.fromJson((Gson) this.i.getValue(), r7, FontSizeItem.class);
        if (r8 == null) goto L9;
    L10:
        FontSizeAdapter r2 = new FontSizeAdapter(CollectionsKt.listOf(r8));
        r2.b = this.f;
        r2.c = new b(this);
        this.h = r2;
        RecyclerView r9 = this.e;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r9 = null;
    L13:
        FontSizeAdapter r10 = this.h;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("fontSizeAdapter");
    L17:
        r9.setAdapter(r0);
        return;
    L16:
        r0 = r10;
    L9:
        r8 = new FontSizeItem();
        goto L10
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559951, r3, false);
    }
}
