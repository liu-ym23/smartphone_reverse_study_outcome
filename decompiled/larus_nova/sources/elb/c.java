package elb;

import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.image.uploader.entity.b f473041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageUploadTask f473042b;

    public c(com.ss.android.lark.image.uploader.entity.b r100, ImageUploadTask r101) {
        this.f473041a = r100;
        this.f473042b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<com.ss.android.lark.image.uploader.entity.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        glb.b r101 = glb.b.f481646a;
        com.ss.android.lark.image.uploader.entity.b r102 = this.f473041a;
        r101.getClass();
        glb.b.e(r102);
        long r103 = System.currentTimeMillis();
        int r104 = blb.c.f19525a;
        blb.c.c(this.f473041a, this.f473042b);
        com.ss.android.lark.image.uploader.entity.b r105 = this.f473041a;
        r105.f426399m = blb.c.a(r105.f426396j, r105.f426387a, r103);
        glb.b.f(this.f473041a);
        r100.onNext(this.f473041a);
        r100.onComplete();
    }
}
