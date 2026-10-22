package zm5;

import android.content.Context;
import android.text.TextPaint;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.TextSegment;

/* JADX INFO: loaded from: classes18.dex */
public final class j extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextSegment f572875c;

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
        j r100 = (j) super.a();
        TextSegment r101 = this.f572875c;
        if (r101 == null) goto L5;
        r100.f572875c = r101.clone();
    L5:
        return r100;
    }

    @Override // zm5.a
    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return c();
    }

    @Override // zm5.d
    public final BaseSegment getSegment() {
        return this.f572875c;
    }

    @Override // zm5.a, zm5.d
    /* JADX INFO: renamed from: clone */
    public final /* bridge */ /* synthetic */ d mo11005clone() throws CloneNotSupportedException {
        return c();
    }

    public j(Context r100, TextSegment r101) {
        super(r100);
        this.f572875c = r101;
    }

    @Override // zm5.a
    public final void b(TextPaint r100, SegmentStyle r101) {
        if (this.f572875c.getTextLikeSegment() != null) goto L6;
        super.b(r100, r101);
        return;
    }
}
