package s90;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.emoji.EmojiUriModel;
import com.bytedance.android.live.base.model.emoji.EmojiUriNode;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f541045b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<BaseEmoji> f541046a;

    static {
        f541045b = PatternProtector.compile("\\[[a-zA-Z0-9\\u4e00-\\u9fa5]+\\]");
    }

    public a() {
        this.f541046a = null;
    }

    public final List<db2.a> b(CharSequence r100) {
        ArrayList r101 = new ArrayList();
        Matcher r102 = f541045b.matcher(r100);
    L4:
        if (r102.find() == false) goto L11;
        String r103 = r102.group();
        int r104 = r102.start();
        int r105 = r102.end();
        if (k.f(IAwemeEmojiProxy.class) == null) goto L8;
        Drawable r106 = ((IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class)).getRealDrawable(r103);
    L9:
        if (r106 == null) goto L4;
        r101.add(new db2.a(r106, r104, r105));
        goto L4
    L8:
        r106 = null;
        goto L9
    L11:
        return r101;
    }

    public final List<EmojiUriNode> c(CharSequence r110) {
        ArrayList r100 = new ArrayList();
        Matcher r111 = f541045b.matcher(r110);
    L4:
        if (r111.find() == false) goto L36;
        String r101 = r111.group();
        int r102 = r111.start();
        int r103 = r111.end();
        List<BaseEmoji> r104 = this.f541046a;
        if (r104 == null) goto L10;
        if (r104.isEmpty() == true) goto L10;
    L12:
        List<BaseEmoji> r105 = this.f541046a;
        if (r105 != null) goto L15;
    L33:
        EmojiUriModel r106 = null;
    L34:
        if (r106 == null) goto L4;
        r100.add(new EmojiUriNode(r106, r102, r103));
        goto L4
    L15:
        if (r105.isEmpty() == true) goto L33;
        Iterator<BaseEmoji> r107 = r105.iterator();
    L19:
        if (r107.hasNext() == false) goto L33;
        BaseEmoji r108 = r107.next();
        if (TextUtils.equals(r108.getDescription(), r101) == false) goto L19;
        int r109 = r108.getIconId();
        String r112 = r108.getLocalFilePath();
        if (r109 > 0) goto L25;
        if (r112 == null) goto L19;
        if (r112.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == true) goto L30;
    L32:
        r106 = new EmojiUriModel(r109, r112, r101);
        goto L34
    L30:
        if (r112.startsWith("file:///") == true) goto L32;
        r112 = r112.replace(MSkiaImageRegionDecoder.FILE_PREFIX, "file:///");
        goto L32
    L25:
        r106 = new EmojiUriModel(r109, r112, r101);
    L10:
        if (k.f(IAwemeEmojiProxy.class) == null) goto L12;
        this.f541046a = ((IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class)).loadAllBaseEmoji();
        goto L12
    L36:
        return r100;
    }

    public static void a(Spannable r100, Drawable r101, int r102, int r103, int r104, int r105, String r106) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() == 0) goto L15;
        if (r102 >= 0) goto L7;
        return;
    L7:
        if (r102 > r100.length()) goto L17;
        if (r102 <= r103) goto L10;
        return;
    L10:
        if (r103 > r100.length()) goto L19;
        r101.setBounds(0, 0, r104, r105);
        x90.a r107 = new x90.a(r101);
        r107.f562962a = 2;
        r107.f562963b = 2;
        r107.f562964c = r106;
        r100.setSpan(r107, r102, r103, 33);
        return;
    L19:
        return;
    L17:
        return;
    }
}
