package kl0;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.lynx.bridge.LiveLynxBridgeModule;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.LynxView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends com.bytedance.ies.web.jsbridge2.b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f503837r = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LiveLynxBridgeModule f503838n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LynxView f503839o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f503840p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function0<String> f503841q;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void j(o r100) {
        Intrinsics.checkNotNullParameter(r100, "environment");
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final View g() {
        LynxView r100 = this.f503839o;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lynxView");
    L5:
        return r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final String h() {
        return this.f503841q.invoke();
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public Context getContext(o r100) {
        Intrinsics.checkNotNullParameter(r100, "environment");
        return this.f503840p;
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void k(String r100) {
        r(new JSONObject(r100));
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void l(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        r(r100);
    }

    public final void r(JSONObject r100) {
        Object r101 = r100.remove("__event_id");
        if ((r101 instanceof String) == true) goto L5;
        r101 = null;
    L5:
        String r102 = (String) r101;
        if (r102 != null) goto L8;
        return;
    L8:
        Object r103 = r100.remove("__params");
        if (r103 == null) goto L17;
        JSONObject r104 = new JSONObject();
        r104.put("code", 1);
        r104.put("data", r103);
        WritableMap r105 = b.d(r104);
        if (r105 == null) goto L18;
        LynxView r106 = this.f503839o;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("lynxView");
    L15:
        r106.sendGlobalEvent(r102, JavaOnlyArray.of(new Object[]{r105}));
        return;
    L18:
        return;
    }

    public c(Context r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "androidContext");
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f503840p = r100;
        this.f503841q = r101;
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void m(String r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r101 != null) goto L5;
        return;
    L5:
        LiveLynxBridgeModule r102 = this.f503838n;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeModule");
    L8:
        r102.invokeCallback$livehybrid_impl_saasRelease(new JSONObject(r100), r101);
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void n(JSONObject r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r101 != null) goto L5;
        return;
    L5:
        LiveLynxBridgeModule r102 = this.f503838n;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeModule");
    L8:
        r102.invokeCallback$livehybrid_impl_saasRelease(r100, r101);
    }
}
