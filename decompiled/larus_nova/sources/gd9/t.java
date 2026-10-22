package gd9;

import com.larus.im.depend.CallByNative;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
public interface t {

    public static final class a {
        public static /* synthetic */ e b(t r100, String r101, Map r102) throws Exception {
            return r100.a(r101, r102, MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ e a(t r100, String r101, Object r102, Map r103, Map r110, int r111) throws Exception {
            if ((r111 & 4) == 0) goto L5;
            r103 = MapsKt.emptyMap();
        L5:
            Map r104 = r103;
            if ((r111 & 8) == 0) goto L8;
            r110 = MapsKt.emptyMap();
        L8:
            Map r105 = r110;
            if ((r111 & 16) == 0) goto L11;
            Map r106 = MapsKt.emptyMap();
        L13:
            return r100.d(r101, r102, r104, r105, r106);
        L11:
            r106 = null;
            goto L13
        }
    }

    @CallByNative
    e a(String r100, Map<String, String> r101, Map<String, String> r102, Map<String, String> r103, Map<String, ? extends Object> r104) throws Exception;

    e b(String r100, String r101, Object r102, Map<String, String> r103, Map<String, String> r104, Map<String, ? extends Object> r105) throws Exception;

    e c(String r100, String r101, Map<String, String> r102, Map<String, String> r103, Map<String, ? extends Object> r104) throws Exception;

    @CallByNative
    e d(String r100, Object r101, Map<String, String> r102, Map<String, String> r103, Map<String, ? extends Object> r104) throws Exception;

    e e(String r100, Object r101, Map<String, String> r102, Map<String, String> r103, Map<String, Long> r104) throws Exception;

    e executeGet(String r100, Map<String, String> r101, Map<String, String> r102, Map<String, ? extends Object> r103) throws Exception;
}
