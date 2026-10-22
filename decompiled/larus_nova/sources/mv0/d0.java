package mv0;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d0 implements l71.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f515820a = null;

    public d0() {
    }

    static {
        f515820a = new d0();
    }

    @Override // l71.g
    public final Map<String, String> a(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        int r101 = ju2.f.M;
        return ju2.f.a.a(r100).b();
    }
}
