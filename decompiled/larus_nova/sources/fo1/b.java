package fo1;

import am2.w;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.room.l;
import com.bytedance.android.live.room.y;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends com.bytedance.android.livesdk.chatroom.ui.framework.base.a {
    public wh1.a A;
    public final PropertyOwner<Boolean> B;
    public boolean C;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public l f478069s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.bytedance.android.livesdk.room.b f478070t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f478071u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f478072v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<is2.f> f478073w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Runnable f478074x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f478075y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f478076z;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f478077a;

        public a(b r100) {
            this.f478077a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ILinkServiceExternal r100 = (ILinkServiceExternal) k.f(ILinkServiceExternal.class);     // Catch: Throwable -> L9
            if (r100 == null) goto L5;
            r100.updateLiveMode(this.f478077a.f112898i);     // Catch: Throwable -> L9
        L5:
            ILinkServiceExternal r101 = (ILinkServiceExternal) k.f(ILinkServiceExternal.class);     // Catch: Throwable -> L9
            if (r101 == null) goto L12;
            r101.updatePortrait(this.f478077a.f112890a);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public final void g() {
        DataCenter r100 = b();
        r100.put("data_room", c());
        r100.put("data_room_id", Long.valueOf(c().f162599id));
        r100.put("data_is_portrait", Boolean.valueOf(this.f112890a));
        r100.put("data_live_mode", this.f112898i);
        r100.put("data_user_center", ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h());
        o r101 = u.l().c(n0.class);
        if (r101 == null) goto L8;
        Map<String, String> r102 = r101.getMap();
        if (r102 == null) goto L8;
        String r103 = r102.get("source");
        if (r103 == null) goto L8;
    L9:
        r100.put("data_enter_source", r103);
        Boolean r104 = Boolean.FALSE;
        r100.put("data_is_anchor", r104);
        d().getRoom().setValue(c());
        d().isUsingEnterRoom().setValue(Boolean.valueOf(this.f478072v));
        d().isAnchor().d(r104);
        int r105 = y.f100451a;
        DataCenter r106 = b();
        com.bytedance.android.livesdk.room.b r107 = this.f478070t;
        if (r107 == null) goto L12;
        CompositeDisposable r108 = r107.f157617z;
    L13:
        y.a(r106, r108, "AudienceInteractionContext#prepareGlobalData", new a(this));
        return;
    L12:
        r108 = null;
    L8:
        r103 = "";
        goto L9
    }

    public b(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100, true);
        this.f478072v = true;
        this.f478073w = new ArrayList();
        this.B = new PropertyOwner(Boolean.FALSE);
    }

    public static final void f(b r100, LiveMode r101) {
        r100.getClass();
        LiveMode r102 = LiveMode.MEDIA;
        if (r101 != r102) goto L8;
        o r103 = u.l().c(w.class);
        if (r103 == null) goto L9;
        r103.setData(new w(r102, "1"));
        return;
    L9:
        return;
    }
}
