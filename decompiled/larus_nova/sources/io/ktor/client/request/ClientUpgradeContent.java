package io.ktor.client.request;

import io.ktor.util.InternalAPI;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes41.dex */
@InternalAPI
public abstract class ClientUpgradeContent extends io.ktor.http.content.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f491757a;

    public ClientUpgradeContent() {
        this.f491757a = LazyKt.lazy(ClientUpgradeContent$content$2.INSTANCE);
    }
}
