package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class LinkSpan extends URLSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final msc.s f492297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f492298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final lsc.d f492299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f492300d;

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View r100) {
        this.f492299c.d(r100, this.f492298b);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        msc.s r101 = this.f492297a;
        r100.setUnderlineText(r101.f515542b);
        int r102 = r101.f515541a;
        if (r102 == 0) goto L5;
        r100.setColor(r102);
        return;
    L5:
        r100.setColor(r100.linkColor);
    }

    public LinkSpan(msc.s r100, String r101, Map<String, String> r102, lsc.d r103) {
        super(r101);
        this.f492297a = r100;
        this.f492298b = r101;
        if (r102 != null) goto L6;
        r102 = Collections.emptyMap();
    L6:
        this.f492300d = r102;
        this.f492299c = r103;
    }
}
