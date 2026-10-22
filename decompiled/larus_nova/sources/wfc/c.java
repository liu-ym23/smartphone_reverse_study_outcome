package wfc;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.photoeditor.text.TextEditorDrawView;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextEditorDrawView f559507a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f559507a.m(true);     // Catch: Throwable -> L4
        this.f559507a.o();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(TextEditorDrawView r100) {
        this.f559507a = r100;
    }
}
