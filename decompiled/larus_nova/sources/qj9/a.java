package qj9;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.business.markdown.api.model.TitleStyle;
import com.larus.livetutor.impl.typing.enumeration.TypingStreamStatus;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.nova.R;
import com.larus.utils.i;
import com.larus.utils.logger.FLogger;
import io.noties.markwon.core.spans.ListMarginInfo;
import j19.c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lw8.d;
import lw8.l;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f533432c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f533433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CustomMarkdownTextView f533434b;

    /* JADX INFO: renamed from: qj9.a$a, reason: collision with other inner class name */
    public static final class C7341a {
    }

    static {
        f533432c = ColorProtector.parseColor("#F9FAFB");
    }

    public a() {
        this.f533433a = i.d(UtilsKt.c());
    }

    public final d b(Context r710) {
        int r100 = c.c(12);
        int r101 = f533432c;
        float r102 = UtilsKt.d(1);
        CustomMarkdownTextView r103 = this.f533434b;
        if (r103 == null) goto L5;
        float r104 = r103.getTextSize();
    L6:
        float r105 = r102 + r104;
        CustomMarkdownTextView r106 = this.f533434b;
        int r107 = -16777216;
        if (r106 == null) goto L9;
        int r108 = r106.getCurrentTextColor();
    L10:
        mw8.b r110 = new mw8.b(r105, r108);
        int r109 = c.c(12);
        int r410 = c.c(4);
        int r111 = c.c(1);
        float r112 = UtilsKt.d(17);
        int r113 = c.c(10);
        int r114 = c.c(16);
        int r115 = c.c(8);
        int r116 = c.c(8);
        CustomMarkdownTextView r117 = this.f533434b;
        if (r117 == null) goto L13;
        int r118 = r117.getCurrentTextColor();
    L14:
        TableConfig r411 = new TableConfig(false, 0, Float.valueOf(r112), Integer.valueOf(r111), null, Integer.valueOf(r118), Integer.valueOf(r115), Integer.valueOf(r116), null, Integer.MAX_VALUE, Integer.valueOf(r113), Integer.valueOf(r114), null, 17, false, false, false, false, false, null, 0, 0, 1036563, null);
        ListMarginInfo r119 = new ListMarginInfo(c.c(5), 0, 0);
        CustomMarkdownTextView r120 = this.f533434b;
        if (r120 == null) goto L17;
        r107 = r120.getCurrentTextColor();
    L17:
        int r121 = i5.r0();
        int r122 = ContextCompat.getColor(r710, R.color.larus_neutral_transparent_2);
        TitleStyle r510 = TitleStyle.LARGE;
        int r123 = ContextCompat.getColor(r710, R.color.larus_static_black);
        int r124 = ContextCompat.getColor(r710, R.color.code_block_bg);
        int r125 = ContextCompat.getColor(r710, R.color.code_block_bg);
        CodeBlockConfig r412 = new CodeBlockConfig(Integer.valueOf(r121), Integer.valueOf(r122), false, null, 0, null, true, "", false, true, r510, false, Integer.valueOf(r124), Integer.valueOf(r125), Integer.valueOf(r123), null, false, false, null, false, null, null, null, false, null, false, false, 134187324, null);
        return new d(r100, Integer.valueOf(r101), null, false, Integer.valueOf(r107), 0, Float.valueOf(1.0f), 0.0f, Float.valueOf(1.0f), 0, 0, Integer.valueOf(r109), Integer.valueOf(r410), null, null, null, r412, r411, null, r119, null, null, r110, null, -23173700, 30);
    L13:
        r118 = -16777216;
        goto L14
    L9:
        r108 = -16777216;
        goto L10
    L5:
        r104 = UtilsKt.d(17);
        goto L6
    }

    @Override // qj9.b
    public final l a(CharSequence r210, TypingStreamStatus r211) {
        if (r211 != TypingStreamStatus.Finish) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L12;
        CharSequence r101 = r210;
    L22:
        String r102 = r101.toString();
        Intrinsics.checkNotNullParameter(r102, "content");
        StringBuilder r103 = new StringBuilder(r102);
        int r104 = r103.indexOf("</div>");
    L23:
        if (r104 == (-1)) goto L32;
        int r105 = r104 + 6;
        if (r105 >= (r102.length() - 2)) goto L31;
        if (Intrinsics.areEqual(r103.substring(r105, r105 + 2), "\n\n") == true) goto L31;
        r103.insert(r105, "\n");
        if (r103.charAt(r105 - 1) == '\n') goto L31;
        r103.insert(r105, "\n");
    L31:
        r104 = r103.indexOf("</div>", r105);
        goto L23
    L32:
        int r106 = r103.indexOf("</div>");
    L33:
        if (r106 == (-1)) goto L39;
        if (r106 <= 0) goto L38;
        if (Intrinsics.areEqual(r103.substring(r106 - 1, r106), ">") == false) goto L38;
        r103.insert(r106, "￼");
    L38:
        r106 = r103.indexOf("</div>", r106 + 2);
        goto L33
    L39:
        String r110 = r103.toString();
        Context r111 = UtilsKt.c();
        CustomMarkdownTextView r107 = this.f533434b;
        if (r107 == null) goto L44;
        r107.setMarkdownWidth(this.f533433a);
        gw8.c.f483071a.getClass();
        gw8.c r108 = gw8.c.a.b();
        if (r108 == null) goto L47;
        l r109 = gw8.c.b.b(r108, r107, r110, true, b(r111));
    L48:
        FLogger r112 = FLogger.f375446a;
        StringBuilder r113 = new StringBuilder("parse: ");
        if (r109 == null) goto L51;
        SpannableStringBuilder r114 = r109.e();
    L52:
        r113.append(r114);
        r112.i("DefaultMarkdownParser", r113.toString());
        return r109;
    L51:
        r114 = null;
    L47:
        r109 = null;
        goto L48
    L44:
        gw8.c.f483071a.getClass();
        gw8.c r115 = gw8.c.a.b();
        if (r115 == null) goto L47;
        r109 = gw8.c.b.a(r115, r111, this.f533433a, r110, true, b(r111), null, null, 224);
        goto L48
    L12:
        if (StringsKt.endsWith$default(r210, '\\', false, 2, null) == false) goto L14;
        CharSequence r116 = r210.subSequence(0, r210.length() - 1).toString();
    L15:
        int r117 = StringsKt.lastIndexOf$default(r210, "\\(", 0, false, 6, null);
        int r118 = StringsKt.lastIndexOf$default(r210, "\\)", 0, false, 6, null);
        int r119 = StringsKt.lastIndexOf$default(r210, "\\[", 0, false, 6, null);
        int r120 = StringsKt.lastIndexOf$default(r210, "\\]", 0, false, 6, null);
        if (r118 >= r117) goto L18;
        r101 = r210.subSequence(0, r117).toString();
        goto L22
    L18:
        if (r120 >= r119) goto L20;
        r101 = r210.subSequence(0, r119).toString();
        goto L22
    L20:
        r101 = r116;
        goto L22
    L14:
        r116 = r210;
        goto L15
    L5:
        if (r211 == TypingStreamStatus.Stop) goto L8;
        r100 = false;
        goto L10
    }
}
