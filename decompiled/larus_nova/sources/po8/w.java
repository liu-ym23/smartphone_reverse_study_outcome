package po8;

import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.view.RiskTipsTextView;
import com.larus.bmhome.utils.c3;
import com.larus.nova.R;
import com.larus.utils.y0;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import tx9.x1;

/* JADX INFO: loaded from: classes26.dex */
public final class w extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f530129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RiskTipsTextView f530130b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        int r101 = c3.f314983a;
        if (c3.a(this.f530129a) == false) goto L9;
        Uri r102 = y0.j(this.f530129a);
        if (r102 == null) goto L7;
        String r103 = UriProtector.getQueryParameter(r102, "pc_guide_scene");
    L8:
        x1.e(r103, null, null, null, null, null, 126);
        goto L9
    L7:
        r103 = null;
    L9:
        com.larus.platform.service.q.f365787a.e(this.f530130b.getContext(), com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", this.f530129a), TuplesKt.to("enable_bottom_share_style", "1")}), null);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
        r100.setColor(ContextCompat.getColor(this.f530130b.getContext(), v19.c.b(R.attr.larus_primary_60, this.f530130b.getContext(), R.color.larus_primary_60)));
    }

    public w(String r100, RiskTipsTextView r101) {
        this.f530129a = r100;
        this.f530130b = r101;
    }
}
