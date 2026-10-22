package kqb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.service.f;
import com.ss.android.lark.location_ui.picklocation.LocationFragment;
import com.ss.android.lark.location_ui.picklocation.LocationView;
import com.ss.android.lark.location_ui.picklocation.p;
import com.ss.android.lark.location_ui.picklocation.q;
import com.ss.android.lark.ui.IActionTitlebar$TextAction;
import com.ss.android.lark.utils.UIHelper;
import iqb.n;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public abstract class b extends IActionTitlebar$TextAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f505662a;

    public b(String r100) {
        super(r100, R.color.location_position_send_disable_color);
        this.f505662a = 0;
    }

    @Override // com.ss.android.lark.ui.IActionTitlebar$BaseAction, com.ss.android.lark.ui.IActionTitlebar$Action
    public final void performAction(View r100) {
        long r101 = SystemClock.uptimeMillis();
        if ((r101 - this.f505662a) <= 1000) goto L37;
        p r102 = (p) this;
        KeyboardUtils.hideKeyboard(r102.f431275b.f431222b);
        iqb.a r103 = r102.f431275b.f431232l;
        if (r103 == null) goto L15;
        List<POIInfo> r104 = r103.f495408b;
        if (r104 == null) goto L15;
        Iterator<POIInfo> r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L15;
        POIInfo r106 = r105.next();
        if (r106.getIsCurrent() == false) goto L11;
    L16:
        if (r106 == null) goto L32;
        r102.f431275b.f431234n.getVendor();
        r106.setVendor("gaode");
        r106.setZoomLevel(r102.f431275b.f431234n.getZoomLevel());
        if (TextUtils.isEmpty(r106.getLocationAddress()) == false) goto L21;
        r106.setLocationAddress(r106.getLocationName());
    L21:
        if (r102.f431275b.f431227g.isSnapshot() == false) goto L31;
        LocationView r107 = r102.f431275b;
        r107.getClass();
        if (d.a() == true) goto L25;
    L27:
        boolean r108 = false;
    L28:
        if (r108 == false) goto L30;
        int r109 = UIHelper.dp2px(100.0f);
        int r110 = UIHelper.getColor(R.color.bg_base);
        Bitmap r111 = Bitmap.createBitmap(r109, r109, Bitmap.Config.RGB_565);
        new Canvas(r111).drawColor(r110);
        r107.f431231k.J3(r107.f431222b, r111, new q(r107, r106));
        goto L32
    L30:
        r107.f431234n.n(new n(r107, r106));
        goto L32
    L25:
        if (f.a().isGmsEnabled() == true) goto L27;
        r108 = true;
        goto L28
    L31:
        ((LocationFragment.a) r102.f431275b.f431253a).a(r106);
    L32:
        this.f505662a = r101;
        return;
    L15:
        r106 = null;
        goto L16
    }
}
