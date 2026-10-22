package com.ss.android.ugc.aweme.poi.event;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/event/GoodsDetailLoadEvent;", "", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getType", "()I", "type", "Companion", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class GoodsDetailLoadEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f451321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f451322b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/event/GoodsDetailLoadEvent$Companion;", "", "()V", "GOODS_DETAIL_CLOSE", "", "GOODS_DETAIL_FMP", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public final int getType() {
        return this.f451321a;
    }

    public GoodsDetailLoadEvent(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        this.f451321a = r100;
        this.f451322b = r101;
    }
}
