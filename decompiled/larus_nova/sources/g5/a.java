package g5;

import com.bytedance.ai.settings.b;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t5.g;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f480013a = 0;

    static {
    }

    public static boolean a(String r100) {
        com.bytedance.ai.settings.a<g> r101 = b.f37578e;
        List<String> r102 = r101.a().b();
        if (r102 != null) goto L6;
        r102 = CollectionsKt.emptyList();
    L6:
        if (r101.a().a() == true) goto L8;
    L20:
        return true;
    L8:
        if (r100 == null) goto L17;
        Iterator<String> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L17;
        String r104 = r103.next();
        if (StringsKt.endsWith$default(r100, r104, false, 2, null) == true) goto L16;
        if (Intrinsics.areEqual(r100, r104) == false) goto L11;
    L16:
        boolean r105 = true;
    L18:
        if (r105 == true) goto L20;
        return false;
    L17:
        r105 = false;
        goto L18
    }
}
