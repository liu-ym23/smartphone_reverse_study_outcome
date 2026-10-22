package com.ss.ugc.live.sdk.msg.unify;

import com.ss.ugc.live.sdk.msg.unify.business.UnifyLiveMessageDispatcher;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWCustomData;
import com.ss.ugc.live.sdk.msg.unify.network.UnifyWSState;
import com.ss.ugc.live.sdk.msg.utils.StateMachine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vlc.n;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements imc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<imc.c> f458356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f458357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateMachine<d, a, AbstractC5492c> f458358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f458359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UnifyWSState f458360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final imc.d f458361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.unify.b f458362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f458363h;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.c$a$a, reason: collision with other inner class name */
        public static final class C5490a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5490a f458364a = null;

            static {
                f458364a = new C5490a();
            }

            public C5490a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f458365a = null;

            static {
                f458365a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.c$a$c, reason: collision with other inner class name */
        public static final class C5491c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f458366a;

            public C5491c(long r100) {
                this.f458366a = r100;
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f458367a = null;

            static {
                f458367a = new d();
            }

            public d() {
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f458368a;

            public e(long r100) {
                this.f458368a = r100;
            }
        }

        public static final class f extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f458369a;

            public f(long r100) {
                this.f458369a = r100;
            }
        }

        public a() {
        }
    }

    public interface b {
        void a(c r100);
    }

    /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC5492c {

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.c$c$a */
        public static final class a extends AbstractC5492c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f458370a = null;

            static {
                f458370a = new a();
            }

            public a() {
            }
        }

        public AbstractC5492c() {
        }
    }

    public static abstract class d {

        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f458371a = null;

            static {
                f458371a = new a();
            }

            public a() {
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f458372a = null;

            static {
                f458372a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.c$d$c, reason: collision with other inner class name */
        public static final class C5493c extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5493c f458373a = null;

            static {
                f458373a = new C5493c();
            }

            public C5493c() {
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.c$d$d, reason: collision with other inner class name */
        public static final class C5494d extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5494d f458374a = null;

            static {
                f458374a = new C5494d();
            }

            public C5494d() {
            }
        }

        public static final class e extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f458375a;

            public e(long r100) {
                this.f458375a = r100;
            }
        }

        public static final class f extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final f f458376a = null;

            static {
                f458376a = new f();
            }

            public f() {
            }
        }

        public d() {
        }
    }

    public final String a() {
        return "[service: " + g() + ", method: " + e() + ", token: " + this.f458359d + ']';
    }

    public final List<UMGWCustomData> b() {
        Map<String, String> r100 = this.f458361f.d();
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, String> r103 = r102.next();
        r101.add(new UMGWCustomData(r103.getKey(), r103.getValue()));
        goto L4
    L6:
        return r101;
    }

    @Override // vlc.f
    public final boolean c() {
        return this.f458360e.e();
    }

    public final int e() {
        return this.f458361f.b().f458425b;
    }

    public final List<UMGWCustomData> f() {
        Map<String, String> r100 = this.f458361f.b().f458426c;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, String> r103 = r102.next();
        r101.add(new UMGWCustomData(r103.getKey(), r103.getValue()));
        goto L4
    L6:
        return r101;
    }

    public final int g() {
        return this.f458361f.b().f458424a;
    }

    public final d h() {
        return this.f458358c.b();
    }

    @Override // imc.a
    public final void unregister() {
        this.f458358c.d(a.d.f458367a);
    }

    @Override // imc.a
    public final void A(UnifyLiveMessageDispatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f458356a.add(r100);
    }

    @Override // vlc.f
    public final void p(n r100) {
        this.f458357b = r100;
    }

    @Override // vlc.f
    public final boolean w(tlc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadItem");
        if (c() == false) goto L5;
        this.f458360e.f(r100);
        return true;
    L5:
        return false;
    }

    public c(long r100, UnifyWSState r101, imc.d r102, com.ss.ugc.live.sdk.msg.unify.b r103, com.ss.ugc.live.sdk.msg.unify.d.a r104) {
        Intrinsics.checkNotNullParameter(r101, "wsState");
        Intrinsics.checkNotNullParameter(r102, "unifyBusinessConfig");
        Intrinsics.checkNotNullParameter(r103, "unifyLinkManager");
        Intrinsics.checkNotNullParameter(r104, "onBridgeStateListener");
        this.f458359d = r100;
        this.f458360e = r101;
        this.f458361f = r102;
        this.f458362g = r103;
        this.f458363h = r104;
        this.f458356a = new CopyOnWriteArraySet();
        StateMachine.a r105 = StateMachine.f458449c;
        Function1<StateMachine.GraphBuilder<d, a, AbstractC5492c>, Unit> r106 = new UnifyMessageBridge$stateMachine$1(this);
        r105.getClass();
        this.f458358c = StateMachine.a.a(r106);
    }
}
