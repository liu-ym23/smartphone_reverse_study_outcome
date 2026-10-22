package com.ss.android.lark.widget.columns.entity;

import android.text.Layout;
import com.ss.android.lark.widget.span.SpanInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#BM\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012*\u0010\u0005\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\t\b\u0016¢\u0006\u0004\b\u000b\u0010\rJ\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0013\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\nH\u0016R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R>\u0010\u0005\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/ss/android/lark/widget/columns/entity/ColumnsInfo;", "Lcom/ss/android/lark/widget/span/SpanInfo;", "columnsWidthRatio", "Ljava/util/LinkedList;", "", "columnsContentLayout", "Ljava/util/HashMap;", "Landroid/text/Layout;", "Lkotlin/collections/HashMap;", "columnsRootId", "", "<init>", "(Ljava/util/LinkedList;Ljava/util/HashMap;Ljava/lang/String;)V", "()V", "getColumnsWidthRatio", "()Ljava/util/LinkedList;", "setColumnsWidthRatio", "(Ljava/util/LinkedList;)V", "getColumnsContentLayout", "()Ljava/util/HashMap;", "setColumnsContentLayout", "(Ljava/util/HashMap;)V", "getColumnsRootId", "()Ljava/lang/String;", "setColumnsRootId", "(Ljava/lang/String;)V", "getColumnsSize", "isValid", "", "setDownGradeColumnsWidthRatioIfNeed", "equals", "other", "", "hashCode", "toString", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColumnsInfo extends SpanInfo {
    public static final a Companion = null;
    public static final int DEFAULT_WIDTH_RATIO = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient HashMap<Integer, Layout> f445731a;
    private String columnsRootId;
    private LinkedList<Integer> columnsWidthRatio;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ColumnsInfo() {
        this(null, null, "");
    }

    public final int getColumnsSize() {
        LinkedList<Integer> r100 = this.columnsWidthRatio;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public final boolean isValid() {
        LinkedList<Integer> r100 = this.columnsWidthRatio;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L10
    }

    public final boolean setDownGradeColumnsWidthRatioIfNeed() {
        LinkedList<Integer> r100 = this.columnsWidthRatio;
        if (r100 != null) goto L5;
    L18:
        boolean r101 = false;
    L19:
        if (r101 == false) goto L24;
        LinkedList<Integer> r102 = this.columnsWidthRatio;
        if (r102 == null) goto L23;
        Collections.fill(r102, 100);
    L23:
        return true;
    L24:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
    L6:
        boolean r103 = false;
    L16:
        if (r103 != true) goto L18;
        r101 = true;
        goto L19
    L7:
        Iterator<T> r104 = r100.iterator();
    L9:
        if (r104.hasNext() == false) goto L6;
        if (((Number) r104.next()).intValue() > 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L9;
        r103 = true;
        goto L16
    L13:
        r105 = false;
        goto L14
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public String toString() {
        return "ColumnsInfo(columnsWidthRatio=" + this.columnsWidthRatio + ", columnsContentLayout=" + this.f445731a + ", columnsRootId='" + this.columnsRootId + "')";
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        LinkedList<Integer> r101 = this.columnsWidthRatio;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        HashMap<Integer, Layout> r105 = this.f445731a;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return ((r104 + r102) * 31) + this.columnsRootId.hashCode();
    L5:
        r103 = 0;
        goto L6
    }

    public final HashMap<Integer, Layout> getColumnsContentLayout() {
        return this.f445731a;
    }

    public final String getColumnsRootId() {
        return this.columnsRootId;
    }

    public final LinkedList<Integer> getColumnsWidthRatio() {
        return this.columnsWidthRatio;
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ColumnsInfo.class, r101) == true) goto L13;
        return false;
    L13:
        if (super.equals(r100) == true) goto L15;
        return false;
    L15:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.columns.entity.ColumnsInfo");
        ColumnsInfo r102 = (ColumnsInfo) r100;
        if (Intrinsics.areEqual(this.columnsWidthRatio, r102.columnsWidthRatio) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f445731a, r102.f445731a) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.columnsRootId, r102.columnsRootId) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setColumnsContentLayout(HashMap<Integer, Layout> r100) {
        this.f445731a = r100;
    }

    public final void setColumnsRootId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.columnsRootId = r100;
    }

    public final void setColumnsWidthRatio(LinkedList<Integer> r100) {
        this.columnsWidthRatio = r100;
    }

    public ColumnsInfo(LinkedList<Integer> r100, HashMap<Integer, Layout> r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "columnsRootId");
        this.columnsWidthRatio = r100;
        this.f445731a = r101;
        this.columnsRootId = r102;
    }

    public /* synthetic */ ColumnsInfo(LinkedList r100, HashMap r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = "";
    L5:
        this(r100, r101, r102);
    }
}
