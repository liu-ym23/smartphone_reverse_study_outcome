package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;", "", "", "enable", "Z", "b", "()Z", "", "", "domainWhiteList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setDomainWhiteList", "(Ljava/util/List;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class LegacyWebcastConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f246314a;

    @SerializedName("domain_white_list")
    private List<String> domainWhiteList;

    @SerializedName("enable")
    private final boolean enable;

    public LegacyWebcastConfig() {
        this.enable = true;
        this.domainWhiteList = CollectionsKt.emptyList();
        this.f246314a = LazyKt.lazy(new LegacyWebcastConfig$domainWhiteMap$2(this));
    }

    public final List<String> a() {
        return this.domainWhiteList;
    }

    public final boolean b() {
        return this.enable;
    }
}
