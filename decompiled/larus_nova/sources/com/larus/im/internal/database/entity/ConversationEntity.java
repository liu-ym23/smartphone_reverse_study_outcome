package com.larus.im.internal.database.entity;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.hihonor.honorid.core.data.UserInfo;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\\\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u0097\u00012\u00020\u0001:\u0004\u0097\u0001\u0098\u0001BÑ\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0014\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b-\u0010.B\t\b\u0016¢\u0006\u0004\b-\u0010/B¡\u0003\b\u0010\u0012\u0006\u00100\u001a\u00020\u0007\u0012\u0006\u00101\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010#\u001a\u00020\u0014\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\u00102\u001a\u0004\u0018\u000103¢\u0006\u0004\b-\u00104J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0007HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010>J\u0010\u0010i\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010>J\u0010\u0010j\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\t\u0010k\u001a\u00020\u000bHÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010>J\t\u0010p\u001a\u00020\u0014HÆ\u0003J\u0010\u0010q\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\u0010\u0010r\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\u0010\u0010s\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\u0010\u0010t\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010v\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010>J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010y\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010>J\u0010\u0010z\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010|\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010>J\u0010\u0010}\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010>J\u000b\u0010~\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0014HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\u0011\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÚ\u0003\u0010\u0089\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010#\u001a\u00020\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u008a\u0001J\u0015\u0010\u008b\u0001\u001a\u00020\u00142\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0007HÖ\u0001J\n\u0010\u008e\u0001\u001a\u00020\u0003HÖ\u0001J-\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u00002\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0001¢\u0006\u0003\b\u0096\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u00106R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u00106R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u00106R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u00106R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010?\u001a\u0004\b=\u0010>R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010?\u001a\u0004\b@\u0010>R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\b\u000f\u0010BR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u00106R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00106R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010?\u001a\u0004\bH\u0010>R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\bK\u0010BR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\bL\u0010BR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\bM\u0010BR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\bN\u0010BR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u00106R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010?\u001a\u0004\bP\u0010>R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u00106R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u00106R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010?\u001a\u0004\bS\u0010>R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\bT\u0010BR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u00106R\u0015\u0010 \u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010?\u001a\u0004\bV\u0010>R\u0015\u0010!\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010?\u001a\u0004\bW\u0010>R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bX\u00106R\u0011\u0010#\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b#\u0010JR\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bY\u00106R\u0015\u0010%\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\bZ\u0010BR\u0015\u0010&\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\b[\u0010BR\u0015\u0010'\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\b\\\u0010BR\u0015\u0010(\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\b]\u0010BR\u0015\u0010)\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\b^\u0010BR\u0013\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b_\u00106R\u0013\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u00106R\u0013\u0010,\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\ba\u00106¨\u0006\u0099\u0001"}, d2 = {"Lcom/larus/im/internal/database/entity/ConversationEntity;", "", "conversationId", "", "projectId", "deviceId", "botType", "", "iconImage", "name", "createTime", "", UserInfo.UPDATE_TIME, "pinned", "pinTime", "isLocal", "conversationPage", "templates", "messageCursor", "ttsEnable", "", "conversationType", "participantCount", "badgeCount", "readBadgeCount", "briefMessageLocalId", "readMessageIndex", "ext", "bizModel", "version", "status", "bizExtra", "retentionCursor", "latestMessageIndex", "ownerId", "isDeleted", "traceMap", "inputLeftActionStyle", "groupReviewStatus", "createScene", "cellType", "createChannel", "parentCellId", "lastSectionId", "botId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId", "()Ljava/lang/String;", "getProjectId", "getDeviceId", "getBotType", "()I", "getIconImage", "getName", "getCreateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUpdateTime", "getPinned", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPinTime", "()J", "getConversationPage", "getTemplates", "getMessageCursor", "getTtsEnable", "()Z", "getConversationType", "getParticipantCount", "getBadgeCount", "getReadBadgeCount", "getBriefMessageLocalId", "getReadMessageIndex", "getExt", "getBizModel", "getVersion", "getStatus", "getBizExtra", "getRetentionCursor", "getLatestMessageIndex", "getOwnerId", "getTraceMap", "getInputLeftActionStyle", "getGroupReviewStatus", "getCreateScene", "getCellType", "getCreateChannel", "getParentCellId", "getLastSectionId", "getBotId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/im/internal/database/entity/ConversationEntity;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "Companion", "$serializer", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ConversationEntity {
    public static final b Companion = null;
    public static final String DEFAULT_CONVERSATION_ID = "";
    private final Integer badgeCount;
    private final String bizExtra;
    private final String bizModel;
    private final String botId;
    private final int botType;
    private final String briefMessageLocalId;
    private final Integer cellType;
    private final String conversationId;
    private final String conversationPage;
    private final Integer conversationType;
    private final Integer createChannel;
    private final Integer createScene;
    private final Long createTime;
    private final String deviceId;
    private final String ext;
    private final Integer groupReviewStatus;
    private final String iconImage;
    private final Integer inputLeftActionStyle;
    private final boolean isDeleted;
    private final Integer isLocal;
    private final String lastSectionId;
    private final Long latestMessageIndex;
    private final Long messageCursor;
    private final String name;
    private final String ownerId;
    private final String parentCellId;
    private final Integer participantCount;
    private final long pinTime;
    private final Integer pinned;
    private final String projectId;
    private final Integer readBadgeCount;
    private final Long readMessageIndex;
    private final Long retentionCursor;
    private final Integer status;
    private final String templates;
    private final String traceMap;
    private final boolean ttsEnable;
    private final Long updateTime;
    private final Long version;

    /* JADX INFO: loaded from: classes29.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ConversationEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f348111a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f348112b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f348112b;
        }

        static {
            a r100 = new a();
            f348111a = r100;
            g2 r101 = new g2("com.larus.im.internal.database.entity.ConversationEntity", r100, 39);
            r101.j("conversationId", true);
            r101.j("projectId", true);
            r101.j("deviceId", true);
            r101.j("botType", true);
            r101.j("iconImage", true);
            r101.j("name", true);
            r101.j("createTime", true);
            r101.j(UserInfo.UPDATE_TIME, true);
            r101.j("pinned", true);
            r101.j("pinTime", true);
            r101.j("isLocal", true);
            r101.j("conversationPage", true);
            r101.j("templates", true);
            r101.j("messageCursor", true);
            r101.j("ttsEnable", true);
            r101.j("conversationType", true);
            r101.j("participantCount", true);
            r101.j("badgeCount", true);
            r101.j("readBadgeCount", true);
            r101.j("briefMessageLocalId", true);
            r101.j("readMessageIndex", true);
            r101.j("ext", true);
            r101.j("bizModel", true);
            r101.j("version", true);
            r101.j("status", true);
            r101.j("bizExtra", true);
            r101.j("retentionCursor", true);
            r101.j("latestMessageIndex", true);
            r101.j("ownerId", true);
            r101.j("isDeleted", true);
            r101.j("traceMap", true);
            r101.j("inputLeftActionStyle", true);
            r101.j("groupReviewStatus", true);
            r101.j("createScene", true);
            r101.j("cellType", true);
            r101.j("createChannel", true);
            r101.j("parentCellId", true);
            r101.j("lastSectionId", true);
            r101.j("botId", true);
            f348112b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            w0 r101 = w0.f520792a;
            g1 r102 = g1.f520681a;
            i r103 = i.f520705a;
            return new d[]{r100, kuc.a.d(r100), kuc.a.d(r100), r101, kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r101), r102, kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r102), r103, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r102), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r100), r103, kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r710) {
            Intrinsics.checkNotNullParameter(r710, "decoder");
            g2 r100 = f348112b;
            c r101 = r710.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            String r102 = r101.decodeStringElement(r100, 0);
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            int r111 = r101.decodeIntElement(r100, 3);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 4, r103, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 5, r103, null);
            g1 r113 = g1.f520681a;
            Long r106 = (Long) r101.decodeNullableSerializableElement(r100, 6, r113, null);
            Long r107 = (Long) r101.decodeNullableSerializableElement(r100, 7, r113, null);
            w0 r114 = w0.f520792a;
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 8, r114, null);
            long r210 = r101.decodeLongElement(r100, 9);
            Integer r109 = (Integer) r101.decodeNullableSerializableElement(r100, 10, r114, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 11, r103, null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 12, r103, null);
            Long r117 = (Long) r101.decodeNullableSerializableElement(r100, 13, r113, null);
            boolean r118 = r101.decodeBooleanElement(r100, 14);
            Integer r119 = (Integer) r101.decodeNullableSerializableElement(r100, 15, r114, null);
            Integer r120 = (Integer) r101.decodeNullableSerializableElement(r100, 16, r114, null);
            Integer r121 = (Integer) r101.decodeNullableSerializableElement(r100, 17, r114, null);
            Integer r122 = (Integer) r101.decodeNullableSerializableElement(r100, 18, r114, null);
            String r123 = (String) r101.decodeNullableSerializableElement(r100, 19, r103, null);
            Long r124 = (Long) r101.decodeNullableSerializableElement(r100, 20, r113, null);
            String r125 = (String) r101.decodeNullableSerializableElement(r100, 21, r103, null);
            String r126 = (String) r101.decodeNullableSerializableElement(r100, 22, r103, null);
            Long r127 = (Long) r101.decodeNullableSerializableElement(r100, 23, r113, null);
            Integer r128 = (Integer) r101.decodeNullableSerializableElement(r100, 24, r114, null);
            String r129 = (String) r101.decodeNullableSerializableElement(r100, 25, r103, null);
            Long r130 = (Long) r101.decodeNullableSerializableElement(r100, 26, r113, null);
            Long r131 = (Long) r101.decodeNullableSerializableElement(r100, 27, r113, null);
            String r132 = (String) r101.decodeNullableSerializableElement(r100, 28, r103, null);
            boolean r133 = r101.decodeBooleanElement(r100, 29);
            String r134 = (String) r101.decodeNullableSerializableElement(r100, 30, r103, null);
            Integer r135 = (Integer) r101.decodeNullableSerializableElement(r100, 31, r114, null);
            Integer r136 = (Integer) r101.decodeNullableSerializableElement(r100, 32, r114, null);
            Integer r137 = (Integer) r101.decodeNullableSerializableElement(r100, 33, r114, null);
            Integer r138 = (Integer) r101.decodeNullableSerializableElement(r100, 34, r114, null);
            Integer r139 = (Integer) r101.decodeNullableSerializableElement(r100, 35, r114, null);
            String r140 = (String) r101.decodeNullableSerializableElement(r100, 36, r103, null);
            String r141 = (String) r101.decodeNullableSerializableElement(r100, 37, r103, null);
            Integer r510 = r136;
            String r511 = (String) r101.decodeNullableSerializableElement(r100, 38, r103, null);
            String r410 = r132;
            String r512 = r140;
            boolean r411 = r133;
            String r412 = r129;
            Long r413 = r130;
            String r414 = r134;
            Long r415 = r131;
            Integer r416 = r135;
            Integer r513 = r137;
            Integer r514 = r138;
            Integer r515 = r139;
            String r516 = r141;
            Integer r310 = r122;
            Integer r311 = r121;
            Integer r312 = r120;
            Integer r313 = r119;
            String r142 = r102;
            Long r314 = r124;
            String r315 = r125;
            String r417 = r126;
            Long r418 = r127;
            Integer r419 = r128;
            String r143 = r104;
            Integer r211 = r109;
            Integer r212 = r108;
            String r144 = r110;
            int r213 = r111;
            String r316 = r123;
            boolean r317 = r118;
            Long r318 = r117;
            String r319 = r116;
            String r214 = r115;
            int r145 = -1;
            int r146 = 127;
            Long r215 = r106;
            Long r216 = r107;
            String r217 = r105;
            String r218 = r112;
        L74:
            r101.endStructure(r100);
            return new ConversationEntity(r145, r146, r142, r143, r144, r213, r217, r218, r215, r216, r212, r210, r211, r214, r319, r318, r317, r313, r312, r311, r310, r316, r314, r315, r417, r418, r419, r412, r413, r415, r410, r411, r414, r416, r510, r513, r514, r515, r512, r516, r511, null);
        L5:
            String r147 = null;
            Integer r148 = null;
            Integer r149 = null;
            Integer r150 = null;
            Integer r151 = null;
            String r152 = null;
            String r153 = null;
            String r154 = null;
            String r155 = null;
            Long r156 = null;
            Integer r157 = null;
            Long r158 = null;
            String r320 = null;
            String r321 = null;
            String r322 = null;
            String r420 = null;
            Long r421 = null;
            Long r422 = null;
            Integer r423 = null;
            Integer r424 = null;
            String r425 = null;
            String r426 = null;
            Long r427 = null;
            Integer r428 = null;
            Integer r429 = null;
            Integer r517 = null;
            Integer r518 = null;
            String r519 = null;
            Long r520 = null;
            String r521 = null;
            Integer r522 = null;
            String r523 = null;
            String r524 = null;
            String r525 = null;
            Long r610 = null;
            long r611 = 0;
            int r159 = 0;
            int r160 = 0;
            boolean r323 = false;
            boolean r526 = false;
            int r612 = 0;
            boolean r613 = true;
        L6:
            if (r613 == false) goto L73;
            Long r614 = r156;
            int r161 = r101.decodeElementIndex(r100);
            switch(r161) {
                case -1: goto L70;
                case 0: goto L69;
                case 1: goto L68;
                case 2: goto L65;
                case 3: goto L62;
                case 4: goto L61;
                case 5: goto L60;
                case 6: goto L58;
                case 7: goto L57;
                case 8: goto L55;
                case 9: goto L53;
                case 10: goto L52;
                case 11: goto L51;
                case 12: goto L50;
                case 13: goto L49;
                case 14: goto L45;
                case 15: goto L44;
                case 16: goto L42;
                case 17: goto L40;
                case 18: goto L39;
                case 19: goto L38;
                case 20: goto L33;
                case 21: goto L31;
                case 22: goto L30;
                case 23: goto L29;
                case 24: goto L28;
                case 25: goto L27;
                case 26: goto L26;
                case 27: goto L24;
                case 28: goto L21;
                case 29: goto L20;
                case 30: goto L19;
                case 31: goto L18;
                case 32: goto L17;
                case 33: goto L16;
                case 34: goto L15;
                case 35: goto L14;
                case 36: goto L13;
                case 37: goto L12;
                case 38: goto L11;
                default: goto L10;
            };
        L11:
            r158 = r158;
            r154 = (String) r101.decodeNullableSerializableElement(r100, 38, v2.f520790a, r154);
            r159 = r159 | 64;
        L23:
            Unit r162 = Unit.INSTANCE;
        L35:
            r156 = r614;
        L36:
            r158 = r158;
        L37:
            r148 = r148;
            r149 = r149;
            r428 = r428;
            r429 = r429;
            r517 = r517;
            Integer r219 = r518;
            String r220 = r519;
        L72:
            r423 = r423;
            r149 = r149;
            r427 = r427;
            r517 = r517;
            r429 = r429;
            r428 = r428;
            r518 = r219;
            r426 = r426;
            r425 = r425;
            r519 = r220;
            r321 = r321;
            r322 = r322;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r424 = r424;
            r148 = r148;
            goto L6
        L12:
            r158 = r158;
            r152 = (String) r101.decodeNullableSerializableElement(r100, 37, v2.f520790a, r152);
            r159 = r159 | 32;
            goto L23
        L13:
            r158 = r158;
            r155 = (String) r101.decodeNullableSerializableElement(r100, 36, v2.f520790a, r155);
            r159 = r159 | 16;
            goto L23
        L14:
            r158 = r158;
            r148 = (Integer) r101.decodeNullableSerializableElement(r100, 35, w0.f520792a, r148);
            r159 = r159 | 8;
            goto L23
        L15:
            r158 = r158;
            r149 = (Integer) r101.decodeNullableSerializableElement(r100, 34, w0.f520792a, r149);
            r159 = r159 | 4;
            goto L23
        L16:
            r158 = r158;
            r157 = (Integer) r101.decodeNullableSerializableElement(r100, 33, w0.f520792a, r157);
            r159 = r159 | 2;
            goto L23
        L17:
            r158 = r158;
            r150 = (Integer) r101.decodeNullableSerializableElement(r100, 32, w0.f520792a, r150);
            r159 = r159 | 1;
            goto L23
        L18:
            r151 = (Integer) r101.decodeNullableSerializableElement(r100, 31, w0.f520792a, r151);
            int r163 = Integer.MIN_VALUE;
        L22:
            r160 = r160 | r163;
            goto L23
        L19:
            r153 = (String) r101.decodeNullableSerializableElement(r100, 30, v2.f520790a, r153);
            r163 = 1073741824;
            goto L22
        L20:
            r526 = r101.decodeBooleanElement(r100, 29);
            r160 = r160 | 536870912;
            Unit r164 = Unit.INSTANCE;
        L25:
            r156 = r614;
            r148 = r148;
            goto L37
        L21:
            r147 = (String) r101.decodeNullableSerializableElement(r100, 28, v2.f520790a, r147);
            r163 = 268435456;
            goto L22
        L24:
            r158 = (Long) r101.decodeNullableSerializableElement(r100, 27, g1.f520681a, r158);
            r160 = r160 | AMapEngineUtils.HALF_MAX_P20_WIDTH;
            Unit r165 = Unit.INSTANCE;
            goto L25
        L26:
            Integer r615 = r148;
            r158 = r158;
            r156 = (Long) r101.decodeNullableSerializableElement(r100, 26, g1.f520681a, r614);
            int r166 = 67108864 | r160;
            Unit r167 = Unit.INSTANCE;
            r160 = r166;
            r148 = r615;
            goto L36
        L27:
            r525 = (String) r101.decodeNullableSerializableElement(r100, 25, v2.f520790a, r525);
            int r168 = 33554432;
        L32:
            int r169 = r168 | r160;
            Unit r170 = Unit.INSTANCE;
            r160 = r169;
            Long r171 = r520;
        L34:
            r520 = r171;
            r148 = r148;
            goto L35
        L28:
            r522 = (Integer) r101.decodeNullableSerializableElement(r100, 24, w0.f520792a, r522);
            r168 = 16777216;
            goto L32
        L29:
            r610 = (Long) r101.decodeNullableSerializableElement(r100, 23, g1.f520681a, r610);
            r168 = 8388608;
            goto L32
        L30:
            r524 = (String) r101.decodeNullableSerializableElement(r100, 22, v2.f520790a, r524);
            r168 = 4194304;
            goto L32
        L31:
            r521 = (String) r101.decodeNullableSerializableElement(r100, 21, v2.f520790a, r521);
            r168 = 2097152;
            goto L32
        L33:
            r148 = r148;
            r158 = r158;
            r171 = (Long) r101.decodeNullableSerializableElement(r100, 20, g1.f520681a, r520);
            r160 = r160 | 1048576;
            Unit r172 = Unit.INSTANCE;
            goto L34
        L38:
            r148 = r148;
            r158 = r158;
            r520 = r520;
            String r173 = (String) r101.decodeNullableSerializableElement(r100, 19, v2.f520790a, r519);
            r160 = r160 | 524288;
            Unit r174 = Unit.INSTANCE;
            r149 = r149;
            r150 = r150;
            r519 = r173;
            r322 = r322;
            r420 = r420;
            r421 = r421;
            Long r175 = r422;
            Integer r324 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r428 = r428;
            r429 = r429;
            r517 = r517;
            r518 = r518;
        L67:
            r422 = r175;
            Integer r176 = r324;
            r321 = r321;
        L71:
            r220 = r519;
            r520 = r520;
            r158 = r158;
            r423 = r176;
            r150 = r150;
            r219 = r518;
            r427 = r427;
            r156 = r614;
            goto L72
        L39:
            Integer r177 = (Integer) r101.decodeNullableSerializableElement(r100, 18, w0.f520792a, r518);
            r160 = r160 | 262144;
            Unit r178 = Unit.INSTANCE;
            r518 = r177;
            r517 = r517;
        L43:
            Integer r179 = r429;
        L47:
            r429 = r179;
            r220 = r519;
            r520 = r520;
            r219 = r518;
            r428 = r428;
            r156 = r614;
            r158 = r158;
            goto L72
        L40:
            r518 = r518;
            Integer r180 = (Integer) r101.decodeNullableSerializableElement(r100, 17, w0.f520792a, r517);
            r160 = r160 | 131072;
            Unit r181 = Unit.INSTANCE;
            r517 = r180;
            goto L43
        L42:
            r148 = r148;
            r149 = r149;
            r158 = r158;
            r518 = r518;
            r519 = r519;
            r520 = r520;
            r517 = r517;
            Integer r182 = (Integer) r101.decodeNullableSerializableElement(r100, 16, w0.f520792a, r429);
            r160 = r160 | 65536;
            Unit r183 = Unit.INSTANCE;
            r429 = r182;
            goto L43
        L44:
            Integer r221 = r429;
            Integer r184 = (Integer) r101.decodeNullableSerializableElement(r100, 15, w0.f520792a, r428);
            r160 = r160 | 32768;
            Unit r185 = Unit.INSTANCE;
        L46:
            r428 = r184;
            r179 = r221;
            goto L47
        L45:
            r184 = r428;
            r221 = r429;
            boolean r222 = r101.decodeBooleanElement(r100, 14);
            r160 = r160 | 16384;
            Unit r325 = Unit.INSTANCE;
            r323 = r222;
            goto L46
        L49:
            r148 = r148;
            r149 = r149;
            r429 = r429;
            r517 = r517;
            r428 = r428;
            Long r186 = (Long) r101.decodeNullableSerializableElement(r100, 13, g1.f520681a, r427);
            r160 = r160 | 8192;
            Unit r187 = Unit.INSTANCE;
            r220 = r519;
            r219 = r518;
            r321 = r321;
            r322 = r322;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r423 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r156 = r614;
            r158 = r158;
            r427 = r186;
            goto L72
        L50:
            String r188 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r426);
            int r189 = r160 | 4096;
            Unit r190 = Unit.INSTANCE;
            r426 = r188;
            int r191 = r189;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r324 = r423;
            r425 = r425;
        L63:
            int r192 = r191;
            r322 = r322;
        L66:
            r160 = r192;
            r175 = r422;
            goto L67
        L51:
            r426 = r426;
            String r193 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r425);
            r191 = r160 | 2048;
            Unit r194 = Unit.INSTANCE;
            r425 = r193;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r324 = r423;
            goto L63
        L52:
            r425 = r425;
            Integer r195 = (Integer) r101.decodeNullableSerializableElement(r100, 10, w0.f520792a, r424);
            r192 = r160 | 1024;
            Unit r196 = Unit.INSTANCE;
            Integer r197 = r195;
        L54:
            r424 = r197;
            r322 = r322;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r324 = r423;
            goto L66
        L53:
            r425 = r425;
            r611 = r101.decodeLongElement(r100, 9);
            int r198 = r160 | 512;
            Unit r326 = Unit.INSTANCE;
            r197 = r424;
            r192 = r198;
            goto L54
        L55:
            r424 = r424;
            Integer r199 = (Integer) r101.decodeNullableSerializableElement(r100, 8, w0.f520792a, r423);
            int r200 = r160 | 256;
            Unit r1100 = Unit.INSTANCE;
            r324 = r199;
            r420 = r420;
            r191 = r200;
            goto L63
        L57:
            r425 = r425;
            r426 = r426;
            r324 = r423;
            Long r201 = (Long) r101.decodeNullableSerializableElement(r100, 7, g1.f520681a, r422);
            int r202 = r160 | 128;
            Unit r1101 = Unit.INSTANCE;
            r191 = r202;
            r422 = r201;
            r420 = r420;
            r421 = r421;
            goto L63
        L58:
            r324 = r423;
            r425 = r425;
            r426 = r426;
            r422 = r422;
            Long r203 = (Long) r101.decodeNullableSerializableElement(r100, 6, g1.f520681a, r421);
            r191 = r160 | 64;
            Unit r1102 = Unit.INSTANCE;
            r421 = r203;
            r420 = r420;
            goto L63
        L60:
            r422 = r422;
            r324 = r423;
            r425 = r425;
            r426 = r426;
            r421 = r421;
            String r204 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r420);
            int r205 = r160 | 32;
            Unit r1103 = Unit.INSTANCE;
            r420 = r204;
            r191 = r205;
            goto L63
        L61:
            r324 = r423;
            r424 = r424;
            r420 = r420;
            String r206 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r322);
            r191 = r160 | 16;
            Unit r1104 = Unit.INSTANCE;
            r322 = r206;
            goto L63
        L62:
            r148 = r148;
            r149 = r149;
            r150 = r150;
            r158 = r158;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r324 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r428 = r428;
            r429 = r429;
            r517 = r517;
            r518 = r518;
            r519 = r519;
            r520 = r520;
            r612 = r101.decodeIntElement(r100, 3);
            Unit r223 = Unit.INSTANCE;
            r191 = r160 | 8;
            goto L63
        L65:
            r148 = r148;
            r149 = r149;
            r150 = r150;
            r158 = r158;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r324 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r428 = r428;
            r429 = r429;
            r517 = r517;
            r518 = r518;
            r519 = r519;
            r520 = r520;
            r322 = r322;
            String r207 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r321);
            r192 = r160 | 4;
            Unit r1105 = Unit.INSTANCE;
            r321 = r207;
            goto L66
        L68:
            r148 = r148;
            r149 = r149;
            r150 = r150;
            r158 = r158;
            r322 = r322;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r428 = r428;
            r429 = r429;
            r517 = r517;
            r518 = r518;
            r519 = r519;
            r520 = r520;
            r321 = r321;
            String r208 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r320);
            r160 = r160 | 2;
            Unit r209 = Unit.INSTANCE;
            r320 = r208;
            r176 = r423;
            goto L71
        L69:
            r148 = r148;
            r149 = r149;
            r150 = r150;
            r158 = r158;
            r321 = r321;
            r322 = r322;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r428 = r428;
            r429 = r429;
            r517 = r517;
            r518 = r518;
            r519 = r519;
            r520 = r520;
            r523 = r101.decodeStringElement(r100, 0);
            r160 = r160 | 1;
            Unit r224 = Unit.INSTANCE;
            r176 = r423;
            goto L71
        L70:
            r148 = r148;
            r149 = r149;
            r150 = r150;
            r158 = r158;
            r321 = r321;
            r322 = r322;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r427 = r427;
            r428 = r428;
            r429 = r429;
            r517 = r517;
            r518 = r518;
            r519 = r519;
            r520 = r520;
            Unit r225 = Unit.INSTANCE;
            r176 = r423;
            r613 = false;
            goto L71
        L10:
            throw new UnknownFieldException(r161);
        L73:
            Integer r226 = r150;
            Long r616 = r156;
            String r227 = r320;
            String r228 = r321;
            String r327 = r420;
            Long r328 = r422;
            String r229 = r426;
            Long r1106 = r427;
            Integer r230 = r428;
            Integer r231 = r429;
            Integer r1107 = r518;
            r416 = r151;
            r414 = r153;
            r410 = r147;
            r513 = r157;
            r316 = r519;
            r314 = r520;
            r514 = r149;
            r311 = r517;
            r510 = r226;
            r214 = r425;
            r144 = r228;
            r217 = r322;
            r215 = r421;
            r212 = r423;
            r211 = r424;
            r411 = r526;
            r315 = r521;
            r419 = r522;
            r142 = r523;
            r417 = r524;
            r412 = r525;
            r418 = r610;
            r210 = r611;
            r413 = r616;
            r415 = r158;
            r515 = r148;
            r516 = r152;
            r511 = r154;
            r146 = r159;
            r145 = r160;
            r512 = r155;
            r318 = r1106;
            r312 = r231;
            r313 = r230;
            r218 = r327;
            r213 = r612;
            r319 = r229;
            r216 = r328;
            r317 = r323;
            r310 = r1107;
            r143 = r227;
            goto L74
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ConversationEntity r102 = (ConversationEntity) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f348112b;
            muc.d r104 = r100.beginStructure(r103);
            ConversationEntity.write$Self$omnisdk_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ConversationEntity> serializer() {
            return a.f348111a;
        }
    }

    public static /* synthetic */ ConversationEntity copy$default(ConversationEntity r110, String r111, String r112, String r210, int r211, String r212, String r213, Long r214, Long r215, Integer r216, long r217, Integer r218, String r310, String r311, Long r312, boolean r313, Integer r314, Integer r315, Integer r316, Integer r317, String r318, Long r319, String r410, String r411, Long r412, Integer r413, String r414, Long r415, Long r416, String r417, boolean r418, String r419, Integer r510, Integer r511, Integer r512, Integer r513, Integer r514, String r515, String r516, String r517, int r518, int r519, Object r610) {
        if ((r518 & 1) == 0) goto L5;
        String r100 = r110.conversationId;
    L7:
        if ((r518 & 2) == 0) goto L9;
        String r101 = r110.projectId;
    L11:
        if ((r518 & 4) == 0) goto L13;
        String r102 = r110.deviceId;
    L15:
        if ((r518 & 8) == 0) goto L17;
        int r103 = r110.botType;
    L19:
        if ((r518 & 16) == 0) goto L21;
        String r104 = r110.iconImage;
    L23:
        if ((r518 & 32) == 0) goto L25;
        String r105 = r110.name;
    L27:
        if ((r518 & 64) == 0) goto L29;
        Long r106 = r110.createTime;
    L31:
        if ((r518 & 128) == 0) goto L33;
        Long r107 = r110.updateTime;
    L35:
        if ((r518 & 256) == 0) goto L37;
        Integer r113 = r110.pinned;
    L39:
        if ((r518 & 512) == 0) goto L41;
        long r114 = r110.pinTime;
    L43:
        if ((r518 & 1024) == 0) goto L45;
        Integer r115 = r110.isLocal;
    L47:
        if ((r518 & 2048) == 0) goto L49;
        String r116 = r110.conversationPage;
    L51:
        if ((r518 & 4096) == 0) goto L53;
        String r117 = r110.templates;
    L54:
        String r320 = r117;
        if ((r518 & 8192) == 0) goto L57;
        Long r118 = r110.messageCursor;
    L58:
        Long r321 = r118;
        if ((r518 & 16384) == 0) goto L61;
        boolean r119 = r110.ttsEnable;
    L62:
        boolean r322 = r119;
        if ((r518 & 32768) == 0) goto L65;
        Integer r120 = r110.conversationType;
    L66:
        Integer r323 = r120;
        if ((r518 & 65536) == 0) goto L69;
        Integer r121 = r110.participantCount;
    L70:
        Integer r324 = r121;
        if ((r518 & 131072) == 0) goto L73;
        Integer r122 = r110.badgeCount;
    L74:
        Integer r325 = r122;
        if ((r518 & 262144) == 0) goto L77;
        Integer r123 = r110.readBadgeCount;
    L78:
        Integer r326 = r123;
        if ((r518 & 524288) == 0) goto L81;
        String r124 = r110.briefMessageLocalId;
    L82:
        String r327 = r124;
        if ((r518 & 1048576) == 0) goto L85;
        Long r125 = r110.readMessageIndex;
    L86:
        Long r328 = r125;
        if ((r518 & 2097152) == 0) goto L89;
        String r126 = r110.ext;
    L90:
        String r420 = r126;
        if ((r518 & 4194304) == 0) goto L93;
        String r127 = r110.bizModel;
    L94:
        String r421 = r127;
        if ((r518 & 8388608) == 0) goto L97;
        Long r128 = r110.version;
    L98:
        Long r422 = r128;
        if ((r518 & 16777216) == 0) goto L101;
        Integer r129 = r110.status;
    L102:
        Integer r423 = r129;
        if ((r518 & 33554432) == 0) goto L105;
        String r130 = r110.bizExtra;
    L106:
        String r424 = r130;
        if ((r518 & 67108864) == 0) goto L109;
        Long r131 = r110.retentionCursor;
    L110:
        Long r425 = r131;
        if ((r518 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Long r132 = r110.latestMessageIndex;
    L114:
        Long r426 = r132;
        if ((r518 & 268435456) == 0) goto L117;
        String r133 = r110.ownerId;
    L118:
        String r427 = r133;
        if ((r518 & 536870912) == 0) goto L121;
        boolean r134 = r110.isDeleted;
    L122:
        boolean r428 = r134;
        if ((r518 & 1073741824) == 0) goto L125;
        String r135 = r110.traceMap;
    L127:
        if ((r518 & Integer.MIN_VALUE) == 0) goto L129;
        Integer r108 = r110.inputLeftActionStyle;
    L130:
        Integer r520 = r108;
        if ((r519 & 1) == 0) goto L133;
        Integer r109 = r110.groupReviewStatus;
    L134:
        Integer r521 = r109;
        if ((r519 & 2) == 0) goto L137;
        Integer r136 = r110.createScene;
    L138:
        Integer r522 = r136;
        if ((r519 & 4) == 0) goto L141;
        Integer r137 = r110.cellType;
    L142:
        Integer r523 = r137;
        if ((r519 & 8) == 0) goto L145;
        Integer r138 = r110.createChannel;
    L146:
        Integer r524 = r138;
        if ((r519 & 16) == 0) goto L149;
        String r139 = r110.parentCellId;
    L150:
        String r525 = r139;
        if ((r519 & 32) == 0) goto L153;
        String r140 = r110.lastSectionId;
    L154:
        String r526 = r140;
        if ((r519 & 64) == 0) goto L157;
        String r141 = r110.botId;
    L159:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r426, r427, r428, r135, r520, r521, r522, r523, r524, r525, r526, r141);
    L157:
        r141 = r517;
        goto L159
    L153:
        r140 = r516;
        goto L154
    L149:
        r139 = r515;
        goto L150
    L145:
        r138 = r514;
        goto L146
    L141:
        r137 = r513;
        goto L142
    L137:
        r136 = r512;
        goto L138
    L133:
        r109 = r511;
        goto L134
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
        return this.conversationId;
    }

    public final long component10() {
        return this.pinTime;
    }

    public final Integer component11() {
        return this.isLocal;
    }

    public final String component12() {
        return this.conversationPage;
    }

    public final String component13() {
        return this.templates;
    }

    public final Long component14() {
        return this.messageCursor;
    }

    public final boolean component15() {
        return this.ttsEnable;
    }

    public final Integer component16() {
        return this.conversationType;
    }

    public final Integer component17() {
        return this.participantCount;
    }

    public final Integer component18() {
        return this.badgeCount;
    }

    public final Integer component19() {
        return this.readBadgeCount;
    }

    public final String component2() {
        return this.projectId;
    }

    public final String component20() {
        return this.briefMessageLocalId;
    }

    public final Long component21() {
        return this.readMessageIndex;
    }

    public final String component22() {
        return this.ext;
    }

    public final String component23() {
        return this.bizModel;
    }

    public final Long component24() {
        return this.version;
    }

    public final Integer component25() {
        return this.status;
    }

    public final String component26() {
        return this.bizExtra;
    }

    public final Long component27() {
        return this.retentionCursor;
    }

    public final Long component28() {
        return this.latestMessageIndex;
    }

    public final String component29() {
        return this.ownerId;
    }

    public final String component3() {
        return this.deviceId;
    }

    public final boolean component30() {
        return this.isDeleted;
    }

    public final String component31() {
        return this.traceMap;
    }

    public final Integer component32() {
        return this.inputLeftActionStyle;
    }

    public final Integer component33() {
        return this.groupReviewStatus;
    }

    public final Integer component34() {
        return this.createScene;
    }

    public final Integer component35() {
        return this.cellType;
    }

    public final Integer component36() {
        return this.createChannel;
    }

    public final String component37() {
        return this.parentCellId;
    }

    public final String component38() {
        return this.lastSectionId;
    }

    public final String component39() {
        return this.botId;
    }

    public final int component4() {
        return this.botType;
    }

    public final String component5() {
        return this.iconImage;
    }

    public final String component6() {
        return this.name;
    }

    public final Long component7() {
        return this.createTime;
    }

    public final Long component8() {
        return this.updateTime;
    }

    public final Integer component9() {
        return this.pinned;
    }

    public final ConversationEntity copy(String r410, String r411, String r412, int r413, String r414, String r415, Long r510, Long r511, Integer r512, long r513, Integer r514, String r515, String r516, Long r517, boolean r518, Integer r610, Integer r611, Integer r612, Integer r613, String r614, Long r615, String r616, String r617, Long r618, Integer r619, String r710, Long r711, Long r712, String r713, boolean r714, String r715, Integer r716, Integer r717, Integer r718, Integer r719, Integer r810, String r811, String r812, String r813) {
        Intrinsics.checkNotNullParameter(r410, "conversationId");
        return new ConversationEntity(r410, r411, r412, r413, r414, r415, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConversationEntity) == true) goto L8;
        return false;
    L8:
        ConversationEntity r101 = (ConversationEntity) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.projectId, r101.projectId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L18;
        return false;
    L18:
        if (this.botType == r101.botType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconImage, r101.iconImage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.pinned, r101.pinned) == true) goto L36;
        return false;
    L36:
        if (this.pinTime == r101.pinTime) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.isLocal, r101.isLocal) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.conversationPage, r101.conversationPage) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.templates, r101.templates) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.messageCursor, r101.messageCursor) == true) goto L51;
        return false;
    L51:
        if (this.ttsEnable == r101.ttsEnable) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.conversationType, r101.conversationType) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.participantCount, r101.participantCount) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.badgeCount, r101.badgeCount) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.readBadgeCount, r101.readBadgeCount) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.briefMessageLocalId, r101.briefMessageLocalId) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.readMessageIndex, r101.readMessageIndex) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.bizModel, r101.bizModel) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.bizExtra, r101.bizExtra) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.retentionCursor, r101.retentionCursor) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.latestMessageIndex, r101.latestMessageIndex) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L96;
        return false;
    L96:
        if (this.isDeleted == r101.isDeleted) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.traceMap, r101.traceMap) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.inputLeftActionStyle, r101.inputLeftActionStyle) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.groupReviewStatus, r101.groupReviewStatus) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.createScene, r101.createScene) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.cellType, r101.cellType) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.createChannel, r101.createChannel) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.parentCellId, r101.parentCellId) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.lastSectionId, r101.lastSectionId) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L125;
        return false;
    L125:
        return true;
    }

    public int hashCode() {
        int r100 = this.conversationId.hashCode() * 31;
        String r101 = this.projectId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.deviceId;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.botType) * 31;
        String r108 = this.iconImage;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.name;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Long r114 = this.createTime;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Long r117 = this.updateTime;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Integer r120 = this.pinned;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        long r122 = this.pinTime;
        int r123 = (((r119 + r121) * 31) + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        Integer r124 = this.isLocal;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.conversationPage;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        String r130 = this.templates;
        if (r130 != null) goto L41;
        int r131 = 0;
    L42:
        int r132 = (r129 + r131) * 31;
        Long r133 = this.messageCursor;
        if (r133 != null) goto L45;
        int r134 = 0;
    L46:
        int r135 = (r132 + r134) * 31;
        int r136 = 1231;
        if (this.ttsEnable == false) goto L49;
        int r137 = 1231;
    L50:
        int r138 = (r135 + r137) * 31;
        Integer r139 = this.conversationType;
        if (r139 != null) goto L53;
        int r140 = 0;
    L54:
        int r141 = (r138 + r140) * 31;
        Integer r142 = this.participantCount;
        if (r142 != null) goto L57;
        int r143 = 0;
    L58:
        int r144 = (r141 + r143) * 31;
        Integer r145 = this.badgeCount;
        if (r145 != null) goto L61;
        int r146 = 0;
    L62:
        int r147 = (r144 + r146) * 31;
        Integer r148 = this.readBadgeCount;
        if (r148 != null) goto L65;
        int r149 = 0;
    L66:
        int r150 = (r147 + r149) * 31;
        String r151 = this.briefMessageLocalId;
        if (r151 != null) goto L69;
        int r152 = 0;
    L70:
        int r153 = (r150 + r152) * 31;
        Long r154 = this.readMessageIndex;
        if (r154 != null) goto L73;
        int r155 = 0;
    L74:
        int r156 = (r153 + r155) * 31;
        String r157 = this.ext;
        if (r157 != null) goto L77;
        int r158 = 0;
    L78:
        int r159 = (r156 + r158) * 31;
        String r160 = this.bizModel;
        if (r160 != null) goto L81;
        int r161 = 0;
    L82:
        int r162 = (r159 + r161) * 31;
        Long r163 = this.version;
        if (r163 != null) goto L85;
        int r164 = 0;
    L86:
        int r165 = (r162 + r164) * 31;
        Integer r166 = this.status;
        if (r166 != null) goto L89;
        int r167 = 0;
    L90:
        int r168 = (r165 + r167) * 31;
        String r169 = this.bizExtra;
        if (r169 != null) goto L93;
        int r170 = 0;
    L94:
        int r171 = (r168 + r170) * 31;
        Long r172 = this.retentionCursor;
        if (r172 != null) goto L97;
        int r173 = 0;
    L98:
        int r174 = (r171 + r173) * 31;
        Long r175 = this.latestMessageIndex;
        if (r175 != null) goto L101;
        int r176 = 0;
    L102:
        int r177 = (r174 + r176) * 31;
        String r178 = this.ownerId;
        if (r178 != null) goto L105;
        int r179 = 0;
    L106:
        int r180 = (r177 + r179) * 31;
        if (this.isDeleted == true) goto L110;
        r136 = 1237;
    L110:
        int r181 = (r180 + r136) * 31;
        String r182 = this.traceMap;
        if (r182 != null) goto L113;
        int r183 = 0;
    L114:
        int r184 = (r181 + r183) * 31;
        Integer r185 = this.inputLeftActionStyle;
        if (r185 != null) goto L117;
        int r186 = 0;
    L118:
        int r187 = (r184 + r186) * 31;
        Integer r188 = this.groupReviewStatus;
        if (r188 != null) goto L121;
        int r189 = 0;
    L122:
        int r190 = (r187 + r189) * 31;
        Integer r191 = this.createScene;
        if (r191 != null) goto L125;
        int r192 = 0;
    L126:
        int r193 = (r190 + r192) * 31;
        Integer r194 = this.cellType;
        if (r194 != null) goto L129;
        int r195 = 0;
    L130:
        int r196 = (r193 + r195) * 31;
        Integer r197 = this.createChannel;
        if (r197 != null) goto L133;
        int r198 = 0;
    L134:
        int r199 = (r196 + r198) * 31;
        String r200 = this.parentCellId;
        if (r200 != null) goto L137;
        int r201 = 0;
    L138:
        int r202 = (r199 + r201) * 31;
        String r203 = this.lastSectionId;
        if (r203 != null) goto L141;
        int r204 = 0;
    L142:
        int r205 = (r202 + r204) * 31;
        String r206 = this.botId;
        if (r206 == null) goto L147;
        r102 = r206.hashCode();
    L147:
        return r205 + r102;
    L141:
        r204 = r203.hashCode();
        goto L142
    L137:
        r201 = r200.hashCode();
        goto L138
    L133:
        r198 = r197.hashCode();
        goto L134
    L129:
        r195 = r194.hashCode();
        goto L130
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
    L105:
        r179 = r178.hashCode();
        goto L106
    L101:
        r176 = r175.hashCode();
        goto L102
    L97:
        r173 = r172.hashCode();
        goto L98
    L93:
        r170 = r169.hashCode();
        goto L94
    L89:
        r167 = r166.hashCode();
        goto L90
    L85:
        r164 = r163.hashCode();
        goto L86
    L81:
        r161 = r160.hashCode();
        goto L82
    L77:
        r158 = r157.hashCode();
        goto L78
    L73:
        r155 = r154.hashCode();
        goto L74
    L69:
        r152 = r151.hashCode();
        goto L70
    L65:
        r149 = r148.hashCode();
        goto L66
    L61:
        r146 = r145.hashCode();
        goto L62
    L57:
        r143 = r142.hashCode();
        goto L58
    L53:
        r140 = r139.hashCode();
        goto L54
    L49:
        r137 = 1237;
        goto L50
    L45:
        r134 = r133.hashCode();
        goto L46
    L41:
        r131 = r130.hashCode();
        goto L42
    L37:
        r128 = r127.hashCode();
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
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
        return "ConversationEntity(conversationId=" + this.conversationId + ", projectId=" + this.projectId + ", deviceId=" + this.deviceId + ", botType=" + this.botType + ", iconImage=" + this.iconImage + ", name=" + this.name + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", pinned=" + this.pinned + ", pinTime=" + this.pinTime + ", isLocal=" + this.isLocal + ", conversationPage=" + this.conversationPage + ", templates=" + this.templates + ", messageCursor=" + this.messageCursor + ", ttsEnable=" + this.ttsEnable + ", conversationType=" + this.conversationType + ", participantCount=" + this.participantCount + ", badgeCount=" + this.badgeCount + ", readBadgeCount=" + this.readBadgeCount + ", briefMessageLocalId=" + this.briefMessageLocalId + ", readMessageIndex=" + this.readMessageIndex + ", ext=" + this.ext + ", bizModel=" + this.bizModel + ", version=" + this.version + ", status=" + this.status + ", bizExtra=" + this.bizExtra + ", retentionCursor=" + this.retentionCursor + ", latestMessageIndex=" + this.latestMessageIndex + ", ownerId=" + this.ownerId + ", isDeleted=" + this.isDeleted + ", traceMap=" + this.traceMap + ", inputLeftActionStyle=" + this.inputLeftActionStyle + ", groupReviewStatus=" + this.groupReviewStatus + ", createScene=" + this.createScene + ", cellType=" + this.cellType + ", createChannel=" + this.createChannel + ", parentCellId=" + this.parentCellId + ", lastSectionId=" + this.lastSectionId + ", botId=" + this.botId + ')';
    }

    static {
        Companion = new b();
    }

    public ConversationEntity() {
        this("", null, null, 0, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, -2, 127, null);
    }

    public final Integer getBadgeCount() {
        return this.badgeCount;
    }

    public final String getBizExtra() {
        return this.bizExtra;
    }

    public final String getBizModel() {
        return this.bizModel;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final int getBotType() {
        return this.botType;
    }

    public final String getBriefMessageLocalId() {
        return this.briefMessageLocalId;
    }

    public final Integer getCellType() {
        return this.cellType;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getConversationPage() {
        return this.conversationPage;
    }

    public final Integer getConversationType() {
        return this.conversationType;
    }

    public final Integer getCreateChannel() {
        return this.createChannel;
    }

    public final Integer getCreateScene() {
        return this.createScene;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getExt() {
        return this.ext;
    }

    public final Integer getGroupReviewStatus() {
        return this.groupReviewStatus;
    }

    public final String getIconImage() {
        return this.iconImage;
    }

    public final Integer getInputLeftActionStyle() {
        return this.inputLeftActionStyle;
    }

    public final String getLastSectionId() {
        return this.lastSectionId;
    }

    public final Long getLatestMessageIndex() {
        return this.latestMessageIndex;
    }

    public final Long getMessageCursor() {
        return this.messageCursor;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getParentCellId() {
        return this.parentCellId;
    }

    public final Integer getParticipantCount() {
        return this.participantCount;
    }

    public final long getPinTime() {
        return this.pinTime;
    }

    public final Integer getPinned() {
        return this.pinned;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final Integer getReadBadgeCount() {
        return this.readBadgeCount;
    }

    public final Long getReadMessageIndex() {
        return this.readMessageIndex;
    }

    public final Long getRetentionCursor() {
        return this.retentionCursor;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getTemplates() {
        return this.templates;
    }

    public final String getTraceMap() {
        return this.traceMap;
    }

    public final boolean getTtsEnable() {
        return this.ttsEnable;
    }

    public final Long getUpdateTime() {
        return this.updateTime;
    }

    public final Long getVersion() {
        return this.version;
    }

    public final boolean isDeleted() {
        return this.isDeleted;
    }

    public final Integer isLocal() {
        return this.isLocal;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(ConversationEntity r100, muc.d r110, f r111) {
        boolean r101 = false;
        if (r110.shouldEncodeElementDefault(r111, 0) == false) goto L6;
    L4:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        r110.encodeStringElement(r111, 0, r100.conversationId);
    L12:
        if (r110.shouldEncodeElementDefault(r111, 1) == false) goto L15;
    L13:
        boolean r103 = true;
    L18:
        if (r103 == false) goto L21;
        r110.encodeNullableSerializableElement(r111, 1, v2.f520790a, r100.projectId);
    L21:
        if (r110.shouldEncodeElementDefault(r111, 2) == false) goto L24;
    L22:
        boolean r104 = true;
    L27:
        if (r104 == false) goto L30;
        r110.encodeNullableSerializableElement(r111, 2, v2.f520790a, r100.deviceId);
    L30:
        if (r110.shouldEncodeElementDefault(r111, 3) == false) goto L33;
    L31:
        boolean r105 = true;
    L36:
        if (r105 == false) goto L39;
        r110.encodeIntElement(r111, 3, r100.botType);
    L39:
        if (r110.shouldEncodeElementDefault(r111, 4) == false) goto L42;
    L40:
        boolean r106 = true;
    L45:
        if (r106 == false) goto L48;
        r110.encodeNullableSerializableElement(r111, 4, v2.f520790a, r100.iconImage);
    L48:
        if (r110.shouldEncodeElementDefault(r111, 5) == false) goto L51;
    L49:
        boolean r107 = true;
    L54:
        if (r107 == false) goto L57;
        r110.encodeNullableSerializableElement(r111, 5, v2.f520790a, r100.name);
    L57:
        if (r110.shouldEncodeElementDefault(r111, 6) == false) goto L60;
    L58:
        boolean r108 = true;
    L63:
        if (r108 == false) goto L66;
        r110.encodeNullableSerializableElement(r111, 6, g1.f520681a, r100.createTime);
    L66:
        if (r110.shouldEncodeElementDefault(r111, 7) == false) goto L69;
    L67:
        boolean r109 = true;
    L72:
        if (r109 == false) goto L75;
        r110.encodeNullableSerializableElement(r111, 7, g1.f520681a, r100.updateTime);
    L75:
        if (r110.shouldEncodeElementDefault(r111, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r110.encodeNullableSerializableElement(r111, 8, w0.f520792a, r100.pinned);
    L84:
        if (r110.shouldEncodeElementDefault(r111, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r110.encodeLongElement(r111, 9, r100.pinTime);
    L93:
        if (r110.shouldEncodeElementDefault(r111, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r110.encodeNullableSerializableElement(r111, 10, w0.f520792a, r100.isLocal);
    L102:
        if (r110.shouldEncodeElementDefault(r111, 11) == false) goto L105;
    L103:
        boolean r115 = true;
    L108:
        if (r115 == false) goto L111;
        r110.encodeNullableSerializableElement(r111, 11, v2.f520790a, r100.conversationPage);
    L111:
        if (r110.shouldEncodeElementDefault(r111, 12) == false) goto L114;
    L112:
        boolean r116 = true;
    L117:
        if (r116 == false) goto L120;
        r110.encodeNullableSerializableElement(r111, 12, v2.f520790a, r100.templates);
    L120:
        if (r110.shouldEncodeElementDefault(r111, 13) == false) goto L123;
    L121:
        boolean r117 = true;
    L126:
        if (r117 == false) goto L129;
        r110.encodeNullableSerializableElement(r111, 13, g1.f520681a, r100.messageCursor);
    L129:
        if (r110.shouldEncodeElementDefault(r111, 14) == false) goto L132;
    L130:
        boolean r118 = true;
    L135:
        if (r118 == false) goto L138;
        r110.encodeBooleanElement(r111, 14, r100.ttsEnable);
    L138:
        if (r110.shouldEncodeElementDefault(r111, 15) == false) goto L141;
    L139:
        boolean r119 = true;
    L144:
        if (r119 == false) goto L147;
        r110.encodeNullableSerializableElement(r111, 15, w0.f520792a, r100.conversationType);
    L147:
        if (r110.shouldEncodeElementDefault(r111, 16) == false) goto L150;
    L148:
        boolean r120 = true;
    L153:
        if (r120 == false) goto L156;
        r110.encodeNullableSerializableElement(r111, 16, w0.f520792a, r100.participantCount);
    L156:
        if (r110.shouldEncodeElementDefault(r111, 17) == false) goto L159;
    L157:
        boolean r121 = true;
    L162:
        if (r121 == false) goto L165;
        r110.encodeNullableSerializableElement(r111, 17, w0.f520792a, r100.badgeCount);
    L165:
        if (r110.shouldEncodeElementDefault(r111, 18) == false) goto L168;
    L166:
        boolean r122 = true;
    L171:
        if (r122 == false) goto L174;
        r110.encodeNullableSerializableElement(r111, 18, w0.f520792a, r100.readBadgeCount);
    L174:
        if (r110.shouldEncodeElementDefault(r111, 19) == false) goto L177;
    L175:
        boolean r123 = true;
    L180:
        if (r123 == false) goto L183;
        r110.encodeNullableSerializableElement(r111, 19, v2.f520790a, r100.briefMessageLocalId);
    L183:
        if (r110.shouldEncodeElementDefault(r111, 20) == false) goto L186;
    L184:
        boolean r124 = true;
    L189:
        if (r124 == false) goto L192;
        r110.encodeNullableSerializableElement(r111, 20, g1.f520681a, r100.readMessageIndex);
    L192:
        if (r110.shouldEncodeElementDefault(r111, 21) == false) goto L195;
    L193:
        boolean r125 = true;
    L198:
        if (r125 == false) goto L201;
        r110.encodeNullableSerializableElement(r111, 21, v2.f520790a, r100.ext);
    L201:
        if (r110.shouldEncodeElementDefault(r111, 22) == false) goto L204;
    L202:
        boolean r126 = true;
    L207:
        if (r126 == false) goto L210;
        r110.encodeNullableSerializableElement(r111, 22, v2.f520790a, r100.bizModel);
    L210:
        if (r110.shouldEncodeElementDefault(r111, 23) == false) goto L213;
    L211:
        boolean r127 = true;
    L216:
        if (r127 == false) goto L219;
        r110.encodeNullableSerializableElement(r111, 23, g1.f520681a, r100.version);
    L219:
        if (r110.shouldEncodeElementDefault(r111, 24) == false) goto L222;
    L220:
        boolean r128 = true;
    L225:
        if (r128 == false) goto L228;
        r110.encodeNullableSerializableElement(r111, 24, w0.f520792a, r100.status);
    L228:
        if (r110.shouldEncodeElementDefault(r111, 25) == false) goto L231;
    L229:
        boolean r129 = true;
    L234:
        if (r129 == false) goto L237;
        r110.encodeNullableSerializableElement(r111, 25, v2.f520790a, r100.bizExtra);
    L237:
        if (r110.shouldEncodeElementDefault(r111, 26) == false) goto L240;
    L238:
        boolean r130 = true;
    L243:
        if (r130 == false) goto L246;
        r110.encodeNullableSerializableElement(r111, 26, g1.f520681a, r100.retentionCursor);
    L246:
        if (r110.shouldEncodeElementDefault(r111, 27) == false) goto L249;
    L247:
        boolean r131 = true;
    L252:
        if (r131 == false) goto L255;
        r110.encodeNullableSerializableElement(r111, 27, g1.f520681a, r100.latestMessageIndex);
    L255:
        if (r110.shouldEncodeElementDefault(r111, 28) == false) goto L258;
    L256:
        boolean r132 = true;
    L261:
        if (r132 == false) goto L264;
        r110.encodeNullableSerializableElement(r111, 28, v2.f520790a, r100.ownerId);
    L264:
        if (r110.shouldEncodeElementDefault(r111, 29) == false) goto L267;
    L265:
        boolean r133 = true;
    L270:
        if (r133 == false) goto L273;
        r110.encodeBooleanElement(r111, 29, r100.isDeleted);
    L273:
        if (r110.shouldEncodeElementDefault(r111, 30) == false) goto L276;
    L274:
        boolean r134 = true;
    L279:
        if (r134 == false) goto L282;
        r110.encodeNullableSerializableElement(r111, 30, v2.f520790a, r100.traceMap);
    L282:
        if (r110.shouldEncodeElementDefault(r111, 31) == false) goto L285;
    L283:
        boolean r135 = true;
    L288:
        if (r135 == false) goto L291;
        r110.encodeNullableSerializableElement(r111, 31, w0.f520792a, r100.inputLeftActionStyle);
    L291:
        if (r110.shouldEncodeElementDefault(r111, 32) == false) goto L294;
    L292:
        boolean r136 = true;
    L297:
        if (r136 == false) goto L300;
        r110.encodeNullableSerializableElement(r111, 32, w0.f520792a, r100.groupReviewStatus);
    L300:
        if (r110.shouldEncodeElementDefault(r111, 33) == false) goto L302;
    L301:
        boolean r137 = true;
    L309:
        if (r137 == false) goto L312;
        r110.encodeNullableSerializableElement(r111, 33, w0.f520792a, r100.createScene);
    L312:
        if (r110.shouldEncodeElementDefault(r111, 34) == false) goto L314;
    L313:
        boolean r138 = true;
    L321:
        if (r138 == false) goto L324;
        r110.encodeNullableSerializableElement(r111, 34, w0.f520792a, r100.cellType);
    L324:
        if (r110.shouldEncodeElementDefault(r111, 35) == false) goto L326;
    L325:
        boolean r139 = true;
    L333:
        if (r139 == false) goto L336;
        r110.encodeNullableSerializableElement(r111, 35, w0.f520792a, r100.createChannel);
    L336:
        if (r110.shouldEncodeElementDefault(r111, 36) == false) goto L339;
    L337:
        boolean r140 = true;
    L342:
        if (r140 == false) goto L345;
        r110.encodeNullableSerializableElement(r111, 36, v2.f520790a, r100.parentCellId);
    L345:
        if (r110.shouldEncodeElementDefault(r111, 37) == false) goto L348;
    L346:
        boolean r141 = true;
    L351:
        if (r141 == false) goto L354;
        r110.encodeNullableSerializableElement(r111, 37, v2.f520790a, r100.lastSectionId);
    L354:
        if (r110.shouldEncodeElementDefault(r111, 38) == false) goto L357;
    L355:
        r101 = true;
    L359:
        if (r101 == false) goto L362;
        r110.encodeNullableSerializableElement(r111, 38, v2.f520790a, r100.botId);
        return;
    L362:
        return;
    L357:
        if (Intrinsics.areEqual(r100.botId, "") == true) goto L359;
    L348:
        if (Intrinsics.areEqual(r100.lastSectionId, "") == false) goto L346;
        r141 = false;
        goto L351
    L339:
        if (Intrinsics.areEqual(r100.parentCellId, "") == false) goto L337;
        r140 = false;
        goto L342
    L326:
        Integer r142 = r100.createChannel;
        if (r142 == null) goto L325;
        if (r142.intValue() != 0) goto L325;
        r139 = false;
        goto L333
    L314:
        Integer r143 = r100.cellType;
        if (r143 == null) goto L313;
        if (r143.intValue() != 0) goto L313;
        r138 = false;
        goto L321
    L302:
        Integer r144 = r100.createScene;
        if (r144 == null) goto L301;
        if (r144.intValue() != 0) goto L301;
        r137 = false;
        goto L309
    L294:
        if (r100.groupReviewStatus != null) goto L292;
        r136 = false;
        goto L297
    L285:
        if (r100.inputLeftActionStyle != null) goto L283;
        r135 = false;
        goto L288
    L276:
        if (r100.traceMap != null) goto L274;
        r134 = false;
        goto L279
    L267:
        if (r100.isDeleted == true) goto L265;
        r133 = false;
        goto L270
    L258:
        if (r100.ownerId != null) goto L256;
        r132 = false;
        goto L261
    L249:
        if (r100.latestMessageIndex != null) goto L247;
        r131 = false;
        goto L252
    L240:
        if (r100.retentionCursor != null) goto L238;
        r130 = false;
        goto L243
    L231:
        if (r100.bizExtra != null) goto L229;
        r129 = false;
        goto L234
    L222:
        if (r100.status != null) goto L220;
        r128 = false;
        goto L225
    L213:
        if (r100.version != null) goto L211;
        r127 = false;
        goto L216
    L204:
        if (r100.bizModel != null) goto L202;
        r126 = false;
        goto L207
    L195:
        if (r100.ext != null) goto L193;
        r125 = false;
        goto L198
    L186:
        if (r100.readMessageIndex != null) goto L184;
        r124 = false;
        goto L189
    L177:
        if (r100.briefMessageLocalId != null) goto L175;
        r123 = false;
        goto L180
    L168:
        if (r100.readBadgeCount != null) goto L166;
        r122 = false;
        goto L171
    L159:
        if (r100.badgeCount != null) goto L157;
        r121 = false;
        goto L162
    L150:
        if (r100.participantCount != null) goto L148;
        r120 = false;
        goto L153
    L141:
        if (r100.conversationType != null) goto L139;
        r119 = false;
        goto L144
    L132:
        if (r100.ttsEnable != true) goto L130;
        r118 = false;
        goto L135
    L123:
        if (r100.messageCursor != null) goto L121;
        r117 = false;
        goto L126
    L114:
        if (r100.templates != null) goto L112;
        r116 = false;
        goto L117
    L105:
        if (r100.conversationPage != null) goto L103;
        r115 = false;
        goto L108
    L96:
        if (r100.isLocal != null) goto L94;
        r114 = false;
        goto L99
    L87:
        if (r100.pinTime != 0) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.pinned != null) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.updateTime != null) goto L67;
        r109 = false;
        goto L72
    L60:
        if (r100.createTime != null) goto L58;
        r108 = false;
        goto L63
    L51:
        if (r100.name != null) goto L49;
        r107 = false;
        goto L54
    L42:
        if (r100.iconImage != null) goto L40;
        r106 = false;
        goto L45
    L33:
        if (r100.botType != 0) goto L31;
        r105 = false;
        goto L36
    L24:
        if (r100.deviceId != null) goto L22;
        r104 = false;
        goto L27
    L15:
        if (r100.projectId != null) goto L13;
        r103 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r100.conversationId, "") == false) goto L4;
        r102 = false;
        goto L9
    }

    public ConversationEntity(String r100, String r101, String r102, int r103, String r104, String r105, Long r110, Long r111, Integer r112, long r113, Integer r114, String r115, String r116, Long r117, boolean r118, Integer r210, Integer r211, Integer r212, Integer r213, String r214, Long r215, String r216, String r217, Long r218, Integer r219, String r310, Long r311, Long r312, String r313, boolean r314, String r315, Integer r316, Integer r317, Integer r318, Integer r319, Integer r410, String r411, String r412, String r413) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.conversationId = r100;
        this.projectId = r101;
        this.deviceId = r102;
        this.botType = r103;
        this.iconImage = r104;
        this.name = r105;
        this.createTime = r110;
        this.updateTime = r111;
        this.pinned = r112;
        this.pinTime = r113;
        this.isLocal = r114;
        this.conversationPage = r115;
        this.templates = r116;
        this.messageCursor = r117;
        this.ttsEnable = r118;
        this.conversationType = r210;
        this.participantCount = r211;
        this.badgeCount = r212;
        this.readBadgeCount = r213;
        this.briefMessageLocalId = r214;
        this.readMessageIndex = r215;
        this.ext = r216;
        this.bizModel = r217;
        this.version = r218;
        this.status = r219;
        this.bizExtra = r310;
        this.retentionCursor = r311;
        this.latestMessageIndex = r312;
        this.ownerId = r313;
        this.isDeleted = r314;
        this.traceMap = r315;
        this.inputLeftActionStyle = r316;
        this.groupReviewStatus = r317;
        this.createScene = r318;
        this.cellType = r319;
        this.createChannel = r410;
        this.parentCellId = r411;
        this.lastSectionId = r412;
        this.botId = r413;
    }

    public ConversationEntity(int r110, int r111, String r112, String r113, String r114, int r115, String r116, String r117, Long r118, Long r210, Integer r211, long r212, Integer r213, String r214, String r215, Long r216, boolean r217, Integer r218, Integer r310, Integer r311, Integer r312, String r313, Long r314, String r315, String r316, Long r317, Integer r318, String r319, Long r410, Long r411, String r412, boolean r413, String r414, Integer r415, Integer r416, Integer r417, Integer r418, Integer r419, String r510, String r511, String r512, q2 r513) {
        if ((r110 & 0) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r111 & 0) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r100 | r101) == false) goto L13;
        b2.a(new int[]{r110, r111}, new int[]{0, 0}, a.f348112b);
        throw null;
    L13:
        if ((r110 & 1) != 0) goto L15;
        this.conversationId = "";
    L17:
        if ((r110 & 2) != 0) goto L19;
        this.projectId = null;
    L21:
        if ((r110 & 4) != 0) goto L23;
        this.deviceId = null;
    L25:
        if ((r110 & 8) != 0) goto L27;
        this.botType = 0;
    L29:
        if ((r110 & 16) != 0) goto L31;
        this.iconImage = null;
    L33:
        if ((r110 & 32) != 0) goto L35;
        this.name = null;
    L37:
        if ((r110 & 64) != 0) goto L39;
        this.createTime = null;
    L41:
        if ((r110 & 128) != 0) goto L43;
        this.updateTime = null;
    L45:
        if ((r110 & 256) != 0) goto L47;
        this.pinned = null;
    L49:
        if ((r110 & 512) != 0) goto L51;
        long r102 = 0;
    L52:
        this.pinTime = r102;
        if ((r110 & 1024) != 0) goto L55;
        this.isLocal = null;
    L57:
        if ((r110 & 2048) != 0) goto L59;
        this.conversationPage = null;
    L61:
        if ((r110 & 4096) != 0) goto L63;
        this.templates = null;
    L65:
        if ((r110 & 8192) != 0) goto L67;
        this.messageCursor = null;
    L69:
        if ((r110 & 16384) != 0) goto L71;
        this.ttsEnable = true;
    L73:
        if ((32768 & r110) != 0) goto L75;
        this.conversationType = null;
    L77:
        if ((65536 & r110) != 0) goto L79;
        this.participantCount = null;
    L81:
        if ((131072 & r110) != 0) goto L83;
        this.badgeCount = null;
    L85:
        if ((262144 & r110) != 0) goto L87;
        this.readBadgeCount = null;
    L89:
        if ((524288 & r110) != 0) goto L91;
        this.briefMessageLocalId = null;
    L93:
        if ((1048576 & r110) != 0) goto L95;
        this.readMessageIndex = null;
    L97:
        if ((2097152 & r110) != 0) goto L99;
        this.ext = null;
    L101:
        if ((4194304 & r110) != 0) goto L103;
        this.bizModel = null;
    L105:
        if ((8388608 & r110) != 0) goto L107;
        this.version = null;
    L109:
        if ((16777216 & r110) != 0) goto L111;
        this.status = null;
    L113:
        if ((33554432 & r110) != 0) goto L115;
        this.bizExtra = null;
    L117:
        if ((67108864 & r110) != 0) goto L119;
        this.retentionCursor = null;
    L121:
        if ((134217728 & r110) != 0) goto L123;
        this.latestMessageIndex = null;
    L125:
        if ((268435456 & r110) != 0) goto L127;
        this.ownerId = null;
    L129:
        if ((536870912 & r110) != 0) goto L131;
        this.isDeleted = false;
    L133:
        if ((1073741824 & r110) != 0) goto L135;
        this.traceMap = null;
    L137:
        if ((r110 & Integer.MIN_VALUE) != 0) goto L139;
        this.inputLeftActionStyle = null;
    L141:
        if ((r111 & 1) != 0) goto L143;
        this.groupReviewStatus = null;
    L145:
        if ((r111 & 2) != 0) goto L147;
        this.createScene = 0;
    L149:
        if ((r111 & 4) != 0) goto L151;
        this.cellType = 0;
    L153:
        if ((r111 & 8) != 0) goto L155;
        this.createChannel = 0;
    L157:
        if ((r111 & 16) != 0) goto L159;
        this.parentCellId = "";
    L161:
        if ((r111 & 32) != 0) goto L163;
        this.lastSectionId = "";
    L165:
        if ((r111 & 64) != 0) goto L167;
        this.botId = "";
        return;
    L167:
        this.botId = r512;
        return;
    L163:
        this.lastSectionId = r511;
        goto L165
    L159:
        this.parentCellId = r510;
        goto L161
    L155:
        this.createChannel = r419;
        goto L157
    L151:
        this.cellType = r418;
        goto L153
    L147:
        this.createScene = r417;
        goto L149
    L143:
        this.groupReviewStatus = r416;
        goto L145
    L139:
        this.inputLeftActionStyle = r415;
        goto L141
    L135:
        this.traceMap = r414;
        goto L137
    L131:
        this.isDeleted = r413;
        goto L133
    L127:
        this.ownerId = r412;
        goto L129
    L123:
        this.latestMessageIndex = r411;
        goto L125
    L119:
        this.retentionCursor = r410;
        goto L121
    L115:
        this.bizExtra = r319;
        goto L117
    L111:
        this.status = r318;
        goto L113
    L107:
        this.version = r317;
        goto L109
    L103:
        this.bizModel = r316;
        goto L105
    L99:
        this.ext = r315;
        goto L101
    L95:
        this.readMessageIndex = r314;
        goto L97
    L91:
        this.briefMessageLocalId = r313;
        goto L93
    L87:
        this.readBadgeCount = r312;
        goto L89
    L83:
        this.badgeCount = r311;
        goto L85
    L79:
        this.participantCount = r310;
        goto L81
    L75:
        this.conversationType = r218;
        goto L77
    L71:
        this.ttsEnable = r217;
        goto L73
    L67:
        this.messageCursor = r216;
        goto L69
    L63:
        this.templates = r215;
        goto L65
    L59:
        this.conversationPage = r214;
        goto L61
    L55:
        this.isLocal = r213;
        goto L57
    L51:
        r102 = r212;
        goto L52
    L47:
        this.pinned = r211;
        goto L49
    L43:
        this.updateTime = r210;
        goto L45
    L39:
        this.createTime = r118;
        goto L41
    L35:
        this.name = r117;
        goto L37
    L31:
        this.iconImage = r116;
        goto L33
    L27:
        this.botType = r115;
        goto L29
    L23:
        this.deviceId = r114;
        goto L25
    L19:
        this.projectId = r113;
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

    public /* synthetic */ ConversationEntity(String r410, String r411, String r412, int r413, String r414, String r415, Long r416, Long r417, Integer r418, long r510, Integer r511, String r512, String r513, Long r514, boolean r515, Integer r516, Integer r517, Integer r518, Integer r610, String r611, Long r612, String r613, String r614, Long r615, Integer r616, String r617, Long r618, Long r619, String r710, boolean r711, String r712, Integer r713, Integer r714, Integer r715, Integer r716, Integer r717, String r718, String r719, String r810, int r811, int r812, DefaultConstructorMarker r813) {
        if ((r811 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r811 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r811 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r811 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r811 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r811 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r811 & 64) == 0) goto L29;
        Long r110 = null;
    L31:
        if ((r811 & 128) == 0) goto L33;
        Long r111 = null;
    L35:
        if ((r811 & 256) == 0) goto L37;
        Integer r112 = null;
    L39:
        if ((r811 & 512) == 0) goto L41;
        long r113 = 0;
    L43:
        if ((r811 & 1024) == 0) goto L45;
        Integer r114 = null;
    L47:
        if ((r811 & 2048) == 0) goto L49;
        String r106 = null;
    L51:
        if ((r811 & 4096) == 0) goto L53;
        String r107 = null;
    L55:
        if ((r811 & 8192) == 0) goto L57;
        Long r108 = null;
    L58:
        Long r115 = r108;
        if ((r811 & 16384) == 0) goto L61;
        boolean r109 = true;
    L63:
        if ((r811 & 32768) == 0) goto L65;
        Integer r116 = null;
    L67:
        if ((r811 & 65536) == 0) goto L69;
        Integer r117 = null;
    L71:
        if ((r811 & 131072) == 0) goto L73;
        Integer r118 = null;
    L75:
        if ((r811 & 262144) == 0) goto L77;
        Integer r210 = null;
    L79:
        if ((r811 & 524288) == 0) goto L81;
        String r211 = null;
    L83:
        if ((r811 & 1048576) == 0) goto L85;
        Long r212 = null;
    L87:
        if ((r811 & 2097152) == 0) goto L89;
        String r213 = null;
    L91:
        if ((r811 & 4194304) == 0) goto L93;
        String r214 = null;
    L95:
        if ((r811 & 8388608) == 0) goto L97;
        Long r215 = null;
    L99:
        if ((r811 & 16777216) == 0) goto L101;
        Integer r216 = null;
    L103:
        if ((r811 & 33554432) == 0) goto L105;
        String r217 = null;
    L107:
        if ((r811 & 67108864) == 0) goto L109;
        Long r218 = null;
    L111:
        if ((r811 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Long r219 = null;
    L115:
        if ((r811 & 268435456) == 0) goto L117;
        String r310 = null;
    L119:
        if ((r811 & 536870912) == 0) goto L121;
        boolean r311 = false;
    L123:
        if ((r811 & 1073741824) == 0) goto L125;
        String r312 = null;
    L127:
        if ((r811 & Integer.MIN_VALUE) == 0) goto L129;
        Integer r119 = null;
    L131:
        if ((r812 & 1) == 0) goto L133;
        Integer r313 = null;
    L135:
        if ((r812 & 2) == 0) goto L137;
        int r314 = 0;
        Integer r315 = 0;
    L139:
        if ((r812 & 4) == 0) goto L141;
        Integer r316 = Integer.valueOf(r314);
    L143:
        if ((r812 & 8) == 0) goto L145;
        Integer r317 = Integer.valueOf(r314);
    L147:
        if ((r812 & 16) == 0) goto L149;
        String r318 = "";
    L151:
        if ((r812 & 32) == 0) goto L153;
        String r319 = "";
    L155:
        if ((r812 & 64) == 0) goto L157;
        String r320 = "";
    L158:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r115, r109, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r119, r313, r315, r316, r317, r318, r319, r320);
        return;
    L157:
        r320 = r810;
        goto L158
    L153:
        r319 = r719;
        goto L155
    L149:
        r318 = r718;
        goto L151
    L145:
        r317 = r717;
        goto L147
    L141:
        r316 = r716;
        goto L143
    L137:
        r314 = 0;
        r315 = r715;
        goto L139
    L133:
        r313 = r714;
        goto L135
    L129:
        r119 = r713;
        goto L131
    L125:
        r312 = r712;
        goto L127
    L121:
        r311 = r711;
        goto L123
    L117:
        r310 = r710;
        goto L119
    L113:
        r219 = r619;
        goto L115
    L109:
        r218 = r618;
        goto L111
    L105:
        r217 = r617;
        goto L107
    L101:
        r216 = r616;
        goto L103
    L97:
        r215 = r615;
        goto L99
    L93:
        r214 = r614;
        goto L95
    L89:
        r213 = r613;
        goto L91
    L85:
        r212 = r612;
        goto L87
    L81:
        r211 = r611;
        goto L83
    L77:
        r210 = r610;
        goto L79
    L73:
        r118 = r518;
        goto L75
    L69:
        r117 = r517;
        goto L71
    L65:
        r116 = r516;
        goto L67
    L61:
        r109 = r515;
        goto L63
    L57:
        r108 = r514;
        goto L58
    L53:
        r107 = r513;
        goto L55
    L49:
        r106 = r512;
        goto L51
    L45:
        r114 = r511;
        goto L47
    L41:
        r113 = r510;
        goto L43
    L37:
        r112 = r418;
        goto L39
    L33:
        r111 = r417;
        goto L35
    L29:
        r110 = r416;
        goto L31
    L25:
        r105 = r415;
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
