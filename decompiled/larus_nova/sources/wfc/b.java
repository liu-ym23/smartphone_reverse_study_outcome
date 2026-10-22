package wfc;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.photoeditor.text.TextEditorDrawView;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextEditorDrawView f559506a;

    @Override // java.lang.Runnable
    public final void run() {
        TextEditorDrawView r100 = this.f559506a;     // Catch: Throwable -> L4
        int r101 = TextEditorDrawView.D;     // Catch: Throwable -> L4
        r100.o();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(TextEditorDrawView r100) {
        this.f559506a = r100;
    }
}
