package dd7;

import android.app.Activity;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes22.dex */
public final class h extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f468032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LynxContext f468033d;

    @Override // cd7.a
    public final void addJavascriptInterface(Object r100, String r101) {
    }

    @Override // cd7.a
    public final void b(String r100, yc7.b.a r101) {
    }

    @Override // cd7.a
    public final void loadUrl(String r100) {
    }

    @Override // dd7.a, cd7.a
    public Activity getActivity() {
        int r100 = g.f468031a;
        return null;
    }

    public final LynxContext getContext() {
        return this.f468033d;
    }

    @Override // cd7.a
    public final String getUrl() {
        return this.f468032c;
    }

    public h(LynxContext r100) {
        this.f468033d = r100;
        this.f468032c = "sslocal://lynx_bridge";
    }
}
