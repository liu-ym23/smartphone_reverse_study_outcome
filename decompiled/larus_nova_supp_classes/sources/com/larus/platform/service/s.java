package com.larus.platform.service;

import com.larus.platform.api.t1;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class s implements t1 {
    public static final s a = null;
    public static final Lazy b = null;

    public s() {
    }

    static {
        a = new s();
        b = LazyKt.lazy(new r());
    }

    public static t1 i() {
        return (t1) b.getValue();
    }

    @Override // com.larus.platform.api.t1
    public final boolean a() {
        t1 r0 = i();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    @Override // com.larus.platform.api.t1
    public final boolean b() {
        t1 r0 = i();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b();
    }

    @Override // com.larus.platform.api.t1
    public final boolean c() {
        t1 r0 = i();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.c();
    }

    @Override // com.larus.platform.api.t1
    public final String d() {
        t1 r0 = i();
        if (r0 == null) goto L6;
        String r1 = r0.d();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "release_version";
    }

    @Override // com.larus.platform.api.t1
    public final boolean e() {
        t1 r0 = i();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.e();
    }

    @Override // com.larus.platform.api.t1
    public final boolean f() {
        t1 r0 = i();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.f();
    }

    @Override // com.larus.platform.api.t1
    public final boolean g() {
        t1 r0 = i();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.g();
    }

    @Override // com.larus.platform.api.t1
    public final String getBuildChannel() {
        t1 r0 = i();
        if (r0 == null) goto L6;
        String r1 = r0.getBuildChannel();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.t1
    public final boolean h() {
        t1 r0 = i();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.h();
    }
}
