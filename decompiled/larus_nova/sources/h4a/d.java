package h4a;

import android.app.Activity;
import com.ivy.ivykit.api.bridge.inject.IChooseMediaResultCallback;
import com.larus.xbridge.impl.choosemedia.BDXFileSelectionMethodHelper;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class d extends BDXFileSelectionMethodHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f483796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IChooseMediaResultCallback f483797d;

    @Override // j4a.f
    public final void a(final hx7.k r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Activity r101 = this.f483796c;
        if (r101 == null) goto L6;
        final IChooseMediaResultCallback r102 = this.f483797d;
        r101.runOnUiThread(new c(r102, r100));
        return;
    }

    @Override // j4a.f
    public final void onFailed(final int r100, final String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Activity r102 = this.f483796c;
        if (r102 == null) goto L6;
        final IChooseMediaResultCallback r103 = this.f483797d;
        r102.runOnUiThread(new b(r103, r100, r101));
        return;
    }

    public d(Activity r100, tx7.d.a r101, WeakReference r102) {
        this.f483796c = r100;
        this.f483797d = r101;
        super(r102);
    }
}
