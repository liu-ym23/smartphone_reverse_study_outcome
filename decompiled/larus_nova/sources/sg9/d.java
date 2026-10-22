package sg9;

import com.larus.ivykit.web.TTWebViewServiceImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class d implements com.bytedance.lynx.webview.internal.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TTWebViewServiceImpl f541890a;

    public d(TTWebViewServiceImpl r100) {
        this.f541890a = r100;
    }

    @Override // com.bytedance.lynx.webview.internal.c
    public final void a(int r100, JSONObject r101, JSONObject r102) {
        TTWebViewServiceImpl.b(this.f541890a, r100, r101, r102);
    }

    @Override // com.bytedance.lynx.webview.internal.c
    public final void b(int r100, JSONObject r101, JSONObject r102) {
        TTWebViewServiceImpl.b(this.f541890a, r100, r101, r102);
    }
}
