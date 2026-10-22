package ea;

import android.widget.TextView;
import com.bytedance.android.annie.view.WebRiskHintView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebRiskHintView f471553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f471554b;

    public a(WebRiskHintView r100, String r101) {
        this.f471553a = r100;
        this.f471554b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView r100 = this.f471553a.f40098a;     // Catch: Throwable -> L7
        if (r100 == null) goto L10;
        r100.setText(this.f471554b);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
