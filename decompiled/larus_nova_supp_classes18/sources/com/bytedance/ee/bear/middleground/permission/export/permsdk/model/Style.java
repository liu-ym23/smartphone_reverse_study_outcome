package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/Style;", "", "<init>", "(Ljava/lang/String;I)V", "TOAST", "DIALOG_ALERT", "UNKNOWN", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Style extends Enum<Style> {
    public static final Style DIALOG_ALERT = null;
    public static final Style TOAST = null;
    public static final Style UNKNOWN = null;
    public static final /* synthetic */ Style[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<Style> getEntries() {
        return b;
    }

    static {
        Style r0 = new Style("TOAST", 0);
        TOAST = r0;
        Style r1 = new Style("DIALOG_ALERT", 1);
        DIALOG_ALERT = r1;
        Style r3 = new Style("UNKNOWN", 2);
        UNKNOWN = r3;
        Style[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static Style[] values() {
        return (Style[]) a.clone();
    }

    public static Style valueOf(String r1) {
        return (Style) a.a(Style.class, r1);
    }

    public Style(String r1, int r2) {
        super(r1, r2);
    }
}
