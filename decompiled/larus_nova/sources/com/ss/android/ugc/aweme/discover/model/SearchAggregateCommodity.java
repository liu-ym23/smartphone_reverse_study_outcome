package com.ss.android.ugc.aweme.discover.model;

import android.view.View;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.commodity.ECSearchUser;
import com.ss.android.ugc.aweme.discover.model.commodity.aladdin.AladdinInfo;
import com.ss.android.ugc.aweme.discover.model.commodity.coupon.CouponIndustry;
import com.ss.android.ugc.aweme.discover.model.commodity.coupon.CouponInfo;
import com.ss.android.ugc.aweme.discover.model.commodity.select.CardTitle;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
import com.ss.android.ugc.aweme.discover.model.commodity.select.UpdateSelect;
import com.ss.android.ugc.aweme.discover.model.suggest.RecommendWordMob;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.AwemeRawAd;
import com.ss.android.ugc.aweme.feed.model.LogPbBean;
import com.ss.android.ugc.aweme.search.dynamic.base.model.DynamicCardData;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000Ö\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0093\u00032\u00020\u00012\u00020\u0002:\u0002\u0093\u0003B\t¢\u0006\u0006\b\u0091\u0003\u0010\u0092\u0003J\b\u0010\u0003\u001a\u00020\u0000H\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010\u0011R$\u0010)\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R$\u0010,\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R$\u0010/\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010=\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bD\u0010F\"\u0004\bG\u0010HR$\u0010I\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010E\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010HR$\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010[\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R*\u0010c\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010j\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010q\u001a\u0004\u0018\u00010p8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR$\u0010x\u001a\u0004\u0018\u00010w8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R)\u0010\u007f\u001a\u0004\u0018\u00010~8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R,\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R(\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u00100\u001a\u0005\b\u008d\u0001\u00102\"\u0005\b\u008e\u0001\u00104R,\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R,\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R(\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009d\u0001\u0010\u0014\u001a\u0005\b\u009e\u0001\u0010\u0016\"\u0005\b\u009f\u0001\u0010\u0018R)\u0010 \u0001\u001a\u00020C8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b \u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R9\u0010§\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0005\u0012\u00030¦\u0001\u0018\u00010¥\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R&\u0010\u00ad\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u00ad\u0001\u0010\r\u001a\u0005\b®\u0001\u0010\u000f\"\u0005\b¯\u0001\u0010\u0011R/\u0010±\u0001\u001a\u000b\u0012\u0005\u0012\u00030°\u0001\u0018\u00010a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b±\u0001\u0010d\u001a\u0005\b²\u0001\u0010f\"\u0005\b³\u0001\u0010hR,\u0010µ\u0001\u001a\u0005\u0018\u00010´\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R,\u0010¼\u0001\u001a\u0005\u0018\u00010»\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R,\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001R)\u0010É\u0001\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÉ\u0001\u0010¡\u0001\u001a\u0006\bÉ\u0001\u0010¢\u0001\"\u0006\bÊ\u0001\u0010¤\u0001R)\u0010Ë\u0001\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bË\u0001\u0010¡\u0001\u001a\u0006\bÌ\u0001\u0010¢\u0001\"\u0006\bÍ\u0001\u0010¤\u0001R9\u0010Î\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0005\u0012\u00030¦\u0001\u0018\u00010¥\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÎ\u0001\u0010¨\u0001\u001a\u0006\bÏ\u0001\u0010ª\u0001\"\u0006\bÐ\u0001\u0010¬\u0001R)\u0010Ñ\u0001\u001a\u00020C8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÑ\u0001\u0010¡\u0001\u001a\u0006\bÑ\u0001\u0010¢\u0001\"\u0006\bÒ\u0001\u0010¤\u0001R,\u0010Ô\u0001\u001a\u0005\u0018\u00010Ó\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R&\u0010Ú\u0001\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÚ\u0001\u0010\u0014\u001a\u0005\bÛ\u0001\u0010\u0016\"\u0005\bÜ\u0001\u0010\u0018R&\u0010Ý\u0001\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÝ\u0001\u0010\u0014\u001a\u0005\bÞ\u0001\u0010\u0016\"\u0005\bß\u0001\u0010\u0018R.\u0010à\u0001\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bà\u0001\u0010d\u001a\u0005\bá\u0001\u0010f\"\u0005\bâ\u0001\u0010hR(\u0010ã\u0001\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bã\u0001\u0010\u0014\u001a\u0005\bä\u0001\u0010\u0016\"\u0005\bå\u0001\u0010\u0018R/\u0010ç\u0001\u001a\u000b\u0012\u0005\u0012\u00030æ\u0001\u0018\u00010a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bç\u0001\u0010d\u001a\u0005\bè\u0001\u0010f\"\u0005\bé\u0001\u0010hR/\u0010ë\u0001\u001a\u000b\u0012\u0005\u0012\u00030ê\u0001\u0018\u00010a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bë\u0001\u0010d\u001a\u0005\bì\u0001\u0010f\"\u0005\bí\u0001\u0010hR(\u0010î\u0001\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bî\u0001\u0010\u0014\u001a\u0005\bï\u0001\u0010\u0016\"\u0005\bð\u0001\u0010\u0018R(\u0010ñ\u0001\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bñ\u0001\u0010\u0014\u001a\u0005\bò\u0001\u0010\u0016\"\u0005\bó\u0001\u0010\u0018R(\u0010ô\u0001\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bô\u0001\u0010\u0014\u001a\u0005\bõ\u0001\u0010\u0016\"\u0005\bö\u0001\u0010\u0018R(\u0010÷\u0001\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b÷\u0001\u0010\u0014\u001a\u0005\bø\u0001\u0010\u0016\"\u0005\bù\u0001\u0010\u0018R(\u0010ú\u0001\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bú\u0001\u0010\u0014\u001a\u0005\bû\u0001\u0010\u0016\"\u0005\bü\u0001\u0010\u0018R(\u0010ý\u0001\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bý\u0001\u0010E\u001a\u0005\bý\u0001\u0010F\"\u0005\bþ\u0001\u0010HR,\u0010\u0080\u0002\u001a\u0005\u0018\u00010ÿ\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R,\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0086\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002\"\u0006\b\u008b\u0002\u0010\u008c\u0002R,\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008d\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008e\u0002\u0010\u008f\u0002\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002\"\u0006\b\u0092\u0002\u0010\u0093\u0002R,\u0010\u0095\u0002\u001a\u0005\u0018\u00010\u0094\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0002\u0010\u0096\u0002\u001a\u0006\b\u0097\u0002\u0010\u0098\u0002\"\u0006\b\u0099\u0002\u0010\u009a\u0002R,\u0010\u009c\u0002\u001a\u0005\u0018\u00010\u009b\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u009c\u0002\u0010\u009d\u0002\u001a\u0006\b\u009e\u0002\u0010\u009f\u0002\"\u0006\b \u0002\u0010¡\u0002R(\u0010¢\u0002\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¢\u0002\u00100\u001a\u0005\b£\u0002\u00102\"\u0005\b¤\u0002\u00104R,\u0010¦\u0002\u001a\u0005\u0018\u00010¥\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¦\u0002\u0010§\u0002\u001a\u0006\b¨\u0002\u0010©\u0002\"\u0006\bª\u0002\u0010«\u0002R&\u0010¬\u0002\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¬\u0002\u0010\r\u001a\u0005\b\u00ad\u0002\u0010\u000f\"\u0005\b®\u0002\u0010\u0011R&\u0010¯\u0002\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¯\u0002\u0010\r\u001a\u0005\b°\u0002\u0010\u000f\"\u0005\b±\u0002\u0010\u0011R&\u0010²\u0002\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b²\u0002\u0010\r\u001a\u0005\b³\u0002\u0010\u000f\"\u0005\b´\u0002\u0010\u0011R&\u0010µ\u0002\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bµ\u0002\u0010\r\u001a\u0005\b¶\u0002\u0010\u000f\"\u0005\b·\u0002\u0010\u0011R)\u0010¸\u0002\u001a\u00020C8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¸\u0002\u0010¡\u0001\u001a\u0006\b¹\u0002\u0010¢\u0001\"\u0006\bº\u0002\u0010¤\u0001R(\u0010»\u0002\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b»\u0002\u0010\u0014\u001a\u0005\b¼\u0002\u0010\u0016\"\u0005\b½\u0002\u0010\u0018R(\u0010¾\u0002\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¾\u0002\u0010\u0014\u001a\u0005\b¿\u0002\u0010\u0016\"\u0005\bÀ\u0002\u0010\u0018R\u001d\u0010Á\u0002\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\u000e\n\u0005\bÁ\u0002\u0010\r\u001a\u0005\bÂ\u0002\u0010\u000fR\"\u0010Ä\u0002\u001a\u0005\u0018\u00010Ã\u00028\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÄ\u0002\u0010Å\u0002\u001a\u0006\bÆ\u0002\u0010Ç\u0002R\"\u0010É\u0002\u001a\u0005\u0018\u00010È\u00028\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÉ\u0002\u0010Ê\u0002\u001a\u0006\bË\u0002\u0010Ì\u0002R\"\u0010Î\u0002\u001a\u0005\u0018\u00010Í\u00028\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÎ\u0002\u0010Ï\u0002\u001a\u0006\bÐ\u0002\u0010Ñ\u0002R,\u0010Ó\u0002\u001a\u0005\u0018\u00010Ò\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÓ\u0002\u0010Ô\u0002\u001a\u0006\bÕ\u0002\u0010Ö\u0002\"\u0006\b×\u0002\u0010Ø\u0002R(\u0010Ù\u0002\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÙ\u0002\u0010\u0014\u001a\u0005\bÚ\u0002\u0010\u0016\"\u0005\bÛ\u0002\u0010\u0018R&\u0010Ü\u0002\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÜ\u0002\u0010\r\u001a\u0005\bÝ\u0002\u0010\u000f\"\u0005\bÞ\u0002\u0010\u0011R)\u0010ß\u0002\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bß\u0002\u0010¡\u0001\u001a\u0006\bà\u0002\u0010¢\u0001\"\u0006\bá\u0002\u0010¤\u0001R(\u0010å\u0002\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bâ\u0002\u0010\u0014\u001a\u0005\bã\u0002\u0010\u0016\"\u0005\bä\u0002\u0010\u0018R(\u0010é\u0002\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bæ\u0002\u0010\u0014\u001a\u0005\bç\u0002\u0010\u0016\"\u0005\bè\u0002\u0010\u0018RL\u0010ö\u0002\u001a%\u0012\u0017\u0012\u00150ë\u0002¢\u0006\u000f\bì\u0002\u0012\n\bí\u0002\u0012\u0005\b\b(î\u0002\u0012\u0005\u0012\u00030ï\u0002\u0018\u00010ê\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bð\u0002\u0010ñ\u0002\u001a\u0006\bò\u0002\u0010ó\u0002\"\u0006\bô\u0002\u0010õ\u0002R(\u0010ú\u0002\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b÷\u0002\u0010\u0014\u001a\u0005\bø\u0002\u0010\u0016\"\u0005\bù\u0002\u0010\u0018R(\u0010þ\u0002\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bû\u0002\u0010\u0014\u001a\u0005\bü\u0002\u0010\u0016\"\u0005\bý\u0002\u0010\u0018R&\u0010\u0082\u0003\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÿ\u0002\u0010\r\u001a\u0005\b\u0080\u0003\u0010\u000f\"\u0005\b\u0081\u0003\u0010\u0011R)\u0010\u0086\u0003\u001a\u00020C8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0083\u0003\u0010¡\u0001\u001a\u0006\b\u0084\u0003\u0010¢\u0001\"\u0006\b\u0085\u0003\u0010¤\u0001R(\u0010\u0088\u0003\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0087\u0003\u0010E\u001a\u0005\b\u0088\u0003\u0010F\"\u0005\b\u0089\u0003\u0010HR,\u0010\u008b\u0003\u001a\u0005\u0018\u00010\u008a\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008b\u0003\u0010\u008c\u0003\u001a\u0006\b\u008d\u0003\u0010\u008e\u0003\"\u0006\b\u008f\u0003\u0010\u0090\u0003¨\u0006\u0094\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/SearchAggregateCommodity;", "Ljava/io/Serializable;", "", "clone", "Lcom/ss/android/ugc/aweme/discover/model/CardProtocolType;", "cardProtocolType", "Lcom/ss/android/ugc/aweme/discover/model/CardProtocolType;", "getCardProtocolType", "()Lcom/ss/android/ugc/aweme/discover/model/CardProtocolType;", "setCardProtocolType", "(Lcom/ss/android/ugc/aweme/discover/model/CardProtocolType;)V", "", "styleType", "I", "getStyleType", "()I", "setStyleType", "(I)V", "", "refId", "Ljava/lang/String;", "getRefId", "()Ljava/lang/String;", "setRefId", "(Ljava/lang/String;)V", "", "docId", "J", "getDocId", "()J", "setDocId", "(J)V", "needInsertDocId", "Ljava/lang/Long;", "getNeedInsertDocId", "()Ljava/lang/Long;", "setNeedInsertDocId", "(Ljava/lang/Long;)V", "docType", "getDocType", "setDocType", "eventLog", "getEventLog", "setEventLog", "level", "getLevel", "setLevel", "resultType", "Ljava/lang/Integer;", "getResultType", "()Ljava/lang/Integer;", "setResultType", "(Ljava/lang/Integer;)V", "Lcom/ss/android/ugc/aweme/discover/model/Commodity;", CardProtocolType.COMMODITY, "Lcom/ss/android/ugc/aweme/discover/model/Commodity;", "getCommodity", "()Lcom/ss/android/ugc/aweme/discover/model/Commodity;", "setCommodity", "(Lcom/ss/android/ugc/aweme/discover/model/Commodity;)V", "Lcom/ss/android/ugc/aweme/feed/model/Aweme;", ShareChannel.DOUYIN, "Lcom/ss/android/ugc/aweme/feed/model/Aweme;", "getAweme", "()Lcom/ss/android/ugc/aweme/feed/model/Aweme;", "setAweme", "(Lcom/ss/android/ugc/aweme/feed/model/Aweme;)V", "", "isAutoPlay", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setAutoPlay", "(Ljava/lang/Boolean;)V", "needPlayFinish", "getNeedPlayFinish", "setNeedPlayFinish", "Lcom/ss/android/ugc/aweme/discover/model/SeedInfo;", "seedInfo", "Lcom/ss/android/ugc/aweme/discover/model/SeedInfo;", "getSeedInfo", "()Lcom/ss/android/ugc/aweme/discover/model/SeedInfo;", "setSeedInfo", "(Lcom/ss/android/ugc/aweme/discover/model/SeedInfo;)V", "Lcom/ss/android/ugc/aweme/discover/model/HashTag;", "tagInfo", "Lcom/ss/android/ugc/aweme/discover/model/HashTag;", "getTagInfo", "()Lcom/ss/android/ugc/aweme/discover/model/HashTag;", "setTagInfo", "(Lcom/ss/android/ugc/aweme/discover/model/HashTag;)V", "Lcom/ss/android/ugc/aweme/discover/model/OrderInfo;", "orderInfo", "Lcom/ss/android/ugc/aweme/discover/model/OrderInfo;", "getOrderInfo", "()Lcom/ss/android/ugc/aweme/discover/model/OrderInfo;", "setOrderInfo", "(Lcom/ss/android/ugc/aweme/discover/model/OrderInfo;)V", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/ECSearchUser;", "users", "Ljava/util/List;", "getUsers", "()Ljava/util/List;", "setUsers", "(Ljava/util/List;)V", "Lcom/ss/android/ugc/aweme/discover/model/CommodityText;", "textInfo", "Lcom/ss/android/ugc/aweme/discover/model/CommodityText;", "getTextInfo", "()Lcom/ss/android/ugc/aweme/discover/model/CommodityText;", "setTextInfo", "(Lcom/ss/android/ugc/aweme/discover/model/CommodityText;)V", "Lcom/ss/android/ugc/aweme/discover/model/SearchShopWindowControlInfo;", "controlInfo", "Lcom/ss/android/ugc/aweme/discover/model/SearchShopWindowControlInfo;", "getControlInfo", "()Lcom/ss/android/ugc/aweme/discover/model/SearchShopWindowControlInfo;", "setControlInfo", "(Lcom/ss/android/ugc/aweme/discover/model/SearchShopWindowControlInfo;)V", "Lcom/ss/android/ugc/aweme/feed/model/AwemeRawAd;", "awemeRawAd", "Lcom/ss/android/ugc/aweme/feed/model/AwemeRawAd;", "getAwemeRawAd", "()Lcom/ss/android/ugc/aweme/feed/model/AwemeRawAd;", "setAwemeRawAd", "(Lcom/ss/android/ugc/aweme/feed/model/AwemeRawAd;)V", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectInfo;", "selectInfo", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectInfo;", "getSelectInfo", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectInfo;", "setSelectInfo", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectInfo;)V", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/CardTitle;", "cardTitle", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/CardTitle;", "getCardTitle", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/CardTitle;", "setCardTitle", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/CardTitle;)V", "floorHeaderStyle", "getFloorHeaderStyle", "setFloorHeaderStyle", "Lcom/ss/android/ugc/aweme/discover/model/SearchClickLinkConfig;", "feedbackConfig", "Lcom/ss/android/ugc/aweme/discover/model/SearchClickLinkConfig;", "getFeedbackConfig", "()Lcom/ss/android/ugc/aweme/discover/model/SearchClickLinkConfig;", "setFeedbackConfig", "(Lcom/ss/android/ugc/aweme/discover/model/SearchClickLinkConfig;)V", "Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponInfo;", "couponInfo", "Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponInfo;", "getCouponInfo", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponInfo;", "setCouponInfo", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponInfo;)V", "rsCardBusinessType", "getRsCardBusinessType", "setRsCardBusinessType", "isRealTimePushDoc", "Z", "()Z", "setRealTimePushDoc", "(Z)V", "", "", "cardBizInfo", "Ljava/util/Map;", "getCardBizInfo", "()Ljava/util/Map;", "setCardBizInfo", "(Ljava/util/Map;)V", "version", "getVersion", "setVersion", "Lcom/ss/android/ugc/aweme/discover/model/RelatedSearchWordItem;", "relatedWordList", "getRelatedWordList", "setRelatedWordList", "Lcom/ss/android/ugc/aweme/discover/model/suggest/RecommendWordMob;", "recommendWordMob", "Lcom/ss/android/ugc/aweme/discover/model/suggest/RecommendWordMob;", "getRecommendWordMob", "()Lcom/ss/android/ugc/aweme/discover/model/suggest/RecommendWordMob;", "setRecommendWordMob", "(Lcom/ss/android/ugc/aweme/discover/model/suggest/RecommendWordMob;)V", "Lcom/ss/android/ugc/aweme/discover/model/CommodityUIInfo;", "uiInfo", "Lcom/ss/android/ugc/aweme/discover/model/CommodityUIInfo;", "getUiInfo", "()Lcom/ss/android/ugc/aweme/discover/model/CommodityUIInfo;", "setUiInfo", "(Lcom/ss/android/ugc/aweme/discover/model/CommodityUIInfo;)V", "Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/AladdinInfo;", "aladdinInfo", "Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/AladdinInfo;", "getAladdinInfo", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/AladdinInfo;", "setAladdinInfo", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/AladdinInfo;)V", "isJumpToProductDetail", "setJumpToProductDetail", "shouldShowSkuPanel", "getShouldShowSkuPanel", "setShouldShowSkuPanel", "logInfo", "getLogInfo", "setLogInfo", "isReportShow", "setReportShow", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "logPbBean", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "getLogPbBean", "()Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "setLogPbBean", "(Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;)V", "buttonType", "getButtonType", "setButtonType", "enterMethod", "getEnterMethod", "setEnterMethod", "supporTypes", "getSupporTypes", "setSupporTypes", "btmSourceToken", "getBtmSourceToken", "setBtmSourceToken", "Lcom/ss/android/ugc/aweme/discover/model/SearchCommodityAdGoodsInfo;", "adGoodsList", "getAdGoodsList", "setAdGoodsList", "Lcom/ss/android/ugc/aweme/discover/model/SearchCommodityAdGraphics;", "adImageList", "getAdImageList", "setAdImageList", "searchCoord", "getSearchCoord", "setSearchCoord", "rawPic", "getRawPic", "setRawPic", "groupId", "getGroupId", "setGroupId", "keyId", "getKeyId", "setKeyId", "searchKeyword", "getSearchKeyword", "setSearchKeyword", "isPreBindData", "setPreBindData", "Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponIndustry;", "couponIndustry", "Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponIndustry;", "getCouponIndustry", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponIndustry;", "setCouponIndustry", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponIndustry;)V", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/UpdateSelect;", "updateSelect", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/UpdateSelect;", "getUpdateSelect", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/UpdateSelect;", "setUpdateSelect", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/UpdateSelect;)V", "Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBanner;", "feedBanner", "Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBanner;", "getFeedBanner", "()Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBanner;", "setFeedBanner", "(Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBanner;)V", "Lcom/ss/android/ugc/aweme/discover/model/GoodsCardFrameStruct;", "goodsCardFrameStruct", "Lcom/ss/android/ugc/aweme/discover/model/GoodsCardFrameStruct;", "getGoodsCardFrameStruct", "()Lcom/ss/android/ugc/aweme/discover/model/GoodsCardFrameStruct;", "setGoodsCardFrameStruct", "(Lcom/ss/android/ugc/aweme/discover/model/GoodsCardFrameStruct;)V", "Lcom/ss/android/ugc/aweme/discover/model/SearchCommodityDynamicPatch;", "dynamicPatch", "Lcom/ss/android/ugc/aweme/discover/model/SearchCommodityDynamicPatch;", "getDynamicPatch", "()Lcom/ss/android/ugc/aweme/discover/model/SearchCommodityDynamicPatch;", "setDynamicPatch", "(Lcom/ss/android/ugc/aweme/discover/model/SearchCommodityDynamicPatch;)V", "showFormat", "getShowFormat", "setShowFormat", "Lcom/ss/android/ugc/aweme/search/dynamic/base/model/DynamicCardData;", "dynamicCardData", "Lcom/ss/android/ugc/aweme/search/dynamic/base/model/DynamicCardData;", "getDynamicCardData", "()Lcom/ss/android/ugc/aweme/search/dynamic/base/model/DynamicCardData;", "setDynamicCardData", "(Lcom/ss/android/ugc/aweme/search/dynamic/base/model/DynamicCardData;)V", "rankInSubList", "getRankInSubList", "setRankInSubList", "totalCountInParent", "getTotalCountInParent", "setTotalCountInParent", "parentRank", "getParentRank", "setParentRank", "rank", "getRank", "setRank", "bannerNeedAnim", "getBannerNeedAnim", "setBannerNeedAnim", "commonRawData", "getCommonRawData", "setCommonRawData", "commonCardInfo", "getCommonCardInfo", "setCommonCardInfo", "liveInnerShopCardType", "getLiveInnerShopCardType", "Lcom/ss/android/ugc/aweme/discover/model/LiveInnerShopInfo;", "liveInnerShopInfo", "Lcom/ss/android/ugc/aweme/discover/model/LiveInnerShopInfo;", "getLiveInnerShopInfo", "()Lcom/ss/android/ugc/aweme/discover/model/LiveInnerShopInfo;", "Lcom/ss/android/ugc/aweme/discover/model/LiveInnerWindowInfo;", "liveInnerWindowInfo", "Lcom/ss/android/ugc/aweme/discover/model/LiveInnerWindowInfo;", "getLiveInnerWindowInfo", "()Lcom/ss/android/ugc/aweme/discover/model/LiveInnerWindowInfo;", "Lcom/ss/android/ugc/aweme/discover/model/InstantAddressInfo;", "instantLocationCard", "Lcom/ss/android/ugc/aweme/discover/model/InstantAddressInfo;", "getInstantLocationCard", "()Lcom/ss/android/ugc/aweme/discover/model/InstantAddressInfo;", "Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsV2;", "guideSearchWordsV2", "Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsV2;", "getGuideSearchWordsV2", "()Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsV2;", "setGuideSearchWordsV2", "(Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsV2;)V", "correctQuery", "getCorrectQuery", "setCorrectQuery", "correctLevel", "getCorrectLevel", "setCorrectLevel", "ignoreRank", "getIgnoreRank", "setIgnoreRank", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getCurrentSearchId", "setCurrentSearchId", "currentSearchId", "b", "getSectionId", "setSectionId", "sectionId", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "c", "Lkotlin/jvm/functions/Function1;", "getLoadMoreFunction", "()Lkotlin/jvm/functions/Function1;", "setLoadMoreFunction", "(Lkotlin/jvm/functions/Function1;)V", "loadMoreFunction", "d", "getSearchChannel", "setSearchChannel", "searchChannel", "e", "getSearchEntrance", "setSearchEntrance", "searchEntrance", "f", "getResultFrom", "setResultFrom", "resultFrom", ce.f26391f, "getHasSideBar", "setHasSideBar", "hasSideBar", "h", "isFirstSearchLastItem", "setFirstSearchLastItem", "Lcom/ss/android/ugc/aweme/discover/model/CommodityJumpParams;", "commodityJumpParams", "Lcom/ss/android/ugc/aweme/discover/model/CommodityJumpParams;", "getCommodityJumpParams", "()Lcom/ss/android/ugc/aweme/discover/model/CommodityJumpParams;", "setCommodityJumpParams", "(Lcom/ss/android/ugc/aweme/discover/model/CommodityJumpParams;)V", "<init>", "()V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchAggregateCommodity implements Serializable, Cloneable {
    public static final int AD_BRAND_GOODS = 32;
    public static final int AD_BRAND_IMAGE = 30;
    public static final int AD_BRAND_LIVE = 24;
    public static final int AD_BRAND_LIVE_INNOVATION = 33;
    public static final int AD_BRAND_PRODUCT_LIST = 19;
    public static final int AD_BRAND_SHOP = 31;
    public static final int AD_BRAND_TOP_EMPTY = 23;
    public static final int AD_BRAND_USER_FOLLOW = 17;
    public static final int AD_BRAND_VIDEO = 18;
    public static final int BANNER_FEED_BOX = 34;
    public static final int COMMODITY_BOTTOM_NEW = 1;
    public static final int COMMODITY_BOTTOM_OLD = 0;
    public static final int COUPON = 27;
    public static final int COUPON_INDUSTRY = 29;
    public static final Companion Companion = null;
    public static final int DOC_TYPE_SHOP_CARD = 290;
    public static final int EMPTY_RESULT_CARD = 37;
    public static final int FILTERS = 14;
    public static final int FILTER_PANEL = 22;
    public static final int FUNCTION_CARD = 26;
    public static final int GUIDE_SEARCH = 49;
    public static final int HASH_TAG = 5;
    public static final int INSTANT_ADDRESS = 48;
    public static final int LIVE_SHOP = 44;
    public static final int LYNX = 99;
    public static final int MARKET_PRODUCT_CARD = 28;
    public static final String NATURE_RESULT = "nature_result";
    public static final int ORDER = 8;
    public static final int PRODUCT_ONLY = 1;
    public static final int PRODUCT_WITH_ALBUM = 41;
    public static final int PRODUCT_WITH_LIVE = 6;
    public static final int PRODUCT_WITH_VIDEO = 2;
    public static final int QUERY_CORRECT = 50;
    public static final int RECOMMEND_FOR_YOU = 20;
    public static final String RECOMMEND_RESULT = "recommend_result";
    public static final int RELATED_SEARCH = 15;
    public static final int REPLAY = 21;
    public static final int SEED = 4;
    public static final int SELECTS = 12;
    public static final int SELECTS_WITH_TWO_LINE = 9999;
    public static final int SHOP = 10;
    public static final int SHOW_FORMAT_LYNX_BOTH = 2;
    public static final int SHOW_FORMAT_LYNX_SINGLE = 1;
    public static final int SORTS = 13;
    public static final int STRONG_BANNER = 16;
    public static final int TITLE = 11;
    public static final int TagsFeeds = 60;
    public static final int USER = 9;
    public static final int VIDEO_ONLY = 3;
    public static final int WEAK_BANNER = 25;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient String f450490a;

    @SerializedName("ad_goods_list")
    private List<SearchCommodityAdGoodsInfo> adGoodsList;

    @SerializedName("ad_image_list")
    private List<SearchCommodityAdGraphics> adImageList;

    @SerializedName("aladdin_info")
    private AladdinInfo aladdinInfo;

    @SerializedName("aweme_info")
    private Aweme aweme;

    @SerializedName("raw_ad_data")
    private AwemeRawAd awemeRawAd;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient String f450491b;
    private boolean bannerNeedAnim;

    @SerializedName("btm_source_token")
    private String btmSourceToken;
    private String buttonType;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Function1<? super View, Unit> f450492c;

    @SerializedName("card_biz_info")
    private Map<String, ? extends Object> cardBizInfo;

    @SerializedName("card_protocol_type")
    private CardProtocolType cardProtocolType;

    @SerializedName("card_title")
    private CardTitle cardTitle;

    @SerializedName("product_info")
    private Commodity commodity;

    @SerializedName("common_card_info")
    private String commonCardInfo;

    @SerializedName("common_raw_data")
    private String commonRawData;

    @SerializedName("control_info")
    private SearchShopWindowControlInfo controlInfo;

    @SerializedName("correct_level")
    private int correctLevel;

    @SerializedName("corrected_query")
    private String correctQuery;

    @SerializedName("coupon_industry")
    private CouponIndustry couponIndustry;

    @SerializedName(a.KEY_COUPON_INFO)
    private CouponInfo couponInfo;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient String f450493d;

    @SerializedName("doc_id")
    private long docId;

    @SerializedName("doc_type")
    private int docType;
    private DynamicCardData dynamicCardData;

    @SerializedName("dynamic_patch")
    private SearchCommodityDynamicPatch dynamicPatch;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient String f450494e;
    private String enterMethod;

    @SerializedName("event_log")
    private String eventLog;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient int f450495f;

    @SerializedName("feed_box_banner")
    private FeedBoxBanner feedBanner;

    @SerializedName("feedback_info")
    private SearchClickLinkConfig feedbackConfig;

    @SerializedName("floor_header_style")
    private Integer floorHeaderStyle;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient boolean f450496g;
    private GoodsCardFrameStruct goodsCardFrameStruct;
    private String groupId;

    @SerializedName("guide_search_wordsv2")
    private GuideSearchWordsV2 guideSearchWordsV2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient Boolean f450497h;

    @SerializedName("ignore_rank")
    private boolean ignoreRank;

    @SerializedName("instant_location_card")
    private final InstantAddressInfo instantLocationCard;

    @SerializedName("is_auto_play")
    private Boolean isAutoPlay;

    @SerializedName("is_jump_to_product_detail")
    private boolean isJumpToProductDetail;
    private Boolean isPreBindData;
    private boolean isRealTimePushDoc;
    private boolean isReportShow;
    private String keyId;

    @SerializedName("level")
    private String level;

    @SerializedName("live_inner_shop_card_type")
    private final int liveInnerShopCardType;

    @SerializedName("live_inner_shop_info")
    private final LiveInnerShopInfo liveInnerShopInfo;

    @SerializedName("live_inner_window_info")
    private final LiveInnerWindowInfo liveInnerWindowInfo;

    @SerializedName("log_info")
    private Map<String, ? extends Object> logInfo;
    private LogPbBean logPbBean;

    @SerializedName("need_insert_doc_id")
    private Long needInsertDocId;

    @SerializedName("need_play_finish")
    private Boolean needPlayFinish;

    @SerializedName("order_info")
    private OrderInfo orderInfo;
    private int parentRank;
    private int rank;
    private int rankInSubList;
    private String rawPic;

    @SerializedName("words_query_record")
    private RecommendWordMob recommendWordMob;

    @SerializedName("ref_id")
    private String refId;

    @SerializedName("related_word_list")
    private List<? extends RelatedSearchWordItem> relatedWordList;

    @SerializedName("result_type")
    private Integer resultType;

    @SerializedName("rs_card_business_type")
    private String rsCardBusinessType;
    private String searchCoord;
    private String searchKeyword;

    @SerializedName("seed_info")
    private SeedInfo seedInfo;

    @SerializedName("select_info")
    private SelectInfo selectInfo;

    @SerializedName("should_show_sku_panel")
    private boolean shouldShowSkuPanel;

    @SerializedName("show_format_lynx")
    private Integer showFormat;

    @SerializedName(MapMonitorConst.STYLE_TYPE)
    private int styleType;

    @SerializedName("show_on_style")
    private List<String> supporTypes;

    @SerializedName("tag_info")
    private HashTag tagInfo;

    @SerializedName("text_info")
    private CommodityText textInfo;
    private int totalCountInParent;

    @SerializedName("ui_info")
    private CommodityUIInfo uiInfo;

    @SerializedName("update_select")
    private UpdateSelect updateSelect;

    @SerializedName("users")
    private List<ECSearchUser> users;

    @SerializedName("version")
    private int version;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/SearchAggregateCommodity$Companion;", "", "()V", "AD_BRAND_GOODS", "", "AD_BRAND_IMAGE", "AD_BRAND_LIVE", "AD_BRAND_LIVE_INNOVATION", "AD_BRAND_PRODUCT_LIST", "AD_BRAND_SHOP", "AD_BRAND_TOP_EMPTY", "AD_BRAND_USER_FOLLOW", "AD_BRAND_VIDEO", "BANNER_FEED_BOX", "COMMODITY_BOTTOM_NEW", "COMMODITY_BOTTOM_OLD", "COUPON", "COUPON_INDUSTRY", "DOC_TYPE_SHOP_CARD", "EMPTY_RESULT_CARD", "FILTERS", "FILTER_PANEL", "FUNCTION_CARD", "GUIDE_SEARCH", "HASH_TAG", "INSTANT_ADDRESS", "LIVE_SHOP", "LYNX", "MARKET_PRODUCT_CARD", "NATURE_RESULT", "", "ORDER", "PRODUCT_ONLY", "PRODUCT_WITH_ALBUM", "PRODUCT_WITH_LIVE", "PRODUCT_WITH_VIDEO", "QUERY_CORRECT", "RECOMMEND_FOR_YOU", "RECOMMEND_RESULT", "RELATED_SEARCH", "REPLAY", "SEED", "SELECTS", "SELECTS_WITH_TWO_LINE", "SHOP", "SHOW_FORMAT_LYNX_BOTH", "SHOW_FORMAT_LYNX_SINGLE", "SORTS", "STRONG_BANNER", "TITLE", "TagsFeeds", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "VIDEO_ONLY", "WEAK_BANNER", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final CommodityJumpParams getCommodityJumpParams() {
        return null;
    }

    public final void setCommodityJumpParams(CommodityJumpParams r100) {
    }

    public SearchAggregateCommodity() {
        this.eventLog = "";
        this.isAutoPlay = Boolean.TRUE;
        Boolean r100 = Boolean.FALSE;
        this.needPlayFinish = r100;
        this.shouldShowSkuPanel = true;
        this.buttonType = "";
        this.enterMethod = "";
        this.supporTypes = CollectionsKt.mutableListOf(new String[]{ItemStyle.ITEM_STYLE_DOUBLE});
        this.showFormat = 0;
        this.rankInSubList = -1;
        this.totalCountInParent = -1;
        this.parentRank = -1;
        this.rank = -1;
        this.correctLevel = 2;
        this.f450497h = r100;
    }

    public SearchAggregateCommodity clone() {
        Object r100 = super.clone();
        if (r100 == null) goto L7;
        return (SearchAggregateCommodity) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity");
    }

    public final List<SearchCommodityAdGoodsInfo> getAdGoodsList() {
        return this.adGoodsList;
    }

    public final List<SearchCommodityAdGraphics> getAdImageList() {
        return this.adImageList;
    }

    public final AladdinInfo getAladdinInfo() {
        return this.aladdinInfo;
    }

    public final Aweme getAweme() {
        return this.aweme;
    }

    public final AwemeRawAd getAwemeRawAd() {
        return this.awemeRawAd;
    }

    public final boolean getBannerNeedAnim() {
        return this.bannerNeedAnim;
    }

    public final String getBtmSourceToken() {
        return this.btmSourceToken;
    }

    public final String getButtonType() {
        return this.buttonType;
    }

    public final Map<String, Object> getCardBizInfo() {
        return this.cardBizInfo;
    }

    public final CardProtocolType getCardProtocolType() {
        return this.cardProtocolType;
    }

    public final CardTitle getCardTitle() {
        return this.cardTitle;
    }

    public final Commodity getCommodity() {
        return this.commodity;
    }

    public final String getCommonCardInfo() {
        return this.commonCardInfo;
    }

    public final String getCommonRawData() {
        return this.commonRawData;
    }

    public final SearchShopWindowControlInfo getControlInfo() {
        return this.controlInfo;
    }

    public final int getCorrectLevel() {
        return this.correctLevel;
    }

    public final String getCorrectQuery() {
        return this.correctQuery;
    }

    public final CouponIndustry getCouponIndustry() {
        return this.couponIndustry;
    }

    public final CouponInfo getCouponInfo() {
        return this.couponInfo;
    }

    public final String getCurrentSearchId() {
        return this.f450490a;
    }

    public final long getDocId() {
        return this.docId;
    }

    public final int getDocType() {
        return this.docType;
    }

    public final DynamicCardData getDynamicCardData() {
        return this.dynamicCardData;
    }

    public final SearchCommodityDynamicPatch getDynamicPatch() {
        return this.dynamicPatch;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEventLog() {
        return this.eventLog;
    }

    public final FeedBoxBanner getFeedBanner() {
        return this.feedBanner;
    }

    public final SearchClickLinkConfig getFeedbackConfig() {
        return this.feedbackConfig;
    }

    public final Integer getFloorHeaderStyle() {
        return this.floorHeaderStyle;
    }

    public final GoodsCardFrameStruct getGoodsCardFrameStruct() {
        return this.goodsCardFrameStruct;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final GuideSearchWordsV2 getGuideSearchWordsV2() {
        return this.guideSearchWordsV2;
    }

    public final boolean getHasSideBar() {
        return this.f450496g;
    }

    public final boolean getIgnoreRank() {
        return this.ignoreRank;
    }

    public final InstantAddressInfo getInstantLocationCard() {
        return this.instantLocationCard;
    }

    public final String getKeyId() {
        return this.keyId;
    }

    public final String getLevel() {
        return this.level;
    }

    public final int getLiveInnerShopCardType() {
        return this.liveInnerShopCardType;
    }

    public final LiveInnerShopInfo getLiveInnerShopInfo() {
        return this.liveInnerShopInfo;
    }

    public final LiveInnerWindowInfo getLiveInnerWindowInfo() {
        return this.liveInnerWindowInfo;
    }

    public final Function1<View, Unit> getLoadMoreFunction() {
        return this.f450492c;
    }

    public final Map<String, Object> getLogInfo() {
        return this.logInfo;
    }

    public final LogPbBean getLogPbBean() {
        return this.logPbBean;
    }

    public final Long getNeedInsertDocId() {
        return this.needInsertDocId;
    }

    public final Boolean getNeedPlayFinish() {
        return this.needPlayFinish;
    }

    public final OrderInfo getOrderInfo() {
        return this.orderInfo;
    }

    public final int getParentRank() {
        return this.parentRank;
    }

    public final int getRank() {
        return this.rank;
    }

    public final int getRankInSubList() {
        return this.rankInSubList;
    }

    public final String getRawPic() {
        return this.rawPic;
    }

    public final RecommendWordMob getRecommendWordMob() {
        return this.recommendWordMob;
    }

    public final String getRefId() {
        return this.refId;
    }

    public final List<RelatedSearchWordItem> getRelatedWordList() {
        return this.relatedWordList;
    }

    public final int getResultFrom() {
        return this.f450495f;
    }

    public final Integer getResultType() {
        return this.resultType;
    }

    public final String getRsCardBusinessType() {
        return this.rsCardBusinessType;
    }

    public final String getSearchChannel() {
        return this.f450493d;
    }

    public final String getSearchCoord() {
        return this.searchCoord;
    }

    public final String getSearchEntrance() {
        return this.f450494e;
    }

    public final String getSearchKeyword() {
        return this.searchKeyword;
    }

    public final String getSectionId() {
        return this.f450491b;
    }

    public final SeedInfo getSeedInfo() {
        return this.seedInfo;
    }

    public final SelectInfo getSelectInfo() {
        return this.selectInfo;
    }

    public final boolean getShouldShowSkuPanel() {
        return this.shouldShowSkuPanel;
    }

    public final Integer getShowFormat() {
        return this.showFormat;
    }

    public final int getStyleType() {
        return this.styleType;
    }

    public final List<String> getSupporTypes() {
        return this.supporTypes;
    }

    public final HashTag getTagInfo() {
        return this.tagInfo;
    }

    public final CommodityText getTextInfo() {
        return this.textInfo;
    }

    public final int getTotalCountInParent() {
        return this.totalCountInParent;
    }

    public final CommodityUIInfo getUiInfo() {
        return this.uiInfo;
    }

    public final UpdateSelect getUpdateSelect() {
        return this.updateSelect;
    }

    public final List<ECSearchUser> getUsers() {
        return this.users;
    }

    public final int getVersion() {
        return this.version;
    }

    public final Boolean isAutoPlay() {
        return this.isAutoPlay;
    }

    public final Boolean isFirstSearchLastItem() {
        return this.f450497h;
    }

    public final boolean isJumpToProductDetail() {
        return this.isJumpToProductDetail;
    }

    public final Boolean isPreBindData() {
        return this.isPreBindData;
    }

    public final boolean isRealTimePushDoc() {
        return this.isRealTimePushDoc;
    }

    public final boolean isReportShow() {
        return this.isReportShow;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8700clone() {
        return clone();
    }

    public final void setAdGoodsList(List<SearchCommodityAdGoodsInfo> r100) {
        this.adGoodsList = r100;
    }

    public final void setAdImageList(List<SearchCommodityAdGraphics> r100) {
        this.adImageList = r100;
    }

    public final void setAladdinInfo(AladdinInfo r100) {
        this.aladdinInfo = r100;
    }

    public final void setAutoPlay(Boolean r100) {
        this.isAutoPlay = r100;
    }

    public final void setAweme(Aweme r100) {
        this.aweme = r100;
    }

    public final void setAwemeRawAd(AwemeRawAd r100) {
        this.awemeRawAd = r100;
    }

    public final void setBannerNeedAnim(boolean r100) {
        this.bannerNeedAnim = r100;
    }

    public final void setBtmSourceToken(String r100) {
        this.btmSourceToken = r100;
    }

    public final void setButtonType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.buttonType = r100;
    }

    public final void setCardBizInfo(Map<String, ? extends Object> r100) {
        this.cardBizInfo = r100;
    }

    public final void setCardProtocolType(CardProtocolType r100) {
        this.cardProtocolType = r100;
    }

    public final void setCardTitle(CardTitle r100) {
        this.cardTitle = r100;
    }

    public final void setCommodity(Commodity r100) {
        this.commodity = r100;
    }

    public final void setCommonCardInfo(String r100) {
        this.commonCardInfo = r100;
    }

    public final void setCommonRawData(String r100) {
        this.commonRawData = r100;
    }

    public final void setControlInfo(SearchShopWindowControlInfo r100) {
        this.controlInfo = r100;
    }

    public final void setCorrectLevel(int r100) {
        this.correctLevel = r100;
    }

    public final void setCorrectQuery(String r100) {
        this.correctQuery = r100;
    }

    public final void setCouponIndustry(CouponIndustry r100) {
        this.couponIndustry = r100;
    }

    public final void setCouponInfo(CouponInfo r100) {
        this.couponInfo = r100;
    }

    public final void setCurrentSearchId(String r100) {
        this.f450490a = r100;
    }

    public final void setDocId(long r100) {
        this.docId = r100;
    }

    public final void setDocType(int r100) {
        this.docType = r100;
    }

    public final void setDynamicCardData(DynamicCardData r100) {
        this.dynamicCardData = r100;
    }

    public final void setDynamicPatch(SearchCommodityDynamicPatch r100) {
        this.dynamicPatch = r100;
    }

    public final void setEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethod = r100;
    }

    public final void setEventLog(String r100) {
        this.eventLog = r100;
    }

    public final void setFeedBanner(FeedBoxBanner r100) {
        this.feedBanner = r100;
    }

    public final void setFeedbackConfig(SearchClickLinkConfig r100) {
        this.feedbackConfig = r100;
    }

    public final void setFirstSearchLastItem(Boolean r100) {
        this.f450497h = r100;
    }

    public final void setFloorHeaderStyle(Integer r100) {
        this.floorHeaderStyle = r100;
    }

    public final void setGoodsCardFrameStruct(GoodsCardFrameStruct r100) {
        this.goodsCardFrameStruct = r100;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setGuideSearchWordsV2(GuideSearchWordsV2 r100) {
        this.guideSearchWordsV2 = r100;
    }

    public final void setHasSideBar(boolean r100) {
        this.f450496g = r100;
    }

    public final void setIgnoreRank(boolean r100) {
        this.ignoreRank = r100;
    }

    public final void setJumpToProductDetail(boolean r100) {
        this.isJumpToProductDetail = r100;
    }

    public final void setKeyId(String r100) {
        this.keyId = r100;
    }

    public final void setLevel(String r100) {
        this.level = r100;
    }

    public final void setLoadMoreFunction(Function1<? super View, Unit> r100) {
        this.f450492c = r100;
    }

    public final void setLogInfo(Map<String, ? extends Object> r100) {
        this.logInfo = r100;
    }

    public final void setLogPbBean(LogPbBean r100) {
        this.logPbBean = r100;
    }

    public final void setNeedInsertDocId(Long r100) {
        this.needInsertDocId = r100;
    }

    public final void setNeedPlayFinish(Boolean r100) {
        this.needPlayFinish = r100;
    }

    public final void setOrderInfo(OrderInfo r100) {
        this.orderInfo = r100;
    }

    public final void setParentRank(int r100) {
        this.parentRank = r100;
    }

    public final void setPreBindData(Boolean r100) {
        this.isPreBindData = r100;
    }

    public final void setRank(int r100) {
        this.rank = r100;
    }

    public final void setRankInSubList(int r100) {
        this.rankInSubList = r100;
    }

    public final void setRawPic(String r100) {
        this.rawPic = r100;
    }

    public final void setRealTimePushDoc(boolean r100) {
        this.isRealTimePushDoc = r100;
    }

    public final void setRecommendWordMob(RecommendWordMob r100) {
        this.recommendWordMob = r100;
    }

    public final void setRefId(String r100) {
        this.refId = r100;
    }

    public final void setRelatedWordList(List<? extends RelatedSearchWordItem> r100) {
        this.relatedWordList = r100;
    }

    public final void setReportShow(boolean r100) {
        this.isReportShow = r100;
    }

    public final void setResultFrom(int r100) {
        this.f450495f = r100;
    }

    public final void setResultType(Integer r100) {
        this.resultType = r100;
    }

    public final void setRsCardBusinessType(String r100) {
        this.rsCardBusinessType = r100;
    }

    public final void setSearchChannel(String r100) {
        this.f450493d = r100;
    }

    public final void setSearchCoord(String r100) {
        this.searchCoord = r100;
    }

    public final void setSearchEntrance(String r100) {
        this.f450494e = r100;
    }

    public final void setSearchKeyword(String r100) {
        this.searchKeyword = r100;
    }

    public final void setSectionId(String r100) {
        this.f450491b = r100;
    }

    public final void setSeedInfo(SeedInfo r100) {
        this.seedInfo = r100;
    }

    public final void setSelectInfo(SelectInfo r100) {
        this.selectInfo = r100;
    }

    public final void setShouldShowSkuPanel(boolean r100) {
        this.shouldShowSkuPanel = r100;
    }

    public final void setShowFormat(Integer r100) {
        this.showFormat = r100;
    }

    public final void setStyleType(int r100) {
        this.styleType = r100;
    }

    public final void setSupporTypes(List<String> r100) {
        this.supporTypes = r100;
    }

    public final void setTagInfo(HashTag r100) {
        this.tagInfo = r100;
    }

    public final void setTextInfo(CommodityText r100) {
        this.textInfo = r100;
    }

    public final void setTotalCountInParent(int r100) {
        this.totalCountInParent = r100;
    }

    public final void setUiInfo(CommodityUIInfo r100) {
        this.uiInfo = r100;
    }

    public final void setUpdateSelect(UpdateSelect r100) {
        this.updateSelect = r100;
    }

    public final void setUsers(List<ECSearchUser> r100) {
        this.users = r100;
    }

    public final void setVersion(int r100) {
        this.version = r100;
    }
}
