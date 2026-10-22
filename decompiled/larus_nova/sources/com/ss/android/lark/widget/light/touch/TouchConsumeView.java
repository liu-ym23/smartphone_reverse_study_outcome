package com.ss.android.lark.widget.light.touch;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.select.SelectableView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 )2\u00020\u0001:\u0003'()B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\u0015\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u000bH\u0000¢\u0006\u0002\b#J\u0012\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010¨\u0006*"}, d2 = {"Lcom/ss/android/lark/widget/light/touch/TouchConsumeView;", "Lcom/ss/android/lark/widget/select/SelectableView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mDontConsumeNonUrlClicks", "", "linkHit", "getLinkHit$linked_emoji_release", "()Z", "setLinkHit$linked_emoji_release", "(Z)V", "stateNormalClickWillTrigger", "stateWaitingForLongPressTrigger", "stateTouchMoving", "mPositionDownStartX", "mPositionDownStartY", "mConsumedSpanEvent", "getMConsumedSpanEvent", "setMConsumedSpanEvent", "scrollTo", "", "x", "y", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "hasFocus", "setConsumeNonSpanClicks", "consume", "setConsumeNonSpanClicks$linked_emoji_release", "setOnLongClickListener", "l", "Landroid/view/View$OnLongClickListener;", "TouchConsumeMovementMethod", "IClickHandler", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class TouchConsumeView extends SelectableView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f446287j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f446288k = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f446289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f446290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f446291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f446292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f446293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f446294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f446295h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f446296i;

    public static final class a {
    }

    public interface b {
        void a(TouchConsumeView r100);
    }

    public static final class c extends LinkMovementMethod {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static c f446297c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f446298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f446299b;

        public static final class a {
            public static c a() {
                if (c.f446297c != null) goto L5;
                c.f446297c = new c();
            L5:
                c r100 = c.f446297c;
                Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.light.touch.TouchConsumeView.TouchConsumeMovementMethod");
                return r100;
            }
        }

        static {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public final boolean onTouchEvent(TextView r100, Spannable r101, MotionEvent r102) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            Intrinsics.checkNotNullParameter(r101, "buffer");
            Intrinsics.checkNotNullParameter(r102, "event");
            return false;
        }

        public c() {
        }

        public static boolean a(int r100, Object r101, Spanned r102) {
            Character r103 = StringsKt.getOrNull(r102, r100);
            if (r103 != null) goto L5;
        L12:
            return false;
        L5:
            if (r103.charValue() == '\n') goto L7;
            return false;
        L7:
            int r104 = r102.getSpanEnd(r101);
            if (r102.getSpanFlags(r101) != 33) goto L12;
            if (r104 != r100) goto L12;
            return true;
        }

        @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public final boolean onGenericMotionEvent(TextView r100, Spannable r101, MotionEvent r102) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            Intrinsics.checkNotNullParameter(r101, "text");
            Intrinsics.checkNotNullParameter(r102, "event");
            return super.onGenericMotionEvent(r100, r101, r102);
        }

        public static int b(View r100, Layout r101, int r102, int r103) {
            if ((r100 instanceof LKUILightTextView) == false) goto L5;
            int r104 = (int) ((LKUILightTextView) r100).getTotalPaddingLeft();
        L6:
            int r105 = r103 - r100.getPaddingTop();
            float r106 = (r102 - r104) + r100.getScrollX();
            int r107 = r101.getOffsetForHorizontal(r101.getLineForVertical(r105 + r100.getScrollY()), r106);
            if (r101.getPrimaryHorizontal(r107) >= r106) goto L9;
            return r107;
        L9:
            return r107 - 1;
        L5:
            r104 = r100.getPaddingLeft();
            goto L6
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return false;
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
    }

    static {
        f446287j = ViewConfiguration.getLongPressTimeout();
    }

    public final boolean getLinkHit$linked_emoji_release() {
        return this.f446290c;
    }

    public final boolean getMConsumedSpanEvent() {
        return this.f446296i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f446290c = false;
        boolean r101 = super.onTouchEvent(r100);
        if (this.f446289b == true) goto L9;
        boolean r102 = this.f446290c;
        if (r102 == true) goto L8;
        return r101;
    L8:
        return r102;
    L9:
        return this.f446290c;
    }

    public final void setConsumeNonSpanClicks$linked_emoji_release(boolean r100) {
        this.f446289b = !r100;
    }

    public final void setLinkHit$linked_emoji_release(boolean r100) {
        this.f446290c = r100;
    }

    public final void setMConsumedSpanEvent(boolean r100) {
        this.f446296i = r100;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        this.f446289b = false;
        super.setOnLongClickListener(r100);
    }

    public TouchConsumeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f446289b = true;
    }

    public /* synthetic */ TouchConsumeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
