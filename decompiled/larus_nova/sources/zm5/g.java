package zm5;

import android.content.Context;
import android.text.TextPaint;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.MentionSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.larus.nova.R;
import un5.l;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends l implements h {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final i f572872s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public MentionSegment f572873t;

    @Override // zm5.h
    public final SegmentStyle getStyle() {
        SegmentStyle r100 = this.f572873t.getStyle();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.f572872s.f572862b;
    }

    public final Object clone() throws CloneNotSupportedException {
        g r100 = (g) super.clone();
        MentionSegment r101 = this.f572873t;
        if (r101 == null) goto L5;
        r100.f572873t = r101.clone();
    L5:
        return r100;
    }

    @Override // zm5.d
    public final BaseSegment getSegment() {
        return this.f572873t;
    }

    @Override // zm5.d
    /* JADX INFO: renamed from: clone */
    public final d mo11005clone() throws CloneNotSupportedException {
        g r100 = (g) super.clone();
        MentionSegment r101 = this.f572873t;
        if (r101 == null) goto L5;
        r100.f572873t = r101.clone();
    L5:
        return r100;
    }

    @Override // un5.l, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        this.f572872s.updateDrawState(r100);
        r100.setColor(this.f550814c.getResources().getColor(R.color.text_link_normal));
    }

    public g(Context r100, String r101, String r102, String r103, boolean r104, String r105) {
        super(r100, r101, r102, r103, r104, r105);
        this.f572872s = new i(r100);
    }

    public g(Context r100, String r101, String r102, String r103, boolean r104, String r105, boolean r106, String r107, un5.a.InterfaceC7903a r108) {
        super(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        this.f572872s = new i(r100);
    }
}
