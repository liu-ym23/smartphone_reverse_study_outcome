package com.larus.im.internal.protocol.bean;

import af9.r;
import af9.s;
import af9.t;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.google.gson.annotations.JsonAdapter;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import java.util.Map;
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
import muc.e;
import nuc.a1;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\be\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ª\u00012\u00060\u0001j\u0002`\u0002:\u0004ª\u0001«\u0001BÅ\u0003\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\b\b\u0002\u0010 \u001a\u00020\r\u0012\b\b\u0002\u0010!\u001a\u00020\r\u0012\b\b\u0002\u0010\"\u001a\u00020#\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001d\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\b\b\u0002\u0010(\u001a\u00020\u0007\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010+\u0012\b\b\u0002\u0010,\u001a\u00020#\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u00100\u001a\u00020\u0007\u0012\b\b\u0002\u00101\u001a\u00020\u0007\u0012\b\b\u0002\u00102\u001a\u00020\u0007\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b4\u00105B\u0093\u0003\b\u0010\u0012\u0006\u00106\u001a\u00020\u0007\u0012\u0006\u00107\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\u0006\u0010 \u001a\u00020\r\u0012\u0006\u0010!\u001a\u00020\r\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020#\u0012\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001d\u0012\u0006\u0010'\u001a\u00020\u0007\u0012\u0006\u0010(\u001a\u00020\u0007\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010+\u0012\u0006\u0010,\u001a\u00020#\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u00100\u001a\u00020\u0007\u0012\u0006\u00101\u001a\u00020\u0007\u0012\u0006\u00102\u001a\u00020\u0007\u0012\b\u00103\u001a\u0004\u0018\u00010\u0004\u0012\b\u00108\u001a\u0004\u0018\u000109¢\u0006\u0004\b4\u0010:J\u000b\u0010t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010v\u001a\u00020\u0007HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010z\u001a\u00020\rHÆ\u0003J\t\u0010{\u001a\u00020\rHÆ\u0003J\t\u0010|\u001a\u00020\rHÆ\u0003J\t\u0010}\u001a\u00020\rHÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\rHÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u0012\u0010\u0088\u0001\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dHÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020#HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020#HÆ\u0003J\u0012\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001dHÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0018\u0010\u0092\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010+HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020#HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010dJ\n\u0010\u0097\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003JÎ\u0003\u0010\u009b\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001d2\b\b\u0002\u0010'\u001a\u00020\u00072\b\b\u0002\u0010(\u001a\u00020\u00072\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010+2\b\b\u0002\u0010,\u001a\u00020#2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u00100\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u00020\u00072\b\b\u0002\u00102\u001a\u00020\u00072\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0003\u0010\u009c\u0001J\u0016\u0010\u009d\u0001\u001a\u00020#2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001HÖ\u0003J\n\u0010 \u0001\u001a\u00020\u0007HÖ\u0001J\n\u0010¡\u0001\u001a\u00020\u0004HÖ\u0001J-\u0010¢\u0001\u001a\u00030£\u00012\u0007\u0010¤\u0001\u001a\u00020\u00002\b\u0010¥\u0001\u001a\u00030¦\u00012\b\u0010§\u0001\u001a\u00030¨\u0001H\u0001¢\u0006\u0003\b©\u0001R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b;\u0010<R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b=\u0010<R\u0018\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b>\u0010<R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b?\u0010<R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b@\u0010<R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bA\u0010<R\u0018\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bB\u0010<R\u0018\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bC\u0010<R\u0018\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bD\u0010<R\u0018\u0010\u0010\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bE\u0010<R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bF\u0010<R\u0018\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bG\u0010<R\u0018\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bH\u0010<R\u0018\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bI\u0010<R\u0018\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bJ\u0010<R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bK\u0010<R\u0018\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bL\u0010<R\u0018\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bM\u0010<R\u0018\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bN\u0010<R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bO\u0010<R \u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bP\u0010<R\u0018\u0010\u001f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bQ\u0010<R\u0018\u0010 \u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bR\u0010<R\u0018\u0010!\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bS\u0010<R\u0018\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bT\u0010<R\u0018\u0010$\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bU\u0010<R \u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bV\u0010<R\u0018\u0010'\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bW\u0010<R\u0018\u0010(\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bX\u0010<R\u001a\u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bY\u0010<R&\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bZ\u0010<R\u0018\u0010,\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b[\u0010<R\u001a\u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\\\u0010<R&\u0010.\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b]\u0010<\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR(\u0010/\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010g\u0012\u0004\bb\u0010<\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u00100\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bh\u0010<\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u00101\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bm\u0010<\u001a\u0004\bn\u0010j\"\u0004\bo\u0010lR\u001c\u00102\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bp\u0010<\u001a\u0004\bq\u0010jR\u001e\u00103\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\br\u0010<\u001a\u0004\bs\u0010_¨\u0006¬\u0001"}, d2 = {"Lcom/larus/im/internal/protocol/bean/ConversationInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationId", "", "localConversationId", "conversationType", "", "creatorId", "name", "image", "Lcom/larus/im/internal/protocol/bean/Image;", "participantCount", "", "humanCount", "tenantId", "bizId", "bizModel", "status", "version", "createTime", UserInfo.UPDATE_TIME, "extra", "pinnedTime", "msgCursor", "botType", "conversationPage", "Lcom/larus/im/internal/protocol/bean/ConversationPage;", "firstPageParticipantList", "", "Lcom/larus/im/internal/protocol/bean/Participant;", "retentionCursor", "lastReadIndex", "latestIndex", "conversationNameAuditing", "", "isDeleted", "msgTemplates", "Lcom/larus/im/internal/protocol/bean/MsgTemplate;", "botConversationContentType", "contentDistType", "defaultOnboarding", "traceMap", "", "callerNameSetting", "callerName", "sectionId", "inputLeftActionStyle", "groupReviewStatus", "createScene", "createChannel", "parentCellId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/protocol/bean/Image;JJJJLjava/lang/String;IJJJLjava/lang/String;JJILcom/larus/im/internal/protocol/bean/ConversationPage;Ljava/util/List;JJJZZLjava/util/List;IILjava/lang/String;Ljava/util/Map;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IIILjava/lang/String;)V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/protocol/bean/Image;JJJJLjava/lang/String;IJJJLjava/lang/String;JJILcom/larus/im/internal/protocol/bean/ConversationPage;Ljava/util/List;JJJZZLjava/util/List;IILjava/lang/String;Ljava/util/Map;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IIILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId$annotations", "()V", "getLocalConversationId$annotations", "getConversationType$annotations", "getCreatorId$annotations", "getName$annotations", "getImage$annotations", "getParticipantCount$annotations", "getHumanCount$annotations", "getTenantId$annotations", "getBizId$annotations", "getBizModel$annotations", "getStatus$annotations", "getVersion$annotations", "getCreateTime$annotations", "getUpdateTime$annotations", "getExtra$annotations", "getPinnedTime$annotations", "getMsgCursor$annotations", "getBotType$annotations", "getConversationPage$annotations", "getFirstPageParticipantList$annotations", "getRetentionCursor$annotations", "getLastReadIndex$annotations", "getLatestIndex$annotations", "getConversationNameAuditing$annotations", "isDeleted$annotations", "getMsgTemplates$annotations", "getBotConversationContentType$annotations", "getContentDistType$annotations", "getDefaultOnboarding$annotations", "getTraceMap$annotations", "getCallerNameSetting$annotations", "getCallerName$annotations", "getSectionId$annotations", "getSectionId", "()Ljava/lang/String;", "setSectionId", "(Ljava/lang/String;)V", "getInputLeftActionStyle$annotations", "getInputLeftActionStyle", "()Ljava/lang/Integer;", "setInputLeftActionStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGroupReviewStatus$annotations", "getGroupReviewStatus", "()I", "setGroupReviewStatus", "(I)V", "getCreateScene$annotations", "getCreateScene", "setCreateScene", "getCreateChannel$annotations", "getCreateChannel", "getParentCellId$annotations", "getParentCellId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/protocol/bean/Image;JJJJLjava/lang/String;IJJJLjava/lang/String;JJILcom/larus/im/internal/protocol/bean/ConversationPage;Ljava/util/List;JJJZZLjava/util/List;IILjava/lang/String;Ljava/util/Map;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IIILjava/lang/String;)Lcom/larus/im/internal/protocol/bean/ConversationInfo;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ConversationInfo implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public long bizId;
    public String bizModel;
    public int botConversationContentType;
    public int botType;
    public String callerName;
    public boolean callerNameSetting;
    public int contentDistType;
    public String conversationId;
    public boolean conversationNameAuditing;
    public ConversationPage conversationPage;
    public int conversationType;
    private final int createChannel;
    private int createScene;
    public long createTime;
    public String creatorId;
    public String defaultOnboarding;
    public String extra;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public List<Participant> firstPageParticipantList;
    private int groupReviewStatus;
    public long humanCount;
    public Image image;
    private Integer inputLeftActionStyle;
    public boolean isDeleted;
    public long lastReadIndex;
    public long latestIndex;
    public String localConversationId;
    public long msgCursor;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public List<MsgTemplate> msgTemplates;
    public String name;
    private final String parentCellId;
    public long participantCount;
    public long pinnedTime;
    public long retentionCursor;
    private String sectionId;
    public int status;
    public long tenantId;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public Map<String, String> traceMap;
    public long updateTime;
    public long version;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ConversationInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f349613a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f349614b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f349614b;
        }

        static {
            a r100 = new a();
            f349613a = r100;
            g2 r101 = new g2("com.larus.im.internal.protocol.bean.ConversationInfo", r100, 39);
            r101.j("conversation_id", true);
            r101.j("local_conversation_id", true);
            r101.j("conversation_type", true);
            r101.j("creator_id", true);
            r101.j("name", true);
            r101.j("image", true);
            r101.j("participant_count", true);
            r101.j("human_count", true);
            r101.j("tenant_id", true);
            r101.j(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, true);
            r101.j("biz_model", true);
            r101.j("status", true);
            r101.j("version", true);
            r101.j("create_time", true);
            r101.j("update_time", true);
            r101.j("extra", true);
            r101.j("pinned_time", true);
            r101.j("msg_cursor", true);
            r101.j("bot_type", true);
            r101.j(CommentPublishScene.CONVERSATION_PAGE, true);
            r101.j("first_page_participant_list", true);
            r101.j("retention_cursor", true);
            r101.j("last_read_index", true);
            r101.j("latest_index", true);
            r101.j("conversation_name_auditing", true);
            r101.j("is_deleted", true);
            r101.j("msg_templates", true);
            r101.j("bot_conversation_content_type", true);
            r101.j("content_dist_type", true);
            r101.j("default_onboarding", true);
            r101.j("trace_map", true);
            r101.j("caller_name_setting", true);
            r101.j(Constant.KEY_CALL_NAME, true);
            r101.j("last_section_id", true);
            r101.j("input_left_button_style", true);
            r101.j("review_status", true);
            r101.j("create_scene", true);
            r101.j("create_channel", true);
            r101.j("related_cell_id", true);
            f349614b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = ConversationInfo.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            w0 r102 = w0.f520792a;
            g1 r103 = g1.f520681a;
            i r104 = i.f520705a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r101), r102, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(Image.a.f349647a), r103, r103, r103, r103, kuc.a.d(r101), r102, r103, r103, r103, kuc.a.d(r101), r103, r103, r102, kuc.a.d(ConversationPage.a.f349615a), kuc.a.d((d) r100[20].getValue()), r103, r103, r103, r104, r104, kuc.a.d((d) r100[26].getValue()), r102, r102, kuc.a.d(r101), kuc.a.d((d) r100[30].getValue()), r104, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r102), r102, r102, r102, kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r810) {
            Intrinsics.checkNotNullParameter(r810, "decoder");
            g2 r100 = f349614b;
            muc.c r101 = r810.beginStructure(r100);
            Lazy[] r102 = ConversationInfo.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            int r111 = r101.decodeIntElement(r100, 2);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 4, r103, null);
            Image r113 = (Image) r101.decodeNullableSerializableElement(r100, 5, Image.a.f349647a, null);
            long r210 = r101.decodeLongElement(r100, 6);
            long r106 = r101.decodeLongElement(r100, 7);
            long r211 = r101.decodeLongElement(r100, 8);
            long r310 = r101.decodeLongElement(r100, 9);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 10, r103, null);
            int r108 = r101.decodeIntElement(r100, 11);
            long r212 = r101.decodeLongElement(r100, 12);
            long r311 = r101.decodeLongElement(r100, 13);
            long r213 = r101.decodeLongElement(r100, 14);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 15, r103, null);
            long r115 = r101.decodeLongElement(r100, 16);
            long r312 = r101.decodeLongElement(r100, 17);
            int r116 = r101.decodeIntElement(r100, 18);
            ConversationPage r109 = (ConversationPage) r101.decodeNullableSerializableElement(r100, 19, ConversationPage.a.f349615a, null);
            List r117 = (List) r101.decodeNullableSerializableElement(r100, 20, (juc.c) r102[20].getValue(), null);
            long r118 = r101.decodeLongElement(r100, 21);
            long r313 = r101.decodeLongElement(r100, 22);
            long r410 = r101.decodeLongElement(r100, 23);
            boolean r119 = r101.decodeBooleanElement(r100, 24);
            boolean r120 = r101.decodeBooleanElement(r100, 25);
            List r121 = (List) r101.decodeNullableSerializableElement(r100, 26, (juc.c) r102[26].getValue(), null);
            int r122 = r101.decodeIntElement(r100, 27);
            int r123 = r101.decodeIntElement(r100, 28);
            String r124 = (String) r101.decodeNullableSerializableElement(r100, 29, r103, null);
            Map r125 = (Map) r101.decodeNullableSerializableElement(r100, 30, (juc.c) r102[30].getValue(), null);
            boolean r126 = r101.decodeBooleanElement(r100, 31);
            String r127 = (String) r101.decodeNullableSerializableElement(r100, 32, r103, null);
            String r128 = (String) r101.decodeNullableSerializableElement(r100, 33, r103, null);
            Integer r129 = (Integer) r101.decodeNullableSerializableElement(r100, 34, w0.f520792a, null);
            int r130 = r101.decodeIntElement(r100, 35);
            int r131 = r101.decodeIntElement(r100, 36);
            int r132 = r101.decodeIntElement(r100, 37);
            String r610 = r127;
            String r611 = (String) r101.decodeNullableSerializableElement(r100, 38, r103, null);
            int r612 = r130;
            int r510 = r123;
            Map r511 = r125;
            List r512 = r121;
            int r513 = r122;
            String r514 = r124;
            String r613 = r128;
            boolean r614 = r126;
            Integer r615 = r129;
            int r616 = r132;
            int r617 = r131;
            int r411 = r116;
            long r412 = r313;
            long r515 = r410;
            boolean r516 = r119;
            boolean r517 = r120;
            long r413 = r118;
            String r314 = r114;
            long r414 = r115;
            List r415 = r117;
            long r416 = r312;
            ConversationPage r417 = r109;
            int r133 = r111;
            String r214 = r112;
            long r315 = r213;
            long r316 = r311;
            int r134 = -1;
            String r215 = r105;
            int r317 = r108;
            Image r216 = r113;
            long r318 = r212;
            long r217 = r210;
            long r218 = r211;
            long r219 = r310;
            String r319 = r107;
            long r220 = r106;
            int r135 = 127;
            String r136 = r104;
            String r137 = r110;
        L73:
            r101.endStructure(r100);
            return new ConversationInfo(r134, r135, r137, r136, r133, r214, r215, r216, r217, r220, r218, r219, r319, r317, r318, r316, r315, r314, r414, r416, r411, r417, r415, r413, r412, r515, r516, r517, r512, r513, r510, r514, r511, r614, r610, r613, r615, r612, r617, r616, r611, null);
        L5:
            String r138 = null;
            String r139 = null;
            String r140 = null;
            Integer r141 = null;
            ConversationPage r142 = null;
            String r143 = null;
            List r144 = null;
            List r145 = null;
            String r146 = null;
            String r147 = null;
            Map r148 = null;
            String r418 = null;
            String r518 = null;
            Image r519 = null;
            String r520 = null;
            String r521 = null;
            long r320 = 0;
            long r522 = 0;
            long r523 = 0;
            long r618 = 0;
            long r619 = 0;
            long r620 = 0;
            long r621 = 0;
            long r622 = 0;
            long r710 = 0;
            long r711 = 0;
            long r712 = 0;
            int r149 = 0;
            int r150 = 0;
            boolean r221 = false;
            int r321 = 0;
            boolean r322 = false;
            int r323 = 0;
            int r324 = 0;
            int r325 = 0;
            int r326 = 0;
            int r419 = 0;
            int r524 = 0;
            int r525 = 0;
            boolean r526 = true;
            long r222 = 0;
            boolean r223 = false;
        L6:
            if (r526 == false) goto L72;
            String r713 = r146;
            int r151 = r101.decodeElementIndex(r100);
            switch(r151) {
                case -1: goto L69;
                case 0: goto L68;
                case 1: goto L65;
                case 2: goto L62;
                case 3: goto L61;
                case 4: goto L60;
                case 5: goto L59;
                case 6: goto L56;
                case 7: goto L53;
                case 8: goto L51;
                case 9: goto L50;
                case 10: goto L49;
                case 11: goto L46;
                case 12: goto L45;
                case 13: goto L43;
                case 14: goto L42;
                case 15: goto L41;
                case 16: goto L38;
                case 17: goto L35;
                case 18: goto L34;
                case 19: goto L33;
                case 20: goto L32;
                case 21: goto L31;
                case 22: goto L30;
                case 23: goto L29;
                case 24: goto L28;
                case 25: goto L27;
                case 26: goto L25;
                case 27: goto L24;
                case 28: goto L23;
                case 29: goto L22;
                case 30: goto L21;
                case 31: goto L20;
                case 32: goto L18;
                case 33: goto L16;
                case 34: goto L15;
                case 35: goto L14;
                case 36: goto L13;
                case 37: goto L12;
                case 38: goto L11;
                default: goto L10;
            };
        L11:
            r138 = (String) r101.decodeNullableSerializableElement(r100, 38, v2.f520790a, r138);
            int r152 = r150 | 64;
            Unit r153 = Unit.INSTANCE;
            r150 = r152;
        L40:
            r102 = r102;
            Map r224 = r148;
            r713 = r713;
            r139 = r139;
        L58:
            String r154 = r147;
            int r155 = r150;
            List r156 = r145;
            int r157 = r149;
            List r158 = r144;
            String r159 = r143;
            ConversationPage r160 = r142;
            Image r161 = r519;
        L64:
            int r162 = r157;
            r145 = r156;
            r150 = r155;
            r147 = r154;
            r148 = r224;
            r418 = r418;
            String r225 = r138;
        L66:
            int r163 = r162;
            String r164 = r139;
            String r165 = r713;
        L67:
            r519 = r161;
            r142 = r160;
            r143 = r159;
            r144 = r158;
            r713 = r165;
            r138 = r225;
            String r327 = r520;
            r149 = r163;
            r139 = r164;
        L71:
            r139 = r139;
            r102 = r102;
            r520 = r327;
            r418 = r418;
            r518 = r518;
            r519 = r519;
            r146 = r713;
            goto L6
        L12:
            int r166 = r101.decodeIntElement(r100, 37);
            r150 = r150 | 32;
            Unit r167 = Unit.INSTANCE;
            r419 = r166;
            goto L40
        L13:
            r321 = r101.decodeIntElement(r100, 36);
            int r168 = r150 | 16;
        L17:
            r150 = r168;
        L37:
            Unit r169 = Unit.INSTANCE;
            goto L40
        L14:
            r323 = r101.decodeIntElement(r100, 35);
            r168 = r150 | 8;
            goto L17
        L15:
            r141 = (Integer) r101.decodeNullableSerializableElement(r100, 34, w0.f520792a, r141);
            r168 = r150 | 4;
            goto L17
        L16:
            r143 = (String) r101.decodeNullableSerializableElement(r100, 33, v2.f520790a, r143);
            r168 = r150 | 2;
            goto L17
        L18:
            r139 = r139;
            r140 = (String) r101.decodeNullableSerializableElement(r100, 32, v2.f520790a, r140);
            r150 = r150 | 1;
            goto L37
        L20:
            r322 = r101.decodeBooleanElement(r100, 31);
            int r170 = Integer.MIN_VALUE;
        L36:
            r149 = r149 | r170;
            goto L37
        L21:
            r148 = (Map) r101.decodeNullableSerializableElement(r100, 30, (juc.c) r102[30].getValue(), r148);
            int r171 = 1073741824;
        L39:
            r149 = r149 | r171;
            Unit r172 = Unit.INSTANCE;
            goto L40
        L22:
            r147 = (String) r101.decodeNullableSerializableElement(r100, 29, v2.f520790a, r147);
            r170 = 536870912;
            goto L36
        L23:
            r325 = r101.decodeIntElement(r100, 28);
            r170 = 268435456;
            goto L36
        L24:
            r324 = r101.decodeIntElement(r100, 27);
            r170 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
            goto L36
        L25:
            r144 = (List) r101.decodeNullableSerializableElement(r100, 26, (juc.c) r102[26].getValue(), r144);
            r149 = r149 | 67108864;
            Unit r173 = Unit.INSTANCE;
            goto L40
        L27:
            r221 = r101.decodeBooleanElement(r100, 25);
            r171 = 33554432;
            goto L39
        L28:
            r223 = r101.decodeBooleanElement(r100, 24);
            r171 = 16777216;
            goto L39
        L29:
            r712 = r101.decodeLongElement(r100, 23);
            r171 = 8388608;
            goto L39
        L30:
            r711 = r101.decodeLongElement(r100, 22);
            r171 = 4194304;
            goto L39
        L31:
            r320 = r101.decodeLongElement(r100, 21);
            r171 = 2097152;
            goto L39
        L32:
            r145 = (List) r101.decodeNullableSerializableElement(r100, 20, (juc.c) r102[20].getValue(), r145);
            r170 = 1048576;
            goto L36
        L33:
            r142 = (ConversationPage) r101.decodeNullableSerializableElement(r100, 19, ConversationPage.a.f349615a, r142);
            r170 = 524288;
            goto L36
        L34:
            r524 = r101.decodeIntElement(r100, 18);
            r170 = 262144;
            goto L36
        L35:
            r710 = r101.decodeLongElement(r100, 17);
            r170 = 131072;
            goto L36
        L38:
            r522 = r101.decodeLongElement(r100, 16);
            r171 = 65536;
            goto L39
        L41:
            r102 = r102;
            String r174 = (String) r101.decodeNullableSerializableElement(r100, 15, v2.f520790a, r139);
            int r175 = r149 | 32768;
            Unit r176 = Unit.INSTANCE;
            r139 = r174;
        L48:
            r225 = r138;
            r163 = r175;
            r164 = r139;
            r418 = r418;
            r518 = r518;
            r165 = r713;
            r158 = r144;
            r159 = r143;
            r160 = r142;
            r161 = r519;
            goto L67
        L42:
            r523 = r101.decodeLongElement(r100, 14);
            r175 = r149 | 16384;
            Unit r226 = Unit.INSTANCE;
            goto L48
        L43:
            r622 = r101.decodeLongElement(r100, 13);
            r175 = r149 | 8192;
            Unit r227 = Unit.INSTANCE;
            goto L48
        L45:
            r618 = r101.decodeLongElement(r100, 12);
            r175 = r149 | 4096;
        L47:
            Unit r228 = Unit.INSTANCE;
            goto L48
        L46:
            r326 = r101.decodeIntElement(r100, 11);
            r175 = r149 | 2048;
            goto L47
        L49:
            r102 = r102;
            r139 = r139;
            r138 = r138;
            String r177 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, r713);
            int r178 = r149 | 1024;
            Unit r179 = Unit.INSTANCE;
            String r180 = r177;
        L55:
            String r811 = r180;
            r149 = r178;
            String r181 = r811;
        L57:
            r713 = r181;
            r138 = r138;
            r224 = r148;
            goto L58
        L50:
            r621 = r101.decodeLongElement(r100, 9);
            int r182 = r149 | 512;
            Unit r420 = Unit.INSTANCE;
        L54:
            int r812 = r182;
            r180 = r713;
            r178 = r812;
            goto L55
        L51:
            r620 = r101.decodeLongElement(r100, 8);
            r182 = r149 | 256;
            Unit r421 = Unit.INSTANCE;
            goto L54
        L53:
            r102 = r102;
            r138 = r138;
            r139 = r139;
            r713 = r713;
            r222 = r101.decodeLongElement(r100, 7);
            r182 = r149 | 128;
            Unit r422 = Unit.INSTANCE;
            goto L54
        L56:
            r102 = r102;
            r138 = r138;
            r139 = r139;
            r181 = r713;
            r619 = r101.decodeLongElement(r100, 6);
            r149 = r149 | 64;
            Unit r423 = Unit.INSTANCE;
            goto L57
        L59:
            r102 = r102;
            String r229 = r138;
            r139 = r139;
            r713 = r713;
            Image r183 = (Image) r101.decodeNullableSerializableElement(r100, 5, Image.a.f349647a, r519);
            Unit r184 = Unit.INSTANCE;
            r138 = r229;
            r518 = r518;
            r224 = r148;
            r154 = r147;
            r155 = r150;
            r156 = r145;
            r157 = r149 | 32;
            r158 = r144;
            r159 = r143;
            r160 = r142;
            r161 = r183;
            goto L64
        L60:
            Image r424 = r519;
            String r185 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r518);
            int r186 = r149 | 16;
            Unit r187 = Unit.INSTANCE;
            r518 = r185;
            int r188 = r186;
        L63:
            r138 = r138;
            r224 = r148;
            r154 = r147;
            r155 = r150;
            r156 = r145;
            r157 = r188;
            r158 = r144;
            r159 = r143;
            r160 = r142;
            r161 = r424;
            goto L64
        L61:
            r424 = r519;
            r518 = r518;
            String r189 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r418);
            int r190 = r149 | 8;
            Unit r191 = Unit.INSTANCE;
            r418 = r189;
            r188 = r190;
            goto L63
        L62:
            r518 = r518;
            r424 = r519;
            r525 = r101.decodeIntElement(r100, 2);
            r188 = r149 | 4;
            Unit r425 = Unit.INSTANCE;
            goto L63
        L65:
            r102 = r102;
            r225 = r138;
            r139 = r139;
            r518 = r518;
            r713 = r713;
            r418 = r418;
            String r192 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r520);
            r162 = r149 | 2;
            Unit r193 = Unit.INSTANCE;
            r520 = r192;
            r158 = r144;
            r159 = r143;
            r160 = r142;
            r161 = r519;
            goto L66
        L68:
            r327 = r520;
            r521 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r521);
            r149 = r149 | 1;
            Unit r194 = Unit.INSTANCE;
        L70:
            r138 = r138;
            goto L71
        L69:
            r327 = r520;
            Unit r195 = Unit.INSTANCE;
            r526 = false;
            goto L70
        L10:
            throw new UnknownFieldException(r151);
        L72:
            String r328 = r520;
            r137 = r521;
            r417 = r142;
            r512 = r144;
            r415 = r145;
            r135 = r150;
            r517 = r221;
            r513 = r324;
            r136 = r328;
            r214 = r418;
            r215 = r518;
            r216 = r519;
            r411 = r524;
            r133 = r525;
            r414 = r522;
            r217 = r619;
            r412 = r711;
            r515 = r712;
            r615 = r141;
            r314 = r139;
            r514 = r147;
            r516 = r223;
            r612 = r323;
            r510 = r325;
            r317 = r326;
            r315 = r523;
            r316 = r622;
            r511 = r148;
            r614 = r322;
            r319 = r146;
            r416 = r710;
            r134 = r149;
            long r813 = r618;
            r610 = r140;
            r613 = r143;
            long r814 = r621;
            r611 = r138;
            r220 = r222;
            r218 = r620;
            r617 = r321;
            r616 = r419;
            r219 = r814;
            r413 = r320;
            r318 = r813;
            goto L73
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ConversationInfo r102 = (ConversationInfo) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f349614b;
            muc.d r104 = r100.beginStructure(r103);
            ConversationInfo.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ConversationInfo> serializer() {
            return a.f349613a;
        }
    }

    public ConversationInfo() {
        this(null, null, 0, null, null, null, 0, 0, 0, 0, null, 0, 0, 0, 0, null, 0, 0, 0, null, null, 0, 0, 0, false, false, null, 0, 0, null, null, false, null, null, null, 0, 0, 0, null, -1, 127, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(Participant.a.f349692a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        return new nuc.f(MsgTemplate.a.f349678a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$1() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_$1();
    }

    public static /* synthetic */ d c() {
        return _childSerializers$_anonymous_$0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConversationInfo copy$default(ConversationInfo r110, String r111, String r112, int r210, String r211, String r212, Image r213, long r214, long r215, long r216, long r310, String r311, int r312, long r313, long r314, long r315, String r410, long r411, long r412, int r413, ConversationPage r414, List r415, long r416, long r510, long r511, boolean r512, boolean r513, List r514, int r515, int r516, String r517, Map r610, boolean r611, String r612, String r613, Integer r614, int r615, int r616, int r617, String r618, int r619, int r710, Object r711) {
        if ((r619 & 1) == 0) goto L5;
        String r100 = r110.conversationId;
    L7:
        if ((r619 & 2) == 0) goto L9;
        String r101 = r110.localConversationId;
    L11:
        if ((r619 & 4) == 0) goto L13;
        int r102 = r110.conversationType;
    L15:
        if ((r619 & 8) == 0) goto L17;
        String r103 = r110.creatorId;
    L19:
        if ((r619 & 16) == 0) goto L21;
        String r104 = r110.name;
    L23:
        if ((r619 & 32) == 0) goto L25;
        Image r105 = r110.image;
    L27:
        if ((r619 & 64) == 0) goto L29;
        long r106 = r110.participantCount;
    L31:
        if ((r619 & 128) == 0) goto L33;
        long r113 = r110.humanCount;
    L35:
        if ((r619 & 256) == 0) goto L37;
        long r114 = r110.tenantId;
    L39:
        if ((r619 & 512) == 0) goto L41;
        long r115 = r110.bizId;
    L42:
        long r316 = r115;
        if ((r619 & 1024) == 0) goto L45;
        String r116 = r110.bizModel;
    L47:
        if ((r619 & 2048) == 0) goto L49;
        int r117 = r110.status;
    L50:
        int r317 = r117;
        String r318 = r116;
        if ((r619 & 4096) == 0) goto L53;
        long r118 = r110.version;
    L54:
        long r319 = r118;
        if ((r619 & 8192) == 0) goto L57;
        long r119 = r110.createTime;
    L58:
        long r320 = r119;
        if ((r619 & 16384) == 0) goto L61;
        long r120 = r110.updateTime;
    L62:
        long r321 = r120;
        if ((r619 & 32768) == 0) goto L65;
        String r121 = r110.extra;
    L66:
        String r417 = r121;
        if ((65536 & r619) == 0) goto L69;
        long r122 = r110.pinnedTime;
    L70:
        long r418 = r122;
        if ((r619 & 131072) == 0) goto L73;
        long r123 = r110.msgCursor;
    L74:
        long r419 = r123;
        if ((r619 & 262144) == 0) goto L77;
        int r124 = r110.botType;
    L79:
        if ((524288 & r619) == 0) goto L81;
        ConversationPage r125 = r110.conversationPage;
    L82:
        ConversationPage r420 = r125;
        if ((r619 & 1048576) == 0) goto L85;
        List r126 = r110.firstPageParticipantList;
    L86:
        int r421 = r124;
        List r422 = r126;
        if ((r619 & 2097152) == 0) goto L89;
        long r127 = r110.retentionCursor;
    L90:
        long r423 = r127;
        if ((r619 & 4194304) == 0) goto L93;
        long r128 = r110.lastReadIndex;
    L94:
        long r518 = r128;
        if ((r619 & 8388608) == 0) goto L97;
        long r129 = r110.latestIndex;
    L98:
        long r519 = r129;
        if ((r619 & 16777216) == 0) goto L101;
        boolean r130 = r110.conversationNameAuditing;
    L103:
        if ((33554432 & r619) == 0) goto L105;
        boolean r131 = r110.isDeleted;
    L106:
        boolean r520 = r131;
        if ((r619 & 67108864) == 0) goto L109;
        List r132 = r110.msgTemplates;
    L110:
        List r521 = r132;
        if ((r619 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r133 = r110.botConversationContentType;
    L114:
        int r522 = r133;
        if ((r619 & 268435456) == 0) goto L117;
        int r134 = r110.contentDistType;
    L118:
        int r523 = r134;
        if ((r619 & 536870912) == 0) goto L121;
        String r135 = r110.defaultOnboarding;
    L122:
        String r524 = r135;
        if ((r619 & 1073741824) == 0) goto L125;
        Map r136 = r110.traceMap;
    L127:
        if ((r619 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r107 = r110.callerNameSetting;
    L130:
        boolean r620 = r107;
        if ((r710 & 1) == 0) goto L133;
        String r108 = r110.callerName;
    L134:
        String r621 = r108;
        if ((r710 & 2) == 0) goto L137;
        String r109 = r110.sectionId;
    L138:
        String r622 = r109;
        if ((r710 & 4) == 0) goto L141;
        Integer r137 = r110.inputLeftActionStyle;
    L142:
        Integer r623 = r137;
        if ((r710 & 8) == 0) goto L145;
        int r138 = r110.groupReviewStatus;
    L146:
        int r624 = r138;
        if ((r710 & 16) == 0) goto L149;
        int r139 = r110.createScene;
    L150:
        int r625 = r139;
        if ((r710 & 32) == 0) goto L153;
        int r140 = r110.createChannel;
    L154:
        int r626 = r140;
        if ((r710 & 64) == 0) goto L157;
        String r141 = r110.parentCellId;
    L159:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r316, r318, r317, r319, r320, r321, r417, r418, r419, r421, r420, r422, r423, r518, r519, r130, r520, r521, r522, r523, r524, r136, r620, r621, r622, r623, r624, r625, r626, r141);
    L157:
        r141 = r618;
        goto L159
    L153:
        r140 = r617;
        goto L154
    L149:
        r139 = r616;
        goto L150
    L145:
        r138 = r615;
        goto L146
    L141:
        r137 = r614;
        goto L142
    L137:
        r109 = r613;
        goto L138
    L133:
        r108 = r612;
        goto L134
    L129:
        r107 = r611;
        goto L130
    L125:
        r136 = r610;
        goto L127
    L121:
        r135 = r517;
        goto L122
    L117:
        r134 = r516;
        goto L118
    L113:
        r133 = r515;
        goto L114
    L109:
        r132 = r514;
        goto L110
    L105:
        r131 = r513;
        goto L106
    L101:
        r130 = r512;
        goto L103
    L97:
        r129 = r511;
        goto L98
    L93:
        r128 = r510;
        goto L94
    L89:
        r127 = r416;
        goto L90
    L85:
        r126 = r415;
        goto L86
    L81:
        r125 = r414;
        goto L82
    L77:
        r124 = r413;
        goto L79
    L73:
        r123 = r412;
        goto L74
    L69:
        r122 = r411;
        goto L70
    L65:
        r121 = r410;
        goto L66
    L61:
        r120 = r315;
        goto L62
    L57:
        r119 = r314;
        goto L58
    L53:
        r118 = r313;
        goto L54
    L49:
        r117 = r312;
        goto L50
    L45:
        r116 = r311;
        goto L47
    L41:
        r115 = r310;
        goto L42
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

    @SerialName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    public static /* synthetic */ void getBizId$annotations() {
    }

    @SerialName("biz_model")
    public static /* synthetic */ void getBizModel$annotations() {
    }

    @SerialName("bot_conversation_content_type")
    public static /* synthetic */ void getBotConversationContentType$annotations() {
    }

    @SerialName("bot_type")
    public static /* synthetic */ void getBotType$annotations() {
    }

    @SerialName(Constant.KEY_CALL_NAME)
    public static /* synthetic */ void getCallerName$annotations() {
    }

    @SerialName("caller_name_setting")
    public static /* synthetic */ void getCallerNameSetting$annotations() {
    }

    @SerialName("content_dist_type")
    public static /* synthetic */ void getContentDistType$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("conversation_name_auditing")
    public static /* synthetic */ void getConversationNameAuditing$annotations() {
    }

    @SerialName(CommentPublishScene.CONVERSATION_PAGE)
    public static /* synthetic */ void getConversationPage$annotations() {
    }

    @SerialName("conversation_type")
    public static /* synthetic */ void getConversationType$annotations() {
    }

    @SerialName("create_channel")
    public static /* synthetic */ void getCreateChannel$annotations() {
    }

    @SerialName("create_scene")
    public static /* synthetic */ void getCreateScene$annotations() {
    }

    @SerialName("create_time")
    public static /* synthetic */ void getCreateTime$annotations() {
    }

    @SerialName("creator_id")
    public static /* synthetic */ void getCreatorId$annotations() {
    }

    @SerialName("default_onboarding")
    public static /* synthetic */ void getDefaultOnboarding$annotations() {
    }

    @SerialName("extra")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName("first_page_participant_list")
    public static /* synthetic */ void getFirstPageParticipantList$annotations() {
    }

    @SerialName("review_status")
    public static /* synthetic */ void getGroupReviewStatus$annotations() {
    }

    @SerialName("human_count")
    public static /* synthetic */ void getHumanCount$annotations() {
    }

    @SerialName("image")
    public static /* synthetic */ void getImage$annotations() {
    }

    @SerialName("input_left_button_style")
    public static /* synthetic */ void getInputLeftActionStyle$annotations() {
    }

    @SerialName("last_read_index")
    public static /* synthetic */ void getLastReadIndex$annotations() {
    }

    @SerialName("latest_index")
    public static /* synthetic */ void getLatestIndex$annotations() {
    }

    @SerialName("local_conversation_id")
    public static /* synthetic */ void getLocalConversationId$annotations() {
    }

    @SerialName("msg_cursor")
    public static /* synthetic */ void getMsgCursor$annotations() {
    }

    @SerialName("msg_templates")
    public static /* synthetic */ void getMsgTemplates$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("related_cell_id")
    public static /* synthetic */ void getParentCellId$annotations() {
    }

    @SerialName("participant_count")
    public static /* synthetic */ void getParticipantCount$annotations() {
    }

    @SerialName("pinned_time")
    public static /* synthetic */ void getPinnedTime$annotations() {
    }

    @SerialName("retention_cursor")
    public static /* synthetic */ void getRetentionCursor$annotations() {
    }

    @SerialName("last_section_id")
    public static /* synthetic */ void getSectionId$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("tenant_id")
    public static /* synthetic */ void getTenantId$annotations() {
    }

    @SerialName("trace_map")
    public static /* synthetic */ void getTraceMap$annotations() {
    }

    @SerialName("update_time")
    public static /* synthetic */ void getUpdateTime$annotations() {
    }

    @SerialName("version")
    public static /* synthetic */ void getVersion$annotations() {
    }

    @SerialName("is_deleted")
    public static /* synthetic */ void isDeleted$annotations() {
    }

    public final String component1() {
        return this.conversationId;
    }

    public final long component10() {
        return this.bizId;
    }

    public final String component11() {
        return this.bizModel;
    }

    public final int component12() {
        return this.status;
    }

    public final long component13() {
        return this.version;
    }

    public final long component14() {
        return this.createTime;
    }

    public final long component15() {
        return this.updateTime;
    }

    public final String component16() {
        return this.extra;
    }

    public final long component17() {
        return this.pinnedTime;
    }

    public final long component18() {
        return this.msgCursor;
    }

    public final int component19() {
        return this.botType;
    }

    public final String component2() {
        return this.localConversationId;
    }

    public final ConversationPage component20() {
        return this.conversationPage;
    }

    public final List<Participant> component21() {
        return this.firstPageParticipantList;
    }

    public final long component22() {
        return this.retentionCursor;
    }

    public final long component23() {
        return this.lastReadIndex;
    }

    public final long component24() {
        return this.latestIndex;
    }

    public final boolean component25() {
        return this.conversationNameAuditing;
    }

    public final boolean component26() {
        return this.isDeleted;
    }

    public final List<MsgTemplate> component27() {
        return this.msgTemplates;
    }

    public final int component28() {
        return this.botConversationContentType;
    }

    public final int component29() {
        return this.contentDistType;
    }

    public final int component3() {
        return this.conversationType;
    }

    public final String component30() {
        return this.defaultOnboarding;
    }

    public final Map<String, String> component31() {
        return this.traceMap;
    }

    public final boolean component32() {
        return this.callerNameSetting;
    }

    public final String component33() {
        return this.callerName;
    }

    public final String component34() {
        return this.sectionId;
    }

    public final Integer component35() {
        return this.inputLeftActionStyle;
    }

    public final int component36() {
        return this.groupReviewStatus;
    }

    public final int component37() {
        return this.createScene;
    }

    public final int component38() {
        return this.createChannel;
    }

    public final String component39() {
        return this.parentCellId;
    }

    public final String component4() {
        return this.creatorId;
    }

    public final String component5() {
        return this.name;
    }

    public final Image component6() {
        return this.image;
    }

    public final long component7() {
        return this.participantCount;
    }

    public final long component8() {
        return this.humanCount;
    }

    public final long component9() {
        return this.tenantId;
    }

    public final ConversationInfo copy(String r510, String r511, int r512, String r513, String r514, Image r515, long r610, long r611, long r612, long r613, String r614, int r615, long r710, long r711, long r712, String r713, long r714, long r715, int r810, ConversationPage r811, List<Participant> r812, long r813, long r814, long r815, boolean r910, boolean r911, List<MsgTemplate> r912, int r913, int r914, String r915, Map<String, String> r916, boolean r917, String r918, String r919, Integer r100, int r101, int r102, int r103, String r104) {
        return new ConversationInfo(r510, r511, r512, r513, r514, r515, r610, r611, r612, r613, r614, r615, r710, r711, r712, r713, r714, r715, r810, r811, r812, r813, r814, r815, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100, r101, r102, r103, r104);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConversationInfo) == true) goto L8;
        return false;
    L8:
        ConversationInfo r101 = (ConversationInfo) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.localConversationId, r101.localConversationId) == true) goto L15;
        return false;
    L15:
        if (this.conversationType == r101.conversationType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.creatorId, r101.creatorId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L27;
        return false;
    L27:
        if (this.participantCount == r101.participantCount) goto L30;
        return false;
    L30:
        if (this.humanCount == r101.humanCount) goto L33;
        return false;
    L33:
        if (this.tenantId == r101.tenantId) goto L36;
        return false;
    L36:
        if (this.bizId == r101.bizId) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.bizModel, r101.bizModel) == true) goto L42;
        return false;
    L42:
        if (this.status == r101.status) goto L45;
        return false;
    L45:
        if (this.version == r101.version) goto L48;
        return false;
    L48:
        if (this.createTime == r101.createTime) goto L51;
        return false;
    L51:
        if (this.updateTime == r101.updateTime) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L57;
        return false;
    L57:
        if (this.pinnedTime == r101.pinnedTime) goto L60;
        return false;
    L60:
        if (this.msgCursor == r101.msgCursor) goto L63;
        return false;
    L63:
        if (this.botType == r101.botType) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.conversationPage, r101.conversationPage) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.firstPageParticipantList, r101.firstPageParticipantList) == true) goto L72;
        return false;
    L72:
        if (this.retentionCursor == r101.retentionCursor) goto L75;
        return false;
    L75:
        if (this.lastReadIndex == r101.lastReadIndex) goto L78;
        return false;
    L78:
        if (this.latestIndex == r101.latestIndex) goto L81;
        return false;
    L81:
        if (this.conversationNameAuditing == r101.conversationNameAuditing) goto L84;
        return false;
    L84:
        if (this.isDeleted == r101.isDeleted) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.msgTemplates, r101.msgTemplates) == true) goto L90;
        return false;
    L90:
        if (this.botConversationContentType == r101.botConversationContentType) goto L93;
        return false;
    L93:
        if (this.contentDistType == r101.contentDistType) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.defaultOnboarding, r101.defaultOnboarding) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.traceMap, r101.traceMap) == true) goto L102;
        return false;
    L102:
        if (this.callerNameSetting == r101.callerNameSetting) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.callerName, r101.callerName) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.sectionId, r101.sectionId) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.inputLeftActionStyle, r101.inputLeftActionStyle) == true) goto L114;
        return false;
    L114:
        if (this.groupReviewStatus == r101.groupReviewStatus) goto L117;
        return false;
    L117:
        if (this.createScene == r101.createScene) goto L120;
        return false;
    L120:
        if (this.createChannel == r101.createChannel) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.parentCellId, r101.parentCellId) == true) goto L125;
        return false;
    L125:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.localConversationId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.conversationType) * 31;
        String r107 = this.creatorId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.name;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Image r113 = this.image;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        long r116 = this.participantCount;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.humanCount;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = this.tenantId;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = this.bizId;
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        String r124 = this.bizModel;
        if (r124 != null) goto L25;
        int r125 = 0;
    L26:
        int r126 = (((r123 + r125) * 31) + this.status) * 31;
        long r127 = this.version;
        int r128 = (r126 + ((int) (r127 ^ (r127 >>> 32)))) * 31;
        long r129 = this.createTime;
        int r130 = (r128 + ((int) (r129 ^ (r129 >>> 32)))) * 31;
        long r131 = this.updateTime;
        int r132 = (r130 + ((int) (r131 ^ (r131 >>> 32)))) * 31;
        String r133 = this.extra;
        if (r133 != null) goto L29;
        int r134 = 0;
    L30:
        int r135 = (r132 + r134) * 31;
        long r136 = this.pinnedTime;
        int r137 = (r135 + ((int) (r136 ^ (r136 >>> 32)))) * 31;
        long r138 = this.msgCursor;
        int r139 = (((r137 + ((int) (r138 ^ (r138 >>> 32)))) * 31) + this.botType) * 31;
        ConversationPage r140 = this.conversationPage;
        if (r140 != null) goto L33;
        int r141 = 0;
    L34:
        int r142 = (r139 + r141) * 31;
        List<Participant> r143 = this.firstPageParticipantList;
        if (r143 != null) goto L37;
        int r144 = 0;
    L38:
        int r145 = (r142 + r144) * 31;
        long r146 = this.retentionCursor;
        int r147 = (r145 + ((int) (r146 ^ (r146 >>> 32)))) * 31;
        long r148 = this.lastReadIndex;
        int r149 = (r147 + ((int) (r148 ^ (r148 >>> 32)))) * 31;
        long r150 = this.latestIndex;
        int r151 = (r149 + ((int) (r150 ^ (r150 >>> 32)))) * 31;
        int r152 = 1231;
        if (this.conversationNameAuditing == false) goto L41;
        int r153 = 1231;
    L42:
        int r154 = (r151 + r153) * 31;
        if (this.isDeleted == false) goto L45;
        int r155 = 1231;
    L46:
        int r156 = (r154 + r155) * 31;
        List<MsgTemplate> r157 = this.msgTemplates;
        if (r157 != null) goto L49;
        int r158 = 0;
    L50:
        int r159 = (((((r156 + r158) * 31) + this.botConversationContentType) * 31) + this.contentDistType) * 31;
        String r160 = this.defaultOnboarding;
        if (r160 != null) goto L53;
        int r161 = 0;
    L54:
        int r162 = (r159 + r161) * 31;
        Map<String, String> r163 = this.traceMap;
        if (r163 != null) goto L57;
        int r164 = 0;
    L58:
        int r165 = (r162 + r164) * 31;
        if (this.callerNameSetting == true) goto L62;
        r152 = 1237;
    L62:
        int r166 = (r165 + r152) * 31;
        String r167 = this.callerName;
        if (r167 != null) goto L65;
        int r168 = 0;
    L66:
        int r169 = (r166 + r168) * 31;
        String r170 = this.sectionId;
        if (r170 != null) goto L69;
        int r171 = 0;
    L70:
        int r172 = (r169 + r171) * 31;
        Integer r173 = this.inputLeftActionStyle;
        if (r173 != null) goto L73;
        int r174 = 0;
    L74:
        int r175 = (((((((r172 + r174) * 31) + this.groupReviewStatus) * 31) + this.createScene) * 31) + this.createChannel) * 31;
        String r176 = this.parentCellId;
        if (r176 == null) goto L79;
        r101 = r176.hashCode();
    L79:
        return r175 + r101;
    L73:
        r174 = r173.hashCode();
        goto L74
    L69:
        r171 = r170.hashCode();
        goto L70
    L65:
        r168 = r167.hashCode();
        goto L66
    L57:
        r164 = r163.hashCode();
        goto L58
    L53:
        r161 = r160.hashCode();
        goto L54
    L49:
        r158 = r157.hashCode();
        goto L50
    L45:
        r155 = 1237;
        goto L46
    L41:
        r153 = 1237;
        goto L42
    L37:
        r144 = r143.hashCode();
        goto L38
    L33:
        r141 = r140.hashCode();
        goto L34
    L29:
        r134 = r133.hashCode();
        goto L30
    L25:
        r125 = r124.hashCode();
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
        return "ConversationInfo(conversationId=" + this.conversationId + ", localConversationId=" + this.localConversationId + ", conversationType=" + this.conversationType + ", creatorId=" + this.creatorId + ", name=" + this.name + ", image=" + this.image + ", participantCount=" + this.participantCount + ", humanCount=" + this.humanCount + ", tenantId=" + this.tenantId + ", bizId=" + this.bizId + ", bizModel=" + this.bizModel + ", status=" + this.status + ", version=" + this.version + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", extra=" + this.extra + ", pinnedTime=" + this.pinnedTime + ", msgCursor=" + this.msgCursor + ", botType=" + this.botType + ", conversationPage=" + this.conversationPage + ", firstPageParticipantList=" + this.firstPageParticipantList + ", retentionCursor=" + this.retentionCursor + ", lastReadIndex=" + this.lastReadIndex + ", latestIndex=" + this.latestIndex + ", conversationNameAuditing=" + this.conversationNameAuditing + ", isDeleted=" + this.isDeleted + ", msgTemplates=" + this.msgTemplates + ", botConversationContentType=" + this.botConversationContentType + ", contentDistType=" + this.contentDistType + ", defaultOnboarding=" + this.defaultOnboarding + ", traceMap=" + this.traceMap + ", callerNameSetting=" + this.callerNameSetting + ", callerName=" + this.callerName + ", sectionId=" + this.sectionId + ", inputLeftActionStyle=" + this.inputLeftActionStyle + ", groupReviewStatus=" + this.groupReviewStatus + ", createScene=" + this.createScene + ", createChannel=" + this.createChannel + ", parentCellId=" + this.parentCellId + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(r100, new r()), null, null, null, null, null, LazyKt.lazy(r100, new s()), null, null, null, LazyKt.lazy(r100, new t()), null, null, null, null, null, null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final int getCreateChannel() {
        return this.createChannel;
    }

    public final int getCreateScene() {
        return this.createScene;
    }

    public final int getGroupReviewStatus() {
        return this.groupReviewStatus;
    }

    public final Integer getInputLeftActionStyle() {
        return this.inputLeftActionStyle;
    }

    public final String getParentCellId() {
        return this.parentCellId;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final void setCreateScene(int r100) {
        this.createScene = r100;
    }

    public final void setGroupReviewStatus(int r100) {
        this.groupReviewStatus = r100;
    }

    public final void setInputLeftActionStyle(Integer r100) {
        this.inputLeftActionStyle = r100;
    }

    public final void setSectionId(String r100) {
        this.sectionId = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(ConversationInfo r100, muc.d r110, f r111) {
        Lazy<d<Object>>[] r101 = $childSerializers;
        boolean r102 = false;
        if (r110.shouldEncodeElementDefault(r111, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r110.encodeNullableSerializableElement(r111, 0, v2.f520790a, r100.conversationId);
    L12:
        if (r110.shouldEncodeElementDefault(r111, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r110.encodeNullableSerializableElement(r111, 1, v2.f520790a, r100.localConversationId);
    L21:
        if (r110.shouldEncodeElementDefault(r111, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r110.encodeIntElement(r111, 2, r100.conversationType);
    L30:
        if (r110.shouldEncodeElementDefault(r111, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r110.encodeNullableSerializableElement(r111, 3, v2.f520790a, r100.creatorId);
    L39:
        if (r110.shouldEncodeElementDefault(r111, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r110.encodeNullableSerializableElement(r111, 4, v2.f520790a, r100.name);
    L48:
        if (r110.shouldEncodeElementDefault(r111, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r110.encodeNullableSerializableElement(r111, 5, Image.a.f349647a, r100.image);
    L57:
        if (r110.shouldEncodeElementDefault(r111, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r110.encodeLongElement(r111, 6, r100.participantCount);
    L66:
        if (r110.shouldEncodeElementDefault(r111, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r110.encodeLongElement(r111, 7, r100.humanCount);
    L75:
        if (r110.shouldEncodeElementDefault(r111, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r110.encodeLongElement(r111, 8, r100.tenantId);
    L84:
        if (r110.shouldEncodeElementDefault(r111, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r110.encodeLongElement(r111, 9, r100.bizId);
    L93:
        if (r110.shouldEncodeElementDefault(r111, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r110.encodeNullableSerializableElement(r111, 10, v2.f520790a, r100.bizModel);
    L102:
        if (r110.shouldEncodeElementDefault(r111, 11) == false) goto L105;
    L103:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r110.encodeIntElement(r111, 11, r100.status);
    L111:
        if (r110.shouldEncodeElementDefault(r111, 12) == false) goto L114;
    L112:
        boolean r117 = true;
    L117:
        if (r117 == false) goto L120;
        r110.encodeLongElement(r111, 12, r100.version);
    L120:
        if (r110.shouldEncodeElementDefault(r111, 13) == false) goto L123;
    L121:
        boolean r118 = true;
    L126:
        if (r118 == false) goto L129;
        r110.encodeLongElement(r111, 13, r100.createTime);
    L129:
        if (r110.shouldEncodeElementDefault(r111, 14) == false) goto L132;
    L130:
        boolean r119 = true;
    L135:
        if (r119 == false) goto L138;
        r110.encodeLongElement(r111, 14, r100.updateTime);
    L138:
        if (r110.shouldEncodeElementDefault(r111, 15) == false) goto L141;
    L139:
        boolean r120 = true;
    L144:
        if (r120 == false) goto L147;
        r110.encodeNullableSerializableElement(r111, 15, v2.f520790a, r100.extra);
    L147:
        if (r110.shouldEncodeElementDefault(r111, 16) == false) goto L150;
    L148:
        boolean r121 = true;
    L153:
        if (r121 == false) goto L156;
        r110.encodeLongElement(r111, 16, r100.pinnedTime);
    L156:
        if (r110.shouldEncodeElementDefault(r111, 17) == false) goto L159;
    L157:
        boolean r122 = true;
    L162:
        if (r122 == false) goto L165;
        r110.encodeLongElement(r111, 17, r100.msgCursor);
    L165:
        if (r110.shouldEncodeElementDefault(r111, 18) == false) goto L168;
    L166:
        boolean r123 = true;
    L171:
        if (r123 == false) goto L174;
        r110.encodeIntElement(r111, 18, r100.botType);
    L174:
        if (r110.shouldEncodeElementDefault(r111, 19) == false) goto L177;
    L175:
        boolean r124 = true;
    L180:
        if (r124 == false) goto L183;
        r110.encodeNullableSerializableElement(r111, 19, ConversationPage.a.f349615a, r100.conversationPage);
    L183:
        if (r110.shouldEncodeElementDefault(r111, 20) == false) goto L186;
    L184:
        boolean r125 = true;
    L189:
        if (r125 == false) goto L192;
        r110.encodeNullableSerializableElement(r111, 20, r101[20].getValue(), r100.firstPageParticipantList);
    L192:
        if (r110.shouldEncodeElementDefault(r111, 21) == false) goto L195;
    L193:
        boolean r126 = true;
    L198:
        if (r126 == false) goto L201;
        r110.encodeLongElement(r111, 21, r100.retentionCursor);
    L201:
        if (r110.shouldEncodeElementDefault(r111, 22) == false) goto L204;
    L202:
        boolean r127 = true;
    L207:
        if (r127 == false) goto L210;
        r110.encodeLongElement(r111, 22, r100.lastReadIndex);
    L210:
        if (r110.shouldEncodeElementDefault(r111, 23) == false) goto L213;
    L211:
        boolean r128 = true;
    L216:
        if (r128 == false) goto L219;
        r110.encodeLongElement(r111, 23, r100.latestIndex);
    L219:
        if (r110.shouldEncodeElementDefault(r111, 24) == false) goto L222;
    L220:
        boolean r129 = true;
    L225:
        if (r129 == false) goto L228;
        r110.encodeBooleanElement(r111, 24, r100.conversationNameAuditing);
    L228:
        if (r110.shouldEncodeElementDefault(r111, 25) == false) goto L231;
    L229:
        boolean r130 = true;
    L234:
        if (r130 == false) goto L237;
        r110.encodeBooleanElement(r111, 25, r100.isDeleted);
    L237:
        if (r110.shouldEncodeElementDefault(r111, 26) == false) goto L240;
    L238:
        boolean r131 = true;
    L243:
        if (r131 == false) goto L246;
        r110.encodeNullableSerializableElement(r111, 26, r101[26].getValue(), r100.msgTemplates);
    L246:
        if (r110.shouldEncodeElementDefault(r111, 27) == false) goto L249;
    L247:
        boolean r132 = true;
    L252:
        if (r132 == false) goto L255;
        r110.encodeIntElement(r111, 27, r100.botConversationContentType);
    L255:
        if (r110.shouldEncodeElementDefault(r111, 28) == false) goto L258;
    L256:
        boolean r133 = true;
    L261:
        if (r133 == false) goto L264;
        r110.encodeIntElement(r111, 28, r100.contentDistType);
    L264:
        if (r110.shouldEncodeElementDefault(r111, 29) == false) goto L267;
    L265:
        boolean r134 = true;
    L270:
        if (r134 == false) goto L273;
        r110.encodeNullableSerializableElement(r111, 29, v2.f520790a, r100.defaultOnboarding);
    L273:
        if (r110.shouldEncodeElementDefault(r111, 30) == false) goto L276;
    L274:
        boolean r135 = true;
    L279:
        if (r135 == false) goto L282;
        r110.encodeNullableSerializableElement(r111, 30, r101[30].getValue(), r100.traceMap);
    L282:
        if (r110.shouldEncodeElementDefault(r111, 31) == false) goto L285;
    L283:
        boolean r136 = true;
    L288:
        if (r136 == false) goto L291;
        r110.encodeBooleanElement(r111, 31, r100.callerNameSetting);
    L291:
        if (r110.shouldEncodeElementDefault(r111, 32) == false) goto L294;
    L292:
        boolean r137 = true;
    L297:
        if (r137 == false) goto L300;
        r110.encodeNullableSerializableElement(r111, 32, v2.f520790a, r100.callerName);
    L300:
        if (r110.shouldEncodeElementDefault(r111, 33) == false) goto L303;
    L301:
        boolean r138 = true;
    L306:
        if (r138 == false) goto L309;
        r110.encodeNullableSerializableElement(r111, 33, v2.f520790a, r100.sectionId);
    L309:
        if (r110.shouldEncodeElementDefault(r111, 34) == false) goto L312;
    L310:
        boolean r139 = true;
    L315:
        if (r139 == false) goto L318;
        r110.encodeNullableSerializableElement(r111, 34, w0.f520792a, r100.inputLeftActionStyle);
    L318:
        if (r110.shouldEncodeElementDefault(r111, 35) == false) goto L321;
    L319:
        boolean r140 = true;
    L324:
        if (r140 == false) goto L327;
        r110.encodeIntElement(r111, 35, r100.groupReviewStatus);
    L327:
        if (r110.shouldEncodeElementDefault(r111, 36) == false) goto L330;
    L328:
        boolean r141 = true;
    L333:
        if (r141 == false) goto L336;
        r110.encodeIntElement(r111, 36, r100.createScene);
    L336:
        if (r110.shouldEncodeElementDefault(r111, 37) == false) goto L339;
    L337:
        boolean r142 = true;
    L342:
        if (r142 == false) goto L345;
        r110.encodeIntElement(r111, 37, r100.createChannel);
    L345:
        if (r110.shouldEncodeElementDefault(r111, 38) == false) goto L348;
    L346:
        r102 = true;
    L350:
        if (r102 == false) goto L353;
        r110.encodeNullableSerializableElement(r111, 38, v2.f520790a, r100.parentCellId);
        return;
    L353:
        return;
    L348:
        if (Intrinsics.areEqual(r100.parentCellId, "") == true) goto L350;
    L339:
        if (r100.createChannel != 0) goto L337;
        r142 = false;
        goto L342
    L330:
        if (r100.createScene != 0) goto L328;
        r141 = false;
        goto L333
    L321:
        if (r100.groupReviewStatus != 0) goto L319;
        r140 = false;
        goto L324
    L312:
        if (r100.inputLeftActionStyle != null) goto L310;
        r139 = false;
        goto L315
    L303:
        if (Intrinsics.areEqual(r100.sectionId, "") == false) goto L301;
        r138 = false;
        goto L306
    L294:
        if (r100.callerName != null) goto L292;
        r137 = false;
        goto L297
    L285:
        if (r100.callerNameSetting == true) goto L283;
        r136 = false;
        goto L288
    L276:
        if (r100.traceMap != null) goto L274;
        r135 = false;
        goto L279
    L267:
        if (r100.defaultOnboarding != null) goto L265;
        r134 = false;
        goto L270
    L258:
        if (r100.contentDistType != 0) goto L256;
        r133 = false;
        goto L261
    L249:
        if (r100.botConversationContentType != 0) goto L247;
        r132 = false;
        goto L252
    L240:
        if (r100.msgTemplates != null) goto L238;
        r131 = false;
        goto L243
    L231:
        if (r100.isDeleted == true) goto L229;
        r130 = false;
        goto L234
    L222:
        if (r100.conversationNameAuditing == true) goto L220;
        r129 = false;
        goto L225
    L213:
        if (r100.latestIndex != 0) goto L211;
        r128 = false;
        goto L216
    L204:
        if (r100.lastReadIndex != 0) goto L202;
        r127 = false;
        goto L207
    L195:
        if (r100.retentionCursor != 0) goto L193;
        r126 = false;
        goto L198
    L186:
        if (r100.firstPageParticipantList != null) goto L184;
        r125 = false;
        goto L189
    L177:
        if (r100.conversationPage != null) goto L175;
        r124 = false;
        goto L180
    L168:
        if (r100.botType != 0) goto L166;
        r123 = false;
        goto L171
    L159:
        if (r100.msgCursor != 0) goto L157;
        r122 = false;
        goto L162
    L150:
        if (r100.pinnedTime != 0) goto L148;
        r121 = false;
        goto L153
    L141:
        if (r100.extra != null) goto L139;
        r120 = false;
        goto L144
    L132:
        if (r100.updateTime != 0) goto L130;
        r119 = false;
        goto L135
    L123:
        if (r100.createTime != 0) goto L121;
        r118 = false;
        goto L126
    L114:
        if (r100.version != 0) goto L112;
        r117 = false;
        goto L117
    L105:
        if (r100.status != 0) goto L103;
        r116 = false;
        goto L108
    L96:
        if (r100.bizModel != null) goto L94;
        r115 = false;
        goto L99
    L87:
        if (r100.bizId != 0) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.tenantId != 0) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.humanCount != 0) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.participantCount != 0) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.image != null) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.name != null) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.creatorId != null) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.conversationType != 0) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.localConversationId != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.conversationId != null) goto L4;
        r103 = false;
        goto L9
    }

    public ConversationInfo(String r100, String r101, int r102, String r103, String r104, Image r105, long r110, long r111, long r112, long r113, String r114, int r115, long r210, long r211, long r212, String r213, long r214, long r215, int r310, ConversationPage r311, List<Participant> r312, long r313, long r314, long r315, boolean r410, boolean r411, List<MsgTemplate> r412, int r413, int r414, String r415, Map<String, String> r416, boolean r417, String r418, String r419, Integer r510, int r511, int r512, int r513, String r514) {
        this.conversationId = r100;
        this.localConversationId = r101;
        this.conversationType = r102;
        this.creatorId = r103;
        this.name = r104;
        this.image = r105;
        this.participantCount = r110;
        this.humanCount = r111;
        this.tenantId = r112;
        this.bizId = r113;
        this.bizModel = r114;
        this.status = r115;
        this.version = r210;
        this.createTime = r211;
        this.updateTime = r212;
        this.extra = r213;
        this.pinnedTime = r214;
        this.msgCursor = r215;
        this.botType = r310;
        this.conversationPage = r311;
        this.firstPageParticipantList = r312;
        this.retentionCursor = r313;
        this.lastReadIndex = r314;
        this.latestIndex = r315;
        this.conversationNameAuditing = r410;
        this.isDeleted = r411;
        this.msgTemplates = r412;
        this.botConversationContentType = r413;
        this.contentDistType = r414;
        this.defaultOnboarding = r415;
        this.traceMap = r416;
        this.callerNameSetting = r417;
        this.callerName = r418;
        this.sectionId = r419;
        this.inputLeftActionStyle = r510;
        this.groupReviewStatus = r511;
        this.createScene = r512;
        this.createChannel = r513;
        this.parentCellId = r514;
    }

    public ConversationInfo(int r110, int r111, String r112, String r113, int r114, String r115, String r116, Image r117, long r118, long r210, long r211, long r212, String r213, int r214, long r215, long r310, long r311, String r312, long r313, long r314, int r410, ConversationPage r411, List r412, long r413, long r414, long r415, boolean r416, boolean r510, List r511, int r512, int r513, String r514, Map r515, boolean r516, String r517, String r518, Integer r519, int r610, int r611, int r612, String r613, q2 r614) {
        if ((r110 & 0) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r111 & 0) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r100 | r101) == false) goto L13;
        b2.a(new int[]{r110, r111}, new int[]{0, 0}, a.f349614b);
        throw null;
    L13:
        if ((r110 & 1) != 0) goto L15;
        this.conversationId = null;
    L17:
        if ((r110 & 2) != 0) goto L19;
        this.localConversationId = null;
    L21:
        if ((r110 & 4) != 0) goto L23;
        this.conversationType = 0;
    L25:
        if ((r110 & 8) != 0) goto L27;
        this.creatorId = null;
    L29:
        if ((r110 & 16) != 0) goto L31;
        this.name = null;
    L33:
        if ((r110 & 32) != 0) goto L35;
        this.image = null;
    L36:
        long r102 = 0;
        if ((r110 & 64) != 0) goto L39;
        this.participantCount = 0;
    L41:
        if ((r110 & 128) != 0) goto L43;
        this.humanCount = 0;
    L45:
        if ((r110 & 256) != 0) goto L47;
        this.tenantId = 0;
    L49:
        if ((r110 & 512) != 0) goto L51;
        this.bizId = 0;
    L53:
        if ((r110 & 1024) != 0) goto L55;
        this.bizModel = null;
    L57:
        if ((r110 & 2048) != 0) goto L59;
        this.status = 0;
    L61:
        if ((r110 & 4096) != 0) goto L63;
        this.version = 0;
    L65:
        if ((r110 & 8192) != 0) goto L67;
        this.createTime = 0;
    L69:
        if ((r110 & 16384) != 0) goto L71;
        this.updateTime = 0;
    L73:
        if ((32768 & r110) != 0) goto L75;
        this.extra = null;
    L77:
        if ((65536 & r110) != 0) goto L79;
        this.pinnedTime = 0;
    L81:
        if ((131072 & r110) != 0) goto L83;
        this.msgCursor = 0;
    L85:
        if ((262144 & r110) != 0) goto L87;
        this.botType = 0;
    L89:
        if ((524288 & r110) != 0) goto L91;
        this.conversationPage = null;
    L93:
        if ((1048576 & r110) != 0) goto L95;
        this.firstPageParticipantList = null;
    L97:
        if ((2097152 & r110) != 0) goto L99;
        this.retentionCursor = 0;
    L101:
        if ((4194304 & r110) != 0) goto L103;
        this.lastReadIndex = 0;
    L105:
        if ((8388608 & r110) == 0) goto L108;
        r102 = r415;
    L108:
        this.latestIndex = r102;
        if ((16777216 & r110) != 0) goto L111;
        this.conversationNameAuditing = false;
    L113:
        if ((33554432 & r110) != 0) goto L115;
        this.isDeleted = false;
    L117:
        if ((67108864 & r110) != 0) goto L119;
        this.msgTemplates = null;
    L121:
        if ((134217728 & r110) != 0) goto L123;
        this.botConversationContentType = 0;
    L125:
        if ((268435456 & r110) != 0) goto L127;
        this.contentDistType = 0;
    L129:
        if ((536870912 & r110) != 0) goto L131;
        this.defaultOnboarding = null;
    L133:
        if ((1073741824 & r110) != 0) goto L135;
        this.traceMap = null;
    L137:
        if ((r110 & Integer.MIN_VALUE) != 0) goto L139;
        this.callerNameSetting = false;
    L141:
        if ((r111 & 1) != 0) goto L143;
        this.callerName = null;
    L145:
        if ((r111 & 2) != 0) goto L147;
        this.sectionId = "";
    L149:
        if ((r111 & 4) != 0) goto L151;
        this.inputLeftActionStyle = null;
    L153:
        if ((r111 & 8) != 0) goto L155;
        this.groupReviewStatus = 0;
    L157:
        if ((r111 & 16) != 0) goto L159;
        this.createScene = 0;
    L161:
        if ((r111 & 32) != 0) goto L163;
        this.createChannel = 0;
    L165:
        if ((r111 & 64) != 0) goto L167;
        this.parentCellId = "";
        return;
    L167:
        this.parentCellId = r613;
        return;
    L163:
        this.createChannel = r612;
        goto L165
    L159:
        this.createScene = r611;
        goto L161
    L155:
        this.groupReviewStatus = r610;
        goto L157
    L151:
        this.inputLeftActionStyle = r519;
        goto L153
    L147:
        this.sectionId = r518;
        goto L149
    L143:
        this.callerName = r517;
        goto L145
    L139:
        this.callerNameSetting = r516;
        goto L141
    L135:
        this.traceMap = r515;
        goto L137
    L131:
        this.defaultOnboarding = r514;
        goto L133
    L127:
        this.contentDistType = r513;
        goto L129
    L123:
        this.botConversationContentType = r512;
        goto L125
    L119:
        this.msgTemplates = r511;
        goto L121
    L115:
        this.isDeleted = r510;
        goto L117
    L111:
        this.conversationNameAuditing = r416;
        goto L113
    L103:
        this.lastReadIndex = r414;
        goto L105
    L99:
        this.retentionCursor = r413;
        goto L101
    L95:
        this.firstPageParticipantList = r412;
        goto L97
    L91:
        this.conversationPage = r411;
        goto L93
    L87:
        this.botType = r410;
        goto L89
    L83:
        this.msgCursor = r314;
        goto L85
    L79:
        this.pinnedTime = r313;
        goto L81
    L75:
        this.extra = r312;
        goto L77
    L71:
        this.updateTime = r311;
        goto L73
    L67:
        this.createTime = r310;
        goto L69
    L63:
        this.version = r215;
        goto L65
    L59:
        this.status = r214;
        goto L61
    L55:
        this.bizModel = r213;
        goto L57
    L51:
        this.bizId = r212;
        goto L53
    L47:
        this.tenantId = r211;
        goto L49
    L43:
        this.humanCount = r210;
        goto L45
    L39:
        this.participantCount = r118;
        goto L41
    L35:
        this.image = r117;
        goto L36
    L31:
        this.name = r116;
        goto L33
    L27:
        this.creatorId = r115;
        goto L29
    L23:
        this.conversationType = r114;
        goto L25
    L19:
        this.localConversationId = r113;
        goto L21
    L15:
        this.conversationId = r112;
        goto L17
    L9:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public /* synthetic */ ConversationInfo(String r510, String r511, int r512, String r513, String r514, Image r515, long r516, long r610, long r611, long r612, String r613, int r614, long r615, long r710, long r711, String r712, long r713, long r714, int r810, ConversationPage r811, List r812, long r813, long r814, long r815, boolean r816, boolean r910, List r911, int r912, int r913, String r914, Map r915, boolean r916, String r917, String r918, Integer r919, int r100, int r101, int r102, String r103, int r104, int r105, DefaultConstructorMarker r106) {
        if ((r104 & 1) == 0) goto L5;
        String r107 = null;
    L7:
        if ((r104 & 2) == 0) goto L9;
        String r108 = null;
    L11:
        if ((r104 & 4) == 0) goto L13;
        int r109 = 0;
    L15:
        if ((r104 & 8) == 0) goto L17;
        String r110 = null;
    L19:
        if ((r104 & 16) == 0) goto L21;
        String r111 = null;
    L23:
        if ((r104 & 32) == 0) goto L25;
        Image r112 = null;
    L26:
        long r113 = 0;
        if ((r104 & 64) == 0) goto L29;
        long r114 = 0;
    L31:
        if ((r104 & 128) == 0) goto L33;
        long r115 = 0;
    L35:
        if ((r104 & 256) == 0) goto L37;
        long r116 = 0;
    L39:
        if ((r104 & 512) == 0) goto L41;
        long r117 = 0;
    L43:
        if ((r104 & 1024) == 0) goto L45;
        String r118 = null;
    L47:
        if ((r104 & 2048) == 0) goto L49;
        int r119 = 0;
    L51:
        if ((r104 & 4096) == 0) goto L53;
        long r210 = 0;
    L55:
        if ((r104 & 8192) == 0) goto L57;
        long r211 = 0;
    L59:
        if ((r104 & 16384) == 0) goto L61;
        long r212 = 0;
    L63:
        if ((32768 & r104) == 0) goto L65;
        String r120 = null;
    L67:
        if ((r104 & 65536) == 0) goto L69;
        long r213 = 0;
    L71:
        if ((r104 & 131072) == 0) goto L73;
        long r214 = 0;
    L75:
        if ((r104 & 262144) == 0) goto L77;
        int r310 = 0;
    L79:
        if ((r104 & 524288) == 0) goto L81;
        ConversationPage r311 = null;
    L83:
        if ((r104 & 1048576) == 0) goto L85;
        List r312 = null;
    L87:
        if ((r104 & 2097152) == 0) goto L89;
        long r313 = 0;
    L91:
        if ((r104 & 4194304) == 0) goto L93;
        long r314 = 0;
    L95:
        if ((r104 & 8388608) != 0) goto L99;
        r113 = r815;
    L99:
        if ((r104 & 16777216) == 0) goto L101;
        boolean r315 = false;
    L103:
        if ((r104 & 33554432) == 0) goto L105;
        boolean r316 = false;
    L107:
        if ((r104 & 67108864) == 0) goto L109;
        List r317 = null;
    L111:
        if ((r104 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r410 = 0;
    L115:
        if ((r104 & 268435456) == 0) goto L117;
        int r411 = 0;
    L119:
        if ((r104 & 536870912) == 0) goto L121;
        String r412 = null;
    L123:
        if ((r104 & 1073741824) == 0) goto L125;
        Map r413 = null;
    L127:
        if ((r104 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r121 = false;
    L131:
        if ((r105 & 1) == 0) goto L133;
        String r414 = null;
    L134:
        String r415 = "";
        if ((r105 & 2) == 0) goto L137;
        String r416 = "";
    L139:
        if ((r105 & 4) == 0) goto L141;
        Integer r417 = null;
    L143:
        if ((r105 & 8) == 0) goto L145;
        int r418 = 0;
    L147:
        if ((r105 & 16) == 0) goto L149;
        int r419 = 0;
    L151:
        if ((r105 & 32) == 0) goto L153;
        int r517 = 0;
    L155:
        if ((r105 & 64) != 0) goto L158;
        r415 = r103;
    L158:
        this(r107, r108, r109, r110, r111, r112, r114, r115, r116, r117, r118, r119, r210, r211, r212, r120, r213, r214, r310, r311, r312, r313, r314, r113, r315, r316, r317, r410, r411, r412, r413, r121, r414, r416, r417, r418, r419, r517, r415);
        return;
    L153:
        r517 = r102;
        goto L155
    L149:
        r419 = r101;
        goto L151
    L145:
        r418 = r100;
        goto L147
    L141:
        r417 = r919;
        goto L143
    L137:
        r416 = r918;
        goto L139
    L133:
        r414 = r917;
        goto L134
    L129:
        r121 = r916;
        goto L131
    L125:
        r413 = r915;
        goto L127
    L121:
        r412 = r914;
        goto L123
    L117:
        r411 = r913;
        goto L119
    L113:
        r410 = r912;
        goto L115
    L109:
        r317 = r911;
        goto L111
    L105:
        r316 = r910;
        goto L107
    L101:
        r315 = r816;
        goto L103
    L93:
        r314 = r814;
        goto L95
    L89:
        r313 = r813;
        goto L91
    L85:
        r312 = r812;
        goto L87
    L81:
        r311 = r811;
        goto L83
    L77:
        r310 = r810;
        goto L79
    L73:
        r214 = r714;
        goto L75
    L69:
        r213 = r713;
        goto L71
    L65:
        r120 = r712;
        goto L67
    L61:
        r212 = r711;
        goto L63
    L57:
        r211 = r710;
        goto L59
    L53:
        r210 = r615;
        goto L55
    L49:
        r119 = r614;
        goto L51
    L45:
        r118 = r613;
        goto L47
    L41:
        r117 = r612;
        goto L43
    L37:
        r116 = r611;
        goto L39
    L33:
        r115 = r610;
        goto L35
    L29:
        r114 = r516;
        goto L31
    L25:
        r112 = r515;
        goto L26
    L21:
        r111 = r514;
        goto L23
    L17:
        r110 = r513;
        goto L19
    L13:
        r109 = r512;
        goto L15
    L9:
        r108 = r511;
        goto L11
    L5:
        r107 = r510;
        goto L7
    }
}
