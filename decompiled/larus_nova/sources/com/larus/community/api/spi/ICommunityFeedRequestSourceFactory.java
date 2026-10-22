package com.larus.community.api.spi;

import android.os.Bundle;
import com.larus.community.impl.applet.s;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import e29.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/larus/community/api/spi/ICommunityFeedRequestSourceFactory;", "", "create", "Lcom/larus/community/api/spi/CommunityFeedRequestSource;", "arguments", "Landroid/os/Bundle;", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICommunityFeedRequestSourceFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f328747a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f328748a = null;

        static {
            f328748a = new a();
        }

        public a() {
        }

        public static c a(Bundle r100) {
            ICommunityFeedRequestSourceFactory r101 = (ICommunityFeedRequestSourceFactory) ServiceManager.get().getService(ICommunityFeedRequestSourceFactory.class);
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.a(r100);
        }
    }

    static {
        f328747a = a.f328748a;
    }

    s a(Bundle r100);
}
