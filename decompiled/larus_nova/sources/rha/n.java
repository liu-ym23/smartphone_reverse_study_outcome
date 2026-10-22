package rha;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.view.ObricIconSwipeUpView;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class n extends PopupWindow {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f537835q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f537836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f537837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z0 f537838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f537839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f537840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f537841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public rha.a f537842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f537843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f537844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ShadowLayout f537845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f537846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ObricIconSwipeUpView f537847l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f537848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f537849n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function0<Unit> f537850o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final i f537851p;

    public static final class a {
        public a() {
        }

        public static final long a(String r100) {
            int r101 = n.f537835q;
            return CastLongProtector.parseLong(r100);
        L5:
            return 0;
        }
    }

    static {
        new a();
    }

    @Override // android.widget.PopupWindow
    @Deprecated(message = "use dismissManually() instead")
    public final void dismiss() {
    }

    public final Pair<Integer, Integer> b() {
        int r100 = 0;
        this.f537843h.measure(0, 0);
        int r101 = this.f537843h.getMeasuredHeight();
        int r102 = this.f537843h.getMeasuredWidth();
        this.f537843h.layout(0, 0, r102, r101);
        FLogger r103 = FLogger.f375446a;
        r103.i("SecondaryMenuPopupWindow", "getPopupWindowPosition: popupHeight = " + r101 + ", popupWidth = " + r102);
        int[] r104 = new int[2];
        this.f537836a.getLocationInWindow(r104);
        int r105 = r104[0];
        int r106 = r104[1];
        r103.i("SecondaryMenuPopupWindow", "getPopupWindowPosition: anchorX = " + r105 + ", anchorY = " + r106);
        View r107 = this.f537844i;
    L3:
        if (r107 == null) goto L11;
        if (Intrinsics.areEqual(r107, this.f537843h) == true) goto L11;
        r100 = r100 + r107.getLeft();
        Object r108 = r107.getParent();
        if ((r108 instanceof View) == true) goto L8;
        r107 = null;
        goto L3
    L8:
        r107 = (View) r108;
    L11:
        return new Pair(Integer.valueOf(r105 - r100), Integer.valueOf(r106 - r101));
    }

    public final void a() {
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [rha.i] */
    public n(LinearLayout r100, r r101, ViewGroup r102, View r103) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        Intrinsics.checkNotNullParameter(r101, "windowConfig");
        super(r100, -2, -2, true);
        this.f537836a = r101.f537855b;
        this.f537837b = r101.f537856c;
        this.f537838c = r101.f537857d;
        this.f537839d = r101.f537858e;
        this.f537840e = r101.f537859f;
        this.f537841f = new AtomicBoolean(true);
        this.f537843h = r100;
        this.f537844i = (LinearLayout) r100.findViewById(R.id.menu_content);
        this.f537845j = (ShadowLayout) r100.findViewById(R.id.menu_shadow);
        this.f537846k = r103;
        if (r102 == null) goto L5;
        ObricIconSwipeUpView r104 = (ObricIconSwipeUpView) r102.findViewById(R.id.obric_gesture_view);
    L6:
        this.f537847l = r104;
        this.f537848m = LazyKt.lazy(new h(this));
        this.f537851p = new i(this);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
