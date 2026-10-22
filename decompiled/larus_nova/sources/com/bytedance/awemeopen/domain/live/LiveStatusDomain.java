package com.bytedance.awemeopen.domain.live;

import a24.b;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.servicesapi.livepreview.AoLiveService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class LiveStatusDomain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AoLiveService f198413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f198414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Observer<b>> f198415c;

    public static final class a {
    }

    static {
    }

    public LiveStatusDomain() {
        this.f198414b = LazyKt.lazy(LiveStatusDomain$liveStatusCacheValidateTime$2.INSTANCE);
        this.f198415c = new ArrayList();
    }
}
