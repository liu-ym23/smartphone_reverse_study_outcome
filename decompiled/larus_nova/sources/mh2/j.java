package mh2;

import android.text.TextUtils;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f513919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f513920b;

    public j(TextView r100, String r101) {
        this.f513919a = r100;
        this.f513920b = r101;
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
        if (TextUtils.isEmpty(this.f513919a.getText().toString()) == false) goto L13;
        this.f513919a.setText(this.f513920b);     // Catch: Throwable -> L6 Exception -> L8
    L19:
        return;
    }
}
