package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR0\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/Strategy;", "", "", "enterFrom", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setEnterFrom", "(Ljava/lang/String;)V", "", "initHide", "I", "c", "()I", "setInitHide", "(I)V", "srpBackAllHide", "d", "setSrpBackAllHide", "", "backSrpSourceHide", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setBackSrpSourceHide", "(Ljava/util/Map;)V", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Strategy {

    @SerializedName("back_srp_source_hide")
    private Map<String, Integer> backSrpSourceHide;

    @SerializedName("enter_from")
    private String enterFrom;

    @SerializedName("init_hide")
    private int initHide;

    @SerializedName("back_srp_all_hide")
    private int srpBackAllHide;

    public Strategy() {
    }

    public final Map<String, Integer> a() {
        return this.backSrpSourceHide;
    }

    public final String b() {
        return this.enterFrom;
    }

    public final int c() {
        return this.initHide;
    }

    public final int d() {
        return this.srpBackAllHide;
    }
}
