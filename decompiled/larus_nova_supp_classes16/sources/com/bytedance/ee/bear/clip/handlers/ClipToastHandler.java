package com.bytedance.ee.bear.clip.handlers;

import android.app.Activity;
import android.graphics.Paint;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import at5.f;
import at5.j;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.compose.foundation.toast.g;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ClipToastHandler implements f<ToastData, LarkWebView> {
    public static final Map<Integer, Integer> c = null;
    public WeakReference<com.larksuite.component.universe_design.toast.c> a;
    public WeakReference<com.larksuite.component.universe_design.toast.c> b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/clip/handlers/ClipToastHandler$ToastData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "status", "", "getStatus", "()I", "setStatus", "(I)V", "progress", "getProgress", "setProgress", "failReason", "getFailReason", "setFailReason", "showRetry", "", "getShowRetry", "()Z", "setShowRetry", "(Z)V", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ToastData implements NonProguard {
        private int failReason;
        private int progress;
        private boolean showRetry;
        private int status;

        public ToastData() {
        }

        public String toString() {
            return "ToastData(status=" + this.status + ", progress=" + this.progress + ", failReason=" + this.failReason + ", showRetry=" + this.showRetry + ')';
        }

        public final int getFailReason() {
            return this.failReason;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean getShowRetry() {
            return this.showRetry;
        }

        public final int getStatus() {
            return this.status;
        }

        public final void setFailReason(int r1) {
            this.failReason = r1;
        }

        public final void setProgress(int r1) {
            this.progress = r1;
        }

        public final void setShowRetry(boolean r1) {
            this.showRetry = r1;
        }

        public final void setStatus(int r1) {
            this.status = r1;
        }
    }

    public static final class a {
    }

    public ClipToastHandler() {
    }

    public final boolean shouldRunInUIThread() {
        return true;
    }

    static {
        c = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(0, 2131888891), TuplesKt.to(1, 2131888886), TuplesKt.to(2, 2131888890), TuplesKt.to(3, 2131888889), TuplesKt.to(4, 2131888893)});
    }

    public final void b(ToastData r6, j r7, LarkWebView r8) {
        Intrinsics.checkNotNullParameter(r7, "callback");
        tt5.a.h("DocsClip#ClipToastHandler", "toast data = " + r6 + ", callback = " + r7);
        if (r6 == null) goto L88;
        if (r8 == null) goto L88;
        int r0 = r6.getStatus();
        if (r0 == 0) goto L44;
        if (r0 != 1) goto L10;
        int r9 = n.a;
        Activity r10 = n.g(r8.getContext());
        WeakReference<com.larksuite.component.universe_design.toast.c> r11 = this.a;
        if (r11 == null) goto L36;
        com.larksuite.component.universe_design.toast.c r12 = r11.get();
        if (r12 == null) goto L36;
        r12.cancel();
    L36:
        if (r10 != null) goto L38;
    L43:
        tt5.a.d("DocsClip#ClipToastHandler", "showSuccess()... activity is null or finished or destroyed!");
        return;
    L38:
        if (r10.isFinishing() == true) goto L43;
        if (r10.isDestroyed() == true) goto L43;
        Toast.showSuccessText(r10, 2131888887);
        return;
    L10:
        if (r0 == 2) goto L12;
        tt5.a.d("DocsClip#ClipToastHandler", "unknown status: " + r6.getStatus());
        return;
    L12:
        int r1 = n.a;
        Activity r13 = n.g(r8.getContext());
        int r2 = r6.getFailReason();
        boolean r14 = r6.getShowRetry();
        WeakReference<com.larksuite.component.universe_design.toast.c> r3 = this.a;
        if (r3 == null) goto L17;
        com.larksuite.component.universe_design.toast.c r4 = r3.get();
        if (r4 == null) goto L17;
        r4.cancel();
    L17:
        if (r13 != null) goto L19;
    L30:
        tt5.a.d("DocsClip#ClipToastHandler", "showFail()... activity is null or finished or destroyed!");
        return;
    L19:
        if (r13.isFinishing() == true) goto L30;
        if (r13.isDestroyed() == true) goto L30;
        Integer r5 = c.get(Integer.valueOf(r2));
        if (r5 == null) goto L29;
        r5.intValue();
        Intrinsics.checkNotNullParameter(r13, "context");
        FlowToast.a r16 = FlowToast.a(r13);
        r16.e(r5.intValue());
        r16.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r13, 2131255144));
        r16.d = 4000;
        if (r14 == false) goto L28;
        e r17 = new e(r7);
        Intrinsics.checkNotNullParameter(r17, JSEventListener.ACTION);
        r16.b(2131888892, new com.larksuite.component.universe_design.toast.a(r17));
    L28:
        g r18 = r16.a();
        r18.show();
        this.b = new WeakReference(r18);
        return;
    L29:
        tt5.a.d("DocsClip#ClipToastHandler", "unknown failReason: " + r2);
        return;
    L44:
        int r19 = n.a;
        Activity r20 = n.g(r8.getContext());
        int r21 = r6.getProgress();
        if (r20 != null) goto L47;
    L86:
        tt5.a.d("DocsClip#ClipToastHandler", "showLoading()... activity is null or finished or destroyed!");
        return;
    L47:
        if (r20.isFinishing() == true) goto L86;
        if (r20.isDestroyed() == true) goto L86;
        WeakReference<com.larksuite.component.universe_design.toast.c> r22 = this.b;
        if (r22 == null) goto L58;
        com.larksuite.component.universe_design.toast.c r23 = r22.get();
        if (r23 == null) goto L58;
        if (r23.isShowing() != true) goto L58;
        boolean r24 = true;
    L59:
        if (r24 == false) goto L65;
        WeakReference<com.larksuite.component.universe_design.toast.c> r26 = this.b;
        if (r26 == null) goto L65;
        com.larksuite.component.universe_design.toast.c r27 = r26.get();
        if (r27 == null) goto L65;
        r27.cancel();
    L65:
        WeakReference<com.larksuite.component.universe_design.toast.c> r28 = this.a;
        if (r28 == null) goto L72;
        com.larksuite.component.universe_design.toast.c r29 = r28.get();
        if (r29 == null) goto L72;
        if (r29.isShowing() != true) goto L72;
        boolean r30 = true;
    L74:
        if (r30 == false) goto L80;
        WeakReference<com.larksuite.component.universe_design.toast.c> r31 = this.a;
        if (r31 == null) goto L78;
        com.larksuite.component.universe_design.toast.c r32 = r31.get();
    L79:
        Intrinsics.checkNotNull(r32);
        r32.setText(r20.getString(2131888888) + r21 + '%');
        return;
    L78:
        r32 = null;
        goto L79
    L80:
        WeakReference<com.larksuite.component.universe_design.toast.c> r33 = this.a;
        if (r33 == null) goto L85;
        com.larksuite.component.universe_design.toast.c r34 = r33.get();
        if (r34 == null) goto L85;
        r34.cancel();
    L85:
        CircularProgressDrawable r36 = new CircularProgressDrawable(r20);
        r36.setStyle(1);
        r36.setColorSchemeColors(new int[]{UDColorUtils.getColor(r20, 2131106521)});
        r36.setStrokeCap(Paint.Cap.ROUND);
        UDToast.a r37 = UDToast.build(r20);
        r37.g(r20.getString(2131888888) + r21 + '%');
        r37.e(r36);
        r37.b.d = 2147483647L;
        g r38 = r37.a();
        r38.show();
        this.a = new WeakReference(r38);
        return;
    L72:
        r30 = false;
    L58:
        r24 = false;
    L88:
        tt5.a.d("DocsClip#ClipToastHandler", "data or LarkWebView is null!");
    }

    public final /* bridge */ /* synthetic */ void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
        b((ToastData) r1, r2, r4);
    }
}
