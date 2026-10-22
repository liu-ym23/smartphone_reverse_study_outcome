package com.ss.android.lark.myai.chat.quickactions;

import android.text.Editable;
import android.text.Spannable;
import android.text.style.StyleSpan;
import com.ss.android.lark.keyboard.edittext2.span.f;
import com.ss.android.lark.keyboard.edittext2.span.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/ss/android/lark/myai/chat/quickactions/QuickActionParamSpan;", "Landroid/text/style/StyleSpan;", "Lcom/ss/android/lark/myai/chat/quickactions/QuickActionInlineBlockSpan;", "paramId", "", "paramName", "paramDescription", "paramPlaceHolder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getParamId", "()Ljava/lang/String;", "getParamName", "getParamDescription", "getParamPlaceHolder", "isRemoving", "", "isRemoving$myai_export_release", "()Z", "setRemoving$myai_export_release", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "myai-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickActionParamSpan extends StyleSpan implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f432850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f432851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f432852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f432853d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QuickActionParamSpan) == true) goto L8;
        return false;
    L8:
        QuickActionParamSpan r101 = (QuickActionParamSpan) r100;
        if (Intrinsics.areEqual(this.f432850a, r101.f432850a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f432851b, r101.f432851b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f432852c, r101.f432852c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f432853d, r101.f432853d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f432850a.hashCode() * 31) + this.f432851b.hashCode()) * 31) + this.f432852c.hashCode()) * 31) + this.f432853d.hashCode();
    }

    @Override // android.text.style.StyleSpan
    public final String toString() {
        return "QuickActionParamSpan(paramId=" + this.f432850a + ", paramName=" + this.f432851b + ", paramDescription=" + this.f432852c + ", paramPlaceHolder=" + this.f432853d + ')';
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.f
    public final k.a a(int r100, int r101, Spannable r102) {
        Intrinsics.checkNotNullParameter(r102, "text");
        return f.a.b(r100, r101, r102);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.k
    public final k.a e(int r100, int r101, Editable r102) {
        return a.C5145a.a(this, r100, r101, r102);
    }

    public QuickActionParamSpan(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "paramId");
        Intrinsics.checkNotNullParameter(r101, "paramName");
        Intrinsics.checkNotNullParameter(r102, "paramDescription");
        Intrinsics.checkNotNullParameter(r103, "paramPlaceHolder");
        super(1);
        this.f432850a = r100;
        this.f432851b = r101;
        this.f432852c = r102;
        this.f432853d = r103;
    }
}
