package qe;

import android.view.View;
import com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent;
import com.bytedance.ies.web.jsbridge2.g;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements pd.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IExternalLiveAnnieComponent f532607a;

    @Override // pd.b
    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
    }

    @Override // pd.b
    public final View getHybridView() {
        View r100 = this.f532607a.getHybridView();
        if (r100 != null) goto L5;
        Object r101 = "null";
    L6:
        r101.toString();
        return r100;
    L5:
        r101 = r100;
        goto L6
    }

    @Override // pd.b
    public final void release() {
        this.f532607a.release();
    }

    public b(IExternalLiveAnnieComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        this.f532607a = r100;
    }

    @Override // pd.b
    public final void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f532607a.updateData(r100);
    }

    @Override // pd.b
    public final void load(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f532607a.load(r100, r101);
    }

    @Override // pd.b
    public final void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f532607a.registerMethod(r100, r101);
    }

    @Override // pd.b
    public final <T> void sendJsEvent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f532607a.sendJsEvent(r100, r101);
    }

    @Override // pd.b
    public final <P, R> void registerMethod(String r100, g<P, R> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        this.f532607a.registerMethod(r100, r101);
    }
}
