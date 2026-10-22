package ko4;

import android.content.Context;
import com.bytedance.ee.bear.lark.dependency.n;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends io4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f504428b;

    public static final class a {
    }

    static {
    }

    public d() {
        this.f504428b = "bitable.common.openChatById";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f504428b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "type");
        Object r102 = r100.toMap().get("chatId");
        if ((r102 instanceof String) == false) goto L5;
        String r103 = (String) r102;
    L6:
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L16;
        tt5.a.d("BitableOpenChatByIdMethod", "open chat failed: chatId is empty");
        XCoreBridgeMethod.onFailure$default(this, r101, 0, "chatId is empty", null, 8, null);
        return;
    L16:
        Context r105 = (Context) provideContext(Context.class);
        if (r105 != null) goto L31;
        tt5.a.d("BitableOpenChatByIdMethod", "open chat failed: context not found");
        XCoreBridgeMethod.onFailure$default(this, r101, 0, "context not found", null, 8, null);
        return;
    L31:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L22
        ((n) org.koin.java.a.c(n.class, null, null, 6)).q(r105);     // Catch: Throwable -> L22
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L25:
        if (Result.m9456isSuccessimpl(r107) == false) goto L27;
        Unit r108 = (Unit) r107;
        XCoreBridgeMethod.onSuccess$default(this, r101, new LinkedHashMap(), null, 4, null);
    L27:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r107);
        if (r109 == null) goto L33;
        tt5.a.d("BitableOpenChatByIdMethod", "open chat failed: " + r109.getMessage());
        XCoreBridgeMethod.onFailure$default(this, r101, 0, "open chat failed", null, 8, null);
        return;
    L33:
        return;
    L22:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L8:
        if (StringsKt.isBlank(r103) == true) goto L11;
        r104 = false;
        goto L13
    L5:
        r103 = null;
        goto L6
    }
}
