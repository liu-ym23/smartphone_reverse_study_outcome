package zm5;

import android.content.Context;
import android.text.TextPaint;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<SegmentT extends BaseSegment> extends un5.h implements h {
    public final i e;
    public final Context f;
    public SegmentT g;

    @Override // zm5.h
    public final SegmentStyle getStyle() {
        return this.g.getStyle();
    }

    public final Object clone() throws CloneNotSupportedException {
        f r0 = (f) super.clone();
        SegmentT r1 = this.g;
        if (r1 == null) goto L5;
        r0.g = (SegmentT) r1.clone();
    L5:
        return r0;
    }

    @Override // zm5.d
    public final SegmentT getSegment() {
        return this.g;
    }

    @Override // zm5.d
    /* JADX INFO: renamed from: clone */
    public final d mo752clone() throws CloneNotSupportedException {
        f r0 = (f) super.clone();
        SegmentT r1 = this.g;
        if (r1 == null) goto L5;
        r0.g = (SegmentT) r1.clone();
    L5:
        return r0;
    }

    @Override // un5.h, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        this.e.updateDrawState(r3);
        r3.setColor(this.f.getResources().getColor(2131106616));
    }

    public f(Context r1, String r2, un5.a.InterfaceC0318a r3) {
        super(r1, r2, r3);
        this.f = r1;
        this.e = new i(r1);
    }
}
