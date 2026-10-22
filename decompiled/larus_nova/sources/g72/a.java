package g72;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.c;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.h;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import kotlin.jvm.internal.Intrinsics;
import r52.l3;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f480215c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f480216d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f480217e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f480218f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Boolean f480219g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f480220h = null;

    public a() {
    }

    static {
        f480220h = new a();
        InteractionWidgetsPosContext.a r100 = InteractionWidgetsPosContext.Companion;
        r100.getClass();
        f480215c = InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp();
        r100.getClass();
        f480216d = InteractionWidgetsPosContext.access$getANCHOR_TOOLBAR_HEIGHT$cp();
        r100.getClass();
        f480217e = InteractionWidgetsPosContext.access$getPAD_TOOLBAR_HEIGHT$cp();
        f480218f = s1.f(8.0f);
        f480219g = l3.f536215a.getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.h
    public final d e(Object r100, d r101, e r102, com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.d r110, com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.e r111) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "heightInfo");
        Intrinsics.checkNotNullParameter(r102, "uiContext");
        Intrinsics.checkNotNullParameter(r110, "roomStatus");
        Intrinsics.checkNotNullParameter(r111, "roomType");
        if (f480219g.booleanValue() == true) goto L5;
    L11:
        int r103 = r101.f133380b;
        if (r103 != (-10086)) goto L21;
        if (PadConfigUtils.a() == false) goto L17;
        r103 = f480217e;
        goto L21
    L17:
        if (r110.isAnchor() == false) goto L19;
        r103 = f480216d;
        goto L21
    L19:
        r103 = f480215c;
    L21:
        if (r110.c() == true) goto L23;
    L25:
        int r104 = 0;
    L26:
        int r105 = r103 + r104;
        if ((r101 instanceof c) == false) goto L31;
        return new c(((c) r101).f133378e, r101.f133379a, r105, r101.f133381c, r101.f133382d);
    L31:
        return new d(r101.f133379a, r105, r101.f133381c, r101.f133382d);
    L23:
        if (r110.f() <= 0) goto L25;
        r104 = r110.f() + f480218f;
        goto L26
    L5:
        if (r110.isAnchor() == false) goto L7;
    L10:
        return r101;
    L7:
        if (r111.isVSRoom() == true) goto L10;
        if (r111.isMediaRoom() == false) goto L11;
        goto L10
    }
}
