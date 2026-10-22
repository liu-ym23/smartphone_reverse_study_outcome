package idb;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import java.util.HashSet;
import java.util.concurrent.Future;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends AbstractBaseSettingHandler {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f489449i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Future<HashSet<String>> f489450j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f489451a = null;

        static {
            f489451a = new c();
        }
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.a
    public final String a() {
        return "lark_features";
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
    public final String f() {
        return "DefaultFeatureGatingHandler";
    }

    public c() {
        this.f489449i = new Object();
        AbstractBaseSettingHandler.a r100 = this.f431105d;
        Function0 r101 = new b();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r100.a(r100.f431110a, r101);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f431107f = r100;
    }
}
