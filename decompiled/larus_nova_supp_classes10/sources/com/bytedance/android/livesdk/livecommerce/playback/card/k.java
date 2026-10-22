package com.bytedance.android.livesdk.livecommerce.playback.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k extends QUIModule {
    public final Fragment l;

    public final QIPresenter h() {
        return new ExplainPlaybackCardPresenter(this.l);
    }

    public k(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(0);
        this.l = r2;
    }

    public final View f(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r3 == null) goto L7;
        View r4 = r3.findViewById(2131372698);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new View(r2);
    }
}
