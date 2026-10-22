package com.larus.bmhome.chat.nestedmenu;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class NestedMenuRightModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f308218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Style f308219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f308220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f308221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f308222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f308223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f308224g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/NestedMenuRightModel$Style;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "SWITCH", "BUTTON", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        public static final Style BUTTON = null;
        public static final Style NORMAL = null;
        public static final Style SWITCH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f308225a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f308226b = null;

        public static EnumEntries<Style> getEntries() {
            return f308226b;
        }

        static {
            Style r100 = new Style(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            Style r101 = new Style("SWITCH", 1);
            SWITCH = r101;
            Style r102 = new Style("BUTTON", 2);
            BUTTON = r102;
            Style[] r103 = {r100, r101, r102};
            f308225a = r103;
            f308226b = EnumEntriesKt.enumEntries(r103);
        }

        public static Style[] values() {
            return (Style[]) f308225a.clone();
        }

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }

        public Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    public NestedMenuRightModel() {
        this(null, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NestedMenuRightModel) == true) goto L8;
        return false;
    L8:
        NestedMenuRightModel r101 = (NestedMenuRightModel) r100;
        if (this.f308218a == r101.f308218a) goto L12;
        return false;
    L12:
        if (this.f308219b == r101.f308219b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(null, null) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f308220c, r101.f308220c) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f308221d, r101.f308221d) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f308222e, r101.f308222e) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f308223f, r101.f308223f) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f308224g, r101.f308224g) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        if (this.f308218a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f308219b.hashCode()) * 31;
        int r102 = 0;
        int r103 = (((((r101 + 0) * 31) + 0) * 31) + 0) * 31;
        String r104 = this.f308220c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f308221d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f308222e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f308223f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f308224g;
        if (r116 == null) goto L27;
        r102 = r116.hashCode();
    L27:
        return r115 + r102;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "NestedMenuRightModel(selected=" + this.f308218a + ", style=" + this.f308219b + ", buttonBackgroundColor=null, buttonTitleColor=null, buttonPressColor=null, text=" + this.f308220c + ", textColor=" + this.f308221d + ", iconRes=" + this.f308222e + ", iconUrl=" + this.f308223f + ", textColorValue=" + this.f308224g + ')';
    }

    public NestedMenuRightModel(String r100, Integer r101, String r102, Integer r103, int r104) {
        if ((r104 & 2) == 0) goto L5;
        Style r105 = Style.NORMAL;
    L7:
        if ((r104 & 32) == 0) goto L10;
        r100 = null;
    L10:
        if ((r104 & 128) == 0) goto L13;
        r101 = null;
    L13:
        if ((r104 & 256) == 0) goto L16;
        r102 = null;
    L16:
        if ((r104 & 512) == 0) goto L18;
        r103 = null;
    L18:
        Intrinsics.checkNotNullParameter(r105, "style");
        this.f308218a = false;
        this.f308219b = r105;
        this.f308220c = r100;
        this.f308221d = null;
        this.f308222e = r101;
        this.f308223f = r102;
        this.f308224g = r103;
        return;
    L5:
        r105 = null;
        goto L7
    }
}
