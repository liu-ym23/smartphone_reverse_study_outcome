package zm5;

import android.content.Context;
import android.text.TextPaint;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.AttachmentSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f572863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AttachmentSegment f572864d;

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
        b r100 = (b) super.a();
        AttachmentSegment r101 = this.f572864d;
        if (r101 == null) goto L5;
        r100.f572864d = r101.clone();
    L5:
        return r100;
    }

    @Override // zm5.a
    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return c();
    }

    @Override // zm5.d
    public final BaseSegment getSegment() {
        return this.f572864d;
    }

    @Override // zm5.a, zm5.d
    /* JADX INFO: renamed from: clone */
    public final /* bridge */ /* synthetic */ d mo11005clone() throws CloneNotSupportedException {
        return c();
    }

    @Override // zm5.a, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        super.updateDrawState(r100);
        r100.setColor(this.f572863c.getResources().getColor(R.color.text_link_normal));
    }

    public b(Context r100, AttachmentSegment r101) {
        super(r100);
        this.f572863c = r100;
        this.f572864d = r101;
    }
}
