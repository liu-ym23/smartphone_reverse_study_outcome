package x25;

import com.bytedance.apm.util.n;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockType;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final AtomicInteger a;

    public f(int r2) {
        this.a = new AtomicInteger(r2);
    }

    public final boolean a(SubBlockType r3) {
        if (r3 != SubBlockType.IMAGE_DATA) goto L6;
    L14:
        int r4 = 1;
    L15:
        int r5 = Integer.valueOf(r4).intValue();
        if (r5 != (this.a.get() & r5)) goto L18;
        boolean r6 = true;
    L20:
        return !r6;
    L18:
        r6 = false;
        goto L20
    L6:
        if (r3 != SubBlockType.POLL_DATA) goto L9;
        r4 = 4;
        goto L15
    L9:
        if (r3 != SubBlockType.COMMENTS_DATA) goto L12;
        r4 = 16;
        goto L15
    L12:
        if (r3 != SubBlockType.INNER_SHEET) goto L14;
        r4 = 64;
        goto L15
    }

    public final boolean b(SubBlockType r5) {
        if (r5 != SubBlockType.IMAGE_DATA) goto L6;
        n r6 = new n(2, 3);
    L15:
        int r0 = ((Integer) r6.a).intValue();
        int r7 = ((Integer) r6.b).intValue();
        if (r0 != (this.a.get() & r0)) goto L18;
        boolean r1 = true;
    L20:
        if (r7 != (this.a.get() & r7)) goto L22;
        boolean r8 = true;
    L23:
        if (r1 == true) goto L28;
        if (r8 == true) goto L29;
        return false;
    L29:
        return true;
    L28:
        return true;
    L22:
        r8 = false;
        goto L23
    L18:
        r1 = false;
        goto L20
    L6:
        if (r5 != SubBlockType.POLL_DATA) goto L9;
        r6 = new n(8, 12);
        goto L15
    L9:
        if (r5 != SubBlockType.COMMENTS_DATA) goto L12;
        r6 = new n(32, 48);
        goto L15
    L12:
        if (r5 != SubBlockType.INNER_SHEET) goto L14;
        r6 = new n(Integer.valueOf(Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE), 192);
        goto L15
    L14:
        r6 = new n(2, 3);
        goto L15
    }

    public final void c(int r3) {
        AtomicInteger r0 = this.a;
        r0.set(r3 | r0.get());
    }
}
