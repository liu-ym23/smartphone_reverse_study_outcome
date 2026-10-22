package com.obric.memorydata.sdk.accessibility;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.sdk.screencapture.rule.SearchNodeEnum;
import com.obric.memorydata.sdk.screencapture.rule.TextMatchRuleEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003JQ\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\u0006\u0010$\u001a\u00020%J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020%HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017¨\u00060"}, d2 = {"Lcom/obric/memorydata/sdk/accessibility/KeywordMatchRule;", "Landroid/os/Parcelable;", "keyword", "", "searchNode", "Lcom/obric/memorydata/sdk/screencapture/rule/SearchNodeEnum;", "matchRule", "Lcom/obric/memorydata/sdk/screencapture/rule/TextMatchRuleEnum;", "traverseAllChildren", "", "viewIdResourceName", "viewTreeCacheValidDuration", "", "viewVisibleOnly", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/sdk/screencapture/rule/SearchNodeEnum;Lcom/obric/memorydata/sdk/screencapture/rule/TextMatchRuleEnum;ZLjava/lang/String;JZ)V", "getKeyword", "()Ljava/lang/String;", "getSearchNode", "()Lcom/obric/memorydata/sdk/screencapture/rule/SearchNodeEnum;", "getMatchRule", "()Lcom/obric/memorydata/sdk/screencapture/rule/TextMatchRuleEnum;", "getTraverseAllChildren", "()Z", "getViewIdResourceName", "getViewTreeCacheValidDuration", "()J", "getViewVisibleOnly", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KeywordMatchRule implements Parcelable {
    public static final Parcelable.Creator<KeywordMatchRule> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SearchNodeEnum f397069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextMatchRuleEnum f397070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f397071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f397072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f397073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f397074g;

    public static final class a implements Parcelable.Creator<KeywordMatchRule> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final KeywordMatchRule createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            SearchNodeEnum r101 = SearchNodeEnum.valueOf(r110.readString());
            TextMatchRuleEnum r102 = TextMatchRuleEnum.valueOf(r110.readString());
            if (r110.readInt() == 0) goto L5;
            boolean r103 = true;
        L6:
            String r104 = r110.readString();
            long r105 = r110.readLong();
            if (r110.readInt() == 0) goto L9;
            boolean r111 = true;
        L11:
            return new KeywordMatchRule(r100, r101, r102, r103, r104, r105, r111);
        L9:
            r111 = false;
            goto L11
        L5:
            r103 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final KeywordMatchRule[] newArray(int r100) {
            return new KeywordMatchRule[r100];
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
        if ((r100 instanceof KeywordMatchRule) == true) goto L8;
        return false;
    L8:
        KeywordMatchRule r101 = (KeywordMatchRule) r100;
        if (Intrinsics.areEqual(this.f397068a, r101.f397068a) == true) goto L12;
        return false;
    L12:
        if (this.f397069b == r101.f397069b) goto L15;
        return false;
    L15:
        if (this.f397070c == r101.f397070c) goto L18;
        return false;
    L18:
        if (this.f397071d == r101.f397071d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f397072e, r101.f397072e) == true) goto L24;
        return false;
    L24:
        if (this.f397073f == r101.f397073f) goto L27;
        return false;
    L27:
        if (this.f397074g == r101.f397074g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f397068a.hashCode() * 31) + this.f397069b.hashCode()) * 31) + this.f397070c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f397071d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        String r104 = this.f397072e;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        long r106 = this.f397073f;
        int r107 = (((r103 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        if (this.f397074g == true) goto L15;
        r101 = 1237;
    L15:
        return r107 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "KeywordMatchRule(keyword=" + this.f397068a + ", searchNode=" + this.f397069b + ", matchRule=" + this.f397070c + ", traverseAllChildren=" + this.f397071d + ", viewIdResourceName=" + this.f397072e + ", viewTreeCacheValidDuration=" + this.f397073f + ", viewVisibleOnly=" + this.f397074g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f397068a);
        r100.writeString(this.f397069b.name());
        r100.writeString(this.f397070c.name());
        r100.writeInt(this.f397071d ? 1 : 0);
        r100.writeString(this.f397072e);
        r100.writeLong(this.f397073f);
        r100.writeInt(this.f397074g ? 1 : 0);
    }

    public KeywordMatchRule(String r100, SearchNodeEnum r101, TextMatchRuleEnum r102, boolean r103, String r104, long r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        Intrinsics.checkNotNullParameter(r101, "searchNode");
        Intrinsics.checkNotNullParameter(r102, "matchRule");
        this.f397068a = r100;
        this.f397069b = r101;
        this.f397070c = r102;
        this.f397071d = r103;
        this.f397072e = r104;
        this.f397073f = r105;
        this.f397074g = r106;
    }
}
