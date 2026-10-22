package mm9;

import com.larus.utils.gson.e;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public static final class a implements e {
        public final Lazy a;

        @Override // com.larus.utils.gson.e
        public final com.larus.utils.gson.c getConfig() {
            return (com.larus.utils.gson.c) this.a.getValue();
        }

        public a() {
            this.a = LazyKt.lazy(new f());
        }

        @Override // com.larus.utils.gson.e
        public final void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "type");
            FLogger.a.i("GsonFilterNotNullManager", "onRemoveNull: " + r4);
        }

        @Override // com.larus.utils.gson.e
        public final void log(String r3) {
            Intrinsics.checkNotNullParameter("FilterNotNullManager", "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            FLogger.a.i("FilterNotNullManager", r3);
        }
    }

    static {
    }
}
