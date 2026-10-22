package zm5;

import android.content.Context;
import android.text.TextPaint;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.MentionSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends un5.e implements h {
    public final i m;
    public MentionSegment n;

    @Override // zm5.h
    public final SegmentStyle getStyle() {
        SegmentStyle r0 = this.n.getStyle();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.m.b;
    }

    public final Object clone() throws CloneNotSupportedException {
        e r0 = (e) super.clone();
        MentionSegment r1 = this.n;
        if (r1 == null) goto L5;
        r0.n = r1.clone();
    L5:
        return r0;
    }

    @Override // zm5.d
    public final BaseSegment getSegment() {
        return this.n;
    }

    @Override // zm5.d
    /* JADX INFO: renamed from: clone */
    public final d mo752clone() throws CloneNotSupportedException {
        e r0 = (e) super.clone();
        MentionSegment r1 = this.n;
        if (r1 == null) goto L5;
        r0.n = r1.clone();
    L5:
        return r0;
    }

    @Override // un5.e, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        this.m.updateDrawState(r3);
        r3.setColor(this.c.getResources().getColor(2131106616));
    }

    public e(Context r12, String r13, int r14, int r15, String r16, String r17, int r18, String r19, String r20) {
        super(r12, r13, r14, r15, r16, r17, r18, r19, r20, null);
        this.m = new i(r12);
    }

    public e(Context r1, String r2, int r3, int r4, String r5, String r6, int r7, String r8, String r9, un5.a.InterfaceC0318a r10) {
        super(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        this.m = new i(r1);
    }
}
