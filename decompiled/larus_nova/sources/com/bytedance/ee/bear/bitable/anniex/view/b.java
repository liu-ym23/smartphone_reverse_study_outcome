package com.bytedance.ee.bear.bitable.anniex.view;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReactionFlowLayout f206800a;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f206801a = null;

        static {
            f206801a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return true;
        }
    }

    public b(ReactionFlowLayout r100) {
        this.f206800a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f206800a.getChildAt(0);     // Catch: Throwable -> L10
        if ((r100 instanceof TextView) == false) goto L5;
        TextView r101 = (TextView) r100;     // Catch: Throwable -> L10
    L6:
        if (r101 != null) goto L8;
        tt5.a.k("BitableLynxReactionView", "applyReactions: reaction text view not found");     // Catch: Throwable -> L10
        return;
    L8:
        r101.setMaxLines(6);     // Catch: Throwable -> L10
        r101.setEllipsize(TextUtils.TruncateAt.END);     // Catch: Throwable -> L10
        r101.setClickable(true);     // Catch: Throwable -> L10
        r101.setLongClickable(true);     // Catch: Throwable -> L10
        r101.setOnTouchListener(a.f206801a);     // Catch: Throwable -> L10
        return;
    L5:
        r101 = null;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
