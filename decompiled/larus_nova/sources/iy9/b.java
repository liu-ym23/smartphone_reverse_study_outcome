package iy9;

import android.graphics.Bitmap;
import com.larus.platform.api.IVideoController;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, Integer> f496615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<String, IVideoController, Unit> f496616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<String, Boolean, Unit> f496617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f496618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap f496619e;

    public b() {
        this(null, null, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super String, Integer> r100, Function2<? super String, ? super IVideoController, Unit> r101, Function2<? super String, ? super Boolean, Unit> r102, Long r103, Bitmap r104) {
        this.f496615a = r100;
        this.f496616b = r101;
        this.f496617c = r102;
        this.f496618d = r103;
        this.f496619e = r104;
    }
}
