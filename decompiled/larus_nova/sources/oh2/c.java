package oh2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.BtmItemBuilder;

/* JADX INFO: loaded from: classes10.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void b(c r100, String r101, boolean r102, String r103, View r110) {
            r100.a(r101, r102, r103, null, r110);
        }

        public static /* synthetic */ void a(c r110, Context r111, String r112, Integer r113, com.bytedance.android.livesdk.livecommerce.intro.model.resp.b r114, com.bytedance.android.btm.api.model.d r115, String r116, il2.a r117) {
            r110.c(r111, r112, r113, r114, 0, 0, null, r115, r116, r117);
        }
    }

    void a(String r100, boolean r101, String r102, BtmItemBuilder r103, View r104);

    Long b(long r100, long r101);

    void c(Context r100, String r101, Integer r102, com.bytedance.android.livesdk.livecommerce.intro.model.resp.b r103, int r104, int r105, cf.a r106, com.bytedance.android.btm.api.model.d r107, String r108, il2.a r110);
}
