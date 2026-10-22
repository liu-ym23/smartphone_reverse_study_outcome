package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/SearchEditViewStyleConfig;", "", "", "", "channel", "[Ljava/lang/String;", "getChannel", "()[Ljava/lang/String;", "Lcom/ss/android/ugc/aweme/search/common/config/SearchStyleConfig;", "commonStyleConfig", "Lcom/ss/android/ugc/aweme/search/common/config/SearchStyleConfig;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/ss/android/ugc/aweme/search/common/config/SearchStyleConfig;", "middleStyleConfig", "b", "sugStyleConfig", "d", "resultStyleConfig", "c", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchEditViewStyleConfig {

    @SerializedName("channel")
    private final String[] channel;

    @SerializedName("common")
    private final SearchStyleConfig commonStyleConfig;

    @SerializedName("middle")
    private final SearchStyleConfig middleStyleConfig;

    @SerializedName("result")
    private final SearchStyleConfig resultStyleConfig;

    @SerializedName("sug")
    private final SearchStyleConfig sugStyleConfig;

    public SearchEditViewStyleConfig() {
        this(null, 31);
    }

    public final String toString() {
        return "SearchEditViewStyleConfig(channel=" + Arrays.toString(this.channel) + ", commonStyleConfig=" + this.commonStyleConfig + ", middleStyleConfig=" + this.middleStyleConfig + ", sugStyleConfig=" + this.sugStyleConfig + ", resultStyleConfig=" + this.resultStyleConfig + ")";
    }

    public final int hashCode() {
        String[] r100 = this.channel;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = Arrays.hashCode(r100);
    L6:
        int r103 = r102 * 31;
        SearchStyleConfig r104 = this.commonStyleConfig;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        SearchStyleConfig r107 = this.middleStyleConfig;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        SearchStyleConfig r110 = this.sugStyleConfig;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        SearchStyleConfig r113 = this.resultStyleConfig;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final SearchStyleConfig a() {
        return this.commonStyleConfig;
    }

    public final SearchStyleConfig b() {
        return this.middleStyleConfig;
    }

    public final SearchStyleConfig c() {
        return this.resultStyleConfig;
    }

    public final SearchStyleConfig d() {
        return this.sugStyleConfig;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(SearchEditViewStyleConfig.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L38;
        SearchEditViewStyleConfig r102 = (SearchEditViewStyleConfig) r100;
        String[] r103 = this.channel;
        if (r103 == null) goto L22;
        String[] r104 = r102.channel;
        if (r104 != null) goto L19;
        return false;
    L19:
        if (Arrays.equals(r103, r104) == true) goto L25;
        return false;
    L25:
        if ((!Intrinsics.areEqual(this.commonStyleConfig, r102.commonStyleConfig)) == false) goto L28;
        return false;
    L28:
        if ((!Intrinsics.areEqual(this.middleStyleConfig, r102.middleStyleConfig)) == false) goto L31;
        return false;
    L31:
        if ((!Intrinsics.areEqual(this.sugStyleConfig, r102.sugStyleConfig)) == false) goto L34;
        return false;
    L34:
        if ((!Intrinsics.areEqual(this.resultStyleConfig, r102.resultStyleConfig)) == false) goto L36;
        return false;
    L36:
        return true;
    L22:
        if (r102.channel == null) goto L25;
        return false;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.ugc.aweme.search.common.config.SearchEditViewStyleConfig");
    L8:
        r101 = null;
        goto L10
    }

    public SearchEditViewStyleConfig(SearchStyleConfig r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        r100 = null;
    L5:
        this.channel = null;
        this.commonStyleConfig = r100;
        this.middleStyleConfig = null;
        this.sugStyleConfig = null;
        this.resultStyleConfig = null;
    }
}
