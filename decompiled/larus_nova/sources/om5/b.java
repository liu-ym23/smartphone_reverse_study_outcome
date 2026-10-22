package om5;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.ee.bear.sheet.cellcontent.SheetCellContentPlugin;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSegment f524293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f524294b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        com.bytedance.ee.bear.sheet.cellcontent.a r101 = this.f524294b.f524295g;
        if (r101 == null) goto L6;
        BaseSegment r102 = this.f524293a;
        SheetCellContentPlugin.access$000(((SheetCellContentPlugin.a) r101).f237420a).b(mu5.b.a(r102));
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        super.updateDrawState(r100);
        r100.setColor(this.f524294b.f467820a.getResources().getColor(R.color.text_link_normal));
    }

    public b(c r100, BaseSegment r101) {
        this.f524294b = r100;
        this.f524293a = r101;
    }
}
