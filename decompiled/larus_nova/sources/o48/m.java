package o48;

import com.larus.common_ui.dialog.u;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class m implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f522005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f522006b;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        this.f522005a.invoke(Boolean.FALSE);
        qr9.b r100 = VideoFeedProviderDelegate.f365695b.getTopPlayerController();
        if (r100 == null) goto L5;
        r100.playPlayer();
    L5:
        o r101 = o.f365780a;
        JSONObject r102 = this.f522006b;
        r102.put("click_type", "cancel");
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("sdk_video_notice_click", r102);
    }

    public m(f r100, JSONObject r101) {
        this.f522005a = r100;
        this.f522006b = r101;
    }
}
