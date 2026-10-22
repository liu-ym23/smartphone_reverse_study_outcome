package ev0;

import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;
import com.bytedance.android.live.profit.taskcenter.panel.trace.LiveTaskPanelTraceMonitor;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f474203a;

    public f(g r100) {
        this.f474203a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        c r102 = this.f474203a.f474204a;
        int r103 = c.f474195f;
        r102.getClass();
        c.a("observePanelState subscribe State.READY 超时关闭");
        this.f474203a.f474206c.put("fail_reason", "time_out");
        c r104 = this.f474203a.f474204a;
        String r105 = LiveTaskPanelTraceMonitor.Step.PANEL_SHOW_HYBRID_FAIL.getStep();
        Map r106 = this.f474203a.f474206c;
        r104.getClass();
        c.d(r105, r106);
        this.f474203a.f474205b.a(PanelInfo.State.DISMISSED, null);
    }
}
