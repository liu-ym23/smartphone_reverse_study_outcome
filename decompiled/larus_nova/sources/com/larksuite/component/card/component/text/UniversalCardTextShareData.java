package com.larksuite.component.card.component.text;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.component.card.protocol.component.BaseComponentShareData;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larksuite/component/card/component/text/UniversalCardTextShareData;", "Lcom/larksuite/component/card/protocol/component/BaseComponentShareData;", "id", "", "<init>", "(Ljava/lang/String;)V", "totalTextLines", "", "getTotalTextLines", "()I", "setTotalTextLines", "(I)V", "textInfoList", "", "Lcom/larksuite/component/card/component/text/UniversalCardTextShareData$TextLineInfo;", "getAvailableLines", "textId", "calcAvailableLines", "tryOccupyLines", GXTemplateKey.STYLE_FONT_LINES, "TextLineInfo", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UniversalCardTextShareData extends BaseComponentShareData {
    public static final a Companion = null;
    private static final String TAG = "UniversalCardTextShareData";
    private final List<b> textInfoList;
    private int totalTextLines;

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f283594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f283595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f283596c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f283594a, r101.f283594a) == true) goto L12;
            return false;
        L12:
            if (this.f283595b == r101.f283595b) goto L15;
            return false;
        L15:
            if (this.f283596c == r101.f283596c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f283594a.hashCode() * 31) + this.f283595b) * 31) + this.f283596c;
        }

        public final String toString() {
            return "TextLineInfo(textId=" + this.f283594a + ", availableLines=" + this.f283595b + ", occupiedLines=" + this.f283596c + ')';
        }

        public b(String r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "textId");
            this.f283594a = r100;
            this.f283595b = r101;
            this.f283596c = r102;
        }
    }

    static {
        Companion = new a();
    }

    public final int getTotalTextLines() {
        return this.totalTextLines;
    }

    public UniversalCardTextShareData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        super(r100);
        this.totalTextLines = Integer.MAX_VALUE;
        this.textInfoList = new ArrayList();
    }

    private final int calcAvailableLines(String r100) {
        int r101 = this.totalTextLines;
        Iterator<b> r102 = this.textInfoList.iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        b r103 = r102.next();
        if (Intrinsics.areEqual(r103.f283594a, r100) == true) goto L8;
        r101 = r101 - r103.f283596c;
        if (r101 >= 0) goto L4;
        r101 = 0;
        goto L13
    L8:
        return RangesKt.coerceAtLeast(r101, 0);
    L13:
        return RangesKt.coerceAtLeast(r101, 0);
    }

    public final int getAvailableLines(String r100) {
        Intrinsics.checkNotNullParameter(r100, "textId");
        return calcAvailableLines(r100);
    }

    public final void setTotalTextLines(int r100) {
        this.totalTextLines = r100;
    }

    public final b tryOccupyLines(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "textId");
        int r102 = calcAvailableLines(r100);
        if (r102 >= r101) goto L6;
        r101 = r102;
    L6:
        Log.d(TAG, "tryOccupyLines, id: " + r100 + ", avail: " + r102 + ", occ: " + r101);
        Iterator<T> r103 = this.textInfoList.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((b) r104).f283594a, r100) == false) goto L8;
    L13:
        b r105 = (b) r104;
        if (r105 == null) goto L17;
        Log.d(TAG, "tryOccupyLines, find and update");
        r105.f283595b = r102;
        r105.f283596c = r101;
        return r105;
    L17:
        Log.d(TAG, "tryOccupyLines, create new");
        b r106 = new b(r100, r102, r101);
        this.textInfoList.add(r106);
        return r106;
    L12:
        r104 = null;
        goto L13
    }
}
