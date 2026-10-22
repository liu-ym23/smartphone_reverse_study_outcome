package com.bytedance.locallife.model.poi.resp;

import android.text.Spannable;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.CardOperationModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\be\b\u0086\b\u0018\u0000 É\u00012\u00020\u0001:\u0002Ê\u0001Bã\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t\u0012\b\b\u0002\u0010E\u001a\u00020\u0013\u0012\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\t\u0012\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\t\u0012\b\b\u0002\u0010H\u001a\u00020\u0013\u0012\b\b\u0002\u0010I\u001a\u00020\u0019\u0012\b\b\u0002\u0010J\u001a\u00020\u0019\u0012\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\t\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010N\u001a\u00020\u0013\u0012\b\b\u0002\u0010O\u001a\u00020\u0019\u0012\b\b\u0002\u0010P\u001a\u00020\u0019\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010W\u001a\u00020\u0013\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u0010Y\u001a\u00020\u0019\u0012\b\b\u0002\u0010Z\u001a\u00020\u0019\u0012\b\b\u0002\u0010[\u001a\u00020\u0019\u0012\b\b\u0002\u0010\\\u001a\u00020\u0019\u0012\b\b\u0002\u0010]\u001a\u000204\u0012\b\b\u0002\u0010^\u001a\u00020\u0019\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010`\u001a\u00020\u0019\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010:¢\u0006\u0006\bÇ\u0001\u0010È\u0001J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tHÆ\u0003J\t\u0010\u0014\u001a\u00020\u0013HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\tHÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0019HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0019HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u001fHÆ\u0003J\t\u0010!\u001a\u00020\u0013HÆ\u0003J\t\u0010\"\u001a\u00020\u0019HÆ\u0003J\t\u0010#\u001a\u00020\u0019HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010&HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010(HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010*HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0013HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010.HÆ\u0003J\t\u00100\u001a\u00020\u0019HÆ\u0003J\t\u00101\u001a\u00020\u0019HÆ\u0003J\t\u00102\u001a\u00020\u0019HÆ\u0003J\t\u00103\u001a\u00020\u0019HÆ\u0003J\t\u00105\u001a\u000204HÆ\u0003J\t\u00106\u001a\u00020\u0019HÆ\u0003J\u0012\u00107\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b7\u00108J\t\u00109\u001a\u00020\u0019HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010:HÆ\u0003Jê\u0003\u0010b\u001a\u00020\u00002\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t2\b\b\u0002\u0010E\u001a\u00020\u00132\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\t2\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\t2\b\b\u0002\u0010H\u001a\u00020\u00132\b\b\u0002\u0010I\u001a\u00020\u00192\b\b\u0002\u0010J\u001a\u00020\u00192\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\t2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010N\u001a\u00020\u00132\b\b\u0002\u0010O\u001a\u00020\u00192\b\b\u0002\u0010P\u001a\u00020\u00192\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010S\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010W\u001a\u00020\u00132\n\b\u0002\u0010X\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010Y\u001a\u00020\u00192\b\b\u0002\u0010Z\u001a\u00020\u00192\b\b\u0002\u0010[\u001a\u00020\u00192\b\b\u0002\u0010\\\u001a\u00020\u00192\b\b\u0002\u0010]\u001a\u0002042\b\b\u0002\u0010^\u001a\u00020\u00192\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010`\u001a\u00020\u00192\n\b\u0002\u0010a\u001a\u0004\u0018\u00010:HÆ\u0001¢\u0006\u0004\bb\u0010cJ\t\u0010d\u001a\u00020\u0007HÖ\u0001J\t\u0010e\u001a\u00020\u0013HÖ\u0001J\u0013\u0010h\u001a\u00020\u00192\b\u0010g\u001a\u0004\u0018\u00010fHÖ\u0003R\u001c\u0010<\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010i\u001a\u0004\bj\u0010kR\u001c\u0010=\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010l\u001a\u0004\bm\u0010\u0006R\u001c\u0010>\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010n\u001a\u0004\bo\u0010pR\"\u0010?\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010q\u001a\u0004\br\u0010sR\"\u0010@\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010q\u001a\u0004\bt\u0010sR\"\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010q\u001a\u0004\bu\u0010sR\u001c\u0010B\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010n\u001a\u0004\bv\u0010pR\u001c\u0010C\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010w\u001a\u0004\bx\u0010yR\"\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010q\u001a\u0004\bz\u0010sR\u001a\u0010E\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010{\u001a\u0004\b|\u0010}R\"\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010q\u001a\u0004\b~\u0010sR\"\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010q\u001a\u0004\b\u007f\u0010sR%\u0010H\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0004\bH\u0010{\u001a\u0005\b\u0080\u0001\u0010}\"\u0006\b\u0081\u0001\u0010\u0082\u0001R'\u0010I\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bI\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R'\u0010J\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bJ\u0010\u0083\u0001\u001a\u0006\b\u0088\u0001\u0010\u0085\u0001\"\u0006\b\u0089\u0001\u0010\u0087\u0001R#\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\r\n\u0004\bK\u0010q\u001a\u0005\b\u008a\u0001\u0010sR-\u0010L\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0004\bL\u0010q\u001a\u0005\b\u008b\u0001\u0010s\"\u0006\b\u008c\u0001\u0010\u008d\u0001R)\u0010M\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bM\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001b\u0010N\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\r\n\u0004\bN\u0010{\u001a\u0005\b\u0093\u0001\u0010}R&\u0010O\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bO\u0010\u0083\u0001\u001a\u0005\bO\u0010\u0085\u0001\"\u0006\b\u0094\u0001\u0010\u0087\u0001R\u001d\u0010P\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bP\u0010\u0083\u0001\u001a\u0006\b\u0095\u0001\u0010\u0085\u0001R\u001d\u0010Q\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\r\n\u0004\bQ\u0010n\u001a\u0005\b\u0096\u0001\u0010pR\u001d\u0010R\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\r\n\u0004\bR\u0010n\u001a\u0005\b\u0097\u0001\u0010pR)\u0010S\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bS\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R)\u0010T\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bT\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R\u001f\u0010U\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bU\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001R\u001d\u0010V\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\r\n\u0004\bV\u0010n\u001a\u0005\b¥\u0001\u0010pR%\u0010W\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\bW\u0010{\u001a\u0005\b¦\u0001\u0010}\"\u0006\b§\u0001\u0010\u0082\u0001R)\u0010X\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bX\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R'\u0010Y\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bY\u0010\u0083\u0001\u001a\u0006\b\u00ad\u0001\u0010\u0085\u0001\"\u0006\b®\u0001\u0010\u0087\u0001R'\u0010Z\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bZ\u0010\u0083\u0001\u001a\u0006\b¯\u0001\u0010\u0085\u0001\"\u0006\b°\u0001\u0010\u0087\u0001R'\u0010[\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b[\u0010\u0083\u0001\u001a\u0006\b±\u0001\u0010\u0085\u0001\"\u0006\b²\u0001\u0010\u0087\u0001R'\u0010\\\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\\\u0010\u0083\u0001\u001a\u0006\b³\u0001\u0010\u0085\u0001\"\u0006\b´\u0001\u0010\u0087\u0001R'\u0010]\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b]\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R'\u0010^\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b^\u0010\u0083\u0001\u001a\u0006\bº\u0001\u0010\u0085\u0001\"\u0006\b»\u0001\u0010\u0087\u0001R(\u0010_\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b_\u0010¼\u0001\u001a\u0005\b½\u0001\u00108\"\u0006\b¾\u0001\u0010¿\u0001R'\u0010`\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b`\u0010\u0083\u0001\u001a\u0006\bÀ\u0001\u0010\u0085\u0001\"\u0006\bÁ\u0001\u0010\u0087\u0001R)\u0010a\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\ba\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001¨\u0006Ë\u0001"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiUgcFeedItem;", "Ljava/io/Serializable;", "Lcom/bytedance/locallife/model/poi/resp/UserInfo;", "component1", "", "component2", "()Ljava/lang/Long;", "", "component3", "", "Lcom/bytedance/locallife/model/poi/resp/RateTag;", "component4", "component5", "component6", "component7", "Lcom/bytedance/locallife/model/poi/resp/SimpleAwemeInfo;", "component8", "Lcom/bytedance/locallife/model/poi/resp/Staffs;", "component9", "", "component10", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "component11", "component12", "component13", "", "component14", "component15", "component16", "Lcom/bytedance/locallife/model/poi/resp/PoiUgcReplyInfo;", "component17", "Lcom/bytedance/locallife/model/poi/resp/ReplyGroup;", "component18", "component19", "component20", "component21", "component22", "component23", "Lcom/bytedance/locallife/model/poi/resp/RecFoodsDetailGroup;", "component24", "Lcom/bytedance/locallife/model/poi/resp/HighQualityTag;", "component25", "Lcom/bytedance/locallife/model/poi/resp/SameUserRate;", "component26", "component27", "component28", "Landroid/text/Spannable;", "component29", "component30", "component31", "component32", "component33", "Lcom/bytedance/locallife/model/poi/resp/ContentParams;", "component34", "component35", "component36", "()Ljava/lang/Integer;", "component37", "Lcom/bytedance/locallife/model/poi/resp/ContentExtra;", "component38", "userInfo", "itemId", "publishedTime", "contentTags", "scoreTags", "impressions", "content", "awemeInfo", "staffs", "itemType", "images", "thumbnails", "diggedCount", "hasContentDiggedByRequestUser", "hasContentBuriedByRequestUser", "impressionPhrase", "replys", "replyGroup", "imgShowNum", "isAnonymous", "canDelete", "ipProvince", "residentLocation", "recommendDishs", "highQualityTag", "sameUserRate", "mobParams", "awemeIndex", "spanContent", "hasMobDeleteShow", "needHideDivider", "lastUgcRate", "needBackground", "contentParams", "followSameFoldedView", "orderIndex", CardOperationModel.PayloadBean.EditType.DELETE_LOCAL, "contentExtra", "copy", "(Lcom/bytedance/locallife/model/poi/resp/UserInfo;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/locallife/model/poi/resp/SimpleAwemeInfo;Ljava/util/List;ILjava/util/List;Ljava/util/List;IZZLjava/util/List;Ljava/util/List;Lcom/bytedance/locallife/model/poi/resp/ReplyGroup;IZZLjava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/model/poi/resp/RecFoodsDetailGroup;Lcom/bytedance/locallife/model/poi/resp/HighQualityTag;Lcom/bytedance/locallife/model/poi/resp/SameUserRate;Ljava/lang/String;ILandroid/text/Spannable;ZZZZLcom/bytedance/locallife/model/poi/resp/ContentParams;ZLjava/lang/Integer;ZLcom/bytedance/locallife/model/poi/resp/ContentExtra;)Lcom/bytedance/locallife/model/poi/resp/PoiUgcFeedItem;", "toString", "hashCode", "", "other", "equals", "Lcom/bytedance/locallife/model/poi/resp/UserInfo;", "getUserInfo", "()Lcom/bytedance/locallife/model/poi/resp/UserInfo;", "Ljava/lang/Long;", "getItemId", "Ljava/lang/String;", "getPublishedTime", "()Ljava/lang/String;", "Ljava/util/List;", "getContentTags", "()Ljava/util/List;", "getScoreTags", "getImpressions", "getContent", "Lcom/bytedance/locallife/model/poi/resp/SimpleAwemeInfo;", "getAwemeInfo", "()Lcom/bytedance/locallife/model/poi/resp/SimpleAwemeInfo;", "getStaffs", "I", "getItemType", "()I", "getImages", "getThumbnails", "getDiggedCount", "setDiggedCount", "(I)V", "Z", "getHasContentDiggedByRequestUser", "()Z", "setHasContentDiggedByRequestUser", "(Z)V", "getHasContentBuriedByRequestUser", "setHasContentBuriedByRequestUser", "getImpressionPhrase", "getReplys", "setReplys", "(Ljava/util/List;)V", "Lcom/bytedance/locallife/model/poi/resp/ReplyGroup;", "getReplyGroup", "()Lcom/bytedance/locallife/model/poi/resp/ReplyGroup;", "setReplyGroup", "(Lcom/bytedance/locallife/model/poi/resp/ReplyGroup;)V", "getImgShowNum", "setAnonymous", "getCanDelete", "getIpProvince", "getResidentLocation", "Lcom/bytedance/locallife/model/poi/resp/RecFoodsDetailGroup;", "getRecommendDishs", "()Lcom/bytedance/locallife/model/poi/resp/RecFoodsDetailGroup;", "setRecommendDishs", "(Lcom/bytedance/locallife/model/poi/resp/RecFoodsDetailGroup;)V", "Lcom/bytedance/locallife/model/poi/resp/HighQualityTag;", "getHighQualityTag", "()Lcom/bytedance/locallife/model/poi/resp/HighQualityTag;", "setHighQualityTag", "(Lcom/bytedance/locallife/model/poi/resp/HighQualityTag;)V", "Lcom/bytedance/locallife/model/poi/resp/SameUserRate;", "getSameUserRate", "()Lcom/bytedance/locallife/model/poi/resp/SameUserRate;", "getMobParams", "getAwemeIndex", "setAwemeIndex", "Landroid/text/Spannable;", "getSpanContent", "()Landroid/text/Spannable;", "setSpanContent", "(Landroid/text/Spannable;)V", "getHasMobDeleteShow", "setHasMobDeleteShow", "getNeedHideDivider", "setNeedHideDivider", "getLastUgcRate", "setLastUgcRate", "getNeedBackground", "setNeedBackground", "Lcom/bytedance/locallife/model/poi/resp/ContentParams;", "getContentParams", "()Lcom/bytedance/locallife/model/poi/resp/ContentParams;", "setContentParams", "(Lcom/bytedance/locallife/model/poi/resp/ContentParams;)V", "getFollowSameFoldedView", "setFollowSameFoldedView", "Ljava/lang/Integer;", "getOrderIndex", "setOrderIndex", "(Ljava/lang/Integer;)V", "getLocalDelete", "setLocalDelete", "Lcom/bytedance/locallife/model/poi/resp/ContentExtra;", "getContentExtra", "()Lcom/bytedance/locallife/model/poi/resp/ContentExtra;", "setContentExtra", "(Lcom/bytedance/locallife/model/poi/resp/ContentExtra;)V", "<init>", "(Lcom/bytedance/locallife/model/poi/resp/UserInfo;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/locallife/model/poi/resp/SimpleAwemeInfo;Ljava/util/List;ILjava/util/List;Ljava/util/List;IZZLjava/util/List;Ljava/util/List;Lcom/bytedance/locallife/model/poi/resp/ReplyGroup;IZZLjava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/model/poi/resp/RecFoodsDetailGroup;Lcom/bytedance/locallife/model/poi/resp/HighQualityTag;Lcom/bytedance/locallife/model/poi/resp/SameUserRate;Ljava/lang/String;ILandroid/text/Spannable;ZZZZLcom/bytedance/locallife/model/poi/resp/ContentParams;ZLjava/lang/Integer;ZLcom/bytedance/locallife/model/poi/resp/ContentExtra;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiUgcFeedItem implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;
    private int awemeIndex;

    @SerializedName("aweme_info")
    private final SimpleAwemeInfo awemeInfo;

    @SerializedName("can_delete")
    private final boolean canDelete;

    @SerializedName("content")
    private final String content;

    @SerializedName("content_extra")
    private ContentExtra contentExtra;
    private ContentParams contentParams;

    @SerializedName("content_tags_v2")
    private final List<RateTag> contentTags;

    @SerializedName("digged_count")
    private int diggedCount;
    private boolean followSameFoldedView;

    @SerializedName("has_content_buried_by_request_user")
    private boolean hasContentBuriedByRequestUser;

    @SerializedName("has_content_digged_by_request_user")
    private boolean hasContentDiggedByRequestUser;
    private boolean hasMobDeleteShow;

    @SerializedName("high_quality_tag")
    private HighQualityTag highQualityTag;

    @SerializedName("images")
    private final List<PoiImageUrlModel> images;

    @SerializedName("img_show_num")
    private final int imgShowNum;

    @SerializedName("impression_phrase")
    private final List<String> impressionPhrase;

    @SerializedName("impressions")
    private final List<String> impressions;

    @SerializedName("ip_province")
    private final String ipProvince;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS)
    private boolean isAnonymous;

    @SerializedName("item_id")
    private final Long itemId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private final int itemType;
    private boolean lastUgcRate;

    @SerializedName("local_delete")
    private boolean localDelete;

    @SerializedName("mob_params")
    private final String mobParams;
    private boolean needBackground;
    private boolean needHideDivider;
    private Integer orderIndex;

    @SerializedName("published_time")
    private final String publishedTime;

    @SerializedName("recommend_dishs")
    private RecFoodsDetailGroup recommendDishs;

    @SerializedName("reply_group")
    private ReplyGroup replyGroup;

    @SerializedName("replys")
    private List<PoiUgcReplyInfo> replys;

    @SerializedName("resident_location")
    private final String residentLocation;

    @SerializedName("same_user_rate")
    private final SameUserRate sameUserRate;

    @SerializedName("score_tags")
    private final List<RateTag> scoreTags;
    private Spannable spanContent;

    @SerializedName("craftsman")
    private final List<Staffs> staffs;

    @SerializedName("thumbnails")
    private final List<PoiImageUrlModel> thumbnails;

    @SerializedName("user_info")
    private final UserInfo userInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PoiUgcFeedItem() {
        this(null, null, null, null, null, null, null, null, null, 0, null, null, 0, false, false, null, null, null, 0, false, false, null, null, null, null, null, null, 0, null, false, false, false, false, null, false, null, false, null, -1, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiUgcFeedItem copy$default(PoiUgcFeedItem r110, UserInfo r111, Long r112, String r210, List r211, List r212, List r213, String r214, SimpleAwemeInfo r215, List r216, int r217, List r218, List r219, int r310, boolean r311, boolean r312, List r313, List r314, ReplyGroup r315, int r316, boolean r317, boolean r318, String r319, String r410, RecFoodsDetailGroup r411, HighQualityTag r412, SameUserRate r413, String r414, int r415, Spannable r416, boolean r417, boolean r418, boolean r419, boolean r510, ContentParams r511, boolean r512, Integer r513, boolean r514, ContentExtra r515, int r516, int r517, Object r518) {
        if ((r516 & 1) == 0) goto L5;
        UserInfo r100 = r110.userInfo;
    L7:
        if ((r516 & 2) == 0) goto L9;
        Long r101 = r110.itemId;
    L11:
        if ((r516 & 4) == 0) goto L13;
        String r102 = r110.publishedTime;
    L15:
        if ((r516 & 8) == 0) goto L17;
        List r103 = r110.contentTags;
    L19:
        if ((r516 & 16) == 0) goto L21;
        List r104 = r110.scoreTags;
    L23:
        if ((r516 & 32) == 0) goto L25;
        List r105 = r110.impressions;
    L27:
        if ((r516 & 64) == 0) goto L29;
        String r106 = r110.content;
    L31:
        if ((r516 & 128) == 0) goto L33;
        SimpleAwemeInfo r107 = r110.awemeInfo;
    L35:
        if ((r516 & 256) == 0) goto L37;
        List r113 = r110.staffs;
    L39:
        if ((r516 & 512) == 0) goto L41;
        int r114 = r110.itemType;
    L43:
        if ((r516 & 1024) == 0) goto L45;
        List r115 = r110.images;
    L47:
        if ((r516 & 2048) == 0) goto L49;
        List r116 = r110.thumbnails;
    L51:
        if ((r516 & 4096) == 0) goto L53;
        int r117 = r110.diggedCount;
    L55:
        if ((r516 & 8192) == 0) goto L57;
        boolean r118 = r110.hasContentDiggedByRequestUser;
    L58:
        boolean r320 = r118;
        if ((r516 & 16384) == 0) goto L61;
        boolean r119 = r110.hasContentBuriedByRequestUser;
    L62:
        boolean r321 = r119;
        if ((r516 & 32768) == 0) goto L65;
        List r120 = r110.impressionPhrase;
    L66:
        List r322 = r120;
        if ((r516 & 65536) == 0) goto L69;
        List r121 = r110.replys;
    L70:
        List r323 = r121;
        if ((r516 & 131072) == 0) goto L73;
        ReplyGroup r122 = r110.replyGroup;
    L74:
        ReplyGroup r324 = r122;
        if ((r516 & 262144) == 0) goto L77;
        int r123 = r110.imgShowNum;
    L78:
        int r325 = r123;
        if ((r516 & 524288) == 0) goto L81;
        boolean r124 = r110.isAnonymous;
    L82:
        boolean r326 = r124;
        if ((r516 & 1048576) == 0) goto L85;
        boolean r125 = r110.canDelete;
    L86:
        boolean r327 = r125;
        if ((r516 & 2097152) == 0) goto L89;
        String r126 = r110.ipProvince;
    L90:
        String r328 = r126;
        if ((r516 & 4194304) == 0) goto L93;
        String r127 = r110.residentLocation;
    L94:
        String r420 = r127;
        if ((r516 & 8388608) == 0) goto L97;
        RecFoodsDetailGroup r128 = r110.recommendDishs;
    L98:
        RecFoodsDetailGroup r421 = r128;
        if ((r516 & 16777216) == 0) goto L101;
        HighQualityTag r129 = r110.highQualityTag;
    L102:
        HighQualityTag r422 = r129;
        if ((r516 & 33554432) == 0) goto L105;
        SameUserRate r130 = r110.sameUserRate;
    L106:
        SameUserRate r423 = r130;
        if ((r516 & 67108864) == 0) goto L109;
        String r131 = r110.mobParams;
    L110:
        String r424 = r131;
        if ((r516 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r132 = r110.awemeIndex;
    L114:
        int r425 = r132;
        if ((r516 & 268435456) == 0) goto L117;
        Spannable r133 = r110.spanContent;
    L118:
        Spannable r426 = r133;
        if ((r516 & 536870912) == 0) goto L121;
        boolean r134 = r110.hasMobDeleteShow;
    L122:
        boolean r427 = r134;
        if ((r516 & 1073741824) == 0) goto L125;
        boolean r135 = r110.needHideDivider;
    L127:
        if ((r516 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r108 = r110.lastUgcRate;
    L130:
        boolean r428 = r108;
        if ((r517 & 1) == 0) goto L133;
        boolean r109 = r110.needBackground;
    L134:
        boolean r519 = r109;
        if ((r517 & 2) == 0) goto L137;
        ContentParams r136 = r110.contentParams;
    L138:
        ContentParams r520 = r136;
        if ((r517 & 4) == 0) goto L141;
        boolean r137 = r110.followSameFoldedView;
    L142:
        boolean r521 = r137;
        if ((r517 & 8) == 0) goto L145;
        Integer r138 = r110.orderIndex;
    L146:
        Integer r522 = r138;
        if ((r517 & 16) == 0) goto L149;
        boolean r139 = r110.localDelete;
    L150:
        boolean r523 = r139;
        if ((r517 & 32) == 0) goto L153;
        ContentExtra r140 = r110.contentExtra;
    L155:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r426, r427, r135, r428, r519, r520, r521, r522, r523, r140);
    L153:
        r140 = r515;
        goto L155
    L149:
        r139 = r514;
        goto L150
    L145:
        r138 = r513;
        goto L146
    L141:
        r137 = r512;
        goto L142
    L137:
        r136 = r511;
        goto L138
    L133:
        r109 = r510;
        goto L134
    L129:
        r108 = r419;
        goto L130
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

    public final UserInfo component1() {
        return this.userInfo;
    }

    public final int component10() {
        return this.itemType;
    }

    public final List<PoiImageUrlModel> component11() {
        return this.images;
    }

    public final List<PoiImageUrlModel> component12() {
        return this.thumbnails;
    }

    public final int component13() {
        return this.diggedCount;
    }

    public final boolean component14() {
        return this.hasContentDiggedByRequestUser;
    }

    public final boolean component15() {
        return this.hasContentBuriedByRequestUser;
    }

    public final List<String> component16() {
        return this.impressionPhrase;
    }

    public final List<PoiUgcReplyInfo> component17() {
        return this.replys;
    }

    public final ReplyGroup component18() {
        return this.replyGroup;
    }

    public final int component19() {
        return this.imgShowNum;
    }

    public final Long component2() {
        return this.itemId;
    }

    public final boolean component20() {
        return this.isAnonymous;
    }

    public final boolean component21() {
        return this.canDelete;
    }

    public final String component22() {
        return this.ipProvince;
    }

    public final String component23() {
        return this.residentLocation;
    }

    public final RecFoodsDetailGroup component24() {
        return this.recommendDishs;
    }

    public final HighQualityTag component25() {
        return this.highQualityTag;
    }

    public final SameUserRate component26() {
        return this.sameUserRate;
    }

    public final String component27() {
        return this.mobParams;
    }

    public final int component28() {
        return this.awemeIndex;
    }

    public final Spannable component29() {
        return this.spanContent;
    }

    public final String component3() {
        return this.publishedTime;
    }

    public final boolean component30() {
        return this.hasMobDeleteShow;
    }

    public final boolean component31() {
        return this.needHideDivider;
    }

    public final boolean component32() {
        return this.lastUgcRate;
    }

    public final boolean component33() {
        return this.needBackground;
    }

    public final ContentParams component34() {
        return this.contentParams;
    }

    public final boolean component35() {
        return this.followSameFoldedView;
    }

    public final Integer component36() {
        return this.orderIndex;
    }

    public final boolean component37() {
        return this.localDelete;
    }

    public final ContentExtra component38() {
        return this.contentExtra;
    }

    public final List<RateTag> component4() {
        return this.contentTags;
    }

    public final List<RateTag> component5() {
        return this.scoreTags;
    }

    public final List<String> component6() {
        return this.impressions;
    }

    public final String component7() {
        return this.content;
    }

    public final SimpleAwemeInfo component8() {
        return this.awemeInfo;
    }

    public final List<Staffs> component9() {
        return this.staffs;
    }

    public final PoiUgcFeedItem copy(UserInfo r410, Long r411, String r412, List<RateTag> r413, List<RateTag> r414, List<String> r415, String r416, SimpleAwemeInfo r417, List<Staffs> r418, int r510, List<PoiImageUrlModel> r511, List<PoiImageUrlModel> r512, int r513, boolean r514, boolean r515, List<String> r516, List<PoiUgcReplyInfo> r517, ReplyGroup r518, int r519, boolean r610, boolean r611, String r612, String r613, RecFoodsDetailGroup r614, HighQualityTag r615, SameUserRate r616, String r617, int r618, Spannable r619, boolean r710, boolean r711, boolean r712, boolean r713, ContentParams r714, boolean r715, Integer r716, boolean r717, ContentExtra r718) {
        Intrinsics.checkNotNullParameter(r714, "contentParams");
        return new PoiUgcFeedItem(r410, r411, r412, r413, r414, r415, r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiUgcFeedItem) == true) goto L8;
        return false;
    L8:
        PoiUgcFeedItem r101 = (PoiUgcFeedItem) r100;
        if (Intrinsics.areEqual(this.userInfo, r101.userInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.publishedTime, r101.publishedTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contentTags, r101.contentTags) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.scoreTags, r101.scoreTags) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.impressions, r101.impressions) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.awemeInfo, r101.awemeInfo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.staffs, r101.staffs) == true) goto L36;
        return false;
    L36:
        if (this.itemType == r101.itemType) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.thumbnails, r101.thumbnails) == true) goto L45;
        return false;
    L45:
        if (this.diggedCount == r101.diggedCount) goto L48;
        return false;
    L48:
        if (this.hasContentDiggedByRequestUser == r101.hasContentDiggedByRequestUser) goto L51;
        return false;
    L51:
        if (this.hasContentBuriedByRequestUser == r101.hasContentBuriedByRequestUser) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.impressionPhrase, r101.impressionPhrase) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.replys, r101.replys) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.replyGroup, r101.replyGroup) == true) goto L63;
        return false;
    L63:
        if (this.imgShowNum == r101.imgShowNum) goto L66;
        return false;
    L66:
        if (this.isAnonymous == r101.isAnonymous) goto L69;
        return false;
    L69:
        if (this.canDelete == r101.canDelete) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.ipProvince, r101.ipProvince) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.residentLocation, r101.residentLocation) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.recommendDishs, r101.recommendDishs) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.highQualityTag, r101.highQualityTag) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.sameUserRate, r101.sameUserRate) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.mobParams, r101.mobParams) == true) goto L90;
        return false;
    L90:
        if (this.awemeIndex == r101.awemeIndex) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.spanContent, r101.spanContent) == true) goto L96;
        return false;
    L96:
        if (this.hasMobDeleteShow == r101.hasMobDeleteShow) goto L99;
        return false;
    L99:
        if (this.needHideDivider == r101.needHideDivider) goto L102;
        return false;
    L102:
        if (this.lastUgcRate == r101.lastUgcRate) goto L105;
        return false;
    L105:
        if (this.needBackground == r101.needBackground) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.contentParams, r101.contentParams) == true) goto L111;
        return false;
    L111:
        if (this.followSameFoldedView == r101.followSameFoldedView) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.orderIndex, r101.orderIndex) == true) goto L117;
        return false;
    L117:
        if (this.localDelete == r101.localDelete) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.contentExtra, r101.contentExtra) == true) goto L122;
        return false;
    L122:
        return true;
    }

    public int hashCode() {
        UserInfo r100 = this.userInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.itemId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.publishedTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<RateTag> r110 = this.contentTags;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<RateTag> r113 = this.scoreTags;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.impressions;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.content;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        SimpleAwemeInfo r122 = this.awemeInfo;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        List<Staffs> r125 = this.staffs;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (((r124 + r126) * 31) + this.itemType) * 31;
        List<PoiImageUrlModel> r128 = this.images;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        List<PoiImageUrlModel> r131 = this.thumbnails;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (((r130 + r132) * 31) + this.diggedCount) * 31;
        int r134 = 1231;
        if (this.hasContentDiggedByRequestUser == false) goto L49;
        int r135 = 1231;
    L50:
        int r136 = (r133 + r135) * 31;
        if (this.hasContentBuriedByRequestUser == false) goto L53;
        int r137 = 1231;
    L54:
        int r138 = (r136 + r137) * 31;
        List<String> r139 = this.impressionPhrase;
        if (r139 != null) goto L57;
        int r140 = 0;
    L58:
        int r141 = (r138 + r140) * 31;
        List<PoiUgcReplyInfo> r142 = this.replys;
        if (r142 != null) goto L61;
        int r143 = 0;
    L62:
        int r144 = (r141 + r143) * 31;
        ReplyGroup r145 = this.replyGroup;
        if (r145 != null) goto L65;
        int r146 = 0;
    L66:
        int r147 = (((r144 + r146) * 31) + this.imgShowNum) * 31;
        if (this.isAnonymous == false) goto L69;
        int r148 = 1231;
    L70:
        int r149 = (r147 + r148) * 31;
        if (this.canDelete == false) goto L73;
        int r150 = 1231;
    L74:
        int r151 = (r149 + r150) * 31;
        String r152 = this.ipProvince;
        if (r152 != null) goto L77;
        int r153 = 0;
    L78:
        int r154 = (r151 + r153) * 31;
        String r155 = this.residentLocation;
        if (r155 != null) goto L81;
        int r156 = 0;
    L82:
        int r157 = (r154 + r156) * 31;
        RecFoodsDetailGroup r158 = this.recommendDishs;
        if (r158 != null) goto L85;
        int r159 = 0;
    L86:
        int r160 = (r157 + r159) * 31;
        HighQualityTag r161 = this.highQualityTag;
        if (r161 != null) goto L89;
        int r162 = 0;
    L90:
        int r163 = (r160 + r162) * 31;
        SameUserRate r164 = this.sameUserRate;
        if (r164 != null) goto L93;
        int r165 = 0;
    L94:
        int r166 = (r163 + r165) * 31;
        String r167 = this.mobParams;
        if (r167 != null) goto L97;
        int r168 = 0;
    L98:
        int r169 = (((r166 + r168) * 31) + this.awemeIndex) * 31;
        Spannable r170 = this.spanContent;
        if (r170 != null) goto L101;
        int r171 = 0;
    L102:
        int r172 = (r169 + r171) * 31;
        if (this.hasMobDeleteShow == false) goto L105;
        int r173 = 1231;
    L106:
        int r174 = (r172 + r173) * 31;
        if (this.needHideDivider == false) goto L109;
        int r175 = 1231;
    L110:
        int r176 = (r174 + r175) * 31;
        if (this.lastUgcRate == false) goto L113;
        int r177 = 1231;
    L114:
        int r178 = (r176 + r177) * 31;
        if (this.needBackground == false) goto L117;
        int r179 = 1231;
    L118:
        int r180 = (((r178 + r179) * 31) + this.contentParams.hashCode()) * 31;
        if (this.followSameFoldedView == false) goto L121;
        int r181 = 1231;
    L122:
        int r182 = (r180 + r181) * 31;
        Integer r183 = this.orderIndex;
        if (r183 != null) goto L125;
        int r184 = 0;
    L126:
        int r185 = (r182 + r184) * 31;
        if (this.localDelete == true) goto L130;
        r134 = 1237;
    L130:
        int r186 = (r185 + r134) * 31;
        ContentExtra r187 = this.contentExtra;
        if (r187 == null) goto L135;
        r101 = r187.hashCode();
    L135:
        return r186 + r101;
    L125:
        r184 = r183.hashCode();
        goto L126
    L121:
        r181 = 1237;
        goto L122
    L117:
        r179 = 1237;
        goto L118
    L113:
        r177 = 1237;
        goto L114
    L109:
        r175 = 1237;
        goto L110
    L105:
        r173 = 1237;
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
        r150 = 1237;
        goto L74
    L69:
        r148 = 1237;
        goto L70
    L65:
        r146 = r145.hashCode();
        goto L66
    L61:
        r143 = r142.hashCode();
        goto L62
    L57:
        r140 = r139.hashCode();
        goto L58
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
        return "PoiUgcFeedItem(userInfo=" + this.userInfo + ", itemId=" + this.itemId + ", publishedTime=" + this.publishedTime + ", contentTags=" + this.contentTags + ", scoreTags=" + this.scoreTags + ", impressions=" + this.impressions + ", content=" + this.content + ", awemeInfo=" + this.awemeInfo + ", staffs=" + this.staffs + ", itemType=" + this.itemType + ", images=" + this.images + ", thumbnails=" + this.thumbnails + ", diggedCount=" + this.diggedCount + ", hasContentDiggedByRequestUser=" + this.hasContentDiggedByRequestUser + ", hasContentBuriedByRequestUser=" + this.hasContentBuriedByRequestUser + ", impressionPhrase=" + this.impressionPhrase + ", replys=" + this.replys + ", replyGroup=" + this.replyGroup + ", imgShowNum=" + this.imgShowNum + ", isAnonymous=" + this.isAnonymous + ", canDelete=" + this.canDelete + ", ipProvince=" + this.ipProvince + ", residentLocation=" + this.residentLocation + ", recommendDishs=" + this.recommendDishs + ", highQualityTag=" + this.highQualityTag + ", sameUserRate=" + this.sameUserRate + ", mobParams=" + this.mobParams + ", awemeIndex=" + this.awemeIndex + ", spanContent=" + this.spanContent + ", hasMobDeleteShow=" + this.hasMobDeleteShow + ", needHideDivider=" + this.needHideDivider + ", lastUgcRate=" + this.lastUgcRate + ", needBackground=" + this.needBackground + ", contentParams=" + this.contentParams + ", followSameFoldedView=" + this.followSameFoldedView + ", orderIndex=" + this.orderIndex + ", localDelete=" + this.localDelete + ", contentExtra=" + this.contentExtra + ')';
    }

    public final int getAwemeIndex() {
        return this.awemeIndex;
    }

    public final SimpleAwemeInfo getAwemeInfo() {
        return this.awemeInfo;
    }

    public final boolean getCanDelete() {
        return this.canDelete;
    }

    public final String getContent() {
        return this.content;
    }

    public final ContentExtra getContentExtra() {
        return this.contentExtra;
    }

    public final ContentParams getContentParams() {
        return this.contentParams;
    }

    public final List<RateTag> getContentTags() {
        return this.contentTags;
    }

    public final int getDiggedCount() {
        return this.diggedCount;
    }

    public final boolean getFollowSameFoldedView() {
        return this.followSameFoldedView;
    }

    public final boolean getHasContentBuriedByRequestUser() {
        return this.hasContentBuriedByRequestUser;
    }

    public final boolean getHasContentDiggedByRequestUser() {
        return this.hasContentDiggedByRequestUser;
    }

    public final boolean getHasMobDeleteShow() {
        return this.hasMobDeleteShow;
    }

    public final HighQualityTag getHighQualityTag() {
        return this.highQualityTag;
    }

    public final List<PoiImageUrlModel> getImages() {
        return this.images;
    }

    public final int getImgShowNum() {
        return this.imgShowNum;
    }

    public final List<String> getImpressionPhrase() {
        return this.impressionPhrase;
    }

    public final List<String> getImpressions() {
        return this.impressions;
    }

    public final String getIpProvince() {
        return this.ipProvince;
    }

    public final Long getItemId() {
        return this.itemId;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final boolean getLastUgcRate() {
        return this.lastUgcRate;
    }

    public final boolean getLocalDelete() {
        return this.localDelete;
    }

    public final String getMobParams() {
        return this.mobParams;
    }

    public final boolean getNeedBackground() {
        return this.needBackground;
    }

    public final boolean getNeedHideDivider() {
        return this.needHideDivider;
    }

    public final Integer getOrderIndex() {
        return this.orderIndex;
    }

    public final String getPublishedTime() {
        return this.publishedTime;
    }

    public final RecFoodsDetailGroup getRecommendDishs() {
        return this.recommendDishs;
    }

    public final ReplyGroup getReplyGroup() {
        return this.replyGroup;
    }

    public final List<PoiUgcReplyInfo> getReplys() {
        return this.replys;
    }

    public final String getResidentLocation() {
        return this.residentLocation;
    }

    public final SameUserRate getSameUserRate() {
        return this.sameUserRate;
    }

    public final List<RateTag> getScoreTags() {
        return this.scoreTags;
    }

    public final Spannable getSpanContent() {
        return this.spanContent;
    }

    public final List<Staffs> getStaffs() {
        return this.staffs;
    }

    public final List<PoiImageUrlModel> getThumbnails() {
        return this.thumbnails;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public final boolean isAnonymous() {
        return this.isAnonymous;
    }

    public final void setAnonymous(boolean r100) {
        this.isAnonymous = r100;
    }

    public final void setAwemeIndex(int r100) {
        this.awemeIndex = r100;
    }

    public final void setContentExtra(ContentExtra r100) {
        this.contentExtra = r100;
    }

    public final void setContentParams(ContentParams r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.contentParams = r100;
    }

    public final void setDiggedCount(int r100) {
        this.diggedCount = r100;
    }

    public final void setFollowSameFoldedView(boolean r100) {
        this.followSameFoldedView = r100;
    }

    public final void setHasContentBuriedByRequestUser(boolean r100) {
        this.hasContentBuriedByRequestUser = r100;
    }

    public final void setHasContentDiggedByRequestUser(boolean r100) {
        this.hasContentDiggedByRequestUser = r100;
    }

    public final void setHasMobDeleteShow(boolean r100) {
        this.hasMobDeleteShow = r100;
    }

    public final void setHighQualityTag(HighQualityTag r100) {
        this.highQualityTag = r100;
    }

    public final void setLastUgcRate(boolean r100) {
        this.lastUgcRate = r100;
    }

    public final void setLocalDelete(boolean r100) {
        this.localDelete = r100;
    }

    public final void setNeedBackground(boolean r100) {
        this.needBackground = r100;
    }

    public final void setNeedHideDivider(boolean r100) {
        this.needHideDivider = r100;
    }

    public final void setOrderIndex(Integer r100) {
        this.orderIndex = r100;
    }

    public final void setRecommendDishs(RecFoodsDetailGroup r100) {
        this.recommendDishs = r100;
    }

    public final void setReplyGroup(ReplyGroup r100) {
        this.replyGroup = r100;
    }

    public final void setReplys(List<PoiUgcReplyInfo> r100) {
        this.replys = r100;
    }

    public final void setSpanContent(Spannable r100) {
        this.spanContent = r100;
    }

    public PoiUgcFeedItem(UserInfo r100, Long r101, String r102, List<RateTag> r103, List<RateTag> r104, List<String> r105, String r110, SimpleAwemeInfo r111, List<Staffs> r112, int r113, List<PoiImageUrlModel> r114, List<PoiImageUrlModel> r115, int r116, boolean r117, boolean r118, List<String> r119, List<PoiUgcReplyInfo> r210, ReplyGroup r211, int r212, boolean r213, boolean r214, String r215, String r216, RecFoodsDetailGroup r217, HighQualityTag r218, SameUserRate r219, String r310, int r311, Spannable r312, boolean r313, boolean r314, boolean r315, boolean r316, ContentParams r317, boolean r318, Integer r319, boolean r410, ContentExtra r411) {
        Intrinsics.checkNotNullParameter(r317, "contentParams");
        this.userInfo = r100;
        this.itemId = r101;
        this.publishedTime = r102;
        this.contentTags = r103;
        this.scoreTags = r104;
        this.impressions = r105;
        this.content = r110;
        this.awemeInfo = r111;
        this.staffs = r112;
        this.itemType = r113;
        this.images = r114;
        this.thumbnails = r115;
        this.diggedCount = r116;
        this.hasContentDiggedByRequestUser = r117;
        this.hasContentBuriedByRequestUser = r118;
        this.impressionPhrase = r119;
        this.replys = r210;
        this.replyGroup = r211;
        this.imgShowNum = r212;
        this.isAnonymous = r213;
        this.canDelete = r214;
        this.ipProvince = r215;
        this.residentLocation = r216;
        this.recommendDishs = r217;
        this.highQualityTag = r218;
        this.sameUserRate = r219;
        this.mobParams = r310;
        this.awemeIndex = r311;
        this.spanContent = r312;
        this.hasMobDeleteShow = r313;
        this.needHideDivider = r314;
        this.lastUgcRate = r315;
        this.needBackground = r316;
        this.contentParams = r317;
        this.followSameFoldedView = r318;
        this.orderIndex = r319;
        this.localDelete = r410;
        this.contentExtra = r411;
    }

    public /* synthetic */ PoiUgcFeedItem(UserInfo r410, Long r411, String r412, List r413, List r414, List r510, String r511, SimpleAwemeInfo r512, List r513, int r514, List r515, List r516, int r517, boolean r518, boolean r519, List r610, List r611, ReplyGroup r612, int r613, boolean r614, boolean r615, String r616, String r617, RecFoodsDetailGroup r618, HighQualityTag r619, SameUserRate r710, String r711, int r712, Spannable r713, boolean r714, boolean r715, boolean r716, boolean r717, ContentParams r718, boolean r719, Integer r810, boolean r811, ContentExtra r812, int r813, int r814, DefaultConstructorMarker r815) {
        if ((r813 & 1) == 0) goto L5;
        UserInfo r100 = null;
    L7:
        if ((r813 & 2) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r813 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r813 & 8) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r813 & 16) == 0) goto L21;
        List r104 = null;
    L23:
        if ((r813 & 32) == 0) goto L25;
        List r105 = null;
    L27:
        if ((r813 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r813 & 128) == 0) goto L33;
        SimpleAwemeInfo r110 = null;
    L35:
        if ((r813 & 256) == 0) goto L37;
        List r111 = null;
    L39:
        if ((r813 & 512) == 0) goto L41;
        int r112 = 0;
    L43:
        if ((r813 & 1024) == 0) goto L45;
        List r113 = null;
    L47:
        if ((r813 & 2048) == 0) goto L49;
        List r114 = null;
    L51:
        if ((r813 & 4096) == 0) goto L53;
        int r107 = 0;
    L55:
        if ((r813 & 8192) == 0) goto L57;
        boolean r115 = false;
    L59:
        if ((r813 & 16384) == 0) goto L61;
        boolean r108 = false;
    L63:
        if ((r813 & 32768) == 0) goto L65;
        List r116 = null;
    L67:
        if ((r813 & 65536) == 0) goto L69;
        List r117 = null;
    L71:
        if ((r813 & 131072) == 0) goto L73;
        ReplyGroup r118 = null;
    L75:
        if ((r813 & 262144) == 0) goto L77;
        int r119 = 3;
    L79:
        if ((r813 & 524288) == 0) goto L81;
        boolean r210 = false;
    L83:
        if ((r813 & 1048576) == 0) goto L85;
        boolean r211 = false;
    L87:
        if ((r813 & 2097152) == 0) goto L89;
        String r212 = "";
    L91:
        if ((r813 & 4194304) == 0) goto L93;
        String r213 = null;
    L95:
        if ((r813 & 8388608) == 0) goto L97;
        RecFoodsDetailGroup r214 = null;
    L99:
        if ((r813 & 16777216) == 0) goto L101;
        HighQualityTag r215 = null;
    L103:
        if ((r813 & 33554432) == 0) goto L105;
        SameUserRate r216 = null;
    L107:
        if ((r813 & 67108864) == 0) goto L109;
        String r217 = "";
    L111:
        if ((r813 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r218 = 0;
    L115:
        if ((r813 & 268435456) == 0) goto L117;
        Spannable r219 = null;
    L119:
        if ((r813 & 536870912) == 0) goto L121;
        boolean r310 = false;
    L123:
        if ((r813 & 1073741824) == 0) goto L125;
        boolean r311 = false;
    L127:
        if ((r813 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r109 = false;
    L131:
        if ((r814 & 1) == 0) goto L133;
        boolean r312 = false;
    L135:
        if ((r814 & 2) == 0) goto L137;
        ContentParams r313 = new ContentParams(null, null, null, null, null, null, null, null, 255, null);
    L139:
        if ((r814 & 4) == 0) goto L141;
        boolean r314 = false;
    L143:
        if ((r814 & 8) == 0) goto L145;
        Integer r315 = null;
    L147:
        if ((r814 & 16) == 0) goto L149;
        boolean r316 = false;
    L151:
        if ((r814 & 32) == 0) goto L153;
        ContentExtra r317 = null;
    L154:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r107, r115, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r109, r312, r313, r314, r315, r316, r317);
        return;
    L153:
        r317 = r812;
        goto L154
    L149:
        r316 = r811;
        goto L151
    L145:
        r315 = r810;
        goto L147
    L141:
        r314 = r719;
        goto L143
    L137:
        r313 = r718;
        goto L139
    L133:
        r312 = r717;
        goto L135
    L129:
        r109 = r716;
        goto L131
    L125:
        r311 = r715;
        goto L127
    L121:
        r310 = r714;
        goto L123
    L117:
        r219 = r713;
        goto L119
    L113:
        r218 = r712;
        goto L115
    L109:
        r217 = r711;
        goto L111
    L105:
        r216 = r710;
        goto L107
    L101:
        r215 = r619;
        goto L103
    L97:
        r214 = r618;
        goto L99
    L93:
        r213 = r617;
        goto L95
    L89:
        r212 = r616;
        goto L91
    L85:
        r211 = r615;
        goto L87
    L81:
        r210 = r614;
        goto L83
    L77:
        r119 = r613;
        goto L79
    L73:
        r118 = r612;
        goto L75
    L69:
        r117 = r611;
        goto L71
    L65:
        r116 = r610;
        goto L67
    L61:
        r108 = r519;
        goto L63
    L57:
        r115 = r518;
        goto L59
    L53:
        r107 = r517;
        goto L55
    L49:
        r114 = r516;
        goto L51
    L45:
        r113 = r515;
        goto L47
    L41:
        r112 = r514;
        goto L43
    L37:
        r111 = r513;
        goto L39
    L33:
        r110 = r512;
        goto L35
    L29:
        r106 = r511;
        goto L31
    L25:
        r105 = r510;
        goto L27
    L21:
        r104 = r414;
        goto L23
    L17:
        r103 = r413;
        goto L19
    L13:
        r102 = r412;
        goto L15
    L9:
        r101 = r411;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }
}
