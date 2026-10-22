package com.larksuite.component.card.component.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/card/component/text/AtProps;", "Lcom/larksuite/component/card/component/text/PlainTextProps;", "userId", "", "textSize", "", "textColor", "textBgColor", "textDecoration", "", "content", "maxLines", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getUserId", "()Ljava/lang/String;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AtProps extends PlainTextProps {
    private final String userId;

    public AtProps() {
        this(null, null, null, null, null, null, 0, 127, null);
    }

    public final String getUserId() {
        return this.userId;
    }

    public AtProps(String r100, Integer r101, String r110, String r111, List<String> r112, String r113, int r114) {
        Intrinsics.checkNotNullParameter(r113, "content");
        super(r101, r110, r111, r112, r113, r114);
        this.userId = r100;
    }

    public /* synthetic */ AtProps(String r100, Integer r101, String r102, String r103, List r110, String r111, int r112, int r113, DefaultConstructorMarker r114) {
        List r104 = null;
        if ((r113 & 1) == 0) goto L5;
        String r115 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        r101 = 14;
    L9:
        Integer r105 = r101;
        if ((r113 & 4) == 0) goto L12;
        String r106 = null;
    L14:
        if ((r113 & 8) == 0) goto L16;
        String r107 = null;
    L18:
        if ((r113 & 16) != 0) goto L22;
        r104 = r110;
    L22:
        if ((r113 & 32) == 0) goto L24;
        r111 = "";
    L24:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L27;
        int r116 = Integer.MAX_VALUE;
    L28:
        this(r115, r105, r106, r107, r104, r108, r116);
        return;
    L27:
        r116 = r112;
        goto L28
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L5:
        r115 = r100;
        goto L7
    }
}
