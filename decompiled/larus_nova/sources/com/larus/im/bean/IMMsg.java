package com.larus.im.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.larus.utils.gson.TimeTransformAdapter;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u007f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 §\u00012\u00020\u0001:\u0004§\u0001¨\u0001BÛ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\"\u001a\u00020\b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b%\u0010&J\b\u0010v\u001a\u00020\u0003H\u0016J\u0012\u0010w\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010x\u001a\u00020\u00032\b\u0010y\u001a\u0004\u0018\u00010\u0003H\u0002J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00102J\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00102J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00102J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u008b\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00102J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010GJ\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00102J\u0011\u0010\u008e\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00102J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00102J\u0011\u0010\u0093\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00102J\u0012\u0010\u0094\u0001\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cHÆ\u0003J\u0011\u0010\u0095\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00102J\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0002\u0010cJ\u0011\u0010\u0097\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00102J\n\u0010\u0098\u0001\u001a\u00020\bHÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010GJä\u0002\u0010\u009b\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\"\u001a\u00020\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0003\u0010\u009c\u0001J\u0007\u0010\u009d\u0001\u001a\u00020\bJ\u0016\u0010\u009e\u0001\u001a\u00020 2\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001HÖ\u0003J\n\u0010¡\u0001\u001a\u00020\bHÖ\u0001J\u001b\u0010¢\u0001\u001a\u00030£\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012\u0007\u0010¦\u0001\u001a\u00020\bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b6\u00102\"\u0004\b7\u00104R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010(\"\u0004\b9\u0010*R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010(\"\u0004\b;\u0010*R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010(\"\u0004\b=\u0010*R\"\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b>\u00102\"\u0004\b?\u00104R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010(\"\u0004\bA\u0010*R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010(\"\u0004\bC\u0010*R\"\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\bD\u00102\"\u0004\bE\u00104R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010J\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\bK\u00102\"\u0004\bL\u00104R\"\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\bM\u00102\"\u0004\bN\u00104R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010(\"\u0004\bP\u0010*R&\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bQ\u0010R\u001a\u0004\bS\u0010(\"\u0004\bT\u0010*R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\bY\u00102\"\u0004\bZ\u00104R\"\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b[\u00102\"\u0004\b\\\u00104R&\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\ba\u00102\"\u0004\bb\u00104R\"\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010f\u001a\u0004\b\u001f\u0010c\"\u0004\bd\u0010eR\"\u0010!\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\bg\u00102\"\u0004\bh\u00104R\u001e\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR \u0010#\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010(\"\u0004\bn\u0010*R\"\u0010$\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010J\u001a\u0004\bo\u0010G\"\u0004\bp\u0010IR\u0013\u0010q\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\br\u0010(R\u0011\u0010s\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0011\u0010u\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bu\u0010tR\u0011\u0010z\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bz\u0010tR\u0011\u0010{\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b{\u0010tR\u0011\u0010|\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b|\u0010tR\u0011\u0010}\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b~\u0010(¨\u0006©\u0001"}, d2 = {"Lcom/larus/im/bean/IMMsg;", "Landroid/os/Parcelable;", "conversationId", "", "localConversationId", "sourceConversationId", "botId", "sourceStartIndex", "", "sourceEndIndex", "sectionId", "messageId", "localMessageId", "index", "sender", "replyId", "status", "createTime", "", "messageType", "contentType", "content", "ttsContent", "ext", "Lcom/larus/im/bean/IMMsgExt;", "feedback", OnekeyLoginConstants.CU_KEY_SEQ, "metaInfo", "", "Lcom/larus/im/bean/IMMetaInfo;", "nextConnectionType", "isDelta", "", "version", "totalSize", "logId", UserInfo.UPDATE_TIME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/IMMsgExt;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/Long;)V", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", "getLocalConversationId", "setLocalConversationId", "getSourceConversationId", "setSourceConversationId", "getBotId", "setBotId", "getSourceStartIndex", "()Ljava/lang/Integer;", "setSourceStartIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSourceEndIndex", "setSourceEndIndex", "getSectionId", "setSectionId", "getMessageId", "setMessageId", "getLocalMessageId", "setLocalMessageId", "getIndex", "setIndex", "getSender", "setSender", "getReplyId", "setReplyId", "getStatus", "setStatus", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMessageType", "setMessageType", "getContentType", "setContentType", "getContent", "setContent", "getTtsContent$annotations", "()V", "getTtsContent", "setTtsContent", "getExt", "()Lcom/larus/im/bean/IMMsgExt;", "setExt", "(Lcom/larus/im/bean/IMMsgExt;)V", "getFeedback", "setFeedback", "getSeq", "setSeq", "getMetaInfo", "()Ljava/util/List;", "setMetaInfo", "(Ljava/util/List;)V", "getNextConnectionType", "setNextConnectionType", "()Ljava/lang/Boolean;", "setDelta", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getVersion", "setVersion", "getTotalSize", "()I", "setTotalSize", "(I)V", "getLogId", "setLogId", "getUpdateTime", "setUpdateTime", "err", "getErr", "isInterrupted", "()Z", "isFinish", "toString", "senderId", SelectInfo.BRIEF, "what", "isServerLoading", "isOnBoardingMsg", "isPromptMsg", "apiId", "getApiId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/IMMsgExt;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/Long;)Lcom/larus/im/bean/IMMsg;", "describeContents", "equals", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "Status", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMMsg implements Parcelable {
    public static final Parcelable.Creator<IMMsg> CREATOR = null;

    @SerializedName("bot_id")
    private String botId;

    @SerializedName("content")
    private String content;

    @SerializedName("content_type")
    private Integer contentType;

    @SerializedName("conversation_id")
    private String conversationId;

    @SerializedName("create_time")
    @JsonAdapter(TimeTransformAdapter.class)
    private Long createTime;

    @SerializedName("ext")
    private IMMsgExt ext;

    @SerializedName("feedback")
    private Integer feedback;

    @SerializedName("index")
    private Integer index;

    @SerializedName("is_delta")
    private Boolean isDelta;

    @SerializedName("local_conversation_id")
    private String localConversationId;

    @SerializedName("local_message_id")
    private String localMessageId;

    @SerializedName("log_id")
    @Expose(deserialize = false)
    private String logId;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private String messageId;

    @SerializedName("message_type")
    private Integer messageType;

    @SerializedName("meta_infos")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<IMMetaInfo> metaInfo;

    @SerializedName("next_connection_type")
    private Integer nextConnectionType;

    @SerializedName(NoticeInfo.KEY_REPLY_ID)
    private String replyId;

    @SerializedName("section_id")
    private String sectionId;

    @SerializedName("sec_sender")
    private String sender;

    @SerializedName("chunk_seq")
    private Integer seq;

    @SerializedName("source_conversation_id")
    private String sourceConversationId;

    @SerializedName("source_end_index")
    private Integer sourceEndIndex;

    @SerializedName("source_start_index")
    private Integer sourceStartIndex;

    @SerializedName("status")
    private Integer status;

    @Expose(deserialize = false, serialize = false)
    private int totalSize;

    @SerializedName("tts_content")
    private String ttsContent;

    @SerializedName("update_time")
    private Long updateTime;

    @SerializedName("version")
    private Integer version;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/im/bean/IMMsg$Status;", "", "<init>", "(Ljava/lang/String;I)V", "PREPARE", "SENDING", "SUCCESS", "FAILED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status FAILED = null;
        public static final Status PREPARE = null;
        public static final Status SENDING = null;
        public static final Status SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f346411a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f346412b = null;

        public static EnumEntries<Status> getEntries() {
            return f346412b;
        }

        static {
            Status r100 = new Status("PREPARE", 0);
            PREPARE = r100;
            Status r101 = new Status("SENDING", 1);
            SENDING = r101;
            Status r102 = new Status("SUCCESS", 2);
            SUCCESS = r102;
            Status r103 = new Status("FAILED", 3);
            FAILED = r103;
            Status[] r104 = {r100, r101, r102, r103};
            f346411a = r104;
            f346412b = EnumEntriesKt.enumEntries(r104);
        }

        public static Status[] values() {
            return (Status[]) f346411a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<IMMsg> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final IMMsg createFromParcel(Parcel r310) {
            Intrinsics.checkNotNullParameter(r310, "parcel");
            String r100 = r310.readString();
            String r101 = r310.readString();
            String r102 = r310.readString();
            String r103 = r310.readString();
            if (r310.readInt() != 0) goto L5;
            Integer r104 = null;
        L7:
            if (r310.readInt() != 0) goto L9;
            Integer r105 = null;
        L10:
            String r106 = r310.readString();
            String r110 = r310.readString();
            String r111 = r310.readString();
            if (r310.readInt() != 0) goto L13;
            Integer r112 = null;
        L14:
            String r113 = r310.readString();
            String r114 = r310.readString();
            if (r310.readInt() != 0) goto L17;
            Integer r115 = null;
        L19:
            if (r310.readInt() != 0) goto L21;
            Long r116 = null;
        L23:
            if (r310.readInt() != 0) goto L25;
            Integer r117 = null;
        L27:
            if (r310.readInt() != 0) goto L29;
            Integer r118 = null;
        L30:
            String r119 = r310.readString();
            String r210 = r310.readString();
            IMMsgExt r211 = (IMMsgExt) r310.readSerializable();
            if (r310.readInt() != 0) goto L33;
            Integer r212 = null;
        L35:
            if (r310.readInt() != 0) goto L37;
            Integer r213 = null;
        L38:
            boolean r214 = false;
            if (r310.readInt() != 0) goto L41;
            ArrayList r107 = null;
        L46:
            if (r310.readInt() != 0) goto L48;
            Integer r215 = null;
        L50:
            if (r310.readInt() != 0) goto L53;
            Boolean r216 = null;
        L57:
            if (r310.readInt() != 0) goto L59;
            Integer r217 = null;
        L60:
            int r311 = r310.readInt();
            String r312 = r310.readString();
            if (r310.readInt() != 0) goto L63;
            Long r108 = null;
        L65:
            return new IMMsg(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r107, r215, r216, r217, r311, r312, r108);
        L63:
            r108 = Long.valueOf(r310.readLong());
            goto L65
        L59:
            r217 = Integer.valueOf(r310.readInt());
            goto L60
        L53:
            if (r310.readInt() == 0) goto L55;
            r214 = true;
        L55:
            r216 = Boolean.valueOf(r214);
            goto L57
        L48:
            r215 = Integer.valueOf(r310.readInt());
            goto L50
        L41:
            int r109 = r310.readInt();
            ArrayList r120 = new ArrayList(r109);
            int r121 = 0;
        L42:
            if (r121 == r109) goto L44;
            int r218 = r109;
            r120.add(IMMetaInfo.CREATOR.createFromParcel(r310));
            r121 = r121 + 1;
            r109 = r218;
            goto L42
        L44:
            r107 = r120;
            goto L46
        L37:
            r213 = Integer.valueOf(r310.readInt());
            goto L38
        L33:
            r212 = Integer.valueOf(r310.readInt());
            goto L35
        L29:
            r118 = Integer.valueOf(r310.readInt());
            goto L30
        L25:
            r117 = Integer.valueOf(r310.readInt());
            goto L27
        L21:
            r116 = Long.valueOf(r310.readLong());
            goto L23
        L17:
            r115 = Integer.valueOf(r310.readInt());
            goto L19
        L13:
            r112 = Integer.valueOf(r310.readInt());
            goto L14
        L9:
            r105 = Integer.valueOf(r310.readInt());
            goto L10
        L5:
            r104 = Integer.valueOf(r310.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final IMMsg[] newArray(int r100) {
            return new IMMsg[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    public IMMsg() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 0, Long.valueOf(AppHost.f326268a.getAppClock().currentTimeMillis()), 1, 1, null, null, null, 0, null, null, 0, Boolean.FALSE, 0, 0, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IMMsg) == true) goto L8;
        return false;
    L8:
        IMMsg r101 = (IMMsg) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.localConversationId, r101.localConversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceConversationId, r101.sourceConversationId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sourceStartIndex, r101.sourceStartIndex) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sourceEndIndex, r101.sourceEndIndex) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sectionId, r101.sectionId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.localMessageId, r101.localMessageId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.index, r101.index) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.sender, r101.sender) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.replyId, r101.replyId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.messageType, r101.messageType) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.contentType, r101.contentType) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.ttsContent, r101.ttsContent) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.feedback, r101.feedback) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.seq, r101.seq) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.metaInfo, r101.metaInfo) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.nextConnectionType, r101.nextConnectionType) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.isDelta, r101.isDelta) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L84;
        return false;
    L84:
        if (this.totalSize == r101.totalSize) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L92;
        return false;
    L92:
        return true;
    }

    public final int hashCode() {
        String r100 = this.conversationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.localConversationId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.sourceConversationId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.botId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.sourceStartIndex;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.sourceEndIndex;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.sectionId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.messageId;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.localMessageId;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.index;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.sender;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.replyId;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.status;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Long r140 = this.createTime;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.messageType;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Integer r146 = this.contentType;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.content;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.ttsContent;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        IMMsgExt r155 = this.ext;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        Integer r158 = this.feedback;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        Integer r161 = this.seq;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        List<IMMetaInfo> r164 = this.metaInfo;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        Integer r167 = this.nextConnectionType;
        if (r167 != null) goto L93;
        int r168 = 0;
    L94:
        int r169 = (r166 + r168) * 31;
        Boolean r170 = this.isDelta;
        if (r170 != null) goto L97;
        int r171 = 0;
    L98:
        int r172 = (r169 + r171) * 31;
        Integer r173 = this.version;
        if (r173 != null) goto L101;
        int r174 = 0;
    L102:
        int r175 = (((r172 + r174) * 31) + this.totalSize) * 31;
        String r176 = this.logId;
        if (r176 != null) goto L105;
        int r177 = 0;
    L106:
        int r178 = (r175 + r177) * 31;
        Long r179 = this.updateTime;
        if (r179 == null) goto L111;
        r101 = r179.hashCode();
    L111:
        return r178 + r101;
    L105:
        r177 = r176.hashCode();
        goto L106
    L101:
        r174 = r173.hashCode();
        goto L102
    L97:
        r171 = r170.hashCode();
        goto L98
    L93:
        r168 = r167.hashCode();
        goto L94
    L89:
        r165 = r164.hashCode();
        goto L90
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
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

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.conversationId);
        r100.writeString(this.localConversationId);
        r100.writeString(this.sourceConversationId);
        r100.writeString(this.botId);
        Integer r102 = this.sourceStartIndex;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.sourceEndIndex;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.sectionId);
        r100.writeString(this.messageId);
        r100.writeString(this.localMessageId);
        Integer r104 = this.index;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        r100.writeString(this.sender);
        r100.writeString(this.replyId);
        Integer r105 = this.status;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        Long r106 = this.createTime;
        if (r106 != null) goto L21;
        r100.writeInt(0);
    L22:
        Integer r107 = this.messageType;
        if (r107 != null) goto L25;
        r100.writeInt(0);
    L26:
        Integer r108 = this.contentType;
        if (r108 != null) goto L29;
        r100.writeInt(0);
    L30:
        r100.writeString(this.content);
        r100.writeString(this.ttsContent);
        r100.writeSerializable(this.ext);
        Integer r109 = this.feedback;
        if (r109 != null) goto L33;
        r100.writeInt(0);
    L34:
        Integer r110 = this.seq;
        if (r110 != null) goto L37;
        r100.writeInt(0);
    L38:
        List<IMMetaInfo> r111 = this.metaInfo;
        if (r111 != null) goto L41;
        r100.writeInt(0);
    L45:
        Integer r112 = this.nextConnectionType;
        if (r112 != null) goto L48;
        r100.writeInt(0);
    L49:
        Boolean r113 = this.isDelta;
        if (r113 != null) goto L52;
        r100.writeInt(0);
    L53:
        Integer r114 = this.version;
        if (r114 != null) goto L56;
        r100.writeInt(0);
    L57:
        r100.writeInt(this.totalSize);
        r100.writeString(this.logId);
        Long r115 = this.updateTime;
        if (r115 != null) goto L60;
        r100.writeInt(0);
        return;
    L60:
        r100.writeInt(1);
        r100.writeLong(r115.longValue());
        return;
    L56:
        r100.writeInt(1);
        r100.writeInt(r114.intValue());
        goto L57
    L52:
        r100.writeInt(1);
        r100.writeInt(r113.booleanValue() ? 1 : 0);
        goto L53
    L48:
        r100.writeInt(1);
        r100.writeInt(r112.intValue());
        goto L49
    L41:
        r100.writeInt(1);
        r100.writeInt(r111.size());
        Iterator<IMMetaInfo> r116 = r111.iterator();
    L43:
        if (r116.hasNext() == false) goto L45;
        r116.next().writeToParcel(r100, r101);
        goto L43
    L37:
        r100.writeInt(1);
        r100.writeInt(r110.intValue());
        goto L38
    L33:
        r100.writeInt(1);
        r100.writeInt(r109.intValue());
        goto L34
    L29:
        r100.writeInt(1);
        r100.writeInt(r108.intValue());
        goto L30
    L25:
        r100.writeInt(1);
        r100.writeInt(r107.intValue());
        goto L26
    L21:
        r100.writeInt(1);
        r100.writeLong(r106.longValue());
        goto L22
    L17:
        r100.writeInt(1);
        r100.writeInt(r105.intValue());
        goto L18
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("Msgv");
        r100.append(this.version);
        r100.append("[seq=");
        r100.append(this.seq);
        r100.append(". id=");
        r100.append(this.messageId);
        r100.append(", sec=");
        r100.append(this.sectionId);
        r100.append(", cvs=");
        r100.append(this.conversationId);
        r100.append(", bot=");
        r100.append(this.botId);
        r100.append(". status=");
        r100.append(this.status);
        r100.append(". msgType=");
        r100.append(this.messageType);
        r100.append(", contentType=");
        r100.append(this.contentType);
        r100.append(". reply=");
        r100.append(this.replyId);
        r100.append(". localId=");
        r100.append(this.localMessageId);
        r100.append(". i=");
        r100.append(this.index);
        r100.append(". u=");
        String r101 = this.sender;
        boolean r102 = false;
        Boolean r103 = null;
        String r104 = null;
        if (r101 == null) goto L10;
        String r105 = StringsKt.trim(r101).toString();
        if (r105 == null) goto L10;
        if (r105.length() <= 10) goto L11;
        r105 = r105.substring(0, 2) + "**" + r105.substring(r105.length() - 8, r105.length());
    L11:
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        r100.append(r105);
        r100.append(". content=");
        r100.append(this.content);
        r100.append(". ttsContent=");
        r100.append(this.ttsContent);
        r100.append(". err=");
        IMMsgExt r106 = this.ext;
        if (r106 == null) goto L19;
        if (r106.isErr() != true) goto L19;
        r102 = true;
    L19:
        if (r102 == false) goto L28;
        StringBuilder r107 = new StringBuilder();
        IMMsgExt r108 = this.ext;
        if (r108 == null) goto L23;
        Long r109 = Long.valueOf(r108.getErrCode());
    L24:
        r107.append(r109);
        r107.append('/');
        IMMsgExt r110 = this.ext;
        if (r110 == null) goto L27;
        r104 = r110.getErrMsg();
    L27:
        r107.append(r104);
        String r111 = ". ";
    L44:
        r107.append(r111);
        r100.append(r107.toString());
        return r100.toString();
    L23:
        r109 = null;
        goto L24
    L28:
        r107 = new StringBuilder("null. isFinish=");
        IMMsgExt r112 = this.ext;
        if (r112 == null) goto L31;
        Boolean r113 = Boolean.valueOf(r112.isFinish());
    L32:
        r107.append(r113);
        r107.append(". hasSuggest=");
        IMMsgExt r114 = this.ext;
        if (r114 == null) goto L35;
        Boolean r115 = Boolean.valueOf(r114.getHasSuggest());
    L36:
        r107.append(r115);
        r107.append(". disableTypeWriter=");
        IMMsgExt r116 = this.ext;
        if (r116 == null) goto L39;
        Boolean r117 = Boolean.valueOf(r116.getDisableTypeWriter());
    L40:
        r107.append(r117);
        r107.append(". disableActionView=");
        IMMsgExt r118 = this.ext;
        if (r118 == null) goto L43;
        r103 = Boolean.valueOf(r118.getDisableActionView());
    L43:
        r107.append(r103);
        r107.append(". protocol=");
        r107.append(this.nextConnectionType);
        r107.append(". isDelta=");
        r107.append(this.isDelta);
        r107.append(". metaInfo=");
        Lazy r119 = com.larus.utils.gson.b.f375403a;
        r107.append(com.larus.utils.gson.b.a(this.metaInfo));
        r111 = ". ]";
        goto L44
    L39:
        r117 = null;
        goto L40
    L35:
        r115 = null;
        goto L36
    L31:
        r113 = null;
    L10:
        r105 = null;
        goto L11
    }

    public final String a() {
        return this.content;
    }

    public final Integer b() {
        return this.contentType;
    }

    public final String c() {
        return this.conversationId;
    }

    public final IMMsgExt d() {
        return this.ext;
    }

    public final Integer e() {
        return this.feedback;
    }

    public final Integer g() {
        return this.index;
    }

    public final String h() {
        return this.localMessageId;
    }

    public final String i() {
        return this.messageId;
    }

    public final Integer j() {
        return this.messageType;
    }

    public final String k() {
        return this.replyId;
    }

    public final String o() {
        return this.sectionId;
    }

    public final String q() {
        return this.sender;
    }

    public final void r(Integer r100) {
        this.index = r100;
    }

    public IMMsg(String r100, String r101, String r102, String r103, Integer r104, Integer r105, String r106, String r110, String r111, Integer r112, String r113, String r114, Integer r115, Long r116, Integer r117, Integer r118, String r119, String r210, IMMsgExt r211, Integer r212, Integer r213, List<IMMetaInfo> r214, Integer r215, Boolean r216, Integer r217, int r218, String r219, Long r310) {
        this.conversationId = r100;
        this.localConversationId = r101;
        this.sourceConversationId = r102;
        this.botId = r103;
        this.sourceStartIndex = r104;
        this.sourceEndIndex = r105;
        this.sectionId = r106;
        this.messageId = r110;
        this.localMessageId = r111;
        this.index = r112;
        this.sender = r113;
        this.replyId = r114;
        this.status = r115;
        this.createTime = r116;
        this.messageType = r117;
        this.contentType = r118;
        this.content = r119;
        this.ttsContent = r210;
        this.ext = r211;
        this.feedback = r212;
        this.seq = r213;
        this.metaInfo = r214;
        this.nextConnectionType = r215;
        this.isDelta = r216;
        this.version = r217;
        this.totalSize = r218;
        this.logId = r219;
        this.updateTime = r310;
    }
}
