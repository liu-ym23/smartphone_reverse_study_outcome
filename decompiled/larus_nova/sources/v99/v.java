package v99;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.larus.settings.value.e10;
import com.larus.settings.value.zb;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class v implements fya.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f553866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f553867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w99.a f553868c;

    @Override // fya.a
    public final void y5() {
    }

    @Override // fya.a
    public final x x5() {
        return new x();
    }

    @Override // fya.a
    public final boolean y3() {
        w99.a r100 = this.f553868c;
        if (r100 == null) goto L5;
        boolean r101 = r100.y3();
    L6:
        FLogger.f375446a.i("FlowVoiceInputExtensionFactory", "[start] isVoiceInputMode " + r101 + ' ');
        return r101;
    L5:
        r101 = false;
        goto L6
    }

    @Override // fya.a
    public final boolean z5() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        return ((Boolean) l0.a(Boolean.FALSE, new zb())).booleanValue();
    }

    public v(w99.a r100) {
        this.f553868c = r100;
    }

    @Override // fya.a
    public final View.OnTouchListener D0(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        w99.a r101 = this.f553868c;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.D0(r100);
    }

    @Override // fya.a
    public final void v5(boolean r100) {
        FLogger.f375446a.i("FlowVoiceInputExtensionFactory", "[start] setVoiceInputMode " + r100 + ' ');
        w99.a r101 = this.f553868c;
        if (r101 == null) goto L6;
        r101.v5(r100);
        return;
    }

    @Override // fya.a
    public final void w5(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        View r101 = r100.getView();
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r101;
    L5:
        ViewGroup r103 = this.f553867b;
        if (r103 == null) goto L8;
        r103.removeAllViews();
    L8:
        FLogger.f375446a.i("FlowVoiceInputExtensionFactory", "[stop] cleanup completed");
    }

    @Override // fya.a
    public final void A5(ViewGroup r100, Fragment r101, ViewGroup r102, fya.a.b r103, final fya.a.c r104) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r104, "callback");
        FLogger.f375446a.i("FlowVoiceInputExtensionFactory", "[start] with compat flow container with adapter " + this.f553868c + ' ');
        this.f553867b = r102;
        this.f553866a = r100;
        w99.a r105 = this.f553868c;
        ConstraintLayout r106 = null;
        if (r105 == null) goto L5;
        ConstraintLayout r107 = r105.GI();
    L6:
        if (r105 == null) goto L8;
        r106 = r105.cz();
    L8:
        if (r107 == null) goto L20;
        if (r106 == null) goto L22;
        if (r100 == null) goto L13;
        r100.addView(r106);
    L13:
        r105.db(r103);
        r105.gg(r104);
        if (r102 == null) goto L21;
        r107.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Context r108 = r107.getContext();
        if (r108 == null) goto L23;
        r107.setBackgroundColor(ContextCompat.getColor(r108, R.color.flow_ud_bg_base_3));
        r107.setPadding(0, 0, 0, 0);
        r107.setTag(r107.getTag());
        r107.setOnClickListener(new u(r104));
        r102.addView(r107);
        return;
    L23:
        return;
    L21:
        return;
    L22:
        return;
    L20:
        return;
    L5:
        r107 = null;
        goto L6
    }
}
