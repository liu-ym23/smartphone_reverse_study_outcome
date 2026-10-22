package com.obric.oui.calendar;

import android.content.Context;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatTextView;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes33.dex */
public final class a0 extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mla.h f399294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DayOfWeek f399295b;

    public a0(Context r100, DayOfWeek r101) {
        super(r100);
        this.f399294a = mla.h.f514384a;
        setGravity(17);
        setTextAlignment(4);
        setTextSize(12.0f);
        setTypeface(Typeface.create(Typeface.DEFAULT, 400, false));
        this.f399295b = r101;
        setText(this.f399294a.a(r101));
    }
}
