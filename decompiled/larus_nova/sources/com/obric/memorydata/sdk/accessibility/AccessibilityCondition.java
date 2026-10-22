package com.obric.memorydata.sdk.accessibility;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.sdk.screencapture.rule.KeywordsMatchRuleEnum;
import com.obric.memorydata.sdk.screencapture.rule.RectMatchRuleEnum;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B«\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u000bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0012HÆ\u0003J\t\u0010?\u001a\u00020\u0014HÆ\u0003J\t\u0010@\u001a\u00020\u0016HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0016HÆ\u0003J±\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0016HÆ\u0001J\u0006\u0010E\u001a\u00020\u0003J\u0013\u0010F\u001a\u00020\u00162\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020\u0003HÖ\u0001J\t\u0010J\u001a\u00020\u0005HÖ\u0001J\u0016\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u001a\u0010\u001a\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00105¨\u0006P"}, d2 = {"Lcom/obric/memorydata/sdk/accessibility/AccessibilityCondition;", "Landroid/os/Parcelable;", "eventType", "", "activityName", "", "activityList", "", "keywordMatchRules", "Lcom/obric/memorydata/sdk/accessibility/KeywordMatchRule;", "keywordsMatchRule", "Lcom/obric/memorydata/sdk/screencapture/rule/KeywordsMatchRuleEnum;", "keywordMatchExpression", "visibleNodeCountCondition", "Lcom/obric/memorydata/sdk/accessibility/VisibleNodeCountCondition;", "touchRects", "Landroid/graphics/Rect;", "touchRectMatchRule", "Lcom/obric/memorydata/sdk/screencapture/rule/RectMatchRuleEnum;", "timeThreshold", "", "optional", "", "screenshotOpt", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "resetToStep", "matched", "<init>", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/obric/memorydata/sdk/screencapture/rule/KeywordsMatchRuleEnum;Ljava/lang/String;Lcom/obric/memorydata/sdk/accessibility/VisibleNodeCountCondition;Ljava/util/List;Lcom/obric/memorydata/sdk/screencapture/rule/RectMatchRuleEnum;JZLcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;IZ)V", "getEventType", "()I", "getActivityName", "()Ljava/lang/String;", "getActivityList", "()Ljava/util/List;", "getKeywordMatchRules", "getKeywordsMatchRule", "()Lcom/obric/memorydata/sdk/screencapture/rule/KeywordsMatchRuleEnum;", "getKeywordMatchExpression", "getVisibleNodeCountCondition", "()Lcom/obric/memorydata/sdk/accessibility/VisibleNodeCountCondition;", "getTouchRects", "getTouchRectMatchRule", "()Lcom/obric/memorydata/sdk/screencapture/rule/RectMatchRuleEnum;", "getTimeThreshold", "()J", "getOptional", "()Z", "getScreenshotOpt", "()Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "getResetToStep", "getMatched", "setMatched", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AccessibilityCondition implements Parcelable {
    public static final Parcelable.Creator<AccessibilityCondition> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f397054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f397056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<KeywordMatchRule> f397057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final KeywordsMatchRuleEnum f397058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f397059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final VisibleNodeCountCondition f397060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Rect> f397061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectMatchRuleEnum f397062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f397063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f397064k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ScreenshotOption f397065l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f397066m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f397067n;

    public static final class a implements Parcelable.Creator<AccessibilityCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AccessibilityCondition createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            int r100 = r210.readInt();
            String r101 = r210.readString();
            ArrayList<String> r102 = r210.createStringArrayList();
            int r103 = r210.readInt();
            ArrayList r104 = new ArrayList(r103);
            int r105 = 0;
        L3:
            if (r105 == r103) goto L5;
            r104.add(KeywordMatchRule.CREATOR.createFromParcel(r210));
            r105 = r105 + 1;
            goto L3
        L5:
            KeywordsMatchRuleEnum r106 = KeywordsMatchRuleEnum.valueOf(r210.readString());
            String r107 = r210.readString();
            ScreenshotOption r108 = null;
            if (r210.readInt() != 0) goto L8;
            VisibleNodeCountCondition r109 = null;
        L9:
            VisibleNodeCountCondition r110 = r109;
            if (r210.readInt() != 0) goto L12;
            ArrayList r111 = null;
        L16:
            RectMatchRuleEnum r112 = RectMatchRuleEnum.valueOf(r210.readString());
            long r113 = r210.readLong();
            if (r210.readInt() == 0) goto L19;
            boolean r114 = true;
        L21:
            if (r210.readInt() == 0) goto L24;
            r108 = ScreenshotOption.CREATOR.createFromParcel(r210);
        L24:
            ScreenshotOption r115 = r108;
            int r116 = r210.readInt();
            if (r210.readInt() == 0) goto L27;
            boolean r117 = true;
        L29:
            return new AccessibilityCondition(r100, r101, r102, r104, r106, r107, r110, r111, r112, r113, r114, r115, r116, r117);
        L27:
            r117 = false;
            goto L29
        L19:
            r114 = false;
            goto L21
        L12:
            int r118 = r210.readInt();
            ArrayList r119 = new ArrayList(r118);
            int r120 = 0;
        L13:
            if (r120 == r118) goto L15;
            r119.add(r210.readParcelable(AccessibilityCondition.class.getClassLoader()));
            r120 = r120 + 1;
            goto L13
        L15:
            r111 = r119;
            goto L16
        L8:
            r109 = VisibleNodeCountCondition.CREATOR.createFromParcel(r210);
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final AccessibilityCondition[] newArray(int r100) {
            return new AccessibilityCondition[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AccessibilityCondition) == true) goto L8;
        return false;
    L8:
        AccessibilityCondition r101 = (AccessibilityCondition) r100;
        if (this.f397054a == r101.f397054a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397055b, r101.f397055b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397056c, r101.f397056c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397057d, r101.f397057d) == true) goto L21;
        return false;
    L21:
        if (this.f397058e == r101.f397058e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f397059f, r101.f397059f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f397060g, r101.f397060g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f397061h, r101.f397061h) == true) goto L33;
        return false;
    L33:
        if (this.f397062i == r101.f397062i) goto L36;
        return false;
    L36:
        if (this.f397063j == r101.f397063j) goto L39;
        return false;
    L39:
        if (this.f397064k == r101.f397064k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f397065l, r101.f397065l) == true) goto L45;
        return false;
    L45:
        if (this.f397066m == r101.f397066m) goto L48;
        return false;
    L48:
        if (this.f397067n == r101.f397067n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f397054a * 31) + this.f397055b.hashCode()) * 31;
        List<String> r101 = this.f397056c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f397057d.hashCode()) * 31) + this.f397058e.hashCode()) * 31;
        String r105 = this.f397059f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        VisibleNodeCountCondition r108 = this.f397060g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        List<Rect> r111 = this.f397061h;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((r110 + r112) * 31) + this.f397062i.hashCode()) * 31;
        long r114 = this.f397063j;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        int r116 = 1231;
        if (this.f397064k == false) goto L21;
        int r117 = 1231;
    L22:
        int r118 = (r115 + r117) * 31;
        ScreenshotOption r119 = this.f397065l;
        if (r119 == null) goto L26;
        r102 = r119.hashCode();
    L26:
        int r120 = (((r118 + r102) * 31) + this.f397066m) * 31;
        if (this.f397067n == true) goto L31;
        r116 = 1237;
    L31:
        return r120 + r116;
    L21:
        r117 = 1237;
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AccessibilityCondition(eventType=" + this.f397054a + ", activityName=" + this.f397055b + ", activityList=" + this.f397056c + ", keywordMatchRules=" + this.f397057d + ", keywordsMatchRule=" + this.f397058e + ", keywordMatchExpression=" + this.f397059f + ", visibleNodeCountCondition=" + this.f397060g + ", touchRects=" + this.f397061h + ", touchRectMatchRule=" + this.f397062i + ", timeThreshold=" + this.f397063j + ", optional=" + this.f397064k + ", screenshotOpt=" + this.f397065l + ", resetToStep=" + this.f397066m + ", matched=" + this.f397067n + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f397054a);
        r100.writeString(this.f397055b);
        r100.writeStringList(this.f397056c);
        List<KeywordMatchRule> r102 = this.f397057d;
        r100.writeInt(r102.size());
        Iterator<KeywordMatchRule> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().writeToParcel(r100, r101);
        goto L4
    L6:
        r100.writeString(this.f397058e.name());
        r100.writeString(this.f397059f);
        VisibleNodeCountCondition r104 = this.f397060g;
        if (r104 != null) goto L9;
        r100.writeInt(0);
    L10:
        List<Rect> r105 = this.f397061h;
        if (r105 != null) goto L13;
        r100.writeInt(0);
    L17:
        r100.writeString(this.f397062i.name());
        r100.writeLong(this.f397063j);
        r100.writeInt(this.f397064k ? 1 : 0);
        ScreenshotOption r106 = this.f397065l;
        if (r106 != null) goto L20;
        r100.writeInt(0);
    L21:
        r100.writeInt(this.f397066m);
        r100.writeInt(this.f397067n ? 1 : 0);
        return;
    L20:
        r100.writeInt(1);
        r106.writeToParcel(r100, r101);
        goto L21
    L13:
        r100.writeInt(1);
        r100.writeInt(r105.size());
        Iterator<Rect> r107 = r105.iterator();
    L15:
        if (r107.hasNext() == false) goto L17;
        r100.writeParcelable(r107.next(), r101);
        goto L15
    L9:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L10
    }

    public AccessibilityCondition(int r100, String r101, List<String> r102, List<KeywordMatchRule> r110, KeywordsMatchRuleEnum r111, String r112, VisibleNodeCountCondition r113, List<Rect> r114, RectMatchRuleEnum r115, long r116, boolean r117, ScreenshotOption r118, int r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r101, "activityName");
        Intrinsics.checkNotNullParameter(r110, "keywordMatchRules");
        Intrinsics.checkNotNullParameter(r111, "keywordsMatchRule");
        Intrinsics.checkNotNullParameter(r115, "touchRectMatchRule");
        this.f397054a = r100;
        this.f397055b = r101;
        this.f397056c = r102;
        this.f397057d = r110;
        this.f397058e = r111;
        this.f397059f = r112;
        this.f397060g = r113;
        this.f397061h = r114;
        this.f397062i = r115;
        this.f397063j = r116;
        this.f397064k = r117;
        this.f397065l = r118;
        this.f397066m = r210;
        this.f397067n = r211;
    }
}
