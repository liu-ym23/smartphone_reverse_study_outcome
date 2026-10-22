package com.larksuite.component.card.component.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u001fHÆ\u0003JÓ\u0001\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020THÖ\u0001J\t\u0010U\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b:\u00100R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>¨\u0006V"}, d2 = {"Lcom/larksuite/component/card/component/text/ContentProps;", "", "id", "", "tag", "atProps", "Lcom/larksuite/component/card/component/text/AtProps;", "linkProps", "Lcom/larksuite/component/card/component/text/LinkProps;", "emojProps", "Lcom/larksuite/component/card/component/text/EmojProps;", "plainTextProps", "Lcom/larksuite/component/card/component/text/PlainTextProps;", "textTagProps", "Lcom/larksuite/component/card/component/text/TagProps;", "listProps", "", "Lcom/larksuite/component/card/component/text/ListItem;", "codeBlockProps", "Lcom/larksuite/component/card/component/text/CardCodeBlockProps;", "imageProps", "Lcom/larksuite/component/card/component/image/ImageContentProps;", "personProps", "Lcom/larksuite/component/card/component/text/PersonProps;", "headingProps", "Lcom/larksuite/component/card/component/text/HeadingProps;", "codeSpanProps", "blockQuoteProps", "numberTagProps", "Lcom/larksuite/component/card/component/text/NumberTagProps;", "audioProps", "Lcom/larksuite/component/card/component/text/AudioProps;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larksuite/component/card/component/text/AtProps;Lcom/larksuite/component/card/component/text/LinkProps;Lcom/larksuite/component/card/component/text/EmojProps;Lcom/larksuite/component/card/component/text/PlainTextProps;Lcom/larksuite/component/card/component/text/TagProps;Ljava/util/List;Lcom/larksuite/component/card/component/text/CardCodeBlockProps;Lcom/larksuite/component/card/component/image/ImageContentProps;Lcom/larksuite/component/card/component/text/PersonProps;Lcom/larksuite/component/card/component/text/HeadingProps;Lcom/larksuite/component/card/component/text/PlainTextProps;Ljava/util/List;Lcom/larksuite/component/card/component/text/NumberTagProps;Lcom/larksuite/component/card/component/text/AudioProps;)V", "getId", "()Ljava/lang/String;", "getTag", "getAtProps", "()Lcom/larksuite/component/card/component/text/AtProps;", "getLinkProps", "()Lcom/larksuite/component/card/component/text/LinkProps;", "getEmojProps", "()Lcom/larksuite/component/card/component/text/EmojProps;", "getPlainTextProps", "()Lcom/larksuite/component/card/component/text/PlainTextProps;", "getTextTagProps", "()Lcom/larksuite/component/card/component/text/TagProps;", "getListProps", "()Ljava/util/List;", "getCodeBlockProps", "()Lcom/larksuite/component/card/component/text/CardCodeBlockProps;", "getImageProps", "()Lcom/larksuite/component/card/component/image/ImageContentProps;", "getPersonProps", "()Lcom/larksuite/component/card/component/text/PersonProps;", "getHeadingProps", "()Lcom/larksuite/component/card/component/text/HeadingProps;", "getCodeSpanProps", "getBlockQuoteProps", "getNumberTagProps", "()Lcom/larksuite/component/card/component/text/NumberTagProps;", "getAudioProps", "()Lcom/larksuite/component/card/component/text/AudioProps;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "", "other", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentProps {
    private final AtProps atProps;
    private final AudioProps audioProps;
    private final List<ContentProps> blockQuoteProps;
    private final CardCodeBlockProps codeBlockProps;
    private final PlainTextProps codeSpanProps;
    private final EmojProps emojProps;
    private final HeadingProps headingProps;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f283578id;
    private final com.larksuite.component.card.component.image.a imageProps;
    private final LinkProps linkProps;
    private final List<ListItem> listProps;
    private final NumberTagProps numberTagProps;
    private final PersonProps personProps;
    private final PlainTextProps plainTextProps;
    private final String tag;
    private final TagProps textTagProps;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContentProps copy$default(ContentProps r110, String r111, String r112, AtProps r210, LinkProps r211, EmojProps r212, PlainTextProps r213, TagProps r214, List r215, CardCodeBlockProps r216, com.larksuite.component.card.component.image.a r217, PersonProps r218, HeadingProps r219, PlainTextProps r310, List r311, NumberTagProps r312, AudioProps r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = r110.f283578id;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = r110.tag;
    L11:
        if ((r314 & 4) == 0) goto L13;
        AtProps r102 = r110.atProps;
    L15:
        if ((r314 & 8) == 0) goto L17;
        LinkProps r103 = r110.linkProps;
    L19:
        if ((r314 & 16) == 0) goto L21;
        EmojProps r104 = r110.emojProps;
    L23:
        if ((r314 & 32) == 0) goto L25;
        PlainTextProps r105 = r110.plainTextProps;
    L27:
        if ((r314 & 64) == 0) goto L29;
        TagProps r106 = r110.textTagProps;
    L31:
        if ((r314 & 128) == 0) goto L33;
        List r107 = r110.listProps;
    L35:
        if ((r314 & 256) == 0) goto L37;
        CardCodeBlockProps r113 = r110.codeBlockProps;
    L39:
        if ((r314 & 512) == 0) goto L41;
        com.larksuite.component.card.component.image.a r114 = r110.imageProps;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        PersonProps r115 = r110.personProps;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        HeadingProps r116 = r110.headingProps;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        PlainTextProps r117 = r110.codeSpanProps;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        List r118 = r110.blockQuoteProps;
    L58:
        List r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        NumberTagProps r119 = r110.numberTagProps;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        AudioProps r108 = r110.audioProps;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.f283578id;
    }

    public final com.larksuite.component.card.component.image.a component10() {
        return this.imageProps;
    }

    public final PersonProps component11() {
        return this.personProps;
    }

    public final HeadingProps component12() {
        return this.headingProps;
    }

    public final PlainTextProps component13() {
        return this.codeSpanProps;
    }

    public final List<ContentProps> component14() {
        return this.blockQuoteProps;
    }

    public final NumberTagProps component15() {
        return this.numberTagProps;
    }

    public final AudioProps component16() {
        return this.audioProps;
    }

    public final String component2() {
        return this.tag;
    }

    public final AtProps component3() {
        return this.atProps;
    }

    public final LinkProps component4() {
        return this.linkProps;
    }

    public final EmojProps component5() {
        return this.emojProps;
    }

    public final PlainTextProps component6() {
        return this.plainTextProps;
    }

    public final TagProps component7() {
        return this.textTagProps;
    }

    public final List<ListItem> component8() {
        return this.listProps;
    }

    public final CardCodeBlockProps component9() {
        return this.codeBlockProps;
    }

    public final ContentProps copy(String r110, String r210, AtProps r211, LinkProps r212, EmojProps r213, PlainTextProps r214, TagProps r215, List<ListItem> r216, CardCodeBlockProps r217, com.larksuite.component.card.component.image.a r218, PersonProps r219, HeadingProps r310, PlainTextProps r311, List<ContentProps> r312, NumberTagProps r313, AudioProps r314) {
        Intrinsics.checkNotNullParameter(r210, "tag");
        return new ContentProps(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContentProps) == true) goto L8;
        return false;
    L8:
        ContentProps r101 = (ContentProps) r100;
        if (Intrinsics.areEqual(this.f283578id, r101.f283578id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.atProps, r101.atProps) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.linkProps, r101.linkProps) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.emojProps, r101.emojProps) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.plainTextProps, r101.plainTextProps) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.textTagProps, r101.textTagProps) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.listProps, r101.listProps) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.codeBlockProps, r101.codeBlockProps) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.imageProps, r101.imageProps) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.personProps, r101.personProps) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.headingProps, r101.headingProps) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.codeSpanProps, r101.codeSpanProps) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.blockQuoteProps, r101.blockQuoteProps) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.numberTagProps, r101.numberTagProps) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.audioProps, r101.audioProps) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        String r100 = this.f283578id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.tag.hashCode()) * 31;
        AtProps r104 = this.atProps;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        LinkProps r107 = this.linkProps;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        EmojProps r110 = this.emojProps;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        PlainTextProps r113 = this.plainTextProps;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        TagProps r116 = this.textTagProps;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<ListItem> r119 = this.listProps;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        CardCodeBlockProps r122 = this.codeBlockProps;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        com.larksuite.component.card.component.image.a r125 = this.imageProps;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        PersonProps r128 = this.personProps;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        HeadingProps r131 = this.headingProps;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        PlainTextProps r134 = this.codeSpanProps;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        List<ContentProps> r137 = this.blockQuoteProps;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        NumberTagProps r140 = this.numberTagProps;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        AudioProps r143 = this.audioProps;
        if (r143 == null) goto L63;
        r101 = r143.hashCode();
    L63:
        return r142 + r101;
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
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

    public String toString() {
        return "ContentProps(id=" + this.f283578id + ", tag=" + this.tag + ", atProps=" + this.atProps + ", linkProps=" + this.linkProps + ", emojProps=" + this.emojProps + ", plainTextProps=" + this.plainTextProps + ", textTagProps=" + this.textTagProps + ", listProps=" + this.listProps + ", codeBlockProps=" + this.codeBlockProps + ", imageProps=" + this.imageProps + ", personProps=" + this.personProps + ", headingProps=" + this.headingProps + ", codeSpanProps=" + this.codeSpanProps + ", blockQuoteProps=" + this.blockQuoteProps + ", numberTagProps=" + this.numberTagProps + ", audioProps=" + this.audioProps + ')';
    }

    public final AtProps getAtProps() {
        return this.atProps;
    }

    public final AudioProps getAudioProps() {
        return this.audioProps;
    }

    public final List<ContentProps> getBlockQuoteProps() {
        return this.blockQuoteProps;
    }

    public final CardCodeBlockProps getCodeBlockProps() {
        return this.codeBlockProps;
    }

    public final PlainTextProps getCodeSpanProps() {
        return this.codeSpanProps;
    }

    public final EmojProps getEmojProps() {
        return this.emojProps;
    }

    public final HeadingProps getHeadingProps() {
        return this.headingProps;
    }

    public final String getId() {
        return this.f283578id;
    }

    public final com.larksuite.component.card.component.image.a getImageProps() {
        return this.imageProps;
    }

    public final LinkProps getLinkProps() {
        return this.linkProps;
    }

    public final List<ListItem> getListProps() {
        return this.listProps;
    }

    public final NumberTagProps getNumberTagProps() {
        return this.numberTagProps;
    }

    public final PersonProps getPersonProps() {
        return this.personProps;
    }

    public final PlainTextProps getPlainTextProps() {
        return this.plainTextProps;
    }

    public final String getTag() {
        return this.tag;
    }

    public final TagProps getTextTagProps() {
        return this.textTagProps;
    }

    public ContentProps(String r100, String r101, AtProps r102, LinkProps r103, EmojProps r104, PlainTextProps r105, TagProps r110, List<ListItem> r111, CardCodeBlockProps r112, com.larksuite.component.card.component.image.a r113, PersonProps r114, HeadingProps r115, PlainTextProps r116, List<ContentProps> r117, NumberTagProps r118, AudioProps r119) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        this.f283578id = r100;
        this.tag = r101;
        this.atProps = r102;
        this.linkProps = r103;
        this.emojProps = r104;
        this.plainTextProps = r105;
        this.textTagProps = r110;
        this.listProps = r111;
        this.codeBlockProps = r112;
        this.imageProps = r113;
        this.personProps = r114;
        this.headingProps = r115;
        this.codeSpanProps = r116;
        this.blockQuoteProps = r117;
        this.numberTagProps = r118;
        this.audioProps = r119;
    }

    public /* synthetic */ ContentProps(String r210, String r211, AtProps r212, LinkProps r213, EmojProps r214, PlainTextProps r215, TagProps r216, List r217, CardCodeBlockProps r218, com.larksuite.component.card.component.image.a r310, PersonProps r311, HeadingProps r312, PlainTextProps r313, List r314, NumberTagProps r315, AudioProps r316, int r317, DefaultConstructorMarker r318) {
        if ((r317 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r317 & 4) == 0) goto L9;
        AtProps r101 = null;
    L11:
        if ((r317 & 8) == 0) goto L13;
        LinkProps r102 = null;
    L15:
        if ((r317 & 16) == 0) goto L17;
        EmojProps r103 = null;
    L19:
        if ((r317 & 32) == 0) goto L21;
        PlainTextProps r104 = null;
    L23:
        if ((r317 & 64) == 0) goto L25;
        TagProps r110 = null;
    L27:
        if ((r317 & 128) == 0) goto L29;
        List r111 = null;
    L31:
        if ((r317 & 256) == 0) goto L33;
        CardCodeBlockProps r112 = null;
    L35:
        if ((r317 & 512) == 0) goto L37;
        com.larksuite.component.card.component.image.a r113 = null;
    L39:
        if ((r317 & 1024) == 0) goto L41;
        PersonProps r114 = null;
    L43:
        if ((r317 & 2048) == 0) goto L45;
        HeadingProps r115 = null;
    L47:
        if ((r317 & 4096) == 0) goto L49;
        PlainTextProps r116 = null;
    L51:
        if ((r317 & 8192) == 0) goto L53;
        List r117 = null;
    L55:
        if ((r317 & 16384) == 0) goto L57;
        NumberTagProps r118 = null;
    L59:
        if ((r317 & 32768) == 0) goto L61;
        AudioProps r119 = null;
    L62:
        this(r100, r211, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119);
        return;
    L61:
        r119 = r316;
        goto L62
    L57:
        r118 = r315;
        goto L59
    L53:
        r117 = r314;
        goto L55
    L49:
        r116 = r313;
        goto L51
    L45:
        r115 = r312;
        goto L47
    L41:
        r114 = r311;
        goto L43
    L37:
        r113 = r310;
        goto L39
    L33:
        r112 = r218;
        goto L35
    L29:
        r111 = r217;
        goto L31
    L25:
        r110 = r216;
        goto L27
    L21:
        r104 = r215;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
