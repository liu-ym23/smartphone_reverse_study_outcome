package x25;

import com.bytedance.apm.util.n;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockType;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f562250a;

    public f(int r100) {
        this.f562250a = new AtomicInteger(r100);
    }

    public final boolean a(SubBlockType r100) {
        if (r100 != SubBlockType.IMAGE_DATA) goto L6;
    L14:
        int r101 = 1;
    L15:
        int r102 = Integer.valueOf(r101).intValue();
        if (r102 != (this.f562250a.get() & r102)) goto L18;
        boolean r103 = true;
    L20:
        return !r103;
    L18:
        r103 = false;
        goto L20
    L6:
        if (r100 != SubBlockType.POLL_DATA) goto L9;
        r101 = 4;
        goto L15
    L9:
        if (r100 != SubBlockType.COMMENTS_DATA) goto L12;
        r101 = 16;
        goto L15
    L12:
        if (r100 != SubBlockType.INNER_SHEET) goto L14;
        r101 = 64;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(SubBlockType r100) {
        if (r100 != SubBlockType.IMAGE_DATA) goto L6;
        n r101 = new n(2, 3);
    L15:
        int r102 = ((Integer) r101.f190676a).intValue();
        int r103 = ((Integer) r101.f190677b).intValue();
        if (r102 != (this.f562250a.get() & r102)) goto L18;
        boolean r104 = true;
    L20:
        if (r103 != (this.f562250a.get() & r103)) goto L22;
        boolean r105 = true;
    L23:
        if (r104 == true) goto L28;
        if (r105 == true) goto L29;
        return false;
    L29:
        return true;
    L28:
        return true;
    L22:
        r105 = false;
        goto L23
    L18:
        r104 = false;
        goto L20
    L6:
        if (r100 != SubBlockType.POLL_DATA) goto L9;
        r101 = new n(8, 12);
        goto L15
    L9:
        if (r100 != SubBlockType.COMMENTS_DATA) goto L12;
        r101 = new n(32, 48);
        goto L15
    L12:
        if (r100 != SubBlockType.INNER_SHEET) goto L14;
        r101 = new n(128, 192);
        goto L15
    L14:
        r101 = new n(2, 3);
        goto L15
    }

    public final void c(int r100) {
        AtomicInteger r101 = this.f562250a;
        r101.set(r100 | r101.get());
    }
}
