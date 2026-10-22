package com.larus.im.internal.protocol.bean;

import af9.l0;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00060\u0001j\u0002`\u0002:\u00029:Bs\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012Bu\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003Ju\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\rHÖ\u0001J\t\u00100\u001a\u00020\u0004HÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0018R \u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0018R\u0018\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0018R\u0018\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0018R\u0018\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0018R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0018R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u0018R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u0018¨\u0006;"}, d2 = {"Lcom/larus/im/internal/protocol/bean/GeneralInteractionAskNotifyDownlinkBody;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationId", "", "threadId", "blocks", "", "Lcom/larus/im/bean/message/block/Block;", "updateTimeMs", "", "ttlMs", WikiFolderPushPlugin.OPT, "", "messageId", "organizerThreadId", "organizerMessageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId$annotations", "()V", "getThreadId$annotations", "getBlocks$annotations", "getUpdateTimeMs$annotations", "getTtlMs$annotations", "getOperation$annotations", "getMessageId$annotations", "getOrganizerThreadId$annotations", "getOrganizerMessageId$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class GeneralInteractionAskNotifyDownlinkBody implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 1;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public List<Block> blocks;
    public String conversationId;
    public String messageId;
    public int operation;
    public String organizerMessageId;
    public String organizerThreadId;
    public String threadId;
    public long ttlMs;
    public long updateTimeMs;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<GeneralInteractionAskNotifyDownlinkBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f349633a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f349634b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f349634b;
        }

        static {
            a r100 = new a();
            f349633a = r100;
            g2 r101 = new g2("com.larus.im.internal.protocol.bean.GeneralInteractionAskNotifyDownlinkBody", r100, 9);
            r101.j("conversation_id", true);
            r101.j(CrashHianalyticsData.THREAD_ID, true);
            r101.j("blocks", true);
            r101.j("update_time_ms", true);
            r101.j("ttl_ms", true);
            r101.j(WikiFolderPushPlugin.OPT, true);
            r101.j(MusicAppletPage.KEY_MESSAGE_ID, true);
            r101.j("organizer_thread_id", true);
            r101.j("organizer_message_id", true);
            f349634b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = GeneralInteractionAskNotifyDownlinkBody.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            g1 r102 = g1.f520681a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r101), kuc.a.d((d) r100[2].getValue()), r102, r102, w0.f520792a, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f349634b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy[] r102 = GeneralInteractionAskNotifyDownlinkBody.access$get$childSerializers$cp();
            int r103 = 5;
            int r104 = 6;
            int r105 = 7;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r106 = v2.f520790a;
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 0, r106, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 1, r106, null);
            List r107 = (List) r101.decodeNullableSerializableElement(r100, 2, (juc.c) r102[2].getValue(), null);
            long r112 = r101.decodeLongElement(r100, 3);
            long r108 = r101.decodeLongElement(r100, 4);
            int r109 = r101.decodeIntElement(r100, 5);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 6, r106, null);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 7, r106, null);
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 8, r106, null);
            int r115 = r109;
            String r212 = r113;
            String r213 = r114;
            long r116 = r108;
            String r117 = r111;
            long r118 = r112;
            int r119 = 511;
            List r120 = r107;
        L26:
            r101.endStructure(r100);
            return new GeneralInteractionAskNotifyDownlinkBody(r119, r110, r117, r120, r118, r116, r115, r212, r213, r211, null);
        L5:
            long r121 = 0;
            String r122 = null;
            String r123 = null;
            String r124 = null;
            List r125 = null;
            String r126 = null;
            String r214 = null;
            long r215 = 0;
            int r127 = 0;
            int r128 = 0;
            boolean r216 = true;
        L6:
            if (r216 == false) goto L25;
            int r129 = r101.decodeElementIndex(r100);
            switch(r129) {
                case -1: goto L24;
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L15;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r129);
        L17:
            r121 = r101.decodeLongElement(r100, 4);
            r128 = r128 | 16;
            goto L6
        L18:
            r215 = r101.decodeLongElement(r100, 3);
            r128 = r128 | 8;
            r103 = 5;
            goto L6
        L19:
            r128 = r128 | 4;
            r125 = (List) r101.decodeNullableSerializableElement(r100, 2, (juc.c) r102[2].getValue(), r125);
        L21:
            r103 = 5;
            r104 = 6;
            r105 = 7;
            goto L6
        L20:
            r214 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r214);
            r128 = r128 | 2;
            goto L21
        L24:
            r103 = 5;
            r105 = 7;
            r216 = false;
            goto L6
        L11:
            r123 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r123);
            int r130 = r128 | 256;
        L16:
            r128 = r130;
        L23:
            r214 = r214;
            r126 = r126;
            r103 = 5;
            r104 = 6;
            r105 = 7;
            goto L6
        L12:
            r122 = (String) r101.decodeNullableSerializableElement(r100, r105, v2.f520790a, r122);
            r130 = r128 | 128;
            goto L16
        L13:
            r128 = r128 | 64;
            r124 = (String) r101.decodeNullableSerializableElement(r100, r104, v2.f520790a, r124);
            goto L23
        L15:
            r127 = r101.decodeIntElement(r100, r103);
            r130 = r128 | 32;
            goto L16
        L22:
            r214 = r214;
            r126 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r126);
            r128 = r128 | 1;
            goto L23
        L25:
            String r131 = r214;
            r115 = r127;
            r212 = r124;
            r119 = r128;
            r116 = r121;
            r118 = r215;
            r213 = r122;
            r117 = r131;
            r211 = r123;
            r120 = r125;
            r110 = r126;
            goto L26
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            GeneralInteractionAskNotifyDownlinkBody r102 = (GeneralInteractionAskNotifyDownlinkBody) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f349634b;
            muc.d r104 = r100.beginStructure(r103);
            GeneralInteractionAskNotifyDownlinkBody.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<GeneralInteractionAskNotifyDownlinkBody> serializer() {
            return a.f349633a;
        }
    }

    public GeneralInteractionAskNotifyDownlinkBody() {
        this(null, null, null, 0, 0, 0, null, null, null, 511, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(Block.a.f346807a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GeneralInteractionAskNotifyDownlinkBody copy$default(GeneralInteractionAskNotifyDownlinkBody r110, String r111, String r112, List r113, long r114, long r115, int r210, String r211, String r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.conversationId;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.threadId;
    L11:
        if ((r214 & 4) == 0) goto L13;
        List r102 = r110.blocks;
    L15:
        if ((r214 & 8) == 0) goto L17;
        long r103 = r110.updateTimeMs;
    L19:
        if ((r214 & 16) == 0) goto L21;
        long r104 = r110.ttlMs;
    L23:
        if ((r214 & 32) == 0) goto L25;
        int r105 = r110.operation;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r116 = r110.messageId;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r117 = r110.organizerThreadId;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r106 = r110.organizerMessageId;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r116, r117, r106);
    L37:
        r106 = r213;
        goto L39
    L33:
        r117 = r212;
        goto L35
    L29:
        r116 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @SerialName("blocks")
    public static /* synthetic */ void getBlocks$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName(MusicAppletPage.KEY_MESSAGE_ID)
    public static /* synthetic */ void getMessageId$annotations() {
    }

    @SerialName(WikiFolderPushPlugin.OPT)
    public static /* synthetic */ void getOperation$annotations() {
    }

    @SerialName("organizer_message_id")
    public static /* synthetic */ void getOrganizerMessageId$annotations() {
    }

    @SerialName("organizer_thread_id")
    public static /* synthetic */ void getOrganizerThreadId$annotations() {
    }

    @SerialName(CrashHianalyticsData.THREAD_ID)
    public static /* synthetic */ void getThreadId$annotations() {
    }

    @SerialName("ttl_ms")
    public static /* synthetic */ void getTtlMs$annotations() {
    }

    @SerialName("update_time_ms")
    public static /* synthetic */ void getUpdateTimeMs$annotations() {
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component2() {
        return this.threadId;
    }

    public final List<Block> component3() {
        return this.blocks;
    }

    public final long component4() {
        return this.updateTimeMs;
    }

    public final long component5() {
        return this.ttlMs;
    }

    public final int component6() {
        return this.operation;
    }

    public final String component7() {
        return this.messageId;
    }

    public final String component8() {
        return this.organizerThreadId;
    }

    public final String component9() {
        return this.organizerMessageId;
    }

    public final GeneralInteractionAskNotifyDownlinkBody copy(String r110, String r111, List<Block> r112, long r113, long r114, int r210, String r211, String r212, String r213) {
        return new GeneralInteractionAskNotifyDownlinkBody(r110, r111, r112, r113, r114, r210, r211, r212, r213);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GeneralInteractionAskNotifyDownlinkBody) == true) goto L8;
        return false;
    L8:
        GeneralInteractionAskNotifyDownlinkBody r101 = (GeneralInteractionAskNotifyDownlinkBody) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.threadId, r101.threadId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.blocks, r101.blocks) == true) goto L18;
        return false;
    L18:
        if (this.updateTimeMs == r101.updateTimeMs) goto L21;
        return false;
    L21:
        if (this.ttlMs == r101.ttlMs) goto L24;
        return false;
    L24:
        if (this.operation == r101.operation) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.organizerThreadId, r101.organizerThreadId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.organizerMessageId, r101.organizerMessageId) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.threadId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<Block> r107 = this.blocks;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.updateTimeMs;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.ttlMs;
        int r113 = (((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.operation) * 31;
        String r114 = this.messageId;
        if (r114 != null) goto L17;
        int r115 = 0;
    L18:
        int r116 = (r113 + r115) * 31;
        String r117 = this.organizerThreadId;
        if (r117 != null) goto L21;
        int r118 = 0;
    L22:
        int r119 = (r116 + r118) * 31;
        String r120 = this.organizerMessageId;
        if (r120 == null) goto L27;
        r101 = r120.hashCode();
    L27:
        return r119 + r101;
    L21:
        r118 = r117.hashCode();
        goto L22
    L17:
        r115 = r114.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GeneralInteractionAskNotifyDownlinkBody(conversationId=" + this.conversationId + ", threadId=" + this.threadId + ", blocks=" + this.blocks + ", updateTimeMs=" + this.updateTimeMs + ", ttlMs=" + this.ttlMs + ", operation=" + this.operation + ", messageId=" + this.messageId + ", organizerThreadId=" + this.organizerThreadId + ", organizerMessageId=" + this.organizerMessageId + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new l0()), null, null, null, null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(GeneralInteractionAskNotifyDownlinkBody r100, muc.d r101, f r110) {
        Lazy<d<Object>>[] r102 = $childSerializers;
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.conversationId);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r110, 1, v2.f520790a, r100.threadId);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r110, 2, r102[2].getValue(), r100.blocks);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeLongElement(r110, 3, r100.updateTimeMs);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeLongElement(r110, 4, r100.ttlMs);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeIntElement(r110, 5, r100.operation);
    L57:
        if (r101.shouldEncodeElementDefault(r110, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r110, 6, v2.f520790a, r100.messageId);
    L66:
        if (r101.shouldEncodeElementDefault(r110, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r110, 7, v2.f520790a, r100.organizerThreadId);
    L75:
        if (r101.shouldEncodeElementDefault(r110, 8) == false) goto L78;
    L76:
        r103 = true;
    L80:
        if (r103 == false) goto L83;
        r101.encodeNullableSerializableElement(r110, 8, v2.f520790a, r100.organizerMessageId);
        return;
    L83:
        return;
    L78:
        if (r100.organizerMessageId == null) goto L80;
    L69:
        if (r100.organizerThreadId != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.messageId != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.operation != GeneralInteractionAskOperation.UNSPECIFIED.value) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.ttlMs != 0) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.updateTimeMs != 0) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.blocks != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.threadId != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.conversationId != null) goto L4;
        r104 = false;
        goto L9
    }

    public GeneralInteractionAskNotifyDownlinkBody(String r100, String r101, List<Block> r102, long r103, long r104, int r105, String r106, String r110, String r111) {
        this.conversationId = r100;
        this.threadId = r101;
        this.blocks = r102;
        this.updateTimeMs = r103;
        this.ttlMs = r104;
        this.operation = r105;
        this.messageId = r106;
        this.organizerThreadId = r110;
        this.organizerMessageId = r111;
    }

    public GeneralInteractionAskNotifyDownlinkBody(int r100, String r101, String r102, List r103, long r104, long r105, int r110, String r111, String r112, String r113, q2 r114) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f349634b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.conversationId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.threadId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.blocks = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.updateTimeMs = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.ttlMs = 0;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.operation = GeneralInteractionAskOperation.UNSPECIFIED.value;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.messageId = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.organizerThreadId = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.organizerMessageId = null;
        return;
    L39:
        this.organizerMessageId = r113;
        return;
    L35:
        this.organizerThreadId = r112;
        goto L37
    L31:
        this.messageId = r111;
        goto L33
    L27:
        this.operation = r110;
        goto L29
    L23:
        this.ttlMs = r105;
        goto L25
    L19:
        this.updateTimeMs = r104;
        goto L21
    L15:
        this.blocks = r103;
        goto L17
    L11:
        this.threadId = r102;
        goto L13
    L7:
        this.conversationId = r101;
        goto L9
    }

    public /* synthetic */ GeneralInteractionAskNotifyDownlinkBody(String r110, String r111, List r112, long r113, long r114, int r210, String r211, String r212, String r213, int r214, DefaultConstructorMarker r215) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        List r103 = null;
    L14:
        long r104 = 0;
        if ((r214 & 8) == 0) goto L17;
        long r105 = 0;
    L19:
        if ((r214 & 16) != 0) goto L23;
        r104 = r114;
    L23:
        if ((r214 & 32) == 0) goto L25;
        int r106 = GeneralInteractionAskOperation.UNSPECIFIED.value;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r115 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r116 = null;
    L35:
        if ((r214 & 256) != 0) goto L38;
        r100 = r213;
    L38:
        this(r101, r102, r103, r105, r104, r106, r115, r116, r100);
        return;
    L33:
        r116 = r212;
        goto L35
    L29:
        r115 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L17:
        r105 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
