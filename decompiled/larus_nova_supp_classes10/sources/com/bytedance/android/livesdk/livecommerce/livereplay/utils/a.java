package com.bytedance.android.livesdk.livecommerce.livereplay.utils;

import android.text.TextUtils;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECReplayScrollProductCardViewModel;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.c;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public static dm.a.b c() {
        return dm.a.a("EC_LIVE_REPLAY");
    }

    static {
    }

    public static boolean b(String r1) {
        return TextUtils.equals(r1, "live_fragment_replay");
    }

    public static AbsECScrollProductCardBaseVideModel a(QContext r1, String r2, ViewModelProvider.Factory r3) {
        Intrinsics.checkNotNullParameter(r1, "qContext");
        Intrinsics.checkNotNullParameter(r3, "factory");
        if (b(r2) == false) goto L6;
        return c.a(r1, ECReplayScrollProductCardViewModel.class, r3);
    L6:
        return c.a(r1, ECScrollProductCardViewModel.class, r3);
    }
}
