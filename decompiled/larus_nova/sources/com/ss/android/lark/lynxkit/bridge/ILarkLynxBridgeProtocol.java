package com.ss.android.lark.lynxkit.bridge;

import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocol;", "", LynxViewpagerItem.BIND_ON_ATTACH, "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolHandle;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolContext;", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILarkLynxBridgeProtocol {
    ILarkLynxBridgeProtocolHandle attach(LarkLynxBridgeProtocolContext r100);
}
