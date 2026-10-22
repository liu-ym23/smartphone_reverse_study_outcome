package com.ss.android.lark.widget.light.span;

import android.text.style.ForegroundColorSpan;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/widget/light/span/CustomForegroundColorSpan;", "Landroid/text/style/ForegroundColorSpan;", "color", "", "<init>", "(I)V", "getColor", "()I", "setColor", "equals", "", "other", "", "hashCode", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomForegroundColorSpan extends ForegroundColorSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f446196a;

    public final int hashCode() {
        return this.f446196a;
    }

    public CustomForegroundColorSpan(int r100) {
        super(r100);
        this.f446196a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CustomForegroundColorSpan) == true) goto L9;
        return false;
    L9:
        if (this.f446196a == ((CustomForegroundColorSpan) r100).f446196a) goto L11;
        return false;
    L11:
        return true;
    }
}
