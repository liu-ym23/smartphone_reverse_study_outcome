package grb;

import com.ss.android.lark.message.card.component.CardCalendarDialogFactory$CardCalendarType;

/* JADX INFO: loaded from: classes36.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f482412a = null;

    static {
        int[] r100 = new int[CardCalendarDialogFactory$CardCalendarType.values().length];
        f482412a = r100;
        r100[CardCalendarDialogFactory$CardCalendarType.Date.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L10:
        f482412a[CardCalendarDialogFactory$CardCalendarType.Time.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L12:
        f482412a[CardCalendarDialogFactory$CardCalendarType.DateTime.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
        return;
    }
}
