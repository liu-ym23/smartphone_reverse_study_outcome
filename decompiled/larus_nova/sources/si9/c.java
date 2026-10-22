package si9;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f542243b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<b> f542244a;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f542245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f542246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f542247c;

        public final String getType() {
            return this.f542246b;
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "type");
            this.f542245a = r100;
            this.f542246b = r101;
            this.f542247c = "";
        }
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf("keys");
    }

    public c() {
    }
}
