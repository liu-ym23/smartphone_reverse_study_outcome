package vx1;

import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends BaseJsBridgeMethodFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fw.a f557456a;

    public c(fw.a r100) {
        this.f557456a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory
    public final Map<String, n56.c> provideLegacyMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        fw.a r101 = this.f557456a;
        int r102 = e.f557458a;
        b r103 = new b(r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, "manager");
        Map r104 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r103, "manager");
        return MapsKt.plus(r104, MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory
    public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        fw.a r101 = this.f557456a;
        int r102 = e.f557458a;
        return r101.a(new b(r100));
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory
    public final Map<String, g<?, ?>> provideStatelessMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        fw.a r101 = this.f557456a;
        int r102 = e.f557458a;
        return r101.b(new b(r100));
    }
}
