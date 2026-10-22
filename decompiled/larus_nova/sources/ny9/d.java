package ny9;

import android.os.Bundle;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes31.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ Object a(d r100, Bundle r101, ICoreInputAbility.OnSendParams r110, boolean r111, String r112, Continuation r113, int r114) {
            if ((r114 & 1) == 0) goto L5;
            r101 = com.larus.utils.f.c(new Pair[0]);
        L5:
            Bundle r102 = r101;
            if ((r114 & 4) == 0) goto L8;
            boolean r103 = false;
        L10:
            if ((r114 & 8) == 0) goto L13;
            r112 = null;
        L13:
            return r100.a(r102, r110, r103, r112, r113);
        L8:
            r103 = r111;
            goto L10
        }

        public static /* synthetic */ Object b(d r100, Bundle r110, String r111, String r112, String r113, Map r114, String r115, Continuation r116) {
            return r100.b(r110, r111, r112, false, r113, r114, r115, r116);
        }
    }

    Object a(Bundle r100, ICoreInputAbility.OnSendParams r101, boolean r102, String r103, Continuation<? super Unit> r104);

    Object b(Bundle r100, String r101, String r102, boolean r103, String r104, Map<String, String> r105, String r106, Continuation<? super Unit> r107);
}
