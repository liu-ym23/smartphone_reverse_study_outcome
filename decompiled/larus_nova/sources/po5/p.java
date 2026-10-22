package po5;

import com.bytedance.ee.bear.tts.TtsLoadScene;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class p implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f530080b = null;

    static {
        f530080b = new p();
    }

    public p() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r100, Map r101) {
        if (r100 != null) goto L6;
        tt5.a.k("TtsRemoveItemCommand", "handleAction, albumVM is null.");
        return false;
    L6:
        Object r102 = r101.get("token");
        mo5.g r103 = null;
        if ((r102 instanceof String) == false) goto L9;
        String r104 = (String) r102;
    L10:
        if (r104 != null) goto L13;
        tt5.a.k("TtsRemoveItemCommand", "handleAction, passedToken is null.");
        return false;
    L13:
        mo5.g r105 = r100.q(r104);
        if (r105 != null) goto L17;
        tt5.a.k("TtsRemoveItemCommand", "handleAction, passedToken not found in album: " + du5.b.i(r104));
        return false;
    L17:
        mo5.g r106 = mo5.h.e(r100);
        if (r106 == null) goto L20;
        String r107 = r106.a();
    L21:
        boolean r108 = Intrinsics.areEqual(r107, r105.a());
        if (r108 == false) goto L28;
        mo5.g r109 = mo5.h.e(r100);
        if (r109 == null) goto L28;
        mo5.g r110 = r100.d(r109);
        if (r110 == null) goto L28;
        r103 = r100.h(r110);
    L28:
        tt5.a.h("TtsRemoveItemCommand", "handleAction, targetVM: " + r105 + ", isSelecting: " + r108 + ", nextItem: " + r103);
        r100.p(r105);
        if (r103 != null) goto L37;
        tt5.a.h("TtsRemoveItemCommand", "handleAction, nextItem not found, select first item.");
        List<mo5.g> r111 = mo5.h.d(r100);
        if (r111 == null) goto L40;
        mo5.g r112 = (mo5.g) CollectionsKt.firstOrNull(r111);
        if (r112 == null) goto L41;
        mo5.g r113 = r100.h(r112);
        if (r113 == null) goto L42;
        r113.h(TtsLoadScene.SWITCH_ITEM, new n(r100));
        return true;
    L42:
        return true;
    L41:
        return true;
    L40:
        return true;
    L37:
        tt5.a.h("TtsRemoveItemCommand", "handleAction, select next item: " + r103);
        r103.p(TtsLoadScene.SWITCH_ITEM, new o(r100));
        return true;
    L20:
        r107 = null;
        goto L21
    L9:
        r104 = null;
        goto L10
    }
}
