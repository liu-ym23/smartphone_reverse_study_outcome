package com.ss.android.lark.widget.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class PrefixSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Paint f448581b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f448582a;

    public static final enum ListType extends Enum<ListType> {
        public static final ListType LOWERCASE_A = null;
        public static final ListType LOWERCASE_ROMAN = null;
        public static final ListType NONE = null;
        public static final ListType NUMBER = null;
        public static final ListType UPPERCASE_A = null;
        public static final ListType UPPERCASE_ROMAN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ListType[] f448583a = null;
        private final int value;

        static {
            ListType r100 = new ListType("NUMBER", 0, 0);
            NUMBER = r100;
            ListType r101 = new ListType("LOWERCASE_A", 1, 1);
            LOWERCASE_A = r101;
            ListType r102 = new ListType("UPPERCASE_A", 2, 2);
            UPPERCASE_A = r102;
            ListType r103 = new ListType("LOWERCASE_ROMAN", 3, 3);
            LOWERCASE_ROMAN = r103;
            ListType r104 = new ListType("UPPERCASE_ROMAN", 4, 4);
            UPPERCASE_ROMAN = r104;
            ListType r105 = new ListType(UserProfileEvent.POSITION_NONE, 5, 5);
            NONE = r105;
            f448583a = new ListType[]{r100, r101, r102, r103, r104, r105};
        }

        public static ListType[] values() {
            return (ListType[]) f448583a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static ListType from(int r100) {
            ListType[] r101 = values();
            if (r100 < 0) goto L10;
            if (r100 >= r101.length) goto L10;
            return r101[r100];
        L10:
            return NONE;
        }

        public static ListType valueOf(String r100) {
            return (ListType) r27.a.a(ListType.class, r100);
        }

        public ListType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type FILL_CIRCLE = null;
        public static final Type FILL_RECT = null;
        public static final Type HOLLOW_CIRCLE = null;
        public static final Type HOLLOW_RECT = null;
        public static final Type LEFT_MARGIN = null;
        public static final Type LIST_NUM = null;
        public static final Type NONE = null;
        public static final Type QUOTE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f448584a = null;

        static {
            Type r100 = new Type("FILL_CIRCLE", 0);
            FILL_CIRCLE = r100;
            Type r101 = new Type("HOLLOW_CIRCLE", 1);
            HOLLOW_CIRCLE = r101;
            Type r102 = new Type("FILL_RECT", 2);
            FILL_RECT = r102;
            Type r103 = new Type("HOLLOW_RECT", 3);
            HOLLOW_RECT = r103;
            Type r104 = new Type("LIST_NUM", 4);
            LIST_NUM = r104;
            Type r105 = new Type("QUOTE", 5);
            QUOTE = r105;
            Type r110 = new Type(UserProfileEvent.POSITION_NONE, 6);
            NONE = r110;
            Type r111 = new Type("LEFT_MARGIN", 7);
            LEFT_MARGIN = r111;
            f448584a = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static Type[] values() {
            return (Type[]) f448584a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f448585a = null;

        static {
            int[] r100 = new int[Type.values().length];
            f448585a = r100;
            r100[Type.FILL_CIRCLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f448585a[Type.FILL_RECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f448585a[Type.HOLLOW_CIRCLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f448585a[Type.HOLLOW_RECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f448585a[Type.QUOTE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f448585a[Type.LIST_NUM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Type f448586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f448587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f448588c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f448589d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f448590e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f448591f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f448592g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f448593h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f448594i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f448595j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f448596k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public ListType f448597l;

        public b() {
            this.f448587b = true;
            this.f448594i = false;
            this.f448595j = 0;
            this.f448596k = 0;
            this.f448597l = ListType.NONE;
        }

        public Type getType() {
            return this.f448586a;
        }
    }

    static {
        f448581b = new Paint();
    }

    public Type getType() {
        return this.f448582a.getType();
    }

    public PrefixSpan(b r100) {
        this.f448582a = r100;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        if (getType() == Type.LEFT_MARGIN) goto L5;
        b r101 = this.f448582a;
        return (int) (((r101.f448588c + r101.f448589d) + r101.f448591f) + 0.5f);
    L5:
        return (int) this.f448582a.f448588c;
    }

    public final void a(Canvas r110, int r111, int r112, int r113, int r114, int r115) {
        switch(a.f448585a[this.f448582a.f448586a.ordinal()]) {
            case 1: goto L26;
            case 2: goto L15;
            case 3: goto L26;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L5;
            default: goto L46;
        };
    L5:
        String r100 = this.f448582a.f448592g;
        if (TextUtils.isEmpty(r100) == true) goto L47;
        float r101 = r111 + (r112 * this.f448582a.f448588c);
        Paint r102 = f448581b;
        Paint.FontMetricsInt r103 = r102.getFontMetricsInt();
        if ((r114 - r113) > ((r103.bottom - r103.top) * 2)) goto L11;
    L13:
        r110.drawText(r100, r101, r115, r102);
        return;
    L11:
        if (this.f448582a.f448594i == true) goto L13;
        Rect r104 = new Rect();
        r102.getTextBounds(r100, 0, r100.length(), r104);
        r110.drawText(r100, r101, (r113 + r104.height()) + ((r103.ascent - r103.top) * 2), r102);
        return;
    L47:
        return;
    L14:
        float r105 = r111;
        r110.drawRect(r105, r113, (int) ((r112 * this.f448582a.f448589d) + r105), r114, f448581b);
        return;
    L15:
        Paint r106 = f448581b;
        Paint.FontMetricsInt r107 = r106.getFontMetricsInt();
        int r108 = r107.bottom - r107.top;
        float r109 = (r113 + r114) / 2.0f;
        if ((r114 - r113) > r108) goto L18;
    L20:
        float r116 = r112;
        b r117 = this.f448582a;
        float r118 = r111 + (r117.f448588c * r116);
        float r119 = r116 * r117.f448589d;
        float r120 = r118 + r119;
        float r121 = r119 / 2.0f;
        float r122 = r109 - r121;
        float r123 = r121 + r109;
        Type r124 = r117.f448586a;
        if (r124 != Type.FILL_RECT) goto L24;
        r110.drawRect(r118, r122, r120, r123, r106);
        return;
    L24:
        if (r124 != Type.HOLLOW_RECT) goto L42;
        r110.drawRect(r118, r122, r120, r123, r106);
        r106.setColor(UIHelper.getColor(R.color.lkui_N00));
        float r125 = this.f448582a.f448590e;
        r110.drawRect(r118 + r125, r122 + r125, r120 - r125, r123 - r125, r106);
        return;
    L42:
        return;
    L18:
        if (this.f448582a.f448594i == true) goto L20;
        r109 = r113 + (r108 / 2.0f);
        goto L20
    L26:
        Paint r126 = f448581b;
        Paint.FontMetricsInt r127 = r126.getFontMetricsInt();
        int r128 = r127.bottom - r127.top;
        float r129 = (r113 + r114) / 2.0f;
        if ((r114 - r113) > r128) goto L29;
    L31:
        b r130 = this.f448582a;
        float r131 = r130.f448589d / 2.0f;
        float r132 = r111 + (r112 * (r130.f448588c + r131));
        Type r133 = r130.f448586a;
        if (r133 != Type.FILL_CIRCLE) goto L35;
        r110.drawCircle(r132, r129, r131, r126);
        return;
    L35:
        if (r133 != Type.HOLLOW_CIRCLE) goto L45;
        r126.setStyle(Paint.Style.STROKE);
        r126.setStrokeWidth(this.f448582a.f448590e);
        r110.drawCircle(r132, r129, r131, r126);
        return;
    L45:
        return;
    L29:
        if (this.f448582a.f448594i == true) goto L31;
        r129 = r113 + (r128 / 2.0f);
        goto L31
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r110, int r111, int r112, int r113, int r114, int r115, CharSequence r116, int r117, int r118, boolean r119, Layout r210) {
        if (this.f448582a.f448587b == true) goto L5;
        return;
    L5:
        Paint r101 = f448581b;
        r101.reset();
        r101.set(r110);
        r101.setAntiAlias(true);
        r101.setColor(this.f448582a.f448593h);
        r101.setTypeface(Typeface.MONOSPACE);
        int r102 = a.f448585a[this.f448582a.f448586a.ordinal()];
        if (r102 != 1) goto L8;
    L16:
        r101.setStyle(Paint.Style.FILL);
    L18:
        if (this.f448582a.f448586a != Type.QUOTE) goto L21;
        a(r100, r111, r112, r113, r115, r114);
        return;
    L21:
        if (((Spanned) r116).getSpanStart(this) != r117) goto L25;
        a(r100, r111, r112, r113, r115, r114);
        return;
    L25:
        return;
    L8:
        if (r102 == 2) goto L16;
        if (r102 == 3) goto L16;
        if (r102 == 4) goto L16;
        if (r102 == 5) goto L16;
        goto L16
    }
}
