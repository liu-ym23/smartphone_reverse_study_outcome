package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.text.Editable;
import android.text.Layout;
import android.widget.EditText;
import com.larus.nova.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f298696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<k1> f298697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f298698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f298699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f298700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorStateList f298701f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0 f298702g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a0 f298703h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f298704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f298705b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f298706c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f298707d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f298704a == r101.f298704a) goto L12;
            return false;
        L12:
            if (Float.compare(this.f298705b, r101.f298705b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f298706c, r101.f298706c) == 0) goto L18;
            return false;
        L18:
            if (this.f298707d == r101.f298707d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f298704a * 31) + Float.floatToIntBits(this.f298705b)) * 31) + Float.floatToIntBits(this.f298706c)) * 31;
            if (this.f298707d == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Position(cursor=" + this.f298704a + ", x=" + this.f298705b + ", baseline=" + this.f298706c + ", rtl=" + this.f298707d + ')';
        }

        public a(int r100, float r101, float r102, boolean r103) {
            this.f298704a = r100;
            this.f298705b = r101;
            this.f298706c = r102;
            this.f298707d = r103;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f298708a = null;

        static {
            int[] r100 = new int[MultiTypePanelTrigger.values().length];
            r100[MultiTypePanelTrigger.MENTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MultiTypePanelTrigger.SLASH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MultiTypePanelTrigger.EXTERNAL_SKILL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f298708a = r100;
        }
    }

    private final void update() {
        k1 r100 = this.f298697b.invoke();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L80:
        a r102 = null;
    L81:
        if (r102 == null) goto L92;
        Editable r103 = this.f298696a.getText();
        if (r103 != null) goto L85;
    L88:
        if (r101 == false) goto L92;
        if (this.f298696a.getCurrentHintTextColor() == 0) goto L99;
        this.f298701f = this.f298696a.getHintTextColors();
        this.f298696a.setHintTextColor(0);
    L99:
        if (Intrinsics.areEqual(this.f298700e, r102) == true) goto L101;
    L104:
        this.f298700e = r102;
        this.f298702g.setBounds(0, 0, this.f298696a.getWidth(), this.f298696a.getHeight());
        this.f298702g.invalidateSelf();
        return;
    L101:
        if (this.f298702g.getBounds().width() != this.f298696a.getWidth()) goto L104;
        if (this.f298702g.getBounds().height() != this.f298696a.getHeight()) goto L104;
        return;
    L85:
        if (r103.length() == 0) goto L88;
        r101 = false;
    L92:
        ColorStateList r104 = this.f298701f;
        if (r104 != null) goto L95;
    L97:
        this.f298701f = null;
        goto L99
    L95:
        if (this.f298696a.getCurrentHintTextColor() != 0) goto L97;
        this.f298696a.setHintTextColor(r104);
        goto L97
    L5:
        if (r100.f298767c.length() != 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L80;
        if (this.f298696a.isShown() == false) goto L80;
        if (this.f298696a.isEnabled() == false) goto L80;
        int r106 = this.f298696a.getSelectionStart();
        Editable r107 = this.f298696a.getText();
        if (r107 == null) goto L80;
        if (r106 != this.f298696a.getSelectionEnd()) goto L80;
        if (r106 != r100.f298766b) goto L80;
        if (r106 >= 0) goto L27;
    L29:
        boolean r108 = false;
    L30:
        if (r108 == false) goto L80;
        int r109 = b.f298708a[r100.f298768d.ordinal()];
        if (r109 != 1) goto L35;
    L41:
        int r110 = r106 - 1;
    L42:
        int r111 = r100.f298765a;
        if (r111 != r110) goto L80;
        if (r100.f298768d != MultiTypePanelTrigger.MENTION) goto L54;
        Character r112 = StringsKt.getOrNull(r107, r111);
        if (r112 == null) goto L80;
        if (r112.charValue() != '@') goto L80;
    L54:
        if (r100.f298768d != MultiTypePanelTrigger.SLASH) goto L61;
        Character r113 = StringsKt.getOrNull(r107, r100.f298765a);
        if (r113 == null) goto L80;
        if (r113.charValue() != '/') goto L80;
    L61:
        Layout r114 = this.f298696a.getLayout();
        if (r114 == null) goto L80;
        if (r106 > r114.getText().length()) goto L80;
        int r115 = r114.getLineForOffset(r106);
        int r116 = RangesKt.coerceAtMost(r114.getLineEnd(r115), r107.length());
        int r117 = r106;
    L68:
        if (r117 >= r116) goto L75;
        if (r107.charAt(r117) == '\n') goto L74;
        if (r107.charAt(r117) != '\r') goto L80;
    L74:
        r117 = r117 + 1;
        goto L68
    L75:
        float r118 = (this.f298696a.getTotalPaddingLeft() + r114.getPrimaryHorizontal(r106)) - this.f298696a.getScrollX();
        float r119 = ((this.f298696a.getBaseline() + r114.getLineBaseline(r115)) - r114.getLineBaseline(0)) - this.f298696a.getScrollY();
        if (r114.getParagraphDirection(r115) >= 0) goto L78;
        boolean r120 = true;
    L79:
        r102 = new a(r106, r118, r119, r120);
        goto L81
    L78:
        r120 = false;
        goto L79
    L35:
        if (r109 == 2) goto L41;
        if (r109 != 3) goto L40;
        r110 = r106;
        goto L42
    L40:
        throw new NoWhenBranchMatchedException();
    L27:
        if (r106 > r107.length()) goto L29;
        r108 = true;
        goto L30
    L7:
        r105 = false;
        goto L8
    }

    public static void a(b0 r100) {
        r100.update();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.ViewTreeObserver$OnPreDrawListener, com.larus.bmhome.chat.component.bottom.core.inputtext.a0] */
    public b0(EditText r100, f1 r101) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        Intrinsics.checkNotNullParameter(r101, "queryProvider");
        this.f298696a = r100;
        this.f298697b = r101;
        this.f298698c = r100.getContext().getString(R.string.larus_input_mention_slash_placeholder);
        this.f298699d = new Paint(1);
        c0 r102 = new c0(this);
        this.f298702g = r102;
        ?? r103 = new a0(this);
        this.f298703h = r103;
        r100.getOverlay().add(r102);
        r100.getViewTreeObserver().addOnPreDrawListener(r103);
    }
}
