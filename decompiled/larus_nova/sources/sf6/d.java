package sf6;

import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes19.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void a(yf6.b r100, Function0 r101) {
            r100.h("on_start_rtc_success", null, null, r101);
        }
    }

    void Z(String r100, String r101, AckFromSource r102);

    void f(String r100);

    void h(String r100, Function0<Boolean> r101, Function0<Boolean> r102, Function0<Boolean> r103);
}
