package com.bytedance.ee.bear.drive.loader.download.platform.api;

import com.alibaba.fastjson.JSON;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class Poller<PARAMS, RESULT> implements IPoller<PARAMS, RESULT> {
    private static final int DEFAULT_PULL_INTERVALS = 10000;
    private static final String TAG = "DrivePlatform_Poller";
    private final IApiPuller<PARAMS, RESULT> apiPuller;
    private volatile RESULT apiUrlResult;
    private CompositeDisposable disposables;
    private IPoller.IPollingStartListener pollingStartListener;
    private final IPullIntervals<RESULT> pullIntervals;
    private final IPullResultChecker<RESULT> pullResultChecker;
    private PushEntity pushMsg;
    private bu5.a pushObserver;
    private IPushResultChecker pushResultChecker;
    private volatile RESULT sdkUrlResult;
    private Sync sync;
    private volatile Throwable throwable;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.loader.download.platform.api.Poller$1, reason: invalid class name */
    public class AnonymousClass1 implements bu5.a {
        final /* synthetic */ Poller this$0;
        final /* synthetic */ Object val$params;

        public static /* synthetic */ void a(AnonymousClass1 r0, Object r1) {
            r0.lambda$didReceivePush$0(r1);
        }

        public static /* synthetic */ void b(Throwable r0) {
            lambda$didReceivePush$1(r0);
        }

        private /* synthetic */ void lambda$didReceivePush$0(Object r3) throws Exception {
            Poller.access$302(this.this$0, r3);
            Poller r4 = this.this$0;
            Poller.access$400(r4, Poller.access$300(r4), true);
        }

        private static void lambda$didReceivePush$1(Throwable r3) throws Exception {
            tt5.a.e(Poller.TAG, "registerPushListener() error", r3, false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void didReceivePush(String r3) {
            String r4 = Poller.access$000(this.this$0, r3);
            if (Poller.access$100(this.this$0) == null) goto L9;
            if (r4 != null) goto L6;
            return;
        L6:
            if (Poller.access$100(this.this$0).onCheck(r4) == false) goto L11;
            Poller.access$200(this.this$0).pull(this.val$params).subscribe(new i(this), new j());
            return;
        L11:
            return;
        }

        public AnonymousClass1(Poller r1, Object r2) {
            this.this$0 = r1;
            this.val$params = r2;
        }
    }

    public static class Body implements Serializable {
        public String data;

        public Body() {
        }
    }

    public static class Data implements Serializable {
        public Body body;

        public Data() {
        }
    }

    public interface IPullIntervals<RESULT> {
        int get(RESULT r1);
    }

    public interface IPullResultChecker<RESULT> {
        boolean onCheck(RESULT r1);
    }

    public interface IPushResultChecker {
        boolean onCheck(String r1);
    }

    public static class PushEntity {
        public final String routeKey;

        public PushEntity(String r1) {
            this.routeKey = r1;
        }
    }

    public static class Result implements Serializable {
        public Data data;

        public Result() {
        }
    }

    public static /* synthetic */ Publisher a(Poller r0, Object r1, Long r2) {
        return r0.lambda$poll$1(r1, r2);
    }

    public static /* synthetic */ uu5.i b(Object r0) {
        return lambda$poll$0(r0);
    }

    public static /* synthetic */ void c(Poller r0, uu5.i r1) {
        r0.lambda$poll$2(r1);
    }

    public static /* synthetic */ void d(Poller r0, Throwable r1) {
        r0.lambda$poll$3(r1);
    }

    public static boolean isPreviewTypeOk(int r2, int r3) {
        if (r2 != 9) goto L6;
        if (r3 != 0) goto L6;
        return true;
    L6:
        if (r2 == r3) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.api.IPoller
    public void shutdown() {
        if (this.sync.stopWorking() == false) goto L11;
        tt5.a.h(TAG, "shutdown poller, clear disposable and unregister push.");
        CompositeDisposable r0 = this.disposables;
        if (r0 == null) goto L8;
        r0.clear();
    L8:
        if (this.pushObserver == null) goto L12;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.a(com.bytedance.ee.space.sync.b.class)).w7(this.pushObserver);
        return;
    L12:
        return;
    }

    public static /* synthetic */ IPushResultChecker access$100(Poller r0) {
        return r0.pushResultChecker;
    }

    public static /* synthetic */ IApiPuller access$200(Poller r0) {
        return r0.apiPuller;
    }

    public static /* synthetic */ Object access$300(Poller r0) {
        return r0.sdkUrlResult;
    }

    public static /* synthetic */ CompositeDisposable access$500(Poller r0) {
        return r0.disposables;
    }

    public static /* synthetic */ Object access$600(Poller r0) {
        return r0.apiUrlResult;
    }

    private static uu5.i lambda$poll$0(Object r1) throws Exception {
        if (r1 != null) goto L5;
        return uu5.i.c();
    L5:
        return new uu5.i(r1);
    }

    private /* synthetic */ void lambda$poll$2(uu5.i r2) throws Exception {
        if (r2.b() == false) goto L6;
        shutdown();
        return;
    L6:
        if (this.disposables.isDisposed() == true) goto L10;
        this.apiUrlResult = (RESULT) r2.a();
        handleResult(this.apiUrlResult, false);
        return;
    }

    private /* synthetic */ void lambda$poll$3(Throwable r3) throws Exception {
        tt5.a.d(TAG, "pull failed, throwable: " + r3);
        this.throwable = r3;
        shutdown();
    }

    private String parsePushData(String r4) {
        tt5.a.b(TAG, "receive json from push, json: " + r4);
        Result r5 = (Result) JSON.parseObject(r4, Result.class);     // Catch: Exception -> L5
    L6:
        if (r5 == null) goto L14;
        Data r6 = r5.data;
        if (r6 == null) goto L14;
        Body r7 = r6.body;
        if (r7 == null) goto L14;
        String r8 = r7.data;
        if (r8 == null) goto L14;
        return r8;
    L14:
        return null;
    L5:
        tt5.a.d(TAG, "parse json from push failed.");
        r5 = null;
        goto L6
    }

    private int safeGetIntervals(int r2) {
        if (r2 <= 0) goto L4;
        return r2;
    L4:
        tt5.a.h(TAG, "get pull intervals return less than 0, use default pull intervals.");
        return DEFAULT_PULL_INTERVALS;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.ee.bear.drive.loader.download.platform.api.IPoller
    public RESULT poll(final PARAMS r10) throws Throwable {
        boolean r3 = false;
        tt5.a.h(TAG, String.format("===> poller start, %s poll start.", new Object[]{this.apiPuller.getClass().getName()}));
        RESULT r1 = (RESULT) this.apiPuller.pull(r10).blockingSingle();
        if (r1 != null) goto L6;
        tt5.a.d(TAG, "===> poller end, the first request failed, result is null.");
        return null;
    L6:
        boolean r5 = this.pullResultChecker.onCheck(r1);
        int r6 = safeGetIntervals(this.pullIntervals.get(r1));
        if (r5 == false) goto L10;
        tt5.a.h(TAG, "===> poller end, the first request check passed.");
        return r1;
    L10:
        this.sync.startWorking();
        Object[] r2 = new Object[2];
        r2[0] = Integer.valueOf(r6);
        if (this.pushMsg == null) goto L13;
        r3 = true;
    L13:
        r2[1] = String.valueOf(r3);
        tt5.a.h(TAG, String.format("the first request check unPassed, pull per %d milliseconds, register push: %s", r2));
        IPoller.IPollingStartListener r0 = this.pollingStartListener;
        if (r0 == null) goto L17;
        r0.onPollingStart();
    L17:
        if (this.pushMsg == null) goto L20;
        this.pushObserver = new AnonymousClass1(this, r10);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.a(com.bytedance.ee.space.sync.b.class)).Lb(this.pushMsg.routeKey, this.pushObserver);
    L20:
        if (a95.b.a("ccm.drive.mobile.enable_user_download_video_during_transcoding") == false) goto L22;
        this.disposables.add(Flowable.interval(1, r6, TimeUnit.MILLISECONDS).subscribeOn(fo5.d.b()).flatMap(new f(this, r10)).subscribe(new g(this), new h(this)));
    L23:
        tt5.a.h(TAG, "thread id: " + ThreadMethodProxy.currentThread().getId() + " go sleeping.");
        this.sync.waiting();
        tt5.a.h(TAG, "thread id: " + ThreadMethodProxy.currentThread().getId() + " has wake up.");
        if (this.sync.pushOk() == false) goto L28;
        shutdown();
        tt5.a.h(TAG, "===> poller end, push result is ready, return result from push.");
        return this.sdkUrlResult;
    L28:
        if (this.sync.pullOk() == false) goto L32;
        shutdown();
        tt5.a.h(TAG, "===> poller end, pull result is ready, return result from pull.");
        return this.apiUrlResult;
    L32:
        if (this.throwable != null) goto L34;
        return null;
    L34:
        Throwable r11 = this.throwable;
        this.throwable = null;
        throw r11;
    L22:
        this.disposables.add(Flowable.interval(1, r6, TimeUnit.MILLISECONDS).subscribeOn(fo5.d.b()).subscribe(new AnonymousClass2(this, r10), new AnonymousClass3(this)));
        goto L23
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.api.IPoller
    public void setPollingStartListener(IPoller.IPollingStartListener r1) {
        this.pollingStartListener = r1;
    }

    public static /* synthetic */ String access$000(Poller r0, String r1) {
        return r0.parsePushData(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object access$302(Poller r0, Object r1) {
        r0.sdkUrlResult = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object access$602(Poller r0, Object r1) {
        r0.apiUrlResult = r1;
        return r1;
    }

    public static /* synthetic */ Throwable access$702(Poller r0, Throwable r1) {
        r0.throwable = r1;
        return r1;
    }

    private void handleResult(RESULT r4, boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "push ";
    L6:
        if (r4 != null) goto L10;
        tt5.a.d(TAG, "handle result failed, result is null, result from: ".concat(r0));
        return;
    L10:
        if (this.pullResultChecker.onCheck(r4) == false) goto L16;
        tt5.a.h(TAG, "handle result success, check passed, result from: ".concat(r0));
        if (r5 == false) goto L14;
        this.sync.setPushOk();
    L15:
        tt5.a.h(TAG, "try to wake poller thread up.");
        this.sync.wakeUp();
        goto L16
    L14:
        this.sync.setPullOk();
    L16:
        tt5.a.h(TAG, "handle result failed, check unPassed & waiting for next time, result from: ".concat(r0));
        return;
    L4:
        r0 = "pull";
        goto L6
    }

    private /* synthetic */ Publisher lambda$poll$1(Object r1, Long r2) throws Exception {
        if (this.disposables.isDisposed() == false) goto L7;
        return Flowable.just(uu5.i.c());
    L7:
        return this.apiPuller.pull(r1).map(new e());
    }

    public void enablePush(PushEntity r1, IPushResultChecker r2) {
        this.pushMsg = r1;
        this.pushResultChecker = r2;
    }

    public Poller(IApiPuller<PARAMS, RESULT> r2, IPullResultChecker<RESULT> r3, IPullIntervals<RESULT> r4) {
        this.disposables = new CompositeDisposable();
        this.sync = new Sync();
        this.throwable = null;
        this.apiPuller = r2;
        this.pullResultChecker = r3;
        this.pullIntervals = r4;
    }

    public static /* synthetic */ void access$400(Poller r0, Object r1, boolean r2) {
        r0.handleResult(r1, r2);
    }
}
