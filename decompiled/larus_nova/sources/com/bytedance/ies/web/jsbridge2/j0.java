package com.bytedance.ies.web.jsbridge2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes19.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f249367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f249368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0 f249369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PermissionConfig f249370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f249371e;

    public final synchronized PermissionGroup a(String r100, d r101, List<TimeLineEvent> r102) throws PermissionConfig.IllegalRemoteConfigException {
        monitor-enter(this);
    L46:
        th = move-exception;
        throw th;
    L4:
        if (this.f249370d != null) goto L8;
        TimeLineEvent.b r103 = new TimeLineEvent.b();     // Catch: Throwable -> L46
        r103.b("call_permission_group", "null");     // Catch: Throwable -> L46
        r103.b("config", "null");     // Catch: Throwable -> L46
        r103.a("label_permission_checker_null_config", r102);     // Catch: Throwable -> L46
        monitor-exit(this);
        return null;
    L8:
        boolean r104 = false;
        if (this.f249369c == null) goto L20;
        d0.d r105 = d0.f249340k;     // Catch: Throwable -> L46
        if (r105.a() == null) goto L15;
        d0.e r106 = r105.a();     // Catch: Throwable -> L46
        SwitchConfigEnum r107 = SwitchConfigEnum.XSS_CALLBACK_ID_SWITCH;     // Catch: Throwable -> L46
        if (r106.f() == false) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L20;
        TimeLineEvent.b r109 = new TimeLineEvent.b();     // Catch: Throwable -> L46
        r109.b("config_repository_fetched", "false");     // Catch: Throwable -> L46
        r109.a("label_permission_checker_fetch", r102);     // Catch: Throwable -> L46
        throw new PermissionConfig.IllegalRemoteConfigException("Permission configuration has not been fetched");     // Catch: Throwable -> L46
    L15:
        r108 = false;
    L20:
        PermissionConfig.b r110 = this.f249370d.a(r100, r102);     // Catch: Throwable -> L46
        if (r110.f249282a == r101.getPermissionGroup()) goto L23;
    L28:
        Set<String> r111 = r110.f249284c;     // Catch: Throwable -> L46
        HashSet r112 = (HashSet) r111;     // Catch: Throwable -> L46
        if (r112.contains(r101.getName()) == false) goto L32;
        monitor-exit(this);
        return null;
    L32:
        Set<String> r113 = r110.f249283b;     // Catch: Throwable -> L46
        HashSet r114 = (HashSet) r113;     // Catch: Throwable -> L46
        if (r114.contains(r101.getName()) == false) goto L38;
        PermissionGroup r115 = PermissionGroup.PRIVATE;     // Catch: Throwable -> L46
        monitor-exit(this);
        return r115;
    L38:
        if (r110.f249282a.compareTo(r101.getPermissionGroup()) >= 0) goto L40;
        r104 = true;
    L40:
        if (r104 == false) goto L43;
        monitor-exit(this);
        return null;
    L43:
        PermissionGroup r116 = r110.f249282a;     // Catch: Throwable -> L46
        monitor-exit(this);
        return r116;
    L23:
        if (r110.f249282a != PermissionGroup.SECURE) goto L28;
        Set<String> r117 = r110.f249283b;     // Catch: Throwable -> L46
        HashSet r118 = (HashSet) r117;     // Catch: Throwable -> L46
        if (r118.contains(r101.getName()) == true) goto L28;
        monitor-exit(this);
        return null;
    }

    public j0(PermissionConfig r100, Set<String> r101, Set<String> r102, boolean r103) {
        this.f249369c = d0.f249337h.a();
        this.f249370d = r100;
        this.f249367a = new LinkedHashSet(r101);
        this.f249368b = new LinkedHashSet(r102);
        this.f249371e = r103;
    }
}
