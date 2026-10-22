package com.larus.home.impl.main.side_bar.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/BizData;", "", "count", "", "maxCount", "hasMainBot", "", "rightIcons", "", "", "quickAccessSectionType", "<init>", "(IIZLjava/util/List;Ljava/lang/String;)V", "getCount", "()I", "getMaxCount", "getHasMainBot", "()Z", "getRightIcons", "()Ljava/util/List;", "getQuickAccessSectionType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("count")
    private final int count;

    @SerializedName("has_main_bot")
    private final boolean hasMainBot;

    @SerializedName(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT)
    private final int maxCount;

    @SerializedName("quick_access_section_type")
    private final String quickAccessSectionType;

    @SerializedName("right_icons")
    private final List<String> rightIcons;

    public b() {
        this(0, 0, true, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.count == r101.count) goto L12;
        return false;
    L12:
        if (this.maxCount == r101.maxCount) goto L15;
        return false;
    L15:
        if (this.hasMainBot == r101.hasMainBot) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rightIcons, r101.rightIcons) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.quickAccessSectionType, r101.quickAccessSectionType) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.count * 31) + this.maxCount) * 31;
        if (this.hasMainBot == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        List<String> r103 = this.rightIcons;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.quickAccessSectionType;
        if (r107 == null) goto L15;
        r104 = r107.hashCode();
    L15:
        return r106 + r104;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BizData(count=" + this.count + ", maxCount=" + this.maxCount + ", hasMainBot=" + this.hasMainBot + ", rightIcons=" + this.rightIcons + ", quickAccessSectionType=" + this.quickAccessSectionType + ')';
    }

    public final int b() {
        return this.count;
    }

    public final boolean c() {
        return this.hasMainBot;
    }

    public final int d() {
        return this.maxCount;
    }

    public final String e() {
        return this.quickAccessSectionType;
    }

    public final List<String> f() {
        return this.rightIcons;
    }

    public static b a(b r100, int r101) {
        return new b(r101, r100.maxCount, r100.hasMainBot, r100.rightIcons, r100.quickAccessSectionType);
    }

    public b(int r100, int r101, boolean r102, List<String> r103, String r104) {
        this.count = r100;
        this.maxCount = r101;
        this.hasMainBot = r102;
        this.rightIcons = r103;
        this.quickAccessSectionType = r104;
    }
}
