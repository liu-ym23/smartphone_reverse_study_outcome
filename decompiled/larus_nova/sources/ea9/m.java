package ea9;

import android.media.projection.MediaProjection;
import com.larus.flow.capture.model.StopReason;
import com.larus.flow.capture.screen.ScreenCaptureService;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
public final class m extends MediaProjection.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenCaptureService f471729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f471730b;

    @Override // android.media.projection.MediaProjection.Callback
    public final void onStop() {
        ScreenCaptureService r100 = this.f471729a;
        Function1<? super da9.b, Unit> r101 = ScreenCaptureService.f343430r;
        r100.getClass();
        ca9.c r102 = ca9.b.f22972a;
        ca9.c.a.b(ca9.b.f22972a, "ScreenShareCaptureException", "ScreenCaptureService.MediaProjection.Callback", CollectionsKt.listOf(this.f471730b));
        this.f471729a.c(StopReason.SOURCE_INTERRUPTED);
    }

    public m(ScreenCaptureService r100, String r101) {
        this.f471729a = r100;
        this.f471730b = r101;
    }
}
