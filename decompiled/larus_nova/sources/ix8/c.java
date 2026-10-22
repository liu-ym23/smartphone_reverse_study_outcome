package ix8;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.keva.KevaImpl;
import com.larus.camera.api.vlm.VLMIntentTrackSource;
import com.larus.camera.api.vlm.VLMSceneType;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f496386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VLMSceneType f496387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ix8.a f496388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f496389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VLMIntentTrackSource f496390e;

    public static final class a {
    }

    static {
    }

    public c() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f496386a, r101.f496386a) == true) goto L12;
        return false;
    L12:
        if (this.f496387b == r101.f496387b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f496388c, r101.f496388c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f496389d, r101.f496389d) == true) goto L21;
        return false;
    L21:
        if (this.f496390e == r101.f496390e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f496386a.hashCode() * 31) + this.f496387b.hashCode()) * 31) + this.f496388c.hashCode()) * 31) + this.f496389d.hashCode()) * 31;
        VLMIntentTrackSource r101 = this.f496390e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "VLMIntentDetectRequest(files=" + this.f496386a + ", sceneType=" + this.f496387b + ", config=" + this.f496388c + ", ext=" + this.f496389d + ", trackSource=" + this.f496390e + ')';
    }

    public /* synthetic */ c(List r110, VLMSceneType r111, ix8.a r112, VLMIntentTrackSource r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r110 = CollectionsKt.emptyList();
    L5:
        List r100 = r110;
        if ((r114 & 2) == 0) goto L8;
        r111 = VLMSceneType.TAKE_PICTURE;
    L8:
        VLMSceneType r101 = r111;
        if ((r114 & 4) == 0) goto L11;
        ix8.a r102 = new ix8.a(null, 0.0f, 0, false, false, 63);
    L13:
        if ((r114 & 8) == 0) goto L15;
        Map r103 = MapsKt.emptyMap();
    L17:
        if ((r114 & 16) == 0) goto L19;
        VLMIntentTrackSource r104 = null;
    L20:
        this(r100, r101, r102, r103, r104);
        return;
    L19:
        r104 = r113;
        goto L20
    L15:
        r103 = null;
        goto L17
    L11:
        r102 = r112;
        goto L13
    }

    public c(List<b> r100, VLMSceneType r101, ix8.a r102, Map<String, ? extends Object> r103, VLMIntentTrackSource r104) {
        Intrinsics.checkNotNullParameter(r100, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        Intrinsics.checkNotNullParameter(r101, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r103, "ext");
        this.f496386a = r100;
        this.f496387b = r101;
        this.f496388c = r102;
        this.f496389d = r103;
        this.f496390e = r104;
    }
}
