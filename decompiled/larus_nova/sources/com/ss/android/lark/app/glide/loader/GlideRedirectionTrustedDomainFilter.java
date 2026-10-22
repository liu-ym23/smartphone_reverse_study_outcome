package com.ss.android.lark.app.glide.loader;

import android.util.LruCache;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
public final class GlideRedirectionTrustedDomainFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f408731a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, Boolean> f408732b = null;

    @AppConfig(key = "glide_forward_header_whitelist_domains")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/app/glide/loader/GlideRedirectionTrustedDomainFilter$DomainsConfig;", "", "<init>", "()V", "domains", "", "", "getDomains", "()Ljava/util/List;", "setDomains", "(Ljava/util/List;)V", "glide-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DomainsConfig {

        @SerializedName("domains")
        private List<String> domains;

        public DomainsConfig() {
        }

        public final List<String> a() {
            return this.domains;
        }
    }

    static {
        f408731a = LazyKt.lazy(GlideRedirectionTrustedDomainFilter$trustedDomains$2.INSTANCE);
        f408732b = new LruCache(20);
    }
}
