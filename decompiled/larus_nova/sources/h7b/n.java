package h7b;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public abstract class n extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f484048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f484049b;

    public n(Context r100) {
        this.f484048a = R.color.text_link_normal;
        this.f484049b = r100;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        r100.setColor(UIUtils.getColor(this.f484049b, this.f484048a));
    }

    public n(Context r100, int r101) {
        this.f484049b = r100;
        this.f484048a = r101;
    }
}
