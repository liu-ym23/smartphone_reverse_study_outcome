package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g extends jc8.a implements gb8.g {
    @Override // jc8.a
    public final String g() {
        return "DeepThinkBlockBizModel";
    }

    @Override // jc8.a
    public final int l() {
        int r100 = com.larus.bmhome.chat.deepresearch.view.j.f302403a;
        return com.larus.bmhome.chat.deepresearch.view.j.A;
    }

    @Override // gb8.g
    public final boolean b(boolean r100) {
        if (com.larus.im.bean.message.a.f0(j()) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f498145a.isFinish() == true) goto L9;
        if (j().getMessageStatusLocal() == 23) goto L9;
        return true;
    }

    @Override // jc8.a
    public final boolean e(jc8.a r100) {
        if ((r100 instanceof g) == true) goto L5;
        return false;
    L5:
        Map<String, String> r101 = j().getExt();
        if (r101 == null) goto L8;
        String r102 = r101.get("need_lazy_load");
    L9:
        g r103 = (g) r100;
        Map<String, String> r104 = r103.j().getExt();
        if (r104 == null) goto L12;
        String r105 = r104.get("need_lazy_load");
    L14:
        if (Intrinsics.areEqual(r102, r105) == true) goto L17;
        return false;
    L17:
        if (this.f498145a.isFinish() == true) goto L19;
        return false;
    L19:
        List<jc8.a> r106 = i();
        List<jc8.a> r107 = r103.i();
        if (r106.size() == r107.size()) goto L22;
        return false;
    L22:
        int r108 = CollectionsKt.getLastIndex(r106);
    L23:
        boolean r109 = true;
        if ((-1) >= r108) goto L47;
        jc8.a r110 = (jc8.a) CollectionsKt.getOrNull(r107, r108);
        if (r110 == null) goto L32;
        Block r111 = r110.f498145a;
        if (r111 == null) goto L32;
        if (r111.isFinish() == true) goto L32;
    L33:
        if (r109 == true) goto L46;
        jc8.a r112 = (jc8.a) CollectionsKt.getOrNull(r106, r108);
        if (r112 == null) goto L37;
        Integer r113 = Integer.valueOf(r112.hashCode());
    L38:
        jc8.a r114 = (jc8.a) CollectionsKt.getOrNull(r107, r108);
        if (r114 == null) goto L41;
        Integer r115 = Integer.valueOf(r114.hashCode());
    L43:
        if (Intrinsics.areEqual(r113, r115) == false) goto L46;
        r108 = r108 - 1;
        goto L23
    L41:
        r115 = null;
        goto L43
    L37:
        r113 = null;
    L46:
        return false;
    L32:
        r109 = false;
        goto L33
    L47:
        return true;
    L12:
        r105 = null;
        goto L14
    L8:
        r102 = null;
        goto L9
    }

    public g(Message r100, Block r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "block");
        super(r100, r101);
    }
}
