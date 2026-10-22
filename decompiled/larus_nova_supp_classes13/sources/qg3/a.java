package qg3;

import android.content.Context;
import com.bytedance.android.shopping.prepurchase.arch.atom_event.ECCheckLoginActionAtomEvent;
import com.bytedance.android.shopping.prepurchase.arch.atom_event.ECCountdownActionAtomEvent;
import com.bytedance.android.shopping.prepurchase.arch.atom_event.ECLegalVerificationActionAtomEvent;
import com.bytedance.android.shopping.prepurchase.arch.atom_event.b;
import com.bytedance.android.shopping.prepurchase.arch.atom_event.d;
import com.bytedance.android.shopping.prepurchase.arch.atom_event.e;
import com.bytedance.android.shopping.prepurchase.arch.atom_event.f;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.bytedance.kmp.ec.yata.common.init.c;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final EventChain a(Context r1, String r2, com.bytedance.kmp.ec.yata.chain.core.a r3, c r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "bizCode");
        Intrinsics.checkNotNullParameter(r3, "serviceProvider");
        Intrinsics.checkNotNullParameter(r4, "switchConfig");
        EventChain r0 = new EventChain(r2, r3, r4);
        Iterator r5 = CollectionsKt.listOf(new t96.a[]{new com.bytedance.android.shopping.prepurchase.arch.atom_event.a(), new ECLegalVerificationActionAtomEvent(r1), new f(), new b(), new ECCheckLoginActionAtomEvent(r1), new e(r1), new ECCountdownActionAtomEvent(), new d(r1)}).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.g((t96.a) r5.next());
        goto L4
    L6:
        return r0;
    }
}
