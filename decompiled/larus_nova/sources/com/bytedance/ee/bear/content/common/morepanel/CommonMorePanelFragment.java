package com.bytedance.ee.bear.content.common.morepanel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/content/common/morepanel/CloseDelegatable;", "<init>", "()V", "rootView", "Landroid/view/View;", "viewModel", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelViewModel;", "adapter", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonPanelAdapter;", "mCloseDelegate", "Lcom/bytedance/ee/bear/content/common/morepanel/CloseDelegatable$CloseDelegate;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "setCloseDelegate", "closeDelegate", "notifyBackPressed", "parseArguments", "updateResetView", "data", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelData;", "Companion", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonMorePanelFragment extends BaseFragment implements com.bytedance.ee.bear.content.common.morepanel.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f216776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommonMorePanelViewModel f216777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CommonPanelAdapter f216778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.ee.bear.content.common.morepanel.a.InterfaceC3091a f216779h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.content.common.morepanel.a
    public final void tk() {
    }

    public CommonMorePanelFragment() {
    }

    @Override // com.bytedance.ee.bear.content.common.morepanel.a
    public final void uC(hw4.a r100) {
        this.f216779h = r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        FragmentActivity r102 = getActivity();
        ArrayList<CommonMorePanelItemData> r103 = null;
        if (r102 == null) goto L5;
        CommonMorePanelViewModel r104 = (CommonMorePanelViewModel) new ViewModelProvider(r102).get(CommonMorePanelViewModel.class);
    L6:
        this.f216777f = r104;
        CommonPanelAdapter r105 = new CommonPanelAdapter();
        this.f216778g = r105;
        b r106 = new b(this);
        Intrinsics.checkNotNullParameter(r106, "listener");
        r105.f216790c = r106;
        View r107 = this.f216776e;
        if (r107 == null) goto L9;
        RecyclerView r108 = (RecyclerView) r107.findViewById(R.id.rv_content_panel);
    L10:
        if (r108 == null) goto L12;
        r108.setLayoutManager(new LinearLayoutManager(getContext()));
    L12:
        if (r108 == null) goto L14;
        r108.setAdapter(this.f216778g);
    L14:
        View r109 = this.f216776e;
        if (r109 == null) goto L17;
        CommonActionPanelLayout r110 = (CommonActionPanelLayout) r109.findViewById(R.id.title_panel);
    L18:
        if (r110 == null) goto L20;
        r110.setOnActionListener(new c(this));
    L20:
        Bundle r111 = getArguments();
        if (r111 == null) goto L23;
        CommonMorePanelData r112 = (CommonMorePanelData) r111.getParcelable("panel_data");
    L24:
        if (r112 == null) goto L26;
        Boolean r113 = Boolean.valueOf(r112.f216774b);
    L27:
        View r114 = this.f216776e;
        if (r114 == null) goto L30;
        TextView r115 = (TextView) r114.findViewById(R.id.tv_reset);
    L31:
        if (r115 != null) goto L33;
    L37:
        if (r115 == null) goto L39;
        r115.setOnClickListener(new d(this));
    L39:
        if (r112 == null) goto L41;
        r103 = r112.f216775c;
    L41:
        View r116 = this.f216776e;
        if (r116 == null) goto L50;
        CommonActionPanelLayout r117 = (CommonActionPanelLayout) r116.findViewById(R.id.title_panel);
        if (r117 == null) goto L50;
        if (r112 == null) goto L48;
        String r118 = r112.f216773a;
        if (r118 == null) goto L48;
    L49:
        r117.setTitle(r118);
    L48:
        r118 = "";
    L50:
        CommonPanelAdapter r119 = this.f216778g;
        if (r119 == null) goto L55;
        if (r103 == null) goto L56;
        r119.f216788a = r103;
        r119.notifyDataSetChanged();
        return;
    L56:
        return;
    L55:
        return;
    L33:
        if (Intrinsics.areEqual(r113, Boolean.TRUE) == false) goto L35;
        int r120 = 0;
    L36:
        r115.setVisibility(r120);
        goto L37
    L35:
        r120 = 8;
        goto L36
    L30:
        r115 = null;
        goto L31
    L26:
        r113 = null;
        goto L27
    L23:
        r112 = null;
        goto L24
    L17:
        r110 = null;
        goto L18
    L9:
        r108 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.content_fragment_common_panel, r101, false);
        this.f216776e = r103;
        return r103;
    }
}
