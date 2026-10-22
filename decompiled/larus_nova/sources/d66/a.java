package d66;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f467198e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f467199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f467200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f467201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C5640a f467202d;

    /* JADX INFO: renamed from: d66.a$a, reason: collision with other inner class name */
    public static final class C5640a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f467203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f467204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f467205c;

        public C5640a(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "file");
            Intrinsics.checkNotNullParameter(r101, "function");
            this.f467203a = r100;
            this.f467204b = r101;
            this.f467205c = r102;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"level", "message", "tag", "codePosition"});
    }

    public a() {
    }
}
