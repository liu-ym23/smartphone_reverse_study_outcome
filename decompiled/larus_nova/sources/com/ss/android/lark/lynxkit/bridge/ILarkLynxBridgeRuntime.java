package com.ss.android.lark.lynxkit.bridge;

import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntime;", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolHandle;", "configure", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolBuilderContext;", LynxViewpagerItem.BIND_ON_ATTACH, "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolContext;", "dispose", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILarkLynxBridgeRuntime extends ILarkLynxBridgeProtocolHandle {
    void attach(LarkLynxBridgeProtocolContext r100);

    void configure(LarkLynxBridgeProtocolBuilderContext r100);

    void dispose();
}
