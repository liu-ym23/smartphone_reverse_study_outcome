package com.ss.android.lark.widget.richtext;

import android.text.Spannable;
import android.text.Spanned;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class RichTextElementCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<? extends RichTextElement.RichTextProperty>, RichTextElement.RichTextTag> f448209a = null;

    static {
        RichTextElement.RichTextTag r100 = RichTextElement.RichTextTag.PARAGRAPH;
        RichTextElement.RichTextTag r101 = RichTextElement.RichTextTag.TEXT;
        f448209a = MapsKt.mapOf(new Pair[]{TuplesKt.to(RichTextElement.AtProperty.class, RichTextElement.RichTextTag.AT), TuplesKt.to(RichTextElement.ParagraphProperty.class, r100), TuplesKt.to(RichTextElement.FigureProperty.class, RichTextElement.RichTextTag.FIGURE), TuplesKt.to(RichTextElement.TextProperty.class, r101), TuplesKt.to(RichTextElement.MentionProperty.class, RichTextElement.RichTextTag.MENTION), TuplesKt.to(RichTextElement.ImageProperty.class, RichTextElement.RichTextTag.IMG), TuplesKt.to(RichTextElement.EmotionProperty.class, RichTextElement.RichTextTag.EMOTION), TuplesKt.to(RichTextElement.MarkdownProperty.class, RichTextElement.RichTextTag.MARKDOWN), TuplesKt.to(RichTextElement.AnchorProperty.class, RichTextElement.RichTextTag.ANCHOR), TuplesKt.to(RichTextElement.MediaProperty.class, RichTextElement.RichTextTag.MEDIA), TuplesKt.to(RichTextElement.DashedProperty.class, r101), TuplesKt.to(RichTextElement.DashedPropertyV2.class, r101), TuplesKt.to(RichTextElement.ParagraphProperty.class, r100), TuplesKt.to(RichTextElement.H1Property.class, RichTextElement.RichTextTag.H1), TuplesKt.to(RichTextElement.H2Property.class, RichTextElement.RichTextTag.H2), TuplesKt.to(RichTextElement.H3Property.class, RichTextElement.RichTextTag.H3), TuplesKt.to(RichTextElement.H4Property.class, RichTextElement.RichTextTag.H4), TuplesKt.to(RichTextElement.H5Property.class, RichTextElement.RichTextTag.H5), TuplesKt.to(RichTextElement.H6Property.class, RichTextElement.RichTextTag.H6), TuplesKt.to(RichTextElement.LIProperty.class, RichTextElement.RichTextTag.LI), TuplesKt.to(RichTextElement.OLProperty.class, RichTextElement.RichTextTag.OL), TuplesKt.to(RichTextElement.ULProperty.class, RichTextElement.RichTextTag.UL), TuplesKt.to(RichTextElement.QuoteProperty.class, RichTextElement.RichTextTag.QUOTE), TuplesKt.to(RichTextElement.CodeProperty.class, RichTextElement.RichTextTag.CODE), TuplesKt.to(RichTextElement.CodeBlockV2Property.class, RichTextElement.RichTextTag.CODE_BLOCK_V2), TuplesKt.to(RichTextElement.MyAIToolProperty.class, RichTextElement.RichTextTag.MY_AI_TOOL), TuplesKt.to(RichTextElement.DocsProperty.class, RichTextElement.RichTextTag.DOCS), TuplesKt.to(RichTextElement.AtUserGroupProperty.class, RichTextElement.RichTextTag.AT_USER_GROUP), TuplesKt.to(RichTextElement.HRProperty.class, RichTextElement.RichTextTag.HR)});
    }

    @JvmStatic
    public static final RichTextElement d() {
        RichTextElement.ParagraphProperty r100 = new RichTextElement.ParagraphProperty();
        r100.setIsNeedEnter(true);
        return h(r100);
    }

    @JvmStatic
    public static final RichTextElement e(String r100) {
        RichTextElement.TextProperty r101 = new RichTextElement.TextProperty();
        r101.setContent(String.valueOf(r100));
        return h(r101);
    }

    @JvmStatic
    public static final List<RichTextElement> f(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return g(r100, RichTextElementCreator$createTextElementsWithStyleV2$1.INSTANCE);
    }

    @JvmStatic
    public static final RichTextElement h(RichTextElement.RichTextProperty r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        RichTextElement r101 = new RichTextElement();
        r101.setProperty(r100);
        r101.setTag(f448209a.get(r100.getClass()));
        StringBuilder r102 = new StringBuilder("toElement: current element is ");
        r102.append(r100.getClass().getName());
        r102.append(", find tag ");
        RichTextElement.RichTextTag r103 = r101.getTag();
        if (r103 == null) goto L6;
        String r104 = r103.name();
        if (r104 == null) goto L6;
    L7:
        r102.append(r104);
        Log.i(RichTextElement.TAG, r102.toString());
        r101.setStyle(new HashMap(0));
        r101.setChildIds(new ArrayList(0));
        return r101;
    L6:
        r104 = "";
        goto L7
    }

    @JvmStatic
    public static final RichTextElement.AnchorProperty a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "href");
        RichTextElement.AnchorProperty r102 = new RichTextElement.AnchorProperty();
        r102.setHref(r101);
        r102.setContent(r100);
        return r102;
    }

    @JvmStatic
    public static final List<RichTextElement> g(CharSequence r100, final Function1<? super Spannable, ? extends List<? extends RichTextElement>> r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "parserAction");
        boolean r102 = true;
        int r103 = 0;
        if (r100.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
        LinkedList r105 = new LinkedList();
        if ((r100 instanceof Spanned) == false) goto L12;
        Function1 r106 = new RichTextElementCreator$createTextElementsWithStyleV2$consumeAction$1(r101);
    L14:
        if (r100.length() == 0) goto L17;
        r102 = false;
    L17:
        if (r102 == true) goto L19;
        int r107 = 0;
    L22:
        if (r103 >= r100.length()) goto L33;
    L24:
        if (r103 >= r100.length()) goto L31;
        if (r100.charAt(r103) != '\n') goto L31;
        if (r103 <= r107) goto L29;
        r105.addAll((Collection) r106.invoke(r100.subSequence(r107, r103)));
    L29:
        r105.add(d());
        r103 = r103 + 1;
        r107 = r103;
    L31:
        if (r103 >= r100.length()) goto L22;
        r103 = r103 + 1;
        goto L22
    L33:
        if (r103 <= r107) goto L35;
        r105.addAll((Collection) r106.invoke(r100.subSequence(r107, r103)));
    L35:
        return r105;
    L19:
        return CollectionsKt.emptyList();
    L12:
        r106 = RichTextElementCreator$createTextElementsWithStyleV2$consumeAction$2.INSTANCE;
        goto L14
    L8:
        return CollectionsKt.emptyList();
    L5:
        r104 = false;
        goto L6
    }

    @JvmStatic
    public static final RichTextElement.AtProperty b(String r100, String r101, String r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "userName");
        Intrinsics.checkNotNullParameter(r102, "originChatterName");
        RichTextElement.AtProperty r105 = new RichTextElement.AtProperty();
        r105.setUserId(r100);
        r105.setOriginUserName(r102);
        r105.setContent("@" + r101);
        r105.setOutChatUser(r103);
        r105.setAnonymous(r104);
        return r105;
    }

    @JvmStatic
    public static final RichTextElement.ImageProperty c(String r100, String r101, int r102, int r103, boolean r104, ResourceCleanScene r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "token");
        RichTextElement.ImageProperty r106 = new RichTextElement.ImageProperty();
        r106.setToken(r101);
        r106.setUrls(CollectionsKt.listOf(r100));
        r106.setOriginWidth(r102);
        r106.setOriginHeight(r103);
        r106.setOriginSource(r104);
        r106.setResourceCleanScene(r105);
        return r106;
    }
}
