package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b&\u0010'J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003JN\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\tR\u001a\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantNative;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/m;", "component1", "", "component2", "", "component3", "()Ljava/lang/Integer;", "component4", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantStyleConfigModel;", "component5", "headerTabs", "expand", "maxTabNum", "newStyle", "styleConfig", "copy", "(Ljava/util/List;ZLjava/lang/Integer;ZLcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantStyleConfigModel;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantNative;", "", "toString", "hashCode", "", "other", "equals", "Ljava/util/List;", "getHeaderTabs", "()Ljava/util/List;", "Z", "getExpand", "()Z", "Ljava/lang/Integer;", "getMaxTabNum", "getNewStyle", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantStyleConfigModel;", "getStyleConfig", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantStyleConfigModel;", "<init>", "(Ljava/util/List;ZLjava/lang/Integer;ZLcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantStyleConfigModel;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderPendantNative implements Serializable {

    @SerializedName("expand")
    private final boolean expand;

    @SerializedName("tabs")
    private final List<m> headerTabs;

    @SerializedName("max_tab_num")
    private final Integer maxTabNum;

    @SerializedName("new_style")
    private final boolean newStyle;

    @SerializedName("style_config")
    private final HeaderNAPendantStyleConfigModel styleConfig;

    public HeaderPendantNative() {
        this(null, false, null, false, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeaderPendantNative copy$default(HeaderPendantNative r3, List r4, boolean r5, Integer r6, boolean r7, HeaderNAPendantStyleConfigModel r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.headerTabs;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.expand;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.maxTabNum;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.newStyle;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.styleConfig;
    L17:
        List r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final List<m> component1() {
        return this.headerTabs;
    }

    public final boolean component2() {
        return this.expand;
    }

    public final Integer component3() {
        return this.maxTabNum;
    }

    public final boolean component4() {
        return this.newStyle;
    }

    public final HeaderNAPendantStyleConfigModel component5() {
        return this.styleConfig;
    }

    public final HeaderPendantNative copy(List<m> r8, boolean r9, Integer r10, boolean r11, HeaderNAPendantStyleConfigModel r12) {
        return new HeaderPendantNative(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HeaderPendantNative) == false) goto L16;
        HeaderPendantNative r4 = (HeaderPendantNative) r3;
        if (Intrinsics.areEqual(this.headerTabs, r4.headerTabs) == true) goto L8;
        return false;
    L8:
        if (this.expand == r4.expand) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.maxTabNum, r4.maxTabNum) == true) goto L12;
        return false;
    L12:
        if (this.newStyle == r4.newStyle) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.styleConfig, r4.styleConfig) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        List<m> r0 = this.headerTabs;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.expand;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        Integer r8 = this.maxTabNum;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        boolean r11 = this.newStyle;
        if (r11 == true) goto L17;
        r5 = r11;
    L17:
        int r12 = (r10 + r5) * 31;
        HeaderNAPendantStyleConfigModel r13 = this.styleConfig;
        if (r13 == null) goto L21;
        r1 = r13.hashCode();
    L21:
        return r12 + r1;
    L12:
        r9 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HeaderPendantNative(headerTabs=" + this.headerTabs + ", expand=" + this.expand + ", maxTabNum=" + this.maxTabNum + ", newStyle=" + this.newStyle + ", styleConfig=" + this.styleConfig + ")";
    }

    public final boolean getExpand() {
        return this.expand;
    }

    public final List<m> getHeaderTabs() {
        return this.headerTabs;
    }

    public final Integer getMaxTabNum() {
        return this.maxTabNum;
    }

    public final boolean getNewStyle() {
        return this.newStyle;
    }

    public final HeaderNAPendantStyleConfigModel getStyleConfig() {
        return this.styleConfig;
    }

    public HeaderPendantNative(List<m> r1, boolean r2, Integer r3, boolean r4, HeaderNAPendantStyleConfigModel r5) {
        this.headerTabs = r1;
        this.expand = r2;
        this.maxTabNum = r3;
        this.newStyle = r4;
        this.styleConfig = r5;
    }

    public /* synthetic */ HeaderPendantNative(List r5, boolean r6, Integer r7, boolean r8, HeaderNAPendantStyleConfigModel r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        List r12 = null;
    L6:
        boolean r1 = false;
        if ((r10 & 2) == 0) goto L9;
        boolean r2 = false;
    L11:
        if ((r10 & 4) == 0) goto L13;
        Integer r3 = null;
    L15:
        if ((r10 & 8) != 0) goto L19;
        r1 = r8;
    L19:
        if ((r10 & 16) == 0) goto L21;
        HeaderNAPendantStyleConfigModel r13 = null;
    L22:
        this(r12, r2, r3, r1, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L13:
        r3 = r7;
        goto L15
    L9:
        r2 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L6
    }
}
