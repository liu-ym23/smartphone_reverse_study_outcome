package gn2;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.message.model.dj;
import com.bytedance.android.livesdk.message.model.hj;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f481800a = 0;

    static {
    }

    @JvmStatic
    public static final int a(hj r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recommendUserMessage");
        int r102 = s1.j(R.dimen.ttlive_recommend_user_margin_top);
        int r103 = s1.j(R.dimen.ttlive_recommend_user_height);
        int r104 = r100.getUsers().size();
        int r105 = r101 - r102;
        if (r105 <= 0) goto L6;
        r103 = r105;
    L6:
        if (r104 == 1) goto L8;
        return r103;
    L8:
        if (r100.getUsers() != null) goto L10;
        return 0;
    L10:
        if (r100.getUsers().size() != 1) goto L21;
        dj r106 = (dj) ListProtector.get(r100.getUsers(), 0);
        if (TextUtils.isEmpty(r106.a()) == false) goto L14;
    L16:
        int r107 = s1.j(R.dimen.ttlive_recommend_single_user_height);
    L18:
        return r107;
    L14:
        if (TextUtils.isEmpty(r106.d()) == true) goto L16;
        r107 = s1.j(R.dimen.ttlive_recommend_single_all_config_user_height);
        goto L18
    L21:
        return 0;
    }
}
