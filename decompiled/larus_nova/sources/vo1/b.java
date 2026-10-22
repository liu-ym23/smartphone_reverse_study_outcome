package vo1;

import android.view.View;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.utils.c0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f556487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f556488b;

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
        if (r100 == null) goto L11;
        d0 r101 = this.f556487a;
        if (r101 == null) goto L7;
        r101.g(r100);
    L7:
        d0 r102 = this.f556487a;
        if (r102 == null) goto L12;
        r102.d(r100);
        return;
    L12:
        return;
    }

    public b(d0 r100, String r101) {
        this.f556487a = r100;
        this.f556488b = r101;
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        d0 r102 = this.f556487a;
        if (r102 == null) goto L6;
        r102.a();
    L6:
        return super.onFallback(r100, r101);
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r100, boolean r101) {
        super.onLoadStart(r100, r101);
        if (r100 == null) goto L8;
        d0 r102 = this.f556487a;
        if (r102 == null) goto L9;
        r102.e(r100, this.f556488b);
        return;
    L9:
        return;
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        super.onContainerError(r100, r101, r102);
        if (r100 == null) goto L7;
        d0 r103 = this.f556487a;
        if (r103 == null) goto L7;
        r103.f(r100, r102);
    L7:
        int r104 = c0.f158902a;
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        v.a();
    }
}
