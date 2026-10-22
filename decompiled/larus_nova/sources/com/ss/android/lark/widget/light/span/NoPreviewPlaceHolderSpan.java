package com.ss.android.lark.widget.light.span;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.nopreview.UnAuthorizationDrawableWrapper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class NoPreviewPlaceHolderSpan extends com.ss.android.lark.widget.span.g implements j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f446205h = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f446206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f446207g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/widget/light/span/NoPreviewPlaceHolderSpan$DrawableSizeType;", "", "<init>", "(Ljava/lang/String;I)V", "FIX_SIZE", "DYNAMIC_SIZE", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DrawableSizeType extends Enum<DrawableSizeType> {
        public static final DrawableSizeType DYNAMIC_SIZE = null;
        public static final DrawableSizeType FIX_SIZE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DrawableSizeType[] f446208a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f446209b = null;

        public static EnumEntries<DrawableSizeType> getEntries() {
            return f446209b;
        }

        static {
            DrawableSizeType r100 = new DrawableSizeType("FIX_SIZE", 0);
            FIX_SIZE = r100;
            DrawableSizeType r101 = new DrawableSizeType("DYNAMIC_SIZE", 1);
            DYNAMIC_SIZE = r101;
            DrawableSizeType[] r102 = {r100, r101};
            f446208a = r102;
            f446209b = EnumEntriesKt.enumEntries(r102);
        }

        public static DrawableSizeType[] values() {
            return (DrawableSizeType[]) f446208a.clone();
        }

        public static DrawableSizeType valueOf(String r100) {
            return (DrawableSizeType) r27.a.a(DrawableSizeType.class, r100);
        }

        public DrawableSizeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.widget.light.span.NoPreviewPlaceHolderSpan$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C5397a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f446210a = null;

            static {
                int[] r100 = new int[DrawableSizeType.values().length];
                r100[DrawableSizeType.DYNAMIC_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[DrawableSizeType.FIX_SIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f446210a = r100;
            }
        }

        public a() {
        }

        public static final Drawable a(Context r100, b r101) {
            int r102 = NoPreviewPlaceHolderSpan.f446205h;
            int r103 = C5397a.f446210a[r101.f446214d.ordinal()];
            boolean r104 = true;
            if (r103 != 1) goto L5;
            UnAuthorizationDrawableWrapper.a r105 = new UnAuthorizationDrawableWrapper.a();
            String r106 = r101.f446211a;
            Intrinsics.checkNotNullParameter(r106, AppConstants.BUNDLE_TIP);
            r105.f448730d = r106;
            float r107 = r101.f446212b;
            if (r107 > 0.0f) goto L17;
            r104 = false;
        L17:
            r105.f448731e = r104;
            r105.f448732f = r101.f446213c;
            r105.f448733g = r107;
            r105.f448728b = r101.f446215e;
            r105.f448729c = r101.f446216f;
            UnAuthorizationDrawableWrapper.Style r108 = UnAuthorizationDrawableWrapper.Style.AUTO;
            Intrinsics.checkNotNullParameter(r108, "style");
            r105.f448727a = r108;
            return r105.a(r100);
        L5:
            if (r103 != 2) goto L12;
            int r109 = com.ss.android.lark.widget.span.nopreview.a.f448735k;
            com.ss.android.lark.widget.span.nopreview.a.C5434a r110 = com.ss.android.lark.widget.span.nopreview.a.b.a(r100);
            String r111 = r101.f446211a;
            Intrinsics.checkNotNullParameter(r111, "text");
            r110.f448752g = r111;
            r110.f448754i = r101.f446213c;
            r110.f448753h = r101.f446212b;
            int r112 = r101.f446217g;
            if (r112 <= 0.0f) goto L19;
            if (r112 <= 0) goto L19;
            r110.f448750e = (int) (((double) r112) * 0.8d);
        L19:
            return r110.a();
        L12:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f446211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f446212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f446213c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final DrawableSizeType f446214d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f446215e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f446216f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f446217g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final c f446218h;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f446219a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public float f446220b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public float f446221c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public DrawableSizeType f446222d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f446223e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f446224f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f446225g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public c f446226h;

            public final b a() {
                return new b(this.f446219a, this.f446220b, this.f446221c, this.f446222d, this.f446223e, this.f446224f, this.f446225g, this.f446226h);
            }

            public a() {
                this.f446219a = "";
                this.f446222d = DrawableSizeType.FIX_SIZE;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f446211a, r101.f446211a) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.f446212b, r101.f446212b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f446213c, r101.f446213c) == 0) goto L18;
            return false;
        L18:
            if (this.f446214d == r101.f446214d) goto L21;
            return false;
        L21:
            if (this.f446215e == r101.f446215e) goto L24;
            return false;
        L24:
            if (this.f446216f == r101.f446216f) goto L27;
            return false;
        L27:
            if (this.f446217g == r101.f446217g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f446218h, r101.f446218h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((((this.f446211a.hashCode() * 31) + Float.floatToIntBits(this.f446212b)) * 31) + Float.floatToIntBits(this.f446213c)) * 31) + this.f446214d.hashCode()) * 31) + this.f446215e) * 31) + this.f446216f) * 31) + this.f446217g) * 31;
            c r101 = this.f446218h;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "DrawableParam(tip=" + this.f446211a + ", borderWidth=" + this.f446212b + ", borderRadius=" + this.f446213c + ", sizeType=" + this.f446214d + ", width=" + this.f446215e + ", height=" + this.f446216f + ", maxWidth=" + this.f446217g + ", margin=" + this.f446218h + ')';
        }

        public b(String r100, float r101, float r102, DrawableSizeType r103, int r104, int r105, int r106, c r107) {
            Intrinsics.checkNotNullParameter(r100, AppConstants.BUNDLE_TIP);
            Intrinsics.checkNotNullParameter(r103, "sizeType");
            this.f446211a = r100;
            this.f446212b = r101;
            this.f446213c = r102;
            this.f446214d = r103;
            this.f446215e = r104;
            this.f446216f = r105;
            this.f446217g = r106;
            this.f446218h = r107;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f446227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f446228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f446229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f446230d;

        public c() {
            this(0, 0, 0, 0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f446227a == r101.f446227a) goto L12;
            return false;
        L12:
            if (this.f446228b == r101.f446228b) goto L15;
            return false;
        L15:
            if (this.f446229c == r101.f446229c) goto L18;
            return false;
        L18:
            if (this.f446230d == r101.f446230d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f446227a * 31) + this.f446228b) * 31) + this.f446229c) * 31) + this.f446230d;
        }

        public final String toString() {
            return "Margin(left=" + this.f446227a + ", top=" + this.f446228b + ", right=" + this.f446229c + ", bottom=" + this.f446230d + ')';
        }

        public c(int r100, int r101, int r102, int r103) {
            this.f446227a = r100;
            this.f446228b = r101;
            this.f446229c = r102;
            this.f446230d = r103;
        }
    }

    static {
        new a();
    }

    @Override // com.ss.android.lark.widget.light.span.j
    public final j.a c() {
        return new j.a(TuplesKt.to(Integer.valueOf(this.f446207g.f446215e), Integer.valueOf(this.f446207g.f446216f)), this.f446207g.f446218h);
    }

    public final int hashCode() {
        return this.f446207g.hashCode();
    }

    public final Context getContext() {
        return this.f446206f;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(NoPreviewPlaceHolderSpan.class, r101) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.light.span.NoPreviewPlaceHolderSpan");
        return Intrinsics.areEqual(this.f446207g, ((NoPreviewPlaceHolderSpan) r100).f446207g);
    L8:
        r101 = null;
        goto L10
    }

    public NoPreviewPlaceHolderSpan(Context r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "param");
        super(a.a(r100, r101));
        this.f446206f = r100;
        this.f446207g = r101;
    }

    @Override // com.ss.android.lark.widget.light.span.j
    public final boolean d(int r110, int r111) {
        b r100 = this.f446207g;
        if (r110 == r100.f446215e) goto L5;
    L8:
        String r101 = r100.f446211a;
        float r102 = r100.f446212b;
        float r103 = r100.f446213c;
        DrawableSizeType r104 = r100.f446214d;
        int r105 = r100.f446217g;
        c r106 = r100.f446218h;
        Intrinsics.checkNotNullParameter(r101, AppConstants.BUNDLE_TIP);
        Intrinsics.checkNotNullParameter(r104, "sizeType");
        b r107 = new b(r101, r102, r103, r104, r110, r111, r105, r106);
        com.ss.android.lark.image.utils.e.b(this, "mDrawable", a.a(this.f446206f, r107));
        com.ss.android.lark.image.utils.e.b(this, "mDrawableRef", null);
        this.f446207g = r107;
        return true;
    L5:
        if (r111 != r100.f446216f) goto L8;
        return false;
    }
}
