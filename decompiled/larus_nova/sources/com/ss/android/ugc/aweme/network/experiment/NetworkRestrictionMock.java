package com.ss.android.ugc.aweme.network.experiment;

import com.bytedance.ies.abmock.annotations.ABKey;
import com.bytedance.ies.abmock.annotations.Owner;
import com.bytedance.ies.abmock.annotations.Scope;
import com.bytedance.ies.abmock.annotations.Title;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import n06.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/network/experiment/NetworkRestrictionMock;", "", "<init>", "()V", "aweme-network-api_release"}, k = 1, mv = {1, 4, 1})
@ABKey("network_restriction_upload_level")
@Owner("huangsijie.hosigus0")
@Scope(businesses = {a.class}, modules = {o06.a.class})
@Title("network_restriction_upload_level")
public final class NetworkRestrictionMock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f451293a = null;

    private NetworkRestrictionMock() {
    }

    static {
        new NetworkRestrictionMock();
        f451293a = LazyKt.lazy(NetworkRestrictionMock$level$2.INSTANCE);
    }
}
