package com.ss.android.lark.widget.richtext;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.widget.span.AtInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {
    public static RichText a() {
        RichText r100 = new RichText();
        RichText.RichTextElements r101 = new RichText.RichTextElements();
        r101.setDictionary(new HashMap());
        r100.setElementIds(new ArrayList());
        r100.setImageIds(new ArrayList());
        r100.setAtIds(new ArrayList());
        r100.setAnchorIds(new ArrayList());
        r100.setMediaIds(new ArrayList());
        r100.setAtUserGroupIds(new ArrayList());
        r100.setDocsIds(new ArrayList());
        r100.setMarkdownIds(new ArrayList());
        r100.setElements(r101);
        r100.setInnerText("");
        r100.setRichTextVersion(0);
        return r100;
    }

    public static RichText b(List<RichTextElement> r110) {
        RichText r100 = new RichText();
        ArrayList r101 = new ArrayList();
        HashMap r102 = new HashMap();
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        ArrayList r106 = new ArrayList();
        ArrayList r107 = new ArrayList();
        ArrayList r108 = new ArrayList();
        new LinkedHashMap();
        ArrayList r109 = new ArrayList();
        int r111 = 0;
        int r112 = 0;
        boolean r113 = false;
        boolean r114 = false;
    L4:
        if (r111 >= r110.size()) goto L71;
        String r115 = String.valueOf(r111);
        RichTextElement r116 = (RichTextElement) ListProtector.get(r110, r111);
        r102.put(r115, r116);
        RichText r117 = r100;
        int r118 = r111;
        if (r116.getTag() != RichTextElement.RichTextTag.TEXT) goto L8;
    L19:
        boolean r119 = true;
    L20:
        if (r119 == false) goto L23;
        r109.add(r115);
    L47:
        r113 = false;
        r114 = false;
    L53:
        if (r116.getTag() != RichTextElement.RichTextTag.IMG) goto L56;
        r103.add(r115);
    L70:
        r111 = r118 + 1;
        r100 = r117;
        goto L4
    L56:
        if (r116.getTag() != RichTextElement.RichTextTag.AT) goto L59;
        r104.add(r115);
        goto L70
    L59:
        if (r116.getTag() != RichTextElement.RichTextTag.ANCHOR) goto L62;
        r105.add(r115);
        goto L70
    L62:
        if (r116.getTag() != RichTextElement.RichTextTag.MEDIA) goto L65;
        r106.add(r115);
        goto L70
    L65:
        if (r116.getTag() != RichTextElement.RichTextTag.AT_USER_GROUP) goto L68;
        r107.add(r115);
        goto L70
    L68:
        if (r116.getTag() != RichTextElement.RichTextTag.MARKDOWN) goto L70;
        r108.add(r115);
        goto L70
    L23:
        if (r116.getTag() != RichTextElement.RichTextTag.PARAGRAPH) goto L31;
        if (CollectionUtils.isEmpty(r109) == true) goto L27;
        r116.setChildIds(r109);
        r109.clear();
        r101.add(r115);
        goto L47
    L27:
        if (r113 == true) goto L47;
        if (r114 == true) goto L47;
        r101.add(r115);
        goto L47
    L31:
        if (r116.getTag() == RichTextElement.RichTextTag.IMG) goto L49;
        if (r116.getTag() == RichTextElement.RichTextTag.MEDIA) goto L49;
        if (r116.getTag() != RichTextElement.RichTextTag.CODE_BLOCK_V2) goto L42;
        if (CollectionUtils.isEmpty(r109) == true) goto L40;
        RichTextElement r120 = RichTextElementCreator.d();
        r112 = r112 + 1;
        r120.setChildIds(r109);
        r109.clear();
        String r121 = String.valueOf(r110.size() + r112);
        r102.put(r121, r120);
        r101.add(r121);
    L40:
        RichTextElement r122 = RichTextElementCreator.d();
        ArrayList r123 = new ArrayList();
        r123.add(r115);
        r122.setChildIds(r123);
        r112 = r112 + 1;
        String r124 = String.valueOf(r110.size() + r112);
        r102.put(r124, r122);
        r101.add(r124);
        r114 = true;
        goto L53
    L42:
        if (r116.getTag() != RichTextElement.RichTextTag.MARKDOWN) goto L53;
        if (CollectionUtils.isEmpty(r109) == true) goto L46;
        RichTextElement r125 = RichTextElementCreator.d();
        r112 = r112 + 1;
        r125.setChildIds(r109);
        r109.clear();
        String r126 = String.valueOf(r110.size() + r112);
        r102.put(r126, r125);
        r101.add(r126);
    L46:
        r101.add(r115);
    L49:
        if (CollectionUtils.isEmpty(r109) == true) goto L51;
        RichTextElement r127 = RichTextElementCreator.d();
        r112 = r112 + 1;
        r127.setChildIds(r109);
        r109.clear();
        String r128 = String.valueOf(r110.size() + r112);
        r102.put(r128, r127);
        r101.add(r128);
    L51:
        Map<Class<? extends RichTextElement.RichTextProperty>, RichTextElement.RichTextTag> r129 = RichTextElementCreator.f448209a;
        RichTextElement r130 = RichTextElementCreator.h(new RichTextElement.FigureProperty());
        ArrayList r131 = new ArrayList();
        r131.add(r115);
        r130.setChildIds(r131);
        r112 = r112 + 1;
        String r132 = String.valueOf(r110.size() + r112);
        r102.put(r132, r130);
        r101.add(r132);
        r113 = true;
        goto L53
    L8:
        if (r116.getTag() == RichTextElement.RichTextTag.AT) goto L19;
        if (r116.getTag() == RichTextElement.RichTextTag.EMOTION) goto L19;
        if (r116.getTag() == RichTextElement.RichTextTag.ANCHOR) goto L19;
        if (r116.getTag() == RichTextElement.RichTextTag.MENTION) goto L19;
        if (r116.getTag() == RichTextElement.RichTextTag.AT_USER_GROUP) goto L19;
        r119 = false;
        goto L20
    L71:
        RichText r133 = r100;
        if (CollectionUtils.isEmpty(r109) == true) goto L74;
        RichTextElement r134 = RichTextElementCreator.d();
        int r135 = r110.size();
        String r136 = String.valueOf(r135 + (r112 + 1));
        r102.put(r136, r134);
        r134.setChildIds(r109);
        r109.clear();
        r101.add(r136);
    L74:
        RichText.RichTextElements r137 = new RichText.RichTextElements();
        r137.setDictionary(r102);
        r133.setElementIds(r101);
        r133.setElements(r137);
        r133.setImageIds(r103);
        r133.setAtIds(r104);
        r133.setAnchorIds(r105);
        r133.setMediaIds(r106);
        r133.setAtUserGroupIds(r107);
        r133.setMarkdownIds(r108);
        r133.setExtraInfo(new RichTextExtraInfo());
        return r133;
    }

    public static RichText c(String r110) {
        if (TextUtils.isEmpty(r110) == true) goto L37;
        StringBuilder r100 = new StringBuilder();
        ArrayList r101 = new ArrayList();
        Matcher r102 = com.ss.android.lark.utils.o.f444744a.matcher(r110);
        ArrayList r103 = new ArrayList();
    L7:
        if (r102.find() == false) goto L10;
        AtInfo r104 = new AtInfo();
        r104.start = r102.start();
        r104.end = r102.end();
        r104.userId = r102.group(1);
        r104.text = r102.group(2);
        r103.add(r104);
        goto L7
    L10:
        if (r103.isEmpty() == false) goto L12;
        r101.addAll(d(r110));
        r100.append(r110);
    L31:
        RichText r111 = b(r101);
        r111.setInnerText(r100.toString());
        return r111;
    L12:
        int r105 = 0;
    L14:
        if (r105 >= r103.size()) goto L28;
        AtInfo r106 = (AtInfo) ListProtector.get(r103, r105);
        if (r105 != 0) goto L18;
        int r107 = 0;
    L19:
        String r108 = r110.substring(r107, r106.start);
        if (TextUtils.isEmpty(r108) == true) goto L22;
        r101.addAll(d(r108));
        r100.append(r108);
    L22:
        String r109 = r106.userId;
        String r112 = r106.text.substring(1);
        Map<Class<? extends RichTextElement.RichTextProperty>, RichTextElement.RichTextTag> r113 = RichTextElementCreator.f448209a;
        Intrinsics.checkNotNullParameter("", "originChatterName");
        if (r109 != null) goto L25;
        r109 = "";
    L25:
        if (r112 != null) goto L27;
        r112 = "";
    L27:
        r101.add(RichTextElementCreator.h(RichTextElementCreator.b(r109, r112, "", false, false)));
        r100.append(r106.text);
        r100.append(" ");
        r105 = r105 + 1;
        goto L14
    L18:
        r107 = ((AtInfo) ListProtector.get(r103, r105 - 1)).end;
        goto L19
    L28:
        String r114 = r110.substring(((AtInfo) ListProtector.get(r103, r103.size() - 1)).end);
        if (TextUtils.isEmpty(r114) == true) goto L31;
        r101.addAll(d(r114));
        r100.append(r114);
        goto L31
    L37:
        return a();
    }

    public static List<RichTextElement> d(String r100) {
        ArrayList r101 = new ArrayList();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        char[] r102 = r100.toCharArray();
        StringBuilder r103 = new StringBuilder();
        int r104 = 0;
    L7:
        if (r104 >= r102.length) goto L17;
        char r105 = r102[r104];
        if (r105 != '\n') goto L14;
        String r106 = r103.toString();
        if (TextUtils.isEmpty(r106) == true) goto L13;
        r101.add(RichTextElementCreator.e(r106));
        r103 = new StringBuilder();
    L13:
        r101.add(RichTextElementCreator.d());
    L15:
        r104 = r104 + 1;
        goto L7
    L14:
        r103.append(r105);
        goto L15
    L17:
        if (TextUtils.isEmpty(r103.toString()) == true) goto L19;
        r101.add(RichTextElementCreator.e(r103.toString()));
    L19:
        return r101;
    }
}
