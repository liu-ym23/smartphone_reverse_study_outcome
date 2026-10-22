package com.larus.im.internal.network.chunk.receiver;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.internal.core.message.MessageHandler;
import com.larus.im.internal.core.message.converter.MessageEntityConverterKt;
import com.larus.im.internal.core.message.receiver.MessageReceiver;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.protocol.bean.DownlinkMessage;
import com.larus.im.internal.protocol.bean.FetchChunkMessageDownlinkBody;
import com.larus.im.internal.protocol.bean.MessageStatus;
import com.larus.im.internal.protocol.bean.SuggestQuestion;
import com.larus.im.internal.protocol.bean.UplinkMessageChannel;
import com.larus.im.internal.stream.StreamChannel;
import com.larus.im.internal.tracking.FlowImTracingProxy;
import com.larus.im.internal.tracking.MessageSuggestFrom;
import com.larus.im.internal.utils.l;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nuc.v2;
import ouc.d0;
import ouc.g0;
import ouc.k;

/* JADX INFO: loaded from: classes30.dex */
public final class HttpDownlinkChunkReceiver implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.im.internal.network.chunk.e.a f349149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f349150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.im.internal.core.message.utils.sync.c f349151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f349152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f349153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f349154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f349155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.im.internal.network.chunk.cache.a.C4363a f349156h;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.im.internal.network.chunk.receiver.b
    public final com.larus.im.internal.network.chunk.cache.a.C4363a getTask() {
        return this.f349156h;
    }

    public HttpDownlinkChunkReceiver(com.larus.im.internal.network.chunk.e.a r100, long r101, com.larus.im.internal.core.message.utils.sync.c r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r102, "looper");
        this.f349149a = r100;
        this.f349150b = r101;
        this.f349151c = r102;
        String r103 = r100.f349112g.getMessageId();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        this.f349154f = r103;
        String r105 = r100.f349113h.token;
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        this.f349155g = r105;
        String r106 = r100.f349112g.getConversationId();
        if (r106 == null) goto L12;
        r104 = r106;
    L12:
        this.f349156h = new com.larus.im.internal.network.chunk.cache.a.C4363a(r103, r105, r104, UplinkMessageChannel.DEFAULT.value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.im.internal.network.chunk.receiver.b
    public final Object a(int r810, com.larus.im.internal.network.e<DownlinkMessage> r811, Continuation<? super Unit> r910) {
        if ((r910 instanceof HttpDownlinkChunkReceiver$receiveDownlink$1) == false) goto L7;
        HttpDownlinkChunkReceiver$receiveDownlink$1 r100 = (HttpDownlinkChunkReceiver$receiveDownlink$1) r910;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r100.label) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L31;
            case 6: goto L30;
            case 7: goto L29;
            case 8: goto L28;
            case 9: goto L27;
            case 10: goto L26;
            case 11: goto L25;
            case 12: goto L24;
            case 13: goto L23;
            case 14: goto L22;
            case 15: goto L21;
            case 16: goto L20;
            case 17: goto L19;
            case 18: goto L19;
            case 19: goto L18;
            case 20: goto L17;
            case 21: goto L16;
            case 22: goto L15;
            case 23: goto L15;
            case 24: goto L14;
            case 25: goto L13;
            case 26: goto L12;
            default: goto L11;
        };
    L12:
        com.larus.im.internal.tracking.b r103 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L264:
        vt7.b<com.larus.im.internal.network.chunk.cache.a.C4363a> r104 = com.larus.im.internal.network.chunk.cache.a.f349088a;
        com.larus.im.internal.network.chunk.cache.a.e(this.f349156h);
        FlowImTracingProxy.f350219a.w(r103);
        Unit r105 = Unit.INSTANCE;
    L266:
        return Unit.INSTANCE;
    L13:
        StreamChannel r106 = (StreamChannel) r100.L$1;
        com.larus.im.internal.tracking.b r107 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r111 = null;
        StreamChannel r108 = r106;
        com.larus.im.internal.tracking.b r109 = r107;
    L260:
        r100.L$0 = r109;
        r100.L$1 = r111;
        r100.label = 26;
        if (StreamChannel.b(r108, (Message) r102, false, r100, 6) != r110) goto L263;
        return r110;
    L263:
        r103 = r109;
        goto L264
    L14:
        r109 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = null;
    L256:
        StreamChannel r112 = StreamChannel.f350095a;
        MessageEntity r113 = this.f349149a.f349112g;
        r100.L$0 = r109;
        r100.L$1 = r112;
        r100.label = 25;
        Object r114 = MessageEntityConverterKt.a(r113, r100);
        if (r114 != r110) goto L259;
        return r110;
    L259:
        r108 = r112;
        r102 = r114;
        goto L260
    L15:
        r109 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = null;
    L253:
        MessageReceiver r115 = MessageReceiver.f347815a;
        String r116 = this.f349149a.f349112g.getConversationId();
        r100.L$0 = r109;
        r100.label = 24;
        if (MessageReceiver.f(r116, r100) != r110) goto L256;
        return r110;
    L16:
        com.larus.im.internal.tracking.b r117 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L243:
        vt7.b<com.larus.im.internal.network.chunk.cache.a.C4363a> r118 = com.larus.im.internal.network.chunk.cache.a.f349088a;
        com.larus.im.internal.network.chunk.cache.a.e(this.f349156h);
        FlowImTracingProxy.f350219a.e(r117);
        Unit r119 = Unit.INSTANCE;
        goto L266
    L17:
        StreamChannel r120 = (StreamChannel) r100.L$1;
        com.larus.im.internal.tracking.b r121 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = null;
        StreamChannel r122 = r120;
        com.larus.im.internal.tracking.b r123 = r121;
    L239:
        r100.L$0 = r123;
        r100.L$1 = r111;
        r100.label = 21;
        if (StreamChannel.b(r122, (Message) r102, false, r100, 6) != r110) goto L242;
        return r110;
    L242:
        r117 = r123;
        goto L243
    L18:
        r123 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = null;
    L235:
        StreamChannel r124 = StreamChannel.f350095a;
        MessageEntity r125 = this.f349149a.f349112g;
        r100.L$0 = r123;
        r100.L$1 = r124;
        r100.label = 20;
        Object r126 = MessageEntityConverterKt.a(r125, r100);
        if (r126 != r110) goto L238;
        return r110;
    L238:
        r122 = r124;
        r102 = r126;
        goto L239
    L19:
        r123 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = null;
    L232:
        MessageReceiver r127 = MessageReceiver.f347815a;
        String r128 = this.f349149a.f349112g.getConversationId();
        r100.L$0 = r123;
        r100.label = 19;
        if (MessageReceiver.f(r128, r100) != r110) goto L235;
        return r110;
    L20:
        com.larus.im.internal.tracking.b r129 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L220:
        vt7.b<com.larus.im.internal.network.chunk.cache.a.C4363a> r130 = com.larus.im.internal.network.chunk.cache.a.f349088a;
        com.larus.im.internal.network.chunk.cache.a.e(this.f349156h);
        FlowImTracingProxy.f350219a.v(r129);
        Unit r131 = Unit.INSTANCE;
        goto L266
    L21:
        StreamChannel r132 = (StreamChannel) r100.L$1;
        com.larus.im.internal.tracking.b r133 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = null;
        StreamChannel r134 = r132;
        com.larus.im.internal.tracking.b r135 = r133;
    L216:
        r100.L$0 = r135;
        r100.L$1 = r111;
        r100.label = 16;
        if (StreamChannel.b(r134, (Message) r102, false, r100, 6) != r110) goto L219;
        return r110;
    L219:
        r129 = r135;
        goto L220
    L22:
        r135 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = null;
    L212:
        StreamChannel r136 = StreamChannel.f350095a;
        MessageEntity r137 = this.f349149a.f349112g;
        r100.L$0 = r135;
        r100.L$1 = r136;
        r100.label = 15;
        Object r138 = MessageEntityConverterKt.a(r137, r100);
        if (r138 != r110) goto L215;
        return r110;
    L215:
        r134 = r136;
        r102 = r138;
        goto L216
    L23:
        r135 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = null;
    L209:
        MessageReceiver r139 = MessageReceiver.f347815a;
        String r140 = this.f349149a.f349112g.getConversationId();
        r100.L$0 = r135;
        r100.label = 14;
        if (MessageReceiver.f(r140, r100) != r110) goto L212;
        return r110;
    L24:
        com.larus.im.internal.tracking.b r141 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L200:
        vt7.b<com.larus.im.internal.network.chunk.cache.a.C4363a> r142 = com.larus.im.internal.network.chunk.cache.a.f349088a;
        com.larus.im.internal.network.chunk.cache.a.e(this.f349156h);
        FlowImTracingProxy.f350219a.j(r141);
        Unit r143 = Unit.INSTANCE;
        goto L266
    L25:
        com.larus.im.internal.tracking.b r144 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L196:
        MessageReceiver r145 = MessageReceiver.f347815a;
        String r146 = this.f349149a.f349112g.getConversationId();
        r100.L$0 = r144;
        r100.label = 12;
        if (MessageReceiver.f(r146, r100) != r110) goto L199;
        return r110;
    L199:
        r141 = r144;
        goto L200
    L26:
        MessageHandler r147 = (MessageHandler) r100.L$1;
        com.larus.im.internal.tracking.b r148 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = null;
    L192:
        r100.L$0 = r148;
        r100.L$1 = r111;
        r100.label = 11;
        r147.getClass();
        if (MessageHandler.q((Message) r102, r100) != r110) goto L195;
        return r110;
    L195:
        r144 = r148;
        goto L196
    L27:
        com.larus.im.internal.tracking.b r149 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r148 = r149;
        r111 = null;
    L189:
        r147 = MessageHandler.f347752a;
        MessageEntity r150 = this.f349149a.f349112g;
        r100.L$0 = r148;
        r100.L$1 = r147;
        r100.label = 10;
        r102 = MessageEntityConverterKt.a(r150, r100);
        if (r102 != r110) goto L192;
        return r110;
    L28:
        com.larus.im.internal.tracking.b r151 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L181:
        vt7.b<com.larus.im.internal.network.chunk.cache.a.C4363a> r152 = com.larus.im.internal.network.chunk.cache.a.f349088a;
        com.larus.im.internal.network.chunk.cache.a.e(this.f349156h);
        FlowImTracingProxy.f350219a.n(r151);
        Unit r153 = Unit.INSTANCE;
        goto L266
    L29:
        StreamChannel r154 = (StreamChannel) r100.L$1;
        com.larus.im.internal.tracking.b r155 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = null;
        StreamChannel r156 = r154;
        com.larus.im.internal.tracking.b r157 = r155;
    L177:
        r100.L$0 = r157;
        r100.L$1 = r111;
        r100.label = 8;
        if (StreamChannel.b(r156, (Message) r102, false, r100, 6) != r110) goto L180;
        return r110;
    L180:
        r151 = r157;
        goto L181
    L30:
        r157 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = null;
    L173:
        StreamChannel r158 = StreamChannel.f350095a;
        MessageEntity r159 = this.f349149a.f349112g;
        r100.L$0 = r157;
        r100.L$1 = r158;
        r100.label = 7;
        Object r160 = MessageEntityConverterKt.a(r159, r100);
        if (r160 != r110) goto L176;
        return r110;
    L176:
        r156 = r158;
        r102 = r160;
        goto L177
    L31:
        r157 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = null;
    L170:
        MessageReceiver r161 = MessageReceiver.f347815a;
        String r162 = this.f349149a.f349112g.getConversationId();
        r100.L$0 = r157;
        r100.label = 6;
        if (MessageReceiver.f(r162, r100) != r110) goto L173;
        return r110;
    L32:
        FetchChunkMessageDownlinkBody r163 = (FetchChunkMessageDownlinkBody) r100.L$0;
        ResultKt.throwOnFailure(r102);
        List<SuggestQuestion> r164 = null;
    L134:
        List<SuggestQuestion> r165 = r163.suggestQuestions;
        List<SuggestQuestion> r166 = r165;
        if (r166 != null) goto L137;
    L140:
        boolean r167 = true;
    L142:
        if ((!r167) == false) goto L144;
        List<SuggestQuestion> r168 = r165;
    L145:
        if (r168 == null) goto L266;
        FlowImTracingProxy r169 = FlowImTracingProxy.f350219a;
        MessageSuggestFrom r170 = MessageSuggestFrom.CHUNK;
        String r171 = r163.messageId;
        if (r171 != null) goto L149;
        String r172 = "";
    L150:
        String r173 = this.f349149a.f349112g.getReplyId();
        if (r173 != null) goto L153;
        String r174 = "";
    L154:
        Map<String, String> r175 = r163.ext;
        if (r175 == null) goto L157;
        String r176 = r175.get("intention");
    L158:
        r169.f(r170, r172, r174, r168, r176);
        Unit r177 = Unit.INSTANCE;
        goto L266
    L157:
        r176 = r164;
        goto L158
    L153:
        r174 = r173;
        goto L154
    L149:
        r172 = r171;
        goto L150
    L144:
        r168 = r164;
        goto L145
    L137:
        if (r166.isEmpty() == true) goto L140;
        r167 = false;
        goto L142
    L33:
        MessageEntity r178 = (MessageEntity) r100.L$2;
        FetchChunkMessageDownlinkBody r179 = (FetchChunkMessageDownlinkBody) r100.L$1;
        com.larus.im.internal.tracking.b r180 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r164 = null;
    L129:
        vt7.b<com.larus.im.internal.network.chunk.cache.a.C4363a> r181 = com.larus.im.internal.network.chunk.cache.a.f349088a;
        com.larus.im.internal.network.chunk.cache.a.f(this.f349155g, r179.seqNo);
        MessageEntity r210 = r178;
        com.larus.im.internal.tracking.b r182 = r180;
    L130:
        FlowImTracingProxy r183 = FlowImTracingProxy.f350219a;
        com.larus.im.internal.tracking.b r184 = com.larus.im.internal.tracking.b.a(r182, 0, 0, null, null, null, null, r210, 255);
        r100.L$0 = r179;
        r100.L$1 = r164;
        r100.L$2 = r164;
        r100.label = 3;
        if (r183.g(r184, r100) != r110) goto L133;
        return r110;
    L133:
        r163 = r179;
        goto L134
    L34:
        MessageEntity r185 = (MessageEntity) r100.L$2;
        r179 = (FetchChunkMessageDownlinkBody) r100.L$1;
        com.larus.im.internal.tracking.b r186 = (com.larus.im.internal.tracking.b) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L124:
        r210 = r185;
        r182 = r186;
        r164 = null;
        goto L130
    L35:
        ResultKt.throwOnFailure(r102);
        com.larus.im.internal.network.e r187 = com.larus.im.internal.network.stragery.f.b(r811, new com.larus.im.internal.network.chunk.receiver.a());
        long r188 = com.larus.im.internal.network.stragery.a.a(this.f349150b);
        com.larus.im.internal.network.chunk.e.a r189 = this.f349149a;
        MessageEntity r190 = r189.f349112g;
        String r191 = this.f349155g;
        String r192 = r189.f349113h.acceptBinaryType;
        if (r192 != null) goto L38;
        String r211 = "";
    L39:
        int r193 = this.f349152d + 1;
        this.f349152d = r193;
        com.larus.im.internal.tracking.b r194 = new com.larus.im.internal.tracking.b(r188, r193, r187.b(), r191, r211, r187, r190);
        if ((r187 instanceof com.larus.im.internal.network.e.f) == false) goto L159;
        FetchChunkMessageDownlinkBody r195 = (FetchChunkMessageDownlinkBody) ((com.larus.im.internal.network.e.f) r187).f349185a;
        if (this.f349153e == false) goto L44;
    L47:
        boolean r196 = true;
    L48:
        this.f349153e = r196;
        int r197 = com.larus.im.internal.network.chunk.a.f349081a;
        StringBuilder r198 = new StringBuilder("fetchByChunk(");
        r198.append(this.f349154f);
        r198.append("): ");
        Intrinsics.checkNotNullParameter(r195, "<this>");
        String r212 = l.f(r195.content);
        List<SuggestQuestion> r199 = r195.suggestQuestions;
        if (r199 == null) goto L58;
        Intrinsics.checkNotNullParameter(r199, "<this>");
        List<SuggestQuestion> r200 = r199;
        ArrayList r1100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r200, 10));
        Iterator<T> r201 = r200.iterator();
    L52:
        if (r201.hasNext() == false) goto L57;
        SuggestQuestion r202 = (SuggestQuestion) r201.next();
        String r1101 = l.c(r202.content);
        if (r1101 != null) goto L56;
        r1101 = "";
    L56:
        r1100.add(r202.copy(r1101));
        goto L52
    L57:
        ArrayList r213 = r1100;
    L59:
        List<d0> r203 = r195.suggestQuestionsV2;
        if (r203 == null) goto L79;
        List<d0> r204 = r203;
        ArrayList r205 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r204, 10));
        Iterator<T> r206 = r204.iterator();
    L63:
        if (r206.hasNext() == false) goto L78;
        d0 r1102 = (d0) r206.next();
        Intrinsics.checkNotNullParameter(r1102, "<this>");
        Result.Companion r1103 = Result.Companion;     // Catch: Throwable -> L70
        ouc.i r1104 = (ouc.i) r1102.get("content");     // Catch: Throwable -> L70
        if ((r1104 instanceof g0) == false) goto L68;
        String r207 = k.g((g0) r1104);     // Catch: Throwable -> L70
        Map r1105 = MapsKt.toMutableMap(r1102);     // Catch: Throwable -> L70
        r1105.put("content", k.c(r207));     // Catch: Throwable -> L70
        new d0(r1105);     // Catch: Throwable -> L70
    L68:
        Object r208 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L70
    L73:
        if (Result.m9455isFailureimpl(r208) == false) goto L77;
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L77;
        com.larus.im.internal.delegate.a.f348188b.e("IMSecureInnerKtx", "failed secure suggest v2");
    L77:
        r205.add(r1102);
    L70:
        th = move-exception;
        Result.Companion r209 = Result.Companion;
        r208 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L73
    L78:
        ArrayList r214 = r205;
    L80:
        String r215 = r195.brief;
        if (r215 == null) goto L83;
        String r310 = l.c(r215);
    L84:
        Map<String, String> r216 = r195.ext;
        if (r216 == null) goto L87;
        Map<String, String> r217 = l.b(r216);
    L88:
        r198.append(FetchChunkMessageDownlinkBody.copy$default(r195, 0, null, 0, 0, r212, null, null, 0, r217, r213, r214, null, r310, 2287, null));
        r198.append(", finish = ");
        r198.append(this.f349153e);
        com.larus.im.internal.utils.b.c("HttpChunkReceiver", r198.toString());
        int r218 = r195.seqNo;
        vt7.b<com.larus.im.internal.network.chunk.cache.a.C4363a> r219 = com.larus.im.internal.network.chunk.cache.a.f349088a;
        if (r218 > com.larus.im.internal.network.chunk.cache.a.b(this.f349155g)) goto L92;
        int r220 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("HttpChunkReceiver", "fetchByChunk(" + this.f349154f + "): seqNo " + r195.seqNo + " is exist");
        return Unit.INSTANCE;
    L92:
        MessageEntity r221 = this.f349149a.f349112g;
        String r222 = this.f349154f;
        if (this.f349153e == false) goto L95;
        int r410 = 21;
    L96:
        int r223 = r195.status;
        if (r223 == MessageStatus.MessageStatus_AVAILABLE.value) goto L99;
    L101:
        int r224 = r195.status;
    L102:
        int r411 = r224;
        int r225 = r195.contentType;
        int r412 = r195.getBeforeContentType();
        if (r195.isNewBlockType() == false) goto L105;
        String r226 = com.larus.im.internal.core.message.converter.a.a(r195.contentBlock, kuc.a.b(Block.Companion.serializer()));
    L106:
        String r510 = r226;
        String r511 = r195.getThinkingContent();
        Map<String, String> r227 = r195.ext;
        if (r227 != null) goto L109;
        r227 = MapsKt.emptyMap();
    L109:
        Map r228 = MapsKt.toMutableMap(r227);
        List<d0> r229 = r195.suggestQuestionsV2;
        if (r229 != null) goto L112;
    L115:
        boolean r230 = true;
    L116:
        if (r230 == true) goto L118;
        r228.put("sp_v2", com.larus.im.internal.core.message.converter.a.a(r195.suggestQuestionsV2, kuc.a.b(d0.Companion.serializer())));
    L118:
        StringCompanionObject r231 = StringCompanionObject.INSTANCE;
        kuc.a.f(r231);
        v2 r232 = v2.f520790a;
        Intrinsics.checkNotNullParameter(r231, "<this>");
        MessageEntity r233 = MessageEntity.copy$default(r221, null, r222, null, null, null, 0, r225, r412, false, r410, r411, null, null, null, 0, false, null, r195.brief, r510, r511, null, com.larus.im.internal.core.message.converter.a.a(r228, kuc.a.c(r232, r232)), null, null, null, 0, null, false, null, 0, com.larus.im.internal.core.message.converter.a.a(r195.suggestQuestions, kuc.a.b(SuggestQuestion.Companion.serializer())), 0, null, null, null, null, null, null, null, null, null, null, 0, 0, -1076758211, UnixStat.PERM_MASK, null);
        Lazy<Long> r234 = com.larus.im.internal.core.message.utils.sync.c.f347898f;
        if (com.larus.im.internal.core.message.utils.sync.c.a.a() == false) goto L125;
        com.larus.im.internal.core.message.utils.sync.c r235 = this.f349151c;
        r100.L$0 = r194;
        r100.L$1 = r195;
        r100.L$2 = r233;
        r100.label = 1;
        if (r235.a(r233, r195, Integer.MAX_VALUE, r100) != r110) goto L123;
        return r110;
    L123:
        r185 = r233;
        r179 = r195;
        r186 = r194;
        goto L124
    L125:
        MessageHandler r236 = MessageHandler.f347752a;
        List<Integer> r237 = r195.appendFields;
        r100.L$0 = r194;
        r100.L$1 = r195;
        r100.L$2 = r233;
        r100.label = 2;
        r164 = null;
        if (MessageHandler.r(r236, r233, false, false, r237, false, null, null, r100, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_ABR) != r110) goto L128;
        return r110;
    L128:
        r178 = r233;
        r179 = r195;
        r180 = r194;
        goto L129
    L112:
        if (r229.isEmpty() == true) goto L115;
        r230 = false;
        goto L116
    L105:
        r226 = r195.content;
        goto L106
    L99:
        if (r223 == r221.getMessageStatus()) goto L101;
        r224 = this.f349149a.f349112g.getMessageStatus();
        goto L102
    L95:
        r410 = 20;
        goto L96
    L87:
        r217 = null;
        goto L88
    L83:
        r310 = null;
        goto L84
    L79:
        r214 = null;
        goto L80
    L58:
        r213 = null;
        goto L59
    L44:
        if (r195.isFinish() == true) goto L47;
        r196 = false;
        goto L48
    L159:
        r111 = null;
        if ((r187 instanceof com.larus.im.internal.network.e.C4366e) == false) goto L182;
        int r238 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("HttpChunkReceiver", "fetchByChunk(" + this.f349154f + "): StreamDone");
        Lazy<Long> r239 = com.larus.im.internal.core.message.utils.sync.c.f347898f;
        if (com.larus.im.internal.core.message.utils.sync.c.a.a() == false) goto L166;
        com.larus.im.internal.core.message.utils.sync.c r240 = this.f349151c;
        Integer r241 = Boxing.boxInt(21);
        com.larus.im.internal.tracking.b r242 = r194;
        r100.L$0 = r242;
        r100.label = 4;
        if (r240.e(r241, r100) != r110) goto L169;
        return r110;
    L169:
        r157 = r242;
        goto L170
    L166:
        r242 = r194;
        MessageHandler r243 = MessageHandler.f347752a;
        String r244 = this.f349154f;
        r100.L$0 = r242;
        r100.label = 5;
        if (r243.z(r244, 21, r100) != r110) goto L169;
        return r110;
    L182:
        r148 = r194;
        if ((r187 instanceof com.larus.im.internal.network.e.c) == false) goto L202;
        int r245 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("HttpChunkReceiver", "fetchByChunk(" + this.f349154f + "): interrupt");
        Lazy<Long> r246 = com.larus.im.internal.core.message.utils.sync.c.f347898f;
        if (com.larus.im.internal.core.message.utils.sync.c.a.a() == false) goto L189;
        com.larus.im.internal.core.message.utils.sync.c r247 = this.f349151c;
        r100.L$0 = r148;
        r100.label = 9;
        if (r247.e(null, r100) != r110) goto L189;
        return r110;
    L202:
        if ((r187 instanceof com.larus.im.internal.network.e.a) == false) goto L222;
        int r248 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("HttpChunkReceiver", "fetchByChunk(" + this.f349154f + "): Cancel");
        Lazy<Long> r249 = com.larus.im.internal.core.message.utils.sync.c.f347898f;
        if (com.larus.im.internal.core.message.utils.sync.c.a.a() == false) goto L208;
        com.larus.im.internal.core.message.utils.sync.c r250 = this.f349151c;
        r100.L$0 = r148;
        r100.label = 13;
        if (r250.e(null, r100) != r110) goto L208;
        return r110;
    L208:
        r135 = r148;
        goto L209
    L222:
        if ((r187 instanceof com.larus.im.internal.network.e.g) == false) goto L244;
        int r251 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("HttpChunkReceiver", "fetchByChunk(" + this.f349154f + "): TimeoutError");
        Lazy<Long> r252 = com.larus.im.internal.core.message.utils.sync.c.f347898f;
        if (com.larus.im.internal.core.message.utils.sync.c.a.a() == false) goto L228;
        com.larus.im.internal.core.message.utils.sync.c r253 = this.f349151c;
        Integer r254 = Boxing.boxInt(22);
        r100.L$0 = r148;
        r100.label = 17;
        if (r253.e(r254, r100) != r110) goto L231;
        return r110;
    L231:
        r123 = r148;
        goto L232
    L228:
        MessageHandler r255 = MessageHandler.f347752a;
        String r256 = this.f349154f;
        r100.L$0 = r148;
        r100.label = 18;
        if (r255.z(r256, 22, r100) != r110) goto L231;
        return r110;
    L244:
        int r257 = com.larus.im.internal.network.chunk.a.f349081a;
        com.larus.im.internal.utils.b.c("HttpChunkReceiver", "fetchByChunk(" + this.f349154f + "): Failed");
        Lazy<Long> r258 = com.larus.im.internal.core.message.utils.sync.c.f347898f;
        if (com.larus.im.internal.core.message.utils.sync.c.a.a() == false) goto L249;
        com.larus.im.internal.core.message.utils.sync.c r259 = this.f349151c;
        Integer r260 = Boxing.boxInt(22);
        r100.L$0 = r148;
        r100.label = 22;
        if (r259.e(r260, r100) != r110) goto L252;
        return r110;
    L252:
        r109 = r148;
        goto L253
    L249:
        MessageHandler r261 = MessageHandler.f347752a;
        String r262 = this.f349154f;
        r100.L$0 = r148;
        r100.label = 23;
        if (r261.z(r262, 22, r100) != r110) goto L252;
        return r110;
    L38:
        r211 = r192;
        goto L39
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r100 = new HttpDownlinkChunkReceiver$receiveDownlink$1(this, r910);
        goto L8
    }
}
