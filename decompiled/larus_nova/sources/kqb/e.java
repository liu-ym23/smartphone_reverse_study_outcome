package kqb;

import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.storage.LarkKVStorage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f505663a = 0;

    static {
    }

    public static com.ss.android.lark.storage.kv.repo.a a() {
        return LarkKVStorage.q(new com.ss.android.lark.storage.a("location_message"), true);
    }

    public static void b(@LocationHitPoint$ResultType String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        a().putString("result_type", r100);
    }
}
