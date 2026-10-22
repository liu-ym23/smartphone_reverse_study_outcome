package s62;

import am2.x;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.k;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AICloneConvItem;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.s2;
import com.bytedance.android.livesdk.widget.TransparentCircleIconView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qb2.g;
import vlc.l;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements l, k22.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CompositeDisposable f540779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f540780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f540781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public yo2.e f540782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<AICloneConvItem> f540783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f540784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f540785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IRoom f540786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f540787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DataContext f540788j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DataCenter f540789k;

    /* JADX INFO: renamed from: s62.a$a, reason: collision with other inner class name */
    public static final class C7572a {
    }

    static {
    }

    @Override // k22.b
    public final AICloneConvItem a() {
        List<AICloneConvItem> r100 = this.f540783e;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (AICloneConvItem) CollectionsKt.firstOrNull(r100);
    }

    @Override // k22.b
    public final void c() {
        ALogger.i("AICloneTag", "unload manager,timestamp = " + System.currentTimeMillis());
        DataCenter r100 = this.f540789k;
        if (r100 == null) goto L5;
        vlc.d r101 = (vlc.d) r100.get("data_message_manager");
    L6:
        if (r101 == null) goto L8;
        r101.removeMessageListener(this);
    L8:
        d r102 = this.f540784f;
        if (r102 == null) goto L11;
        hd0.c.f().e(r102);
    L11:
        this.f540780b = false;
        this.f540781c = false;
        CompositeDisposable r103 = this.f540779a;
        if (r103 == null) goto L14;
        r103.clear();
    L14:
        yo2.e r104 = this.f540782d;
        if (r104 == null) goto L17;
        r104.d();
    L17:
        this.f540782d = null;
        this.f540779a = null;
        return;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean d() {
        ALogger.i("AICloneTag", "link state = " + ((Integer) hd0.c.f().f481009b));
        Boolean r100 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.c.f133632a;
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.c.a(this.f540786h) == true) goto L5;
    L17:
        return false;
    L5:
        if (a() == null) goto L17;
        Integer r101 = (Integer) hd0.c.f().f481009b;
        if (r101 != null) goto L10;
    L11:
        Integer r102 = (Integer) hd0.c.f().f481009b;
        if (r102 != null) goto L15;
        return true;
    L15:
        if (2 == r102.intValue()) goto L17;
        return true;
    L10:
        if (1 == r101.intValue()) goto L17;
        goto L11
    }

    public static String f(String r100) {
        String r101 = "";
        if (r100 != null) goto L5;
        return "";
    L5:
        JSONObject r102 = s2.a(Uri.decode(r100));
        o r103 = j0.l().c(x.class);
        if (r103 == null) goto L13;
        Map<String, String> r104 = r103.getMap();
        if (r104 == null) goto L13;
        String r105 = r104.get("enter_method");
        if (r105 == null) goto L13;
        r101 = r105;
    L13:
        r102.put(BdpAppEventConstant.PARAMS_LIVE_ENTER_METHOD, r101);
        return r102.toString();
    }

    public final void e(int r100) {
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.b.a(InteractivityMonitor.Event.AIBootMessageShowFailed, this.f540786h, Integer.valueOf(r100));
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof k) == false) goto L36;
        k r101 = (k) r100;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.b.b(InteractivityMonitor.Event.AIBootMessageReceive, this.f540786h);
        if (d() == true) goto L9;
        ALogger.i("AICloneTag", "receive one boot message but can't show");
        e(1);
        return;
    L9:
        if (this.f540780b == true) goto L11;
        e(2);
        ALogger.i("AICloneTag", "comment ai icon invisiable, can't show");
        return;
    L11:
        yo2.e r102 = this.f540782d;
        if (r102 == null) goto L17;
        if (r102.h() != true) goto L17;
        e(3);
        ALogger.i("AICloneTag", "a bubble is showing, can't show");
        return;
    L17:
        if (this.f540787i != null) goto L20;
        e(4);
        ALogger.i("AICloneTag", "ai view is null can't show");
        return;
    L20:
        if (this.f540781c == false) goto L22;
        e(5);
        ALogger.i("AICloneTag", "in clear screen, can't show");
        return;
    L22:
        View r103 = LayoutInflater.from(this.f540785g).inflate(R.layout.ttlive_comment_ai_guide_bubble, null);
        TransparentCircleIconView r104 = (TransparentCircleIconView) r103.findViewById(R.id.bubble_anchor_iv);
        m0 r105 = r101.getCommon();
        if (r105 == null) goto L29;
        IBaseUser r106 = r105.getUser();
        if (r106 == null) goto L29;
        py.k r107 = r106.getAvatarThumbKt();
        if (r107 == null) goto L29;
        ImageLoader.bindImage(r104, r107);
    L29:
        r103.setOnClickListener(new f(this, r101));
        TextView r108 = (TextView) r103.findViewById(R.id.tv_bubble_content);
        m0 r109 = r101.getCommon();
        if (r109 == null) goto L42;
        a5 r110 = r109.getDisplayText();
        if (r110 == null) goto L43;
        LiveRichContentEngine.a().a().c(mb2.d.a(r110, null, 1.0f), new g(false, 0.0f, 7), new e(this, r108, r103));
        return;
    L43:
        return;
    L42:
        return;
    }

    public a(DataContext r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "dataContext");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f540788j = r100;
        this.f540789k = r101;
    }

    @Override // k22.b
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
        if (r100 != null) goto L5;
    L38:
        List<AICloneConvItem> r102 = this.f540783e;
        if (r102 == null) goto L52;
        AICloneConvItem r103 = (AICloneConvItem) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L53;
        f2.c(r103.getErrToast(), 0);
        return;
    L53:
        return;
    L52:
        return;
    L5:
        if (d() == false) goto L38;
        ALogger.i("AICloneTag", "open schema, origin schema is ".concat(r100));
        Uri.Builder r104 = UriProtector.parse(r100).buildUpon();
        o r105 = j0.l().c(x.class);     // Catch: Throwable -> L27 Exception -> L29
        if (r105 == null) goto L14;
        Map<String, String> r106 = r105.getMap();     // Catch: Throwable -> L27 Exception -> L29
        if (r106 == null) goto L14;
        String r107 = r106.get("enter_from_merge");     // Catch: Throwable -> L27 Exception -> L29
        if (r107 == null) goto L14;
    L15:
        r104.appendQueryParameter("enter_from", r107).appendQueryParameter("enter_method", r101);     // Catch: Throwable -> L27 Exception -> L29
        Uri r108 = r104.build();     // Catch: Throwable -> L27 Exception -> L29
        Set<String> r109 = r108.getQueryParameterNames();     // Catch: Throwable -> L27 Exception -> L29
        Uri.Builder r110 = r108.buildUpon().clearQuery();     // Catch: Throwable -> L27 Exception -> L29
        Iterator<String> r111 = r109.iterator();     // Catch: Throwable -> L27 Exception -> L29
    L16:
        if (r111.hasNext() == false) goto L24;
        String r112 = r111.next();     // Catch: Throwable -> L27 Exception -> L29
        if (Intrinsics.areEqual(r112, "log_extra") == false) goto L21;
        String r113 = f(r108.getQueryParameter(r112));     // Catch: Throwable -> L27 Exception -> L29
    L22:
        r110.appendQueryParameter(r112, r113);     // Catch: Throwable -> L27 Exception -> L29
        goto L16
    L21:
        r113 = r108.getQueryParameter(r112);     // Catch: Throwable -> L27 Exception -> L29
        goto L22
    L24:
        String r114 = r110.build().toString();
        ALogger.i("AICloneTag", "final schema is " + r114);
        Context r115 = this.f540785g;
        if (r115 == null) goto L49;
    L33:
        ((IBaseLiveActionHandler) jc1.k.n(IBaseLiveActionHandler.class)).handle(r115, r114);
        return;
    L49:
        return;
    L14:
        r107 = "";
    L27:
        th = move-exception;
        String r116 = r104.build().toString();
        ALogger.i("AICloneTag", "final schema is " + r116);
        Context r117 = this.f540785g;
        if (r117 == null) goto L37;
        ((IBaseLiveActionHandler) jc1.k.n(IBaseLiveActionHandler.class)).handle(r117, r116);
    L37:
        throw th;
    L29:
        e = move-exception;
        SafetyGuard.a(null, e, "origin schema is " + r100);     // Catch: Throwable -> L27
        r114 = r104.build().toString();
        ALogger.i("AICloneTag", "final schema is " + r114);
        r115 = this.f540785g;
        if (r115 != null) goto L33;
    }
}
