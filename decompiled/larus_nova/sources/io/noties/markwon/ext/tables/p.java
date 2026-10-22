package io.noties.markwon.ext.tables;

import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes41.dex */
public final class p implements io.noties.markwon.ext.tables.a.InterfaceC6318a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f492543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f492544b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f492545a;

        @Override // java.lang.Runnable
        public final void run() {
            TextView r100 = this.f492545a.f492544b;     // Catch: Throwable -> L4
            r100.setText(r100.getText());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(p r100) {
            this.f492545a = r100;
        }
    }

    public p(TextView r100) {
        this.f492544b = r100;
        this.f492543a = new a(this);
    }
}
