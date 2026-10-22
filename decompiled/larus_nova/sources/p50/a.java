package p50;

import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends BaseDataSubscriber<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f527737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function4 f527738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f527739c;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        if (r100.hasResult() == false) goto L24;
        CloseableReference<CloseableImage> r101 = r100.getResult();
        if (r101 == null) goto L30;
        CloseableImage r102 = r101.get();
        if (r102 == null) goto L31;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    L9:
        if ((r102 instanceof CloseableAnimatedImage) == false) goto L17;
        AnimatedImage r103 = ((CloseableAnimatedImage) r102).getImage();     // Catch: Throwable -> L19
        if (r103 == null) goto L13;
        int r104 = r103.getFrameCount();     // Catch: Throwable -> L19
    L14:
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L17;
        c.a(this.f527737a, (CloseableAnimatedImage) r102, this.f527738b, this.f527739c, r104, r105);     // Catch: Throwable -> L19
        r105 = r105 + 1;     // Catch: Throwable -> L19
        goto L15
    L13:
        r104 = 0;
    L17:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r102, null);
        return;
    L31:
        return;
    L30:
        return;
    }

    public a(c r100, Function4 r101, Uri r102) {
        this.f527737a = r100;
        this.f527738b = r101;
        this.f527739c = r102;
    }
}
