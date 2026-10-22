package kg4;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.component.lyric.model.b;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f503371a = 0.0f;

    static {
        f503371a = s1.u();
    }

    public static final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$calcaulateLineDuration");
        int[] r101 = r100.f203034g;
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r103 >= r102) goto L8;
        r104 = r104 + r101[r103];
        r103 = r103 + 1;
        goto L6
    L8:
        r100.f203041n = Integer.valueOf(r104);
    }

    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        ALogger.i("lib-lyric", r100);
    }

    public static final <T> T c(List<? extends T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$safeGet");
        int r102 = r100.size();
        if (r101 < 0) goto L7;
        if (r102 <= r101) goto L7;
        return (T) ListProtector.get(r100, r101);
    L7:
        return null;
    }
}
