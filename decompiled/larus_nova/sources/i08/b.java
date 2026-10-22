package i08;

import android.text.TextUtils;
import android.widget.TextView;
import com.larksuite.component.ui.toast.loading.LKUILoadingToastImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LKUILoadingToastImpl f487894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CharSequence f487895b;

    public b(LKUILoadingToastImpl r100, CharSequence r101) {
        this.f487894a = r100;
        this.f487895b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LKUILoadingToastImpl r100 = this.f487894a;     // Catch: Throwable -> L8
        CharSequence r101 = this.f487895b;     // Catch: Throwable -> L8
        LKUILoadingToastImpl.b r102 = r100.f284481f;     // Catch: Throwable -> L8
        r102.getClass();     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r101) == false) goto L5;
        int r103 = 8;
    L6:
        TextView r104 = r102.f284483a;     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L8
        r104.setText(r101);     // Catch: Throwable -> L8
        TextView r105 = r102.f284483a;     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L8
        r105.setVisibility(r103);     // Catch: Throwable -> L8
        return;
    L5:
        r103 = 0;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
