package com.ss.android.lark.widget.codeblock.theme;

import android.text.style.StyleSpan;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\f\u001a\u00020\u0006H\u0016J\u0013\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/widget/codeblock/theme/CustomStyleSpan;", "Lcom/ss/android/lark/widget/codeblock/theme/ICustomStyle;", "Landroid/text/style/StyleSpan;", "isUserCustom", "", "style", "", "<init>", "(ZI)V", "()Z", "setUserCustom", "(Z)V", "hashCode", "equals", "other", "", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomStyleSpan extends StyleSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f445720a;

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(getStyle()), Boolean.valueOf(this.f445720a)});
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CustomStyleSpan) == true) goto L8;
        return false;
    L8:
        CustomStyleSpan r101 = (CustomStyleSpan) r100;
        if (getStyle() == r101.getStyle()) goto L11;
    L13:
        return false;
    L11:
        if (this.f445720a != r101.f445720a) goto L13;
        return true;
    }

    public CustomStyleSpan(boolean r100, int r101) {
        super(r101);
        this.f445720a = r100;
    }
}
