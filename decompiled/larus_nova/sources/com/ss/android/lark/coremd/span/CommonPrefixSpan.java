package com.ss.android.lark.coremd.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;

/* JADX INFO: loaded from: classes35.dex */
public class CommonPrefixSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f419933b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f419934a;

    public static final enum ListType extends Enum<ListType> {
        public static final ListType LOWERCASE_A = null;
        public static final ListType LOWERCASE_ROMAN = null;
        public static final ListType NONE = null;
        public static final ListType NUMBER = null;
        public static final ListType UPPERCASE_A = null;
        public static final ListType UPPERCASE_ROMAN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ListType[] f419935a = null;
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
            f419935a = new ListType[]{r100, r101, r102, r103, r104, r105};
        }

        public static ListType[] values() {
            return (ListType[]) f419935a.clone();
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
        public static final /* synthetic */ Type[] f419936a = null;

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
            f419936a = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static Type[] values() {
            return (Type[]) f419936a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a extends ThreadLocal<Paint> {
        @Override // java.lang.ThreadLocal
        public final Paint initialValue() {
            return new Paint();
        }

        public a() {
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f419937a = null;

        static {
            int[] r100 = new int[Type.values().length];
            f419937a = r100;
            r100[Type.FILL_CIRCLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f419937a[Type.FILL_RECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f419937a[Type.HOLLOW_CIRCLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f419937a[Type.HOLLOW_RECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f419937a[Type.QUOTE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f419937a[Type.LIST_NUM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Type f419938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f419939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f419940c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f419941d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f419942e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f419943f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f419944g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f419945h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f419946i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f419947j;

        public c() {
            this.f419939b = true;
            this.f419945h = 0;
            this.f419946i = 0;
            ListType r100 = ListType.NUMBER;
            this.f419947j = 1.0f;
        }

        public Type getType() {
            return this.f419938a;
        }
    }

    static {
        f419933b = new a();
    }

    public Type getType() {
        return this.f419934a.getType();
    }

    public CommonPrefixSpan(c r100) {
        this.f419934a = r100;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r100) {
        if (getType() == Type.LEFT_MARGIN) goto L5;
        c r101 = this.f419934a;
        return (int) (((r101.f419940c + r101.f419941d) + r101.f419942e) + 0.5f);
    L5:
        return (int) this.f419934a.f419940c;
    }

    public final void a(Canvas r110, Paint r111, int r112, int r113, int r114, int r210, int r211) {
        switch(b.f419937a[this.f419934a.f419938a.ordinal()]) {
            case 1: goto L23;
            case 2: goto L14;
            case 3: goto L23;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L5;
            default: goto L40;
        };
    L5:
        String r100 = this.f419934a.f419943f;
        if (TextUtils.isEmpty(r100) == true) goto L41;
        float r101 = r112 + (r113 * this.f419934a.f419940c);
        float r102 = r111.getTextSize();
        r111.setTextSize(this.f419934a.f419947j);
        Paint.FontMetricsInt r103 = r111.getFontMetricsInt();
        if ((r210 - r114) <= ((r103.bottom - r103.top) * 2)) goto L11;
        this.f419934a.getClass();
        Rect r104 = new Rect();
        r111.getTextBounds(r100, 0, r100.length(), r104);
        r110.drawText(r100, r101, (r114 + r104.height()) + ((r103.ascent - r103.top) * 2), r111);
    L12:
        r111.setTextSize(r102);
        return;
    L11:
        r110.drawText(r100, r101, r211, r111);
        goto L12
    L41:
        return;
    L13:
        float r105 = r112;
        r110.drawRect(r105, r114, (int) ((r113 * this.f419934a.f419941d) + r105), r210, r111);
        return;
    L14:
        Paint.FontMetricsInt r106 = r111.getFontMetricsInt();
        int r115 = r106.bottom - r106.top;
        float r107 = (r114 + r210) / 2.0f;
        if ((r210 - r114) <= r115) goto L17;
        this.f419934a.getClass();
        r107 = (r115 / 2.0f) + r114;
    L17:
        float r108 = r113;
        c r109 = this.f419934a;
        float r116 = r112 + (r109.f419940c * r108);
        float r117 = r108 * r109.f419941d;
        float r118 = r116 + r117;
        float r119 = r117 / 2.0f;
        float r120 = r107 - r119;
        float r121 = r107 + r119;
        Type r122 = r109.f419938a;
        if (r122 != Type.FILL_RECT) goto L21;
        r110.drawRect(r116, r120, r118, r121, r111);
        return;
    L21:
        if (r122 != Type.HOLLOW_RECT) goto L36;
        r110.drawRect(r116, r120, r118, r121, r111);
        r111.setColor(FakePickerAvatarCreator.BLUE);
        this.f419934a.getClass();
        this.f419934a.getClass();
        this.f419934a.getClass();
        this.f419934a.getClass();
        r110.drawRect(r116 + 0.0f, r120 + 0.0f, r118 - 0.0f, r121 - 0.0f, r111);
        return;
    L36:
        return;
    L23:
        Paint.FontMetricsInt r123 = r111.getFontMetricsInt();
        int r124 = r123.bottom - r123.top;
        float r125 = (r114 + r210) / 2.0f;
        if ((r210 - r114) <= r124) goto L26;
        this.f419934a.getClass();
        r125 = r114 + (r124 / 2.0f);
    L26:
        c r126 = this.f419934a;
        float r127 = r126.f419941d / 2.0f;
        float r128 = r112 + (r113 * (r126.f419940c + r127));
        Type r129 = r126.f419938a;
        if (r129 != Type.FILL_CIRCLE) goto L30;
        r110.drawCircle(r128, r125, r127, r111);
        return;
    L30:
        if (r129 != Type.HOLLOW_CIRCLE) goto L39;
        r111.setStyle(Paint.Style.STROKE);
        this.f419934a.getClass();
        r111.setStrokeWidth(0.0f);
        r110.drawCircle(r128, r125, r127, r111);
        return;
    L39:
        return;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r110, Paint r111, int r112, int r113, int r114, int r115, int r116, CharSequence r117, int r118, int r119, boolean r210, Layout r211) {
        if (this.f419934a.f419939b == true) goto L5;
        return;
    L5:
        Paint r100 = f419933b.get();
        r100.reset();
        r100.set(r111);
        r100.setAntiAlias(true);
        r100.setColor(this.f419934a.f419944g);
        r100.setTypeface(Typeface.MONOSPACE);
        int r101 = b.f419937a[this.f419934a.f419938a.ordinal()];
        if (r101 != 1) goto L8;
    L16:
        r100.setStyle(Paint.Style.FILL);
    L18:
        if (this.f419934a.f419938a != Type.QUOTE) goto L21;
        a(r110, r100, r112, r113, r114, r116, r115);
        return;
    L21:
        if (((Spanned) r117).getSpanStart(this) != r118) goto L25;
        a(r110, r100, r112, r113, r114, r116, r115);
        return;
    L25:
        return;
    L8:
        if (r101 == 2) goto L16;
        if (r101 == 3) goto L16;
        if (r101 == 4) goto L16;
        if (r101 == 5) goto L16;
        goto L16
    }
}
