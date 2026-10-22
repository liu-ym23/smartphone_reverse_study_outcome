package zb8;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.chat.gallery.impl.preview.input.s;
import com.larus.platform.model.action.SuggestedAction;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public interface e extends m1a.a {

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void a(e r100, f r101, s r102, int r103) {
            Function0<Boolean> r104 = r102;
            if ((r103 & 2) == 0) goto L6;
            r104 = new c();
        L6:
            if ((r103 & 4) == 0) goto L8;
            Function0<Unit> r105 = new d();
        L9:
            r100.mQ(r101, r104, r105);
            return;
        L8:
            r105 = null;
            goto L9
        }

        public static /* synthetic */ void b(e r110, String r111, HashMap r112, zb8.a r113, CameraResultRoute r114, CameraOutputContext r115, boolean r116, int r117) {
            if ((r117 & 4) == 0) goto L5;
            zb8.a r100 = null;
        L7:
            if ((r117 & 16) == 0) goto L9;
            CameraResultRoute r101 = null;
        L11:
            if ((r117 & 32) == 0) goto L13;
            CameraOutputContext r102 = null;
        L15:
            if ((r117 & 64) == 0) goto L17;
            boolean r103 = false;
        L18:
            r110.L40(r111, r112, r100, null, r101, r102, r103);
            return;
        L17:
            r103 = r116;
            goto L18
        L13:
            r102 = r115;
            goto L15
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    void D40(boolean r100);

    void L40(String r100, HashMap<String, Object> r101, zb8.a r102, String r103, CameraResultRoute r104, CameraOutputContext r105, boolean r106);

    void MI();

    SuggestedAction Pc();

    boolean bM();

    boolean gs(String r100);

    boolean jH();

    void kL(boolean r100);

    void mQ(f r100, Function0<Boolean> r101, Function0<Unit> r102);

    void md(b r100);

    boolean qt();

    void wl();

    void y80();
}
