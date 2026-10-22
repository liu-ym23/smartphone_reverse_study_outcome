package hi9;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import ei9.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface a<STATE extends f> {

    /* JADX INFO: renamed from: hi9.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes30.dex */
    public static final class C6150a {
        public static void a(f r100) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        }
    }

    boolean a(f r100);

    int b(STATE r100);
}
