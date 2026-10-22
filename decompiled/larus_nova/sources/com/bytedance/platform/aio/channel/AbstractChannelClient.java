package com.bytedance.platform.aio.channel;

import com.bytedance.platform.aio.Severity;
import com.bytedance.platform.aio.channel.js.model.BytesContentType;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class AbstractChannelClient<T, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f266555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, AbstractChannelClient<T, R>.a> f266556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f266557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c<T, R> f266558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f266559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ f f266560f;

    public class a implements com.bytedance.platform.aio.channel.b<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f266561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f266562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f266563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.bytedance.platform.aio.channel.b.InterfaceC3727b<R> f266564d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f266565e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.bytedance.platform.aio.channel.b.a f266566f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<e<T>> f266567g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f266568h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Function1<AbstractChannelClient<T, R>.a, Unit> f266569i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ f f266570j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ AbstractChannelClient f266571k;

        @Override // com.bytedance.platform.aio.channel.b
        public final void b() {
            if (this.f266563c == true) goto L9;
            String r100 = this.f266561a;
            com.bytedance.platform.aio.b.f266552a.getClass();
            com.bytedance.platform.aio.b r101 = com.bytedance.platform.aio.b.a.f266553a;
            Severity r102 = Severity.DEBUG;
            if (r101.b(r102, r100) == false) goto L7;
            r101.a(r102, r100, "closeWrite: channel = " + this);
        L7:
            ((ArrayList) this.f266567g).add(new e.a(this.f266568h, false, true, 2));
            flush();
            h(true);
            return;
        }

        @Override // com.bytedance.platform.aio.channel.b
        public final void close() {
            if (this.f266562b == true) goto L5;
        L7:
            boolean r100 = false;
        L8:
            if (r100 == false) goto L10;
            return;
        L10:
            String r101 = this.f266561a;
            com.bytedance.platform.aio.b.f266552a.getClass();
            com.bytedance.platform.aio.b r102 = com.bytedance.platform.aio.b.a.f266553a;
            Severity r103 = Severity.DEBUG;
            if (r102.b(r103, r101) == false) goto L13;
            r102.a(r103, r101, "close: channel = " + this);
        L13:
            ((ArrayList) this.f266567g).add(new e.a(this.f266568h, true, true));
            flush();
            g(true);
            h(true);
            return;
        L5:
            if (this.f266563c == false) goto L7;
            r100 = true;
            goto L8
        }

        @Override // com.bytedance.platform.aio.channel.b
        public final void e() {
            if (this.f266562b == true) goto L9;
            String r100 = this.f266561a;
            com.bytedance.platform.aio.b.f266552a.getClass();
            com.bytedance.platform.aio.b r101 = com.bytedance.platform.aio.b.a.f266553a;
            Severity r102 = Severity.DEBUG;
            if (r101.b(r102, r100) == false) goto L7;
            r101.a(r102, r100, "closeRead: channel = " + this);
        L7:
            ((ArrayList) this.f266567g).add(new e.a(this.f266568h, true, false, 4));
            flush();
            g(true);
            return;
        }

        @Override // com.bytedance.platform.aio.channel.b
        public final void flush() {
            if (((ArrayList) this.f266567g).isEmpty() == false) goto L5;
            return;
        L5:
            this.f266571k.c(this.f266567g);
            String r100 = this.f266561a;
            com.bytedance.platform.aio.b.f266552a.getClass();
            com.bytedance.platform.aio.b r101 = com.bytedance.platform.aio.b.a.f266553a;
            Severity r102 = Severity.DEBUG;
            if (r101.b(r102, r100) == false) goto L8;
            r101.a(r102, r100, "write buffer flushed, channel = " + this);
        L8:
            ((ArrayList) this.f266567g).clear();
        }

        public final String toString() {
            return "Channel(id = " + this.f266568h + ", tag = " + this.f266570j.f266591a + ", readClosed = " + this.f266562b + ", writeClosed = " + this.f266563c + ')';
        }

        @Override // com.bytedance.platform.aio.channel.b
        public final String getChannelId() {
            return this.f266568h;
        }

        @Override // com.bytedance.platform.aio.channel.b
        public final void c(h57.a r100) {
            if (this.f266565e == false) goto L6;
            r100.a("internal_error", "reader missed something", MapsKt.emptyMap());
        L6:
            if (this.f266562b == false) goto L8;
            return;
        L8:
            this.f266564d = r100;
            String r101 = this.f266561a;
            com.bytedance.platform.aio.b.f266552a.getClass();
            com.bytedance.platform.aio.b r102 = com.bytedance.platform.aio.b.a.f266553a;
            Severity r103 = Severity.DEBUG;
            if (r102.b(r103, r101) == false) goto L12;
            r102.a(r103, r101, "setReader: reader = " + r100 + ", channel = " + this);
            return;
        }

        public final void g(boolean r100) {
            boolean r101 = false;
            if (this.f266562b == true) goto L12;
            String r102 = this.f266561a;
            com.bytedance.platform.aio.b.f266552a.getClass();
            com.bytedance.platform.aio.b r103 = com.bytedance.platform.aio.b.a.f266553a;
            Severity r104 = Severity.DEBUG;
            if (r103.b(r104, r102) == false) goto L7;
            r103.a(r104, r102, "local read closed, channel = " + this.f266568h + ", channel = " + this);
        L7:
            this.f266562b = true;
            com.bytedance.platform.aio.channel.b.InterfaceC3727b<R> r105 = this.f266564d;
            if (r105 == null) goto L10;
            r105.onClose();
        L10:
            this.f266564d = null;
            f(this, r100, true, false, 4);
        L12:
            if (this.f266562b == true) goto L14;
        L16:
            if (r101 == false) goto L19;
            this.f266566f = null;
            return;
        L19:
            return;
        L14:
            if (this.f266563c == false) goto L16;
            r101 = true;
            goto L16
        }

        public final void h(boolean r100) {
            boolean r101 = false;
            if (this.f266563c == true) goto L9;
            String r102 = this.f266561a;
            com.bytedance.platform.aio.b.f266552a.getClass();
            com.bytedance.platform.aio.b r103 = com.bytedance.platform.aio.b.a.f266553a;
            Severity r104 = Severity.DEBUG;
            if (r103.b(r104, r102) == false) goto L7;
            r103.a(r104, r102, "local write closed, channel = " + this);
        L7:
            this.f266563c = true;
            ((ArrayList) this.f266567g).clear();
            f(this, r100, false, true, 2);
        L9:
            if (this.f266562b == true) goto L11;
        L13:
            if (r101 == false) goto L16;
            this.f266566f = null;
            return;
        L16:
            return;
        L11:
            if (this.f266563c == false) goto L13;
            r101 = true;
            goto L13
        }

        @Override // com.bytedance.platform.aio.channel.b
        public final void a(T r100, BytesContentType r101) {
            Intrinsics.checkNotNullParameter(r101, "contentType");
            if (this.f266563c == false) goto L5;
            return;
        L5:
            e.d.a r102 = new e.d.a(this.f266568h, r100, r101);
            ((ArrayList) this.f266567g).add(r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(AbstractChannelClient r100, String r101, Function1<? super AbstractChannelClient<T, R>.a, Unit> r102) {
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.Notification.CHANNEL_ID);
            Intrinsics.checkNotNullParameter(r102, "onChannelClosed");
            this.f266571k = r100;
            this.f266570j = new f();
            this.f266568h = r101;
            this.f266569i = r102;
            this.f266561a = "AbstractChannelImpl";
            this.f266567g = new ArrayList();
        }

        @Override // com.bytedance.platform.aio.channel.b
        public final void d(String r100, String r101, Map<String, String> r102, BytesContentType r103) {
            Intrinsics.checkNotNullParameter(r100, "category");
            Intrinsics.checkNotNullParameter(r101, "message");
            Intrinsics.checkNotNullParameter(r103, "contentType");
            if (this.f266563c == false) goto L5;
            return;
        L5:
            String r104 = this.f266568h;
            if (r102 != null) goto L8;
            r102 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L8:
            e.d.b r105 = new e.d.b(r104, new com.bytedance.platform.aio.channel.a(r100, r101, r102), r103);
            ((ArrayList) this.f266567g).add(r105);
        }

        public static void f(a r100, boolean r101, boolean r102, boolean r103, int r104) {
            boolean r105 = false;
            if ((r104 & 2) == 0) goto L6;
            r102 = false;
        L6:
            if ((r104 & 4) == 0) goto L8;
            r103 = false;
        L8:
            if (r102 == false) goto L12;
            com.bytedance.platform.aio.channel.b.a r106 = r100.f266566f;
            if (r106 == null) goto L12;
            r106.b(r101);
        L12:
            if (r103 == false) goto L17;
            com.bytedance.platform.aio.channel.b.a r107 = r100.f266566f;
            if (r107 == null) goto L17;
            r107.a();
        L17:
            if (r100.f266562b == true) goto L19;
        L21:
            if (r105 == false) goto L24;
            r100.f266569i.invoke(r100);
            return;
        L24:
            return;
        L19:
            if (r100.f266563c == false) goto L21;
            r105 = true;
            goto L21
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f266572a = null;

        public b() {
        }

        static {
            f266572a = new b();
        }

        @Override // com.bytedance.platform.aio.channel.c
        public final void a(String r100, String r101, a r102, BytesContentType r103) {
            Intrinsics.checkNotNullParameter(r100, "interfaceId");
            Intrinsics.checkNotNullParameter(r101, "methodId");
            Intrinsics.checkNotNullParameter(r102, "channel");
            Intrinsics.checkNotNullParameter(r103, "preferredContentType");
            r102.d("internal_error", "connectionHandler is not set", null, r103);
            r102.close();
        }
    }

    public void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.CHANNEL_ID);
    }

    public abstract void c(List<? extends e<? extends T>> r100);

    public AbstractChannelClient() {
        this.f266560f = new f();
        this.f266555a = "AbstractChannelClient";
        this.f266556b = new LinkedHashMap();
        this.f266557c = 1;
        this.f266558d = b.f266572a;
    }

    public final AbstractChannelClient<T, R>.a b(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.CHANNEL_ID);
        AbstractChannelClient<T, R>.a r101 = new a(this, r100, new AbstractChannelClient$createChannel$channel$1(this));
        Iterator<T> r102 = this.f266560f.f266591a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        T r103 = r102.next();
        Intrinsics.checkNotNullParameter(r103, "tag");
        f r104 = r101.f266570j;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "tag");
        r104.f266591a.add(r103);
        goto L4
    L6:
        return r101;
    }
}
