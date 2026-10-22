package com.ss.android.lark.widget.light.span;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.UrlInfo;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class q extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UrlInfo f446283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f446284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<Context> f446285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f446286d;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        if (this.f446284b == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f446283a.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f446284b == r101.f446284b) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f446283a, r101.f446283a) == true) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof mcc.m) == true) goto L6;
        return;
    L6:
        if (r100.getTag(R.id.tag_long_press) == null) goto L10;
        r100.setTag(R.id.tag_long_press, null);
        if (((mcc.o) r100).t(r100, this.f446283a) == false) goto L16;
        r100.performHapticFeedback(0);
        return;
    L16:
        return;
    L10:
        long r101 = SystemClock.uptimeMillis();
        long r102 = r101 - this.f446286d;
        this.f446286d = r101;
        if (r102 >= 500) goto L14;
        Log.d("UrlClickSpan", "url click elapsed too short");
        return;
    L14:
        ((mcc.o) r100).r(r100, this.f446283a);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        Context r101 = this.f446285c.get();
        if (r101 == null) goto L5;
        int r102 = UIUtils.getColor(r101, R.color.text_link_normal);
    L6:
        r100.setColor(r102);
        r100.setUnderlineText(this.f446284b);
        return;
    L5:
        r102 = UIHelper.getColor(R.color.lkui_B700);
        goto L6
    }

    public q(UrlInfo r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "urlInfo");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f446283a = r100;
        this.f446284b = false;
        this.f446285c = new WeakReference(r101);
    }
}
