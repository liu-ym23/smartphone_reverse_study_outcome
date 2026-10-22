package v04;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.awemeopen.apps.framework.comment.emoji.OnlineSmallEmojiCache;
import com.bytedance.awemeopen.apps.framework.comment.emoji.OnlineSmallEmojiResManager;
import com.bytedance.awemeopen.emojires.EmojiValueRes;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f552302a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f552303b;

    static {
        f552302a = PatternProtector.compile("(\\[)([^\\[\\]]+)(])");
        f552303b = false;
    }

    public static void a(TextView r100) {
        CharSequence r101 = r100.getText();
        SpannableString r102 = new SpannableString(r101);
        com.bytedance.awemeopen.apps.framework.base.view.b[] r103 = (com.bytedance.awemeopen.apps.framework.base.view.b[]) r102.getSpans(0, r101.length(), com.bytedance.awemeopen.apps.framework.base.view.b.class);
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r102.removeSpan(r103[r105]);
        r105 = r105 + 1;
        goto L3
    L5:
        Matcher r106 = f552302a.matcher(r101);
    L7:
        if (r106.find() == false) goto L15;
        int r107 = r106.start();
        int r108 = r106.end();
        String r109 = r106.group();
        Drawable r110 = b(r100.getContext(), r109);
        if (r110 == null) goto L7;
        int r111 = r100.getLineHeight();
        r110.setBounds(0, 0, r111, r111);
        com.bytedance.awemeopen.apps.framework.base.view.b r112 = new com.bytedance.awemeopen.apps.framework.base.view.b(r110);
        if (r107 >= r108) goto L7;
        r102.setSpan(r112, r107, r108, 33);
        goto L7
    L15:
        if ((r100 instanceof EditText) == false) goto L19;
        Editable r113 = r100.getEditableText();
        if (r113 == null) goto L29;
        r113.replace(0, r113.length(), r102);
        return;
    L29:
        return;
    L19:
        r100.setText(r102);
    }

    public static Drawable b(Context r100, String r101) {
        OnlineSmallEmojiResManager r102 = OnlineSmallEmojiResManager.f194144i;
        Drawable r103 = null;
        r103 = null;
        Bitmap r104 = null;
        r104 = null;
        if (r102.c() == false) goto L11;
        Resources r105 = r100.getResources();
        if (r102.c() == false) goto L22;
        OnlineSmallEmojiCache r106 = r102.f194149e;
        if (r106 == null) goto L22;
        String r107 = r102.e(r101);
        int r108 = OnlineSmallEmojiCache.f194140d;
        r104 = r106.b(r107, true);
    L22:
        return new BitmapDrawable(r105, r104);
    L11:
        a r109 = a.a();
        Resources r110 = r100.getResources();
        r109.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L19;
        r103 = EmojiValueRes.getEmoji(r101, r110);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        AoLogger.l("EmojiResHelper", new Object[]{e, "Reflection failed to obtain Emoji"});
    L19:
        return r103;
    }

    public static List<String> c(Context r100, String r101) {
        if (r100 != null) goto L4;
        r100 = com.bytedance.awemeopen.apps.framework.utils.a.b();
    L4:
        if (r100 == null) goto L16;
        if (TextUtils.isEmpty(r101) == true) goto L16;
        ArrayList r102 = new ArrayList();
        Matcher r103 = f552302a.matcher(r101);
    L10:
        if (r103.find() == false) goto L14;
        String r104 = r103.group();
        if (b(r100, r104) == null) goto L10;
        r102.add(r104);
        goto L10
    L14:
        return r102;
    L16:
        return new ArrayList();
    }
}
