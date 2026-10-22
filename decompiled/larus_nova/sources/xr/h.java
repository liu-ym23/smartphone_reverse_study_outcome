package xr;

import android.content.Context;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public interface h extends o {

    public static final class a {
        public static /* synthetic */ void a(h r100, int r110, String r111, boolean r112, String r113, String r114, Integer r115, qv.d r116) {
            r100.o0(r110, r111, r112, r113, r114, r115, r116, null);
        }
    }

    void o0(int r100, String r101, boolean r102, String r103, String r104, Integer r105, qv.d r106, Map<String, String> r107);

    void openExternalBrowser(Context r100, String r101, String r102);

    void openLiveMiniPlay(Context r100, String r101, Map<String, ? extends Object> r102, Function0<Unit> r103, Function0<Unit> r104);

    void preloadInteractGame(String r100, String r101, Function0<Unit> r102, Function0<Unit> r103);

    void preloadMiniGame(String r100);
}
