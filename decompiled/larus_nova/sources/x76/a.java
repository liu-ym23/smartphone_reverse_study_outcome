package x76;

import android.text.Editable;
import android.text.Selection;
import com.bytedance.ies.xelement.input.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f562823a = null;

    static {
        f562823a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.ies.xelement.input.n
    public final boolean a(Editable r110) {
        Intrinsics.checkNotNullParameter(r110, "editableText");
        int r100 = Selection.getSelectionStart(r110);
        int r101 = Selection.getSelectionEnd(r110);
        Object[] r102 = r110.getSpans(r100, r101, b.class);
        int r103 = r102.length;
        boolean r104 = false;
        int r105 = 0;
    L4:
        if (r105 >= r103) goto L12;
        Object r106 = r102[r105];
        if (r110.getSpanEnd((b) r106) != r100) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == true) goto L13;
        r105 = r105 + 1;
    L13:
        b r108 = (b) r106;
        if (r108 == null) goto L18;
        if (r100 != r101) goto L17;
        r104 = true;
    L17:
        Selection.setSelection(r110, r110.getSpanStart(r108), r110.getSpanEnd(r108));
    L18:
        return r104;
    L8:
        r107 = false;
        goto L9
    L12:
        r106 = null;
        goto L13
    }
}
