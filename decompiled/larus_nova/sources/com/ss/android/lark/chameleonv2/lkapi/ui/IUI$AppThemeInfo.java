package com.ss.android.lark.chameleonv2.lkapi.ui;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$AppThemeInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "style", "Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$ThemeStyle;", "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$ThemeStyle;)V", "getStyle", "()Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$ThemeStyle;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IUI$AppThemeInfo implements NonProguard {
    private final IUI$ThemeStyle style;

    public static /* synthetic */ IUI$AppThemeInfo copy$default(IUI$AppThemeInfo r100, IUI$ThemeStyle r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.style;
    L6:
        return r100.copy(r101);
    }

    public final IUI$ThemeStyle component1() {
        return this.style;
    }

    public final IUI$AppThemeInfo copy(IUI$ThemeStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        return new IUI$AppThemeInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IUI$AppThemeInfo) == true) goto L9;
        return false;
    L9:
        if (this.style == ((IUI$AppThemeInfo) r100).style) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.style.hashCode();
    }

    public String toString() {
        return "AppThemeInfo(style=" + this.style + ')';
    }

    public final IUI$ThemeStyle getStyle() {
        return this.style;
    }

    public IUI$AppThemeInfo(IUI$ThemeStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        this.style = r100;
    }
}
