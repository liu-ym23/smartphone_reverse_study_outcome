package com.bytedance.live.richcontent.widget;

import ak6.f;
import ak6.g;
import android.content.Context;
import android.graphics.Canvas;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import ek6.d;
import ek6.e;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/live/richcontent/widget/RichContentTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lak6/b;", "engine", "", "setEngine", "Lak6/f;", "config", "setConfig", "Lek6/e;", "richContent", "setRichContent", "Lnk6/a;", "listener", "setRichContentClickListener", "", "intervalTimeInMs", "setAnimUpdateIntervalInMs", "Lak6/g;", "spanRendResult", "setSpanRendResult", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "richcontent_release"}, k = 1, mv = {1, 4, 2})
public final class RichContentTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ak6.b f255806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f255807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ak6.a f255808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f255809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f255810e;

    public static final class a extends Spannable.Factory {
        public a() {
        }

        @Override // android.text.Spannable.Factory
        public final Spannable newSpannable(CharSequence r100) {
            if ((r100 instanceof SpannableString) == false) goto L7;
            return (Spannable) r100;
        L7:
            return super.newSpannable(r100);
        }
    }

    public static final class b {
    }

    static {
    }

    public RichContentTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RichContentTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
        if (this.f255809d == false) goto L8;
        long r101 = this.f255810e;
        if (r101 <= 0) goto L9;
        postInvalidateDelayed(r101);
        return;
    L9:
        return;
    }

    public final void setAnimUpdateIntervalInMs(long r100) {
        this.f255810e = r100;
    }

    public final void setConfig(f r100) {
        this.f255807b = r100;
    }

    public final void setEngine(ak6.b r100) {
        this.f255806a = r100;
    }

    public final void setRichContent(e r100) {
        Intrinsics.checkNotNullParameter(r100, "richContent");
        f r101 = this.f255807b;
        if (r101 != null) goto L6;
        r101 = new f(false, false);
    L6:
        Intrinsics.checkNotNullParameter(r100, "richContent");
        Intrinsics.checkNotNullParameter(r101, "config");
        ak6.b r102 = this.f255806a;
        if (r102 == null) goto L13;
        ak6.a r103 = this.f255808c;
        if (r103 == null) goto L11;
        r103.dispose();
    L11:
        this.f255808c = r102.a().c(r100, r101, new nk6.b(this));
        return;
    }

    public final void setRichContentClickListener(nk6.a r100) {
        setOnClickListener(r100);
    }

    public final void setSpanRendResult(g r100) {
        Intrinsics.checkNotNullParameter(r100, "spanRendResult");
        e r101 = r100.f4076c;
        Intrinsics.checkNotNullParameter(r101, "$this$hasAnimation");
        Iterator<T> r102 = r101.f472943a.iterator();
    L3:
        SpannableString r103 = null;
        if (r102.hasNext() == false) goto L8;
        Object r104 = r102.next();
        if (((d) r104).a() == false) goto L3;
    L10:
        if (r104 == null) goto L12;
        boolean r105 = true;
    L13:
        this.f255809d = r105;
        SpannableString r106 = r100.f4074a;
        if ((true ^ Intrinsics.areEqual(r106, getText())) == false) goto L16;
        r103 = r106;
    L16:
        if (r103 == null) goto L22;
        super.setText(r103, TextView.BufferType.SPANNABLE);
        return;
    L22:
        return;
    L12:
        r105 = false;
        goto L13
    L8:
        r104 = null;
        goto L10
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        super.setText(r100, r101);
        ak6.a r102 = this.f255808c;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        this.f255809d = false;
    }

    public RichContentTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f255810e = 50;
        setMovementMethod(new LinkMovementMethod());
        setHighlightColor(0);
        setSpannableFactory(new a());
    }

    public /* synthetic */ RichContentTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
