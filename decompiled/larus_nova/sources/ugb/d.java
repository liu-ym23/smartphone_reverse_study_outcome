package ugb;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.tag.TagData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {
    public static final boolean a(Chat r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        TagData r101 = r100.getTagData();
        if (r101 == null) goto L21;
        TagData.Companion.getClass();
        Iterator r102 = ((ArrayList) TagData.a.b(r101)).iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (g08.b.a(((g08.a) r103).f479500b) == false) goto L6;
    L11:
        g08.a r104 = (g08.a) r103;
        if (r104 != null) goto L15;
        return false;
    L15:
        if (r104.f479500b != 1) goto L22;
        return true;
    L22:
        return false;
    L10:
        r103 = null;
        goto L11
    L21:
        return false;
    }
}
