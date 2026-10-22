package gpa;

import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence[] f482134b;

    public a(CharSequence[] r100) {
        if (r100 == null) goto L11;
        if (r100.length != 7) goto L9;
        this.f482134b = r100;
        return;
    L9:
        throw new IllegalArgumentException("Array must contain exactly 7 elements");
    L11:
        throw new IllegalArgumentException("Cannot be null");
    }

    @Override // gpa.h
    public final CharSequence a(DayOfWeek r100) {
        return this.f482134b[r100.getValue() - 1];
    }
}
