package com.larksuite.component.blockit.core;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;

/* JADX INFO: loaded from: classes24.dex */
public final enum BlockLifeCycleEvent extends Enum<BlockLifeCycleEvent> {
    public static final BlockLifeCycleEvent ON_DESTROY = null;
    public static final BlockLifeCycleEvent ON_HIDE = null;
    public static final BlockLifeCycleEvent ON_INIT = null;
    public static final BlockLifeCycleEvent ON_LOAD = null;
    public static final BlockLifeCycleEvent ON_SHOW = null;
    public static final BlockLifeCycleEvent UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlockLifeCycleEvent[] f282975a = null;
    String name;

    static {
        BlockLifeCycleEvent r100 = new BlockLifeCycleEvent("ON_INIT", 0, "onInit");
        ON_INIT = r100;
        BlockLifeCycleEvent r101 = new BlockLifeCycleEvent("ON_LOAD", 1, WidgetCostModule.TYPE_ON_LOAD);
        ON_LOAD = r101;
        BlockLifeCycleEvent r102 = new BlockLifeCycleEvent("ON_SHOW", 2, SendEventContainerMethodParamModel.EventKinds.onShow);
        ON_SHOW = r102;
        BlockLifeCycleEvent r103 = new BlockLifeCycleEvent("ON_HIDE", 3, "onHide");
        ON_HIDE = r103;
        BlockLifeCycleEvent r104 = new BlockLifeCycleEvent("ON_DESTROY", 4, LiveCommonConstants.REASON_ON_DEDTROY);
        ON_DESTROY = r104;
        BlockLifeCycleEvent r105 = new BlockLifeCycleEvent("UNKNOWN", 5, "unknown");
        UNKNOWN = r105;
        f282975a = new BlockLifeCycleEvent[]{r100, r101, r102, r103, r104, r105};
    }

    public static BlockLifeCycleEvent[] values() {
        return (BlockLifeCycleEvent[]) f282975a.clone();
    }

    public static BlockLifeCycleEvent valueOf(String r100) {
        return (BlockLifeCycleEvent) r27.a.a(BlockLifeCycleEvent.class, r100);
    }

    public BlockLifeCycleEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.name = r102;
    }
}
