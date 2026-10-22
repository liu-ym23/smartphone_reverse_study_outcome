package com.larksuite.component.card.component.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/larksuite/component/card/component/text/NumberTagProps;", "Lcom/larksuite/component/card/component/text/PlainTextProps;", "url", "", "originalTextSize", "", "circleSize", "tagBgColor", "textSize", "textColor", "textBgColor", "textDecoration", "", "content", "maxLines", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getUrl", "()Ljava/lang/String;", "getOriginalTextSize", "()I", "getCircleSize", "getTagBgColor", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NumberTagProps extends PlainTextProps {
    private final int circleSize;
    private final int originalTextSize;
    private final String tagBgColor;
    private final String url;

    public NumberTagProps() {
        this(null, 0, 0, null, null, null, null, null, null, 0, 1023, null);
    }

    public final int getCircleSize() {
        return this.circleSize;
    }

    public final int getOriginalTextSize() {
        return this.originalTextSize;
    }

    public final String getTagBgColor() {
        return this.tagBgColor;
    }

    public final String getUrl() {
        return this.url;
    }

    public NumberTagProps(String r100, int r110, int r111, String r112, Integer r113, String r114, String r115, List<String> r116, String r117, int r118) {
        Intrinsics.checkNotNullParameter(r117, "content");
        super(r113, r114, r115, r116, r117, r118);
        this.url = r100;
        this.originalTextSize = r110;
        this.circleSize = r111;
        this.tagBgColor = r112;
    }

    public /* synthetic */ NumberTagProps(String r110, int r111, int r112, String r113, Integer r114, String r115, String r116, List r117, String r118, int r210, int r211, DefaultConstructorMarker r212) {
        List r100 = null;
        if ((r211 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r211 & 2) == 0) goto L9;
        int r102 = 14;
    L11:
        if ((r211 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r211 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r211 & 16) == 0) goto L21;
        Integer r105 = 14;
    L23:
        if ((r211 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r211 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r211 & 128) != 0) goto L35;
        r100 = r117;
    L35:
        if ((r211 & 256) == 0) goto L37;
        String r108 = "";
    L39:
        if ((r211 & 512) == 0) goto L41;
        int r109 = Integer.MAX_VALUE;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r100, r108, r109);
        return;
    L41:
        r109 = r210;
        goto L42
    L37:
        r108 = r118;
        goto L39
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
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
