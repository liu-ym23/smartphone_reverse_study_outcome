package o7b;

import com.ss.android.lark.widget.richtext.Image;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f522291a = 0;

    static {
    }

    public static Image a(com.ss.android.lark.image.entity.Image r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Image r101 = new Image();
        r101.setKey(r100.getKey());
        r101.setWidth(r100.getWidth());
        r101.setHeight(r100.getHeight());
        r101.setUrls(r100.getUrls());
        if (r100.getType() != com.ss.android.lark.image.entity.Image.Type.ENCRYPTED) goto L8;
        r101.setType(Image.Type.ENCRYPTED);
    L9:
        return r101;
    L8:
        r101.setType(Image.Type.NORMAL);
        goto L9
    }
}
