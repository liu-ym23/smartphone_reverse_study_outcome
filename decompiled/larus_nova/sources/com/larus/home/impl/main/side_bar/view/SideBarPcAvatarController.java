package com.larus.home.impl.main.side_bar.view;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.model.PcDeviceUiState;
import com.larus.bmhome.taskskill.service.TaskModeService;
import com.larus.nova.R;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public final class SideBarPcAvatarController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f344840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f344841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.bmhome.taskskill.service.d f344842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f344843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f344844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f344845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<PcDevice> f344846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IdentityHashMap<Object, Function0<Unit>> f344847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c2 f344848i;

    public static final class a {
    }

    static {
    }

    public final void b() {
        this.f344844e = true;
        bs8.e r100 = this.f344842c.b();
        if (r100 == null) goto L5;
        List<PcDevice> r101 = r100.a();
    L6:
        if (r101 != null) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        this.f344846g = r101;
        d();
        c();
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void c() {
        if (this.f344844e == true) goto L5;
    L12:
        e();
        return;
    L5:
        if (this.f344847h.isEmpty() == true) goto L12;
        if (this.f344845f == false) goto L10;
        return;
    L10:
        this.f344842c.f();
        this.f344842c.d().observe(this.f344840a, this.f344848i);
        this.f344845f = true;
        BuildersKt.launch$default(this.f344841b, null, null, new SideBarPcAvatarController$reconcileObservation$1(this, null), 3, null);
    }

    public final void d() {
        if (this.f344844e == true) goto L5;
        return;
    L5:
        Iterator r100 = CollectionsKt.toList(this.f344847h.values()).iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        ((Function0) r100.next()).invoke();
        goto L7
    }

    public final void e() {
        if (this.f344845f == true) goto L5;
        return;
    L5:
        this.f344842c.d().removeObserver(this.f344848i);
        this.f344842c.e();
        this.f344845f = false;
    }

    public final Integer a(wc9.e r100) {
        PcDeviceUiState r101 = null;
        if (this.f344843d.invoke().booleanValue() == false) goto L14;
        bs8.a.C0354a r102 = bs8.a.f20295h;
        if (r100 == null) goto L8;
        String r103 = r100.f559215r;
    L9:
        r102.getClass();
        bs8.a r104 = bs8.a.C0354a.a(r103);
        if (r104 == null) goto L14;
        if (r104.c() == false) goto L14;
    L15:
        if (r104 != null) goto L17;
        return null;
    L17:
        List<PcDevice> r105 = this.f344846g;
        String r106 = r104.f20300e;
        if (r106 == null) goto L20;
        String r107 = StringsKt.trim(r106).toString();
    L21:
        boolean r108 = true;
        if (r107 != null) goto L24;
    L27:
        boolean r109 = true;
    L28:
        if (r109 == true) goto L37;
        Iterator<T> r110 = r105.iterator();
    L31:
        if (r110.hasNext() == false) goto L35;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((PcDevice) r111).getDeviceId(), r107) == false) goto L31;
    L36:
        PcDevice r112 = (PcDevice) r111;
    L57:
        if (r112 == null) goto L60;
        r101 = bs8.g.b(r112);
    L60:
        if (r101 == PcDeviceUiState.AUTHORIZED_AVAILABLE) goto L63;
        r108 = false;
    L63:
        if (r108 == false) goto L66;
        return Integer.valueOf(R.drawable.larus_ic_remote_pc_online_avatar);
    L66:
        return Integer.valueOf(R.drawable.larus_ic_remote_pc_offline_avatar);
    L35:
        r111 = null;
        goto L36
    L37:
        String r113 = r104.f20296a;
        if (r113 != null) goto L40;
    L56:
        r112 = null;
        goto L57
    L40:
        if (r113.length() <= 0) goto L42;
        boolean r114 = true;
    L43:
        if (r114 == true) goto L46;
        r113 = null;
    L46:
        if (r113 == null) goto L56;
        Iterator<T> r115 = r105.iterator();
    L50:
        if (r115.hasNext() == false) goto L54;
        Object r116 = r115.next();
        if (Intrinsics.areEqual(((PcDevice) r116).d(), r113) == false) goto L50;
    L55:
        r112 = (PcDevice) r116;
        goto L57
    L54:
        r116 = null;
        goto L55
    L42:
        r114 = false;
        goto L43
    L24:
        if (r107.length() == 0) goto L27;
        r109 = false;
        goto L28
    L20:
        r107 = null;
        goto L21
    L8:
        r103 = null;
    L14:
        r104 = null;
        goto L15
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.larus.home.impl.main.side_bar.view.c2] */
    public SideBarPcAvatarController(LifecycleOwner r100, LifecycleCoroutineScope r101) {
        com.larus.bmhome.taskskill.service.d r102 = TaskModeService.f314424a.d();
        Function0<Boolean> r103 = new b2();
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "coroutineScope");
        Intrinsics.checkNotNullParameter(r102, "deviceProvider");
        Intrinsics.checkNotNullParameter(r103, "remoteControlEnabled");
        this.f344840a = r100;
        this.f344841b = r101;
        this.f344842c = r102;
        this.f344843d = r103;
        this.f344846g = CollectionsKt.emptyList();
        this.f344847h = new IdentityHashMap();
        this.f344848i = new c2(this);
    }
}
