package defpackage;

import com.bytedance.forest.Forest;
import com.bytedance.forest.model.o;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.base.d;
import com.bytedance.ies.argus.bean.config.f;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ies.argus.repository.ArgusConfigType;
import com.bytedance.ies.argus.repository.g;
import com.bytedance.ies.bullet.forest.ForestLoader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes42.dex */
public final class ExtraStrategyConfigManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<ArgusConfigType, Class<? extends com.bytedance.ies.argus.bean.config.a>> f1182b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<ExtraStrategyConfigManager> f1183c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<ArgusConfigType, com.bytedance.ies.argus.bean.config.a> f1184a;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f1185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArgusConfigType f1186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f1187c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.bytedance.ies.argus.bean.config.a f1188d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f1189e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f1185a == r101.f1185a) goto L12;
            return false;
        L12:
            if (this.f1186b == r101.f1186b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f1187c, r101.f1187c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f1188d, r101.f1188d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f1189e, r101.f1189e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            if (this.f1185a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = ((((r100 * 31) + this.f1186b.hashCode()) * 31) + this.f1187c.hashCode()) * 31;
            com.bytedance.ies.argus.bean.config.a r102 = this.f1188d;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r101 + r104) * 31;
            String r106 = this.f1189e;
            if (r106 == null) goto L15;
            r103 = r106.hashCode();
        L15:
            return r105 + r103;
        L9:
            r104 = r102.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "ConfigFetchResult(isSuccess=" + this.f1185a + ", configType=" + this.f1186b + ", channel=" + this.f1187c + ", config=" + this.f1188d + ", msg=" + this.f1189e + ')';
        }

        public b(boolean r100, ArgusConfigType r101, String r102, com.bytedance.ies.argus.bean.config.a r103, String r104) {
            Intrinsics.checkNotNullParameter(r101, "configType");
            Intrinsics.checkNotNullParameter(r102, "channel");
            this.f1185a = r100;
            this.f1186b = r101;
            this.f1187c = r102;
            this.f1188d = r103;
            this.f1189e = r104;
        }
    }

    static {
        f1182b = MapsKt.mapOf(new Pair[]{TuplesKt.to(ArgusConfigType.WEB_CONTENT_VERIFY_CONFIG, f.class), TuplesKt.to(ArgusConfigType.FE_CONFIG_WEB, com.bytedance.ies.argus.bean.config.b.class), TuplesKt.to(ArgusConfigType.FE_CONFIG_LYNX, com.bytedance.ies.argus.bean.config.b.class)});
        f1183c = LazyKt.lazy(ExtraStrategyConfigManager$Companion$instance$2.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a() {
        Lazy<ArgusConfigManager> r100 = ArgusConfigManager.f246083j;
        ArgusConfigManager r101 = ArgusConfigManager.a.a();
        Function1<com.bytedance.ies.argus.repository.f, Unit> r102 = new ExtraStrategyConfigManager$init$1(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "collector");
        g r103 = r101.f246085b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "collector");
        r103.f246098b.add((Function1<T, Unit>) r102);
    }

    public ExtraStrategyConfigManager() {
        this.f1184a = new ConcurrentHashMap();
    }

    public final void b(boolean r110, int r111) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        com.bytedance.ies.bullet.forest.f<String, o> r101 = ForestLoader.f246728a;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(ForestLoader.d());     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L9;
        r102 = null;
    L9:
        Forest r103 = (Forest) r102;
        if (r103 == null) goto L12;
        Lazy<ArgusEnv> r112 = ArgusEnv.f245917d;
        BuildersKt.launch$default(ArgusEnv.b.a().f245920c, null, null, new ExtraStrategyConfigManager$triggerFetchConfig$1(this, r103, r110, null), 3, null);
        return;
    L12:
        if (r111 < 2) goto L14;
        d.b("ExtraStrategyConfig", "ForestLoader.default = null, can not fetch config", null, 12);
        return;
    L14:
        Lazy<ArgusEnv> r104 = ArgusEnv.f245917d;
        BuildersKt.launch$default(ArgusEnv.b.a().f245920c, null, null, new ExtraStrategyConfigManager$retryTriggerFetchConfig$1(this, r110, r111, null), 3, null);
        return;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
