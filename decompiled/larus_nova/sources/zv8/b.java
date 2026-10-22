package zv8;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f573742a;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.larus_debug_dialog_base);
        b r101 = this.f573742a.f573754c;
        if (r101 == null) goto L12;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L12;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        Resources r104 = r102.getContext().getResources();
        r103.width = (int) (((double) WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).widthPixels) * 0.9d);
        r102.setGravity(80);
        r102.setAttributes(r103);
        View r105 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r106 = ThreadMethodProxy.currentThread();
        if (r106 == com.larus.home.impl.utils.c.f346341a) goto L11;
        com.larus.home.impl.utils.c.a(r106, "getDecorView");
    L11:
        r105.setBackgroundResource(android.R.color.transparent);
    L12:
        final j r107 = this.f573742a;
        r107.getClass();
        final Activity r108 = AppHost.f326268a.a().getCurrentActivity();
        if (r108 == null) goto L74;
        b r109 = r107.f573754c;
        Integer r110 = null;
        if (r109 == null) goto L18;
        LinearLayout r111 = (LinearLayout) r109.findViewById(R.id.debug_dialog_real_container);
    L19:
        r107.f573755d = r111;
        b r112 = r107.f573754c;
        if (r112 == null) goto L22;
        Space r113 = (Space) r112.findViewById(R.id.debug_dialog_empty_view);
    L23:
        r107.f573756e = r113;
        b r114 = r107.f573754c;
        if (r114 == null) goto L26;
        TextView r115 = (TextView) r114.findViewById(R.id.debug_dialog_title);
    L27:
        r107.f573757f = r115;
        b r116 = r107.f573754c;
        if (r116 == null) goto L30;
        ViewStub r117 = (ViewStub) r116.findViewById(R.id.debug_dialog_content);
    L31:
        r107.f573758g = r117;
        b r118 = r107.f573754c;
        if (r118 == null) goto L34;
        TextView r119 = (TextView) r118.findViewById(R.id.debug_dialog_close);
    L35:
        r107.f573759h = r119;
        TextView r120 = r107.f573757f;
        if (r120 == null) goto L38;
        r120.setText(r107.c());
    L38:
        ViewStub r121 = r107.f573758g;
        if (r121 == null) goto L41;
        r121.setLayoutResource(r107.h());
    L41:
        Integer r122 = -1;
        if (r122.intValue() <= 0) goto L44;
        boolean r123 = true;
    L45:
        if (r123 == false) goto L47;
        r110 = r122;
    L47:
        if (r110 == null) goto L51;
        final int r124 = r110.intValue();
        ViewStub r125 = r107.f573758g;
        if (r125 == null) goto L51;
        r125.setOnInflateListener(new g(r108, r124));
    L51:
        ViewStub r126 = r107.f573758g;
        if (r126 == null) goto L54;
        r126.inflate();
    L54:
        Space r127 = r107.f573756e;
        if (r127 == null) goto L57;
        r127.setVisibility(0);
    L57:
        Space r128 = r107.f573756e;
        if (r128 == null) goto L60;
        r128.setClickable(true);
    L60:
        Space r129 = r107.f573756e;
        if (r129 == null) goto L63;
        r129.setEnabled(true);
    L63:
        Space r130 = r107.f573756e;
        if (r130 == null) goto L66;
        r130.setOnClickListener(new h(r107));
    L66:
        LinearLayout r131 = r107.f573755d;
        if (r131 == null) goto L69;
        r131.setBackgroundResource(R.drawable.larus_bg_border_develop_entrance_group);
    L69:
        TextView r132 = r107.f573759h;
        if (r132 == null) goto L73;
        r132.setOnClickListener(new i(r107));
        return;
    L73:
        return;
    L44:
        r123 = false;
        goto L45
    L34:
        r119 = null;
        goto L35
    L30:
        r117 = null;
        goto L31
    L26:
        r115 = null;
        goto L27
    L22:
        r113 = null;
        goto L23
    L18:
        r111 = null;
        goto L19
    }

    public b(Context r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dialogEntrance");
        super(r100);
        this.f573742a = r101;
    }
}
