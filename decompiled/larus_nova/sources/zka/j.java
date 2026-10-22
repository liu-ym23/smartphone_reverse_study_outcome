package zka;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class j extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f572722a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f572722a.invoke(r100.getData().getString("result", null));
    }

    public j(e r100, Looper r101) {
        this.f572722a = r100;
        super(r101);
    }
}
