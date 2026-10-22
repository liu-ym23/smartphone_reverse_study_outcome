package com.ss.android.lark.picker.doubao.assembly.highlight;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.view.span.VerticalAlignImageSpan;
import com.ss.android.lark.search.dto.info.TagContent;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import rz7.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\b\b\u0001\u0010!\u001a\u00020\u0015H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/ss/android/lark/picker/doubao/assembly/highlight/DoubaoHighlightUtils;", "", "<init>", "()V", "HIGHLIGHT_TAG", "", "STYLE_TAG", "BOLD_TAG", "HIGHLIGHT_BOLD_TAG", "DOC_ICON_TAG", "INLINE_ICON_TAG", "DOC_ICON_TYPE", "COLOR", "GREY", "DEFAULT_COLOR", "INLINE_ICON_TYPE", "INLINE_UD_TYPE", "INSERT_SPACE_PRE", "INSERT_SPACE_AFT", "COLOR_MAP", "", "", "getCOLOR_MAP", "()Ljava/util/Map;", "addSearchHighLightedTagInternal", "", "builder", "Landroid/text/SpannableStringBuilder;", "textView", "Landroid/widget/TextView;", "tagList", "", "Lcom/ss/android/lark/search/dto/info/TagContent;", "highLightColor", "picker-doubao-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoHighlightUtils {
    private static final String BOLD_TAG = "b";
    private static final String COLOR = "color";
    private static final Map<String, Integer> COLOR_MAP = null;
    private static final String DEFAULT_COLOR = "grey";
    private static final String DOC_ICON_TAG = "di";
    private static final String DOC_ICON_TYPE = "type";
    private static final String GREY = "grey";
    private static final String HIGHLIGHT_BOLD_TAG = "hb";
    private static final String HIGHLIGHT_TAG = "h";
    private static final String INLINE_ICON_TAG = "pi";
    private static final String INLINE_ICON_TYPE = "icon";
    private static final String INLINE_UD_TYPE = "ud";
    private static final String INSERT_SPACE_AFT = " ";
    private static final String INSERT_SPACE_PRE = " ";
    public static final DoubaoHighlightUtils INSTANCE = null;
    private static final String STYLE_TAG = "asl-style";

    private DoubaoHighlightUtils() {
    }

    static {
        INSTANCE = new DoubaoHighlightUtils();
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("grey", Integer.valueOf(R.color.text_placeholder));
        COLOR_MAP = r100;
    }

    public final Map<String, Integer> getCOLOR_MAP() {
        return COLOR_MAP;
    }

    @JvmStatic
    public static final void addSearchHighLightedTagInternal(final SpannableStringBuilder r110, final TextView r210, List<TagContent> r211, int r212) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r210, "textView");
        if (r211 == null) goto L70;
        Iterator<T> r111 = r211.iterator();
    L6:
        if (r111.hasNext() == false) goto L70;
        TagContent r100 = (TagContent) r111.next();
        final int r101 = r100.getContent().getStart() + 0;
        if (r101 >= r110.length()) goto L6;
        if ((r100.getContent().getContent().length() + r101) > r110.length()) goto L6;
        final int r102 = r101 + r100.getContent().getContent().length();
        String r103 = r100.getTag();
        int r104 = r103.hashCode();
        boolean r105 = true;
        if (r104 != 98) goto L15;
        if (r103.equals(BOLD_TAG) == false) goto L6;
        r110.setSpan(new StyleSpan(1), r101, r102, 33);
        r110.setSpan(new ForegroundColorSpan(UIHelper.getColor(R.color.text_caption)), r101, r102, 33);
        goto L6
    L15:
        if (r104 != 104) goto L17;
        if (r103.equals("h") == false) goto L6;
        r110.setSpan(new ForegroundColorSpan(r212), r101, r102, 33);
        goto L6
    L17:
        if (r104 != 3205) goto L19;
        r103.equals(DOC_ICON_TAG);
        goto L6
    L19:
        if (r104 != 3322) goto L21;
        if (r103.equals(HIGHLIGHT_BOLD_TAG) == false) goto L6;
        r110.setSpan(new ForegroundColorSpan(r212), r101, r102, 33);
        r110.setSpan(new StyleSpan(1), r101, r102, 33);
        goto L6
    L21:
        if (r104 != 3577) goto L23;
        if (r103.equals(INLINE_ICON_TAG) == false) goto L6;
        String r106 = r100.getAttributeMap().get("ud");
        if (r106 != null) goto L39;
        r106 = "";
    L39:
        String r107 = r100.getAttributeMap().get("icon");
        if (r107 != null) goto L42;
        String r112 = "";
    L43:
        final int r113 = (int) r210.getTextSize();
        final int r108 = r210.getCurrentTextColor();
        if (r106.length() <= 0) goto L46;
        boolean r109 = true;
    L48:
        if (r109 == true) goto L49;
        if (r112.length() > 0) goto L54;
        r105 = false;
    L54:
        if (r105 == true) goto L55;
        Drawable r114 = UDIconUtils.getIconDrawable(r210.getContext(), R.drawable.ud_icon_link_copy_outlined);
        r114.setTint(r108);
        r114.setBounds(0, 0, r113, r113);
        r110.setSpan(new VerticalAlignImageSpan(r114), r101 + 1, r102 - 1, 33);
        goto L6
    L55:
        a.f539978a.getEncryptIconLoader().a(r210.getContext(), r112, r113, r113, new DoubaoHighlightUtils$addSearchHighLightedTagInternal$1$1(r108, r113, r110, r101, r102, r210));
        goto L6
    L49:
        Drawable r115 = UDIconUtils.getIconDrawable(r210.getContext(), R.drawable.ud_icon_link_copy_outlined);
        r115.setTint(r108);
        r115.setBounds(0, 0, r113, r113);
        r110.setSpan(new VerticalAlignImageSpan(r115), r101 + 1, r102 - 1, 33);
        goto L6
    L46:
        r109 = false;
        goto L48
    L42:
        r112 = r107;
        goto L43
    L23:
        if (r104 != 2089511070) goto L6;
        if (r103.equals(STYLE_TAG) == false) goto L6;
        Integer r116 = COLOR_MAP.get(r100.getAttributeMap().get("color"));
        if (r116 == null) goto L31;
        int r117 = r116.intValue();
    L32:
        r110.setSpan(new ForegroundColorSpan(UIHelper.getColor(r117)), r101, r102, 33);
        goto L6
    L31:
        r117 = R.color.text_disable;
    L70:
        r210.setText(r110);
    }
}
