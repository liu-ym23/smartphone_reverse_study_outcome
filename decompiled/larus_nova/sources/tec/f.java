package tec;

import android.view.View;
import com.ss.android.lark.widget.span.MediaInfo;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;
import mcc.h;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f545677a;

    public f(a r100) {
        this.f545677a = r100;
    }

    @Override // mcc.h
    public final void m(View r100, MediaInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, Keys.API_PARAM_KEY_MEDIA_INFO);
        h r102 = this.f545677a.f545668l;
        if (r102 == null) goto L6;
        r102.m(r100, r101);
        return;
    }
}
