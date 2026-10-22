package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.commodity.ECSearchUser;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import com.ss.android.ugc.aweme.feed.model.LogPbBean;
import com.ss.android.ugc.aweme.feed.model.search.SearchCommodityTagInfo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 ¾\u00022\u00020\u0001:\u0002¾\u0002B\t¢\u0006\u0006\b¼\u0002\u0010½\u0002J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0097\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0017R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR$\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\n\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\n\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\"\u00101\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\n\u001a\u0004\b8\u0010\f\"\u0004\b9\u0010\u000eR\"\u0010:\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010@\u001a\u00020&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010(\u001a\u0004\bA\u0010*\"\u0004\bB\u0010,R*\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u001e\u001a\u0004\bE\u0010 \"\u0004\bF\u0010\"R$\u0010H\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010N\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010\n\u001a\u0004\bO\u0010\f\"\u0004\bP\u0010\u000eR*\u0010R\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010\u001e\u001a\u0004\bS\u0010 \"\u0004\bT\u0010\"R$\u0010U\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\n\u001a\u0004\bV\u0010\f\"\u0004\bW\u0010\u000eR$\u0010Y\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R$\u0010_\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b_\u0010Z\u001a\u0004\b`\u0010\\\"\u0004\ba\u0010^R$\u0010b\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bb\u0010Z\u001a\u0004\bc\u0010\\\"\u0004\bd\u0010^R$\u0010e\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010Z\u001a\u0004\bf\u0010\\\"\u0004\bg\u0010^R$\u0010h\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bh\u0010Z\u001a\u0004\bi\u0010\\\"\u0004\bj\u0010^R$\u0010k\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010Z\u001a\u0004\bl\u0010\\\"\u0004\bm\u0010^R$\u0010n\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR*\u0010t\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bt\u0010\u001e\u001a\u0004\bu\u0010 \"\u0004\bv\u0010\"R$\u0010x\u001a\u0004\u0018\u00010w8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R)\u0010\u007f\u001a\u0004\u0018\u00010~8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R+\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R(\u0010\u008b\u0001\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008b\u0001\u0010Z\u001a\u0005\b\u008c\u0001\u0010\\\"\u0005\b\u008d\u0001\u0010^R,\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R,\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R,\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R,\u0010¤\u0001\u001a\u0005\u0018\u00010£\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R,\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R+\u0010±\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b±\u0001\u0010\u0086\u0001\u001a\u0006\b²\u0001\u0010\u0088\u0001\"\u0006\b³\u0001\u0010\u008a\u0001R,\u0010µ\u0001\u001a\u0005\u0018\u00010´\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R(\u0010»\u0001\u001a\u0004\u0018\u00010w8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b»\u0001\u0010y\u001a\u0005\b¼\u0001\u0010{\"\u0005\b½\u0001\u0010}R,\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R+\u0010Å\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÅ\u0001\u0010\u0086\u0001\u001a\u0006\bÆ\u0001\u0010\u0088\u0001\"\u0006\bÇ\u0001\u0010\u008a\u0001R&\u0010È\u0001\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÈ\u0001\u0010;\u001a\u0005\bÉ\u0001\u0010=\"\u0005\bÊ\u0001\u0010?R,\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÌ\u0001\u0010Í\u0001\u001a\u0006\bÎ\u0001\u0010Ï\u0001\"\u0006\bÐ\u0001\u0010Ñ\u0001R,\u0010Ó\u0001\u001a\u0005\u0018\u00010Ò\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÓ\u0001\u0010Ô\u0001\u001a\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R(\u0010Ù\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÙ\u0001\u0010\n\u001a\u0005\bÚ\u0001\u0010\f\"\u0005\bÛ\u0001\u0010\u000eR(\u0010Ü\u0001\u001a\u0004\u0018\u00010w8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÜ\u0001\u0010y\u001a\u0005\bÝ\u0001\u0010{\"\u0005\bÞ\u0001\u0010}R.\u0010ß\u0001\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bß\u0001\u0010\u001e\u001a\u0005\bà\u0001\u0010 \"\u0005\bá\u0001\u0010\"R.\u0010â\u0001\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bâ\u0001\u0010\u001e\u001a\u0005\bã\u0001\u0010 \"\u0005\bä\u0001\u0010\"R/\u0010æ\u0001\u001a\u000b\u0012\u0005\u0012\u00030å\u0001\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bæ\u0001\u0010\u001e\u001a\u0005\bç\u0001\u0010 \"\u0005\bè\u0001\u0010\"R,\u0010ê\u0001\u001a\u0005\u0018\u00010é\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bê\u0001\u0010ë\u0001\u001a\u0006\bì\u0001\u0010í\u0001\"\u0006\bî\u0001\u0010ï\u0001R,\u0010ñ\u0001\u001a\u0005\u0018\u00010ð\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bñ\u0001\u0010ò\u0001\u001a\u0006\bó\u0001\u0010ô\u0001\"\u0006\bõ\u0001\u0010ö\u0001R,\u0010ø\u0001\u001a\u0005\u0018\u00010÷\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bø\u0001\u0010ù\u0001\u001a\u0006\bú\u0001\u0010û\u0001\"\u0006\bü\u0001\u0010ý\u0001R,\u0010ÿ\u0001\u001a\u0005\u0018\u00010þ\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÿ\u0001\u0010\u0080\u0002\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002\"\u0006\b\u0083\u0002\u0010\u0084\u0002R8\u0010\u0086\u0002\u001a\u0011\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0085\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0086\u0002\u0010\u0087\u0002\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002\"\u0006\b\u008a\u0002\u0010\u008b\u0002R8\u0010\u008c\u0002\u001a\u0011\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0085\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008c\u0002\u0010\u0087\u0002\u001a\u0006\b\u008d\u0002\u0010\u0089\u0002\"\u0006\b\u008e\u0002\u0010\u008b\u0002R(\u0010\u008f\u0002\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008f\u0002\u0010\n\u001a\u0005\b\u0090\u0002\u0010\f\"\u0005\b\u0091\u0002\u0010\u000eR(\u0010\u0092\u0002\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0092\u0002\u0010\n\u001a\u0005\b\u0093\u0002\u0010\f\"\u0005\b\u0094\u0002\u0010\u000eR,\u0010\u0096\u0002\u001a\u0005\u0018\u00010\u0095\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0096\u0002\u0010\u0097\u0002\u001a\u0006\b\u0098\u0002\u0010\u0099\u0002\"\u0006\b\u009a\u0002\u0010\u009b\u0002R,\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009c\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u009d\u0002\u0010\u009e\u0002\u001a\u0006\b\u009f\u0002\u0010 \u0002\"\u0006\b¡\u0002\u0010¢\u0002R)\u0010£\u0002\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b£\u0002\u0010¤\u0002\u001a\u0006\b£\u0002\u0010¥\u0002\"\u0006\b¦\u0002\u0010§\u0002R,\u0010©\u0002\u001a\u0005\u0018\u00010¨\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b©\u0002\u0010ª\u0002\u001a\u0006\b«\u0002\u0010¬\u0002\"\u0006\b\u00ad\u0002\u0010®\u0002R,\u0010¶\u0002\u001a\u0005\u0018\u00010¯\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b°\u0002\u0010±\u0002\u001a\u0006\b²\u0002\u0010³\u0002\"\u0006\b´\u0002\u0010µ\u0002R(\u0010·\u0002\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b·\u0002\u0010\n\u001a\u0005\b¸\u0002\u0010\f\"\u0005\b¹\u0002\u0010\u000eR\u0014\u0010º\u0002\u001a\u00020\u00048G¢\u0006\b\u001a\u0006\bº\u0002\u0010¥\u0002R\u0014\u0010»\u0002\u001a\u00020\u00048G¢\u0006\b\u001a\u0006\b»\u0002\u0010¥\u0002¨\u0006¿\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/Commodity;", "Ljava/io/Serializable;", "", "o", "", "equals", "", "hashCode", "", "gid", "Ljava/lang/String;", "getGid", "()Ljava/lang/String;", "setGid", "(Ljava/lang/String;)V", "commodityId", "getCommodityId", "setCommodityId", "name", "getName", "setName", "needConfigUnifiedPadding", "Ljava/lang/Boolean;", "getNeedConfigUnifiedPadding", "()Ljava/lang/Boolean;", "setNeedConfigUnifiedPadding", "(Ljava/lang/Boolean;)V", "", "Lcom/ss/android/ugc/aweme/discover/model/Position;", "nameHighlightPositions", "Ljava/util/List;", "getNameHighlightPositions", "()Ljava/util/List;", "setNameHighlightPositions", "(Ljava/util/List;)V", "platformName", "getPlatformName", "setPlatformName", "", "price", "J", "getPrice", "()J", "setPrice", "(J)V", "image", "getImage", "setImage", "", "imageRatio", FaceService.girlLabel, "getImageRatio", "()F", "setImageRatio", "(F)V", "schema", "getSchema", "setSchema", "commodityType", "I", "getCommodityType", "()I", "setCommodityType", "(I)V", "schemaType", "getSchemaType", "setSchemaType", "Lcom/ss/android/ugc/aweme/feed/model/search/SearchCommodityTagInfo;", "tagInfos", "getTagInfos", "setTagInfos", "Lcom/ss/android/ugc/aweme/discover/model/MainImageTag;", "mainImageTag", "Lcom/ss/android/ugc/aweme/discover/model/MainImageTag;", "getMainImageTag", "()Lcom/ss/android/ugc/aweme/discover/model/MainImageTag;", "setMainImageTag", "(Lcom/ss/android/ugc/aweme/discover/model/MainImageTag;)V", "tagInfosJson", "getTagInfosJson", "setTagInfosJson", "Lcom/ss/android/ugc/aweme/discover/model/Coupon;", "coupons", "getCoupons", "setCoupons", "extraInfo", "getExtraInfo", "setExtraInfo", "Lcom/ss/android/ugc/aweme/discover/model/CommonText;", "strongPrice", "Lcom/ss/android/ugc/aweme/discover/model/CommonText;", "getStrongPrice", "()Lcom/ss/android/ugc/aweme/discover/model/CommonText;", "setStrongPrice", "(Lcom/ss/android/ugc/aweme/discover/model/CommonText;)V", "strongPricePrefix", "getStrongPricePrefix", "setStrongPricePrefix", "strongPriceSuffix", "getStrongPriceSuffix", "setStrongPriceSuffix", "weakPrice", "getWeakPrice", "setWeakPrice", "weakPriceSuffix", "getWeakPriceSuffix", "setWeakPriceSuffix", SalesInfoStruct.SALES, "getSales", "setSales", "recommendPrice", "Lcom/ss/android/ugc/aweme/discover/model/Coupon;", "getRecommendPrice", "()Lcom/ss/android/ugc/aweme/discover/model/Coupon;", "setRecommendPrice", "(Lcom/ss/android/ugc/aweme/discover/model/Coupon;)V", "rights", "getRights", "setRights", "Lcom/ss/android/ugc/aweme/discover/model/ProductRecommendInfo;", "recommendInfo", "Lcom/ss/android/ugc/aweme/discover/model/ProductRecommendInfo;", "getRecommendInfo", "()Lcom/ss/android/ugc/aweme/discover/model/ProductRecommendInfo;", "setRecommendInfo", "(Lcom/ss/android/ugc/aweme/discover/model/ProductRecommendInfo;)V", "Lcom/ss/android/ugc/aweme/discover/model/MarketRecommendInfo;", "marketInfo", "Lcom/ss/android/ugc/aweme/discover/model/MarketRecommendInfo;", "getMarketInfo", "()Lcom/ss/android/ugc/aweme/discover/model/MarketRecommendInfo;", "setMarketInfo", "(Lcom/ss/android/ugc/aweme/discover/model/MarketRecommendInfo;)V", "titleLines", "Ljava/lang/Integer;", "getTitleLines", "()Ljava/lang/Integer;", "setTitleLines", "(Ljava/lang/Integer;)V", "textPrice", "getTextPrice", "setTextPrice", "Lcom/ss/android/ugc/aweme/discover/model/VideoPlayInfo;", "videoPlayInfo", "Lcom/ss/android/ugc/aweme/discover/model/VideoPlayInfo;", "getVideoPlayInfo", "()Lcom/ss/android/ugc/aweme/discover/model/VideoPlayInfo;", "setVideoPlayInfo", "(Lcom/ss/android/ugc/aweme/discover/model/VideoPlayInfo;)V", "Lcom/ss/android/ugc/aweme/discover/model/ShoppingCart;", "shoppingCart", "Lcom/ss/android/ugc/aweme/discover/model/ShoppingCart;", "getShoppingCart", "()Lcom/ss/android/ugc/aweme/discover/model/ShoppingCart;", "setShoppingCart", "(Lcom/ss/android/ugc/aweme/discover/model/ShoppingCart;)V", "Lcom/ss/android/ugc/aweme/discover/model/PriceCouponInfo;", "priceDiscountInfo", "Lcom/ss/android/ugc/aweme/discover/model/PriceCouponInfo;", "getPriceDiscountInfo", "()Lcom/ss/android/ugc/aweme/discover/model/PriceCouponInfo;", "setPriceDiscountInfo", "(Lcom/ss/android/ugc/aweme/discover/model/PriceCouponInfo;)V", "Lcom/ss/android/ugc/aweme/discover/model/PriceCouponBgInfo;", "priceBackgroundImage", "Lcom/ss/android/ugc/aweme/discover/model/PriceCouponBgInfo;", "getPriceBackgroundImage", "()Lcom/ss/android/ugc/aweme/discover/model/PriceCouponBgInfo;", "setPriceBackgroundImage", "(Lcom/ss/android/ugc/aweme/discover/model/PriceCouponBgInfo;)V", "Lcom/ss/android/ugc/aweme/discover/model/PriceStrengthenInfo;", "priceStrengthInfo", "Lcom/ss/android/ugc/aweme/discover/model/PriceStrengthenInfo;", "getPriceStrengthInfo", "()Lcom/ss/android/ugc/aweme/discover/model/PriceStrengthenInfo;", "setPriceStrengthInfo", "(Lcom/ss/android/ugc/aweme/discover/model/PriceStrengthenInfo;)V", "singlePriceAreaType", "getSinglePriceAreaType", "setSinglePriceAreaType", "Lcom/ss/android/ugc/aweme/discover/model/FreeChargeInfoStruct;", "freeChargeInfo", "Lcom/ss/android/ugc/aweme/discover/model/FreeChargeInfoStruct;", "getFreeChargeInfo", "()Lcom/ss/android/ugc/aweme/discover/model/FreeChargeInfoStruct;", "setFreeChargeInfo", "(Lcom/ss/android/ugc/aweme/discover/model/FreeChargeInfoStruct;)V", "singleRecommendInfo", "getSingleRecommendInfo", "setSingleRecommendInfo", "Lcom/ss/android/ugc/aweme/discover/model/ShopInfo;", "singleShopInfo", "Lcom/ss/android/ugc/aweme/discover/model/ShopInfo;", "getSingleShopInfo", "()Lcom/ss/android/ugc/aweme/discover/model/ShopInfo;", "setSingleShopInfo", "(Lcom/ss/android/ugc/aweme/discover/model/ShopInfo;)V", "singleTitleLines", "getSingleTitleLines", "setSingleTitleLines", "priceStyle", "getPriceStyle", "setPriceStyle", "Lcom/ss/android/ugc/aweme/discover/model/PriceUpperAreaInfo;", "priceUpperAreaInfo", "Lcom/ss/android/ugc/aweme/discover/model/PriceUpperAreaInfo;", "getPriceUpperAreaInfo", "()Lcom/ss/android/ugc/aweme/discover/model/PriceUpperAreaInfo;", "setPriceUpperAreaInfo", "(Lcom/ss/android/ugc/aweme/discover/model/PriceUpperAreaInfo;)V", "Lcom/ss/android/ugc/aweme/discover/model/PriceAreaInfo;", "priceAreaInfo", "Lcom/ss/android/ugc/aweme/discover/model/PriceAreaInfo;", "getPriceAreaInfo", "()Lcom/ss/android/ugc/aweme/discover/model/PriceAreaInfo;", "setPriceAreaInfo", "(Lcom/ss/android/ugc/aweme/discover/model/PriceAreaInfo;)V", "productStateText", "getProductStateText", "setProductStateText", "singleCardRecommendInfo", "getSingleCardRecommendInfo", "setSingleCardRecommendInfo", "singleCardTagInfos", "getSingleCardTagInfos", "setSingleCardTagInfos", "singleCardRights", "getSingleCardRights", "setSingleCardRights", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "covers", "getCovers", "setCovers", "Lcom/ss/android/ugc/aweme/discover/model/CommodityAdLabel;", "adLabel", "Lcom/ss/android/ugc/aweme/discover/model/CommodityAdLabel;", "getAdLabel", "()Lcom/ss/android/ugc/aweme/discover/model/CommodityAdLabel;", "setAdLabel", "(Lcom/ss/android/ugc/aweme/discover/model/CommodityAdLabel;)V", "Lcom/ss/android/ugc/aweme/discover/model/MainPictureRegion;", "mainPictureRegion", "Lcom/ss/android/ugc/aweme/discover/model/MainPictureRegion;", "getMainPictureRegion", "()Lcom/ss/android/ugc/aweme/discover/model/MainPictureRegion;", "setMainPictureRegion", "(Lcom/ss/android/ugc/aweme/discover/model/MainPictureRegion;)V", "Lcom/ss/android/ugc/aweme/discover/model/CommoditySearchWordRegion;", "searchWordRegion", "Lcom/ss/android/ugc/aweme/discover/model/CommoditySearchWordRegion;", "getSearchWordRegion", "()Lcom/ss/android/ugc/aweme/discover/model/CommoditySearchWordRegion;", "setSearchWordRegion", "(Lcom/ss/android/ugc/aweme/discover/model/CommoditySearchWordRegion;)V", "Lcom/ss/android/ugc/aweme/discover/model/BiddingInformation;", "biddingInformation", "Lcom/ss/android/ugc/aweme/discover/model/BiddingInformation;", "getBiddingInformation", "()Lcom/ss/android/ugc/aweme/discover/model/BiddingInformation;", "setBiddingInformation", "(Lcom/ss/android/ugc/aweme/discover/model/BiddingInformation;)V", "", "extraInfoMap", "Ljava/util/Map;", "getExtraInfoMap", "()Ljava/util/Map;", "setExtraInfoMap", "(Ljava/util/Map;)V", "bcmParams", "getBcmParams", "setBcmParams", "shopId", "getShopId", "setShopId", "firstCategoryId", "getFirstCategoryId", "setFirstCategoryId", "Lcom/ss/android/ugc/aweme/discover/model/InformationBackgroundColor;", "informationBackgroundColor", "Lcom/ss/android/ugc/aweme/discover/model/InformationBackgroundColor;", "getInformationBackgroundColor", "()Lcom/ss/android/ugc/aweme/discover/model/InformationBackgroundColor;", "setInformationBackgroundColor", "(Lcom/ss/android/ugc/aweme/discover/model/InformationBackgroundColor;)V", "Lcom/ss/android/ugc/aweme/discover/model/CardBorder;", "cardBorder", "Lcom/ss/android/ugc/aweme/discover/model/CardBorder;", "getCardBorder", "()Lcom/ss/android/ugc/aweme/discover/model/CardBorder;", "setCardBorder", "(Lcom/ss/android/ugc/aweme/discover/model/CardBorder;)V", "isReportShow", "Z", "()Z", "setReportShow", "(Z)V", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "logPb", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "getLogPb", "()Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "setLogPb", "(Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;)V", "Lcom/ss/android/ugc/aweme/discover/model/commodity/ECSearchUser;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/ss/android/ugc/aweme/discover/model/commodity/ECSearchUser;", "getSearchUser", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/ECSearchUser;", "setSearchUser", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/ECSearchUser;)V", "searchUser", "skuId", "getSkuId", "setSkuId", "isMiniApp", "isPreview", "<init>", "()V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Commodity implements Serializable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 42;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient ECSearchUser f450482a;

    @SerializedName("ad_label")
    private CommodityAdLabel adLabel;

    @SerializedName("bcm_params")
    private Map<String, String> bcmParams;

    @SerializedName("bidding_information")
    private BiddingInformation biddingInformation;

    @SerializedName("card_border")
    private CardBorder cardBorder;

    @SerializedName("promotion_id")
    private String commodityId;

    @SerializedName(a.KEY_COMMODITY_TYPE)
    private int commodityType;

    @SerializedName(AnchorBenefitToast.TYPE_COUPON)
    private List<Coupon> coupons;

    @SerializedName("single_card_product_covers")
    private List<? extends UrlModel> covers;

    @SerializedName("extra_info")
    private String extraInfo;

    @SerializedName("extra_info_map")
    private Map<String, ? extends Object> extraInfoMap;

    @SerializedName("first_category_id")
    private String firstCategoryId;

    @SerializedName("free_charge_info")
    private FreeChargeInfoStruct freeChargeInfo;

    @SerializedName("gid")
    private String gid;

    @SerializedName("img")
    private String image;

    @SerializedName("image_ratio")
    private float imageRatio;

    @SerializedName("information_background_color")
    private InformationBackgroundColor informationBackgroundColor;
    private boolean isReportShow;
    private LogPbBean logPb;

    @SerializedName("main_image_tag")
    private MainImageTag mainImageTag;

    @SerializedName("main_picture_region")
    private MainPictureRegion mainPictureRegion;

    @SerializedName("market_info")
    private MarketRecommendInfo marketInfo;

    @SerializedName("name")
    private String name;

    @SerializedName("name_highlight_positions")
    private List<Position> nameHighlightPositions;

    @SerializedName("need_config_unified_padding")
    private Boolean needConfigUnifiedPadding;

    @SerializedName("platform_name")
    private String platformName;

    @SerializedName("show_price")
    private long price;

    @SerializedName("price_area_info")
    private PriceAreaInfo priceAreaInfo;

    @SerializedName("price_background")
    private PriceCouponBgInfo priceBackgroundImage;

    @SerializedName("price_discount_info")
    private PriceCouponInfo priceDiscountInfo;

    @SerializedName("price_strengthen_info")
    private PriceStrengthenInfo priceStrengthInfo;

    @SerializedName("price_style")
    private int priceStyle;

    @SerializedName("price_upper_area_info")
    private PriceUpperAreaInfo priceUpperAreaInfo;

    @SerializedName("product_state_text")
    private String productStateText;

    @SerializedName(a.KEY_RECOMMEND_INFO)
    private ProductRecommendInfo recommendInfo;

    @SerializedName("recommend_price_region")
    private Coupon recommendPrice;

    @SerializedName("rights")
    private List<Coupon> rights;

    @SerializedName(SalesInfoStruct.SALES)
    private CommonText sales;

    @SerializedName("schema")
    private String schema;

    @SerializedName("schema_type")
    private long schemaType;

    @SerializedName("search_word_region")
    private CommoditySearchWordRegion searchWordRegion;

    @SerializedName(a.KEY_SHOP_ID)
    private String shopId;

    @SerializedName("shopping_cart")
    private ShoppingCart shoppingCart;

    @SerializedName("single_card_recommend_info")
    private ProductRecommendInfo singleCardRecommendInfo;

    @SerializedName("single_card_rights")
    private List<Coupon> singleCardRights;

    @SerializedName("single_card_tag_infos")
    private List<SearchCommodityTagInfo> singleCardTagInfos;

    @SerializedName("single_price_area_type")
    private Integer singlePriceAreaType;

    @SerializedName("single_recommend_info")
    private ProductRecommendInfo singleRecommendInfo;

    @SerializedName("single_shop_info")
    private ShopInfo singleShopInfo;

    @SerializedName("single_title_lines")
    private Integer singleTitleLines;

    @SerializedName(a.KEY_SKU_ID)
    private String skuId;

    @SerializedName("strong_price")
    private CommonText strongPrice;

    @SerializedName("strong_price_prefix")
    private CommonText strongPricePrefix;

    @SerializedName("strong_price_suffix")
    private CommonText strongPriceSuffix;

    @SerializedName("tag_infos")
    private List<SearchCommodityTagInfo> tagInfos;
    private String tagInfosJson;

    @SerializedName("text_price")
    private CommonText textPrice;

    @SerializedName("title_lines")
    private Integer titleLines;

    @SerializedName(a.KEY_VIDEO_INFO)
    private VideoPlayInfo videoPlayInfo;

    @SerializedName("weak_price")
    private CommonText weakPrice;

    @SerializedName("weak_price_suffix")
    private CommonText weakPriceSuffix;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/Commodity$Companion;", "", "()V", "serialVersionUID", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    @AllowImpl
    public int hashCode() {
        String r100 = this.gid;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    @AllowImpl
    public final boolean isMiniApp() {
        if (this.schemaType != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @AllowImpl
    public final boolean isPreview() {
        if (this.schemaType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public Commodity() {
        this.gid = "";
        this.commodityId = "";
        this.name = "";
        this.needConfigUnifiedPadding = Boolean.FALSE;
        this.platformName = "";
        this.imageRatio = 1.0f;
        this.schema = "";
    }

    public final CommodityAdLabel getAdLabel() {
        return this.adLabel;
    }

    public final Map<String, String> getBcmParams() {
        return this.bcmParams;
    }

    public final BiddingInformation getBiddingInformation() {
        return this.biddingInformation;
    }

    public final CardBorder getCardBorder() {
        return this.cardBorder;
    }

    public final String getCommodityId() {
        return this.commodityId;
    }

    public final int getCommodityType() {
        return this.commodityType;
    }

    public final List<Coupon> getCoupons() {
        return this.coupons;
    }

    public final List<UrlModel> getCovers() {
        return this.covers;
    }

    public final String getExtraInfo() {
        return this.extraInfo;
    }

    public final Map<String, Object> getExtraInfoMap() {
        return this.extraInfoMap;
    }

    public final String getFirstCategoryId() {
        return this.firstCategoryId;
    }

    public final FreeChargeInfoStruct getFreeChargeInfo() {
        return this.freeChargeInfo;
    }

    public final String getGid() {
        return this.gid;
    }

    public final String getImage() {
        return this.image;
    }

    public final float getImageRatio() {
        return this.imageRatio;
    }

    public final InformationBackgroundColor getInformationBackgroundColor() {
        return this.informationBackgroundColor;
    }

    public final LogPbBean getLogPb() {
        return this.logPb;
    }

    public final MainImageTag getMainImageTag() {
        return this.mainImageTag;
    }

    public final MainPictureRegion getMainPictureRegion() {
        return this.mainPictureRegion;
    }

    public final MarketRecommendInfo getMarketInfo() {
        return this.marketInfo;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Position> getNameHighlightPositions() {
        return this.nameHighlightPositions;
    }

    public final Boolean getNeedConfigUnifiedPadding() {
        return this.needConfigUnifiedPadding;
    }

    public final String getPlatformName() {
        return this.platformName;
    }

    public final long getPrice() {
        return this.price;
    }

    public final PriceAreaInfo getPriceAreaInfo() {
        return this.priceAreaInfo;
    }

    public final PriceCouponBgInfo getPriceBackgroundImage() {
        return this.priceBackgroundImage;
    }

    public final PriceCouponInfo getPriceDiscountInfo() {
        return this.priceDiscountInfo;
    }

    public final PriceStrengthenInfo getPriceStrengthInfo() {
        return this.priceStrengthInfo;
    }

    public final int getPriceStyle() {
        return this.priceStyle;
    }

    public final PriceUpperAreaInfo getPriceUpperAreaInfo() {
        return this.priceUpperAreaInfo;
    }

    public final String getProductStateText() {
        return this.productStateText;
    }

    public final ProductRecommendInfo getRecommendInfo() {
        return this.recommendInfo;
    }

    public final Coupon getRecommendPrice() {
        return this.recommendPrice;
    }

    public final List<Coupon> getRights() {
        return this.rights;
    }

    public final CommonText getSales() {
        return this.sales;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final long getSchemaType() {
        return this.schemaType;
    }

    public final ECSearchUser getSearchUser() {
        return this.f450482a;
    }

    public final CommoditySearchWordRegion getSearchWordRegion() {
        return this.searchWordRegion;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }

    public final ProductRecommendInfo getSingleCardRecommendInfo() {
        return this.singleCardRecommendInfo;
    }

    public final List<Coupon> getSingleCardRights() {
        return this.singleCardRights;
    }

    public final List<SearchCommodityTagInfo> getSingleCardTagInfos() {
        return this.singleCardTagInfos;
    }

    public final Integer getSinglePriceAreaType() {
        return this.singlePriceAreaType;
    }

    public final ProductRecommendInfo getSingleRecommendInfo() {
        return this.singleRecommendInfo;
    }

    public final ShopInfo getSingleShopInfo() {
        return this.singleShopInfo;
    }

    public final Integer getSingleTitleLines() {
        return this.singleTitleLines;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final CommonText getStrongPrice() {
        return this.strongPrice;
    }

    public final CommonText getStrongPricePrefix() {
        return this.strongPricePrefix;
    }

    public final CommonText getStrongPriceSuffix() {
        return this.strongPriceSuffix;
    }

    public final List<SearchCommodityTagInfo> getTagInfos() {
        return this.tagInfos;
    }

    public final String getTagInfosJson() {
        return this.tagInfosJson;
    }

    public final CommonText getTextPrice() {
        return this.textPrice;
    }

    public final Integer getTitleLines() {
        return this.titleLines;
    }

    public final VideoPlayInfo getVideoPlayInfo() {
        return this.videoPlayInfo;
    }

    public final CommonText getWeakPrice() {
        return this.weakPrice;
    }

    public final CommonText getWeakPriceSuffix() {
        return this.weakPriceSuffix;
    }

    public final boolean isReportShow() {
        return this.isReportShow;
    }

    @AllowImpl
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Commodity) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.gid, ((Commodity) r100).gid);
    }

    public final void setAdLabel(CommodityAdLabel r100) {
        this.adLabel = r100;
    }

    public final void setBcmParams(Map<String, String> r100) {
        this.bcmParams = r100;
    }

    public final void setBiddingInformation(BiddingInformation r100) {
        this.biddingInformation = r100;
    }

    public final void setCardBorder(CardBorder r100) {
        this.cardBorder = r100;
    }

    public final void setCommodityId(String r100) {
        this.commodityId = r100;
    }

    public final void setCommodityType(int r100) {
        this.commodityType = r100;
    }

    public final void setCoupons(List<Coupon> r100) {
        this.coupons = r100;
    }

    public final void setCovers(List<? extends UrlModel> r100) {
        this.covers = r100;
    }

    public final void setExtraInfo(String r100) {
        this.extraInfo = r100;
    }

    public final void setExtraInfoMap(Map<String, ? extends Object> r100) {
        this.extraInfoMap = r100;
    }

    public final void setFirstCategoryId(String r100) {
        this.firstCategoryId = r100;
    }

    public final void setFreeChargeInfo(FreeChargeInfoStruct r100) {
        this.freeChargeInfo = r100;
    }

    public final void setGid(String r100) {
        this.gid = r100;
    }

    public final void setImage(String r100) {
        this.image = r100;
    }

    public final void setImageRatio(float r100) {
        this.imageRatio = r100;
    }

    public final void setInformationBackgroundColor(InformationBackgroundColor r100) {
        this.informationBackgroundColor = r100;
    }

    public final void setLogPb(LogPbBean r100) {
        this.logPb = r100;
    }

    public final void setMainImageTag(MainImageTag r100) {
        this.mainImageTag = r100;
    }

    public final void setMainPictureRegion(MainPictureRegion r100) {
        this.mainPictureRegion = r100;
    }

    public final void setMarketInfo(MarketRecommendInfo r100) {
        this.marketInfo = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setNameHighlightPositions(List<Position> r100) {
        this.nameHighlightPositions = r100;
    }

    public final void setNeedConfigUnifiedPadding(Boolean r100) {
        this.needConfigUnifiedPadding = r100;
    }

    public final void setPlatformName(String r100) {
        this.platformName = r100;
    }

    public final void setPrice(long r100) {
        this.price = r100;
    }

    public final void setPriceAreaInfo(PriceAreaInfo r100) {
        this.priceAreaInfo = r100;
    }

    public final void setPriceBackgroundImage(PriceCouponBgInfo r100) {
        this.priceBackgroundImage = r100;
    }

    public final void setPriceDiscountInfo(PriceCouponInfo r100) {
        this.priceDiscountInfo = r100;
    }

    public final void setPriceStrengthInfo(PriceStrengthenInfo r100) {
        this.priceStrengthInfo = r100;
    }

    public final void setPriceStyle(int r100) {
        this.priceStyle = r100;
    }

    public final void setPriceUpperAreaInfo(PriceUpperAreaInfo r100) {
        this.priceUpperAreaInfo = r100;
    }

    public final void setProductStateText(String r100) {
        this.productStateText = r100;
    }

    public final void setRecommendInfo(ProductRecommendInfo r100) {
        this.recommendInfo = r100;
    }

    public final void setRecommendPrice(Coupon r100) {
        this.recommendPrice = r100;
    }

    public final void setReportShow(boolean r100) {
        this.isReportShow = r100;
    }

    public final void setRights(List<Coupon> r100) {
        this.rights = r100;
    }

    public final void setSales(CommonText r100) {
        this.sales = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setSchemaType(long r100) {
        this.schemaType = r100;
    }

    public final void setSearchUser(ECSearchUser r100) {
        this.f450482a = r100;
    }

    public final void setSearchWordRegion(CommoditySearchWordRegion r100) {
        this.searchWordRegion = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setShoppingCart(ShoppingCart r100) {
        this.shoppingCart = r100;
    }

    public final void setSingleCardRecommendInfo(ProductRecommendInfo r100) {
        this.singleCardRecommendInfo = r100;
    }

    public final void setSingleCardRights(List<Coupon> r100) {
        this.singleCardRights = r100;
    }

    public final void setSingleCardTagInfos(List<SearchCommodityTagInfo> r100) {
        this.singleCardTagInfos = r100;
    }

    public final void setSinglePriceAreaType(Integer r100) {
        this.singlePriceAreaType = r100;
    }

    public final void setSingleRecommendInfo(ProductRecommendInfo r100) {
        this.singleRecommendInfo = r100;
    }

    public final void setSingleShopInfo(ShopInfo r100) {
        this.singleShopInfo = r100;
    }

    public final void setSingleTitleLines(Integer r100) {
        this.singleTitleLines = r100;
    }

    public final void setSkuId(String r100) {
        this.skuId = r100;
    }

    public final void setStrongPrice(CommonText r100) {
        this.strongPrice = r100;
    }

    public final void setStrongPricePrefix(CommonText r100) {
        this.strongPricePrefix = r100;
    }

    public final void setStrongPriceSuffix(CommonText r100) {
        this.strongPriceSuffix = r100;
    }

    public final void setTagInfos(List<SearchCommodityTagInfo> r100) {
        this.tagInfos = r100;
    }

    public final void setTagInfosJson(String r100) {
        this.tagInfosJson = r100;
    }

    public final void setTextPrice(CommonText r100) {
        this.textPrice = r100;
    }

    public final void setTitleLines(Integer r100) {
        this.titleLines = r100;
    }

    public final void setVideoPlayInfo(VideoPlayInfo r100) {
        this.videoPlayInfo = r100;
    }

    public final void setWeakPrice(CommonText r100) {
        this.weakPrice = r100;
    }

    public final void setWeakPriceSuffix(CommonText r100) {
        this.weakPriceSuffix = r100;
    }
}
