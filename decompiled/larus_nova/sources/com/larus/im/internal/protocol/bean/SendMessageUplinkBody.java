package com.larus.im.internal.protocol.bean;

import af9.d2;
import af9.e2;
import af9.f2;
import af9.h2;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import java.util.Map;
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
import nuc.a1;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 o2\u00060\u0001j\u0002`\u0002:\u0002opBÉ\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b%\u0010&B\u00ad\u0002\b\u0010\u0012\u0006\u0010'\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\b\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\u0010#\u001a\u0004\u0018\u00010$\u0012\b\u0010(\u001a\u0004\u0018\u00010)¢\u0006\u0004\b%\u0010*J\u000b\u0010F\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010I\u001a\u00020\u0006HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0017\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010Q\u001a\u00020\u0006HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010WJ\u000b\u0010X\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010Z\u001a\u00020\u0006HÆ\u0003J\u0017\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010^J\u000b\u0010_\u001a\u0004\u0018\u00010$HÆ\u0003JÐ\u0002\u0010`\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u00062\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$HÆ\u0001¢\u0006\u0002\u0010aJ\u0013\u0010b\u001a\u00020\"2\b\u0010c\u001a\u0004\u0018\u00010dHÖ\u0003J\t\u0010e\u001a\u00020\u0006HÖ\u0001J\t\u0010f\u001a\u00020\u0004HÖ\u0001J%\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\u00002\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020mH\u0001¢\u0006\u0002\bnR\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b+\u0010,R\u0018\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b-\u0010,R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b.\u0010,R\u0018\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b/\u0010,R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b0\u0010,R \u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b1\u0010,R&\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b2\u0010,R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b3\u0010,R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b4\u0010,R \u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b5\u0010,R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b6\u0010,R\u0018\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b7\u0010,R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b8\u0010,R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b9\u0010,R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b:\u0010,R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b;\u0010,R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\n\n\u0002\u0010=\u0012\u0004\b<\u0010,R\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b>\u0010,R \u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b?\u0010,R\u0018\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b@\u0010,R&\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bA\u0010,R\u001a\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bB\u0010,R\u001c\u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\n\n\u0002\u0010D\u0012\u0004\bC\u0010,R\u001a\u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bE\u0010,¨\u0006q"}, d2 = {"Lcom/larus/im/internal/protocol/bean/SendMessageUplinkBody;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationId", "", "conversationType", "", "senderId", "contentType", "content", "contentBlock", "", "Lcom/larus/im/bean/message/block/Block;", "ext", "", "referenceInfo", "Lcom/larus/im/internal/protocol/bean/ReferenceInfo;", "localMessageId", "messageTags", "clientControllerParam", "Lcom/larus/im/internal/protocol/bean/ClientControllerParam;", "botType", "localConversationId", "botId", "localOnboardingMessageId", "reeditMsgId", "createTime", "", "bizContentType", "localMessageIdList", "status", "appletPayload", "uniqueKey", "ackOnly", "", "fallbackParam", "Lcom/larus/im/internal/protocol/bean/ClientFallbackParam;", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/Map;Lcom/larus/im/internal/protocol/bean/ReferenceInfo;Ljava/lang/String;Ljava/util/List;Lcom/larus/im/internal/protocol/bean/ClientControllerParam;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;ILjava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/internal/protocol/bean/ClientFallbackParam;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/Map;Lcom/larus/im/internal/protocol/bean/ReferenceInfo;Ljava/lang/String;Ljava/util/List;Lcom/larus/im/internal/protocol/bean/ClientControllerParam;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;ILjava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/internal/protocol/bean/ClientFallbackParam;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId$annotations", "()V", "getConversationType$annotations", "getSenderId$annotations", "getContentType$annotations", "getContent$annotations", "getContentBlock$annotations", "getExt$annotations", "getReferenceInfo$annotations", "getLocalMessageId$annotations", "getMessageTags$annotations", "getClientControllerParam$annotations", "getBotType$annotations", "getLocalConversationId$annotations", "getBotId$annotations", "getLocalOnboardingMessageId$annotations", "getReeditMsgId$annotations", "getCreateTime$annotations", "Ljava/lang/Long;", "getBizContentType$annotations", "getLocalMessageIdList$annotations", "getStatus$annotations", "getAppletPayload$annotations", "getUniqueKey$annotations", "getAckOnly$annotations", "Ljava/lang/Boolean;", "getFallbackParam$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "()Ljava/lang/Long;", "component18", "component19", "component20", "component21", "component22", "component23", "()Ljava/lang/Boolean;", "component24", "copy", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/Map;Lcom/larus/im/internal/protocol/bean/ReferenceInfo;Ljava/lang/String;Ljava/util/List;Lcom/larus/im/internal/protocol/bean/ClientControllerParam;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;ILjava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/internal/protocol/bean/ClientFallbackParam;)Lcom/larus/im/internal/protocol/bean/SendMessageUplinkBody;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class SendMessageUplinkBody implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public Boolean ackOnly;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public Map<String, String> appletPayload;
    public String bizContentType;
    public String botId;
    public int botType;
    public ClientControllerParam clientControllerParam;
    public String content;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public List<Block> contentBlock;
    public int contentType;
    public String conversationId;
    public int conversationType;
    public Long createTime;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public Map<String, String> ext;
    public com.larus.im.internal.protocol.bean.a fallbackParam;
    public String localConversationId;
    public String localMessageId;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public List<String> localMessageIdList;
    public String localOnboardingMessageId;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public List<Integer> messageTags;
    public String reeditMsgId;
    public ReferenceInfo referenceInfo;
    public String senderId;
    public int status;
    public String uniqueKey;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<SendMessageUplinkBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f349716a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f349717b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f349717b;
        }

        static {
            a r100 = new a();
            f349716a = r100;
            g2 r101 = new g2("com.larus.im.internal.protocol.bean.SendMessageUplinkBody", r100, 24);
            r101.j("conversation_id", true);
            r101.j("conversation_type", true);
            r101.j("sender_id", true);
            r101.j("content_type", true);
            r101.j("content", true);
            r101.j("content_block", true);
            r101.j("ext", true);
            r101.j("reference_info", true);
            r101.j("local_message_id", true);
            r101.j("message_tags", true);
            r101.j("client_controller_param", true);
            r101.j("bot_type", true);
            r101.j("local_conversation_id", true);
            r101.j("bot_id", true);
            r101.j("local_onboarding_message_id", true);
            r101.j("reedit_msg_id", true);
            r101.j("create_time", true);
            r101.j("biz_content_type", true);
            r101.j("local_message_id_list", true);
            r101.j("status", true);
            r101.j("applet_payload", true);
            r101.j("unique_key", true);
            r101.j("ack_only", true);
            r101.j("client_fallback_param", true);
            f349717b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = SendMessageUplinkBody.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            w0 r102 = w0.f520792a;
            return new d[]{kuc.a.d(r101), r102, kuc.a.d(r101), r102, kuc.a.d(r101), kuc.a.d((d) r100[5].getValue()), kuc.a.d((d) r100[6].getValue()), kuc.a.d(ReferenceInfo.a.f349700a), kuc.a.d(r101), kuc.a.d((d) r100[9].getValue()), kuc.a.d(ClientControllerParam.a.f349607a), r102, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(g1.f520681a), kuc.a.d(r101), kuc.a.d((d) r100[18].getValue()), r102, kuc.a.d((d) r100[20].getValue()), kuc.a.d(r101), kuc.a.d(i.f520705a), kuc.a.d(com.larus.im.internal.protocol.bean.a.C4371a.f349748a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r510) {
            Intrinsics.checkNotNullParameter(r510, "decoder");
            g2 r100 = f349717b;
            muc.c r101 = r510.beginStructure(r100);
            Lazy[] r102 = SendMessageUplinkBody.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            int r111 = r101.decodeIntElement(r100, 1);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            int r105 = r101.decodeIntElement(r100, 3);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 4, r103, null);
            List r112 = (List) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), null);
            Map r107 = (Map) r101.decodeNullableSerializableElement(r100, 6, (juc.c) r102[6].getValue(), null);
            ReferenceInfo r108 = (ReferenceInfo) r101.decodeNullableSerializableElement(r100, 7, ReferenceInfo.a.f349700a, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 8, r103, null);
            List r109 = (List) r101.decodeNullableSerializableElement(r100, 9, (juc.c) r102[9].getValue(), null);
            ClientControllerParam r114 = (ClientControllerParam) r101.decodeNullableSerializableElement(r100, 10, ClientControllerParam.a.f349607a, null);
            int r115 = r101.decodeIntElement(r100, 11);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 12, r103, null);
            String r117 = (String) r101.decodeNullableSerializableElement(r100, 13, r103, null);
            String r118 = (String) r101.decodeNullableSerializableElement(r100, 14, r103, null);
            String r119 = (String) r101.decodeNullableSerializableElement(r100, 15, r103, null);
            List r210 = r109;
            Long r120 = (Long) r101.decodeNullableSerializableElement(r100, 16, g1.f520681a, null);
            String r121 = (String) r101.decodeNullableSerializableElement(r100, 17, r103, null);
            String r122 = r110;
            List r123 = (List) r101.decodeNullableSerializableElement(r100, 18, (juc.c) r102[18].getValue(), null);
            int r124 = r101.decodeIntElement(r100, 19);
            Map r125 = (Map) r101.decodeNullableSerializableElement(r100, 20, (juc.c) r102[20].getValue(), null);
            String r126 = (String) r101.decodeNullableSerializableElement(r100, 21, r103, null);
            Boolean r127 = (Boolean) r101.decodeNullableSerializableElement(r100, 22, i.f520705a, null);
            com.larus.im.internal.protocol.bean.a r410 = (com.larus.im.internal.protocol.bean.a) r101.decodeNullableSerializableElement(r100, 23, com.larus.im.internal.protocol.bean.a.C4371a.f349748a, null);
            String r310 = r126;
            List r311 = r123;
            String r312 = r121;
            int r313 = r124;
            int r211 = r115;
            Map r314 = r125;
            Long r315 = r120;
            Boolean r316 = r127;
            String r317 = r119;
            String r318 = r118;
            String r319 = r117;
            String r212 = r116;
            ClientControllerParam r213 = r114;
            Map r214 = r107;
            int r128 = 16777215;
            int r129 = r111;
            int r215 = r105;
            ReferenceInfo r216 = r108;
            String r130 = r104;
            String r217 = r106;
            String r218 = r113;
            List r219 = r112;
        L53:
            r101.endStructure(r100);
            return new SendMessageUplinkBody(r128, r122, r129, r130, r215, r217, r219, r214, r216, r218, r210, r213, r211, r212, r319, r318, r317, r315, r312, r311, r313, r314, r310, r316, r410, null);
        L5:
            String r131 = null;
            Boolean r132 = null;
            String r133 = null;
            List r134 = null;
            Long r135 = null;
            String r136 = null;
            String r137 = null;
            Map r138 = null;
            String r139 = null;
            String r140 = null;
            ClientControllerParam r141 = null;
            com.larus.im.internal.protocol.bean.a r142 = null;
            String r220 = null;
            String r320 = null;
            String r411 = null;
            List r412 = null;
            Map r413 = null;
            ReferenceInfo r414 = null;
            String r415 = null;
            List r416 = null;
            int r143 = 0;
            int r321 = 0;
            int r322 = 0;
            int r417 = 0;
            int r418 = 0;
            boolean r419 = true;
        L6:
            if (r419 == false) goto L52;
            r141 = r141;
            int r144 = r101.decodeElementIndex(r100);
            switch(r144) {
                case -1: goto L51;
                case 0: goto L48;
                case 1: goto L46;
                case 2: goto L43;
                case 3: goto L41;
                case 4: goto L40;
                case 5: goto L39;
                case 6: goto L37;
                case 7: goto L35;
                case 8: goto L33;
                case 9: goto L32;
                case 10: goto L31;
                case 11: goto L29;
                case 12: goto L28;
                case 13: goto L26;
                case 14: goto L24;
                case 15: goto L22;
                case 16: goto L21;
                case 17: goto L19;
                case 18: goto L18;
                case 19: goto L16;
                case 20: goto L15;
                case 21: goto L13;
                case 22: goto L12;
                case 23: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r144);
        L28:
            r131 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r131);
            r143 = r143 | 4096;
        L30:
            r132 = r132;
            r141 = r141;
            goto L6
        L29:
            r418 = r101.decodeIntElement(r100, 11);
            r143 = r143 | 2048;
            goto L30
        L31:
            r141 = (ClientControllerParam) r101.decodeNullableSerializableElement(r100, 10, ClientControllerParam.a.f349607a, r141);
            r143 = r143 | 1024;
            r132 = r132;
            r133 = r133;
            goto L6
        L32:
            int r145 = r143 | 512;
            r416 = (List) r101.decodeNullableSerializableElement(r100, 9, (juc.c) r102[9].getValue(), r416);
            r415 = r415;
        L36:
            r414 = r414;
            r143 = r145;
            Map r146 = r413;
        L50:
            r413 = r146;
            r132 = r132;
            r320 = r320;
            r133 = r133;
            r411 = r411;
            r412 = r412;
            r102 = r102;
            r414 = r414;
            r415 = r415;
            r416 = r416;
            r134 = r134;
            goto L6
        L33:
            r416 = r416;
            r415 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r415);
            r145 = r143 | 256;
            goto L36
        L35:
            r132 = r132;
            r133 = r133;
            r134 = r134;
            r416 = r416;
            r141 = r141;
            r415 = r415;
            r414 = (ReferenceInfo) r101.decodeNullableSerializableElement(r100, 7, ReferenceInfo.a.f349700a, r414);
            r145 = r143 | 128;
            goto L36
        L37:
            r132 = r132;
            r133 = r133;
            r134 = r134;
            r415 = r415;
            r416 = r416;
            r141 = r141;
            r414 = r414;
            r146 = (Map) r101.decodeNullableSerializableElement(r100, 6, (juc.c) r102[6].getValue(), r413);
            r143 = r143 | 64;
            goto L50
        L39:
            r412 = (List) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), r412);
            int r147 = r143 | 32;
            int r323 = r321;
        L42:
            r321 = r323;
        L47:
            r320 = r320;
            int r148 = r147;
        L49:
            r143 = r148;
            r146 = r413;
            goto L50
        L40:
            r412 = r412;
            int r149 = r143 | 16;
            r411 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r411);
        L44:
            r148 = r149;
            r320 = r320;
            goto L49
        L41:
            r412 = r412;
            r323 = r101.decodeIntElement(r100, 3);
            r147 = r143 | 8;
            goto L42
        L43:
            r412 = r412;
            r411 = r411;
            r320 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r320);
            r149 = r143 | 4;
            goto L44
        L46:
            r102 = r102;
            r132 = r132;
            r133 = r133;
            r134 = r134;
            r412 = r412;
            r413 = r413;
            r414 = r414;
            r415 = r415;
            r416 = r416;
            r141 = r141;
            r147 = r143 | 2;
            r322 = r101.decodeIntElement(r100, 1);
            goto L47
        L48:
            r102 = r102;
            r132 = r132;
            r133 = r133;
            r134 = r134;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r414 = r414;
            r415 = r415;
            r416 = r416;
            r141 = r141;
            r320 = r320;
            r220 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r220);
            r148 = r143 | 1;
            goto L49
        L51:
            r141 = r141;
            r132 = r132;
            r133 = r133;
            r134 = r134;
            r419 = false;
            goto L6
        L11:
            r131 = r131;
            int r150 = 8388608;
            r142 = (com.larus.im.internal.protocol.bean.a) r101.decodeNullableSerializableElement(r100, 23, com.larus.im.internal.protocol.bean.a.C4371a.f349748a, r142);
        L23:
            r143 = r143 | r150;
        L27:
            r141 = r141;
            r131 = r131;
            goto L6
        L12:
            r131 = r131;
            r132 = (Boolean) r101.decodeNullableSerializableElement(r100, 22, i.f520705a, r132);
            r150 = 4194304;
            goto L23
        L13:
            r131 = r131;
            r136 = (String) r101.decodeNullableSerializableElement(r100, 21, v2.f520790a, r136);
            r150 = 2097152;
            goto L23
        L15:
            r138 = (Map) r101.decodeNullableSerializableElement(r100, 20, (juc.c) r102[20].getValue(), r138);
            r150 = 1048576;
            goto L23
        L16:
            r131 = r131;
            r143 = r143 | 524288;
            r417 = r101.decodeIntElement(r100, 19);
            goto L27
        L18:
            r134 = (List) r101.decodeNullableSerializableElement(r100, 18, (juc.c) r102[18].getValue(), r134);
            r150 = 262144;
            goto L23
        L19:
            r133 = (String) r101.decodeNullableSerializableElement(r100, 17, v2.f520790a, r133);
            r150 = 131072;
            goto L23
        L21:
            r131 = r131;
            r135 = (Long) r101.decodeNullableSerializableElement(r100, 16, g1.f520681a, r135);
            r150 = 65536;
            goto L23
        L22:
            r131 = r131;
            r137 = (String) r101.decodeNullableSerializableElement(r100, 15, v2.f520790a, r137);
            r150 = 32768;
            goto L23
        L24:
            r131 = r131;
            r140 = (String) r101.decodeNullableSerializableElement(r100, 14, v2.f520790a, r140);
            r143 = r143 | 16384;
            goto L27
        L26:
            r131 = r131;
            r139 = (String) r101.decodeNullableSerializableElement(r100, 13, v2.f520790a, r139);
            r143 = r143 | 8192;
            goto L27
        L52:
            String r221 = r320;
            String r222 = r411;
            r122 = r220;
            r315 = r135;
            r319 = r139;
            r212 = r131;
            r318 = r140;
            r128 = r143;
            r213 = r141;
            r410 = r142;
            r130 = r221;
            r217 = r222;
            r219 = r412;
            r216 = r414;
            r218 = r415;
            r311 = r134;
            r215 = r321;
            r129 = r322;
            r211 = r418;
            r310 = r136;
            r317 = r137;
            r314 = r138;
            r316 = r132;
            r312 = r133;
            r210 = r416;
            r313 = r417;
            r214 = r413;
            goto L53
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            SendMessageUplinkBody r102 = (SendMessageUplinkBody) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f349717b;
            muc.d r104 = r100.beginStructure(r103);
            SendMessageUplinkBody.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<SendMessageUplinkBody> serializer() {
            return a.f349716a;
        }
    }

    public SendMessageUplinkBody() {
        this(null, 0, null, 0, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 0, null, null, null, null, 16777215, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(Block.a.f346807a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$1() {
        return new nuc.f(w0.f520792a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$2() {
        return new nuc.f(v2.f520790a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$3() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_$3();
    }

    public static /* synthetic */ d c() {
        return _childSerializers$_anonymous_$0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SendMessageUplinkBody copy$default(SendMessageUplinkBody r110, String r111, int r112, String r210, int r211, String r212, List r213, Map r214, ReferenceInfo r215, String r216, List r217, ClientControllerParam r218, int r219, String r310, String r311, String r312, String r313, Long r314, String r315, List r316, int r317, Map r318, String r319, Boolean r410, com.larus.im.internal.protocol.bean.a r411, int r412, Object r413) {
        if ((r412 & 1) == 0) goto L5;
        String r100 = r110.conversationId;
    L7:
        if ((r412 & 2) == 0) goto L9;
        int r101 = r110.conversationType;
    L11:
        if ((r412 & 4) == 0) goto L13;
        String r102 = r110.senderId;
    L15:
        if ((r412 & 8) == 0) goto L17;
        int r103 = r110.contentType;
    L19:
        if ((r412 & 16) == 0) goto L21;
        String r104 = r110.content;
    L23:
        if ((r412 & 32) == 0) goto L25;
        List r105 = r110.contentBlock;
    L27:
        if ((r412 & 64) == 0) goto L29;
        Map r106 = r110.ext;
    L31:
        if ((r412 & 128) == 0) goto L33;
        ReferenceInfo r107 = r110.referenceInfo;
    L35:
        if ((r412 & 256) == 0) goto L37;
        String r113 = r110.localMessageId;
    L39:
        if ((r412 & 512) == 0) goto L41;
        List r114 = r110.messageTags;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        ClientControllerParam r115 = r110.clientControllerParam;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        int r116 = r110.botType;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        String r117 = r110.localConversationId;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        String r118 = r110.botId;
    L58:
        String r320 = r118;
        if ((r412 & 16384) == 0) goto L61;
        String r119 = r110.localOnboardingMessageId;
    L62:
        String r321 = r119;
        if ((r412 & 32768) == 0) goto L65;
        String r120 = r110.reeditMsgId;
    L66:
        String r322 = r120;
        if ((r412 & 65536) == 0) goto L69;
        Long r121 = r110.createTime;
    L70:
        Long r323 = r121;
        if ((r412 & 131072) == 0) goto L73;
        String r122 = r110.bizContentType;
    L74:
        String r324 = r122;
        if ((r412 & 262144) == 0) goto L77;
        List r123 = r110.localMessageIdList;
    L78:
        List r325 = r123;
        if ((r412 & 524288) == 0) goto L81;
        int r124 = r110.status;
    L82:
        int r326 = r124;
        if ((r412 & 1048576) == 0) goto L85;
        Map r125 = r110.appletPayload;
    L86:
        Map r327 = r125;
        if ((r412 & 2097152) == 0) goto L89;
        String r126 = r110.uniqueKey;
    L90:
        String r328 = r126;
        if ((r412 & 4194304) == 0) goto L93;
        Boolean r127 = r110.ackOnly;
    L95:
        if ((r412 & 8388608) == 0) goto L97;
        com.larus.im.internal.protocol.bean.a r108 = r110.fallbackParam;
    L99:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r127, r108);
    L97:
        r108 = r411;
        goto L99
    L93:
        r127 = r410;
        goto L95
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public static /* synthetic */ d d() {
        return _childSerializers$_anonymous_$1();
    }

    public static /* synthetic */ d e() {
        return _childSerializers$_anonymous_$2();
    }

    @SerialName("ack_only")
    public static /* synthetic */ void getAckOnly$annotations() {
    }

    @SerialName("applet_payload")
    public static /* synthetic */ void getAppletPayload$annotations() {
    }

    @SerialName("biz_content_type")
    public static /* synthetic */ void getBizContentType$annotations() {
    }

    @SerialName("bot_id")
    public static /* synthetic */ void getBotId$annotations() {
    }

    @SerialName("bot_type")
    public static /* synthetic */ void getBotType$annotations() {
    }

    @SerialName("client_controller_param")
    public static /* synthetic */ void getClientControllerParam$annotations() {
    }

    @SerialName("content")
    public static /* synthetic */ void getContent$annotations() {
    }

    @SerialName("content_block")
    public static /* synthetic */ void getContentBlock$annotations() {
    }

    @SerialName("content_type")
    public static /* synthetic */ void getContentType$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("conversation_type")
    public static /* synthetic */ void getConversationType$annotations() {
    }

    @SerialName("create_time")
    public static /* synthetic */ void getCreateTime$annotations() {
    }

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName("client_fallback_param")
    public static /* synthetic */ void getFallbackParam$annotations() {
    }

    @SerialName("local_conversation_id")
    public static /* synthetic */ void getLocalConversationId$annotations() {
    }

    @SerialName("local_message_id")
    public static /* synthetic */ void getLocalMessageId$annotations() {
    }

    @SerialName("local_message_id_list")
    public static /* synthetic */ void getLocalMessageIdList$annotations() {
    }

    @SerialName("local_onboarding_message_id")
    public static /* synthetic */ void getLocalOnboardingMessageId$annotations() {
    }

    @SerialName("message_tags")
    public static /* synthetic */ void getMessageTags$annotations() {
    }

    @SerialName("reedit_msg_id")
    public static /* synthetic */ void getReeditMsgId$annotations() {
    }

    @SerialName("reference_info")
    public static /* synthetic */ void getReferenceInfo$annotations() {
    }

    @SerialName("sender_id")
    public static /* synthetic */ void getSenderId$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("unique_key")
    public static /* synthetic */ void getUniqueKey$annotations() {
    }

    public final String component1() {
        return this.conversationId;
    }

    public final List<Integer> component10() {
        return this.messageTags;
    }

    public final ClientControllerParam component11() {
        return this.clientControllerParam;
    }

    public final int component12() {
        return this.botType;
    }

    public final String component13() {
        return this.localConversationId;
    }

    public final String component14() {
        return this.botId;
    }

    public final String component15() {
        return this.localOnboardingMessageId;
    }

    public final String component16() {
        return this.reeditMsgId;
    }

    public final Long component17() {
        return this.createTime;
    }

    public final String component18() {
        return this.bizContentType;
    }

    public final List<String> component19() {
        return this.localMessageIdList;
    }

    public final int component2() {
        return this.conversationType;
    }

    public final int component20() {
        return this.status;
    }

    public final Map<String, String> component21() {
        return this.appletPayload;
    }

    public final String component22() {
        return this.uniqueKey;
    }

    public final Boolean component23() {
        return this.ackOnly;
    }

    public final com.larus.im.internal.protocol.bean.a component24() {
        return this.fallbackParam;
    }

    public final String component3() {
        return this.senderId;
    }

    public final int component4() {
        return this.contentType;
    }

    public final String component5() {
        return this.content;
    }

    public final List<Block> component6() {
        return this.contentBlock;
    }

    public final Map<String, String> component7() {
        return this.ext;
    }

    public final ReferenceInfo component8() {
        return this.referenceInfo;
    }

    public final String component9() {
        return this.localMessageId;
    }

    public final SendMessageUplinkBody copy(String r210, int r211, String r212, int r310, String r311, List<Block> r312, Map<String, String> r313, ReferenceInfo r314, String r315, List<Integer> r316, ClientControllerParam r317, int r318, String r319, String r410, String r411, String r412, Long r413, String r414, List<String> r415, int r416, Map<String, String> r417, String r418, Boolean r419, com.larus.im.internal.protocol.bean.a r510) {
        return new SendMessageUplinkBody(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SendMessageUplinkBody) == true) goto L8;
        return false;
    L8:
        SendMessageUplinkBody r101 = (SendMessageUplinkBody) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (this.conversationType == r101.conversationType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.senderId, r101.senderId) == true) goto L18;
        return false;
    L18:
        if (this.contentType == r101.contentType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.contentBlock, r101.contentBlock) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.referenceInfo, r101.referenceInfo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.localMessageId, r101.localMessageId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.messageTags, r101.messageTags) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.clientControllerParam, r101.clientControllerParam) == true) goto L42;
        return false;
    L42:
        if (this.botType == r101.botType) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.localConversationId, r101.localConversationId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.localOnboardingMessageId, r101.localOnboardingMessageId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.reeditMsgId, r101.reeditMsgId) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.bizContentType, r101.bizContentType) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.localMessageIdList, r101.localMessageIdList) == true) goto L66;
        return false;
    L66:
        if (this.status == r101.status) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.appletPayload, r101.appletPayload) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.uniqueKey, r101.uniqueKey) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.ackOnly, r101.ackOnly) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.fallbackParam, r101.fallbackParam) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.conversationType) * 31;
        String r104 = this.senderId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.contentType) * 31;
        String r107 = this.content;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<Block> r110 = this.contentBlock;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.ext;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        ReferenceInfo r116 = this.referenceInfo;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.localMessageId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<Integer> r122 = this.messageTags;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        ClientControllerParam r125 = this.clientControllerParam;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (((r124 + r126) * 31) + this.botType) * 31;
        String r128 = this.localConversationId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.botId;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.localOnboardingMessageId;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.reeditMsgId;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Long r140 = this.createTime;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.bizContentType;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        List<String> r146 = this.localMessageIdList;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (((r145 + r147) * 31) + this.status) * 31;
        Map<String, String> r149 = this.appletPayload;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.uniqueKey;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        Boolean r155 = this.ackOnly;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        com.larus.im.internal.protocol.bean.a r158 = this.fallbackParam;
        if (r158 == null) goto L83;
        r101 = r158.hashCode();
    L83:
        return r157 + r101;
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
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
        return "SendMessageUplinkBody(conversationId=" + this.conversationId + ", conversationType=" + this.conversationType + ", senderId=" + this.senderId + ", contentType=" + this.contentType + ", content=" + this.content + ", contentBlock=" + this.contentBlock + ", ext=" + this.ext + ", referenceInfo=" + this.referenceInfo + ", localMessageId=" + this.localMessageId + ", messageTags=" + this.messageTags + ", clientControllerParam=" + this.clientControllerParam + ", botType=" + this.botType + ", localConversationId=" + this.localConversationId + ", botId=" + this.botId + ", localOnboardingMessageId=" + this.localOnboardingMessageId + ", reeditMsgId=" + this.reeditMsgId + ", createTime=" + this.createTime + ", bizContentType=" + this.bizContentType + ", localMessageIdList=" + this.localMessageIdList + ", status=" + this.status + ", appletPayload=" + this.appletPayload + ", uniqueKey=" + this.uniqueKey + ", ackOnly=" + this.ackOnly + ", fallbackParam=" + this.fallbackParam + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, null, null, LazyKt.lazy(r100, new d2()), LazyKt.lazy(r100, new e2()), null, null, LazyKt.lazy(r100, new f2()), null, null, null, null, null, null, null, null, LazyKt.lazy(r100, new af9.g2()), null, LazyKt.lazy(r100, new h2()), null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(SendMessageUplinkBody r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.conversationId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeIntElement(r102, 1, r100.conversationType);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.senderId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeIntElement(r102, 3, r100.contentType);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.content);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, r103[5].getValue(), r100.contentBlock);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, r103[6].getValue(), r100.ext);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, ReferenceInfo.a.f349700a, r100.referenceInfo);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, v2.f520790a, r100.localMessageId);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, r103[9].getValue(), r100.messageTags);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 10, ClientControllerParam.a.f349607a, r100.clientControllerParam);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r101.encodeIntElement(r102, 11, r100.botType);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        boolean r117 = true;
    L117:
        if (r117 == false) goto L120;
        r101.encodeNullableSerializableElement(r102, 12, v2.f520790a, r100.localConversationId);
    L120:
        if (r101.shouldEncodeElementDefault(r102, 13) == false) goto L123;
    L121:
        boolean r118 = true;
    L126:
        if (r118 == false) goto L129;
        r101.encodeNullableSerializableElement(r102, 13, v2.f520790a, r100.botId);
    L129:
        if (r101.shouldEncodeElementDefault(r102, 14) == false) goto L132;
    L130:
        boolean r119 = true;
    L135:
        if (r119 == false) goto L138;
        r101.encodeNullableSerializableElement(r102, 14, v2.f520790a, r100.localOnboardingMessageId);
    L138:
        if (r101.shouldEncodeElementDefault(r102, 15) == false) goto L141;
    L139:
        boolean r120 = true;
    L144:
        if (r120 == false) goto L147;
        r101.encodeNullableSerializableElement(r102, 15, v2.f520790a, r100.reeditMsgId);
    L147:
        if (r101.shouldEncodeElementDefault(r102, 16) == false) goto L150;
    L148:
        boolean r121 = true;
    L153:
        if (r121 == false) goto L156;
        r101.encodeNullableSerializableElement(r102, 16, g1.f520681a, r100.createTime);
    L156:
        if (r101.shouldEncodeElementDefault(r102, 17) == false) goto L159;
    L157:
        boolean r122 = true;
    L162:
        if (r122 == false) goto L165;
        r101.encodeNullableSerializableElement(r102, 17, v2.f520790a, r100.bizContentType);
    L165:
        if (r101.shouldEncodeElementDefault(r102, 18) == false) goto L168;
    L166:
        boolean r123 = true;
    L171:
        if (r123 == false) goto L174;
        r101.encodeNullableSerializableElement(r102, 18, r103[18].getValue(), r100.localMessageIdList);
    L174:
        if (r101.shouldEncodeElementDefault(r102, 19) == false) goto L177;
    L175:
        boolean r124 = true;
    L180:
        if (r124 == false) goto L183;
        r101.encodeIntElement(r102, 19, r100.status);
    L183:
        if (r101.shouldEncodeElementDefault(r102, 20) == false) goto L186;
    L184:
        boolean r125 = true;
    L189:
        if (r125 == false) goto L192;
        r101.encodeNullableSerializableElement(r102, 20, r103[20].getValue(), r100.appletPayload);
    L192:
        if (r101.shouldEncodeElementDefault(r102, 21) == false) goto L195;
    L193:
        boolean r126 = true;
    L198:
        if (r126 == false) goto L201;
        r101.encodeNullableSerializableElement(r102, 21, v2.f520790a, r100.uniqueKey);
    L201:
        if (r101.shouldEncodeElementDefault(r102, 22) == false) goto L204;
    L202:
        boolean r127 = true;
    L207:
        if (r127 == false) goto L210;
        r101.encodeNullableSerializableElement(r102, 22, i.f520705a, r100.ackOnly);
    L210:
        if (r101.shouldEncodeElementDefault(r102, 23) == false) goto L213;
    L211:
        r104 = true;
    L215:
        if (r104 == false) goto L218;
        r101.encodeNullableSerializableElement(r102, 23, com.larus.im.internal.protocol.bean.a.C4371a.f349748a, r100.fallbackParam);
        return;
    L218:
        return;
    L213:
        if (r100.fallbackParam == null) goto L215;
    L204:
        if (Intrinsics.areEqual(r100.ackOnly, Boolean.FALSE) == false) goto L202;
        r127 = false;
        goto L207
    L195:
        if (r100.uniqueKey != null) goto L193;
        r126 = false;
        goto L198
    L186:
        if (r100.appletPayload != null) goto L184;
        r125 = false;
        goto L189
    L177:
        if (r100.status != 0) goto L175;
        r124 = false;
        goto L180
    L168:
        if (r100.localMessageIdList != null) goto L166;
        r123 = false;
        goto L171
    L159:
        if (r100.bizContentType != null) goto L157;
        r122 = false;
        goto L162
    L150:
        if (r100.createTime != null) goto L148;
        r121 = false;
        goto L153
    L141:
        if (r100.reeditMsgId != null) goto L139;
        r120 = false;
        goto L144
    L132:
        if (r100.localOnboardingMessageId != null) goto L130;
        r119 = false;
        goto L135
    L123:
        if (r100.botId != null) goto L121;
        r118 = false;
        goto L126
    L114:
        if (r100.localConversationId != null) goto L112;
        r117 = false;
        goto L117
    L105:
        if (r100.botType != 0) goto L103;
        r116 = false;
        goto L108
    L96:
        if (r100.clientControllerParam != null) goto L94;
        r115 = false;
        goto L99
    L87:
        if (r100.messageTags != null) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.localMessageId != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.referenceInfo != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.ext != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.contentBlock != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.content != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.contentType != 0) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.senderId != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.conversationType != 0) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.conversationId != null) goto L4;
        r105 = false;
        goto L9
    }

    public SendMessageUplinkBody(String r100, int r101, String r102, int r103, String r104, List<Block> r105, Map<String, String> r106, ReferenceInfo r110, String r111, List<Integer> r112, ClientControllerParam r113, int r114, String r115, String r116, String r117, String r118, Long r119, String r210, List<String> r211, int r212, Map<String, String> r213, String r214, Boolean r215, com.larus.im.internal.protocol.bean.a r216) {
        this.conversationId = r100;
        this.conversationType = r101;
        this.senderId = r102;
        this.contentType = r103;
        this.content = r104;
        this.contentBlock = r105;
        this.ext = r106;
        this.referenceInfo = r110;
        this.localMessageId = r111;
        this.messageTags = r112;
        this.clientControllerParam = r113;
        this.botType = r114;
        this.localConversationId = r115;
        this.botId = r116;
        this.localOnboardingMessageId = r117;
        this.reeditMsgId = r118;
        this.createTime = r119;
        this.bizContentType = r210;
        this.localMessageIdList = r211;
        this.status = r212;
        this.appletPayload = r213;
        this.uniqueKey = r214;
        this.ackOnly = r215;
        this.fallbackParam = r216;
    }

    public SendMessageUplinkBody(int r100, String r101, int r102, String r103, int r110, String r111, List r112, Map r113, ReferenceInfo r114, String r115, List r116, ClientControllerParam r117, int r118, String r119, String r210, String r211, String r212, Long r213, String r214, List r215, int r216, Map r217, String r218, Boolean r219, com.larus.im.internal.protocol.bean.a r310, q2 r311) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f349717b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.conversationId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.conversationType = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.senderId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.contentType = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.content = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.contentBlock = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.ext = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.referenceInfo = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.localMessageId = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.messageTags = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.clientControllerParam = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.botType = 0;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.localConversationId = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.botId = null;
    L61:
        if ((r100 & 16384) != 0) goto L63;
        this.localOnboardingMessageId = null;
    L65:
        if ((32768 & r100) != 0) goto L67;
        this.reeditMsgId = null;
    L69:
        if ((65536 & r100) != 0) goto L71;
        this.createTime = null;
    L73:
        if ((131072 & r100) != 0) goto L75;
        this.bizContentType = null;
    L77:
        if ((262144 & r100) != 0) goto L79;
        this.localMessageIdList = null;
    L81:
        if ((524288 & r100) != 0) goto L83;
        this.status = 0;
    L85:
        if ((1048576 & r100) != 0) goto L87;
        this.appletPayload = null;
    L89:
        if ((2097152 & r100) != 0) goto L91;
        this.uniqueKey = null;
    L93:
        if ((4194304 & r100) != 0) goto L95;
        Boolean r104 = Boolean.FALSE;
    L96:
        this.ackOnly = r104;
        if ((r100 & 8388608) != 0) goto L99;
        this.fallbackParam = null;
        return;
    L99:
        this.fallbackParam = r310;
        return;
    L95:
        r104 = r219;
        goto L96
    L91:
        this.uniqueKey = r218;
        goto L93
    L87:
        this.appletPayload = r217;
        goto L89
    L83:
        this.status = r216;
        goto L85
    L79:
        this.localMessageIdList = r215;
        goto L81
    L75:
        this.bizContentType = r214;
        goto L77
    L71:
        this.createTime = r213;
        goto L73
    L67:
        this.reeditMsgId = r212;
        goto L69
    L63:
        this.localOnboardingMessageId = r211;
        goto L65
    L59:
        this.botId = r210;
        goto L61
    L55:
        this.localConversationId = r119;
        goto L57
    L51:
        this.botType = r118;
        goto L53
    L47:
        this.clientControllerParam = r117;
        goto L49
    L43:
        this.messageTags = r116;
        goto L45
    L39:
        this.localMessageId = r115;
        goto L41
    L35:
        this.referenceInfo = r114;
        goto L37
    L31:
        this.ext = r113;
        goto L33
    L27:
        this.contentBlock = r112;
        goto L29
    L23:
        this.content = r111;
        goto L25
    L19:
        this.contentType = r110;
        goto L21
    L15:
        this.senderId = r103;
        goto L17
    L11:
        this.conversationType = r102;
        goto L13
    L7:
        this.conversationId = r101;
        goto L9
    }

    public /* synthetic */ SendMessageUplinkBody(String r210, int r211, String r212, int r213, String r310, List r311, Map r312, ReferenceInfo r313, String r314, List r315, ClientControllerParam r316, int r317, String r318, String r319, String r410, String r411, Long r412, String r413, List r414, int r415, Map r416, String r417, Boolean r418, com.larus.im.internal.protocol.bean.a r419, int r510, DefaultConstructorMarker r511) {
        if ((r510 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r510 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r510 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r510 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r510 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r510 & 32) == 0) goto L25;
        List r105 = null;
    L27:
        if ((r510 & 64) == 0) goto L29;
        Map r106 = null;
    L31:
        if ((r510 & 128) == 0) goto L33;
        ReferenceInfo r110 = null;
    L35:
        if ((r510 & 256) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r510 & 512) == 0) goto L41;
        List r112 = null;
    L43:
        if ((r510 & 1024) == 0) goto L45;
        ClientControllerParam r113 = null;
    L47:
        if ((r510 & 2048) == 0) goto L49;
        int r114 = 0;
    L51:
        if ((r510 & 4096) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r510 & 8192) == 0) goto L57;
        String r107 = null;
    L59:
        if ((r510 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r510 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r510 & 65536) == 0) goto L69;
        Long r117 = null;
    L71:
        if ((r510 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r510 & 262144) == 0) goto L77;
        List r119 = null;
    L79:
        if ((r510 & 524288) == 0) goto L81;
        int r214 = 0;
    L83:
        if ((r510 & 1048576) == 0) goto L85;
        Map r215 = null;
    L87:
        if ((r510 & 2097152) == 0) goto L89;
        String r216 = null;
    L91:
        if ((r510 & 4194304) == 0) goto L93;
        Boolean r217 = Boolean.FALSE;
    L95:
        if ((r510 & 8388608) == 0) goto L97;
        com.larus.im.internal.protocol.bean.a r109 = null;
    L98:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r118, r119, r214, r215, r216, r217, r109);
        return;
    L97:
        r109 = r419;
        goto L98
    L93:
        r217 = r418;
        goto L95
    L89:
        r216 = r417;
        goto L91
    L85:
        r215 = r416;
        goto L87
    L81:
        r214 = r415;
        goto L83
    L77:
        r119 = r414;
        goto L79
    L73:
        r118 = r413;
        goto L75
    L69:
        r117 = r412;
        goto L71
    L65:
        r116 = r411;
        goto L67
    L61:
        r108 = r410;
        goto L63
    L57:
        r107 = r319;
        goto L59
    L53:
        r115 = r318;
        goto L55
    L49:
        r114 = r317;
        goto L51
    L45:
        r113 = r316;
        goto L47
    L41:
        r112 = r315;
        goto L43
    L37:
        r111 = r314;
        goto L39
    L33:
        r110 = r313;
        goto L35
    L29:
        r106 = r312;
        goto L31
    L25:
        r105 = r311;
        goto L27
    L21:
        r104 = r310;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
