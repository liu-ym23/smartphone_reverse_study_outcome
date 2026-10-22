package com.ss.android.ugc.aweme.poi.mob;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/mob/PoiMobEventParams;", "", "Builder", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiMobEventParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f451352a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/mob/PoiMobEventParams$Builder;", "", "<init>", "()V", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, String> f451353a;

        public Builder() {
        }
    }

    public PoiMobEventParams(Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f451352a = r100.f451353a;
    }
}
