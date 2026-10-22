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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final Pattern a = null;
    public static boolean b;

    static {
        a = PatternProtector.compile("(\\[)([^\\[\\]]+)(])");
        b = false;
    }

    public static void a(TextView r7) {
        CharSequence r0 = r7.getText();
        SpannableString r1 = new SpannableString(r0);
        com.bytedance.awemeopen.apps.framework.base.view.b[] r2 = (com.bytedance.awemeopen.apps.framework.base.view.b[]) r1.getSpans(0, r0.length(), com.bytedance.awemeopen.apps.framework.base.view.b.class);
        int r3 = r2.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        r1.removeSpan(r2[r5]);
        r5 = r5 + 1;
        goto L3
    L5:
        Matcher r4 = a.matcher(r0);
    L7:
        if (r4.find() == false) goto L15;
        int r6 = r4.start();
        int r8 = r4.end();
        String r9 = r4.group();
        Drawable r10 = b(r7.getContext(), r9);
        if (r10 == null) goto L7;
        int r11 = r7.getLineHeight();
        r10.setBounds(0, 0, r11, r11);
        com.bytedance.awemeopen.apps.framework.base.view.b r12 = new com.bytedance.awemeopen.apps.framework.base.view.b(r10);
        if (r6 >= r8) goto L7;
        r1.setSpan(r12, r6, r8, 33);
        goto L7
    L15:
        if ((r7 instanceof EditText) == false) goto L19;
        Editable r13 = r7.getEditableText();
        if (r13 == null) goto L29;
        r13.replace(0, r13.length(), r1);
        return;
    L29:
        return;
    L19:
        r7.setText(r1);
    }

    public static Drawable b(Context r5, String r6) {
        OnlineSmallEmojiResManager r0 = OnlineSmallEmojiResManager.i;
        Drawable r3 = null;
        r3 = null;
        Bitmap r4 = null;
        r4 = null;
        if (r0.c() == false) goto L11;
        Resources r7 = r5.getResources();
        if (r0.c() == false) goto L22;
        OnlineSmallEmojiCache r8 = r0.e;
        if (r8 == null) goto L22;
        String r9 = r0.e(r6);
        int r1 = OnlineSmallEmojiCache.d;
        r4 = r8.b(r9, true);
    L22:
        return new BitmapDrawable(r7, r4);
    L11:
        a r2 = a.a();
        Resources r10 = r5.getResources();
        r2.getClass();
        if (TextUtils.isEmpty(r6) == true) goto L19;
        r3 = EmojiValueRes.getEmoji(r6, r10);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        AoLogger.l("EmojiResHelper", new Object[]{e, "Reflection failed to obtain Emoji"});
    L19:
        return r3;
    }

    public static List<String> c(Context r3, String r4) {
        if (r3 != null) goto L4;
        r3 = com.bytedance.awemeopen.apps.framework.utils.a.b();
    L4:
        if (r3 == null) goto L16;
        if (TextUtils.isEmpty(r4) == true) goto L16;
        ArrayList r0 = new ArrayList();
        Matcher r5 = a.matcher(r4);
    L10:
        if (r5.find() == false) goto L14;
        String r1 = r5.group();
        if (b(r3, r1) == null) goto L10;
        r0.add(r1);
        goto L10
    L14:
        return r0;
    L16:
        return new ArrayList();
    }
}
