package u19;

import android.content.Context;
import com.bytedance.crash.dumper.Scraps;
import com.obric.assistant.common.spi.toast.ObricToastHelperDelegate;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f548337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f548338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f548339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f548340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f548341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f548342f;

    public g() {
        this.f548337a = true;
        this.f548340d = "";
    }

    public final f a(Context r100) {
        Object r101 = ObricToastHelperDelegate.f387851b.createToastHolder(r100);
        if ((r101 instanceof f) == false) goto L5;
        f r102 = (f) r101;
    L6:
        if (r102 == null) goto L8;
    L14:
        r102.setAutoDisappear(this.f548337a);
        r102.setDuration(this.f548341e);
        r102.icon(this.f548339c);
        r102.text(this.f548340d);
        r102.setYOffsetPx(this.f548342f);
        return r102;
    L8:
        if (this.f548337a == true) goto L10;
    L13:
        r102 = new e();
        goto L14
    L10:
        if (this.f548338b == true) goto L13;
        r102 = new i();
        goto L14
    L5:
        r102 = null;
        goto L6
    }

    public final void b(int r100, TimeUnit r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        if (r102 == false) goto L5;
    L6:
        this.f548338b = true;
    L7:
        this.f548341e = (int) r101.toMillis(r100);
        return;
    L5:
        if (r101.toMillis(r100) <= 3500) goto L7;
        goto L6
    }
}
