package dk;

import android.view.View;
import com.bytedance.android.ec.hybrid.popup.j;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends com.bytedance.android.ec.hybrid.bridge.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ck.b f468983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f468984e;

    /* JADX INFO: renamed from: dk.a$a, reason: collision with other inner class name */
    public static final class C5680a {
    }

    static {
    }

    public a(ck.b r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        super("ec.popup_dismiss");
        this.f468983d = r100;
        this.f468984e = r101;
    }

    @Override // com.bytedance.android.ec.hybrid.bridge.b
    public final Pair<Boolean, String> a(IBDXBridgeContext r100, Map<String, ? extends Object> r101, Map<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "result");
        Object r103 = r101.get("container_id");
        if ((r103 instanceof String) == true) goto L5;
        r103 = null;
    L5:
        String r104 = (String) r103;
        View r105 = r100.getEngineView();
        if (r104 == null) goto L23;
        if (r105 == null) goto L23;
        if (Intrinsics.areEqual(r104, "self") == false) goto L20;
        j r106 = this.f468984e;
        if (r106 == null) goto L15;
        this.f468983d.f(r106);
    L15:
        if (this.f468984e == null) goto L17;
        boolean r107 = true;
    L19:
        return TuplesKt.to(Boolean.valueOf(r107), null);
    L17:
        r107 = false;
        goto L19
    L20:
        this.f468983d.finish(r104);
        return TuplesKt.to(Boolean.TRUE, null);
    L23:
        return TuplesKt.to(Boolean.FALSE, null);
    }
}
