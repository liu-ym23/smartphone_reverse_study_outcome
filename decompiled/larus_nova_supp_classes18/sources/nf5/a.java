package nf5;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.comment.export.CommentDiffUtils;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final Map<String, Boolean> a = null;
    public static final Bundle b = null;

    static {
        a = new LinkedHashMap();
        Bundle r0 = new Bundle();
        int r1 = CommentDiffUtils.a;
        r0.putInt("TRANSLATE", 1);
        b = r0;
    }

    public static boolean a(TranslateConfig r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "config");
        boolean r0 = r4.getShow();
        boolean r1 = false;
        if (r4.getType() != 3) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r0 == false) goto L11;
        if (r6 == false) goto L11;
        r1 = true;
    L11:
        tt5.a.h("Comment#CommentTranslate", "diffViewShowOrigin: " + r1 + " 1:" + r0 + " 2:" + r6);
        return r1;
    L5:
        if (Intrinsics.areEqual(((LinkedHashMap) a).get(r5), Boolean.TRUE) == false) goto L7;
        r6 = true;
        goto L8
    }

    public static boolean c(TranslateConfig r2, CommentBean.CommentDetail r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "item");
        return d(r2, r3.getReply_id(), r3.getTranslate_status(), r3.getContent());
    }

    public static boolean f(TranslateConfig r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "config");
        boolean r0 = r6.getShow();
        boolean r9 = Intrinsics.areEqual(r8, "success");
        boolean r2 = false;
        if (r6.getType() != 3) goto L5;
        boolean r1 = true;
    L7:
        if (r6.getType() != 3) goto L9;
    L11:
        boolean r10 = false;
    L12:
        if (r1 == true) goto L16;
        if (r10 == true) goto L16;
        boolean r4 = false;
    L17:
        boolean r11 = !Intrinsics.areEqual(((LinkedHashMap) a).get(r7), Boolean.TRUE);
        if (r0 == false) goto L23;
        if (r9 == false) goto L23;
        if (r4 == false) goto L23;
        if (r11 == false) goto L23;
        r2 = true;
    L23:
        tt5.a.h("Comment#CommentTranslate", "showDiffView: " + r2 + " 1:" + r0 + " 2:" + r9 + " 3b:" + r1 + " 3c:" + r10 + " 4:" + r11);
        return r2;
    L16:
        r4 = true;
        goto L17
    L9:
        if (Intrinsics.areEqual(((LinkedHashMap) a).get(r7), Boolean.TRUE) == false) goto L11;
        r10 = true;
        goto L12
    L5:
        r1 = false;
        goto L7
    }

    public static boolean g(TranslateConfig r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "config");
        boolean r0 = r4.getShow();
        boolean r7 = Intrinsics.areEqual(r6, "success");
        boolean r2 = false;
        if (r4.getType() != 2) goto L5;
        boolean r8 = true;
    L6:
        boolean r9 = !Intrinsics.areEqual(((LinkedHashMap) a).get(r5), Boolean.TRUE);
        if (r0 == false) goto L12;
        if (r7 == false) goto L12;
        if (r8 == false) goto L12;
        if (r9 == false) goto L12;
        r2 = true;
    L12:
        tt5.a.h("Comment#CommentTranslate", "content show: " + r2 + " 1:" + r0 + " 2:" + r7 + " 3:" + r8 + " 4：" + r9);
        return r2;
    L5:
        r8 = false;
        goto L6
    }

    public static boolean h(TranslateConfig r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "config");
        boolean r8 = r5.getShow();
        boolean r0 = Intrinsics.areEqual(r7, "loading");
        boolean r9 = Intrinsics.areEqual(r7, "success");
        boolean r2 = true;
        boolean r1 = !Intrinsics.areEqual(((LinkedHashMap) a).get(r6), Boolean.TRUE);
        boolean r10 = !TextUtils.isEmpty(r6);
        if (r8 == false) goto L9;
        if (r0 == true) goto L6;
        if (r9 == false) goto L9;
    L6:
        if (r1 == false) goto L9;
        if (r10 == false) goto L9;
    L10:
        tt5.a.h("Comment#CommentTranslate", "translateIcon show: " + r2 + " 1:" + r8 + " 2a:" + r0 + " 2b:" + r9 + " 3:" + r1 + " 4:" + r10);
        return r2;
    L9:
        r2 = false;
        goto L10
    }

    public static boolean b(TranslateConfig r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "config");
        boolean r0 = r4.getShow();
        boolean r8 = Intrinsics.areEqual(r6, "success");
        boolean r2 = false;
        if (r4.getType() != 2) goto L5;
        boolean r9 = true;
    L6:
        boolean r10 = !Intrinsics.areEqual(((LinkedHashMap) a).get(r5), Boolean.TRUE);
        boolean r11 = !TextUtils.isEmpty(r7);
        if (r0 == false) goto L13;
        if (r8 == false) goto L13;
        if (r9 == false) goto L13;
        if (r10 == false) goto L13;
        if (r11 == false) goto L13;
        r2 = true;
    L13:
        tt5.a.h("Comment#CommentTranslate", "reactionWindowShowOrigin: " + r2 + " 1:" + r0 + " 2:" + r8 + " 3:" + r9 + " 4:" + r10 + " 5" + r11);
        return r2;
    L5:
        r9 = false;
        goto L6
    }

    public static boolean d(TranslateConfig r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "config");
        boolean r5 = r1.getShow();
        boolean r6 = Intrinsics.areEqual(r3, "success");
        boolean r7 = !TextUtils.isEmpty(r4);
        if (r5 == false) goto L9;
        if (r6 == false) goto L9;
        if (r7 == false) goto L9;
        if (Intrinsics.areEqual(((LinkedHashMap) a).get(r2), Boolean.TRUE) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean e(TranslateConfig r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "config");
        boolean r7 = r3.getShow();
        boolean r0 = false;
        if (r5 != null) goto L5;
    L10:
        boolean r8 = true;
    L11:
        boolean r9 = Intrinsics.areEqual(((LinkedHashMap) a).get(r4), Boolean.TRUE);
        boolean r10 = !TextUtils.isEmpty(r6);
        if (r7 == false) goto L17;
        if (r8 == true) goto L15;
        if (r9 == false) goto L17;
    L15:
        if (r10 == false) goto L17;
        r0 = true;
    L17:
        tt5.a.h("Comment#CommentTranslate", "reactionWindowShowTranslate show: " + r0 + " 1:" + r7 + " 2a:" + r8 + " 2b: " + r9);
        return r0;
    L5:
        if (Intrinsics.areEqual(r5, "default") == true) goto L10;
        if (Intrinsics.areEqual(r5, "error") == true) goto L10;
        r8 = false;
        goto L11
    }
}
