package com.larus.bmhome.video.save_share;

import android.content.Context;
import com.larus.bmhome.utils.c4;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.bmhome.video.save_share.a$a, reason: collision with other inner class name */
    public static final class C4112a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(a r110, Context r111, nr9.g r112, c4 r113, String r114, CoroutineScope r210, boolean r211, boolean r212, JSONObject r213, Map r214, String r215, boolean r216, Function4 r217, int r218) {
            if ((r218 & 32) == 0) goto L5;
            boolean r100 = true;
        L7:
            if ((r218 & 64) == 0) goto L9;
            boolean r101 = false;
        L11:
            if ((r218 & 128) == 0) goto L13;
            JSONObject r115 = null;
        L15:
            if ((r218 & 256) == 0) goto L17;
            Map r116 = null;
        L19:
            if ((r218 & 512) == 0) goto L21;
            String r117 = null;
        L23:
            if ((r218 & 1024) == 0) goto L25;
            boolean r118 = false;
        L26:
            r110.b(r111, r112, r113, r114, r210, r100, r101, r115, r116, r117, r118, r217);
            return;
        L25:
            r118 = r216;
            goto L26
        L21:
            r117 = r215;
            goto L23
        L17:
            r116 = r214;
            goto L19
        L13:
            r115 = r213;
            goto L15
        L9:
            r101 = r212;
            goto L11
        L5:
            r100 = r211;
            goto L7
        }
    }

    void b(Context r100, nr9.g r101, c4 r102, String r103, CoroutineScope r104, boolean r105, boolean r106, JSONObject r107, Map<String, String> r108, String r110, boolean r111, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r112);
}
