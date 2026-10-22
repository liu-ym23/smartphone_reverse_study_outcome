package com.ss.android.ugc.aweme.search.filter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderItem;
import com.ss.android.ugc.aweme.search.filter.view.component.ECSearchSimpleAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchGoodFilterLeftView;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/ugc/aweme/search/filter/view/component/ECSearchSimpleAdapter;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem;", "adapter", "", "setAdapter", "", "visible", "setVisible", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchGoodFilterLeftView extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f452884e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f452885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f452886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f452887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f452888d;

    public ECSearchGoodFilterLeftView(Context r100) {
        this(r100, null);
    }

    public final void setAdapter(ECSearchSimpleAdapter<RenderItem> r100) {
        RecyclerView r101 = this.f452886b;
        if (r101 == null) goto L5;
        r101.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
    L5:
        RecyclerView r102 = this.f452886b;
        if (r102 == null) goto L8;
        r102.setAdapter(r100);
    L8:
        RecyclerView r103 = this.f452886b;
        if (r103 == null) goto L11;
        r103.setLayoutManager(new GridLayoutManager(getContext(), 1));
    L11:
        RecyclerView r104 = this.f452886b;
        if (r104 == null) goto L15;
        r104.setItemAnimator(null);
        return;
    }

    public final void setVisible(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        setVisibility(r101);
        return;
    L4:
        r101 = 8;
        goto L5
    }

    public ECSearchGoodFilterLeftView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        new ECSearchGoodFilterLeftView$adapter$1(this);
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.ec_search_components_commodity_filter_left_broad_view, this);
        this.f452885a = r102;
        View r103 = null;
        if (r102 == null) goto L5;
        RecyclerView r104 = (RecyclerView) r102.findViewById(R.id.filter_left_root_rv);
    L6:
        this.f452886b = r104;
        View r105 = this.f452885a;
        if (r105 == null) goto L9;
        View r106 = r105.findViewById(R.id.horizontal_gradient_bg);
    L10:
        this.f452887c = r106;
        View r107 = this.f452885a;
        if (r107 == null) goto L13;
        r103 = r107.findViewById(R.id.vertical_gradient_bg);
    L13:
        this.f452888d = r103;
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
