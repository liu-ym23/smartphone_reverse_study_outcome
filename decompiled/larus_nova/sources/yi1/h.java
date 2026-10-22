package yi1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends BaseJsBridgeMethodFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f567859a;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f567860a;

        public a(h r100) {
            this.f567860a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            ALogger.i("ttlive_anchor_swallow_back", "find jsb live.audiencePageCloseAndJump");
            return new c(this.f567860a.f567859a);
        }
    }

    public h(WeakReference r100) {
        this.f567859a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideStatefulMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.mapOf(TuplesKt.to("live.audiencePageCloseAndJump", new a(this)));
    }
}
