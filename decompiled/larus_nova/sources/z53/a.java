package z53;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public class a implements ControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f570095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f570096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f570097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f570098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f570099e;

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageFailed(String r100, Throwable r101) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onRelease(String r100) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
    }

    public void b(String r100, ImageInfo r101) {
        Function0<Unit> r102 = this.f570098d;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke();
        return;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r110, Throwable r111) {
        if (this.f570099e == false) goto L10;
        int r112 = com.bytedance.android.ec.core.anchorv3.a.f43797a;
        List<String> r113 = this.f570095a;
        if (r113 == null) goto L7;
        String r114 = CollectionsKt.joinToString$default(r113, ",", null, null, 0, null, null, 62, null);
    L8:
        com.bytedance.android.ec.core.anchorv3.a.c(0, this.f570096b, r114, r111);
        return;
    L7:
        r114 = null;
        goto L8
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public /* bridge */ /* synthetic */ void onIntermediateImageSet(String r100, ImageInfo r101) {
        b(r100, r101);
    }

    public void a(String r100, ImageInfo r101, Animatable r102) {
        if (this.f570099e == false) goto L5;
        int r103 = com.bytedance.android.ec.core.anchorv3.a.f43797a;
        com.bytedance.android.ec.core.anchorv3.a.c(1, this.f570096b, null, null);
    L5:
        Function0<Unit> r104 = this.f570097c;
        if (r104 == null) goto L9;
        Unit r105 = r104.invoke();
        return;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public /* bridge */ /* synthetic */ void onFinalImageSet(String r100, ImageInfo r101, Animatable r102) {
        a(r100, r101, r102);
    }

    public /* synthetic */ a(List r100, String r101, Function0 r102, boolean r110, int r111) {
        if ((r111 & 4) == 0) goto L5;
        r102 = null;
    L5:
        Function0 r103 = r102;
        if ((r111 & 16) == 0) goto L8;
        boolean r104 = true;
    L9:
        this(r100, r101, r103, null, r104);
        return;
    L8:
        r104 = r110;
        goto L9
    }

    public a(List<String> r100, String r101, Function0<Unit> r102, Function0<Unit> r103, boolean r104) {
        this.f570095a = r100;
        this.f570096b = r101;
        this.f570097c = r102;
        this.f570098d = r103;
        this.f570099e = r104;
    }
}
