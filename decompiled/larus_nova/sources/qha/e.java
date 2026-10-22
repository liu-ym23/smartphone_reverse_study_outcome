package qha;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.y0;
import com.obric.assistant.common.spi.IObricUIService;
import com.obric.assistant.impl.databinding.ObricItemCustomActionbarNormalHolderBinding;
import com.obric.assistant.view.actionbar.custom.ObricActionBarSegmentCell;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class e implements ss8.e, ss8.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1a.b f533024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f533025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f533026c;

    public static final class a {
    }

    static {
    }

    @Override // ss8.e
    public final boolean g() {
        return true;
    }

    public z0 j(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return r100;
    }

    public abstract String k();

    public abstract int m();

    public aq8.e n() {
        return null;
    }

    public com.larus.bmhome.actionbar.model.r o() {
        return null;
    }

    public abstract long p();

    public abstract int q();

    public abstract int r();

    @Override // ss8.f
    public List a() {
        return i();
    }

    public final List<z0> i() {
        String r100 = y0.k(UriProtector.parse("res://" + AppHost.f326268a.getApplication().getPackageName() + '/' + r()));
        long r101 = p();
        String r110 = k();
        Resources r102 = getContext().getResources();
        if (r102 == null) goto L5;
        String r103 = r102.getString(q());
    L6:
        int r111 = m();
        g1 r104 = new g1(null, r100, null, null, 29);
        g1 r105 = new g1(null, r100, null, null, 29);
        com.larus.bmhome.actionbar.model.r r210 = o();
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("KEY_FILE_OR_WEB_ADDRESS", l());
        return CollectionsKt.listOf(j(new z0(Long.valueOf(r101), r110, r104, r105, r103, null, Integer.valueOf(r111), null, null, null, r210, null, true, r106, null, 536805280, 13)));
    L5:
        r103 = null;
        goto L6
    }

    public final String toString() {
        return k();
    }

    public Context getContext() {
        return this.f533025b;
    }

    public String l() {
        return this.f533026c;
    }

    @Override // ss8.e
    public boolean h(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100.f295606b, k());
    }

    @Override // ss8.e
    public List b(BotModel r100, wc9.e r101) {
        Intrinsics.checkNotNullParameter(r100, "bot");
        Intrinsics.checkNotNullParameter(r101, "conversation");
        return i();
    }

    @Override // ss8.e
    public boolean d(z0 r100, z0 r101) {
        Intrinsics.checkNotNullParameter(r100, "old");
        Intrinsics.checkNotNullParameter(r101, TeaEventTrack.ACTION_DRAMA_NEXT);
        return false;
    }

    public e(t1a.b r100, Context r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "vContext");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "address");
        this.f533024a = r100;
        this.f533025b = r101;
        this.f533026c = r102;
    }

    @Override // ss8.e
    public void e(BaseActionBarHolder r100, z0 r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof ObricActionBarSegmentCell) == false) goto L5;
        ObricActionBarSegmentCell r103 = (ObricActionBarSegmentCell) r100;
    L6:
        if (r103 == null) goto L18;
        String r104 = r101.f295609e;
        String r105 = "";
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        g1 r106 = r101.f295607c;
        if (r106 == null) goto L16;
        String r107 = r106.f295156b;
        if (r107 == null) goto L16;
        r105 = r107;
    L16:
        r103.U3(r104, r105, r101, r102);
        return;
    L18:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // ss8.e
    public BaseActionBarHolder f(ViewGroup r100, t1 r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "defaultClickCallback");
        ObricItemCustomActionbarNormalHolderBinding r103 = ObricItemCustomActionbarNormalHolderBinding.a(LayoutInflater.from(r100.getContext()), r100);
        IObricUIService r104 = (IObricUIService) ServiceManager.get().getService(IObricUIService.class);
        if (r104 == null) goto L5;
        r104.na(new TextView[]{r103.f389596d, r103.f389597e});
    L5:
        Intrinsics.checkNotNullParameter(r103, "binding");
        Intrinsics.checkNotNullParameter(r101, "defaultClickCallback");
        return new ObricActionBarSegmentCell(r103, r101, r102, n());
    }
}
