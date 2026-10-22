package k78;

import com.f.android.quality.impl.Scene;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f502054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f68.a f502056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Scene f502057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f502058e;

    public final void b(Map<String, ? extends Object> r100) {
        boolean r101 = true;
        if (this.f502054a.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f502058e = true;
        f68.a r103 = this.f502056c;
        if (r103 == null) goto L26;
        Scene r104 = this.f502057d;
        if (r104 == null) goto L27;
        Map<String, Object> r105 = r103.a();
        if (r105 == null) goto L23;
        Map<String, ? extends Object> r106 = MapsKt.toMutableMap(r105);
        if (r106 == null) goto L23;
        if (r100 != null) goto L18;
    L21:
        if (r101 == true) goto L24;
        r106.putAll(r100);
    L24:
        r104.f274069a.b();
        r104.b("fh_dev_scene_start", r106, null);
        r104.f274073e = false;
        return;
    L18:
        if (r100.isEmpty() == true) goto L21;
        r101 = false;
    L23:
        r106 = null;
        goto L24
    L27:
        return;
    L26:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void c(Map<String, ? extends Object> r100) {
        boolean r101 = true;
        if (this.f502054a.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        if (this.f502058e == false) goto L31;
        this.f502058e = false;
        f68.a r103 = this.f502056c;
        if (r103 == null) goto L29;
        Scene r104 = this.f502057d;
        if (r104 == null) goto L30;
        Map<String, Object> r105 = r103.a();
        if (r105 == null) goto L25;
        Map<String, ? extends Object> r106 = MapsKt.toMutableMap(r105);
        if (r106 == null) goto L25;
        if (r100 != null) goto L20;
    L23:
        if (r101 == true) goto L26;
        r106.putAll(r100);
    L26:
        r104.h(r106, 0);
        return;
    L20:
        if (r100.isEmpty() == true) goto L23;
        r101 = false;
    L25:
        r106 = null;
        goto L26
    L30:
        return;
    L29:
        return;
    L31:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r102 = false;
        if (this.f502054a.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        Scene r104 = this.f502057d;
        if (r104 == null) goto L26;
        f68.a r105 = this.f502056c;
        if (r105 == null) goto L23;
        Map<String, Object> r106 = r105.a();
        if (r106 == null) goto L23;
        Map<String, ? extends Object> r107 = MapsKt.toMutableMap(r106);
        if (r107 == null) goto L23;
        if (r101 != null) goto L18;
    L19:
        r102 = true;
    L20:
        if (r102 == true) goto L22;
        r107.putAll(r101);
    L22:
        Unit r108 = Unit.INSTANCE;
    L24:
        r104.c(r100, r107);
        return;
    L18:
        if (r101.isEmpty() == false) goto L20;
    L23:
        r107 = null;
        goto L24
    L26:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void d(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        boolean r102 = false;
        if (this.f502054a.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        Scene r104 = this.f502057d;
        if (r104 == null) goto L26;
        f68.a r105 = this.f502056c;
        if (r105 == null) goto L23;
        Map<String, Object> r106 = r105.a();
        if (r106 == null) goto L23;
        Map<String, ? extends Object> r107 = MapsKt.toMutableMap(r106);
        if (r107 == null) goto L23;
        if (r101 != null) goto L18;
    L19:
        r102 = true;
    L20:
        if (r102 == true) goto L22;
        r107.putAll(r101);
    L22:
        Unit r108 = Unit.INSTANCE;
    L24:
        r104.g(r100, null, r107);
        return;
    L18:
        if (r101.isEmpty() == false) goto L20;
    L23:
        r107 = null;
        goto L24
    L26:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void e(String r110, Map<String, ? extends Object> r111) {
        Intrinsics.checkNotNullParameter(r110, "step");
        boolean r100 = false;
        if (this.f502054a.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        Scene r102 = this.f502057d;
        if (r102 == null) goto L26;
        f68.a r103 = this.f502056c;
        if (r103 == null) goto L23;
        Map<String, Object> r104 = r103.a();
        if (r104 == null) goto L23;
        Map<String, ? extends Object> r105 = MapsKt.toMutableMap(r104);
        if (r105 == null) goto L23;
        if (r111 != null) goto L18;
    L19:
        r100 = true;
    L20:
        if (r100 == true) goto L22;
        r105.putAll(r111);
    L22:
        Unit r112 = Unit.INSTANCE;
        Map<String, ? extends Object> r106 = r105;
    L24:
        r102.f(r110, null, true, null, null, r106);
        return;
    L18:
        if (r111.isEmpty() == false) goto L20;
    L23:
        r106 = null;
        goto L24
    L26:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public c(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "mTaskId");
        Intrinsics.checkNotNullParameter(r101, "mSpeaker");
        Intrinsics.checkNotNullParameter(r102, "mModelName");
        Intrinsics.checkNotNullParameter(r104, "botId");
        this.f502054a = r100;
        this.f502055b = r103;
        this.f502056c = new f68.a(r100, r101, r102, r104);
        int r105 = qt7.a.f534816a;
        Map r106 = MapsKt.emptyMap();
        int r107 = Scene.f274068i;
        List r108 = CollectionsKt.emptyList();
        Scene r109 = new Scene("TTS_V2", "TTS_SAMI_V2");
        r109.f274070b.addAll(r108);
        ((ConcurrentHashMap) r109.f274072d).putAll(r106);
        this.f502057d = r109;
    }
}
