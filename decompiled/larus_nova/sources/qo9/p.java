package qo9;

import android.view.View;
import com.larus.bmhome.ability.FloatChatWindowState;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
public final class p implements va8.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f534320a;

    public p(o r100) {
        this.f534320a = r100;
    }

    @Override // va8.i
    public final void LS(float r100) {
        float r101 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        this.f534320a.i((int) (100 * r101));
        View r102 = this.f534320a.f534310l;
        if (r102 == null) goto L5;
        r102.setAlpha(r101);
    L5:
        View r103 = this.f534320a.f534310l;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r101 <= 0.0f) goto L10;
        int r104 = 0;
    L11:
        r103.setVisibility(r104);
        return;
    L10:
        r104 = 8;
        goto L11
    }

    @Override // va8.i
    public final void am(va8.h r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        o r101 = this.f534320a;
        r101.f534312n = r100.f553966a;
        r101.i(r100.f553968c);
        o r102 = this.f534320a;
        if (r100.f553966a != FloatChatWindowState.Expanded) goto L5;
        boolean r103 = true;
    L6:
        r102.h(r103, "window_state", false);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
