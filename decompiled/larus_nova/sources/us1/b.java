package us1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.config.od1;
import com.bytedance.android.livesdk.config.ph0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.z0;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f551438a = 0;

    public static boolean a() {
        float r100 = z0.b(true);
        if (r100 <= 0) goto L7;
        if (r100 >= od1.f120896a.getValue().floatValue()) goto L7;
    L12:
        return false;
    L7:
        if (ph0.f120980a.getValue().booleanValue() == false) goto L12;
        if (c() == true) goto L12;
        return true;
    }

    public static String b() {
        if (ph0.f120980a.getValue().booleanValue() == true) goto L7;
        return s1.B(R.string.ttlive_pk_interact_reject_link);
    L7:
        return s1.B(R.string.ttlive_interact_guest_can_not_support_audience_link_tips);
    }

    public static boolean c() {
        if (PadConfigUtils.c() == false) goto L5;
    L10:
        return true;
    L5:
        if (PadConfigUtils.c() == true) goto L10;
        if (FoldScreenUtils.f() == true) goto L10;
        return false;
    }

    static {
    }
}
