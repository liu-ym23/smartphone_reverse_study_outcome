package lg;

import com.bytedance.android.ec.core.apt.APTNodeType;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class h extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f509123a;

    @Override // lg.b
    public int getType() {
        return this.f509123a;
    }

    public h(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f509123a = APTNodeType.EVENT.getValue();
        JSONObject r102 = new JSONObject();
        r102.put(ReportCardMonitorPlugin.EVENT_NAME, r100);
        r102.put("event_params", r101);
        Unit r103 = Unit.INSTANCE;
    }
}
