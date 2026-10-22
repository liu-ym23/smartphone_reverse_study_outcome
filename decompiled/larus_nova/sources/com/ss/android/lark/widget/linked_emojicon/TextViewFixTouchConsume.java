package com.ss.android.lark.widget.linked_emojicon;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes38.dex */
public abstract class TextViewFixTouchConsume extends EllipsizedEmojiconTextView {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f446342r = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f446343k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f446344l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f446345m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f446346n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f446347o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f446348p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f446349q;

    public static class a extends LinkMovementMethod {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static a f446350c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f446351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f446352b;

        /* JADX INFO: renamed from: com.ss.android.lark.widget.linked_emojicon.TextViewFixTouchConsume$a$a, reason: collision with other inner class name */
        public class C5399a extends TimerTask {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TextViewFixTouchConsume f446353a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ClickableSpan[] f446354b;

            /* JADX INFO: renamed from: com.ss.android.lark.widget.linked_emojicon.TextViewFixTouchConsume$a$a$a, reason: collision with other inner class name */
            public class RunnableC5400a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ C5399a f446355a;

                public final void a() {
                    TextViewFixTouchConsume r100 = this.f446355a.f446353a;
                    if (r100.f446347o == false) goto L5;
                L11:
                    r100.f446346n = false;
                    r100.f446347o = false;
                    return;
                L5:
                    if (r100.f446345m == true) goto L11;
                    if (r100.f446346n == false) goto L11;
                    r100.setTag(R.id.tag_long_press, "tag_long_press");
                    C5399a r101 = this.f446355a;
                    r101.f446354b[0].onClick(r101.f446353a);
                    this.f446355a.f446353a.f446346n = false;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }

                public RunnableC5400a(C5399a r100) {
                    this.f446355a = r100;
                }
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                Activity r100 = UIUtils.getActivityFromView(this.f446353a);     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.runOnUiThread(new RunnableC5400a(this));     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }

            public C5399a(TextViewFixTouchConsume r100, ClickableSpan[] r101) {
                this.f446353a = r100;
                this.f446354b = r101;
            }
        }

        public a() {
            this.f446351a = false;
        }

        @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public final boolean onGenericMotionEvent(TextView r100, Spannable r101, MotionEvent r102) {
            if (this.f446351a == false) goto L7;
            return false;
        L7:
            return super.onGenericMotionEvent(r100, r101, r102);
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public final boolean onTouchEvent(TextView r110, Spannable r111, MotionEvent r112) {
            int r100 = r112.getAction();
            TextViewFixTouchConsume r101 = (TextViewFixTouchConsume) r110;
            if (r100 != 3) goto L7;
            r101.f446347o = true;
            return true;
        L7:
            if (r100 != 2) goto L19;
            int r113 = r101.f446348p;
            if (r113 != 0) goto L14;
            if (r101.f446349q != 0) goto L14;
        L18:
            return true;
        L14:
            if (Math.abs(r113 - ((int) r112.getX())) < 10) goto L16;
        L17:
            r101.f446347o = true;
            goto L18
        L16:
            if (Math.abs(r101.f446349q - ((int) r112.getY())) < 10) goto L18;
        L19:
            if (r100 == 1) goto L24;
            if (r100 == 0) goto L24;
            return Touch.onTouchEvent(r110, r111, r112);
        L24:
            int r102 = (int) r112.getX();
            int r103 = (int) r112.getY();
            if (r100 != 0) goto L27;
            r101.f446348p = r102;
            r101.f446349q = r103;
        L29:
            int r104 = r102 - r110.getTotalPaddingLeft();
            int r105 = r103 - r110.getTotalPaddingTop();
            int r106 = r104 + r110.getScrollX();
            int r107 = r105 + r110.getScrollY();
            Layout r108 = r110.getLayout();
            int r109 = r108.getLineForVertical(r107);
            float r114 = r106;
            int r115 = r108.getOffsetForHorizontal(r109, r114);
            if (r108.getPrimaryHorizontal(r115) < r114) goto L32;
            r115 = r115 - 1;
        L32:
            int r116 = r108.getLineEnd(r109);
            if (r116 <= 1) goto L35;
            int r117 = r116 - 1;
        L37:
            if (r114 <= r108.getSecondaryHorizontal(r117)) goto L39;
            r115 = r115 + 1;
        L39:
            ClickableSpan[] r118 = (ClickableSpan[]) r111.getSpans(r115, r115, ClickableSpan.class);
            if (r118.length == 0) goto L63;
            r101.f446345m = false;
            if (r100 == 1) goto L44;
            if (r100 != 0) goto L60;
            r101.f446347o = false;
            if (r101.f446346n == true) goto L58;
            r101.f446346n = true;
            new PthreadTimer("TextViewFixTouchConsume$LocalLinkMovementMethod").schedule(new C5399a(r101, r118), TextViewFixTouchConsume.f446342r);
            Selection.setSelection(r111, r111.getSpanStart(r118[0]), r111.getSpanEnd(r118[0]));
            goto L60
        L58:
            r101.f446345m = true;
        L60:
            if ((r110 instanceof TextViewFixTouchConsume) == false) goto L62;
            ((TextViewFixTouchConsume) r110).f446344l = true;
        L62:
            return true;
        L44:
            if (r101.f446346n == false) goto L60;
            r101.f446345m = true;
            this.f446352b = r102;
            if (r118.length != 1) goto L49;
            r118[0].onClick(r110);
            goto L60
        L49:
            if (r118.length <= 1) goto L60;
            if (((ReplacementSpan[]) r111.getSpans(r115, r115, ReplacementSpan.class)).length == 0) goto L53;
            r118[r118.length - 1].onClick(r110);
            goto L60
        L53:
            r118[0].onClick(r110);
            goto L60
        L63:
            Selection.removeSelection(r111);
            Touch.onTouchEvent(r110, r111, r112);
            return false;
        L35:
            r117 = 0;
            goto L37
        L27:
            if (r100 != 1) goto L29;
            r101.f446348p = 0;
            r101.f446349q = 0;
            goto L29
        }
    }

    @Override // android.view.View
    public final boolean hasFocus() {
        return false;
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
    }

    static {
        f446342r = ViewConfiguration.getLongPressTimeout();
    }

    public TextViewFixTouchConsume(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        this.f446344l = false;
        r101 = super.onTouchEvent(r100);     // Catch: Exception -> L5
    L8:
        if (this.f446343k == true) goto L10;
        boolean r102 = this.f446344l;
        if (r102 == true) goto L14;
        return r101;
    L14:
        return r102;
    L10:
        return this.f446344l;
    L5:
        e = move-exception;
        Log.e("TextViewFixTouchConsume", "supre onTouchEvent crash:" + e);
        goto L8
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        this.f446343k = false;
        super.setOnLongClickListener(r100);
    }

    public TextViewFixTouchConsume(Context r100, AttributeSet r101) {
        this(r100, r101, android.R.attr.textViewStyle);
    }

    public TextViewFixTouchConsume(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f446343k = true;
        this.f446345m = false;
        this.f446346n = false;
        this.f446347o = false;
        this.f446348p = 0;
        this.f446349q = 0;
    }
}
