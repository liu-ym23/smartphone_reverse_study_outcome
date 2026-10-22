package com.larus.im.internal.database.entity;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.im.internal.jni.bean.OmniMessageContentType;
import com.larus.im.internal.jni.bean.OmniMessageStatus;
import com.larus.im.internal.jni.bean.OmniMessageStatusLocal;
import com.larus.im.internal.jni.bean.OmniRegenStatus;
import com.larus.im.internal.jni.bean.OmniUserType;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\bi\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ©\u00012\u00020\u0001:\u0004©\u0001ª\u0001Bù\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u000e\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u000b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u000b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u00100\u001a\u00020\b\u0012\b\b\u0002\u00101\u001a\u00020\b¢\u0006\u0004\b2\u00103B\t\b\u0016¢\u0006\u0004\b2\u00104B¿\u0003\b\u0010\u0012\u0006\u00105\u001a\u00020\u000b\u0012\u0006\u00106\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010!\u001a\u00020\u000e\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010#\u001a\u00020\u000b\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010%\u001a\u00020\u000b\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010.\u001a\u0004\u0018\u00010\b\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00100\u001a\u00020\b\u0012\u0006\u00101\u001a\u00020\b\u0012\b\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\b2\u00109J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010@J\t\u0010t\u001a\u00020\bHÆ\u0003J\t\u0010u\u001a\u00020\u000bHÆ\u0003J\t\u0010v\u001a\u00020\u000bHÆ\u0003J\t\u0010w\u001a\u00020\u000eHÆ\u0003J\t\u0010x\u001a\u00020\u000bHÆ\u0003J\t\u0010y\u001a\u00020\u000bHÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010|\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010MJ\t\u0010}\u001a\u00020\u000bHÆ\u0003J\t\u0010~\u001a\u00020\u000eHÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010MJ\n\u0010\u0088\u0001\u001a\u00020\bHÆ\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u000bHÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u000bHÆ\u0003J\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010MJ\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0097\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010@J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\bHÆ\u0003J\u0082\u0004\u0010\u009b\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010!\u001a\u00020\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010#\u001a\u00020\u000b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010%\u001a\u00020\u000b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00100\u001a\u00020\b2\b\b\u0002\u00101\u001a\u00020\bHÆ\u0001¢\u0006\u0003\u0010\u009c\u0001J\u0015\u0010\u009d\u0001\u001a\u00020\u000e2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u000bHÖ\u0001J\n\u0010 \u0001\u001a\u00020\u0003HÖ\u0001J-\u0010¡\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020\u00002\b\u0010¤\u0001\u001a\u00030¥\u00012\b\u0010¦\u0001\u001a\u00030§\u0001H\u0001¢\u0006\u0003\b¨\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010;R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010;R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010A\u001a\u0004\b?\u0010@R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010ER\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010GR\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bH\u0010ER\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bI\u0010ER\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010;R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010;R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010N\u001a\u0004\bL\u0010MR\u0011\u0010\u0014\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bO\u0010ER\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bP\u0010GR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010;R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u0010;R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010;R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u0010;R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u0010;R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u0010;R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u0010;R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bX\u0010;R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010N\u001a\u0004\bY\u0010MR\u0011\u0010\u001f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010CR\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u0010;R\u0011\u0010!\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010GR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b]\u0010;R\u0011\u0010#\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b^\u0010ER\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b_\u0010;R\u0011\u0010%\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b`\u0010ER\u0015\u0010&\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010N\u001a\u0004\ba\u0010MR\u0013\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010;R\u0013\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bc\u0010;R\u0013\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bd\u0010;R\u0013\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\be\u0010;R\u001e\u0010+\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bf\u00104\u001a\u0004\bg\u0010;R\u001e\u0010,\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bh\u00104\u001a\u0004\bi\u0010;R\u0013\u0010-\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bj\u0010;R\u0015\u0010.\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010A\u001a\u0004\bk\u0010@R\u0013\u0010/\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bl\u0010;R\u0011\u00100\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bm\u0010CR\u0011\u00101\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bn\u0010C¨\u0006«\u0001"}, d2 = {"Lcom/larus/im/internal/database/entity/MessageEntity;", "", "localMessageId", "", "messageId", "sectionId", "sectionName", "serverIndex", "", "createTime", "contentType", "", "beforeContentType", "isNewBlockType", "", "status", "messageStatus", "regenMessageList", "regenRootId", "regenIndex", "regenStatus", "regenVisible", "senderId", SelectInfo.BRIEF, "content", "thinkingContent", "ftsContent", "ext", "conversationId", "threadId", "feedback", "localIndex", "referenceInfo", "sourceFromAsr", "imageDataPath", "imageUploadStatus", "suggestQuestions", "userType", "messageBodyVersion", PromotionProductPrivilegesStruct.TAGS, "replyId", "bizContentType", "bizExtra", "subList", "subListGroup", "collectionId", "subMessageIndex", "referMsgId", "timeGroupId", "audioDuration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JIIZIILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/String;ZLjava/lang/String;ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;JJ)V", "()V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JIIZIILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/String;ZLjava/lang/String;ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLocalMessageId", "()Ljava/lang/String;", "getMessageId", "getSectionId", "getSectionName", "getServerIndex", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreateTime", "()J", "getContentType", "()I", "getBeforeContentType", "()Z", "getStatus", "getMessageStatus", "getRegenMessageList", "getRegenRootId", "getRegenIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRegenStatus", "getRegenVisible", "getSenderId", "getBrief", "getContent", "getThinkingContent", "getFtsContent", "getExt", "getConversationId", "getThreadId", "getFeedback", "getLocalIndex", "getReferenceInfo", "getSourceFromAsr", "getImageDataPath", "getImageUploadStatus", "getSuggestQuestions", "getUserType", "getMessageBodyVersion", "getTags", "getReplyId", "getBizContentType", "getBizExtra", "getSubList$annotations", "getSubList", "getSubListGroup$annotations", "getSubListGroup", "getCollectionId", "getSubMessageIndex", "getReferMsgId", "getTimeGroupId", "getAudioDuration", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JIIZIILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/String;ZLjava/lang/String;ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;JJ)Lcom/larus/im/internal/database/entity/MessageEntity;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "Companion", "$serializer", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class MessageEntity {
    public static final b Companion = null;
    private static final String DEFAULT_LOCAL_MESSAGE_ID = "";
    private final long audioDuration;
    private final int beforeContentType;
    private final String bizContentType;
    private final String bizExtra;
    private final String brief;
    private final String collectionId;
    private final String content;
    private final int contentType;
    private final String conversationId;
    private final long createTime;
    private final String ext;
    private final Integer feedback;
    private final String ftsContent;
    private final String imageDataPath;
    private final int imageUploadStatus;
    private final boolean isNewBlockType;
    private final long localIndex;
    private final String localMessageId;
    private final Integer messageBodyVersion;
    private final String messageId;
    private final int messageStatus;
    private final String referMsgId;
    private final String referenceInfo;
    private final Integer regenIndex;
    private final String regenMessageList;
    private final String regenRootId;
    private final int regenStatus;
    private final boolean regenVisible;
    private final String replyId;
    private final String sectionId;
    private final String sectionName;
    private final String senderId;
    private final Long serverIndex;
    private final boolean sourceFromAsr;
    private final int status;
    private final String subList;
    private final String subListGroup;
    private final Long subMessageIndex;
    private final String suggestQuestions;
    private final String tags;
    private final String thinkingContent;
    private final String threadId;
    private final long timeGroupId;
    private final int userType;

    /* JADX INFO: loaded from: classes29.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<MessageEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f348117a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f348118b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f348118b;
        }

        static {
            a r100 = new a();
            f348117a = r100;
            g2 r101 = new g2("com.larus.im.internal.database.entity.MessageEntity", r100, 44);
            r101.j("localMessageId", true);
            r101.j("messageId", true);
            r101.j("sectionId", true);
            r101.j("sectionName", true);
            r101.j("serverIndex", true);
            r101.j("createTime", true);
            r101.j("contentType", true);
            r101.j("beforeContentType", true);
            r101.j("isNewBlockType", true);
            r101.j("status", true);
            r101.j("messageStatus", true);
            r101.j("regenMessageList", true);
            r101.j("regenRootId", true);
            r101.j("regenIndex", true);
            r101.j("regenStatus", true);
            r101.j("regenVisible", true);
            r101.j("senderId", true);
            r101.j(SelectInfo.BRIEF, true);
            r101.j("content", true);
            r101.j("thinkingContent", true);
            r101.j("ftsContent", true);
            r101.j("ext", true);
            r101.j("conversationId", true);
            r101.j("threadId", true);
            r101.j("feedback", true);
            r101.j("localIndex", true);
            r101.j("referenceInfo", true);
            r101.j("sourceFromAsr", true);
            r101.j("imageDataPath", true);
            r101.j("imageUploadStatus", true);
            r101.j("suggestQuestions", true);
            r101.j("userType", true);
            r101.j("messageBodyVersion", true);
            r101.j(PromotionProductPrivilegesStruct.TAGS, true);
            r101.j("replyId", true);
            r101.j("bizContentType", true);
            r101.j("bizExtra", true);
            r101.j("subList", true);
            r101.j("subListGroup", true);
            r101.j("collectionId", true);
            r101.j("subMessageIndex", true);
            r101.j("referMsgId", true);
            r101.j("timeGroupId", true);
            r101.j("audioDuration", true);
            f348118b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            g1 r101 = g1.f520681a;
            w0 r102 = w0.f520792a;
            i r103 = i.f520705a;
            return new d[]{r100, kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), r101, r102, r102, r103, r102, r102, kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r102), r102, r103, kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r102), r101, kuc.a.d(r100), r103, kuc.a.d(r100), r102, kuc.a.d(r100), r102, kuc.a.d(r102), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r100), r101, r101};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r710) {
            Intrinsics.checkNotNullParameter(r710, "decoder");
            g2 r100 = f348118b;
            c r101 = r710.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            String r102 = r101.decodeStringElement(r100, 0);
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
            g1 r111 = g1.f520681a;
            Long r112 = (Long) r101.decodeNullableSerializableElement(r100, 4, r111, null);
            long r210 = r101.decodeLongElement(r100, 5);
            int r113 = r101.decodeIntElement(r100, 6);
            int r114 = r101.decodeIntElement(r100, 7);
            boolean r106 = r101.decodeBooleanElement(r100, 8);
            int r107 = r101.decodeIntElement(r100, 9);
            int r108 = r101.decodeIntElement(r100, 10);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 11, r103, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 12, r103, null);
            w0 r116 = w0.f520792a;
            Integer r117 = (Integer) r101.decodeNullableSerializableElement(r100, 13, r116, null);
            int r118 = r101.decodeIntElement(r100, 14);
            boolean r119 = r101.decodeBooleanElement(r100, 15);
            String r120 = (String) r101.decodeNullableSerializableElement(r100, 16, r103, null);
            String r121 = (String) r101.decodeNullableSerializableElement(r100, 17, r103, null);
            String r122 = (String) r101.decodeNullableSerializableElement(r100, 18, r103, null);
            String r123 = (String) r101.decodeNullableSerializableElement(r100, 19, r103, null);
            String r124 = (String) r101.decodeNullableSerializableElement(r100, 20, r103, null);
            String r125 = (String) r101.decodeNullableSerializableElement(r100, 21, r103, null);
            String r126 = (String) r101.decodeNullableSerializableElement(r100, 22, r103, null);
            String r127 = (String) r101.decodeNullableSerializableElement(r100, 23, r103, null);
            Integer r128 = (Integer) r101.decodeNullableSerializableElement(r100, 24, r116, null);
            long r310 = r101.decodeLongElement(r100, 25);
            String r129 = (String) r101.decodeNullableSerializableElement(r100, 26, r103, null);
            boolean r130 = r101.decodeBooleanElement(r100, 27);
            String r131 = (String) r101.decodeNullableSerializableElement(r100, 28, r103, null);
            int r132 = r101.decodeIntElement(r100, 29);
            String r133 = (String) r101.decodeNullableSerializableElement(r100, 30, r103, null);
            int r134 = r101.decodeIntElement(r100, 31);
            Integer r135 = (Integer) r101.decodeNullableSerializableElement(r100, 32, r116, null);
            String r136 = (String) r101.decodeNullableSerializableElement(r100, 33, r103, null);
            String r137 = (String) r101.decodeNullableSerializableElement(r100, 34, r103, null);
            String r138 = (String) r101.decodeNullableSerializableElement(r100, 35, r103, null);
            String r139 = (String) r101.decodeNullableSerializableElement(r100, 36, r103, null);
            String r140 = (String) r101.decodeNullableSerializableElement(r100, 37, r103, null);
            String r141 = (String) r101.decodeNullableSerializableElement(r100, 38, r103, null);
            String r142 = (String) r101.decodeNullableSerializableElement(r100, 39, r103, null);
            Long r143 = (Long) r101.decodeNullableSerializableElement(r100, 40, r111, null);
            String r144 = (String) r101.decodeNullableSerializableElement(r100, 41, r103, null);
            long r410 = r101.decodeLongElement(r100, 42);
            long r411 = r101.decodeLongElement(r100, 43);
            int r145 = UnixStat.PERM_MASK;
            Long r510 = r143;
            String r511 = r144;
            String r512 = r139;
            String r513 = r140;
            String r514 = r141;
            String r515 = r142;
            long r516 = r410;
            long r517 = r411;
            Integer r412 = r135;
            String r413 = r136;
            int r414 = r132;
            String r146 = r102;
            String r415 = r133;
            String r416 = r131;
            int r417 = r134;
            String r418 = r137;
            String r518 = r138;
            int r211 = r108;
            boolean r419 = r130;
            String r420 = r129;
            String r311 = r122;
            Integer r312 = r128;
            Long r147 = r112;
            String r313 = r126;
            long r314 = r310;
            String r315 = r123;
            String r316 = r120;
            String r317 = r124;
            String r148 = r110;
            boolean r212 = r106;
            int r213 = r118;
            String r318 = r127;
            String r319 = r121;
            int r214 = r114;
            int r149 = -1;
            int r215 = r113;
            String r150 = r104;
            long r151 = r210;
            String r216 = r115;
            String r217 = r109;
            int r218 = r107;
            String r152 = r105;
            Integer r219 = r117;
            String r320 = r125;
            boolean r220 = r119;
        L83:
            r101.endStructure(r100);
            return new MessageEntity(r149, r145, r146, r150, r152, r148, r147, r151, r215, r214, r212, r218, r211, r216, r217, r219, r213, r220, r316, r319, r311, r315, r317, r320, r313, r318, r312, r314, r420, r419, r416, r414, r415, r417, r412, r413, r418, r518, r512, r513, r514, r515, r510, r511, r516, r517, null);
        L5:
            String r153 = null;
            String r154 = null;
            String r155 = null;
            String r156 = null;
            String r157 = null;
            String r158 = null;
            String r159 = null;
            Long r160 = null;
            Integer r161 = null;
            String r162 = null;
            String r163 = null;
            String r164 = null;
            String r421 = null;
            String r422 = null;
            String r423 = null;
            Long r424 = null;
            String r425 = null;
            String r426 = null;
            Integer r427 = null;
            String r428 = null;
            String r519 = null;
            String r520 = null;
            String r521 = null;
            String r522 = null;
            String r523 = null;
            String r524 = null;
            String r525 = null;
            String r526 = null;
            Integer r527 = null;
            String r610 = null;
            long r611 = 0;
            long r612 = 0;
            long r613 = 0;
            long r711 = 0;
            int r165 = 0;
            int r166 = 0;
            int r221 = 0;
            boolean r222 = false;
            boolean r223 = false;
            int r321 = 0;
            boolean r429 = false;
            int r430 = 0;
            int r528 = 0;
            int r614 = 0;
            int r615 = 0;
            int r616 = 0;
            boolean r712 = true;
        L6:
            if (r712 == false) goto L82;
            String r713 = r159;
            int r167 = r101.decodeElementIndex(r100);
            switch(r167) {
                case -1: goto L79;
                case 0: goto L78;
                case 1: goto L77;
                case 2: goto L74;
                case 3: goto L72;
                case 4: goto L70;
                case 5: goto L68;
                case 6: goto L65;
                case 7: goto L63;
                case 8: goto L62;
                case 9: goto L61;
                case 10: goto L60;
                case 11: goto L59;
                case 12: goto L58;
                case 13: goto L57;
                case 14: goto L54;
                case 15: goto L53;
                case 16: goto L52;
                case 17: goto L51;
                case 18: goto L49;
                case 19: goto L45;
                case 20: goto L43;
                case 21: goto L41;
                case 22: goto L40;
                case 23: goto L38;
                case 24: goto L37;
                case 25: goto L36;
                case 26: goto L35;
                case 27: goto L33;
                case 28: goto L32;
                case 29: goto L29;
                case 30: goto L28;
                case 31: goto L26;
                case 32: goto L24;
                case 33: goto L22;
                case 34: goto L21;
                case 35: goto L20;
                case 36: goto L19;
                case 37: goto L18;
                case 38: goto L17;
                case 39: goto L16;
                case 40: goto L15;
                case 41: goto L14;
                case 42: goto L12;
                case 43: goto L11;
                default: goto L10;
            };
        L11:
            r711 = r101.decodeLongElement(r100, 43);
            int r168 = r165 | 2048;
        L13:
            Unit r169 = Unit.INSTANCE;
        L31:
            r165 = r168;
            String r170 = r164;
            r159 = r713;
            String r171 = r163;
            String r172 = r162;
            String r173 = r153;
            Integer r174 = r161;
            Long r175 = r160;
            String r176 = r523;
        L48:
            r154 = r154;
            r523 = r176;
            r160 = r175;
            r161 = r174;
            r153 = r173;
            r162 = r172;
            r163 = r171;
            r164 = r170;
            String r224 = r422;
            String r322 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r519 = r519;
            r520 = r520;
            r521 = r521;
            String r177 = r522;
        L81:
            r522 = r177;
            r521 = r521;
            r520 = r520;
            r519 = r519;
            r427 = r427;
            r426 = r426;
            r422 = r224;
            r423 = r322;
            r424 = r424;
            r425 = r425;
            r154 = r154;
            r165 = r165;
            goto L6
        L12:
            r613 = r101.decodeLongElement(r100, 42);
            r168 = r165 | 1024;
            goto L13
        L14:
            r158 = (String) r101.decodeNullableSerializableElement(r100, 41, v2.f520790a, r158);
            int r178 = r165 | 512;
        L23:
            r165 = r178;
        L25:
            Unit r179 = Unit.INSTANCE;
        L27:
            Long r180 = r160;
            r176 = r523;
        L44:
            Long r181 = r180;
            r165 = r165;
            String r182 = r522;
        L46:
            r170 = r164;
            r171 = r163;
            r172 = r162;
            r173 = r153;
            r174 = r161;
            r175 = r181;
            r159 = r713;
        L47:
            r522 = r182;
            r154 = r154;
            goto L48
        L15:
            r160 = (Long) r101.decodeNullableSerializableElement(r100, 40, g1.f520681a, r160);
            r178 = r165 | 256;
            goto L23
        L16:
            r153 = (String) r101.decodeNullableSerializableElement(r100, 39, v2.f520790a, r153);
            r178 = r165 | 128;
            goto L23
        L17:
            r157 = (String) r101.decodeNullableSerializableElement(r100, 38, v2.f520790a, r157);
            r178 = r165 | 64;
            goto L23
        L18:
            r155 = (String) r101.decodeNullableSerializableElement(r100, 37, v2.f520790a, r155);
            r178 = r165 | 32;
            goto L23
        L19:
            r162 = (String) r101.decodeNullableSerializableElement(r100, 36, v2.f520790a, r162);
            r178 = r165 | 16;
            goto L23
        L20:
            r154 = r154;
            r156 = (String) r101.decodeNullableSerializableElement(r100, 35, v2.f520790a, r156);
            r165 = r165 | 8;
            Unit r183 = Unit.INSTANCE;
            goto L27
        L21:
            r163 = (String) r101.decodeNullableSerializableElement(r100, 34, v2.f520790a, r163);
            r178 = r165 | 4;
            goto L23
        L22:
            r164 = (String) r101.decodeNullableSerializableElement(r100, 33, v2.f520790a, r164);
            r178 = r165 | 2;
            goto L23
        L24:
            r154 = r154;
            r161 = (Integer) r101.decodeNullableSerializableElement(r100, 32, w0.f520792a, r161);
            r165 = r165 | 1;
            goto L25
        L26:
            r154 = r154;
            int r184 = r101.decodeIntElement(r100, 31);
            r166 = r166 | Integer.MIN_VALUE;
            Unit r431 = Unit.INSTANCE;
            r430 = r184;
            goto L27
        L28:
            r154 = (String) r101.decodeNullableSerializableElement(r100, 30, v2.f520790a, r154);
            int r185 = 1073741824;
        L30:
            r166 = r166 | r185;
            Unit r186 = Unit.INSTANCE;
            r168 = r165;
            goto L31
        L29:
            r615 = r101.decodeIntElement(r100, 29);
            r154 = r154;
            r185 = 536870912;
            goto L30
        L32:
            r154 = r154;
            r159 = (String) r101.decodeNullableSerializableElement(r100, 28, v2.f520790a, r713);
            int r187 = 268435456;
        L34:
            Unit r188 = Unit.INSTANCE;
            r166 = r187 | r166;
            r170 = r164;
            r182 = r522;
            r171 = r163;
            r172 = r162;
            r173 = r153;
            r174 = r161;
            r175 = r160;
            r176 = r523;
            goto L47
        L33:
            r154 = r154;
            r222 = r101.decodeBooleanElement(r100, 27);
            r187 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
            r159 = r713;
            goto L34
        L35:
            r154 = r154;
            r165 = r165;
            String r189 = (String) r101.decodeNullableSerializableElement(r100, 26, v2.f520790a, r610);
            r166 = r166 | 67108864;
            Unit r190 = Unit.INSTANCE;
            r610 = r189;
        L42:
            r180 = r160;
            r176 = r523;
            r165 = r165;
            goto L44
        L36:
            r612 = r101.decodeLongElement(r100, 25);
            int r191 = 33554432;
        L39:
            r166 = r166 | r191;
            Unit r192 = Unit.INSTANCE;
            goto L42
        L37:
            r154 = r154;
            r165 = r165;
            Integer r193 = (Integer) r101.decodeNullableSerializableElement(r100, 24, w0.f520792a, r527);
            r166 = r166 | 16777216;
            Unit r194 = Unit.INSTANCE;
            r527 = r193;
            goto L42
        L38:
            r526 = (String) r101.decodeNullableSerializableElement(r100, 23, v2.f520790a, r526);
            r191 = 8388608;
            goto L39
        L40:
            r154 = r154;
            r165 = r165;
            String r195 = (String) r101.decodeNullableSerializableElement(r100, 22, v2.f520790a, r525);
            r166 = r166 | 4194304;
            Unit r196 = Unit.INSTANCE;
            r525 = r195;
            goto L42
        L41:
            r154 = r154;
            r165 = r165;
            String r197 = (String) r101.decodeNullableSerializableElement(r100, 21, v2.f520790a, r524);
            r166 = r166 | 2097152;
            Unit r198 = Unit.INSTANCE;
            r524 = r197;
            goto L42
        L43:
            r154 = r154;
            int r714 = r165;
            String r199 = (String) r101.decodeNullableSerializableElement(r100, 20, v2.f520790a, r523);
            r166 = r166 | 1048576;
            Unit r200 = Unit.INSTANCE;
            r165 = r714;
            Long r715 = r160;
            r176 = r199;
            r180 = r715;
            goto L44
        L45:
            r154 = r154;
            r165 = r165;
            r182 = (String) r101.decodeNullableSerializableElement(r100, 19, v2.f520790a, r522);
            r166 = r166 | 524288;
            Unit r201 = Unit.INSTANCE;
            r181 = r160;
            r176 = r523;
            goto L46
        L49:
            r154 = r154;
            r165 = r165;
            r522 = r522;
            r523 = r523;
            r155 = r155;
            String r202 = (String) r101.decodeNullableSerializableElement(r100, 18, v2.f520790a, r521);
            int r203 = 262144 | r166;
            Unit r204 = Unit.INSTANCE;
            r166 = r203;
            r521 = r202;
            r224 = r422;
            r322 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r519 = r519;
            r520 = r520;
        L80:
            r421 = r421;
            r523 = r523;
            r155 = r155;
            r177 = r522;
            r159 = r713;
            goto L81
        L51:
            r154 = r154;
            r165 = r165;
            r155 = r155;
            r522 = r522;
            r523 = r523;
            r521 = r521;
            String r205 = (String) r101.decodeNullableSerializableElement(r100, 17, v2.f520790a, r520);
            int r206 = 131072 | r166;
            Unit r207 = Unit.INSTANCE;
            String r208 = r205;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r519 = r519;
        L73:
            r520 = r208;
            r322 = r423;
            r166 = r206;
        L76:
            r224 = r422;
            goto L80
        L52:
            r154 = r154;
            r165 = r165;
            r155 = r155;
            r521 = r521;
            r522 = r522;
            r523 = r523;
            r520 = r520;
            String r209 = (String) r101.decodeNullableSerializableElement(r100, 16, v2.f520790a, r519);
            int r225 = 65536 | r166;
            Unit r226 = Unit.INSTANCE;
            String r227 = r209;
            boolean r228 = r429;
        L56:
            r519 = r227;
            r429 = r228;
            r322 = r423;
        L75:
            r166 = r225;
            goto L76
        L53:
            r228 = r101.decodeBooleanElement(r100, 15);
            int r229 = r166 | 32768;
            Unit r432 = Unit.INSTANCE;
        L55:
            int r716 = r229;
            r227 = r519;
            r225 = r716;
            goto L56
        L54:
            r528 = r101.decodeIntElement(r100, 14);
            r229 = r166 | 16384;
            Unit r230 = Unit.INSTANCE;
            r228 = r429;
            goto L55
        L57:
            r154 = r154;
            r165 = r165;
            r155 = r155;
            r521 = r521;
            r522 = r522;
            r523 = r523;
            r519 = r519;
            Integer r231 = (Integer) r101.decodeNullableSerializableElement(r100, 13, w0.f520792a, r427);
            r206 = r166 | 8192;
            Unit r232 = Unit.INSTANCE;
            r427 = r231;
            r208 = r520;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            goto L73
        L58:
            r154 = r154;
            r165 = r165;
            r155 = r155;
            r519 = r519;
            r521 = r521;
            r522 = r522;
            r523 = r523;
            r427 = r427;
            String r233 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r426);
            int r234 = r166 | 4096;
            Unit r235 = Unit.INSTANCE;
            r426 = r233;
            r206 = r234;
            r208 = r520;
            r424 = r424;
            r425 = r425;
            goto L73
        L59:
            r154 = r154;
            r165 = r165;
            r155 = r155;
            r427 = r427;
            r519 = r519;
            r520 = r520;
            r521 = r521;
            r522 = r522;
            r523 = r523;
            r426 = r426;
            String r236 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r425);
            r206 = r166 | 2048;
            Unit r237 = Unit.INSTANCE;
            String r238 = r236;
        L69:
            r425 = r238;
            r208 = r520;
            r424 = r424;
            goto L73
        L60:
            r221 = r101.decodeIntElement(r100, 10);
            int r239 = r166 | 1024;
            Unit r323 = Unit.INSTANCE;
        L66:
            int r717 = r239;
            r238 = r425;
            r206 = r717;
            goto L69
        L61:
            int r324 = r101.decodeIntElement(r100, 9);
            r239 = r166 | 512;
            Unit r325 = Unit.INSTANCE;
            r321 = r324;
            goto L66
        L62:
            r223 = r101.decodeBooleanElement(r100, 8);
            r239 = r166 | 256;
            Unit r326 = Unit.INSTANCE;
            goto L66
        L63:
            r614 = r101.decodeIntElement(r100, 7);
            r239 = r166 | 128;
            Unit r327 = Unit.INSTANCE;
            goto L66
        L65:
            r154 = r154;
            r165 = r165;
            r155 = r155;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r519 = r519;
            r520 = r520;
            r521 = r521;
            r522 = r522;
            r523 = r523;
            r616 = r101.decodeIntElement(r100, 6);
            r239 = r166 | 64;
            Unit r328 = Unit.INSTANCE;
            goto L66
        L68:
            r154 = r154;
            r165 = r165;
            r155 = r155;
            r426 = r426;
            r427 = r427;
            r519 = r519;
            r520 = r520;
            r521 = r521;
            r522 = r522;
            r523 = r523;
            r611 = r101.decodeLongElement(r100, 5);
            int r240 = r166 | 32;
            Unit r329 = Unit.INSTANCE;
            r238 = r425;
            r206 = r240;
            goto L69
        L70:
            r154 = r154;
            r165 = r165;
            r155 = r155;
            r426 = r426;
            r427 = r427;
            r519 = r519;
            r521 = r521;
            r522 = r522;
            r523 = r523;
            r425 = r425;
            Long r241 = (Long) r101.decodeNullableSerializableElement(r100, 4, g1.f520681a, r424);
            int r242 = r166 | 16;
            Unit r243 = Unit.INSTANCE;
            r424 = r241;
            r206 = r242;
            r208 = r520;
            goto L73
        L72:
            r154 = r154;
            r165 = r165;
            r155 = r155;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r519 = r519;
            r521 = r521;
            r522 = r522;
            r523 = r523;
            r424 = r424;
            String r244 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r423);
            r206 = r166 | 8;
            Unit r245 = Unit.INSTANCE;
            r423 = r244;
            r208 = r520;
            goto L73
        L74:
            r154 = r154;
            r165 = r165;
            r155 = r155;
            r519 = r519;
            r520 = r520;
            r521 = r521;
            r522 = r522;
            r523 = r523;
            r322 = r423;
            String r246 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r422);
            r225 = r166 | 4;
            Unit r247 = Unit.INSTANCE;
            r422 = r246;
            goto L75
        L77:
            r154 = r154;
            r165 = r165;
            r155 = r155;
            r322 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r519 = r519;
            r520 = r520;
            r521 = r521;
            r522 = r522;
            r523 = r523;
            r224 = r422;
            String r248 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r421);
            r166 = r166 | 2;
            Unit r249 = Unit.INSTANCE;
            r421 = r248;
            goto L80
        L78:
            r154 = r154;
            r165 = r165;
            r155 = r155;
            r421 = r421;
            r224 = r422;
            r322 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r519 = r519;
            r520 = r520;
            r521 = r521;
            r522 = r522;
            r523 = r523;
            r428 = r101.decodeStringElement(r100, 0);
            r166 = r166 | 1;
            Unit r250 = Unit.INSTANCE;
            goto L80
        L79:
            r154 = r154;
            r165 = r165;
            r155 = r155;
            r421 = r421;
            r224 = r422;
            r322 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r519 = r519;
            r520 = r520;
            r521 = r521;
            r522 = r522;
            r523 = r523;
            Unit r251 = Unit.INSTANCE;
            r712 = false;
            goto L80
        L10:
            throw new UnknownFieldException(r167);
        L82:
            String r1100 = r155;
            String r252 = r421;
            Long r330 = r424;
            String r331 = r425;
            String r253 = r426;
            Integer r254 = r427;
            String r255 = r519;
            String r1101 = r520;
            String r1102 = r521;
            String r1103 = r523;
            r518 = r156;
            r514 = r157;
            r315 = r522;
            r510 = r160;
            r412 = r161;
            r515 = r153;
            r512 = r162;
            r413 = r164;
            r317 = r1103;
            r419 = r222;
            r152 = r422;
            r148 = r423;
            r220 = r429;
            r417 = r430;
            r146 = r428;
            r213 = r528;
            r320 = r524;
            r313 = r525;
            r318 = r526;
            r312 = r527;
            r214 = r614;
            r420 = r610;
            r414 = r615;
            r215 = r616;
            r516 = r613;
            r517 = r711;
            r416 = r159;
            r415 = r154;
            r145 = r165;
            r149 = r166;
            r511 = r158;
            r418 = r163;
            r513 = r1100;
            r316 = r255;
            r217 = r253;
            r211 = r221;
            r212 = r223;
            r147 = r330;
            r216 = r331;
            r150 = r252;
            r311 = r1102;
            r319 = r1101;
            r219 = r254;
            r218 = r321;
            r151 = r611;
            r314 = r612;
            goto L83
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            MessageEntity r102 = (MessageEntity) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f348118b;
            muc.d r104 = r100.beginStructure(r103);
            MessageEntity.write$Self$omnisdk_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<MessageEntity> serializer() {
            return a.f348117a;
        }
    }

    public static /* synthetic */ MessageEntity copy$default(MessageEntity r110, String r111, String r112, String r210, String r211, Long r212, long r213, int r214, int r215, boolean r216, int r217, int r218, String r310, String r311, Integer r312, int r313, boolean r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, Integer r413, long r414, String r415, boolean r416, String r417, int r418, String r510, int r511, Integer r512, String r513, String r514, String r515, String r516, String r517, String r518, String r519, Long r610, String r611, long r612, long r613, int r614, int r615, Object r616) {
        if ((r614 & 1) == 0) goto L5;
        String r100 = r110.localMessageId;
    L7:
        if ((r614 & 2) == 0) goto L9;
        String r101 = r110.messageId;
    L11:
        if ((r614 & 4) == 0) goto L13;
        String r102 = r110.sectionId;
    L15:
        if ((r614 & 8) == 0) goto L17;
        String r103 = r110.sectionName;
    L19:
        if ((r614 & 16) == 0) goto L21;
        Long r104 = r110.serverIndex;
    L23:
        if ((r614 & 32) == 0) goto L25;
        long r105 = r110.createTime;
    L27:
        if ((r614 & 64) == 0) goto L29;
        int r113 = r110.contentType;
    L31:
        if ((r614 & 128) == 0) goto L33;
        int r114 = r110.beforeContentType;
    L35:
        if ((r614 & 256) == 0) goto L37;
        boolean r115 = r110.isNewBlockType;
    L39:
        if ((r614 & 512) == 0) goto L41;
        int r116 = r110.status;
    L43:
        if ((r614 & 1024) == 0) goto L45;
        int r117 = r110.messageStatus;
    L47:
        if ((r614 & 2048) == 0) goto L49;
        String r118 = r110.regenMessageList;
    L50:
        String r320 = r118;
        if ((r614 & 4096) == 0) goto L53;
        String r119 = r110.regenRootId;
    L54:
        String r321 = r119;
        if ((r614 & 8192) == 0) goto L57;
        Integer r120 = r110.regenIndex;
    L58:
        Integer r322 = r120;
        if ((r614 & 16384) == 0) goto L61;
        int r121 = r110.regenStatus;
    L62:
        int r323 = r121;
        if ((r614 & 32768) == 0) goto L65;
        boolean r122 = r110.regenVisible;
    L66:
        boolean r324 = r122;
        if ((r614 & 65536) == 0) goto L69;
        String r123 = r110.senderId;
    L70:
        String r325 = r123;
        if ((r614 & 131072) == 0) goto L73;
        String r124 = r110.brief;
    L74:
        String r326 = r124;
        if ((r614 & 262144) == 0) goto L77;
        String r125 = r110.content;
    L78:
        String r327 = r125;
        if ((r614 & 524288) == 0) goto L81;
        String r126 = r110.thinkingContent;
    L82:
        String r328 = r126;
        if ((r614 & 1048576) == 0) goto L85;
        String r127 = r110.ftsContent;
    L86:
        String r329 = r127;
        if ((r614 & 2097152) == 0) goto L89;
        String r128 = r110.ext;
    L90:
        String r419 = r128;
        if ((r614 & 4194304) == 0) goto L93;
        String r129 = r110.conversationId;
    L94:
        String r420 = r129;
        if ((r614 & 8388608) == 0) goto L97;
        String r130 = r110.threadId;
    L98:
        String r421 = r130;
        if ((r614 & 16777216) == 0) goto L101;
        Integer r131 = r110.feedback;
    L102:
        int r219 = r117;
        Integer r422 = r131;
        if ((r614 & 33554432) == 0) goto L105;
        long r132 = r110.localIndex;
    L106:
        long r423 = r132;
        if ((r614 & 67108864) == 0) goto L109;
        String r133 = r110.referenceInfo;
    L111:
        if ((134217728 & r614) == 0) goto L113;
        boolean r134 = r110.sourceFromAsr;
    L114:
        boolean r424 = r134;
        if ((r614 & 268435456) == 0) goto L117;
        String r135 = r110.imageDataPath;
    L118:
        String r425 = r135;
        if ((r614 & 536870912) == 0) goto L121;
        int r136 = r110.imageUploadStatus;
    L122:
        int r426 = r136;
        if ((r614 & 1073741824) == 0) goto L125;
        String r137 = r110.suggestQuestions;
    L127:
        if ((r614 & Integer.MIN_VALUE) == 0) goto L129;
        int r106 = r110.userType;
    L130:
        int r520 = r106;
        if ((r615 & 1) == 0) goto L133;
        Integer r107 = r110.messageBodyVersion;
    L134:
        Integer r521 = r107;
        if ((r615 & 2) == 0) goto L137;
        String r108 = r110.tags;
    L138:
        String r522 = r108;
        if ((r615 & 4) == 0) goto L141;
        String r109 = r110.replyId;
    L142:
        String r523 = r109;
        if ((r615 & 8) == 0) goto L145;
        String r138 = r110.bizContentType;
    L146:
        String r524 = r138;
        if ((r615 & 16) == 0) goto L149;
        String r139 = r110.bizExtra;
    L150:
        String r525 = r139;
        if ((r615 & 32) == 0) goto L153;
        String r140 = r110.subList;
    L154:
        String r526 = r140;
        if ((r615 & 64) == 0) goto L157;
        String r141 = r110.subListGroup;
    L158:
        String r527 = r141;
        if ((r615 & 128) == 0) goto L161;
        String r142 = r110.collectionId;
    L162:
        String r528 = r142;
        if ((r615 & 256) == 0) goto L165;
        Long r143 = r110.subMessageIndex;
    L166:
        Long r617 = r143;
        if ((r615 & 512) == 0) goto L169;
        String r144 = r110.referMsgId;
    L170:
        String r618 = r144;
        String r427 = r133;
        String r529 = r137;
        if ((r615 & 1024) == 0) goto L173;
        long r145 = r110.timeGroupId;
    L175:
        if ((r615 & 2048) == 0) goto L177;
        long r146 = r110.audioDuration;
    L179:
        return r110.copy(r100, r101, r102, r103, r104, r105, r113, r114, r115, r116, r219, r320, r321, r322, r323, r324, r325, r326, r327, r328, r329, r419, r420, r421, r422, r423, r427, r424, r425, r426, r529, r520, r521, r522, r523, r524, r525, r526, r527, r528, r617, r618, r145, r146);
    L177:
        r146 = r613;
        goto L179
    L173:
        r145 = r612;
        goto L175
    L169:
        r144 = r611;
        goto L170
    L165:
        r143 = r610;
        goto L166
    L161:
        r142 = r519;
        goto L162
    L157:
        r141 = r518;
        goto L158
    L153:
        r140 = r517;
        goto L154
    L149:
        r139 = r516;
        goto L150
    L145:
        r138 = r515;
        goto L146
    L141:
        r109 = r514;
        goto L142
    L137:
        r108 = r513;
        goto L138
    L133:
        r107 = r512;
        goto L134
    L129:
        r106 = r511;
        goto L130
    L125:
        r137 = r510;
        goto L127
    L121:
        r136 = r418;
        goto L122
    L117:
        r135 = r417;
        goto L118
    L113:
        r134 = r416;
        goto L114
    L109:
        r133 = r415;
        goto L111
    L105:
        r132 = r414;
        goto L106
    L101:
        r131 = r413;
        goto L102
    L97:
        r130 = r412;
        goto L98
    L93:
        r129 = r411;
        goto L94
    L89:
        r128 = r410;
        goto L90
    L85:
        r127 = r319;
        goto L86
    L81:
        r126 = r318;
        goto L82
    L77:
        r125 = r317;
        goto L78
    L73:
        r124 = r316;
        goto L74
    L69:
        r123 = r315;
        goto L70
    L65:
        r122 = r314;
        goto L66
    L61:
        r121 = r313;
        goto L62
    L57:
        r120 = r312;
        goto L58
    L53:
        r119 = r311;
        goto L54
    L49:
        r118 = r310;
        goto L50
    L45:
        r117 = r218;
        goto L47
    L41:
        r116 = r217;
        goto L43
    L37:
        r115 = r216;
        goto L39
    L33:
        r114 = r215;
        goto L35
    L29:
        r113 = r214;
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

    @Deprecated(message = "deleted")
    public static /* synthetic */ void getSubList$annotations() {
    }

    @Deprecated(message = "deleted")
    public static /* synthetic */ void getSubListGroup$annotations() {
    }

    public final String component1() {
        return this.localMessageId;
    }

    public final int component10() {
        return this.status;
    }

    public final int component11() {
        return this.messageStatus;
    }

    public final String component12() {
        return this.regenMessageList;
    }

    public final String component13() {
        return this.regenRootId;
    }

    public final Integer component14() {
        return this.regenIndex;
    }

    public final int component15() {
        return this.regenStatus;
    }

    public final boolean component16() {
        return this.regenVisible;
    }

    public final String component17() {
        return this.senderId;
    }

    public final String component18() {
        return this.brief;
    }

    public final String component19() {
        return this.content;
    }

    public final String component2() {
        return this.messageId;
    }

    public final String component20() {
        return this.thinkingContent;
    }

    public final String component21() {
        return this.ftsContent;
    }

    public final String component22() {
        return this.ext;
    }

    public final String component23() {
        return this.conversationId;
    }

    public final String component24() {
        return this.threadId;
    }

    public final Integer component25() {
        return this.feedback;
    }

    public final long component26() {
        return this.localIndex;
    }

    public final String component27() {
        return this.referenceInfo;
    }

    public final boolean component28() {
        return this.sourceFromAsr;
    }

    public final String component29() {
        return this.imageDataPath;
    }

    public final String component3() {
        return this.sectionId;
    }

    public final int component30() {
        return this.imageUploadStatus;
    }

    public final String component31() {
        return this.suggestQuestions;
    }

    public final int component32() {
        return this.userType;
    }

    public final Integer component33() {
        return this.messageBodyVersion;
    }

    public final String component34() {
        return this.tags;
    }

    public final String component35() {
        return this.replyId;
    }

    public final String component36() {
        return this.bizContentType;
    }

    public final String component37() {
        return this.bizExtra;
    }

    public final String component38() {
        return this.subList;
    }

    public final String component39() {
        return this.subListGroup;
    }

    public final String component4() {
        return this.sectionName;
    }

    public final String component40() {
        return this.collectionId;
    }

    public final Long component41() {
        return this.subMessageIndex;
    }

    public final String component42() {
        return this.referMsgId;
    }

    public final long component43() {
        return this.timeGroupId;
    }

    public final long component44() {
        return this.audioDuration;
    }

    public final Long component5() {
        return this.serverIndex;
    }

    public final long component6() {
        return this.createTime;
    }

    public final int component7() {
        return this.contentType;
    }

    public final int component8() {
        return this.beforeContentType;
    }

    public final boolean component9() {
        return this.isNewBlockType;
    }

    public final MessageEntity copy(String r510, String r511, String r512, String r513, Long r514, long r515, int r516, int r610, boolean r611, int r612, int r613, String r614, String r615, Integer r616, int r617, boolean r618, String r619, String r710, String r711, String r712, String r713, String r714, String r715, String r716, Integer r717, long r718, String r810, boolean r811, String r812, int r813, String r814, int r815, Integer r816, String r817, String r818, String r819, String r910, String r911, String r912, String r913, Long r914, String r915, long r916, long r917) {
        Intrinsics.checkNotNullParameter(r510, "localMessageId");
        return new MessageEntity(r510, r511, r512, r513, r514, r515, r516, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageEntity) == true) goto L8;
        return false;
    L8:
        MessageEntity r101 = (MessageEntity) r100;
        if (Intrinsics.areEqual(this.localMessageId, r101.localMessageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sectionId, r101.sectionId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sectionName, r101.sectionName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.serverIndex, r101.serverIndex) == true) goto L24;
        return false;
    L24:
        if (this.createTime == r101.createTime) goto L27;
        return false;
    L27:
        if (this.contentType == r101.contentType) goto L30;
        return false;
    L30:
        if (this.beforeContentType == r101.beforeContentType) goto L33;
        return false;
    L33:
        if (this.isNewBlockType == r101.isNewBlockType) goto L36;
        return false;
    L36:
        if (this.status == r101.status) goto L39;
        return false;
    L39:
        if (this.messageStatus == r101.messageStatus) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.regenMessageList, r101.regenMessageList) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.regenRootId, r101.regenRootId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.regenIndex, r101.regenIndex) == true) goto L51;
        return false;
    L51:
        if (this.regenStatus == r101.regenStatus) goto L54;
        return false;
    L54:
        if (this.regenVisible == r101.regenVisible) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.senderId, r101.senderId) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.brief, r101.brief) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.thinkingContent, r101.thinkingContent) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.ftsContent, r101.ftsContent) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.threadId, r101.threadId) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.feedback, r101.feedback) == true) goto L84;
        return false;
    L84:
        if (this.localIndex == r101.localIndex) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.referenceInfo, r101.referenceInfo) == true) goto L90;
        return false;
    L90:
        if (this.sourceFromAsr == r101.sourceFromAsr) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.imageDataPath, r101.imageDataPath) == true) goto L96;
        return false;
    L96:
        if (this.imageUploadStatus == r101.imageUploadStatus) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.suggestQuestions, r101.suggestQuestions) == true) goto L102;
        return false;
    L102:
        if (this.userType == r101.userType) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.messageBodyVersion, r101.messageBodyVersion) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.replyId, r101.replyId) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.bizContentType, r101.bizContentType) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.bizExtra, r101.bizExtra) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.subList, r101.subList) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.subListGroup, r101.subListGroup) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.collectionId, r101.collectionId) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.subMessageIndex, r101.subMessageIndex) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.referMsgId, r101.referMsgId) == true) goto L135;
        return false;
    L135:
        if (this.timeGroupId == r101.timeGroupId) goto L138;
        return false;
    L138:
        if (this.audioDuration == r101.audioDuration) goto L140;
        return false;
    L140:
        return true;
    }

    public int hashCode() {
        int r100 = this.localMessageId.hashCode() * 31;
        String r101 = this.messageId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.sectionId;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.sectionName;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Long r111 = this.serverIndex;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        long r113 = this.createTime;
        int r114 = (((((((r110 + r112) * 31) + ((int) (r113 ^ (r113 >>> 32)))) * 31) + this.contentType) * 31) + this.beforeContentType) * 31;
        int r115 = 1231;
        if (this.isNewBlockType == false) goto L21;
        int r116 = 1231;
    L22:
        int r117 = (((((r114 + r116) * 31) + this.status) * 31) + this.messageStatus) * 31;
        String r118 = this.regenMessageList;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.regenRootId;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        Integer r124 = this.regenIndex;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (((r123 + r125) * 31) + this.regenStatus) * 31;
        if (this.regenVisible == false) goto L37;
        int r127 = 1231;
    L38:
        int r128 = (r126 + r127) * 31;
        String r129 = this.senderId;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        String r132 = this.brief;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        String r135 = this.content;
        if (r135 != null) goto L49;
        int r136 = 0;
    L50:
        int r137 = (r134 + r136) * 31;
        String r138 = this.thinkingContent;
        if (r138 != null) goto L53;
        int r139 = 0;
    L54:
        int r140 = (r137 + r139) * 31;
        String r141 = this.ftsContent;
        if (r141 != null) goto L57;
        int r142 = 0;
    L58:
        int r143 = (r140 + r142) * 31;
        String r144 = this.ext;
        if (r144 != null) goto L61;
        int r145 = 0;
    L62:
        int r146 = (r143 + r145) * 31;
        String r147 = this.conversationId;
        if (r147 != null) goto L65;
        int r148 = 0;
    L66:
        int r149 = (r146 + r148) * 31;
        String r150 = this.threadId;
        if (r150 != null) goto L69;
        int r151 = 0;
    L70:
        int r152 = (r149 + r151) * 31;
        Integer r153 = this.feedback;
        if (r153 != null) goto L73;
        int r154 = 0;
    L74:
        long r155 = this.localIndex;
        int r156 = (((r152 + r154) * 31) + ((int) (r155 ^ (r155 >>> 32)))) * 31;
        String r157 = this.referenceInfo;
        if (r157 != null) goto L77;
        int r158 = 0;
    L78:
        int r159 = (r156 + r158) * 31;
        if (this.sourceFromAsr == true) goto L82;
        r115 = 1237;
    L82:
        int r160 = (r159 + r115) * 31;
        String r161 = this.imageDataPath;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (((r160 + r162) * 31) + this.imageUploadStatus) * 31;
        String r164 = this.suggestQuestions;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (((r163 + r165) * 31) + this.userType) * 31;
        Integer r167 = this.messageBodyVersion;
        if (r167 != null) goto L93;
        int r168 = 0;
    L94:
        int r169 = (r166 + r168) * 31;
        String r170 = this.tags;
        if (r170 != null) goto L97;
        int r171 = 0;
    L98:
        int r172 = (r169 + r171) * 31;
        String r173 = this.replyId;
        if (r173 != null) goto L101;
        int r174 = 0;
    L102:
        int r175 = (r172 + r174) * 31;
        String r176 = this.bizContentType;
        if (r176 != null) goto L105;
        int r177 = 0;
    L106:
        int r178 = (r175 + r177) * 31;
        String r179 = this.bizExtra;
        if (r179 != null) goto L109;
        int r180 = 0;
    L110:
        int r181 = (r178 + r180) * 31;
        String r182 = this.subList;
        if (r182 != null) goto L113;
        int r183 = 0;
    L114:
        int r184 = (r181 + r183) * 31;
        String r185 = this.subListGroup;
        if (r185 != null) goto L117;
        int r186 = 0;
    L118:
        int r187 = (r184 + r186) * 31;
        String r188 = this.collectionId;
        if (r188 != null) goto L121;
        int r189 = 0;
    L122:
        int r190 = (r187 + r189) * 31;
        Long r191 = this.subMessageIndex;
        if (r191 != null) goto L125;
        int r192 = 0;
    L126:
        int r193 = (r190 + r192) * 31;
        String r194 = this.referMsgId;
        if (r194 == null) goto L130;
        r102 = r194.hashCode();
    L130:
        int r195 = (r193 + r102) * 31;
        long r196 = this.timeGroupId;
        int r197 = (r195 + ((int) (r196 ^ (r196 >>> 32)))) * 31;
        long r198 = this.audioDuration;
        return r197 + ((int) (r198 ^ (r198 >>> 32)));
    L125:
        r192 = r191.hashCode();
        goto L126
    L121:
        r189 = r188.hashCode();
        goto L122
    L117:
        r186 = r185.hashCode();
        goto L118
    L113:
        r183 = r182.hashCode();
        goto L114
    L109:
        r180 = r179.hashCode();
        goto L110
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
    L77:
        r158 = r157.hashCode();
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
        r127 = 1237;
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = 1237;
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
        return "MessageEntity(localMessageId=" + this.localMessageId + ", messageId=" + this.messageId + ", sectionId=" + this.sectionId + ", sectionName=" + this.sectionName + ", serverIndex=" + this.serverIndex + ", createTime=" + this.createTime + ", contentType=" + this.contentType + ", beforeContentType=" + this.beforeContentType + ", isNewBlockType=" + this.isNewBlockType + ", status=" + this.status + ", messageStatus=" + this.messageStatus + ", regenMessageList=" + this.regenMessageList + ", regenRootId=" + this.regenRootId + ", regenIndex=" + this.regenIndex + ", regenStatus=" + this.regenStatus + ", regenVisible=" + this.regenVisible + ", senderId=" + this.senderId + ", brief=" + this.brief + ", content=" + this.content + ", thinkingContent=" + this.thinkingContent + ", ftsContent=" + this.ftsContent + ", ext=" + this.ext + ", conversationId=" + this.conversationId + ", threadId=" + this.threadId + ", feedback=" + this.feedback + ", localIndex=" + this.localIndex + ", referenceInfo=" + this.referenceInfo + ", sourceFromAsr=" + this.sourceFromAsr + ", imageDataPath=" + this.imageDataPath + ", imageUploadStatus=" + this.imageUploadStatus + ", suggestQuestions=" + this.suggestQuestions + ", userType=" + this.userType + ", messageBodyVersion=" + this.messageBodyVersion + ", tags=" + this.tags + ", replyId=" + this.replyId + ", bizContentType=" + this.bizContentType + ", bizExtra=" + this.bizExtra + ", subList=" + this.subList + ", subListGroup=" + this.subListGroup + ", collectionId=" + this.collectionId + ", subMessageIndex=" + this.subMessageIndex + ", referMsgId=" + this.referMsgId + ", timeGroupId=" + this.timeGroupId + ", audioDuration=" + this.audioDuration + ')';
    }

    static {
        Companion = new b();
    }

    public MessageEntity() {
        this("", null, null, null, null, 0, 0, 0, false, 0, 0, null, null, null, 0, false, null, null, null, null, null, null, null, null, null, 0, null, false, null, 0, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, -2, UnixStat.PERM_MASK, null);
    }

    public final long getAudioDuration() {
        return this.audioDuration;
    }

    public final int getBeforeContentType() {
        return this.beforeContentType;
    }

    public final String getBizContentType() {
        return this.bizContentType;
    }

    public final String getBizExtra() {
        return this.bizExtra;
    }

    public final String getBrief() {
        return this.brief;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getExt() {
        return this.ext;
    }

    public final Integer getFeedback() {
        return this.feedback;
    }

    public final String getFtsContent() {
        return this.ftsContent;
    }

    public final String getImageDataPath() {
        return this.imageDataPath;
    }

    public final int getImageUploadStatus() {
        return this.imageUploadStatus;
    }

    public final long getLocalIndex() {
        return this.localIndex;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final Integer getMessageBodyVersion() {
        return this.messageBodyVersion;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final int getMessageStatus() {
        return this.messageStatus;
    }

    public final String getReferMsgId() {
        return this.referMsgId;
    }

    public final String getReferenceInfo() {
        return this.referenceInfo;
    }

    public final Integer getRegenIndex() {
        return this.regenIndex;
    }

    public final String getRegenMessageList() {
        return this.regenMessageList;
    }

    public final String getRegenRootId() {
        return this.regenRootId;
    }

    public final int getRegenStatus() {
        return this.regenStatus;
    }

    public final boolean getRegenVisible() {
        return this.regenVisible;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final String getSectionName() {
        return this.sectionName;
    }

    public final String getSenderId() {
        return this.senderId;
    }

    public final Long getServerIndex() {
        return this.serverIndex;
    }

    public final boolean getSourceFromAsr() {
        return this.sourceFromAsr;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getSubList() {
        return this.subList;
    }

    public final String getSubListGroup() {
        return this.subListGroup;
    }

    public final Long getSubMessageIndex() {
        return this.subMessageIndex;
    }

    public final String getSuggestQuestions() {
        return this.suggestQuestions;
    }

    public final String getTags() {
        return this.tags;
    }

    public final String getThinkingContent() {
        return this.thinkingContent;
    }

    public final String getThreadId() {
        return this.threadId;
    }

    public final long getTimeGroupId() {
        return this.timeGroupId;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final boolean isNewBlockType() {
        return this.isNewBlockType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(MessageEntity r110, muc.d r111, f r112) {
        boolean r100 = false;
        if (r111.shouldEncodeElementDefault(r112, 0) == false) goto L6;
    L4:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        r111.encodeStringElement(r112, 0, r110.localMessageId);
    L12:
        if (r111.shouldEncodeElementDefault(r112, 1) == false) goto L15;
    L13:
        boolean r102 = true;
    L18:
        if (r102 == false) goto L21;
        r111.encodeNullableSerializableElement(r112, 1, v2.f520790a, r110.messageId);
    L21:
        if (r111.shouldEncodeElementDefault(r112, 2) == false) goto L24;
    L22:
        boolean r103 = true;
    L27:
        if (r103 == false) goto L30;
        r111.encodeNullableSerializableElement(r112, 2, v2.f520790a, r110.sectionId);
    L30:
        if (r111.shouldEncodeElementDefault(r112, 3) == false) goto L33;
    L31:
        boolean r104 = true;
    L36:
        if (r104 == false) goto L39;
        r111.encodeNullableSerializableElement(r112, 3, v2.f520790a, r110.sectionName);
    L39:
        if (r111.shouldEncodeElementDefault(r112, 4) == false) goto L42;
    L40:
        boolean r105 = true;
    L45:
        if (r105 == false) goto L48;
        r111.encodeNullableSerializableElement(r112, 4, g1.f520681a, r110.serverIndex);
    L48:
        if (r111.shouldEncodeElementDefault(r112, 5) == false) goto L51;
    L49:
        boolean r106 = true;
    L54:
        if (r106 == false) goto L57;
        r111.encodeLongElement(r112, 5, r110.createTime);
    L57:
        if (r111.shouldEncodeElementDefault(r112, 6) == false) goto L60;
    L58:
        boolean r107 = true;
    L63:
        if (r107 == false) goto L66;
        r111.encodeIntElement(r112, 6, r110.contentType);
    L66:
        if (r111.shouldEncodeElementDefault(r112, 7) == false) goto L69;
    L67:
        boolean r108 = true;
    L72:
        if (r108 == false) goto L75;
        r111.encodeIntElement(r112, 7, r110.beforeContentType);
    L75:
        if (r111.shouldEncodeElementDefault(r112, 8) == false) goto L78;
    L76:
        boolean r109 = true;
    L81:
        if (r109 == false) goto L84;
        r111.encodeBooleanElement(r112, 8, r110.isNewBlockType);
    L84:
        if (r111.shouldEncodeElementDefault(r112, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r111.encodeIntElement(r112, 9, r110.status);
    L93:
        if (r111.shouldEncodeElementDefault(r112, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r111.encodeIntElement(r112, 10, r110.messageStatus);
    L102:
        if (r111.shouldEncodeElementDefault(r112, 11) == false) goto L105;
    L103:
        boolean r115 = true;
    L108:
        if (r115 == false) goto L111;
        r111.encodeNullableSerializableElement(r112, 11, v2.f520790a, r110.regenMessageList);
    L111:
        if (r111.shouldEncodeElementDefault(r112, 12) == false) goto L114;
    L112:
        boolean r116 = true;
    L117:
        if (r116 == false) goto L120;
        r111.encodeNullableSerializableElement(r112, 12, v2.f520790a, r110.regenRootId);
    L120:
        if (r111.shouldEncodeElementDefault(r112, 13) == false) goto L123;
    L121:
        boolean r117 = true;
    L126:
        if (r117 == false) goto L129;
        r111.encodeNullableSerializableElement(r112, 13, w0.f520792a, r110.regenIndex);
    L129:
        if (r111.shouldEncodeElementDefault(r112, 14) == false) goto L132;
    L130:
        boolean r118 = true;
    L135:
        if (r118 == false) goto L138;
        r111.encodeIntElement(r112, 14, r110.regenStatus);
    L138:
        if (r111.shouldEncodeElementDefault(r112, 15) == false) goto L141;
    L139:
        boolean r119 = true;
    L144:
        if (r119 == false) goto L147;
        r111.encodeBooleanElement(r112, 15, r110.regenVisible);
    L147:
        if (r111.shouldEncodeElementDefault(r112, 16) == false) goto L150;
    L148:
        boolean r120 = true;
    L153:
        if (r120 == false) goto L156;
        r111.encodeNullableSerializableElement(r112, 16, v2.f520790a, r110.senderId);
    L156:
        if (r111.shouldEncodeElementDefault(r112, 17) == false) goto L159;
    L157:
        boolean r121 = true;
    L162:
        if (r121 == false) goto L165;
        r111.encodeNullableSerializableElement(r112, 17, v2.f520790a, r110.brief);
    L165:
        if (r111.shouldEncodeElementDefault(r112, 18) == false) goto L168;
    L166:
        boolean r122 = true;
    L171:
        if (r122 == false) goto L174;
        r111.encodeNullableSerializableElement(r112, 18, v2.f520790a, r110.content);
    L174:
        if (r111.shouldEncodeElementDefault(r112, 19) == false) goto L177;
    L175:
        boolean r123 = true;
    L180:
        if (r123 == false) goto L183;
        r111.encodeNullableSerializableElement(r112, 19, v2.f520790a, r110.thinkingContent);
    L183:
        if (r111.shouldEncodeElementDefault(r112, 20) == false) goto L186;
    L184:
        boolean r124 = true;
    L189:
        if (r124 == false) goto L192;
        r111.encodeNullableSerializableElement(r112, 20, v2.f520790a, r110.ftsContent);
    L192:
        if (r111.shouldEncodeElementDefault(r112, 21) == false) goto L195;
    L193:
        boolean r125 = true;
    L198:
        if (r125 == false) goto L201;
        r111.encodeNullableSerializableElement(r112, 21, v2.f520790a, r110.ext);
    L201:
        if (r111.shouldEncodeElementDefault(r112, 22) == false) goto L204;
    L202:
        boolean r126 = true;
    L207:
        if (r126 == false) goto L210;
        r111.encodeNullableSerializableElement(r112, 22, v2.f520790a, r110.conversationId);
    L210:
        if (r111.shouldEncodeElementDefault(r112, 23) == false) goto L213;
    L211:
        boolean r127 = true;
    L216:
        if (r127 == false) goto L219;
        r111.encodeNullableSerializableElement(r112, 23, v2.f520790a, r110.threadId);
    L219:
        if (r111.shouldEncodeElementDefault(r112, 24) == false) goto L221;
    L220:
        boolean r128 = true;
    L228:
        if (r128 == false) goto L231;
        r111.encodeNullableSerializableElement(r112, 24, w0.f520792a, r110.feedback);
    L231:
        if (r111.shouldEncodeElementDefault(r112, 25) == false) goto L234;
    L232:
        boolean r129 = true;
    L237:
        if (r129 == false) goto L240;
        r111.encodeLongElement(r112, 25, r110.localIndex);
    L240:
        if (r111.shouldEncodeElementDefault(r112, 26) == false) goto L243;
    L241:
        boolean r130 = true;
    L246:
        if (r130 == false) goto L249;
        r111.encodeNullableSerializableElement(r112, 26, v2.f520790a, r110.referenceInfo);
    L249:
        if (r111.shouldEncodeElementDefault(r112, 27) == false) goto L252;
    L250:
        boolean r131 = true;
    L255:
        if (r131 == false) goto L258;
        r111.encodeBooleanElement(r112, 27, r110.sourceFromAsr);
    L258:
        if (r111.shouldEncodeElementDefault(r112, 28) == false) goto L261;
    L259:
        boolean r132 = true;
    L264:
        if (r132 == false) goto L267;
        r111.encodeNullableSerializableElement(r112, 28, v2.f520790a, r110.imageDataPath);
    L267:
        if (r111.shouldEncodeElementDefault(r112, 29) == false) goto L270;
    L268:
        boolean r133 = true;
    L273:
        if (r133 == false) goto L276;
        r111.encodeIntElement(r112, 29, r110.imageUploadStatus);
    L276:
        if (r111.shouldEncodeElementDefault(r112, 30) == false) goto L279;
    L277:
        boolean r134 = true;
    L282:
        if (r134 == false) goto L285;
        r111.encodeNullableSerializableElement(r112, 30, v2.f520790a, r110.suggestQuestions);
    L285:
        if (r111.shouldEncodeElementDefault(r112, 31) == false) goto L288;
    L286:
        boolean r135 = true;
    L291:
        if (r135 == false) goto L294;
        r111.encodeIntElement(r112, 31, r110.userType);
    L294:
        if (r111.shouldEncodeElementDefault(r112, 32) == false) goto L297;
    L295:
        boolean r136 = true;
    L300:
        if (r136 == false) goto L303;
        r111.encodeNullableSerializableElement(r112, 32, w0.f520792a, r110.messageBodyVersion);
    L303:
        if (r111.shouldEncodeElementDefault(r112, 33) == false) goto L306;
    L304:
        boolean r137 = true;
    L309:
        if (r137 == false) goto L312;
        r111.encodeNullableSerializableElement(r112, 33, v2.f520790a, r110.tags);
    L312:
        if (r111.shouldEncodeElementDefault(r112, 34) == false) goto L315;
    L313:
        boolean r138 = true;
    L318:
        if (r138 == false) goto L321;
        r111.encodeNullableSerializableElement(r112, 34, v2.f520790a, r110.replyId);
    L321:
        if (r111.shouldEncodeElementDefault(r112, 35) == false) goto L324;
    L322:
        boolean r139 = true;
    L327:
        if (r139 == false) goto L330;
        r111.encodeNullableSerializableElement(r112, 35, v2.f520790a, r110.bizContentType);
    L330:
        if (r111.shouldEncodeElementDefault(r112, 36) == false) goto L333;
    L331:
        boolean r140 = true;
    L336:
        if (r140 == false) goto L339;
        r111.encodeNullableSerializableElement(r112, 36, v2.f520790a, r110.bizExtra);
    L339:
        if (r111.shouldEncodeElementDefault(r112, 37) == false) goto L342;
    L340:
        boolean r141 = true;
    L345:
        if (r141 == false) goto L348;
        r111.encodeNullableSerializableElement(r112, 37, v2.f520790a, r110.subList);
    L348:
        if (r111.shouldEncodeElementDefault(r112, 38) == false) goto L351;
    L349:
        boolean r142 = true;
    L354:
        if (r142 == false) goto L357;
        r111.encodeNullableSerializableElement(r112, 38, v2.f520790a, r110.subListGroup);
    L357:
        if (r111.shouldEncodeElementDefault(r112, 39) == false) goto L360;
    L358:
        boolean r143 = true;
    L363:
        if (r143 == false) goto L366;
        r111.encodeNullableSerializableElement(r112, 39, v2.f520790a, r110.collectionId);
    L366:
        if (r111.shouldEncodeElementDefault(r112, 40) == false) goto L369;
    L367:
        boolean r144 = true;
    L372:
        if (r144 == false) goto L375;
        r111.encodeNullableSerializableElement(r112, 40, g1.f520681a, r110.subMessageIndex);
    L375:
        if (r111.shouldEncodeElementDefault(r112, 41) == false) goto L378;
    L376:
        boolean r145 = true;
    L381:
        if (r145 == false) goto L384;
        r111.encodeNullableSerializableElement(r112, 41, v2.f520790a, r110.referMsgId);
    L384:
        if (r111.shouldEncodeElementDefault(r112, 42) == false) goto L387;
    L385:
        boolean r146 = true;
    L390:
        if (r146 == false) goto L393;
        r111.encodeLongElement(r112, 42, r110.timeGroupId);
    L393:
        if (r111.shouldEncodeElementDefault(r112, 43) == false) goto L396;
    L394:
        r100 = true;
    L398:
        if (r100 == false) goto L401;
        r111.encodeLongElement(r112, 43, r110.audioDuration);
        return;
    L401:
        return;
    L396:
        if (r110.audioDuration == 0) goto L398;
    L387:
        if (r110.timeGroupId != 0) goto L385;
        r146 = false;
        goto L390
    L378:
        if (r110.referMsgId != null) goto L376;
        r145 = false;
        goto L381
    L369:
        if (r110.subMessageIndex != null) goto L367;
        r144 = false;
        goto L372
    L360:
        if (r110.collectionId != null) goto L358;
        r143 = false;
        goto L363
    L351:
        if (r110.subListGroup != null) goto L349;
        r142 = false;
        goto L354
    L342:
        if (r110.subList != null) goto L340;
        r141 = false;
        goto L345
    L333:
        if (r110.bizExtra != null) goto L331;
        r140 = false;
        goto L336
    L324:
        if (r110.bizContentType != null) goto L322;
        r139 = false;
        goto L327
    L315:
        if (r110.replyId != null) goto L313;
        r138 = false;
        goto L318
    L306:
        if (r110.tags != null) goto L304;
        r137 = false;
        goto L309
    L297:
        if (r110.messageBodyVersion != null) goto L295;
        r136 = false;
        goto L300
    L288:
        if (r110.userType != OmniUserType.UNKNOWN.value) goto L286;
        r135 = false;
        goto L291
    L279:
        if (r110.suggestQuestions != null) goto L277;
        r134 = false;
        goto L282
    L270:
        if (r110.imageUploadStatus != 0) goto L268;
        r133 = false;
        goto L273
    L261:
        if (r110.imageDataPath != null) goto L259;
        r132 = false;
        goto L264
    L252:
        if (r110.sourceFromAsr != true) goto L250;
        r131 = false;
        goto L255
    L243:
        if (r110.referenceInfo != null) goto L241;
        r130 = false;
        goto L246
    L234:
        if (r110.localIndex != 0) goto L232;
        r129 = false;
        goto L237
    L221:
        Integer r147 = r110.feedback;
        if (r147 == null) goto L220;
        if (r147.intValue() != 0) goto L220;
        r128 = false;
        goto L228
    L213:
        if (r110.threadId != null) goto L211;
        r127 = false;
        goto L216
    L204:
        if (r110.conversationId != null) goto L202;
        r126 = false;
        goto L207
    L195:
        if (r110.ext != null) goto L193;
        r125 = false;
        goto L198
    L186:
        if (Intrinsics.areEqual(r110.ftsContent, "") == false) goto L184;
        r124 = false;
        goto L189
    L177:
        if (r110.thinkingContent != null) goto L175;
        r123 = false;
        goto L180
    L168:
        if (r110.content != null) goto L166;
        r122 = false;
        goto L171
    L159:
        if (r110.brief != null) goto L157;
        r121 = false;
        goto L162
    L150:
        if (r110.senderId != null) goto L148;
        r120 = false;
        goto L153
    L141:
        if (r110.regenVisible != true) goto L139;
        r119 = false;
        goto L144
    L132:
        if (r110.regenStatus != OmniRegenStatus.REGEN_STATUS_EMPTY.value) goto L130;
        r118 = false;
        goto L135
    L123:
        if (r110.regenIndex != null) goto L121;
        r117 = false;
        goto L126
    L114:
        if (r110.regenRootId != null) goto L112;
        r116 = false;
        goto L117
    L105:
        if (r110.regenMessageList != null) goto L103;
        r115 = false;
        goto L108
    L96:
        if (r110.messageStatus != OmniMessageStatus.MessageStatus_AVAILABLE.value) goto L94;
        r114 = false;
        goto L99
    L87:
        if (r110.status != OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_SENDING.value) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r110.isNewBlockType == true) goto L76;
        r109 = false;
        goto L81
    L69:
        if (r110.beforeContentType != OmniMessageContentType.UNSPECIFIED.value) goto L67;
        r108 = false;
        goto L72
    L60:
        if (r110.contentType != OmniMessageContentType.TXT.value) goto L58;
        r107 = false;
        goto L63
    L51:
        if (r110.createTime != (com.larus.im.internal.delegate.c.f348197a.currentTimeMillis() / ((long) 1000))) goto L49;
        r106 = false;
        goto L54
    L42:
        if (r110.serverIndex != null) goto L40;
        r105 = false;
        goto L45
    L33:
        if (r110.sectionName != null) goto L31;
        r104 = false;
        goto L36
    L24:
        if (r110.sectionId != null) goto L22;
        r103 = false;
        goto L27
    L15:
        if (r110.messageId != null) goto L13;
        r102 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r110.localMessageId, "") == false) goto L4;
        r101 = false;
        goto L9
    }

    public MessageEntity(String r100, String r101, String r102, String r103, Long r104, long r105, int r110, int r111, boolean r112, int r113, int r114, String r115, String r116, Integer r117, int r118, boolean r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, Integer r219, long r310, String r311, boolean r312, String r313, int r314, String r315, int r316, Integer r317, String r318, String r410, String r411, String r412, String r413, String r414, String r415, Long r416, String r417, long r418, long r510) {
        Intrinsics.checkNotNullParameter(r100, "localMessageId");
        this.localMessageId = r100;
        this.messageId = r101;
        this.sectionId = r102;
        this.sectionName = r103;
        this.serverIndex = r104;
        this.createTime = r105;
        this.contentType = r110;
        this.beforeContentType = r111;
        this.isNewBlockType = r112;
        this.status = r113;
        this.messageStatus = r114;
        this.regenMessageList = r115;
        this.regenRootId = r116;
        this.regenIndex = r117;
        this.regenStatus = r118;
        this.regenVisible = r210;
        this.senderId = r211;
        this.brief = r212;
        this.content = r213;
        this.thinkingContent = r214;
        this.ftsContent = r215;
        this.ext = r216;
        this.conversationId = r217;
        this.threadId = r218;
        this.feedback = r219;
        this.localIndex = r310;
        this.referenceInfo = r311;
        this.sourceFromAsr = r312;
        this.imageDataPath = r313;
        this.imageUploadStatus = r314;
        this.suggestQuestions = r315;
        this.userType = r316;
        this.messageBodyVersion = r317;
        this.tags = r318;
        this.replyId = r410;
        this.bizContentType = r411;
        this.bizExtra = r412;
        this.subList = r413;
        this.subListGroup = r414;
        this.collectionId = r415;
        this.subMessageIndex = r416;
        this.referMsgId = r417;
        this.timeGroupId = r418;
        this.audioDuration = r510;
    }

    public MessageEntity(int r110, int r111, String r112, String r113, String r114, String r115, Long r116, long r210, int r211, int r212, boolean r213, int r214, int r215, String r216, String r217, Integer r218, int r310, boolean r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, Integer r410, long r411, String r412, boolean r413, String r414, int r415, String r416, int r417, Integer r418, String r510, String r511, String r512, String r513, String r514, String r515, String r516, Long r517, String r518, long r519, long r610, q2 r611) {
        if ((r110 & 0) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r111 & 0) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r100 | r101) == false) goto L13;
        b2.a(new int[]{r110, r111}, new int[]{0, 0}, a.f348118b);
        throw null;
    L13:
        if ((r110 & 1) != 0) goto L15;
        this.localMessageId = "";
    L17:
        if ((r110 & 2) != 0) goto L19;
        this.messageId = null;
    L21:
        if ((r110 & 4) != 0) goto L23;
        this.sectionId = null;
    L25:
        if ((r110 & 8) != 0) goto L27;
        this.sectionName = null;
    L29:
        if ((r110 & 16) != 0) goto L31;
        this.serverIndex = null;
    L33:
        if ((r110 & 32) != 0) goto L35;
        long r102 = com.larus.im.internal.delegate.c.f348197a.currentTimeMillis() / ((long) 1000);
    L36:
        this.createTime = r102;
        if ((r110 & 64) != 0) goto L39;
        int r103 = OmniMessageContentType.TXT.value;
    L40:
        this.contentType = r103;
        if ((r110 & 128) != 0) goto L43;
        int r104 = OmniMessageContentType.UNSPECIFIED.value;
    L44:
        this.beforeContentType = r104;
        if ((r110 & 256) != 0) goto L47;
        this.isNewBlockType = false;
    L49:
        if ((r110 & 512) != 0) goto L51;
        int r105 = OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_SENDING.value;
    L52:
        this.status = r105;
        if ((r110 & 1024) != 0) goto L55;
        int r106 = OmniMessageStatus.MessageStatus_AVAILABLE.value;
    L56:
        this.messageStatus = r106;
        if ((r110 & 2048) != 0) goto L59;
        this.regenMessageList = null;
    L61:
        if ((r110 & 4096) != 0) goto L63;
        this.regenRootId = null;
    L65:
        if ((r110 & 8192) != 0) goto L67;
        this.regenIndex = null;
    L69:
        if ((r110 & 16384) != 0) goto L71;
        int r107 = OmniRegenStatus.REGEN_STATUS_EMPTY.value;
    L72:
        this.regenStatus = r107;
        if ((32768 & r110) != 0) goto L75;
        this.regenVisible = true;
    L77:
        if ((65536 & r110) != 0) goto L79;
        this.senderId = null;
    L81:
        if ((131072 & r110) != 0) goto L83;
        this.brief = null;
    L85:
        if ((262144 & r110) != 0) goto L87;
        this.content = null;
    L89:
        if ((524288 & r110) != 0) goto L91;
        this.thinkingContent = null;
    L93:
        if ((1048576 & r110) != 0) goto L95;
        this.ftsContent = "";
    L97:
        if ((2097152 & r110) != 0) goto L99;
        this.ext = null;
    L101:
        if ((4194304 & r110) != 0) goto L103;
        this.conversationId = null;
    L105:
        if ((8388608 & r110) != 0) goto L107;
        this.threadId = null;
    L109:
        if ((16777216 & r110) != 0) goto L111;
        Integer r108 = 0;
    L112:
        this.feedback = r108;
        if ((33554432 & r110) != 0) goto L115;
        this.localIndex = 0;
    L117:
        if ((67108864 & r110) != 0) goto L119;
        this.referenceInfo = null;
    L121:
        if ((134217728 & r110) != 0) goto L123;
        this.sourceFromAsr = true;
    L125:
        if ((268435456 & r110) != 0) goto L127;
        this.imageDataPath = null;
    L129:
        if ((536870912 & r110) != 0) goto L131;
        this.imageUploadStatus = 0;
    L133:
        if ((1073741824 & r110) != 0) goto L135;
        this.suggestQuestions = null;
    L137:
        if ((r110 & Integer.MIN_VALUE) != 0) goto L139;
        int r109 = OmniUserType.UNKNOWN.value;
    L140:
        this.userType = r109;
        if ((r111 & 1) != 0) goto L143;
        this.messageBodyVersion = null;
    L145:
        if ((r111 & 2) != 0) goto L147;
        this.tags = null;
    L149:
        if ((r111 & 4) != 0) goto L151;
        this.replyId = null;
    L153:
        if ((r111 & 8) != 0) goto L155;
        this.bizContentType = null;
    L157:
        if ((r111 & 16) != 0) goto L159;
        this.bizExtra = null;
    L161:
        if ((r111 & 32) != 0) goto L163;
        this.subList = null;
    L165:
        if ((r111 & 64) != 0) goto L167;
        this.subListGroup = null;
    L169:
        if ((r111 & 128) != 0) goto L171;
        this.collectionId = null;
    L173:
        if ((r111 & 256) != 0) goto L175;
        this.subMessageIndex = null;
    L177:
        if ((r111 & 512) != 0) goto L179;
        this.referMsgId = null;
    L181:
        if ((r111 & 1024) != 0) goto L183;
        this.timeGroupId = 0;
    L185:
        if ((r111 & 2048) != 0) goto L187;
        this.audioDuration = 0;
        return;
    L187:
        this.audioDuration = r610;
        return;
    L183:
        this.timeGroupId = r519;
        goto L185
    L179:
        this.referMsgId = r518;
        goto L181
    L175:
        this.subMessageIndex = r517;
        goto L177
    L171:
        this.collectionId = r516;
        goto L173
    L167:
        this.subListGroup = r515;
        goto L169
    L163:
        this.subList = r514;
        goto L165
    L159:
        this.bizExtra = r513;
        goto L161
    L155:
        this.bizContentType = r512;
        goto L157
    L151:
        this.replyId = r511;
        goto L153
    L147:
        this.tags = r510;
        goto L149
    L143:
        this.messageBodyVersion = r418;
        goto L145
    L139:
        r109 = r417;
        goto L140
    L135:
        this.suggestQuestions = r416;
        goto L137
    L131:
        this.imageUploadStatus = r415;
        goto L133
    L127:
        this.imageDataPath = r414;
        goto L129
    L123:
        this.sourceFromAsr = r413;
        goto L125
    L119:
        this.referenceInfo = r412;
        goto L121
    L115:
        this.localIndex = r411;
        goto L117
    L111:
        r108 = r410;
        goto L112
    L107:
        this.threadId = r319;
        goto L109
    L103:
        this.conversationId = r318;
        goto L105
    L99:
        this.ext = r317;
        goto L101
    L95:
        this.ftsContent = r316;
        goto L97
    L91:
        this.thinkingContent = r315;
        goto L93
    L87:
        this.content = r314;
        goto L89
    L83:
        this.brief = r313;
        goto L85
    L79:
        this.senderId = r312;
        goto L81
    L75:
        this.regenVisible = r311;
        goto L77
    L71:
        r107 = r310;
        goto L72
    L67:
        this.regenIndex = r218;
        goto L69
    L63:
        this.regenRootId = r217;
        goto L65
    L59:
        this.regenMessageList = r216;
        goto L61
    L55:
        r106 = r215;
        goto L56
    L51:
        r105 = r214;
        goto L52
    L47:
        this.isNewBlockType = r213;
        goto L49
    L43:
        r104 = r212;
        goto L44
    L39:
        r103 = r211;
        goto L40
    L35:
        r102 = r210;
        goto L36
    L31:
        this.serverIndex = r116;
        goto L33
    L27:
        this.sectionName = r115;
        goto L29
    L23:
        this.sectionId = r114;
        goto L25
    L19:
        this.messageId = r113;
        goto L21
    L15:
        this.localMessageId = r112;
        goto L17
    L9:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public /* synthetic */ MessageEntity(String r410, String r510, String r511, String r512, Long r513, long r514, int r515, int r516, boolean r517, int r518, int r610, String r611, String r612, Integer r613, int r614, boolean r615, String r616, String r617, String r618, String r619, String r710, String r711, String r712, String r713, Integer r714, long r715, String r716, boolean r717, String r718, int r810, String r811, int r812, Integer r813, String r814, String r815, String r816, String r817, String r818, String r819, String r910, Long r911, String r912, long r913, long r914, int r915, int r916, DefaultConstructorMarker r917) {
        if ((r915 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r915 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r915 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r915 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r915 & 16) == 0) goto L21;
        Long r104 = null;
    L23:
        if ((r915 & 32) == 0) goto L25;
        long r105 = com.larus.im.internal.delegate.c.f348197a.currentTimeMillis() / ((long) 1000);
    L27:
        if ((r915 & 64) == 0) goto L29;
        int r110 = OmniMessageContentType.TXT.value;
    L31:
        if ((r915 & 128) == 0) goto L33;
        int r111 = OmniMessageContentType.UNSPECIFIED.value;
    L35:
        if ((r915 & 256) == 0) goto L37;
        boolean r112 = false;
    L39:
        if ((r915 & 512) == 0) goto L41;
        int r113 = OmniMessageStatusLocal.MESSAGE_STATUS_LOCAL_SENDING.value;
    L43:
        if ((r915 & 1024) == 0) goto L45;
        int r106 = OmniMessageStatus.MessageStatus_AVAILABLE.value;
    L47:
        if ((r915 & 2048) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r915 & 4096) == 0) goto L53;
        String r107 = null;
    L54:
        String r115 = r107;
        if ((r915 & 8192) == 0) goto L57;
        Integer r108 = null;
    L58:
        Integer r116 = r108;
        if ((r915 & 16384) == 0) goto L61;
        int r109 = OmniRegenStatus.REGEN_STATUS_EMPTY.value;
    L62:
        boolean r117 = true;
        if ((r915 & 32768) == 0) goto L65;
        boolean r118 = true;
    L67:
        if ((r915 & 65536) == 0) goto L69;
        String r210 = null;
    L71:
        if ((r915 & 131072) == 0) goto L73;
        String r211 = null;
    L75:
        if ((r915 & 262144) == 0) goto L77;
        String r212 = null;
    L79:
        if ((r915 & 524288) == 0) goto L81;
        String r213 = null;
    L83:
        if ((r915 & 1048576) == 0) goto L85;
        String r214 = "";
    L87:
        if ((r915 & 2097152) == 0) goto L89;
        String r215 = null;
    L91:
        if ((r915 & 4194304) == 0) goto L93;
        String r216 = null;
    L95:
        if ((r915 & 8388608) == 0) goto L97;
        String r217 = null;
    L99:
        if ((r915 & 16777216) == 0) goto L101;
        int r218 = 0;
        Integer r219 = 0;
    L102:
        long r310 = 0;
        if ((r915 & 33554432) == 0) goto L105;
        long r311 = 0;
    L107:
        if ((r915 & 67108864) == 0) goto L109;
        String r312 = null;
    L111:
        if ((r915 & AMapEngineUtils.HALF_MAX_P20_WIDTH) != 0) goto L115;
        r117 = r717;
    L115:
        if ((r915 & 268435456) == 0) goto L117;
        String r313 = null;
    L119:
        if ((r915 & 536870912) != 0) goto L123;
        r218 = r810;
    L123:
        if ((r915 & 1073741824) == 0) goto L125;
        String r314 = null;
    L127:
        if ((r915 & Integer.MIN_VALUE) == 0) goto L129;
        int r119 = OmniUserType.UNKNOWN.value;
    L131:
        if ((r916 & 1) == 0) goto L133;
        Integer r315 = null;
    L135:
        if ((r916 & 2) == 0) goto L137;
        String r316 = null;
    L139:
        if ((r916 & 4) == 0) goto L141;
        String r317 = null;
    L143:
        if ((r916 & 8) == 0) goto L145;
        String r411 = null;
    L147:
        if ((r916 & 16) == 0) goto L149;
        String r412 = null;
    L151:
        if ((r916 & 32) == 0) goto L153;
        String r413 = null;
    L155:
        if ((r916 & 64) == 0) goto L157;
        String r414 = null;
    L158:
        int r918 = r119;
        if ((r916 & 128) == 0) goto L161;
        String r120 = null;
    L162:
        String r919 = r120;
        if ((r916 & 256) == 0) goto L165;
        Long r121 = null;
    L166:
        Long r415 = r121;
        if ((r916 & 512) == 0) goto L169;
        String r122 = null;
    L170:
        String r416 = r122;
        if ((r916 & 1024) == 0) goto L173;
        long r417 = 0;
    L175:
        if ((r916 & 2048) != 0) goto L178;
        r310 = r914;
    L178:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r114, r115, r116, r109, r118, r210, r211, r212, r213, r214, r215, r216, r217, r219, r311, r312, r117, r313, r218, r314, r918, r315, r316, r317, r411, r412, r413, r414, r919, r415, r416, r417, r310);
        return;
    L173:
        r417 = r913;
        goto L175
    L169:
        r122 = r912;
        goto L170
    L165:
        r121 = r911;
        goto L166
    L161:
        r120 = r910;
        goto L162
    L157:
        r414 = r819;
        goto L158
    L153:
        r413 = r818;
        goto L155
    L149:
        r412 = r817;
        goto L151
    L145:
        r411 = r816;
        goto L147
    L141:
        r317 = r815;
        goto L143
    L137:
        r316 = r814;
        goto L139
    L133:
        r315 = r813;
        goto L135
    L129:
        r119 = r812;
        goto L131
    L125:
        r314 = r811;
        goto L127
    L117:
        r313 = r718;
        goto L119
    L109:
        r312 = r716;
        goto L111
    L105:
        r311 = r715;
        goto L107
    L101:
        r218 = 0;
        r219 = r714;
        goto L102
    L97:
        r217 = r713;
        goto L99
    L93:
        r216 = r712;
        goto L95
    L89:
        r215 = r711;
        goto L91
    L85:
        r214 = r710;
        goto L87
    L81:
        r213 = r619;
        goto L83
    L77:
        r212 = r618;
        goto L79
    L73:
        r211 = r617;
        goto L75
    L69:
        r210 = r616;
        goto L71
    L65:
        r118 = r615;
        goto L67
    L61:
        r109 = r614;
        goto L62
    L57:
        r108 = r613;
        goto L58
    L53:
        r107 = r612;
        goto L54
    L49:
        r114 = r611;
        goto L51
    L45:
        r106 = r610;
        goto L47
    L41:
        r113 = r518;
        goto L43
    L37:
        r112 = r517;
        goto L39
    L33:
        r111 = r516;
        goto L35
    L29:
        r110 = r515;
        goto L31
    L25:
        r105 = r514;
        goto L27
    L21:
        r104 = r513;
        goto L23
    L17:
        r103 = r512;
        goto L19
    L13:
        r102 = r511;
        goto L15
    L9:
        r101 = r510;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }
}
