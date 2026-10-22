package r42;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatValueNode;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r52.g3;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f536022a = 0;

    /* JADX INFO: renamed from: r42.a$a, reason: collision with other inner class name */
    public static final class C7433a<T> implements SingleOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f536023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vlc.d f536024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ tlc.a f536025c;

        /* JADX INFO: renamed from: r42.a$a$a, reason: collision with other inner class name */
        public static final class C7434a implements vlc.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C7433a f536026a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SingleEmitter f536027b;

            @Override // vlc.i
            public final void a(Throwable r100) {
                Intrinsics.checkNotNullParameter(r100, "error");
                int r101 = a.f536022a;
                a.c("fetch first history messages failed due to " + r100.getMessage());
                if (this.f536027b.isDisposed() == true) goto L6;
                this.f536027b.onError(r100);
                return;
            }

            public C7434a(C7433a r100, SingleEmitter r101) {
                this.f536026a = r100;
                this.f536027b = r101;
            }

            @Override // vlc.i
            public final void b(List<? extends tlc.d> r100, boolean r101) {
                Intrinsics.checkNotNullParameter(r100, "messages");
                int r102 = a.f536022a;
                a.c("fetch first history messages success, fetched count: " + r100.size() + ", hasMore: " + r101);
                ArrayList r103 = new ArrayList();
                Iterator<T> r104 = r100.iterator();
            L4:
                if (r104.hasNext() == false) goto L8;
                T r105 = r104.next();
                int r106 = a.f536022a;
                if ((!a.a((tlc.d) r105, this.f536026a.f536024b)) == false) goto L4;
                r103.add(r105);
                goto L4
            L8:
                SingleEmitter r107 = this.f536027b;
                int r108 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
                r107.onSuccess(new com.ss.ugc.live.sdk.msg.utils.g.c(new p(r103, r101)));
            }
        }

        public C7433a(Ref.IntRef r100, vlc.d r101, tlc.a r102) {
            this.f536023a = r100;
            this.f536024b = r101;
            this.f536025c = r102;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<com.ss.ugc.live.sdk.msg.utils.g<p, Throwable>> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            int r101 = a.f536022a;
            a.c("public screen first message processor start fetch history message, count: " + this.f536023a.element);
            vlc.d r102 = this.f536024b;
            if ((r102 instanceof vlc.e) == true) goto L5;
            r102 = null;
        L5:
            vlc.e r103 = (vlc.e) r102;
            if (r103 == null) goto L9;
            r103.E(this.f536025c, new C7434a(this, r100));
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f536028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f536029b;

        public b(long r100, o r101) {
            this.f536028a = r100;
            this.f536029b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.ss.ugc.live.sdk.msg.utils.g r101 = (com.ss.ugc.live.sdk.msg.utils.g) r100;
            if ((r101 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L6;
            p r102 = (p) ((com.ss.ugc.live.sdk.msg.utils.g.c) r101).f458479b;
            z32.f.d(PSRoomStatValueNode.HistoryMessageFetchCostTime, System.currentTimeMillis() - this.f536028a);
            this.f536029b.a(new n(r102, null));
            return;
        L6:
            if ((r101 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L13;
            E r103 = ((com.ss.ugc.live.sdk.msg.utils.g.b) r101).f458478b;
            o r104 = this.f536029b;
            String r105 = r103.getMessage();
            if (r105 != null) goto L10;
            r105 = "Unknown";
        L10:
            r104.a(new n(null, r105));
            return;
        L13:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f536030a;

        public c(o r100) {
            this.f536030a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            MainThreadPostUtils.e(new r42.b(this, (Throwable) r100));
        }
    }

    static {
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("HISTORY_COMMENT_TAG", r100);
    }

    public static boolean a(tlc.d r100, vlc.d r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((r101 instanceof vlc.e) == true) goto L5;
        r101 = null;
    L5:
        vlc.e r102 = (vlc.e) r101;
        if (r102 == null) goto L13;
        amc.e r103 = r102.q();
        if (r103 == null) goto L13;
        amc.b r104 = r103.b();
        if (r104 == null) goto L13;
        List<vlc.b> r105 = r104.getInterceptors();
        if (r105 == null) goto L13;
    L14:
        Iterator<vlc.b> r106 = r105.iterator();
    L16:
        if (r106.hasNext() == false) goto L21;
        if (r106.next().onMessage(r100) == false) goto L16;
        return true;
    L21:
        return false;
    L13:
        r105 = CollectionsKt.emptyList();
        goto L14
    }

    public static Disposable b(vlc.d r100, o r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        Ref.IntRef r102 = new Ref.IntRef();
        r102.element = g.d();
        if (g.c() == false) goto L6;
        r102.element += 12;
    L6:
        return Single.create(new C7433a(r102, r100, new tlc.a(r102.element))).timeout(Math.max(500, g3.f536185a.getValue().longValue()), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(System.currentTimeMillis(), r101), new c(r101));
    }
}
