package com.bytedance.ee.bear.templates.center.list.base;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTemplateListPresenter f239006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TemplateV4 f239007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f239008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f239009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f239010e;

    public f(BaseTemplateListPresenter r100, TemplateV4 r101, String r102, String r103, boolean r104) {
        this.f239006a = r100;
        this.f239007b = r101;
        this.f239008c = r102;
        this.f239009d = r103;
        this.f239010e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        tt5.a.d("BaseTemplateListPresenter", "createBlankDocument createOnlineDocument()...failed, throwable = " + r101);
        BaseTemplateListPresenter.I8(this.f239006a, this.f239007b, this.f239008c, this.f239009d, r101, this.f239010e);
    }
}
