package dl0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o implements a<c.d, User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<User> f469075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c.d f469076b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f469077c = null;

    public o() {
    }

    static {
        f469077c = new o();
        f469076b = c.d.f469059a;
    }

    public final boolean d() {
        WeakReference<User> r100 = f469075a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        User r101 = r100.get();
        if (r101 != null) goto L8;
        return false;
    L8:
        FollowInfo r102 = r101.getFollowInfo();
        if (r102 == null) goto L11;
        Long r103 = Long.valueOf(r102.getFollowStatus());
    L12:
        if (r103 != null) goto L15;
    L16:
        if (r103 != null) goto L19;
        return false;
    L19:
        if (r103.longValue() != 3) goto L22;
    L20:
        return true;
    L22:
        return false;
    L15:
        if (r103.longValue() == 2) goto L20;
    L11:
        r103 = null;
        goto L12
    }

    @Override // dl0.a
    public final c b() {
        return f469076b;
    }

    @Override // dl0.a
    public final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        WeakReference<User> r101 = f469075a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        User r102 = r101.get();
        if (r102 != null) goto L8;
        return;
    L8:
        FollowInfo r103 = r102.getFollowInfo();
        if (r103 == null) goto L11;
        Long r104 = Long.valueOf(r103.getFollowStatus());
    L12:
        TextView r105 = (TextView) r100.findViewById(R.id.tv_friend);
        r105.setTextColor(s1.h(R.color.ttlive_white));
        r105.setPadding((int) s1.e(6.0f), 0, (int) s1.e(6.0f), 0);
        if (r104 != null) goto L16;
    L18:
        if (r104 != null) goto L21;
        return;
    L21:
        if (r104.longValue() != 3) goto L25;
        r105.setText(s1.B(R.string.ttlive_user_relation_fans));
        return;
    L25:
        return;
    L16:
        if (r104.longValue() != 2) goto L18;
        r105.setText(s1.B(R.string.ttlive_user_relation_friends));
        return;
    L11:
        r104 = null;
        goto L12
    }

    @Override // dl0.a
    public final View a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        return LayoutInflater.from(r100).inflate(R.layout.ttlive_badge_pk_relation_layout, r101, false);
    }
}
