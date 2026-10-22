package mm9;

import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514502a = 0;

    public static final class a implements com.larus.utils.gson.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f514503a;

        @Override // com.larus.utils.gson.e
        public final com.larus.utils.gson.c getConfig() {
            return (com.larus.utils.gson.c) this.f514503a.getValue();
        }

        public a() {
            this.f514503a = LazyKt.lazy(new f());
        }

        @Override // com.larus.utils.gson.e
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            FLogger.f375446a.i("GsonFilterNotNullManager", "onRemoveNull: " + r100);
        }

        @Override // com.larus.utils.gson.e
        public final void log(String r100) {
            Intrinsics.checkNotNullParameter("FilterNotNullManager", "tag");
            Intrinsics.checkNotNullParameter(r100, "msg");
            FLogger.f375446a.i("FilterNotNullManager", r100);
        }
    }

    static {
    }
}
