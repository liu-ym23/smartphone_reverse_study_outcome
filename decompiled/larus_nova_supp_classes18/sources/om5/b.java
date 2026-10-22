package om5;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.ee.bear.sheet.cellcontent.SheetCellContentPlugin;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import db5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends ClickableSpan {
    public final /* synthetic */ BaseSegment a;
    public final /* synthetic */ c b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        com.bytedance.ee.bear.sheet.cellcontent.a r3 = this.b.g;
        if (r3 == null) goto L6;
        BaseSegment r0 = this.a;
        SheetCellContentPlugin.access$000(((SheetCellContentPlugin.a) r3).a).b(mu5.b.a(r0));
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        super.updateDrawState(r3);
        r3.setColor(((i) this.b).a.getResources().getColor(2131106616));
    }

    public b(c r1, BaseSegment r2) {
        this.b = r1;
        this.a = r2;
    }
}
