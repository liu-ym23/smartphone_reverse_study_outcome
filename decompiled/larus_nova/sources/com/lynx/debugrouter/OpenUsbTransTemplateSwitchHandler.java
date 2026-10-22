package com.lynx.debugrouter;

import com.lynx.debugrouter.app.MessageHandleResult;
import com.lynx.debugrouter.app.MessageHandler;
import com.lynx.debugrouter.base.usb.USBTransTemplateUtil;
import com.lynx.debugrouter.log.LLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/lynx/debugrouter/OpenUsbTransTemplateSwitchHandler;", "Lcom/lynx/debugrouter/app/MessageHandler;", "()V", "getName", "", "handle", "Lcom/lynx/debugrouter/app/MessageHandleResult;", "params", "", "Companion", "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OpenUsbTransTemplateSwitchHandler implements MessageHandler {
    public static final Companion Companion = null;
    public static final String TAG = "USBTransTemplateSwitch";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/lynx/debugrouter/OpenUsbTransTemplateSwitchHandler$Companion;", "", "()V", "TAG", "", "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OpenUsbTransTemplateSwitchHandler() {
    }

    @Override // com.lynx.debugrouter.app.MessageHandler
    public String getName() {
        return "App.OpenUsbTransTemplateSwitch";
    }

    @Override // com.lynx.debugrouter.app.MessageHandler
    public MessageHandleResult handle(Map<String, String> r100) {
        LLog.i(TAG, "OpenUsbTransTemplateSwitchHandler handle");
        USBTransTemplateUtil.INSTANCE.setDebugPlatformSupport(true);
        return new MessageHandleResult();
    }
}
