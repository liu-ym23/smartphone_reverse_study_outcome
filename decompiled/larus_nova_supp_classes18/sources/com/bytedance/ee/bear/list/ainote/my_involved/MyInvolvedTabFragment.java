package com.bytedance.ee.bear.list.ainote.my_involved;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.ainote.AINoteTabFragment;
import com.bytedance.ee.bear.list.sort.SortAndFilterFragment;
import dd5.s1;
import lc5.f;
import lc5.p;
import lc5.r;
import qc5.a;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MyInvolvedTabFragment extends AINoteTabFragment {
    @Override // com.bytedance.ee.bear.list.ainote.AINoteTabFragment
    public final String ca0() {
        return "ai_notes";
    }

    @Override // com.bytedance.ee.bear.list.ainote.AINoteTabFragment
    public final String da0() {
        return "my_involved";
    }

    @Override // com.bytedance.ee.bear.list.ainote.AINoteTabFragment
    public final int getContentViewLayoutId() {
        return 2131563467;
    }

    @Override // com.bytedance.ee.bear.list.ainote.AINoteTabFragment, wc5.f.a
    public final void eF() {
        ConnectionService.NetworkState r1 = this.t;
        if (r1 != null) goto L5;
    L7:
        Context r2 = ((LazyBaseFragment) this).g;
        Toast.showFailureText(r2, r2.getString(2131887789), 0);
        return;
    L5:
        if (r1.a() == false) goto L7;
        a.j();
        p r3 = new p("ccm_space_drive_page_click", "ai_notes", "none", "filter", "ccm_space_header_filter_view", "", e.o.b, "", "", false, false, false, 0, null, "", null);
        f.a.I(r3);
        Bundle r4 = getArguments();
        r4.putString("key_module", "ai_notes");
        r4.putString("key_token", "my_involved");
        r4.putParcelable("key_sort_strategy", this.v);
        r4.putBoolean("key_sort_filter_enable", false);
        r4.putBoolean("key_filter_folder", true);
        ActionSheetDialogFragment.ba0(getActivity(), SortAndFilterFragment.class, r4);
    }

    @Override // com.bytedance.ee.bear.list.ainote.AINoteTabFragment
    public final void ea0() {
        super.ea0();
        if (this.o.getSortView() == null) goto L11;
        TextView r0 = this.o.a;
        if (r0 == null) goto L7;
        r0.setOnClickListener(null);
    L7:
        AppCompatImageView r1 = this.o.d;
        if (r1 == null) goto L12;
        r1.setVisibility(8);
        return;
    L12:
        return;
    }

    public MyInvolvedTabFragment() {
    }

    @Override // com.bytedance.ee.bear.list.ainote.AINoteTabFragment, wc5.f.a
    public final void WU(boolean r15) {
        Mj(r15);
        s1.a.a.f((d) org.koin.java.a.a(d.class), r15, "ai_notes");
        a.j();
        r r16 = new r("ccm_space_drive_page_click", "ai_notes", "none", "", e.e.b, false, false, false, 0, "");
        f.a.O(r16);
    }
}
