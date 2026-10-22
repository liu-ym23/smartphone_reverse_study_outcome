package com.lynx.tasm.fluency;

import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<LynxContext> f383346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, com.lynx.tasm.fluency.b> f383347b;

    /* JADX INFO: renamed from: com.lynx.tasm.fluency.a$a, reason: collision with other inner class name */
    public static class C4572a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f383348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f383349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f383350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public LynxBooleanOption f383351d;

        public C4572a() {
            this.f383348a = "";
            this.f383349b = "";
            this.f383350c = -1.0d;
            this.f383351d = LynxBooleanOption.UNSET;
        }
    }

    public static class b implements com.lynx.tasm.fluency.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C4572a f383352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f383353b;

        public b(C4572a r100, int r101) {
            this.f383352a = r100;
            this.f383353b = r101;
        }
    }

    public a(LynxContext r100) {
        this.f383347b = new HashMap();
        this.f383346a = new WeakReference(r100);
    }
}
