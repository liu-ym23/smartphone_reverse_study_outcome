package com.larksuite.component.universe_design.button.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/button/compose/UDButtonShape;", "", "<init>", "(Ljava/lang/String;I)V", "Rounded", "Circle", "universe-ui-button_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDButtonShape extends Enum<UDButtonShape> {
    public static final UDButtonShape Circle = null;
    public static final UDButtonShape Rounded = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDButtonShape[] f284605a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284606b = null;

    public static EnumEntries<UDButtonShape> getEntries() {
        return f284606b;
    }

    static {
        UDButtonShape r100 = new UDButtonShape("Rounded", 0);
        Rounded = r100;
        UDButtonShape r101 = new UDButtonShape("Circle", 1);
        Circle = r101;
        UDButtonShape[] r102 = {r100, r101};
        f284605a = r102;
        f284606b = EnumEntriesKt.enumEntries(r102);
    }

    public static UDButtonShape[] values() {
        return (UDButtonShape[]) f284605a.clone();
    }

    public static UDButtonShape valueOf(String r100) {
        return (UDButtonShape) r27.a.a(UDButtonShape.class, r100);
    }

    public UDButtonShape(String r100, int r101) {
        super(r100, r101);
    }
}
