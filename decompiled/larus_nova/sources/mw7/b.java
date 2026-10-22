package mw7;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.hihonor.honorid.UseCase;
import com.hihonor.honorid.usecase.WriteHnAccountUseCase;
import com.larus.apm.impl.protector.RunnableProtector;
import exc.e;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes23.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UseCase f515973a;

    public final void a() {
        UseCase r100 = this.f515973a;
        Q r101 = r100.f276524a;
        WriteHnAccountUseCase r102 = (WriteHnAccountUseCase) r100;
        WriteHnAccountUseCase.RequestValues r103 = (WriteHnAccountUseCase.RequestValues) r101;
        e.c("WriteHnAccountUseCase", "writeHnAccount");
        Context r104 = r102.f276631b;
        FileOutputStream r105 = cxc.a.f465749a;
        if (r104 != null) goto L5;
    L12:
        qw7.b.b(r102.f276631b, r102.f276632c);     // Catch: Exception -> L10
        return;
    L10:
        e.e("WriteHnAccountUseCase", "Exception");
        return;
    L5:
        if (TextUtils.isEmpty("accounts.xml") == true) goto L12;
        cxc.a.d(new PolarisFileWrapper(r104.getFilesDir(), "accounts.xml"));
        goto L12
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

    public b(WriteHnAccountUseCase r100) {
        this.f515973a = r100;
    }
}
