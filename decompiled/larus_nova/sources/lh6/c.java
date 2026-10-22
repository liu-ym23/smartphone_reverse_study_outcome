package lh6;

import com.bytedance.android.live.liveinteract.plantform.camera.SwitchCameraManager;
import com.bytedance.live.bizlink.api.platform.status.event.StatusEventCategory;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ng6.d;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements lg6.a<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f509276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ lg6.a f509277b;

    @Override // lg6.a
    public final void a(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        b r101 = this.f509276a;
        r101.f509271h.a(new mg6.b(StatusEventCategory.VIDEO, d.a.f519079b, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("isCameraOpen", Boolean.valueOf(r101.d())), TuplesKt.to("videoCaptureMode", Integer.valueOf(this.f509276a.b()))})));
        lg6.a r102 = this.f509277b;
        if (r102 == null) goto L6;
        r102.a(r100);
        return;
    }

    @Override // lg6.a
    public final void onFailed(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        lg6.a r101 = this.f509277b;
        if (r101 == null) goto L6;
        r101.onFailed(r100);
        return;
    }

    public c(b r100, SwitchCameraManager.f r101) {
        this.f509276a = r100;
        this.f509277b = r101;
    }
}
