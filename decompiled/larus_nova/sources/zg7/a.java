package zg7;

import com.bytedance.timon.permission.storage.TimonMedia;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f572099a = null;

    static {
        f572099a = new a();
    }

    public a() {
    }

    public final void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Objects.toString(r100);
    }

    public final void b(boolean r100, TimonMedia.ExtraInfo r101) {
        Intrinsics.checkNotNullParameter(r101, "info");
        a(MapsKt.mapOf(new Pair[]{TuplesKt.to("id", String.valueOf(r101.f270648j)), TuplesKt.to("jumped", String.valueOf(r100))}));
    }
}
