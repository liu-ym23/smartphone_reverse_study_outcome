package com.obric.assistant.settings.autogui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemViewType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AUTO_GUI_SWITCH", "TITLE_HINT", "APP_AVAILABLE", "APP_INAVAILABLE", "LOADING_HINT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAutoGuiItemViewType extends Enum<ObricAutoGuiItemViewType> {
    public static final ObricAutoGuiItemViewType APP_AVAILABLE = null;
    public static final ObricAutoGuiItemViewType APP_INAVAILABLE = null;
    public static final ObricAutoGuiItemViewType AUTO_GUI_SWITCH = null;
    public static final ObricAutoGuiItemViewType LOADING_HINT = null;
    public static final ObricAutoGuiItemViewType TITLE_HINT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricAutoGuiItemViewType[] f391822a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391823b = null;
    private final int value;

    public static EnumEntries<ObricAutoGuiItemViewType> getEntries() {
        return f391823b;
    }

    static {
        ObricAutoGuiItemViewType r100 = new ObricAutoGuiItemViewType("AUTO_GUI_SWITCH", 0, 0);
        AUTO_GUI_SWITCH = r100;
        ObricAutoGuiItemViewType r101 = new ObricAutoGuiItemViewType("TITLE_HINT", 1, 1);
        TITLE_HINT = r101;
        ObricAutoGuiItemViewType r102 = new ObricAutoGuiItemViewType("APP_AVAILABLE", 2, 2);
        APP_AVAILABLE = r102;
        ObricAutoGuiItemViewType r103 = new ObricAutoGuiItemViewType("APP_INAVAILABLE", 3, 3);
        APP_INAVAILABLE = r103;
        ObricAutoGuiItemViewType r104 = new ObricAutoGuiItemViewType("LOADING_HINT", 4, 4);
        LOADING_HINT = r104;
        ObricAutoGuiItemViewType[] r105 = {r100, r101, r102, r103, r104};
        f391822a = r105;
        f391823b = EnumEntriesKt.enumEntries(r105);
    }

    public static ObricAutoGuiItemViewType[] values() {
        return (ObricAutoGuiItemViewType[]) f391822a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ObricAutoGuiItemViewType valueOf(String r100) {
        return (ObricAutoGuiItemViewType) r27.a.a(ObricAutoGuiItemViewType.class, r100);
    }

    public ObricAutoGuiItemViewType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
