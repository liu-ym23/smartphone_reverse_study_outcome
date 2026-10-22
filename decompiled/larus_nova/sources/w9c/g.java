package w9c;

import com.ss.android.lark.pb.ug_reach.TextElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f558797a = 0;

    static {
    }

    public static String a(TextElement r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "textElement");
        boolean r101 = false;
        if (r100.mtype != TextElement.TextType.PLAIN) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        Intrinsics.checkNotNullParameter(r100, "textElement");
        if (r100.mtype != TextElement.TextType.HTML) goto L15;
        r101 = true;
    L15:
        if (r101 == true) goto L17;
        return null;
    L17:
        return r100.mcontent;
    L11:
        return r100.mcontent;
    L8:
        r102 = false;
        goto L9
    }
}
