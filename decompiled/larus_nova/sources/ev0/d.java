package ev0;

import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f474201a = null;

    static {
        int[] r100 = new int[PanelInfo.State.values().length];
        f474201a = r100;
        r100[PanelInfo.State.READY.ordinal()] = 1;
        r100[PanelInfo.State.SHOWING.ordinal()] = 2;
        r100[PanelInfo.State.DISMISSED.ordinal()] = 3;
    }
}
