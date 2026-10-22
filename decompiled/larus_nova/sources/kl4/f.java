package kl4;

import com.bytedance.dora.link.spp.DoraSppLink;
import com.bytedance.dorax.kmp.callback.DoraXRetCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements k {
    public f() {
    }

    @Override // kl4.k
    public final void a(hl4.c r210, com.bytedance.dorax.kmp.b r211) {
        Intrinsics.checkNotNullParameter(r210, "event");
        List<? extends hl4.b> r100 = r210.f485676e;
        List<? extends hl4.b> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        DoraXRetCode r103 = null;
        if (r102 == true) goto L24;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r100.iterator();
        if (r105.hasNext() == true) goto L22;
        byte[] r106 = {(byte) 0};
        Iterator r107 = r104.iterator();
        int r108 = 0;
    L15:
        if (r107.hasNext() == false) goto L17;
        r108 = r108 + ((byte[]) r107.next()).length;
        goto L15
    L17:
        byte[] r109 = new byte[(r106.length + 1) + r108];
        r109[0] = (byte) (128 | r210.f485674c);
        ArraysKt.copyInto$default(r106, r109, 1, 0, 0, 12, null);
        int r110 = r106.length + 1;
        Iterator r111 = r104.iterator();
    L19:
        if (r111.hasNext() == false) goto L21;
        byte[] r112 = (byte[]) r111.next();
        ArraysKt.copyInto$default(r112, r109, r110, 0, 0, 12, null);
        r110 = r110 + r112.length;
        goto L19
    L21:
        byte[] r113 = r109;
    L34:
        int r114 = r210.f485672a;
        int r115 = r210.f485673b;
        int r116 = ll4.a.f509676a;
        ll4.a.b("AndroidTxChannel", "send event: " + Reflection.getOrCreateKotlinClass(r210.getClass()).getSimpleName() + ", sid: " + r114 + ", cid: " + r115 + ", timeout: 600 ms");
        DoraSppLink r117 = ak4.a.d().f4000a;
        r117.getClass();
        int r118 = r117.F(r114, r115, n.c(r114, r115, r113), 0, r113, (long) 600, "kmp");
        DoraXRetCode.Companion.getClass();
        Iterator<DoraXRetCode> r119 = DoraXRetCode.getEntries().iterator();
    L36:
        if (r119.hasNext() == false) goto L43;
        DoraXRetCode r120 = r119.next();
        if (r120.getCode() != r118) goto L40;
        boolean r121 = true;
    L41:
        if (r121 == false) goto L36;
        r103 = r120;
        goto L43
    L40:
        r121 = false;
    L43:
        DoraXRetCode r122 = r103;
        if (r122 != null) goto L46;
        r122 = DoraXRetCode.UnknowError;
    L46:
        int r123 = ll4.a.f509676a;
        ll4.a.b("AndroidTxChannel", "txSync result: " + r118 + ", mapped retCode: " + r122);
        r211.a(r122);
        return;
    L22:
        ((hl4.b) r105.next()).getClass();
        throw null;
    L24:
        byte[] r124 = r210.f485675d;
        if (r124 == null) goto L27;
        int r125 = r124.length;
    L28:
        if (r125 < 128) goto L30;
        byte[] r126 = {(byte) ((r125 / 128) | 128), (byte) (r125 % 128)};
    L31:
        if (r124 != null) goto L33;
        r124 = new byte[0];
    L33:
        r113 = new byte[(r126.length + 1) + r124.length];
        r113[0] = (byte) r210.f485674c;
        ArraysKt.copyInto$default(r126, r113, 1, 0, 0, 12, null);
        ArraysKt.copyInto$default(r124, r113, r126.length + 1, 0, 0, 12, null);
        goto L34
    L30:
        r126 = new byte[]{(byte) (r125 & 255)};
        goto L31
    L27:
        r125 = 0;
        goto L28
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}
