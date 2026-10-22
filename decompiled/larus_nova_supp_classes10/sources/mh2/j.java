package mh2;

import android.text.TextUtils;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements Runnable {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ String b;

    public j(TextView r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    L18:
        return;
    L3:
        if (TextUtils.isEmpty(this.a.getText().toString()) == false) goto L13;
        this.a.setText(this.b);     // Catch: Throwable -> L6 Exception -> L8
    L19:
        return;
    }
}
