package me3;

import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends BaseRequestListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f513469a;

    public a(Function0 r100) {
        this.f513469a = r100;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestSuccess(ImageRequest r100, String r101, boolean r102) {
        super.onRequestSuccess(r100, r101, r102);
        this.f513469a.invoke();
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestFailure(ImageRequest r100, String r101, Throwable r102, boolean r103) {
        super.onRequestFailure(r100, r101, r102, r103);
        this.f513469a.invoke();
    }
}
