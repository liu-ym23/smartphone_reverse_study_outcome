package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k1 implements RecordPanelView.b {
    public final /* synthetic */ InputComment a;

    @Override // com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView.b
    public final void a() {
        this.a.Q(true, null);
    }

    public k1(InputComment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView.b
    public final void b(boolean r3) {
        tt5.a.h("Comment#InputComment", "onRecordStatusChanged: " + r3);
    }
}
