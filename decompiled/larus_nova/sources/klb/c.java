package klb;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends klb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f504029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f504030c;

    public interface a {
        void a(View r100, String r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof a) == true) goto L5;
        return;
    L5:
        if (a(r100) == true) goto L10;
        ((a) r100).a(r100, this.f504030c);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setColor(UIUtils.getColor(this.f504029b, R.color.text_link_normal));
        r100.setUnderlineText(false);
    }

    public c(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "phone");
        this.f504029b = r100;
        this.f504030c = r101;
    }
}
