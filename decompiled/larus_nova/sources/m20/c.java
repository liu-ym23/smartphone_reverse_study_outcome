package m20;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.xplay.perf.XplayPerfPanelView;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XplayPerfPanelView f511637a;

    public c(XplayPerfPanelView r100) {
        this.f511637a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        XplayPerfPanelView.c r101 = (XplayPerfPanelView.c) r100;
        ((ArrayList) this.f511637a.f62315c).clear();
        ((ArrayList) this.f511637a.f62315c).add("CPU(均值): " + r101.f62329a);
        ((ArrayList) this.f511637a.f62315c).add("GPU(均值): " + r101.f62330b);
        ((ArrayList) this.f511637a.f62315c).add("内存(MB)(均值) : " + r101.f62331c);
        ((ArrayList) this.f511637a.f62315c).add("卡顿率(均值): " + r101.f62332d);
        ((ArrayList) this.f511637a.f62315c).add("推流帧率(均值): " + r101.f62333e);
        ((ArrayList) this.f511637a.f62315c).add("温度最大值: " + r101.f62334f);
        List<String> r102 = this.f511637a.f62315c;
        StringBuilder r103 = new StringBuilder("xplay 分辨率: ");
        a r104 = XplayPerfPanelView.f62312o;
        r103.append(r104.f511632a);
        r103.append('-');
        r103.append(r104.f511633b);
        ((ArrayList) r102).add(r103.toString());
        ((ArrayList) this.f511637a.f62315c).add("xplay 下行码率: " + r104.f511635d + " kbps");
        ((ArrayList) this.f511637a.f62315c).add("xplay 渲染帧率: " + r104.f511634c);
        RecyclerView.Adapter r105 = this.f511637a.f62313a.getAdapter();
        if (r105 == null) goto L6;
        r105.notifyItemRangeChanged(0, ((ArrayList) this.f511637a.f62315c).size());
        return;
    }
}
