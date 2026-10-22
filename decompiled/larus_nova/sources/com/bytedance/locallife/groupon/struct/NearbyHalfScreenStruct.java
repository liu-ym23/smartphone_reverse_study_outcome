package com.bytedance.locallife.groupon.struct;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0003\b\u0085\u0001\b\u0087\b\u0018\u0000 ®\u00012\u00020\u0001:\u0002¯\u0001B\u008d\u0003\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00109\u001a\u00020\u0002\u0012\b\b\u0002\u0010:\u001a\u00020\u0006\u0012\b\b\u0002\u0010;\u001a\u00020\u0002\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010=\u001a\u00020\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010?\u001a\u00020\u0017\u0012\b\b\u0002\u0010@\u001a\u00020\u0017\u0012\b\b\u0002\u0010A\u001a\u00020\u0017\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u001f\u0012\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010+\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0017¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\t\u0010\u0011\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0002HÆ\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\nJ\t\u0010\u0018\u001a\u00020\u0017HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0017HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0017HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!HÆ\u0003J\u0012\u0010#\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\nJ\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\nJ\u000b\u0010(\u001a\u0004\u0018\u00010'HÆ\u0003J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010\nJ\u0012\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010\nJ\u0017\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010+HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\nJ\u0012\u0010/\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b/\u0010$J\u0094\u0003\u0010P\u001a\u00020\u00002\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00109\u001a\u00020\u00022\b\b\u0002\u0010:\u001a\u00020\u00062\b\b\u0002\u0010;\u001a\u00020\u00022\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010=\u001a\u00020\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010?\u001a\u00020\u00172\b\b\u0002\u0010@\u001a\u00020\u00172\b\b\u0002\u0010A\u001a\u00020\u00172\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u001f2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010I\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010+2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0004\bP\u0010QJ\t\u0010R\u001a\u00020\u0006HÖ\u0001J\t\u0010S\u001a\u00020\u0002HÖ\u0001J\u0013\u0010U\u001a\u00020\u00172\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u00100\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u00101\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010V\u001a\u0004\b[\u0010X\"\u0004\b\\\u0010ZR$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010]\u001a\u0004\b^\u0010\n\"\u0004\b_\u0010`R$\u00103\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010]\u001a\u0004\ba\u0010\n\"\u0004\bb\u0010`R$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010]\u001a\u0004\bc\u0010\n\"\u0004\bd\u0010`R$\u00105\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010V\u001a\u0004\be\u0010X\"\u0004\bf\u0010ZR$\u00106\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010]\u001a\u0004\bg\u0010\n\"\u0004\bh\u0010`R$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010]\u001a\u0004\bi\u0010\n\"\u0004\bj\u0010`R$\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010]\u001a\u0004\bk\u0010\n\"\u0004\bl\u0010`R\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010:\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010V\u001a\u0004\br\u0010X\"\u0004\bs\u0010ZR(\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b;\u0010m\u0012\u0004\bv\u0010w\u001a\u0004\bt\u0010o\"\u0004\bu\u0010qR\u001c\u0010<\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010V\u001a\u0004\bx\u0010XR\u001a\u0010=\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010m\u001a\u0004\by\u0010oR\u001c\u0010>\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010]\u001a\u0004\bz\u0010\nR\u001a\u0010?\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010{\u001a\u0004\b|\u0010}R\u001a\u0010@\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010{\u001a\u0004\b~\u0010}R\u001a\u0010A\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010{\u001a\u0004\b\u007f\u0010}R\u001f\u0010B\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bB\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001f\u0010C\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bC\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001f\u0010D\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bD\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R%\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bE\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001e\u0010F\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bF\u0010\u008c\u0001\u001a\u0005\b\u008d\u0001\u0010$R\u001d\u0010G\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bG\u0010]\u001a\u0005\b\u008e\u0001\u0010\nR\u001d\u0010H\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bH\u0010]\u001a\u0005\b\u008f\u0001\u0010\nR\u001f\u0010I\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bI\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001d\u0010J\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bJ\u0010]\u001a\u0005\b\u0093\u0001\u0010\nR\u001d\u0010K\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bK\u0010]\u001a\u0005\b\u0094\u0001\u0010\nR+\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bL\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001d\u0010M\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\r\n\u0004\bM\u0010V\u001a\u0005\b\u0098\u0001\u0010XR\u001d\u0010N\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bN\u0010]\u001a\u0005\b\u0099\u0001\u0010\nR\u001e\u0010O\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bO\u0010\u008c\u0001\u001a\u0005\b\u009a\u0001\u0010$R'\u0010\u009b\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u009b\u0001\u0010{\u001a\u0005\b\u009c\u0001\u0010}\"\u0006\b\u009d\u0001\u0010\u009e\u0001R&\u0010\u009f\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010m\u001a\u0005\b \u0001\u0010o\"\u0005\b¡\u0001\u0010qR'\u0010¢\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b¢\u0001\u0010{\u001a\u0005\b¢\u0001\u0010}\"\u0006\b£\u0001\u0010\u009e\u0001R'\u0010¤\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b¤\u0001\u0010{\u001a\u0005\b¤\u0001\u0010}\"\u0006\b¥\u0001\u0010\u009e\u0001R(\u0010¦\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¦\u0001\u0010V\u001a\u0005\b§\u0001\u0010X\"\u0005\b¨\u0001\u0010ZR(\u0010©\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b©\u0001\u0010V\u001a\u0005\bª\u0001\u0010X\"\u0005\b«\u0001\u0010Z¨\u0006°\u0001"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyHalfScreenStruct;", "", "", "getCloseType", "Lcom/bytedance/locallife/groupon/struct/SizeStyle;", "getSizeStyle", "", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "", "component16", "component17", "component18", "Lcom/bytedance/locallife/groupon/struct/HalfClosedAction;", "component19", "Lcom/bytedance/locallife/groupon/struct/HalfShowedAction;", "component20", "Lcom/bytedance/locallife/groupon/struct/ArrowStyleConfigStruct;", "component21", "", "component22", "component23", "()Ljava/lang/Boolean;", "component24", "component25", "Lcom/bytedance/locallife/groupon/struct/GesturesInfo;", "component26", "component27", "component28", "", "component29", "component30", "component31", "component32", "contentUrl", "nativeViewType", "originHeightPercent", "maxHeightPercent", "style", "id", "requestSource", "fixHeight", "arrowXOffset", "fullScreenEnable", "arrowColor", "nativeCloseBtn", "groupId", "nativeCloseStyle", "diamondCardHeight", "sendViewAppeared", "needHighlightFeed", "sendBackEvent", "halfClosedAction", "halfShowedAction", "arrowStyleconfig", "bubbleGuideScene", "appendCommonParams", "appendGrouponCommonParamsToSession", "forceDragBarStyle", "gesturesInfo", "paddingTop", "windowHeightConfig", "trackParams", "moduleId", "containerType", "disableScrollToTop", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/String;ILjava/lang/String;ILjava/lang/Integer;ZZZLcom/bytedance/locallife/groupon/struct/HalfClosedAction;Lcom/bytedance/locallife/groupon/struct/HalfShowedAction;Lcom/bytedance/locallife/groupon/struct/ArrowStyleConfigStruct;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/struct/GesturesInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/bytedance/locallife/groupon/struct/NearbyHalfScreenStruct;", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getContentUrl", "()Ljava/lang/String;", "setContentUrl", "(Ljava/lang/String;)V", "getNativeViewType", "setNativeViewType", "Ljava/lang/Integer;", "getOriginHeightPercent", "setOriginHeightPercent", "(Ljava/lang/Integer;)V", "getMaxHeightPercent", "setMaxHeightPercent", "getStyle", "setStyle", "getId", "setId", "getRequestSource", "setRequestSource", "getFixHeight", "setFixHeight", "getArrowXOffset", "setArrowXOffset", "I", "getFullScreenEnable", "()I", "setFullScreenEnable", "(I)V", "getArrowColor", "setArrowColor", "getNativeCloseBtn", "setNativeCloseBtn", "getNativeCloseBtn$annotations", "()V", "getGroupId", "getNativeCloseStyle", "getDiamondCardHeight", "Z", "getSendViewAppeared", "()Z", "getNeedHighlightFeed", "getSendBackEvent", "Lcom/bytedance/locallife/groupon/struct/HalfClosedAction;", "getHalfClosedAction", "()Lcom/bytedance/locallife/groupon/struct/HalfClosedAction;", "Lcom/bytedance/locallife/groupon/struct/HalfShowedAction;", "getHalfShowedAction", "()Lcom/bytedance/locallife/groupon/struct/HalfShowedAction;", "Lcom/bytedance/locallife/groupon/struct/ArrowStyleConfigStruct;", "getArrowStyleconfig", "()Lcom/bytedance/locallife/groupon/struct/ArrowStyleConfigStruct;", "Ljava/util/List;", "getBubbleGuideScene", "()Ljava/util/List;", "Ljava/lang/Boolean;", "getAppendCommonParams", "getAppendGrouponCommonParamsToSession", "getForceDragBarStyle", "Lcom/bytedance/locallife/groupon/struct/GesturesInfo;", "getGesturesInfo", "()Lcom/bytedance/locallife/groupon/struct/GesturesInfo;", "getPaddingTop", "getWindowHeightConfig", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "getModuleId", "getContainerType", "getDisableScrollToTop", "used", "getUsed", "setUsed", "(Z)V", "dataFrom", "getDataFrom", "setDataFrom", "isColdStart", "setColdStart", "isPreParse", "setPreParse", "enterFrom", "getEnterFrom", "setEnterFrom", "enterMethod", "getEnterMethod", "setEnterMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/String;ILjava/lang/String;ILjava/lang/Integer;ZZZLcom/bytedance/locallife/groupon/struct/HalfClosedAction;Lcom/bytedance/locallife/groupon/struct/HalfShowedAction;Lcom/bytedance/locallife/groupon/struct/ArrowStyleConfigStruct;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/locallife/groupon/struct/GesturesInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class NearbyHalfScreenStruct {
    public static final int CONTAINER_TYPE_ANNIEX = 2;
    public static final int CONTAINER_TYPE_BULLET = 1;
    public static final a Companion = null;
    public static final int FORCE_DRAG_BAR_HIDE = 2;
    public static final int FORCE_DRAG_BAR_SHOW = 1;
    public static final int HALF_SCREEN_STYLE_ONE = 0;
    public static final int HALF_SCREEN_STYLE_TWO = 1;
    public static final int NATIVE_CLOSE_FULL_CLOSE_HALF_DEFAULT = 2;
    public static final int NATIVE_CLOSE_STYLE_DARK = 4;
    public static final int NATIVE_CLOSE_STYLE_FULL_DARK = 5;
    public static final int NATIVE_CLOSE_STYLE_HALF_DARK = 6;
    public static final int NATIVE_CLOSE_STYLE_LIGHT = 3;
    public static final int NATIVE_CLOSE_TYPE_FULL_SHOW = 3;
    public static final int NATIVE_CLOSE_TYPE_HALF_SHOW = 4;
    public static final int NATIVE_CLOSE_TYPE_HIDE = 5;
    public static final int NATIVE_CLOSE_TYPE_SHOW = 6;
    public static final int STYLE_ONE_FULL_THRESH_HOLD = 100;
    public static final int TOP_SLOGAN_TYPE_CONFIGURABLE = 1;
    public static final int TOP_SLOGAN_TYPE_LEGACY = 0;
    public static final int WINDOW_CONFIG_FULL = 1;

    @SerializedName("append_common_track_params")
    private final Boolean appendCommonParams;

    @SerializedName("append_groupon_common_param_to_session")
    private final Integer appendGrouponCommonParamsToSession;

    @SerializedName("arrow_color")
    private String arrowColor;

    @SerializedName("style_config")
    private final ArrowStyleConfigStruct arrowStyleconfig;

    @SerializedName("arrow_x_offset")
    private Integer arrowXOffset;

    @SerializedName("bubble_guide_scene")
    private final List<Integer> bubbleGuideScene;

    @SerializedName(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE)
    private final Integer containerType;

    @SerializedName("content_url")
    private String contentUrl;
    private int dataFrom;

    @SerializedName("diamond_card_height")
    private final Integer diamondCardHeight;

    @SerializedName("disable_scroll_to_top")
    private final Boolean disableScrollToTop;
    private String enterFrom;
    private String enterMethod;

    @SerializedName("fix_height")
    private Integer fixHeight;

    @SerializedName("force_drag_bar_style")
    private final Integer forceDragBarStyle;

    @SerializedName("full_screen_enable")
    private int fullScreenEnable;

    @SerializedName("gestures_info")
    private final GesturesInfo gesturesInfo;

    @SerializedName("group_id")
    private final String groupId;

    @SerializedName("half_closed_action")
    private final HalfClosedAction halfClosedAction;

    @SerializedName("half_show_action")
    private final HalfShowedAction halfShowedAction;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f258829id;
    private boolean isColdStart;
    private boolean isPreParse;

    @SerializedName("max_percent")
    private Integer maxHeightPercent;

    @SerializedName("module_id")
    private final String moduleId;

    @SerializedName("native_close_btn")
    private int nativeCloseBtn;

    @SerializedName("native_close_style")
    private final int nativeCloseStyle;

    @SerializedName("native_view_type")
    private String nativeViewType;

    @SerializedName("need_highlight_feed")
    private final boolean needHighlightFeed;

    @SerializedName("origin_percent")
    private Integer originHeightPercent;

    @SerializedName("padding_top")
    private final Integer paddingTop;

    @SerializedName("request_source")
    private Integer requestSource;

    @SerializedName("event_back_action")
    private final boolean sendBackEvent;

    @SerializedName("event_view_appeared")
    private final boolean sendViewAppeared;

    @SerializedName("style")
    private Integer style;

    @SerializedName("track_params")
    private final Map<String, String> trackParams;
    private boolean used;

    @SerializedName("android_window_config")
    private final Integer windowHeightConfig;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public NearbyHalfScreenStruct() {
        this(null, null, null, null, null, null, null, null, null, 0, null, 0, null, 0, null, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NearbyHalfScreenStruct copy$default(NearbyHalfScreenStruct r110, String r111, String r112, Integer r210, Integer r211, Integer r212, String r213, Integer r214, Integer r215, Integer r216, int r217, String r218, int r219, String r310, int r311, Integer r312, boolean r313, boolean r314, boolean r315, HalfClosedAction r316, HalfShowedAction r317, ArrowStyleConfigStruct r318, List r319, Boolean r410, Integer r411, Integer r412, GesturesInfo r413, Integer r414, Integer r415, Map r416, String r417, Integer r418, Boolean r419, int r510, Object r511) {
        if ((r510 & 1) == 0) goto L5;
        String r100 = r110.contentUrl;
    L7:
        if ((r510 & 2) == 0) goto L9;
        String r101 = r110.nativeViewType;
    L11:
        if ((r510 & 4) == 0) goto L13;
        Integer r102 = r110.originHeightPercent;
    L15:
        if ((r510 & 8) == 0) goto L17;
        Integer r103 = r110.maxHeightPercent;
    L19:
        if ((r510 & 16) == 0) goto L21;
        Integer r104 = r110.style;
    L23:
        if ((r510 & 32) == 0) goto L25;
        String r105 = r110.f258829id;
    L27:
        if ((r510 & 64) == 0) goto L29;
        Integer r106 = r110.requestSource;
    L31:
        if ((r510 & 128) == 0) goto L33;
        Integer r107 = r110.fixHeight;
    L35:
        if ((r510 & 256) == 0) goto L37;
        Integer r113 = r110.arrowXOffset;
    L39:
        if ((r510 & 512) == 0) goto L41;
        int r114 = r110.fullScreenEnable;
    L43:
        if ((r510 & 1024) == 0) goto L45;
        String r115 = r110.arrowColor;
    L47:
        if ((r510 & 2048) == 0) goto L49;
        int r116 = r110.nativeCloseBtn;
    L51:
        if ((r510 & 4096) == 0) goto L53;
        String r117 = r110.groupId;
    L55:
        if ((r510 & 8192) == 0) goto L57;
        int r118 = r110.nativeCloseStyle;
    L58:
        int r320 = r118;
        if ((r510 & 16384) == 0) goto L61;
        Integer r119 = r110.diamondCardHeight;
    L62:
        Integer r321 = r119;
        if ((r510 & 32768) == 0) goto L65;
        boolean r120 = r110.sendViewAppeared;
    L66:
        boolean r322 = r120;
        if ((r510 & 65536) == 0) goto L69;
        boolean r121 = r110.needHighlightFeed;
    L70:
        boolean r323 = r121;
        if ((r510 & 131072) == 0) goto L73;
        boolean r122 = r110.sendBackEvent;
    L74:
        boolean r324 = r122;
        if ((r510 & 262144) == 0) goto L77;
        HalfClosedAction r123 = r110.halfClosedAction;
    L78:
        HalfClosedAction r325 = r123;
        if ((r510 & 524288) == 0) goto L81;
        HalfShowedAction r124 = r110.halfShowedAction;
    L82:
        HalfShowedAction r326 = r124;
        if ((r510 & 1048576) == 0) goto L85;
        ArrowStyleConfigStruct r125 = r110.arrowStyleconfig;
    L86:
        ArrowStyleConfigStruct r327 = r125;
        if ((r510 & 2097152) == 0) goto L89;
        List r126 = r110.bubbleGuideScene;
    L90:
        List r328 = r126;
        if ((r510 & 4194304) == 0) goto L93;
        Boolean r127 = r110.appendCommonParams;
    L94:
        Boolean r420 = r127;
        if ((r510 & 8388608) == 0) goto L97;
        Integer r128 = r110.appendGrouponCommonParamsToSession;
    L98:
        Integer r421 = r128;
        if ((r510 & 16777216) == 0) goto L101;
        Integer r129 = r110.forceDragBarStyle;
    L102:
        Integer r422 = r129;
        if ((r510 & 33554432) == 0) goto L105;
        GesturesInfo r130 = r110.gesturesInfo;
    L106:
        GesturesInfo r423 = r130;
        if ((r510 & 67108864) == 0) goto L109;
        Integer r131 = r110.paddingTop;
    L110:
        Integer r424 = r131;
        if ((r510 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Integer r132 = r110.windowHeightConfig;
    L114:
        Integer r425 = r132;
        if ((r510 & 268435456) == 0) goto L117;
        Map r133 = r110.trackParams;
    L118:
        Map r426 = r133;
        if ((r510 & 536870912) == 0) goto L121;
        String r134 = r110.moduleId;
    L122:
        String r427 = r134;
        if ((r510 & 1073741824) == 0) goto L125;
        Integer r135 = r110.containerType;
    L127:
        if ((r510 & Integer.MIN_VALUE) == 0) goto L129;
        Boolean r108 = r110.disableScrollToTop;
    L131:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r426, r427, r135, r108);
    L129:
        r108 = r419;
        goto L131
    L125:
        r135 = r418;
        goto L127
    L121:
        r134 = r417;
        goto L122
    L117:
        r133 = r416;
        goto L118
    L113:
        r132 = r415;
        goto L114
    L109:
        r131 = r414;
        goto L110
    L105:
        r130 = r413;
        goto L106
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
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

    @Deprecated(message = "不用直接调用这个属性，通过getCloseType方法获取")
    public static /* synthetic */ void getNativeCloseBtn$annotations() {
    }

    public final String component1() {
        return this.contentUrl;
    }

    public final int component10() {
        return this.fullScreenEnable;
    }

    public final String component11() {
        return this.arrowColor;
    }

    public final int component12() {
        return this.nativeCloseBtn;
    }

    public final String component13() {
        return this.groupId;
    }

    public final int component14() {
        return this.nativeCloseStyle;
    }

    public final Integer component15() {
        return this.diamondCardHeight;
    }

    public final boolean component16() {
        return this.sendViewAppeared;
    }

    public final boolean component17() {
        return this.needHighlightFeed;
    }

    public final boolean component18() {
        return this.sendBackEvent;
    }

    public final HalfClosedAction component19() {
        return this.halfClosedAction;
    }

    public final String component2() {
        return this.nativeViewType;
    }

    public final HalfShowedAction component20() {
        return this.halfShowedAction;
    }

    public final ArrowStyleConfigStruct component21() {
        return this.arrowStyleconfig;
    }

    public final List<Integer> component22() {
        return this.bubbleGuideScene;
    }

    public final Boolean component23() {
        return this.appendCommonParams;
    }

    public final Integer component24() {
        return this.appendGrouponCommonParamsToSession;
    }

    public final Integer component25() {
        return this.forceDragBarStyle;
    }

    public final GesturesInfo component26() {
        return this.gesturesInfo;
    }

    public final Integer component27() {
        return this.paddingTop;
    }

    public final Integer component28() {
        return this.windowHeightConfig;
    }

    public final Map<String, String> component29() {
        return this.trackParams;
    }

    public final Integer component3() {
        return this.originHeightPercent;
    }

    public final String component30() {
        return this.moduleId;
    }

    public final Integer component31() {
        return this.containerType;
    }

    public final Boolean component32() {
        return this.disableScrollToTop;
    }

    public final Integer component4() {
        return this.maxHeightPercent;
    }

    public final Integer component5() {
        return this.style;
    }

    public final String component6() {
        return this.f258829id;
    }

    public final Integer component7() {
        return this.requestSource;
    }

    public final Integer component8() {
        return this.fixHeight;
    }

    public final Integer component9() {
        return this.arrowXOffset;
    }

    public final NearbyHalfScreenStruct copy(String r310, String r311, Integer r312, Integer r313, Integer r314, String r410, Integer r411, Integer r412, Integer r413, int r414, String r415, int r416, String r417, int r418, Integer r419, boolean r510, boolean r511, boolean r512, HalfClosedAction r513, HalfShowedAction r514, ArrowStyleConfigStruct r515, List<Integer> r516, Boolean r517, Integer r518, Integer r519, GesturesInfo r610, Integer r611, Integer r612, Map<String, String> r613, String r614, Integer r615, Boolean r616) {
        Intrinsics.checkNotNullParameter(r415, "arrowColor");
        return new NearbyHalfScreenStruct(r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NearbyHalfScreenStruct) == true) goto L8;
        return false;
    L8:
        NearbyHalfScreenStruct r101 = (NearbyHalfScreenStruct) r100;
        if (Intrinsics.areEqual(this.contentUrl, r101.contentUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nativeViewType, r101.nativeViewType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.originHeightPercent, r101.originHeightPercent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxHeightPercent, r101.maxHeightPercent) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f258829id, r101.f258829id) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.requestSource, r101.requestSource) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.fixHeight, r101.fixHeight) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.arrowXOffset, r101.arrowXOffset) == true) goto L36;
        return false;
    L36:
        if (this.fullScreenEnable == r101.fullScreenEnable) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.arrowColor, r101.arrowColor) == true) goto L42;
        return false;
    L42:
        if (this.nativeCloseBtn == r101.nativeCloseBtn) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L48;
        return false;
    L48:
        if (this.nativeCloseStyle == r101.nativeCloseStyle) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.diamondCardHeight, r101.diamondCardHeight) == true) goto L54;
        return false;
    L54:
        if (this.sendViewAppeared == r101.sendViewAppeared) goto L57;
        return false;
    L57:
        if (this.needHighlightFeed == r101.needHighlightFeed) goto L60;
        return false;
    L60:
        if (this.sendBackEvent == r101.sendBackEvent) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.halfClosedAction, r101.halfClosedAction) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.halfShowedAction, r101.halfShowedAction) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.arrowStyleconfig, r101.arrowStyleconfig) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.bubbleGuideScene, r101.bubbleGuideScene) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.appendCommonParams, r101.appendCommonParams) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.appendGrouponCommonParamsToSession, r101.appendGrouponCommonParamsToSession) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.forceDragBarStyle, r101.forceDragBarStyle) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.gesturesInfo, r101.gesturesInfo) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.paddingTop, r101.paddingTop) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.windowHeightConfig, r101.windowHeightConfig) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.moduleId, r101.moduleId) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.containerType, r101.containerType) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.disableScrollToTop, r101.disableScrollToTop) == true) goto L104;
        return false;
    L104:
        return true;
    }

    public int hashCode() {
        String r100 = this.contentUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.nativeViewType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.originHeightPercent;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.maxHeightPercent;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.style;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f258829id;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.requestSource;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.fixHeight;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.arrowXOffset;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (((((((r124 + r126) * 31) + this.fullScreenEnable) * 31) + this.arrowColor.hashCode()) * 31) + this.nativeCloseBtn) * 31;
        String r128 = this.groupId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (((r127 + r129) * 31) + this.nativeCloseStyle) * 31;
        Integer r131 = this.diamondCardHeight;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        int r134 = 1231;
        if (this.sendViewAppeared == false) goto L49;
        int r135 = 1231;
    L50:
        int r136 = (r133 + r135) * 31;
        if (this.needHighlightFeed == false) goto L53;
        int r137 = 1231;
    L54:
        int r138 = (r136 + r137) * 31;
        if (this.sendBackEvent == true) goto L58;
        r134 = 1237;
    L58:
        int r139 = (r138 + r134) * 31;
        HalfClosedAction r140 = this.halfClosedAction;
        if (r140 != null) goto L61;
        int r141 = 0;
    L62:
        int r142 = (r139 + r141) * 31;
        HalfShowedAction r143 = this.halfShowedAction;
        if (r143 != null) goto L65;
        int r144 = 0;
    L66:
        int r145 = (r142 + r144) * 31;
        ArrowStyleConfigStruct r146 = this.arrowStyleconfig;
        if (r146 != null) goto L69;
        int r147 = 0;
    L70:
        int r148 = (r145 + r147) * 31;
        List<Integer> r149 = this.bubbleGuideScene;
        if (r149 != null) goto L73;
        int r150 = 0;
    L74:
        int r151 = (r148 + r150) * 31;
        Boolean r152 = this.appendCommonParams;
        if (r152 != null) goto L77;
        int r153 = 0;
    L78:
        int r154 = (r151 + r153) * 31;
        Integer r155 = this.appendGrouponCommonParamsToSession;
        if (r155 != null) goto L81;
        int r156 = 0;
    L82:
        int r157 = (r154 + r156) * 31;
        Integer r158 = this.forceDragBarStyle;
        if (r158 != null) goto L85;
        int r159 = 0;
    L86:
        int r160 = (r157 + r159) * 31;
        GesturesInfo r161 = this.gesturesInfo;
        if (r161 != null) goto L89;
        int r162 = 0;
    L90:
        int r163 = (r160 + r162) * 31;
        Integer r164 = this.paddingTop;
        if (r164 != null) goto L93;
        int r165 = 0;
    L94:
        int r166 = (r163 + r165) * 31;
        Integer r167 = this.windowHeightConfig;
        if (r167 != null) goto L97;
        int r168 = 0;
    L98:
        int r169 = (r166 + r168) * 31;
        Map<String, String> r170 = this.trackParams;
        if (r170 != null) goto L101;
        int r171 = 0;
    L102:
        int r172 = (r169 + r171) * 31;
        String r173 = this.moduleId;
        if (r173 != null) goto L105;
        int r174 = 0;
    L106:
        int r175 = (r172 + r174) * 31;
        Integer r176 = this.containerType;
        if (r176 != null) goto L109;
        int r177 = 0;
    L110:
        int r178 = (r175 + r177) * 31;
        Boolean r179 = this.disableScrollToTop;
        if (r179 == null) goto L115;
        r101 = r179.hashCode();
    L115:
        return r178 + r101;
    L109:
        r177 = r176.hashCode();
        goto L110
    L105:
        r174 = r173.hashCode();
        goto L106
    L101:
        r171 = r170.hashCode();
        goto L102
    L97:
        r168 = r167.hashCode();
        goto L98
    L93:
        r165 = r164.hashCode();
        goto L94
    L89:
        r162 = r161.hashCode();
        goto L90
    L85:
        r159 = r158.hashCode();
        goto L86
    L81:
        r156 = r155.hashCode();
        goto L82
    L77:
        r153 = r152.hashCode();
        goto L78
    L73:
        r150 = r149.hashCode();
        goto L74
    L69:
        r147 = r146.hashCode();
        goto L70
    L65:
        r144 = r143.hashCode();
        goto L66
    L61:
        r141 = r140.hashCode();
        goto L62
    L53:
        r137 = 1237;
        goto L54
    L49:
        r135 = 1237;
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
        return "NearbyHalfScreenStruct(contentUrl=" + this.contentUrl + ", nativeViewType=" + this.nativeViewType + ", originHeightPercent=" + this.originHeightPercent + ", maxHeightPercent=" + this.maxHeightPercent + ", style=" + this.style + ", id=" + this.f258829id + ", requestSource=" + this.requestSource + ", fixHeight=" + this.fixHeight + ", arrowXOffset=" + this.arrowXOffset + ", fullScreenEnable=" + this.fullScreenEnable + ", arrowColor=" + this.arrowColor + ", nativeCloseBtn=" + this.nativeCloseBtn + ", groupId=" + this.groupId + ", nativeCloseStyle=" + this.nativeCloseStyle + ", diamondCardHeight=" + this.diamondCardHeight + ", sendViewAppeared=" + this.sendViewAppeared + ", needHighlightFeed=" + this.needHighlightFeed + ", sendBackEvent=" + this.sendBackEvent + ", halfClosedAction=" + this.halfClosedAction + ", halfShowedAction=" + this.halfShowedAction + ", arrowStyleconfig=" + this.arrowStyleconfig + ", bubbleGuideScene=" + this.bubbleGuideScene + ", appendCommonParams=" + this.appendCommonParams + ", appendGrouponCommonParamsToSession=" + this.appendGrouponCommonParamsToSession + ", forceDragBarStyle=" + this.forceDragBarStyle + ", gesturesInfo=" + this.gesturesInfo + ", paddingTop=" + this.paddingTop + ", windowHeightConfig=" + this.windowHeightConfig + ", trackParams=" + this.trackParams + ", moduleId=" + this.moduleId + ", containerType=" + this.containerType + ", disableScrollToTop=" + this.disableScrollToTop + ')';
    }

    public final int getCloseType() {
        int r100 = this.nativeCloseBtn;
        if (r100 == 0) goto L15;
        if (r100 == 1) goto L15;
        if (r100 != 2) goto L28;
        Integer r101 = this.style;
        if (r101 != null) goto L12;
    L14:
        return 4;
    L12:
        if (r101.intValue() != 0) goto L14;
    L13:
        return 5;
    L28:
        return r100;
    L15:
        Integer r102 = this.style;
        if (r102 != null) goto L19;
    L23:
        return 6;
    L19:
        if (r102.intValue() != 0) goto L23;
        if (this.fullScreenEnable != 1) goto L13;
        return 3;
    }

    public final SizeStyle getSizeStyle() {
        if (Intrinsics.areEqual(this.f258829id, "groupon_tab") == false) goto L15;
        ArrowStyleConfigStruct r100 = this.arrowStyleconfig;
        boolean r101 = false;
        if (r100 == null) goto L12;
        Integer r102 = r100.getArrowStyle();
        if (r102 == null) goto L12;
        if (r102.intValue() != 0) goto L12;
        r101 = true;
    L12:
        if (r101 == false) goto L15;
        return SizeStyle.SIZE_9;
    L15:
        return SizeStyle.SIZE_7;
    }

    public final Boolean getAppendCommonParams() {
        return this.appendCommonParams;
    }

    public final Integer getAppendGrouponCommonParamsToSession() {
        return this.appendGrouponCommonParamsToSession;
    }

    public final String getArrowColor() {
        return this.arrowColor;
    }

    public final ArrowStyleConfigStruct getArrowStyleconfig() {
        return this.arrowStyleconfig;
    }

    public final Integer getArrowXOffset() {
        return this.arrowXOffset;
    }

    public final List<Integer> getBubbleGuideScene() {
        return this.bubbleGuideScene;
    }

    public final Integer getContainerType() {
        return this.containerType;
    }

    public final String getContentUrl() {
        return this.contentUrl;
    }

    public final int getDataFrom() {
        return this.dataFrom;
    }

    public final Integer getDiamondCardHeight() {
        return this.diamondCardHeight;
    }

    public final Boolean getDisableScrollToTop() {
        return this.disableScrollToTop;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final Integer getFixHeight() {
        return this.fixHeight;
    }

    public final Integer getForceDragBarStyle() {
        return this.forceDragBarStyle;
    }

    public final int getFullScreenEnable() {
        return this.fullScreenEnable;
    }

    public final GesturesInfo getGesturesInfo() {
        return this.gesturesInfo;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final HalfClosedAction getHalfClosedAction() {
        return this.halfClosedAction;
    }

    public final HalfShowedAction getHalfShowedAction() {
        return this.halfShowedAction;
    }

    public final String getId() {
        return this.f258829id;
    }

    public final Integer getMaxHeightPercent() {
        return this.maxHeightPercent;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final int getNativeCloseBtn() {
        return this.nativeCloseBtn;
    }

    public final int getNativeCloseStyle() {
        return this.nativeCloseStyle;
    }

    public final String getNativeViewType() {
        return this.nativeViewType;
    }

    public final boolean getNeedHighlightFeed() {
        return this.needHighlightFeed;
    }

    public final Integer getOriginHeightPercent() {
        return this.originHeightPercent;
    }

    public final Integer getPaddingTop() {
        return this.paddingTop;
    }

    public final Integer getRequestSource() {
        return this.requestSource;
    }

    public final boolean getSendBackEvent() {
        return this.sendBackEvent;
    }

    public final boolean getSendViewAppeared() {
        return this.sendViewAppeared;
    }

    public final Integer getStyle() {
        return this.style;
    }

    public final Map<String, String> getTrackParams() {
        return this.trackParams;
    }

    public final boolean getUsed() {
        return this.used;
    }

    public final Integer getWindowHeightConfig() {
        return this.windowHeightConfig;
    }

    public final boolean isColdStart() {
        return this.isColdStart;
    }

    public final boolean isPreParse() {
        return this.isPreParse;
    }

    public final void setArrowColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.arrowColor = r100;
    }

    public final void setArrowXOffset(Integer r100) {
        this.arrowXOffset = r100;
    }

    public final void setColdStart(boolean r100) {
        this.isColdStart = r100;
    }

    public final void setContentUrl(String r100) {
        this.contentUrl = r100;
    }

    public final void setDataFrom(int r100) {
        this.dataFrom = r100;
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setFixHeight(Integer r100) {
        this.fixHeight = r100;
    }

    public final void setFullScreenEnable(int r100) {
        this.fullScreenEnable = r100;
    }

    public final void setId(String r100) {
        this.f258829id = r100;
    }

    public final void setMaxHeightPercent(Integer r100) {
        this.maxHeightPercent = r100;
    }

    public final void setNativeCloseBtn(int r100) {
        this.nativeCloseBtn = r100;
    }

    public final void setNativeViewType(String r100) {
        this.nativeViewType = r100;
    }

    public final void setOriginHeightPercent(Integer r100) {
        this.originHeightPercent = r100;
    }

    public final void setPreParse(boolean r100) {
        this.isPreParse = r100;
    }

    public final void setRequestSource(Integer r100) {
        this.requestSource = r100;
    }

    public final void setStyle(Integer r100) {
        this.style = r100;
    }

    public final void setUsed(boolean r100) {
        this.used = r100;
    }

    public NearbyHalfScreenStruct(String r100, String r101, Integer r102, Integer r103, Integer r104, String r105, Integer r110, Integer r111, Integer r112, int r113, String r114, int r115, String r116, int r117, Integer r118, boolean r119, boolean r210, boolean r211, HalfClosedAction r212, HalfShowedAction r213, ArrowStyleConfigStruct r214, List<Integer> r215, Boolean r216, Integer r217, Integer r218, GesturesInfo r219, Integer r310, Integer r311, Map<String, String> r312, String r313, Integer r314, Boolean r315) {
        Intrinsics.checkNotNullParameter(r114, "arrowColor");
        this.contentUrl = r100;
        this.nativeViewType = r101;
        this.originHeightPercent = r102;
        this.maxHeightPercent = r103;
        this.style = r104;
        this.f258829id = r105;
        this.requestSource = r110;
        this.fixHeight = r111;
        this.arrowXOffset = r112;
        this.fullScreenEnable = r113;
        this.arrowColor = r114;
        this.nativeCloseBtn = r115;
        this.groupId = r116;
        this.nativeCloseStyle = r117;
        this.diamondCardHeight = r118;
        this.sendViewAppeared = r119;
        this.needHighlightFeed = r210;
        this.sendBackEvent = r211;
        this.halfClosedAction = r212;
        this.halfShowedAction = r213;
        this.arrowStyleconfig = r214;
        this.bubbleGuideScene = r215;
        this.appendCommonParams = r216;
        this.appendGrouponCommonParamsToSession = r217;
        this.forceDragBarStyle = r218;
        this.gesturesInfo = r219;
        this.paddingTop = r310;
        this.windowHeightConfig = r311;
        this.trackParams = r312;
        this.moduleId = r313;
        this.containerType = r314;
        this.disableScrollToTop = r315;
    }

    public /* synthetic */ NearbyHalfScreenStruct(String r310, String r311, Integer r312, Integer r313, Integer r314, String r315, Integer r410, Integer r411, Integer r412, int r413, String r414, int r415, String r416, int r417, Integer r418, boolean r419, boolean r510, boolean r511, HalfClosedAction r512, HalfShowedAction r513, ArrowStyleConfigStruct r514, List r515, Boolean r516, Integer r517, Integer r518, GesturesInfo r519, Integer r610, Integer r611, Map r612, String r613, Integer r614, Boolean r615, int r616, DefaultConstructorMarker r617) {
        if ((r616 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r616 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r616 & 4) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r616 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r616 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r616 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r616 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r616 & 128) == 0) goto L33;
        Integer r107 = null;
    L35:
        if ((r616 & 256) == 0) goto L37;
        Integer r110 = null;
    L39:
        if ((r616 & 512) == 0) goto L41;
        int r111 = 0;
    L43:
        if ((r616 & 1024) == 0) goto L45;
        String r112 = CustomHeaderConfig.COLOR_LIGHT;
    L47:
        if ((r616 & 2048) == 0) goto L49;
        int r113 = 0;
    L51:
        if ((r616 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r616 & 8192) == 0) goto L57;
        int r108 = 4;
    L59:
        if ((r616 & 16384) == 0) goto L61;
        Integer r115 = null;
    L63:
        if ((r616 & 32768) == 0) goto L65;
        boolean r116 = false;
    L67:
        if ((r616 & 65536) == 0) goto L69;
        boolean r117 = true;
    L71:
        if ((r616 & 131072) == 0) goto L73;
        boolean r118 = false;
    L75:
        if ((r616 & 262144) == 0) goto L77;
        HalfClosedAction r119 = null;
    L79:
        if ((r616 & 524288) == 0) goto L81;
        HalfShowedAction r210 = null;
    L83:
        if ((r616 & 1048576) == 0) goto L85;
        ArrowStyleConfigStruct r211 = null;
    L87:
        if ((r616 & 2097152) == 0) goto L89;
        List r212 = null;
    L91:
        if ((r616 & 4194304) == 0) goto L93;
        Boolean r213 = Boolean.FALSE;
    L95:
        if ((r616 & 8388608) == 0) goto L97;
        Integer r214 = 0;
    L99:
        if ((r616 & 16777216) == 0) goto L101;
        Integer r215 = null;
    L103:
        if ((r616 & 33554432) == 0) goto L105;
        GesturesInfo r216 = null;
    L107:
        if ((r616 & 67108864) == 0) goto L109;
        Integer r217 = null;
    L111:
        if ((r616 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Integer r218 = null;
    L115:
        if ((r616 & 268435456) == 0) goto L117;
        Map r219 = null;
    L119:
        if ((r616 & 536870912) == 0) goto L121;
        String r316 = null;
    L123:
        if ((r616 & 1073741824) == 0) goto L125;
        Integer r317 = null;
    L127:
        if ((r616 & Integer.MIN_VALUE) == 0) goto L129;
        Boolean r109 = null;
    L130:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r108, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r316, r317, r109);
        return;
    L129:
        r109 = r615;
        goto L130
    L125:
        r317 = r614;
        goto L127
    L121:
        r316 = r613;
        goto L123
    L117:
        r219 = r612;
        goto L119
    L113:
        r218 = r611;
        goto L115
    L109:
        r217 = r610;
        goto L111
    L105:
        r216 = r519;
        goto L107
    L101:
        r215 = r518;
        goto L103
    L97:
        r214 = r517;
        goto L99
    L93:
        r213 = r516;
        goto L95
    L89:
        r212 = r515;
        goto L91
    L85:
        r211 = r514;
        goto L87
    L81:
        r210 = r513;
        goto L83
    L77:
        r119 = r512;
        goto L79
    L73:
        r118 = r511;
        goto L75
    L69:
        r117 = r510;
        goto L71
    L65:
        r116 = r419;
        goto L67
    L61:
        r115 = r418;
        goto L63
    L57:
        r108 = r417;
        goto L59
    L53:
        r114 = r416;
        goto L55
    L49:
        r113 = r415;
        goto L51
    L45:
        r112 = r414;
        goto L47
    L41:
        r111 = r413;
        goto L43
    L37:
        r110 = r412;
        goto L39
    L33:
        r107 = r411;
        goto L35
    L29:
        r106 = r410;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
