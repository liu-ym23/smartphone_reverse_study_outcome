package ecc;

import android.view.View;
import com.ss.android.lark.widget.span.MediaInfo;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements mcc.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f472180a;

    public g(b r100) {
        this.f472180a = r100;
    }

    @Override // mcc.h
    public final void m(View r100, MediaInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, Keys.API_PARAM_KEY_MEDIA_INFO);
        mcc.h r102 = this.f472180a.f472173h;
        if (r102 == null) goto L6;
        r102.m(r100, r101);
        return;
    }
}
