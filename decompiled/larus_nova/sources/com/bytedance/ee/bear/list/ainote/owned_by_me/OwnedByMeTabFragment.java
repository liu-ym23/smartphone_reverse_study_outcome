package com.bytedance.ee.bear.list.ainote.owned_by_me;

import com.bytedance.ee.bear.list.ainote.AINoteTabFragment;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class OwnedByMeTabFragment extends AINoteTabFragment {
    @Override // com.bytedance.ee.bear.list.ainote.AINoteTabFragment
    public final String ca0() {
        return "ai_notes";
    }

    @Override // com.bytedance.ee.bear.list.ainote.AINoteTabFragment
    public final String da0() {
        return "owned_by_me";
    }

    @Override // com.bytedance.ee.bear.list.ainote.AINoteTabFragment
    public final int getContentViewLayoutId() {
        return R.layout.list_ai_note_personal;
    }

    public OwnedByMeTabFragment() {
    }

    @Override // com.bytedance.ee.bear.list.ainote.AINoteTabFragment, dd5.p1
    public final void Mj(boolean r100) {
        this.f227613o.b(r100);
    }
}
