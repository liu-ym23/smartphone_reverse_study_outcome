package com.larksuite.component.card.component.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/larksuite/component/card/component/text/TextStyle;", "", "textSize", "", "textColorToken", "", "textBGColorToken", "align", "maxLines", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getTextSize", "()I", "getTextColorToken", "()Ljava/lang/String;", "getTextBGColorToken", "getAlign", "getMaxLines", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TextStyle {
    private final String align;
    private final int maxLines;
    private final String textBGColorToken;
    private final String textColorToken;
    private final int textSize;

    public TextStyle() {
        this(0, null, null, null, 0, 31, null);
    }

    public final String getAlign() {
        return this.align;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final String getTextBGColorToken() {
        return this.textBGColorToken;
    }

    public final String getTextColorToken() {
        return this.textColorToken;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public TextStyle(int r100, String r101, String r102, String r103, int r104) {
        this.textSize = r100;
        this.textColorToken = r101;
        this.textBGColorToken = r102;
        this.align = r103;
        this.maxLines = r104;
    }

    public /* synthetic */ TextStyle(int r100, String r101, String r102, String r103, int r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = 14;
    L5:
        String r106 = null;
        if ((r105 & 2) == 0) goto L8;
        String r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        String r107 = null;
    L14:
        if ((r105 & 8) != 0) goto L18;
        r106 = r103;
    L18:
        if ((r105 & 16) == 0) goto L20;
        int r108 = 1;
    L21:
        this(r100, r111, r107, r106, r108);
        return;
    L20:
        r108 = r104;
        goto L21
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
