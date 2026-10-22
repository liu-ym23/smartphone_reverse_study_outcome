package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/ECPreloadExtra;", "", "", "defaultSchemaRegex", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/ECPreloadMatcher;", "ecPreloadMatchers", "Ljava/util/List;", "b", "()Ljava/util/List;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPreloadExtra {

    @SerializedName("default_schema_regex")
    private final String defaultSchemaRegex;

    @SerializedName("matchers")
    private final List<ECPreloadMatcher> ecPreloadMatchers;

    public ECPreloadExtra() {
    }

    public final String a() {
        return this.defaultSchemaRegex;
    }

    public final List<ECPreloadMatcher> b() {
        return this.ecPreloadMatchers;
    }
}
