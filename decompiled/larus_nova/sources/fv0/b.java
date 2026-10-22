package fv0;

import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f478953a = null;

    static {
        int[] r100 = new int[PanelInfo.State.values().length];
        f478953a = r100;
        r100[PanelInfo.State.WAITING.ordinal()] = 1;
        r100[PanelInfo.State.READY.ordinal()] = 2;
        r100[PanelInfo.State.SHOWING.ordinal()] = 3;
        r100[PanelInfo.State.DISMISSED.ordinal()] = 4;
    }
}
