package ww5;

import com.bytedance.flow_audio.api.service.KmpTtsEventEnum;
import com.bytedance.flow_audio.api.service.KmpTtsLifeState;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r100, KmpTtsEventEnum r101, String r110, int r111, int r112) {
            if ((r112 & 2) == 0) goto L5;
            String r102 = "";
        L7:
            if ((r112 & 4) == 0) goto L9;
            int r103 = -1;
        L11:
            if ((r112 & 8) == 0) goto L13;
            String r104 = "";
        L15:
            if ((r112 & 16) == 0) goto L17;
            Map<String, ? extends Object> r105 = MapsKt.emptyMap();
        L18:
            r100.b(r101, r102, r103, r104, r105);
            return;
        L17:
            r105 = null;
            goto L18
        L13:
            r104 = null;
            goto L15
        L9:
            r103 = r111;
            goto L11
        L5:
            r102 = r110;
            goto L7
        }
    }

    void a(byte[] r100);

    void b(KmpTtsEventEnum r100, String r101, int r102, String r103, Map<String, ? extends Object> r104);

    void c(KmpTtsLifeState r100, String r101, Map<String, String> r102);
}
