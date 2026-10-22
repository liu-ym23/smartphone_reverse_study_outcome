package ys9;

import android.view.View;
import com.larus.nova.R;
import com.larus.platform.api.creation.TplType;
import com.larus.utils.l;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f568996a = 0;

    static {
    }

    public static Balloon a(final View r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, TplType.MENU);
        Balloon.a r102 = new Balloon.a(r100.getContext());
        r102.n(Integer.MIN_VALUE);
        r102.j(Integer.MIN_VALUE);
        r102.f406065z = 16.0f;
        r102.e(ArrowPositionRules.ALIGN_BALLOON);
        r102.f(0);
        r102.f406055p = 0.5f;
        r102.f406061v = 0;
        r102.g(BalloonAnimation.FADE);
        r102.f406044g0 = true;
        r102.h(true);
        r102.T = true;
        r102.l(new a(r100));
        r102.c(c.b(R.attr.larus_message_menu_arrow, r100.getContext(), R.drawable.larus_message_menu_arrow));
        Intrinsics.checkNotNullParameter(r101, "layout");
        r102.I = r101;
        Balloon r103 = r102.b();
        l.c(r100, "ext_balloon_pop", new WeakReference(r103));
        return r103;
    }
}
