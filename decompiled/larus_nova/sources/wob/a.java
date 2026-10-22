package wob;

import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.slot.InjectableInputView;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InjectableInputView f560538a;

    public a(InjectableInputView r100) {
        this.f560538a = r100;
    }

    public final void a() {
        int r100 = this.f560538a.f430933b.getMeasuredWidth();
        int r101 = this.f560538a.f430935d.getMeasuredWidth();
        InjectableInputView r102 = this.f560538a;
        int r103 = r102.f430939h;
        int r104 = 0;
        if (r100 <= 0) goto L5;
        int r105 = r100 + r102.f430940i;
    L6:
        int r106 = r105 + r103;
        if (r101 <= 0) goto L9;
        r104 = r102.f430940i + r101;
    L9:
        EditText r107 = r102.f430932a;
        int r108 = r107.getPaddingTop();
        r107.setPadding(r106, r108, r103 + r104, this.f560538a.f430932a.getPaddingBottom());
        return;
    L5:
        r105 = 0;
        goto L6
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
}
