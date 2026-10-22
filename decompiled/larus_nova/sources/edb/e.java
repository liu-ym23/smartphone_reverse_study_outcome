package edb;

import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichTextElement;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f472256a = 0;

    static {
    }

    public static void a(UDIcon r100, RichTextElement.AnchorProperty r101) {
        if (r100 == null) goto L5;
        String r102 = r100.getUnicode();
    L6:
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L24;
        int r104 = a.f472252a;
        if (r100 == null) goto L16;
        String r105 = r100.getKey();
    L17:
        int r106 = a.a(r105);
        if (r106 == 0) goto L30;
        r101.setLocalIconRes(r106);
        r101.setLocalGrayIconRes(r106);
        if (r100 == null) goto L31;
        ThemeColor r107 = r100.getThemeColor();
        if (r107 == null) goto L32;
        r101.setIconColor(com.ss.android.lark.export.entity.preview.a.a(r107, UIHelper.getContext(), null));
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L16:
        r105 = null;
        goto L17
    L24:
        if (r100 == null) goto L34;
        String r108 = r100.getUnicode();
        if (r108 == null) goto L35;
        r101.setUnicode(r108);
        return;
    L35:
        return;
    L34:
        return;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
