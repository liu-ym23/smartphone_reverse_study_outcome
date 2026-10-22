package com.lynx.debugrouter;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.debugrouter.app.MessageHandleResult;
import com.lynx.debugrouter.app.MessageHandler;
import com.lynx.debugrouter.base.usb.TemplateData;
import com.lynx.debugrouter.base.usb.TemplateFileSize;
import com.lynx.debugrouter.base.usb.USBTransTemplateUtil;
import com.lynx.debugrouter.log.LLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/lynx/debugrouter/ReceiveTemplateByUsbHandler;", "Lcom/lynx/debugrouter/app/MessageHandler;", "()V", "getName", "", "handle", "Lcom/lynx/debugrouter/app/MessageHandleResult;", "params", "", "Companion", "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReceiveTemplateByUsbHandler implements MessageHandler {
    public static final Companion Companion = null;
    public static final String TAG = "USBTransTemplateReceive";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/lynx/debugrouter/ReceiveTemplateByUsbHandler$Companion;", "", "()V", "TAG", "", "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public ReceiveTemplateByUsbHandler() {
    }

    @Override // com.lynx.debugrouter.app.MessageHandler
    public String getName() {
        return "App.ReceiveTemplateByUsb";
    }

    @Override // com.lynx.debugrouter.app.MessageHandler
    public MessageHandleResult handle(Map<String, String> r100) {
        LLog.i(TAG, "ReceiveTemplateByUsbHandler handle");
        if (r100 == null) goto L7;
        String r101 = r100.get("requestId");
        if (r101 == null) goto L7;
        long r102 = CastLongProtector.parseLong(r101);
    L9:
        if (r102 != (-1)) goto L12;
        LLog.e(TAG, "reqId == " + r102);
        return new MessageHandleResult(-1, "illegal message: reqId == " + r102);
    L12:
        LLog.i(TAG, "Receive data reqId: " + r102);
        String r103 = null;
        if (r100 == null) goto L15;
        String r104 = r100.get("error");
    L16:
        if (r104 == null) goto L19;
        LLog.i(TAG, "Receive error: ".concat(r104));
        USBTransTemplateUtil.INSTANCE.receiveResponseSize(r102, new TemplateFileSize(-2, -2));
        return new MessageHandleResult();
    L19:
        if (r100 == null) goto L21;
        r103 = r100.get("data");
    L21:
        if (r100 == null) goto L25;
        String r105 = r100.get("seqId");
        if (r105 == null) goto L25;
        int r106 = CastIntegerProtector.parseInt(r105);
    L26:
        if (r106 == (-1)) goto L44;
        if (r103 == null) goto L44;
        USBTransTemplateUtil r107 = USBTransTemplateUtil.INSTANCE;
        r107.receiveData(r102, new TemplateData(r106, r103));
        String r108 = r100.get("seq_count");
        if (r108 == null) goto L32;
        int r109 = CastIntegerProtector.parseInt(r108);
    L33:
        String r110 = r100.get("tem_file_len");
        if (r110 == null) goto L36;
        int r111 = CastIntegerProtector.parseInt(r110);
    L38:
        if (r109 == (-1)) goto L42;
        if (r111 == (-1)) goto L42;
        LLog.i(TAG, "Receive ResponseSize: seqCount = " + r109 + ", tem_file_len = " + r111);
        r107.receiveResponseSize(r102, new TemplateFileSize(r109, r111));
        return new MessageHandleResult();
    L42:
        LLog.e(TAG, "seqCount = " + r109 + ", tem_file_len = " + r111);
        return new MessageHandleResult(-1, "illegal seqCount or temLen");
    L36:
        r111 = -1;
        goto L38
    L32:
        r109 = -1;
    L44:
        LLog.e(TAG, "seqId = " + r106 + ", data == " + r103);
        return new MessageHandleResult(-1, "illegal message: seqId = " + r106 + ", data == " + r103);
    L25:
        r106 = -1;
        goto L26
    L15:
        r104 = null;
    L7:
        r102 = -1;
        goto L9
    }
}
