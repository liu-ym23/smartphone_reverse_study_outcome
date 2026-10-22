package l11;

import com.bytedance.android.scope.o;
import java.util.Map;
import k11.f;
import k11.g;
import k11.k;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements g, f, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k11.c f506953a;

    public c() {
    }

    @Override // k11.g
    public final void loadLinker(long r100, long r101, boolean r102, k r103) {
        Intrinsics.checkNotNullParameter(r103, "logInfo");
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // k11.g
    public final void unloadLinker(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
    }

    @Override // k11.f
    public final k11.c a() {
        return this.f506953a;
    }

    @Override // k11.g
    public final void updateLinkInfo(Map<String, String> r100, long r101, Map<String, String> r102) {
        if (r101 != 0) goto L7;
        this.f506953a = null;
        return;
    L7:
        if (r100 == null) goto L9;
        Map r103 = MapsKt.toMap(r100);
    L10:
        if (r102 == null) goto L12;
        Map r104 = MapsKt.toMap(r102);
    L13:
        this.f506953a = new k11.c(r103, r101, r104);
        StringBuilder r105 = new StringBuilder("updateLinkInfo ");
        k11.c r106 = this.f506953a;
        if (r106 == null) goto L16;
        Map<String, String> r107 = r106.f501350a;
    L17:
        r105.append(r107);
        jy0.b.c("LoadLinkerService", r105.toString(), null, 4);
        return;
    L16:
        r107 = null;
        goto L17
    L12:
        r104 = null;
        goto L13
    L9:
        r103 = null;
        goto L10
    }
}
