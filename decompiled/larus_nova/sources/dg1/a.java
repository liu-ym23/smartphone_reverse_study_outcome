package dg1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.broadcast.v2.component.comp.AbsShellWidget;
import com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.sdk.account.platform.api.IVKService;
import hs1.b;
import hs1.e;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f468367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WidgetManager f468368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, WeakReference<Widget>> f468369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f468370d;

    @Override // hs1.e
    public final void onCreate() {
        ALogger.d("BroadcastShellComponentSystem", IVKService.ResponseConstants.CREATED);
        WidgetManager r100 = WidgetManager.of(this.f468370d.f105456m, null);
        this.f468368b = r100;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L5:
        DataCenter r101 = this.f468367a;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("_dataCenter");
    L8:
        r100.setDataCenter(r101);
    }

    @Override // hs1.e
    public final void onDestroy() {
        ALogger.i("BroadcastShellComponentSystem", LiveCommonConstants.REASON_ON_DEDTROY);
        Iterator<Map.Entry<String, WeakReference<Widget>>> r100 = this.f468369c.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Widget r101 = r100.next().getValue().get();
        if (r101 == null) goto L4;
        r101.onDestroy();
        goto L4
    L8:
        this.f468369c.clear();
    }

    public a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f468370d = r100;
        this.f468369c = new HashMap();
    }

    public final void a(b r100) {
        Widget r101 = (Widget) r100.f486943a.f486945b.newInstance();
        if ((r101 instanceof AbsShellWidget) == false) goto L5;
        ((AbsShellWidget) r101).f105405a = this.f468370d;
    L5:
        ALogger.i("BroadcastShellComponentSystem", "load component " + r100.f486943a.f486944a);
        Integer r102 = r100.a().f495585a;
        if (r102 == null) goto L8;
        int r103 = r102.intValue();
    L10:
        if (r103 <= 0) goto L15;
        WidgetManager r104 = this.f468368b;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L14:
        r104.load(r103, r101, true);
    L19:
        this.f468369c.put(r100.f486943a.f486944a, new WeakReference(r101));
        return;
    L15:
        WidgetManager r105 = this.f468368b;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L18:
        r105.load(r101, false);
        goto L19
    L8:
        r103 = -1;
        goto L10
    }
}
