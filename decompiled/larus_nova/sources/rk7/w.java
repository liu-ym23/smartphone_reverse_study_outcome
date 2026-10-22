package rk7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f538401b;

    public final boolean a() {
        String r100 = this.f538400a;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L20;
        String r102 = this.f538401b;
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == true) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (StringsKt.isBlank(r102) == true) goto L16;
        r103 = false;
        goto L17
    L20:
        return false;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public w(String r110) {
        if (r110 == null) goto L13;
        List r111 = StringsKt.split$default(r110, new char[]{'.'}, false, 0, 6, null);
        if (r111 != null) goto L7;
        return;
    L7:
        if (r111.size() != 2) goto L10;
        this.f538400a = (String) ListProtector.get(r111, 0);
        this.f538401b = (String) ListProtector.get(r111, 1);
        return;
    L10:
        if (r111.size() != 3) goto L16;
        this.f538400a = ((String) ListProtector.get(r111, 0)) + '.' + ((String) ListProtector.get(r111, 1));
        this.f538401b = String.valueOf(ListProtector.get(r111, 2));
        return;
    L16:
        return;
    }
}
