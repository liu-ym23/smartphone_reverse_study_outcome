package me3;

import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends BaseRequestListener {
    public final /* synthetic */ Function0 a;

    public a(Function0 r1) {
        this.a = r1;
    }

    public final void onRequestSuccess(ImageRequest r1, String r2, boolean r3) {
        super.onRequestSuccess(r1, r2, r3);
        this.a.invoke();
    }

    public final void onRequestFailure(ImageRequest r1, String r2, Throwable r3, boolean r4) {
        super.onRequestFailure(r1, r2, r3, r4);
        this.a.invoke();
    }
}
