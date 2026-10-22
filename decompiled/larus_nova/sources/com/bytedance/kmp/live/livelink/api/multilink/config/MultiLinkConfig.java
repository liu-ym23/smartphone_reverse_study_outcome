package com.bytedance.kmp.live.livelink.api.multilink.config;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.multilink.base.model.ReplyType;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xb6.c;
import xb6.d;
import xb6.e;
import xb6.f;

/* JADX INFO: loaded from: classes19.dex */
public final class MultiLinkConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkSource f252210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f252211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f252212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f252213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f252214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f252215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f252216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f252217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArraySet<d> f252218i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArraySet<e> f252219j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CopyOnWriteArraySet<f> f252220k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f252221l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f252222m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f252223n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f252224o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/live/livelink/api/multilink/config/MultiLinkConfig$LinkSource;", "", "APPLY", "REPLY", "JOIN", UserProfileEvent.POSITION_NONE, "APPLY_AUTO", "multi-link-service-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkSource extends Enum<LinkSource> {
        public static final LinkSource APPLY = null;
        public static final LinkSource APPLY_AUTO = null;
        public static final LinkSource JOIN = null;
        public static final LinkSource NONE = null;
        public static final LinkSource REPLY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LinkSource[] f252225a = null;

        static {
            LinkSource r100 = new LinkSource("APPLY", 0);
            APPLY = r100;
            LinkSource r101 = new LinkSource("REPLY", 1);
            REPLY = r101;
            LinkSource r102 = new LinkSource("JOIN", 2);
            JOIN = r102;
            LinkSource r103 = new LinkSource(UserProfileEvent.POSITION_NONE, 3);
            NONE = r103;
            LinkSource r104 = new LinkSource("APPLY_AUTO", 4);
            APPLY_AUTO = r104;
            f252225a = new LinkSource[]{r100, r101, r102, r103, r104};
        }

        public static LinkSource valueOf(String r100) {
            return (LinkSource) r27.a.a(LinkSource.class, r100);
        }

        public static LinkSource[] values() {
            return (LinkSource[]) f252225a.clone();
        }

        public LinkSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "linkSource " + this.f252210a.ordinal() + ", roomId " + this.f252223n + ", anchorId " + this.f252224o + ",linkMicScene " + this.f252212c + ",needCheckLinkPermission " + this.f252211b + ",linkType " + this.f252214e + ", replyType " + this.f252217h + " , replyToUser " + this.f252215f;
    }

    public final void a(vb6.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Iterator<f> r101 = this.f252220k.iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        f r102 = r101.next();
        if (Intrinsics.areEqual(r102.f563128a, r100) == false) goto L4;
        this.f252220k.remove(r102);
        return;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        LinkMonitor.a("MultiLinkConfig", "resetConfig", "reason " + r100, null, null, false, 120);
        this.f252210a = LinkSource.NONE;
        this.f252217h = ReplyType.None.ordinal();
        this.f252212c = 0;
        Iterator<f> r101 = this.f252220k.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        f r102 = r101.next();
        if (r102.f563129b == true) goto L4;
        this.f252220k.remove(r102);
        goto L4
    L8:
        Iterator<e> r103 = this.f252219j.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        e r104 = r103.next();
        if (r104.f563127b == true) goto L10;
        this.f252219j.remove(r104);
        goto L10
    L14:
        Iterator<d> r105 = this.f252218i.iterator();
    L16:
        if (r105.hasNext() == false) goto L20;
        d r106 = r105.next();
        if (r106.f563125b == true) goto L16;
        this.f252218i.remove(r106);
        goto L16
    L20:
        this.f252215f = "";
        this.f252213d = "";
    }

    public MultiLinkConfig(boolean r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        this.f252222m = r100;
        this.f252223n = r101;
        this.f252224o = r102;
        this.f252210a = LinkSource.NONE;
        this.f252211b = true;
        this.f252213d = "";
        this.f252214e = 2;
        this.f252215f = "";
        this.f252216g = "";
        this.f252217h = ReplyType.None.ordinal();
        this.f252218i = new CopyOnWriteArraySet();
        this.f252219j = new CopyOnWriteArraySet();
        this.f252220k = new CopyOnWriteArraySet();
    }
}
