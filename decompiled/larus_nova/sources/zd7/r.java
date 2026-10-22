package zd7;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<yd7.e.c> f571421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Exception f571422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f571423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Integer f571424d;

    public r(CompletionBlock<yd7.e.c> r100, Exception r101, int r102, Integer r103) {
        this.f571421a = r100;
        this.f571422b = r101;
        this.f571423c = r102;
        this.f571424d = r103;
    }

    public final void a() {
        CompletionBlock<yd7.e.c> r100 = this.f571421a;
        String r101 = this.f571422b.getMessage();
        if (r101 != null) goto L5;
        r101 = "store file exception";
    L5:
        XBaseModel r102 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.e.c.class));
        int r103 = this.f571423c;
        Integer r104 = this.f571424d;
        yd7.e.c r105 = (yd7.e.c) r102;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L8
        Object r107 = Result.m9449constructorimpl(Integer.valueOf(r103));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r107) == false) goto L13;
        r107 = 0;
    L13:
        r105.setHttpCode((Number) r107);
        Object r108 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r108) == false) goto L21;
        r108 = 0;
    L21:
        r105.setClientCode((Number) r108);
        r105.setFilePath("");
        Unit r109 = Unit.INSTANCE;
        r100.onFailure(0, r101, (XBaseResultModel) r102);
        return;
    L16:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
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
}
