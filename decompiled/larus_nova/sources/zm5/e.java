package zm5;

import android.content.Context;
import android.text.TextPaint;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.MentionSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends un5.e implements h {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final i f572867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MentionSegment f572868n;

    @Override // zm5.h
    public final SegmentStyle getStyle() {
        SegmentStyle r100 = this.f572868n.getStyle();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.f572867m.f572862b;
    }

    public final Object clone() throws CloneNotSupportedException {
        e r100 = (e) super.clone();
        MentionSegment r101 = this.f572868n;
        if (r101 == null) goto L5;
        r100.f572868n = r101.clone();
    L5:
        return r100;
    }

    @Override // zm5.d
    public final BaseSegment getSegment() {
        return this.f572868n;
    }

    @Override // zm5.d
    /* JADX INFO: renamed from: clone */
    public final d mo11005clone() throws CloneNotSupportedException {
        e r100 = (e) super.clone();
        MentionSegment r101 = this.f572868n;
        if (r101 == null) goto L5;
        r100.f572868n = r101.clone();
    L5:
        return r100;
    }

    @Override // un5.e, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        this.f572867m.updateDrawState(r100);
        r100.setColor(this.f550785c.getResources().getColor(R.color.text_link_normal));
    }

    public e(Context r110, String r111, int r112, int r113, String r114, String r115, int r116, String r117, String r210) {
        super(r110, r111, r112, r113, r114, r115, r116, r117, r210, null);
        this.f572867m = new i(r110);
    }

    public e(Context r100, String r101, int r102, int r103, String r104, String r105, int r106, String r107, String r108, un5.a.InterfaceC7903a r110) {
        super(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110);
        this.f572867m = new i(r100);
    }
}
