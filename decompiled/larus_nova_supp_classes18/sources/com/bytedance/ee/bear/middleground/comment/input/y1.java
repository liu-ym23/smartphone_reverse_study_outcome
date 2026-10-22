package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y1 implements RecordPanelView.b {
    public final /* synthetic */ InputCommentV2 a;

    @Override // com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView.b
    public final void a() {
        this.a.j0(true, null);
    }

    public y1(InputCommentV2 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView.b
    public final void b(boolean r4) {
        tt5.a.h(this.a.i0, "onRecordStatusChanged: " + r4);
    }
}
