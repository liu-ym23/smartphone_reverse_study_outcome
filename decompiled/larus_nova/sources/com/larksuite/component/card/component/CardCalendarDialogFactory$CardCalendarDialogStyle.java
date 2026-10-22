package com.larksuite.component.card.component;

/* JADX INFO: loaded from: classes24.dex */
public final enum CardCalendarDialogFactory$CardCalendarDialogStyle extends Enum<CardCalendarDialogFactory$CardCalendarDialogStyle> {
    public static final CardCalendarDialogFactory$CardCalendarDialogStyle BottomSheet = null;
    public static final CardCalendarDialogFactory$CardCalendarDialogStyle Modal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardCalendarDialogFactory$CardCalendarDialogStyle[] f283255a = null;

    static {
        CardCalendarDialogFactory$CardCalendarDialogStyle r100 = new CardCalendarDialogFactory$CardCalendarDialogStyle("BottomSheet", 0);
        BottomSheet = r100;
        CardCalendarDialogFactory$CardCalendarDialogStyle r101 = new CardCalendarDialogFactory$CardCalendarDialogStyle("Modal", 1);
        Modal = r101;
        f283255a = new CardCalendarDialogFactory$CardCalendarDialogStyle[]{r100, r101};
    }

    public static CardCalendarDialogFactory$CardCalendarDialogStyle[] values() {
        return (CardCalendarDialogFactory$CardCalendarDialogStyle[]) f283255a.clone();
    }

    public static CardCalendarDialogFactory$CardCalendarDialogStyle valueOf(String r100) {
        return (CardCalendarDialogFactory$CardCalendarDialogStyle) r27.a.a(CardCalendarDialogFactory$CardCalendarDialogStyle.class, r100);
    }

    public CardCalendarDialogFactory$CardCalendarDialogStyle(String r100, int r101) {
        super(r100, r101);
    }
}
