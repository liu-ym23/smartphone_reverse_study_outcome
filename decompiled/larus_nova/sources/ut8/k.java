package ut8;

import android.graphics.Rect;
import android.text.Layout;
import android.text.TextUtils;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public class k extends b {
    public int A;
    public int B;
    public int C;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final TextView f551705x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f551706y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f551707z;

    @Override // ut8.b
    public void j() {
    }

    @Override // ut8.b
    public final Rect f() {
        if (this.f551705x == null) goto L19;
        int r100 = this.f551665l;
        if (r100 < 0) goto L19;
        if (this.f551666m <= r100) goto L19;
        Layout r101 = g();
        if (r101 != null) goto L22;
        return null;
    L22:
        int r102 = r101.getLineForOffset(this.f551665l);     // Catch: Exception -> L21
        int r103 = r101.getLineTop(r102);     // Catch: Exception -> L21
        r101.getLineBottom(r102);     // Catch: Exception -> L21
        int r104 = r101.getLineForOffset(this.f551666m);     // Catch: Exception -> L21
        r101.getLineTop(r104);     // Catch: Exception -> L21
        int r105 = r101.getLineBottom(r104);     // Catch: Exception -> L21
        int r106 = this.f551659f[0] + j.b(this.f551705x);     // Catch: Exception -> L21
        int r107 = (this.f551659f[1] + j.c(this.f551705x)) + r103;     // Catch: Exception -> L21
        int r108 = (this.f551659f[0] + j.b(this.f551705x)) + this.f551705x.getWidth();     // Catch: Exception -> L21
        int r109 = (this.f551659f[1] + j.c(this.f551705x)) + r105;
        if (r102 == r104) goto L24;
    L17:
        return new Rect(r106, r107, r108, r109);
    L24:
        int r110 = (int) r101.getPrimaryHorizontal(this.f551665l);     // Catch: Exception -> L20
        int r111 = (int) r101.getPrimaryHorizontal(this.f551666m);     // Catch: Exception -> L20
        r106 = (this.f551659f[0] + j.b(this.f551705x)) + r110;     // Catch: Exception -> L20
        r108 = (this.f551659f[0] + j.b(this.f551705x)) + r111;
    L19:
        return null;
    }

    @Override // ut8.b
    public final Layout g() {
        TextView r100 = this.f551705x;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getLayout();
    }

    @Override // ut8.b
    public final CharSequence h() {
        TextView r100 = this.f551705x;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getText();
    }

    public k(TextView r100) {
        super(r100);
        this.f551705x = r100;
    }

    public final boolean q(Layout r100, int r101) {
        if (r100 == null) goto L15;
        TextView r102 = this.f551705x;
        if (r102 == null) goto L19;
        r102.getGlobalVisibleRect(this.f551660g);
        int r103 = r100.getLineForOffset(r101);
        int r104 = (this.f551659f[1] + j.c(this.f551705x)) + r100.getLineTop(r103);
        int r105 = (this.f551659f[1] + j.c(this.f551705x)) + r100.getLineBottom(r103);
        Rect r106 = this.f551660g;
        if (r104 >= r106.top) goto L10;
        return false;
    L10:
        if (r105 <= r106.bottom) goto L12;
        return false;
    L12:
        if (this.f551659f[1] == 0) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    L15:
        return false;
    }

    @Override // ut8.b
    public final void p(boolean r100, int r101, int r102) {
        this.f551705x.getLocationInWindow(this.f551659f);
        int[] r103 = this.f551659f;
        int r104 = j.a(this.f551705x, r101 - r103[0], r102 - r103[1]);
        if (r104 >= 0) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        this.f551665l = r104;
    L9:
        if (this.f551665l <= this.f551666m) goto L18;
        i r105 = this.f551661h;
        boolean r106 = !r105.f551696f;
        r105.f551696f = r106;
        if (r105.f551694d == true) goto L13;
        r105.f551695e = r106;
    L13:
        r105.invalidate();
        i r107 = this.f551663j;
        boolean r108 = !r107.f551696f;
        r107.f551696f = r108;
        if (r107.f551694d == true) goto L16;
        r107.f551695e = r108;
    L16:
        r107.invalidate();
        int r109 = this.f551665l;
        this.f551665l = this.f551666m;
        this.f551666m = r109;
        return;
    L18:
        return;
    L7:
        this.f551666m = r104;
        goto L9
    }

    @Override // ut8.b
    public final void k(Layout r110, int r111, final i r112, boolean r210) {
        if (r110 == null) goto L68;
        TextView r100 = this.f551705x;
        if (r100 == null) goto L69;
        if (r112 == null) goto L76;
        r100.getGlobalVisibleRect(this.f551660g);
        int r101 = r110.getLineForOffset(r111);
        float r102 = r110.getPrimaryHorizontal(r111);     // Catch: Exception -> L11
    L10:
        int r103 = (int) r102;
    L17:
        int r104 = (this.f551659f[0] + j.b(this.f551705x)) + r103;
        int r105 = (this.f551659f[1] + j.c(this.f551705x)) + r110.getLineTop(r101);
        int r106 = (this.f551659f[1] + j.c(this.f551705x)) + r110.getLineBottom(r101);
        int r107 = r110.getLineBottom(r101) - r110.getLineTop(r101);
        if (r210 == false) goto L20;
        this.f551706y = r104;
        this.f551707z = r105;
    L21:
        Rect r108 = this.f551660g;
        if (r105 >= r108.top) goto L24;
    L29:
        r112.setOutArea(true);
    L30:
        TextView r109 = this.f551705x;
        r112.f551700j = r107;
        int r113 = r112.f551704n;
        int r114 = r104 - r113;
        int r115 = (r105 + r107) - r113;
        if (r112.f551695e == false) goto L67;
        r114 = (r104 - (r112.f551697g * 2)) - r113;
    L67:
    L60:
        e = move-exception;
        e.printStackTrace();
        return;
    L34:
        if (r112.f551691a != null) goto L37;
        PopupWindow r116 = new PopupWindow(r112);     // Catch: Exception -> L60
        r116.setClippingEnabled(false);     // Catch: Exception -> L60
        r116.setWidth((r112.f551697g * 2) + (r112.f551704n * 2));     // Catch: Exception -> L60
        r116.setHeight((r112.f551697g * 2) + (r112.f551704n * 2));     // Catch: Exception -> L60
        r116.setFocusable(false);     // Catch: Exception -> L60
        r116.setOutsideTouchable(true);     // Catch: Exception -> L60
        r116.setTouchInterceptor(new h(r112));     // Catch: Exception -> L60
        r112.f551691a = r116;     // Catch: Exception -> L60
    L37:
        if (r112.f551691a.isShowing() == false) goto L47;
        r112.invalidate();     // Catch: Exception -> L60
        PopupWindow r117 = r112.f551691a;     // Catch: Exception -> L60
        if ((r117 instanceof PopupWindow) == false) goto L44;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r117) == false) goto L44;
        r117.update(r114, r115, -1, -1);     // Catch: Exception -> L60
        return;
    L44:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r117, r114, r115, -1, -1) == true) goto L71;
        r117.update(r114, r115, -1, -1);     // Catch: Exception -> L60
        return;
    L71:
        return;
    L47:
        PopupWindow r118 = r112.f551691a;     // Catch: Exception -> L60
        if (PopupWindowLancet.hasSubWindowToken(r109) == false) goto L51;
        return;
    L51:
        if ((r118 instanceof PopupWindow) == true) goto L53;
    L55:
        OverlaySource r119 = PopupWindowLancet.resolveSource(r109);     // Catch: Exception -> L60
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r118, r109, r119, 0, r114, r115) == true) goto L75;
        r118.showAtLocation(r109, 0, r114, r115);     // Catch: Exception -> L60
        PopupWindowLancet.trackAfterShow(r118, r119, r109);     // Catch: Exception -> L60
        return;
    L75:
        return;
    L53:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r118) == false) goto L55;
        r118.showAtLocation(r109, 0, r114, r115);     // Catch: Exception -> L60
        return;
    L24:
        if (r106 > r108.bottom) goto L29;
        if (this.f551659f[1] == 0) goto L29;
        r112.setOutArea(false);
        goto L30
    L20:
        this.A = r104;
        this.B = r105;
        this.C = r106;
    L11:
        if (r210 == false) goto L13;
        int r120 = r110.getLineStart(r101);
    L63:
        r102 = r110.getPrimaryHorizontal(r120);     // Catch: Exception -> L16
    L16:
        r103 = 0;
        goto L17
    L13:
        r120 = r110.getLineEnd(r101);
        goto L63
    L76:
        return;
    L69:
        return;
    }

    public final void r(int r110, int r111, int r112, boolean r113) {
        TextView r100 = this.f551705x;
        if (r100 != null) goto L5;
        return;
    L5:
        int r114 = j.a(r100, r110, r111);
        CharSequence r115 = h();
        if (TextUtils.isEmpty(r115) == true) goto L74;
        if (r114 >= 0) goto L10;
        return;
    L10:
        if (r114 < r115.length()) goto L12;
        r114 = r115.length() - 1;
    L12:
        String r101 = r115.toString();
        TextView r102 = this.f551705x;
        Lazy r103 = vt8.c.f557231a;
        Intrinsics.checkNotNullParameter(r101, "txt");
        Intrinsics.checkNotNullParameter(r102, "txtView");
        if (r101.length() != 0) goto L15;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L19;
        Pair<Integer, Integer> r116 = TuplesKt.to(0, 0);
    L46:
        int r117 = vt8.c.f557232b;
        if (r117 == 1) goto L59;
        if (r117 == 2) goto L58;
        if (r117 != 3) goto L51;
        SelectionRangeType r118 = SelectionRangeType.PARAGRAPH;
    L60:
        SelectionRangeType r105 = r118;
        this.f551665l = r116.getFirst().intValue();
        this.f551666m = r116.getSecond().intValue();
        this.f551705x.getLocationInWindow(this.f551659f);
        Objects.toString(this.f551672s);
        Objects.toString(r105);
        if (this.f551672s == null) goto L72;
        if (r105 == null) goto L72;
        Rect r106 = f();
        int r119 = this.f551665l;
        if (r119 < 0) goto L70;
        int r120 = this.f551666m;
        if (r120 <= r119) goto L70;
        if (r120 > r115.length()) goto L70;
        String r121 = r115.subSequence(this.f551665l, this.f551666m).toString();
    L71:
        this.f551672s.b(r105, this.f551665l, this.f551666m, false, false, r106, r121);
    L70:
        r121 = "";
    L72:
        m();
        l();
        this.f551669p = true;
        return;
    L51:
        if (r117 != 4) goto L53;
        r118 = SelectionRangeType.SENTENCE;
        goto L60
    L53:
        if (r117 == 5) goto L55;
        r118 = null;
        goto L60
    L55:
        r118 = SelectionRangeType.ENTIRE;
        goto L60
    L58:
        r118 = SelectionRangeType.MARK_TEXT;
        goto L60
    L59:
        r118 = SelectionRangeType.WORD;
        goto L60
    L19:
        if (r114 >= 0) goto L22;
        r114 = 0;
    L24:
        if (r113 == false) goto L29;
        if (r112 != 2) goto L29;
        if (vt8.c.a().getDoubleClickShiftStrategy() <= 0) goto L29;
        int r107 = vt8.c.a().getDoubleClickShiftStrategy();
    L42:
        vt8.d r108 = vt8.c.b(r107, r102);
        Pair<Integer, Integer> r109 = r108.a(r101, r114);
        vt8.c.f557232b = r108.b();
        com.larus.business.markdown.api.depend.d r122 = IMarkdownLoggerKt.a();
        if (r122 == null) goto L45;
        r122.i("DefaultSelectionController", "getSelectPair, txt:" + g2a.d.b(r101) + ",index:" + r114 + ",clickCount:" + r112 + ",isReClick:" + r113 + ",latestUsedStrategyId:" + vt8.c.f557232b + ",pair:" + r109);
    L45:
        r116 = r109;
    L29:
        if (r112 == 0) goto L39;
        if (r112 == 2) goto L35;
        if (r112 == 3) goto L33;
        r107 = vt8.c.a().getDoubleClickStrategy();
        goto L42
    L33:
        r107 = vt8.c.a().getTripleClickStrategy();
        goto L42
    L35:
        if (vt8.c.a().getEnableMarkedTextFirst() == true) goto L40;
        r107 = vt8.c.a().getDoubleClickStrategy();
    L40:
        r107 = 2;
        goto L42
    L39:
        if (vt8.c.a().getEnableMarkedTextFirst() == true) goto L40;
        r107 = vt8.c.a().getLongPressStrategy();
        goto L42
    L22:
        if (r114 < r101.length()) goto L24;
        r114 = r101.length() - 1;
        goto L24
    L15:
        r104 = false;
        goto L17
    }
}
