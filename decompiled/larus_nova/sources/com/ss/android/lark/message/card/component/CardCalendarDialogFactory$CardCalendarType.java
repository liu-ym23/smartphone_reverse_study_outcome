package com.ss.android.lark.message.card.component;

import androidx.exifinterface.media.ExifInterface;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum CardCalendarDialogFactory$CardCalendarType extends Enum<CardCalendarDialogFactory$CardCalendarType> {
    public static final CardCalendarDialogFactory$CardCalendarType Date = null;
    public static final CardCalendarDialogFactory$CardCalendarType DateTime = null;
    public static final CardCalendarDialogFactory$CardCalendarType Time = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardCalendarDialogFactory$CardCalendarType[] f431904a = null;

    static {
        CardCalendarDialogFactory$CardCalendarType r100 = new CardCalendarDialogFactory$CardCalendarType("Date", 0);
        Date = r100;
        CardCalendarDialogFactory$CardCalendarType r101 = new CardCalendarDialogFactory$CardCalendarType("Time", 1);
        Time = r101;
        CardCalendarDialogFactory$CardCalendarType r102 = new CardCalendarDialogFactory$CardCalendarType(ExifInterface.TAG_DATETIME, 2);
        DateTime = r102;
        f431904a = new CardCalendarDialogFactory$CardCalendarType[]{r100, r101, r102};
    }

    public static CardCalendarDialogFactory$CardCalendarType[] values() {
        return (CardCalendarDialogFactory$CardCalendarType[]) f431904a.clone();
    }

    public static CardCalendarDialogFactory$CardCalendarType valueOf(String r100) {
        return (CardCalendarDialogFactory$CardCalendarType) a.a(CardCalendarDialogFactory$CardCalendarType.class, r100);
    }

    public CardCalendarDialogFactory$CardCalendarType(String r100, int r101) {
        super(r100, r101);
    }
}
