package com.bytedance.live.richcontent.engine;

import ak6.g;
import com.bytedance.android.livesdk.interactivity.service.richcontent.config.LiveRichContentConfig;
import com.bytedance.android.livesdk.interactivity.service.richcontent.config.b;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.obric.miniapp.alarm.AccountType;
import ek6.d;
import ik6.a;
import ik6.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import jk6.e;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mk6.f;

/* JADX INFO: loaded from: classes19.dex */
public final class SpanRendClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends d>, a<? extends d>> f255744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f255745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f255746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f255747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorService f255748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final hk6.e f255749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.live.richcontent.utils.c f255750g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/live/richcontent/engine/SpanRendClient$RendType;", "", AccountType.ALL, CardAdapter.TEXT, "TEXT_AND_SYNC_RESOURCE", "RESOURCE", "richcontent_release"}, k = 1, mv = {1, 4, 2})
    public static final enum RendType extends Enum<RendType> {
        public static final RendType ALL = null;
        public static final RendType RESOURCE = null;
        public static final RendType TEXT = null;
        public static final RendType TEXT_AND_SYNC_RESOURCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RendType[] f255751a = null;

        static {
            RendType r100 = new RendType(AccountType.ALL, 0);
            ALL = r100;
            RendType r101 = new RendType(CardAdapter.TEXT, 1);
            TEXT = r101;
            RendType r102 = new RendType("TEXT_AND_SYNC_RESOURCE", 2);
            TEXT_AND_SYNC_RESOURCE = r102;
            RendType r103 = new RendType("RESOURCE", 3);
            RESOURCE = r103;
            f255751a = new RendType[]{r100, r101, r102, r103};
        }

        public static RendType valueOf(String r100) {
            return (RendType) r27.a.a(RendType.class, r100);
        }

        public static RendType[] values() {
            return (RendType[]) f255751a.clone();
        }

        public RendType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final <T extends d> a<T> a(T r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        a<T> r101 = (a) this.f255744a.get(r100.getClass());
        if (r101 != null) goto L7;
        com.bytedance.live.richcontent.utils.c r102 = this.f255750g;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "content");
        r102.f255805a.error("onFindContentRenderFailed, content is " + r100, null);
        return null;
    L7:
        return r101;
    }

    public final g e(ek6.e r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "richContent");
        Intrinsics.checkNotNullParameter(r101, "config");
        ik6.d r102 = new ik6.d(r100, r101);
        return ((f) b(RendType.TEXT_AND_SYNC_RESOURCE, r102, null)).f514319a;
    }

    public SpanRendClient(LiveRichContentConfig r100, hk6.e r101, com.bytedance.live.richcontent.utils.c r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "resourceManager");
        Intrinsics.checkNotNullParameter(r102, "monitor");
        this.f255749f = r101;
        this.f255750g = r102;
        this.f255744a = r100.f140954e;
        this.f255745b = CollectionsKt.mutableListOf(new c[]{new jk6.f(), new jk6.c(), new jk6.b(), new jk6.a(), new jk6.d()});
        this.f255746c = r100.f140955f;
        this.f255747d = new e(r102);
        this.f255748e = r100.f140956g.a();
    }

    public final ak6.a b(RendType r100, ik6.d r101, ak6.e r102) {
        ak6.f r103 = null;
        this.f255750g.e(r101, r100.name());     // Catch: Exception -> L22
        int r104 = dk6.b.f469021a[r100.ordinal()];     // Catch: Exception -> L22
        if (r104 != 1) goto L6;
        ArrayList r105 = new ArrayList();     // Catch: Exception -> L22
        r105.addAll(this.f255745b);     // Catch: Exception -> L22
        r105.addAll(this.f255746c);     // Catch: Exception -> L22
        r105.add(this.f255747d);     // Catch: Exception -> L22
    L17:
        Iterator r106 = r105.iterator();     // Catch: Exception -> L22
    L19:
        if (r106.hasNext() == false) goto L25;
        ((c) r106.next()).a(this, r101);     // Catch: Exception -> L22
    L25:
        if (r100 == RendType.ALL) goto L29;
        if (r100 == RendType.RESOURCE) goto L29;
    L31:
        boolean r107 = false;
    L32:
        com.bytedance.live.richcontent.utils.c r108 = this.f255750g;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r101, "rendItem");
        r108.f255805a.a();
        if (r107 == false) goto L43;
        mk6.d r109 = new mk6.d(this, this.f255750g, r101, r102);
        ak6.f r110 = r101.f490270b;
        if ((r110 instanceof ak6.f) == false) goto L38;
        r103 = r110;
    L38:
        if (r103 != null) goto L40;
    L42:
        r109.run();
        return r109;
    L40:
        if (r103.f4072a != true) goto L42;
        this.f255748e.submit(r109);
        return r109;
    L43:
        f r111 = new f(r101.c(), r102);
        r111.run();
        return r111;
    L29:
        if (r101.e() == true) goto L31;
        r107 = true;
        goto L32
    L6:
        if (r104 != 2) goto L8;
        r105 = new ArrayList();     // Catch: Exception -> L22
        r105.addAll(this.f255745b);     // Catch: Exception -> L22
        r105.addAll(this.f255746c);     // Catch: Exception -> L22
        goto L17
    L8:
        if (r104 != 3) goto L10;
        r105 = new ArrayList();     // Catch: Exception -> L22
        r105.addAll(this.f255745b);     // Catch: Exception -> L22
        r105.addAll(this.f255746c);     // Catch: Exception -> L22
        r105.add(this.f255747d);     // Catch: Exception -> L22
        goto L17
    L10:
        if (r104 != 4) goto L13;
        r105 = new ArrayList();     // Catch: Exception -> L22
        r105.add(this.f255747d);     // Catch: Exception -> L22
        goto L17
    L13:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        this.f255750g.a(r101, null, e.getMessage(), e);
        goto L25
    }

    public final ak6.a c(ek6.e r100, ak6.f r101, ak6.e r102) {
        Intrinsics.checkNotNullParameter(r100, "richContent");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ik6.d r103 = new ik6.d(r100, r101);
        return b(RendType.ALL, r103, r102);
    }

    public final ak6.a d(g r100, b r101, ak6.e r102) {
        Intrinsics.checkNotNullParameter(r100, "spanRendResult");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ik6.d r103 = new ik6.d(r100, r101);
        return b(RendType.RESOURCE, r103, r102);
    }
}
