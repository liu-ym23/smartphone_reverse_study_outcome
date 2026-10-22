package com.larus.setting.api;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;
import com.larus.setting.api.data.NotifySettingsItemId;
import com.larus.setting.api.data.NotifySettingsSectionId;
import com.larus.setting.api.data.SettingsItemAction;
import com.larus.utils.y;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class q implements aza.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<zs9.c> f367920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f367921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<List<zs9.c>, Unit> f367922c;

    @Override // aza.a
    public final void a(final pza.b r100) {
        Intrinsics.checkNotNullParameter(r100, "settings");
        int r101 = m.f367913a;
        List<zs9.c> r102 = this.f367920a;
        FragmentActivity r103 = this.f367921b;
        zs9.b r104 = new zs9.b();
        r104.f573490a = NotifySettingsItemId.HUMAN_CHAT.getValue();
        r104.f573491b = r100.f531142b;
        r104.f573493d = Integer.valueOf(r100.f531143c);
        r104.f573494e = Boolean.valueOf(r100.f531144d);
        r104.f573496g = SettingsItemAction.TOGGLE;
        r104.f573497h = new l(r100);
        String r105 = NotifySettingsSectionId.NOTIFY_TYPE.getValue();
        Iterator<T> r106 = r102.iterator();
    L3:
        String r107 = null;
        if (r106.hasNext() == false) goto L8;
        Object r108 = r106.next();
        if (Intrinsics.areEqual(((zs9.c) r108).f573498a, r105) == false) goto L3;
    L9:
        zs9.c r109 = (zs9.c) r108;
        if (r109 == null) goto L18;
        List r110 = CollectionsKt.listOf(r104);
        List<zs9.b> r111 = r109.f573500c;
        ArrayList r112 = new ArrayList();
        Iterator<T> r113 = r111.iterator();
    L13:
        if (r113.hasNext() == false) goto L17;
        Object r114 = r113.next();
        if (Intrinsics.areEqual(((zs9.b) r114).f573490a, r104.f573490a) == true) goto L13;
        r112.add(r114);
        goto L13
    L17:
        r109.a(CollectionsKt.plus(r110, r112));
    L22:
        SoftReference<Handler> r115 = y.f375498a;
        final Function1<List<zs9.c>, Unit> r116 = this.f367922c;
        final List<zs9.c> r117 = this.f367920a;
        y.c(new p(r116, r117));
        return;
    L18:
        zs9.c r118 = new zs9.c();
        r118.f573498a = r105;
        if (r103 == null) goto L21;
        r107 = r103.getString(R.string.larus_settings_notif_sectionTitle_notifType);
    L21:
        r118.f573499b = r107;
        r118.a(CollectionsKt.listOf(r104));
        r102.add(r118);
        goto L22
    L8:
        r108 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(List<zs9.c> r100, FragmentActivity r101, Function1<? super List<zs9.c>, Unit> r102) {
        this.f367920a = r100;
        this.f367921b = r101;
        this.f367922c = r102;
    }
}
