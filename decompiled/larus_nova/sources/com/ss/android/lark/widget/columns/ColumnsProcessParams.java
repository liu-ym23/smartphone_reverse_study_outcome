package com.ss.android.lark.widget.columns;

import android.text.Layout;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012f\u0010\u0002\u001ab\u0012\u0004\u0012\u00020\u0004\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007\u0018\u00010\u0003j0\u0012\u0004\u0012\u00020\u0004\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007\u0018\u0001`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016Ji\u0010\u0019\u001ab\u0012\u0004\u0012\u00020\u0004\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007\u0018\u00010\u0003j0\u0012\u0004\u0012\u00020\u0004\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007\u0018\u0001`\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J\u0091\u0001\u0010\u001d\u001a\u00020\u00002h\b\u0002\u0010\u0002\u001ab\u0012\u0004\u0012\u00020\u0004\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007\u0018\u00010\u0003j0\u0012\u0004\u0012\u00020\u0004\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007\u0018\u0001`\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001Rq\u0010\u0002\u001ab\u0012\u0004\u0012\u00020\u0004\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007\u0018\u00010\u0003j0\u0012\u0004\u0012\u00020\u0004\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/widget/columns/ColumnsProcessParams;", "Ljava/io/Serializable;", "columnsLayoutMap", "Ljava/util/HashMap;", "", "", "Landroid/text/Layout;", "Lkotlin/collections/HashMap;", "maxWidth", "contextType", "isShowColumnsDetail", "", "<init>", "(Ljava/util/HashMap;IIZ)V", "getColumnsLayoutMap", "()Ljava/util/HashMap;", "getMaxWidth", "()I", "getContextType", "()Z", "equals", "other", "", "hashCode", "toString", "component1", "component2", "component3", "component4", "copy", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColumnsProcessParams implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient HashMap<String, HashMap<Integer, Layout>> f445729a;
    private final int contextType;
    private final boolean isShowColumnsDetail;
    private final int maxWidth;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ColumnsProcessParams copy$default(ColumnsProcessParams r100, HashMap r101, int r102, int r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f445729a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.maxWidth;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.contextType;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.isShowColumnsDetail;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final HashMap<String, HashMap<Integer, Layout>> component1() {
        return this.f445729a;
    }

    public final int component2() {
        return this.maxWidth;
    }

    public final int component3() {
        return this.contextType;
    }

    public final boolean component4() {
        return this.isShowColumnsDetail;
    }

    public final ColumnsProcessParams copy(HashMap<String, HashMap<Integer, Layout>> r100, int r101, int r102, boolean r103) {
        return new ColumnsProcessParams(r100, r101, r102, r103);
    }

    public int hashCode() {
        HashMap<String, HashMap<Integer, Layout>> r100 = this.f445729a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((((r101 * 31) + this.maxWidth) * 31) + this.contextType) * 31;
        if (this.isShowColumnsDetail == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "ColumnsProcessParams(columnsLayoutMap=" + this.f445729a + ", maxWidth=" + this.maxWidth + ", contextType=" + this.contextType + ", isShowColumnsDetail=" + this.isShowColumnsDetail + ')';
    }

    public final HashMap<String, HashMap<Integer, Layout>> getColumnsLayoutMap() {
        return this.f445729a;
    }

    public final int getContextType() {
        return this.contextType;
    }

    public final int getMaxWidth() {
        return this.maxWidth;
    }

    public final boolean isShowColumnsDetail() {
        return this.isShowColumnsDetail;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ColumnsProcessParams.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.columns.ColumnsProcessParams");
        ColumnsProcessParams r102 = (ColumnsProcessParams) r100;
        if (Intrinsics.areEqual(this.f445729a, r102.f445729a) == true) goto L16;
        return false;
    L16:
        if (this.maxWidth == r102.maxWidth) goto L19;
        return false;
    L19:
        if (this.contextType == r102.contextType) goto L22;
        return false;
    L22:
        if (this.isShowColumnsDetail == r102.isShowColumnsDetail) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public ColumnsProcessParams(HashMap<String, HashMap<Integer, Layout>> r100, int r101, int r102, boolean r103) {
        this.f445729a = r100;
        this.maxWidth = r101;
        this.contextType = r102;
        this.isShowColumnsDetail = r103;
    }
}
