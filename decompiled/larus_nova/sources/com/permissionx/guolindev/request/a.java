package com.permissionx.guolindev.request;

import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.permission.api.IPermissionX;
import com.larus.permission.impl.IPermissionXImpl;
import com.larus.permission.impl.view.ExplainRequestDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f404364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f404365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f404366c;

    @Override // com.permissionx.guolindev.request.b
    public final void finish() {
        a r100 = this.f404365b;
        if (r100 == null) goto L5;
        r100.request();
        Unit r101 = Unit.INSTANCE;
    L6:
        if (r101 != null) goto L147;
        ArrayList r102 = new ArrayList();
        r102.addAll(this.f404364a.f404385i);
        r102.addAll(this.f404364a.f404386j);
        r102.addAll(this.f404364a.f404383g);
        if (this.f404364a.f404381e.contains("android.permission.ACCESS_BACKGROUND_LOCATION") == false) goto L14;
        if (moa.b.a(this.f404364a.getActivity(), "android.permission.ACCESS_BACKGROUND_LOCATION") == false) goto L12;
        this.f404364a.f404384h.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        goto L14
    L12:
        r102.add("android.permission.ACCESS_BACKGROUND_LOCATION");
    L14:
        if (this.f404364a.f404381e.contains("android.permission.SYSTEM_ALERT_WINDOW") == false) goto L24;
        if (Build.VERSION.SDK_INT < 23) goto L24;
        if (this.f404364a.c() < 23) goto L24;
        if (Settings.canDrawOverlays(this.f404364a.getActivity()) == false) goto L22;
        this.f404364a.f404384h.add("android.permission.SYSTEM_ALERT_WINDOW");
        goto L24
    L22:
        r102.add("android.permission.SYSTEM_ALERT_WINDOW");
    L24:
        if (this.f404364a.f404381e.contains("android.permission.WRITE_SETTINGS") == false) goto L34;
        if (Build.VERSION.SDK_INT < 23) goto L34;
        if (this.f404364a.c() < 23) goto L34;
        if (Settings.System.canWrite(this.f404364a.getActivity()) == false) goto L32;
        this.f404364a.f404384h.add("android.permission.WRITE_SETTINGS");
        goto L34
    L32:
        r102.add("android.permission.WRITE_SETTINGS");
    L34:
        if (this.f404364a.f404381e.contains("android.permission.MANAGE_EXTERNAL_STORAGE") == false) goto L42;
        if (Build.VERSION.SDK_INT >= 30) goto L38;
    L40:
        r102.add("android.permission.MANAGE_EXTERNAL_STORAGE");
        goto L42
    L38:
        if (Environment.isExternalStorageManager() == false) goto L40;
        this.f404364a.f404384h.add("android.permission.MANAGE_EXTERNAL_STORAGE");
    L42:
        if (this.f404364a.f404381e.contains("android.permission.REQUEST_INSTALL_PACKAGES") == false) goto L53;
        if (Build.VERSION.SDK_INT >= 26) goto L46;
    L51:
        r102.add("android.permission.REQUEST_INSTALL_PACKAGES");
        goto L53
    L46:
        if (this.f404364a.c() < 26) goto L51;
        if (this.f404364a.getActivity().getPackageManager().canRequestPackageInstalls() == false) goto L50;
        this.f404364a.f404384h.add("android.permission.REQUEST_INSTALL_PACKAGES");
        goto L53
    L50:
        r102.add("android.permission.REQUEST_INSTALL_PACKAGES");
    L53:
        if (this.f404364a.f404381e.contains("android.permission.POST_NOTIFICATIONS") == false) goto L59;
        if (NotificationManagerCompat.from(this.f404364a.getActivity()).areNotificationsEnabled() == false) goto L57;
        this.f404364a.f404384h.add("android.permission.POST_NOTIFICATIONS");
        goto L59
    L57:
        r102.add("android.permission.POST_NOTIFICATIONS");
    L59:
        if (this.f404364a.f404381e.contains("android.permission.BODY_SENSORS_BACKGROUND") == true) goto L61;
    L64:
        noa.b r103 = this.f404364a.f404389m;
        if (r103 == null) goto L114;
        Intrinsics.checkNotNull(r103);
        boolean r104 = r102.isEmpty();
        ArrayList r105 = new ArrayList(this.f404364a.f404384h);
        hp9.g r106 = (hp9.g) r103;
        Function3 r107 = r106.f486481a;
        IPermissionX.c r108 = r106.f486482b;
        Ref.BooleanRef r109 = r106.f486483c;
        List r110 = r106.f486484d;
        Ref.ObjectRef r111 = r106.f486485e;
        FragmentManager r112 = r106.f486486f;
        int r113 = IPermissionXImpl.f363965d;
        Intrinsics.checkNotNullParameter(r105, "grantedList");
        Intrinsics.checkNotNullParameter(r102, "deniedList");
        if (r104 == true) goto L69;
    L92:
        if (r107 == null) goto L94;
        r107.invoke(Boolean.FALSE, r105, r102);
    L94:
        if (r108 == null) goto L96;
        r108.onResult(false, r105, r102, r109.element);
    L96:
        Iterator r114 = r110.iterator();
    L98:
        if (r114.hasNext() == false) goto L114;
        String r115 = (String) r114.next();
        if (r111.element == 0) goto L98;
        if (r109.element == true) goto L98;
        if (r112 == null) goto L105;
        Fragment r116 = r112.findFragmentByTag(r115);
    L106:
        ExplainRequestDialog r117 = (ExplainRequestDialog) r116;
        if (r117 == null) goto L98;
        r117.dismiss();     // Catch: Exception -> L110
    L110:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r118 = DialogFragmentLancet.sLastShowStack;
        if (r118 == null) goto L98;
        com.bytedance.crash.d.d(r118, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L98
    L105:
        r116 = null;
        goto L106
    L69:
        if ((!r105.isEmpty()) == false) goto L92;
        if (r107 == null) goto L72;
        r107.invoke(Boolean.TRUE, r105, r102);
    L72:
        if (r108 == null) goto L74;
        r108.onResult(true, r105, r102, r109.element);
    L74:
        Iterator r119 = r110.iterator();
    L76:
        if (r119.hasNext() == false) goto L114;
        String r120 = (String) r119.next();
        if (r111.element == 0) goto L76;
        if (r109.element == true) goto L76;
        if (r112 == null) goto L83;
        Fragment r121 = r112.findFragmentByTag(r120);
    L84:
        ExplainRequestDialog r122 = (ExplainRequestDialog) r121;
        if (r122 == null) goto L76;
        r122.dismiss();     // Catch: Exception -> L88
    L88:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r123 = DialogFragmentLancet.sLastShowStack;
        if (r123 == null) goto L76;
        com.bytedance.crash.d.d(r123, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L76
    L83:
        r121 = null;
    L114:
        o r124 = this.f404364a;
        Fragment r125 = r124.a().findFragmentByTag("InvisibleFragment");
        if (r125 == null) goto L118;
        r124.a().beginTransaction().remove(r125).commitNowAllowingStateLoss();
    L118:
        if (Build.VERSION.SDK_INT == 26) goto L148;
        r124.getActivity().setRequestedOrientation(r124.f404379c);
        return;
    L148:
        return;
    L61:
        if (moa.b.a(this.f404364a.getActivity(), "android.permission.BODY_SENSORS_BACKGROUND") == false) goto L63;
        this.f404364a.f404384h.add("android.permission.BODY_SENSORS_BACKGROUND");
        goto L64
    L63:
        r102.add("android.permission.BODY_SENSORS_BACKGROUND");
        goto L64
    L147:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.permissionx.guolindev.request.b
    public final d a() {
        return this.f404366c;
    }

    public a(o r100) {
        Intrinsics.checkNotNullParameter(r100, "pb");
        this.f404364a = r100;
        new c(r100, this);
        this.f404366c = new d(r100, this);
        new c(r100, this);
        this.f404366c = new d(r100, this);
    }
}
