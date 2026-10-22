package com.bytedance.ee.bear.middleground.comment.input;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f1 implements com.bytedance.ee.bear.widget.w {
    public final /* synthetic */ InputComment a;

    public f1(InputComment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.widget.w
    public final void onCancel() {
        InputComment.A(this.a);
    }
}
