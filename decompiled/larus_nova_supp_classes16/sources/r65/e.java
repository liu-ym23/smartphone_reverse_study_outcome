package r65;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends m75.a<c> {
    public static final /* synthetic */ int j = 0;
    public final FragmentActivity e;
    public final o75.a f;
    public String g;
    public String h;
    public final a95.a i;

    public static final class a {
    }

    static {
    }

    public final FragmentActivity getActivity() {
        return this.e;
    }

    public e(FragmentActivity r2, o75.a r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "driveConfigService");
        super(r2);
        this.e = r2;
        this.f = r3;
        int r4 = a95.a.d;
        this.i = a95.a.b.a(null);
    }

    public final void j(List<String> r8, Bundle r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "extras");
        if (r8 == null) goto L5;
        Flowable.fromCallable(new f(this, r8, r11, r9, r10)).subscribeOn(fo5.d.b()).onErrorReturn(g.a).subscribe();
        if (i() == false) goto L13;
        ((c) this.a).NU(-1);
        return;
    L13:
        return;
    L5:
        if (i() == false) goto L12;
        ((c) this.a).HW();
        return;
    }
}
