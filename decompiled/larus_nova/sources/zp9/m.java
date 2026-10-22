package zp9;

import android.view.View;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.profile.api.bean.UserCreationModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface m {

    public static final class a {
        public static void b(UserCreationModel r100, l0 r101) {
            Intrinsics.checkNotNullParameter(r100, "userCreationModel");
            Intrinsics.checkNotNullParameter(r101, "menuItem");
        }

        public static /* synthetic */ boolean a(m r100, UserCreation r101, int r102, String r103, String r110) {
            return r100.a(r101, r102, r103, r110, null);
        }
    }

    boolean a(UserCreation r100, int r101, String r102, String r103, @DoSameQuickMenuType String r104);

    boolean b(UserCreation r100);

    void c(TabItemInfo r100);

    void d(UserCreation r100);

    boolean e();

    void f(UserCreationModel r100, int r101);

    boolean g();

    void h(UserCreationModel r100, l0 r101, View r102);

    void i(UserCreation r100);
}
