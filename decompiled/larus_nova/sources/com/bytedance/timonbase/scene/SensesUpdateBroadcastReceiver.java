package com.bytedance.timonbase.scene;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.bytedance.timonbase.scene.lifecycle.ForegroundState;
import com.bytedance.timonbase.utils.TMThreadUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sh7.e;
import sh7.f;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/timonbase/scene/SensesUpdateBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "timonbase_release"}, k = 1, mv = {1, 4, 0})
public final class SensesUpdateBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f270875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, sh7.d<? extends Object>> f270876b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f270877c = null;

    public static final class a {
        public a() {
        }

        public static void a(int r100, Object r101) {
            Intent r102 = new Intent("com.bytedance.timon.base.APP_SENSE_UPDATE_ACTION");
            Bundle r103 = new Bundle();
            if ((r101 instanceof Boolean) == false) goto L6;
            Boolean r104 = (Boolean) r101;
            r104.booleanValue();
            r103.putBoolean("sense_value", r104.booleanValue());
        L6:
            if ((r101 instanceof ForegroundState) == false) goto L8;
            boolean r105 = ((ForegroundState) r101).f270887b;
            r103.putParcelable("sense_value", (Parcelable) r101);
        L8:
            r102.putExtra("sense_type", r100);
            r102.putExtras(r103);
            Application r106 = SensesUpdateBroadcastReceiver.f270875a;
            if (r106 == null) goto L11;
            String r107 = r106.getPackageName();
        L12:
            r102.setPackage(r107);
            Application r108 = SensesUpdateBroadcastReceiver.f270875a;
            if (r108 == null) goto L16;
            r108.sendBroadcast(r102);
            return;
        L16:
            return;
        L11:
            r107 = null;
            goto L12
        }
    }

    static {
        f270877c = new a();
        f270876b = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, e.f541979b), TuplesKt.to(1, f.f541981b), TuplesKt.to(2, sh7.b.f541976b), TuplesKt.to(3, sh7.a.f541974b), TuplesKt.to(4, sh7.c.f541977a)});
    }

    public SensesUpdateBroadcastReceiver(Application r100) {
        f270875a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getAction();
    L7:
        if ((!Intrinsics.areEqual(r103, "com.bytedance.timon.base.APP_SENSE_UPDATE_ACTION")) == false) goto L9;
        return;
    L9:
        final int r104 = r101.getIntExtra("sense_type", -1);
        if (r104 != (-1)) goto L12;
        return;
    L12:
        Bundle r105 = r101.getExtras();
        if (r105 == null) goto L15;
        final Object r106 = r105.get("sense_value");
    L16:
        int r107 = com.bytedance.timonbase.b.f270799a;
        StringBuilder r108 = new StringBuilder("onReceive: ");
        sh7.d<? extends Object> r109 = f270876b.get(Integer.valueOf(r104));
        if (r109 == null) goto L19;
        r102 = r109.getClass().getSimpleName();
    L19:
        r108.append(r102);
        r108.append(':');
        r108.append(r106);
        r108.append(" pid:");
        r108.append(Process.myPid());
        com.bytedance.timonbase.b.a("SensesUpdateBroadcastRe", r108.toString());
        TMThreadUtils r110 = TMThreadUtils.f270906d;
        Function0<Unit> r111 = new AnonymousClass1(r104, r106);
        r110.getClass();
        TMThreadUtils.a(r111);
        return;
    L15:
        r106 = null;
        goto L16
    L5:
        r103 = null;
        goto L7
    }
}
