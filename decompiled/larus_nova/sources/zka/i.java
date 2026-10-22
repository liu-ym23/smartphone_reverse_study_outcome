package zka;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class i extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f572721a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f572721a.invoke(Boolean.valueOf(r100.getData().getBoolean("success", false)));
    }

    public i(d r100, Looper r101) {
        this.f572721a = r100;
        super(r101);
    }
}
