package zm5;

import android.content.Context;
import android.text.TextPaint;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.MentionSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import un5.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends l implements h {
    public final i s;
    public MentionSegment t;

    @Override // zm5.h
    public final SegmentStyle getStyle() {
        SegmentStyle r0 = this.t.getStyle();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.s.b;
    }

    public final Object clone() throws CloneNotSupportedException {
        g r0 = (g) super.clone();
        MentionSegment r1 = this.t;
        if (r1 == null) goto L5;
        r0.t = r1.clone();
    L5:
        return r0;
    }

    @Override // zm5.d
    public final BaseSegment getSegment() {
        return this.t;
    }

    @Override // zm5.d
    /* JADX INFO: renamed from: clone */
    public final d mo752clone() throws CloneNotSupportedException {
        g r0 = (g) super.clone();
        MentionSegment r1 = this.t;
        if (r1 == null) goto L5;
        r0.t = r1.clone();
    L5:
        return r0;
    }

    @Override // un5.l, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        this.s.updateDrawState(r3);
        r3.setColor(this.c.getResources().getColor(2131106616));
    }

    public g(Context r1, String r2, String r3, String r4, boolean r5, String r6) {
        super(r1, r2, r3, r4, r5, r6);
        this.s = new i(r1);
    }

    public g(Context r1, String r2, String r3, String r4, boolean r5, String r6, boolean r7, String r8, un5.a.InterfaceC0318a r9) {
        super(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        this.s = new i(r1);
    }
}
