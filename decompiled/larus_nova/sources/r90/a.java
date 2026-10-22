package r90;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import java.util.List;
import java.util.regex.Matcher;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f536678c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u90.a f536679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s90.a f536680b;

    public static a a() {
        if (f536678c != null) goto L6;
        f536678c = new a();
    L6:
        return f536678c;
    }

    public final List<BaseEmoji> b() {
        this.f536679a.getClass();
        if (k.f(IAwemeEmojiProxy.class) != null) goto L7;
        return null;
    L7:
        return ((IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class)).loadAllBaseEmoji();
    }

    public a() {
        this.f536679a = new u90.a();
        this.f536680b = new s90.a();
    }

    public final SpannableString c(CharSequence r110, float r111, boolean r112) {
        this.f536680b.getClass();
        if (r110 != null) goto L6;
        return null;
    L6:
        if ((r110 instanceof Spannable) == false) goto L14;
        Spannable r100 = (Spannable) r110;
        int r101 = 0;
        x90.a[] r102 = (x90.a[]) r100.getSpans(0, r110.length(), x90.a.class);
        if (r102 == null) goto L14;
        if (r102.length <= 0) goto L14;
        int r103 = r102.length;
    L12:
        if (r101 >= r103) goto L14;
        r100.removeSpan(r102[r101]);
        r101 = r101 + 1;
    L14:
        SpannableString r104 = SpannableString.valueOf(r110);
        Matcher r105 = s90.a.f541045b.matcher(r110);
    L16:
        if (r105.find() == false) goto L24;
        String r106 = r105.group();
        int r107 = r105.start();
        int r108 = r105.end();
        if (k.f(IAwemeEmojiProxy.class) == null) goto L20;
        Drawable r109 = ((IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class)).getRealDrawable(r106);
    L21:
        if (r109 == null) goto L16;
        s90.a.a(r104, r109, r107, r108, (int) (fb2.c.b(r111, r109, r112) + 0.5f), (int) (fb2.c.a(r111, r112) + 0.5f), String.valueOf(r110.subSequence(r107, r108)));
        goto L16
    L20:
        r109 = null;
        goto L21
    L24:
        return r104;
    }
}
