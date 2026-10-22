package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ThemeColors;", "Ljava/io/Serializable;", "themecolors", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getThemecolors", "()Ljava/util/ArrayList;", "equals", "", "other", "", "hashCode", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThemeColors implements Serializable {
    private final ArrayList<ThemeColor> themecolors;

    public int hashCode() {
        ArrayList<ThemeColor> r100 = this.themecolors;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final ArrayList<ThemeColor> getThemecolors() {
        return this.themecolors;
    }

    public ThemeColors(ArrayList<ThemeColor> r100) {
        this.themecolors = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ThemeColors) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.themecolors, ((ThemeColors) r100).themecolors) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
