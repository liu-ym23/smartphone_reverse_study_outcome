package cs2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.profit.lottery.c3;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0.a f465167a;

    public final b d() {
        this.f465167a.setCornerRadius(16.0f);
        return this;
    }

    @Override // cs2.a
    public Context getContext() {
        return this.f465167a.getContext();
    }

    public final Dialog h() {
        return this.f465167a.f();
    }

    public final b f() {
        this.f465167a.setTitle(R.string.ttlive_live_prop_count_error_title);
        return this;
    }

    public b(x0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f465167a = r100;
    }

    public final b c(boolean r100) {
        this.f465167a.d(r100);
        return this;
    }

    public final b e(CharSequence r100) {
        this.f465167a.b(r100);
        return this;
    }

    public final b g(CharSequence r100) {
        this.f465167a.setTitle(r100);
        return this;
    }

    public final b b(CharSequence r100, c3 r101) {
        this.f465167a.e(0, r100, r101);
        return this;
    }

    public final b a(int r100, int r101, DialogInterface.OnClickListener r102) {
        this.f465167a.a(r100, r101, r102);
        return this;
    }
}
