package eq4;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.larus.nova.R;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class i extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f473493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<AttachmentEntity> f473494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f473495c;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        g r101 = this.f473495c;
        if (r101 == null) goto L6;
        r101.i1();
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
        r100.setColor(this.f473493a.getResources().getColor(R.color.text_link_normal));
    }

    public i(Context r100, AttachmentEntity r101, List<AttachmentEntity> r102, g r103) {
        this.f473493a = r100;
        this.f473494b = r102;
        this.f473495c = r103;
    }
}
