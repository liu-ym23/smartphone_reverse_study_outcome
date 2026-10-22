package com.larksuite.component.card.component.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/larksuite/component/card/component/text/PlainTextProps;", "", "textSize", "", "textColor", "", "textBgColor", "textDecoration", "", "content", "maxLines", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getTextSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTextColor", "()Ljava/lang/String;", "getTextBgColor", "getTextDecoration", "()Ljava/util/List;", "getContent", "getMaxLines", "()I", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PlainTextProps {
    private final String content;
    private final int maxLines;
    private final String textBgColor;
    private final String textColor;
    private final List<String> textDecoration;
    private final Integer textSize;

    public PlainTextProps() {
        this(null, null, null, null, null, 0, 63, null);
    }

    public final String getContent() {
        return this.content;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final String getTextBgColor() {
        return this.textBgColor;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final List<String> getTextDecoration() {
        return this.textDecoration;
    }

    public final Integer getTextSize() {
        return this.textSize;
    }

    public PlainTextProps(Integer r100, String r101, String r102, List<String> r103, String r104, int r105) {
        Intrinsics.checkNotNullParameter(r104, "content");
        this.textSize = r100;
        this.textColor = r101;
        this.textBgColor = r102;
        this.textDecoration = r103;
        this.content = r104;
        this.maxLines = r105;
    }

    public /* synthetic */ PlainTextProps(Integer r100, String r101, String r102, List r103, String r104, int r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = 14;
    L5:
        List r105 = null;
        if ((r111 & 2) == 0) goto L8;
        String r113 = null;
    L10:
        if ((r111 & 4) == 0) goto L12;
        String r106 = null;
    L14:
        if ((r111 & 8) != 0) goto L18;
        r105 = r103;
    L18:
        if ((r111 & 16) == 0) goto L20;
        r104 = "";
    L20:
        String r107 = r104;
        if ((r111 & 32) == 0) goto L23;
        int r108 = Integer.MAX_VALUE;
    L24:
        this(r100, r113, r106, r105, r107, r108);
        return;
    L23:
        r108 = r110;
        goto L24
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}
