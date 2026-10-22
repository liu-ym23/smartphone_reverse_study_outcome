package po5;

import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p implements a {
    public static final p b = null;

    static {
        b = new p();
    }

    public p() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r6, Map r7) {
        if (r6 != null) goto L6;
        tt5.a.k("TtsRemoveItemCommand", "handleAction, albumVM is null.");
        return false;
    L6:
        Object r8 = r7.get(ResourceData.KEY_TOKEN);
        mo5.g r3 = null;
        if ((r8 instanceof String) == false) goto L9;
        String r9 = (String) r8;
    L10:
        if (r9 != null) goto L13;
        tt5.a.k("TtsRemoveItemCommand", "handleAction, passedToken is null.");
        return false;
    L13:
        mo5.g r2 = r6.q(r9);
        if (r2 != null) goto L17;
        tt5.a.k("TtsRemoveItemCommand", "handleAction, passedToken not found in album: " + du5.b.i(r9));
        return false;
    L17:
        mo5.g r10 = mo5.h.e(r6);
        if (r10 == null) goto L20;
        String r11 = r10.a();
    L21:
        boolean r12 = Intrinsics.areEqual(r11, r2.a());
        if (r12 == false) goto L28;
        mo5.g r0 = mo5.h.e(r6);
        if (r0 == null) goto L28;
        mo5.g r1 = r6.d(r0);
        if (r1 == null) goto L28;
        r3 = r6.h(r1);
    L28:
        tt5.a.h("TtsRemoveItemCommand", "handleAction, targetVM: " + r2 + ", isSelecting: " + r12 + ", nextItem: " + r3);
        r6.p(r2);
        if (r3 != null) goto L37;
        tt5.a.h("TtsRemoveItemCommand", "handleAction, nextItem not found, select first item.");
        List<mo5.g> r13 = mo5.h.d(r6);
        if (r13 == null) goto L40;
        mo5.g r14 = (mo5.g) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L41;
        mo5.g r15 = r6.h(r14);
        if (r15 == null) goto L42;
        r15.h(TtsLoadScene.SWITCH_ITEM, new n(r6));
        return true;
    L42:
        return true;
    L41:
        return true;
    L40:
        return true;
    L37:
        tt5.a.h("TtsRemoveItemCommand", "handleAction, select next item: " + r3);
        r3.p(TtsLoadScene.SWITCH_ITEM, new o(r6));
        return true;
    L20:
        r11 = null;
        goto L21
    L9:
        r9 = null;
        goto L10
    }
}
