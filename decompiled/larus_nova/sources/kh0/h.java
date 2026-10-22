package kh0;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, kh0.a> f503430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f503431b;

    public static final class a implements kh0.a.InterfaceC6552a {
        public a() {
        }

        @Override // kh0.a.InterfaceC6552a
        public final boolean a() {
            return true;
        }
    }

    public final kh0.a a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "panelId");
        Object r101 = ((LinkedHashMap) this.f503430a).get(r100);
        if (r101 != null) goto L7;
        kh0.a r102 = new kh0.a(this.f503431b, new a(), r100, null);
        r102.d();
        return r102;
    L7:
        return (kh0.a) r101;
    }

    public h(boolean r100, com.bytedance.android.live.liveinteract.plantform.dynamicframe.e r101) {
        this.f503431b = r100;
        this.f503430a = new LinkedHashMap();
    }
}
