package p8a;

import com.lynx.markdown.ServalMarkdownView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* JADX INFO: loaded from: classes32.dex */
public final class d extends ServalMarkdownView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShadowNode f528234a;

    @Override // com.lynx.markdown.MarkdownView, com.lynx.markdown.IMarkdownViewHandle
    public final void requestAlign() {
        super.requestAlign();
        ShadowNode r100 = this.f528234a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.q();
    }

    @Override // com.lynx.markdown.MarkdownView, com.lynx.markdown.IMarkdownViewHandle
    public final void requestMeasure() {
        super.requestMeasure();
        ShadowNode r100 = this.f528234a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.q();
    }

    public d(LynxContext r100, ShadowNode r101) {
        super(r100);
        this.f528234a = r101;
    }
}
