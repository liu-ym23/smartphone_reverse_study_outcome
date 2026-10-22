package kotlin.io;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002¢\u0006\u0002\b\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", RootDescription.ROOT_ELEMENT, "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FilePathComponentsKt {
    public FilesKt__FilePathComponentsKt() {
    }

    public static final File getRoot(File r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new File(getRootName(r100));
    }

    private static final int getRootLength$FilesKt__FilePathComponentsKt(String r100) {
        int r101 = StringsKt.indexOf$default(r100, File.separatorChar, 0, false, 4, null);
        if (r101 != 0) goto L18;
        if (r100.length() <= 1) goto L16;
        char r102 = r100.charAt(1);
        char r103 = File.separatorChar;
        if (r102 != r103) goto L16;
        int r104 = StringsKt.indexOf$default(r100, r103, 2, false, 4, null);
        if (r104 < 0) goto L16;
        int r105 = StringsKt.indexOf$default(r100, File.separatorChar, r104 + 1, false, 4, null);
        if (r105 < 0) goto L15;
        return r105 + 1;
    L15:
        return r100.length();
    L16:
        return 1;
    L18:
        if (r101 <= 0) goto L24;
        if (r100.charAt(r101 - 1) != ':') goto L24;
        return r101 + 1;
    L24:
        if (r101 == (-1)) goto L26;
    L29:
        return 0;
    L26:
        if (StringsKt.endsWith$default(r100, ':', false, 2, null) == false) goto L29;
        return r100.length();
    }

    public static final String getRootName(File r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getPath().substring(0, getRootLength$FilesKt__FilePathComponentsKt(r100.getPath()));
    }

    public static final boolean isRooted(File r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (getRootLength$FilesKt__FilePathComponentsKt(r100.getPath()) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final FilePathComponents toComponents(File r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getPath();
        Intrinsics.checkNotNull(r101);
        int r102 = getRootLength$FilesKt__FilePathComponentsKt(r101);
        String r103 = r101.substring(0, r102);
        String r104 = r101.substring(r102);
        if (r104.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        List r106 = CollectionsKt.emptyList();
    L14:
        return new FilePathComponents(new File(r103), r106);
    L8:
        List r107 = StringsKt.split$default(r104, new char[]{File.separatorChar}, false, 0, 6, null);
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = r107.iterator();
    L10:
        if (r109.hasNext() == false) goto L12;
        r108.add(new File((String) r109.next()));
        goto L10
    L12:
        r106 = r108;
        goto L14
    L5:
        r105 = false;
        goto L6
    }

    public static final File subPath(File r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return toComponents(r100).subPath(r101, r102);
    }
}
