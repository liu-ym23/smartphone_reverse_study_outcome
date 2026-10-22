package p04;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedActivity;
import com.bytedance.awemeopen.apps.framework.feed.profile.f;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.profile.likes.UserProfileLikeVideoViewHolder;
import com.bytedance.awemeopen.apps.framework.profile.likes.UserProfileLikesFragmentViewModel;
import com.bytedance.awemeopen.apps.framework.utils.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends o {
    public final /* synthetic */ UserProfileLikeVideoViewHolder d;
    public final /* synthetic */ jz3.a e;

    @Override // com.bytedance.awemeopen.apps.framework.utils.o
    public final void a() {
        UserProfileLikeVideoViewHolder r0 = this.d;
        int r8 = this.e.d;
        int r1 = UserProfileLikeVideoViewHolder.h;
        r0.getClass();
        String r2 = f.a;
        String r3 = r0.c.d.getUserOpenId();
        f.a.C0084a r4 = f.a.C0084a.a;
        long r5 = r0.c.d.maxCursor();
        boolean r6 = r0.c.d.hasMore();
        Object r7 = r0.c.d.getDataList().getValue();
        Intrinsics.checkNotNull(r7);
        f.a(r3, r4, r5, r6, (List) ((ListState) r7).a, r8, r0.c.d.getEnterAid());
        DampScrollableLayout r9 = m04.a.a;
        UserProfileLikesFragmentViewModel r10 = r0.c.d;
        Intrinsics.checkNotNullParameter(r10, "vm");
        m04.a.b = r10;
        int r11 = AosUserProfileFeedActivity.a;
        FragmentActivity r12 = r0.c.getActivity();
        Bundle r13 = new Bundle();
        r13.putByte("hide_long_press_tab", r0.c.d.getHideLongPressTab() ? 1 : 0);
        r13.putString("host_extra_param_json_str", r0.c.d.getHostExtraParams().toString());
        r13.putString("host_enter_from", r0.c.d.getHostEnterFrom());
        Unit r14 = Unit.INSTANCE;
        AosUserProfileFeedActivity.a.a(r12, r13);
    }

    public b(UserProfileLikeVideoViewHolder r1, jz3.a r2) {
        this.d = r1;
        this.e = r2;
    }
}
