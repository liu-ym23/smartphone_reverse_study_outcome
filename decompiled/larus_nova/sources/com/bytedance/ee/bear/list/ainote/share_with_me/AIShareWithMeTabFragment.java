package com.bytedance.ee.bear.list.ainote.share_with_me;

import com.bytedance.ee.bear.list.ainote.AINoteTabFragment;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class AIShareWithMeTabFragment extends AINoteTabFragment {
    @Override // com.bytedance.ee.bear.list.ainote.AINoteTabFragment
    public final String ca0() {
        return "ai_notes";
    }

    @Override // com.bytedance.ee.bear.list.ainote.AINoteTabFragment
    public final String da0() {
        return "ai_share_with_me";
    }

    @Override // com.bytedance.ee.bear.list.ainote.AINoteTabFragment
    public final int getContentViewLayoutId() {
        return R.layout.list_ai_note_share_with_me;
    }

    public AIShareWithMeTabFragment() {
    }
}
