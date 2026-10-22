package defpackage;

import com.larus.common_ui.dialog.u;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes42.dex */
public final class a1 implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1360a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        FLogger.f375446a.i("ZipShareUtils", "User clicked cancel feedback");
        Function0<Unit> r100 = this.f1360a;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public a1(y0 r100) {
        this.f1360a = r100;
    }
}
