package hd9;

import com.larus.im.internal.database.entity.MessageEntity;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nuc.a1;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f484620a = null;

    static {
        f484620a = new c();
    }

    public c() {
    }

    @Override // hd9.m
    public final Map<String, String> a(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        String r101 = r100.getExt();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return null;
    L12:
        wt7.c r103 = wt7.a.f561230a;
        String r104 = r100.getExt();
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        kuc.a.f(r105);
        v2 r106 = v2.f520790a;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        a1 r107 = kuc.a.c(r106, r106);
        r103.getClass();
        return (Map) wt7.c.a(r104, r107);
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
