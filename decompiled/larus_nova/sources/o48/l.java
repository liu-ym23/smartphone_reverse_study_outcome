package o48;

import com.larus.common_ui.dialog.p0;
import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class l implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f522003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f522004b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        this.f522003a.invoke(Boolean.TRUE);
        o r100 = o.f365780a;
        JSONObject r101 = this.f522004b;
        r101.put("click_type", "authorize");
        Unit r102 = Unit.INSTANCE;
        r100.reportEvent("sdk_video_notice_click", r101);
    }

    public l(f r100, JSONObject r101) {
        this.f522003a = r100;
        this.f522004b = r101;
    }
}
