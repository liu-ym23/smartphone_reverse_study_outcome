package j19;

import com.larus.common_ui.photoviewer.ZoomableControllerImp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ZoomableControllerImp f496868a;

    public a(ZoomableControllerImp r100) {
        Intrinsics.checkNotNullParameter(r100, "zc");
        this.f496868a = r100;
    }

    @Override // j19.l
    public final float nextFactor(float r100) {
        ZoomableControllerImp r101 = this.f496868a;
        float r102 = r101.f327674g;
        if (r102 != 0.0f) goto L5;
        r102 = r101.f327675h;
    L5:
        float r103 = r101.f327673f;
        if (r100 >= ((r102 + r103) / 2)) goto L9;
        return r102;
    L9:
        return r103;
    }
}
