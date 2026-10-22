package ip8;

import com.larus.bmhome.video.Content;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f495312a = null;

    static {
        f495312a = LazyKt.lazy(new c());
    }

    public static final boolean a(Content r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return !CollectionsKt.contains((List) f495312a.getValue(), r100.getItemType());
    }
}
