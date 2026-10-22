package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements RecordPanelView.b {
    public final /* synthetic */ AsideInputComment a;

    @Override // com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView.b
    public final void a() {
        this.a.j0(true, null);
    }

    public m(AsideInputComment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView.b
    public final void b(boolean r4) {
        tt5.a.h(this.a.i0, "onRecordStatusChanged: " + r4);
    }
}
