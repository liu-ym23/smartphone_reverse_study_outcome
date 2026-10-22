package com.bytedance.ee.bear.list.delete;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeleteExecutor f227849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2<String, io.reactivex.disposables.a, Unit> f227850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ io.reactivex.disposables.a f227851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Unit> f227852d;

    /* JADX WARN: Multi-variable type inference failed */
    public b(DeleteExecutor r100, Function2<? super String, ? super io.reactivex.disposables.a, Unit> r101, io.reactivex.disposables.a r102, Function1<? super Throwable, Unit> r103) {
        this.f227849a = r100;
        this.f227850b = r101;
        this.f227851c = r102;
        this.f227852d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Result r101 = (Result) r100;
        tt5.a.h(this.f227849a.f227814b, " create task result, code=" + r101.code);
        DeleteTaskResult r102 = (DeleteTaskResult) r101.data;
        if (r102 == null) goto L5;
        String r103 = r102.getTaskId();
    L7:
        if (r101.code != 0) goto L16;
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L16;
        this.f227850b.invoke(r103, this.f227851c);
        return;
    L10:
        if (r103.length() == 0) goto L13;
        r104 = false;
    L16:
        this.f227852d.invoke(new Exception("failed,taskId:" + r103));
        return;
    L5:
        r103 = null;
        goto L7
    }
}
