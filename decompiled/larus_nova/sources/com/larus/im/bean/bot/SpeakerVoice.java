package com.larus.im.bean.bot;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.disk.api.CacheHandlerBusiness;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.texturerender.TextureRenderKeys;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
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
import nuc.l0;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;
import uc9.c0;
import uc9.d0;
import uc9.e0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0003\b\u0082\u0001\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ¾\u00012\u00060\u0001j\u0002`\u0002:\u0004½\u0001¾\u0001Bõ\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0013\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0016\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b\u0012\b\b\u0002\u0010 \u001a\u00020\u0013\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001b\u0012\b\b\u0002\u0010#\u001a\u00020\u0013\u0012\b\b\u0002\u0010$\u001a\u00020\u0013\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\u0016\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b,\u0010-BË\u0002\b\u0010\u0012\u0006\u0010.\u001a\u00020\u0013\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0013\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0016\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b\u0012\u0006\u0010 \u001a\u00020\u0013\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001b\u0012\u0006\u0010#\u001a\u00020\u0013\u0012\u0006\u0010$\u001a\u00020\u0013\u0012\u0006\u0010%\u001a\u00020&\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010)\u001a\u00020\u0016\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010/\u001a\u0004\u0018\u000100¢\u0006\u0004\b,\u00101J\t\u0010\u0090\u0001\u001a\u00020\u0004H\u0016J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0013HÆ\u0003J\u0012\u0010¢\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001bHÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0016HÆ\u0003J\u0012\u0010¥\u0001\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bHÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0013HÆ\u0003J\u0012\u0010§\u0001\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001bHÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010ª\u0001\u001a\u00020&HÆ\u0003J\n\u0010«\u0001\u001a\u00020&HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u00ad\u0001\u001a\u00020\u0016HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jø\u0002\u0010°\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00132\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00162\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020\u00132\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001b2\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010)\u001a\u00020\u00162\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0016\u0010±\u0001\u001a\u00020\u00162\n\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001HÖ\u0003J\n\u0010´\u0001\u001a\u00020\u0013HÖ\u0001J-\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010·\u0001\u001a\u00020\u00002\b\u0010¸\u0001\u001a\u00030¹\u00012\b\u0010º\u0001\u001a\u00030»\u0001H\u0001¢\u0006\u0003\b¼\u0001R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R&\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u00103\u001a\u0004\b<\u00105\"\u0004\b=\u00107R&\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b>\u00103\u001a\u0004\b?\u00105\"\u0004\b@\u00107R&\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bA\u00103\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER&\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bF\u00103\u001a\u0004\bG\u00105\"\u0004\bH\u00107R&\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bI\u00103\u001a\u0004\bJ\u00105\"\u0004\bK\u00107R&\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bL\u00103\u001a\u0004\bM\u00105\"\u0004\bN\u00107R&\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bO\u00103\u001a\u0004\bP\u00105\"\u0004\bQ\u00107R&\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bR\u00103\u001a\u0004\bS\u00105\"\u0004\bT\u00107R&\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bU\u00103\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR&\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bZ\u00103\u001a\u0004\b[\u00105\"\u0004\b\\\u00107R$\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b]\u00103\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bb\u00103\u001a\u0004\bc\u0010_\"\u0004\bd\u0010aR$\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\be\u00103\u001a\u0004\b\u0015\u0010f\"\u0004\bg\u0010hR\u001c\u0010\u0017\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bi\u00103\u001a\u0004\bj\u0010kR$\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bl\u00103\u001a\u0004\bm\u0010_\"\u0004\bn\u0010aR,\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bo\u00103\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bt\u00103\u001a\u0004\bu\u00105R$\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bv\u00103\u001a\u0004\bw\u0010f\"\u0004\bx\u0010hR$\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\by\u00103\u001a\u0004\bz\u0010qR\u001c\u0010 \u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b{\u00103\u001a\u0004\b|\u0010_R$\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b}\u00103\u001a\u0004\b~\u0010qR\u001d\u0010#\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000f\n\u0000\u0012\u0004\b\u007f\u00103\u001a\u0005\b\u0080\u0001\u0010_R\u001e\u0010$\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0081\u0001\u00103\u001a\u0005\b\u0082\u0001\u0010_R\u001f\u0010%\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u0083\u0001\u00103\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001f\u0010'\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u0086\u0001\u00103\u001a\u0006\b\u0087\u0001\u0010\u0085\u0001R \u0010(\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0088\u0001\u00103\u001a\u0005\b\u0089\u0001\u00105R\u001e\u0010)\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u008a\u0001\u00103\u001a\u0005\b\u008b\u0001\u0010fR \u0010*\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u008c\u0001\u00103\u001a\u0005\b\u008d\u0001\u00105R \u0010+\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u008e\u0001\u00103\u001a\u0005\b\u008f\u0001\u00105¨\u0006¿\u0001"}, d2 = {"Lcom/larus/im/bean/bot/SpeakerVoice;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "id", "", "modelName", "name", "creatorUserName", "icon", "Lcom/larus/im/bean/bot/IconItem;", "language", "styleId", "styleName", UserInfo.LANGUAGECODE, "languageKey", "preview", "Lcom/larus/im/bean/bot/AudioPreview;", "creatorId", "status", "", "privateStatus", "isUgcVoice", "", "createTime", "", "nameStatus", "exclusiveBotIds", "", "displayHeatScore", "bestMatch", "tagList", "Lcom/larus/im/bean/bot/VoiceTag;", "confStatus", "mixVoiceList", "Lcom/larus/im/bean/bot/MixVoice;", TextureRenderKeys.KEY_IS_PITCH, "speechRate", "pitchF64", "", "speechRateF64", "extra", "allowMix", "audioMetrics", "callStyleId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/IconItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/AudioPreview;Ljava/lang/String;IIZJILjava/util/List;Ljava/lang/String;ZLjava/util/List;ILjava/util/List;IIFFLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/IconItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/AudioPreview;Ljava/lang/String;IIZJILjava/util/List;Ljava/lang/String;ZLjava/util/List;ILjava/util/List;IIFFLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getModelName$annotations", "getModelName", "setModelName", "getName$annotations", "getName", "setName", "getCreatorUserName$annotations", "getCreatorUserName", "setCreatorUserName", "getIcon$annotations", "getIcon", "()Lcom/larus/im/bean/bot/IconItem;", "setIcon", "(Lcom/larus/im/bean/bot/IconItem;)V", "getLanguage$annotations", "getLanguage", "setLanguage", "getStyleId$annotations", "getStyleId", "setStyleId", "getStyleName$annotations", "getStyleName", "setStyleName", "getLanguageCode$annotations", "getLanguageCode", "setLanguageCode", "getLanguageKey$annotations", "getLanguageKey", "setLanguageKey", "getPreview$annotations", "getPreview", "()Lcom/larus/im/bean/bot/AudioPreview;", "setPreview", "(Lcom/larus/im/bean/bot/AudioPreview;)V", "getCreatorId$annotations", "getCreatorId", "setCreatorId", "getStatus$annotations", "getStatus", "()I", "setStatus", "(I)V", "getPrivateStatus$annotations", "getPrivateStatus", "setPrivateStatus", "isUgcVoice$annotations", "()Z", "setUgcVoice", "(Z)V", "getCreateTime$annotations", "getCreateTime", "()J", "getNameStatus$annotations", "getNameStatus", "setNameStatus", "getExclusiveBotIds$annotations", "getExclusiveBotIds", "()Ljava/util/List;", "setExclusiveBotIds", "(Ljava/util/List;)V", "getDisplayHeatScore$annotations", "getDisplayHeatScore", "getBestMatch$annotations", "getBestMatch", "setBestMatch", "getTagList$annotations", "getTagList", "getConfStatus$annotations", "getConfStatus", "getMixVoiceList$annotations", "getMixVoiceList", "getPitch$annotations", "getPitch", "getSpeechRate$annotations", "getSpeechRate", "getPitchF64$annotations", "getPitchF64", "()F", "getSpeechRateF64$annotations", "getSpeechRateF64", "getExtra$annotations", "getExtra", "getAllowMix$annotations", "getAllowMix", "getAudioMetrics$annotations", "getAudioMetrics", "getCallStyleId$annotations", "getCallStyleId", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "copy", "equals", "other", "", "hashCode", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class SpeakerVoice implements java.io.Serializable {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f346502a = null;
    private final boolean allowMix;
    private final String audioMetrics;
    private boolean bestMatch;
    private final String callStyleId;
    private final int confStatus;
    private final long createTime;
    private String creatorId;
    private String creatorUserName;
    private final String displayHeatScore;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<Long> exclusiveBotIds;
    private final String extra;
    private IconItem icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f346503id;
    private boolean isUgcVoice;
    private String language;
    private String languageCode;
    private String languageKey;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<MixVoice> mixVoiceList;
    private String modelName;
    private String name;
    private int nameStatus;
    private final int pitch;
    private final float pitchF64;
    private AudioPreview preview;
    private int privateStatus;
    private final int speechRate;
    private final float speechRateF64;
    private int status;
    private String styleId;
    private String styleName;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<VoiceTag> tagList;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<SpeakerVoice> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346504a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346505b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346505b;
        }

        static {
            a r100 = new a();
            f346504a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.SpeakerVoice", r100, 31);
            r101.j("id", true);
            r101.j("model_name", true);
            r101.j("name", true);
            r101.j("creator_username", true);
            r101.j("icon", true);
            r101.j("language", true);
            r101.j("style_id", true);
            r101.j("style_name", true);
            r101.j("language_code", true);
            r101.j("language_key", true);
            r101.j("preview", true);
            r101.j("creator_id", true);
            r101.j("status", true);
            r101.j("private_status", true);
            r101.j(CacheHandlerBusiness.UGC_VOICE, true);
            r101.j("create_time", true);
            r101.j("name_status", true);
            r101.j("exclusive_bot_ids", true);
            r101.j("display_heat_score", true);
            r101.j("is_best_match", true);
            r101.j("tag_list", true);
            r101.j("voice_conf_status", true);
            r101.j("mix_voice_list", true);
            r101.j(TextureRenderKeys.KEY_IS_PITCH, true);
            r101.j("speech_rate", true);
            r101.j("pitch_f64", true);
            r101.j("speech_rate_f64", true);
            r101.j("extra", true);
            r101.j("allow_mix", true);
            r101.j("audio_metrics", true);
            r101.j("style_id_phone_call", true);
            f346505b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = SpeakerVoice.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            w0 r102 = w0.f520792a;
            i r103 = i.f520705a;
            l0 r104 = l0.f520731a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(IconItem.a.f346476a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(AudioPreview.a.f346420a), kuc.a.d(r101), r102, r102, r103, g1.f520681a, r102, kuc.a.d((d) r100[17].getValue()), kuc.a.d(r101), r103, kuc.a.d((d) r100[20].getValue()), r102, kuc.a.d((d) r100[22].getValue()), r102, r102, r104, r104, kuc.a.d(r101), r103, kuc.a.d(r101), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r510) {
            Intrinsics.checkNotNullParameter(r510, "decoder");
            g2 r100 = f346505b;
            c r101 = r510.beginStructure(r100);
            Lazy[] r102 = SpeakerVoice.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
            IconItem r105 = (IconItem) r101.decodeNullableSerializableElement(r100, 4, IconItem.a.f346476a, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 5, r103, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 6, r103, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 7, r103, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 8, r103, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 9, r103, null);
            AudioPreview r114 = (AudioPreview) r101.decodeNullableSerializableElement(r100, 10, AudioPreview.a.f346420a, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 11, r103, null);
            int r116 = r101.decodeIntElement(r100, 12);
            int r117 = r101.decodeIntElement(r100, 13);
            boolean r118 = r101.decodeBooleanElement(r100, 14);
            long r210 = r101.decodeLongElement(r100, 15);
            int r119 = r101.decodeIntElement(r100, 16);
            List r120 = (List) r101.decodeNullableSerializableElement(r100, 17, (juc.c) r102[17].getValue(), null);
            String r121 = (String) r101.decodeNullableSerializableElement(r100, 18, r103, null);
            boolean r122 = r101.decodeBooleanElement(r100, 19);
            List r123 = (List) r101.decodeNullableSerializableElement(r100, 20, (juc.c) r102[20].getValue(), null);
            int r124 = r101.decodeIntElement(r100, 21);
            List r125 = (List) r101.decodeNullableSerializableElement(r100, 22, (juc.c) r102[22].getValue(), null);
            int r126 = r101.decodeIntElement(r100, 23);
            int r127 = r101.decodeIntElement(r100, 24);
            float r128 = r101.decodeFloatElement(r100, 25);
            float r129 = r101.decodeFloatElement(r100, 26);
            String r130 = (String) r101.decodeNullableSerializableElement(r100, 27, r103, null);
            boolean r131 = r101.decodeBooleanElement(r100, 28);
            String r132 = (String) r101.decodeNullableSerializableElement(r100, 29, r103, null);
            List r310 = r120;
            String r410 = (String) r101.decodeNullableSerializableElement(r100, 30, r103, null);
            List r311 = r123;
            int r411 = r124;
            int r412 = r126;
            boolean r312 = r122;
            int r413 = r127;
            boolean r414 = r131;
            int r313 = r119;
            String r415 = r132;
            String r314 = r121;
            List r416 = r125;
            float r417 = r128;
            float r418 = r129;
            String r419 = r130;
            String r211 = r109;
            String r212 = r108;
            int r315 = r116;
            String r213 = r115;
            String r133 = r110;
            int r316 = r117;
            String r214 = r112;
            int r134 = Integer.MAX_VALUE;
            boolean r317 = r118;
            String r215 = r111;
            AudioPreview r216 = r114;
            IconItem r217 = r105;
            long r318 = r210;
            String r218 = r106;
            String r219 = r113;
            String r220 = r107;
            String r135 = r104;
        L66:
            r101.endStructure(r100);
            return new SpeakerVoice(r134, r133, r135, r215, r214, r217, r219, r218, r220, r212, r211, r216, r213, r315, r316, r317, r318, r313, r310, r314, r312, r311, r411, r416, r412, r413, r417, r418, r419, r414, r415, r410, null);
        L5:
            List r136 = null;
            List r137 = null;
            String r138 = null;
            String r139 = null;
            AudioPreview r140 = null;
            String r141 = null;
            String r142 = null;
            String r143 = null;
            String r144 = null;
            String r145 = null;
            List r146 = null;
            String r147 = null;
            String r319 = null;
            String r320 = null;
            String r321 = null;
            String r420 = null;
            String r421 = null;
            IconItem r422 = null;
            String r423 = null;
            long r511 = 0;
            int r148 = 0;
            int r221 = 0;
            boolean r222 = false;
            int r223 = 0;
            int r224 = 0;
            int r225 = 0;
            int r424 = 0;
            r418 = 0.0f;
            float r425 = 0.0f;
            boolean r512 = false;
            int r513 = 0;
            boolean r514 = false;
            boolean r515 = true;
        L6:
            if (r515 == false) goto L65;
            String r516 = r147;
            int r149 = r101.decodeElementIndex(r100);
            switch(r149) {
                case -1: goto L63;
                case 0: goto L62;
                case 1: goto L59;
                case 2: goto L56;
                case 3: goto L54;
                case 4: goto L53;
                case 5: goto L51;
                case 6: goto L50;
                case 7: goto L49;
                case 8: goto L48;
                case 9: goto L46;
                case 10: goto L43;
                case 11: goto L42;
                case 12: goto L40;
                case 13: goto L38;
                case 14: goto L36;
                case 15: goto L34;
                case 16: goto L33;
                case 17: goto L29;
                case 18: goto L27;
                case 19: goto L25;
                case 20: goto L24;
                case 21: goto L22;
                case 22: goto L21;
                case 23: goto L20;
                case 24: goto L19;
                case 25: goto L17;
                case 26: goto L16;
                case 27: goto L15;
                case 28: goto L14;
                case 29: goto L13;
                case 30: goto L11;
                default: goto L10;
            };
        L11:
            r143 = (String) r101.decodeNullableSerializableElement(r100, 30, v2.f520790a, r143);
            int r150 = 1073741824 | r148;
            Unit r151 = Unit.INSTANCE;
            int r152 = r150;
        L12:
            float r153 = r418;
        L32:
            r102 = r102;
            int r322 = r224;
            int r323 = r225;
            String r324 = r321;
            r421 = r421;
            String r325 = r423;
            r516 = r516;
            boolean r226 = r222;
            int r227 = r223;
            int r228 = r152;
            int r229 = r221;
            String r154 = r145;
            List r230 = r146;
            String r155 = r144;
            String r156 = r143;
            String r157 = r142;
            String r158 = r141;
            List r159 = r136;
            AudioPreview r160 = r140;
            String r161 = r139;
            String r162 = r138;
            IconItem r163 = r422;
        L61:
            r418 = r153;
            r144 = r155;
            r146 = r230;
            r221 = r229;
            r223 = r227;
            r225 = r323;
            String r326 = r320;
            String r426 = r420;
            List r427 = r137;
            IconItem r327 = r163;
            r138 = r162;
            r139 = r161;
            r140 = r160;
            r136 = r159;
            r141 = r158;
            r142 = r157;
            r143 = r156;
            r145 = r154;
            r148 = r228;
            r222 = r226;
            r224 = r322;
            String r328 = r324;
        L64:
            r102 = r102;
            r320 = r326;
            r321 = r328;
            r421 = r421;
            r422 = r327;
            r423 = r325;
            r147 = r516;
            r137 = r427;
            r420 = r426;
            goto L6
        L13:
            r145 = (String) r101.decodeNullableSerializableElement(r100, 29, v2.f520790a, r145);
            int r164 = 536870912;
        L28:
            r152 = r148 | r164;
            Unit r165 = Unit.INSTANCE;
        L31:
            r153 = r418;
            goto L32
        L14:
            r514 = r101.decodeBooleanElement(r100, 28);
            r164 = 268435456;
            goto L28
        L15:
            r141 = (String) r101.decodeNullableSerializableElement(r100, 27, v2.f520790a, r141);
            r164 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
            goto L28
        L16:
            r144 = r144;
            r153 = r101.decodeFloatElement(r100, 26);
            r152 = r148 | 67108864;
            Unit r166 = Unit.INSTANCE;
            goto L32
        L17:
            float r167 = r101.decodeFloatElement(r100, 25);
            r152 = r148 | 33554432;
            Unit r168 = Unit.INSTANCE;
            r425 = r167;
            goto L12
        L19:
            r513 = r101.decodeIntElement(r100, 24);
            r164 = 16777216;
            goto L28
        L20:
            r225 = r101.decodeIntElement(r100, 23);
            r164 = 8388608;
            goto L28
        L21:
            r136 = (List) r101.decodeNullableSerializableElement(r100, 22, (juc.c) r102[22].getValue(), r136);
            int r169 = 4194304;
        L30:
            int r170 = r169 | r148;
            Unit r171 = Unit.INSTANCE;
            r152 = r170;
            goto L31
        L22:
            r224 = r101.decodeIntElement(r100, 21);
            r169 = 2097152;
            goto L30
        L24:
            r137 = (List) r101.decodeNullableSerializableElement(r100, 20, (juc.c) r102[20].getValue(), r137);
            r164 = 1048576;
            goto L28
        L25:
            r512 = r101.decodeBooleanElement(r100, 19);
            r164 = 524288;
            goto L28
        L27:
            r144 = r144;
            r142 = (String) r101.decodeNullableSerializableElement(r100, 18, v2.f520790a, r142);
            r164 = 262144;
            goto L28
        L29:
            r144 = r144;
            r146 = (List) r101.decodeNullableSerializableElement(r100, 17, (juc.c) r102[17].getValue(), r146);
            r169 = 131072;
            goto L30
        L33:
            r223 = r101.decodeIntElement(r100, 16);
            int r172 = 65536;
        L35:
            int r173 = r148 | r172;
        L39:
            Unit r174 = Unit.INSTANCE;
        L41:
            r102 = r102;
        L47:
            r420 = r420;
            r325 = r423;
            r516 = r516;
            String r175 = r144;
        L58:
            IconItem r176 = r422;
            String r329 = r321;
        L60:
            r323 = r225;
            r324 = r329;
            r227 = r223;
            r322 = r224;
            r229 = r221;
            r226 = r222;
            r230 = r146;
            r228 = r173;
            r155 = r175;
            r154 = r145;
            r153 = r418;
            r156 = r143;
            r157 = r142;
            r158 = r141;
            r159 = r136;
            r160 = r140;
            r161 = r139;
            r162 = r138;
            r163 = r176;
            r137 = r137;
            r420 = r420;
            goto L61
        L34:
            r511 = r101.decodeLongElement(r100, 15);
            r172 = 32768;
            goto L35
        L36:
            r144 = r144;
            r222 = r101.decodeBooleanElement(r100, 14);
            r173 = r148 | 16384;
            goto L39
        L38:
            r144 = r144;
            r221 = r101.decodeIntElement(r100, 13);
            r173 = r148 | 8192;
            goto L39
        L40:
            r144 = r144;
            r424 = r101.decodeIntElement(r100, 12);
            r173 = r148 | 4096;
            Unit r177 = Unit.INSTANCE;
            goto L41
        L42:
            r139 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r139);
            r173 = r148 | 2048;
        L44:
            Unit r178 = Unit.INSTANCE;
            goto L47
        L43:
            r140 = (AudioPreview) r101.decodeNullableSerializableElement(r100, 10, AudioPreview.a.f346420a, r140);
            r173 = r148 | 1024;
            goto L44
        L46:
            r102 = r102;
            r144 = r144;
            r138 = (String) r101.decodeNullableSerializableElement(r100, 9, v2.f520790a, r138);
            r173 = r148 | 512;
            Unit r179 = Unit.INSTANCE;
            goto L47
        L48:
            r102 = r102;
            String r517 = r144;
            String r180 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r420);
            r173 = r148 | 256;
            Unit r181 = Unit.INSTANCE;
            r420 = r180;
            r325 = r423;
            r516 = r516;
            r175 = r517;
            goto L58
        L49:
            r102 = r102;
            r420 = r420;
            r175 = (String) r101.decodeNullableSerializableElement(r100, 7, v2.f520790a, r144);
            r173 = r148 | 128;
            Unit r182 = Unit.INSTANCE;
            r325 = r423;
            r516 = r516;
            goto L58
        L50:
            r102 = r102;
            r420 = r420;
            String r183 = r144;
            String r184 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r516);
            r173 = r148 | 64;
            Unit r185 = Unit.INSTANCE;
            r516 = r184;
            r175 = r183;
            r325 = r423;
            goto L58
        L51:
            r102 = r102;
            String r330 = r144;
            r420 = r420;
            r516 = r516;
            String r186 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r423);
            r173 = r148 | 32;
            Unit r187 = Unit.INSTANCE;
            r325 = r186;
            r175 = r330;
            goto L58
        L53:
            r325 = r423;
            IconItem r188 = (IconItem) r101.decodeNullableSerializableElement(r100, 4, IconItem.a.f346476a, r422);
            int r189 = r148 | 16;
            Unit r190 = Unit.INSTANCE;
            IconItem r191 = r188;
        L55:
            r422 = r191;
            r173 = r189;
            r421 = r421;
        L57:
            r175 = r144;
            goto L58
        L54:
            r325 = r423;
            String r192 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r421);
            r189 = r148 | 8;
            Unit r193 = Unit.INSTANCE;
            r421 = r192;
            r191 = r422;
            goto L55
        L56:
            r102 = r102;
            r144 = r144;
            r420 = r420;
            r422 = r422;
            r325 = r423;
            r516 = r516;
            r137 = r137;
            r421 = r421;
            r321 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r321);
            Unit r194 = Unit.INSTANCE;
            r173 = r148 | 4;
            goto L57
        L59:
            r102 = r102;
            r420 = r420;
            r421 = r421;
            r325 = r423;
            r516 = r516;
            r137 = r137;
            r329 = r321;
            r320 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r320);
            r173 = r148 | 2;
            Unit r195 = Unit.INSTANCE;
            r176 = r422;
            r175 = r144;
            goto L60
        L62:
            r102 = r102;
            String r331 = r144;
            r328 = r321;
            r426 = r420;
            r421 = r421;
            r327 = r422;
            r325 = r423;
            r516 = r516;
            r427 = r137;
            r326 = r320;
            String r196 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r319);
            r148 = r148 | 1;
            Unit r197 = Unit.INSTANCE;
            r319 = r196;
            r144 = r331;
            goto L64
        L63:
            r102 = r102;
            String r332 = r144;
            r326 = r320;
            r328 = r321;
            r426 = r420;
            r421 = r421;
            r327 = r422;
            r325 = r423;
            r516 = r516;
            r427 = r137;
            Unit r198 = Unit.INSTANCE;
            r144 = r332;
            r515 = false;
            goto L64
        L10:
            throw new UnknownFieldException(r149);
        L65:
            String r333 = r320;
            String r334 = r321;
            IconItem r335 = r422;
            String r336 = r423;
            r133 = r319;
            r314 = r142;
            r410 = r143;
            r415 = r145;
            r310 = r146;
            r134 = r148;
            r313 = r223;
            r412 = r225;
            r135 = r333;
            r215 = r334;
            r214 = r421;
            r217 = r335;
            r219 = r336;
            r218 = r147;
            r315 = r424;
            r417 = r425;
            r312 = r512;
            r413 = r513;
            r414 = r514;
            r318 = r511;
            r211 = r138;
            r213 = r139;
            r419 = r141;
            r316 = r221;
            r317 = r222;
            r220 = r144;
            r212 = r420;
            r311 = r137;
            r416 = r136;
            r411 = r224;
            r216 = r140;
            goto L66
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            SpeakerVoice r102 = (SpeakerVoice) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346505b;
            muc.d r104 = r100.beginStructure(r103);
            SpeakerVoice.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<SpeakerVoice> serializer() {
            return a.f346504a;
        }
    }

    public SpeakerVoice() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, false, 0, 0, null, null, false, null, 0, null, 0, 0, 0.0f, 0.0f, null, false, null, null, Integer.MAX_VALUE, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpeakerVoice copy$default(SpeakerVoice r110, String r111, String r112, String r210, String r211, IconItem r212, String r213, String r214, String r215, String r216, String r217, AudioPreview r218, String r219, int r310, int r311, boolean r312, long r313, int r314, List r315, String r316, boolean r317, List r318, int r410, List r411, int r412, int r413, float r414, float r415, String r416, boolean r417, String r418, String r419, int r510, Object r511) {
        if ((r510 & 1) == 0) goto L5;
        String r100 = r110.f346503id;
    L7:
        if ((r510 & 2) == 0) goto L9;
        String r101 = r110.modelName;
    L11:
        if ((r510 & 4) == 0) goto L13;
        String r102 = r110.name;
    L15:
        if ((r510 & 8) == 0) goto L17;
        String r103 = r110.creatorUserName;
    L19:
        if ((r510 & 16) == 0) goto L21;
        IconItem r104 = r110.icon;
    L23:
        if ((r510 & 32) == 0) goto L25;
        String r105 = r110.language;
    L27:
        if ((r510 & 64) == 0) goto L29;
        String r106 = r110.styleId;
    L31:
        if ((r510 & 128) == 0) goto L33;
        String r107 = r110.styleName;
    L35:
        if ((r510 & 256) == 0) goto L37;
        String r113 = r110.languageCode;
    L39:
        if ((r510 & 512) == 0) goto L41;
        String r114 = r110.languageKey;
    L43:
        if ((r510 & 1024) == 0) goto L45;
        AudioPreview r115 = r110.preview;
    L47:
        if ((r510 & 2048) == 0) goto L49;
        String r116 = r110.creatorId;
    L51:
        if ((r510 & 4096) == 0) goto L53;
        int r117 = r110.status;
    L55:
        if ((r510 & 8192) == 0) goto L57;
        int r118 = r110.privateStatus;
    L58:
        int r319 = r118;
        if ((r510 & 16384) == 0) goto L61;
        boolean r119 = r110.isUgcVoice;
    L62:
        int r320 = r117;
        boolean r321 = r119;
        if ((r510 & 32768) == 0) goto L65;
        long r120 = r110.createTime;
    L66:
        long r322 = r120;
        if ((r510 & 65536) == 0) goto L69;
        int r121 = r110.nameStatus;
    L71:
        if ((131072 & r510) == 0) goto L73;
        List r122 = r110.exclusiveBotIds;
    L74:
        List r323 = r122;
        if ((r510 & 262144) == 0) goto L77;
        String r123 = r110.displayHeatScore;
    L78:
        String r324 = r123;
        if ((r510 & 524288) == 0) goto L81;
        boolean r124 = r110.bestMatch;
    L82:
        boolean r325 = r124;
        if ((r510 & 1048576) == 0) goto L85;
        List r125 = r110.tagList;
    L86:
        List r326 = r125;
        if ((r510 & 2097152) == 0) goto L89;
        int r126 = r110.confStatus;
    L90:
        int r420 = r126;
        if ((r510 & 4194304) == 0) goto L93;
        List r127 = r110.mixVoiceList;
    L94:
        List r421 = r127;
        if ((r510 & 8388608) == 0) goto L97;
        int r128 = r110.pitch;
    L98:
        int r422 = r128;
        if ((r510 & 16777216) == 0) goto L101;
        int r129 = r110.speechRate;
    L102:
        int r423 = r129;
        if ((r510 & 33554432) == 0) goto L105;
        float r130 = r110.pitchF64;
    L106:
        float r424 = r130;
        if ((r510 & 67108864) == 0) goto L109;
        float r131 = r110.speechRateF64;
    L110:
        float r425 = r131;
        if ((r510 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r132 = r110.extra;
    L114:
        String r426 = r132;
        if ((r510 & 268435456) == 0) goto L117;
        boolean r133 = r110.allowMix;
    L118:
        boolean r427 = r133;
        if ((r510 & 536870912) == 0) goto L121;
        String r134 = r110.audioMetrics;
    L123:
        if ((r510 & 1073741824) == 0) goto L125;
        String r108 = r110.callStyleId;
    L127:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r320, r319, r321, r322, r121, r323, r324, r325, r326, r420, r421, r422, r423, r424, r425, r426, r427, r134, r108);
    L125:
        r108 = r419;
        goto L127
    L121:
        r134 = r418;
        goto L123
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
        goto L71
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

    @SerialName("allow_mix")
    public static /* synthetic */ void getAllowMix$annotations() {
    }

    @SerialName("audio_metrics")
    public static /* synthetic */ void getAudioMetrics$annotations() {
    }

    @SerialName("is_best_match")
    public static /* synthetic */ void getBestMatch$annotations() {
    }

    @SerialName("style_id_phone_call")
    public static /* synthetic */ void getCallStyleId$annotations() {
    }

    @SerialName("voice_conf_status")
    public static /* synthetic */ void getConfStatus$annotations() {
    }

    @SerialName("create_time")
    public static /* synthetic */ void getCreateTime$annotations() {
    }

    @SerialName("creator_id")
    public static /* synthetic */ void getCreatorId$annotations() {
    }

    @SerialName("creator_username")
    public static /* synthetic */ void getCreatorUserName$annotations() {
    }

    @SerialName("display_heat_score")
    public static /* synthetic */ void getDisplayHeatScore$annotations() {
    }

    @SerialName("exclusive_bot_ids")
    public static /* synthetic */ void getExclusiveBotIds$annotations() {
    }

    @SerialName("extra")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName("icon")
    public static /* synthetic */ void getIcon$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("language")
    public static /* synthetic */ void getLanguage$annotations() {
    }

    @SerialName("language_code")
    public static /* synthetic */ void getLanguageCode$annotations() {
    }

    @SerialName("language_key")
    public static /* synthetic */ void getLanguageKey$annotations() {
    }

    @SerialName("mix_voice_list")
    public static /* synthetic */ void getMixVoiceList$annotations() {
    }

    @SerialName("model_name")
    public static /* synthetic */ void getModelName$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("name_status")
    public static /* synthetic */ void getNameStatus$annotations() {
    }

    @SerialName(TextureRenderKeys.KEY_IS_PITCH)
    public static /* synthetic */ void getPitch$annotations() {
    }

    @SerialName("pitch_f64")
    public static /* synthetic */ void getPitchF64$annotations() {
    }

    @SerialName("preview")
    public static /* synthetic */ void getPreview$annotations() {
    }

    @SerialName("private_status")
    public static /* synthetic */ void getPrivateStatus$annotations() {
    }

    @SerialName("speech_rate")
    public static /* synthetic */ void getSpeechRate$annotations() {
    }

    @SerialName("speech_rate_f64")
    public static /* synthetic */ void getSpeechRateF64$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("style_id")
    public static /* synthetic */ void getStyleId$annotations() {
    }

    @SerialName("style_name")
    public static /* synthetic */ void getStyleName$annotations() {
    }

    @SerialName("tag_list")
    public static /* synthetic */ void getTagList$annotations() {
    }

    @SerialName(CacheHandlerBusiness.UGC_VOICE)
    public static /* synthetic */ void isUgcVoice$annotations() {
    }

    public final String component1() {
        return this.f346503id;
    }

    public final String component10() {
        return this.languageKey;
    }

    public final AudioPreview component11() {
        return this.preview;
    }

    public final String component12() {
        return this.creatorId;
    }

    public final int component13() {
        return this.status;
    }

    public final int component14() {
        return this.privateStatus;
    }

    public final boolean component15() {
        return this.isUgcVoice;
    }

    public final long component16() {
        return this.createTime;
    }

    public final int component17() {
        return this.nameStatus;
    }

    public final List<Long> component18() {
        return this.exclusiveBotIds;
    }

    public final String component19() {
        return this.displayHeatScore;
    }

    public final String component2() {
        return this.modelName;
    }

    public final boolean component20() {
        return this.bestMatch;
    }

    public final List<VoiceTag> component21() {
        return this.tagList;
    }

    public final int component22() {
        return this.confStatus;
    }

    public final List<MixVoice> component23() {
        return this.mixVoiceList;
    }

    public final int component24() {
        return this.pitch;
    }

    public final int component25() {
        return this.speechRate;
    }

    public final float component26() {
        return this.pitchF64;
    }

    public final float component27() {
        return this.speechRateF64;
    }

    public final String component28() {
        return this.extra;
    }

    public final boolean component29() {
        return this.allowMix;
    }

    public final String component3() {
        return this.name;
    }

    public final String component30() {
        return this.audioMetrics;
    }

    public final String component31() {
        return this.callStyleId;
    }

    public final String component4() {
        return this.creatorUserName;
    }

    public final IconItem component5() {
        return this.icon;
    }

    public final String component6() {
        return this.language;
    }

    public final String component7() {
        return this.styleId;
    }

    public final String component8() {
        return this.styleName;
    }

    public final String component9() {
        return this.languageCode;
    }

    public final SpeakerVoice copy(String r310, String r311, String r312, String r313, IconItem r314, String r410, String r411, String r412, String r413, String r414, AudioPreview r415, String r416, int r417, int r418, boolean r419, long r510, int r511, List<Long> r512, String r513, boolean r514, List<VoiceTag> r515, int r516, List<MixVoice> r517, int r518, int r610, float r611, float r612, String r613, boolean r614, String r615, String r616) {
        return new SpeakerVoice(r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpeakerVoice) == true) goto L8;
        return false;
    L8:
        SpeakerVoice r101 = (SpeakerVoice) r100;
        if (Intrinsics.areEqual(this.f346503id, r101.f346503id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.modelName, r101.modelName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.creatorUserName, r101.creatorUserName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.language, r101.language) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.styleId, r101.styleId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.styleName, r101.styleName) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.languageCode, r101.languageCode) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.languageKey, r101.languageKey) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.preview, r101.preview) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.creatorId, r101.creatorId) == true) goto L45;
        return false;
    L45:
        if (this.status == r101.status) goto L48;
        return false;
    L48:
        if (this.privateStatus == r101.privateStatus) goto L51;
        return false;
    L51:
        if (this.isUgcVoice == r101.isUgcVoice) goto L54;
        return false;
    L54:
        if (this.createTime == r101.createTime) goto L57;
        return false;
    L57:
        if (this.nameStatus == r101.nameStatus) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.exclusiveBotIds, r101.exclusiveBotIds) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.displayHeatScore, r101.displayHeatScore) == true) goto L66;
        return false;
    L66:
        if (this.bestMatch == r101.bestMatch) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.tagList, r101.tagList) == true) goto L72;
        return false;
    L72:
        if (this.confStatus == r101.confStatus) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.mixVoiceList, r101.mixVoiceList) == true) goto L78;
        return false;
    L78:
        if (this.pitch == r101.pitch) goto L81;
        return false;
    L81:
        if (this.speechRate == r101.speechRate) goto L84;
        return false;
    L84:
        if (Float.compare(this.pitchF64, r101.pitchF64) == 0) goto L87;
        return false;
    L87:
        if (Float.compare(this.speechRateF64, r101.speechRateF64) == 0) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L93;
        return false;
    L93:
        if (this.allowMix == r101.allowMix) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.audioMetrics, r101.audioMetrics) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.callStyleId, r101.callStyleId) == true) goto L101;
        return false;
    L101:
        return true;
    }

    public int hashCode() {
        String r100 = this.f346503id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.modelName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.name;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.creatorUserName;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        IconItem r113 = this.icon;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.language;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.styleId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.styleName;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.languageCode;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.languageKey;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        AudioPreview r131 = this.preview;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.creatorId;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (((((r133 + r135) * 31) + this.status) * 31) + this.privateStatus) * 31;
        int r137 = 1231;
        if (this.isUgcVoice == false) goto L53;
        int r138 = 1231;
    L54:
        long r139 = this.createTime;
        int r140 = (((((r136 + r138) * 31) + ((int) (r139 ^ (r139 >>> 32)))) * 31) + this.nameStatus) * 31;
        List<Long> r141 = this.exclusiveBotIds;
        if (r141 != null) goto L57;
        int r142 = 0;
    L58:
        int r143 = (r140 + r142) * 31;
        String r144 = this.displayHeatScore;
        if (r144 != null) goto L61;
        int r145 = 0;
    L62:
        int r146 = (r143 + r145) * 31;
        if (this.bestMatch == false) goto L65;
        int r147 = 1231;
    L66:
        int r148 = (r146 + r147) * 31;
        List<VoiceTag> r149 = this.tagList;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (((r148 + r150) * 31) + this.confStatus) * 31;
        List<MixVoice> r152 = this.mixVoiceList;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (((((((((r151 + r153) * 31) + this.pitch) * 31) + this.speechRate) * 31) + Float.floatToIntBits(this.pitchF64)) * 31) + Float.floatToIntBits(this.speechRateF64)) * 31;
        String r155 = this.extra;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        if (this.allowMix == true) goto L82;
        r137 = 1237;
    L82:
        int r158 = (r157 + r137) * 31;
        String r159 = this.audioMetrics;
        if (r159 != null) goto L85;
        int r160 = 0;
    L86:
        int r161 = (r158 + r160) * 31;
        String r162 = this.callStyleId;
        if (r162 == null) goto L91;
        r101 = r162.hashCode();
    L91:
        return r161 + r101;
    L85:
        r160 = r159.hashCode();
        goto L86
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = 1237;
        goto L66
    L61:
        r145 = r144.hashCode();
        goto L62
    L57:
        r142 = r141.hashCode();
        goto L58
    L53:
        r138 = 1237;
        goto L54
    L49:
        r135 = r134.hashCode();
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

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f346502a = new Lazy[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(r100, new c0()), null, null, LazyKt.lazy(r100, new d0()), null, LazyKt.lazy(r100, new e0()), null, null, null, null, null, null, null, null};
    }

    public String toString() {
        return "id:" + this.f346503id + ", name:" + this.name + ", styleId:" + this.styleId + ", callStyleId:" + this.callStyleId + ", languageCode:" + this.languageCode + ", status:" + this.status + ", nameStatus:" + this.nameStatus + ", confStatus:" + this.confStatus + ", mixVoiceList:" + this.mixVoiceList;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return f346502a;
    }

    public final boolean getAllowMix() {
        return this.allowMix;
    }

    public final String getAudioMetrics() {
        return this.audioMetrics;
    }

    public final boolean getBestMatch() {
        return this.bestMatch;
    }

    public final String getCallStyleId() {
        return this.callStyleId;
    }

    public final int getConfStatus() {
        return this.confStatus;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getCreatorId() {
        return this.creatorId;
    }

    public final String getCreatorUserName() {
        return this.creatorUserName;
    }

    public final String getDisplayHeatScore() {
        return this.displayHeatScore;
    }

    public final List<Long> getExclusiveBotIds() {
        return this.exclusiveBotIds;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final IconItem getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f346503id;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getLanguageCode() {
        return this.languageCode;
    }

    public final String getLanguageKey() {
        return this.languageKey;
    }

    public final List<MixVoice> getMixVoiceList() {
        return this.mixVoiceList;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNameStatus() {
        return this.nameStatus;
    }

    public final int getPitch() {
        return this.pitch;
    }

    public final float getPitchF64() {
        return this.pitchF64;
    }

    public final AudioPreview getPreview() {
        return this.preview;
    }

    public final int getPrivateStatus() {
        return this.privateStatus;
    }

    public final int getSpeechRate() {
        return this.speechRate;
    }

    public final float getSpeechRateF64() {
        return this.speechRateF64;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getStyleId() {
        return this.styleId;
    }

    public final String getStyleName() {
        return this.styleName;
    }

    public final List<VoiceTag> getTagList() {
        return this.tagList;
    }

    public final boolean isUgcVoice() {
        return this.isUgcVoice;
    }

    public final void setBestMatch(boolean r100) {
        this.bestMatch = r100;
    }

    public final void setCreatorId(String r100) {
        this.creatorId = r100;
    }

    public final void setCreatorUserName(String r100) {
        this.creatorUserName = r100;
    }

    public final void setExclusiveBotIds(List<Long> r100) {
        this.exclusiveBotIds = r100;
    }

    public final void setIcon(IconItem r100) {
        this.icon = r100;
    }

    public final void setId(String r100) {
        this.f346503id = r100;
    }

    public final void setLanguage(String r100) {
        this.language = r100;
    }

    public final void setLanguageCode(String r100) {
        this.languageCode = r100;
    }

    public final void setLanguageKey(String r100) {
        this.languageKey = r100;
    }

    public final void setModelName(String r100) {
        this.modelName = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setNameStatus(int r100) {
        this.nameStatus = r100;
    }

    public final void setPreview(AudioPreview r100) {
        this.preview = r100;
    }

    public final void setPrivateStatus(int r100) {
        this.privateStatus = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setStyleId(String r100) {
        this.styleId = r100;
    }

    public final void setStyleName(String r100) {
        this.styleName = r100;
    }

    public final void setUgcVoice(boolean r100) {
        this.isUgcVoice = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(SpeakerVoice r110, muc.d r111, f r112) {
        Lazy<d<Object>>[] r100 = f346502a;
        boolean r101 = false;
        if (r111.shouldEncodeElementDefault(r112, 0) == false) goto L6;
    L4:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        r111.encodeNullableSerializableElement(r112, 0, v2.f520790a, r110.f346503id);
    L12:
        if (r111.shouldEncodeElementDefault(r112, 1) == false) goto L15;
    L13:
        boolean r103 = true;
    L18:
        if (r103 == false) goto L21;
        r111.encodeNullableSerializableElement(r112, 1, v2.f520790a, r110.modelName);
    L21:
        if (r111.shouldEncodeElementDefault(r112, 2) == false) goto L24;
    L22:
        boolean r104 = true;
    L27:
        if (r104 == false) goto L30;
        r111.encodeNullableSerializableElement(r112, 2, v2.f520790a, r110.name);
    L30:
        if (r111.shouldEncodeElementDefault(r112, 3) == false) goto L33;
    L31:
        boolean r105 = true;
    L36:
        if (r105 == false) goto L39;
        r111.encodeNullableSerializableElement(r112, 3, v2.f520790a, r110.creatorUserName);
    L39:
        if (r111.shouldEncodeElementDefault(r112, 4) == false) goto L42;
    L40:
        boolean r106 = true;
    L45:
        if (r106 == false) goto L48;
        r111.encodeNullableSerializableElement(r112, 4, IconItem.a.f346476a, r110.icon);
    L48:
        if (r111.shouldEncodeElementDefault(r112, 5) == false) goto L51;
    L49:
        boolean r107 = true;
    L54:
        if (r107 == false) goto L57;
        r111.encodeNullableSerializableElement(r112, 5, v2.f520790a, r110.language);
    L57:
        if (r111.shouldEncodeElementDefault(r112, 6) == false) goto L60;
    L58:
        boolean r108 = true;
    L63:
        if (r108 == false) goto L66;
        r111.encodeNullableSerializableElement(r112, 6, v2.f520790a, r110.styleId);
    L66:
        if (r111.shouldEncodeElementDefault(r112, 7) == false) goto L69;
    L67:
        boolean r109 = true;
    L72:
        if (r109 == false) goto L75;
        r111.encodeNullableSerializableElement(r112, 7, v2.f520790a, r110.styleName);
    L75:
        if (r111.shouldEncodeElementDefault(r112, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r111.encodeNullableSerializableElement(r112, 8, v2.f520790a, r110.languageCode);
    L84:
        if (r111.shouldEncodeElementDefault(r112, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r111.encodeNullableSerializableElement(r112, 9, v2.f520790a, r110.languageKey);
    L93:
        if (r111.shouldEncodeElementDefault(r112, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r111.encodeNullableSerializableElement(r112, 10, AudioPreview.a.f346420a, r110.preview);
    L102:
        if (r111.shouldEncodeElementDefault(r112, 11) == false) goto L105;
    L103:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r111.encodeNullableSerializableElement(r112, 11, v2.f520790a, r110.creatorId);
    L111:
        if (r111.shouldEncodeElementDefault(r112, 12) == false) goto L114;
    L112:
        boolean r117 = true;
    L117:
        if (r117 == false) goto L120;
        r111.encodeIntElement(r112, 12, r110.status);
    L120:
        if (r111.shouldEncodeElementDefault(r112, 13) == false) goto L123;
    L121:
        boolean r118 = true;
    L126:
        if (r118 == false) goto L129;
        r111.encodeIntElement(r112, 13, r110.privateStatus);
    L129:
        if (r111.shouldEncodeElementDefault(r112, 14) == false) goto L132;
    L130:
        boolean r119 = true;
    L135:
        if (r119 == false) goto L138;
        r111.encodeBooleanElement(r112, 14, r110.isUgcVoice);
    L138:
        if (r111.shouldEncodeElementDefault(r112, 15) == false) goto L141;
    L139:
        boolean r120 = true;
    L144:
        if (r120 == false) goto L147;
        r111.encodeLongElement(r112, 15, r110.createTime);
    L147:
        if (r111.shouldEncodeElementDefault(r112, 16) == false) goto L150;
    L148:
        boolean r121 = true;
    L153:
        if (r121 == false) goto L156;
        r111.encodeIntElement(r112, 16, r110.nameStatus);
    L156:
        if (r111.shouldEncodeElementDefault(r112, 17) == false) goto L159;
    L157:
        boolean r122 = true;
    L162:
        if (r122 == false) goto L165;
        r111.encodeNullableSerializableElement(r112, 17, r100[17].getValue(), r110.exclusiveBotIds);
    L165:
        if (r111.shouldEncodeElementDefault(r112, 18) == false) goto L168;
    L166:
        boolean r123 = true;
    L171:
        if (r123 == false) goto L174;
        r111.encodeNullableSerializableElement(r112, 18, v2.f520790a, r110.displayHeatScore);
    L174:
        if (r111.shouldEncodeElementDefault(r112, 19) == false) goto L177;
    L175:
        boolean r124 = true;
    L180:
        if (r124 == false) goto L183;
        r111.encodeBooleanElement(r112, 19, r110.bestMatch);
    L183:
        if (r111.shouldEncodeElementDefault(r112, 20) == false) goto L186;
    L184:
        boolean r125 = true;
    L189:
        if (r125 == false) goto L192;
        r111.encodeNullableSerializableElement(r112, 20, r100[20].getValue(), r110.tagList);
    L192:
        if (r111.shouldEncodeElementDefault(r112, 21) == false) goto L195;
    L193:
        boolean r126 = true;
    L198:
        if (r126 == false) goto L201;
        r111.encodeIntElement(r112, 21, r110.confStatus);
    L201:
        if (r111.shouldEncodeElementDefault(r112, 22) == false) goto L204;
    L202:
        boolean r127 = true;
    L207:
        if (r127 == false) goto L210;
        r111.encodeNullableSerializableElement(r112, 22, r100[22].getValue(), r110.mixVoiceList);
    L210:
        if (r111.shouldEncodeElementDefault(r112, 23) == false) goto L213;
    L211:
        boolean r128 = true;
    L216:
        if (r128 == false) goto L219;
        r111.encodeIntElement(r112, 23, r110.pitch);
    L219:
        if (r111.shouldEncodeElementDefault(r112, 24) == false) goto L222;
    L220:
        boolean r129 = true;
    L225:
        if (r129 == false) goto L228;
        r111.encodeIntElement(r112, 24, r110.speechRate);
    L228:
        if (r111.shouldEncodeElementDefault(r112, 25) == false) goto L231;
    L229:
        boolean r130 = true;
    L234:
        if (r130 == false) goto L237;
        r111.encodeFloatElement(r112, 25, r110.pitchF64);
    L237:
        if (r111.shouldEncodeElementDefault(r112, 26) == false) goto L240;
    L238:
        boolean r131 = true;
    L243:
        if (r131 == false) goto L246;
        r111.encodeFloatElement(r112, 26, r110.speechRateF64);
    L246:
        if (r111.shouldEncodeElementDefault(r112, 27) == false) goto L249;
    L247:
        boolean r132 = true;
    L252:
        if (r132 == false) goto L255;
        r111.encodeNullableSerializableElement(r112, 27, v2.f520790a, r110.extra);
    L255:
        if (r111.shouldEncodeElementDefault(r112, 28) == false) goto L258;
    L256:
        boolean r133 = true;
    L261:
        if (r133 == false) goto L264;
        r111.encodeBooleanElement(r112, 28, r110.allowMix);
    L264:
        if (r111.shouldEncodeElementDefault(r112, 29) == false) goto L267;
    L265:
        boolean r134 = true;
    L270:
        if (r134 == false) goto L273;
        r111.encodeNullableSerializableElement(r112, 29, v2.f520790a, r110.audioMetrics);
    L273:
        if (r111.shouldEncodeElementDefault(r112, 30) == false) goto L276;
    L274:
        r101 = true;
    L278:
        if (r101 == false) goto L281;
        r111.encodeNullableSerializableElement(r112, 30, v2.f520790a, r110.callStyleId);
        return;
    L281:
        return;
    L276:
        if (Intrinsics.areEqual(r110.callStyleId, "") == true) goto L278;
    L267:
        if (Intrinsics.areEqual(r110.audioMetrics, "") == false) goto L265;
        r134 = false;
        goto L270
    L258:
        if (r110.allowMix == true) goto L256;
        r133 = false;
        goto L261
    L249:
        if (Intrinsics.areEqual(r110.extra, "") == false) goto L247;
        r132 = false;
        goto L252
    L240:
        if (Float.compare(r110.speechRateF64, 10.0f) != 0) goto L238;
        r131 = false;
        goto L243
    L231:
        if (Float.compare(r110.pitchF64, 0.0f) != 0) goto L229;
        r130 = false;
        goto L234
    L222:
        if (r110.speechRate != 10) goto L220;
        r129 = false;
        goto L225
    L213:
        if (r110.pitch != 0) goto L211;
        r128 = false;
        goto L216
    L204:
        if (r110.mixVoiceList != null) goto L202;
        r127 = false;
        goto L207
    L195:
        if (r110.confStatus != 0) goto L193;
        r126 = false;
        goto L198
    L186:
        if (r110.tagList != null) goto L184;
        r125 = false;
        goto L189
    L177:
        if (r110.bestMatch == true) goto L175;
        r124 = false;
        goto L180
    L168:
        if (Intrinsics.areEqual(r110.displayHeatScore, "") == false) goto L166;
        r123 = false;
        goto L171
    L159:
        if (r110.exclusiveBotIds != null) goto L157;
        r122 = false;
        goto L162
    L150:
        if (r110.nameStatus != 1) goto L148;
        r121 = false;
        goto L153
    L141:
        if (r110.createTime != (com.larus.im.internal.delegate.c.f348197a.currentTimeMillis() / 1000)) goto L139;
        r120 = false;
        goto L144
    L132:
        if (r110.isUgcVoice == true) goto L130;
        r119 = false;
        goto L135
    L123:
        if (r110.privateStatus != 0) goto L121;
        r118 = false;
        goto L126
    L114:
        if (r110.status != 1) goto L112;
        r117 = false;
        goto L117
    L105:
        if (Intrinsics.areEqual(r110.creatorId, "") == false) goto L103;
        r116 = false;
        goto L108
    L96:
        if (r110.preview != null) goto L94;
        r115 = false;
        goto L99
    L87:
        if (Intrinsics.areEqual(r110.languageKey, "") == false) goto L85;
        r114 = false;
        goto L90
    L78:
        if (Intrinsics.areEqual(r110.languageCode, "") == false) goto L76;
        r113 = false;
        goto L81
    L69:
        if (Intrinsics.areEqual(r110.styleName, "") == false) goto L67;
        r109 = false;
        goto L72
    L60:
        if (Intrinsics.areEqual(r110.styleId, "") == false) goto L58;
        r108 = false;
        goto L63
    L51:
        if (Intrinsics.areEqual(r110.language, "") == false) goto L49;
        r107 = false;
        goto L54
    L42:
        if (r110.icon != null) goto L40;
        r106 = false;
        goto L45
    L33:
        if (Intrinsics.areEqual(r110.creatorUserName, "") == false) goto L31;
        r105 = false;
        goto L36
    L24:
        if (Intrinsics.areEqual(r110.name, "") == false) goto L22;
        r104 = false;
        goto L27
    L15:
        if (Intrinsics.areEqual(r110.modelName, "") == false) goto L13;
        r103 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r110.f346503id, "") == false) goto L4;
        r102 = false;
        goto L9
    }

    public SpeakerVoice(String r100, String r101, String r102, String r103, IconItem r104, String r105, String r110, String r111, String r112, String r113, AudioPreview r114, String r115, int r116, int r117, boolean r118, long r119, int r210, List<Long> r211, String r212, boolean r213, List<VoiceTag> r214, int r215, List<MixVoice> r216, int r217, int r218, float r310, float r311, String r312, boolean r313, String r314, String r315) {
        this.f346503id = r100;
        this.modelName = r101;
        this.name = r102;
        this.creatorUserName = r103;
        this.icon = r104;
        this.language = r105;
        this.styleId = r110;
        this.styleName = r111;
        this.languageCode = r112;
        this.languageKey = r113;
        this.preview = r114;
        this.creatorId = r115;
        this.status = r116;
        this.privateStatus = r117;
        this.isUgcVoice = r118;
        this.createTime = r119;
        this.nameStatus = r210;
        this.exclusiveBotIds = r211;
        this.displayHeatScore = r212;
        this.bestMatch = r213;
        this.tagList = r214;
        this.confStatus = r215;
        this.mixVoiceList = r216;
        this.pitch = r217;
        this.speechRate = r218;
        this.pitchF64 = r310;
        this.speechRateF64 = r311;
        this.extra = r312;
        this.allowMix = r313;
        this.audioMetrics = r314;
        this.callStyleId = r315;
    }

    public SpeakerVoice(int r110, String r111, String r112, String r113, String r114, IconItem r115, String r116, String r117, String r210, String r211, String r212, AudioPreview r213, String r214, int r215, int r216, boolean r217, long r218, int r310, List r311, String r312, boolean r313, List r314, int r315, List r316, int r317, int r318, float r319, float r410, String r411, boolean r412, String r413, String r414, q2 r415) {
        if ((r110 & 0) == 0) goto L5;
        b2.b(r110, 0, a.f346505b);
        throw null;
    L5:
        if ((r110 & 1) != 0) goto L7;
        this.f346503id = "";
    L9:
        if ((r110 & 2) != 0) goto L11;
        this.modelName = "";
    L13:
        if ((r110 & 4) != 0) goto L15;
        this.name = "";
    L17:
        if ((r110 & 8) != 0) goto L19;
        this.creatorUserName = "";
    L21:
        if ((r110 & 16) != 0) goto L23;
        this.icon = null;
    L25:
        if ((r110 & 32) != 0) goto L27;
        this.language = "";
    L29:
        if ((r110 & 64) != 0) goto L31;
        this.styleId = "";
    L33:
        if ((r110 & 128) != 0) goto L35;
        this.styleName = "";
    L37:
        if ((r110 & 256) != 0) goto L39;
        this.languageCode = "";
    L41:
        if ((r110 & 512) != 0) goto L43;
        this.languageKey = "";
    L45:
        if ((r110 & 1024) != 0) goto L47;
        this.preview = null;
    L49:
        if ((r110 & 2048) != 0) goto L51;
        this.creatorId = "";
    L53:
        if ((r110 & 4096) != 0) goto L55;
        this.status = 1;
    L57:
        if ((r110 & 8192) != 0) goto L59;
        this.privateStatus = 0;
    L61:
        if ((r110 & 16384) != 0) goto L63;
        this.isUgcVoice = false;
    L65:
        if ((32768 & r110) != 0) goto L67;
        long r100 = com.larus.im.internal.delegate.c.f348197a.currentTimeMillis() / 1000;
    L68:
        this.createTime = r100;
        if ((65536 & r110) != 0) goto L71;
        this.nameStatus = 1;
    L73:
        if ((131072 & r110) != 0) goto L75;
        this.exclusiveBotIds = null;
    L77:
        if ((262144 & r110) != 0) goto L79;
        this.displayHeatScore = "";
    L81:
        if ((524288 & r110) != 0) goto L83;
        this.bestMatch = false;
    L85:
        if ((1048576 & r110) != 0) goto L87;
        this.tagList = null;
    L89:
        if ((2097152 & r110) != 0) goto L91;
        this.confStatus = 0;
    L93:
        if ((4194304 & r110) != 0) goto L95;
        this.mixVoiceList = null;
    L97:
        if ((8388608 & r110) != 0) goto L99;
        this.pitch = 0;
    L101:
        if ((16777216 & r110) != 0) goto L103;
        int r101 = 10;
    L104:
        this.speechRate = r101;
        if ((33554432 & r110) != 0) goto L107;
        float r102 = 0.0f;
    L108:
        this.pitchF64 = r102;
        if ((67108864 & r110) != 0) goto L111;
        float r103 = 10.0f;
    L112:
        this.speechRateF64 = r103;
        if ((134217728 & r110) != 0) goto L115;
        this.extra = "";
    L117:
        if ((268435456 & r110) != 0) goto L119;
        this.allowMix = false;
    L121:
        if ((536870912 & r110) != 0) goto L123;
        this.audioMetrics = "";
    L125:
        if ((r110 & 1073741824) != 0) goto L127;
        this.callStyleId = "";
        return;
    L127:
        this.callStyleId = r414;
        return;
    L123:
        this.audioMetrics = r413;
        goto L125
    L119:
        this.allowMix = r412;
        goto L121
    L115:
        this.extra = r411;
        goto L117
    L111:
        r103 = r410;
        goto L112
    L107:
        r102 = r319;
        goto L108
    L103:
        r101 = r318;
        goto L104
    L99:
        this.pitch = r317;
        goto L101
    L95:
        this.mixVoiceList = r316;
        goto L97
    L91:
        this.confStatus = r315;
        goto L93
    L87:
        this.tagList = r314;
        goto L89
    L83:
        this.bestMatch = r313;
        goto L85
    L79:
        this.displayHeatScore = r312;
        goto L81
    L75:
        this.exclusiveBotIds = r311;
        goto L77
    L71:
        this.nameStatus = r310;
        goto L73
    L67:
        r100 = r218;
        goto L68
    L63:
        this.isUgcVoice = r217;
        goto L65
    L59:
        this.privateStatus = r216;
        goto L61
    L55:
        this.status = r215;
        goto L57
    L51:
        this.creatorId = r214;
        goto L53
    L47:
        this.preview = r213;
        goto L49
    L43:
        this.languageKey = r212;
        goto L45
    L39:
        this.languageCode = r211;
        goto L41
    L35:
        this.styleName = r210;
        goto L37
    L31:
        this.styleId = r117;
        goto L33
    L27:
        this.language = r116;
        goto L29
    L23:
        this.icon = r115;
        goto L25
    L19:
        this.creatorUserName = r114;
        goto L21
    L15:
        this.name = r113;
        goto L17
    L11:
        this.modelName = r112;
        goto L13
    L7:
        this.f346503id = r111;
        goto L9
    }

    public /* synthetic */ SpeakerVoice(String r310, String r311, String r312, String r313, IconItem r314, String r315, String r410, String r411, String r412, String r413, AudioPreview r414, String r415, int r416, int r417, boolean r418, long r419, int r510, List r511, String r512, boolean r513, List r514, int r515, List r516, int r517, int r518, float r610, float r611, String r612, boolean r613, String r614, String r615, int r616, DefaultConstructorMarker r617) {
        if ((r616 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r616 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r616 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r616 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r616 & 16) == 0) goto L21;
        IconItem r104 = null;
    L23:
        if ((r616 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r616 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r616 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r616 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r616 & 512) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r616 & 1024) == 0) goto L45;
        AudioPreview r113 = null;
    L47:
        if ((r616 & 2048) == 0) goto L49;
        String r114 = "";
    L50:
        int r115 = 1;
        if ((r616 & 4096) == 0) goto L53;
        int r116 = 1;
    L54:
        boolean r117 = false;
        if ((r616 & 8192) == 0) goto L57;
        int r107 = 0;
    L59:
        if ((r616 & 16384) == 0) goto L61;
        boolean r108 = false;
    L63:
        if ((r616 & 32768) == 0) goto L65;
        long r118 = com.larus.im.internal.delegate.c.f348197a.currentTimeMillis() / 1000;
    L67:
        if ((r616 & 65536) != 0) goto L71;
        r115 = r510;
    L71:
        if ((r616 & 131072) == 0) goto L73;
        List r210 = null;
    L75:
        if ((r616 & 262144) == 0) goto L77;
        String r211 = "";
    L79:
        if ((r616 & 524288) == 0) goto L81;
        boolean r212 = false;
    L83:
        if ((r616 & 1048576) == 0) goto L85;
        List r213 = null;
    L87:
        if ((r616 & 2097152) == 0) goto L89;
        int r214 = 0;
    L91:
        if ((r616 & 4194304) == 0) goto L93;
        List r215 = null;
    L95:
        if ((r616 & 8388608) == 0) goto L97;
        int r216 = 0;
    L99:
        if ((r616 & 16777216) == 0) goto L101;
        int r217 = 10;
    L103:
        if ((r616 & 33554432) == 0) goto L105;
        float r218 = 0.0f;
    L107:
        if ((r616 & 67108864) == 0) goto L109;
        float r219 = 10.0f;
    L111:
        if ((r616 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r316 = "";
    L115:
        if ((r616 & 268435456) != 0) goto L119;
        r117 = r613;
    L119:
        if ((r616 & 536870912) == 0) goto L121;
        String r317 = "";
    L123:
        if ((r616 & 1073741824) == 0) goto L125;
        String r109 = "";
    L126:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r116, r107, r108, r118, r115, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r316, r117, r317, r109);
        return;
    L125:
        r109 = r615;
        goto L126
    L121:
        r317 = r614;
        goto L123
    L113:
        r316 = r612;
        goto L115
    L109:
        r219 = r611;
        goto L111
    L105:
        r218 = r610;
        goto L107
    L101:
        r217 = r518;
        goto L103
    L97:
        r216 = r517;
        goto L99
    L93:
        r215 = r516;
        goto L95
    L89:
        r214 = r515;
        goto L91
    L85:
        r213 = r514;
        goto L87
    L81:
        r212 = r513;
        goto L83
    L77:
        r211 = r512;
        goto L79
    L73:
        r210 = r511;
        goto L75
    L65:
        r118 = r419;
        goto L67
    L61:
        r108 = r418;
        goto L63
    L57:
        r107 = r417;
        goto L59
    L53:
        r116 = r416;
        goto L54
    L49:
        r114 = r415;
        goto L50
    L45:
        r113 = r414;
        goto L47
    L41:
        r112 = r413;
        goto L43
    L37:
        r111 = r412;
        goto L39
    L33:
        r110 = r411;
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
