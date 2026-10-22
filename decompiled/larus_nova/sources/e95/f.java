package e95;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
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

/* JADX INFO: loaded from: classes16.dex */
public final class f<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f471501a;

    public f(b r100) {
        this.f471501a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final ArchiveTree call() {
        b r100 = this.f471501a;
        String r101 = z75.b.a(r100.f471490a.f225836d, r100.f471491b.f2278b);
        this.f471501a.f471492c = Archive.isEncrypted(r101);
        List<ArchiveEntry> r102 = Archive.getFileList(r101);
        StringBuilder r103 = new StringBuilder("load() fileList size=");
        if (r102 == null) goto L5;
        int r104 = r102.size();
    L6:
        r103.append(r104);
        tt5.a.h("ArchiveTreeDataLoader", r103.toString());
        if (r102 != null) goto L9;
        r102 = CollectionsKt.emptyList();
    L9:
        a r105 = new a(r102);
        ArchiveTree r106 = new ArchiveTree();
        r106.setName(".");
        r106.setFileType(0);
        r106.setChildren(new ArrayList());
        r106.setPath("");
        Iterator<ArchiveEntry> r107 = r105.f471489a.iterator();
    L11:
        if (r107.hasNext() == false) goto L41;
        ArchiveEntry r108 = r107.next();
        String r109 = r108.getPath();
        if (r109 != null) goto L15;
        String r110 = "";
    L16:
        List r111 = StringsKt.split$default(r110, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        Iterator r112 = r111.iterator();
        ArchiveTree r113 = r106;
        int r114 = 0;
    L18:
        if (r112.hasNext() == false) goto L11;
        Object r115 = r112.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        String r117 = (String) r115;
        ArchiveTree r118 = new ArchiveTree();
        r118.setName(r117);
        if (r114 == (r111.size() - 1)) goto L25;
        r118.setFileType(0);
    L32:
        r118.setParent(r113);
        if (r118.getFileType() != 0) goto L35;
        r118.setPath(r118.getParent().getPath() + r117 + '/');
    L37:
        if (r113.getChildren().contains(r118) == true) goto L39;
        r113.getChildren().add(r118);
        r113 = r118;
    L40:
        r114 = r116;
        goto L18
    L39:
        Object r119 = ListProtector.get(r113.getChildren(), r113.getChildren().indexOf(r118));
        Intrinsics.checkNotNull(r119);
        r113 = (ArchiveTree) r119;
        goto L40
    L35:
        r118.setPath(r118.getParent().getPath() + r117);
        goto L37
    L25:
        if (r117.length() != 0) goto L27;
        boolean r120 = true;
    L28:
        if (r120 == true) goto L40;
        r118.setFileType(!r108.isFolder() ? 1 : 0);
        r118.setSize(r108.getSize());
        goto L32
    L27:
        r120 = false;
        goto L28
    L15:
        r110 = r109;
        goto L16
    L41:
        return r106;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
