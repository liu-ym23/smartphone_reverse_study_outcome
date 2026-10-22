package com.ss.android.lark.lynxkit.host;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/LarkLynxHostLifecycleCallback;", "", SendEventContainerMethodParamModel.EventKinds.onShow, "", KtvSubElement.CONTAINER, "Lcom/ss/android/lark/lynxkit/container/ILarkLynxContainer;", "onHide", LiveCommonConstants.REASON_ON_DEDTROY, "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface LarkLynxHostLifecycleCallback {
    void onDestroy(ILarkLynxContainer r100);

    void onHide(ILarkLynxContainer r100);

    void onShow(ILarkLynxContainer r100);
}
