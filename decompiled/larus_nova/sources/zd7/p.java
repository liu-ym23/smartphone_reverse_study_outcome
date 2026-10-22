package zd7;

import android.net.Uri;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<yd7.e.c> f571411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap<String, String> f571412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f571413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f571414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Integer f571415e;

    public p(CompletionBlock<yd7.e.c> r100, LinkedHashMap<String, String> r101, Uri r102, int r103, Integer r104) {
        this.f571411a = r100;
        this.f571412b = r101;
        this.f571413c = r102;
        this.f571414d = r103;
        this.f571415e = r104;
    }

    public final void a() {
        CompletionBlock<yd7.e.c> r100 = this.f571411a;
        XBaseModel r101 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.e.c.class));
        LinkedHashMap<String, String> r102 = this.f571412b;
        Uri r103 = this.f571413c;
        int r104 = this.f571414d;
        Integer r105 = this.f571415e;
        yd7.e.c r106 = (yd7.e.c) r101;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L5
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(r104));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r108) == false) goto L10;
        r108 = 0;
    L10:
        r106.setHttpCode((Number) r108);
        Object r109 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r109) == false) goto L18;
        r109 = 0;
    L18:
        r106.setClientCode((Number) r109);
        r106.setHeader(r102);
        r106.setFilePath(String.valueOf(r103));
        CompletionBlock.DefaultImpls.onSuccess$default(r100, (XBaseResultModel) r101, null, 2, null);
        return;
    L13:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
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
