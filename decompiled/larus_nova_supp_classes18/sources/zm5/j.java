package zm5;

import android.content.Context;
import android.text.TextPaint;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.TextSegment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends a {
    public TextSegment c;

    @Override // zm5.d, un5.i
    public final boolean E() {
        return true;
    }

    @Override // zm5.d
    public final boolean g1() {
        return true;
    }

    @Override // zm5.a
    public final /* bridge */ /* synthetic */ a a() throws CloneNotSupportedException {
        return c();
    }

    public final j c() throws CloneNotSupportedException {
        j r0 = (j) super.a();
        TextSegment r1 = this.c;
        if (r1 == null) goto L5;
        r0.c = r1.clone();
    L5:
        return r0;
    }

    @Override // zm5.a
    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return c();
    }

    @Override // zm5.d
    public final BaseSegment getSegment() {
        return this.c;
    }

    @Override // zm5.a, zm5.d
    /* JADX INFO: renamed from: clone */
    public final /* bridge */ /* synthetic */ d mo752clone() throws CloneNotSupportedException {
        return c();
    }

    public j(Context r1, TextSegment r2) {
        super(r1);
        this.c = r2;
    }

    @Override // zm5.a
    public final void b(TextPaint r2, SegmentStyle r3) {
        if (this.c.getTextLikeSegment() != null) goto L6;
        super.b(r2, r3);
        return;
    }
}
