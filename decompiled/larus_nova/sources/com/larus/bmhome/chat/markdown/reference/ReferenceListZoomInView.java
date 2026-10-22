package com.larus.bmhome.chat.markdown.reference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.mainbot.impl.databinding.LarusReferenceListZoomInViewBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/markdown/reference/ReferenceListZoomInView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusReferenceListZoomInViewBinding;", "setReferenceListRecyclerViewAdapter", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getSearchReferenceList", "Landroidx/recyclerview/widget/RecyclerView;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReferenceListZoomInView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusReferenceListZoomInViewBinding f307150a;

    public ReferenceListZoomInView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReferenceListZoomInView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final RecyclerView getSearchReferenceList() {
        return this.f307150a.f358821c;
    }

    public final void setReferenceListRecyclerViewAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        this.f307150a.f358821c.setAdapter(r100);
    }

    public ReferenceListZoomInView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_reference_list_zoom_in_view, this, false);
        addView(r103);
        int r104 = R.id.mask_reference_title;
        View r105 = ViewBindings.findChildViewById(r103, R.id.mask_reference_title);
        if (r105 == null) goto L9;
        r104 = R.id.search_reference_list;
        RecyclerView r106 = (RecyclerView) ViewBindings.findChildViewById(r103, R.id.search_reference_list);
        if (r106 == null) goto L9;
        this.f307150a = new LarusReferenceListZoomInViewBinding((ConstraintLayout) r103, r105, r106);
        r106.setLayoutManager(new LinearLayoutManager(r100));
        r106.addItemDecoration(new AnonymousClass1(this));
        r106.addOnLayoutChangeListener(new q(this));
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ ReferenceListZoomInView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
