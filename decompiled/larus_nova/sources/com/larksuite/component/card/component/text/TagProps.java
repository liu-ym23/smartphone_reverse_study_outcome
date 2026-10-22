package com.larksuite.component.card.component.text;

import android.text.TextUtils;
import com.larus.trace.CopyContentTypeString;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u001b\u001a\u00020\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/larksuite/component/card/component/text/TagProps;", "Lcom/larksuite/component/card/component/text/TextStyle;", "content", "", "tagBGColorToken", "tagStyle", "textDecoration", "", "originalTextSize", "", "index", "textSize", "textColorToken", "textBGColorToken", "align", "maxLines", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "getTagBGColorToken", "getTagStyle", "getTextDecoration", "()Ljava/util/List;", "getOriginalTextSize", "()I", "getIndex", "isInTable", "", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagProps extends TextStyle {
    private final String content;
    private final int index;
    private final int originalTextSize;
    private final String tagBGColorToken;
    private final String tagStyle;
    private final List<String> textDecoration;

    public TagProps() {
        this(null, null, null, null, 0, 0, 0, null, null, null, 0, 2047, null);
    }

    public final boolean isInTable() {
        return TextUtils.equals(CopyContentTypeString.TABLE, this.tagStyle);
    }

    public final String getContent() {
        return this.content;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getOriginalTextSize() {
        return this.originalTextSize;
    }

    public final String getTagBGColorToken() {
        return this.tagBGColorToken;
    }

    public final String getTagStyle() {
        return this.tagStyle;
    }

    public final List<String> getTextDecoration() {
        return this.textDecoration;
    }

    public TagProps(String r100, String r101, String r110, List<String> r111, int r112, int r113, int r114, String r115, String r116, String r117, int r118) {
        super(r114, r115, r116, r117, r118);
        this.content = r100;
        this.tagBGColorToken = r101;
        this.tagStyle = r110;
        this.textDecoration = r111;
        this.originalTextSize = r112;
        this.index = r113;
    }

    public /* synthetic */ TagProps(String r110, String r111, String r112, List r113, int r114, int r115, int r116, String r210, String r211, String r212, int r213, int r214, DefaultConstructorMarker r215) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        List r104 = null;
    L18:
        int r105 = 14;
        if ((r214 & 16) == 0) goto L21;
        int r106 = 14;
    L23:
        if ((r214 & 32) == 0) goto L25;
        int r107 = -1;
    L27:
        if ((r214 & 64) != 0) goto L31;
        r105 = r116;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r214 & 512) != 0) goto L43;
        r100 = r212;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        int r109 = 1;
    L46:
        this(r101, r102, r103, r104, r106, r107, r105, r108, r117, r100, r109);
        return;
    L45:
        r109 = r213;
        goto L46
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
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
