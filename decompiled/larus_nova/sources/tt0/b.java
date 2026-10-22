package tt0;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.ProfileFansClub;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.c1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.profile.ui.util.m;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f547504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f547505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f547506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f547507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f547508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f547509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f547510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f547511h;

    public b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f547511h = r100;
        LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_view_new_profile_tag_layout, r100, true);
        View r101 = r100.findViewById(R.id.profile_tag_fans_layout);
        this.f547504a = r101;
        this.f547506c = (TextView) r100.findViewById(R.id.profile_tag_never_join_fans_club);
        this.f547507d = (TextView) r100.findViewById(R.id.profile_tag_only_subscribe);
        if (r101 == null) goto L5;
        TextView r102 = (TextView) r101.findViewById(R.id.profile_tag_fans_name);
    L6:
        this.f547505b = r102;
        this.f547508e = r100.findViewById(R.id.profile_fans_club_count_layout);
        this.f547509f = (TextView) r100.findViewById(R.id.profile_fans_club_count);
        this.f547510g = (TextView) r100.findViewById(R.id.profile_fans_club_count_suffix);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void a(ProfileFansClub r100) {
        View r101 = this.f547508e;
        if (r101 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r101);
    L5:
        int r102 = m.f86955a;
        m.a(this.f547509f);
        if (r100 != null) goto L8;
        Pair<String, String> r103 = c1.b(0);
    L13:
        TextView r104 = this.f547509f;
        if (r104 == null) goto L16;
        r104.setText(((String) r103.first).toString());
    L16:
        TextView r105 = this.f547510g;
        if (r105 == null) goto L34;
        Object[] r106 = new Object[1];
        String r107 = (String) r103.second;
        if (r107 != null) goto L22;
        r107 = "";
    L22:
        r106[0] = r107;
        r105.setText(s1.C(R.string.ttlive_new_profile_fan_count_tv, r106));
        return;
    L34:
        return;
    L8:
        String r108 = r100.fansCountStr;
        if (r108 == null) goto L11;
    L24:
        if (r108 == null) goto L28;
        TextView r109 = this.f547509f;
        if (r109 == null) goto L28;
        r109.setText(r108);
    L28:
        String r110 = r100.fansCountSubStr;
        if (r110 == null) goto L35;
        TextView r111 = this.f547510g;
        if (r111 == null) goto L36;
        r111.setText(r110);
        return;
    L36:
        return;
    L35:
        return;
    L11:
        if (r100.fansCountSubStr != null) goto L24;
        r103 = c1.b(r100.totalFansCount);
        goto L13
    }
}
