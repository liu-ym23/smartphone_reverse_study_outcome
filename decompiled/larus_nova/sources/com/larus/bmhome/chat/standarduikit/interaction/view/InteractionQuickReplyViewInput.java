package com.larus.bmhome.chat.standarduikit.interaction.view;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
public final class InteractionQuickReplyViewInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f309306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f309307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f309308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f309309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CharSequence f309310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CharSequence f309311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f309312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Button> f309313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f309314i;

    public static final class Button {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f309315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Style f309316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f309317c;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/interaction/view/InteractionQuickReplyViewInput$Button$Style;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY", "SECONDARY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Style extends Enum<Style> {
            public static final Style PRIMARY = null;
            public static final Style SECONDARY = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Style[] f309318a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f309319b = null;

            public static EnumEntries<Style> getEntries() {
                return f309319b;
            }

            static {
                Style r100 = new Style("PRIMARY", 0);
                PRIMARY = r100;
                Style r101 = new Style("SECONDARY", 1);
                SECONDARY = r101;
                Style[] r102 = {r100, r101};
                f309318a = r102;
                f309319b = EnumEntriesKt.enumEntries(r102);
            }

            public static Style[] values() {
                return (Style[]) f309318a.clone();
            }

            public static Style valueOf(String r100) {
                return (Style) a.a(Style.class, r100);
            }

            public Style(String r100, int r101) {
                super(r100, r101);
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Button) == true) goto L8;
            return false;
        L8:
            Button r101 = (Button) r100;
            if (Intrinsics.areEqual(this.f309315a, r101.f309315a) == true) goto L12;
            return false;
        L12:
            if (this.f309316b == r101.f309316b) goto L15;
            return false;
        L15:
            if (this.f309317c == r101.f309317c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f309315a.hashCode() * 31) + this.f309316b.hashCode()) * 31;
            if (this.f309317c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Button(text=" + this.f309315a + ", style=" + this.f309316b + ", enabled=" + this.f309317c + ')';
        }

        public Button(CharSequence r100, Style r101) {
            Intrinsics.checkNotNullParameter(r100, "text");
            Intrinsics.checkNotNullParameter(r101, "style");
            this.f309315a = r100;
            this.f309316b = r101;
            this.f309317c = true;
        }
    }

    public InteractionQuickReplyViewInput() {
        this(null, null, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InteractionQuickReplyViewInput) == true) goto L8;
        return false;
    L8:
        InteractionQuickReplyViewInput r101 = (InteractionQuickReplyViewInput) r100;
        if (Intrinsics.areEqual(this.f309306a, r101.f309306a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309307b, r101.f309307b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309308c, r101.f309308c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309309d, r101.f309309d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f309310e, r101.f309310e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f309311f, r101.f309311f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f309312g, r101.f309312g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f309313h, r101.f309313h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f309314i, r101.f309314i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f309306a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f309307b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f309308c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        CharSequence r110 = this.f309309d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        CharSequence r113 = this.f309310e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        CharSequence r116 = this.f309311f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        CharSequence r119 = this.f309312g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (((r118 + r120) * 31) + this.f309313h.hashCode()) * 31;
        Integer r122 = this.f309314i;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "InteractionQuickReplyViewInput(iconUrlLight=" + this.f309306a + ", iconUrlDark=" + this.f309307b + ", iconRes=" + this.f309308c + ", label=" + this.f309309d + ", title=" + this.f309310e + ", description=" + this.f309311f + ", folderName=" + this.f309312g + ", buttons=" + this.f309313h + ", loadingIndex=" + this.f309314i + ')';
    }

    public InteractionQuickReplyViewInput(String r100, String r101, CharSequence r102, CharSequence r103, CharSequence r104, CharSequence r105, List r106, Integer r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r111 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 64) == 0) goto L21;
        r105 = null;
    L21:
        if ((r111 & 128) == 0) goto L24;
        r106 = CollectionsKt.emptyList();
    L24:
        if ((r111 & 256) == 0) goto L26;
        r110 = null;
    L26:
        Intrinsics.checkNotNullParameter(r106, "buttons");
        this.f309306a = r100;
        this.f309307b = r101;
        this.f309308c = null;
        this.f309309d = r102;
        this.f309310e = r103;
        this.f309311f = r104;
        this.f309312g = r105;
        this.f309313h = r106;
        this.f309314i = r110;
    }
}
