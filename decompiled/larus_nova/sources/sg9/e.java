package sg9;

import com.bytedance.lynx.webview.TTWebSdk;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.essentialtask.ipc.EssentialTaskIPCProvider;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class e extends TTWebSdk.h {
    @Override // com.bytedance.lynx.webview.TTWebSdk.h
    public final void a() {
        FLogger.f375446a.i("TTWebViewServiceImpl", "init ttwebview finished");
        o r100 = o.f365780a;
        JSONObject r101 = new JSONObject();
        r101.put(EssentialTaskIPCProvider.KEY_IS_SUCCEED, TTWebSdk.isTTWebView());
        Unit r102 = Unit.INSTANCE;
        r100.reportEvent("ttwebview_init", r101);
    }

    public e() {
    }
}
