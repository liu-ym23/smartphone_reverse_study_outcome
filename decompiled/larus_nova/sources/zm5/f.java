package zm5;

import android.content.Context;
import android.text.TextPaint;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class f<SegmentT extends BaseSegment> extends un5.h implements h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f572869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f572870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SegmentT f572871g;

    @Override // zm5.h
    public final SegmentStyle getStyle() {
        return this.f572871g.getStyle();
    }

    public final Object clone() throws CloneNotSupportedException {
        f r100 = (f) super.clone();
        SegmentT r101 = this.f572871g;
        if (r101 == null) goto L5;
        r100.f572871g = (SegmentT) r101.clone();
    L5:
        return r100;
    }

    @Override // zm5.d
    public final SegmentT getSegment() {
        return this.f572871g;
    }

    @Override // zm5.d
    /* JADX INFO: renamed from: clone */
    public final d mo11005clone() throws CloneNotSupportedException {
        f r100 = (f) super.clone();
        SegmentT r101 = this.f572871g;
        if (r101 == null) goto L5;
        r100.f572871g = (SegmentT) r101.clone();
    L5:
        return r100;
    }

    @Override // un5.h, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        this.f572869e.updateDrawState(r100);
        r100.setColor(this.f572870f.getResources().getColor(R.color.text_link_normal));
    }

    public f(Context r100, String r101, un5.a.InterfaceC7903a r102) {
        super(r100, r101, r102);
        this.f572870f = r100;
        this.f572869e = new i(r100);
    }
}
