package un5;

import android.content.Context;
import android.text.TextPaint;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class h extends un5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f550804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f550805d;

    public static final class a {
    }

    static {
    }

    @Override // un5.i
    public final boolean E() {
        return true;
    }

    public final boolean g1() {
        return false;
    }

    public final Context getContext() {
        return this.f550804c;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
        int r101 = this.f550773b;
        if (r101 == (-1)) goto L5;
        r100.setColor(r101);
        return;
    L5:
        r100.setColor(this.f550804c.getResources().getColor(R.color.text_link_normal));
    }

    public h(Context r100, String r101, un5.a.InterfaceC7903a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "href");
        this.f550804c = r100;
        this.f550805d = r101;
        this.f550772a = r102;
    }
}
