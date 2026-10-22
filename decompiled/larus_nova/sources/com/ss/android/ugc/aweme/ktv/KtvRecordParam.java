package com.ss.android.ugc.aweme.ktv;

import com.alipay.sdk.m.x.d;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.tools.utils.f;
import com.ss.android.vesdk.VERecordData;
import com.tencent.connect.share.QzonePublish;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\\\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B·\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010#\u001a\u00020\u0006\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010*\u001a\u00020\u000b\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010%\u0012\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030-\u0012\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030-\u0012\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0-\u0012\b\b\u0002\u00100\u001a\u00020\u000b\u0012\b\b\u0002\u00101\u001a\u00020\u0006\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u00105\u001a\u00020\u0006\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000107\u0012\b\b\u0002\u00108\u001a\u00020\u0006\u0012\b\b\u0002\u00109\u001a\u00020\u0006\u0012\b\b\u0002\u0010:\u001a\u00020\u0006\u0012\b\b\u0002\u0010;\u001a\u00020<¢\u0006\u0002\u0010=J\u0011\u0010Á\u0001\u001a\f\u0012\u0005\u0012\u00030Ã\u0001\u0018\u00010Â\u0001J\u0007\u0010Ä\u0001\u001a\u00020\u0006J\t\u0010Å\u0001\u001a\u00020\u0006H\u0002J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fHÆ\u0003J\f\u0010È\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003J\f\u0010É\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ê\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003J\f\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010Í\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010Î\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010Ï\u0001\u001a\u00020\u000bHÆ\u0003J\f\u0010Ð\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\f\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0018\u0010Ò\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cHÆ\u0003J\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010Õ\u0001\u001a\u00020\u000bHÆ\u0003J\f\u0010Ö\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\f\u0010×\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\n\u0010Ø\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010Ù\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010Ú\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010Û\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\n\u0010Ü\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010ß\u0001\u001a\u00020\u000bHÆ\u0003J\f\u0010à\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\u0010\u0010á\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030-HÆ\u0003J\u0010\u0010â\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030-HÆ\u0003J\u0010\u0010ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0-HÆ\u0003J\n\u0010ä\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010å\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010é\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010ê\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010ë\u0001\u001a\u0004\u0018\u000107HÆ\u0003J\n\u0010ì\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010í\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010î\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010ï\u0001\u001a\u00020<HÆ\u0003J\f\u0010ð\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010ò\u0001\u001a\u00020\u000bHÆ\u0003J\f\u0010ó\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010ô\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003J¼\u0004\u0010õ\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010#\u001a\u00020\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010*\u001a\u00020\u000b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010%2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030-2\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030-2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0-2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u00020\u00062\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00105\u001a\u00020\u00062\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\b\b\u0002\u00108\u001a\u00020\u00062\b\b\u0002\u00109\u001a\u00020\u00062\b\b\u0002\u0010:\u001a\u00020\u00062\b\b\u0002\u0010;\u001a\u00020<HÆ\u0001J\u0016\u0010ö\u0001\u001a\u00020\u00062\n\u0010÷\u0001\u001a\u0005\u0018\u00010ø\u0001HÖ\u0003J\u0007\u0010ù\u0001\u001a\u00020\u000bJ\u0007\u0010ú\u0001\u001a\u00020\u000bJ\n\u0010û\u0001\u001a\u00020\u000bHÖ\u0001J\u0011\u0010ü\u0001\u001a\f\u0012\u0005\u0012\u00030Ã\u0001\u0018\u00010Â\u0001J\n\u0010ý\u0001\u001a\u00020\u0003HÖ\u0001R\u001a\u00101\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010C\"\u0004\bG\u0010ER\u001a\u0010\u0017\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010'\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010\"\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001c\u0010!\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010U\"\u0004\bY\u0010WR\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010\u0015\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010I\"\u0004\b_\u0010KR\u001c\u00102\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010M\"\u0004\ba\u0010OR\u001c\u0010&\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010Q\"\u0004\bc\u0010SR\u001a\u0010\u0018\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010I\"\u0004\be\u0010KR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010M\"\u0004\bg\u0010OR\u001a\u00109\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010?\"\u0004\bh\u0010AR\u001a\u00108\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010?\"\u0004\bi\u0010AR\u001a\u00105\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010?\"\u0004\bj\u0010AR\u001a\u0010:\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010?\"\u0004\bk\u0010AR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010Q\"\u0004\bm\u0010SR(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010M\"\u0004\bs\u0010OR\u001a\u0010 \u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010I\"\u0004\bu\u0010KR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010I\"\u0004\bw\u0010KR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010U\"\u0004\by\u0010WR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010M\"\u0004\b{\u0010OR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010M\"\u0004\b}\u0010OR\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0-X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R#\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030-X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u007f\"\u0006\b\u0083\u0001\u0010\u0081\u0001R#\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030-X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u007f\"\u0006\b\u0085\u0001\u0010\u0081\u0001R\u001e\u0010)\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010M\"\u0005\b\u0087\u0001\u0010OR\u001c\u0010*\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010I\"\u0005\b\u0089\u0001\u0010KR\u001e\u0010(\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010M\"\u0005\b\u008b\u0001\u0010OR\u001e\u0010+\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010Q\"\u0005\b\u008d\u0001\u0010SR\u001c\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010?\"\u0005\b\u008f\u0001\u0010AR \u0010\u0011\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010M\"\u0005\b\u0095\u0001\u0010OR\u001c\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010I\"\u0005\b\u0097\u0001\u0010KR0\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001c\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010I\"\u0005\b \u0001\u0010KR\u001e\u00104\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010M\"\u0005\b¢\u0001\u0010OR\u001e\u00103\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010M\"\u0005\b¤\u0001\u0010OR\u001c\u0010#\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010?\"\u0005\b¦\u0001\u0010AR \u0010\u0013\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010\u0091\u0001\"\u0006\b¨\u0001\u0010\u0093\u0001R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010M\"\u0005\bª\u0001\u0010OR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010M\"\u0005\b¬\u0001\u0010OR,\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00032\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b®\u0001\u0010M\"\u0005\b¯\u0001\u0010OR.\u0010°\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\r8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b±\u0001\u0010\u0091\u0001\"\u0006\b²\u0001\u0010\u0093\u0001R\u001e\u0010;\u001a\u00020<X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R,\u0010·\u0001\u001a\u0004\u0018\u00010\u00032\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¸\u0001\u0010M\"\u0005\b¹\u0001\u0010OR0\u0010º\u0001\u001a\u0005\u0018\u00010\u0099\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b»\u0001\u0010\u009c\u0001\"\u0006\b¼\u0001\u0010\u009e\u0001R\u001c\u00100\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b½\u0001\u0010I\"\u0005\b¾\u0001\u0010KR \u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¿\u0001\u0010\u0091\u0001\"\u0006\bÀ\u0001\u0010\u0093\u0001¨\u0006þ\u0001"}, d2 = {"Lcom/ss/android/ugc/aweme/ktv/KtvRecordParam;", "Ljava/io/Serializable;", "id", "", "musicId", "needFetchMusic", "", "musicSelectedFrom", "title", "author", "recordMode", "", "voiceTrack", "Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;", VERecordData.AUDIOPATHS, "", "audioDurations", "originTrack", "originTrackPath", "subTrack", "subTrackPath", "duration", "shootDuration", "auditionDuration", "fullSongShootDuration", "lyricUrl", "Lcom/ss/android/ugc/aweme/base/model/UrlModel;", "lyricLines", "Ljava/util/TreeMap;", "Lcom/ss/android/ugc/aweme/ktv/LyricsLineInfo;", "lyricPath", "lyricType", "lyricStartTime", "coverMedium", "coverLarge", "showAuthor", "lyricEffect", "Lcom/ss/android/ugc/aweme/ktv/SimpleEffect;", "fontEffect", "authorEffect", "mvVideoEffectPath", "mvImageEffectPath", "mvMode", "mvVideoResEffect", "mvFilePaths", "Ljava/util/ArrayList;", "mvFileTypes", "mvFileDurations", QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "adjustedStickerPosition", "enterMethod", "shootWay", "shootPageEnterMethod", "isPgc", "customSegmentInfo", "Lcom/ss/android/ugc/aweme/ktv/CustomSegmentInfo;", "isFull", "isFollowSing", "isQuickShoot", "tuningData", "Lcom/ss/android/ugc/aweme/ktv/TuningData;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/ss/android/ugc/aweme/ktv/KtvAudioParam;Ljava/util/List;Ljava/util/List;Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;Ljava/lang/String;Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;Ljava/lang/String;IIIILcom/ss/android/ugc/aweme/base/model/UrlModel;Ljava/util/TreeMap;Ljava/lang/String;IILcom/ss/android/ugc/aweme/base/model/UrlModel;Lcom/ss/android/ugc/aweme/base/model/UrlModel;ZLcom/ss/android/ugc/aweme/ktv/SimpleEffect;Lcom/ss/android/ugc/aweme/ktv/SimpleEffect;Lcom/ss/android/ugc/aweme/ktv/SimpleEffect;Ljava/lang/String;Ljava/lang/String;ILcom/ss/android/ugc/aweme/ktv/SimpleEffect;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/ss/android/ugc/aweme/ktv/CustomSegmentInfo;ZZZLcom/ss/android/ugc/aweme/ktv/TuningData;)V", "getAdjustedStickerPosition", "()Z", "setAdjustedStickerPosition", "(Z)V", "getAudioDurations", "()Ljava/util/List;", "setAudioDurations", "(Ljava/util/List;)V", "getAudioPaths", "setAudioPaths", "getAuditionDuration", "()I", "setAuditionDuration", "(I)V", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "getAuthorEffect", "()Lcom/ss/android/ugc/aweme/ktv/SimpleEffect;", "setAuthorEffect", "(Lcom/ss/android/ugc/aweme/ktv/SimpleEffect;)V", "getCoverLarge", "()Lcom/ss/android/ugc/aweme/base/model/UrlModel;", "setCoverLarge", "(Lcom/ss/android/ugc/aweme/base/model/UrlModel;)V", "getCoverMedium", "setCoverMedium", "getCustomSegmentInfo", "()Lcom/ss/android/ugc/aweme/ktv/CustomSegmentInfo;", "setCustomSegmentInfo", "(Lcom/ss/android/ugc/aweme/ktv/CustomSegmentInfo;)V", "getDuration", "setDuration", "getEnterMethod", "setEnterMethod", "getFontEffect", "setFontEffect", "getFullSongShootDuration", "setFullSongShootDuration", "getId", "setId", "setFollowSing", "setFull", "setPgc", "setQuickShoot", "getLyricEffect", "setLyricEffect", "getLyricLines", "()Ljava/util/TreeMap;", "setLyricLines", "(Ljava/util/TreeMap;)V", "getLyricPath", "setLyricPath", "getLyricStartTime", "setLyricStartTime", "getLyricType", "setLyricType", "getLyricUrl", "setLyricUrl", "getMusicId", "setMusicId", "getMusicSelectedFrom", "setMusicSelectedFrom", "getMvFileDurations", "()Ljava/util/ArrayList;", "setMvFileDurations", "(Ljava/util/ArrayList;)V", "getMvFilePaths", "setMvFilePaths", "getMvFileTypes", "setMvFileTypes", "getMvImageEffectPath", "setMvImageEffectPath", "getMvMode", "setMvMode", "getMvVideoEffectPath", "setMvVideoEffectPath", "getMvVideoResEffect", "setMvVideoResEffect", "getNeedFetchMusic", "setNeedFetchMusic", "getOriginTrack", "()Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;", "setOriginTrack", "(Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;)V", "getOriginTrackPath", "setOriginTrackPath", "getRecordMode", "setRecordMode", "value", "Lcom/ss/android/ugc/aweme/ktv/ReverberationData;", "reverberation", "getReverberation", "()Lcom/ss/android/ugc/aweme/ktv/ReverberationData;", "setReverberation", "(Lcom/ss/android/ugc/aweme/ktv/ReverberationData;)V", "getShootDuration", "setShootDuration", "getShootPageEnterMethod", "setShootPageEnterMethod", "getShootWay", "setShootWay", "getShowAuthor", "setShowAuthor", "getSubTrack", "setSubTrack", "getSubTrackPath", "setSubTrackPath", "getTitle", d.f25925o, "tuningAudioOutputPath", "getTuningAudioOutputPath", "setTuningAudioOutputPath", "tuningAudioTrack", "getTuningAudioTrack", "setTuningAudioTrack", "getTuningData", "()Lcom/ss/android/ugc/aweme/ktv/TuningData;", "setTuningData", "(Lcom/ss/android/ugc/aweme/ktv/TuningData;)V", "tuningMidiPath", "getTuningMidiPath", "setTuningMidiPath", "tuningReverberation", "getTuningReverberation", "setTuningReverberation", "getVideoDuration", "setVideoDuration", "getVoiceTrack", "setVoiceTrack", "accompanimentTimeIntervals", "", "Lcom/ss/android/ugc/aweme/ktv/AudioInterval;", "checkFiles", "checkTuningMidiFile", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "getAudioStartTimeOffset", "getShootSegmentDuration", "hashCode", "originalTimeIntervals", "toString", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class KtvRecordParam implements Serializable {
    private boolean adjustedStickerPosition;
    private List<Integer> audioDurations;
    private List<String> audioPaths;
    private int auditionDuration;
    private String author;
    private SimpleEffect authorEffect;
    private UrlModel coverLarge;
    private UrlModel coverMedium;
    private CustomSegmentInfo customSegmentInfo;
    private int duration;
    private String enterMethod;
    private SimpleEffect fontEffect;
    private int fullSongShootDuration;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f450956id;
    private boolean isFollowSing;
    private boolean isFull;
    private boolean isPgc;
    private boolean isQuickShoot;
    private SimpleEffect lyricEffect;
    private TreeMap<Integer, LyricsLineInfo> lyricLines;
    private String lyricPath;
    private int lyricStartTime;
    private int lyricType;
    private UrlModel lyricUrl;
    private String musicId;
    private String musicSelectedFrom;
    private ArrayList<Integer> mvFileDurations;
    private ArrayList<String> mvFilePaths;
    private ArrayList<String> mvFileTypes;
    private String mvImageEffectPath;
    private int mvMode;
    private String mvVideoEffectPath;
    private SimpleEffect mvVideoResEffect;
    private boolean needFetchMusic;
    private KtvAudioParam originTrack;
    private String originTrackPath;
    private int recordMode;
    private int shootDuration;
    private String shootPageEnterMethod;
    private String shootWay;
    private boolean showAuthor;
    private KtvAudioParam subTrack;
    private String subTrackPath;
    private String title;
    private TuningData tuningData;
    private int videoDuration;
    private KtvAudioParam voiceTrack;

    public KtvRecordParam() {
        this(null, null, false, null, null, null, 0, null, null, null, null, null, null, null, 0, 0, 0, 0, null, null, null, 0, 0, null, null, false, null, null, null, null, null, 0, null, null, null, null, 0, false, null, null, null, false, null, false, false, false, null, -1, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KtvRecordParam copy$default(KtvRecordParam r110, String r111, String r112, boolean r210, String r211, String r212, String r213, int r214, KtvAudioParam r215, List r216, List r217, KtvAudioParam r218, String r219, KtvAudioParam r310, String r311, int r312, int r313, int r314, int r315, UrlModel r316, TreeMap r317, String r318, int r319, int r410, UrlModel r411, UrlModel r412, boolean r413, SimpleEffect r414, SimpleEffect r415, SimpleEffect r416, String r417, String r418, int r419, SimpleEffect r510, ArrayList r511, ArrayList r512, ArrayList r513, int r514, boolean r515, String r516, String r517, String r518, boolean r519, CustomSegmentInfo r610, boolean r611, boolean r612, boolean r613, TuningData r614, int r615, int r616, Object r617) {
        if ((r615 & 1) == 0) goto L5;
        String r100 = r110.f450956id;
    L7:
        if ((r615 & 2) == 0) goto L9;
        String r101 = r110.musicId;
    L11:
        if ((r615 & 4) == 0) goto L13;
        boolean r102 = r110.needFetchMusic;
    L15:
        if ((r615 & 8) == 0) goto L17;
        String r103 = r110.musicSelectedFrom;
    L19:
        if ((r615 & 16) == 0) goto L21;
        String r104 = r110.title;
    L23:
        if ((r615 & 32) == 0) goto L25;
        String r105 = r110.author;
    L27:
        if ((r615 & 64) == 0) goto L29;
        int r106 = r110.recordMode;
    L31:
        if ((r615 & 128) == 0) goto L33;
        KtvAudioParam r113 = r110.voiceTrack;
    L35:
        if ((r615 & 256) == 0) goto L37;
        List r114 = r110.audioPaths;
    L39:
        if ((r615 & 512) == 0) goto L41;
        List r115 = r110.audioDurations;
    L43:
        if ((r615 & 1024) == 0) goto L45;
        KtvAudioParam r116 = r110.originTrack;
    L47:
        if ((r615 & 2048) == 0) goto L49;
        String r117 = r110.originTrackPath;
    L51:
        if ((r615 & 4096) == 0) goto L53;
        KtvAudioParam r118 = r110.subTrack;
    L54:
        KtvAudioParam r320 = r118;
        if ((r615 & 8192) == 0) goto L57;
        String r119 = r110.subTrackPath;
    L58:
        String r321 = r119;
        if ((r615 & 16384) == 0) goto L61;
        int r120 = r110.duration;
    L62:
        int r322 = r120;
        if ((r615 & 32768) == 0) goto L65;
        int r121 = r110.shootDuration;
    L66:
        int r323 = r121;
        if ((r615 & 65536) == 0) goto L69;
        int r122 = r110.auditionDuration;
    L70:
        int r324 = r122;
        if ((r615 & 131072) == 0) goto L73;
        int r123 = r110.fullSongShootDuration;
    L74:
        int r325 = r123;
        if ((r615 & 262144) == 0) goto L77;
        UrlModel r124 = r110.lyricUrl;
    L78:
        UrlModel r326 = r124;
        if ((r615 & 524288) == 0) goto L81;
        TreeMap r125 = r110.lyricLines;
    L82:
        TreeMap r327 = r125;
        if ((r615 & 1048576) == 0) goto L85;
        String r126 = r110.lyricPath;
    L86:
        String r328 = r126;
        if ((r615 & 2097152) == 0) goto L89;
        int r127 = r110.lyricType;
    L90:
        int r329 = r127;
        if ((r615 & 4194304) == 0) goto L93;
        int r128 = r110.lyricStartTime;
    L94:
        int r420 = r128;
        if ((r615 & 8388608) == 0) goto L97;
        UrlModel r129 = r110.coverMedium;
    L98:
        UrlModel r421 = r129;
        if ((r615 & 16777216) == 0) goto L101;
        UrlModel r130 = r110.coverLarge;
    L102:
        UrlModel r422 = r130;
        if ((r615 & 33554432) == 0) goto L105;
        boolean r131 = r110.showAuthor;
    L106:
        boolean r423 = r131;
        if ((r615 & 67108864) == 0) goto L109;
        SimpleEffect r132 = r110.lyricEffect;
    L110:
        SimpleEffect r424 = r132;
        if ((r615 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        SimpleEffect r133 = r110.fontEffect;
    L114:
        SimpleEffect r425 = r133;
        if ((r615 & 268435456) == 0) goto L117;
        SimpleEffect r134 = r110.authorEffect;
    L118:
        SimpleEffect r426 = r134;
        if ((r615 & 536870912) == 0) goto L121;
        String r135 = r110.mvVideoEffectPath;
    L122:
        String r427 = r135;
        if ((r615 & 1073741824) == 0) goto L125;
        String r136 = r110.mvImageEffectPath;
    L127:
        if ((r615 & Integer.MIN_VALUE) == 0) goto L129;
        int r107 = r110.mvMode;
    L130:
        int r428 = r107;
        if ((r616 & 1) == 0) goto L133;
        SimpleEffect r108 = r110.mvVideoResEffect;
    L134:
        SimpleEffect r520 = r108;
        if ((r616 & 2) == 0) goto L137;
        ArrayList r109 = r110.mvFilePaths;
    L138:
        ArrayList r521 = r109;
        if ((r616 & 4) == 0) goto L141;
        ArrayList r137 = r110.mvFileTypes;
    L142:
        ArrayList r522 = r137;
        if ((r616 & 8) == 0) goto L145;
        ArrayList r138 = r110.mvFileDurations;
    L146:
        ArrayList r523 = r138;
        if ((r616 & 16) == 0) goto L149;
        int r139 = r110.videoDuration;
    L150:
        int r524 = r139;
        if ((r616 & 32) == 0) goto L153;
        boolean r140 = r110.adjustedStickerPosition;
    L154:
        boolean r525 = r140;
        if ((r616 & 64) == 0) goto L157;
        String r141 = r110.enterMethod;
    L158:
        String r526 = r141;
        if ((r616 & 128) == 0) goto L161;
        String r142 = r110.shootWay;
    L162:
        String r527 = r142;
        if ((r616 & 256) == 0) goto L165;
        String r143 = r110.shootPageEnterMethod;
    L166:
        String r528 = r143;
        if ((r616 & 512) == 0) goto L169;
        boolean r144 = r110.isPgc;
    L170:
        boolean r529 = r144;
        if ((r616 & 1024) == 0) goto L173;
        CustomSegmentInfo r145 = r110.customSegmentInfo;
    L174:
        CustomSegmentInfo r618 = r145;
        if ((r616 & 2048) == 0) goto L177;
        boolean r146 = r110.isFull;
    L178:
        boolean r619 = r146;
        if ((r616 & 4096) == 0) goto L181;
        boolean r147 = r110.isFollowSing;
    L182:
        boolean r620 = r147;
        if ((r616 & 8192) == 0) goto L185;
        boolean r148 = r110.isQuickShoot;
    L187:
        if ((r616 & 16384) == 0) goto L189;
        TuningData r149 = r110.tuningData;
    L191:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r329, r420, r421, r422, r423, r424, r425, r426, r427, r136, r428, r520, r521, r522, r523, r524, r525, r526, r527, r528, r529, r618, r619, r620, r148, r149);
    L189:
        r149 = r614;
        goto L191
    L185:
        r148 = r613;
        goto L187
    L181:
        r147 = r612;
        goto L182
    L177:
        r146 = r611;
        goto L178
    L173:
        r145 = r610;
        goto L174
    L169:
        r144 = r519;
        goto L170
    L165:
        r143 = r518;
        goto L166
    L161:
        r142 = r517;
        goto L162
    L157:
        r141 = r516;
        goto L158
    L153:
        r140 = r515;
        goto L154
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
        r109 = r511;
        goto L138
    L133:
        r108 = r510;
        goto L134
    L129:
        r107 = r419;
        goto L130
    L125:
        r136 = r418;
        goto L127
    L121:
        r135 = r417;
        goto L122
    L117:
        r134 = r416;
        goto L118
    L113:
        r133 = r415;
        goto L114
    L109:
        r132 = r414;
        goto L110
    L105:
        r131 = r413;
        goto L106
    L101:
        r130 = r412;
        goto L102
    L97:
        r129 = r411;
        goto L98
    L93:
        r128 = r410;
        goto L94
    L89:
        r127 = r319;
        goto L90
    L85:
        r126 = r318;
        goto L86
    L81:
        r125 = r317;
        goto L82
    L77:
        r124 = r316;
        goto L78
    L73:
        r123 = r315;
        goto L74
    L69:
        r122 = r314;
        goto L70
    L65:
        r121 = r313;
        goto L66
    L61:
        r120 = r312;
        goto L62
    L57:
        r119 = r311;
        goto L58
    L53:
        r118 = r310;
        goto L54
    L49:
        r117 = r219;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
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
        return this.f450956id;
    }

    public final List<Integer> component10() {
        return this.audioDurations;
    }

    public final KtvAudioParam component11() {
        return this.originTrack;
    }

    public final String component12() {
        return this.originTrackPath;
    }

    public final KtvAudioParam component13() {
        return this.subTrack;
    }

    public final String component14() {
        return this.subTrackPath;
    }

    public final int component15() {
        return this.duration;
    }

    public final int component16() {
        return this.shootDuration;
    }

    public final int component17() {
        return this.auditionDuration;
    }

    public final int component18() {
        return this.fullSongShootDuration;
    }

    public final UrlModel component19() {
        return this.lyricUrl;
    }

    public final String component2() {
        return this.musicId;
    }

    public final TreeMap<Integer, LyricsLineInfo> component20() {
        return this.lyricLines;
    }

    public final String component21() {
        return this.lyricPath;
    }

    public final int component22() {
        return this.lyricType;
    }

    public final int component23() {
        return this.lyricStartTime;
    }

    public final UrlModel component24() {
        return this.coverMedium;
    }

    public final UrlModel component25() {
        return this.coverLarge;
    }

    public final boolean component26() {
        return this.showAuthor;
    }

    public final SimpleEffect component27() {
        return this.lyricEffect;
    }

    public final SimpleEffect component28() {
        return this.fontEffect;
    }

    public final SimpleEffect component29() {
        return this.authorEffect;
    }

    public final boolean component3() {
        return this.needFetchMusic;
    }

    public final String component30() {
        return this.mvVideoEffectPath;
    }

    public final String component31() {
        return this.mvImageEffectPath;
    }

    public final int component32() {
        return this.mvMode;
    }

    public final SimpleEffect component33() {
        return this.mvVideoResEffect;
    }

    public final ArrayList<String> component34() {
        return this.mvFilePaths;
    }

    public final ArrayList<String> component35() {
        return this.mvFileTypes;
    }

    public final ArrayList<Integer> component36() {
        return this.mvFileDurations;
    }

    public final int component37() {
        return this.videoDuration;
    }

    public final boolean component38() {
        return this.adjustedStickerPosition;
    }

    public final String component39() {
        return this.enterMethod;
    }

    public final String component4() {
        return this.musicSelectedFrom;
    }

    public final String component40() {
        return this.shootWay;
    }

    public final String component41() {
        return this.shootPageEnterMethod;
    }

    public final boolean component42() {
        return this.isPgc;
    }

    public final CustomSegmentInfo component43() {
        return this.customSegmentInfo;
    }

    public final boolean component44() {
        return this.isFull;
    }

    public final boolean component45() {
        return this.isFollowSing;
    }

    public final boolean component46() {
        return this.isQuickShoot;
    }

    public final TuningData component47() {
        return this.tuningData;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.author;
    }

    public final int component7() {
        return this.recordMode;
    }

    public final KtvAudioParam component8() {
        return this.voiceTrack;
    }

    public final List<String> component9() {
        return this.audioPaths;
    }

    public final KtvRecordParam copy(String r510, String r511, boolean r512, String r513, String r514, String r515, int r516, KtvAudioParam r517, List<String> r518, List<Integer> r519, KtvAudioParam r610, String r611, KtvAudioParam r612, String r613, int r614, int r615, int r616, int r617, UrlModel r618, TreeMap<Integer, LyricsLineInfo> r619, String r710, int r711, int r712, UrlModel r713, UrlModel r714, boolean r715, SimpleEffect r716, SimpleEffect r717, SimpleEffect r718, String r719, String r810, int r811, SimpleEffect r812, ArrayList<String> r813, ArrayList<String> r814, ArrayList<Integer> r815, int r816, boolean r817, String r818, String r819, String r910, boolean r911, CustomSegmentInfo r912, boolean r913, boolean r914, boolean r915, TuningData r916) {
        Intrinsics.checkNotNullParameter(r518, VERecordData.AUDIOPATHS);
        Intrinsics.checkNotNullParameter(r519, "audioDurations");
        Intrinsics.checkNotNullParameter(r813, "mvFilePaths");
        Intrinsics.checkNotNullParameter(r814, "mvFileTypes");
        Intrinsics.checkNotNullParameter(r815, "mvFileDurations");
        Intrinsics.checkNotNullParameter(r916, "tuningData");
        return new KtvRecordParam(r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof KtvRecordParam) == false) goto L100;
        KtvRecordParam r101 = (KtvRecordParam) r100;
        if (Intrinsics.areEqual(this.f450956id, r101.f450956id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.musicId, r101.musicId) == true) goto L10;
        return false;
    L10:
        if (this.needFetchMusic == r101.needFetchMusic) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.musicSelectedFrom, r101.musicSelectedFrom) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.author, r101.author) == true) goto L18;
        return false;
    L18:
        if (this.recordMode == r101.recordMode) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.voiceTrack, r101.voiceTrack) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.audioPaths, r101.audioPaths) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.audioDurations, r101.audioDurations) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.originTrack, r101.originTrack) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.originTrackPath, r101.originTrackPath) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.subTrack, r101.subTrack) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.subTrackPath, r101.subTrackPath) == true) goto L34;
        return false;
    L34:
        if (this.duration == r101.duration) goto L36;
        return false;
    L36:
        if (this.shootDuration == r101.shootDuration) goto L38;
        return false;
    L38:
        if (this.auditionDuration == r101.auditionDuration) goto L40;
        return false;
    L40:
        if (this.fullSongShootDuration == r101.fullSongShootDuration) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.lyricUrl, r101.lyricUrl) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.lyricLines, r101.lyricLines) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.lyricPath, r101.lyricPath) == true) goto L48;
        return false;
    L48:
        if (this.lyricType == r101.lyricType) goto L50;
        return false;
    L50:
        if (this.lyricStartTime == r101.lyricStartTime) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.coverMedium, r101.coverMedium) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.coverLarge, r101.coverLarge) == true) goto L56;
        return false;
    L56:
        if (this.showAuthor == r101.showAuthor) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.lyricEffect, r101.lyricEffect) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.fontEffect, r101.fontEffect) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.authorEffect, r101.authorEffect) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.mvVideoEffectPath, r101.mvVideoEffectPath) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.mvImageEffectPath, r101.mvImageEffectPath) == true) goto L68;
        return false;
    L68:
        if (this.mvMode == r101.mvMode) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.mvVideoResEffect, r101.mvVideoResEffect) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.mvFilePaths, r101.mvFilePaths) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.mvFileTypes, r101.mvFileTypes) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.mvFileDurations, r101.mvFileDurations) == true) goto L78;
        return false;
    L78:
        if (this.videoDuration == r101.videoDuration) goto L80;
        return false;
    L80:
        if (this.adjustedStickerPosition == r101.adjustedStickerPosition) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.shootWay, r101.shootWay) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.shootPageEnterMethod, r101.shootPageEnterMethod) == true) goto L88;
        return false;
    L88:
        if (this.isPgc == r101.isPgc) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.customSegmentInfo, r101.customSegmentInfo) == true) goto L92;
        return false;
    L92:
        if (this.isFull == r101.isFull) goto L94;
        return false;
    L94:
        if (this.isFollowSing == r101.isFollowSing) goto L96;
        return false;
    L96:
        if (this.isQuickShoot == r101.isQuickShoot) goto L98;
        return false;
    L98:
        if (Intrinsics.areEqual(this.tuningData, r101.tuningData) == true) goto L151;
        return false;
    L151:
        return true;
    L100:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v100, types: [int] */
    /* JADX WARN: Type inference failed for: r2v105, types: [int] */
    /* JADX WARN: Type inference failed for: r2v107, types: [int] */
    /* JADX WARN: Type inference failed for: r2v110 */
    /* JADX WARN: Type inference failed for: r2v111 */
    /* JADX WARN: Type inference failed for: r2v113 */
    /* JADX WARN: Type inference failed for: r2v117 */
    /* JADX WARN: Type inference failed for: r2v127 */
    /* JADX WARN: Type inference failed for: r2v143 */
    /* JADX WARN: Type inference failed for: r2v145 */
    /* JADX WARN: Type inference failed for: r2v146 */
    /* JADX WARN: Type inference failed for: r2v147 */
    /* JADX WARN: Type inference failed for: r2v148 */
    /* JADX WARN: Type inference failed for: r2v149 */
    /* JADX WARN: Type inference failed for: r2v150 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v58, types: [int] */
    /* JADX WARN: Type inference failed for: r2v89, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r100 = this.f450956id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.musicId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.needFetchMusic;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        String r111 = this.musicSelectedFrom;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        String r114 = this.title;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        String r117 = this.author;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (((r116 + r118) * 31) + this.recordMode) * 31;
        KtvAudioParam r120 = this.voiceTrack;
        if (r120 == null) goto L28;
        int r121 = r120.hashCode();
    L29:
        int r122 = (r119 + r121) * 31;
        List<String> r123 = this.audioPaths;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (r122 + r124) * 31;
        List<Integer> r126 = this.audioDurations;
        if (r126 == null) goto L36;
        int r127 = r126.hashCode();
    L37:
        int r128 = (r125 + r127) * 31;
        KtvAudioParam r129 = this.originTrack;
        if (r129 == null) goto L40;
        int r130 = r129.hashCode();
    L41:
        int r131 = (r128 + r130) * 31;
        String r132 = this.originTrackPath;
        if (r132 == null) goto L44;
        int r133 = r132.hashCode();
    L45:
        int r134 = (r131 + r133) * 31;
        KtvAudioParam r135 = this.subTrack;
        if (r135 == null) goto L48;
        int r136 = r135.hashCode();
    L49:
        int r137 = (r134 + r136) * 31;
        String r138 = this.subTrackPath;
        if (r138 == null) goto L52;
        int r139 = r138.hashCode();
    L53:
        int r140 = (((((((((r137 + r139) * 31) + this.duration) * 31) + this.shootDuration) * 31) + this.auditionDuration) * 31) + this.fullSongShootDuration) * 31;
        UrlModel r141 = this.lyricUrl;
        if (r141 == null) goto L56;
        int r142 = r141.hashCode();
    L57:
        int r143 = (r140 + r142) * 31;
        TreeMap<Integer, LyricsLineInfo> r144 = this.lyricLines;
        if (r144 == null) goto L60;
        int r145 = r144.hashCode();
    L61:
        int r146 = (r143 + r145) * 31;
        String r147 = this.lyricPath;
        if (r147 == null) goto L64;
        int r148 = r147.hashCode();
    L65:
        int r149 = (((((r146 + r148) * 31) + this.lyricType) * 31) + this.lyricStartTime) * 31;
        UrlModel r150 = this.coverMedium;
        if (r150 == null) goto L68;
        int r151 = r150.hashCode();
    L69:
        int r152 = (r149 + r151) * 31;
        UrlModel r153 = this.coverLarge;
        if (r153 == null) goto L72;
        int r154 = r153.hashCode();
    L73:
        int r155 = (r152 + r154) * 31;
        boolean r156 = this.showAuthor;
        ?? r157 = r156;
        if (r156 == false) goto L76;
        r157 = 1;
    L76:
        int r158 = (r155 + r157) * 31;
        SimpleEffect r159 = this.lyricEffect;
        if (r159 == null) goto L79;
        int r160 = r159.hashCode();
    L80:
        int r161 = (r158 + r160) * 31;
        SimpleEffect r162 = this.fontEffect;
        if (r162 == null) goto L83;
        int r163 = r162.hashCode();
    L84:
        int r164 = (r161 + r163) * 31;
        SimpleEffect r165 = this.authorEffect;
        if (r165 == null) goto L87;
        int r166 = r165.hashCode();
    L88:
        int r167 = (r164 + r166) * 31;
        String r168 = this.mvVideoEffectPath;
        if (r168 == null) goto L91;
        int r169 = r168.hashCode();
    L92:
        int r170 = (r167 + r169) * 31;
        String r171 = this.mvImageEffectPath;
        if (r171 == null) goto L95;
        int r172 = r171.hashCode();
    L96:
        int r173 = (((r170 + r172) * 31) + this.mvMode) * 31;
        SimpleEffect r174 = this.mvVideoResEffect;
        if (r174 == null) goto L99;
        int r175 = r174.hashCode();
    L100:
        int r176 = (r173 + r175) * 31;
        ArrayList<String> r177 = this.mvFilePaths;
        if (r177 == null) goto L103;
        int r178 = r177.hashCode();
    L104:
        int r179 = (r176 + r178) * 31;
        ArrayList<String> r180 = this.mvFileTypes;
        if (r180 == null) goto L107;
        int r181 = r180.hashCode();
    L108:
        int r182 = (r179 + r181) * 31;
        ArrayList<Integer> r183 = this.mvFileDurations;
        if (r183 == null) goto L111;
        int r184 = r183.hashCode();
    L112:
        int r185 = (((r182 + r184) * 31) + this.videoDuration) * 31;
        boolean r186 = this.adjustedStickerPosition;
        ?? r187 = r186;
        if (r186 == false) goto L115;
        r187 = 1;
    L115:
        int r188 = (r185 + r187) * 31;
        String r189 = this.enterMethod;
        if (r189 == null) goto L118;
        int r190 = r189.hashCode();
    L119:
        int r191 = (r188 + r190) * 31;
        String r192 = this.shootWay;
        if (r192 == null) goto L122;
        int r193 = r192.hashCode();
    L123:
        int r194 = (r191 + r193) * 31;
        String r195 = this.shootPageEnterMethod;
        if (r195 == null) goto L126;
        int r196 = r195.hashCode();
    L127:
        int r197 = (r194 + r196) * 31;
        boolean r198 = this.isPgc;
        ?? r199 = r198;
        if (r198 == false) goto L130;
        r199 = 1;
    L130:
        int r200 = (r197 + r199) * 31;
        CustomSegmentInfo r201 = this.customSegmentInfo;
        if (r201 == null) goto L133;
        int r202 = r201.hashCode();
    L134:
        int r203 = (r200 + r202) * 31;
        boolean r204 = this.isFull;
        ?? r205 = r204;
        if (r204 == false) goto L137;
        r205 = 1;
    L137:
        int r206 = (r203 + r205) * 31;
        boolean r207 = this.isFollowSing;
        ?? r208 = r207;
        if (r207 == false) goto L140;
        r208 = 1;
    L140:
        int r209 = (r206 + r208) * 31;
        boolean r210 = this.isQuickShoot;
        if (r210 == true) goto L144;
        r108 = r210;
    L144:
        int r211 = (r209 + r108) * 31;
        TuningData r212 = this.tuningData;
        if (r212 == null) goto L148;
        r101 = r212.hashCode();
    L148:
        return r211 + r101;
    L133:
        r202 = 0;
        goto L134
    L126:
        r196 = 0;
        goto L127
    L122:
        r193 = 0;
        goto L123
    L118:
        r190 = 0;
        goto L119
    L111:
        r184 = 0;
        goto L112
    L107:
        r181 = 0;
        goto L108
    L103:
        r178 = 0;
        goto L104
    L99:
        r175 = 0;
        goto L100
    L95:
        r172 = 0;
        goto L96
    L91:
        r169 = 0;
        goto L92
    L87:
        r166 = 0;
        goto L88
    L83:
        r163 = 0;
        goto L84
    L79:
        r160 = 0;
        goto L80
    L72:
        r154 = 0;
        goto L73
    L68:
        r151 = 0;
        goto L69
    L64:
        r148 = 0;
        goto L65
    L60:
        r145 = 0;
        goto L61
    L56:
        r142 = 0;
        goto L57
    L52:
        r139 = 0;
        goto L53
    L48:
        r136 = 0;
        goto L49
    L44:
        r133 = 0;
        goto L45
    L40:
        r130 = 0;
        goto L41
    L36:
        r127 = 0;
        goto L37
    L32:
        r124 = 0;
        goto L33
    L28:
        r121 = 0;
        goto L29
    L24:
        r118 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "KtvRecordParam(id=" + this.f450956id + ", musicId=" + this.musicId + ", needFetchMusic=" + this.needFetchMusic + ", musicSelectedFrom=" + this.musicSelectedFrom + ", title=" + this.title + ", author=" + this.author + ", recordMode=" + this.recordMode + ", voiceTrack=" + this.voiceTrack + ", audioPaths=" + this.audioPaths + ", audioDurations=" + this.audioDurations + ", originTrack=" + this.originTrack + ", originTrackPath=" + this.originTrackPath + ", subTrack=" + this.subTrack + ", subTrackPath=" + this.subTrackPath + ", duration=" + this.duration + ", shootDuration=" + this.shootDuration + ", auditionDuration=" + this.auditionDuration + ", fullSongShootDuration=" + this.fullSongShootDuration + ", lyricUrl=" + this.lyricUrl + ", lyricLines=" + this.lyricLines + ", lyricPath=" + this.lyricPath + ", lyricType=" + this.lyricType + ", lyricStartTime=" + this.lyricStartTime + ", coverMedium=" + this.coverMedium + ", coverLarge=" + this.coverLarge + ", showAuthor=" + this.showAuthor + ", lyricEffect=" + this.lyricEffect + ", fontEffect=" + this.fontEffect + ", authorEffect=" + this.authorEffect + ", mvVideoEffectPath=" + this.mvVideoEffectPath + ", mvImageEffectPath=" + this.mvImageEffectPath + ", mvMode=" + this.mvMode + ", mvVideoResEffect=" + this.mvVideoResEffect + ", mvFilePaths=" + this.mvFilePaths + ", mvFileTypes=" + this.mvFileTypes + ", mvFileDurations=" + this.mvFileDurations + ", videoDuration=" + this.videoDuration + ", adjustedStickerPosition=" + this.adjustedStickerPosition + ", enterMethod=" + this.enterMethod + ", shootWay=" + this.shootWay + ", shootPageEnterMethod=" + this.shootPageEnterMethod + ", isPgc=" + this.isPgc + ", customSegmentInfo=" + this.customSegmentInfo + ", isFull=" + this.isFull + ", isFollowSing=" + this.isFollowSing + ", isQuickShoot=" + this.isQuickShoot + ", tuningData=" + this.tuningData + ")";
    }

    private final boolean checkTuningMidiFile() {
        if (this.tuningData.getTuningAudioTrack() != null) goto L5;
    L10:
        return true;
    L5:
        if (this.tuningData.getTuningAudioTrack() != null) goto L7;
    L9:
        return false;
    L7:
        if (f.a(this.tuningData.getTuningMidiPath()) == false) goto L9;
        goto L9
    }

    public final List<AudioInterval> accompanimentTimeIntervals() {
        KtvAudioParam r100 = this.subTrack;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTimeList();
    }

    public final boolean checkFiles() {
        if (f.a(this.originTrackPath) == true) goto L5;
    L11:
        return false;
    L5:
        if (f.a(this.subTrackPath) == false) goto L11;
        if (f.a(this.lyricPath) == false) goto L11;
        if (checkTuningMidiFile() == false) goto L11;
        return true;
    }

    public final int getAudioStartTimeOffset() {
        CustomSegmentInfo r100 = this.customSegmentInfo;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        return r100.getStartTimeOffset();
    L5:
        return 0;
    }

    public final ReverberationData getReverberation() {
        return this.tuningData.getReverberation();
    }

    public final int getShootSegmentDuration() {
        CustomSegmentInfo r100 = this.customSegmentInfo;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        return r100.getShootDuration();
    L6:
        return this.shootDuration;
    }

    public final String getTuningAudioOutputPath() {
        return this.tuningData.getTuningAudioOutputPath();
    }

    public final KtvAudioParam getTuningAudioTrack() {
        return this.tuningData.getTuningAudioTrack();
    }

    public final String getTuningMidiPath() {
        return this.tuningData.getTuningMidiPath();
    }

    public final ReverberationData getTuningReverberation() {
        return this.tuningData.getTuningReverberation();
    }

    public final List<AudioInterval> originalTimeIntervals() {
        KtvAudioParam r100 = this.originTrack;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTimeList();
    }

    public final boolean getAdjustedStickerPosition() {
        return this.adjustedStickerPosition;
    }

    public final List<Integer> getAudioDurations() {
        return this.audioDurations;
    }

    public final List<String> getAudioPaths() {
        return this.audioPaths;
    }

    public final int getAuditionDuration() {
        return this.auditionDuration;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final SimpleEffect getAuthorEffect() {
        return this.authorEffect;
    }

    public final UrlModel getCoverLarge() {
        return this.coverLarge;
    }

    public final UrlModel getCoverMedium() {
        return this.coverMedium;
    }

    public final CustomSegmentInfo getCustomSegmentInfo() {
        return this.customSegmentInfo;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final SimpleEffect getFontEffect() {
        return this.fontEffect;
    }

    public final int getFullSongShootDuration() {
        return this.fullSongShootDuration;
    }

    public final String getId() {
        return this.f450956id;
    }

    public final SimpleEffect getLyricEffect() {
        return this.lyricEffect;
    }

    public final TreeMap<Integer, LyricsLineInfo> getLyricLines() {
        return this.lyricLines;
    }

    public final String getLyricPath() {
        return this.lyricPath;
    }

    public final int getLyricStartTime() {
        return this.lyricStartTime;
    }

    public final int getLyricType() {
        return this.lyricType;
    }

    public final UrlModel getLyricUrl() {
        return this.lyricUrl;
    }

    public final String getMusicId() {
        return this.musicId;
    }

    public final String getMusicSelectedFrom() {
        return this.musicSelectedFrom;
    }

    public final ArrayList<Integer> getMvFileDurations() {
        return this.mvFileDurations;
    }

    public final ArrayList<String> getMvFilePaths() {
        return this.mvFilePaths;
    }

    public final ArrayList<String> getMvFileTypes() {
        return this.mvFileTypes;
    }

    public final String getMvImageEffectPath() {
        return this.mvImageEffectPath;
    }

    public final int getMvMode() {
        return this.mvMode;
    }

    public final String getMvVideoEffectPath() {
        return this.mvVideoEffectPath;
    }

    public final SimpleEffect getMvVideoResEffect() {
        return this.mvVideoResEffect;
    }

    public final boolean getNeedFetchMusic() {
        return this.needFetchMusic;
    }

    public final KtvAudioParam getOriginTrack() {
        return this.originTrack;
    }

    public final String getOriginTrackPath() {
        return this.originTrackPath;
    }

    public final int getRecordMode() {
        return this.recordMode;
    }

    public final int getShootDuration() {
        return this.shootDuration;
    }

    public final String getShootPageEnterMethod() {
        return this.shootPageEnterMethod;
    }

    public final String getShootWay() {
        return this.shootWay;
    }

    public final boolean getShowAuthor() {
        return this.showAuthor;
    }

    public final KtvAudioParam getSubTrack() {
        return this.subTrack;
    }

    public final String getSubTrackPath() {
        return this.subTrackPath;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TuningData getTuningData() {
        return this.tuningData;
    }

    public final int getVideoDuration() {
        return this.videoDuration;
    }

    public final KtvAudioParam getVoiceTrack() {
        return this.voiceTrack;
    }

    public final boolean isFollowSing() {
        return this.isFollowSing;
    }

    public final boolean isFull() {
        return this.isFull;
    }

    public final boolean isPgc() {
        return this.isPgc;
    }

    public final boolean isQuickShoot() {
        return this.isQuickShoot;
    }

    public final void setAdjustedStickerPosition(boolean r100) {
        this.adjustedStickerPosition = r100;
    }

    public final void setAudioDurations(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.audioDurations = r100;
    }

    public final void setAudioPaths(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.audioPaths = r100;
    }

    public final void setAuditionDuration(int r100) {
        this.auditionDuration = r100;
    }

    public final void setAuthor(String r100) {
        this.author = r100;
    }

    public final void setAuthorEffect(SimpleEffect r100) {
        this.authorEffect = r100;
    }

    public final void setCoverLarge(UrlModel r100) {
        this.coverLarge = r100;
    }

    public final void setCoverMedium(UrlModel r100) {
        this.coverMedium = r100;
    }

    public final void setCustomSegmentInfo(CustomSegmentInfo r100) {
        this.customSegmentInfo = r100;
    }

    public final void setDuration(int r100) {
        this.duration = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setFollowSing(boolean r100) {
        this.isFollowSing = r100;
    }

    public final void setFontEffect(SimpleEffect r100) {
        this.fontEffect = r100;
    }

    public final void setFull(boolean r100) {
        this.isFull = r100;
    }

    public final void setFullSongShootDuration(int r100) {
        this.fullSongShootDuration = r100;
    }

    public final void setId(String r100) {
        this.f450956id = r100;
    }

    public final void setLyricEffect(SimpleEffect r100) {
        this.lyricEffect = r100;
    }

    public final void setLyricLines(TreeMap<Integer, LyricsLineInfo> r100) {
        this.lyricLines = r100;
    }

    public final void setLyricPath(String r100) {
        this.lyricPath = r100;
    }

    public final void setLyricStartTime(int r100) {
        this.lyricStartTime = r100;
    }

    public final void setLyricType(int r100) {
        this.lyricType = r100;
    }

    public final void setLyricUrl(UrlModel r100) {
        this.lyricUrl = r100;
    }

    public final void setMusicId(String r100) {
        this.musicId = r100;
    }

    public final void setMusicSelectedFrom(String r100) {
        this.musicSelectedFrom = r100;
    }

    public final void setMvFileDurations(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mvFileDurations = r100;
    }

    public final void setMvFilePaths(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mvFilePaths = r100;
    }

    public final void setMvFileTypes(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mvFileTypes = r100;
    }

    public final void setMvImageEffectPath(String r100) {
        this.mvImageEffectPath = r100;
    }

    public final void setMvMode(int r100) {
        this.mvMode = r100;
    }

    public final void setMvVideoEffectPath(String r100) {
        this.mvVideoEffectPath = r100;
    }

    public final void setMvVideoResEffect(SimpleEffect r100) {
        this.mvVideoResEffect = r100;
    }

    public final void setNeedFetchMusic(boolean r100) {
        this.needFetchMusic = r100;
    }

    public final void setOriginTrack(KtvAudioParam r100) {
        this.originTrack = r100;
    }

    public final void setOriginTrackPath(String r100) {
        this.originTrackPath = r100;
    }

    public final void setPgc(boolean r100) {
        this.isPgc = r100;
    }

    public final void setQuickShoot(boolean r100) {
        this.isQuickShoot = r100;
    }

    public final void setRecordMode(int r100) {
        this.recordMode = r100;
    }

    public final void setReverberation(ReverberationData r100) {
        this.tuningData.setReverberation(r100);
    }

    public final void setShootDuration(int r100) {
        this.shootDuration = r100;
    }

    public final void setShootPageEnterMethod(String r100) {
        this.shootPageEnterMethod = r100;
    }

    public final void setShootWay(String r100) {
        this.shootWay = r100;
    }

    public final void setShowAuthor(boolean r100) {
        this.showAuthor = r100;
    }

    public final void setSubTrack(KtvAudioParam r100) {
        this.subTrack = r100;
    }

    public final void setSubTrackPath(String r100) {
        this.subTrackPath = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setTuningAudioOutputPath(String r100) {
        this.tuningData.setTuningAudioOutputPath(r100);
    }

    public final void setTuningAudioTrack(KtvAudioParam r100) {
        this.tuningData.setTuningAudioTrack(r100);
    }

    public final void setTuningData(TuningData r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tuningData = r100;
    }

    public final void setTuningMidiPath(String r100) {
        this.tuningData.setTuningMidiPath(r100);
    }

    public final void setTuningReverberation(ReverberationData r100) {
        this.tuningData.setTuningReverberation(r100);
    }

    public final void setVideoDuration(int r100) {
        this.videoDuration = r100;
    }

    public final void setVoiceTrack(KtvAudioParam r100) {
        this.voiceTrack = r100;
    }

    public KtvRecordParam(String r100, String r110, boolean r111, String r112, String r113, String r114, int r115, KtvAudioParam r116, List<String> r117, List<Integer> r118, KtvAudioParam r119, String r210, KtvAudioParam r211, String r212, int r213, int r214, int r215, int r216, UrlModel r217, TreeMap<Integer, LyricsLineInfo> r218, String r219, int r310, int r311, UrlModel r312, UrlModel r313, boolean r314, SimpleEffect r315, SimpleEffect r316, SimpleEffect r317, String r318, String r319, int r410, SimpleEffect r411, ArrayList<String> r412, ArrayList<String> r413, ArrayList<Integer> r414, int r415, boolean r416, String r417, String r418, String r419, boolean r510, CustomSegmentInfo r511, boolean r512, boolean r513, boolean r514, TuningData r515) {
        Intrinsics.checkNotNullParameter(r117, VERecordData.AUDIOPATHS);
        Intrinsics.checkNotNullParameter(r118, "audioDurations");
        Intrinsics.checkNotNullParameter(r412, "mvFilePaths");
        Intrinsics.checkNotNullParameter(r413, "mvFileTypes");
        Intrinsics.checkNotNullParameter(r414, "mvFileDurations");
        Intrinsics.checkNotNullParameter(r515, "tuningData");
        this.f450956id = r100;
        this.musicId = r110;
        this.needFetchMusic = r111;
        this.musicSelectedFrom = r112;
        this.title = r113;
        this.author = r114;
        this.recordMode = r115;
        this.voiceTrack = r116;
        this.audioPaths = r117;
        this.audioDurations = r118;
        this.originTrack = r119;
        this.originTrackPath = r210;
        this.subTrack = r211;
        this.subTrackPath = r212;
        this.duration = r213;
        this.shootDuration = r214;
        this.auditionDuration = r215;
        this.fullSongShootDuration = r216;
        this.lyricUrl = r217;
        this.lyricLines = r218;
        this.lyricPath = r219;
        this.lyricType = r310;
        this.lyricStartTime = r311;
        this.coverMedium = r312;
        this.coverLarge = r313;
        this.showAuthor = r314;
        this.lyricEffect = r315;
        this.fontEffect = r316;
        this.authorEffect = r317;
        this.mvVideoEffectPath = r318;
        this.mvImageEffectPath = r319;
        this.mvMode = r410;
        this.mvVideoResEffect = r411;
        this.mvFilePaths = r412;
        this.mvFileTypes = r413;
        this.mvFileDurations = r414;
        this.videoDuration = r415;
        this.adjustedStickerPosition = r416;
        this.enterMethod = r417;
        this.shootWay = r418;
        this.shootPageEnterMethod = r419;
        this.isPgc = r510;
        this.customSegmentInfo = r511;
        this.isFull = r512;
        this.isFollowSing = r513;
        this.isQuickShoot = r514;
        this.tuningData = r515;
    }

    public /* synthetic */ KtvRecordParam(String r410, String r411, boolean r412, String r510, String r511, String r512, int r513, KtvAudioParam r514, List r515, List r516, KtvAudioParam r517, String r518, KtvAudioParam r519, String r610, int r611, int r612, int r613, int r614, UrlModel r615, TreeMap r616, String r617, int r618, int r619, UrlModel r710, UrlModel r711, boolean r712, SimpleEffect r713, SimpleEffect r714, SimpleEffect r715, String r716, String r717, int r718, SimpleEffect r719, ArrayList r810, ArrayList r811, ArrayList r812, int r813, boolean r814, String r815, String r816, String r817, boolean r818, CustomSegmentInfo r819, boolean r910, boolean r911, boolean r912, TuningData r913, int r914, int r915, DefaultConstructorMarker r916) {
        if ((r914 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r914 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r914 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r914 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r914 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r914 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r914 & 64) == 0) goto L29;
        int r110 = -1;
    L31:
        if ((r914 & 128) == 0) goto L33;
        KtvAudioParam r111 = null;
    L35:
        if ((r914 & 256) == 0) goto L37;
        List r112 = new ArrayList();
    L39:
        if ((r914 & 512) == 0) goto L41;
        List r113 = new ArrayList();
    L43:
        if ((r914 & 1024) == 0) goto L45;
        KtvAudioParam r114 = null;
    L47:
        if ((r914 & 2048) == 0) goto L49;
        String r115 = null;
    L51:
        if ((r914 & 4096) == 0) goto L53;
        KtvAudioParam r106 = null;
    L55:
        if ((r914 & 8192) == 0) goto L57;
        String r107 = null;
    L58:
        String r116 = r107;
        if ((r914 & 16384) == 0) goto L61;
        int r108 = 0;
    L63:
        if ((r914 & 32768) == 0) goto L65;
        int r117 = 0;
    L67:
        if ((r914 & 65536) == 0) goto L69;
        int r118 = 0;
    L71:
        if ((r914 & 131072) == 0) goto L73;
        int r119 = 0;
    L75:
        if ((r914 & 262144) == 0) goto L77;
        UrlModel r210 = null;
    L79:
        if ((r914 & 524288) == 0) goto L81;
        TreeMap r211 = null;
    L83:
        if ((r914 & 1048576) == 0) goto L85;
        String r212 = null;
    L87:
        if ((r914 & 2097152) == 0) goto L89;
        int r213 = 0;
    L91:
        if ((r914 & 4194304) == 0) goto L93;
        int r214 = 0;
    L95:
        if ((r914 & 8388608) == 0) goto L97;
        UrlModel r215 = null;
    L99:
        if ((r914 & 16777216) == 0) goto L101;
        UrlModel r216 = null;
    L103:
        if ((r914 & 33554432) == 0) goto L105;
        boolean r217 = false;
    L107:
        if ((r914 & 67108864) == 0) goto L109;
        SimpleEffect r218 = null;
    L111:
        if ((r914 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        SimpleEffect r219 = null;
    L115:
        if ((r914 & 268435456) == 0) goto L117;
        SimpleEffect r310 = null;
    L119:
        if ((r914 & 536870912) == 0) goto L121;
        String r311 = null;
    L123:
        if ((r914 & 1073741824) == 0) goto L125;
        String r312 = null;
    L127:
        if ((r914 & Integer.MIN_VALUE) == 0) goto L129;
        int r109 = 0;
    L131:
        if ((r915 & 1) == 0) goto L133;
        SimpleEffect r313 = null;
    L135:
        if ((r915 & 2) == 0) goto L137;
        ArrayList r314 = new ArrayList();
    L139:
        if ((r915 & 4) == 0) goto L141;
        ArrayList r315 = new ArrayList();
    L143:
        if ((r915 & 8) == 0) goto L145;
        ArrayList r316 = new ArrayList();
    L147:
        if ((r915 & 16) == 0) goto L149;
        int r317 = 0;
    L151:
        if ((r915 & 32) == 0) goto L153;
        boolean r318 = false;
    L155:
        if ((r915 & 64) == 0) goto L157;
        String r319 = null;
    L158:
        int r917 = r109;
        if ((r915 & 128) == 0) goto L161;
        String r120 = null;
    L162:
        String r413 = r120;
        if ((r915 & 256) == 0) goto L165;
        String r121 = null;
    L166:
        String r414 = r121;
        if ((r915 & 512) == 0) goto L169;
        boolean r122 = true;
    L170:
        boolean r415 = r122;
        if ((r915 & 1024) == 0) goto L173;
        CustomSegmentInfo r123 = null;
    L174:
        CustomSegmentInfo r918 = r123;
        if ((r915 & 2048) == 0) goto L177;
        boolean r124 = false;
    L178:
        boolean r416 = r124;
        if ((r915 & 4096) == 0) goto L181;
        boolean r125 = false;
    L182:
        boolean r417 = r125;
        if ((r915 & 8192) == 0) goto L185;
        boolean r126 = false;
    L187:
        if ((r915 & 16384) == 0) goto L189;
        TuningData r127 = new TuningData(null, false, null, null, null, null, null, null, null, 0, null, false, 0, false, null, null, false, null, null, null, 0, 2097151, null);
    L190:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r116, r108, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r917, r313, r314, r315, r316, r317, r318, r319, r413, r414, r415, r918, r416, r417, r126, r127);
        return;
    L189:
        r127 = r913;
        goto L190
    L185:
        r126 = r912;
        goto L187
    L181:
        r125 = r911;
        goto L182
    L177:
        r124 = r910;
        goto L178
    L173:
        r123 = r819;
        goto L174
    L169:
        r122 = r818;
        goto L170
    L165:
        r121 = r817;
        goto L166
    L161:
        r120 = r816;
        goto L162
    L157:
        r319 = r815;
        goto L158
    L153:
        r318 = r814;
        goto L155
    L149:
        r317 = r813;
        goto L151
    L145:
        r316 = r812;
        goto L147
    L141:
        r315 = r811;
        goto L143
    L137:
        r314 = r810;
        goto L139
    L133:
        r313 = r719;
        goto L135
    L129:
        r109 = r718;
        goto L131
    L125:
        r312 = r717;
        goto L127
    L121:
        r311 = r716;
        goto L123
    L117:
        r310 = r715;
        goto L119
    L113:
        r219 = r714;
        goto L115
    L109:
        r218 = r713;
        goto L111
    L105:
        r217 = r712;
        goto L107
    L101:
        r216 = r711;
        goto L103
    L97:
        r215 = r710;
        goto L99
    L93:
        r214 = r619;
        goto L95
    L89:
        r213 = r618;
        goto L91
    L85:
        r212 = r617;
        goto L87
    L81:
        r211 = r616;
        goto L83
    L77:
        r210 = r615;
        goto L79
    L73:
        r119 = r614;
        goto L75
    L69:
        r118 = r613;
        goto L71
    L65:
        r117 = r612;
        goto L67
    L61:
        r108 = r611;
        goto L63
    L57:
        r107 = r610;
        goto L58
    L53:
        r106 = r519;
        goto L55
    L49:
        r115 = r518;
        goto L51
    L45:
        r114 = r517;
        goto L47
    L41:
        r113 = r516;
        goto L43
    L37:
        r112 = r515;
        goto L39
    L33:
        r111 = r514;
        goto L35
    L29:
        r110 = r513;
        goto L31
    L25:
        r105 = r512;
        goto L27
    L21:
        r104 = r511;
        goto L23
    L17:
        r103 = r510;
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
