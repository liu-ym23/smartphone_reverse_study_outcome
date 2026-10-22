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
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/content/common/morepanel/CloseDelegatable;", "<init>", "()V", "rootView", "Landroid/view/View;", "viewModel", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelViewModel;", "adapter", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonPanelAdapter;", "mCloseDelegate", "Lcom/bytedance/ee/bear/content/common/morepanel/CloseDelegatable$CloseDelegate;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "setCloseDelegate", "closeDelegate", "notifyBackPressed", "parseArguments", "updateResetView", "data", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelData;", "Companion", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonMorePanelFragment extends BaseFragment implements com.bytedance.ee.bear.content.common.morepanel.a {
    public View e;
    public CommonMorePanelViewModel f;
    public CommonPanelAdapter g;
    public com.bytedance.ee.bear.content.common.morepanel.a.InterfaceC0035a h;

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
    public final void uC(hw4.a r1) {
        this.h = r1;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        FragmentActivity r7 = getActivity();
        ArrayList<CommonMorePanelItemData> r8 = null;
        if (r7 == null) goto L5;
        CommonMorePanelViewModel r9 = (CommonMorePanelViewModel) new ViewModelProvider(r7).get(CommonMorePanelViewModel.class);
    L6:
        this.f = r9;
        CommonPanelAdapter r10 = new CommonPanelAdapter();
        this.g = r10;
        b r0 = new b(this);
        Intrinsics.checkNotNullParameter(r0, "listener");
        r10.c = r0;
        View r11 = this.e;
        if (r11 == null) goto L9;
        RecyclerView r12 = (RecyclerView) r11.findViewById(2131384937);
    L10:
        if (r12 == null) goto L12;
        r12.setLayoutManager(new LinearLayoutManager(getContext()));
    L12:
        if (r12 == null) goto L14;
        r12.setAdapter(this.g);
    L14:
        View r13 = this.e;
        if (r13 == null) goto L17;
        CommonActionPanelLayout r14 = (CommonActionPanelLayout) r13.findViewById(2131388889);
    L18:
        if (r14 == null) goto L20;
        r14.setOnActionListener(new c(this));
    L20:
        Bundle r16 = getArguments();
        if (r16 == null) goto L23;
        CommonMorePanelData r17 = (CommonMorePanelData) r16.getParcelable("panel_data");
    L24:
        if (r17 == null) goto L26;
        Boolean r1 = Boolean.valueOf(r17.b);
    L27:
        View r2 = this.e;
        if (r2 == null) goto L30;
        TextView r3 = (TextView) r2.findViewById(2131391298);
    L31:
        if (r3 != null) goto L33;
    L37:
        if (r3 == null) goto L39;
        r3.setOnClickListener(new d(this));
    L39:
        if (r17 == null) goto L41;
        r8 = r17.c;
    L41:
        View r4 = this.e;
        if (r4 == null) goto L50;
        CommonActionPanelLayout r18 = r4.findViewById(2131388889);
        if (r18 == null) goto L50;
        if (r17 == null) goto L48;
        String r19 = r17.a;
        if (r19 == null) goto L48;
    L49:
        r18.setTitle(r19);
    L48:
        r19 = "";
    L50:
        CommonPanelAdapter r20 = this.g;
        if (r20 == null) goto L55;
        if (r8 == null) goto L56;
        r20.a = r8;
        r20.notifyDataSetChanged();
        return;
    L56:
        return;
    L55:
        return;
    L33:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L35;
        int r21 = 0;
    L36:
        r3.setVisibility(r21);
        goto L37
    L35:
        r21 = 8;
        goto L36
    L30:
        r3 = null;
        goto L31
    L26:
        r1 = null;
        goto L27
    L23:
        r17 = null;
        goto L24
    L17:
        r14 = null;
        goto L18
    L9:
        r12 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131559934, r3, false);
        this.e = r5;
        return r5;
    }
}
