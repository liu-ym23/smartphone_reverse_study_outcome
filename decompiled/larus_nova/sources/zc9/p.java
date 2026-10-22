package zc9;

import androidx.exifinterface.media.ExifInterface;
import com.larus.im.bean.message.block.FileSource;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import nuc.m2;

/* JADX INFO: loaded from: classes29.dex */
public final class p implements juc.d<FileSource> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f571278a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f571279b = null;

    public p() {
    }

    static {
        f571278a = new p();
        f571279b = luc.n.a(ExifInterface.TAG_FILE_SOURCE, luc.e.f.f510854a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f571279b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        String r101 = null;
        if ((r100 instanceof ouc.h) == false) goto L15;
        ouc.i r102 = ((ouc.h) r100).a();
        if ((r102 instanceof ouc.g0) == false) goto L7;
        ouc.g0 r103 = (ouc.g0) r102;
    L8:
        if (r103 == null) goto L14;
        Integer r104 = ouc.k.l(r103);
        if (r104 == null) goto L13;
        String r105 = r104.toString();
        if (r105 == null) goto L13;
    L16:
        if (r105 == null) goto L26;
        StringBuilder r106 = new StringBuilder();
        int r107 = r105.length();
        int r108 = 0;
    L18:
        if (r108 >= r107) goto L23;
        char r109 = r105.charAt(r108);
        if (Character.isLetterOrDigit(r109) == false) goto L22;
        r106.append(r109);
    L22:
        r108 = r108 + 1;
        goto L18
    L23:
        String r110 = r106.toString();
        if (r110 == null) goto L26;
        r101 = r110.toUpperCase(Locale.ROOT);
    L26:
        if (r101 == null) goto L60;
        int r111 = r101.hashCode();
        if (r111 == (-1564050230)) goto L56;
        if (r111 == 79) goto L53;
        if (r111 == 2547) goto L50;
        if (r111 == 365188760) goto L47;
        if (r111 == 48) goto L44;
        if (r111 != 49) goto L60;
        if (r101.equals("1") == false) goto L60;
    L65:
        return FileSource.FILE_SOURCE_PC;
    L44:
        if (r101.equals("0") == false) goto L60;
    L64:
        return FileSource.FILE_SOURCE_O;
    L47:
        if (r101.equals("FILESOURCEO") == true) goto L64;
    L50:
        if (r101.equals("PC") == true) goto L65;
    L53:
        if (r101.equals("O") == false) goto L60;
    L56:
        if (r101.equals("FILESOURCEPC") == true) goto L65;
    L60:
        return FileSource.UNKNOWN;
    L13:
        r105 = r103.a();
        goto L16
    L14:
        r105 = null;
        goto L16
    L7:
        r103 = null;
        goto L8
    L15:
        r105 = String.valueOf(r100.decodeInt());
        goto L16
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        FileSource r102 = (FileSource) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        if ((r100 instanceof ouc.u) == false) goto L5;
        ((ouc.u) r100).a(ouc.k.b(Integer.valueOf(r102.getValue())));
        return;
    L5:
        r100.encodeInt(r102.getValue());
    }
}
