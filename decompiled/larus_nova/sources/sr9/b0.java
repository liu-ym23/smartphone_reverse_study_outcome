package sr9;

import android.content.Context;
import com.larus.bmhome.utils.c4;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class b0 implements com.larus.bmhome.video.save_share.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f543236a = null;

    static {
        f543236a = new b0();
    }

    public b0() {
    }

    @Override // com.larus.bmhome.video.save_share.a
    public final void b(Context r100, nr9.g r101, c4 r102, String r103, CoroutineScope r104, boolean r105, boolean r106, JSONObject r107, Map<String, String> r108, String r110, boolean r111, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r112) {
        Intrinsics.checkNotNullParameter(r102, "videoDetailEventParams");
        Intrinsics.checkNotNullParameter(r103, "clickMethod");
        Intrinsics.checkNotNullParameter(r104, "scope");
        Intrinsics.checkNotNullParameter(r112, "dismissLoadingCallback");
        r112.invoke(501, "", 0L, Boolean.FALSE);
    }
}
