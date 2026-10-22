package phc;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.ControllerListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class b<INFO> implements ControllerListener<INFO> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ControllerListener<INFO>[] f529313a;

    public b(ControllerListener<INFO>... r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f529313a = r100;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onRelease(String r100) {
        ControllerListener<INFO>[] r101 = this.f529313a;
        if (r101 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        ControllerListener<INFO> r104 = r101[r103];
        if (r104 == null) goto L9;
        r104.onRelease(r100);
    L9:
        r103 = r103 + 1;
        goto L5
    L14:
        return;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        ControllerListener<INFO>[] r102 = this.f529313a;
        if (r102 == null) goto L10;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L14;
        ControllerListener<INFO> r105 = r102[r104];
        if (r105 == null) goto L9;
        r105.onFailure(r100, r101);
    L9:
        r104 = r104 + 1;
        goto L5
    L14:
        return;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageFailed(String r100, Throwable r101) {
        ControllerListener<INFO>[] r102 = this.f529313a;
        if (r102 == null) goto L10;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L14;
        ControllerListener<INFO> r105 = r102[r104];
        if (r105 == null) goto L9;
        r105.onIntermediateImageFailed(r100, r101);
    L9:
        r104 = r104 + 1;
        goto L5
    L14:
        return;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageSet(String r100, INFO r101) {
        ControllerListener<INFO>[] r102 = this.f529313a;
        if (r102 == null) goto L10;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L14;
        ControllerListener<INFO> r105 = r102[r104];
        if (r105 == null) goto L9;
        r105.onIntermediateImageSet(r100, r101);
    L9:
        r104 = r104 + 1;
        goto L5
    L14:
        return;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        ControllerListener<INFO>[] r102 = this.f529313a;
        if (r102 == null) goto L10;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L14;
        ControllerListener<INFO> r105 = r102[r104];
        if (r105 == null) goto L9;
        r105.onSubmit(r100, r101);
    L9:
        r104 = r104 + 1;
        goto L5
    L14:
        return;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, INFO r101, Animatable r102) {
        ControllerListener<INFO>[] r103 = this.f529313a;
        if (r103 == null) goto L10;
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L14;
        ControllerListener<INFO> r106 = r103[r105];
        if (r106 == null) goto L9;
        r106.onFinalImageSet(r100, r101, r102);
    L9:
        r105 = r105 + 1;
        goto L5
    L14:
        return;
    }
}
