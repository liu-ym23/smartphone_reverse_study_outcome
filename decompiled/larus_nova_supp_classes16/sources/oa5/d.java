package oa5;

import com.bytedance.ee.bear.edit.component.richtexteditor.RichTextEditorWebView;
import tb5.n;
import vv4.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends j {
    public final wv4.a c;

    @Override // vv4.j, vv4.k
    public final n getBridge() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(RichTextEditorWebView r1, at5.a r2) {
        super(r1, r2);
        wv4.a r3 = new wv4.a(this);
        this.c = r3;
        r3.b = new b(this);
    }
}
