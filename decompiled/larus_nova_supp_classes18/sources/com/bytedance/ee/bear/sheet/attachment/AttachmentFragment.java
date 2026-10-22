package com.bytedance.ee.bear.sheet.attachment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ee.bear.sheet.fab.FabItemEnum;
import com.bytedance.ee.bear.sheet.fab.FabViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AttachmentFragment extends BaseFragment implements View.OnClickListener {
    public static final /* synthetic */ int i = 0;
    public AttachmentViewModel e;
    public sa5.b f;
    public SheetDragView g;
    public float h;

    public final boolean onBackPressed() {
        this.e.closeAttachmentPanel();
        return true;
    }

    public AttachmentFragment() {
        this.h = 0.0f;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e.closeAttachmentPanel();
        sa5.b r0 = this.f;
        if (r0 == null) goto L6;
        r0.d(this);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        FabViewModel r0 = (FabViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, FabViewModel.class);
        if (r5.getId() != 2131386185) goto L6;
        this.e.closeAttachmentPanel();
        r0.clickItem(FabItemEnum.operation.name(), null);
        return;
    L6:
        if (r5.getId() != 2131386174) goto L10;
        this.e.closeAttachmentPanel();
        r0.clickItem(FabItemEnum.input.name(), null);
        return;
    }

    public final void onConfigurationChanged(Configuration r1) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r1);
        this.e.closeAttachmentPanel();
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.e = (AttachmentViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, AttachmentViewModel.class);
    }

    public final void onViewCreated(final View r5, Bundle r6) {
        super.onViewCreated(r5, r6);
        r5.findViewById(2131363350).setOnClickListener(new a(this));
        r5.findViewById(2131386185).setOnClickListener(new g(this));
        r5.findViewById(2131386174).setOnClickListener(new g(this));
        final FabViewModel r7 = (FabViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, FabViewModel.class);
        r7.getTopItems().observe(getViewLifecycleOwner(), new b(r5, r7));
        final RecyclerView r8 = r5.findViewById(2131363346);
        final AttachmentListAdapter r0 = new AttachmentListAdapter();
        r0.b = new c(this);
        r8.setLayoutManager(new LinearLayoutManager(getActivity()));
        r8.setAdapter(r0);
        this.g = (SheetDragView) r5.findViewById(2131363349);
        float r9 = com.bytedance.ee.util.ui.n.t();
        if (this.e.isVCFollow() == false) goto L5;
        float r1 = 0.6f;
    L6:
        this.h = r9 * r1;
        SheetDragView r10 = this.g;
        float r2 = com.bytedance.ee.util.ui.n.t() * 0.4f;
        float r3 = this.h;
        r10.y = 0.0f;
        r10.z = r2;
        r10.A = r3;
        r10.x.m(0.0f, r2, r3);
        this.g.addOnLayoutChangeListener(new d(this, r8));
        this.g.setOnCloseListener(new e(this));
        this.e.getAttachmentList().observe(getViewLifecycleOwner(), new f(this, r0, r8));
        return;
    L5:
        r1 = 0.75f;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        sa5.b r5 = (sa5.b) sa5.m.a.a(getActivity(), sa5.b.class);
        this.f = r5;
        if (r5 == null) goto L6;
        r5.e(this);
    L6:
        return r2.inflate(2131564522, r3, false);
    }
}
