package gh0;

import com.bytedance.android.live.core.log.ALogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vm2.l;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f481244a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f481245b = null;

    static {
        f481244a = l.a();
        f481245b = CollectionsKt.mutableListOf(new String[]{"WindowListHelper"});
    }

    public static void a(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        Intrinsics.checkNotNullParameter(r101, "content");
        if (f481244a == true) goto L6;
        return;
    L6:
        if (r102 == false) goto L8;
        ALogger.e("LinkDebugLog", "subTag: " + r100 + " | content: " + r101);
        return;
    L8:
        ALogger.i("LinkDebugLog", "subTag: " + r100 + " | content: " + r101);
    }
}
