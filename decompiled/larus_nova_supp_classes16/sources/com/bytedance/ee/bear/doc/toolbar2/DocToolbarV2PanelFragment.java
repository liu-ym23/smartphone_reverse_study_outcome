package com.bytedance.ee.bear.doc.toolbar2;

import android.R;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.edit.component.toolbar2.AbsToolbarV2PanelFragment;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarV2Fragment;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolbarV2PanelViewModel;
import com.ss.android.lark.slideback.SlideFrameLayout;
import java.util.ArrayList;
import java.util.List;
import pz4.b;
import pz4.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocToolbarV2PanelFragment extends AbsToolbarV2PanelFragment {
    public static final /* synthetic */ int J = 0;
    public a I;

    public class a implements SlideFrameLayout.f {
        public final /* synthetic */ DocToolbarV2PanelFragment a;

        public final void c(View r1, int r2) {
        }

        public final void e(View r1) {
        }

        public a(DocToolbarV2PanelFragment r1) {
            this.a = r1;
        }

        public final void b(float r1) {
            this.a.Z90().hideToolbar();
        }
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public final BaseToolbarV2PanelViewModel<DocToolbarV2> Z90() {
        return (BaseToolbarV2PanelViewModel) q.a(this, ToolbarV2PanelViewModel.class);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.AbsToolbarV2PanelFragment, com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public final void onDestroyView() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L12;
        View r1 = r0.findViewById(R.id.content);
        if ((r1.getParent() instanceof SlideFrameLayout) == false) goto L12;
        SlideFrameLayout r2 = r1.getParent();
        a r3 = this.I;
        List r4 = r2.j;
        if (r4 == null) goto L12;
        if (r3 == null) goto L12;
        ((ArrayList) r4).remove(r3);
    L12:
        super.onDestroyView();
    }

    public DocToolbarV2PanelFragment() {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.AbsToolbarV2PanelFragment
    public final Class<? extends BaseSubToolbarV2Fragment> oa0() {
        return DocSubToolbarFragment.class;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.AbsToolbarV2PanelFragment, com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public final void fa0(ItemIdV2 r1, String r2) {
        super.fa0(r1, r2);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        this.j.postDelayed(new b(this), 100);
        if (this.I != null) goto L5;
        this.I = new a(this);
    L5:
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L11;
        View r7 = r6.findViewById(R.id.content);
        if ((r7.getParent() instanceof SlideFrameLayout) == false) goto L11;
        r7.getParent().a(this.I);
    L11:
        r4.setOnGenericMotionListener(new d());
    }
}
