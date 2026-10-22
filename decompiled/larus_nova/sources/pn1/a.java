package pn1;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.blockword.BlockWordApi;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockWordApi f529943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f529944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f529945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Integer, ef1.a> f529946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f529947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Room f529948f;

    /* JADX INFO: renamed from: pn1.a$a, reason: collision with other inner class name */
    public static final class C7213a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f529949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f529950b;

        public b(a r100, String r101) {
            this.f529949a = r100;
            this.f529950b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ef1.b r101 = (ef1.b) ((Response) r100).data;
            if (r101 == null) goto L8;
            Integer r102 = r101.a();
            if (r102 == null) goto L9;
            int r103 = r102.intValue();
            ef1.a r104 = new ef1.a(r103, this.f529950b);
            this.f529949a.f529946d.put(Integer.valueOf(r103), r104);
            this.f529949a.f529947e.e(r104);
            a r105 = this.f529949a;
            r105.f529947e.a(r105.f529946d.size(), this.f529949a.f529945c);
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f529951a;

        public c(a r100) {
            this.f529951a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            f r101 = this.f529951a.f529947e;
            r101.d((Throwable) r100);
        }
    }

    static {
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_SEARCH_WORD);
        Room r101 = this.f529948f;
        if (r101 == null) goto L9;
        String r102 = r101.getOwnerUserIdString();
        if (r102 == null) goto L10;
        String r103 = ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h().a(r102);
        long r104 = this.f529948f.f162599id;
        Disposable r105 = this.f529943a.addBlockWord(r100, r103, r104).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r100), new c(this));
        this.f529944b.add(r105);
        return;
    L10:
        return;
    }

    public a(f r100, Room r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f529947e = r100;
        this.f529948f = r101;
        l.d().getClass();
        this.f529943a = (BlockWordApi) com.bytedance.android.live.network.c.b().e(BlockWordApi.class);
        this.f529944b = new CompositeDisposable();
        this.f529945c = 10;
        this.f529946d = new HashMap();
    }
}
