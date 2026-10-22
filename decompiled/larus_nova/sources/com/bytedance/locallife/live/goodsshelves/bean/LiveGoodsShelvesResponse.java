package com.bytedance.locallife.live.goodsshelves.bean;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\by\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 º\u00012\u00020\u0001:\u0002»\u0001Bñ\u0003\u0012\b\b\u0002\u00109\u001a\u00020\u0002\u0012\b\b\u0002\u0010:\u001a\u00020\b\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010<\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010A\u001a\u00020\u0006\u0012\b\b\u0002\u0010B\u001a\u00020\u0018\u0012\b\b\u0002\u0010C\u001a\u00020\b\u0012\b\b\u0002\u0010D\u001a\u00020\u0002\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010F\u001a\u00020\b\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010 \u0012\u0018\b\u0002\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"\u0012\u0018\b\u0002\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"\u0012\u0016\b\u0002\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\u0016\b\u0002\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010(\u0012\u0016\b\u0002\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\u0016\b\u0002\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010.\u0012\u0018\b\u0002\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u000100\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u000102\u0012\u0016\b\u0002\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\b\b\u0002\u0010V\u001a\u00020\b\u0012\b\b\u0002\u0010W\u001a\u00020\b\u0012\b\b\u0002\u0010X\u001a\u00020\b\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u000107¢\u0006\u0006\b¸\u0001\u0010¹\u0001J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000b\u001a\u00020\bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fHÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fHÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0018HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0002HÆ\u0003J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003J\u0019\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"HÆ\u0003J\u0019\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"HÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"HÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010(HÆ\u0003J\u0017\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"HÆ\u0003J\u0017\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010.HÆ\u0003J\u0019\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u000100HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u000102HÆ\u0003J\u0017\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"HÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u000107HÆ\u0003Jø\u0003\u0010Z\u001a\u00020\u00002\b\b\u0002\u00109\u001a\u00020\u00022\b\b\u0002\u0010:\u001a\u00020\b2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010<\u001a\u00020\u00022\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010A\u001a\u00020\u00062\b\b\u0002\u0010B\u001a\u00020\u00182\b\b\u0002\u0010C\u001a\u00020\b2\b\b\u0002\u0010D\u001a\u00020\u00022\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010F\u001a\u00020\b2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010H\u001a\u0004\u0018\u00010 2\u0018\b\u0002\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"2\u0018\b\u0002\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"2\u0016\b\u0002\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0016\b\u0002\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010(2\u0016\b\u0002\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0016\b\u0002\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010R\u001a\u0004\u0018\u00010.2\u0018\b\u0002\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u0001002\n\b\u0002\u0010T\u001a\u0004\u0018\u0001022\u0016\b\u0002\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"2\b\b\u0002\u0010V\u001a\u00020\b2\b\b\u0002\u0010W\u001a\u00020\b2\b\b\u0002\u0010X\u001a\u00020\b2\n\b\u0002\u0010Y\u001a\u0004\u0018\u000107HÆ\u0001¢\u0006\u0004\bZ\u0010[J\t\u0010\\\u001a\u00020\u0002HÖ\u0001J\t\u0010]\u001a\u00020\bHÖ\u0001J\u0013\u0010_\u001a\u00020\u00062\b\u0010^\u001a\u0004\u0018\u00010#HÖ\u0003R\u0017\u00109\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b9\u0010`\u001a\u0004\ba\u0010bR\u0017\u0010:\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b:\u0010c\u001a\u0004\bd\u0010eR\u0019\u0010;\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b;\u0010f\u001a\u0004\bg\u0010hR\u0017\u0010<\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b<\u0010`\u001a\u0004\bi\u0010bR\u001f\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b=\u0010j\u001a\u0004\bk\u0010lR\u001f\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b>\u0010j\u001a\u0004\bm\u0010lR\u0019\u0010?\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b?\u0010n\u001a\u0004\bo\u0010pR\u0019\u0010@\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b@\u0010q\u001a\u0004\br\u0010sR\u0017\u0010A\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\bA\u0010t\u001a\u0004\bu\u0010vR\u0017\u0010B\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\bB\u0010w\u001a\u0004\bx\u0010yR\u0017\u0010C\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\bC\u0010c\u001a\u0004\bz\u0010eR\u0017\u0010D\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\bD\u0010`\u001a\u0004\b{\u0010bR\u0019\u0010E\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\bE\u0010|\u001a\u0004\b}\u0010\u001dR\u0017\u0010F\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\bF\u0010c\u001a\u0004\b~\u0010eR\u0019\u0010G\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bG\u0010`\u001a\u0004\b\u007f\u0010bR\u001c\u0010H\u001a\u0004\u0018\u00010 8\u0006¢\u0006\u000f\n\u0005\bH\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R7\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bI\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R7\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bJ\u0010\u0083\u0001\u001a\u0006\b\u0088\u0001\u0010\u0085\u0001\"\u0006\b\u0089\u0001\u0010\u0087\u0001R5\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bK\u0010\u0083\u0001\u001a\u0006\b\u008a\u0001\u0010\u0085\u0001\"\u0006\b\u008b\u0001\u0010\u0087\u0001R5\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bL\u0010\u0083\u0001\u001a\u0006\b\u008c\u0001\u0010\u0085\u0001\"\u0006\b\u008d\u0001\u0010\u0087\u0001R\u001f\u0010M\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bM\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R5\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bN\u0010\u0083\u0001\u001a\u0006\b\u0091\u0001\u0010\u0085\u0001\"\u0006\b\u0092\u0001\u0010\u0087\u0001R5\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bO\u0010\u0083\u0001\u001a\u0006\b\u0093\u0001\u0010\u0085\u0001\"\u0006\b\u0094\u0001\u0010\u0087\u0001R\u001d\u0010P\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bP\u0010`\u001a\u0005\b\u0095\u0001\u0010bR\u001d\u0010Q\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bQ\u0010`\u001a\u0005\b\u0096\u0001\u0010bR\u001c\u0010R\u001a\u0004\u0018\u00010.8\u0006¢\u0006\u000f\n\u0005\bR\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R7\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bS\u0010\u0083\u0001\u001a\u0006\b\u009a\u0001\u0010\u0085\u0001\"\u0006\b\u009b\u0001\u0010\u0087\u0001R\u001f\u0010T\u001a\u0004\u0018\u0001028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bT\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R5\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bU\u0010\u0083\u0001\u001a\u0006\b\u009f\u0001\u0010\u0085\u0001\"\u0006\b \u0001\u0010\u0087\u0001R%\u0010V\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0004\bV\u0010c\u001a\u0005\b¡\u0001\u0010e\"\u0006\b¢\u0001\u0010£\u0001R\u0014\u0010W\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bW\u0010cR\u001b\u0010X\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\r\n\u0004\bX\u0010c\u001a\u0005\b¤\u0001\u0010eR)\u0010Y\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bY\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R0\u0010«\u0001\u001a\u00020\b2\u0007\u0010ª\u0001\u001a\u00020\b8\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0005\b«\u0001\u0010c\u001a\u0005\b¬\u0001\u0010e\"\u0006\b\u00ad\u0001\u0010£\u0001R)\u0010®\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b®\u0001\u0010|\u001a\u0005\b®\u0001\u0010\u001d\"\u0006\b¯\u0001\u0010°\u0001R,\u0010²\u0001\u001a\u0005\u0018\u00010±\u00018F@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001¨\u0006¼\u0001"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesResponse;", "Ljava/io/Serializable;", "", "cardId", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesCard;", "getLiveGoodsShelvesCardByCardId", "", "hasCardData", "", "getOffset", "component1", "component2", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardBanner;", "component3", "component4", "", "component5", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardTabInfo;", "component6", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesController;", "component7", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeUserLocation;", "component8", "component9", "", "component10", "component11", "component12", "component13", "()Ljava/lang/Boolean;", "component14", "component15", "Lcom/bytedance/locallife/live/goodsshelves/bean/MemberSchema;", "component16", "", "", "component17", "component18", "component19", "component20", "Lcom/bytedance/locallife/live/goodsshelves/bean/ClientStyleConfig;", "component21", "component22", "component23", "component24", "component25", "Lcom/bytedance/locallife/live/goodsshelves/bean/ServerTimeExtra;", "component26", "", "component27", "Lcom/bytedance/locallife/live/goodsshelves/bean/RefreshConfig;", "component28", "component29", "component30", "component32", "Lcom/bytedance/locallife/live/goodsshelves/bean/l0;", "component33", "agg_card_id", "live_room_type", "card_banner", "agg_web_url", "card_list", "card_tab_info", "controller", "user_location", "degrade_switch", "server_time", "status_code", "status_msg", "hide_consult_btn", "total", "request_id", "member_schema", "lynx_topbar_data", "search_data", "extraLog", "commonSession", "clientStyleConfig", "lynxCommonData", "lynxBottomBarData", "serverExtraInfo", "version", "extra", "perfLog", "refreshConfig", "selling_point_data", "nextOffset", "offset", "selectedTabId", "parsedFeConfig", "copy", "(Ljava/lang/String;ILcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardBanner;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesController;Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeUserLocation;ZJILjava/lang/String;Ljava/lang/Boolean;ILjava/lang/String;Lcom/bytedance/locallife/live/goodsshelves/bean/MemberSchema;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/locallife/live/goodsshelves/bean/ClientStyleConfig;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/live/goodsshelves/bean/ServerTimeExtra;Ljava/util/Map;Lcom/bytedance/locallife/live/goodsshelves/bean/RefreshConfig;Ljava/util/Map;IIILcom/bytedance/locallife/live/goodsshelves/bean/l0;)Lcom/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesResponse;", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getAgg_card_id", "()Ljava/lang/String;", "I", "getLive_room_type", "()I", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardBanner;", "getCard_banner", "()Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardBanner;", "getAgg_web_url", "Ljava/util/List;", "getCard_list", "()Ljava/util/List;", "getCard_tab_info", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesController;", "getController", "()Lcom/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesController;", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeUserLocation;", "getUser_location", "()Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeUserLocation;", "Z", "getDegrade_switch", "()Z", "J", "getServer_time", "()J", "getStatus_code", "getStatus_msg", "Ljava/lang/Boolean;", "getHide_consult_btn", "getTotal", "getRequest_id", "Lcom/bytedance/locallife/live/goodsshelves/bean/MemberSchema;", "getMember_schema", "()Lcom/bytedance/locallife/live/goodsshelves/bean/MemberSchema;", "Ljava/util/Map;", "getLynx_topbar_data", "()Ljava/util/Map;", "setLynx_topbar_data", "(Ljava/util/Map;)V", "getSearch_data", "setSearch_data", "getExtraLog", "setExtraLog", "getCommonSession", "setCommonSession", "Lcom/bytedance/locallife/live/goodsshelves/bean/ClientStyleConfig;", "getClientStyleConfig", "()Lcom/bytedance/locallife/live/goodsshelves/bean/ClientStyleConfig;", "getLynxCommonData", "setLynxCommonData", "getLynxBottomBarData", "setLynxBottomBarData", "getServerExtraInfo", "getVersion", "Lcom/bytedance/locallife/live/goodsshelves/bean/ServerTimeExtra;", "getExtra", "()Lcom/bytedance/locallife/live/goodsshelves/bean/ServerTimeExtra;", "getPerfLog", "setPerfLog", "Lcom/bytedance/locallife/live/goodsshelves/bean/RefreshConfig;", "getRefreshConfig", "()Lcom/bytedance/locallife/live/goodsshelves/bean/RefreshConfig;", "getSelling_point_data", "setSelling_point_data", "getNextOffset", "setNextOffset", "(I)V", "getSelectedTabId", "Lcom/bytedance/locallife/live/goodsshelves/bean/l0;", "getParsedFeConfig", "()Lcom/bytedance/locallife/live/goodsshelves/bean/l0;", "setParsedFeConfig", "(Lcom/bytedance/locallife/live/goodsshelves/bean/l0;)V", "value", "dataType", "getDataType", "setDataType", "isTalentShowcase", "setTalentShowcase", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/locallife/live/goodsshelves/bean/LynxTopbarData;", "lynxTopbarData", "Lcom/bytedance/locallife/live/goodsshelves/bean/LynxTopbarData;", "getLynxTopbarData", "()Lcom/bytedance/locallife/live/goodsshelves/bean/LynxTopbarData;", "setLynxTopbarData", "(Lcom/bytedance/locallife/live/goodsshelves/bean/LynxTopbarData;)V", "<init>", "(Ljava/lang/String;ILcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardBanner;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesController;Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeUserLocation;ZJILjava/lang/String;Ljava/lang/Boolean;ILjava/lang/String;Lcom/bytedance/locallife/live/goodsshelves/bean/MemberSchema;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/locallife/live/goodsshelves/bean/ClientStyleConfig;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/live/goodsshelves/bean/ServerTimeExtra;Ljava/util/Map;Lcom/bytedance/locallife/live/goodsshelves/bean/RefreshConfig;Ljava/util/Map;IIILcom/bytedance/locallife/live/goodsshelves/bean/l0;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveGoodsShelvesResponse implements Serializable {
    public static final a Companion = null;
    public static final int DATA_TYPE_CACHE = 2;
    public static final String POI_DETAIL_ADDRESS = "poi_detail_address";
    public static final String POI_DISTANCE = "poi_distance";
    public static final String POI_PROVINCE = "poi_province";
    public static final String POI_TAG = "poi_tag";
    public static final int TOP_BAR_TYPE_DEFAULT = 0;
    public static final int TOP_BAR_TYPE_GROUPON_RECOMMEND = 2;
    public static final int TOP_BAR_TYPE_SINGLE_STORE = 1;
    public static final String VERSION_V1 = "v1";
    public static final String VERSION_V2 = "v2";
    private final String agg_card_id;
    private final String agg_web_url;
    private final LiveLocalLifeCardBanner card_banner;
    private final List<LiveGoodsShelvesCard> card_list;
    private final List<LiveLocalLifeCardTabInfo> card_tab_info;

    @SerializedName("client_style_config")
    private final ClientStyleConfig clientStyleConfig;

    @SerializedName("common_session")
    private Map<String, ? extends Object> commonSession;
    private final LiveGoodsShelvesController controller;
    private int dataType;
    private final boolean degrade_switch;
    private final ServerTimeExtra extra;

    @SerializedName("extra_log")
    private Map<String, ? extends Object> extraLog;
    private final Boolean hide_consult_btn;
    private Boolean isTalentShowcase;
    private final int live_room_type;

    @SerializedName("lynx_bottom_bar_data")
    private Map<String, ? extends Object> lynxBottomBarData;

    @SerializedName("lynx_common_data")
    private Map<String, ? extends Object> lynxCommonData;
    private LynxTopbarData lynxTopbarData;
    private Map<String, ? extends Object> lynx_topbar_data;
    private final MemberSchema member_schema;

    @SerializedName("next_offset")
    private int nextOffset;

    @SerializedName("offset")
    private final int offset;
    private l0 parsedFeConfig;

    @SerializedName("perf_log")
    private Map<String, Object> perfLog;

    @SerializedName("refresh_config")
    private final RefreshConfig refreshConfig;
    private final String request_id;
    private Map<String, ? extends Object> search_data;

    @SerializedName("selected_tab_id")
    private final int selectedTabId;

    @SerializedName("selling_point_data")
    private Map<String, ? extends Object> selling_point_data;

    @SerializedName("server_extra_info")
    private final String serverExtraInfo;
    private final long server_time;
    private final int status_code;
    private final String status_msg;
    private final int total;
    private final LiveLocalLifeUserLocation user_location;

    @SerializedName("version")
    private final String version;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LiveGoodsShelvesResponse() {
        this(null, 0, null, null, null, null, null, null, false, 0, 0, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, null, -1, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveGoodsShelvesResponse copy$default(LiveGoodsShelvesResponse r110, String r111, int r112, LiveLocalLifeCardBanner r210, String r211, List r212, List r213, LiveGoodsShelvesController r214, LiveLocalLifeUserLocation r215, boolean r216, long r217, int r218, String r310, Boolean r311, int r312, String r313, MemberSchema r314, Map r315, Map r316, Map r317, Map r318, ClientStyleConfig r319, Map r410, Map r411, String r412, String r413, ServerTimeExtra r414, Map r415, RefreshConfig r416, Map r417, int r418, int r419, int r510, l0 r511, int r512, int r513, Object r514) {
        if ((r512 & 1) == 0) goto L5;
        String r100 = r110.agg_card_id;
    L7:
        if ((r512 & 2) == 0) goto L9;
        int r101 = r110.live_room_type;
    L11:
        if ((r512 & 4) == 0) goto L13;
        LiveLocalLifeCardBanner r102 = r110.card_banner;
    L15:
        if ((r512 & 8) == 0) goto L17;
        String r103 = r110.agg_web_url;
    L19:
        if ((r512 & 16) == 0) goto L21;
        List r104 = r110.card_list;
    L23:
        if ((r512 & 32) == 0) goto L25;
        List r105 = r110.card_tab_info;
    L27:
        if ((r512 & 64) == 0) goto L29;
        LiveGoodsShelvesController r106 = r110.controller;
    L31:
        if ((r512 & 128) == 0) goto L33;
        LiveLocalLifeUserLocation r107 = r110.user_location;
    L35:
        if ((r512 & 256) == 0) goto L37;
        boolean r113 = r110.degrade_switch;
    L39:
        if ((r512 & 512) == 0) goto L41;
        long r114 = r110.server_time;
    L43:
        if ((r512 & 1024) == 0) goto L45;
        int r115 = r110.status_code;
    L47:
        if ((r512 & 2048) == 0) goto L49;
        String r116 = r110.status_msg;
    L51:
        if ((r512 & 4096) == 0) goto L53;
        Boolean r117 = r110.hide_consult_btn;
    L54:
        Boolean r320 = r117;
        if ((r512 & 8192) == 0) goto L57;
        int r118 = r110.total;
    L58:
        int r321 = r118;
        if ((r512 & 16384) == 0) goto L61;
        String r119 = r110.request_id;
    L62:
        String r322 = r119;
        if ((r512 & 32768) == 0) goto L65;
        MemberSchema r120 = r110.member_schema;
    L66:
        MemberSchema r323 = r120;
        if ((r512 & 65536) == 0) goto L69;
        Map r121 = r110.lynx_topbar_data;
    L70:
        Map r324 = r121;
        if ((r512 & 131072) == 0) goto L73;
        Map r122 = r110.search_data;
    L74:
        Map r325 = r122;
        if ((r512 & 262144) == 0) goto L77;
        Map r123 = r110.extraLog;
    L78:
        Map r326 = r123;
        if ((r512 & 524288) == 0) goto L81;
        Map r124 = r110.commonSession;
    L82:
        Map r327 = r124;
        if ((r512 & 1048576) == 0) goto L85;
        ClientStyleConfig r125 = r110.clientStyleConfig;
    L86:
        ClientStyleConfig r328 = r125;
        if ((r512 & 2097152) == 0) goto L89;
        Map r126 = r110.lynxCommonData;
    L90:
        Map r420 = r126;
        if ((r512 & 4194304) == 0) goto L93;
        Map r127 = r110.lynxBottomBarData;
    L94:
        Map r421 = r127;
        if ((r512 & 8388608) == 0) goto L97;
        String r128 = r110.serverExtraInfo;
    L98:
        String r422 = r128;
        if ((r512 & 16777216) == 0) goto L101;
        String r129 = r110.version;
    L102:
        String r423 = r129;
        if ((r512 & 33554432) == 0) goto L105;
        ServerTimeExtra r130 = r110.extra;
    L106:
        ServerTimeExtra r424 = r130;
        if ((r512 & 67108864) == 0) goto L109;
        Map r131 = r110.perfLog;
    L110:
        Map r425 = r131;
        if ((r512 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        RefreshConfig r132 = r110.refreshConfig;
    L114:
        RefreshConfig r426 = r132;
        if ((r512 & 268435456) == 0) goto L117;
        Map r133 = r110.selling_point_data;
    L118:
        Map r427 = r133;
        if ((r512 & 536870912) == 0) goto L121;
        int r134 = r110.nextOffset;
    L122:
        int r428 = r134;
        if ((r512 & 1073741824) == 0) goto L125;
        int r135 = r110.offset;
    L127:
        if ((r512 & Integer.MIN_VALUE) == 0) goto L129;
        int r108 = r110.selectedTabId;
    L130:
        int r515 = r108;
        if ((r513 & 1) == 0) goto L133;
        l0 r109 = r110.parsedFeConfig;
    L135:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r426, r427, r428, r135, r515, r109);
    L133:
        r109 = r511;
        goto L135
    L129:
        r108 = r510;
        goto L130
    L125:
        r135 = r419;
        goto L127
    L121:
        r134 = r418;
        goto L122
    L117:
        r133 = r417;
        goto L118
    L113:
        r132 = r416;
        goto L114
    L109:
        r131 = r415;
        goto L110
    L105:
        r130 = r414;
        goto L106
    L101:
        r129 = r413;
        goto L102
    L97:
        r128 = r412;
        goto L98
    L93:
        r127 = r411;
        goto L94
    L89:
        r126 = r410;
        goto L90
    L85:
        r125 = r319;
        goto L86
    L81:
        r124 = r318;
        goto L82
    L77:
        r123 = r317;
        goto L78
    L73:
        r122 = r316;
        goto L74
    L69:
        r121 = r315;
        goto L70
    L65:
        r120 = r314;
        goto L66
    L61:
        r119 = r313;
        goto L62
    L57:
        r118 = r312;
        goto L58
    L53:
        r117 = r311;
        goto L54
    L49:
        r116 = r310;
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

    public final String component1() {
        return this.agg_card_id;
    }

    public final long component10() {
        return this.server_time;
    }

    public final int component11() {
        return this.status_code;
    }

    public final String component12() {
        return this.status_msg;
    }

    public final Boolean component13() {
        return this.hide_consult_btn;
    }

    public final int component14() {
        return this.total;
    }

    public final String component15() {
        return this.request_id;
    }

    public final MemberSchema component16() {
        return this.member_schema;
    }

    public final Map<String, Object> component17() {
        return this.lynx_topbar_data;
    }

    public final Map<String, Object> component18() {
        return this.search_data;
    }

    public final Map<String, Object> component19() {
        return this.extraLog;
    }

    public final int component2() {
        return this.live_room_type;
    }

    public final Map<String, Object> component20() {
        return this.commonSession;
    }

    public final ClientStyleConfig component21() {
        return this.clientStyleConfig;
    }

    public final Map<String, Object> component22() {
        return this.lynxCommonData;
    }

    public final Map<String, Object> component23() {
        return this.lynxBottomBarData;
    }

    public final String component24() {
        return this.serverExtraInfo;
    }

    public final String component25() {
        return this.version;
    }

    public final ServerTimeExtra component26() {
        return this.extra;
    }

    public final Map<String, Object> component27() {
        return this.perfLog;
    }

    public final RefreshConfig component28() {
        return this.refreshConfig;
    }

    public final Map<String, Object> component29() {
        return this.selling_point_data;
    }

    public final LiveLocalLifeCardBanner component3() {
        return this.card_banner;
    }

    public final int component30() {
        return this.nextOffset;
    }

    public final int component32() {
        return this.selectedTabId;
    }

    public final l0 component33() {
        return this.parsedFeConfig;
    }

    public final String component4() {
        return this.agg_web_url;
    }

    public final List<LiveGoodsShelvesCard> component5() {
        return this.card_list;
    }

    public final List<LiveLocalLifeCardTabInfo> component6() {
        return this.card_tab_info;
    }

    public final LiveGoodsShelvesController component7() {
        return this.controller;
    }

    public final LiveLocalLifeUserLocation component8() {
        return this.user_location;
    }

    public final boolean component9() {
        return this.degrade_switch;
    }

    public final LiveGoodsShelvesResponse copy(String r310, int r311, LiveLocalLifeCardBanner r410, String r411, List<LiveGoodsShelvesCard> r412, List<LiveLocalLifeCardTabInfo> r413, LiveGoodsShelvesController r414, LiveLocalLifeUserLocation r415, boolean r416, long r417, int r418, String r510, Boolean r511, int r512, String r513, MemberSchema r514, Map<String, ? extends Object> r515, Map<String, ? extends Object> r516, Map<String, ? extends Object> r517, Map<String, ? extends Object> r518, ClientStyleConfig r519, Map<String, ? extends Object> r610, Map<String, ? extends Object> r611, String r612, String r613, ServerTimeExtra r614, Map<String, Object> r615, RefreshConfig r616, Map<String, ? extends Object> r617, int r618, int r619, int r710, l0 r711) {
        Intrinsics.checkNotNullParameter(r310, "agg_card_id");
        Intrinsics.checkNotNullParameter(r411, "agg_web_url");
        Intrinsics.checkNotNullParameter(r510, "status_msg");
        return new LiveGoodsShelvesResponse(r310, r311, r410, r411, r412, r413, r414, r415, r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveGoodsShelvesResponse) == true) goto L8;
        return false;
    L8:
        LiveGoodsShelvesResponse r101 = (LiveGoodsShelvesResponse) r100;
        if (Intrinsics.areEqual(this.agg_card_id, r101.agg_card_id) == true) goto L12;
        return false;
    L12:
        if (this.live_room_type == r101.live_room_type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.card_banner, r101.card_banner) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.agg_web_url, r101.agg_web_url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.card_list, r101.card_list) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.card_tab_info, r101.card_tab_info) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.controller, r101.controller) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.user_location, r101.user_location) == true) goto L33;
        return false;
    L33:
        if (this.degrade_switch == r101.degrade_switch) goto L36;
        return false;
    L36:
        if (this.server_time == r101.server_time) goto L39;
        return false;
    L39:
        if (this.status_code == r101.status_code) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.status_msg, r101.status_msg) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.hide_consult_btn, r101.hide_consult_btn) == true) goto L48;
        return false;
    L48:
        if (this.total == r101.total) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.request_id, r101.request_id) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.member_schema, r101.member_schema) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.lynx_topbar_data, r101.lynx_topbar_data) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.search_data, r101.search_data) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.extraLog, r101.extraLog) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.commonSession, r101.commonSession) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.clientStyleConfig, r101.clientStyleConfig) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.lynxCommonData, r101.lynxCommonData) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.lynxBottomBarData, r101.lynxBottomBarData) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.serverExtraInfo, r101.serverExtraInfo) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.perfLog, r101.perfLog) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.refreshConfig, r101.refreshConfig) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.selling_point_data, r101.selling_point_data) == true) goto L96;
        return false;
    L96:
        if (this.nextOffset == r101.nextOffset) goto L99;
        return false;
    L99:
        if (this.offset == r101.offset) goto L102;
        return false;
    L102:
        if (this.selectedTabId == r101.selectedTabId) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.parsedFeConfig, r101.parsedFeConfig) == true) goto L107;
        return false;
    L107:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.agg_card_id.hashCode() * 31) + this.live_room_type) * 31;
        LiveLocalLifeCardBanner r101 = this.card_banner;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.agg_web_url.hashCode()) * 31;
        List<LiveGoodsShelvesCard> r105 = this.card_list;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        List<LiveLocalLifeCardTabInfo> r108 = this.card_tab_info;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        LiveGoodsShelvesController r111 = this.controller;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        LiveLocalLifeUserLocation r114 = this.user_location;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.degrade_switch == false) goto L25;
        int r117 = 1231;
    L26:
        long r118 = this.server_time;
        int r119 = (((((((r116 + r117) * 31) + ((int) (r118 ^ (r118 >>> 32)))) * 31) + this.status_code) * 31) + this.status_msg.hashCode()) * 31;
        Boolean r120 = this.hide_consult_btn;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (((r119 + r121) * 31) + this.total) * 31;
        String r123 = this.request_id;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        MemberSchema r126 = this.member_schema;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        Map<String, ? extends Object> r129 = this.lynx_topbar_data;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        Map<String, ? extends Object> r132 = this.search_data;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        Map<String, ? extends Object> r135 = this.extraLog;
        if (r135 != null) goto L49;
        int r136 = 0;
    L50:
        int r137 = (r134 + r136) * 31;
        Map<String, ? extends Object> r138 = this.commonSession;
        if (r138 != null) goto L53;
        int r139 = 0;
    L54:
        int r140 = (r137 + r139) * 31;
        ClientStyleConfig r141 = this.clientStyleConfig;
        if (r141 != null) goto L57;
        int r142 = 0;
    L58:
        int r143 = (r140 + r142) * 31;
        Map<String, ? extends Object> r144 = this.lynxCommonData;
        if (r144 != null) goto L61;
        int r145 = 0;
    L62:
        int r146 = (r143 + r145) * 31;
        Map<String, ? extends Object> r147 = this.lynxBottomBarData;
        if (r147 != null) goto L65;
        int r148 = 0;
    L66:
        int r149 = (r146 + r148) * 31;
        String r150 = this.serverExtraInfo;
        if (r150 != null) goto L69;
        int r151 = 0;
    L70:
        int r152 = (r149 + r151) * 31;
        String r153 = this.version;
        if (r153 != null) goto L73;
        int r154 = 0;
    L74:
        int r155 = (r152 + r154) * 31;
        ServerTimeExtra r156 = this.extra;
        if (r156 != null) goto L77;
        int r157 = 0;
    L78:
        int r158 = (r155 + r157) * 31;
        Map<String, Object> r159 = this.perfLog;
        if (r159 != null) goto L81;
        int r160 = 0;
    L82:
        int r161 = (r158 + r160) * 31;
        RefreshConfig r162 = this.refreshConfig;
        if (r162 != null) goto L85;
        int r163 = 0;
    L86:
        int r164 = (r161 + r163) * 31;
        Map<String, ? extends Object> r165 = this.selling_point_data;
        if (r165 != null) goto L89;
        int r166 = 0;
    L90:
        int r167 = (((((((r164 + r166) * 31) + this.nextOffset) * 31) + this.offset) * 31) + this.selectedTabId) * 31;
        l0 r168 = this.parsedFeConfig;
        if (r168 == null) goto L95;
        r102 = r168.hashCode();
    L95:
        return r167 + r102;
    L89:
        r166 = r165.hashCode();
        goto L90
    L85:
        r163 = r162.hashCode();
        goto L86
    L81:
        r160 = r159.hashCode();
        goto L82
    L77:
        r157 = r156.hashCode();
        goto L78
    L73:
        r154 = r153.hashCode();
        goto L74
    L69:
        r151 = r150.hashCode();
        goto L70
    L65:
        r148 = r147.hashCode();
        goto L66
    L61:
        r145 = r144.hashCode();
        goto L62
    L57:
        r142 = r141.hashCode();
        goto L58
    L53:
        r139 = r138.hashCode();
        goto L54
    L49:
        r136 = r135.hashCode();
        goto L50
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r117 = 1237;
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "LiveGoodsShelvesResponse(agg_card_id=" + this.agg_card_id + ", live_room_type=" + this.live_room_type + ", card_banner=" + this.card_banner + ", agg_web_url=" + this.agg_web_url + ", card_list=" + this.card_list + ", card_tab_info=" + this.card_tab_info + ", controller=" + this.controller + ", user_location=" + this.user_location + ", degrade_switch=" + this.degrade_switch + ", server_time=" + this.server_time + ", status_code=" + this.status_code + ", status_msg=" + this.status_msg + ", hide_consult_btn=" + this.hide_consult_btn + ", total=" + this.total + ", request_id=" + this.request_id + ", member_schema=" + this.member_schema + ", lynx_topbar_data=" + this.lynx_topbar_data + ", search_data=" + this.search_data + ", extraLog=" + this.extraLog + ", commonSession=" + this.commonSession + ", clientStyleConfig=" + this.clientStyleConfig + ", lynxCommonData=" + this.lynxCommonData + ", lynxBottomBarData=" + this.lynxBottomBarData + ", serverExtraInfo=" + this.serverExtraInfo + ", version=" + this.version + ", extra=" + this.extra + ", perfLog=" + this.perfLog + ", refreshConfig=" + this.refreshConfig + ", selling_point_data=" + this.selling_point_data + ", nextOffset=" + this.nextOffset + ", offset=" + this.offset + ", selectedTabId=" + this.selectedTabId + ", parsedFeConfig=" + this.parsedFeConfig + ')';
    }

    public final LynxTopbarData getLynxTopbarData() {
        if (this.lynxTopbarData != null) goto L9;
        if (this.lynx_topbar_data == null) goto L9;
        Gson r100 = LiveLifeSaaSUtil.r();
        this.lynxTopbarData = (LynxTopbarData) r100.fromJson(r100.toJsonTree(this.lynx_topbar_data), LynxTopbarData.class);     // Catch: Exception -> L10
    L9:
        return this.lynxTopbarData;
    }

    public final int getOffset() {
        int r100 = this.offset;
        if (r100 >= 0) goto L6;
        return 0;
    L6:
        return r100;
    }

    public final boolean hasCardData() {
        List<LiveGoodsShelvesCard> r100 = this.card_list;
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((!r100.isEmpty()) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final String getAgg_card_id() {
        return this.agg_card_id;
    }

    public final String getAgg_web_url() {
        return this.agg_web_url;
    }

    public final LiveLocalLifeCardBanner getCard_banner() {
        return this.card_banner;
    }

    public final List<LiveGoodsShelvesCard> getCard_list() {
        return this.card_list;
    }

    public final List<LiveLocalLifeCardTabInfo> getCard_tab_info() {
        return this.card_tab_info;
    }

    public final ClientStyleConfig getClientStyleConfig() {
        return this.clientStyleConfig;
    }

    public final Map<String, Object> getCommonSession() {
        return this.commonSession;
    }

    public final LiveGoodsShelvesController getController() {
        return this.controller;
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final boolean getDegrade_switch() {
        return this.degrade_switch;
    }

    public final ServerTimeExtra getExtra() {
        return this.extra;
    }

    public final Map<String, Object> getExtraLog() {
        return this.extraLog;
    }

    public final Boolean getHide_consult_btn() {
        return this.hide_consult_btn;
    }

    public final int getLive_room_type() {
        return this.live_room_type;
    }

    public final Map<String, Object> getLynxBottomBarData() {
        return this.lynxBottomBarData;
    }

    public final Map<String, Object> getLynxCommonData() {
        return this.lynxCommonData;
    }

    public final Map<String, Object> getLynx_topbar_data() {
        return this.lynx_topbar_data;
    }

    public final MemberSchema getMember_schema() {
        return this.member_schema;
    }

    public final int getNextOffset() {
        return this.nextOffset;
    }

    public final l0 getParsedFeConfig() {
        return this.parsedFeConfig;
    }

    public final Map<String, Object> getPerfLog() {
        return this.perfLog;
    }

    public final RefreshConfig getRefreshConfig() {
        return this.refreshConfig;
    }

    public final String getRequest_id() {
        return this.request_id;
    }

    public final Map<String, Object> getSearch_data() {
        return this.search_data;
    }

    public final int getSelectedTabId() {
        return this.selectedTabId;
    }

    public final Map<String, Object> getSelling_point_data() {
        return this.selling_point_data;
    }

    public final String getServerExtraInfo() {
        return this.serverExtraInfo;
    }

    public final long getServer_time() {
        return this.server_time;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    public final String getStatus_msg() {
        return this.status_msg;
    }

    public final int getTotal() {
        return this.total;
    }

    public final LiveLocalLifeUserLocation getUser_location() {
        return this.user_location;
    }

    public final String getVersion() {
        return this.version;
    }

    public final Boolean isTalentShowcase() {
        return this.isTalentShowcase;
    }

    public final LiveGoodsShelvesCard getLiveGoodsShelvesCardByCardId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cardId");
        List<LiveGoodsShelvesCard> r101 = this.card_list;
        Object r102 = null;
        if (r101 == null) goto L15;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((LiveGoodsShelvesCard) r104).getCardId(), r100) == false) goto L6;
        r102 = r104;
    L11:
        return (LiveGoodsShelvesCard) r102;
    L15:
        return null;
    }

    public final void setCommonSession(Map<String, ? extends Object> r100) {
        this.commonSession = r100;
    }

    public final void setDataType(int r100) {
        if (r100 != 1) goto L5;
    L9:
        r100 = 1;
    L10:
        this.dataType = r100;
        return;
    L5:
        if (r100 == 3) goto L9;
        if (r100 == 4) goto L9;
        goto L9
    }

    public final void setExtraLog(Map<String, ? extends Object> r100) {
        this.extraLog = r100;
    }

    public final void setLynxBottomBarData(Map<String, ? extends Object> r100) {
        this.lynxBottomBarData = r100;
    }

    public final void setLynxCommonData(Map<String, ? extends Object> r100) {
        this.lynxCommonData = r100;
    }

    public final void setLynxTopbarData(LynxTopbarData r100) {
        this.lynxTopbarData = r100;
    }

    public final void setLynx_topbar_data(Map<String, ? extends Object> r100) {
        this.lynx_topbar_data = r100;
    }

    public final void setNextOffset(int r100) {
        this.nextOffset = r100;
    }

    public final void setParsedFeConfig(l0 r100) {
        this.parsedFeConfig = r100;
    }

    public final void setPerfLog(Map<String, Object> r100) {
        this.perfLog = r100;
    }

    public final void setSearch_data(Map<String, ? extends Object> r100) {
        this.search_data = r100;
    }

    public final void setSelling_point_data(Map<String, ? extends Object> r100) {
        this.selling_point_data = r100;
    }

    public final void setTalentShowcase(Boolean r100) {
        this.isTalentShowcase = r100;
    }

    public LiveGoodsShelvesResponse(String r100, int r101, LiveLocalLifeCardBanner r102, String r103, List<LiveGoodsShelvesCard> r110, List<LiveLocalLifeCardTabInfo> r111, LiveGoodsShelvesController r112, LiveLocalLifeUserLocation r113, boolean r114, long r115, int r116, String r117, Boolean r118, int r210, String r211, MemberSchema r212, Map<String, ? extends Object> r213, Map<String, ? extends Object> r214, Map<String, ? extends Object> r215, Map<String, ? extends Object> r216, ClientStyleConfig r217, Map<String, ? extends Object> r218, Map<String, ? extends Object> r219, String r310, String r311, ServerTimeExtra r312, Map<String, Object> r313, RefreshConfig r314, Map<String, ? extends Object> r315, int r316, int r317, int r318, l0 r319) {
        Intrinsics.checkNotNullParameter(r100, "agg_card_id");
        Intrinsics.checkNotNullParameter(r103, "agg_web_url");
        Intrinsics.checkNotNullParameter(r117, "status_msg");
        this.agg_card_id = r100;
        this.live_room_type = r101;
        this.card_banner = r102;
        this.agg_web_url = r103;
        this.card_list = r110;
        this.card_tab_info = r111;
        this.controller = r112;
        this.user_location = r113;
        this.degrade_switch = r114;
        this.server_time = r115;
        this.status_code = r116;
        this.status_msg = r117;
        this.hide_consult_btn = r118;
        this.total = r210;
        this.request_id = r211;
        this.member_schema = r212;
        this.lynx_topbar_data = r213;
        this.search_data = r214;
        this.extraLog = r215;
        this.commonSession = r216;
        this.clientStyleConfig = r217;
        this.lynxCommonData = r218;
        this.lynxBottomBarData = r219;
        this.serverExtraInfo = r310;
        this.version = r311;
        this.extra = r312;
        this.perfLog = r313;
        this.refreshConfig = r314;
        this.selling_point_data = r315;
        this.nextOffset = r316;
        this.offset = r317;
        this.selectedTabId = r318;
        this.parsedFeConfig = r319;
        this.dataType = -1;
        this.isTalentShowcase = Boolean.FALSE;
    }

    public /* synthetic */ LiveGoodsShelvesResponse(String r310, int r311, LiveLocalLifeCardBanner r312, String r313, List r314, List r315, LiveGoodsShelvesController r410, LiveLocalLifeUserLocation r411, boolean r412, long r413, int r414, String r415, Boolean r416, int r417, String r418, MemberSchema r510, Map r511, Map r512, Map r513, Map r514, ClientStyleConfig r515, Map r516, Map r517, String r518, String r519, ServerTimeExtra r610, Map r611, RefreshConfig r612, Map r613, int r614, int r615, int r616, l0 r617, int r618, int r619, DefaultConstructorMarker r710) {
        String r100 = "";
        if ((r618 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r618 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r618 & 4) == 0) goto L13;
        LiveLocalLifeCardBanner r103 = null;
    L15:
        if ((r618 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r618 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r618 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r618 & 64) == 0) goto L29;
        LiveGoodsShelvesController r110 = null;
    L31:
        if ((r618 & 128) == 0) goto L33;
        LiveLocalLifeUserLocation r111 = null;
    L35:
        if ((r618 & 256) == 0) goto L37;
        boolean r112 = false;
    L39:
        if ((r618 & 512) == 0) goto L41;
        long r113 = 0;
    L43:
        if ((r618 & 1024) == 0) goto L45;
        int r114 = 0;
    L47:
        if ((r618 & 2048) != 0) goto L51;
        r100 = r415;
    L51:
        if ((r618 & 4096) == 0) goto L53;
        Boolean r107 = null;
    L55:
        if ((r618 & 8192) == 0) goto L57;
        int r108 = 0;
    L58:
        int r711 = r108;
        if ((r618 & 16384) == 0) goto L61;
        String r109 = null;
    L63:
        if ((r618 & 32768) == 0) goto L65;
        MemberSchema r115 = null;
    L67:
        if ((r618 & 65536) == 0) goto L69;
        Map r116 = null;
    L71:
        if ((r618 & 131072) == 0) goto L73;
        Map r117 = null;
    L75:
        if ((r618 & 262144) == 0) goto L77;
        Map r118 = null;
    L79:
        if ((r618 & 524288) == 0) goto L81;
        Map r210 = null;
    L83:
        if ((r618 & 1048576) == 0) goto L85;
        ClientStyleConfig r211 = null;
    L87:
        if ((r618 & 2097152) == 0) goto L89;
        Map r212 = null;
    L91:
        if ((r618 & 4194304) == 0) goto L93;
        Map r213 = null;
    L95:
        if ((r618 & 8388608) == 0) goto L97;
        String r214 = null;
    L99:
        if ((r618 & 16777216) == 0) goto L101;
        String r215 = null;
    L103:
        if ((r618 & 33554432) == 0) goto L105;
        ServerTimeExtra r216 = null;
    L107:
        if ((r618 & 67108864) == 0) goto L109;
        Map r217 = null;
    L111:
        if ((r618 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        RefreshConfig r218 = null;
    L115:
        if ((r618 & 268435456) == 0) goto L117;
        Map r219 = null;
    L119:
        if ((r618 & 536870912) == 0) goto L121;
        int r316 = 0;
    L123:
        if ((r618 & 1073741824) == 0) goto L125;
        int r317 = 0;
    L127:
        if ((r618 & Integer.MIN_VALUE) == 0) goto L129;
        int r119 = 0;
    L131:
        if ((r619 & 1) == 0) goto L133;
        l0 r318 = null;
    L134:
        this(r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r100, r107, r711, r109, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r316, r317, r119, r318);
        return;
    L133:
        r318 = r617;
        goto L134
    L129:
        r119 = r616;
        goto L131
    L125:
        r317 = r615;
        goto L127
    L121:
        r316 = r614;
        goto L123
    L117:
        r219 = r613;
        goto L119
    L113:
        r218 = r612;
        goto L115
    L109:
        r217 = r611;
        goto L111
    L105:
        r216 = r610;
        goto L107
    L101:
        r215 = r519;
        goto L103
    L97:
        r214 = r518;
        goto L99
    L93:
        r213 = r517;
        goto L95
    L89:
        r212 = r516;
        goto L91
    L85:
        r211 = r515;
        goto L87
    L81:
        r210 = r514;
        goto L83
    L77:
        r118 = r513;
        goto L79
    L73:
        r117 = r512;
        goto L75
    L69:
        r116 = r511;
        goto L71
    L65:
        r115 = r510;
        goto L67
    L61:
        r109 = r418;
        goto L63
    L57:
        r108 = r417;
        goto L58
    L53:
        r107 = r416;
        goto L55
    L45:
        r114 = r414;
        goto L47
    L41:
        r113 = r413;
        goto L43
    L37:
        r112 = r412;
        goto L39
    L33:
        r111 = r411;
        goto L35
    L29:
        r110 = r410;
        goto L31
    L25:
        r106 = r315;
        goto L27
    L21:
        r105 = r314;
        goto L23
    L17:
        r104 = r313;
        goto L19
    L13:
        r103 = r312;
        goto L15
    L9:
        r102 = r311;
        goto L11
    L5:
        r101 = r310;
        goto L7
    }
}
