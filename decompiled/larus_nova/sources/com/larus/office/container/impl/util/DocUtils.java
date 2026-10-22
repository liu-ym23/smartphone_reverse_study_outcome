package com.larus.office.container.impl.util;

import android.os.SystemClock;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.bean.message.block.TextBlockScene;
import com.larus.utils.logger.FLogger;
import ic8.p0;
import ic8.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class DocUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocUtils f362145a = null;

    static {
        f362145a = new DocUtils();
    }

    public DocUtils() {
    }

    public final Object a(String r210, String r211, Continuation<? super String> r310) {
        String r100 = r211;
        if ((r310 instanceof DocUtils$getMessageMarkdownContent$1) == false) goto L7;
        DocUtils$getMessageMarkdownContent$1 r101 = (DocUtils$getMessageMarkdownContent$1) r310;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        String r106 = "DocUtils";
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        long r107 = r101.J$1;
        long r110 = r101.J$0;
        r100 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L31:
        Message r108 = (Message) r103;
        long r111 = SystemClock.elapsedRealtime() - r107;
        if (r108 != null) goto L35;
        FLogger.f375446a.i("DocUtils", "getMessageMarkdownContent: message not found, messageId=" + r100 + ", findCost=" + r111 + "ms, totalCost=" + (SystemClock.elapsedRealtime() - r110) + "ms");
        return null;
    L35:
        long r109 = SystemClock.elapsedRealtime();
        if (r108.getContentType() == 800) goto L38;
    L40:
        boolean r112 = false;
    L41:
        String r113 = "";
        if (r112 == false) goto L58;
        p0 r114 = q0.a(r108);
        if (r114 == null) goto L56;
        p0.a r115 = r114.e();
        if (r115 == null) goto L56;
        String r116 = r115.e();
        if (r116 == null) goto L56;
        String r117 = r115.a();
        if (StringsKt.startsWith$default(r116, "# ", false, 2, null) == true) goto L55;
        r116 = "# ".concat(r116);
    L55:
        r113 = r116 + '\n' + r117;
    L56:
        String r118 = "DocUtils";
    L199:
        long r119 = SystemClock.elapsedRealtime() - r109;
        FLogger.f375446a.i(r118, "getMessageMarkdownContent: messageId=" + r100 + ", findCost=" + r111 + "ms, convertCost=" + r119 + "ms, totalCost=" + (SystemClock.elapsedRealtime() - r110) + "ms, contentLen=" + r113.length());
        return r113;
    L58:
        if (com.larus.im.bean.message.a.b0(r108) == false) goto L195;
        List<Block> r120 = com.larus.im.bean.message.a.d(r108);
        if (r120.isEmpty() == false) goto L62;
        String r212 = "";
    L129:
        List<Block> r121 = r120;
        Iterator<T> r122 = r121.iterator();
    L131:
        if (r122.hasNext() == false) goto L142;
        Object r123 = r122.next();
        BlockContent r124 = ((Block) r123).getContent();
        if (r124 == null) goto L139;
        TextBlock r125 = r124.getTextBlock();
        if (r125 == null) goto L139;
        if (r125.scene != TextBlockScene.TEXT_BLOCK_AIDOC.getType()) goto L139;
        boolean r126 = true;
    L140:
        if (r126 == false) goto L131;
    L143:
        Block r127 = (Block) r123;
        if (r127 == null) goto L149;
        String r128 = qf8.a.a(r127, r108);
        if (r128 != null) goto L148;
        r128 = r212;
    L148:
        String r129 = new Regex("\\n+").replace(r128, "\n");
        r118 = "DocUtils";
    L187:
        if (r129.length() != 0) goto L189;
        boolean r130 = true;
    L190:
        if (r130 == false) goto L194;
        String r131 = com.larus.bmhome.chat.bean.d.H(r108);
        if (r131 == null) goto L197;
    L198:
        r113 = r131;
    L197:
        r113 = r212;
        goto L199
    L194:
        r113 = r129;
        goto L199
    L189:
        r130 = false;
        goto L190
    L149:
        ArrayList r132 = new ArrayList();
        Iterator r133 = r121.iterator();
    L151:
        if (r133.hasNext() == false) goto L159;
        Object r134 = r133.next();
        Iterator r213 = r133;
        String r135 = r106;
        if (((Block) r134).getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L155;
        boolean r136 = true;
    L156:
        if (r136 == false) goto L158;
        r132.add(r134);
    L158:
        r133 = r213;
        r106 = r135;
        goto L151
    L155:
        r136 = false;
        goto L156
    L159:
        r118 = r106;
        ArrayList r137 = new ArrayList();
        Iterator r138 = r132.iterator();
        int r139 = 0;
    L161:
        if (r138.hasNext() == false) goto L185;
        Object r140 = r138.next();
        int r141 = r139 + 1;
        if (r139 >= 0) goto L165;
        CollectionsKt.throwIndexOverflow();
    L165:
        Block r142 = (Block) r140;
        if (r139 != 0) goto L168;
        String r143 = qf8.a.a(r142, r108);
    L174:
        if (r143 != null) goto L176;
    L181:
        r143 = null;
    L182:
        if (r143 == null) goto L184;
        r137.add(r143);
    L184:
        r139 = r141;
        goto L161
    L176:
        if (r143.length() <= 0) goto L178;
        boolean r144 = true;
    L179:
        if (r144 == false) goto L181;
    L178:
        r144 = false;
        goto L179
    L168:
        BlockContent r145 = r142.getContent();
        if (r145 == null) goto L173;
        TextBlock r146 = r145.getTextBlock();
        if (r146 == null) goto L173;
        r143 = r146.text;
    L173:
        r143 = null;
        goto L174
    L185:
        r129 = new Regex("\\n+").replace(CollectionsKt.joinToString$default(r137, "", null, null, 0, null, null, 62, null), "\n");
    L139:
        r126 = false;
        goto L140
    L142:
        r123 = null;
        goto L143
    L62:
        LinkedHashSet r147 = new LinkedHashSet();
        Iterator<Block> r148 = r120.iterator();
    L64:
        if (r148.hasNext() == false) goto L76;
        Block r149 = r148.next();
        String r150 = r149.getBlockId();
        String r214 = r113;
        if (r149.getBlockType() != BlockType.BLOCK_TYPE_DEEP_THINK.getValue()) goto L75;
        if (r150 != null) goto L69;
    L72:
        boolean r151 = true;
    L73:
        if (r151 == true) goto L75;
        r147.add(r150);
        goto L75
    L69:
        if (r150.length() == 0) goto L72;
        r151 = false;
    L75:
        r113 = r214;
        goto L64
    L76:
        r212 = r113;
        if (r147.isEmpty() == true) goto L129;
        boolean r152 = true;
    L80:
        if (r152 == false) goto L107;
        Iterator<Block> r153 = r120.iterator();
        boolean r154 = false;
    L83:
        if (r153.hasNext() == false) goto L106;
        Block r155 = r153.next();
        r153 = r153;
        String r156 = r155.getParentId();
        String r157 = r155.getBlockId();
        if (r156 != null) goto L87;
    L90:
        boolean r158 = true;
    L91:
        if (r158 == true) goto L83;
        if (r157 != null) goto L94;
    L97:
        boolean r159 = true;
    L98:
        if (r159 == true) goto L83;
        if (r147.contains(r156) == false) goto L83;
        if (r147.add(r157) == false) goto L83;
        r154 = true;
        goto L83
    L94:
        if (r157.length() == 0) goto L97;
        r159 = false;
        goto L98
    L87:
        if (r156.length() == 0) goto L90;
        r158 = false;
        goto L91
    L106:
        r152 = r154;
        goto L80
    L107:
        ArrayList r160 = new ArrayList();
        Iterator r161 = r120.iterator();
    L109:
        if (r161.hasNext() == false) goto L126;
        Object r162 = r161.next();
        Iterator r215 = r161;
        String r163 = ((Block) r162).getBlockId();
        if (r163 != null) goto L113;
    L116:
        boolean r164 = true;
    L117:
        if (r164 == false) goto L119;
    L121:
        boolean r165 = false;
    L122:
        if (r165 == true) goto L124;
        r160.add(r162);
    L124:
        r161 = r215;
        goto L109
    L119:
        if (r147.contains(r163) == false) goto L121;
        r165 = true;
        goto L122
    L113:
        if (r163.length() == 0) goto L116;
        r164 = false;
        goto L117
    L126:
        if (r160.size() == r120.size()) goto L128;
        FLogger.f375446a.i("DocUtils", "filterThinkingBlocksForOfflineDoc: filtered=" + (r120.size() - r160.size()) + ", total=" + r120.size());
    L128:
        r120 = r160;
        goto L129
    L195:
        r118 = "DocUtils";
        r212 = "";
        r131 = com.larus.bmhome.chat.bean.d.H(r108);
        if (r131 != null) goto L198;
    L38:
        if (Intrinsics.areEqual(r108.getBizContentType(), "dora_record") == false) goto L40;
        r112 = true;
        goto L41
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r110 = SystemClock.elapsedRealtime();
        if (Intrinsics.areEqual(r210, "fake_offline_doc_id") == true) goto L18;
        FLogger.f375446a.i("DocUtils", "getMessageMarkdownContent: skip, not offline doc, cost=" + (SystemClock.elapsedRealtime() - r110) + "ms");
        return null;
    L18:
        if (r100 != null) goto L20;
    L23:
        boolean r166 = true;
    L24:
        if (r166 == false) goto L27;
        FLogger.f375446a.i("DocUtils", "getMessageMarkdownContent: skip, messageId empty, cost=" + (SystemClock.elapsedRealtime() - r110) + "ms");
        return null;
    L27:
        long r167 = SystemClock.elapsedRealtime();
        IChatRepoService r168 = zh8.a.f572196a;
        IChatRepoService r169 = zh8.a.f572196a;
        r101.L$0 = r100;
        r101.J$0 = r110;
        r101.J$1 = r167;
        r101.label = 1;
        r103 = r169.E1(r100, r101);
        if (r103 != r104) goto L30;
        return r104;
    L30:
        r107 = r167;
        goto L31
    L20:
        if (r211.length() == 0) goto L23;
        r166 = false;
    L7:
        r101 = new DocUtils$getMessageMarkdownContent$1(this, r310);
        goto L8
    }
}
