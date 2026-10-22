package io.ktor.client.plugins.cache;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import io.ktor.http.j;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f491674a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f491675b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f491676c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f491677d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f491678e = null;

    static {
        f491674a = new j("no-store");
        f491675b = new j(HTTP.NO_CACHE);
        f491676c = new j(BridgePrivilege.PRIVATE);
        f491677d = new j("only-if-cached");
        f491678e = new j("must-revalidate");
    }
}
