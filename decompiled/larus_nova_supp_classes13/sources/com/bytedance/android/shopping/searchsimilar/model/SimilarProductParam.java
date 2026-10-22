package com.bytedance.android.shopping.searchsimilar.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001$BA\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\t\u001a\u00020\u0002HÆ\u0003JJ\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/model/SimilarProductParam;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "()Ljava/lang/Integer;", "component5", "awemeId", "enterFrom", "authorId", "totalPanelHeight", "monitorName", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/searchsimilar/model/SimilarProductParam;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getAwemeId", "()Ljava/lang/String;", "getEnterFrom", "getAuthorId", "Ljava/lang/Integer;", "getTotalPanelHeight", "getMonitorName", "setMonitorName", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductParam implements Serializable {
    public static final String AUTHOR_id = "author_id";
    public static final String AWEME_ID = "aweme_id";
    public static final a Companion = null;
    public static final String ENTER_FROM = "enter_from";
    public static final String TOTAL_PANEL_HEIGHT = "total_panel_height";
    private final String authorId;
    private final String awemeId;
    private final String enterFrom;
    private String monitorName;
    private final Integer totalPanelHeight;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SimilarProductParam() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SimilarProductParam copy$default(SimilarProductParam r3, String r4, String r5, String r6, Integer r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.awemeId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.enterFrom;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.authorId;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.totalPanelHeight;
    L14:
        Integer r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.monitorName;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.awemeId;
    }

    public final String component2() {
        return this.enterFrom;
    }

    public final String component3() {
        return this.authorId;
    }

    public final Integer component4() {
        return this.totalPanelHeight;
    }

    public final String component5() {
        return this.monitorName;
    }

    public final SimilarProductParam copy(String r8, String r9, String r10, Integer r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "monitorName");
        return new SimilarProductParam(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SimilarProductParam) == false) goto L16;
        SimilarProductParam r4 = (SimilarProductParam) r3;
        if (Intrinsics.areEqual(this.awemeId, r4.awemeId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterFrom, r4.enterFrom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.authorId, r4.authorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.totalPanelHeight, r4.totalPanelHeight) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.monitorName, r4.monitorName) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.awemeId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.enterFrom;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.authorId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.totalPanelHeight;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.monitorName;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SimilarProductParam(awemeId=" + this.awemeId + ", enterFrom=" + this.enterFrom + ", authorId=" + this.authorId + ", totalPanelHeight=" + this.totalPanelHeight + ", monitorName=" + this.monitorName + ")";
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAwemeId() {
        return this.awemeId;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getMonitorName() {
        return this.monitorName;
    }

    public final Integer getTotalPanelHeight() {
        return this.totalPanelHeight;
    }

    public final void setMonitorName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.monitorName = r2;
    }

    public SimilarProductParam(String r2, String r3, String r4, Integer r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "monitorName");
        this.awemeId = r2;
        this.enterFrom = r3;
        this.authorId = r4;
        this.totalPanelHeight = r5;
        this.monitorName = r6;
    }

    public /* synthetic */ SimilarProductParam(String r4, String r5, String r6, Integer r7, String r8, int r9, DefaultConstructorMarker r10) {
        Integer r0 = null;
        if ((r9 & 1) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r9 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r9 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r9 & 8) != 0) goto L19;
        r0 = r7;
    L19:
        if ((r9 & 16) == 0) goto L21;
        r8 = "";
    L21:
        this(r11, r1, r2, r0, r8);
        return;
    L13:
        r2 = r6;
        goto L15
    L9:
        r1 = r5;
        goto L11
    L5:
        r11 = r4;
        goto L7
    }
}
