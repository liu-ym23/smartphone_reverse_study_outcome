package qb4;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f532316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0.b f532317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f532318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f532319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f532320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Map f532321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Map f532322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a0 f532323h;

    public class a implements sb4.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f532324a;

        @Override // sb4.l
        public final void a() {
            WeakReference<sb4.k> r100 = this.f532324a.f532323h.f532296b;
            if (r100 != null) goto L5;
        L7:
            b0 r101 = this.f532324a;
            a0.b r102 = r101.f532317b;
            d.a r103 = (d.a) r102;
            r103.a(r101.f532318c, r101.f532319d);
            return;
        L5:
            if (r100.get() == null) goto L7;
            c(this.f532324a.f532323h.f532296b.get());
            this.f532324a.f532323h.f532296b.clear();
            this.f532324a.f532323h.f532296b = null;
            goto L7
        }

        @Override // sb4.l
        public final void b() {
            WeakReference<sb4.k> r100 = this.f532324a.f532323h.f532296b;
            if (r100 != null) goto L5;
        L7:
            b0 r101 = this.f532324a;
            r101.f532323h.b(r101.f532320e, r101.f532321f, r101.f532322g, r101.f532317b);
            return;
        L5:
            if (r100.get() == null) goto L7;
            c(this.f532324a.f532323h.f532296b.get());
            this.f532324a.f532323h.f532296b.clear();
            this.f532324a.f532323h.f532296b = null;
            goto L7
        }

        @Override // sb4.l
        public final void onCancel() {
            WeakReference<sb4.k> r100 = this.f532324a.f532323h.f532296b;
            if (r100 != null) goto L5;
        L7:
            b0 r101 = this.f532324a;
            a0.b r102 = r101.f532317b;
            d.a r103 = (d.a) r102;
            r103.a(r101.f532318c, r101.f532319d);
            return;
        L5:
            if (r100.get() == null) goto L7;
            c(this.f532324a.f532323h.f532296b.get());
            this.f532324a.f532323h.f532296b.clear();
            this.f532324a.f532323h.f532296b = null;
            goto L7
        }

        public a(b0 r100) {
            this.f532324a = r100;
        }

        public static void c(sb4.k r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L10;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }
    }

    public final void a() {
        String r100 = this.f532316a.getString(R.string.turing_net_error_dlg_fail_title);
        String r101 = this.f532316a.getString(R.string.turing_verify_retry_content);
        sb4.b r102 = new sb4.b();
        r102.f541211a = r100;
        r102.f541212b = r101;
        r102.f541213c = this.f532316a.getString(R.string.turing_verify_cancel);
        r102.f541214d = this.f532316a.getString(R.string.turing_verify_retry);
        sb4.k r103 = new sb4.k(this.f532316a, r102, true, new a(this));
        a0 r104 = this.f532323h;
        r104.f532296b = new WeakReference(r103);
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r103);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
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

    public b0(a0 r100, Activity r101, a0.b r102, int r103, String r104, String r105, Map r106, Map r107) {
        this.f532323h = r100;
        this.f532316a = r101;
        this.f532317b = r102;
        this.f532318c = r103;
        this.f532319d = r104;
        this.f532320e = r105;
        this.f532321f = r106;
        this.f532322g = r107;
    }
}
