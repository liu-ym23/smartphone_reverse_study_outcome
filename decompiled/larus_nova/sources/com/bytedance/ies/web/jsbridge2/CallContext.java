package com.bytedance.ies.web.jsbridge2;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes19.dex */
public final class CallContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f249266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f249267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f249268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f249269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f249270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f249271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f249272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f249273h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m0 f249274i;

    public static final enum HostType extends Enum<HostType> {
        public static final HostType PRIVATE = null;
        public static final HostType PROTECTED = null;
        public static final HostType PUBLIC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HostType[] f249275a = null;

        static {
            HostType r100 = new HostType("PRIVATE", 0);
            PRIVATE = r100;
            HostType r101 = new HostType("PROTECTED", 1);
            PROTECTED = r101;
            HostType r102 = new HostType("PUBLIC", 2);
            PUBLIC = r102;
            f249275a = new HostType[]{r100, r101, r102};
        }

        public static HostType[] values() {
            return (HostType[]) f249275a.clone();
        }

        public static HostType valueOf(String r100) {
            return (HostType) r27.a.a(HostType.class, r100);
        }

        public HostType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String a() {
        String r100 = this.f249272g;
        if (r100 != null) goto L5;
        return "host";
    L5:
        if (r100.isEmpty() == false) goto L8;
        return "host";
    L8:
        return this.f249272g;
    }

    public CallContext() {
        this.f249270e = true;
        this.f249271f = false;
        this.f249273h = null;
        this.f249274i = new m0();
    }

    public Context getContext() {
        return this.f249266a;
    }

    public final <T> void b(String r100, T r101) {
        h r102 = this.f249273h;
        if (r102 == null) goto L5;
        r102.a(r100, r101);
        return;
    L5:
        k r103 = this.f249268c;
        if (r103 == null) goto L10;
        r103.f249380i.q(r100, r101);
        return;
    }
}
