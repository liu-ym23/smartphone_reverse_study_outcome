package com.larus.im.bean;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.bmhome.chat.component.list.ChatListComponentViewModel;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\t\n\u0003\bñ\u0001\u0018\u0000 ©\u00022\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0003:\u0002©\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR(\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R(\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R$\u0010'\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010\n\"\u0004\b)\u0010\fR$\u0010*\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010\n\"\u0004\b,\u0010\fR$\u0010-\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010\n\"\u0004\b/\u0010\fR$\u00100\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010\n\"\u0004\b2\u0010\fR$\u00103\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011R$\u00106\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010\n\"\u0004\b7\u0010\fR\u0011\u00108\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b8\u0010\nR$\u0010:\u001a\u0002092\u0006\u0010\u0006\u001a\u0002098F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010?\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010\u000f\"\u0004\bA\u0010\u0011R$\u0010B\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bC\u0010\n\"\u0004\bD\u0010\fR\u0011\u0010E\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bF\u0010\nR\u0011\u0010G\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bH\u0010\nR\u0011\u0010I\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bJ\u0010\nR\u0011\u0010K\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bL\u0010\nR\u0011\u0010M\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bN\u0010\nR\u0011\u0010O\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bP\u0010\nR\u0011\u0010Q\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bR\u0010<R\u0011\u0010S\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bT\u0010<R\u0011\u0010U\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bV\u0010<R\u0011\u0010W\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bX\u0010\u000fR$\u0010Y\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010\n\"\u0004\b[\u0010\fR$\u0010\\\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010\n\"\u0004\b^\u0010\fR$\u0010_\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u0010\n\"\u0004\ba\u0010\fR(\u0010b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010\u000f\"\u0004\bd\u0010\u0011R$\u0010e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bf\u0010\u000f\"\u0004\bg\u0010\u0011R$\u0010h\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010\u000f\"\u0004\bj\u0010\u0011R$\u0010k\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bl\u0010!\"\u0004\bm\u0010#R$\u0010n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u0010\u000f\"\u0004\bp\u0010\u0011R\u0011\u0010q\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bq\u0010\nR\u0011\u0010r\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\br\u0010\nR\u0011\u0010s\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bs\u0010\nR\u0011\u0010t\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bu\u0010\u000fR\u0011\u0010v\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\bw\u0010!R\u0011\u0010x\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\by\u0010\u000fR\u0011\u0010z\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b{\u0010\u000fR\u0011\u0010|\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b}\u0010\u000fR%\u0010~\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\r\u001a\u0004\b\u007f\u0010!\"\u0005\b\u0080\u0001\u0010#R'\u0010\u0081\u0001\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0082\u0001\u0010!\"\u0005\b\u0083\u0001\u0010#R'\u0010\u0084\u0001\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0085\u0001\u0010!\"\u0005\b\u0086\u0001\u0010#R'\u0010\u0087\u0001\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0087\u0001\u0010!\"\u0005\b\u0088\u0001\u0010#R'\u0010\u0089\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008a\u0001\u0010\u000f\"\u0005\b\u008b\u0001\u0010\u0011R'\u0010\u008c\u0001\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008d\u0001\u0010!\"\u0005\b\u008e\u0001\u0010#R'\u0010\u008f\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0090\u0001\u0010\u000f\"\u0005\b\u0091\u0001\u0010\u0011R'\u0010\u0092\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0093\u0001\u0010\u000f\"\u0005\b\u0094\u0001\u0010\u0011R\u0013\u0010\u0095\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010\u000fR\u0013\u0010\u0097\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0098\u0001\u0010\u000fR\u0013\u0010\u0099\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010\u000fR\u0013\u0010\u009b\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010\u000fR\u0013\u0010\u009d\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010\u000fR\u0013\u0010\u009f\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b \u0001\u0010\u000fR\u0013\u0010¡\u0001\u001a\u00020\u001e8F¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010!R\u0016\u0010£\u0001\u001a\u0004\u0018\u00010\u001e8F¢\u0006\b\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0013\u0010¦\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b§\u0001\u0010\u000fR\u0013\u0010¨\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b©\u0001\u0010\u000fR\u0013\u0010ª\u0001\u001a\u00020\u001e8F¢\u0006\u0007\u001a\u0005\b«\u0001\u0010!R\u0013\u0010¬\u0001\u001a\u0002098F¢\u0006\u0007\u001a\u0005\b\u00ad\u0001\u0010<R\u0013\u0010®\u0001\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\b®\u0001\u0010\nR\u0013\u0010¯\u0001\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\b¯\u0001\u0010\nR\u0013\u0010°\u0001\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\b°\u0001\u0010\nR\u0013\u0010±\u0001\u001a\u00020\u001e8F¢\u0006\u0007\u001a\u0005\b²\u0001\u0010!R+\u0010³\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b´\u0001\u0010\u000f\"\u0005\bµ\u0001\u0010\u0011R+\u0010¶\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b·\u0001\u0010\u000f\"\u0005\b¸\u0001\u0010\u0011R-\u0010¹\u0001\u001a\u0004\u0018\u0001092\b\u0010\u0006\u001a\u0004\u0018\u0001098F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R'\u0010¾\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¿\u0001\u0010\u000f\"\u0005\bÀ\u0001\u0010\u0011R'\u0010Á\u0001\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÂ\u0001\u0010!\"\u0005\bÃ\u0001\u0010#R'\u0010Ä\u0001\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÅ\u0001\u0010!\"\u0005\bÆ\u0001\u0010#R'\u0010Ç\u0001\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÈ\u0001\u0010!\"\u0005\bÉ\u0001\u0010#R'\u0010Ê\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÊ\u0001\u0010\u000f\"\u0005\bË\u0001\u0010\u0011R'\u0010Ì\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÍ\u0001\u0010\u000f\"\u0005\bÎ\u0001\u0010\u0011R'\u0010Ï\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÐ\u0001\u0010\u000f\"\u0005\bÑ\u0001\u0010\u0011R'\u0010Ò\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÓ\u0001\u0010\u000f\"\u0005\bÔ\u0001\u0010\u0011R+\u0010Õ\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÖ\u0001\u0010\u000f\"\u0005\b×\u0001\u0010\u0011R'\u0010Ø\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÙ\u0001\u0010\u000f\"\u0005\bÚ\u0001\u0010\u0011R\u0013\u0010Û\u0001\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\bÜ\u0001\u0010\nR\u0013\u0010Ý\u0001\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\bÞ\u0001\u0010\nR'\u0010ß\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bà\u0001\u0010\u000f\"\u0005\bá\u0001\u0010\u0011R'\u0010â\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bã\u0001\u0010\u000f\"\u0005\bä\u0001\u0010\u0011R'\u0010å\u0001\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bæ\u0001\u0010\n\"\u0005\bç\u0001\u0010\fR'\u0010è\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bé\u0001\u0010\u000f\"\u0005\bê\u0001\u0010\u0011R'\u0010ë\u0001\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bì\u0001\u0010\n\"\u0005\bí\u0001\u0010\fR'\u0010î\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bï\u0001\u0010\u000f\"\u0005\bð\u0001\u0010\u0011R'\u0010ñ\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bò\u0001\u0010\u000f\"\u0005\bó\u0001\u0010\u0011R'\u0010ô\u0001\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bõ\u0001\u0010!\"\u0005\bö\u0001\u0010#R'\u0010÷\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bø\u0001\u0010\u000f\"\u0005\bù\u0001\u0010\u0011R'\u0010ú\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bû\u0001\u0010\u000f\"\u0005\bü\u0001\u0010\u0011R'\u0010ý\u0001\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bþ\u0001\u0010\u000f\"\u0005\bÿ\u0001\u0010\u0011R'\u0010\u0080\u0002\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0081\u0002\u0010\u000f\"\u0005\b\u0082\u0002\u0010\u0011R'\u0010\u0083\u0002\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0084\u0002\u0010\u000f\"\u0005\b\u0085\u0002\u0010\u0011R'\u0010\u0086\u0002\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0087\u0002\u0010!\"\u0005\b\u0088\u0002\u0010#R\u0013\u0010\u0089\u0002\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\b\u008a\u0002\u0010\nR+\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008c\u0002\u0010\u000f\"\u0005\b\u008d\u0002\u0010\u0011R'\u0010\u008e\u0002\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008f\u0002\u0010\u000f\"\u0005\b\u0090\u0002\u0010\u0011R'\u0010\u0091\u0002\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0092\u0002\u0010\u000f\"\u0005\b\u0093\u0002\u0010\u0011R\u0013\u0010\u0094\u0002\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\b\u0094\u0002\u0010\nR+\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0096\u0002\u0010\u000f\"\u0005\b\u0097\u0002\u0010\u0011R+\u0010\u0098\u0002\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0099\u0002\u0010\u000f\"\u0005\b\u009a\u0002\u0010\u0011R\u0015\u0010\u009b\u0002\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0007\u001a\u0005\b\u009c\u0002\u0010\u000fR\u0015\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0007\u001a\u0005\b\u009e\u0002\u0010\u000fR\u0015\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0007\u001a\u0005\b \u0002\u0010\u000fR\u0015\u0010¡\u0002\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0007\u001a\u0005\b¢\u0002\u0010\u000fR+\u0010£\u0002\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¤\u0002\u0010\u000f\"\u0005\b¥\u0002\u0010\u0011R\u0013\u0010¦\u0002\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\b¦\u0002\u0010\nR\u0013\u0010§\u0002\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\b¨\u0002\u0010\n¨\u0006ª\u0002"}, d2 = {"Lcom/larus/im/bean/IMMsgExt;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<init>", "()V", "value", "", "stream", "getStream", "()Z", "setStream", "(Z)V", "ttsStr", "getTtsStr", "()Ljava/lang/String;", "setTtsStr", "(Ljava/lang/String;)V", "eduExtForTts", "getEduExtForTts", "setEduExtForTts", "tts", "getTts", "setTts", "localCallId", "getLocalCallId", "setLocalCallId", "callAsrId", "getCallAsrId", "setCallAsrId", "", "mediaSearchType", "getMediaSearchType", "()I", "setMediaSearchType", "(I)V", "answerWithSuggest", "getAnswerWithSuggest", "setAnswerWithSuggest", "replace", "getReplace", "setReplace", "delete", "getDelete", "setDelete", "regen", "getRegen", "setRegen", "regenActive", "getRegenActive", "setRegenActive", "lastRegenerateSelectedMessageId", "getLastRegenerateSelectedMessageId", "setLastRegenerateSelectedMessageId", "isFinish", "setFinish", "isErr", "", "errCode", "getErrCode", "()J", "setErrCode", "(J)V", "errMsg", "getErrMsg", "setErrMsg", "hasSuggest", "getHasSuggest", "setHasSuggest", "disableTypeWriter", "getDisableTypeWriter", "queueTtsMessage", "getQueueTtsMessage", "feelyImgMessage", "getFeelyImgMessage", "serverLoadingNotInterruptTts", "getServerLoadingNotInterruptTts", "feelyEmojiImgMessage", "getFeelyEmojiImgMessage", "disableActionView", "getDisableActionView", "timeout", "getTimeout", "streamTimeout", "getStreamTimeout", "limitTime", "getLimitTime", "limitTips", "getLimitTips", "searchView", "getSearchView", "setSearchView", "needLocation", "getNeedLocation", "setNeedLocation", "updateLocation", "getUpdateLocation", "setUpdateLocation", "pluginAuthInfo", "getPluginAuthInfo", "setPluginAuthInfo", "wiki", "getWiki", "setWiki", "sWikiLink", "getSWikiLink", "setSWikiLink", "searchEngineType", "getSearchEngineType", "setSearchEngineType", "searchUrl", "getSearchUrl", "setSearchUrl", "isClearContextMessage", "isCrowdTest", "isDeepThinkingPro", "crowdTestTitle", "getCrowdTestTitle", "streamIndex", "getStreamIndex", "crowdTestSubTitle", "getCrowdTestSubTitle", "crowdTestButtonList", "getCrowdTestButtonList", "crowdTestMessageIndex", "getCrowdTestMessageIndex", "multiBots", "getMultiBots", "setMultiBots", "onBoarding", "getOnBoarding", "setOnBoarding", "onBoardingV2", "getOnBoardingV2", "setOnBoardingV2", "isConnectCallerName", "setConnectCallerName", "onBoardingContentSource", "getOnBoardingContentSource", "setOnBoardingContentSource", "bigProfile", "getBigProfile", "setBigProfile", SelectInfo.BRIEF, "getBrief", "setBrief", "pluginPayload", "getPluginPayload", "setPluginPayload", "suggestPrompt", "getSuggestPrompt", "suggestV2Prompt", "getSuggestV2Prompt", "suggestItems", "getSuggestItems", "suggestItemsV2", "getSuggestItemsV2", "nextPulseRespData", "getNextPulseRespData", "wcbTitle", "getWcbTitle", "wcbTitleStyle", "getWcbTitleStyle", "nextPulseType", "getNextPulseType", "()Ljava/lang/Integer;", "onboardingDisplayStyle", "getOnboardingDisplayStyle", "onboardingSug", "getOnboardingSug", "onboardingSugType", "getOnboardingSugType", "onboardingSugExpirationTime", "getOnboardingSugExpirationTime", "isClickClearContext", "isWelcomeBackMessageHidden", "isNoDisappear", "suggestActionCardCnt", "getSuggestActionCardCnt", "fromAsr", "getFromAsr", "setFromAsr", "templateData", "getTemplateData", "setTemplateData", GXTemplateKey.GAIAX_TEMPLATE_ID, "getTemplateId", "()Ljava/lang/Long;", "setTemplateId", "(Ljava/lang/Long;)V", "itemId", "getItemId", "setItemId", "searchIntend", "getSearchIntend", "setSearchIntend", "fromPush", "getFromPush", "setFromPush", "modelType", "getModelType", "setModelType", "isFromCache", "setFromCache", "llmFakePrompt", "getLlmFakePrompt", "setLlmFakePrompt", "llmFakeResponse", "getLlmFakeResponse", "setLlmFakeResponse", "enterChatMethod", "getEnterChatMethod", "setEnterChatMethod", "source", "getSource", "setSource", "apiId", "getApiId", "setApiId", "proactiveBotMessage", "getProactiveBotMessage", "actionBarProactiveBotMessage", "getActionBarProactiveBotMessage", "collectionId", "getCollectionId", "setCollectionId", "sourceMessageId", "getSourceMessageId", "setSourceMessageId", "localSubCoCoMsg", "getLocalSubCoCoMsg", "setLocalSubCoCoMsg", "onboardingCardID", "getOnboardingCardID", "setOnboardingCardID", "enableVideoRecommend", "getEnableVideoRecommend", "setEnableVideoRecommend", "botState", "getBotState", "setBotState", "onboardingCardType", "getOnboardingCardType", "setOnboardingCardType", "skillCardCnt", "getSkillCardCnt", "setSkillCardCnt", "showFrom", "getShowFrom", "setShowFrom", "originMessageId", "getOriginMessageId", "setOriginMessageId", "secScene", "getSecScene", "setSecScene", "actionBarKey", "getActionBarKey", "setActionBarKey", "actionBarCommandId", "getActionBarCommandId", "setActionBarCommandId", "actionBarInstructionType", "getActionBarInstructionType", "setActionBarInstructionType", DyPayConstant.KEY_SHOW_LOADING, "getShowLoading", "recordCardMsgId", "getRecordCardMsgId", "setRecordCardMsgId", "innerLogId", "getInnerLogId", "setInnerLogId", "clientReportScene", "getClientReportScene", "setClientReportScene", "isCollected", "fpaCommonParam", "getFpaCommonParam", "setFpaCommonParam", "reqId", "getReqId", "setReqId", "msgSourceType", "getMsgSourceType", "msgCandidateSourceType", "getMsgCandidateSourceType", "msgGid", "getMsgGid", "notifyTaskId", "getNotifyTaskId", "videoSource", "getVideoSource", "setVideoSource", "isVideoVLM", "supportPodcastGenerate", "getSupportPodcastGenerate", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMMsgExt extends HashMap<String, String> {
    public static final a Companion = null;
    public static final long ERROR_NEED_LOGIN_DOUBAO = 710022023;
    public static final long ERROR_TOURIST_REACH_CREATE_BOT_LIMIT = 710022015;
    public static final long ERROR_TOURIST_REACH_MESSAGE_LIMIT = 710022013;
    public static final long ERR_BOT_BAN = 710022010;
    public static final long ERR_BOT_DELETE = 710022005;
    public static final long ERR_BOT_PRIVATE = 710022016;
    public static final long ERR_BOT_REVIEWING = 710022011;
    public static final long ERR_HIGH_RISK_PROMPT = 710022008;
    public static final long ERR_LIMIT = 710022004;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getActionBarCommandId() {
        String r100 = (String) get("action_bar_command_id");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final int getActionBarInstructionType() {
        String r100 = (String) get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
        if (r100 != null) goto L17;
        r100 = "";
    L17:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(Integer.valueOf(JSONObjectProtectorUtils.getInt(new JSONObject(r100), "instruction_type")));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L12;
        r102 = null;
    L12:
        Integer r103 = (Integer) r102;
        if (r103 != null) goto L19;
        return 0;
    L19:
        return r103.intValue();
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final String getActionBarKey() {
        String r100 = (String) get("action_bar_key");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final boolean getActionBarProactiveBotMessage() {
        return Intrinsics.areEqual(get("action_bar_proactive_bot_msg"), "1");
    }

    public final int getAnswerWithSuggest() {
        String r100 = (String) get("answer_with_suggest");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final String getApiId() {
        String r100 = (String) get("api_id");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final int getBigProfile() {
        String r100 = (String) get("onboarding_big_profile");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final String getBotState() {
        String r100 = (String) get("bot_state");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getBrief() {
        String r100 = (String) get(SelectInfo.BRIEF);
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getCallAsrId() {
        return (String) get("call_asr_id");
    }

    public final String getClientReportScene() {
        String r100 = (String) get("client_report_scene");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getCollectionId() {
        String r100 = (String) get("collection_id");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getCrowdTestButtonList() {
        String r100 = (String) get("crowd_test_button_list");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getCrowdTestMessageIndex() {
        String r100 = (String) get("crowd_test_msg_index");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getCrowdTestSubTitle() {
        String r100 = (String) get("crowd_test_subtitle");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getCrowdTestTitle() {
        String r100 = (String) get("crowd_test_title");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final boolean getDelete() {
        return Intrinsics.areEqual(get("delete"), "1");
    }

    public final boolean getDisableActionView() {
        if (Intrinsics.areEqual(get("disable_action_view"), "true") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(get("disable_action_view"), "1") == true) goto L8;
        return false;
    }

    public final boolean getDisableTypeWriter() {
        return Intrinsics.areEqual(get("disable_type_writer"), "true");
    }

    public final String getEduExtForTts() {
        String r100 = (String) get("edu_ext_for_tts");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final boolean getEnableVideoRecommend() {
        return Intrinsics.areEqual(get("enable_video_recommend"), "1");
    }

    public final String getEnterChatMethod() {
        String r100 = (String) get("douyin_traffic_source");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final long getErrCode() {
        String r100 = (String) get("has_err");
        if (r100 == null) goto L7;
        Long r101 = StringsKt.toLongOrNull(r100);
        if (r101 == null) goto L7;
        return r101.longValue();
    L7:
        return 0;
    }

    public final String getErrMsg() {
        String r100 = (String) get(LocationMonitorConst.ERR_MSG);
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final boolean getFeelyEmojiImgMessage() {
        return Intrinsics.areEqual(get("is_feely_emojis_img"), "true");
    }

    public final boolean getFeelyImgMessage() {
        return Intrinsics.areEqual(get("is_feely_img"), "true");
    }

    public final String getFpaCommonParam() {
        return (String) get("fpa_common_param");
    }

    public final String getFromAsr() {
        return (String) get("from_asr");
    }

    public final int getFromPush() {
        String r100 = (String) get("from_push");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final boolean getHasSuggest() {
        return Intrinsics.areEqual(get("has_suggest"), "1");
    }

    public final String getInnerLogId() {
        String r100 = (String) get("inner_log_id");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getItemId() {
        String r100 = (String) get("item_id");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getLastRegenerateSelectedMessageId() {
        String r100 = (String) get("lastRegenerateSelectedMessageId");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final long getLimitTime() {
        String r100 = (String) get("limit_time");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L9:
        return ((long) r102) * 1000;
    L7:
        r102 = 0;
        goto L9
    }

    public final String getLimitTips() {
        String r100 = (String) get("limit_tips");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getLlmFakePrompt() {
        String r100 = (String) get("llm_fake_prompt");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getLlmFakeResponse() {
        String r100 = (String) get("llm_fake_response");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getLocalCallId() {
        return (String) get("local_call_id");
    }

    public final boolean getLocalSubCoCoMsg() {
        return Intrinsics.areEqual(get("local_sub_coco_conv"), "true");
    }

    public final int getMediaSearchType() {
        String r100 = (String) get("media_search_type");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final int getModelType() {
        String r100 = (String) get(AdDownloadModel.JsonKey.MODEL_TYPE);
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final String getMsgCandidateSourceType() {
        return (String) get("msg_candidate_source");
    }

    public final String getMsgGid() {
        return (String) get("msg_group_id");
    }

    public final String getMsgSourceType() {
        return (String) get("msg_source_type");
    }

    public final int getMultiBots() {
        String r100 = (String) get("multi_bots");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final boolean getNeedLocation() {
        return Intrinsics.areEqual(get(ChatListComponentViewModel.LOCATION_TAG), "1");
    }

    public final String getNextPulseRespData() {
        String r100 = (String) get("next_pulse_resp_data");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final Integer getNextPulseType() {
        String r100 = (String) get("next_pulse_type");
        if (r100 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r100);
    }

    public final String getNotifyTaskId() {
        return (String) get("notify_task_id");
    }

    public final int getOnBoarding() {
        String r100 = (String) get("onboarding");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final String getOnBoardingContentSource() {
        String r100 = (String) get("onboarding_content_source");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final int getOnBoardingV2() {
        String r100 = (String) get("onboarding_v2");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final String getOnboardingCardID() {
        String r100 = (String) get("onboarding_card_id");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getOnboardingCardType() {
        String r100 = (String) get("onboarding_card_skill_type");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getOnboardingDisplayStyle() {
        String r100 = (String) get("onboarding_display_style");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getOnboardingSug() {
        String r100 = (String) get("onboarding_sug");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final long getOnboardingSugExpirationTime() {
        String r100 = (String) get("onboarding_sug_expiration_time");
        if (r100 == null) goto L7;
        Long r101 = StringsKt.toLongOrNull(r100);
        if (r101 == null) goto L7;
        return r101.longValue();
    L7:
        return 0;
    }

    public final int getOnboardingSugType() {
        String r100 = (String) get("onboarding_sug_type");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final String getOriginMessageId() {
        String r100 = (String) get(ConversationConstants.KEY_ORIGIN_MESSAGE_ID);
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getPluginAuthInfo() {
        return (String) get("plugin_auth_info");
    }

    public final String getPluginPayload() {
        String r100 = (String) get("plugin_payload");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final boolean getProactiveBotMessage() {
        return Intrinsics.areEqual(get("proactive_bot_msg"), "1");
    }

    public final boolean getQueueTtsMessage() {
        return Intrinsics.areEqual(get("tts_queue"), "true");
    }

    public final String getRecordCardMsgId() {
        String r100 = (String) get("record_card_msg_id");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final boolean getRegen() {
        return Intrinsics.areEqual(get("regen"), "1");
    }

    public final boolean getRegenActive() {
        return Intrinsics.areEqual(get("regen_active"), "1");
    }

    public final boolean getReplace() {
        return Intrinsics.areEqual(get("replace"), "1");
    }

    public final String getReqId() {
        return (String) get("req_id");
    }

    public final String getSWikiLink() {
        String r100 = (String) get("s$wiki_link");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final int getSearchEngineType() {
        String r100 = (String) get("search_engine_type");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final int getSearchIntend() {
        String r100 = (String) get("search_intend");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final String getSearchUrl() {
        String r100 = (String) get("search_url");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final boolean getSearchView() {
        return Intrinsics.areEqual(get("search_view"), "1");
    }

    public final String getSecScene() {
        String r100 = (String) get("sec_scene");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final boolean getServerLoadingNotInterruptTts() {
        return Intrinsics.areEqual(get("server_loading_not_interrupt_tts"), "1");
    }

    public final String getShowFrom() {
        String r100 = (String) get("show_from");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final boolean getShowLoading() {
        return Intrinsics.areEqual(get("show_loading"), "1");
    }

    public final int getSkillCardCnt() {
        String r100 = (String) get("skill_card_cnt");
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.intValue();
    }

    public final String getSource() {
        String r100 = (String) get("source");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getSourceMessageId() {
        String r100 = (String) get("source_message_id");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final boolean getStream() {
        return Intrinsics.areEqual(get("stream"), "1");
    }

    public final int getStreamIndex() {
        String r100 = (String) get("stream_idx");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final long getStreamTimeout() {
        String r100 = (String) get("blanking_timeout");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L9:
        return ((long) (r102 + 2)) * 1000;
    L7:
        r102 = 60;
        goto L9
    }

    public final int getSuggestActionCardCnt() {
        String r100 = (String) get("skill_card_cnt");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final String getSuggestItems() {
        String r100 = (String) get("suggest_items");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getSuggestItemsV2() {
        String r100 = (String) get("suggest_items_v2");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getSuggestPrompt() {
        String r100 = (String) get(CloudControlInf.SP);
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getSuggestV2Prompt() {
        String r100 = (String) get("sp_v2");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final boolean getSupportPodcastGenerate() {
        return Intrinsics.areEqual(get("support_podcast_generate"), "1");
    }

    public final String getTemplateData() {
        return (String) get("template_data");
    }

    public final Long getTemplateId() {
        String r100 = (String) get("msg_template_id");
        if (r100 != null) goto L7;
        return null;
    L7:
        return StringsKt.toLongOrNull(r100);
    }

    public final long getTimeout() {
        String r100 = (String) get("timeout");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L9:
        return ((long) r102) * 1000;
    L7:
        r102 = 180;
        goto L9
    }

    public final boolean getTts() {
        return Intrinsics.areEqual(get("tts"), "1");
    }

    public final String getTtsStr() {
        String r100 = get("tts");
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return r100;
    }

    public final boolean getUpdateLocation() {
        return Intrinsics.areEqual(get("update_location"), "1");
    }

    public final String getVideoSource() {
        return (String) get("video_source");
    }

    public final String getWcbTitle() {
        String r100 = (String) get("wcb_title");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final int getWcbTitleStyle() {
        String r100 = (String) get("wcb_title_style");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final String getWiki() {
        String r100 = (String) get("wiki");
        if (r100 != null) goto L6;
        return "0";
    L6:
        return r100;
    }

    public final boolean isClearContextMessage() {
        return Intrinsics.areEqual(get("clear_context"), "1");
    }

    public final boolean isClickClearContext() {
        return Intrinsics.areEqual(get("click_clear_context"), "true");
    }

    public final boolean isCollected() {
        if (Intrinsics.areEqual(get("collection_status"), "1") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(get("collection_status"), "3") == true) goto L8;
        return false;
    }

    public final int isConnectCallerName() {
        String r100 = (String) get("is_connect_caller_name");
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final boolean isCrowdTest() {
        return Intrinsics.areEqual(get("is_crowd_testing"), "1");
    }

    public final boolean isDeepThinkingPro() {
        return Intrinsics.areEqual(get("is_pro"), "1");
    }

    public final boolean isFinish() {
        return Intrinsics.areEqual(get(EventConstant.Key.IS_FINISH), "1");
    }

    public final String isFromCache() {
        String r100 = (String) get("is_from_cache");
        if (r100 != null) goto L6;
        return "0";
    L6:
        return r100;
    }

    public final boolean isNoDisappear() {
        return Intrinsics.areEqual(get("no_disappear"), "true");
    }

    public final boolean isVideoVLM() {
        if (Intrinsics.areEqual(get("llm_intention"), "vlm") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(get("llm_intention_detail"), "video") == false) goto L7;
        return true;
    }

    public final boolean isWelcomeBackMessageHidden() {
        return Intrinsics.areEqual(get("wcb_message_hidden"), "true");
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<String> getValues() {
        return super.values();
    }

    public final boolean isErr() {
        if (getErrCode() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<String> values() {
        return getValues();
    }

    public IMMsgExt() {
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsValue((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    public final void setActionBarCommandId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("action_bar_command_id", r100);
    }

    public final void setActionBarInstructionType(int r100) {
        String r101 = (String) get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r103 = new JSONObject(r101);     // Catch: Throwable -> L7
        r103.put("instruction_type", r100);     // Catch: Throwable -> L7
        Result.m9449constructorimpl(put(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION, r103.toString()));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void setActionBarKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("action_bar_key", r100);
    }

    public final void setAnswerWithSuggest(int r100) {
        put("answer_with_suggest", String.valueOf(r100));
    }

    public final void setApiId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("api_id", r100);
    }

    public final void setBigProfile(int r100) {
        put("onboarding_big_profile", String.valueOf(r100));
    }

    public final void setBotState(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("bot_state", r100);
    }

    public final void setBrief(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put(SelectInfo.BRIEF, r100);
    }

    public final void setCallAsrId(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        put("call_asr_id", r100);
    }

    public final void setClientReportScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("client_report_scene", r100);
    }

    public final void setCollectionId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("collection_id", r100);
    }

    public final void setConnectCallerName(int r100) {
        put("is_connect_caller_name", String.valueOf(r100));
    }

    public final void setDelete(boolean r100) {
        if (r100 == false) goto L5;
        put("delete", "1");
        return;
    }

    public final void setEduExtForTts(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("edu_ext_for_tts", r100);
    }

    public final void setEnableVideoRecommend(boolean r100) {
        put("enable_video_recommend", String.valueOf(r100));
    }

    public final void setEnterChatMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("douyin_traffic_source", r100);
    }

    public final void setErrCode(long r100) {
        put("has_err", String.valueOf(r100));
    }

    public final void setErrMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put(LocationMonitorConst.ERR_MSG, r100);
    }

    public final void setFinish(boolean r100) {
        if (r100 == false) goto L5;
        put(EventConstant.Key.IS_FINISH, "1");
        return;
    }

    public final void setFpaCommonParam(String r100) {
        if (r100 != null) goto L5;
        String r101 = (String) remove("fpa_common_param");
        return;
    L5:
        String r102 = put("fpa_common_param", r100);
    }

    public final void setFromAsr(String r100) {
        put("from_asr", String.valueOf(r100));
    }

    public final void setFromCache(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("is_from_cache", r100);
    }

    public final void setFromPush(int r100) {
        put("from_push", String.valueOf(r100));
    }

    public final void setHasSuggest(boolean r100) {
        if (r100 == false) goto L5;
        put("has_suggest", "1");
        return;
    }

    public final void setInnerLogId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("inner_log_id", r100);
    }

    public final void setItemId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("item_id", r100);
    }

    public final void setLastRegenerateSelectedMessageId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("lastRegenerateSelectedMessageId", r100);
    }

    public final void setLlmFakePrompt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("llm_fake_prompt", r100);
    }

    public final void setLlmFakeResponse(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("llm_fake_response", r100);
    }

    public final void setLocalCallId(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        put("local_call_id", r100);
    }

    public final void setLocalSubCoCoMsg(boolean r100) {
        put("local_sub_coco_conv", String.valueOf(r100));
    }

    public final void setMediaSearchType(int r100) {
        put("media_search_type", String.valueOf(r100));
    }

    public final void setModelType(int r100) {
        put(AdDownloadModel.JsonKey.MODEL_TYPE, String.valueOf(r100));
    }

    public final void setMultiBots(int r100) {
        put("multi_bots", String.valueOf(r100));
    }

    public final void setNeedLocation(boolean r100) {
        if (r100 == false) goto L5;
        Object r101 = put(ChatListComponentViewModel.LOCATION_TAG, "1");
    L6:
        String r102 = (String) r101;
        return;
    L5:
        r101 = remove(ChatListComponentViewModel.LOCATION_TAG);
        goto L6
    }

    public final void setOnBoarding(int r100) {
        put("onboarding", String.valueOf(r100));
    }

    public final void setOnBoardingContentSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("onboarding_content_source", r100);
    }

    public final void setOnBoardingV2(int r100) {
        put("onboarding_v2", String.valueOf(r100));
    }

    public final void setOnboardingCardID(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("onboarding_card_id", r100);
    }

    public final void setOnboardingCardType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("onboarding_card_skill_type", r100);
    }

    public final void setOriginMessageId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put(ConversationConstants.KEY_ORIGIN_MESSAGE_ID, r100);
    }

    public final void setPluginAuthInfo(String r100) {
        if (r100 == null) goto L5;
        String r101 = put("plugin_auth_info", r100);
        return;
    L5:
        String r102 = (String) remove("plugin_auth_info");
    }

    public final void setPluginPayload(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("plugin_payload", r100);
    }

    public final void setRecordCardMsgId(String r100) {
        if (r100 != null) goto L5;
        String r101 = (String) remove("record_card_msg_id");
        return;
    L5:
        String r102 = put("record_card_msg_id", r100);
    }

    public final void setRegen(boolean r100) {
        if (r100 == false) goto L5;
        put("regen", "1");
        return;
    }

    public final void setRegenActive(boolean r100) {
        if (r100 == false) goto L5;
        put("regen_active", "1");
        return;
    }

    public final void setReplace(boolean r100) {
        if (r100 == false) goto L5;
        put("replace", "1");
        return;
    }

    public final void setReqId(String r100) {
        if (r100 != null) goto L5;
        String r101 = (String) remove("req_id");
        return;
    L5:
        String r102 = put("req_id", r100);
    }

    public final void setSWikiLink(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("s$wiki_link", r100);
    }

    public final void setSearchEngineType(int r100) {
        put("search_engine_type", String.valueOf(r100));
    }

    public final void setSearchIntend(int r100) {
        put("search_intend", String.valueOf(r100));
    }

    public final void setSearchUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("search_url", r100);
    }

    public final void setSearchView(boolean r100) {
        if (r100 == false) goto L5;
        Object r101 = put("search_view", "1");
    L6:
        String r102 = (String) r101;
        return;
    L5:
        r101 = remove("search_view");
        goto L6
    }

    public final void setSecScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("sec_scene", r100);
    }

    public final void setShowFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("show_from", r100);
    }

    public final void setSkillCardCnt(int r100) {
        put("skill_card_cnt", String.valueOf(r100));
    }

    public final void setSource(String r100) {
        if (r100 != null) goto L5;
        String r101 = (String) remove("source");
        return;
    L5:
        String r102 = put("source", r100);
    }

    public final void setSourceMessageId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("source_message_id", r100);
    }

    public final void setStream(boolean r100) {
        if (r100 == false) goto L5;
        put("stream", "1");
        return;
    }

    public final void setTemplateData(String r100) {
        if (r100 != null) goto L5;
        String r101 = (String) remove("template_data");
        return;
    L5:
        String r102 = put("template_data", r100);
    }

    public final void setTemplateId(Long r100) {
        if (r100 != null) goto L5;
        String r101 = (String) remove("msg_template_id");
        return;
    L5:
        String r102 = put("msg_template_id", r100.toString());
    }

    public final void setTts(boolean r100) {
        if (r100 == false) goto L5;
        put("tts", "1");
        return;
    }

    public final void setTtsStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (Intrinsics.areEqual(r100, "0") == false) goto L5;
    L12:
        put("tts", r100);
        return;
    L5:
        if (Intrinsics.areEqual(r100, "1") == true) goto L12;
        FLogger.f375446a.e("IMMsgExt", "set tts param err! it = " + r100);
        if (AppHost.f326268a.isDebug() == true) goto L11;
        return;
    L11:
        throw new RuntimeException("tts must be 1 or 0!");
    }

    public final void setUpdateLocation(boolean r100) {
        if (r100 == false) goto L5;
        Object r101 = put("update_location", "1");
    L6:
        String r102 = (String) r101;
        return;
    L5:
        r101 = remove("update_location");
        goto L6
    }

    public final void setVideoSource(String r100) {
        if (r100 != null) goto L5;
        String r101 = (String) remove("video_source");
        return;
    L5:
        String r102 = put("video_source", r100);
    }

    public final void setWiki(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        put("wiki", r100);
    }

    public /* bridge */ boolean containsKey(String r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(String r100) {
        return super.containsValue(r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ String get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ String remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    public /* bridge */ String get(String r100) {
        return (String) super.get(r100);
    }

    public /* bridge */ String remove(String r100) {
        return (String) super.remove(r100);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, (String) r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r101 instanceof String) == true) goto L9;
        return false;
    L9:
        return remove((String) r100, (String) r101);
    }

    public final /* bridge */ String getOrDefault(Object r100, String r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, r101);
    }

    public /* bridge */ boolean remove(String r100, String r101) {
        return super.remove(r100, r101);
    }

    public /* bridge */ String getOrDefault(String r100, String r101) {
        return (String) super.getOrDefault(r100, r101);
    }
}
