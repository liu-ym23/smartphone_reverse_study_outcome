package e95;

import com.bytedance.ee.bear.drive.view.preview.archive.ArchiveTree;
import com.bytedance.ee.bear.libarchive.Archive;
import com.bytedance.ee.bear.libarchive.ArchiveEntry;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f<V> implements Callable {
    public final /* synthetic */ b a;

    public f(b r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public final ArchiveTree call() {
        b r0 = this.a;
        String r1 = z75.b.a(r0.a.d, r0.b.b);
        this.a.c = Archive.isEncrypted(r1);
        List<ArchiveEntry> r2 = Archive.getFileList(r1);
        StringBuilder r3 = new StringBuilder("load() fileList size=");
        if (r2 == null) goto L5;
        int r4 = r2.size();
    L6:
        r3.append(r4);
        tt5.a.h("ArchiveTreeDataLoader", r3.toString());
        if (r2 != null) goto L9;
        r2 = CollectionsKt.emptyList();
    L9:
        a r5 = new a(r2);
        ArchiveTree r6 = new ArchiveTree();
        r6.setName(".");
        r6.setFileType(0);
        r6.setChildren(new ArrayList());
        r6.setPath("");
        Iterator<ArchiveEntry> r7 = r5.a.iterator();
    L11:
        if (r7.hasNext() == false) goto L41;
        ArchiveEntry r8 = r7.next();
        String r9 = r8.getPath();
        if (r9 != null) goto L15;
        String r10 = "";
    L16:
        List r11 = StringsKt.split$default(r10, new String[]{"/"}, false, 0, 6, null);
        Iterator r12 = r11.iterator();
        ArchiveTree r13 = r6;
        int r14 = 0;
    L18:
        if (r12.hasNext() == false) goto L11;
        Object r16 = r12.next();
        int r17 = r14 + 1;
        if (r14 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        String r18 = (String) r16;
        ArchiveTree r19 = new ArchiveTree();
        r19.setName(r18);
        if (r14 == (r11.size() - 1)) goto L25;
        r19.setFileType(0);
    L32:
        r19.setParent(r13);
        if (r19.getFileType() != 0) goto L35;
        r19.setPath(r19.getParent().getPath() + r18 + '/');
    L37:
        if (r13.getChildren().contains(r19) == true) goto L39;
        r13.getChildren().add(r19);
        r13 = r19;
    L40:
        r14 = r17;
        goto L18
    L39:
        Object r20 = ListProtector.get(r13.getChildren(), r13.getChildren().indexOf(r19));
        Intrinsics.checkNotNull(r20);
        r13 = (ArchiveTree) r20;
        goto L40
    L35:
        r19.setPath(r19.getParent().getPath() + r18);
        goto L37
    L25:
        if (r18.length() != 0) goto L27;
        boolean r21 = true;
    L28:
        if (r21 == true) goto L40;
        r19.setFileType(!r8.isFolder() ? 1 : 0);
        r19.setSize(r8.getSize());
        goto L32
    L27:
        r21 = false;
        goto L28
    L15:
        r10 = r9;
        goto L16
    L41:
        return r6;
    L5:
        r4 = 0;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
