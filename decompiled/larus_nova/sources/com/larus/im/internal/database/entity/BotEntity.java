package com.larus.im.internal.database.entity;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
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
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b3\n\u0002\u0018\u0002\n\u0003\b®\u0001\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u0083\u00022\u00020\u0001:\u0004\u0083\u0002\u0084\u0002Bÿ\u0005\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\n\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\bF\u0010GB\t\b\u0016¢\u0006\u0004\bF\u0010HB¥\u0005\b\u0010\u0012\u0006\u0010I\u001a\u00020\n\u0012\u0006\u0010J\u001a\u00020\n\u0012\u0006\u0010K\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010&\u001a\u00020\n\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\b\u00100\u001a\u0004\u0018\u00010\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010\u0003\u0012\b\u00102\u001a\u0004\u0018\u00010\u0003\u0012\b\u00103\u001a\u0004\u0018\u00010\u0003\u0012\b\u00104\u001a\u0004\u0018\u00010\u0003\u0012\b\u00105\u001a\u0004\u0018\u00010\u0003\u0012\b\u00106\u001a\u0004\u0018\u00010\u0003\u0012\b\u00107\u001a\u0004\u0018\u00010\u0003\u0012\b\u00108\u001a\u0004\u0018\u00010\u0003\u0012\b\u00109\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010?\u001a\u0004\u0018\u00010\n\u0012\b\u0010@\u001a\u0004\u0018\u00010\n\u0012\b\u0010A\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010B\u001a\u0004\u0018\u00010\n\u0012\b\u0010C\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010D\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010E\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010L\u001a\u0004\u0018\u00010M¢\u0006\u0004\bF\u0010NJ\n\u0010µ\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010·\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0007HÆ\u0003J\u0011\u0010¹\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010VJ\u0011\u0010º\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010YJ\f\u0010»\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010¿\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010YJ\f\u0010À\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Á\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Â\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Ã\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010YJ\u0011\u0010Ä\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010YJ\f\u0010Å\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010È\u0001\u001a\u00020\u0019HÆ\u0003J\u0011\u0010É\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010YJ\u0011\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010lJ\u0011\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010lJ\f\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Í\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Î\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ï\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ô\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Õ\u0001\u001a\u00020\nHÆ\u0003J\f\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010×\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ø\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Û\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010lJ\f\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ß\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010à\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010á\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010â\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ã\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ä\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010å\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010é\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ë\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ì\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010í\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010î\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010YJ\u0011\u0010ï\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010YJ\u0011\u0010ð\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010VJ\u0011\u0010ñ\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010YJ\u0011\u0010ò\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010VJ\f\u0010ó\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010ô\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010lJ\u0088\u0006\u0010õ\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010&\u001a\u00020\n2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0003\u0010ö\u0001J\u0015\u0010÷\u0001\u001a\u00020\u00192\t\u0010ø\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010ù\u0001\u001a\u00020\nHÖ\u0001J\n\u0010ú\u0001\u001a\u00020\u0003HÖ\u0001J-\u0010û\u0001\u001a\u00030ü\u00012\u0007\u0010ý\u0001\u001a\u00020\u00002\b\u0010þ\u0001\u001a\u00030ÿ\u00012\b\u0010\u0080\u0002\u001a\u00030\u0081\u0002H\u0001¢\u0006\u0003\b\u0082\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010PR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u0010PR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010W\u001a\u0004\bU\u0010VR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bX\u0010YR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u0010PR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010PR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b]\u0010PR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u0010PR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b_\u0010YR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u0010PR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\ba\u0010PR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010PR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bc\u0010YR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bd\u0010YR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\be\u0010PR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bf\u0010PR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bg\u0010PR\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bj\u0010YR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010m\u001a\u0004\bk\u0010lR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010m\u001a\u0004\bn\u0010lR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bo\u0010PR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bp\u0010PR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bq\u0010PR\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\br\u0010PR\u001c\u0010!\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010P\"\u0004\bt\u0010uR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bv\u0010PR\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bw\u0010PR\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bx\u0010PR\u0013\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\by\u0010PR\u001a\u0010&\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001c\u0010'\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010P\"\u0004\b\u007f\u0010uR\u001e\u0010(\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010P\"\u0005\b\u0081\u0001\u0010uR\u001e\u0010)\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010P\"\u0005\b\u0083\u0001\u0010uR\u001e\u0010*\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010P\"\u0005\b\u0085\u0001\u0010uR\u001e\u0010+\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010P\"\u0005\b\u0087\u0001\u0010uR\u001e\u0010,\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010P\"\u0005\b\u0089\u0001\u0010uR!\u0010-\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0013\n\u0002\u0010m\u001a\u0005\b\u008a\u0001\u0010l\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001e\u0010.\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010P\"\u0005\b\u008e\u0001\u0010uR\u001e\u0010/\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010P\"\u0005\b\u0090\u0001\u0010uR\u001e\u00100\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010P\"\u0005\b\u0092\u0001\u0010uR\u001e\u00101\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010P\"\u0005\b\u0094\u0001\u0010uR\u001e\u00102\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010P\"\u0005\b\u0096\u0001\u0010uR\u001e\u00103\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010P\"\u0005\b\u0098\u0001\u0010uR\u001e\u00104\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010P\"\u0005\b\u009a\u0001\u0010uR\u001e\u00105\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010P\"\u0005\b\u009c\u0001\u0010uR\u001e\u00106\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010P\"\u0005\b\u009e\u0001\u0010uR\u001e\u00107\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010P\"\u0005\b \u0001\u0010uR\u001e\u00108\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010P\"\u0005\b¢\u0001\u0010uR\u001e\u00109\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010P\"\u0005\b¤\u0001\u0010uR\u001e\u0010:\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010P\"\u0005\b¦\u0001\u0010uR\u001e\u0010;\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0001\u0010P\"\u0005\b¨\u0001\u0010uR\u001e\u0010<\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010P\"\u0005\bª\u0001\u0010uR\u001e\u0010=\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010P\"\u0005\b¬\u0001\u0010uR\u0014\u0010>\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u00ad\u0001\u0010PR\u0016\u0010?\u001a\u0004\u0018\u00010\n¢\u0006\u000b\n\u0002\u0010Z\u001a\u0005\b®\u0001\u0010YR\u0016\u0010@\u001a\u0004\u0018\u00010\n¢\u0006\u000b\n\u0002\u0010Z\u001a\u0005\b¯\u0001\u0010YR\u0016\u0010A\u001a\u0004\u0018\u00010\u0007¢\u0006\u000b\n\u0002\u0010W\u001a\u0005\b°\u0001\u0010VR\u0016\u0010B\u001a\u0004\u0018\u00010\n¢\u0006\u000b\n\u0002\u0010Z\u001a\u0005\b±\u0001\u0010YR\u0016\u0010C\u001a\u0004\u0018\u00010\u0007¢\u0006\u000b\n\u0002\u0010W\u001a\u0005\b²\u0001\u0010VR\u001e\u0010D\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b³\u0001\u0010P\"\u0005\b´\u0001\u0010uR\u0015\u0010E\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010m\u001a\u0004\bE\u0010l¨\u0006\u0085\u0002"}, d2 = {"Lcom/larus/im/internal/database/entity/BotEntity;", "", "botId", "", "name", "iconImage", "createTime", "", UserInfo.UPDATE_TIME, "botType", "", "shareInfo", "botCreatorInfo", "tagList", "selectTextActions", "privateStatus", "conversationPage", "descriptionForModel", "descriptionForHuman", "botStatus", "status", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "voiceType", "editPos", "muted", "", "recommendIndex", "messagePush", "showMessagePush", "bio", "bioEdit", "botStatistic", "answerActions", "actionScenes", "answerActionExposurePriority", "menuActions", "streamingAnswerActions", "botConf", "botMode", "bgImgUrl", "bgImgColor", "bgVideoModel", "iconPrompt", "switchConfInfo", "callerName", "callerNameSettings", "sceneModelList", "firstMet", "cameraTabConfigMap", "botFeatureLabel", "onboarding", "bgImgUri", "bgImgInfo", "botMemoryConfig", "callImgConfig", "botIconMappedAppIcon", "dynamicImgUri", "dynamicImgUrl", "messagePushSwitchConfirmTitle", "msgRegenModeList", "unavailableInstructionTypeList", "serviceBotConf", "loadingConf", "likeInfoShow", "likeInfoLiked", "likeInfoCount", "botCommentInfoShow", "botCommentInfoCount", "extra", "isDisable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;)V", "()V", "seen0", "seen1", "seen2", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBotId", "()Ljava/lang/String;", "getName", "getIconImage", "getCreateTime", "()J", "getUpdateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBotType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShareInfo", "getBotCreatorInfo", "getTagList", "getSelectTextActions", "getPrivateStatus", "getConversationPage", "getDescriptionForModel", "getDescriptionForHuman", "getBotStatus", "getStatus", "getModel", "getVoiceType", "getEditPos", "getMuted", "()Z", "getRecommendIndex", "getMessagePush", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowMessagePush", "getBio", "getBioEdit", "getBotStatistic", "getAnswerActions", "getActionScenes", "setActionScenes", "(Ljava/lang/String;)V", "getAnswerActionExposurePriority", "getMenuActions", "getStreamingAnswerActions", "getBotConf", "getBotMode", "()I", "setBotMode", "(I)V", "getBgImgUrl", "setBgImgUrl", "getBgImgColor", "setBgImgColor", "getBgVideoModel", "setBgVideoModel", "getIconPrompt", "setIconPrompt", "getSwitchConfInfo", "setSwitchConfInfo", "getCallerName", "setCallerName", "getCallerNameSettings", "setCallerNameSettings", "(Ljava/lang/Boolean;)V", "getSceneModelList", "setSceneModelList", "getFirstMet", "setFirstMet", "getCameraTabConfigMap", "setCameraTabConfigMap", "getBotFeatureLabel", "setBotFeatureLabel", "getOnboarding", "setOnboarding", "getBgImgUri", "setBgImgUri", "getBgImgInfo", "setBgImgInfo", "getBotMemoryConfig", "setBotMemoryConfig", "getCallImgConfig", "setCallImgConfig", "getBotIconMappedAppIcon", "setBotIconMappedAppIcon", "getDynamicImgUri", "setDynamicImgUri", "getDynamicImgUrl", "setDynamicImgUrl", "getMessagePushSwitchConfirmTitle", "setMessagePushSwitchConfirmTitle", "getMsgRegenModeList", "setMsgRegenModeList", "getUnavailableInstructionTypeList", "setUnavailableInstructionTypeList", "getServiceBotConf", "setServiceBotConf", "getLoadingConf", "getLikeInfoShow", "getLikeInfoLiked", "getLikeInfoCount", "getBotCommentInfoShow", "getBotCommentInfoCount", "getExtra", "setExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/im/internal/database/entity/BotEntity;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "Companion", "$serializer", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class BotEntity {
    public static final b Companion = null;
    private static final String DEFAULT_BOT_ID = "";
    private String actionScenes;
    private final String answerActionExposurePriority;
    private final String answerActions;
    private String bgImgColor;
    private String bgImgInfo;
    private String bgImgUri;
    private String bgImgUrl;
    private String bgVideoModel;
    private final String bio;
    private final String bioEdit;
    private final Long botCommentInfoCount;
    private final Integer botCommentInfoShow;
    private final String botConf;
    private final String botCreatorInfo;
    private String botFeatureLabel;
    private String botIconMappedAppIcon;
    private final String botId;
    private String botMemoryConfig;
    private int botMode;
    private final String botStatistic;
    private final Integer botStatus;
    private final Integer botType;
    private String callImgConfig;
    private String callerName;
    private Boolean callerNameSettings;
    private String cameraTabConfigMap;
    private final String conversationPage;
    private final long createTime;
    private final String descriptionForHuman;
    private final String descriptionForModel;
    private String dynamicImgUri;
    private String dynamicImgUrl;
    private final String editPos;
    private String extra;
    private String firstMet;
    private final String iconImage;
    private String iconPrompt;
    private final Boolean isDisable;
    private final Long likeInfoCount;
    private final Integer likeInfoLiked;
    private final Integer likeInfoShow;
    private final String loadingConf;
    private final String menuActions;
    private final Boolean messagePush;
    private String messagePushSwitchConfirmTitle;
    private final String model;
    private String msgRegenModeList;
    private final boolean muted;
    private final String name;
    private String onboarding;
    private final Integer privateStatus;
    private final Integer recommendIndex;
    private String sceneModelList;
    private final String selectTextActions;
    private String serviceBotConf;
    private final String shareInfo;
    private final Boolean showMessagePush;
    private final Integer status;
    private final String streamingAnswerActions;
    private String switchConfInfo;
    private final String tagList;
    private String unavailableInstructionTypeList;
    private final Long updateTime;
    private final String voiceType;

    /* JADX INFO: loaded from: classes29.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<BotEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f348109a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f348110b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f348110b;
        }

        static {
            a r100 = new a();
            f348109a = r100;
            g2 r101 = new g2("com.larus.im.internal.database.entity.BotEntity", r100, 64);
            r101.j("botId", true);
            r101.j("name", true);
            r101.j("iconImage", true);
            r101.j("createTime", true);
            r101.j(UserInfo.UPDATE_TIME, true);
            r101.j("botType", true);
            r101.j("shareInfo", true);
            r101.j("botCreatorInfo", true);
            r101.j("tagList", true);
            r101.j("selectTextActions", true);
            r101.j("privateStatus", true);
            r101.j("conversationPage", true);
            r101.j("descriptionForModel", true);
            r101.j("descriptionForHuman", true);
            r101.j("botStatus", true);
            r101.j("status", true);
            r101.j(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, true);
            r101.j("voiceType", true);
            r101.j("editPos", true);
            r101.j("muted", true);
            r101.j("recommendIndex", true);
            r101.j("messagePush", true);
            r101.j("showMessagePush", true);
            r101.j("bio", true);
            r101.j("bioEdit", true);
            r101.j("botStatistic", true);
            r101.j("answerActions", true);
            r101.j("actionScenes", true);
            r101.j("answerActionExposurePriority", true);
            r101.j("menuActions", true);
            r101.j("streamingAnswerActions", true);
            r101.j("botConf", true);
            r101.j("botMode", true);
            r101.j("bgImgUrl", true);
            r101.j("bgImgColor", true);
            r101.j("bgVideoModel", true);
            r101.j("iconPrompt", true);
            r101.j("switchConfInfo", true);
            r101.j("callerName", true);
            r101.j("callerNameSettings", true);
            r101.j("sceneModelList", true);
            r101.j("firstMet", true);
            r101.j("cameraTabConfigMap", true);
            r101.j("botFeatureLabel", true);
            r101.j("onboarding", true);
            r101.j("bgImgUri", true);
            r101.j("bgImgInfo", true);
            r101.j("botMemoryConfig", true);
            r101.j("callImgConfig", true);
            r101.j("botIconMappedAppIcon", true);
            r101.j("dynamicImgUri", true);
            r101.j("dynamicImgUrl", true);
            r101.j("messagePushSwitchConfirmTitle", true);
            r101.j("msgRegenModeList", true);
            r101.j("unavailableInstructionTypeList", true);
            r101.j("serviceBotConf", true);
            r101.j("loadingConf", true);
            r101.j("likeInfoShow", true);
            r101.j("likeInfoLiked", true);
            r101.j("likeInfoCount", true);
            r101.j("botCommentInfoShow", true);
            r101.j("botCommentInfoCount", true);
            r101.j("extra", true);
            r101.j("isDisable", true);
            f348110b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            g1 r101 = g1.f520681a;
            w0 r102 = w0.f520792a;
            i r103 = i.f520705a;
            return new d[]{r100, kuc.a.d(r100), kuc.a.d(r100), r101, kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r102), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), r103, kuc.a.d(r102), kuc.a.d(r103), kuc.a.d(r103), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), r102, kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r103), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r103)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r910) {
            Intrinsics.checkNotNullParameter(r910, "decoder");
            g2 r100 = f348110b;
            c r101 = r910.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            String r102 = r101.decodeStringElement(r100, 0);
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            long r210 = r101.decodeLongElement(r100, 3);
            g1 r111 = g1.f520681a;
            Long r105 = (Long) r101.decodeNullableSerializableElement(r100, 4, r111, null);
            w0 r112 = w0.f520792a;
            Integer r113 = (Integer) r101.decodeNullableSerializableElement(r100, 5, r112, null);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 6, r103, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 7, r103, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 8, r103, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 9, r103, null);
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 10, r112, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 11, r103, null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 12, r103, null);
            String r117 = (String) r101.decodeNullableSerializableElement(r100, 13, r103, null);
            Integer r118 = (Integer) r101.decodeNullableSerializableElement(r100, 14, r112, null);
            Integer r119 = (Integer) r101.decodeNullableSerializableElement(r100, 15, r112, null);
            String r120 = (String) r101.decodeNullableSerializableElement(r100, 16, r103, null);
            String r121 = (String) r101.decodeNullableSerializableElement(r100, 17, r103, null);
            String r122 = (String) r101.decodeNullableSerializableElement(r100, 18, r103, null);
            boolean r123 = r101.decodeBooleanElement(r100, 19);
            Integer r124 = (Integer) r101.decodeNullableSerializableElement(r100, 20, r112, null);
            i r125 = i.f520705a;
            Boolean r126 = (Boolean) r101.decodeNullableSerializableElement(r100, 21, r125, null);
            Boolean r127 = (Boolean) r101.decodeNullableSerializableElement(r100, 22, r125, null);
            String r128 = (String) r101.decodeNullableSerializableElement(r100, 23, r103, null);
            String r129 = (String) r101.decodeNullableSerializableElement(r100, 24, r103, null);
            String r130 = (String) r101.decodeNullableSerializableElement(r100, 25, r103, null);
            String r131 = (String) r101.decodeNullableSerializableElement(r100, 26, r103, null);
            String r132 = (String) r101.decodeNullableSerializableElement(r100, 27, r103, null);
            String r133 = (String) r101.decodeNullableSerializableElement(r100, 28, r103, null);
            String r134 = (String) r101.decodeNullableSerializableElement(r100, 29, r103, null);
            String r135 = (String) r101.decodeNullableSerializableElement(r100, 30, r103, null);
            String r136 = (String) r101.decodeNullableSerializableElement(r100, 31, r103, null);
            int r137 = r101.decodeIntElement(r100, 32);
            String r138 = (String) r101.decodeNullableSerializableElement(r100, 33, r103, null);
            String r139 = (String) r101.decodeNullableSerializableElement(r100, 34, r103, null);
            String r140 = (String) r101.decodeNullableSerializableElement(r100, 35, r103, null);
            String r141 = (String) r101.decodeNullableSerializableElement(r100, 36, r103, null);
            String r142 = (String) r101.decodeNullableSerializableElement(r100, 37, r103, null);
            String r143 = (String) r101.decodeNullableSerializableElement(r100, 38, r103, null);
            Boolean r144 = (Boolean) r101.decodeNullableSerializableElement(r100, 39, r125, null);
            String r145 = (String) r101.decodeNullableSerializableElement(r100, 40, r103, null);
            String r146 = (String) r101.decodeNullableSerializableElement(r100, 41, r103, null);
            String r147 = (String) r101.decodeNullableSerializableElement(r100, 42, r103, null);
            String r148 = (String) r101.decodeNullableSerializableElement(r100, 43, r103, null);
            String r149 = (String) r101.decodeNullableSerializableElement(r100, 44, r103, null);
            String r150 = (String) r101.decodeNullableSerializableElement(r100, 45, r103, null);
            String r151 = (String) r101.decodeNullableSerializableElement(r100, 46, r103, null);
            String r152 = (String) r101.decodeNullableSerializableElement(r100, 47, r103, null);
            String r153 = (String) r101.decodeNullableSerializableElement(r100, 48, r103, null);
            String r154 = (String) r101.decodeNullableSerializableElement(r100, 49, r103, null);
            String r155 = (String) r101.decodeNullableSerializableElement(r100, 50, r103, null);
            String r156 = (String) r101.decodeNullableSerializableElement(r100, 51, r103, null);
            String r157 = (String) r101.decodeNullableSerializableElement(r100, 52, r103, null);
            String r158 = (String) r101.decodeNullableSerializableElement(r100, 53, r103, null);
            String r159 = (String) r101.decodeNullableSerializableElement(r100, 54, r103, null);
            String r160 = (String) r101.decodeNullableSerializableElement(r100, 55, r103, null);
            String r161 = (String) r101.decodeNullableSerializableElement(r100, 56, r103, null);
            Integer r162 = (Integer) r101.decodeNullableSerializableElement(r100, 57, r112, null);
            Integer r163 = (Integer) r101.decodeNullableSerializableElement(r100, 58, r112, null);
            Long r164 = (Long) r101.decodeNullableSerializableElement(r100, 59, r111, null);
            Integer r165 = (Integer) r101.decodeNullableSerializableElement(r100, 60, r112, null);
            Long r166 = (Long) r101.decodeNullableSerializableElement(r100, 61, r111, null);
            String r167 = (String) r101.decodeNullableSerializableElement(r100, 62, r103, null);
            int r168 = -1;
            int r169 = -1;
            Boolean r710 = (Boolean) r101.decodeNullableSerializableElement(r100, 63, r125, null);
            Integer r711 = r165;
            String r712 = r167;
            Long r713 = r166;
            String r610 = r157;
            String r611 = r158;
            String r714 = r159;
            String r715 = r160;
            String r716 = r161;
            Integer r717 = r162;
            Integer r718 = r163;
            Long r719 = r164;
            String r612 = r149;
            String r613 = r150;
            String r614 = r151;
            String r615 = r152;
            String r616 = r153;
            String r617 = r154;
            String r618 = r155;
            String r619 = r156;
            String r510 = r141;
            String r511 = r142;
            String r512 = r143;
            Boolean r513 = r144;
            String r514 = r145;
            String r515 = r146;
            String r516 = r147;
            String r517 = r148;
            String r410 = r136;
            int r411 = r137;
            String r412 = r133;
            String r413 = r134;
            String r414 = r135;
            String r415 = r138;
            String r518 = r139;
            String r519 = r140;
            Boolean r310 = r126;
            Boolean r311 = r127;
            String r312 = r128;
            String r416 = r129;
            String r417 = r131;
            String r418 = r132;
            boolean r313 = r123;
            String r314 = r121;
            String r315 = r120;
            Integer r316 = r119;
            Integer r317 = r118;
            long r170 = r210;
            Integer r318 = r124;
            String r211 = r107;
            Long r212 = r105;
            String r213 = r106;
            Integer r214 = r113;
            String r215 = r117;
            String r216 = r116;
            String r217 = r115;
            String r218 = r114;
            String r171 = r102;
            String r219 = r109;
            Integer r220 = r108;
            String r319 = r122;
            String r172 = r104;
            String r173 = r110;
            String r419 = r130;
        L101:
            r101.endStructure(r100);
            return new BotEntity(r168, r169, 0, r171, r172, r173, r170, r212, r214, r218, r217, r213, r211, r220, r219, r216, r215, r317, r316, r315, r314, r319, r313, r318, r310, r311, r312, r416, r419, r417, r418, r412, r413, r414, r410, r411, r415, r518, r519, r510, r511, r512, r513, r514, r515, r516, r517, r612, r613, r614, r615, r616, r617, r618, r619, r610, r611, r714, r715, r716, r717, r718, r719, r711, r713, r712, r710, null);
        L5:
            Integer r174 = null;
            Boolean r175 = null;
            String r221 = null;
            String r176 = null;
            String r177 = null;
            Integer r178 = null;
            Integer r179 = null;
            String r180 = null;
            String r181 = null;
            Long r182 = null;
            String r183 = null;
            Long r184 = null;
            String r185 = null;
            String r320 = null;
            Long r321 = null;
            Integer r322 = null;
            String r323 = null;
            String r420 = null;
            String r421 = null;
            String r422 = null;
            Integer r423 = null;
            String r424 = null;
            String r425 = null;
            String r426 = null;
            Integer r427 = null;
            Integer r428 = null;
            String r429 = null;
            String r520 = null;
            String r521 = null;
            Integer r522 = null;
            Boolean r523 = null;
            String r524 = null;
            String r525 = null;
            String r526 = null;
            String r527 = null;
            String r528 = null;
            String r529 = null;
            String r620 = null;
            Boolean r621 = null;
            String r622 = null;
            String r623 = null;
            String r624 = null;
            String r625 = null;
            String r626 = null;
            String r627 = null;
            String r628 = null;
            String r629 = null;
            String r720 = null;
            String r721 = null;
            String r722 = null;
            String r723 = null;
            String r724 = null;
            String r725 = null;
            String r726 = null;
            String r727 = null;
            String r728 = null;
            String r729 = null;
            String r810 = null;
            String r811 = null;
            Boolean r812 = null;
            String r813 = null;
            long r814 = 0;
            int r186 = 0;
            boolean r815 = false;
            int r816 = 0;
            int r817 = 0;
            boolean r818 = true;
        L6:
            if (r818 == false) goto L100;
            String r911 = r181;
            int r187 = r101.decodeElementIndex(r100);
            switch(r187) {
                case -1: goto L96;
                case 0: goto L95;
                case 1: goto L93;
                case 2: goto L91;
                case 3: goto L89;
                case 4: goto L87;
                case 5: goto L85;
                case 6: goto L83;
                case 7: goto L82;
                case 8: goto L80;
                case 9: goto L79;
                case 10: goto L78;
                case 11: goto L77;
                case 12: goto L76;
                case 13: goto L75;
                case 14: goto L74;
                case 15: goto L73;
                case 16: goto L72;
                case 17: goto L71;
                case 18: goto L70;
                case 19: goto L68;
                case 20: goto L65;
                case 21: goto L64;
                case 22: goto L62;
                case 23: goto L61;
                case 24: goto L59;
                case 25: goto L58;
                case 26: goto L57;
                case 27: goto L56;
                case 28: goto L55;
                case 29: goto L54;
                case 30: goto L53;
                case 31: goto L51;
                case 32: goto L49;
                case 33: goto L42;
                case 34: goto L41;
                case 35: goto L40;
                case 36: goto L39;
                case 37: goto L38;
                case 38: goto L37;
                case 39: goto L36;
                case 40: goto L35;
                case 41: goto L34;
                case 42: goto L33;
                case 43: goto L32;
                case 44: goto L31;
                case 45: goto L30;
                case 46: goto L29;
                case 47: goto L28;
                case 48: goto L27;
                case 49: goto L26;
                case 50: goto L25;
                case 51: goto L24;
                case 52: goto L23;
                case 53: goto L21;
                case 54: goto L20;
                case 55: goto L19;
                case 56: goto L18;
                case 57: goto L17;
                case 58: goto L16;
                case 59: goto L15;
                case 60: goto L14;
                case 61: goto L13;
                case 62: goto L12;
                case 63: goto L11;
                default: goto L10;
            };
        L11:
            r175 = (Boolean) r101.decodeNullableSerializableElement(r100, 63, i.f520705a, r175);
            int r188 = Integer.MIN_VALUE;
        L22:
            r186 = r186 | r188;
            Unit r189 = Unit.INSTANCE;
            r181 = r911;
            String r190 = r180;
        L48:
            String r912 = r190;
        L50:
            r180 = r912;
        L52:
            r221 = r221;
            String r191 = r320;
            Long r222 = r321;
            Integer r223 = r322;
            String r324 = r323;
            r420 = r420;
            String r325 = r421;
            String r326 = r422;
            Integer r327 = r423;
            String r328 = r424;
            String r224 = r425;
            String r225 = r426;
            Integer r192 = r427;
            Integer r226 = r428;
            String r227 = r429;
            String r193 = r520;
            String r228 = r521;
            int r229 = r817;
            r186 = r186;
        L99:
            r320 = r191;
            r427 = r192;
            r520 = r193;
            r429 = r227;
            r428 = r226;
            r521 = r228;
            r426 = r225;
            r221 = r221;
            r425 = r224;
            r321 = r222;
            r322 = r223;
            r323 = r324;
            r420 = r420;
            r421 = r325;
            r422 = r326;
            r423 = r327;
            r424 = r328;
            r186 = r186;
            r817 = r229;
            goto L6
        L12:
            r177 = (String) r101.decodeNullableSerializableElement(r100, 62, v2.f520790a, r177);
            r188 = 1073741824;
            goto L22
        L13:
            r182 = (Long) r101.decodeNullableSerializableElement(r100, 61, g1.f520681a, r182);
            r188 = 536870912;
            goto L22
        L14:
            r179 = (Integer) r101.decodeNullableSerializableElement(r100, 60, w0.f520792a, r179);
            r188 = 268435456;
            goto L22
        L15:
            r184 = (Long) r101.decodeNullableSerializableElement(r100, 59, g1.f520681a, r184);
            r188 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
            goto L22
        L16:
            r178 = (Integer) r101.decodeNullableSerializableElement(r100, 58, w0.f520792a, r178);
            r188 = 67108864;
            goto L22
        L17:
            r174 = (Integer) r101.decodeNullableSerializableElement(r100, 57, w0.f520792a, r174);
            r188 = 33554432;
            goto L22
        L18:
            r176 = (String) r101.decodeNullableSerializableElement(r100, 56, v2.f520790a, r176);
            r188 = 16777216;
            goto L22
        L19:
            r185 = (String) r101.decodeNullableSerializableElement(r100, 55, v2.f520790a, r185);
            r188 = 8388608;
            goto L22
        L20:
            r183 = (String) r101.decodeNullableSerializableElement(r100, 54, v2.f520790a, r183);
            r188 = 4194304;
            goto L22
        L21:
            r221 = (String) r101.decodeNullableSerializableElement(r100, 53, v2.f520790a, r221);
            r188 = 2097152;
            goto L22
        L23:
            r175 = r175;
            r190 = (String) r101.decodeNullableSerializableElement(r100, 52, v2.f520790a, r180);
            int r194 = 1048576 | r186;
            Unit r195 = Unit.INSTANCE;
            String r196 = r622;
        L46:
            r622 = r196;
            r181 = r911;
            r186 = r194;
            String r197 = r526;
        L47:
            r526 = r197;
            r175 = r175;
            goto L48
        L24:
            r175 = r175;
            r181 = (String) r101.decodeNullableSerializableElement(r100, 51, v2.f520790a, r911);
            int r198 = 524288 | r186;
            Unit r199 = Unit.INSTANCE;
            r186 = r198;
            r197 = r526;
            r190 = r180;
            goto L47
        L25:
            String r200 = (String) r101.decodeNullableSerializableElement(r100, 50, v2.f520790a, r813);
            int r201 = r186 | 262144;
            Unit r202 = Unit.INSTANCE;
            r813 = r200;
        L43:
            r194 = r201;
        L44:
            r196 = r622;
        L45:
            r190 = r180;
            goto L46
        L26:
            String r203 = (String) r101.decodeNullableSerializableElement(r100, 49, v2.f520790a, r811);
            r201 = r186 | 131072;
            Unit r204 = Unit.INSTANCE;
            r811 = r203;
            goto L43
        L27:
            String r205 = (String) r101.decodeNullableSerializableElement(r100, 48, v2.f520790a, r810);
            r201 = r186 | 65536;
            Unit r206 = Unit.INSTANCE;
            r810 = r205;
            goto L43
        L28:
            String r207 = (String) r101.decodeNullableSerializableElement(r100, 47, v2.f520790a, r727);
            r201 = r186 | 32768;
            Unit r208 = Unit.INSTANCE;
            r727 = r207;
            goto L43
        L29:
            String r209 = (String) r101.decodeNullableSerializableElement(r100, 46, v2.f520790a, r627);
            r201 = r186 | 16384;
            Unit r230 = Unit.INSTANCE;
            r627 = r209;
            goto L43
        L30:
            String r231 = (String) r101.decodeNullableSerializableElement(r100, 45, v2.f520790a, r626);
            r201 = r186 | 8192;
            Unit r232 = Unit.INSTANCE;
            r626 = r231;
            goto L43
        L31:
            String r233 = (String) r101.decodeNullableSerializableElement(r100, 44, v2.f520790a, r625);
            r201 = r186 | 4096;
            Unit r234 = Unit.INSTANCE;
            r625 = r233;
            goto L43
        L32:
            r175 = r175;
            r180 = r180;
            r729 = (String) r101.decodeNullableSerializableElement(r100, 43, v2.f520790a, r729);
            r194 = r186 | 2048;
            Unit r235 = Unit.INSTANCE;
            goto L44
        L33:
            String r236 = (String) r101.decodeNullableSerializableElement(r100, 42, v2.f520790a, r624);
            r201 = r186 | 1024;
            Unit r237 = Unit.INSTANCE;
            r624 = r236;
            goto L43
        L34:
            String r238 = (String) r101.decodeNullableSerializableElement(r100, 41, v2.f520790a, r623);
            r201 = r186 | 512;
            Unit r239 = Unit.INSTANCE;
            r623 = r238;
            goto L43
        L35:
            r175 = r175;
            r180 = r180;
            String r240 = (String) r101.decodeNullableSerializableElement(r100, 40, v2.f520790a, r622);
            int r241 = r186 | 256;
            Unit r242 = Unit.INSTANCE;
            r196 = r240;
            r194 = r241;
            goto L45
        L36:
            Boolean r243 = (Boolean) r101.decodeNullableSerializableElement(r100, 39, i.f520705a, r621);
            r201 = r186 | 128;
            Unit r244 = Unit.INSTANCE;
            r621 = r243;
            goto L43
        L37:
            String r245 = (String) r101.decodeNullableSerializableElement(r100, 38, v2.f520790a, r620);
            r201 = r186 | 64;
            Unit r246 = Unit.INSTANCE;
            r620 = r245;
            goto L43
        L38:
            String r247 = (String) r101.decodeNullableSerializableElement(r100, 37, v2.f520790a, r529);
            r201 = r186 | 32;
            Unit r248 = Unit.INSTANCE;
            r529 = r247;
            goto L43
        L39:
            String r249 = (String) r101.decodeNullableSerializableElement(r100, 36, v2.f520790a, r528);
            r201 = r186 | 16;
            Unit r250 = Unit.INSTANCE;
            r528 = r249;
            goto L43
        L40:
            String r251 = (String) r101.decodeNullableSerializableElement(r100, 35, v2.f520790a, r527);
            r201 = r186 | 8;
            Unit r252 = Unit.INSTANCE;
            r527 = r251;
            goto L43
        L41:
            String r253 = (String) r101.decodeNullableSerializableElement(r100, 34, v2.f520790a, r526);
            r201 = r186 | 4;
            Unit r254 = Unit.INSTANCE;
            r526 = r253;
            goto L43
        L42:
            String r255 = (String) r101.decodeNullableSerializableElement(r100, 33, v2.f520790a, r525);
            r201 = r186 | 2;
            Unit r256 = Unit.INSTANCE;
            r525 = r255;
            goto L43
        L49:
            Boolean r913 = r175;
            r912 = r180;
            String r257 = r525;
            int r1100 = r101.decodeIntElement(r100, 32);
            r186 = r186 | 1;
            Unit r530 = Unit.INSTANCE;
            r525 = r257;
            r816 = r1100;
            r181 = r911;
            r175 = r913;
            goto L50
        L51:
            Boolean r914 = r175;
            String r915 = r180;
            String r258 = (String) r101.decodeNullableSerializableElement(r100, 31, v2.f520790a, r524);
            r817 = r817 | Integer.MIN_VALUE;
            Unit r259 = Unit.INSTANCE;
            r524 = r258;
            r181 = r911;
            r180 = r915;
            r175 = r914;
            goto L52
        L53:
            r722 = (String) r101.decodeNullableSerializableElement(r100, 30, v2.f520790a, r722);
            int r260 = 1073741824;
        L63:
            int r261 = r260 | r817;
        L60:
            Unit r262 = Unit.INSTANCE;
        L66:
            Boolean r263 = r523;
        L67:
            int r264 = r261;
        L69:
            r523 = r263;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r328 = r424;
            r224 = r425;
            r225 = r426;
            Integer r265 = r427;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            String r1101 = r521;
            r522 = r522;
        L84:
            Integer r266 = r265;
            Long r267 = r321;
            r223 = r322;
            r324 = r323;
        L88:
            r222 = r267;
            int r1102 = r264;
            Integer r268 = r266;
            Boolean r269 = r523;
        L94:
            r523 = r269;
        L98:
            r229 = r1102;
            r522 = r522;
            r228 = r1101;
            r181 = r911;
            r192 = r268;
            r191 = r320;
            r180 = r180;
            r175 = r175;
            goto L99
        L54:
            r724 = (String) r101.decodeNullableSerializableElement(r100, 29, v2.f520790a, r724);
            r260 = 536870912;
            goto L63
        L55:
            r629 = (String) r101.decodeNullableSerializableElement(r100, 28, v2.f520790a, r629);
            r260 = 268435456;
            goto L63
        L56:
            r721 = (String) r101.decodeNullableSerializableElement(r100, 27, v2.f520790a, r721);
            r260 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
            goto L63
        L57:
            r723 = (String) r101.decodeNullableSerializableElement(r100, 26, v2.f520790a, r723);
            r260 = 67108864;
            goto L63
        L58:
            r720 = (String) r101.decodeNullableSerializableElement(r100, 25, v2.f520790a, r720);
            r260 = 33554432;
            goto L63
        L59:
            r175 = r175;
            r180 = r180;
            int r1103 = r817;
            r186 = r186;
            r728 = (String) r101.decodeNullableSerializableElement(r100, 24, v2.f520790a, r728);
            r261 = 16777216 | r1103;
            goto L60
        L61:
            r725 = (String) r101.decodeNullableSerializableElement(r100, 23, v2.f520790a, r725);
            r260 = 8388608;
            goto L63
        L62:
            r812 = (Boolean) r101.decodeNullableSerializableElement(r100, 22, i.f520705a, r812);
            r260 = 4194304;
            goto L63
        L64:
            r175 = r175;
            r180 = r180;
            int r1104 = r817;
            r186 = r186;
            r263 = (Boolean) r101.decodeNullableSerializableElement(r100, 21, i.f520705a, r523);
            r261 = 2097152 | r1104;
            Unit r270 = Unit.INSTANCE;
            goto L67
        L65:
            r175 = r175;
            r180 = r180;
            int r1105 = r817;
            r186 = r186;
            Integer r271 = (Integer) r101.decodeNullableSerializableElement(r100, 20, w0.f520792a, r522);
            Unit r272 = Unit.INSTANCE;
            r522 = r271;
            r261 = 1048576 | r1105;
            goto L66
        L68:
            r175 = r175;
            r180 = r180;
            int r1106 = r817;
            r186 = r186;
            r815 = r101.decodeBooleanElement(r100, 19);
            r264 = 524288 | r1106;
            Unit r1107 = Unit.INSTANCE;
            r263 = r523;
            goto L69
        L70:
            r175 = r175;
            r180 = r180;
            int r1108 = r817;
            r186 = r186;
            r522 = r522;
            String r273 = (String) r101.decodeNullableSerializableElement(r100, 18, v2.f520790a, r521);
            r264 = 262144 | r1108;
            Unit r1109 = Unit.INSTANCE;
            r1101 = r273;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r328 = r424;
            r224 = r425;
            r225 = r426;
            r265 = r427;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            goto L84
        L71:
            r1101 = r521;
            String r274 = (String) r101.decodeNullableSerializableElement(r100, 17, v2.f520790a, r520);
            Unit r1110 = Unit.INSTANCE;
            r193 = r274;
            int r1111 = 131072 | r817;
            r223 = r322;
            r324 = r323;
            r420 = r420;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            String r329 = r424;
            r224 = r425;
            r225 = r426;
            Integer r275 = r427;
            r226 = r428;
            r227 = r429;
        L90:
            r222 = r321;
            int r276 = r1111;
            String r277 = r329;
        L92:
            r328 = r277;
            r1102 = r276;
            r320 = r320;
        L97:
            r628 = r628;
            r268 = r275;
            goto L98
        L72:
            r175 = r175;
            r180 = r180;
            r1101 = r521;
            r522 = r522;
            int r1112 = r817;
            r186 = r186;
            r193 = r520;
            String r278 = (String) r101.decodeNullableSerializableElement(r100, 16, v2.f520790a, r429);
            r264 = 65536 | r1112;
            Unit r1113 = Unit.INSTANCE;
            r227 = r278;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r328 = r424;
            r224 = r425;
            r225 = r426;
            r265 = r427;
            r226 = r428;
            goto L84
        L73:
            r193 = r520;
            r1101 = r521;
            r227 = r429;
            Integer r279 = (Integer) r101.decodeNullableSerializableElement(r100, 15, w0.f520792a, r428);
            Unit r1114 = Unit.INSTANCE;
            r226 = r279;
            r1111 = 32768 | r817;
            r223 = r322;
            r324 = r323;
            r420 = r420;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r329 = r424;
            r224 = r425;
            r225 = r426;
            r275 = r427;
            goto L90
        L74:
            r175 = r175;
            r180 = r180;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r522 = r522;
            int r1115 = r817;
            r186 = r186;
            r226 = r428;
            r265 = (Integer) r101.decodeNullableSerializableElement(r100, 14, w0.f520792a, r427);
            r264 = r1115 | 16384;
            Unit r1116 = Unit.INSTANCE;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r328 = r424;
            r224 = r425;
            r225 = r426;
            goto L84
        L75:
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r275 = r427;
            String r280 = (String) r101.decodeNullableSerializableElement(r100, 13, v2.f520790a, r426);
            Unit r1117 = Unit.INSTANCE;
            r225 = r280;
            r1111 = r817 | 8192;
            r223 = r322;
            r324 = r323;
            r420 = r420;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r329 = r424;
            r224 = r425;
            goto L90
        L76:
            r175 = r175;
            r180 = r180;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r522 = r522;
            int r1118 = r817;
            r186 = r186;
            r225 = r426;
            String r281 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r425);
            r264 = r1118 | 4096;
            Unit r1119 = Unit.INSTANCE;
            r224 = r281;
            r265 = r427;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r328 = r424;
            goto L84
        L77:
            r225 = r426;
            r275 = r427;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r224 = r425;
            String r282 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r424);
            Unit r1120 = Unit.INSTANCE;
            r329 = r282;
            r1111 = r817 | 2048;
            r223 = r322;
            r324 = r323;
            r420 = r420;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            goto L90
        L78:
            r175 = r175;
            r180 = r180;
            r224 = r425;
            r225 = r426;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r522 = r522;
            int r1121 = r817;
            r186 = r186;
            r328 = r424;
            Integer r283 = (Integer) r101.decodeNullableSerializableElement(r100, 10, w0.f520792a, r423);
            r264 = r1121 | 1024;
            Unit r1122 = Unit.INSTANCE;
            r327 = r283;
            r265 = r427;
            r325 = r421;
            r326 = r422;
            goto L84
        L79:
            r329 = r424;
            r224 = r425;
            r225 = r426;
            r275 = r427;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r327 = r423;
            String r284 = (String) r101.decodeNullableSerializableElement(r100, 9, v2.f520790a, r422);
            Unit r1123 = Unit.INSTANCE;
            r326 = r284;
            r1111 = r817 | 512;
            r223 = r322;
            r324 = r323;
            r420 = r420;
            r325 = r421;
            goto L90
        L80:
            r175 = r175;
            r180 = r180;
            r327 = r423;
            r328 = r424;
            r224 = r425;
            r225 = r426;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r522 = r522;
            int r1124 = r817;
            r186 = r186;
            r326 = r422;
            String r285 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r421);
            r264 = r1124 | 256;
            Unit r1125 = Unit.INSTANCE;
            r325 = r285;
            r265 = r427;
            goto L84
        L82:
            r326 = r422;
            r327 = r423;
            r329 = r424;
            r224 = r425;
            r225 = r426;
            r275 = r427;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r325 = r421;
            String r286 = (String) r101.decodeNullableSerializableElement(r100, 7, v2.f520790a, r420);
            Unit r1126 = Unit.INSTANCE;
            r420 = r286;
            r1111 = r817 | 128;
            r223 = r322;
            r324 = r323;
            goto L90
        L83:
            r175 = r175;
            r180 = r180;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r328 = r424;
            r224 = r425;
            r225 = r426;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r522 = r522;
            int r1127 = r817;
            r186 = r186;
            r420 = r420;
            String r287 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r323);
            r264 = r1127 | 64;
            Unit r1128 = Unit.INSTANCE;
            r323 = r287;
            r265 = r427;
            goto L84
        L85:
            r420 = r420;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r329 = r424;
            r224 = r425;
            r225 = r426;
            r275 = r427;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r324 = r323;
            Integer r288 = (Integer) r101.decodeNullableSerializableElement(r100, 5, w0.f520792a, r322);
            Unit r1129 = Unit.INSTANCE;
            r223 = r288;
            r1111 = r817 | 32;
            goto L90
        L87:
            r175 = r175;
            r180 = r180;
            r324 = r323;
            r420 = r420;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r328 = r424;
            r224 = r425;
            r225 = r426;
            r266 = r427;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r522 = r522;
            int r1130 = r817;
            r186 = r186;
            r223 = r322;
            r267 = (Long) r101.decodeNullableSerializableElement(r100, 4, g1.f520681a, r321);
            r264 = r1130 | 16;
            Unit r1131 = Unit.INSTANCE;
            goto L88
        L89:
            r175 = r175;
            r180 = r180;
            r321 = r321;
            r223 = r322;
            r324 = r323;
            r420 = r420;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r329 = r424;
            r224 = r425;
            r225 = r426;
            r275 = r427;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r522 = r522;
            int r1132 = r817;
            r186 = r186;
            r814 = r101.decodeLongElement(r100, 3);
            r1111 = r1132 | 8;
            Unit r289 = Unit.INSTANCE;
            goto L90
        L91:
            r175 = r175;
            r180 = r180;
            r223 = r322;
            r324 = r323;
            r420 = r420;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r224 = r425;
            r225 = r426;
            r275 = r427;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r522 = r522;
            int r1133 = r817;
            r186 = r186;
            r222 = r321;
            String r290 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r320);
            r276 = r1133 | 4;
            Unit r1134 = Unit.INSTANCE;
            r320 = r290;
            r277 = r424;
            goto L92
        L93:
            r175 = r175;
            r180 = r180;
            r222 = r321;
            r223 = r322;
            r324 = r323;
            r420 = r420;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r328 = r424;
            r224 = r425;
            r225 = r426;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r522 = r522;
            int r1135 = r817;
            r186 = r186;
            r628 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r628);
            Unit r291 = Unit.INSTANCE;
            r1102 = r1135 | 2;
            r268 = r427;
            r269 = r523;
            goto L94
        L95:
            r175 = r175;
            r180 = r180;
            r320 = r320;
            r222 = r321;
            r223 = r322;
            r324 = r323;
            r420 = r420;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r328 = r424;
            r224 = r425;
            r225 = r426;
            r275 = r427;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r522 = r522;
            int r1136 = r817;
            r186 = r186;
            r726 = r101.decodeStringElement(r100, 0);
            r1102 = r1136 | 1;
            Unit r292 = Unit.INSTANCE;
            goto L97
        L96:
            r175 = r175;
            r180 = r180;
            r320 = r320;
            r222 = r321;
            r223 = r322;
            r324 = r323;
            r420 = r420;
            r325 = r421;
            r326 = r422;
            r327 = r423;
            r328 = r424;
            r224 = r425;
            r225 = r426;
            r275 = r427;
            r226 = r428;
            r227 = r429;
            r193 = r520;
            r1101 = r521;
            r522 = r522;
            r1102 = r817;
            r186 = r186;
            Unit r293 = Unit.INSTANCE;
            r818 = false;
            goto L97
        L10:
            throw new UnknownFieldException(r187);
        L100:
            String r916 = r180;
            String r917 = r181;
            String r294 = r320;
            Long r295 = r321;
            Integer r296 = r322;
            String r330 = r323;
            String r331 = r420;
            String r332 = r422;
            String r333 = r424;
            String r297 = r426;
            Integer r298 = r427;
            Integer r299 = r428;
            String r2100 = r429;
            String r1137 = r520;
            String r1138 = r521;
            r172 = r628;
            r318 = r522;
            r216 = r425;
            r213 = r421;
            r220 = r423;
            r310 = r523;
            r410 = r524;
            r415 = r525;
            r518 = r526;
            r519 = r527;
            r510 = r528;
            r511 = r529;
            r512 = r620;
            r513 = r621;
            r514 = r622;
            r515 = r623;
            r516 = r624;
            r612 = r625;
            r613 = r626;
            r614 = r627;
            r412 = r629;
            r419 = r720;
            r418 = r721;
            r414 = r722;
            r417 = r723;
            r413 = r724;
            r312 = r725;
            r615 = r727;
            r416 = r728;
            r517 = r729;
            r616 = r810;
            r617 = r811;
            r311 = r812;
            r411 = r816;
            r618 = r813;
            r619 = r917;
            r610 = r916;
            r710 = r175;
            r716 = r176;
            r712 = r177;
            r718 = r178;
            r173 = r294;
            r713 = r182;
            r717 = r174;
            r714 = r183;
            r719 = r184;
            r715 = r185;
            r319 = r1138;
            r315 = r2100;
            r611 = r221;
            r212 = r295;
            r211 = r332;
            r219 = r333;
            r171 = r726;
            r313 = r815;
            r169 = r186;
            r711 = r179;
            r168 = r817;
            r314 = r1137;
            r170 = r814;
            r316 = r299;
            r214 = r296;
            r215 = r297;
            r217 = r331;
            r317 = r298;
            r218 = r330;
            goto L101
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            BotEntity r102 = (BotEntity) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f348110b;
            muc.d r104 = r100.beginStructure(r103);
            BotEntity.write$Self$omnisdk_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<BotEntity> serializer() {
            return a.f348109a;
        }
    }

    public static /* synthetic */ BotEntity copy$default(BotEntity r210, String r211, String r212, String r213, long r214, Long r310, Integer r311, String r312, String r313, String r314, String r315, Integer r316, String r317, String r318, String r319, Integer r410, Integer r411, String r412, String r413, String r414, boolean r415, Integer r416, Boolean r417, Boolean r418, String r419, String r510, String r511, String r512, String r513, String r514, String r515, String r516, String r517, int r518, String r519, String r610, String r611, String r612, String r613, String r614, Boolean r615, String r616, String r617, String r618, String r619, String r710, String r711, String r712, String r713, String r714, String r715, String r716, String r717, String r718, String r719, String r810, String r811, String r812, Integer r813, Integer r814, Long r815, Integer r816, Long r817, String r818, Boolean r819, int r910, int r911, Object r912) {
        if ((r910 & 1) == 0) goto L5;
        String r100 = r210.botId;
    L7:
        if ((r910 & 2) == 0) goto L9;
        String r101 = r210.name;
    L11:
        if ((r910 & 4) == 0) goto L13;
        String r102 = r210.iconImage;
    L15:
        if ((r910 & 8) == 0) goto L17;
        long r103 = r210.createTime;
    L19:
        if ((r910 & 16) == 0) goto L21;
        Long r104 = r210.updateTime;
    L23:
        if ((r910 & 32) == 0) goto L25;
        Integer r105 = r210.botType;
    L27:
        if ((r910 & 64) == 0) goto L29;
        String r110 = r210.shareInfo;
    L31:
        if ((r910 & 128) == 0) goto L33;
        String r111 = r210.botCreatorInfo;
    L35:
        if ((r910 & 256) == 0) goto L37;
        String r112 = r210.tagList;
    L39:
        if ((r910 & 512) == 0) goto L41;
        String r113 = r210.selectTextActions;
    L43:
        if ((r910 & 1024) == 0) goto L45;
        Integer r114 = r210.privateStatus;
    L47:
        if ((r910 & 2048) == 0) goto L49;
        String r115 = r210.conversationPage;
    L50:
        String r320 = r115;
        if ((r910 & 4096) == 0) goto L53;
        String r116 = r210.descriptionForModel;
    L54:
        String r321 = r116;
        if ((r910 & 8192) == 0) goto L57;
        String r117 = r210.descriptionForHuman;
    L58:
        String r322 = r117;
        if ((r910 & 16384) == 0) goto L61;
        Integer r118 = r210.botStatus;
    L62:
        Integer r420 = r118;
        if ((r910 & 32768) == 0) goto L65;
        Integer r119 = r210.status;
    L66:
        Integer r421 = r119;
        if ((r910 & 65536) == 0) goto L69;
        String r120 = r210.model;
    L70:
        String r422 = r120;
        if ((r910 & 131072) == 0) goto L73;
        String r121 = r210.voiceType;
    L74:
        String r423 = r121;
        if ((r910 & 262144) == 0) goto L77;
        String r122 = r210.editPos;
    L78:
        String r424 = r122;
        if ((r910 & 524288) == 0) goto L81;
        boolean r123 = r210.muted;
    L82:
        boolean r425 = r123;
        if ((r910 & 1048576) == 0) goto L85;
        Integer r124 = r210.recommendIndex;
    L86:
        Integer r426 = r124;
        if ((r910 & 2097152) == 0) goto L89;
        Boolean r125 = r210.messagePush;
    L90:
        Boolean r427 = r125;
        if ((r910 & 4194304) == 0) goto L93;
        Boolean r126 = r210.showMessagePush;
    L94:
        Boolean r428 = r126;
        if ((r910 & 8388608) == 0) goto L97;
        String r127 = r210.bio;
    L98:
        String r429 = r127;
        if ((r910 & 16777216) == 0) goto L101;
        String r128 = r210.bioEdit;
    L102:
        String r520 = r128;
        if ((r910 & 33554432) == 0) goto L105;
        String r129 = r210.botStatistic;
    L106:
        String r521 = r129;
        if ((r910 & 67108864) == 0) goto L109;
        String r130 = r210.answerActions;
    L110:
        String r522 = r130;
        if ((r910 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r131 = r210.actionScenes;
    L114:
        String r523 = r131;
        if ((r910 & 268435456) == 0) goto L117;
        String r132 = r210.answerActionExposurePriority;
    L118:
        String r524 = r132;
        if ((r910 & 536870912) == 0) goto L121;
        String r133 = r210.menuActions;
    L122:
        String r525 = r133;
        if ((r910 & 1073741824) == 0) goto L125;
        String r134 = r210.streamingAnswerActions;
    L127:
        if ((r910 & Integer.MIN_VALUE) == 0) goto L129;
        String r106 = r210.botConf;
    L130:
        String r526 = r106;
        if ((r911 & 1) == 0) goto L133;
        int r107 = r210.botMode;
    L134:
        int r527 = r107;
        if ((r911 & 2) == 0) goto L137;
        String r108 = r210.bgImgUrl;
    L138:
        String r528 = r108;
        if ((r911 & 4) == 0) goto L141;
        String r109 = r210.bgImgColor;
    L142:
        String r620 = r109;
        if ((r911 & 8) == 0) goto L145;
        String r135 = r210.bgVideoModel;
    L146:
        String r621 = r135;
        if ((r911 & 16) == 0) goto L149;
        String r136 = r210.iconPrompt;
    L150:
        String r622 = r136;
        if ((r911 & 32) == 0) goto L153;
        String r137 = r210.switchConfInfo;
    L154:
        String r623 = r137;
        if ((r911 & 64) == 0) goto L157;
        String r138 = r210.callerName;
    L158:
        String r624 = r138;
        if ((r911 & 128) == 0) goto L161;
        Boolean r139 = r210.callerNameSettings;
    L162:
        Boolean r625 = r139;
        if ((r911 & 256) == 0) goto L165;
        String r140 = r210.sceneModelList;
    L166:
        String r626 = r140;
        if ((r911 & 512) == 0) goto L169;
        String r141 = r210.firstMet;
    L170:
        String r627 = r141;
        if ((r911 & 1024) == 0) goto L173;
        String r142 = r210.cameraTabConfigMap;
    L174:
        String r628 = r142;
        if ((r911 & 2048) == 0) goto L177;
        String r143 = r210.botFeatureLabel;
    L178:
        String r629 = r143;
        if ((r911 & 4096) == 0) goto L181;
        String r144 = r210.onboarding;
    L182:
        String r720 = r144;
        if ((r911 & 8192) == 0) goto L185;
        String r145 = r210.bgImgUri;
    L186:
        String r721 = r145;
        if ((r911 & 16384) == 0) goto L189;
        String r146 = r210.bgImgInfo;
    L190:
        String r722 = r146;
        if ((r911 & 32768) == 0) goto L193;
        String r147 = r210.botMemoryConfig;
    L194:
        String r723 = r147;
        if ((r911 & 65536) == 0) goto L197;
        String r148 = r210.callImgConfig;
    L198:
        String r724 = r148;
        if ((r911 & 131072) == 0) goto L201;
        String r149 = r210.botIconMappedAppIcon;
    L202:
        String r725 = r149;
        if ((r911 & 262144) == 0) goto L205;
        String r150 = r210.dynamicImgUri;
    L206:
        String r726 = r150;
        if ((r911 & 524288) == 0) goto L209;
        String r151 = r210.dynamicImgUrl;
    L210:
        String r727 = r151;
        if ((r911 & 1048576) == 0) goto L213;
        String r152 = r210.messagePushSwitchConfirmTitle;
    L214:
        String r728 = r152;
        if ((r911 & 2097152) == 0) goto L217;
        String r153 = r210.msgRegenModeList;
    L218:
        String r729 = r153;
        if ((r911 & 4194304) == 0) goto L221;
        String r154 = r210.unavailableInstructionTypeList;
    L222:
        String r820 = r154;
        if ((r911 & 8388608) == 0) goto L225;
        String r155 = r210.serviceBotConf;
    L226:
        String r821 = r155;
        if ((r911 & 16777216) == 0) goto L229;
        String r156 = r210.loadingConf;
    L230:
        String r822 = r156;
        if ((r911 & 33554432) == 0) goto L233;
        Integer r157 = r210.likeInfoShow;
    L234:
        Integer r823 = r157;
        if ((r911 & 67108864) == 0) goto L237;
        Integer r158 = r210.likeInfoLiked;
    L238:
        Integer r824 = r158;
        if ((r911 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        Long r159 = r210.likeInfoCount;
    L242:
        Long r825 = r159;
        if ((r911 & 268435456) == 0) goto L245;
        Integer r160 = r210.botCommentInfoShow;
    L246:
        Integer r826 = r160;
        if ((r911 & 536870912) == 0) goto L249;
        Long r161 = r210.botCommentInfoCount;
    L250:
        Long r827 = r161;
        if ((r911 & 1073741824) == 0) goto L253;
        String r162 = r210.extra;
    L255:
        if ((r911 & Integer.MIN_VALUE) == 0) goto L257;
        Boolean r163 = r210.isDisable;
    L259:
        return r210.copy(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r320, r321, r322, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r520, r521, r522, r523, r524, r525, r134, r526, r527, r528, r620, r621, r622, r623, r624, r625, r626, r627, r628, r629, r720, r721, r722, r723, r724, r725, r726, r727, r728, r729, r820, r821, r822, r823, r824, r825, r826, r827, r162, r163);
    L257:
        r163 = r819;
        goto L259
    L253:
        r162 = r818;
        goto L255
    L249:
        r161 = r817;
        goto L250
    L245:
        r160 = r816;
        goto L246
    L241:
        r159 = r815;
        goto L242
    L237:
        r158 = r814;
        goto L238
    L233:
        r157 = r813;
        goto L234
    L229:
        r156 = r812;
        goto L230
    L225:
        r155 = r811;
        goto L226
    L221:
        r154 = r810;
        goto L222
    L217:
        r153 = r719;
        goto L218
    L213:
        r152 = r718;
        goto L214
    L209:
        r151 = r717;
        goto L210
    L205:
        r150 = r716;
        goto L206
    L201:
        r149 = r715;
        goto L202
    L197:
        r148 = r714;
        goto L198
    L193:
        r147 = r713;
        goto L194
    L189:
        r146 = r712;
        goto L190
    L185:
        r145 = r711;
        goto L186
    L181:
        r144 = r710;
        goto L182
    L177:
        r143 = r619;
        goto L178
    L173:
        r142 = r618;
        goto L174
    L169:
        r141 = r617;
        goto L170
    L165:
        r140 = r616;
        goto L166
    L161:
        r139 = r615;
        goto L162
    L157:
        r138 = r614;
        goto L158
    L153:
        r137 = r613;
        goto L154
    L149:
        r136 = r612;
        goto L150
    L145:
        r135 = r611;
        goto L146
    L141:
        r109 = r610;
        goto L142
    L137:
        r108 = r519;
        goto L138
    L133:
        r107 = r518;
        goto L134
    L129:
        r106 = r517;
        goto L130
    L125:
        r134 = r516;
        goto L127
    L121:
        r133 = r515;
        goto L122
    L117:
        r132 = r514;
        goto L118
    L113:
        r131 = r513;
        goto L114
    L109:
        r130 = r512;
        goto L110
    L105:
        r129 = r511;
        goto L106
    L101:
        r128 = r510;
        goto L102
    L97:
        r127 = r419;
        goto L98
    L93:
        r126 = r418;
        goto L94
    L89:
        r125 = r417;
        goto L90
    L85:
        r124 = r416;
        goto L86
    L81:
        r123 = r415;
        goto L82
    L77:
        r122 = r414;
        goto L78
    L73:
        r121 = r413;
        goto L74
    L69:
        r120 = r412;
        goto L70
    L65:
        r119 = r411;
        goto L66
    L61:
        r118 = r410;
        goto L62
    L57:
        r117 = r319;
        goto L58
    L53:
        r116 = r318;
        goto L54
    L49:
        r115 = r317;
        goto L50
    L45:
        r114 = r316;
        goto L47
    L41:
        r113 = r315;
        goto L43
    L37:
        r112 = r314;
        goto L39
    L33:
        r111 = r313;
        goto L35
    L29:
        r110 = r312;
        goto L31
    L25:
        r105 = r311;
        goto L27
    L21:
        r104 = r310;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public final String component1() {
        return this.botId;
    }

    public final String component10() {
        return this.selectTextActions;
    }

    public final Integer component11() {
        return this.privateStatus;
    }

    public final String component12() {
        return this.conversationPage;
    }

    public final String component13() {
        return this.descriptionForModel;
    }

    public final String component14() {
        return this.descriptionForHuman;
    }

    public final Integer component15() {
        return this.botStatus;
    }

    public final Integer component16() {
        return this.status;
    }

    public final String component17() {
        return this.model;
    }

    public final String component18() {
        return this.voiceType;
    }

    public final String component19() {
        return this.editPos;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component20() {
        return this.muted;
    }

    public final Integer component21() {
        return this.recommendIndex;
    }

    public final Boolean component22() {
        return this.messagePush;
    }

    public final Boolean component23() {
        return this.showMessagePush;
    }

    public final String component24() {
        return this.bio;
    }

    public final String component25() {
        return this.bioEdit;
    }

    public final String component26() {
        return this.botStatistic;
    }

    public final String component27() {
        return this.answerActions;
    }

    public final String component28() {
        return this.actionScenes;
    }

    public final String component29() {
        return this.answerActionExposurePriority;
    }

    public final String component3() {
        return this.iconImage;
    }

    public final String component30() {
        return this.menuActions;
    }

    public final String component31() {
        return this.streamingAnswerActions;
    }

    public final String component32() {
        return this.botConf;
    }

    public final int component33() {
        return this.botMode;
    }

    public final String component34() {
        return this.bgImgUrl;
    }

    public final String component35() {
        return this.bgImgColor;
    }

    public final String component36() {
        return this.bgVideoModel;
    }

    public final String component37() {
        return this.iconPrompt;
    }

    public final String component38() {
        return this.switchConfInfo;
    }

    public final String component39() {
        return this.callerName;
    }

    public final long component4() {
        return this.createTime;
    }

    public final Boolean component40() {
        return this.callerNameSettings;
    }

    public final String component41() {
        return this.sceneModelList;
    }

    public final String component42() {
        return this.firstMet;
    }

    public final String component43() {
        return this.cameraTabConfigMap;
    }

    public final String component44() {
        return this.botFeatureLabel;
    }

    public final String component45() {
        return this.onboarding;
    }

    public final String component46() {
        return this.bgImgUri;
    }

    public final String component47() {
        return this.bgImgInfo;
    }

    public final String component48() {
        return this.botMemoryConfig;
    }

    public final String component49() {
        return this.callImgConfig;
    }

    public final Long component5() {
        return this.updateTime;
    }

    public final String component50() {
        return this.botIconMappedAppIcon;
    }

    public final String component51() {
        return this.dynamicImgUri;
    }

    public final String component52() {
        return this.dynamicImgUrl;
    }

    public final String component53() {
        return this.messagePushSwitchConfirmTitle;
    }

    public final String component54() {
        return this.msgRegenModeList;
    }

    public final String component55() {
        return this.unavailableInstructionTypeList;
    }

    public final String component56() {
        return this.serviceBotConf;
    }

    public final String component57() {
        return this.loadingConf;
    }

    public final Integer component58() {
        return this.likeInfoShow;
    }

    public final Integer component59() {
        return this.likeInfoLiked;
    }

    public final Integer component6() {
        return this.botType;
    }

    public final Long component60() {
        return this.likeInfoCount;
    }

    public final Integer component61() {
        return this.botCommentInfoShow;
    }

    public final Long component62() {
        return this.botCommentInfoCount;
    }

    public final String component63() {
        return this.extra;
    }

    public final Boolean component64() {
        return this.isDisable;
    }

    public final String component7() {
        return this.shareInfo;
    }

    public final String component8() {
        return this.botCreatorInfo;
    }

    public final String component9() {
        return this.tagList;
    }

    public final BotEntity copy(String r610, String r710, String r711, long r712, Long r713, Integer r714, String r715, String r716, String r717, String r718, Integer r810, String r811, String r812, String r813, Integer r814, Integer r815, String r816, String r817, String r818, boolean r819, Integer r910, Boolean r911, Boolean r912, String r913, String r914, String r915, String r916, String r917, String r918, String r919, String r100, String r101, int r102, String r103, String r104, String r105, String r106, String r107, String r108, Boolean r109, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, String r120, String r121, String r122, String r123, String r124, String r125, String r126, Integer r127, Integer r128, Long r129, Integer r130, Long r131, String r132, Boolean r133) {
        Intrinsics.checkNotNullParameter(r610, "botId");
        return new BotEntity(r610, r710, r711, r712, r713, r714, r715, r716, r717, r718, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotEntity) == true) goto L8;
        return false;
    L8:
        BotEntity r101 = (BotEntity) r100;
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconImage, r101.iconImage) == true) goto L18;
        return false;
    L18:
        if (this.createTime == r101.createTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.botType, r101.botType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.shareInfo, r101.shareInfo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.botCreatorInfo, r101.botCreatorInfo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.tagList, r101.tagList) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.selectTextActions, r101.selectTextActions) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.privateStatus, r101.privateStatus) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.conversationPage, r101.conversationPage) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.descriptionForModel, r101.descriptionForModel) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.descriptionForHuman, r101.descriptionForHuman) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.botStatus, r101.botStatus) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.voiceType, r101.voiceType) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.editPos, r101.editPos) == true) goto L66;
        return false;
    L66:
        if (this.muted == r101.muted) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.recommendIndex, r101.recommendIndex) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.messagePush, r101.messagePush) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.showMessagePush, r101.showMessagePush) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.bio, r101.bio) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.bioEdit, r101.bioEdit) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.botStatistic, r101.botStatistic) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.answerActions, r101.answerActions) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.actionScenes, r101.actionScenes) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.answerActionExposurePriority, r101.answerActionExposurePriority) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.menuActions, r101.menuActions) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.streamingAnswerActions, r101.streamingAnswerActions) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.botConf, r101.botConf) == true) goto L105;
        return false;
    L105:
        if (this.botMode == r101.botMode) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.bgImgUrl, r101.bgImgUrl) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.bgImgColor, r101.bgImgColor) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.bgVideoModel, r101.bgVideoModel) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.iconPrompt, r101.iconPrompt) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.switchConfInfo, r101.switchConfInfo) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.callerName, r101.callerName) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.callerNameSettings, r101.callerNameSettings) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.sceneModelList, r101.sceneModelList) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.firstMet, r101.firstMet) == true) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.cameraTabConfigMap, r101.cameraTabConfigMap) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.botFeatureLabel, r101.botFeatureLabel) == true) goto L141;
        return false;
    L141:
        if (Intrinsics.areEqual(this.onboarding, r101.onboarding) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.bgImgUri, r101.bgImgUri) == true) goto L147;
        return false;
    L147:
        if (Intrinsics.areEqual(this.bgImgInfo, r101.bgImgInfo) == true) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.botMemoryConfig, r101.botMemoryConfig) == true) goto L153;
        return false;
    L153:
        if (Intrinsics.areEqual(this.callImgConfig, r101.callImgConfig) == true) goto L156;
        return false;
    L156:
        if (Intrinsics.areEqual(this.botIconMappedAppIcon, r101.botIconMappedAppIcon) == true) goto L159;
        return false;
    L159:
        if (Intrinsics.areEqual(this.dynamicImgUri, r101.dynamicImgUri) == true) goto L162;
        return false;
    L162:
        if (Intrinsics.areEqual(this.dynamicImgUrl, r101.dynamicImgUrl) == true) goto L165;
        return false;
    L165:
        if (Intrinsics.areEqual(this.messagePushSwitchConfirmTitle, r101.messagePushSwitchConfirmTitle) == true) goto L168;
        return false;
    L168:
        if (Intrinsics.areEqual(this.msgRegenModeList, r101.msgRegenModeList) == true) goto L171;
        return false;
    L171:
        if (Intrinsics.areEqual(this.unavailableInstructionTypeList, r101.unavailableInstructionTypeList) == true) goto L174;
        return false;
    L174:
        if (Intrinsics.areEqual(this.serviceBotConf, r101.serviceBotConf) == true) goto L177;
        return false;
    L177:
        if (Intrinsics.areEqual(this.loadingConf, r101.loadingConf) == true) goto L180;
        return false;
    L180:
        if (Intrinsics.areEqual(this.likeInfoShow, r101.likeInfoShow) == true) goto L183;
        return false;
    L183:
        if (Intrinsics.areEqual(this.likeInfoLiked, r101.likeInfoLiked) == true) goto L186;
        return false;
    L186:
        if (Intrinsics.areEqual(this.likeInfoCount, r101.likeInfoCount) == true) goto L189;
        return false;
    L189:
        if (Intrinsics.areEqual(this.botCommentInfoShow, r101.botCommentInfoShow) == true) goto L192;
        return false;
    L192:
        if (Intrinsics.areEqual(this.botCommentInfoCount, r101.botCommentInfoCount) == true) goto L195;
        return false;
    L195:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L198;
        return false;
    L198:
        if (Intrinsics.areEqual(this.isDisable, r101.isDisable) == true) goto L200;
        return false;
    L200:
        return true;
    }

    public int hashCode() {
        int r100 = this.botId.hashCode() * 31;
        String r101 = this.name;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.iconImage;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        long r107 = this.createTime;
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        Long r109 = this.updateTime;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        Integer r112 = this.botType;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.shareInfo;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.botCreatorInfo;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.tagList;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        String r124 = this.selectTextActions;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        Integer r127 = this.privateStatus;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        String r130 = this.conversationPage;
        if (r130 != null) goto L41;
        int r131 = 0;
    L42:
        int r132 = (r129 + r131) * 31;
        String r133 = this.descriptionForModel;
        if (r133 != null) goto L45;
        int r134 = 0;
    L46:
        int r135 = (r132 + r134) * 31;
        String r136 = this.descriptionForHuman;
        if (r136 != null) goto L49;
        int r137 = 0;
    L50:
        int r138 = (r135 + r137) * 31;
        Integer r139 = this.botStatus;
        if (r139 != null) goto L53;
        int r140 = 0;
    L54:
        int r141 = (r138 + r140) * 31;
        Integer r142 = this.status;
        if (r142 != null) goto L57;
        int r143 = 0;
    L58:
        int r144 = (r141 + r143) * 31;
        String r145 = this.model;
        if (r145 != null) goto L61;
        int r146 = 0;
    L62:
        int r147 = (r144 + r146) * 31;
        String r148 = this.voiceType;
        if (r148 != null) goto L65;
        int r149 = 0;
    L66:
        int r150 = (r147 + r149) * 31;
        String r151 = this.editPos;
        if (r151 != null) goto L69;
        int r152 = 0;
    L70:
        int r153 = (r150 + r152) * 31;
        if (this.muted == false) goto L73;
        int r154 = 1231;
    L74:
        int r155 = (r153 + r154) * 31;
        Integer r156 = this.recommendIndex;
        if (r156 != null) goto L77;
        int r157 = 0;
    L78:
        int r158 = (r155 + r157) * 31;
        Boolean r159 = this.messagePush;
        if (r159 != null) goto L81;
        int r160 = 0;
    L82:
        int r161 = (r158 + r160) * 31;
        Boolean r162 = this.showMessagePush;
        if (r162 != null) goto L85;
        int r163 = 0;
    L86:
        int r164 = (r161 + r163) * 31;
        String r165 = this.bio;
        if (r165 != null) goto L89;
        int r166 = 0;
    L90:
        int r167 = (r164 + r166) * 31;
        String r168 = this.bioEdit;
        if (r168 != null) goto L93;
        int r169 = 0;
    L94:
        int r170 = (r167 + r169) * 31;
        String r171 = this.botStatistic;
        if (r171 != null) goto L97;
        int r172 = 0;
    L98:
        int r173 = (r170 + r172) * 31;
        String r174 = this.answerActions;
        if (r174 != null) goto L101;
        int r175 = 0;
    L102:
        int r176 = (r173 + r175) * 31;
        String r177 = this.actionScenes;
        if (r177 != null) goto L105;
        int r178 = 0;
    L106:
        int r179 = (r176 + r178) * 31;
        String r180 = this.answerActionExposurePriority;
        if (r180 != null) goto L109;
        int r181 = 0;
    L110:
        int r182 = (r179 + r181) * 31;
        String r183 = this.menuActions;
        if (r183 != null) goto L113;
        int r184 = 0;
    L114:
        int r185 = (r182 + r184) * 31;
        String r186 = this.streamingAnswerActions;
        if (r186 != null) goto L117;
        int r187 = 0;
    L118:
        int r188 = (r185 + r187) * 31;
        String r189 = this.botConf;
        if (r189 != null) goto L121;
        int r190 = 0;
    L122:
        int r191 = (((r188 + r190) * 31) + this.botMode) * 31;
        String r192 = this.bgImgUrl;
        if (r192 != null) goto L125;
        int r193 = 0;
    L126:
        int r194 = (r191 + r193) * 31;
        String r195 = this.bgImgColor;
        if (r195 != null) goto L129;
        int r196 = 0;
    L130:
        int r197 = (r194 + r196) * 31;
        String r198 = this.bgVideoModel;
        if (r198 != null) goto L133;
        int r199 = 0;
    L134:
        int r200 = (r197 + r199) * 31;
        String r201 = this.iconPrompt;
        if (r201 != null) goto L137;
        int r202 = 0;
    L138:
        int r203 = (r200 + r202) * 31;
        String r204 = this.switchConfInfo;
        if (r204 != null) goto L141;
        int r205 = 0;
    L142:
        int r206 = (r203 + r205) * 31;
        String r207 = this.callerName;
        if (r207 != null) goto L145;
        int r208 = 0;
    L146:
        int r209 = (r206 + r208) * 31;
        Boolean r210 = this.callerNameSettings;
        if (r210 != null) goto L149;
        int r211 = 0;
    L150:
        int r212 = (r209 + r211) * 31;
        String r213 = this.sceneModelList;
        if (r213 != null) goto L153;
        int r214 = 0;
    L154:
        int r215 = (r212 + r214) * 31;
        String r216 = this.firstMet;
        if (r216 != null) goto L157;
        int r217 = 0;
    L158:
        int r218 = (r215 + r217) * 31;
        String r219 = this.cameraTabConfigMap;
        if (r219 != null) goto L161;
        int r220 = 0;
    L162:
        int r221 = (r218 + r220) * 31;
        String r222 = this.botFeatureLabel;
        if (r222 != null) goto L165;
        int r223 = 0;
    L166:
        int r224 = (r221 + r223) * 31;
        String r225 = this.onboarding;
        if (r225 != null) goto L169;
        int r226 = 0;
    L170:
        int r227 = (r224 + r226) * 31;
        String r228 = this.bgImgUri;
        if (r228 != null) goto L173;
        int r229 = 0;
    L174:
        int r230 = (r227 + r229) * 31;
        String r231 = this.bgImgInfo;
        if (r231 != null) goto L177;
        int r232 = 0;
    L178:
        int r233 = (r230 + r232) * 31;
        String r234 = this.botMemoryConfig;
        if (r234 != null) goto L181;
        int r235 = 0;
    L182:
        int r236 = (r233 + r235) * 31;
        String r237 = this.callImgConfig;
        if (r237 != null) goto L185;
        int r238 = 0;
    L186:
        int r239 = (r236 + r238) * 31;
        String r240 = this.botIconMappedAppIcon;
        if (r240 != null) goto L189;
        int r241 = 0;
    L190:
        int r242 = (r239 + r241) * 31;
        String r243 = this.dynamicImgUri;
        if (r243 != null) goto L193;
        int r244 = 0;
    L194:
        int r245 = (r242 + r244) * 31;
        String r246 = this.dynamicImgUrl;
        if (r246 != null) goto L197;
        int r247 = 0;
    L198:
        int r248 = (r245 + r247) * 31;
        String r249 = this.messagePushSwitchConfirmTitle;
        if (r249 != null) goto L201;
        int r250 = 0;
    L202:
        int r251 = (r248 + r250) * 31;
        String r252 = this.msgRegenModeList;
        if (r252 != null) goto L205;
        int r253 = 0;
    L206:
        int r254 = (r251 + r253) * 31;
        String r255 = this.unavailableInstructionTypeList;
        if (r255 != null) goto L209;
        int r256 = 0;
    L210:
        int r257 = (r254 + r256) * 31;
        String r258 = this.serviceBotConf;
        if (r258 != null) goto L213;
        int r259 = 0;
    L214:
        int r260 = (r257 + r259) * 31;
        String r261 = this.loadingConf;
        if (r261 != null) goto L217;
        int r262 = 0;
    L218:
        int r263 = (r260 + r262) * 31;
        Integer r264 = this.likeInfoShow;
        if (r264 != null) goto L221;
        int r265 = 0;
    L222:
        int r266 = (r263 + r265) * 31;
        Integer r267 = this.likeInfoLiked;
        if (r267 != null) goto L225;
        int r268 = 0;
    L226:
        int r269 = (r266 + r268) * 31;
        Long r270 = this.likeInfoCount;
        if (r270 != null) goto L229;
        int r271 = 0;
    L230:
        int r272 = (r269 + r271) * 31;
        Integer r273 = this.botCommentInfoShow;
        if (r273 != null) goto L233;
        int r274 = 0;
    L234:
        int r275 = (r272 + r274) * 31;
        Long r276 = this.botCommentInfoCount;
        if (r276 != null) goto L237;
        int r277 = 0;
    L238:
        int r278 = (r275 + r277) * 31;
        String r279 = this.extra;
        if (r279 != null) goto L241;
        int r280 = 0;
    L242:
        int r281 = (r278 + r280) * 31;
        Boolean r282 = this.isDisable;
        if (r282 == null) goto L247;
        r102 = r282.hashCode();
    L247:
        return r281 + r102;
    L241:
        r280 = r279.hashCode();
        goto L242
    L237:
        r277 = r276.hashCode();
        goto L238
    L233:
        r274 = r273.hashCode();
        goto L234
    L229:
        r271 = r270.hashCode();
        goto L230
    L225:
        r268 = r267.hashCode();
        goto L226
    L221:
        r265 = r264.hashCode();
        goto L222
    L217:
        r262 = r261.hashCode();
        goto L218
    L213:
        r259 = r258.hashCode();
        goto L214
    L209:
        r256 = r255.hashCode();
        goto L210
    L205:
        r253 = r252.hashCode();
        goto L206
    L201:
        r250 = r249.hashCode();
        goto L202
    L197:
        r247 = r246.hashCode();
        goto L198
    L193:
        r244 = r243.hashCode();
        goto L194
    L189:
        r241 = r240.hashCode();
        goto L190
    L185:
        r238 = r237.hashCode();
        goto L186
    L181:
        r235 = r234.hashCode();
        goto L182
    L177:
        r232 = r231.hashCode();
        goto L178
    L173:
        r229 = r228.hashCode();
        goto L174
    L169:
        r226 = r225.hashCode();
        goto L170
    L165:
        r223 = r222.hashCode();
        goto L166
    L161:
        r220 = r219.hashCode();
        goto L162
    L157:
        r217 = r216.hashCode();
        goto L158
    L153:
        r214 = r213.hashCode();
        goto L154
    L149:
        r211 = r210.hashCode();
        goto L150
    L145:
        r208 = r207.hashCode();
        goto L146
    L141:
        r205 = r204.hashCode();
        goto L142
    L137:
        r202 = r201.hashCode();
        goto L138
    L133:
        r199 = r198.hashCode();
        goto L134
    L129:
        r196 = r195.hashCode();
        goto L130
    L125:
        r193 = r192.hashCode();
        goto L126
    L121:
        r190 = r189.hashCode();
        goto L122
    L117:
        r187 = r186.hashCode();
        goto L118
    L113:
        r184 = r183.hashCode();
        goto L114
    L109:
        r181 = r180.hashCode();
        goto L110
    L105:
        r178 = r177.hashCode();
        goto L106
    L101:
        r175 = r174.hashCode();
        goto L102
    L97:
        r172 = r171.hashCode();
        goto L98
    L93:
        r169 = r168.hashCode();
        goto L94
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
        r154 = 1237;
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
        r137 = r136.hashCode();
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
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "BotEntity(botId=" + this.botId + ", name=" + this.name + ", iconImage=" + this.iconImage + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", botType=" + this.botType + ", shareInfo=" + this.shareInfo + ", botCreatorInfo=" + this.botCreatorInfo + ", tagList=" + this.tagList + ", selectTextActions=" + this.selectTextActions + ", privateStatus=" + this.privateStatus + ", conversationPage=" + this.conversationPage + ", descriptionForModel=" + this.descriptionForModel + ", descriptionForHuman=" + this.descriptionForHuman + ", botStatus=" + this.botStatus + ", status=" + this.status + ", model=" + this.model + ", voiceType=" + this.voiceType + ", editPos=" + this.editPos + ", muted=" + this.muted + ", recommendIndex=" + this.recommendIndex + ", messagePush=" + this.messagePush + ", showMessagePush=" + this.showMessagePush + ", bio=" + this.bio + ", bioEdit=" + this.bioEdit + ", botStatistic=" + this.botStatistic + ", answerActions=" + this.answerActions + ", actionScenes=" + this.actionScenes + ", answerActionExposurePriority=" + this.answerActionExposurePriority + ", menuActions=" + this.menuActions + ", streamingAnswerActions=" + this.streamingAnswerActions + ", botConf=" + this.botConf + ", botMode=" + this.botMode + ", bgImgUrl=" + this.bgImgUrl + ", bgImgColor=" + this.bgImgColor + ", bgVideoModel=" + this.bgVideoModel + ", iconPrompt=" + this.iconPrompt + ", switchConfInfo=" + this.switchConfInfo + ", callerName=" + this.callerName + ", callerNameSettings=" + this.callerNameSettings + ", sceneModelList=" + this.sceneModelList + ", firstMet=" + this.firstMet + ", cameraTabConfigMap=" + this.cameraTabConfigMap + ", botFeatureLabel=" + this.botFeatureLabel + ", onboarding=" + this.onboarding + ", bgImgUri=" + this.bgImgUri + ", bgImgInfo=" + this.bgImgInfo + ", botMemoryConfig=" + this.botMemoryConfig + ", callImgConfig=" + this.callImgConfig + ", botIconMappedAppIcon=" + this.botIconMappedAppIcon + ", dynamicImgUri=" + this.dynamicImgUri + ", dynamicImgUrl=" + this.dynamicImgUrl + ", messagePushSwitchConfirmTitle=" + this.messagePushSwitchConfirmTitle + ", msgRegenModeList=" + this.msgRegenModeList + ", unavailableInstructionTypeList=" + this.unavailableInstructionTypeList + ", serviceBotConf=" + this.serviceBotConf + ", loadingConf=" + this.loadingConf + ", likeInfoShow=" + this.likeInfoShow + ", likeInfoLiked=" + this.likeInfoLiked + ", likeInfoCount=" + this.likeInfoCount + ", botCommentInfoShow=" + this.botCommentInfoShow + ", botCommentInfoCount=" + this.botCommentInfoCount + ", extra=" + this.extra + ", isDisable=" + this.isDisable + ')';
    }

    static {
        Companion = new b();
    }

    public BotEntity() {
        this("", null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, null);
    }

    public final String getActionScenes() {
        return this.actionScenes;
    }

    public final String getAnswerActionExposurePriority() {
        return this.answerActionExposurePriority;
    }

    public final String getAnswerActions() {
        return this.answerActions;
    }

    public final String getBgImgColor() {
        return this.bgImgColor;
    }

    public final String getBgImgInfo() {
        return this.bgImgInfo;
    }

    public final String getBgImgUri() {
        return this.bgImgUri;
    }

    public final String getBgImgUrl() {
        return this.bgImgUrl;
    }

    public final String getBgVideoModel() {
        return this.bgVideoModel;
    }

    public final String getBio() {
        return this.bio;
    }

    public final String getBioEdit() {
        return this.bioEdit;
    }

    public final Long getBotCommentInfoCount() {
        return this.botCommentInfoCount;
    }

    public final Integer getBotCommentInfoShow() {
        return this.botCommentInfoShow;
    }

    public final String getBotConf() {
        return this.botConf;
    }

    public final String getBotCreatorInfo() {
        return this.botCreatorInfo;
    }

    public final String getBotFeatureLabel() {
        return this.botFeatureLabel;
    }

    public final String getBotIconMappedAppIcon() {
        return this.botIconMappedAppIcon;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getBotMemoryConfig() {
        return this.botMemoryConfig;
    }

    public final int getBotMode() {
        return this.botMode;
    }

    public final String getBotStatistic() {
        return this.botStatistic;
    }

    public final Integer getBotStatus() {
        return this.botStatus;
    }

    public final Integer getBotType() {
        return this.botType;
    }

    public final String getCallImgConfig() {
        return this.callImgConfig;
    }

    public final String getCallerName() {
        return this.callerName;
    }

    public final Boolean getCallerNameSettings() {
        return this.callerNameSettings;
    }

    public final String getCameraTabConfigMap() {
        return this.cameraTabConfigMap;
    }

    public final String getConversationPage() {
        return this.conversationPage;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getDescriptionForHuman() {
        return this.descriptionForHuman;
    }

    public final String getDescriptionForModel() {
        return this.descriptionForModel;
    }

    public final String getDynamicImgUri() {
        return this.dynamicImgUri;
    }

    public final String getDynamicImgUrl() {
        return this.dynamicImgUrl;
    }

    public final String getEditPos() {
        return this.editPos;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getFirstMet() {
        return this.firstMet;
    }

    public final String getIconImage() {
        return this.iconImage;
    }

    public final String getIconPrompt() {
        return this.iconPrompt;
    }

    public final Long getLikeInfoCount() {
        return this.likeInfoCount;
    }

    public final Integer getLikeInfoLiked() {
        return this.likeInfoLiked;
    }

    public final Integer getLikeInfoShow() {
        return this.likeInfoShow;
    }

    public final String getLoadingConf() {
        return this.loadingConf;
    }

    public final String getMenuActions() {
        return this.menuActions;
    }

    public final Boolean getMessagePush() {
        return this.messagePush;
    }

    public final String getMessagePushSwitchConfirmTitle() {
        return this.messagePushSwitchConfirmTitle;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getMsgRegenModeList() {
        return this.msgRegenModeList;
    }

    public final boolean getMuted() {
        return this.muted;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOnboarding() {
        return this.onboarding;
    }

    public final Integer getPrivateStatus() {
        return this.privateStatus;
    }

    public final Integer getRecommendIndex() {
        return this.recommendIndex;
    }

    public final String getSceneModelList() {
        return this.sceneModelList;
    }

    public final String getSelectTextActions() {
        return this.selectTextActions;
    }

    public final String getServiceBotConf() {
        return this.serviceBotConf;
    }

    public final String getShareInfo() {
        return this.shareInfo;
    }

    public final Boolean getShowMessagePush() {
        return this.showMessagePush;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getStreamingAnswerActions() {
        return this.streamingAnswerActions;
    }

    public final String getSwitchConfInfo() {
        return this.switchConfInfo;
    }

    public final String getTagList() {
        return this.tagList;
    }

    public final String getUnavailableInstructionTypeList() {
        return this.unavailableInstructionTypeList;
    }

    public final Long getUpdateTime() {
        return this.updateTime;
    }

    public final String getVoiceType() {
        return this.voiceType;
    }

    public final Boolean isDisable() {
        return this.isDisable;
    }

    public final void setActionScenes(String r100) {
        this.actionScenes = r100;
    }

    public final void setBgImgColor(String r100) {
        this.bgImgColor = r100;
    }

    public final void setBgImgInfo(String r100) {
        this.bgImgInfo = r100;
    }

    public final void setBgImgUri(String r100) {
        this.bgImgUri = r100;
    }

    public final void setBgImgUrl(String r100) {
        this.bgImgUrl = r100;
    }

    public final void setBgVideoModel(String r100) {
        this.bgVideoModel = r100;
    }

    public final void setBotFeatureLabel(String r100) {
        this.botFeatureLabel = r100;
    }

    public final void setBotIconMappedAppIcon(String r100) {
        this.botIconMappedAppIcon = r100;
    }

    public final void setBotMemoryConfig(String r100) {
        this.botMemoryConfig = r100;
    }

    public final void setBotMode(int r100) {
        this.botMode = r100;
    }

    public final void setCallImgConfig(String r100) {
        this.callImgConfig = r100;
    }

    public final void setCallerName(String r100) {
        this.callerName = r100;
    }

    public final void setCallerNameSettings(Boolean r100) {
        this.callerNameSettings = r100;
    }

    public final void setCameraTabConfigMap(String r100) {
        this.cameraTabConfigMap = r100;
    }

    public final void setDynamicImgUri(String r100) {
        this.dynamicImgUri = r100;
    }

    public final void setDynamicImgUrl(String r100) {
        this.dynamicImgUrl = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setFirstMet(String r100) {
        this.firstMet = r100;
    }

    public final void setIconPrompt(String r100) {
        this.iconPrompt = r100;
    }

    public final void setMessagePushSwitchConfirmTitle(String r100) {
        this.messagePushSwitchConfirmTitle = r100;
    }

    public final void setMsgRegenModeList(String r100) {
        this.msgRegenModeList = r100;
    }

    public final void setOnboarding(String r100) {
        this.onboarding = r100;
    }

    public final void setSceneModelList(String r100) {
        this.sceneModelList = r100;
    }

    public final void setServiceBotConf(String r100) {
        this.serviceBotConf = r100;
    }

    public final void setSwitchConfInfo(String r100) {
        this.switchConfInfo = r100;
    }

    public final void setUnavailableInstructionTypeList(String r100) {
        this.unavailableInstructionTypeList = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(BotEntity r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeStringElement(r110, 0, r100.botId);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeNullableSerializableElement(r110, 1, v2.f520790a, r100.name);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeNullableSerializableElement(r110, 2, v2.f520790a, r100.iconImage);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r101.encodeLongElement(r110, 3, r100.createTime);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r101.encodeNullableSerializableElement(r110, 4, g1.f520681a, r100.updateTime);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r101.encodeNullableSerializableElement(r110, 5, w0.f520792a, r100.botType);
    L57:
        if (r101.shouldEncodeElementDefault(r110, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r101.encodeNullableSerializableElement(r110, 6, v2.f520790a, r100.shareInfo);
    L66:
        if (r101.shouldEncodeElementDefault(r110, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r110, 7, v2.f520790a, r100.botCreatorInfo);
    L75:
        if (r101.shouldEncodeElementDefault(r110, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeNullableSerializableElement(r110, 8, v2.f520790a, r100.tagList);
    L84:
        if (r101.shouldEncodeElementDefault(r110, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeNullableSerializableElement(r110, 9, v2.f520790a, r100.selectTextActions);
    L93:
        if (r101.shouldEncodeElementDefault(r110, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r101.encodeNullableSerializableElement(r110, 10, w0.f520792a, r100.privateStatus);
    L102:
        if (r101.shouldEncodeElementDefault(r110, 11) == false) goto L105;
    L103:
        boolean r115 = true;
    L108:
        if (r115 == false) goto L111;
        r101.encodeNullableSerializableElement(r110, 11, v2.f520790a, r100.conversationPage);
    L111:
        if (r101.shouldEncodeElementDefault(r110, 12) == false) goto L114;
    L112:
        boolean r116 = true;
    L117:
        if (r116 == false) goto L120;
        r101.encodeNullableSerializableElement(r110, 12, v2.f520790a, r100.descriptionForModel);
    L120:
        if (r101.shouldEncodeElementDefault(r110, 13) == false) goto L123;
    L121:
        boolean r117 = true;
    L126:
        if (r117 == false) goto L129;
        r101.encodeNullableSerializableElement(r110, 13, v2.f520790a, r100.descriptionForHuman);
    L129:
        if (r101.shouldEncodeElementDefault(r110, 14) == false) goto L132;
    L130:
        boolean r118 = true;
    L135:
        if (r118 == false) goto L138;
        r101.encodeNullableSerializableElement(r110, 14, w0.f520792a, r100.botStatus);
    L138:
        if (r101.shouldEncodeElementDefault(r110, 15) == false) goto L141;
    L139:
        boolean r119 = true;
    L144:
        if (r119 == false) goto L147;
        r101.encodeNullableSerializableElement(r110, 15, w0.f520792a, r100.status);
    L147:
        if (r101.shouldEncodeElementDefault(r110, 16) == false) goto L150;
    L148:
        boolean r120 = true;
    L153:
        if (r120 == false) goto L156;
        r101.encodeNullableSerializableElement(r110, 16, v2.f520790a, r100.model);
    L156:
        if (r101.shouldEncodeElementDefault(r110, 17) == false) goto L159;
    L157:
        boolean r121 = true;
    L162:
        if (r121 == false) goto L165;
        r101.encodeNullableSerializableElement(r110, 17, v2.f520790a, r100.voiceType);
    L165:
        if (r101.shouldEncodeElementDefault(r110, 18) == false) goto L168;
    L166:
        boolean r122 = true;
    L171:
        if (r122 == false) goto L174;
        r101.encodeNullableSerializableElement(r110, 18, v2.f520790a, r100.editPos);
    L174:
        if (r101.shouldEncodeElementDefault(r110, 19) == false) goto L177;
    L175:
        boolean r123 = true;
    L180:
        if (r123 == false) goto L183;
        r101.encodeBooleanElement(r110, 19, r100.muted);
    L183:
        if (r101.shouldEncodeElementDefault(r110, 20) == false) goto L186;
    L184:
        boolean r124 = true;
    L189:
        if (r124 == false) goto L192;
        r101.encodeNullableSerializableElement(r110, 20, w0.f520792a, r100.recommendIndex);
    L192:
        if (r101.shouldEncodeElementDefault(r110, 21) == false) goto L195;
    L193:
        boolean r125 = true;
    L198:
        if (r125 == false) goto L201;
        r101.encodeNullableSerializableElement(r110, 21, i.f520705a, r100.messagePush);
    L201:
        if (r101.shouldEncodeElementDefault(r110, 22) == false) goto L204;
    L202:
        boolean r126 = true;
    L207:
        if (r126 == false) goto L210;
        r101.encodeNullableSerializableElement(r110, 22, i.f520705a, r100.showMessagePush);
    L210:
        if (r101.shouldEncodeElementDefault(r110, 23) == false) goto L213;
    L211:
        boolean r127 = true;
    L216:
        if (r127 == false) goto L219;
        r101.encodeNullableSerializableElement(r110, 23, v2.f520790a, r100.bio);
    L219:
        if (r101.shouldEncodeElementDefault(r110, 24) == false) goto L222;
    L220:
        boolean r128 = true;
    L225:
        if (r128 == false) goto L228;
        r101.encodeNullableSerializableElement(r110, 24, v2.f520790a, r100.bioEdit);
    L228:
        if (r101.shouldEncodeElementDefault(r110, 25) == false) goto L231;
    L229:
        boolean r129 = true;
    L234:
        if (r129 == false) goto L237;
        r101.encodeNullableSerializableElement(r110, 25, v2.f520790a, r100.botStatistic);
    L237:
        if (r101.shouldEncodeElementDefault(r110, 26) == false) goto L240;
    L238:
        boolean r130 = true;
    L243:
        if (r130 == false) goto L246;
        r101.encodeNullableSerializableElement(r110, 26, v2.f520790a, r100.answerActions);
    L246:
        if (r101.shouldEncodeElementDefault(r110, 27) == false) goto L249;
    L247:
        boolean r131 = true;
    L252:
        if (r131 == false) goto L255;
        r101.encodeNullableSerializableElement(r110, 27, v2.f520790a, r100.actionScenes);
    L255:
        if (r101.shouldEncodeElementDefault(r110, 28) == false) goto L258;
    L256:
        boolean r132 = true;
    L261:
        if (r132 == false) goto L264;
        r101.encodeNullableSerializableElement(r110, 28, v2.f520790a, r100.answerActionExposurePriority);
    L264:
        if (r101.shouldEncodeElementDefault(r110, 29) == false) goto L267;
    L265:
        boolean r133 = true;
    L270:
        if (r133 == false) goto L273;
        r101.encodeNullableSerializableElement(r110, 29, v2.f520790a, r100.menuActions);
    L273:
        if (r101.shouldEncodeElementDefault(r110, 30) == false) goto L276;
    L274:
        boolean r134 = true;
    L279:
        if (r134 == false) goto L282;
        r101.encodeNullableSerializableElement(r110, 30, v2.f520790a, r100.streamingAnswerActions);
    L282:
        if (r101.shouldEncodeElementDefault(r110, 31) == false) goto L285;
    L283:
        boolean r135 = true;
    L288:
        if (r135 == false) goto L291;
        r101.encodeNullableSerializableElement(r110, 31, v2.f520790a, r100.botConf);
    L291:
        if (r101.shouldEncodeElementDefault(r110, 32) == false) goto L294;
    L292:
        boolean r136 = true;
    L297:
        if (r136 == false) goto L300;
        r101.encodeIntElement(r110, 32, r100.botMode);
    L300:
        if (r101.shouldEncodeElementDefault(r110, 33) == false) goto L303;
    L301:
        boolean r137 = true;
    L306:
        if (r137 == false) goto L309;
        r101.encodeNullableSerializableElement(r110, 33, v2.f520790a, r100.bgImgUrl);
    L309:
        if (r101.shouldEncodeElementDefault(r110, 34) == false) goto L312;
    L310:
        boolean r138 = true;
    L315:
        if (r138 == false) goto L318;
        r101.encodeNullableSerializableElement(r110, 34, v2.f520790a, r100.bgImgColor);
    L318:
        if (r101.shouldEncodeElementDefault(r110, 35) == false) goto L321;
    L319:
        boolean r139 = true;
    L324:
        if (r139 == false) goto L327;
        r101.encodeNullableSerializableElement(r110, 35, v2.f520790a, r100.bgVideoModel);
    L327:
        if (r101.shouldEncodeElementDefault(r110, 36) == false) goto L330;
    L328:
        boolean r140 = true;
    L333:
        if (r140 == false) goto L336;
        r101.encodeNullableSerializableElement(r110, 36, v2.f520790a, r100.iconPrompt);
    L336:
        if (r101.shouldEncodeElementDefault(r110, 37) == false) goto L339;
    L337:
        boolean r141 = true;
    L342:
        if (r141 == false) goto L345;
        r101.encodeNullableSerializableElement(r110, 37, v2.f520790a, r100.switchConfInfo);
    L345:
        if (r101.shouldEncodeElementDefault(r110, 38) == false) goto L348;
    L346:
        boolean r142 = true;
    L351:
        if (r142 == false) goto L354;
        r101.encodeNullableSerializableElement(r110, 38, v2.f520790a, r100.callerName);
    L354:
        if (r101.shouldEncodeElementDefault(r110, 39) == false) goto L357;
    L355:
        boolean r143 = true;
    L360:
        if (r143 == false) goto L363;
        r101.encodeNullableSerializableElement(r110, 39, i.f520705a, r100.callerNameSettings);
    L363:
        if (r101.shouldEncodeElementDefault(r110, 40) == false) goto L366;
    L364:
        boolean r144 = true;
    L369:
        if (r144 == false) goto L372;
        r101.encodeNullableSerializableElement(r110, 40, v2.f520790a, r100.sceneModelList);
    L372:
        if (r101.shouldEncodeElementDefault(r110, 41) == false) goto L375;
    L373:
        boolean r145 = true;
    L378:
        if (r145 == false) goto L381;
        r101.encodeNullableSerializableElement(r110, 41, v2.f520790a, r100.firstMet);
    L381:
        if (r101.shouldEncodeElementDefault(r110, 42) == false) goto L384;
    L382:
        boolean r146 = true;
    L387:
        if (r146 == false) goto L390;
        r101.encodeNullableSerializableElement(r110, 42, v2.f520790a, r100.cameraTabConfigMap);
    L390:
        if (r101.shouldEncodeElementDefault(r110, 43) == false) goto L393;
    L391:
        boolean r147 = true;
    L396:
        if (r147 == false) goto L399;
        r101.encodeNullableSerializableElement(r110, 43, v2.f520790a, r100.botFeatureLabel);
    L399:
        if (r101.shouldEncodeElementDefault(r110, 44) == false) goto L402;
    L400:
        boolean r148 = true;
    L405:
        if (r148 == false) goto L408;
        r101.encodeNullableSerializableElement(r110, 44, v2.f520790a, r100.onboarding);
    L408:
        if (r101.shouldEncodeElementDefault(r110, 45) == false) goto L411;
    L409:
        boolean r149 = true;
    L414:
        if (r149 == false) goto L417;
        r101.encodeNullableSerializableElement(r110, 45, v2.f520790a, r100.bgImgUri);
    L417:
        if (r101.shouldEncodeElementDefault(r110, 46) == false) goto L420;
    L418:
        boolean r150 = true;
    L423:
        if (r150 == false) goto L426;
        r101.encodeNullableSerializableElement(r110, 46, v2.f520790a, r100.bgImgInfo);
    L426:
        if (r101.shouldEncodeElementDefault(r110, 47) == false) goto L429;
    L427:
        boolean r151 = true;
    L432:
        if (r151 == false) goto L435;
        r101.encodeNullableSerializableElement(r110, 47, v2.f520790a, r100.botMemoryConfig);
    L435:
        if (r101.shouldEncodeElementDefault(r110, 48) == false) goto L438;
    L436:
        boolean r152 = true;
    L441:
        if (r152 == false) goto L444;
        r101.encodeNullableSerializableElement(r110, 48, v2.f520790a, r100.callImgConfig);
    L444:
        if (r101.shouldEncodeElementDefault(r110, 49) == false) goto L447;
    L445:
        boolean r153 = true;
    L450:
        if (r153 == false) goto L453;
        r101.encodeNullableSerializableElement(r110, 49, v2.f520790a, r100.botIconMappedAppIcon);
    L453:
        if (r101.shouldEncodeElementDefault(r110, 50) == false) goto L456;
    L454:
        boolean r154 = true;
    L459:
        if (r154 == false) goto L462;
        r101.encodeNullableSerializableElement(r110, 50, v2.f520790a, r100.dynamicImgUri);
    L462:
        if (r101.shouldEncodeElementDefault(r110, 51) == false) goto L465;
    L463:
        boolean r155 = true;
    L468:
        if (r155 == false) goto L471;
        r101.encodeNullableSerializableElement(r110, 51, v2.f520790a, r100.dynamicImgUrl);
    L471:
        if (r101.shouldEncodeElementDefault(r110, 52) == false) goto L474;
    L472:
        boolean r156 = true;
    L477:
        if (r156 == false) goto L480;
        r101.encodeNullableSerializableElement(r110, 52, v2.f520790a, r100.messagePushSwitchConfirmTitle);
    L480:
        if (r101.shouldEncodeElementDefault(r110, 53) == false) goto L483;
    L481:
        boolean r157 = true;
    L486:
        if (r157 == false) goto L489;
        r101.encodeNullableSerializableElement(r110, 53, v2.f520790a, r100.msgRegenModeList);
    L489:
        if (r101.shouldEncodeElementDefault(r110, 54) == false) goto L492;
    L490:
        boolean r158 = true;
    L495:
        if (r158 == false) goto L498;
        r101.encodeNullableSerializableElement(r110, 54, v2.f520790a, r100.unavailableInstructionTypeList);
    L498:
        if (r101.shouldEncodeElementDefault(r110, 55) == false) goto L501;
    L499:
        boolean r159 = true;
    L504:
        if (r159 == false) goto L507;
        r101.encodeNullableSerializableElement(r110, 55, v2.f520790a, r100.serviceBotConf);
    L507:
        if (r101.shouldEncodeElementDefault(r110, 56) == false) goto L510;
    L508:
        boolean r160 = true;
    L513:
        if (r160 == false) goto L516;
        r101.encodeNullableSerializableElement(r110, 56, v2.f520790a, r100.loadingConf);
    L516:
        if (r101.shouldEncodeElementDefault(r110, 57) == false) goto L519;
    L517:
        boolean r161 = true;
    L522:
        if (r161 == false) goto L525;
        r101.encodeNullableSerializableElement(r110, 57, w0.f520792a, r100.likeInfoShow);
    L525:
        if (r101.shouldEncodeElementDefault(r110, 58) == false) goto L528;
    L526:
        boolean r162 = true;
    L531:
        if (r162 == false) goto L534;
        r101.encodeNullableSerializableElement(r110, 58, w0.f520792a, r100.likeInfoLiked);
    L534:
        if (r101.shouldEncodeElementDefault(r110, 59) == false) goto L537;
    L535:
        boolean r163 = true;
    L540:
        if (r163 == false) goto L543;
        r101.encodeNullableSerializableElement(r110, 59, g1.f520681a, r100.likeInfoCount);
    L543:
        if (r101.shouldEncodeElementDefault(r110, 60) == false) goto L546;
    L544:
        boolean r164 = true;
    L549:
        if (r164 == false) goto L552;
        r101.encodeNullableSerializableElement(r110, 60, w0.f520792a, r100.botCommentInfoShow);
    L552:
        if (r101.shouldEncodeElementDefault(r110, 61) == false) goto L555;
    L553:
        boolean r165 = true;
    L558:
        if (r165 == false) goto L561;
        r101.encodeNullableSerializableElement(r110, 61, g1.f520681a, r100.botCommentInfoCount);
    L561:
        if (r101.shouldEncodeElementDefault(r110, 62) == false) goto L564;
    L562:
        boolean r166 = true;
    L567:
        if (r166 == false) goto L570;
        r101.encodeNullableSerializableElement(r110, 62, v2.f520790a, r100.extra);
    L570:
        if (r101.shouldEncodeElementDefault(r110, 63) == false) goto L573;
    L571:
        r102 = true;
    L575:
        if (r102 == false) goto L578;
        r101.encodeNullableSerializableElement(r110, 63, i.f520705a, r100.isDisable);
        return;
    L578:
        return;
    L573:
        if (r100.isDisable == null) goto L575;
    L564:
        if (r100.extra != null) goto L562;
        r166 = false;
        goto L567
    L555:
        if (r100.botCommentInfoCount != null) goto L553;
        r165 = false;
        goto L558
    L546:
        if (r100.botCommentInfoShow != null) goto L544;
        r164 = false;
        goto L549
    L537:
        if (r100.likeInfoCount != null) goto L535;
        r163 = false;
        goto L540
    L528:
        if (r100.likeInfoLiked != null) goto L526;
        r162 = false;
        goto L531
    L519:
        if (r100.likeInfoShow != null) goto L517;
        r161 = false;
        goto L522
    L510:
        if (r100.loadingConf != null) goto L508;
        r160 = false;
        goto L513
    L501:
        if (r100.serviceBotConf != null) goto L499;
        r159 = false;
        goto L504
    L492:
        if (r100.unavailableInstructionTypeList != null) goto L490;
        r158 = false;
        goto L495
    L483:
        if (r100.msgRegenModeList != null) goto L481;
        r157 = false;
        goto L486
    L474:
        if (r100.messagePushSwitchConfirmTitle != null) goto L472;
        r156 = false;
        goto L477
    L465:
        if (r100.dynamicImgUrl != null) goto L463;
        r155 = false;
        goto L468
    L456:
        if (r100.dynamicImgUri != null) goto L454;
        r154 = false;
        goto L459
    L447:
        if (r100.botIconMappedAppIcon != null) goto L445;
        r153 = false;
        goto L450
    L438:
        if (r100.callImgConfig != null) goto L436;
        r152 = false;
        goto L441
    L429:
        if (r100.botMemoryConfig != null) goto L427;
        r151 = false;
        goto L432
    L420:
        if (r100.bgImgInfo != null) goto L418;
        r150 = false;
        goto L423
    L411:
        if (r100.bgImgUri != null) goto L409;
        r149 = false;
        goto L414
    L402:
        if (r100.onboarding != null) goto L400;
        r148 = false;
        goto L405
    L393:
        if (r100.botFeatureLabel != null) goto L391;
        r147 = false;
        goto L396
    L384:
        if (r100.cameraTabConfigMap != null) goto L382;
        r146 = false;
        goto L387
    L375:
        if (r100.firstMet != null) goto L373;
        r145 = false;
        goto L378
    L366:
        if (r100.sceneModelList != null) goto L364;
        r144 = false;
        goto L369
    L357:
        if (r100.callerNameSettings != null) goto L355;
        r143 = false;
        goto L360
    L348:
        if (r100.callerName != null) goto L346;
        r142 = false;
        goto L351
    L339:
        if (r100.switchConfInfo != null) goto L337;
        r141 = false;
        goto L342
    L330:
        if (r100.iconPrompt != null) goto L328;
        r140 = false;
        goto L333
    L321:
        if (r100.bgVideoModel != null) goto L319;
        r139 = false;
        goto L324
    L312:
        if (r100.bgImgColor != null) goto L310;
        r138 = false;
        goto L315
    L303:
        if (r100.bgImgUrl != null) goto L301;
        r137 = false;
        goto L306
    L294:
        if (r100.botMode != (-1)) goto L292;
        r136 = false;
        goto L297
    L285:
        if (r100.botConf != null) goto L283;
        r135 = false;
        goto L288
    L276:
        if (r100.streamingAnswerActions != null) goto L274;
        r134 = false;
        goto L279
    L267:
        if (r100.menuActions != null) goto L265;
        r133 = false;
        goto L270
    L258:
        if (r100.answerActionExposurePriority != null) goto L256;
        r132 = false;
        goto L261
    L249:
        if (r100.actionScenes != null) goto L247;
        r131 = false;
        goto L252
    L240:
        if (r100.answerActions != null) goto L238;
        r130 = false;
        goto L243
    L231:
        if (r100.botStatistic != null) goto L229;
        r129 = false;
        goto L234
    L222:
        if (r100.bioEdit != null) goto L220;
        r128 = false;
        goto L225
    L213:
        if (r100.bio != null) goto L211;
        r127 = false;
        goto L216
    L204:
        if (Intrinsics.areEqual(r100.showMessagePush, Boolean.FALSE) == false) goto L202;
        r126 = false;
        goto L207
    L195:
        if (Intrinsics.areEqual(r100.messagePush, Boolean.FALSE) == false) goto L193;
        r125 = false;
        goto L198
    L186:
        if (r100.recommendIndex != null) goto L184;
        r124 = false;
        goto L189
    L177:
        if (r100.muted == true) goto L175;
        r123 = false;
        goto L180
    L168:
        if (r100.editPos != null) goto L166;
        r122 = false;
        goto L171
    L159:
        if (r100.voiceType != null) goto L157;
        r121 = false;
        goto L162
    L150:
        if (r100.model != null) goto L148;
        r120 = false;
        goto L153
    L141:
        if (r100.status != null) goto L139;
        r119 = false;
        goto L144
    L132:
        if (r100.botStatus != null) goto L130;
        r118 = false;
        goto L135
    L123:
        if (r100.descriptionForHuman != null) goto L121;
        r117 = false;
        goto L126
    L114:
        if (r100.descriptionForModel != null) goto L112;
        r116 = false;
        goto L117
    L105:
        if (r100.conversationPage != null) goto L103;
        r115 = false;
        goto L108
    L96:
        if (r100.privateStatus != null) goto L94;
        r114 = false;
        goto L99
    L87:
        if (r100.selectTextActions != null) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.tagList != null) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.botCreatorInfo != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.shareInfo != null) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.botType != null) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.updateTime != null) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.createTime != com.larus.im.internal.delegate.c.f348197a.currentTimeMillis()) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.iconImage != null) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.name != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r100.botId, "") == false) goto L4;
        r103 = false;
        goto L9
    }

    public BotEntity(String r100, String r101, String r102, long r103, Long r104, Integer r110, String r111, String r112, String r113, String r114, Integer r115, String r116, String r117, String r118, Integer r119, Integer r210, String r211, String r212, String r213, boolean r214, Integer r215, Boolean r216, Boolean r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, int r317, String r318, String r319, String r410, String r411, String r412, String r413, Boolean r414, String r415, String r416, String r417, String r418, String r419, String r510, String r511, String r512, String r513, String r514, String r515, String r516, String r517, String r518, String r519, String r610, String r611, Integer r612, Integer r613, Long r614, Integer r615, Long r616, String r617, Boolean r618) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.botId = r100;
        this.name = r101;
        this.iconImage = r102;
        this.createTime = r103;
        this.updateTime = r104;
        this.botType = r110;
        this.shareInfo = r111;
        this.botCreatorInfo = r112;
        this.tagList = r113;
        this.selectTextActions = r114;
        this.privateStatus = r115;
        this.conversationPage = r116;
        this.descriptionForModel = r117;
        this.descriptionForHuman = r118;
        this.botStatus = r119;
        this.status = r210;
        this.model = r211;
        this.voiceType = r212;
        this.editPos = r213;
        this.muted = r214;
        this.recommendIndex = r215;
        this.messagePush = r216;
        this.showMessagePush = r217;
        this.bio = r218;
        this.bioEdit = r219;
        this.botStatistic = r310;
        this.answerActions = r311;
        this.actionScenes = r312;
        this.answerActionExposurePriority = r313;
        this.menuActions = r314;
        this.streamingAnswerActions = r315;
        this.botConf = r316;
        this.botMode = r317;
        this.bgImgUrl = r318;
        this.bgImgColor = r319;
        this.bgVideoModel = r410;
        this.iconPrompt = r411;
        this.switchConfInfo = r412;
        this.callerName = r413;
        this.callerNameSettings = r414;
        this.sceneModelList = r415;
        this.firstMet = r416;
        this.cameraTabConfigMap = r417;
        this.botFeatureLabel = r418;
        this.onboarding = r419;
        this.bgImgUri = r510;
        this.bgImgInfo = r511;
        this.botMemoryConfig = r512;
        this.callImgConfig = r513;
        this.botIconMappedAppIcon = r514;
        this.dynamicImgUri = r515;
        this.dynamicImgUrl = r516;
        this.messagePushSwitchConfirmTitle = r517;
        this.msgRegenModeList = r518;
        this.unavailableInstructionTypeList = r519;
        this.serviceBotConf = r610;
        this.loadingConf = r611;
        this.likeInfoShow = r612;
        this.likeInfoLiked = r613;
        this.likeInfoCount = r614;
        this.botCommentInfoShow = r615;
        this.botCommentInfoCount = r616;
        this.extra = r617;
        this.isDisable = r618;
    }

    public /* synthetic */ BotEntity(String r610, String r611, String r612, long r613, Long r710, Integer r711, String r712, String r713, String r714, String r715, Integer r716, String r717, String r718, String r719, Integer r810, Integer r811, String r812, String r813, String r814, boolean r815, Integer r816, Boolean r817, Boolean r818, String r819, String r910, String r911, String r912, String r913, String r914, String r915, String r916, String r917, int r918, String r919, String r100, String r101, String r102, String r103, String r104, Boolean r105, String r106, String r107, String r108, String r109, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, String r120, String r121, String r122, Integer r123, Integer r124, Long r125, Integer r126, Long r127, String r128, Boolean r129, int r130, int r131, DefaultConstructorMarker r132) {
        if ((r130 & 1) == 0) goto L5;
        String r133 = "";
    L7:
        if ((r130 & 2) == 0) goto L9;
        String r134 = null;
    L11:
        if ((r130 & 4) == 0) goto L13;
        String r135 = null;
    L15:
        if ((r130 & 8) == 0) goto L17;
        long r136 = com.larus.im.internal.delegate.c.f348197a.currentTimeMillis();
    L19:
        if ((r130 & 16) == 0) goto L21;
        Long r137 = null;
    L23:
        if ((r130 & 32) == 0) goto L25;
        Integer r138 = null;
    L27:
        if ((r130 & 64) == 0) goto L29;
        String r139 = null;
    L31:
        if ((r130 & 128) == 0) goto L33;
        String r140 = null;
    L35:
        if ((r130 & 256) == 0) goto L37;
        String r141 = null;
    L39:
        if ((r130 & 512) == 0) goto L41;
        String r142 = null;
    L43:
        if ((r130 & 1024) == 0) goto L45;
        Integer r143 = null;
    L47:
        if ((r130 & 2048) == 0) goto L49;
        String r144 = null;
    L51:
        if ((r130 & 4096) == 0) goto L53;
        String r145 = null;
    L54:
        String r1310 = r145;
        if ((r130 & 8192) == 0) goto L57;
        String r146 = null;
    L58:
        String r147 = r146;
        if ((r130 & 16384) == 0) goto L61;
        Integer r148 = null;
    L63:
        if ((r130 & 32768) == 0) goto L65;
        Integer r149 = null;
    L67:
        if ((r130 & 65536) == 0) goto L69;
        String r210 = null;
    L71:
        if ((r130 & 131072) == 0) goto L73;
        String r211 = null;
    L75:
        if ((r130 & 262144) == 0) goto L77;
        String r212 = null;
    L79:
        if ((r130 & 524288) == 0) goto L81;
        boolean r213 = false;
    L83:
        if ((r130 & 1048576) == 0) goto L85;
        Integer r214 = null;
    L87:
        if ((r130 & 2097152) == 0) goto L89;
        Boolean r215 = Boolean.FALSE;
    L91:
        if ((r130 & 4194304) == 0) goto L93;
        Boolean r310 = Boolean.FALSE;
    L95:
        if ((r130 & 8388608) == 0) goto L97;
        String r311 = null;
    L99:
        if ((r130 & 16777216) == 0) goto L101;
        String r312 = null;
    L103:
        if ((r130 & 33554432) == 0) goto L105;
        String r313 = null;
    L107:
        if ((r130 & 67108864) == 0) goto L109;
        String r314 = null;
    L111:
        if ((r130 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r315 = null;
    L115:
        if ((r130 & 268435456) == 0) goto L117;
        String r316 = null;
    L119:
        if ((r130 & 536870912) == 0) goto L121;
        String r317 = null;
    L123:
        if ((r130 & 1073741824) == 0) goto L125;
        String r318 = null;
    L127:
        if ((r130 & Integer.MIN_VALUE) == 0) goto L129;
        String r150 = null;
    L131:
        if ((r131 & 1) == 0) goto L133;
        int r319 = -1;
    L135:
        if ((r131 & 2) == 0) goto L137;
        String r410 = null;
    L139:
        if ((r131 & 4) == 0) goto L141;
        String r411 = null;
    L143:
        if ((r131 & 8) == 0) goto L145;
        String r412 = null;
    L147:
        if ((r131 & 16) == 0) goto L149;
        String r413 = null;
    L151:
        if ((r131 & 32) == 0) goto L153;
        String r414 = null;
    L155:
        if ((r131 & 64) == 0) goto L157;
        String r415 = null;
    L158:
        String r1311 = r150;
        if ((r131 & 128) == 0) goto L161;
        Boolean r151 = null;
    L162:
        Boolean r416 = r151;
        if ((r131 & 256) == 0) goto L165;
        String r152 = null;
    L166:
        String r417 = r152;
        if ((r131 & 512) == 0) goto L169;
        String r153 = null;
    L170:
        String r418 = r153;
        if ((r131 & 1024) == 0) goto L173;
        String r154 = null;
    L174:
        String r419 = r154;
        if ((r131 & 2048) == 0) goto L177;
        String r155 = null;
    L178:
        String r510 = r155;
        if ((r131 & 4096) == 0) goto L181;
        String r156 = null;
    L182:
        String r511 = r156;
        if ((r131 & 8192) == 0) goto L185;
        String r157 = null;
    L186:
        String r512 = r157;
        if ((r131 & 16384) == 0) goto L189;
        String r158 = null;
    L191:
        if ((r131 & 32768) == 0) goto L193;
        String r159 = null;
    L195:
        if ((r131 & 65536) == 0) goto L197;
        String r160 = null;
    L199:
        if ((r131 & 131072) == 0) goto L201;
        String r216 = null;
    L203:
        if ((r131 & 262144) == 0) goto L205;
        String r217 = null;
    L207:
        if ((r131 & 524288) == 0) goto L209;
        String r218 = null;
    L211:
        if ((r131 & 1048576) == 0) goto L213;
        String r219 = null;
    L215:
        if ((r131 & 2097152) == 0) goto L217;
        String r513 = null;
    L219:
        if ((r131 & 4194304) == 0) goto L221;
        String r514 = null;
    L223:
        if ((r131 & 8388608) == 0) goto L225;
        String r515 = null;
    L227:
        if ((r131 & 16777216) == 0) goto L229;
        String r516 = null;
    L231:
        if ((r131 & 33554432) == 0) goto L233;
        Integer r517 = null;
    L235:
        if ((r131 & 67108864) == 0) goto L237;
        Integer r518 = null;
    L239:
        if ((r131 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        Long r519 = null;
    L243:
        if ((r131 & 268435456) == 0) goto L245;
        Integer r614 = null;
    L247:
        if ((r131 & 536870912) == 0) goto L249;
        Long r615 = null;
    L251:
        if ((r131 & 1073741824) == 0) goto L253;
        String r616 = null;
    L255:
        if ((r131 & Integer.MIN_VALUE) == 0) goto L257;
        Boolean r161 = null;
    L258:
        this(r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r1310, r147, r148, r149, r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r1311, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r158, r159, r160, r216, r217, r218, r219, r513, r514, r515, r516, r517, r518, r519, r614, r615, r616, r161);
        return;
    L257:
        r161 = r129;
        goto L258
    L253:
        r616 = r128;
        goto L255
    L249:
        r615 = r127;
        goto L251
    L245:
        r614 = r126;
        goto L247
    L241:
        r519 = r125;
        goto L243
    L237:
        r518 = r124;
        goto L239
    L233:
        r517 = r123;
        goto L235
    L229:
        r516 = r122;
        goto L231
    L225:
        r515 = r121;
        goto L227
    L221:
        r514 = r120;
        goto L223
    L217:
        r513 = r119;
        goto L219
    L213:
        r219 = r118;
        goto L215
    L209:
        r218 = r117;
        goto L211
    L205:
        r217 = r116;
        goto L207
    L201:
        r216 = r115;
        goto L203
    L197:
        r160 = r114;
        goto L199
    L193:
        r159 = r113;
        goto L195
    L189:
        r158 = r112;
        goto L191
    L185:
        r157 = r111;
        goto L186
    L181:
        r156 = r110;
        goto L182
    L177:
        r155 = r109;
        goto L178
    L173:
        r154 = r108;
        goto L174
    L169:
        r153 = r107;
        goto L170
    L165:
        r152 = r106;
        goto L166
    L161:
        r151 = r105;
        goto L162
    L157:
        r415 = r104;
        goto L158
    L153:
        r414 = r103;
        goto L155
    L149:
        r413 = r102;
        goto L151
    L145:
        r412 = r101;
        goto L147
    L141:
        r411 = r100;
        goto L143
    L137:
        r410 = r919;
        goto L139
    L133:
        r319 = r918;
        goto L135
    L129:
        r150 = r917;
        goto L131
    L125:
        r318 = r916;
        goto L127
    L121:
        r317 = r915;
        goto L123
    L117:
        r316 = r914;
        goto L119
    L113:
        r315 = r913;
        goto L115
    L109:
        r314 = r912;
        goto L111
    L105:
        r313 = r911;
        goto L107
    L101:
        r312 = r910;
        goto L103
    L97:
        r311 = r819;
        goto L99
    L93:
        r310 = r818;
        goto L95
    L89:
        r215 = r817;
        goto L91
    L85:
        r214 = r816;
        goto L87
    L81:
        r213 = r815;
        goto L83
    L77:
        r212 = r814;
        goto L79
    L73:
        r211 = r813;
        goto L75
    L69:
        r210 = r812;
        goto L71
    L65:
        r149 = r811;
        goto L67
    L61:
        r148 = r810;
        goto L63
    L57:
        r146 = r719;
        goto L58
    L53:
        r145 = r718;
        goto L54
    L49:
        r144 = r717;
        goto L51
    L45:
        r143 = r716;
        goto L47
    L41:
        r142 = r715;
        goto L43
    L37:
        r141 = r714;
        goto L39
    L33:
        r140 = r713;
        goto L35
    L29:
        r139 = r712;
        goto L31
    L25:
        r138 = r711;
        goto L27
    L21:
        r137 = r710;
        goto L23
    L17:
        r136 = r613;
        goto L19
    L13:
        r135 = r612;
        goto L15
    L9:
        r134 = r611;
        goto L11
    L5:
        r133 = r610;
        goto L7
    }

    public BotEntity(int r110, int r111, int r112, String r113, String r114, String r210, long r211, Long r212, Integer r213, String r214, String r215, String r216, String r217, Integer r218, String r310, String r311, String r312, Integer r313, Integer r314, String r315, String r316, String r317, boolean r318, Integer r319, Boolean r410, Boolean r411, String r412, String r413, String r414, String r415, String r416, String r417, String r418, String r419, String r510, int r511, String r512, String r513, String r514, String r515, String r516, String r517, Boolean r518, String r519, String r610, String r611, String r612, String r613, String r614, String r615, String r616, String r617, String r618, String r619, String r710, String r711, String r712, String r713, String r714, String r715, Integer r716, Integer r717, Long r718, Integer r719, Long r810, String r811, Boolean r812, q2 r813) {
        boolean r100 = false;
        if ((r110 & 0) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r111 & 0) == 0) goto L9;
        boolean r102 = true;
    L10:
        boolean r103 = r101 | r102;
        if ((r112 & 0) == 0) goto L13;
        boolean r104 = true;
    L15:
        if ((r103 | r104) == false) goto L17;
        b2.a(new int[]{r110, r111, r112}, new int[]{0, 0, 0}, a.f348110b);
        throw null;
    L17:
        if ((r110 & 1) != 0) goto L19;
        String r105 = "";
    L20:
        this.botId = r105;
        if ((r110 & 2) != 0) goto L23;
        this.name = null;
    L25:
        if ((r110 & 4) != 0) goto L27;
        this.iconImage = null;
    L29:
        if ((r110 & 8) != 0) goto L31;
        long r106 = com.larus.im.internal.delegate.c.f348197a.currentTimeMillis();
    L32:
        this.createTime = r106;
        if ((r110 & 16) != 0) goto L35;
        this.updateTime = null;
    L37:
        if ((r110 & 32) != 0) goto L39;
        this.botType = null;
    L41:
        if ((r110 & 64) != 0) goto L43;
        this.shareInfo = null;
    L45:
        if ((r110 & 128) != 0) goto L47;
        this.botCreatorInfo = null;
    L49:
        if ((r110 & 256) != 0) goto L51;
        this.tagList = null;
    L53:
        if ((r110 & 512) != 0) goto L55;
        this.selectTextActions = null;
    L57:
        if ((r110 & 1024) != 0) goto L59;
        this.privateStatus = null;
    L61:
        if ((r110 & 2048) != 0) goto L63;
        this.conversationPage = null;
    L65:
        if ((r110 & 4096) != 0) goto L67;
        this.descriptionForModel = null;
    L69:
        if ((r110 & 8192) != 0) goto L71;
        this.descriptionForHuman = null;
    L73:
        if ((r110 & 16384) != 0) goto L75;
        this.botStatus = null;
    L77:
        if ((r110 & 32768) != 0) goto L79;
        this.status = null;
    L81:
        if ((r110 & 65536) != 0) goto L83;
        this.model = null;
    L85:
        if ((r110 & 131072) != 0) goto L87;
        this.voiceType = null;
    L89:
        if ((r110 & 262144) != 0) goto L91;
        this.editPos = null;
    L93:
        if ((r110 & 524288) == 0) goto L96;
        r100 = r318;
    L96:
        this.muted = r100;
        if ((r110 & 1048576) != 0) goto L99;
        this.recommendIndex = null;
    L101:
        if ((r110 & 2097152) != 0) goto L103;
        Boolean r115 = Boolean.FALSE;
    L104:
        this.messagePush = r115;
        if ((r110 & 4194304) != 0) goto L107;
        Boolean r116 = Boolean.FALSE;
    L108:
        this.showMessagePush = r116;
        if ((r110 & 8388608) != 0) goto L111;
        this.bio = null;
    L113:
        if ((16777216 & r110) != 0) goto L115;
        this.bioEdit = null;
    L117:
        if ((33554432 & r110) != 0) goto L119;
        this.botStatistic = null;
    L121:
        if ((67108864 & r110) != 0) goto L123;
        this.answerActions = null;
    L125:
        if ((134217728 & r110) != 0) goto L127;
        this.actionScenes = null;
    L129:
        if ((268435456 & r110) != 0) goto L131;
        this.answerActionExposurePriority = null;
    L133:
        if ((536870912 & r110) != 0) goto L135;
        this.menuActions = null;
    L137:
        if ((1073741824 & r110) != 0) goto L139;
        this.streamingAnswerActions = null;
    L141:
        if ((r110 & Integer.MIN_VALUE) != 0) goto L143;
        this.botConf = null;
    L145:
        if ((r111 & 1) != 0) goto L147;
        int r107 = -1;
    L148:
        this.botMode = r107;
        if ((r111 & 2) != 0) goto L151;
        this.bgImgUrl = null;
    L153:
        if ((r111 & 4) != 0) goto L155;
        this.bgImgColor = null;
    L157:
        if ((r111 & 8) != 0) goto L159;
        this.bgVideoModel = null;
    L161:
        if ((r111 & 16) != 0) goto L163;
        this.iconPrompt = null;
    L165:
        if ((r111 & 32) != 0) goto L167;
        this.switchConfInfo = null;
    L169:
        if ((r111 & 64) != 0) goto L171;
        this.callerName = null;
    L173:
        if ((r111 & 128) != 0) goto L175;
        this.callerNameSettings = null;
    L177:
        if ((r111 & 256) != 0) goto L179;
        this.sceneModelList = null;
    L181:
        if ((r111 & 512) != 0) goto L183;
        this.firstMet = null;
    L185:
        if ((r111 & 1024) != 0) goto L187;
        this.cameraTabConfigMap = null;
    L189:
        if ((r111 & 2048) != 0) goto L191;
        this.botFeatureLabel = null;
    L193:
        if ((r111 & 4096) != 0) goto L195;
        this.onboarding = null;
    L197:
        if ((r111 & 8192) != 0) goto L199;
        this.bgImgUri = null;
    L201:
        if ((r111 & 16384) != 0) goto L203;
        this.bgImgInfo = null;
    L205:
        if ((r111 & 32768) != 0) goto L207;
        this.botMemoryConfig = null;
    L209:
        if ((r111 & 65536) != 0) goto L211;
        this.callImgConfig = null;
    L213:
        if ((r111 & 131072) != 0) goto L215;
        this.botIconMappedAppIcon = null;
    L217:
        if ((r111 & 262144) != 0) goto L219;
        this.dynamicImgUri = null;
    L221:
        if ((r111 & 524288) != 0) goto L223;
        this.dynamicImgUrl = null;
    L225:
        if ((r111 & 1048576) != 0) goto L227;
        this.messagePushSwitchConfirmTitle = null;
    L229:
        if ((r111 & 2097152) != 0) goto L231;
        this.msgRegenModeList = null;
    L233:
        if ((r111 & 4194304) != 0) goto L235;
        this.unavailableInstructionTypeList = null;
    L237:
        if ((r111 & 8388608) != 0) goto L239;
        this.serviceBotConf = null;
    L241:
        if ((16777216 & r111) != 0) goto L243;
        this.loadingConf = null;
    L245:
        if ((33554432 & r111) != 0) goto L247;
        this.likeInfoShow = null;
    L249:
        if ((67108864 & r111) != 0) goto L251;
        this.likeInfoLiked = null;
    L253:
        if ((134217728 & r111) != 0) goto L255;
        this.likeInfoCount = null;
    L257:
        if ((268435456 & r111) != 0) goto L259;
        this.botCommentInfoShow = null;
    L261:
        if ((536870912 & r111) != 0) goto L263;
        this.botCommentInfoCount = null;
    L265:
        if ((1073741824 & r111) != 0) goto L267;
        this.extra = null;
    L269:
        if ((Integer.MIN_VALUE & r111) != 0) goto L271;
        this.isDisable = null;
        return;
    L271:
        this.isDisable = r812;
        return;
    L267:
        this.extra = r811;
        goto L269
    L263:
        this.botCommentInfoCount = r810;
        goto L265
    L259:
        this.botCommentInfoShow = r719;
        goto L261
    L255:
        this.likeInfoCount = r718;
        goto L257
    L251:
        this.likeInfoLiked = r717;
        goto L253
    L247:
        this.likeInfoShow = r716;
        goto L249
    L243:
        this.loadingConf = r715;
        goto L245
    L239:
        this.serviceBotConf = r714;
        goto L241
    L235:
        this.unavailableInstructionTypeList = r713;
        goto L237
    L231:
        this.msgRegenModeList = r712;
        goto L233
    L227:
        this.messagePushSwitchConfirmTitle = r711;
        goto L229
    L223:
        this.dynamicImgUrl = r710;
        goto L225
    L219:
        this.dynamicImgUri = r619;
        goto L221
    L215:
        this.botIconMappedAppIcon = r618;
        goto L217
    L211:
        this.callImgConfig = r617;
        goto L213
    L207:
        this.botMemoryConfig = r616;
        goto L209
    L203:
        this.bgImgInfo = r615;
        goto L205
    L199:
        this.bgImgUri = r614;
        goto L201
    L195:
        this.onboarding = r613;
        goto L197
    L191:
        this.botFeatureLabel = r612;
        goto L193
    L187:
        this.cameraTabConfigMap = r611;
        goto L189
    L183:
        this.firstMet = r610;
        goto L185
    L179:
        this.sceneModelList = r519;
        goto L181
    L175:
        this.callerNameSettings = r518;
        goto L177
    L171:
        this.callerName = r517;
        goto L173
    L167:
        this.switchConfInfo = r516;
        goto L169
    L163:
        this.iconPrompt = r515;
        goto L165
    L159:
        this.bgVideoModel = r514;
        goto L161
    L155:
        this.bgImgColor = r513;
        goto L157
    L151:
        this.bgImgUrl = r512;
        goto L153
    L147:
        r107 = r511;
        goto L148
    L143:
        this.botConf = r510;
        goto L145
    L139:
        this.streamingAnswerActions = r419;
        goto L141
    L135:
        this.menuActions = r418;
        goto L137
    L131:
        this.answerActionExposurePriority = r417;
        goto L133
    L127:
        this.actionScenes = r416;
        goto L129
    L123:
        this.answerActions = r415;
        goto L125
    L119:
        this.botStatistic = r414;
        goto L121
    L115:
        this.bioEdit = r413;
        goto L117
    L111:
        this.bio = r412;
        goto L113
    L107:
        r116 = r411;
        goto L108
    L103:
        r115 = r410;
        goto L104
    L99:
        this.recommendIndex = r319;
        goto L101
    L91:
        this.editPos = r317;
        goto L93
    L87:
        this.voiceType = r316;
        goto L89
    L83:
        this.model = r315;
        goto L85
    L79:
        this.status = r314;
        goto L81
    L75:
        this.botStatus = r313;
        goto L77
    L71:
        this.descriptionForHuman = r312;
        goto L73
    L67:
        this.descriptionForModel = r311;
        goto L69
    L63:
        this.conversationPage = r310;
        goto L65
    L59:
        this.privateStatus = r218;
        goto L61
    L55:
        this.selectTextActions = r217;
        goto L57
    L51:
        this.tagList = r216;
        goto L53
    L47:
        this.botCreatorInfo = r215;
        goto L49
    L43:
        this.shareInfo = r214;
        goto L45
    L39:
        this.botType = r213;
        goto L41
    L35:
        this.updateTime = r212;
        goto L37
    L31:
        r106 = r211;
        goto L32
    L27:
        this.iconImage = r210;
        goto L29
    L23:
        this.name = r114;
        goto L25
    L19:
        r105 = r113;
        goto L20
    L13:
        r104 = false;
        goto L15
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }
}
