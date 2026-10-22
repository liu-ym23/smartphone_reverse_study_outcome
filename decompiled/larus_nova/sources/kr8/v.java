package kr8;

import com.larus.utils.logger.FLogger;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f505894a = null;

    static {
        f505894a = new LinkedHashSet();
    }

    public static l a(p r100, String r101) {
        u r102 = u.f505893a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r101, "key");
        Set<String> r103 = f505894a;
        if (r103.contains(r101) == false) goto L5;
        boolean r104 = false;
    L6:
        FLogger.f375446a.i("MusicMobSendFilter", "[filterByCreationDimension] creationId=" + r101 + ", allow=" + r104);
        if (r104 == true) goto L11;
        return null;
    L11:
        return r100;
    L5:
        r103.add(r101);
        r104 = true;
        goto L6
    }
}
