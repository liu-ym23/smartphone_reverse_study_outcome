package com.ss.android.lark.widget.codeblock.theme;

import android.text.style.StrikethroughSpan;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0007\"\u0004\b\b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/widget/codeblock/theme/CustomStrikethroughSpan;", "Lcom/ss/android/lark/widget/codeblock/theme/ICustomStyle;", "Landroid/text/style/StrikethroughSpan;", "isUserCustom", "", "<init>", "(Z)V", "()Z", "setUserCustom", "equals", "other", "", "hashCode", "", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomStrikethroughSpan extends StrikethroughSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f445719a;

    public final int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.f445719a)});
    }

    public CustomStrikethroughSpan(boolean r100) {
        this.f445719a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CustomStrikethroughSpan) == true) goto L9;
        return false;
    L9:
        if (this.f445719a == ((CustomStrikethroughSpan) r100).f445719a) goto L13;
        return false;
    L13:
        return true;
    }
}
