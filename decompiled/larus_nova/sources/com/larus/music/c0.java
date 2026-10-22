package com.larus.music;

import com.larus.platform.api.h4;
import com.larus.platform.api.i5;
import com.larus.platform.api.j5;
import com.larus.platform.api.p4;
import java.util.ArrayList;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class c0 implements n38.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j5 f359469a;

    public c0(j5 r100) {
        this.f359469a = r100;
    }

    @Override // n38.f
    public final void onResult(String r110, String r111, String r112) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L44;
        MusicAuthManager r101 = MusicAuthManager.f359456a;
        i5 r102 = this.f359469a.f365178h;
        if (r102 == null) goto L13;
        String r103 = r102.f365159h;
    L14:
        if (r103 != null) goto L16;
    L19:
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
        boolean r105 = true;
    L31:
        if (r105 == false) goto L44;
        i5 r106 = this.f359469a.f365178h;
        if (r106 == null) goto L36;
        ArrayList<String> r107 = r106.f365157f;
    L37:
        List r108 = MusicAuthManager.a(null, r107);
        i5 r109 = this.f359469a.f365178h;
        if (r109 == null) goto L42;
        p4 r113 = r109.f365156e;
        if (r113 == null) goto L42;
        p4 r114 = p4.a(r113, ar9.b.a(r108));
    L43:
        j5 r115 = this.f359469a;
        x r116 = new x(null, r115);
        ((h4) TuplesKt.to(new y(r114, r115, r116), r116).getSecond()).a(true, false);
        return;
    L42:
        r114 = null;
        goto L43
    L36:
        r107 = null;
        goto L37
    L22:
        if (r112 != null) goto L24;
    L27:
        boolean r117 = true;
    L28:
        if (r117 == false) goto L30;
        r105 = false;
        goto L31
    L30:
        r105 = StringsKt.split$default(r112, new String[]{","}, false, 0, 6, null).containsAll(StringsKt.split$default(r103, new String[]{","}, false, 0, 6, null));
        goto L31
    L24:
        if (StringsKt.isBlank(r112) == true) goto L27;
        r117 = false;
        goto L28
    L16:
        if (StringsKt.isBlank(r103) == true) goto L19;
        r104 = false;
        goto L20
    L13:
        r103 = null;
    L44:
        MusicAuthManager.f359456a.d(this.f359469a);
        return;
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r100 = false;
        goto L9
    }
}
