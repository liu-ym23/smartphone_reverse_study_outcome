package com.larus.larkfeed.impl.reach;

import androidx.appcompat.app.AppCompatActivity;
import com.larus.im.b;
import com.larus.reach.api.ReachSceneInterceptor;
import gd9.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ns9.e;
import ns9.t;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/larus/larkfeed/impl/reach/SocialImReachSceneInterceptor;", "Lcom/larus/reach/api/ReachSceneInterceptor;", "<init>", "()V", "pushScene", "", "getPushScene", "()Ljava/lang/String;", "canShow", "", "request", "Lcom/larus/reach/api/ReachRequest;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialImReachSceneInterceptor implements ReachSceneInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f355503a;

    public SocialImReachSceneInterceptor() {
        this.f355503a = "social_im";
    }

    @Override // com.larus.reach.api.ReachSceneInterceptor
    public final String a() {
        return this.f355503a;
    }

    @Override // com.larus.reach.api.ReachSceneInterceptor
    public final boolean f(t r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        i r101 = b.f346407a;
        Intrinsics.checkNotNull(r101);
        return r101.a().e() instanceof AppCompatActivity;
    }

    @Override // com.larus.reach.api.ReachSceneInterceptor
    public final boolean j(t r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "click");
        return false;
    }
}
