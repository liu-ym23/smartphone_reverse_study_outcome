package com.bytedance.ee.bear.document.keyboard;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class KeyboardPlugin extends DocumentPluginV2 {
    private static final String KEYBOARD_HEIGHT_HANDLE = "biz.util.keyboardHeight";
    private static final String TAG = "KeyboardPlugin";

    public static class a implements i<Keyboard> {
        public final KeyboardViewModel a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(KeyboardViewModel r1) {
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

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private KeyboardViewModel getKeyboardViewModel() {
        return (KeyboardViewModel) viewModel(KeyboardViewModel.class);
    }

    public KeyboardPlugin() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put(KEYBOARD_HEIGHT_HANDLE, new a(getKeyboardViewModel()));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        KeyboardViewModel r0 = getKeyboardViewModel();
        ((DocumentPluginHost) r3).b().registerEditPanel(r3.getLifecycleOwner(), r0);
    }
}
