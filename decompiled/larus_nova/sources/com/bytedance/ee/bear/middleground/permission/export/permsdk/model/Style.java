package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/Style;", "", "<init>", "(Ljava/lang/String;I)V", "TOAST", "DIALOG_ALERT", "UNKNOWN", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Style extends Enum<Style> {
    public static final Style DIALOG_ALERT = null;
    public static final Style TOAST = null;
    public static final Style UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Style[] f233873a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f233874b = null;

    public static EnumEntries<Style> getEntries() {
        return f233874b;
    }

    static {
        Style r100 = new Style("TOAST", 0);
        TOAST = r100;
        Style r101 = new Style("DIALOG_ALERT", 1);
        DIALOG_ALERT = r101;
        Style r102 = new Style("UNKNOWN", 2);
        UNKNOWN = r102;
        Style[] r103 = {r100, r101, r102};
        f233873a = r103;
        f233874b = EnumEntriesKt.enumEntries(r103);
    }

    public static Style[] values() {
        return (Style[]) f233873a.clone();
    }

    public static Style valueOf(String r100) {
        return (Style) a.a(Style.class, r100);
    }

    public Style(String r100, int r101) {
        super(r100, r101);
    }
}
