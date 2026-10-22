package jt0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.profile.ui.base.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public interface b {

    public static final class a {
        public static void a(ProfileTagContent r100, NewProfileUser r101, h r102) {
            Intrinsics.checkNotNullParameter(r100, "tagContent");
            Intrinsics.checkNotNullParameter(r101, "user");
            Intrinsics.checkNotNullParameter(r102, "profileContext");
        }

        public static void b(ProfileTagContent r100, NewProfileUser r101, h r102) {
            Intrinsics.checkNotNullParameter(r100, "tagContent");
            Intrinsics.checkNotNullParameter(r101, "user");
            Intrinsics.checkNotNullParameter(r102, "profileContext");
        }
    }

    ViewGroup.LayoutParams a();

    boolean b(ProfileTagContent r100, h r101);

    void c(Fragment r100, View r101, ProfileTagContent r102, h r103, NewProfileUser r104);

    View d(Context r100);

    boolean e(ProfileTagContent r100, NewProfileUser r101, h r102);

    void f(NewProfileUser r100, h r101);

    void g(ProfileTagContent r100, NewProfileUser r101, h r102);

    long getType();

    void h(ProfileTagContent r100, NewProfileUser r101, h r102);
}
