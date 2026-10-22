package na8;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class k extends o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<Integer> f518475f = null;

    public static final class a {
    }

    static {
        f518475f = SetsKt.setOf(new Integer[]{0, 3, 4, 5});
    }

    public k() {
        super("biz.forms.audioStartRecord", "biz.forms.onFrameRecorded");
    }

    @Override // na8.o
    public final boolean f(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return f518475f.contains(Integer.valueOf(r100.optInt("state", -1)));
    }
}
