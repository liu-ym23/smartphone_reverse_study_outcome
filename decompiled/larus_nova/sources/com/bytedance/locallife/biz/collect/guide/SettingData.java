package com.bytedance.locallife.biz.collect.guide;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/biz/collect/guide/SettingData;", "", "matchUrls", "", "", "(Ljava/util/List;)V", "getMatchUrls", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SettingData {

    @SerializedName("match_urls")
    private final List<String> matchUrls;

    /* JADX WARN: Multi-variable type inference failed */
    public SettingData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingData copy$default(SettingData r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.matchUrls;
    L6:
        return r100.copy(r101);
    }

    public final List<String> component1() {
        return this.matchUrls;
    }

    public final SettingData copy(List<String> r100) {
        return new SettingData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SettingData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.matchUrls, ((SettingData) r100).matchUrls) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.matchUrls;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "SettingData(matchUrls=" + this.matchUrls + ')';
    }

    public final List<String> getMatchUrls() {
        return this.matchUrls;
    }

    public SettingData(List<String> r100) {
        this.matchUrls = r100;
    }

    public /* synthetic */ SettingData(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = CollectionsKt.listOf("detail_pay_footer/template.js");
    L5:
        this(r100);
    }
}
