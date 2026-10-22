package com.larksuite.component.card.component;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f283268a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f283269b = null;

    static {
        int[] r100 = new int[CardCalendarDialogFactory$CardCalendarDialogStyle.values().length];
        f283269b = r100;
        r100[CardCalendarDialogFactory$CardCalendarDialogStyle.BottomSheet.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L16:
        f283269b[CardCalendarDialogFactory$CardCalendarDialogStyle.Modal.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L6:
        int[] r101 = new int[CardCalendarDialogFactory$CardCalendarType.values().length];
        f283268a = r101;
        r101[CardCalendarDialogFactory$CardCalendarType.Date.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
    L20:
        f283268a[CardCalendarDialogFactory$CardCalendarType.Time.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
    L24:
        f283268a[CardCalendarDialogFactory$CardCalendarType.DateTime.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        return;
    }
}
