package com.bytedance.ee.bear.document.keyboard;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeKeyboardPlugin extends DocumentPluginV3 {
    private static final String KEYBOARD_HEIGHT_HANDLE = "biz.util.keyboardHeight";
    private static final String TAG = "KeyboardPlugin";

    public static class a implements i<Keyboard> {
        public final OfficeKeyboardViewModel a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(OfficeKeyboardViewModel r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            Keyboard r3 = (Keyboard) r1;
            if (r3 == null) goto L5;
            this.a.setActive(r3.isActive());
            return;
        L5:
            this.a.setActive(false);
        }
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private OfficeKeyboardViewModel getKeyboardViewModel() {
        return (OfficeKeyboardViewModel) viewModel(OfficeKeyboardViewModel.class);
    }

    public OfficeKeyboardPlugin() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put(KEYBOARD_HEIGHT_HANDLE, new a(getKeyboardViewModel()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        OfficeKeyboardViewModel r0 = getKeyboardViewModel();
        h35.a.a(r3).registerEditPanel(r3.getLifecycleOwner(), r0);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }
}
