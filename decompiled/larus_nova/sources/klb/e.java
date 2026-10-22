package klb;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e extends klb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f504032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f504033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f504034d;

    public static final class a {
    }

    public interface b {
        void b(View r100, String r101);
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof b) == true) goto L5;
        return;
    L5:
        if (a(r100) == true) goto L10;
        Log.i("OCRUrlSpan", "onClick " + this.f504033c);
        ((b) r100).b(r100, this.f504033c);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setColor(UIUtils.getColor(this.f504032b, R.color.text_link_normal));
        r100.setUnderlineText(this.f504034d);
    }

    public e(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f504032b = r100;
        this.f504033c = r101;
        this.f504034d = false;
    }
}
