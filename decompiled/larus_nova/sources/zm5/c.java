package zm5;

import android.content.Context;
import android.text.TextPaint;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.PanoSegment;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f572865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PanoSegment f572866d;

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

    public final c c() throws CloneNotSupportedException {
        c r100 = (c) super.a();
        PanoSegment r101 = this.f572866d;
        if (r101 == null) goto L5;
        r100.f572866d = r101.clone();
    L5:
        return r100;
    }

    @Override // zm5.a
    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return c();
    }

    @Override // zm5.d
    public final BaseSegment getSegment() {
        return this.f572866d;
    }

    @Override // zm5.a, zm5.d
    /* JADX INFO: renamed from: clone */
    public final /* bridge */ /* synthetic */ d mo11005clone() throws CloneNotSupportedException {
        return c();
    }

    @Override // zm5.a, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        super.updateDrawState(r100);
        r100.setColor(this.f572865c.getResources().getColor(R.color.text_link_normal));
    }

    public c(Context r100, PanoSegment r101) {
        super(r100);
        this.f572865c = r100;
        this.f572866d = r101;
    }
}
