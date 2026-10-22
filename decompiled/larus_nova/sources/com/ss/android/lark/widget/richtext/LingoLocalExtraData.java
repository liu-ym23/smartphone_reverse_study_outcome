package com.ss.android.lark.widget.richtext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J)\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\bHÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\bHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR1\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/widget/richtext/LingoLocalExtraData;", "Ljava/io/Serializable;", "highlightIgnoreWords", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "pinInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/ArrayList;Ljava/util/HashMap;)V", "getHighlightIgnoreWords", "()Ljava/util/ArrayList;", "getPinInfo", "()Ljava/util/HashMap;", "equals", "", "other", "", "hashCode", "", "component1", "component2", "copy", "toString", "richtext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LingoLocalExtraData implements Serializable {
    private final ArrayList<String> highlightIgnoreWords;
    private final HashMap<String, String> pinInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LingoLocalExtraData copy$default(LingoLocalExtraData r100, ArrayList r101, HashMap r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.highlightIgnoreWords;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.pinInfo;
    L9:
        return r100.copy(r101, r102);
    }

    public final ArrayList<String> component1() {
        return this.highlightIgnoreWords;
    }

    public final HashMap<String, String> component2() {
        return this.pinInfo;
    }

    public final LingoLocalExtraData copy(ArrayList<String> r100, HashMap<String, String> r101) {
        return new LingoLocalExtraData(r100, r101);
    }

    public String toString() {
        return "LingoLocalExtraData(highlightIgnoreWords=" + this.highlightIgnoreWords + ", pinInfo=" + this.pinInfo + ')';
    }

    public int hashCode() {
        ArrayList<String> r100 = this.highlightIgnoreWords;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HashMap<String, String> r104 = this.pinInfo;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final ArrayList<String> getHighlightIgnoreWords() {
        return this.highlightIgnoreWords;
    }

    public final HashMap<String, String> getPinInfo() {
        return this.pinInfo;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(LingoLocalExtraData.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.richtext.LingoLocalExtraData");
        LingoLocalExtraData r102 = (LingoLocalExtraData) r100;
        if (Intrinsics.areEqual(this.highlightIgnoreWords, r102.highlightIgnoreWords) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.pinInfo, r102.pinInfo) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public LingoLocalExtraData(ArrayList<String> r100, HashMap<String, String> r101) {
        this.highlightIgnoreWords = r100;
        this.pinInfo = r101;
    }
}
