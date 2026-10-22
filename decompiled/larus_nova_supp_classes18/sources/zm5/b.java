package zm5;

import android.content.Context;
import android.text.TextPaint;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.AttachmentSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends a {
    public final Context c;
    public AttachmentSegment d;

    @Override // zm5.d, un5.i
    public final boolean E() {
        return false;
    }

    @Override // zm5.d
    public final boolean g1() {
        return false;
    }

    @Override // zm5.a
    public final /* bridge */ /* synthetic */ a a() throws CloneNotSupportedException {
        return c();
    }

    public final b c() throws CloneNotSupportedException {
        b r0 = (b) super.a();
        AttachmentSegment r1 = this.d;
        if (r1 == null) goto L5;
        r0.d = r1.clone();
    L5:
        return r0;
    }

    @Override // zm5.a
    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return c();
    }

    @Override // zm5.d
    public final BaseSegment getSegment() {
        return this.d;
    }

    @Override // zm5.a, zm5.d
    /* JADX INFO: renamed from: clone */
    public final /* bridge */ /* synthetic */ d mo752clone() throws CloneNotSupportedException {
        return c();
    }

    @Override // zm5.a, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        super.updateDrawState(r3);
        r3.setColor(this.c.getResources().getColor(2131106616));
    }

    public b(Context r1, AttachmentSegment r2) {
        super(r1);
        this.c = r1;
        this.d = r2;
    }
}
