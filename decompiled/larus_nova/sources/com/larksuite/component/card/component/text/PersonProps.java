package com.larksuite.component.card.component.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/larksuite/component/card/component/text/PersonProps;", "Lcom/larksuite/component/card/component/text/PlainTextProps;", "person", "Lcom/larksuite/component/card/component/text/Person;", "showAvatar", "", "showName", "type", "", "containerPadding", "Lcom/larksuite/component/card/component/text/ContainerPadding;", "textSize", "", "textColor", "textBgColor", "textDecoration", "", "content", "maxLines", "<init>", "(Lcom/larksuite/component/card/component/text/Person;ZZLjava/lang/String;Lcom/larksuite/component/card/component/text/ContainerPadding;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getPerson", "()Lcom/larksuite/component/card/component/text/Person;", "getShowAvatar", "()Z", "getShowName", "getType", "()Ljava/lang/String;", "getContainerPadding", "()Lcom/larksuite/component/card/component/text/ContainerPadding;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonProps extends PlainTextProps {
    private final ContainerPadding containerPadding;
    private final Person person;
    private final boolean showAvatar;
    private final boolean showName;
    private final String type;

    public PersonProps() {
        this(null, false, false, null, null, null, null, null, null, null, 0, 2047, null);
    }

    public final ContainerPadding getContainerPadding() {
        return this.containerPadding;
    }

    public final Person getPerson() {
        return this.person;
    }

    public final boolean getShowAvatar() {
        return this.showAvatar;
    }

    public final boolean getShowName() {
        return this.showName;
    }

    public final String getType() {
        return this.type;
    }

    public PersonProps(Person r100, boolean r110, boolean r111, String r112, ContainerPadding r113, Integer r114, String r115, String r116, List<String> r117, String r118, int r119) {
        Intrinsics.checkNotNullParameter(r118, "content");
        super(r114, r115, r116, r117, r118, r119);
        this.person = r100;
        this.showAvatar = r110;
        this.showName = r111;
        this.type = r112;
        this.containerPadding = r113;
    }

    public /* synthetic */ PersonProps(Person r110, boolean r111, boolean r112, String r113, ContainerPadding r114, Integer r115, String r116, String r117, List r210, String r211, int r212, int r213, DefaultConstructorMarker r214) {
        List r100 = null;
        if ((r213 & 1) == 0) goto L5;
        Person r101 = null;
    L7:
        if ((r213 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r213 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r213 & 16) == 0) goto L21;
        ContainerPadding r105 = null;
    L23:
        if ((r213 & 32) == 0) goto L25;
        Integer r106 = 14;
    L27:
        if ((r213 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r213 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r213 & 256) != 0) goto L39;
        r100 = r210;
    L39:
        if ((r213 & 512) == 0) goto L41;
        String r118 = "";
    L43:
        if ((r213 & 1024) == 0) goto L45;
        int r109 = Integer.MAX_VALUE;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100, r118, r109);
        return;
    L45:
        r109 = r212;
        goto L46
    L41:
        r118 = r211;
        goto L43
    L33:
        r108 = r117;
        goto L35
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
