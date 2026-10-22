package zka;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f572720a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f572720a.invoke(Boolean.valueOf(r100.getData().getBoolean("success", false)));
    }

    public h(c r100, Looper r101) {
        this.f572720a = r100;
        super(r101);
    }
}
