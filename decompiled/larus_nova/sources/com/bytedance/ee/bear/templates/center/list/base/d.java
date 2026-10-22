package com.bytedance.ee.bear.templates.center.list.base;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTemplateListPresenter f238999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TemplateV4 f239000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f239001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f239002d;

    public d(BaseTemplateListPresenter r100, TemplateV4 r101, String r102, String r103) {
        this.f238999a = r100;
        this.f239000b = r101;
        this.f239001c = r102;
        this.f239002d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        tt5.a.d("BaseTemplateListPresenter", "createBlankDocument createOfflineDocumentFlow()...failed, throwable = " + r101);
        BaseTemplateListPresenter.I8(this.f238999a, this.f239000b, this.f239001c, this.f239002d, r101, false);
    }
}
