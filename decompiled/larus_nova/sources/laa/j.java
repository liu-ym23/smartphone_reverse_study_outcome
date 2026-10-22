package laa;

import android.widget.LinearLayout;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.im.bean.message.Message;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.ability.ObricSpecialInputScene;
import java.util.Map;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: classes32.dex */
public interface j extends m1a.a {

    public static final class a {
        public static /* synthetic */ void a(j r100, boolean r101, StateInfo r102, ObricSpecialInputScene r110, z0 r111, boolean r112, boolean r113, int r114) {
            if ((r114 & 1) == 0) goto L5;
            boolean r103 = true;
        L7:
            if ((r114 & 2) == 0) goto L9;
            StateInfo r104 = null;
        L11:
            if ((r114 & 4) == 0) goto L13;
            ObricSpecialInputScene r105 = null;
        L15:
            if ((r114 & 8) == 0) goto L17;
            z0 r106 = null;
        L19:
            if ((r114 & 16) == 0) goto L21;
            boolean r107 = false;
        L23:
            if ((r114 & 64) == 0) goto L25;
            boolean r108 = false;
        L26:
            r100.zI(r103, r104, r105, r106, r107, r108);
            return;
        L25:
            r108 = r113;
            goto L26
        L21:
            r107 = r112;
            goto L23
        L17:
            r106 = r111;
            goto L19
        L13:
            r105 = r110;
            goto L15
        L9:
            r104 = r102;
            goto L11
        L5:
            r103 = r101;
            goto L7
        }
    }

    void Fq(LinearLayout r100);

    void HY();

    boolean J70();

    b1 O4();

    void RC(u r100);

    boolean Re();

    void Z50(Message r100, String r101, Map<String, String> r102);

    void e00(u r100);

    void e90();

    void ed();

    b1 i80();

    void j1(boolean r100);

    boolean or();

    void ph();

    void td();

    void zI(boolean r100, StateInfo r101, ObricSpecialInputScene r102, z0 r103, boolean r104, boolean r105);
}
