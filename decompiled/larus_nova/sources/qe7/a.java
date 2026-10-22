package qe7;

import android.util.Pair;
import bolts.Task;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.cn.runtime.depend.h;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends GeckoUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f532685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f532686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f532687c;

    /* JADX INFO: renamed from: qe7.a$a, reason: collision with other inner class name */
    public static final class CallableC7317a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f532688a;

        public CallableC7317a(a r100) {
            this.f532688a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.f532688a.f532685a.b();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class b<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map<String, List<UpdatePackage>> f532689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f532690b;

        public b(Map<String, List<UpdatePackage>> r100, a r101) {
            this.f532689a = r100;
            this.f532690b = r101;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            Map<String, List<UpdatePackage>> r100 = this.f532689a;
            if (r100 != null) goto L5;
        L22:
            this.f532690b.f532685a.b();
            return;
        L5:
            if (r100.containsKey(this.f532690b.f532687c) == false) goto L22;
            List<UpdatePackage> r101 = this.f532689a.get(this.f532690b.f532687c);
            if (r101 == null) goto L12;
            boolean r102 = true;
            if (r101.isEmpty() != true) goto L12;
        L13:
            UpdatePackage r103 = null;
            if (r102 == true) goto L18;
            if (r101 == null) goto L18;
            r103 = (UpdatePackage) ListProtector.get(r101, 0);
        L18:
            if (r103 == null) goto L20;
            r103.getFullPackage();
        L20:
            this.f532690b.f532685a.b();
            return;
        L12:
            r102 = false;
            goto L13
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class c<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f532691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UpdatePackage f532692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f532693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f532694d;

        public c(a r100, UpdatePackage r101, long r102, long r103) {
            this.f532691a = r100;
            this.f532692b = r101;
            this.f532693c = r102;
            this.f532694d = r103;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            JSONObject r100 = new JSONObject();
            UpdatePackage r101 = this.f532692b;
            a r102 = this.f532691a;
            long r103 = this.f532693c;
            long r104 = this.f532694d;
            if (r101 == null) goto L6;
            String r105 = r101.getChannel();
            if (r105 == null) goto L6;
        L7:
            r100.put("channel", r105);
            r100.put("totalResources", r103);
            r100.put("loadedResources", r104);
            EventCenter.enqueueEvent(new Event(this.f532691a.f532686b + "_getGeckoUpdateProgress", System.currentTimeMillis(), new f66.d(r100)));
            return;
        L6:
            r105 = r102.f532686b;
            goto L7
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class d<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f532695a;

        public d(a r100) {
            this.f532695a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.f532695a.f532685a.a();
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onLocalNewestVersion(LocalPackageModel r100) {
        Task.call(new d(this), Task.UI_THREAD_EXECUTOR);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r100, Throwable r101) {
        super.onCheckServerVersionFail(r100, r101);
        Task.call(new CallableC7317a(this), Task.UI_THREAD_EXECUTOR);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r100, Map<String, List<UpdatePackage>> r101) {
        super.onCheckServerVersionSuccess(r100, r101);
        Task.call(new b(r101, this), Task.UI_THREAD_EXECUTOR);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateFailed(UpdatePackage r100, Throwable r101) {
        super.onUpdateFailed(r100, r101);
        Task.call(new qe7.b(this, r100, true, r101), Task.UI_THREAD_EXECUTOR);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateSuccess(UpdatePackage r100, long r101) {
        super.onUpdateSuccess(r100, r101);
        Task.call(new qe7.b(this, r100, false, null), Task.UI_THREAD_EXECUTOR);
    }

    public a(ee7.h r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "channel");
        Intrinsics.checkNotNullParameter(r102, "accessKey");
        this.f532685a = r100;
        this.f532686b = r101;
        this.f532687c = r102;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onDownloadProgress(UpdatePackage r100, long r110, long r111) {
        super.onDownloadProgress(r100, r110, r111);
        Task.call(new c(this, r100, r110, r111), Task.UI_THREAD_EXECUTOR);
    }
}
