package qo9;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.larus.office.plugins.inputv2.w1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Context> f534271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xu5.a f534272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f534273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f534274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f534275e;

    public final void a() {
        Context r100 = this.f534271a.invoke();
        xu5.a r101 = this.f534272b;
        if (r101 == null) goto L27;
        if (r100 != null) goto L7;
        return;
    L7:
        if (this.f534273c == true) goto L15;
        if (this.f534274d == true) goto L15;
        if (this.f534275e == false) goto L26;
        r101.resetState();
        this.f534275e = false;
        return;
    L26:
        return;
    L15:
        if (this.f534275e == true) goto L17;
        r101.saveState();
        this.f534275e = true;
    L17:
        boolean r102 = this.f534274d;
        if (r102 == false) goto L20;
        int r103 = R.attr.larus_static_black_transparent_1;
    L21:
        if (r102 == false) goto L23;
        int r104 = R.color.larus_static_black_transparent_1;
    L24:
        r101.b(ContextCompat.getColor(r100, v19.c.b(r103, r100, r104)), true);
        return;
    L23:
        r104 = R.color.larus_neutral_transparent_2;
        goto L24
    L20:
        r103 = R.attr.larus_neutral_transparent_2;
        goto L21
    }

    public e(w1 r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProvider");
        this.f534271a = r100;
    }
}
