package com.ss.android.lark.message.universalcard.datachannel;

import android.os.Handler;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.openplatform.v1.SubscribeUniversalCardRequest;
import com.bytedance.lark.pb.openplatform.v1.SubscribeUniversalCardResponse;
import com.bytedance.lark.pb.openplatform.v1.UnSubscribeUniversalCardRequest;
import com.bytedance.lark.pb.openplatform.v1.UnSubscribeUniversalCardResponse;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizParam;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.message.p;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class UniversalCardSubscriptionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f432247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f432248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<Runnable> f432249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f432250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f432251e;

    public final class DestroyTask implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UniversalCardSubscriptionManager f432252a;

        public final void a() {
            Log.i("UniversalCardSubscriptionManager", "destroy task run");
            Collection<b> r100 = this.f432252a.f432251e.values();
            final UniversalCardSubscriptionManager r101 = this.f432252a;
            Iterator<T> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L9;
            final b r103 = (b) r102.next();
            Iterator<T> r104 = r103.f432264c.entrySet().iterator();
        L7:
            if (r104.hasNext() == false) goto L4;
            final String r105 = (String) ((Map.Entry) r104.next()).getValue();
            IGetDataCallback<UnSubscribeUniversalCardResponse> r106 = new UniversalCardSubscriptionManager$DestroyTask$run$1$1$1(r101, r105, r103);
            r101.getClass();
            UnSubscribeUniversalCardRequest.Builder r107 = new UnSubscribeUniversalCardRequest.Builder().token(r105);
            SdkSender.asynSendRequestNonWrap(Command.UNSUBSCRIBE_UNIVERSAL_CARD, r107, r106, new e(r101));
            goto L7
        L9:
            this.f432252a.f432251e.clear();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public DestroyTask(UniversalCardSubscriptionManager r100) {
            this.f432252a = r100;
        }
    }

    public final class SubscriptionTask implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f432253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f432254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f432255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.ss.android.lark.message.universalcard.datachannel.b f432256d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ UniversalCardSubscriptionManager f432257e;

        public static final class a<T> implements SdkSender.IParser {
            public a(SubscriptionTask r100) {
            }

            @Override // com.ss.android.lark.sdk.SdkSender.IParser
            public final Object parse(byte[] r100) {
                if (r100 == null) goto L6;
                SubscribeUniversalCardResponse r101 = SubscribeUniversalCardResponse.ADAPTER.decode(r100);
                if (r101 == null) goto L6;
                return r101;
            L6:
                return new SubscribeUniversalCardResponse.Builder().token("").build();
            }
        }

        public final void a() {
            Log.i("UniversalCardSubscriptionManager", UniversalCardSubscriptionManager.a(this.f432257e, "subscribe", this.f432253a, this.f432255c));
            ConcurrentHashMap<String, b> r100 = this.f432257e.f432251e;
            String r101 = this.f432253a;
            b r102 = r100.get(r101);
            if (r102 != null) goto L8;
            r102 = new b(this.f432255c, this.f432253a, new HashMap());
            b r103 = r100.putIfAbsent(r101, r102);
            if (r103 == null) goto L8;
            r102 = r103;
        L8:
            final b r104 = r102;
            if (r104.f432264c.containsKey(this.f432256d) == false) goto L12;
            Log.w("UniversalCardSubscriptionManager", UniversalCardSubscriptionManager.a(this.f432257e, "subscribe duplicate subscribe, ignore", this.f432253a, this.f432255c));
            this.f432257e.b();
            return;
        L12:
            UniversalCardBizParam r105 = new UniversalCardBizParam.Builder().biz_id(this.f432253a).biz_type(Integer.valueOf(this.f432254b)).build();
            SubscribeUniversalCardRequest.Builder r106 = new SubscribeUniversalCardRequest.Builder().card_id(this.f432255c).biz_param(r105).need_push(Boolean.TRUE);
            Command r107 = Command.SUBSCRIBE_UNIVERSAL_CARD;
            final UniversalCardSubscriptionManager r108 = this.f432257e;
            SdkSender.asynSendRequestNonWrap(r107, r106, new UniversalCardSubscriptionManager$SubscriptionTask$run$1(r108, this, r104), new a(this));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public SubscriptionTask(UniversalCardSubscriptionManager r100, String r101, int r102, String r103, p r104) {
            Intrinsics.checkNotNullParameter(r101, "bizID");
            Intrinsics.checkNotNullParameter(r103, "universalCardID");
            Intrinsics.checkNotNullParameter(r104, "subscriber");
            this.f432257e = r100;
            this.f432253a = r101;
            this.f432254b = r102;
            this.f432255c = r103;
            this.f432256d = r104;
        }
    }

    public final class UnSubscriptionTask implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f432258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f432259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.ss.android.lark.message.universalcard.datachannel.b f432260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ UniversalCardSubscriptionManager f432261d;

        public final void a() {
            Log.i("UniversalCardSubscriptionManager", UniversalCardSubscriptionManager.a(this.f432261d, "unsubscribe", this.f432258a, this.f432259b));
            final b r100 = this.f432261d.f432251e.get(this.f432258a);
            if (r100 != null) goto L6;
            UniversalCardSubscriptionManager r101 = this.f432261d;
            Log.e("UniversalCardSubscriptionManager", UniversalCardSubscriptionManager.a(r101, "unsubscribe subscription not found", this.f432258a, this.f432259b));
            r101.b();
            return;
        L6:
            String r102 = r100.f432264c.get(this.f432260c);
            if (r102 != null) goto L10;
            UniversalCardSubscriptionManager r103 = this.f432261d;
            Log.e("UniversalCardSubscriptionManager", UniversalCardSubscriptionManager.a(r103, "unsubscribe token not found", this.f432258a, this.f432259b));
            r103.b();
            return;
        L10:
            final UniversalCardSubscriptionManager r104 = this.f432261d;
            IGetDataCallback<UnSubscribeUniversalCardResponse> r105 = new UniversalCardSubscriptionManager$UnSubscriptionTask$run$1(r104, this, r100);
            r104.getClass();
            UnSubscribeUniversalCardRequest.Builder r106 = new UnSubscribeUniversalCardRequest.Builder().token(r102);
            SdkSender.asynSendRequestNonWrap(Command.UNSUBSCRIBE_UNIVERSAL_CARD, r106, r105, new e(r104));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public UnSubscriptionTask(UniversalCardSubscriptionManager r100, String r101, String r102, p r103) {
            Intrinsics.checkNotNullParameter(r101, "bizID");
            Intrinsics.checkNotNullParameter(r102, "universalCardID");
            Intrinsics.checkNotNullParameter(r103, "subscriber");
            this.f432261d = r100;
            this.f432258a = r101;
            this.f432259b = r102;
            this.f432260c = r103;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f432262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f432263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<com.ss.android.lark.message.universalcard.datachannel.b, String> f432264c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f432262a, r101.f432262a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f432263b, r101.f432263b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f432264c, r101.f432264c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f432262a.hashCode() * 31) + this.f432263b.hashCode()) * 31) + this.f432264c.hashCode();
        }

        public final String toString() {
            return "Subscription(universalCardID=" + this.f432262a + ", bizID=" + this.f432263b + ", subscribers=" + this.f432264c + ')';
        }

        public b(String r100, String r101, Map<com.ss.android.lark.message.universalcard.datachannel.b, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "universalCardID");
            Intrinsics.checkNotNullParameter(r101, "bizID");
            Intrinsics.checkNotNullParameter(r102, "subscribers");
            this.f432262a = r100;
            this.f432263b = r101;
            this.f432264c = r102;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UniversalCardSubscriptionManager f432265a;

        public c(UniversalCardSubscriptionManager r100) {
            this.f432265a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f432265a.f432249c.take().run();     // Catch: Throwable -> L4
            return;
        L4:
            Log.i("UniversalCardSubscriptionManager", "runTask, destroyed");     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L10;
            return;
        L10:
            throw th;
        }
    }

    static {
    }

    public final void b() {
        ((Handler) this.f432248b.getValue()).post(new c(this));
    }

    public UniversalCardSubscriptionManager() {
        this.f432247a = new PthreadHandlerThreadV2("UniversalCardSubscriptionHandler");
        this.f432248b = LazyKt.lazy(new UniversalCardSubscriptionManager$subscriptionHandler$2(this));
        this.f432249c = new LinkedBlockingQueue();
        this.f432251e = new ConcurrentHashMap();
        b();
    }

    public static final String a(UniversalCardSubscriptionManager r100, String r101, String r102, String r103) {
        r100.getClass();
        return r101 + " bizId=" + r102 + ", cardID=" + r103;
    }
}
