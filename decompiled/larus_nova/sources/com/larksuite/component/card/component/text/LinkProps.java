package com.larksuite.component.card.component.text;

import com.larksuite.component.card.component.udicon.UDIconContentProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001Bu\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/larksuite/component/card/component/text/LinkProps;", "Lcom/larksuite/component/card/component/text/PlainTextProps;", "url", "", "androidUrl", "icon", "Lcom/larksuite/component/card/component/udicon/UDIconContentProps;", "textSize", "", "textColor", "textBgColor", "textDecoration", "", "content", "maxLines", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larksuite/component/card/component/udicon/UDIconContentProps;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getUrl", "()Ljava/lang/String;", "getAndroidUrl", "getIcon", "()Lcom/larksuite/component/card/component/udicon/UDIconContentProps;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkProps extends PlainTextProps {
    private final String androidUrl;
    private final UDIconContentProps icon;
    private final String url;

    public LinkProps() {
        this(null, null, null, null, null, null, null, null, 0, 511, null);
    }

    public final String getAndroidUrl() {
        return this.androidUrl;
    }

    public final UDIconContentProps getIcon() {
        return this.icon;
    }

    public final String getUrl() {
        return this.url;
    }

    public LinkProps(String r100, String r110, UDIconContentProps r111, Integer r112, String r113, String r114, List<String> r115, String r116, int r117) {
        Intrinsics.checkNotNullParameter(r116, "content");
        super(r112, r113, r114, r115, r116, r117);
        this.url = r100;
        this.androidUrl = r110;
        this.icon = r111;
    }

    public /* synthetic */ LinkProps(String r110, String r111, UDIconContentProps r112, Integer r113, String r114, String r115, List r116, String r117, int r118, int r119, DefaultConstructorMarker r210) {
        List r100 = null;
        if ((r119 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r119 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r119 & 4) == 0) goto L13;
        UDIconContentProps r103 = null;
    L15:
        if ((r119 & 8) == 0) goto L17;
        Integer r104 = 14;
    L19:
        if ((r119 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r119 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r119 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r119 & 128) == 0) goto L33;
        String r107 = "";
    L35:
        if ((r119 & 256) == 0) goto L37;
        int r108 = Integer.MAX_VALUE;
    L38:
        this(r101, r102, r103, r104, r105, r106, r100, r107, r108);
        return;
    L37:
        r108 = r118;
        goto L38
    L33:
        r107 = r117;
        goto L35
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
