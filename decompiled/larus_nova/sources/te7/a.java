package te7;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.lynx.tasm.LynxError;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public interface a {

    /* JADX INFO: renamed from: te7.a$a, reason: collision with other inner class name */
    public static final class C7714a {
        public static void a(JSONObject r100, LinkedHashMap r101, String r102, Throwable r103) {
            Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
            Intrinsics.checkNotNullParameter(r101, "responseHeader");
            Intrinsics.checkNotNullParameter(r102, "rawResponse");
            Intrinsics.checkNotNullParameter(r103, LynxError.LYNX_THROWABLE);
        }
    }

    void a(JSONObject r100, LinkedHashMap<String, String> r101, Integer r102, int r103);

    Unit b(JSONObject r100, LinkedHashMap<String, String> r101, String r102, Throwable r103, Integer r104, int r105);

    void c(Integer r100, LinkedHashMap<String, String> r101, Throwable r102, int r103);
}
