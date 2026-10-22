package com.larus.doc.impl.util;

import android.os.SystemClock;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.doc.sdk.api.VoiceInputFrom;
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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import vd9.r;

/* JADX INFO: loaded from: classes27.dex */
public final class DocUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocUtils f331466a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f331467b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f331468c = null;

    public DocUtils() {
    }

    static {
        f331466a = new DocUtils();
        f331467b = new Regex("!\\[[^\\]]*]\\([^)]+\\)");
        f331468c = LazyKt.lazy(new a());
    }

    public static String a(Message r210) {
        Intrinsics.checkNotNullParameter(r210, "message");
        boolean r100 = true;
        if (r210.getContentType() == 800) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L24;
        p0 r102 = q0.a(r210);
        if (r102 == null) goto L199;
        p0.a r103 = r102.e();
        if (r103 == null) goto L202;
        String r104 = r103.e();
        if (r104 == null) goto L203;
        String r105 = r103.a();
        if (StringsKt.startsWith$default(r104, "# ", false, 2, null) == true) goto L200;
        r104 = "# ".concat(r104);
    L200:
        return r104 + '\n' + r105;
    L203:
        return "";
    L202:
        return "";
    L199:
        return "";
    L24:
        if (com.larus.im.bean.message.a.b0(r210) == false) goto L157;
        Intrinsics.checkNotNullParameter(r210, "<this>");
        List r106 = r.a(r210);
        if (r106.isEmpty() == true) goto L92;
        LinkedHashSet r107 = new LinkedHashSet();
        Iterator r108 = r106.iterator();
    L30:
        if (r108.hasNext() == false) goto L42;
        Block r109 = (Block) r108.next();
        String r110 = r109.getBlockId();
        if (r109.getBlockType() != BlockType.BLOCK_TYPE_DEEP_THINK.getValue()) goto L30;
        if (r110 != null) goto L35;
    L38:
        boolean r111 = true;
    L39:
        if (r111 == true) goto L30;
        r107.add(r110);
        goto L30
    L35:
        if (r110.length() == 0) goto L38;
        r111 = false;
        goto L39
    L42:
        if (r107.isEmpty() == true) goto L92;
        boolean r112 = true;
    L45:
        if (r112 == false) goto L71;
        Iterator r113 = r106.iterator();
        boolean r114 = false;
    L48:
        if (r113.hasNext() == false) goto L70;
        Block r115 = (Block) r113.next();
        String r116 = r115.getParentId();
        String r117 = r115.getBlockId();
        if (r116 != null) goto L52;
    L55:
        boolean r118 = true;
    L56:
        if (r118 == true) goto L48;
        if (r117 != null) goto L59;
    L62:
        boolean r119 = true;
    L63:
        if (r119 == true) goto L48;
        if (r107.contains(r116) == false) goto L48;
        if (r107.add(r117) == false) goto L48;
        r114 = true;
        goto L48
    L59:
        if (r117.length() == 0) goto L62;
        r119 = false;
        goto L63
    L52:
        if (r116.length() == 0) goto L55;
        r118 = false;
        goto L56
    L70:
        r112 = r114;
        goto L45
    L71:
        ArrayList r120 = new ArrayList();
        Iterator r121 = r106.iterator();
    L73:
        if (r121.hasNext() == false) goto L89;
        Object r122 = r121.next();
        String r123 = ((Block) r122).getBlockId();
        if (r123 != null) goto L77;
    L80:
        boolean r124 = true;
    L81:
        if (r124 == false) goto L83;
    L85:
        boolean r125 = false;
    L86:
        if (r125 == true) goto L73;
        r120.add(r122);
        goto L73
    L83:
        if (r107.contains(r123) == false) goto L85;
        r125 = true;
        goto L86
    L77:
        if (r123.length() == 0) goto L80;
        r124 = false;
        goto L81
    L89:
        if (r120.size() == r106.size()) goto L91;
        FLogger.f375446a.i("DocUtils", "filterThinkingBlocksForOfflineDoc: filtered=" + (r106.size() - r120.size()) + ", total=" + r106.size());
    L91:
        r106 = r120;
    L92:
        List r126 = r106;
        Iterator r127 = r126.iterator();
    L94:
        if (r127.hasNext() == false) goto L105;
        Object r128 = r127.next();
        BlockContent r129 = ((Block) r128).getContent();
        if (r129 == null) goto L102;
        TextBlock r130 = r129.getTextBlock();
        if (r130 == null) goto L102;
        if (r130.scene != TextBlockScene.TEXT_BLOCK_AIDOC.getType()) goto L102;
        boolean r131 = true;
    L103:
        if (r131 == false) goto L94;
    L106:
        Block r132 = (Block) r128;
        if (r132 == null) goto L112;
        String r133 = qf8.a.a(r132, r210);
        if (r133 != null) goto L111;
        r133 = "";
    L111:
        String r134 = new Regex("\\n+").replace(r133, "\n");
    L149:
        if (r134.length() == 0) goto L152;
        r100 = false;
    L152:
        if (r100 == false) goto L201;
        String r135 = d.H(r210);
        if (r135 != null) goto L161;
        return "";
    L161:
        return r135;
    L201:
        return r134;
    L112:
        ArrayList r136 = new ArrayList();
        Iterator r137 = r126.iterator();
    L114:
        if (r137.hasNext() == false) goto L121;
        Object r138 = r137.next();
        if (((Block) r138).getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L118;
        boolean r139 = true;
    L119:
        if (r139 == false) goto L114;
        r136.add(r138);
        goto L114
    L118:
        r139 = false;
        goto L119
    L121:
        ArrayList r140 = new ArrayList();
        Iterator r141 = r136.iterator();
        int r142 = 0;
    L123:
        if (r141.hasNext() == false) goto L147;
        Object r143 = r141.next();
        int r144 = r142 + 1;
        if (r142 >= 0) goto L127;
        CollectionsKt.throwIndexOverflow();
    L127:
        Block r145 = (Block) r143;
        if (r142 != 0) goto L130;
        String r146 = qf8.a.a(r145, r210);
    L136:
        if (r146 != null) goto L138;
    L143:
        r146 = null;
    L144:
        if (r146 == null) goto L146;
        r140.add(r146);
    L146:
        r142 = r144;
        goto L123
    L138:
        if (r146.length() <= 0) goto L140;
        boolean r147 = true;
    L141:
        if (r147 == false) goto L143;
    L140:
        r147 = false;
        goto L141
    L130:
        BlockContent r148 = r145.getContent();
        if (r148 == null) goto L135;
        TextBlock r149 = r148.getTextBlock();
        if (r149 == null) goto L135;
        r146 = r149.text;
    L135:
        r146 = null;
        goto L136
    L147:
        r134 = new Regex("\\n+").replace(CollectionsKt.joinToString$default(r140, "", null, null, 0, null, null, 62, null), "\n");
    L102:
        r131 = false;
        goto L103
    L105:
        r128 = null;
        goto L106
    L157:
        r135 = d.H(r210);
        if (r135 != null) goto L161;
        return "";
    L5:
        if (Intrinsics.areEqual(r210.getBizContentType(), "dora_record") == false) goto L7;
        r101 = true;
        goto L9
    }

    public static String c(String r100) {
        if (r100 != null) goto L4;
    L21:
        return "chat";
    L4:
        switch(r100.hashCode()) {
            case -1140332614: goto L19;
            case 50910586: goto L15;
            case 1506620522: goto L11;
            case 1571879921: goto L7;
            default: goto L21;
        };
    L7:
        if (r100.equals("doc_create_empty") == false) goto L21;
        return VoiceInputFrom.NEW_DOC;
    L11:
        if (r100.equals("doc_exist_content") == false) goto L21;
        return "existing_doc";
    L15:
        if (r100.equals("doc_create_list") == false) goto L21;
        return "doc_manage";
    L19:
        if (r100.equals("doc_ai_edit") == false) goto L21;
        return "basic_edit_left_icon";
    }

    public final Object b(String r110, String r111, Continuation<? super String> r112) {
        if ((r112 instanceof DocUtils$getMessageMarkdownContent$1) == false) goto L7;
        DocUtils$getMessageMarkdownContent$1 r100 = (DocUtils$getMessageMarkdownContent$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        long r114 = r100.J$1;
        long r104 = r100.J$0;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L31:
        Message r115 = (Message) r113;
        long r106 = SystemClock.elapsedRealtime() - r114;
        if (r115 != null) goto L35;
        FLogger.f375446a.i("DocUtils", "getMessageMarkdownContent: message not found, messageId=" + r105 + ", findCost=" + r106 + "ms, totalCost=" + (SystemClock.elapsedRealtime() - r104) + "ms");
        return null;
    L35:
        long r107 = SystemClock.elapsedRealtime();
        String r116 = a(r115);
        long r108 = SystemClock.elapsedRealtime() - r107;
        FLogger.f375446a.i("DocUtils", "getMessageMarkdownContent: messageId=" + r105 + ", findCost=" + r106 + "ms, convertCost=" + r108 + "ms, totalCost=" + (SystemClock.elapsedRealtime() - r104) + "ms, contentLen=" + r116.length());
        return r116;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        long r109 = SystemClock.elapsedRealtime();
        if (Intrinsics.areEqual(r110, "fake_offline_doc_id") == true) goto L18;
        FLogger.f375446a.i("DocUtils", "getMessageMarkdownContent: skip, not offline doc, cost=" + (SystemClock.elapsedRealtime() - r109) + "ms");
        return null;
    L18:
        if (r111 != null) goto L20;
    L23:
        boolean r117 = true;
    L24:
        if (r117 == false) goto L27;
        FLogger.f375446a.i("DocUtils", "getMessageMarkdownContent: skip, messageId empty, cost=" + (SystemClock.elapsedRealtime() - r109) + "ms");
        return null;
    L27:
        long r118 = SystemClock.elapsedRealtime();
        IChatRepoService r119 = zh8.a.f572196a;
        r100.L$0 = r111;
        r100.J$0 = r109;
        r100.J$1 = r118;
        r100.label = 1;
        r113 = r119.E1(r111, r100);
        if (r113 != r102) goto L30;
        return r102;
    L30:
        r105 = r111;
        r104 = r109;
        r114 = r118;
        goto L31
    L20:
        if (r111.length() == 0) goto L23;
        r117 = false;
    L7:
        r100 = new DocUtils$getMessageMarkdownContent$1(this, r112);
        goto L8
    }
}
