package gp2;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.ui.base.f;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.base.l;
import com.bytedance.android.livesdk.profile.SaaSProfileInfoViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import qs0.w;

/* JADX INFO: loaded from: classes11.dex */
public class c extends zr0.a {

    public static final class a extends lt0.c {
        @Override // lt0.c, jt0.b
        public final boolean e(ProfileTagContent r100, NewProfileUser r101, h r102) {
            Intrinsics.checkNotNullParameter(r100, "tagContent");
            Intrinsics.checkNotNullParameter(r101, "user");
            Intrinsics.checkNotNullParameter(r102, "profileContext");
            return false;
        }

        public a() {
        }
    }

    @Override // zr0.a, com.bytedance.android.live.platform.ILiveProfilePlatformService
    public com.bytedance.android.live.profile.model.h getProfileBtnResource() {
        w r100 = os0.b.c().getSaaSAdapterService();
        boolean r101 = false;
        if (r100 == null) goto L5;
        boolean r102 = r100.enableDiffProfileStyle();
    L6:
        w r103 = os0.b.c().getSaaSAdapterService();
        if (r103 == null) goto L10;
        r101 = r103.canShowDouYinIM();
    L10:
        return new com.bytedance.android.live.profile.model.h(r102, r101);
    L5:
        r102 = false;
        goto L6
    }

    public c() {
    }

    @Override // zr0.a, com.bytedance.android.live.platform.ILiveProfilePlatformService
    public NewProfileInfoViewModel createProfileViewModel(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        return (NewProfileInfoViewModel) ViewModelProviders.of(r100).get(SaaSProfileInfoViewModel.class);
    }

    @Override // zr0.a, com.bytedance.android.live.platform.ILiveProfilePlatformService
    public List<f> processCompDescList(List<f> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        r100.add(new b());
        return r100;
    }

    @Override // zr0.a, com.bytedance.android.live.platform.ILiveProfilePlatformService
    public jt0.b createTagItem(l r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "hostBehavior");
        if (r101 == ProfileTagContent.TAG_TYPE_POI) goto L7;
        return null;
    L7:
        return new a();
    }
}
