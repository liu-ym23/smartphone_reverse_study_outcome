package com.larksuite.component.card.component.text;

import com.larksuite.component.card.component.udicon.UDIconContentProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B½\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/larksuite/component/card/component/text/AudioProps;", "Lcom/larksuite/component/card/component/text/PlainTextProps;", "audioInfo", "Lcom/larksuite/component/card/component/text/MarkdownAudioInfo;", "audioState", "Lcom/larksuite/component/card/component/text/MarkdownAudioState;", "bgColor", "", "style", "showTime", "", "icon", "Lcom/larksuite/component/card/component/udicon/UDIconContentProps;", "originalTextSize", "", "bgHeight", "bgPadding", "Lcom/larksuite/component/card/component/text/MarkdownAudioBgPadding;", "textSize", "textColor", "textBgColor", "textDecoration", "", "content", "maxLines", "<init>", "(Lcom/larksuite/component/card/component/text/MarkdownAudioInfo;Lcom/larksuite/component/card/component/text/MarkdownAudioState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larksuite/component/card/component/udicon/UDIconContentProps;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larksuite/component/card/component/text/MarkdownAudioBgPadding;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getAudioInfo", "()Lcom/larksuite/component/card/component/text/MarkdownAudioInfo;", "getAudioState", "()Lcom/larksuite/component/card/component/text/MarkdownAudioState;", "getBgColor", "()Ljava/lang/String;", "getStyle", "getShowTime", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIcon", "()Lcom/larksuite/component/card/component/udicon/UDIconContentProps;", "getOriginalTextSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBgHeight", "getBgPadding", "()Lcom/larksuite/component/card/component/text/MarkdownAudioBgPadding;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioProps extends PlainTextProps {
    private final a audioInfo;
    private final MarkdownAudioState audioState;
    private final String bgColor;
    private final Integer bgHeight;
    private final MarkdownAudioBgPadding bgPadding;
    private final UDIconContentProps icon;
    private final Integer originalTextSize;
    private final Boolean showTime;
    private final String style;

    public AudioProps() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 32767, null);
    }

    public final a getAudioInfo() {
        return this.audioInfo;
    }

    public final MarkdownAudioState getAudioState() {
        return this.audioState;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final Integer getBgHeight() {
        return this.bgHeight;
    }

    public final MarkdownAudioBgPadding getBgPadding() {
        return this.bgPadding;
    }

    public final UDIconContentProps getIcon() {
        return this.icon;
    }

    public final Integer getOriginalTextSize() {
        return this.originalTextSize;
    }

    public final Boolean getShowTime() {
        return this.showTime;
    }

    public final String getStyle() {
        return this.style;
    }

    public AudioProps(a r100, MarkdownAudioState r110, String r111, String r112, Boolean r113, UDIconContentProps r114, Integer r115, Integer r116, MarkdownAudioBgPadding r117, Integer r118, String r119, String r210, List<String> r211, String r212, int r213) {
        Intrinsics.checkNotNullParameter(r212, "content");
        super(r118, r119, r210, r211, r212, r213);
        this.audioInfo = r100;
        this.audioState = r110;
        this.bgColor = r111;
        this.style = r112;
        this.showTime = r113;
        this.icon = r114;
        this.originalTextSize = r115;
        this.bgHeight = r116;
        this.bgPadding = r117;
    }

    public /* synthetic */ AudioProps(a r110, MarkdownAudioState r111, String r112, String r113, Boolean r210, UDIconContentProps r211, Integer r212, Integer r213, MarkdownAudioBgPadding r214, Integer r215, String r216, String r217, List r218, String r219, int r310, int r311, DefaultConstructorMarker r312) {
        List r100 = null;
        if ((r311 & 1) == 0) goto L5;
        a r101 = null;
    L7:
        if ((r311 & 2) == 0) goto L9;
        MarkdownAudioState r102 = null;
    L11:
        if ((r311 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r311 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r311 & 16) == 0) goto L21;
        Boolean r105 = null;
    L23:
        if ((r311 & 32) == 0) goto L25;
        UDIconContentProps r106 = null;
    L27:
        if ((r311 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r311 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r311 & 256) == 0) goto L37;
        MarkdownAudioBgPadding r114 = null;
    L39:
        if ((r311 & 512) == 0) goto L41;
        Integer r115 = 14;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r311 & 2048) == 0) goto L49;
        String r117 = null;
    L51:
        if ((r311 & 4096) != 0) goto L55;
        r100 = r218;
    L55:
        if ((r311 & 8192) == 0) goto L57;
        String r118 = "";
    L59:
        if ((r311 & 16384) == 0) goto L61;
        int r109 = Integer.MAX_VALUE;
    L62:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r100, r118, r109);
        return;
    L61:
        r109 = r310;
        goto L62
    L57:
        r118 = r219;
        goto L59
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
