package vn0;

import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements qj0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f556409a;

    public a(ViewGroup r100) {
        this.f556409a = r100;
    }

    @Override // qj0.a
    public final boolean a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ViewGroup r101 = this.f556409a;
        if (r101 == null) goto L5;
        ViewGroup r102 = (ViewGroup) r101.findViewById(R.id.audio_interact_effect_container);
    L6:
        if (r102 != null) goto L8;
    L10:
        return false;
    L8:
        if (r102.indexOfChild(r100) != (-1)) goto L10;
        r102.addView(r100);
        return true;
    L5:
        r102 = null;
        goto L6
    }

    @Override // qj0.a
    public final boolean b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ViewGroup r101 = this.f556409a;
        if (r101 == null) goto L5;
        ViewGroup r102 = (ViewGroup) r101.findViewById(R.id.audio_interact_effect_container);
    L6:
        if (r102 != null) goto L8;
    L10:
        return false;
    L8:
        if (r102.indexOfChild(r100) == (-1)) goto L10;
        r102.removeView(r100);
        return true;
    L5:
        r102 = null;
        goto L6
    }
}
