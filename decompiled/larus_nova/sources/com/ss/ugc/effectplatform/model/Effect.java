package com.ss.ugc.effectplatform.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.facebook.imagepipeline.memory.PoolStatsTracker;
import com.larus.bmhome.share.panel.ShareType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.ugc.effectplatform.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\bY\n\u0002\u0010\t\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b/\b\u0017\u0018\u0000 þ\u00012\u00020\u0001:\u0002ÿ\u0001Bç\u0006\u0012\b\b\u0002\u0010&\u001a\u00020\b\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\b\b\u0002\u0010-\u001a\u00020\b\u0012\b\b\u0002\u00100\u001a\u00020\b\u0012\b\b\u0002\u00103\u001a\u00020\b\u0012\b\b\u0002\u00107\u001a\u000206\u0012\b\b\u0002\u0010=\u001a\u000206\u0012\b\b\u0002\u0010@\u001a\u000206\u0012\b\b\u0002\u0010C\u001a\u000206\u0012\b\b\u0002\u0010F\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\u0010\b\u0002\u0010P\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\b\b\u0002\u0010S\u001a\u00020\b\u0012\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\u000e\b\u0002\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00000\n\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010_\u001a\u00020\u0006\u0012\b\b\u0002\u0010b\u001a\u00020\u0006\u0012\b\b\u0002\u0010e\u001a\u00020\b\u0012\b\b\u0002\u0010h\u001a\u00020\b\u0012\b\b\u0002\u0010k\u001a\u00020\b\u0012\b\b\u0002\u0010n\u001a\u00020\b\u0012\u0010\b\u0002\u0010q\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010w\u001a\u00020\b\u0012\b\b\u0002\u0010z\u001a\u00020\b\u0012\b\b\u0002\u0010}\u001a\u00020\b\u0012\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0085\u0001\u001a\u00020\b\u0012\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u008a\u0001\u001a\u00020\b\u0012\u0011\b\u0002\u0010\u008d\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\n\b\u0002\u0010\u0091\u0001\u001a\u00030\u0090\u0001\u0012\t\b\u0002\u0010\u0097\u0001\u001a\u00020\b\u0012\u0011\b\u0002\u0010\u009a\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\n\b\u0002\u0010\u009d\u0001\u001a\u00030\u0090\u0001\u0012\u000b\b\u0002\u0010 \u0001\u001a\u0004\u0018\u00010\b\u0012\u0011\b\u0002\u0010£\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\u0011\b\u0002\u0010¦\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\t\b\u0002\u0010©\u0001\u001a\u00020\b\u0012\t\b\u0002\u0010¬\u0001\u001a\u00020\b\u0012\t\b\u0002\u0010¯\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010±\u0001\u001a\u00020\b\u0012\t\b\u0002\u0010´\u0001\u001a\u00020\b\u0012\u000b\b\u0002\u0010·\u0001\u001a\u0004\u0018\u00010\b\u0012\t\b\u0002\u0010º\u0001\u001a\u00020\b\u0012\u000b\b\u0002\u0010½\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010À\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010Á\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010Ä\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010Ç\u0001\u001a\u0004\u0018\u00010\b\u0012\f\b\u0002\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u0001\u0012\u0012\b\u0002\u0010Ò\u0001\u001a\u000b\u0012\u0005\u0012\u00030Ñ\u0001\u0018\u00010\n\u0012\u000b\b\u0002\u0010Õ\u0001\u001a\u0004\u0018\u00010\b\u0012\t\b\u0002\u0010Ø\u0001\u001a\u00020\u0006\u0012\n\b\u0002\u0010Û\u0001\u001a\u00030\u0090\u0001\u0012\u000b\b\u0002\u0010Þ\u0001\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010á\u0001\u001a\u00030\u0090\u0001\u0012\t\b\u0002\u0010ä\u0001\u001a\u000206\u0012\u000b\b\u0002\u0010ç\u0001\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010ê\u0001\u001a\u00030\u0090\u0001\u0012\u0011\b\u0002\u0010í\u0001\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\n\u0012\u000b\b\u0002\u0010ð\u0001\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010ó\u0001\u001a\u00030\u0090\u0001\u0012\t\b\u0002\u0010ö\u0001\u001a\u00020\u0006\u0012\n\b\u0002\u0010ù\u0001\u001a\u00030\u0090\u0001¢\u0006\u0006\bü\u0001\u0010ý\u0001J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u0011\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006HÖ\u0001R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\n8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\n8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010\b8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010%R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u001aR*\u0010*\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u001dR\"\u0010-\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010\"\u001a\u0004\b.\u0010\u0011\"\u0004\b/\u0010%R\"\u00100\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b0\u0010\"\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010%R\"\u00103\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b3\u0010\"\u001a\u0004\b4\u0010\u0011\"\u0004\b5\u0010%R\"\u00107\u001a\u0002068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u0002068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b=\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R\"\u0010@\u001a\u0002068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b@\u00108\u001a\u0004\bA\u0010:\"\u0004\bB\u0010<R\"\u0010C\u001a\u0002068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bC\u00108\u001a\u0004\bD\u0010:\"\u0004\bE\u0010<R\"\u0010F\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010\u001aR*\u0010M\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010\u001a\u001a\u0004\bN\u0010\f\"\u0004\bO\u0010\u001dR*\u0010P\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bP\u0010\u001a\u001a\u0004\bQ\u0010\f\"\u0004\bR\u0010\u001dR\"\u0010S\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bS\u0010\"\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010%R*\u0010V\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bV\u0010\u001a\u001a\u0004\bW\u0010\f\"\u0004\bX\u0010\u001dR(\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00000\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bY\u0010\u001a\u001a\u0004\bZ\u0010\f\"\u0004\b[\u0010\u001dR$\u0010\\\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\\\u0010\"\u001a\u0004\b]\u0010\u0011\"\u0004\b^\u0010%R\"\u0010_\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b_\u0010G\u001a\u0004\b`\u0010I\"\u0004\ba\u0010KR\"\u0010b\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bb\u0010G\u001a\u0004\bc\u0010I\"\u0004\bd\u0010KR\"\u0010e\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\be\u0010\"\u001a\u0004\bf\u0010\u0011\"\u0004\bg\u0010%R\"\u0010h\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bh\u0010\"\u001a\u0004\bi\u0010\u0011\"\u0004\bj\u0010%R\"\u0010k\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bk\u0010\"\u001a\u0004\bl\u0010\u0011\"\u0004\bm\u0010%R\"\u0010n\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bn\u0010\"\u001a\u0004\bo\u0010\u0011\"\u0004\bp\u0010%R*\u0010q\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bq\u0010\u001a\u001a\u0004\br\u0010\f\"\u0004\bs\u0010\u001dR$\u0010t\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bt\u0010\"\u001a\u0004\bu\u0010\u0011\"\u0004\bv\u0010%R\"\u0010w\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bw\u0010\"\u001a\u0004\bx\u0010\u0011\"\u0004\by\u0010%R\"\u0010z\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bz\u0010\"\u001a\u0004\b{\u0010\u0011\"\u0004\b|\u0010%R\"\u0010}\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b}\u0010\"\u001a\u0004\b~\u0010\u0011\"\u0004\b\u007f\u0010%R)\u0010\u0080\u0001\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0080\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R&\u0010\u0085\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010\"\u001a\u0005\b\u0086\u0001\u0010\u0011\"\u0005\b\u0087\u0001\u0010%R)\u0010\u0088\u0001\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0081\u0001\u001a\u0006\b\u0088\u0001\u0010\u0082\u0001\"\u0006\b\u0089\u0001\u0010\u0084\u0001R&\u0010\u008a\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\"\u001a\u0005\b\u008b\u0001\u0010\u0011\"\u0005\b\u008c\u0001\u0010%R.\u0010\u008d\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010\u001a\u001a\u0005\b\u008e\u0001\u0010\f\"\u0005\b\u008f\u0001\u0010\u001dR*\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R&\u0010\u0097\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010\"\u001a\u0005\b\u0098\u0001\u0010\u0011\"\u0005\b\u0099\u0001\u0010%R.\u0010\u009a\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010\u001a\u001a\u0005\b\u009b\u0001\u0010\f\"\u0005\b\u009c\u0001\u0010\u001dR*\u0010\u009d\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u0092\u0001\u001a\u0006\b\u009e\u0001\u0010\u0094\u0001\"\u0006\b\u009f\u0001\u0010\u0096\u0001R(\u0010 \u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b \u0001\u0010\"\u001a\u0005\b¡\u0001\u0010\u0011\"\u0005\b¢\u0001\u0010%R.\u0010£\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b£\u0001\u0010\u001a\u001a\u0005\b¤\u0001\u0010\f\"\u0005\b¥\u0001\u0010\u001dR.\u0010¦\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b¦\u0001\u0010\u001a\u001a\u0005\b§\u0001\u0010\f\"\u0005\b¨\u0001\u0010\u001dR&\u0010©\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b©\u0001\u0010\"\u001a\u0005\bª\u0001\u0010\u0011\"\u0005\b«\u0001\u0010%R&\u0010¬\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b¬\u0001\u0010\"\u001a\u0005\b\u00ad\u0001\u0010\u0011\"\u0005\b®\u0001\u0010%R)\u0010¯\u0001\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¯\u0001\u0010\u0081\u0001\u001a\u0006\b¯\u0001\u0010\u0082\u0001\"\u0006\b°\u0001\u0010\u0084\u0001R&\u0010±\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b±\u0001\u0010\"\u001a\u0005\b²\u0001\u0010\u0011\"\u0005\b³\u0001\u0010%R&\u0010´\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b´\u0001\u0010\"\u001a\u0005\bµ\u0001\u0010\u0011\"\u0005\b¶\u0001\u0010%R(\u0010·\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b·\u0001\u0010\"\u001a\u0005\b¸\u0001\u0010\u0011\"\u0005\b¹\u0001\u0010%R&\u0010º\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bº\u0001\u0010\"\u001a\u0005\b»\u0001\u0010\u0011\"\u0005\b¼\u0001\u0010%R(\u0010½\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b½\u0001\u0010\"\u001a\u0005\b¾\u0001\u0010\u0011\"\u0005\b¿\u0001\u0010%R\u001a\u0010À\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÀ\u0001\u0010\"R(\u0010Á\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÁ\u0001\u0010\"\u001a\u0005\bÂ\u0001\u0010\u0011\"\u0005\bÃ\u0001\u0010%R(\u0010Ä\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÄ\u0001\u0010\"\u001a\u0005\bÅ\u0001\u0010\u0011\"\u0005\bÆ\u0001\u0010%R(\u0010Ç\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÇ\u0001\u0010\"\u001a\u0005\bÈ\u0001\u0010\u0011\"\u0005\bÉ\u0001\u0010%R,\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bË\u0001\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R/\u0010Ò\u0001\u001a\u000b\u0012\u0005\u0012\u00030Ñ\u0001\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÒ\u0001\u0010\u001a\u001a\u0005\bÓ\u0001\u0010\f\"\u0005\bÔ\u0001\u0010\u001dR(\u0010Õ\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÕ\u0001\u0010\"\u001a\u0005\bÖ\u0001\u0010\u0011\"\u0005\b×\u0001\u0010%R&\u0010Ø\u0001\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bØ\u0001\u0010G\u001a\u0005\bÙ\u0001\u0010I\"\u0005\bÚ\u0001\u0010KR*\u0010Û\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÛ\u0001\u0010\u0092\u0001\u001a\u0006\bÜ\u0001\u0010\u0094\u0001\"\u0006\bÝ\u0001\u0010\u0096\u0001R(\u0010Þ\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÞ\u0001\u0010\"\u001a\u0005\bß\u0001\u0010\u0011\"\u0005\bà\u0001\u0010%R*\u0010á\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bá\u0001\u0010\u0092\u0001\u001a\u0006\bâ\u0001\u0010\u0094\u0001\"\u0006\bã\u0001\u0010\u0096\u0001R&\u0010ä\u0001\u001a\u0002068\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bä\u0001\u00108\u001a\u0005\bå\u0001\u0010:\"\u0005\bæ\u0001\u0010<R(\u0010ç\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bç\u0001\u0010\"\u001a\u0005\bè\u0001\u0010\u0011\"\u0005\bé\u0001\u0010%R*\u0010ê\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bê\u0001\u0010\u0092\u0001\u001a\u0006\bë\u0001\u0010\u0094\u0001\"\u0006\bì\u0001\u0010\u0096\u0001R.\u0010í\u0001\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bí\u0001\u0010\u001a\u001a\u0005\bî\u0001\u0010\f\"\u0005\bï\u0001\u0010\u001dR(\u0010ð\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bð\u0001\u0010\"\u001a\u0005\bñ\u0001\u0010\u0011\"\u0005\bò\u0001\u0010%R*\u0010ó\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bó\u0001\u0010\u0092\u0001\u001a\u0006\bô\u0001\u0010\u0094\u0001\"\u0006\bõ\u0001\u0010\u0096\u0001R&\u0010ö\u0001\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bö\u0001\u0010G\u001a\u0005\b÷\u0001\u0010I\"\u0005\bø\u0001\u0010KR*\u0010ù\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bù\u0001\u0010\u0092\u0001\u001a\u0006\bú\u0001\u0010\u0094\u0001\"\u0006\bû\u0001\u0010\u0096\u0001¨\u0006\u0080\u0002"}, d2 = {"Lcom/ss/ugc/effectplatform/model/Effect;", "Lcom/ss/ugc/effectplatform/model/AndroidParcelable;", "", "other", "", "equals", "", "hashCode", "", "toString", "", "getInternalRequirements$effect_model_release", "()Ljava/util/List;", "getInternalRequirements", "getInternalType$effect_model_release", "getInternalType", "getInternalModelNames$effect_model_release", "()Ljava/lang/String;", "getInternalModelNames", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "requirements", "Ljava/util/List;", "getRequirements", "setRequirements", "(Ljava/util/List;)V", "types", "getTypes", "setTypes", "model_names", "Ljava/lang/String;", "getModel_names", "setModel_names", "(Ljava/lang/String;)V", "name", "getName", "setName", "_requirements", "requirements_sec", "getRequirements_sec", "setRequirements_sec", "hint", "getHint", "setHint", "id", "getId", "setId", MobConstants.EFFECT_ID, "getEffect_id", "setEffect_id", "Lcom/ss/ugc/effectplatform/model/UrlModel;", ShareType.FILE_URL, "Lcom/ss/ugc/effectplatform/model/UrlModel;", "getFile_url", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setFile_url", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "icon_url", "getIcon_url", "setIcon_url", "hint_icon", "getHint_icon", "setHint_icon", "hint_file", "getHint_file", "setHint_file", "hint_file_format", "I", "getHint_file_format", "()I", "setHint_file_format", "(I)V", "_type", "types_sec", "getTypes_sec", "setTypes_sec", PromotionProductPrivilegesStruct.TAGS, "getTags", "setTags", "tags_updated_at", "getTags_updated_at", "setTags_updated_at", "children", "getChildren", "setChildren", "child_effects", "getChild_effects", "setChild_effects", "parent", "getParent", "setParent", "effect_type", "getEffect_type", "setEffect_type", "source", "getSource", "setSource", "designer_id", "getDesigner_id", "setDesigner_id", "designer_encrypted_id", "getDesigner_encrypted_id", "setDesigner_encrypted_id", "device_platform", "getDevice_platform", "setDevice_platform", "schema", "getSchema", "setSchema", "music", "getMusic", "setMusic", "extra", "getExtra", "setExtra", "sdk_extra", "getSdk_extra", "setSdk_extra", "ad_raw_data", "getAd_raw_data", "setAd_raw_data", "composer_params", "getComposer_params", "setComposer_params", "is_busi", "Z", "()Z", "set_busi", "(Z)V", "iop_id", "getIop_id", "setIop_id", "is_iop", "set_iop", "resource_id", "getResource_id", "setResource_id", "bind_ids", "getBind_ids", "setBind_ids", "", "ptime", "J", "getPtime", "()J", "setPtime", "(J)V", "grade_key", "getGrade_key", "setGrade_key", "challenge", "getChallenge", "setChallenge", "use_number", "getUse_number", "setUse_number", "extra_tag", "getExtra_tag", "setExtra_tag", "videoPlayURLs", "getVideoPlayURLs", "setVideoPlayURLs", "composerPath", "getComposerPath", "setComposerPath", "zipPath", "getZipPath", "setZipPath", "unzipPath", "getUnzipPath", "setUnzipPath", "isDownloaded", "setDownloaded", "panel", "getPanel", "setPanel", "searchType", "getSearchType", "setSearchType", "effect_source_id", "getEffect_source_id", "setEffect_source_id", "platformVersion", "getPlatformVersion", "setPlatformVersion", "recId", "getRecId", "setRecId", "_model_names", "model_names_sec", "getModel_names_sec", "setModel_names_sec", "original_effect_id", "getOriginal_effect_id", "setOriginal_effect_id", InstantPlayContext.NICKNAME, "getNickname", "setNickname", "Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;", "avatar_thumb", "Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;", "getAvatar_thumb", "()Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;", "setAvatar_thumb", "(Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;)V", "Lcom/ss/ugc/effectplatform/model/RankingEffectModel;", "ranking_List", "getRanking_List", "setRanking_List", "server_extra", "getServer_extra", "setServer_extra", "force_insert_priority", "getForce_insert_priority", "setForce_insert_priority", "force_insert_position", "getForce_insert_position", "setForce_insert_position", "labels", "getLabels", "setLabels", "rec_tag", "getRec_tag", "setRec_tag", "designer_avatar", "getDesigner_avatar", "setDesigner_avatar", "designer_nickname", "getDesigner_nickname", "setDesigner_nickname", PoolStatsTracker.USED_COUNT, "getUsed_count", "setUsed_count", "covers", "getCovers", "setCovers", "keywords", "getKeywords", "setKeywords", "created_at", "getCreated_at", "setCreated_at", ShortVideoSegments.KEY_PROP_PROVIDER, "getProvider", "setProvider", "zipSize", "getZipSize", "setZipSize", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/UrlModel;Lcom/ss/ugc/effectplatform/model/UrlModel;Lcom/ss/ugc/effectplatform/model/UrlModel;Lcom/ss/ugc/effectplatform/model/UrlModel;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/util/List;JLjava/lang/String;Ljava/util/List;JLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;Ljava/util/List;Ljava/lang/String;IJLjava/lang/String;JLcom/ss/ugc/effectplatform/model/UrlModel;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;JIJ)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "effect_model_release"}, k = 1, mv = {1, 4, 0})
public class Effect implements AndroidParcelable {
    public static final Parcelable.Creator CREATOR = null;
    public static final a Companion = null;
    private String _model_names;
    private List<String> _requirements;
    private List<String> _type;
    private String ad_raw_data;
    private AuthorThumbModel avatar_thumb;
    private List<String> bind_ids;
    private List<String> challenge;
    private List<? extends Effect> child_effects;
    private List<String> children;
    private List<String> composerPath;
    private String composer_params;
    private List<? extends UrlModel> covers;
    private long created_at;
    private UrlModel designer_avatar;
    private String designer_encrypted_id;
    private String designer_id;
    private String designer_nickname;
    private String device_platform;
    private String effect_id;
    private String effect_source_id;
    private int effect_type;
    private String extra;
    private String extra_tag;
    private UrlModel file_url;
    private long force_insert_position;
    private int force_insert_priority;
    private String grade_key;
    private String hint;
    private UrlModel hint_file;
    private int hint_file_format;
    private UrlModel hint_icon;
    private UrlModel icon_url;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f457404id;
    private String iop_id;
    private boolean isDownloaded;
    private boolean is_busi;
    private boolean is_iop;
    private String keywords;
    private String labels;
    private String model_names;
    private String model_names_sec;
    private List<String> music;
    private String name;
    private String nickname;
    private String original_effect_id;
    private String panel;
    private String parent;
    private String platformVersion;
    private int provider;
    private long ptime;
    private List<? extends RankingEffectModel> ranking_List;
    private String recId;
    private long rec_tag;
    private List<String> requirements;
    private List<String> requirements_sec;
    private String resource_id;
    private String schema;
    private String sdk_extra;
    private String searchType;
    private String server_extra;
    private int source;
    private List<String> tags;
    private String tags_updated_at;
    private List<String> types;
    private List<String> types_sec;
    private String unzipPath;
    private long use_number;
    private long used_count;
    private List<String> videoPlayURLs;
    private String zipPath;
    private long zipSize;

    public static final class a extends AndroidEffectParceler {
        public a(int r100) {
        }
    }

    public static class b implements Parcelable.Creator {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r100) {
            return new Effect[r100];
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r810) {
            Parcel r100 = r810;
            Effect.Companion.getClass();
            String r101 = r810.readString();
            ArrayList<String> r102 = r810.createStringArrayList();
            ArrayList<String> r103 = r810.createStringArrayList();
            String r104 = r810.readString();
            String r105 = r810.readString();
            String r106 = r810.readString();
            Parcelable r107 = r100.readParcelable(Effect.class.getClassLoader());
            if (r107 == null) goto L152;
            UrlModel r110 = (UrlModel) r107;
            Parcelable r108 = r100.readParcelable(Effect.class.getClassLoader());
            if (r108 == null) goto L150;
            UrlModel r111 = (UrlModel) r108;
            Parcelable r109 = r100.readParcelable(Effect.class.getClassLoader());
            if (r109 == null) goto L148;
            UrlModel r112 = (UrlModel) r109;
            Parcelable r113 = r100.readParcelable(Effect.class.getClassLoader());
            if (r113 == null) goto L146;
            UrlModel r114 = (UrlModel) r113;
            int r115 = r810.readInt();
            ArrayList<String> r116 = r810.createStringArrayList();
            ArrayList<String> r117 = r810.createStringArrayList();
            ArrayList<String> r118 = r810.createStringArrayList();
            String r119 = r810.readString();
            ArrayList<String> r120 = r810.createStringArrayList();
            int r121 = r810.readInt();
            ArrayList r122 = new ArrayList(r121);
        L11:
            if (r121 == 0) goto L13;
            ArrayList r210 = r122;
            Parcelable r123 = r810.readParcelable(Effect.class.getClassLoader());
            if (r123 == null) goto L144;
            r210.add((Effect) r123);
            r121 = r121 - 1;
            r100 = r810;
            r122 = r210;
            r101 = r101;
            goto L11
        L144:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.Effect");
        L13:
            if (r101 != null) goto L16;
            r101 = "";
        L16:
            if (r102 != null) goto L19;
            r102 = new ArrayList();
        L19:
            if (r104 == null) goto L21;
            String r211 = r104;
        L22:
            if (r105 == null) goto L24;
            String r212 = r105;
        L25:
            if (r106 == null) goto L27;
            String r213 = r106;
        L28:
            if (r116 == null) goto L30;
            ArrayList<String> r214 = r116;
        L31:
            if (r119 == null) goto L33;
            String r215 = r119;
        L34:
            String r216 = r810.readString();
            int r217 = r810.readInt();
            int r218 = r810.readInt();
            String r124 = r810.readString();
            if (r124 == null) goto L37;
            String r219 = r124;
        L38:
            String r125 = r810.readString();
            if (r125 == null) goto L41;
            String r310 = r125;
        L42:
            String r126 = r810.readString();
            if (r126 == null) goto L45;
            String r311 = r126;
        L46:
            String r127 = r810.readString();
            if (r127 == null) goto L49;
            String r312 = r127;
        L50:
            ArrayList<String> r313 = r810.createStringArrayList();
            String r314 = r810.readString();
            String r128 = r810.readString();
            if (r128 == null) goto L53;
            String r315 = r128;
        L54:
            String r129 = r810.readString();
            if (r129 == null) goto L57;
            String r316 = r129;
        L58:
            String r130 = r810.readString();
            if (r130 == null) goto L61;
            String r317 = r130;
        L63:
            if (r810.readInt() != 1) goto L65;
            boolean r318 = true;
        L66:
            String r131 = r810.readString();
            if (r131 == null) goto L69;
            String r319 = r131;
        L71:
            if (r810.readInt() != 1) goto L73;
            boolean r410 = true;
        L74:
            String r132 = r810.readString();
            if (r132 == null) goto L77;
            String r411 = r132;
        L78:
            ArrayList<String> r412 = r810.createStringArrayList();
            long r413 = r810.readLong();
            String r133 = r810.readString();
            if (r133 == null) goto L81;
            String r414 = r133;
        L82:
            ArrayList<String> r415 = r810.createStringArrayList();
            long r416 = r810.readLong();
            String r417 = r810.readString();
            ArrayList<String> r510 = r810.createStringArrayList();
            ArrayList<String> r511 = r810.createStringArrayList();
            String r134 = r810.readString();
            if (r134 == null) goto L85;
            String r512 = r134;
        L86:
            String r135 = r810.readString();
            if (r135 == null) goto L89;
            String r513 = r135;
        L91:
            if (r810.readInt() != 1) goto L93;
            boolean r514 = true;
        L94:
            String r136 = r810.readString();
            if (r136 == null) goto L97;
            String r515 = r136;
        L98:
            String r137 = r810.readString();
            if (r137 == null) goto L101;
            String r516 = r137;
        L102:
            String r517 = r810.readString();
            String r138 = r810.readString();
            if (r138 == null) goto L105;
            String r518 = r138;
        L106:
            String r519 = r810.readString();
            String r610 = r810.readString();
            String r611 = r810.readString();
            String r612 = r810.readString();
            String r613 = r810.readString();
            Parcelable r139 = r100.readParcelable(AuthorThumbModel.class.getClassLoader());
            if ((r139 instanceof AuthorThumbModel) == true) goto L109;
            r139 = null;
        L109:
            AuthorThumbModel r614 = (AuthorThumbModel) r139;
            int r140 = r810.readInt();
            ArrayList r141 = new ArrayList();
            int r142 = 0;
        L110:
            if (r142 >= r140) goto L118;
            Parcelable r143 = r100.readParcelable(RankingEffectModel.class.getClassLoader());
            if ((r143 instanceof RankingEffectModel) == true) goto L114;
            r143 = null;
        L114:
            RankingEffectModel r144 = (RankingEffectModel) r143;
            if (r144 == null) goto L117;
            r141.add(r144);
        L117:
            r142 = r142 + 1;
            goto L110
        L118:
            String r615 = r810.readString();
            int r616 = r810.readInt();
            long r617 = r810.readLong();
            String r710 = r810.readString();
            long r711 = r810.readLong();
            Parcelable r145 = r100.readParcelable(Effect.class.getClassLoader());
            if (r145 == null) goto L139;
            UrlModel r712 = (UrlModel) r145;
            String r811 = r810.readString();
            long r812 = r810.readLong();
            int r146 = r810.readInt();
            ArrayList r147 = new ArrayList();
            int r148 = 0;
        L121:
            if (r148 >= r146) goto L128;
            Parcelable r149 = r100.readParcelable(Effect.class.getClassLoader());
            if ((r149 instanceof Parcelable) == true) goto L125;
            r149 = null;
        L125:
            if (r149 == null) goto L127;
            r147.add(r149);
        L127:
            r148 = r148 + 1;
            goto L121
        L128:
            ArrayList<String> r150 = r214;
            String r151 = r215;
            Effect r152 = new Effect(r101, r102, r103, r211, r212, r213, r110, r111, r112, r114, r115, r150, r117, r118, r151, r120, r122, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r141, r615, r616, r617, r710, r711, r712, r811, r812, r147, r810.readString(), r810.readLong(), r810.readInt(), r810.readLong());
            ArrayList<String> r153 = r810.createStringArrayList();
            if (r153 != null) goto L132;
            r153 = new ArrayList();
        L132:
            r152.setRequirements(r153);
            ArrayList<String> r154 = r810.createStringArrayList();
            if (r154 != null) goto L136;
            r154 = new ArrayList();
        L136:
            r152.setTypes(r154);
            r152.setModel_names(r810.readString());
            return r152;
        L139:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.UrlModel");
        L105:
            r518 = "";
            goto L106
        L101:
            r516 = "";
            goto L102
        L97:
            r515 = "";
            goto L98
        L93:
            r514 = false;
            goto L94
        L89:
            r513 = "";
            goto L91
        L85:
            r512 = "";
            goto L86
        L81:
            r414 = "";
            goto L82
        L77:
            r411 = "";
            goto L78
        L73:
            r410 = false;
            goto L74
        L69:
            r319 = "";
            goto L71
        L65:
            r318 = false;
            goto L66
        L61:
            r317 = "";
            goto L63
        L57:
            r316 = "";
            goto L58
        L53:
            r315 = "";
            goto L54
        L49:
            r312 = "";
            goto L50
        L45:
            r311 = "";
            goto L46
        L41:
            r310 = "";
            goto L42
        L37:
            r219 = "";
            goto L38
        L33:
            r215 = "";
            goto L34
        L30:
            r214 = new ArrayList();
            goto L31
        L27:
            r213 = "";
            goto L28
        L24:
            r212 = "";
            goto L25
        L21:
            r211 = "";
            goto L22
        L146:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.UrlModel");
        L148:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.UrlModel");
        L150:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.UrlModel");
        L152:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.UrlModel");
        }
    }

    static {
        Companion = new a(0);
        CREATOR = new b();
    }

    public Effect() {
        this(null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, false, null, false, null, null, 0, null, null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, 0, null, null, 0, null, null, 0, 0, 0, -1, -1, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getModel_names() {
        String r100 = this._model_names;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L23;
        String r103 = getModel_names_sec();
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == true) goto L23;
        int r105 = flc.a.f477768a;
        j r106 = com.ss.ugc.effectplatform.f.f457400a;
        j r107 = com.ss.ugc.effectplatform.f.f457400a;
        if (r107 == null) goto L21;
        String r108 = r107.decrypt(getModel_names_sec());
    L22:
        this._model_names = r108;
        goto L23
    L21:
        r108 = null;
        goto L22
    L13:
        if (StringsKt.isBlank(r103) == true) goto L16;
        r104 = false;
    L23:
        String r109 = this._model_names;
        if (r109 != null) goto L26;
    L27:
        r101 = true;
    L28:
        if (r101 == false) goto L31;
        return this.model_names;
    L31:
        return this._model_names;
    L26:
        if (StringsKt.isBlank(r109) == false) goto L28;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public List<String> getRequirements() {
        List<String> r100 = this.requirements_sec;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L22;
        List<String> r102 = this.requirements_sec;
        if (r102 != null) goto L13;
    L14:
        int r103 = flc.a.f477768a;
        j r104 = com.ss.ugc.effectplatform.f.f457400a;
        if (r104 == null) goto L19;
        List<String> r105 = com.ss.ugc.effectplatform.g.a(r104, this.requirements_sec);
        if (r105 == null) goto L19;
    L20:
        this._requirements = r105;
    L19:
        r105 = new ArrayList();
        goto L20
    L13:
        if (r102.size() != this._requirements.size()) goto L14;
    L22:
        if (this._requirements.isEmpty() == false) goto L25;
        return this.requirements;
    L25:
        return this._requirements;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public List<String> getTypes() {
        List<String> r100 = this.types_sec;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L22;
        List<String> r102 = this.types_sec;
        if (r102 != null) goto L13;
    L14:
        int r103 = flc.a.f477768a;
        j r104 = com.ss.ugc.effectplatform.f.f457400a;
        if (r104 == null) goto L19;
        List<String> r105 = com.ss.ugc.effectplatform.g.a(r104, this.types_sec);
        if (r105 == null) goto L19;
    L20:
        this._type = r105;
    L19:
        r105 = new ArrayList();
        goto L20
    L13:
        if (r102.size() != this._type.size()) goto L14;
    L22:
        if (this._type.isEmpty() == false) goto L25;
        return this.types;
    L25:
        return this._type;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public String toString() {
        return "Effect(name='" + getName() + "', _requirements=" + this._requirements + ", requirements_sec=" + this.requirements_sec + ", hint='" + getHint() + "', id='" + getId() + "', original_effect_id='" + getOriginal_effect_id() + "', effect_id='" + getEffect_id() + "', file_url=" + getFile_url() + ", icon_url=" + getIcon_url() + ", hint_icon=" + getHint_icon() + ", hint_file=" + getHint_file() + ", hint_file_format=" + getHint_file_format() + ", _type=" + this._type + ", types_sec=" + this.types_sec + ", tags=" + getTags() + ", tags_updated_at='" + getTags_updated_at() + "', children=" + getChildren() + ", child_effects=" + getChild_effects() + ", parent=" + getParent() + ", effect_type=" + getEffect_type() + ", source=" + getSource() + ", designer_id='" + getDesigner_id() + "', designer_encrypted_id='" + getDesigner_encrypted_id() + "', device_platform='" + getDevice_platform() + "', schema='" + getSchema() + "', music=" + getMusic() + ", extra='" + getExtra() + "', sdk_extra='" + getSdk_extra() + "', ad_raw_data='" + getAd_raw_data() + "', composer_params='" + getComposer_params() + "', is_busi=" + is_busi() + ", iop_id='" + getIop_id() + "', is_iop=" + is_iop() + ", resource_id='" + getResource_id() + "', bind_ids=" + getBind_ids() + ", publish_time=" + getPtime() + ", grade_key='" + getGrade_key() + "', composerPath=" + getComposerPath() + ", zipPath='" + getZipPath() + "', unzipPath='" + getUnzipPath() + "', isDownloaded=" + isDownloaded() + ", panel='" + getPanel() + "', recId=" + getRecId() + ", _model_names=" + this._model_names + ", model_names_sec='" + getModel_names_sec() + "', labels='" + getLabels() + "', rec_tag='" + getRec_tag() + "', designer_avatar=" + getDesigner_avatar() + ", designer_nickname=" + getDesigner_nickname() + ", used_count=" + getUsed_count() + ", covers=" + getCovers() + ", keywords=" + getKeywords() + ", created_at=" + getCreated_at() + ", provider=" + getProvider() + ", zipSize=" + getZipSize() + ')';
    }

    public int hashCode() {
        return (((getId().hashCode() * 31) + getEffect_id().hashCode()) * 31) + getResource_id().hashCode();
    }

    public String getAd_raw_data() {
        return this.ad_raw_data;
    }

    public AuthorThumbModel getAvatar_thumb() {
        return this.avatar_thumb;
    }

    public List<String> getBind_ids() {
        return this.bind_ids;
    }

    public List<String> getChallenge() {
        return this.challenge;
    }

    public List<Effect> getChild_effects() {
        return this.child_effects;
    }

    public List<String> getChildren() {
        return this.children;
    }

    public List<String> getComposerPath() {
        return this.composerPath;
    }

    public String getComposer_params() {
        return this.composer_params;
    }

    public List<UrlModel> getCovers() {
        return this.covers;
    }

    public long getCreated_at() {
        return this.created_at;
    }

    public UrlModel getDesigner_avatar() {
        return this.designer_avatar;
    }

    public String getDesigner_encrypted_id() {
        return this.designer_encrypted_id;
    }

    public String getDesigner_id() {
        return this.designer_id;
    }

    public String getDesigner_nickname() {
        return this.designer_nickname;
    }

    public String getDevice_platform() {
        return this.device_platform;
    }

    public String getEffect_id() {
        return this.effect_id;
    }

    public String getEffect_source_id() {
        return this.effect_source_id;
    }

    public int getEffect_type() {
        return this.effect_type;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getExtra_tag() {
        return this.extra_tag;
    }

    public UrlModel getFile_url() {
        return this.file_url;
    }

    public long getForce_insert_position() {
        return this.force_insert_position;
    }

    public int getForce_insert_priority() {
        return this.force_insert_priority;
    }

    public String getGrade_key() {
        return this.grade_key;
    }

    public String getHint() {
        return this.hint;
    }

    public UrlModel getHint_file() {
        return this.hint_file;
    }

    public int getHint_file_format() {
        return this.hint_file_format;
    }

    public UrlModel getHint_icon() {
        return this.hint_icon;
    }

    public UrlModel getIcon_url() {
        return this.icon_url;
    }

    public String getId() {
        return this.f457404id;
    }

    public final String getInternalModelNames$effect_model_release() {
        return this._model_names;
    }

    public final List<String> getInternalRequirements$effect_model_release() {
        return this._requirements;
    }

    public final List<String> getInternalType$effect_model_release() {
        return this._type;
    }

    public String getIop_id() {
        return this.iop_id;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public String getLabels() {
        return this.labels;
    }

    public String getModel_names_sec() {
        return this.model_names_sec;
    }

    public List<String> getMusic() {
        return this.music;
    }

    public String getName() {
        return this.name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getOriginal_effect_id() {
        return this.original_effect_id;
    }

    public String getPanel() {
        return this.panel;
    }

    public String getParent() {
        return this.parent;
    }

    public final String getPlatformVersion() {
        return this.platformVersion;
    }

    public int getProvider() {
        return this.provider;
    }

    public long getPtime() {
        return this.ptime;
    }

    public List<RankingEffectModel> getRanking_List() {
        return this.ranking_List;
    }

    public String getRecId() {
        return this.recId;
    }

    public long getRec_tag() {
        return this.rec_tag;
    }

    public final List<String> getRequirements_sec() {
        return this.requirements_sec;
    }

    public String getResource_id() {
        return this.resource_id;
    }

    public String getSchema() {
        return this.schema;
    }

    public String getSdk_extra() {
        return this.sdk_extra;
    }

    public String getSearchType() {
        return this.searchType;
    }

    public String getServer_extra() {
        return this.server_extra;
    }

    public int getSource() {
        return this.source;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getTags_updated_at() {
        return this.tags_updated_at;
    }

    public final List<String> getTypes_sec() {
        return this.types_sec;
    }

    public String getUnzipPath() {
        return this.unzipPath;
    }

    public long getUse_number() {
        return this.use_number;
    }

    public long getUsed_count() {
        return this.used_count;
    }

    public List<String> getVideoPlayURLs() {
        return this.videoPlayURLs;
    }

    public String getZipPath() {
        return this.zipPath;
    }

    public long getZipSize() {
        return this.zipSize;
    }

    public boolean isDownloaded() {
        return this.isDownloaded;
    }

    public boolean is_busi() {
        return this.is_busi;
    }

    public boolean is_iop() {
        return this.is_iop;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Effect) == true) goto L8;
        return false;
    L8:
        Effect r101 = (Effect) r100;
        if ((!Intrinsics.areEqual(getId(), r101.getId())) == false) goto L12;
        return false;
    L12:
        if ((!Intrinsics.areEqual(getEffect_id(), r101.getEffect_id())) == false) goto L15;
        return false;
    L15:
        if ((!Intrinsics.areEqual(getResource_id(), r101.getResource_id())) == false) goto L17;
        return false;
    L17:
        return true;
    }

    public void setAd_raw_data(String r100) {
        this.ad_raw_data = r100;
    }

    public void setAvatar_thumb(AuthorThumbModel r100) {
        this.avatar_thumb = r100;
    }

    public void setBind_ids(List<String> r100) {
        this.bind_ids = r100;
    }

    public void setChallenge(List<String> r100) {
        this.challenge = r100;
    }

    public void setChild_effects(List<? extends Effect> r100) {
        this.child_effects = r100;
    }

    public void setChildren(List<String> r100) {
        this.children = r100;
    }

    public void setComposerPath(List<String> r100) {
        this.composerPath = r100;
    }

    public void setComposer_params(String r100) {
        this.composer_params = r100;
    }

    public void setCovers(List<? extends UrlModel> r100) {
        this.covers = r100;
    }

    public void setCreated_at(long r100) {
        this.created_at = r100;
    }

    public void setDesigner_avatar(UrlModel r100) {
        this.designer_avatar = r100;
    }

    public void setDesigner_encrypted_id(String r100) {
        this.designer_encrypted_id = r100;
    }

    public void setDesigner_id(String r100) {
        this.designer_id = r100;
    }

    public void setDesigner_nickname(String r100) {
        this.designer_nickname = r100;
    }

    public void setDevice_platform(String r100) {
        this.device_platform = r100;
    }

    public void setDownloaded(boolean r100) {
        this.isDownloaded = r100;
    }

    public void setEffect_id(String r100) {
        this.effect_id = r100;
    }

    public void setEffect_source_id(String r100) {
        this.effect_source_id = r100;
    }

    public void setEffect_type(int r100) {
        this.effect_type = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setExtra_tag(String r100) {
        this.extra_tag = r100;
    }

    public void setFile_url(UrlModel r100) {
        this.file_url = r100;
    }

    public void setForce_insert_position(long r100) {
        this.force_insert_position = r100;
    }

    public void setForce_insert_priority(int r100) {
        this.force_insert_priority = r100;
    }

    public void setGrade_key(String r100) {
        this.grade_key = r100;
    }

    public void setHint(String r100) {
        this.hint = r100;
    }

    public void setHint_file(UrlModel r100) {
        this.hint_file = r100;
    }

    public void setHint_file_format(int r100) {
        this.hint_file_format = r100;
    }

    public void setHint_icon(UrlModel r100) {
        this.hint_icon = r100;
    }

    public void setIcon_url(UrlModel r100) {
        this.icon_url = r100;
    }

    public void setId(String r100) {
        this.f457404id = r100;
    }

    public void setIop_id(String r100) {
        this.iop_id = r100;
    }

    public void setKeywords(String r100) {
        this.keywords = r100;
    }

    public void setLabels(String r100) {
        this.labels = r100;
    }

    public final void setModel_names(String r100) {
        this.model_names = r100;
    }

    public void setModel_names_sec(String r100) {
        this.model_names_sec = r100;
    }

    public void setMusic(List<String> r100) {
        this.music = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setNickname(String r100) {
        this.nickname = r100;
    }

    public void setOriginal_effect_id(String r100) {
        this.original_effect_id = r100;
    }

    public void setPanel(String r100) {
        this.panel = r100;
    }

    public void setParent(String r100) {
        this.parent = r100;
    }

    public final void setPlatformVersion(String r100) {
        this.platformVersion = r100;
    }

    public void setProvider(int r100) {
        this.provider = r100;
    }

    public void setPtime(long r100) {
        this.ptime = r100;
    }

    public void setRanking_List(List<? extends RankingEffectModel> r100) {
        this.ranking_List = r100;
    }

    public void setRecId(String r100) {
        this.recId = r100;
    }

    public void setRec_tag(long r100) {
        this.rec_tag = r100;
    }

    public void setRequirements(List<String> r100) {
        this.requirements = r100;
    }

    public final void setRequirements_sec(List<String> r100) {
        this.requirements_sec = r100;
    }

    public void setResource_id(String r100) {
        this.resource_id = r100;
    }

    public void setSchema(String r100) {
        this.schema = r100;
    }

    public void setSdk_extra(String r100) {
        this.sdk_extra = r100;
    }

    public void setSearchType(String r100) {
        this.searchType = r100;
    }

    public void setServer_extra(String r100) {
        this.server_extra = r100;
    }

    public void setSource(int r100) {
        this.source = r100;
    }

    public void setTags(List<String> r100) {
        this.tags = r100;
    }

    public void setTags_updated_at(String r100) {
        this.tags_updated_at = r100;
    }

    public void setTypes(List<String> r100) {
        this.types = r100;
    }

    public final void setTypes_sec(List<String> r100) {
        this.types_sec = r100;
    }

    public void setUnzipPath(String r100) {
        this.unzipPath = r100;
    }

    public void setUse_number(long r100) {
        this.use_number = r100;
    }

    public void setUsed_count(long r100) {
        this.used_count = r100;
    }

    public void setVideoPlayURLs(List<String> r100) {
        this.videoPlayURLs = r100;
    }

    public void setZipPath(String r100) {
        this.zipPath = r100;
    }

    public void setZipSize(long r100) {
        this.zipSize = r100;
    }

    public void set_busi(boolean r100) {
        this.is_busi = r100;
    }

    public void set_iop(boolean r100) {
        this.is_iop = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Companion.getClass();
        r100.writeString(getName());
        r100.writeStringList(getInternalRequirements$effect_model_release());
        r100.writeStringList(getRequirements_sec());
        r100.writeString(getHint());
        r100.writeString(getId());
        r100.writeString(getEffect_id());
        r100.writeParcelable(getFile_url(), r101);
        r100.writeParcelable(getIcon_url(), r101);
        r100.writeParcelable(getHint_icon(), r101);
        r100.writeParcelable(getHint_file(), r101);
        r100.writeInt(getHint_file_format());
        r100.writeStringList(getInternalType$effect_model_release());
        r100.writeStringList(getTypes_sec());
        r100.writeStringList(getTags());
        r100.writeString(getTags_updated_at());
        r100.writeStringList(getChildren());
        List<Effect> r102 = getChild_effects();
        r100.writeInt(r102.size());
        Iterator<Effect> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.writeParcelable(r103.next(), r101);
        goto L4
    L6:
        r100.writeString(getParent());
        r100.writeInt(getEffect_type());
        r100.writeInt(getSource());
        r100.writeString(getDesigner_id());
        r100.writeString(getDesigner_encrypted_id());
        r100.writeString(getDevice_platform());
        r100.writeString(getSchema());
        r100.writeStringList(getMusic());
        r100.writeString(getExtra());
        r100.writeString(getSdk_extra());
        r100.writeString(getAd_raw_data());
        r100.writeString(getComposer_params());
        r100.writeInt(is_busi() ? 1 : 0);
        r100.writeString(getIop_id());
        r100.writeInt(is_iop() ? 1 : 0);
        r100.writeString(getResource_id());
        r100.writeStringList(getBind_ids());
        r100.writeLong(getPtime());
        r100.writeString(getGrade_key());
        r100.writeStringList(getChallenge());
        r100.writeLong(getUse_number());
        r100.writeString(getExtra_tag());
        r100.writeStringList(getVideoPlayURLs());
        r100.writeStringList(getComposerPath());
        r100.writeString(getZipPath());
        r100.writeString(getUnzipPath());
        r100.writeInt(isDownloaded() ? 1 : 0);
        r100.writeString(getPanel());
        r100.writeString(getSearchType());
        r100.writeString(getEffect_source_id());
        r100.writeString(getPlatformVersion());
        r100.writeString(getRecId());
        r100.writeString(getInternalModelNames$effect_model_release());
        r100.writeString(getModel_names_sec());
        r100.writeString(getOriginal_effect_id());
        r100.writeString(getNickname());
        r100.writeParcelable(getAvatar_thumb(), r101);
        List<RankingEffectModel> r104 = getRanking_List();
        int r105 = 0;
        if (r104 == null) goto L9;
        int r106 = r104.size();
    L10:
        r100.writeInt(r106);
        if (r104 == null) goto L16;
        Iterator<RankingEffectModel> r107 = r104.iterator();
    L14:
        if (r107.hasNext() == false) goto L16;
        r100.writeParcelable(r107.next(), r101);
    L16:
        r100.writeString(getServer_extra());
        r100.writeInt(getForce_insert_priority());
        r100.writeLong(getForce_insert_position());
        r100.writeString(getLabels());
        r100.writeLong(getRec_tag());
        r100.writeParcelable(getDesigner_avatar(), r101);
        r100.writeString(getDesigner_nickname());
        r100.writeLong(getUsed_count());
        List<UrlModel> r108 = getCovers();
        if (r108 == null) goto L19;
        r105 = r108.size();
    L19:
        r100.writeInt(r105);
        if (r108 == null) goto L25;
        Iterator<UrlModel> r109 = r108.iterator();
    L23:
        if (r109.hasNext() == false) goto L25;
        r100.writeParcelable(r109.next(), r101);
    L25:
        r100.writeString(getKeywords());
        r100.writeLong(getCreated_at());
        r100.writeInt(getProvider());
        r100.writeLong(getZipSize());
        r100.writeStringList(getRequirements());
        r100.writeStringList(getTypes());
        r100.writeString(getModel_names());
        return;
    L9:
        r106 = 0;
        goto L10
    }

    public Effect(String r100, List<String> r101, List<String> r102, String r103, String r104, String r105, UrlModel r110, UrlModel r111, UrlModel r112, UrlModel r113, int r114, List<String> r115, List<String> r116, List<String> r117, String r118, List<String> r119, List<? extends Effect> r210, String r211, int r212, int r213, String r214, String r215, String r216, String r217, List<String> r218, String r219, String r310, String r311, String r312, boolean r313, String r314, boolean r315, String r316, List<String> r317, long r318, String r410, List<String> r411, long r412, String r413, List<String> r414, List<String> r415, String r416, String r417, boolean r418, String r510, String r511, String r512, String r513, String r514, String r515, String r516, String r517, String r518, AuthorThumbModel r519, List<? extends RankingEffectModel> r610, String r611, int r612, long r613, String r614, long r615, UrlModel r616, String r617, long r710, List<? extends UrlModel> r711, String r712, long r713, int r714, long r715) {
        this.name = r100;
        this._requirements = r101;
        this.requirements_sec = r102;
        this.hint = r103;
        this.f457404id = r104;
        this.effect_id = r105;
        this.file_url = r110;
        this.icon_url = r111;
        this.hint_icon = r112;
        this.hint_file = r113;
        this.hint_file_format = r114;
        this._type = r115;
        this.types_sec = r116;
        this.tags = r117;
        this.tags_updated_at = r118;
        this.children = r119;
        this.child_effects = r210;
        this.parent = r211;
        this.effect_type = r212;
        this.source = r213;
        this.designer_id = r214;
        this.designer_encrypted_id = r215;
        this.device_platform = r216;
        this.schema = r217;
        this.music = r218;
        this.extra = r219;
        this.sdk_extra = r310;
        this.ad_raw_data = r311;
        this.composer_params = r312;
        this.is_busi = r313;
        this.iop_id = r314;
        this.is_iop = r315;
        this.resource_id = r316;
        this.bind_ids = r317;
        this.ptime = r318;
        this.grade_key = r410;
        this.challenge = r411;
        this.use_number = r412;
        this.extra_tag = r413;
        this.videoPlayURLs = r414;
        this.composerPath = r415;
        this.zipPath = r416;
        this.unzipPath = r417;
        this.isDownloaded = r418;
        this.panel = r510;
        this.searchType = r511;
        this.effect_source_id = r512;
        this.platformVersion = r513;
        this.recId = r514;
        this._model_names = r515;
        this.model_names_sec = r516;
        this.original_effect_id = r517;
        this.nickname = r518;
        this.avatar_thumb = r519;
        this.ranking_List = r610;
        this.server_extra = r611;
        this.force_insert_priority = r612;
        this.force_insert_position = r613;
        this.labels = r614;
        this.rec_tag = r615;
        this.designer_avatar = r616;
        this.designer_nickname = r617;
        this.used_count = r710;
        this.covers = r711;
        this.keywords = r712;
        this.created_at = r713;
        this.provider = r714;
        this.zipSize = r715;
        this.requirements = new ArrayList();
        this.types = new ArrayList();
    }

    public /* synthetic */ Effect(String r710, List r711, List r712, String r713, String r714, String r810, UrlModel r811, UrlModel r812, UrlModel r813, UrlModel r814, int r815, List r816, List r817, List r818, String r819, List r910, List r911, String r912, int r913, int r914, String r915, String r916, String r917, String r918, List r919, String r100, String r101, String r102, String r103, boolean r104, String r105, boolean r106, String r107, List r108, long r109, String r111, List r112, long r113, String r115, List r116, List r117, String r118, String r119, boolean r120, String r121, String r122, String r123, String r124, String r125, String r126, String r127, String r128, String r129, AuthorThumbModel r130, List r131, String r132, int r133, long r134, String r136, long r137, UrlModel r139, String r140, long r141, List r143, String r144, long r145, int r147, long r148, int r150, int r151, int r152, DefaultConstructorMarker r153) {
        if ((r150 & 1) == 0) goto L5;
        String r110 = "";
    L7:
        if ((r150 & 2) == 0) goto L9;
        List r114 = new ArrayList();
    L11:
        if ((r150 & 4) == 0) goto L13;
        List r135 = null;
    L15:
        if ((r150 & 8) == 0) goto L17;
        String r138 = "";
    L19:
        if ((r150 & 16) == 0) goto L21;
        String r142 = "";
    L23:
        if ((r150 & 32) == 0) goto L25;
        String r146 = "";
    L27:
        if ((r150 & 64) == 0) goto L29;
        UrlModel r149 = new UrlModel(null, null, null, null, 15, null);
    L31:
        if ((r150 & 128) == 0) goto L33;
        UrlModel r154 = new UrlModel(null, null, null, null, 15, null);
    L35:
        if ((r150 & 256) == 0) goto L37;
        UrlModel r155 = new UrlModel(null, null, null, null, 15, null);
    L39:
        if ((r150 & 512) == 0) goto L41;
        UrlModel r156 = new UrlModel(null, null, null, null, 15, null);
    L43:
        if ((r150 & 1024) == 0) goto L45;
        int r157 = 0;
    L47:
        if ((r150 & 2048) == 0) goto L49;
        List r158 = new ArrayList();
    L51:
        if ((r150 & 4096) == 0) goto L53;
        List r159 = null;
    L55:
        if ((r150 & 8192) == 0) goto L57;
        List r160 = new ArrayList();
    L58:
        List r161 = r160;
        if ((r150 & 16384) == 0) goto L61;
        String r162 = "";
    L63:
        if ((r150 & 32768) == 0) goto L65;
        List r163 = null;
    L67:
        if ((r150 & 65536) == 0) goto L69;
        List r210 = new ArrayList();
    L71:
        if ((r150 & 131072) == 0) goto L73;
        String r211 = null;
    L75:
        if ((r150 & 262144) == 0) goto L77;
        int r212 = 0;
    L79:
        if ((r150 & 524288) == 0) goto L81;
        int r213 = 0;
    L83:
        if ((r150 & 1048576) == 0) goto L85;
        String r214 = "";
    L87:
        if ((r150 & 2097152) == 0) goto L89;
        String r215 = "";
    L91:
        if ((r150 & 4194304) == 0) goto L93;
        String r216 = "";
    L95:
        if ((r150 & 8388608) == 0) goto L97;
        String r217 = "";
    L99:
        if ((r150 & 16777216) == 0) goto L101;
        List r218 = null;
    L103:
        if ((r150 & 33554432) == 0) goto L105;
        String r310 = null;
    L107:
        if ((r150 & 67108864) == 0) goto L109;
        String r311 = "";
    L111:
        if ((r150 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r312 = "";
    L115:
        if ((r150 & 268435456) == 0) goto L117;
        String r313 = "";
    L119:
        if ((r150 & 536870912) == 0) goto L121;
        boolean r314 = false;
    L123:
        if ((r150 & 1073741824) == 0) goto L125;
        String r315 = "";
    L127:
        if ((r150 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r164 = false;
    L131:
        if ((r151 & 1) == 0) goto L133;
        String r316 = "";
    L135:
        if ((r151 & 2) == 0) goto L137;
        List r317 = null;
    L138:
        long r318 = 0;
        if ((r151 & 4) == 0) goto L141;
        long r410 = 0;
    L143:
        if ((r151 & 8) == 0) goto L145;
        String r319 = "";
    L147:
        if ((r151 & 16) == 0) goto L149;
        List r411 = null;
    L151:
        if ((r151 & 32) == 0) goto L153;
        long r412 = 0;
    L155:
        if ((r151 & 64) == 0) goto L157;
        String r413 = null;
    L158:
        boolean r1510 = r164;
        if ((r151 & 128) == 0) goto L161;
        List r165 = null;
    L162:
        List r414 = r165;
        if ((r151 & 256) == 0) goto L165;
        List r166 = null;
    L166:
        List r415 = r166;
        if ((r151 & 512) == 0) goto L169;
        String r167 = "";
    L170:
        String r416 = r167;
        if ((r151 & 1024) == 0) goto L173;
        String r168 = "";
    L174:
        String r510 = r168;
        if ((r151 & 2048) == 0) goto L177;
        boolean r169 = false;
    L178:
        boolean r511 = r169;
        if ((r151 & 4096) == 0) goto L181;
        String r170 = "";
    L182:
        String r512 = r170;
        if ((r151 & 8192) == 0) goto L185;
        String r171 = "";
    L186:
        String r1511 = r171;
        if ((r151 & 16384) == 0) goto L189;
        String r172 = null;
    L191:
        if ((r151 & 32768) == 0) goto L193;
        String r173 = "760.0.0.269-alpha.24";
    L195:
        if ((r151 & 65536) == 0) goto L197;
        String r174 = null;
    L199:
        if ((r151 & 131072) == 0) goto L201;
        String r219 = null;
    L203:
        if ((r151 & 262144) == 0) goto L205;
        String r513 = null;
    L207:
        if ((r151 & 524288) == 0) goto L209;
        String r514 = null;
    L211:
        if ((r151 & 1048576) == 0) goto L213;
        String r515 = null;
    L215:
        if ((r151 & 2097152) == 0) goto L217;
        AuthorThumbModel r516 = null;
    L219:
        if ((r151 & 4194304) == 0) goto L221;
        List r517 = null;
    L223:
        if ((r151 & 8388608) == 0) goto L225;
        String r518 = null;
    L227:
        if ((r151 & 16777216) == 0) goto L229;
        int r519 = -1;
    L231:
        if ((r151 & 33554432) == 0) goto L233;
        long r610 = -1;
    L235:
        if ((r151 & 67108864) == 0) goto L237;
        String r611 = null;
    L239:
        if ((r151 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        long r612 = -1;
    L243:
        if ((r151 & 268435456) == 0) goto L245;
        UrlModel r613 = new UrlModel(null, null, null, null, 15, null);
    L247:
        if ((r151 & 536870912) == 0) goto L249;
        String r614 = null;
    L251:
        if ((r151 & 1073741824) == 0) goto L253;
        long r615 = 0;
    L255:
        if ((r151 & Integer.MIN_VALUE) == 0) goto L257;
        List r175 = null;
    L259:
        if ((r152 & 1) == 0) goto L261;
        String r616 = null;
    L263:
        if ((r152 & 2) == 0) goto L265;
        long r715 = 0;
    L267:
        if ((r152 & 4) == 0) goto L269;
        int r716 = 0;
    L271:
        if ((r152 & 8) != 0) goto L274;
        r318 = r148;
    L274:
        this(r110, r114, r135, r138, r142, r146, r149, r154, r155, r156, r157, r158, r159, r161, r162, r163, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r1510, r316, r317, r410, r319, r411, r412, r413, r414, r415, r416, r510, r511, r512, r1511, r172, r173, r174, r219, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r175, r616, r715, r716, r318);
        return;
    L269:
        r716 = r147;
        goto L271
    L265:
        r715 = r145;
        goto L267
    L261:
        r616 = r144;
        goto L263
    L257:
        r175 = r143;
        goto L259
    L253:
        r615 = r141;
        goto L255
    L249:
        r614 = r140;
        goto L251
    L245:
        r613 = r139;
        goto L247
    L241:
        r612 = r137;
        goto L243
    L237:
        r611 = r136;
        goto L239
    L233:
        r610 = r134;
        goto L235
    L229:
        r519 = r133;
        goto L231
    L225:
        r518 = r132;
        goto L227
    L221:
        r517 = r131;
        goto L223
    L217:
        r516 = r130;
        goto L219
    L213:
        r515 = r129;
        goto L215
    L209:
        r514 = r128;
        goto L211
    L205:
        r513 = r127;
        goto L207
    L201:
        r219 = r126;
        goto L203
    L197:
        r174 = r125;
        goto L199
    L193:
        r173 = r124;
        goto L195
    L189:
        r172 = r123;
        goto L191
    L185:
        r171 = r122;
        goto L186
    L181:
        r170 = r121;
        goto L182
    L177:
        r169 = r120;
        goto L178
    L173:
        r168 = r119;
        goto L174
    L169:
        r167 = r118;
        goto L170
    L165:
        r166 = r117;
        goto L166
    L161:
        r165 = r116;
        goto L162
    L157:
        r413 = r115;
        goto L158
    L153:
        r412 = r113;
        goto L155
    L149:
        r411 = r112;
        goto L151
    L145:
        r319 = r111;
        goto L147
    L141:
        r410 = r109;
        goto L143
    L137:
        r317 = r108;
        goto L138
    L133:
        r316 = r107;
        goto L135
    L129:
        r164 = r106;
        goto L131
    L125:
        r315 = r105;
        goto L127
    L121:
        r314 = r104;
        goto L123
    L117:
        r313 = r103;
        goto L119
    L113:
        r312 = r102;
        goto L115
    L109:
        r311 = r101;
        goto L111
    L105:
        r310 = r100;
        goto L107
    L101:
        r218 = r919;
        goto L103
    L97:
        r217 = r918;
        goto L99
    L93:
        r216 = r917;
        goto L95
    L89:
        r215 = r916;
        goto L91
    L85:
        r214 = r915;
        goto L87
    L81:
        r213 = r914;
        goto L83
    L77:
        r212 = r913;
        goto L79
    L73:
        r211 = r912;
        goto L75
    L69:
        r210 = r911;
        goto L71
    L65:
        r163 = r910;
        goto L67
    L61:
        r162 = r819;
        goto L63
    L57:
        r160 = r818;
        goto L58
    L53:
        r159 = r817;
        goto L55
    L49:
        r158 = r816;
        goto L51
    L45:
        r157 = r815;
        goto L47
    L41:
        r156 = r814;
        goto L43
    L37:
        r155 = r813;
        goto L39
    L33:
        r154 = r812;
        goto L35
    L29:
        r149 = r811;
        goto L31
    L25:
        r146 = r810;
        goto L27
    L21:
        r142 = r714;
        goto L23
    L17:
        r138 = r713;
        goto L19
    L13:
        r135 = r712;
        goto L15
    L9:
        r114 = r711;
        goto L11
    L5:
        r110 = r710;
        goto L7
    }
}
