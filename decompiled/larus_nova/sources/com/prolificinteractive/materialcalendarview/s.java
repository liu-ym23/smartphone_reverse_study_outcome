package com.prolificinteractive.materialcalendarview;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes34.dex */
public final class s extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gpa.h f404532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DayOfWeek f404533b;

    public s(Context r100, DayOfWeek r101) {
        super(r100);
        this.f404532a = gpa.h.f482140a;
        setGravity(17);
        setTextAlignment(4);
        this.f404533b = r101;
        setText(this.f404532a.a(r101));
    }
}
