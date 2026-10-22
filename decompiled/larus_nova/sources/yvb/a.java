package yvb;

import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.PrefixInfo;
import com.ss.android.lark.widget.span.PrefixSpan;
import com.ss.android.lark.widget.span.SpanInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f569312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f569313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<SpanInfo> f569314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f569315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a f569316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f569317f;

    public final String b() {
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a r100 = this.f569316e;
        if (r100 == null) goto L9;
        StringBuilder r101 = r100.f435768f;
        if (r101 == null) goto L9;
        String r102 = r101.toString();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return this.f569312a;
    }

    public final void a(int r110) {
        List<SpanInfo> r100 = this.f569314c;
        int r101 = e.f569330a;
        int r102 = b().length();
        String r103 = b();
        d r104 = this.f569313b;
        Intrinsics.checkNotNullParameter(r103, "text");
        Intrinsics.checkNotNullParameter(r104, "style");
        r104.getClass();
        if (r110 >= 1) goto L5;
    L8:
        d.b r105 = null;
    L9:
        PrefixSpan.b r106 = new PrefixSpan.b();
        r106.f448587b = true;
        float r107 = 5.0f;
        r106.f448588c = UIHelper.dp2px(((r110 - 1) * 24.0f) + 5.0f);
        r106.f448591f = UIHelper.dp2px(16.0f);
        if (r105 == null) goto L14;
        Float r108 = r105.f569328b;
        if (r108 == null) goto L14;
        r107 = r108.floatValue();
    L18:
        r106.f448589d = UIHelper.dp2px(r107);
        if (r105 == null) goto L23;
        Integer r109 = r105.f569329c;
        if (r109 == null) goto L23;
        int r111 = r109.intValue();
    L27:
        r106.f448593h = r111;
        if (r105 == null) goto L31;
        PrefixSpan.Type r112 = r105.f569327a;
        if (r112 == null) goto L31;
    L37:
        r106.f448586a = r112;
        PrefixInfo r113 = new PrefixInfo(r106);
        r113.type = 12;
        r113.start = 0;
        r113.end = r102;
        r113.text = r103;
        ((ArrayList) r100).add(r113);
        return;
    L31:
        if (r110 == 1) goto L35;
        if (r110 == 2) goto L34;
        PrefixSpan.Type r114 = PrefixSpan.Type.FILL_RECT;
    L36:
        r112 = r114;
        goto L37
    L34:
        r114 = PrefixSpan.Type.HOLLOW_CIRCLE;
        goto L36
    L35:
        r114 = PrefixSpan.Type.FILL_CIRCLE;
    L23:
        Integer r115 = r104.f569323b;
        if (r115 == null) goto L26;
        r111 = r115.intValue();
        goto L27
    L26:
        LarkAppContext.Companion.getClass();
        r111 = UDColorUtils.getColor(LarkAppContext.access$getInstance$cp().getContext(), R.color.text_title);
    L14:
        if (r110 == 1) goto L18;
        if (r110 == 2) goto L17;
        r107 = 3.0f;
        goto L18
    L17:
        r107 = 4.0f;
        goto L18
    L5:
        if (r110 > 3) goto L8;
        r105 = r104.f569325d.get(Integer.valueOf(r110));
        goto L9
    }

    public a(String r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceText");
        Intrinsics.checkNotNullParameter(r101, "style");
        this.f569312a = r100;
        this.f569313b = r101;
        this.f569314c = new ArrayList();
    }
}
