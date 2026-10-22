package nf5;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.middleground.comment.export.CommentDiffUtils;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Boolean> f518950a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Bundle f518951b = null;

    static {
        f518950a = new LinkedHashMap();
        Bundle r100 = new Bundle();
        int r101 = CommentDiffUtils.f231330a;
        r100.putInt("TRANSLATE", 1);
        f518951b = r100;
    }

    public static boolean a(TranslateConfig r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        boolean r102 = r100.getShow();
        boolean r103 = false;
        if (r100.getType() != 3) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r102 == false) goto L11;
        if (r104 == false) goto L11;
        r103 = true;
    L11:
        tt5.a.h("Comment#CommentTranslate", "diffViewShowOrigin: " + r103 + " 1:" + r102 + " 2:" + r104);
        return r103;
    L5:
        if (Intrinsics.areEqual(((LinkedHashMap) f518950a).get(r101), Boolean.TRUE) == false) goto L7;
        r104 = true;
        goto L8
    }

    public static boolean c(TranslateConfig r100, CommentBean.CommentDetail r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        return d(r100, r101.getReply_id(), r101.getTranslate_status(), r101.getContent());
    }

    public static boolean f(TranslateConfig r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        boolean r103 = r100.getShow();
        boolean r104 = Intrinsics.areEqual(r102, "success");
        boolean r105 = false;
        if (r100.getType() != 3) goto L5;
        boolean r106 = true;
    L7:
        if (r100.getType() != 3) goto L9;
    L11:
        boolean r107 = false;
    L12:
        if (r106 == true) goto L16;
        if (r107 == true) goto L16;
        boolean r108 = false;
    L17:
        boolean r109 = !Intrinsics.areEqual(((LinkedHashMap) f518950a).get(r101), Boolean.TRUE);
        if (r103 == false) goto L23;
        if (r104 == false) goto L23;
        if (r108 == false) goto L23;
        if (r109 == false) goto L23;
        r105 = true;
    L23:
        tt5.a.h("Comment#CommentTranslate", "showDiffView: " + r105 + " 1:" + r103 + " 2:" + r104 + " 3b:" + r106 + " 3c:" + r107 + " 4:" + r109);
        return r105;
    L16:
        r108 = true;
        goto L17
    L9:
        if (Intrinsics.areEqual(((LinkedHashMap) f518950a).get(r101), Boolean.TRUE) == false) goto L11;
        r107 = true;
        goto L12
    L5:
        r106 = false;
        goto L7
    }

    public static boolean g(TranslateConfig r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        boolean r103 = r100.getShow();
        boolean r104 = Intrinsics.areEqual(r102, "success");
        boolean r105 = false;
        if (r100.getType() != 2) goto L5;
        boolean r106 = true;
    L6:
        boolean r107 = !Intrinsics.areEqual(((LinkedHashMap) f518950a).get(r101), Boolean.TRUE);
        if (r103 == false) goto L12;
        if (r104 == false) goto L12;
        if (r106 == false) goto L12;
        if (r107 == false) goto L12;
        r105 = true;
    L12:
        tt5.a.h("Comment#CommentTranslate", "content show: " + r105 + " 1:" + r103 + " 2:" + r104 + " 3:" + r106 + " 4：" + r107);
        return r105;
    L5:
        r106 = false;
        goto L6
    }

    public static boolean h(TranslateConfig r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        boolean r103 = r100.getShow();
        boolean r104 = Intrinsics.areEqual(r102, "loading");
        boolean r105 = Intrinsics.areEqual(r102, "success");
        boolean r106 = true;
        boolean r107 = !Intrinsics.areEqual(((LinkedHashMap) f518950a).get(r101), Boolean.TRUE);
        boolean r108 = !TextUtils.isEmpty(r101);
        if (r103 == false) goto L9;
        if (r104 == true) goto L6;
        if (r105 == false) goto L9;
    L6:
        if (r107 == false) goto L9;
        if (r108 == false) goto L9;
    L10:
        tt5.a.h("Comment#CommentTranslate", "translateIcon show: " + r106 + " 1:" + r103 + " 2a:" + r104 + " 2b:" + r105 + " 3:" + r107 + " 4:" + r108);
        return r106;
    L9:
        r106 = false;
        goto L10
    }

    public static boolean b(TranslateConfig r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "config");
        boolean r104 = r100.getShow();
        boolean r105 = Intrinsics.areEqual(r102, "success");
        boolean r106 = false;
        if (r100.getType() != 2) goto L5;
        boolean r107 = true;
    L6:
        boolean r108 = !Intrinsics.areEqual(((LinkedHashMap) f518950a).get(r101), Boolean.TRUE);
        boolean r109 = !TextUtils.isEmpty(r103);
        if (r104 == false) goto L13;
        if (r105 == false) goto L13;
        if (r107 == false) goto L13;
        if (r108 == false) goto L13;
        if (r109 == false) goto L13;
        r106 = true;
    L13:
        tt5.a.h("Comment#CommentTranslate", "reactionWindowShowOrigin: " + r106 + " 1:" + r104 + " 2:" + r105 + " 3:" + r107 + " 4:" + r108 + " 5" + r109);
        return r106;
    L5:
        r107 = false;
        goto L6
    }

    public static boolean d(TranslateConfig r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "config");
        boolean r104 = r100.getShow();
        boolean r105 = Intrinsics.areEqual(r102, "success");
        boolean r106 = !TextUtils.isEmpty(r103);
        if (r104 == false) goto L9;
        if (r105 == false) goto L9;
        if (r106 == false) goto L9;
        if (Intrinsics.areEqual(((LinkedHashMap) f518950a).get(r101), Boolean.TRUE) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean e(TranslateConfig r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "config");
        boolean r104 = r100.getShow();
        boolean r105 = false;
        if (r102 != null) goto L5;
    L10:
        boolean r106 = true;
    L11:
        boolean r107 = Intrinsics.areEqual(((LinkedHashMap) f518950a).get(r101), Boolean.TRUE);
        boolean r108 = !TextUtils.isEmpty(r103);
        if (r104 == false) goto L17;
        if (r106 == true) goto L15;
        if (r107 == false) goto L17;
    L15:
        if (r108 == false) goto L17;
        r105 = true;
    L17:
        tt5.a.h("Comment#CommentTranslate", "reactionWindowShowTranslate show: " + r105 + " 1:" + r104 + " 2a:" + r106 + " 2b: " + r107);
        return r105;
    L5:
        if (Intrinsics.areEqual(r102, "default") == true) goto L10;
        if (Intrinsics.areEqual(r102, "error") == true) goto L10;
        r106 = false;
        goto L11
    }
}
