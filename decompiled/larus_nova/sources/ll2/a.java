package ll2;

import com.bytedance.android.ec.live.api.commerce.userinfo.ECAuthorArea;
import com.bytedance.android.ec.monitor.duration.i;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends com.bytedance.android.ec.common.api.jump.model.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<ECAuthorArea> f509673a;

    /* JADX INFO: renamed from: ll2.a$a, reason: collision with other inner class name */
    public static final class C6707a implements com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<ECAuthorArea> f509674a;

        public C6707a(Function0<ECAuthorArea> r100) {
            Intrinsics.checkNotNullParameter(r100, "authorArea");
            this.f509674a = r100;
        }

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a
        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            if (Intrinsics.areEqual(r100, Reflection.getOrCreateKotlinClass(a.class)) == false) goto L7;
            return new a(this.f509674a, i.f47987a.create("ec_perf_duration_live_user_info"));
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r100).newInstance();
        }
    }

    public a(Function0<ECAuthorArea> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "authorArea");
        Intrinsics.checkNotNullParameter(r101, "performanceMonitorKey");
        this.f509673a = r100;
    }
}
