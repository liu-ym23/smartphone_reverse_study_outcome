package com.ss.android.lark.widget.linked_emojicon.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import qsb.b;

/* JADX INFO: loaded from: classes38.dex */
public final class EmojiHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f446356a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f446357b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f446358c = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/widget/linked_emojicon/base/EmojiHandler$EmojiAlignment;", "", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface EmojiAlignment {
        public static final a Companion = null;
        public static final int EMOJI_ALIGN_BASELINE = 1;
        public static final int EMOJI_ALIGN_BOTTOM = 0;
        public static final int EMOJI_ALIGN_CENTER = 2;
        public static final int EMOJI_ALIGN_TRUE_CENTER = 3;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f446359a = null;

            static {
                f446359a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f446359a;
        }
    }

    static {
        f446356a = b.a().h2();
        f446357b = true;
        f446358c = PatternProtector.compile("\\[[^\\[\\]]+?\\]");
    }

    @JvmStatic
    public static final List<Pair<Integer, Integer>> b(String r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
        int r104 = -1;
    L3:
        if (r103 >= r102) goto L14;
        char r105 = r100.charAt(r103);
        if (r105 != '[') goto L8;
        r104 = r103;
    L13:
        r103 = r103 + 1;
        goto L3
    L8:
        if (r105 != ']') goto L13;
        if (r104 <= (-1)) goto L13;
        CharSequence r106 = r100.subSequence(r104 + 1, r103);
        if (f446356a.get(r106) == null) goto L13;
        r101.add(TuplesKt.to(Integer.valueOf(r104), Integer.valueOf(r103)));
        r104 = -1;
        goto L13
    L14:
        return r101;
    }

    @JvmStatic
    public static final String e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = f(r100);
        if (Intrinsics.areEqual(r101, "[" + r100 + ']') == false) goto L6;
        Intrinsics.checkNotNullParameter(r100, "key");
        return "[" + b.a().K9(r100, false) + ']';
    L6:
        return r101;
    }

    @Deprecated(message = "Only support EmojiKey", replaceWith = @ReplaceWith(expression = "Use [getEmojiText()] instead，both support EmojiKey and ReactionKey", imports = {}))
    @JvmStatic
    public static final String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return "[" + b.a().K9(r100, true) + ']';
    }

    @JvmStatic
    public static final Drawable c(String r100, IGetDataCallback<Boolean> r101, IGetDataCallback<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Drawable r103 = d(r100, r101, r102);
        if (r103 != null) goto L13;
        Intrinsics.checkNotNullParameter(r100, "key");
        Bitmap r104 = b.a().Hb(r100, false);
        if (r104 != null) goto L8;
        b.a().ge(r100, true, r101, r102);
        BitmapDrawable r105 = null;
    L14:
        return r105;
    L8:
        if (r101 == null) goto L10;
        r101.onSuccess(Boolean.TRUE);
    L10:
        if (r102 == null) goto L12;
        r102.onSuccess(Boolean.TRUE);
    L12:
        r105 = new BitmapDrawable(r104);
        goto L14
    L13:
        return r103;
    }

    @Deprecated(message = "Only support EmojiKey", replaceWith = @ReplaceWith(expression = "Use [getEmojiDrawable()] instead，both support EmojiKey and ReactionKey", imports = {}))
    @JvmStatic
    public static final Drawable d(String r100, IGetDataCallback<Boolean> r101, IGetDataCallback<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Bitmap r103 = b.a().Hb(r100, true);
        if (r103 != null) goto L6;
        b.a().ge(r100, true, r101, r102);
        return null;
    L6:
        if (r101 == null) goto L8;
        r101.onSuccess(Boolean.TRUE);
    L8:
        if (r102 == null) goto L11;
        r102.onSuccess(Boolean.TRUE);
    L11:
        return new BitmapDrawable(r103);
    }

    @Deprecated(message = "No longer maintain")
    @JvmStatic
    public static final void a(Context r210, Spannable r211, int r212, int r213, int r214, int r215, int r216) {
        if (r211 == null) goto L53;
        if (r210 == null) goto L59;
        int r100 = r211.length();
        int r101 = r100 - r215;
        if (r216 < 0) goto L11;
        if (r216 >= r101) goto L11;
        r100 = r216 + r215;
    L11:
        int r110 = r100;
        a[] r102 = (a[]) r211.getSpans(r215, r110, a.class);
        int r103 = r102.length;
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L14;
        r211.removeSpan(r102[r104]);
        r104 = r104 + 1;
        goto L12
    L14:
        Matcher r111 = f446358c.matcher(r211.subSequence(r215, r110).toString());
        if (r111.find() == true) goto L17;
        return;
    L17:
        r111.reset();
        int r105 = r215;
        int r112 = 0;
    L19:
        if (r111.find() == false) goto L60;
        boolean r106 = true;
        if (f446357b == false) goto L31;
        String r107 = r111.group();
        if (r107.length() != 0) goto L25;
        boolean r108 = true;
    L26:
        if (r108 == true) goto L52;
        if (r107.length() < 2) goto L52;
        String r109 = r107.substring(StringsKt.indexOf$default(r107, "[", 0, false, 6, null) + 1, StringsKt.indexOf$default(r107, "]", 0, false, 6, null));
        String r113 = r107;
    L38:
        String r114 = f446356a.get(r109);
        if (r114 == null) goto L52;
        Drawable r115 = d(r114, null, null);
        if (r115 == null) goto L52;
        int r116 = StringsKt.indexOf$default(r211, r113, r105, false, 4, null);
        int r117 = r113.length() + r116;
        if (r116 < 0) goto L52;
        if (r117 > r110) goto L52;
        r211.setSpan(new a(r210, r115, r114, r212, r213, r214), r116, r117, 33);
        int r118 = r112 + 1;
        if (r118 >= 200) goto L61;
        r112 = r118;
        r105 = r117;
        goto L52
    L61:
        return;
    L52:
        r111 = r111;
        goto L19
    L25:
        r108 = false;
        goto L26
    L31:
        String r119 = r111.group(1);
        if (r119.length() == 0) goto L35;
        r106 = false;
    L35:
        if (r106 == true) goto L52;
        r113 = "[" + r119 + ']';
        r109 = r119;
        goto L38
    L60:
        return;
    L59:
        return;
    }
}
