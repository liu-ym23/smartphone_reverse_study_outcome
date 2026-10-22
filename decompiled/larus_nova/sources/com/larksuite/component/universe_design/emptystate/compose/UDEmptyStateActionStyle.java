package com.larksuite.component.universe_design.emptystate.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/emptystate/compose/UDEmptyStateActionStyle;", "", "<init>", "(Ljava/lang/String;I)V", "Button", "TextLink", "universe-ui-emptystate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDEmptyStateActionStyle extends Enum<UDEmptyStateActionStyle> {
    public static final UDEmptyStateActionStyle Button = null;
    public static final UDEmptyStateActionStyle TextLink = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDEmptyStateActionStyle[] f285004a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285005b = null;

    public static EnumEntries<UDEmptyStateActionStyle> getEntries() {
        return f285005b;
    }

    static {
        UDEmptyStateActionStyle r100 = new UDEmptyStateActionStyle("Button", 0);
        Button = r100;
        UDEmptyStateActionStyle r101 = new UDEmptyStateActionStyle("TextLink", 1);
        TextLink = r101;
        UDEmptyStateActionStyle[] r102 = {r100, r101};
        f285004a = r102;
        f285005b = EnumEntriesKt.enumEntries(r102);
    }

    public static UDEmptyStateActionStyle[] values() {
        return (UDEmptyStateActionStyle[]) f285004a.clone();
    }

    public static UDEmptyStateActionStyle valueOf(String r100) {
        return (UDEmptyStateActionStyle) r27.a.a(UDEmptyStateActionStyle.class, r100);
    }

    public UDEmptyStateActionStyle(String r100, int r101) {
        super(r100, r101);
    }
}
