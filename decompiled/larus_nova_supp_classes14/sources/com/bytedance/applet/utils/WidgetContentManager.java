package com.bytedance.applet.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TagEnum;
import com.larus.im.bean.message.block.AppletBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockMetaInfo;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.RichMediaType;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WidgetContentManager {
    public static final WidgetContentManager a = null;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ String a;
        public final /* synthetic */ CompletableDeferred<Boolean> b;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("WidgetContentManager", "updateWidgetContent remote update fail, msgId=" + this.a + " error=" + r4.getExt());
            this.b.complete(Boolean.FALSE);
        }

        public final void onSuccess(Object r3) {
            Intrinsics.checkNotNullParameter((Message) r3, "result");
            FLogger.a.i("WidgetContentManager", "updateWidgetContent success msgId=" + this.a);
            this.b.complete(Boolean.TRUE);
        }

        public a(String r1, CompletableDeferred<Boolean> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = new WidgetContentManager();
    }

    public WidgetContentManager() {
    }

    public static String b(String r5) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L28;
        return null;
    L28:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r6 = Result.constructor-impl(new JSONObject(r5).optString("mixture_card_id", ""));     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r6) == false) goto L19;
        r6 = null;
    L19:
        String r7 = (String) r6;
        if (r7 != null) goto L22;
        return null;
    L22:
        if (r7.length() > 0) goto L25;
        r0 = false;
    L25:
        if (r0 == true) goto L27;
        return null;
    L27:
        return r7;
    L14:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r2 = false;
        goto L10
    }

    public static String a(String r5, String r6, String r7) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L37;
        FLogger.a.e("WidgetContentManager", "buildNewRenderData oldRenderData is null or blank");
        return null;
    L37:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        Object r8 = Result.constructor-impl(new JSONObject(r5));     // Catch: Throwable -> L15
    L18:
        if (Result.exceptionOrNull-impl(r8) != null) goto L35;
        JSONObject r9 = (JSONObject) r8;
        if (r6.length() > 0) goto L23;
        r0 = false;
    L23:
        if (r0 == false) goto L25;
        r9.put("widget_id", r6);
    L25:
        Object r1 = r9.opt("widget_data");
        if ((r1 instanceof String) == false) goto L29;
        r9.put("widget_data", r7);
        return r9.toString();
    L29:
        FLogger r10 = FLogger.a;
        StringBuilder r11 = new StringBuilder("buildNewRenderData widget_data is not string(type=");
        if (r1 == null) goto L32;
        String r12 = r1.getClass().getSimpleName();
    L33:
        r11.append(r12);
        r11.append(')');
        r10.e("WidgetContentManager", r11.toString());
        return null;
    L32:
        r12 = "missing";
        goto L33
    L35:
        FLogger.a.e("WidgetContentManager", "buildNewRenderData parse renderData failed");
        return null;
    L15:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r2 = false;
        goto L10
    }

    public final Object c(String r105, String r106, String r107, String r108, Continuation<? super Boolean> r109) {
        String r1 = r106;
        if ((r109 instanceof WidgetContentManager$updateWidgetContent$1) == false) goto L7;
        WidgetContentManager$updateWidgetContent$1 r3 = (WidgetContentManager$updateWidgetContent$1) r109;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L155:
        return r2;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r0 = (String) r3.L$3;
        String r7 = (String) r3.L$2;
        String r8 = (String) r3.L$1;
        String r11 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r9 = r0;
        Object r10 = r2;
        String r12 = r7;
        r1 = r8;
    L27:
        Message r13 = (Message) r10;
        if (r13 != null) goto L31;
        FLogger.a.e("WidgetContentManager", "updateWidgetContent message not found, msgId=" + r11);
        return Boxing.boxBoolean(false);
    L31:
        List r14 = r13.getContentBlock();
        if (r14 != null) goto L34;
    L38:
        Intrinsics.checkNotNullParameter(r13, "<this>");
        r14 = vd9.r.a(r13);
        if ((!r14.isEmpty()) == true) goto L42;
        r14 = null;
    L42:
        if (r14 != null) goto L44;
        WidgetContentManager$updateWidgetContent$1 r30 = r3;
        Object r29 = r5;
        String r31 = r11;
    L141:
        List r15 = null;
    L142:
        List r16 = r15;
        if (r16 != null) goto L145;
    L148:
        boolean r17 = true;
    L149:
        if (r17 == false) goto L152;
        FLogger.a.e("WidgetContentManager", "updateWidgetContent build failed, msgId=" + r31);
        return Boxing.boxBoolean(false);
    L152:
        String r18 = r31;
        CompletableDeferred r19 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.larus.im.d.e().w(r18, r15, new a(r18, r19));
        WidgetContentManager$updateWidgetContent$1 r20 = r30;
        r20.L$0 = null;
        r20.L$1 = null;
        r20.L$2 = null;
        r20.L$3 = null;
        r20.label = 2;
        r2 = r19.await(r20);
        Object r21 = r29;
        if (r2 != r21) goto L155;
        return r21;
    L145:
        if (r16.isEmpty() == true) goto L148;
        r17 = false;
    L44:
        List r110 = r14;
        Iterator r111 = r110.iterator();
        int r22 = 0;
    L46:
        if (r111.hasNext() == false) goto L140;
        int r112 = r22 + 1;
        Block r113 = (Block) r111.next();
        if (r113.getBlockType() != BlockType.BLOCK_TYPE_WIDGET.getValue()) goto L71;
        BlockContent r23 = r113.getContent();
        if (r23 == null) goto L79;
        AppletBlock r24 = r23.getAppletBlock();
        if (r24 == null) goto L79;
        if (r1.length() <= 0) goto L57;
        boolean r25 = true;
    L58:
        if (r25 == true) goto L60;
    L62:
        String r114 = a(r24.renderData, r12, r9);
        if (r114 == null) goto L79;
        BlockContent r28 = r113.getContent();
        if (r28 == null) goto L68;
        BlockContent r26 = BlockContent.copy$default(r28, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, AppletBlock.copy$default(r24, r114, null, null, null, null, 30, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.MAX_VALUE, -1, 31, null);
    L69:
        Block r27 = Block.copy$default(r113, 0, null, null, r26, false, null, null, null, 247, null);
    L80:
        r30 = r3;
        r29 = r5;
        r31 = r11;
        Iterator r1010 = r111;
    L137:
        if (r27 != null) goto L139;
        r111 = r1010;
        r22 = r112;
        r5 = r29;
        r3 = r30;
        r11 = r31;
        goto L46
    L139:
        r15 = CollectionsKt.toMutableList(r110);
        ListProtector.set(r15, r22, r27);
        goto L142
    L68:
        r26 = null;
        goto L69
    L60:
        if (Intrinsics.areEqual(b(r24.renderData), r1) == true) goto L62;
    L57:
        r25 = false;
    L79:
        r27 = null;
        goto L80
    L71:
        if (r113.getBlockType() == BlockType.BLOCK_TYPE_TEXT.getValue()) goto L73;
    L136:
        r30 = r3;
        r29 = r5;
        r31 = r11;
        r1010 = r111;
        r27 = null;
        goto L137
    L73:
        if (r1.length() <= 0) goto L75;
        boolean r32 = true;
    L76:
        if (r32 == false) goto L136;
        List r33 = r113.getMetaInfo();
        if (r33 == null) goto L79;
        Iterator r115 = r33.iterator();
        int r116 = 0;
    L83:
        if (r115.hasNext() == false) goto L136;
        int r117 = r116 + 1;
        BlockMetaInfo r34 = (BlockMetaInfo) r115.next();
        if (r34.type != TagEnum.TagEnum_InsertText_BLOCK.value) goto L134;
        String r35 = r34.getRealInfo();
        if (r35 != null) goto L156;
    L101:
        r30 = r3;
        r29 = r5;
        r31 = r11;
        r1010 = r111;
    L130:
        BlockMetaInfo r36 = null;
    L131:
        if (r36 == null) goto L135;
        List r37 = CollectionsKt.toMutableList(r33);
        ListProtector.set(r37, r116, r36);
        r27 = Block.copy$default(r113, 0, null, null, null, false, null, null, r37, 127, null);
    L135:
        r111 = r1010;
        r116 = r117;
        r5 = r29;
        r3 = r30;
        r11 = r31;
        goto L83
    L156:
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L91
        Object r39 = Result.constructor-impl(new JSONObject(r35));     // Catch: Throwable -> L91
    L94:
        if (Result.isFailure-impl(r39) == false) goto L96;
        r39 = null;
    L96:
        JSONObject r40 = (JSONObject) r39;
        if (r40 == null) goto L101;
        JSONArray r41 = r40.optJSONArray("media");
        if (r41 == null) goto L101;
        r1010 = r111;
        int r118 = r41.length();
        r29 = r5;
        int r42 = 0;
    L103:
        if (r42 >= r118) goto L129;
        int r1011 = r118;
        JSONObject r119 = r41.optJSONObject(r42);
        if (r119 != null) goto L108;
        r30 = r3;
        JSONArray r1012 = r41;
    L107:
        r31 = r11;
    L128:
        r42 = r42 + 1;
        r118 = r1011;
        r41 = r1012;
        r3 = r30;
        r11 = r31;
        goto L103
    L108:
        r1012 = r41;
        r30 = r3;
        if (r119.optInt("type") != RichMediaType.APPLET.getValue()) goto L107;
        JSONObject r43 = r119.optJSONObject("applet");
        if (r43 == null) goto L107;
        String r44 = r43.optString("render_data", "");
        Intrinsics.checkNotNull(r44);
        if (r44.length() != 0) goto L116;
        boolean r210 = true;
    L117:
        if (r210 == true) goto L107;
        r31 = r11;
        if (Intrinsics.areEqual(b(r44), r1) == false) goto L128;
        String r45 = a(r44, r12, r9);
        if (r45 == null) goto L130;
        r43.put("render_data", r45);
        if (r34.infoV2 == null) goto L127;
        r36 = BlockMetaInfo.copy$default(r34, 0, null, r40.toString(), 3, null);
        goto L131
    L127:
        r36 = BlockMetaInfo.copy$default(r34, 0, r40.toString(), null, 5, null);
        goto L131
    L116:
        r210 = false;
        goto L117
    L129:
        r30 = r3;
        r31 = r11;
    L91:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L94
    L134:
        r30 = r3;
        r29 = r5;
        r31 = r11;
        r1010 = r111;
        goto L135
    L75:
        r32 = false;
        goto L76
    L140:
        r30 = r3;
        r29 = r5;
        r31 = r11;
        FLogger.a.e("WidgetContentManager", "buildUpdatedBlocks no matching card found for cardId=" + r1 + ", msgId=" + r13.getMessageId());
        goto L141
    L34:
        if ((!r14.isEmpty()) == true) goto L37;
        r14 = null;
    L37:
        if (r14 != null) goto L44;
    L16:
        ResultKt.throwOnFailure(r2);
        FLogger r47 = FLogger.a;
        r47.i("WidgetContentManager", "updateWidgetContent start msgId=" + r105 + " cardId=" + r1 + " widgetDataLen=" + r108.length());
        if (r108.length() != 0) goto L19;
        boolean r48 = true;
    L20:
        if (r48 == false) goto L23;
        r47.e("WidgetContentManager", "updateWidgetContent widgetData is empty, msgId=" + r105);
        return Boxing.boxBoolean(false);
    L23:
        IChatRepoService r49 = zh8.a.a;
        r3.L$0 = r105;
        r3.L$1 = r1;
        r12 = r107;
        r3.L$2 = r12;
        r3.L$3 = r108;
        r3.label = 1;
        Object r50 = r49.E1(r105, r3);
        if (r50 != r5) goto L26;
        return r5;
    L26:
        r11 = r105;
        r10 = r50;
        r9 = r108;
        goto L27
    L19:
        r48 = false;
    L7:
        r3 = new WidgetContentManager$updateWidgetContent$1(this, r109);
        goto L8
    }
}
