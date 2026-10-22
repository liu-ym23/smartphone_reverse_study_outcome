package com.bytedance.android.window.shop.home;

import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.common.param.ECWindowShareParam;
import com.bytedance.android.ec.window.base.common.taskgraph.PipelinePool;
import com.bytedance.android.ec.window.base.shop.WindowFansClubInfo;
import com.bytedance.android.window.shop.home.tab.common.WindowTabRequestParamKey;
import com.bytedance.android.window.shop.home.tab.tabplugin.TabNavigationParams;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b<\u0018\u0000 \u009e\u00022\u00020\u0001:\u0002\u009f\u0002B\u001b\u0012\u0007\u0010\u0098\u0002\u001a\u00020\u0002\u0012\u0007\u0010\u009a\u0002\u001a\u00020\u0002¢\u0006\u0006\b\u009c\u0002\u0010\u009d\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001d\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\"\u0010%\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001e\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b.\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010/\u001a\u0004\b4\u00100\"\u0004\b5\u00102R$\u00106\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0013\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010*R#\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020>8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\"\u0010D\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010\u001e\u001a\u0004\bD\u0010 \"\u0004\bE\u0010\"R$\u0010F\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0013\u001a\u0004\bG\u0010\u0015\"\u0004\bH\u0010*R$\u0010I\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0013\u001a\u0004\bJ\u0010\u0015\"\u0004\bK\u0010*R$\u0010L\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010\u0013\u001a\u0004\bM\u0010\u0015\"\u0004\bN\u0010*R\"\u0010O\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010\u001e\u001a\u0004\bO\u0010 \"\u0004\bP\u0010\"R$\u0010R\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010Y\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010_\u001a\u00020X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010\u001e\u001a\u0004\be\u0010 \"\u0004\bf\u0010\"R$\u0010g\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010\u0013\u001a\u0004\bh\u0010\u0015\"\u0004\bi\u0010*R\"\u0010j\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010\u0013\u001a\u0004\bk\u0010\u0015\"\u0004\bl\u0010*R\u001a\u0010m\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\bm\u0010\u0013\u001a\u0004\bn\u0010\u0015R\u0019\u0010o\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bo\u0010\u0013\u001a\u0004\bp\u0010\u0015R\"\u0010q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010\u0013\u001a\u0004\br\u0010\u0015\"\u0004\bs\u0010*R\"\u0010t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010\u0013\u001a\u0004\bu\u0010\u0015\"\u0004\bv\u0010*R$\u0010w\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010\u0013\u001a\u0004\bx\u0010\u0015\"\u0004\by\u0010*R\u0019\u0010z\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bz\u0010\u0013\u001a\u0004\b{\u0010\u0015R\u001a\u0010}\u001a\u0004\u0018\u00010|8\u0006¢\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R&\u0010\u0081\u0001\u001a\u00020X8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010`\u001a\u0005\b\u0082\u0001\u0010b\"\u0005\b\u0083\u0001\u0010dR&\u0010\u0084\u0001\u001a\u00020X8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010`\u001a\u0005\b\u0085\u0001\u0010b\"\u0005\b\u0086\u0001\u0010dR,\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R+\u0010\u008e\u0001\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R(\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0094\u0001\u0010\u0013\u001a\u0005\b\u0095\u0001\u0010\u0015\"\u0005\b\u0096\u0001\u0010*R&\u0010\u0097\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010\u001e\u001a\u0005\b\u0098\u0001\u0010 \"\u0005\b\u0099\u0001\u0010\"R,\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R,\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R(\u0010¨\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¨\u0001\u0010\u0013\u001a\u0005\b©\u0001\u0010\u0015\"\u0005\bª\u0001\u0010*R$\u0010¬\u0001\u001a\u000f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0«\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R6\u0010¯\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010®\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b¯\u0001\u0010;\u001a\u0005\b°\u0001\u0010=\"\u0006\b±\u0001\u0010²\u0001R(\u0010³\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b³\u0001\u0010\u0013\u001a\u0005\b´\u0001\u0010\u0015\"\u0005\bµ\u0001\u0010*R(\u0010¶\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¶\u0001\u0010\u0013\u001a\u0005\b·\u0001\u0010\u0015\"\u0005\b¸\u0001\u0010*R(\u0010¹\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¹\u0001\u0010\u0013\u001a\u0005\bº\u0001\u0010\u0015\"\u0005\b»\u0001\u0010*R\u001c\u0010¼\u0001\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\u000e\n\u0005\b¼\u0001\u0010\u0013\u001a\u0005\b½\u0001\u0010\u0015R+\u0010¾\u0001\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¾\u0001\u0010\u008f\u0001\u001a\u0006\b¿\u0001\u0010\u0091\u0001\"\u0006\bÀ\u0001\u0010\u0093\u0001R&\u0010Á\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÁ\u0001\u0010\u001e\u001a\u0005\bÂ\u0001\u0010 \"\u0005\bÃ\u0001\u0010\"R&\u0010Ä\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÄ\u0001\u0010\u001e\u001a\u0005\bÄ\u0001\u0010 \"\u0005\bÅ\u0001\u0010\"R&\u0010Æ\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÆ\u0001\u0010\u001e\u001a\u0005\bÇ\u0001\u0010 \"\u0005\bÈ\u0001\u0010\"R&\u0010É\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÉ\u0001\u0010\u001e\u001a\u0005\bÊ\u0001\u0010 \"\u0005\bË\u0001\u0010\"R+\u0010Ì\u0001\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÌ\u0001\u0010\u008f\u0001\u001a\u0006\bÍ\u0001\u0010\u0091\u0001\"\u0006\bÎ\u0001\u0010\u0093\u0001R&\u0010Ï\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÏ\u0001\u0010\u001e\u001a\u0005\bÐ\u0001\u0010 \"\u0005\bÑ\u0001\u0010\"R(\u0010Ò\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÒ\u0001\u0010\u0013\u001a\u0005\bÓ\u0001\u0010\u0015\"\u0005\bÔ\u0001\u0010*R+\u0010Õ\u0001\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÕ\u0001\u0010\u008f\u0001\u001a\u0006\bÖ\u0001\u0010\u0091\u0001\"\u0006\b×\u0001\u0010\u0093\u0001R(\u0010Ø\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bØ\u0001\u0010\u0013\u001a\u0005\bÙ\u0001\u0010\u0015\"\u0005\bÚ\u0001\u0010*R(\u0010Û\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÛ\u0001\u0010\u0013\u001a\u0005\bÜ\u0001\u0010\u0015\"\u0005\bÝ\u0001\u0010*R(\u0010Þ\u0001\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÞ\u0001\u0010Z\u001a\u0005\bß\u0001\u0010\\\"\u0005\bà\u0001\u0010^R+\u0010á\u0001\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bá\u0001\u0010\u008f\u0001\u001a\u0006\bâ\u0001\u0010\u0091\u0001\"\u0006\bã\u0001\u0010\u0093\u0001R,\u0010å\u0001\u001a\u0005\u0018\u00010ä\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bå\u0001\u0010æ\u0001\u001a\u0006\bç\u0001\u0010è\u0001\"\u0006\bé\u0001\u0010ê\u0001R(\u0010ë\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bë\u0001\u0010\u0013\u001a\u0005\bì\u0001\u0010\u0015\"\u0005\bí\u0001\u0010*R(\u0010î\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bî\u0001\u0010\u0013\u001a\u0005\bï\u0001\u0010\u0015\"\u0005\bð\u0001\u0010*R(\u0010ñ\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bñ\u0001\u0010\u0013\u001a\u0005\bò\u0001\u0010\u0015\"\u0005\bó\u0001\u0010*R&\u0010ô\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bô\u0001\u0010\u0013\u001a\u0005\bõ\u0001\u0010\u0015\"\u0005\bö\u0001\u0010*R&\u0010÷\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b÷\u0001\u0010\u0013\u001a\u0005\bø\u0001\u0010\u0015\"\u0005\bù\u0001\u0010*R&\u0010ú\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bú\u0001\u0010\u0013\u001a\u0005\bû\u0001\u0010\u0015\"\u0005\bü\u0001\u0010*R(\u0010ý\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bý\u0001\u0010\u0013\u001a\u0005\bþ\u0001\u0010\u0015\"\u0005\bÿ\u0001\u0010*R+\u0010\u0080\u0002\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0002\u0010\u008f\u0001\u001a\u0006\b\u0081\u0002\u0010\u0091\u0001\"\u0006\b\u0082\u0002\u0010\u0093\u0001R(\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0083\u0002\u0010\u0013\u001a\u0005\b\u0084\u0002\u0010\u0015\"\u0005\b\u0085\u0002\u0010*R(\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0086\u0002\u0010\u0013\u001a\u0005\b\u0087\u0002\u0010\u0015\"\u0005\b\u0088\u0002\u0010*R+\u0010\u0089\u0002\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0089\u0002\u0010\u008f\u0001\u001a\u0006\b\u008a\u0002\u0010\u0091\u0001\"\u0006\b\u008b\u0002\u0010\u0093\u0001R(\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008c\u0002\u0010\u0013\u001a\u0005\b\u008d\u0002\u0010\u0015\"\u0005\b\u008e\u0002\u0010*R(\u0010\u008f\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008f\u0002\u0010\u0013\u001a\u0005\b\u0090\u0002\u0010\u0015\"\u0005\b\u0091\u0002\u0010*R(\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0092\u0002\u0010\u0013\u001a\u0005\b\u0093\u0002\u0010\u0015\"\u0005\b\u0094\u0002\u0010*R(\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0095\u0002\u0010\u0013\u001a\u0005\b\u0096\u0002\u0010\u0015\"\u0005\b\u0097\u0002\u0010*R\u001a\u0010\u0098\u0002\u001a\u00020\u00028\u0006¢\u0006\u000e\n\u0005\b\u0098\u0002\u0010\u0013\u001a\u0005\b\u0099\u0002\u0010\u0015R\u001a\u0010\u009a\u0002\u001a\u00020\u00028\u0006¢\u0006\u000e\n\u0005\b\u009a\u0002\u0010\u0013\u001a\u0005\b\u009b\u0002\u0010\u0015¨\u0006 \u0002"}, d2 = {"Lcom/bytedance/android/window/shop/home/ECWindowParam;", "Ljava/io/Serializable;", "", "key", "", "value", "", "putPassThroughParam", "T", "getPassThroughParam", "(Ljava/lang/String;)Ljava/lang/Object;", "", "isPreview", "Lcom/bytedance/android/window/shop/home/tab/common/WindowTabRequestParamKey;", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/TabNavigationParams;", "anchorParam", "addAnchorParam", "removeAnchorParam", "windowSessionId", "Ljava/lang/String;", "getWindowSessionId", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/window/base/common/taskgraph/PipelinePool$PipelineId;", "pipelineId", "Lcom/bytedance/android/ec/window/base/common/taskgraph/PipelinePool$PipelineId;", "getPipelineId", "()Lcom/bytedance/android/ec/window/base/common/taskgraph/PipelinePool$PipelineId;", "setPipelineId", "(Lcom/bytedance/android/ec/window/base/common/taskgraph/PipelinePool$PipelineId;)V", "statusBarDarkFont", "Z", "getStatusBarDarkFont", "()Z", "setStatusBarDarkFont", "(Z)V", "isCroppedStyle", "setCroppedStyle", "isSplitStyle", "setSplitStyle", "backUrl", "getBackUrl", "setBackUrl", "(Ljava/lang/String;)V", "isFromWindowInner", "setFromWindowInner", "", "isFromAd", "I", "()I", "setFromAd", "(I)V", "enableCommonAdTrack", "getEnableCommonAdTrack", "setEnableCommonAdTrack", "bcm", "getBcm", "setBcm", "", "passThroughParams", "Ljava/util/Map;", "getPassThroughParams", "()Ljava/util/Map;", "Lcom/bytedance/android/ec/window/base/common/param/ECWindowShareParam;", "shareInfo$delegate", "Lkotlin/Lazy;", "getShareInfo", "()Lcom/bytedance/android/ec/window/base/common/param/ECWindowShareParam;", "shareInfo", "isEcShare", "setEcShare", "shareContent", "getShareContent", "setShareContent", "shareObject", "getShareObject", "setShareObject", "productId", "getProductId", "setProductId", "isFirstFrameReported", "setFirstFrameReported", "Lcom/bytedance/android/window/shop/home/WindowMonitor;", "monitor", "Lcom/bytedance/android/window/shop/home/WindowMonitor;", "getMonitor", "()Lcom/bytedance/android/window/shop/home/WindowMonitor;", "setMonitor", "(Lcom/bytedance/android/window/shop/home/WindowMonitor;)V", "", "startGapTime", "Ljava/lang/Long;", "getStartGapTime", "()Ljava/lang/Long;", "setStartGapTime", "(Ljava/lang/Long;)V", "lifecycleMonitorId", "J", "getLifecycleMonitorId", "()J", "setLifecycleMonitorId", "(J)V", "isLuban", "setLuban", "searchParams", "getSearchParams", "setSearchParams", "enterFrom", "getEnterFrom", "setEnterFrom", "pageName", "getPageName", "tempId", "getTempId", "enterMethod", "getEnterMethod", "setEnterMethod", "entranceLocation", "getEntranceLocation", "setEntranceLocation", "preSceneType", "getPreSceneType", "setPreSceneType", "pageType", "getPageType", "Lcom/bytedance/android/ec/model/ECUrlModel;", "brandTag", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBrandTag", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "startTime", "getStartTime", "setStartTime", "headerInterfaceTime", "getHeaderInterfaceTime", "setHeaderInterfaceTime", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "adLogExtra", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "setAdLogExtra", "(Lcom/bytedance/android/ec/model/ECAdLogExtra;)V", "followStatus", "Ljava/lang/Integer;", "getFollowStatus", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "whichAccount", "getWhichAccount", "setWhichAccount", "useLynxCard", "getUseLynxCard", "setUseLynxCard", "Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "fansClubInfo", "Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "getFansClubInfo", "()Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "setFansClubInfo", "(Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;)V", "Lcom/bytedance/android/window/shop/home/ECWindowJobKeys;", "windowJobKeys", "Lcom/bytedance/android/window/shop/home/ECWindowJobKeys;", "getWindowJobKeys", "()Lcom/bytedance/android/window/shop/home/ECWindowJobKeys;", "setWindowJobKeys", "(Lcom/bytedance/android/window/shop/home/ECWindowJobKeys;)V", "forceInsertInfo", "getForceInsertInfo", "setForceInsertInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "requestParamHolder", "Ljava/util/concurrent/ConcurrentHashMap;", "", "queryParams", "getQueryParams", "setQueryParams", "(Ljava/util/Map;)V", "storeSourcePage", "getStoreSourcePage", "setStoreSourcePage", "storeSourceMethod", "getStoreSourceMethod", "setStoreSourceMethod", "storeGroupType", "getStoreGroupType", "setStoreGroupType", "liveAnchorId", "getLiveAnchorId", "sourceType", "getSourceType", "setSourceType", "hasHeaderLive", "getHasHeaderLive", "setHasHeaderLive", "isTopMode", "setTopMode", "showCouponSkeleton", "getShowCouponSkeleton", "setShowCouponSkeleton", "liveDefaultMute", "getLiveDefaultMute", "setLiveDefaultMute", "liveStyle", "getLiveStyle", "setLiveStyle", "fromProfile", "getFromProfile", "setFromProfile", "sourceProductId", "getSourceProductId", "setSourceProductId", "targetTabType", "getTargetTabType", "setTargetTabType", "targetCategory", "getTargetCategory", "setTargetCategory", "targetChildCategory", "getTargetChildCategory", "setTargetChildCategory", "targetSortType", "getTargetSortType", "setTargetSortType", "targetSort", "getTargetSort", "setTargetSort", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "targetLayoutType", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "getTargetLayoutType", "()Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "setTargetLayoutType", "(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;)V", "targetSubCategoryId", "getTargetSubCategoryId", "setTargetSubCategoryId", "tmpId", "getTmpId", "setTmpId", "token", "getToken", "setToken", "preGroupId", "getPreGroupId", "setPreGroupId", "preProductId", "getPreProductId", "setPreProductId", "preRoomId", "getPreRoomId", "setPreRoomId", "customIds", "getCustomIds", "setCustomIds", "customIdType", "getCustomIdType", "setCustomIdType", "enterStoreEvent", "getEnterStoreEvent", "setEnterStoreEvent", "extraSchema", "getExtraSchema", "setExtraSchema", "extraSchemaType", "getExtraSchemaType", "setExtraSchemaType", "entranceClassName", "getEntranceClassName", "setEntranceClassName", "ecomJsonStr", "getEcomJsonStr", "setEcomJsonStr", "ecomPitayaJsonStr", "getEcomPitayaJsonStr", "setEcomPitayaJsonStr", "btmPageId", "getBtmPageId", "setBtmPageId", "authorId", "getAuthorId", "secAuthorId", "getSecAuthorId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowParam implements Serializable {
    public static final a Companion = null;
    public static final String KEY_MODAL = "modal";
    private ECAdLogExtra adLogExtra;
    private final String authorId;
    private String backUrl;
    private String bcm;
    private final ECUrlModel brandTag;
    private String btmPageId;
    private Integer customIdType;
    private String customIds;
    private String ecomJsonStr;
    private String ecomPitayaJsonStr;
    private int enableCommonAdTrack;
    private String enterFrom;
    private String enterMethod;
    private String enterStoreEvent;
    private String entranceClassName;
    private String entranceLocation;
    private String extraSchema;
    private Integer extraSchemaType;
    private WindowFansClubInfo fansClubInfo;
    private Integer followStatus;
    private String forceInsertInfo;
    private boolean fromProfile;
    private boolean hasHeaderLive;
    private long headerInterfaceTime;
    private boolean isCroppedStyle;
    private boolean isEcShare;
    private boolean isFirstFrameReported;
    private int isFromAd;
    private boolean isFromWindowInner;
    private boolean isLuban;
    private boolean isSplitStyle;
    private boolean isTopMode;
    private long lifecycleMonitorId;
    private final String liveAnchorId;
    private boolean liveDefaultMute;
    private Integer liveStyle;
    private WindowMonitor monitor;
    private final String pageName;
    private final String pageType;
    private final Map<String, Object> passThroughParams;
    private PipelinePool.PipelineId pipelineId;
    private String preGroupId;
    private String preProductId;
    private String preRoomId;
    private String preSceneType;
    private String productId;
    private Map<String, ? extends Object> queryParams;
    private final ConcurrentHashMap<WindowTabRequestParamKey, TabNavigationParams> requestParamHolder;
    private String searchParams;
    private final String secAuthorId;
    private String shareContent;
    private final Lazy shareInfo$delegate;
    private String shareObject;
    private boolean showCouponSkeleton;
    private String sourceProductId;
    private Integer sourceType;
    private Long startGapTime;
    private long startTime;
    private boolean statusBarDarkFont;
    private String storeGroupType;
    private String storeSourceMethod;
    private String storeSourcePage;
    private String targetCategory;
    private String targetChildCategory;
    private WindowLayoutType targetLayoutType;
    private Integer targetSort;
    private Long targetSortType;
    private String targetSubCategoryId;
    private Integer targetTabType;
    private final String tempId;
    private String tmpId;
    private String token;
    private boolean useLynxCard;
    private String whichAccount;
    private ECWindowJobKeys windowJobKeys;
    private final String windowSessionId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final ECWindowShareParam getShareInfo() {
        return (ECWindowShareParam) this.shareInfo$delegate.getValue();
    }

    public final boolean isPreview() {
        if (com.bytedance.android.shopping.extensions.k.c(this.tmpId) == false) goto L5;
    L8:
        return true;
    L5:
        if (com.bytedance.android.shopping.extensions.k.c(this.token) == true) goto L8;
        return false;
    }

    public final ECAdLogExtra getAdLogExtra() {
        return this.adLogExtra;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getBackUrl() {
        return this.backUrl;
    }

    public final String getBcm() {
        return this.bcm;
    }

    public final ECUrlModel getBrandTag() {
        return this.brandTag;
    }

    public final String getBtmPageId() {
        return this.btmPageId;
    }

    public final Integer getCustomIdType() {
        return this.customIdType;
    }

    public final String getCustomIds() {
        return this.customIds;
    }

    public final String getEcomJsonStr() {
        return this.ecomJsonStr;
    }

    public final String getEcomPitayaJsonStr() {
        return this.ecomPitayaJsonStr;
    }

    public final int getEnableCommonAdTrack() {
        return this.enableCommonAdTrack;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEnterStoreEvent() {
        return this.enterStoreEvent;
    }

    public final String getEntranceClassName() {
        return this.entranceClassName;
    }

    public final String getEntranceLocation() {
        return this.entranceLocation;
    }

    public final String getExtraSchema() {
        return this.extraSchema;
    }

    public final Integer getExtraSchemaType() {
        return this.extraSchemaType;
    }

    public final WindowFansClubInfo getFansClubInfo() {
        return this.fansClubInfo;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final String getForceInsertInfo() {
        return this.forceInsertInfo;
    }

    public final boolean getFromProfile() {
        return this.fromProfile;
    }

    public final boolean getHasHeaderLive() {
        return this.hasHeaderLive;
    }

    public final long getHeaderInterfaceTime() {
        return this.headerInterfaceTime;
    }

    public final long getLifecycleMonitorId() {
        return this.lifecycleMonitorId;
    }

    public final String getLiveAnchorId() {
        return this.liveAnchorId;
    }

    public final boolean getLiveDefaultMute() {
        return this.liveDefaultMute;
    }

    public final Integer getLiveStyle() {
        return this.liveStyle;
    }

    public final WindowMonitor getMonitor() {
        return this.monitor;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final Map<String, Object> getPassThroughParams() {
        return this.passThroughParams;
    }

    public final PipelinePool.PipelineId getPipelineId() {
        return this.pipelineId;
    }

    public final String getPreGroupId() {
        return this.preGroupId;
    }

    public final String getPreProductId() {
        return this.preProductId;
    }

    public final String getPreRoomId() {
        return this.preRoomId;
    }

    public final String getPreSceneType() {
        return this.preSceneType;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Map<String, Object> getQueryParams() {
        return this.queryParams;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getShareContent() {
        return this.shareContent;
    }

    public final String getShareObject() {
        return this.shareObject;
    }

    public final boolean getShowCouponSkeleton() {
        return this.showCouponSkeleton;
    }

    public final String getSourceProductId() {
        return this.sourceProductId;
    }

    public final Integer getSourceType() {
        return this.sourceType;
    }

    public final Long getStartGapTime() {
        return this.startGapTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final boolean getStatusBarDarkFont() {
        return this.statusBarDarkFont;
    }

    public final String getStoreGroupType() {
        return this.storeGroupType;
    }

    public final String getStoreSourceMethod() {
        return this.storeSourceMethod;
    }

    public final String getStoreSourcePage() {
        return this.storeSourcePage;
    }

    public final String getTargetCategory() {
        return this.targetCategory;
    }

    public final String getTargetChildCategory() {
        return this.targetChildCategory;
    }

    public final WindowLayoutType getTargetLayoutType() {
        return this.targetLayoutType;
    }

    public final Integer getTargetSort() {
        return this.targetSort;
    }

    public final Long getTargetSortType() {
        return this.targetSortType;
    }

    public final String getTargetSubCategoryId() {
        return this.targetSubCategoryId;
    }

    public final Integer getTargetTabType() {
        return this.targetTabType;
    }

    public final String getTempId() {
        return this.tempId;
    }

    public final String getTmpId() {
        return this.tmpId;
    }

    public final String getToken() {
        return this.token;
    }

    public final boolean getUseLynxCard() {
        return this.useLynxCard;
    }

    public final String getWhichAccount() {
        return this.whichAccount;
    }

    public final ECWindowJobKeys getWindowJobKeys() {
        return this.windowJobKeys;
    }

    public final String getWindowSessionId() {
        return this.windowSessionId;
    }

    public final boolean isCroppedStyle() {
        return this.isCroppedStyle;
    }

    public final boolean isEcShare() {
        return this.isEcShare;
    }

    public final boolean isFirstFrameReported() {
        return this.isFirstFrameReported;
    }

    public final int isFromAd() {
        return this.isFromAd;
    }

    public final boolean isFromWindowInner() {
        return this.isFromWindowInner;
    }

    public final boolean isLuban() {
        return this.isLuban;
    }

    public final boolean isSplitStyle() {
        return this.isSplitStyle;
    }

    public final boolean isTopMode() {
        return this.isTopMode;
    }

    public final <T> T getPassThroughParam(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        T r3 = (T) this.passThroughParams.get(r2);
        if ((r3 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r3;
    }

    public final TabNavigationParams removeAnchorParam(WindowTabRequestParamKey r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.requestParamHolder.remove(r2);
    }

    public final void setAdLogExtra(ECAdLogExtra r1) {
        this.adLogExtra = r1;
    }

    public final void setBackUrl(String r1) {
        this.backUrl = r1;
    }

    public final void setBcm(String r1) {
        this.bcm = r1;
    }

    public final void setBtmPageId(String r1) {
        this.btmPageId = r1;
    }

    public final void setCroppedStyle(boolean r1) {
        this.isCroppedStyle = r1;
    }

    public final void setCustomIdType(Integer r1) {
        this.customIdType = r1;
    }

    public final void setCustomIds(String r1) {
        this.customIds = r1;
    }

    public final void setEcShare(boolean r1) {
        this.isEcShare = r1;
    }

    public final void setEcomJsonStr(String r1) {
        this.ecomJsonStr = r1;
    }

    public final void setEcomPitayaJsonStr(String r1) {
        this.ecomPitayaJsonStr = r1;
    }

    public final void setEnableCommonAdTrack(int r1) {
        this.enableCommonAdTrack = r1;
    }

    public final void setEnterFrom(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterFrom = r2;
    }

    public final void setEnterMethod(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterMethod = r2;
    }

    public final void setEnterStoreEvent(String r1) {
        this.enterStoreEvent = r1;
    }

    public final void setEntranceClassName(String r1) {
        this.entranceClassName = r1;
    }

    public final void setEntranceLocation(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entranceLocation = r2;
    }

    public final void setExtraSchema(String r1) {
        this.extraSchema = r1;
    }

    public final void setExtraSchemaType(Integer r1) {
        this.extraSchemaType = r1;
    }

    public final void setFansClubInfo(WindowFansClubInfo r1) {
        this.fansClubInfo = r1;
    }

    public final void setFirstFrameReported(boolean r1) {
        this.isFirstFrameReported = r1;
    }

    public final void setFollowStatus(Integer r1) {
        this.followStatus = r1;
    }

    public final void setForceInsertInfo(String r1) {
        this.forceInsertInfo = r1;
    }

    public final void setFromAd(int r1) {
        this.isFromAd = r1;
    }

    public final void setFromProfile(boolean r1) {
        this.fromProfile = r1;
    }

    public final void setFromWindowInner(boolean r1) {
        this.isFromWindowInner = r1;
    }

    public final void setHasHeaderLive(boolean r1) {
        this.hasHeaderLive = r1;
    }

    public final void setHeaderInterfaceTime(long r1) {
        this.headerInterfaceTime = r1;
    }

    public final void setLifecycleMonitorId(long r1) {
        this.lifecycleMonitorId = r1;
    }

    public final void setLiveDefaultMute(boolean r1) {
        this.liveDefaultMute = r1;
    }

    public final void setLiveStyle(Integer r1) {
        this.liveStyle = r1;
    }

    public final void setLuban(boolean r1) {
        this.isLuban = r1;
    }

    public final void setMonitor(WindowMonitor r1) {
        this.monitor = r1;
    }

    public final void setPipelineId(PipelinePool.PipelineId r1) {
        this.pipelineId = r1;
    }

    public final void setPreGroupId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.preGroupId = r2;
    }

    public final void setPreProductId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.preProductId = r2;
    }

    public final void setPreRoomId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.preRoomId = r2;
    }

    public final void setPreSceneType(String r1) {
        this.preSceneType = r1;
    }

    public final void setProductId(String r1) {
        this.productId = r1;
    }

    public final void setQueryParams(Map<String, ? extends Object> r1) {
        this.queryParams = r1;
    }

    public final void setSearchParams(String r1) {
        this.searchParams = r1;
    }

    public final void setShareContent(String r1) {
        this.shareContent = r1;
    }

    public final void setShareObject(String r1) {
        this.shareObject = r1;
    }

    public final void setShowCouponSkeleton(boolean r1) {
        this.showCouponSkeleton = r1;
    }

    public final void setSourceProductId(String r1) {
        this.sourceProductId = r1;
    }

    public final void setSourceType(Integer r1) {
        this.sourceType = r1;
    }

    public final void setSplitStyle(boolean r1) {
        this.isSplitStyle = r1;
    }

    public final void setStartGapTime(Long r1) {
        this.startGapTime = r1;
    }

    public final void setStartTime(long r1) {
        this.startTime = r1;
    }

    public final void setStatusBarDarkFont(boolean r1) {
        this.statusBarDarkFont = r1;
    }

    public final void setStoreGroupType(String r1) {
        this.storeGroupType = r1;
    }

    public final void setStoreSourceMethod(String r1) {
        this.storeSourceMethod = r1;
    }

    public final void setStoreSourcePage(String r1) {
        this.storeSourcePage = r1;
    }

    public final void setTargetCategory(String r1) {
        this.targetCategory = r1;
    }

    public final void setTargetChildCategory(String r1) {
        this.targetChildCategory = r1;
    }

    public final void setTargetLayoutType(WindowLayoutType r1) {
        this.targetLayoutType = r1;
    }

    public final void setTargetSort(Integer r1) {
        this.targetSort = r1;
    }

    public final void setTargetSortType(Long r1) {
        this.targetSortType = r1;
    }

    public final void setTargetSubCategoryId(String r1) {
        this.targetSubCategoryId = r1;
    }

    public final void setTargetTabType(Integer r1) {
        this.targetTabType = r1;
    }

    public final void setTmpId(String r1) {
        this.tmpId = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }

    public final void setTopMode(boolean r1) {
        this.isTopMode = r1;
    }

    public final void setUseLynxCard(boolean r1) {
        this.useLynxCard = r1;
    }

    public final void setWhichAccount(String r1) {
        this.whichAccount = r1;
    }

    public final void setWindowJobKeys(ECWindowJobKeys r1) {
        this.windowJobKeys = r1;
    }

    public ECWindowParam(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "authorId");
        Intrinsics.checkNotNullParameter(r3, "secAuthorId");
        this.authorId = r2;
        this.secAuthorId = r3;
        this.windowSessionId = UUID.randomUUID().toString();
        this.passThroughParams = new LinkedHashMap();
        this.shareInfo$delegate = LazyKt.lazy(ECWindowParam$shareInfo$2.INSTANCE);
        this.lifecycleMonitorId = -1;
        this.enterFrom = "open_url";
        this.pageName = "store_page";
        this.enterMethod = "click_comment";
        this.entranceLocation = "open_url";
        this.followStatus = -1;
        this.requestParamHolder = new ConcurrentHashMap();
        this.liveDefaultMute = true;
        this.preGroupId = "";
        this.preProductId = "";
        this.preRoomId = "";
    }

    public final void addAnchorParam(WindowTabRequestParamKey r2, TabNavigationParams r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "anchorParam");
        this.requestParamHolder.put(r2, r3);
    }

    public final void putPassThroughParam(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.passThroughParams.put(r2, r3);
    }
}
