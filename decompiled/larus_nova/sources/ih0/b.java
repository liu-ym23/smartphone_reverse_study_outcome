package ih0;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import vlc.l;

/* JADX INFO: loaded from: classes46.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ c a(b r100, Context r101, Uri r102, b7.a r110, long r111) {
            return r100.Bi(r101, r102, r110, r111, null);
        }
    }

    void B1(f r100, h r101, boolean r102);

    com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c Bi(Context r100, Uri r101, b7.a r102, long r103, DataCenter r104);

    void Dk(String r100, String r101, JsonObject r102, boolean r103);

    void E6(String r100, g r101);

    void Gb(String r100, c r101);

    void Ll(List<? extends tf0.e> r100);

    JsonObject Nm();

    Map<Integer, List<Integer>> Pl();

    JsonObject T(e r100);

    void Tl(c r100);

    l U6(String r100);

    Object Xg();

    c Z9();

    Map<String, LayoutConfigModel> en();

    void fa(c r100);

    boolean isDynamicAnimating();

    void jc(String r100);

    boolean jl(String r100);

    void oe(String r100, l r101);

    c oo();

    Object ql(String r100);

    void setDynamicAnimatorListener(Function0<Unit> r100);

    c tb();

    void updateViewInLiveBg(String r100, JsonObject r101, h r102);
}
