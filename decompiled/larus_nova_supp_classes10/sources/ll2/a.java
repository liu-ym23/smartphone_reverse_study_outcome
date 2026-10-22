package ll2;

import com.bytedance.android.ec.live.api.commerce.userinfo.ECAuthorArea;
import com.bytedance.android.ec.monitor.duration.i;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends com.bytedance.android.ec.common.api.jump.model.a {
    public final Function0<ECAuthorArea> a;

    /* JADX INFO: renamed from: ll2.a$a, reason: collision with other inner class name */
    public static final class C0151a implements com.bytedance.android.ec.common.api.jump.model.a.a {
        public final Function0<ECAuthorArea> a;

        public C0151a(Function0<ECAuthorArea> r2) {
            Intrinsics.checkNotNullParameter(r2, "authorArea");
            this.a = r2;
        }

        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r4) {
            Intrinsics.checkNotNullParameter(r4, "modelClass");
            if (Intrinsics.areEqual(r4, Reflection.getOrCreateKotlinClass(a.class)) == false) goto L7;
            return new a(this.a, i.a.create("ec_perf_duration_live_user_info"));
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r4).newInstance();
        }
    }

    public a(Function0<ECAuthorArea> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "authorArea");
        Intrinsics.checkNotNullParameter(r3, "performanceMonitorKey");
        this.a = r2;
    }
}
