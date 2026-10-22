package com.larus.im.bean.message;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
import com.tencent.connect.common.Constants;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
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
import kotlin.text.StringsKt;
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
import nuc.i0;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;
import yc9.a0;
import yc9.b0;
import yc9.u;
import yc9.v;
import yc9.w;
import yc9.x;
import yc9.y;
import yc9.z;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b~\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Â\u00012\u00060\u0001j\u0002`\u0002:\u0004Á\u0001Â\u0001Bé\u0003\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0003\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0012\u0012\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010'\u001a\u00020\b\u0012\b\b\u0002\u0010(\u001a\u00020\u000e\u0012\b\b\u0002\u0010)\u001a\u00020\u001c\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012\u0012\b\b\u0002\u0010,\u001a\u00020\u000e\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010/\u001a\u00020\u001c\u0012\u0012\b\u0002\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0012\u0012\u0016\b\u0002\u00101\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0012\u0018\u00010\u0012\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b3\u00104B»\u0003\b\u0010\u0012\u0006\u00105\u001a\u00020\b\u0012\u0006\u00106\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u000e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0012\u0012\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010$\u0012\b\u0010%\u001a\u0004\u0018\u00010\b\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010'\u001a\u00020\b\u0012\u0006\u0010(\u001a\u00020\u000e\u0012\u0006\u0010)\u001a\u00020\u001c\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012\u0012\u0006\u0010,\u001a\u00020\u000e\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010.\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010/\u001a\u00020\u001c\u0012\u0010\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0012\u0012\u0014\u00101\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0012\u0018\u00010\u0012\u0012\b\u00102\u001a\u0004\u0018\u00010\u0004\u0012\b\u00107\u001a\u0004\u0018\u000108¢\u0006\u0004\b3\u00109J\t\u0010\u008d\u0001\u001a\u00020\u0004H\u0016J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\bHÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010\u0098\u0001\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0018\u0010\u009b\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010 \u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010£\u0001\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0012HÆ\u0003J\u0018\u0010¤\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010$HÆ\u0003J\u0011\u0010¥\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010rJ\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010§\u0001\u001a\u00020\bHÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010©\u0001\u001a\u00020\u001cHÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010«\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010®\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010rJ\n\u0010¯\u0001\u001a\u00020\u001cHÆ\u0003J\u0014\u0010°\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0012HÆ\u0003J\u0018\u0010±\u0001\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0012\u0018\u00010\u0012HÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jò\u0003\u0010³\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0003\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00122\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00042\b\b\u0003\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u001c2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00122\b\b\u0002\u0010,\u001a\u00020\u000e2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010/\u001a\u00020\u001c2\u0012\b\u0002\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00122\u0016\b\u0002\u00101\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0012\u0018\u00010\u00122\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0003\u0010´\u0001J\u0016\u0010µ\u0001\u001a\u00020\u000e2\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001HÖ\u0003J\n\u0010¸\u0001\u001a\u00020\bHÖ\u0001J-\u0010¹\u0001\u001a\u00030º\u00012\u0007\u0010»\u0001\u001a\u00020\u00002\b\u0010¼\u0001\u001a\u00030½\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0001¢\u0006\u0003\bÀ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010;\u001a\u0004\b?\u0010=R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010;\u001a\u0004\bA\u0010=R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010;\u001a\u0004\bC\u0010DR\u001c\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010;\u001a\u0004\bF\u0010DR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010;\u001a\u0004\bH\u0010IR\u001c\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010;\u001a\u0004\bK\u0010DR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010;\u001a\u0004\b\r\u0010MR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010;\u001a\u0004\bO\u0010=R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010;\u001a\u0004\bQ\u0010=R$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010;\u001a\u0004\bS\u0010TR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010;\u001a\u0004\bV\u0010=R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bW\u0010;\u001a\u0004\bX\u0010YR*\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bZ\u0010;\u001a\u0004\b[\u0010\\R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b]\u0010;\u001a\u0004\b^\u0010=R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b_\u0010;\u001a\u0004\b`\u0010=R\u001c\u0010\u001b\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\ba\u0010;\u001a\u0004\bb\u0010cR\u001c\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bd\u0010;\u001a\u0004\be\u0010cR\u001c\u0010\u001e\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bf\u0010;\u001a\u0004\bg\u0010MR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bh\u0010;\u001a\u0004\bi\u0010=R\u001e\u0010 \u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bj\u0010;\u001a\u0004\bk\u0010=R$\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bl\u0010;\u001a\u0004\bm\u0010TR*\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bn\u0010;\u001a\u0004\bo\u0010\\R \u0010%\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010s\u0012\u0004\bp\u0010;\u001a\u0004\bq\u0010rR\u001e\u0010&\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bt\u0010;\u001a\u0004\bu\u0010=R\u001c\u0010'\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bv\u0010;\u001a\u0004\bw\u0010DR\u001c\u0010(\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bx\u0010;\u001a\u0004\by\u0010MR\u001c\u0010)\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bz\u0010;\u001a\u0004\b{\u0010cR\u001e\u0010*\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b|\u0010;\u001a\u0004\b}\u0010=R$\u0010+\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b~\u0010;\u001a\u0004\b\u007f\u0010TR\u001e\u0010,\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0080\u0001\u0010;\u001a\u0005\b\u0081\u0001\u0010MR \u0010-\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0082\u0001\u0010;\u001a\u0005\b\u0083\u0001\u0010=R!\u0010.\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0011\n\u0002\u0010s\u0012\u0005\b\u0084\u0001\u0010;\u001a\u0004\b.\u0010rR\u001e\u0010/\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0085\u0001\u0010;\u001a\u0005\b\u0086\u0001\u0010cR(\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0087\u0001\u0010;\u001a\u0005\b\u0088\u0001\u0010TR,\u00101\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0012\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0089\u0001\u0010;\u001a\u0005\b\u008a\u0001\u0010TR \u00102\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u008b\u0001\u0010;\u001a\u0005\b\u008c\u0001\u0010=¨\u0006Ã\u0001"}, d2 = {"Lcom/larus/im/bean/message/Message;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationId", "", "threadId", "senderId", "userType", "", "messageStatusLocal", "messageStatus", "Lcom/larus/im/bean/message/MessageStatus;", "contentType", "isNewBlockType", "", SelectInfo.BRIEF, "content", "contentBlock", "", "Lcom/larus/im/bean/message/block/Block;", "thinkingContent", "referenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "ext", "", "localMessageId", "messageId", "localIndex", "", "serverIndex", "sourceFromAsr", "sectionId", "sectionName", "suggestQuestions", "Lcom/larus/im/bean/message/SuggestQuestion;", "businessExt", "", "feedback", "regenRootId", "regenStatus", "regenVisible", "regenIndex", "replyId", PromotionProductPrivilegesStruct.TAGS, "msgLoading", "bizContentType", "isConnectCallerName", "createTime", "subList", "subListGroup", "collectionIdCompat", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/larus/im/bean/message/MessageStatus;IZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/larus/im/bean/message/ReferenceInfo;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;JJZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/String;IZJLjava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/Integer;JLjava/util/List;Ljava/util/List;Ljava/lang/String;)V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/larus/im/bean/message/MessageStatus;IZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/larus/im/bean/message/ReferenceInfo;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;JJZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/String;IZJLjava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/Integer;JLjava/util/List;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId$annotations", "()V", "getConversationId", "()Ljava/lang/String;", "getThreadId$annotations", "getThreadId", "getSenderId$annotations", "getSenderId", "getUserType$annotations", "getUserType", "()I", "getMessageStatusLocal$annotations", "getMessageStatusLocal", "getMessageStatus$annotations", "getMessageStatus", "()Lcom/larus/im/bean/message/MessageStatus;", "getContentType$annotations", "getContentType", "isNewBlockType$annotations", "()Z", "getBrief$annotations", "getBrief", "getContent$annotations", "getContent", "getContentBlock$annotations", "getContentBlock", "()Ljava/util/List;", "getThinkingContent$annotations", "getThinkingContent", "getReferenceInfo$annotations", "getReferenceInfo", "()Lcom/larus/im/bean/message/ReferenceInfo;", "getExt$annotations", "getExt", "()Ljava/util/Map;", "getLocalMessageId$annotations", "getLocalMessageId", "getMessageId$annotations", "getMessageId", "getLocalIndex$annotations", "getLocalIndex", "()J", "getServerIndex$annotations", "getServerIndex", "getSourceFromAsr$annotations", "getSourceFromAsr", "getSectionId$annotations", "getSectionId", "getSectionName$annotations", "getSectionName", "getSuggestQuestions$annotations", "getSuggestQuestions", "getBusinessExt$annotations", "getBusinessExt", "getFeedback$annotations", "getFeedback", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRegenRootId$annotations", "getRegenRootId", "getRegenStatus$annotations", "getRegenStatus", "getRegenVisible$annotations", "getRegenVisible", "getRegenIndex$annotations", "getRegenIndex", "getReplyId$annotations", "getReplyId", "getTags$annotations", "getTags", "getMsgLoading$annotations", "getMsgLoading", "getBizContentType$annotations", "getBizContentType", "isConnectCallerName$annotations", "getCreateTime$annotations", "getCreateTime", "getSubList$annotations", "getSubList", "getSubListGroup$annotations", "getSubListGroup", "getCollectionIdCompat$annotations", "getCollectionIdCompat", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/larus/im/bean/message/MessageStatus;IZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/larus/im/bean/message/ReferenceInfo;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;JJZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/String;IZJLjava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/Integer;JLjava/util/List;Ljava/util/List;Ljava/lang/String;)Lcom/larus/im/bean/message/Message;", "equals", "other", "", "hashCode", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class Message implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private final String bizContentType;
    private final String brief;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> businessExt;
    private final String collectionIdCompat;
    private final String content;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Block> contentBlock;
    private final int contentType;
    private final String conversationId;
    private final long createTime;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> ext;
    private final Integer feedback;
    private final Integer isConnectCallerName;
    private final boolean isNewBlockType;
    private final long localIndex;
    private final String localMessageId;
    private final String messageId;
    private final MessageStatus messageStatus;
    private final int messageStatusLocal;
    private final boolean msgLoading;
    private final ReferenceInfo referenceInfo;
    private final long regenIndex;
    private final String regenRootId;
    private final int regenStatus;
    private final boolean regenVisible;
    private final String replyId;
    private final String sectionId;
    private final String sectionName;
    private final String senderId;
    private final long serverIndex;
    private final boolean sourceFromAsr;
    private final List<Message> subList;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<List<Message>> subListGroup;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<SuggestQuestion> suggestQuestions;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Integer> tags;
    private final String thinkingContent;
    private final String threadId;
    private final int userType;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<Message> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346671a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346672b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346672b;
        }

        static {
            a r100 = new a();
            f346671a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.Message", r100, 37);
            r101.j("conversation_id", true);
            r101.j(CrashHianalyticsData.THREAD_ID, true);
            r101.j("sender_id", true);
            r101.j("user_type", true);
            r101.j("message_status_local", true);
            r101.j("message_status", true);
            r101.j("content_type", true);
            r101.j("is_new_block_type", true);
            r101.j(SelectInfo.BRIEF, true);
            r101.j("content", true);
            r101.j("content_block", true);
            r101.j("thinking_content", true);
            r101.j("reference_info", true);
            r101.j("ext", true);
            r101.j("local_message_id", true);
            r101.j(MusicAppletPage.KEY_MESSAGE_ID, true);
            r101.j("local_index", true);
            r101.j("server_index", true);
            r101.j("source_from_asr", true);
            r101.j("section_id", true);
            r101.j("section_name", true);
            r101.j("suggest_question", true);
            r101.j("business_ext", true);
            r101.j("feedback", true);
            r101.j("regen_root_id", true);
            r101.j("regen_status", true);
            r101.j("regen_visible", true);
            r101.j("regen_index", true);
            r101.j(NoticeInfo.KEY_REPLY_ID, true);
            r101.j(PromotionProductPrivilegesStruct.TAGS, true);
            r101.j("msg_loading", true);
            r101.j("biz_content_type", true);
            r101.j("is_connect_caller_name", true);
            r101.j("create_time", true);
            r101.j("sub_list", true);
            r101.j("sub_list_group", true);
            r101.j("collection_id", true);
            f346672b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = Message.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            w0 r102 = w0.f520792a;
            i r103 = i.f520705a;
            g1 r104 = g1.f520681a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), r102, r102, kuc.a.d((d) r100[5].getValue()), r102, r103, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d((d) r100[10].getValue()), kuc.a.d(r101), kuc.a.d(ReferenceInfo.a.f346698a), kuc.a.d((d) r100[13].getValue()), kuc.a.d(r101), kuc.a.d(r101), r104, r104, r103, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d((d) r100[21].getValue()), kuc.a.d((d) r100[22].getValue()), kuc.a.d(r102), kuc.a.d(r101), r102, r103, r104, kuc.a.d(r101), kuc.a.d((d) r100[29].getValue()), r103, kuc.a.d(r101), kuc.a.d(r102), r104, kuc.a.d((d) r100[34].getValue()), kuc.a.d((d) r100[35].getValue()), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r710) {
            Intrinsics.checkNotNullParameter(r710, "decoder");
            g2 r100 = f346672b;
            muc.c r101 = r710.beginStructure(r100);
            Lazy[] r102 = Message.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            int r112 = r101.decodeIntElement(r100, 3);
            int r105 = r101.decodeIntElement(r100, 4);
            MessageStatus r113 = (MessageStatus) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), null);
            int r114 = r101.decodeIntElement(r100, 6);
            boolean r106 = r101.decodeBooleanElement(r100, 7);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 8, r103, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 9, r103, null);
            List r109 = (List) r101.decodeNullableSerializableElement(r100, 10, (juc.c) r102[10].getValue(), null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 11, r103, null);
            ReferenceInfo r116 = (ReferenceInfo) r101.decodeNullableSerializableElement(r100, 12, ReferenceInfo.a.f346698a, null);
            Map r117 = (Map) r101.decodeNullableSerializableElement(r100, 13, (juc.c) r102[13].getValue(), null);
            String r118 = (String) r101.decodeNullableSerializableElement(r100, 14, r103, null);
            String r119 = (String) r101.decodeNullableSerializableElement(r100, 15, r103, null);
            long r120 = r101.decodeLongElement(r100, 16);
            long r210 = r101.decodeLongElement(r100, 17);
            boolean r121 = r101.decodeBooleanElement(r100, 18);
            String r122 = (String) r101.decodeNullableSerializableElement(r100, 19, r103, null);
            String r123 = (String) r101.decodeNullableSerializableElement(r100, 20, r103, null);
            List r124 = (List) r101.decodeNullableSerializableElement(r100, 21, (juc.c) r102[21].getValue(), null);
            Map r125 = (Map) r101.decodeNullableSerializableElement(r100, 22, (juc.c) r102[22].getValue(), null);
            w0 r126 = w0.f520792a;
            Integer r127 = (Integer) r101.decodeNullableSerializableElement(r100, 23, r126, null);
            String r128 = (String) r101.decodeNullableSerializableElement(r100, 24, r103, null);
            int r129 = r101.decodeIntElement(r100, 25);
            boolean r130 = r101.decodeBooleanElement(r100, 26);
            long r310 = r101.decodeLongElement(r100, 27);
            String r131 = (String) r101.decodeNullableSerializableElement(r100, 28, r103, null);
            List r132 = (List) r101.decodeNullableSerializableElement(r100, 29, (juc.c) r102[29].getValue(), null);
            boolean r133 = r101.decodeBooleanElement(r100, 30);
            String r410 = (String) r101.decodeNullableSerializableElement(r100, 31, r103, null);
            Integer r134 = (Integer) r101.decodeNullableSerializableElement(r100, 32, r126, null);
            long r411 = r101.decodeLongElement(r100, 33);
            List r135 = (List) r101.decodeNullableSerializableElement(r100, 34, (juc.c) r102[34].getValue(), null);
            int r136 = -1;
            Integer r412 = r134;
            List r510 = (List) r101.decodeNullableSerializableElement(r100, 35, (juc.c) r102[35].getValue(), null);
            String r511 = (String) r101.decodeNullableSerializableElement(r100, 36, r103, null);
            List r512 = r135;
            int r137 = r105;
            boolean r413 = r133;
            String r138 = r110;
            String r139 = r111;
            String r414 = r410;
            long r415 = r411;
            int r311 = r129;
            int r140 = r114;
            String r141 = r104;
            List r416 = r132;
            String r417 = r131;
            String r312 = r123;
            long r418 = r310;
            long r313 = r210;
            Integer r314 = r127;
            String r315 = r128;
            long r211 = r120;
            String r316 = r122;
            List r212 = r109;
            boolean r142 = r106;
            List r317 = r124;
            String r213 = r118;
            String r214 = r107;
            boolean r318 = r121;
            ReferenceInfo r215 = r116;
            String r216 = r115;
            int r143 = r112;
            boolean r419 = r130;
            Map r319 = r125;
            String r217 = r119;
            MessageStatus r144 = r113;
            int r145 = 31;
            Map r218 = r117;
            String r219 = r108;
        L74:
            r101.endStructure(r100);
            return new Message(r136, r145, r138, r141, r139, r143, r137, r144, r140, r142, r214, r219, r212, r216, r215, r218, r213, r217, r211, r313, r318, r316, r312, r317, r319, r314, r315, r311, r419, r418, r417, r416, r413, r414, r412, r415, r512, r510, r511, null);
        L5:
            String r146 = null;
            String r147 = null;
            String r148 = null;
            String r149 = null;
            Map r150 = null;
            String r151 = null;
            List r152 = null;
            Integer r153 = null;
            Integer r154 = null;
            List r155 = null;
            List r156 = null;
            List r157 = null;
            String r320 = null;
            String r420 = null;
            MessageStatus r421 = null;
            String r422 = null;
            String r423 = null;
            List r424 = null;
            String r425 = null;
            String r426 = null;
            ReferenceInfo r427 = null;
            Map r428 = null;
            String r513 = null;
            String r514 = null;
            String r515 = null;
            long r516 = 0;
            long r517 = 0;
            long r610 = 0;
            long r611 = 0;
            int r158 = 0;
            boolean r321 = false;
            boolean r322 = false;
            int r323 = 0;
            boolean r429 = false;
            int r518 = 0;
            int r519 = 0;
            int r520 = 0;
            boolean r521 = false;
            boolean r612 = true;
            int r613 = 0;
        L6:
            if (r612 == false) goto L73;
            String r614 = r151;
            int r159 = r101.decodeElementIndex(r100);
            switch(r159) {
                case -1: goto L69;
                case 0: goto L68;
                case 1: goto L67;
                case 2: goto L65;
                case 3: goto L63;
                case 4: goto L62;
                case 5: goto L61;
                case 6: goto L58;
                case 7: goto L57;
                case 8: goto L56;
                case 9: goto L54;
                case 10: goto L52;
                case 11: goto L51;
                case 12: goto L49;
                case 13: goto L48;
                case 14: goto L47;
                case 15: goto L42;
                case 16: goto L41;
                case 17: goto L38;
                case 18: goto L37;
                case 19: goto L36;
                case 20: goto L35;
                case 21: goto L32;
                case 22: goto L28;
                case 23: goto L26;
                case 24: goto L25;
                case 25: goto L23;
                case 26: goto L22;
                case 27: goto L21;
                case 28: goto L20;
                case 29: goto L19;
                case 30: goto L18;
                case 31: goto L17;
                case 32: goto L16;
                case 33: goto L14;
                case 34: goto L13;
                case 35: goto L12;
                case 36: goto L11;
                default: goto L10;
            };
        L11:
            r147 = (String) r101.decodeNullableSerializableElement(r100, 36, v2.f520790a, r147);
            int r160 = r613 | 16;
        L15:
            r613 = r160;
        L30:
            Unit r161 = Unit.INSTANCE;
        L31:
            r152 = r152;
        L34:
            r147 = r147;
            String r162 = r146;
            String r163 = r514;
        L45:
            List r220 = r157;
            List r164 = r156;
            List r165 = r155;
            String r166 = r162;
            r151 = r614;
        L46:
            r102 = r102;
            String r221 = r163;
            r146 = r166;
            r155 = r165;
            r156 = r164;
            r147 = r147;
            r157 = r220;
            String r222 = r420;
            MessageStatus r167 = r421;
            String r223 = r422;
            r423 = r423;
            List r224 = r424;
            r425 = r425;
            String r225 = r426;
            ReferenceInfo r226 = r427;
            r428 = r428;
            String r227 = r513;
        L72:
            r421 = r167;
            r424 = r224;
            r426 = r225;
            r427 = r226;
            r428 = r428;
            r513 = r227;
            r420 = r222;
            r425 = r425;
            r422 = r223;
            r514 = r221;
            r102 = r102;
            r423 = r423;
            goto L6
        L12:
            r157 = (List) r101.decodeNullableSerializableElement(r100, 35, (juc.c) r102[35].getValue(), r157);
            r160 = r613 | 8;
            goto L15
        L13:
            r155 = (List) r101.decodeNullableSerializableElement(r100, 34, (juc.c) r102[34].getValue(), r155);
            r160 = r613 | 4;
            goto L15
        L14:
            r611 = r101.decodeLongElement(r100, 33);
            r160 = r613 | 2;
            goto L15
        L16:
            r152 = r152;
            r153 = (Integer) r101.decodeNullableSerializableElement(r100, 32, w0.f520792a, r153);
            r613 = r613 | 1;
            goto L30
        L17:
            r149 = (String) r101.decodeNullableSerializableElement(r100, 31, v2.f520790a, r149);
            int r168 = Integer.MIN_VALUE;
        L29:
            r158 = r158 | r168;
            goto L30
        L18:
            r521 = r101.decodeBooleanElement(r100, 30);
            r168 = 1073741824;
            goto L29
        L19:
            r156 = (List) r101.decodeNullableSerializableElement(r100, 29, (juc.c) r102[29].getValue(), r156);
            int r169 = 536870912;
        L27:
            r158 = r158 | r169;
            goto L30
        L20:
            r148 = (String) r101.decodeNullableSerializableElement(r100, 28, v2.f520790a, r148);
            r169 = 268435456;
            goto L27
        L21:
            r610 = r101.decodeLongElement(r100, 27);
            int r170 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        L24:
            r158 = r158 | r170;
            Unit r171 = Unit.INSTANCE;
            r152 = r152;
        L33:
            r147 = r147;
            goto L34
        L22:
            r152 = r152;
            boolean r172 = r101.decodeBooleanElement(r100, 26);
            r158 = r158 | 67108864;
            Unit r173 = Unit.INSTANCE;
            r322 = r172;
            goto L31
        L23:
            r518 = r101.decodeIntElement(r100, 25);
            r170 = 33554432;
            goto L24
        L25:
            r146 = (String) r101.decodeNullableSerializableElement(r100, 24, v2.f520790a, r146);
            r169 = 16777216;
            goto L27
        L26:
            r154 = (Integer) r101.decodeNullableSerializableElement(r100, 23, w0.f520792a, r154);
            r169 = 8388608;
            goto L27
        L28:
            r150 = (Map) r101.decodeNullableSerializableElement(r100, 22, (juc.c) r102[22].getValue(), r150);
            r168 = 4194304;
            goto L29
        L32:
            r152 = (List) r101.decodeNullableSerializableElement(r100, 21, (juc.c) r102[21].getValue(), r152);
            r158 = r158 | 2097152;
            Unit r174 = Unit.INSTANCE;
            goto L33
        L35:
            r147 = r147;
            r151 = (String) r101.decodeNullableSerializableElement(r100, 20, v2.f520790a, r614);
            int r175 = 1048576 | r158;
            Unit r176 = Unit.INSTANCE;
            r158 = r175;
            r220 = r157;
            r152 = r152;
            r164 = r156;
            r165 = r155;
            r166 = r146;
            r163 = r514;
            goto L46
        L36:
            r147 = r147;
            r152 = r152;
            r515 = (String) r101.decodeNullableSerializableElement(r100, 19, v2.f520790a, r515);
            int r177 = r158 | 524288;
            Unit r178 = Unit.INSTANCE;
        L40:
            int r179 = r177;
            String r180 = r515;
        L44:
            r515 = r180;
            r158 = r179;
            r162 = r146;
            r163 = r514;
            r152 = r152;
            goto L45
        L37:
            r429 = r101.decodeBooleanElement(r100, 18);
            int r181 = 262144;
        L39:
            r177 = r158 | r181;
            Unit r182 = Unit.INSTANCE;
            goto L40
        L38:
            r517 = r101.decodeLongElement(r100, 17);
            r181 = 131072;
            goto L39
        L41:
            r516 = r101.decodeLongElement(r100, 16);
            int r183 = r158 | 65536;
            Unit r184 = Unit.INSTANCE;
            String r228 = r515;
        L43:
            r179 = r183;
            r180 = r228;
            goto L44
        L42:
            r228 = r515;
            String r185 = (String) r101.decodeNullableSerializableElement(r100, 15, v2.f520790a, r514);
            r183 = r158 | 32768;
            Unit r186 = Unit.INSTANCE;
            r514 = r185;
            goto L43
        L47:
            r147 = r147;
            r152 = r152;
            r514 = r514;
            r515 = r515;
            r148 = r148;
            String r187 = (String) r101.decodeNullableSerializableElement(r100, 14, v2.f520790a, r513);
            int r188 = r158 | 16384;
            Unit r189 = Unit.INSTANCE;
            r513 = r187;
            r423 = r423;
            r424 = r424;
            r425 = r425;
            r427 = r427;
            r428 = r428;
        L60:
            MessageStatus r190 = r421;
        L64:
            r223 = r422;
            int r191 = r188;
            ReferenceInfo r192 = r427;
            List r193 = r424;
            r222 = r420;
            String r194 = r426;
            MessageStatus r195 = r190;
        L71:
            r221 = r514;
            r515 = r515;
            r152 = r152;
            r224 = r193;
            r148 = r148;
            r225 = r194;
            r151 = r614;
            MessageStatus r615 = r195;
            r158 = r191;
            r147 = r147;
            r167 = r615;
            String r711 = r513;
            r226 = r192;
            r149 = r149;
            r227 = r711;
            goto L72
        L48:
            r513 = r513;
            Map r196 = (Map) r101.decodeNullableSerializableElement(r100, 13, (juc.c) r102[13].getValue(), r428);
            int r197 = r158 | 8192;
            Unit r198 = Unit.INSTANCE;
            r428 = r196;
            r188 = r197;
        L50:
            r423 = r423;
            r424 = r424;
            r425 = r425;
            r427 = r427;
            goto L60
        L49:
            r513 = r513;
            r428 = r428;
            ReferenceInfo r199 = (ReferenceInfo) r101.decodeNullableSerializableElement(r100, 12, ReferenceInfo.a.f346698a, r427);
            r188 = r158 | 4096;
            Unit r200 = Unit.INSTANCE;
            r427 = r199;
            goto L50
        L51:
            r147 = r147;
            r148 = r148;
            r152 = r152;
            r427 = r427;
            r428 = r428;
            r513 = r513;
            r514 = r514;
            r515 = r515;
            String r201 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r425);
            r188 = r158 | 2048;
            Unit r202 = Unit.INSTANCE;
            r425 = r201;
            r423 = r423;
            r424 = r424;
            goto L60
        L52:
            r147 = r147;
            r148 = r148;
            r149 = r149;
            r152 = r152;
            r427 = r427;
            r428 = r428;
            r513 = r513;
            r514 = r514;
            r515 = r515;
            r425 = r425;
            List r203 = (List) r101.decodeNullableSerializableElement(r100, 10, (juc.c) r102[10].getValue(), r424);
            int r204 = r158 | 1024;
            Unit r205 = Unit.INSTANCE;
            r424 = r203;
            r188 = r204;
            r190 = r421;
            r422 = r422;
            r423 = r423;
            goto L64
        L54:
            r147 = r147;
            r148 = r148;
            r152 = r152;
            r425 = r425;
            r427 = r427;
            r428 = r428;
            r513 = r513;
            r514 = r514;
            r515 = r515;
            r424 = r424;
            String r206 = (String) r101.decodeNullableSerializableElement(r100, 9, v2.f520790a, r423);
            r188 = r158 | 512;
            Unit r207 = Unit.INSTANCE;
            r423 = r206;
            goto L60
        L56:
            r423 = r423;
            r422 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r422);
            int r208 = r158 | 256;
            Unit r209 = Unit.INSTANCE;
            r188 = r208;
            boolean r324 = r321;
        L59:
            r321 = r324;
            goto L60
        L57:
            r422 = r422;
            r423 = r423;
            r324 = r101.decodeBooleanElement(r100, 7);
            r188 = r158 | 128;
            Unit r325 = Unit.INSTANCE;
            goto L59
        L58:
            r422 = r422;
            r423 = r423;
            r520 = r101.decodeIntElement(r100, 6);
            r188 = r158 | 64;
            Unit r326 = Unit.INSTANCE;
            r324 = r321;
            goto L59
        L61:
            r147 = r147;
            r148 = r148;
            r149 = r149;
            r152 = r152;
            r422 = r422;
            r423 = r423;
            r424 = r424;
            r425 = r425;
            r427 = r427;
            r428 = r428;
            r513 = r513;
            r514 = r514;
            r515 = r515;
            r190 = (MessageStatus) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), r421);
            int r229 = r158 | 32;
            Unit r230 = Unit.INSTANCE;
            r188 = r229;
            goto L64
        L62:
            r102 = r102;
            r147 = r147;
            r148 = r148;
            r149 = r149;
            r152 = r152;
            r190 = r421;
            r422 = r422;
            r423 = r423;
            r424 = r424;
            r425 = r425;
            r427 = r427;
            r428 = r428;
            r513 = r513;
            r514 = r514;
            r515 = r515;
            int r327 = r101.decodeIntElement(r100, 4);
            r188 = r158 | 16;
            Unit r328 = Unit.INSTANCE;
            r323 = r327;
            goto L64
        L63:
            r102 = r102;
            r147 = r147;
            r148 = r148;
            r149 = r149;
            r152 = r152;
            r190 = r421;
            r422 = r422;
            r423 = r423;
            r424 = r424;
            r425 = r425;
            r427 = r427;
            r428 = r428;
            r513 = r513;
            r514 = r514;
            r515 = r515;
            r519 = r101.decodeIntElement(r100, 3);
            r188 = r158 | 8;
            Unit r231 = Unit.INSTANCE;
            goto L64
        L65:
            MessageStatus r232 = r421;
            String r430 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r426);
            Unit r233 = Unit.INSTANCE;
            r223 = r422;
            r158 = r158 | 4;
            r222 = r420;
            String r234 = r430;
        L70:
            r320 = r320;
            r191 = r158;
            r195 = r232;
            r193 = r424;
            ReferenceInfo r616 = r427;
            r194 = r234;
            r192 = r616;
            goto L71
        L67:
            r232 = r421;
            r234 = r426;
            r223 = r422;
            String r235 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r420);
            r158 = r158 | 2;
            Unit r236 = Unit.INSTANCE;
            r222 = r235;
            goto L70
        L68:
            r102 = r102;
            r147 = r147;
            r148 = r148;
            r149 = r149;
            r152 = r152;
            r232 = r421;
            r223 = r422;
            r423 = r423;
            r424 = r424;
            r425 = r425;
            r234 = r426;
            r427 = r427;
            r428 = r428;
            r513 = r513;
            r514 = r514;
            r515 = r515;
            r222 = r420;
            r320 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r320);
            r158 = r158 | 1;
            Unit r237 = Unit.INSTANCE;
            goto L70
        L69:
            r102 = r102;
            r147 = r147;
            r148 = r148;
            r149 = r149;
            r152 = r152;
            r320 = r320;
            r222 = r420;
            r232 = r421;
            r223 = r422;
            r423 = r423;
            r424 = r424;
            r425 = r425;
            r234 = r426;
            r427 = r427;
            r428 = r428;
            r513 = r513;
            r514 = r514;
            r515 = r515;
            Unit r238 = Unit.INSTANCE;
            r612 = false;
            goto L70
        L10:
            throw new UnknownFieldException(r159);
        L73:
            String r1100 = r147;
            String r239 = r149;
            String r617 = r151;
            List r618 = r152;
            String r240 = r320;
            String r329 = r423;
            List r330 = r424;
            String r241 = r425;
            String r242 = r426;
            ReferenceInfo r243 = r427;
            Map r244 = r428;
            String r245 = r513;
            String r246 = r514;
            r412 = r153;
            r512 = r155;
            r416 = r156;
            r510 = r157;
            r316 = r515;
            r417 = r148;
            r414 = r239;
            r141 = r420;
            r214 = r422;
            r144 = r421;
            r219 = r329;
            r142 = r321;
            r419 = r322;
            r318 = r429;
            r311 = r518;
            r143 = r519;
            r140 = r520;
            r413 = r521;
            r211 = r516;
            r313 = r517;
            r418 = r610;
            r415 = r611;
            r312 = r617;
            r139 = r242;
            r136 = r158;
            r319 = r150;
            r215 = r243;
            r217 = r246;
            r314 = r154;
            r511 = r1100;
            r218 = r244;
            r216 = r241;
            r137 = r323;
            r145 = r613;
            r315 = r146;
            r213 = r245;
            r212 = r330;
            r317 = r618;
            r138 = r240;
            goto L74
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            Message r102 = (Message) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346672b;
            muc.d r104 = r100.beginStructure(r103);
            Message.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<Message> serializer() {
            return a.f346671a;
        }
    }

    public Message() {
        this(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return i0.a("com.larus.im.bean.message.MessageStatus", MessageStatus.values(), new String[]{"0", "1", "3", "5", "7", "6", "8", Constants.VIA_SHARE_TYPE_MINI_PROGRAM, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "11"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null});
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        return new nuc.f(Block.a.f346807a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$1() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$2() {
        return new nuc.f(SuggestQuestion.a.f346721a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$3() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$4() {
        return new nuc.f(w0.f520792a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$5() {
        return new nuc.f(kuc.a.d(a.f346671a));
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$6() {
        return new nuc.f(new nuc.f(a.f346671a));
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_$0();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_$4();
    }

    public static /* synthetic */ d c() {
        return _childSerializers$_anonymous_$2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Message copy$default(Message r110, String r111, String r112, String r210, int r211, int r212, MessageStatus r213, int r214, boolean r215, String r216, String r217, List r218, String r219, ReferenceInfo r310, Map r311, String r312, String r313, long r314, long r315, boolean r316, String r317, String r410, List r411, Map r412, Integer r413, String r414, int r415, boolean r416, long r417, String r418, List r510, boolean r511, String r512, Integer r513, long r514, List r515, List r516, String r517, int r518, int r610, Object r611) {
        if ((r518 & 1) == 0) goto L5;
        String r100 = r110.conversationId;
    L7:
        if ((r518 & 2) == 0) goto L9;
        String r101 = r110.threadId;
    L11:
        if ((r518 & 4) == 0) goto L13;
        String r102 = r110.senderId;
    L15:
        if ((r518 & 8) == 0) goto L17;
        int r103 = r110.userType;
    L19:
        if ((r518 & 16) == 0) goto L21;
        int r104 = r110.messageStatusLocal;
    L23:
        if ((r518 & 32) == 0) goto L25;
        MessageStatus r105 = r110.messageStatus;
    L27:
        if ((r518 & 64) == 0) goto L29;
        int r106 = r110.contentType;
    L31:
        if ((r518 & 128) == 0) goto L33;
        boolean r107 = r110.isNewBlockType;
    L35:
        if ((r518 & 256) == 0) goto L37;
        String r113 = r110.brief;
    L39:
        if ((r518 & 512) == 0) goto L41;
        String r114 = r110.content;
    L43:
        if ((r518 & 1024) == 0) goto L45;
        List r115 = r110.contentBlock;
    L47:
        if ((r518 & 2048) == 0) goto L49;
        String r116 = r110.thinkingContent;
    L51:
        if ((r518 & 4096) == 0) goto L53;
        ReferenceInfo r117 = r110.referenceInfo;
    L55:
        if ((r518 & 8192) == 0) goto L57;
        Map r118 = r110.ext;
    L58:
        Map r318 = r118;
        if ((r518 & 16384) == 0) goto L61;
        String r119 = r110.localMessageId;
    L62:
        String r319 = r119;
        if ((r518 & 32768) == 0) goto L65;
        String r120 = r110.messageId;
    L66:
        ReferenceInfo r320 = r117;
        String r321 = r120;
        if ((r518 & 65536) == 0) goto L69;
        long r121 = r110.localIndex;
    L70:
        long r322 = r121;
        if ((r518 & 131072) == 0) goto L73;
        long r122 = r110.serverIndex;
    L74:
        long r323 = r122;
        if ((r518 & 262144) == 0) goto L77;
        boolean r123 = r110.sourceFromAsr;
    L79:
        if ((524288 & r518) == 0) goto L81;
        String r124 = r110.sectionId;
    L82:
        String r324 = r124;
        if ((r518 & 1048576) == 0) goto L85;
        String r125 = r110.sectionName;
    L86:
        String r419 = r125;
        if ((r518 & 2097152) == 0) goto L89;
        List r126 = r110.suggestQuestions;
    L90:
        List r420 = r126;
        if ((r518 & 4194304) == 0) goto L93;
        Map r127 = r110.businessExt;
    L94:
        Map r421 = r127;
        if ((r518 & 8388608) == 0) goto L97;
        Integer r128 = r110.feedback;
    L98:
        Integer r422 = r128;
        if ((r518 & 16777216) == 0) goto L101;
        String r129 = r110.regenRootId;
    L102:
        String r423 = r129;
        if ((r518 & 33554432) == 0) goto L105;
        int r130 = r110.regenStatus;
    L106:
        int r424 = r130;
        if ((r518 & 67108864) == 0) goto L109;
        boolean r131 = r110.regenVisible;
    L110:
        boolean r325 = r123;
        boolean r425 = r131;
        if ((r518 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        long r132 = r110.regenIndex;
    L114:
        long r426 = r132;
        if ((r518 & 268435456) == 0) goto L117;
        String r133 = r110.replyId;
    L119:
        if ((536870912 & r518) == 0) goto L121;
        List r134 = r110.tags;
    L122:
        List r519 = r134;
        if ((r518 & 1073741824) == 0) goto L125;
        boolean r135 = r110.msgLoading;
    L127:
        if ((r518 & Integer.MIN_VALUE) == 0) goto L129;
        String r108 = r110.bizContentType;
    L130:
        String r520 = r108;
        if ((r610 & 1) == 0) goto L133;
        Integer r109 = r110.isConnectCallerName;
    L134:
        String r427 = r133;
        boolean r521 = r135;
        if ((r610 & 2) == 0) goto L137;
        long r136 = r110.createTime;
    L138:
        long r522 = r136;
        if ((r610 & 4) == 0) goto L141;
        List r137 = r110.subList;
    L143:
        if ((r610 & 8) == 0) goto L145;
        List r138 = r110.subListGroup;
    L146:
        List r523 = r138;
        if ((r610 & 16) == 0) goto L149;
        String r139 = r110.collectionIdCompat;
    L151:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r320, r318, r319, r321, r322, r323, r325, r324, r419, r420, r421, r422, r423, r424, r425, r426, r427, r519, r521, r520, r109, r522, r137, r523, r139);
    L149:
        r139 = r517;
        goto L151
    L145:
        r138 = r516;
        goto L146
    L141:
        r137 = r515;
        goto L143
    L137:
        r136 = r514;
        goto L138
    L133:
        r109 = r513;
        goto L134
    L129:
        r108 = r512;
        goto L130
    L125:
        r135 = r511;
        goto L127
    L121:
        r134 = r510;
        goto L122
    L117:
        r133 = r418;
        goto L119
    L113:
        r132 = r417;
        goto L114
    L109:
        r131 = r416;
        goto L110
    L105:
        r130 = r415;
        goto L106
    L101:
        r129 = r414;
        goto L102
    L97:
        r128 = r413;
        goto L98
    L93:
        r127 = r412;
        goto L94
    L89:
        r126 = r411;
        goto L90
    L85:
        r125 = r410;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L79
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

    public static /* synthetic */ d d() {
        return _childSerializers$_anonymous_$1();
    }

    public static /* synthetic */ d e() {
        return _childSerializers$_anonymous_$5();
    }

    public static /* synthetic */ d f() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d g() {
        return _childSerializers$_anonymous_$6();
    }

    @SerialName("biz_content_type")
    public static /* synthetic */ void getBizContentType$annotations() {
    }

    @SerialName(SelectInfo.BRIEF)
    public static /* synthetic */ void getBrief$annotations() {
    }

    @SerialName("business_ext")
    public static /* synthetic */ void getBusinessExt$annotations() {
    }

    @SerialName("collection_id")
    public static /* synthetic */ void getCollectionIdCompat$annotations() {
    }

    @SerialName("content")
    public static /* synthetic */ void getContent$annotations() {
    }

    @SerialName("content_block")
    public static /* synthetic */ void getContentBlock$annotations() {
    }

    @SerialName("content_type")
    public static /* synthetic */ void getContentType$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("create_time")
    public static /* synthetic */ void getCreateTime$annotations() {
    }

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName("feedback")
    public static /* synthetic */ void getFeedback$annotations() {
    }

    @SerialName("local_index")
    public static /* synthetic */ void getLocalIndex$annotations() {
    }

    @SerialName("local_message_id")
    public static /* synthetic */ void getLocalMessageId$annotations() {
    }

    @SerialName(MusicAppletPage.KEY_MESSAGE_ID)
    public static /* synthetic */ void getMessageId$annotations() {
    }

    @SerialName("message_status")
    public static /* synthetic */ void getMessageStatus$annotations() {
    }

    @SerialName("message_status_local")
    public static /* synthetic */ void getMessageStatusLocal$annotations() {
    }

    @SerialName("msg_loading")
    public static /* synthetic */ void getMsgLoading$annotations() {
    }

    @SerialName("reference_info")
    public static /* synthetic */ void getReferenceInfo$annotations() {
    }

    @SerialName("regen_index")
    public static /* synthetic */ void getRegenIndex$annotations() {
    }

    @SerialName("regen_root_id")
    public static /* synthetic */ void getRegenRootId$annotations() {
    }

    @SerialName("regen_status")
    public static /* synthetic */ void getRegenStatus$annotations() {
    }

    @SerialName("regen_visible")
    public static /* synthetic */ void getRegenVisible$annotations() {
    }

    @SerialName(NoticeInfo.KEY_REPLY_ID)
    public static /* synthetic */ void getReplyId$annotations() {
    }

    @SerialName("section_id")
    public static /* synthetic */ void getSectionId$annotations() {
    }

    @SerialName("section_name")
    public static /* synthetic */ void getSectionName$annotations() {
    }

    @SerialName("sender_id")
    public static /* synthetic */ void getSenderId$annotations() {
    }

    @SerialName("server_index")
    public static /* synthetic */ void getServerIndex$annotations() {
    }

    @SerialName("source_from_asr")
    public static /* synthetic */ void getSourceFromAsr$annotations() {
    }

    @SerialName("sub_list")
    public static /* synthetic */ void getSubList$annotations() {
    }

    @SerialName("sub_list_group")
    public static /* synthetic */ void getSubListGroup$annotations() {
    }

    @SerialName("suggest_question")
    public static /* synthetic */ void getSuggestQuestions$annotations() {
    }

    @SerialName(PromotionProductPrivilegesStruct.TAGS)
    public static /* synthetic */ void getTags$annotations() {
    }

    @SerialName("thinking_content")
    public static /* synthetic */ void getThinkingContent$annotations() {
    }

    @SerialName(CrashHianalyticsData.THREAD_ID)
    public static /* synthetic */ void getThreadId$annotations() {
    }

    @SerialName("user_type")
    public static /* synthetic */ void getUserType$annotations() {
    }

    public static /* synthetic */ d h() {
        return _childSerializers$_anonymous_$3();
    }

    @SerialName("is_connect_caller_name")
    public static /* synthetic */ void isConnectCallerName$annotations() {
    }

    @SerialName("is_new_block_type")
    public static /* synthetic */ void isNewBlockType$annotations() {
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component10() {
        return this.content;
    }

    public final List<Block> component11() {
        return this.contentBlock;
    }

    public final String component12() {
        return this.thinkingContent;
    }

    public final ReferenceInfo component13() {
        return this.referenceInfo;
    }

    public final Map<String, String> component14() {
        return this.ext;
    }

    public final String component15() {
        return this.localMessageId;
    }

    public final String component16() {
        return this.messageId;
    }

    public final long component17() {
        return this.localIndex;
    }

    public final long component18() {
        return this.serverIndex;
    }

    public final boolean component19() {
        return this.sourceFromAsr;
    }

    public final String component2() {
        return this.threadId;
    }

    public final String component20() {
        return this.sectionId;
    }

    public final String component21() {
        return this.sectionName;
    }

    public final List<SuggestQuestion> component22() {
        return this.suggestQuestions;
    }

    public final Map<String, String> component23() {
        return this.businessExt;
    }

    public final Integer component24() {
        return this.feedback;
    }

    public final String component25() {
        return this.regenRootId;
    }

    public final int component26() {
        return this.regenStatus;
    }

    public final boolean component27() {
        return this.regenVisible;
    }

    public final long component28() {
        return this.regenIndex;
    }

    public final String component29() {
        return this.replyId;
    }

    public final String component3() {
        return this.senderId;
    }

    public final List<Integer> component30() {
        return this.tags;
    }

    public final boolean component31() {
        return this.msgLoading;
    }

    public final String component32() {
        return this.bizContentType;
    }

    public final Integer component33() {
        return this.isConnectCallerName;
    }

    public final long component34() {
        return this.createTime;
    }

    public final List<Message> component35() {
        return this.subList;
    }

    public final List<List<Message>> component36() {
        return this.subListGroup;
    }

    public final String component37() {
        return this.collectionIdCompat;
    }

    public final int component4() {
        return this.userType;
    }

    public final int component5() {
        return this.messageStatusLocal;
    }

    public final MessageStatus component6() {
        return this.messageStatus;
    }

    public final int component7() {
        return this.contentType;
    }

    public final boolean component8() {
        return this.isNewBlockType;
    }

    public final String component9() {
        return this.brief;
    }

    public final Message copy(String r410, String r411, String r412, @com.larus.im.bean.conversation.UserType int r413, @MessageStatusLocal int r414, MessageStatus r415, @MessageContentType int r510, boolean r511, String r512, String r513, List<Block> r514, String r515, ReferenceInfo r516, Map<String, String> r517, String r518, String r519, long r610, long r611, boolean r612, String r613, String r614, List<SuggestQuestion> r615, Map<String, String> r616, Integer r617, String r710, @RegenStatus int r711, boolean r712, long r713, String r714, List<Integer> r715, boolean r716, String r717, Integer r718, long r810, List<Message> r811, List<? extends List<Message>> r812, String r813) {
        return new Message(r410, r411, r412, r413, r414, r415, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r710, r711, r712, r713, r714, r715, r716, r717, r718, r810, r811, r812, r813);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Message) == true) goto L8;
        return false;
    L8:
        Message r101 = (Message) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.threadId, r101.threadId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.senderId, r101.senderId) == true) goto L18;
        return false;
    L18:
        if (this.userType == r101.userType) goto L21;
        return false;
    L21:
        if (this.messageStatusLocal == r101.messageStatusLocal) goto L24;
        return false;
    L24:
        if (this.messageStatus == r101.messageStatus) goto L27;
        return false;
    L27:
        if (this.contentType == r101.contentType) goto L30;
        return false;
    L30:
        if (this.isNewBlockType == r101.isNewBlockType) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.brief, r101.brief) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.contentBlock, r101.contentBlock) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.thinkingContent, r101.thinkingContent) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.referenceInfo, r101.referenceInfo) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.localMessageId, r101.localMessageId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L57;
        return false;
    L57:
        if (this.localIndex == r101.localIndex) goto L60;
        return false;
    L60:
        if (this.serverIndex == r101.serverIndex) goto L63;
        return false;
    L63:
        if (this.sourceFromAsr == r101.sourceFromAsr) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.sectionId, r101.sectionId) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.sectionName, r101.sectionName) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.suggestQuestions, r101.suggestQuestions) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.businessExt, r101.businessExt) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.feedback, r101.feedback) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.regenRootId, r101.regenRootId) == true) goto L84;
        return false;
    L84:
        if (this.regenStatus == r101.regenStatus) goto L87;
        return false;
    L87:
        if (this.regenVisible == r101.regenVisible) goto L90;
        return false;
    L90:
        if (this.regenIndex == r101.regenIndex) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.replyId, r101.replyId) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L99;
        return false;
    L99:
        if (this.msgLoading == r101.msgLoading) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.bizContentType, r101.bizContentType) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.isConnectCallerName, r101.isConnectCallerName) == true) goto L108;
        return false;
    L108:
        if (this.createTime == r101.createTime) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.subList, r101.subList) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.subListGroup, r101.subListGroup) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.collectionIdCompat, r101.collectionIdCompat) == true) goto L119;
        return false;
    L119:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.threadId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.senderId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((r106 + r108) * 31) + this.userType) * 31) + this.messageStatusLocal) * 31;
        MessageStatus r110 = this.messageStatus;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.contentType) * 31;
        int r113 = 1231;
        if (this.isNewBlockType == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.brief;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.content;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<Block> r122 = this.contentBlock;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.thinkingContent;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        ReferenceInfo r128 = this.referenceInfo;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Map<String, String> r131 = this.ext;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.localMessageId;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.messageId;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        long r139 = this.localIndex;
        int r140 = (((r136 + r138) * 31) + ((int) (r139 ^ (r139 >>> 32)))) * 31;
        long r141 = this.serverIndex;
        int r142 = (r140 + ((int) (r141 ^ (r141 >>> 32)))) * 31;
        if (this.sourceFromAsr == false) goto L57;
        int r143 = 1231;
    L58:
        int r144 = (r142 + r143) * 31;
        String r145 = this.sectionId;
        if (r145 != null) goto L61;
        int r146 = 0;
    L62:
        int r147 = (r144 + r146) * 31;
        String r148 = this.sectionName;
        if (r148 != null) goto L65;
        int r149 = 0;
    L66:
        int r150 = (r147 + r149) * 31;
        List<SuggestQuestion> r151 = this.suggestQuestions;
        if (r151 != null) goto L69;
        int r152 = 0;
    L70:
        int r153 = (r150 + r152) * 31;
        Map<String, String> r154 = this.businessExt;
        if (r154 != null) goto L73;
        int r155 = 0;
    L74:
        int r156 = (r153 + r155) * 31;
        Integer r157 = this.feedback;
        if (r157 != null) goto L77;
        int r158 = 0;
    L78:
        int r159 = (r156 + r158) * 31;
        String r160 = this.regenRootId;
        if (r160 != null) goto L81;
        int r161 = 0;
    L82:
        int r162 = (((r159 + r161) * 31) + this.regenStatus) * 31;
        if (this.regenVisible == false) goto L85;
        int r163 = 1231;
    L86:
        int r164 = (r162 + r163) * 31;
        long r165 = this.regenIndex;
        int r166 = (r164 + ((int) (r165 ^ (r165 >>> 32)))) * 31;
        String r167 = this.replyId;
        if (r167 != null) goto L89;
        int r168 = 0;
    L90:
        int r169 = (r166 + r168) * 31;
        List<Integer> r170 = this.tags;
        if (r170 != null) goto L93;
        int r171 = 0;
    L94:
        int r172 = (r169 + r171) * 31;
        if (this.msgLoading == true) goto L98;
        r113 = 1237;
    L98:
        int r173 = (r172 + r113) * 31;
        String r174 = this.bizContentType;
        if (r174 != null) goto L101;
        int r175 = 0;
    L102:
        int r176 = (r173 + r175) * 31;
        Integer r177 = this.isConnectCallerName;
        if (r177 != null) goto L105;
        int r178 = 0;
    L106:
        int r179 = (r176 + r178) * 31;
        long r180 = this.createTime;
        int r181 = (r179 + ((int) (r180 ^ (r180 >>> 32)))) * 31;
        List<Message> r182 = this.subList;
        if (r182 != null) goto L109;
        int r183 = 0;
    L110:
        int r184 = (r181 + r183) * 31;
        List<List<Message>> r185 = this.subListGroup;
        if (r185 != null) goto L113;
        int r186 = 0;
    L114:
        int r187 = (r184 + r186) * 31;
        String r188 = this.collectionIdCompat;
        if (r188 == null) goto L119;
        r101 = r188.hashCode();
    L119:
        return r187 + r101;
    L113:
        r186 = r185.hashCode();
        goto L114
    L109:
        r183 = r182.hashCode();
        goto L110
    L105:
        r178 = r177.hashCode();
        goto L106
    L101:
        r175 = r174.hashCode();
        goto L102
    L93:
        r171 = r170.hashCode();
        goto L94
    L89:
        r168 = r167.hashCode();
        goto L90
    L85:
        r163 = 1237;
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
        r143 = 1237;
        goto L58
    L53:
        r138 = r137.hashCode();
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
        r114 = 1237;
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
        $childSerializers = new Lazy[]{null, null, null, null, null, LazyKt.lazy(r100, new u()), null, null, null, null, LazyKt.lazy(r100, new v()), null, null, LazyKt.lazy(r100, new w()), null, null, null, null, null, null, null, LazyKt.lazy(r100, new x()), LazyKt.lazy(r100, new y()), null, null, null, null, null, null, LazyKt.lazy(r100, new z()), null, null, null, null, LazyKt.lazy(r100, new a0()), LazyKt.lazy(r100, new b0()), null};
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("cvsId: ");
        r100.append(this.conversationId);
        r100.append(" ; threadId: ");
        r100.append(this.threadId);
        r100.append("; sender: ");
        r100.append(this.senderId);
        r100.append("; statusLocal: ");
        r100.append(this.messageStatusLocal);
        r100.append("; status: ");
        r100.append(StringsKt.replace$default(String.valueOf(this.messageStatus), "MessageStatus_", "", false, 4, null));
        r100.append("; localMsg: ");
        r100.append(this.localMessageId);
        r100.append("; local: ");
        r100.append(this.localIndex);
        r100.append(";  server: ");
        r100.append(this.serverIndex);
        r100.append("; secId: ");
        r100.append(this.sectionId);
        r100.append("; sectionName: ");
        r100.append(this.sectionName);
        r100.append("; replyId: ");
        r100.append(this.replyId);
        r100.append("; content: eraseIMContent; contentType: ");
        r100.append(this.contentType);
        r100.append("; msgId: ");
        r100.append(this.messageId);
        r100.append("; createTime: ");
        r100.append(this.createTime);
        r100.append("; groupId: ");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Map<String, String> r101 = getExt();
        if (r101 == null) goto L9;
        String r102 = r101.get("group");
        if (r102 == null) goto L9;
        Long r103 = StringsKt.toLongOrNull(r102);
        if (r103 == null) goto L9;
        long r104 = r103.longValue();
    L10:
        r100.append(r104);
        r100.append(';');
        return r100.toString();
    L9:
        r104 = 0;
        goto L10
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final String getBizContentType() {
        return this.bizContentType;
    }

    public final String getBrief() {
        return this.brief;
    }

    public final Map<String, String> getBusinessExt() {
        return this.businessExt;
    }

    public final String getCollectionIdCompat() {
        return this.collectionIdCompat;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<Block> getContentBlock() {
        return this.contentBlock;
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

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final Integer getFeedback() {
        return this.feedback;
    }

    public final long getLocalIndex() {
        return this.localIndex;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final MessageStatus getMessageStatus() {
        return this.messageStatus;
    }

    public final int getMessageStatusLocal() {
        return this.messageStatusLocal;
    }

    public final boolean getMsgLoading() {
        return this.msgLoading;
    }

    public final ReferenceInfo getReferenceInfo() {
        return this.referenceInfo;
    }

    public final long getRegenIndex() {
        return this.regenIndex;
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

    public final long getServerIndex() {
        return this.serverIndex;
    }

    public final boolean getSourceFromAsr() {
        return this.sourceFromAsr;
    }

    public final List<Message> getSubList() {
        return this.subList;
    }

    public final List<List<Message>> getSubListGroup() {
        return this.subListGroup;
    }

    public final List<SuggestQuestion> getSuggestQuestions() {
        return this.suggestQuestions;
    }

    public final List<Integer> getTags() {
        return this.tags;
    }

    public final String getThinkingContent() {
        return this.thinkingContent;
    }

    public final String getThreadId() {
        return this.threadId;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final Integer isConnectCallerName() {
        return this.isConnectCallerName;
    }

    public final boolean isNewBlockType() {
        return this.isNewBlockType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(Message r100, muc.d r101, f r110) {
        Lazy<d<Object>>[] r102 = $childSerializers;
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.conversationId);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r110, 1, v2.f520790a, r100.threadId);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r110, 2, v2.f520790a, r100.senderId);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeIntElement(r110, 3, r100.userType);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeIntElement(r110, 4, r100.messageStatusLocal);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r110, 5, r102[5].getValue(), r100.messageStatus);
    L57:
        if (r101.shouldEncodeElementDefault(r110, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeIntElement(r110, 6, r100.contentType);
    L66:
        if (r101.shouldEncodeElementDefault(r110, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeBooleanElement(r110, 7, r100.isNewBlockType);
    L75:
        if (r101.shouldEncodeElementDefault(r110, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeNullableSerializableElement(r110, 8, v2.f520790a, r100.brief);
    L84:
        if (r101.shouldEncodeElementDefault(r110, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeNullableSerializableElement(r110, 9, v2.f520790a, r100.content);
    L93:
        if (r101.shouldEncodeElementDefault(r110, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r101.encodeNullableSerializableElement(r110, 10, r102[10].getValue(), r100.contentBlock);
    L102:
        if (r101.shouldEncodeElementDefault(r110, 11) == false) goto L105;
    L103:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r101.encodeNullableSerializableElement(r110, 11, v2.f520790a, r100.thinkingContent);
    L111:
        if (r101.shouldEncodeElementDefault(r110, 12) == false) goto L114;
    L112:
        boolean r117 = true;
    L117:
        if (r117 == false) goto L120;
        r101.encodeNullableSerializableElement(r110, 12, ReferenceInfo.a.f346698a, r100.referenceInfo);
    L120:
        if (r101.shouldEncodeElementDefault(r110, 13) == false) goto L123;
    L121:
        boolean r118 = true;
    L126:
        if (r118 == false) goto L129;
        r101.encodeNullableSerializableElement(r110, 13, r102[13].getValue(), r100.ext);
    L129:
        if (r101.shouldEncodeElementDefault(r110, 14) == false) goto L132;
    L130:
        boolean r119 = true;
    L135:
        if (r119 == false) goto L138;
        r101.encodeNullableSerializableElement(r110, 14, v2.f520790a, r100.localMessageId);
    L138:
        if (r101.shouldEncodeElementDefault(r110, 15) == false) goto L141;
    L139:
        boolean r120 = true;
    L144:
        if (r120 == false) goto L147;
        r101.encodeNullableSerializableElement(r110, 15, v2.f520790a, r100.messageId);
    L147:
        if (r101.shouldEncodeElementDefault(r110, 16) == false) goto L150;
    L148:
        boolean r121 = true;
    L153:
        if (r121 == false) goto L156;
        r101.encodeLongElement(r110, 16, r100.localIndex);
    L156:
        if (r101.shouldEncodeElementDefault(r110, 17) == false) goto L159;
    L157:
        boolean r122 = true;
    L162:
        if (r122 == false) goto L165;
        r101.encodeLongElement(r110, 17, r100.serverIndex);
    L165:
        if (r101.shouldEncodeElementDefault(r110, 18) == false) goto L168;
    L166:
        boolean r123 = true;
    L171:
        if (r123 == false) goto L174;
        r101.encodeBooleanElement(r110, 18, r100.sourceFromAsr);
    L174:
        if (r101.shouldEncodeElementDefault(r110, 19) == false) goto L177;
    L175:
        boolean r124 = true;
    L180:
        if (r124 == false) goto L183;
        r101.encodeNullableSerializableElement(r110, 19, v2.f520790a, r100.sectionId);
    L183:
        if (r101.shouldEncodeElementDefault(r110, 20) == false) goto L186;
    L184:
        boolean r125 = true;
    L189:
        if (r125 == false) goto L192;
        r101.encodeNullableSerializableElement(r110, 20, v2.f520790a, r100.sectionName);
    L192:
        if (r101.shouldEncodeElementDefault(r110, 21) == false) goto L195;
    L193:
        boolean r126 = true;
    L198:
        if (r126 == false) goto L201;
        r101.encodeNullableSerializableElement(r110, 21, r102[21].getValue(), r100.suggestQuestions);
    L201:
        if (r101.shouldEncodeElementDefault(r110, 22) == false) goto L204;
    L202:
        boolean r127 = true;
    L207:
        if (r127 == false) goto L210;
        r101.encodeNullableSerializableElement(r110, 22, r102[22].getValue(), r100.businessExt);
    L210:
        if (r101.shouldEncodeElementDefault(r110, 23) == false) goto L213;
    L211:
        boolean r128 = true;
    L216:
        if (r128 == false) goto L219;
        r101.encodeNullableSerializableElement(r110, 23, w0.f520792a, r100.feedback);
    L219:
        if (r101.shouldEncodeElementDefault(r110, 24) == false) goto L222;
    L220:
        boolean r129 = true;
    L225:
        if (r129 == false) goto L228;
        r101.encodeNullableSerializableElement(r110, 24, v2.f520790a, r100.regenRootId);
    L228:
        if (r101.shouldEncodeElementDefault(r110, 25) == false) goto L231;
    L229:
        boolean r130 = true;
    L234:
        if (r130 == false) goto L237;
        r101.encodeIntElement(r110, 25, r100.regenStatus);
    L237:
        if (r101.shouldEncodeElementDefault(r110, 26) == false) goto L240;
    L238:
        boolean r131 = true;
    L243:
        if (r131 == false) goto L246;
        r101.encodeBooleanElement(r110, 26, r100.regenVisible);
    L246:
        if (r101.shouldEncodeElementDefault(r110, 27) == false) goto L249;
    L247:
        boolean r132 = true;
    L252:
        if (r132 == false) goto L255;
        r101.encodeLongElement(r110, 27, r100.regenIndex);
    L255:
        if (r101.shouldEncodeElementDefault(r110, 28) == false) goto L258;
    L256:
        boolean r133 = true;
    L261:
        if (r133 == false) goto L264;
        r101.encodeNullableSerializableElement(r110, 28, v2.f520790a, r100.replyId);
    L264:
        if (r101.shouldEncodeElementDefault(r110, 29) == false) goto L267;
    L265:
        boolean r134 = true;
    L270:
        if (r134 == false) goto L273;
        r101.encodeNullableSerializableElement(r110, 29, r102[29].getValue(), r100.tags);
    L273:
        if (r101.shouldEncodeElementDefault(r110, 30) == false) goto L276;
    L274:
        boolean r135 = true;
    L279:
        if (r135 == false) goto L282;
        r101.encodeBooleanElement(r110, 30, r100.msgLoading);
    L282:
        if (r101.shouldEncodeElementDefault(r110, 31) == false) goto L285;
    L283:
        boolean r136 = true;
    L288:
        if (r136 == false) goto L291;
        r101.encodeNullableSerializableElement(r110, 31, v2.f520790a, r100.bizContentType);
    L291:
        if (r101.shouldEncodeElementDefault(r110, 32) == false) goto L293;
    L292:
        boolean r137 = true;
    L300:
        if (r137 == false) goto L303;
        r101.encodeNullableSerializableElement(r110, 32, w0.f520792a, r100.isConnectCallerName);
    L303:
        if (r101.shouldEncodeElementDefault(r110, 33) == false) goto L306;
    L304:
        boolean r138 = true;
    L309:
        if (r138 == false) goto L312;
        r101.encodeLongElement(r110, 33, r100.createTime);
    L312:
        if (r101.shouldEncodeElementDefault(r110, 34) == false) goto L315;
    L313:
        boolean r139 = true;
    L318:
        if (r139 == false) goto L321;
        r101.encodeNullableSerializableElement(r110, 34, r102[34].getValue(), r100.subList);
    L321:
        if (r101.shouldEncodeElementDefault(r110, 35) == false) goto L324;
    L322:
        boolean r140 = true;
    L327:
        if (r140 == false) goto L330;
        r101.encodeNullableSerializableElement(r110, 35, r102[35].getValue(), r100.subListGroup);
    L330:
        if (r101.shouldEncodeElementDefault(r110, 36) == false) goto L333;
    L331:
        r103 = true;
    L335:
        if (r103 == false) goto L338;
        r101.encodeNullableSerializableElement(r110, 36, v2.f520790a, r100.collectionIdCompat);
        return;
    L338:
        return;
    L333:
        if (r100.collectionIdCompat == null) goto L335;
    L324:
        if (r100.subListGroup != null) goto L322;
        r140 = false;
        goto L327
    L315:
        if (r100.subList != null) goto L313;
        r139 = false;
        goto L318
    L306:
        if (r100.createTime != 0) goto L304;
        r138 = false;
        goto L309
    L293:
        Integer r141 = r100.isConnectCallerName;
        if (r141 == null) goto L292;
        if (r141.intValue() != 0) goto L292;
        r137 = false;
        goto L300
    L285:
        if (r100.bizContentType != null) goto L283;
        r136 = false;
        goto L288
    L276:
        if (r100.msgLoading == true) goto L274;
        r135 = false;
        goto L279
    L267:
        if (r100.tags != null) goto L265;
        r134 = false;
        goto L270
    L258:
        if (r100.replyId != null) goto L256;
        r133 = false;
        goto L261
    L249:
        if (r100.regenIndex != 0) goto L247;
        r132 = false;
        goto L252
    L240:
        if (r100.regenVisible != true) goto L238;
        r131 = false;
        goto L243
    L231:
        if (r100.regenStatus != 0) goto L229;
        r130 = false;
        goto L234
    L222:
        if (r100.regenRootId != null) goto L220;
        r129 = false;
        goto L225
    L213:
        if (r100.feedback != null) goto L211;
        r128 = false;
        goto L216
    L204:
        if (Intrinsics.areEqual(r100.businessExt, new LinkedHashMap()) == false) goto L202;
        r127 = false;
        goto L207
    L195:
        if (r100.suggestQuestions != null) goto L193;
        r126 = false;
        goto L198
    L186:
        if (r100.sectionName != null) goto L184;
        r125 = false;
        goto L189
    L177:
        if (r100.sectionId != null) goto L175;
        r124 = false;
        goto L180
    L168:
        if (r100.sourceFromAsr == true) goto L166;
        r123 = false;
        goto L171
    L159:
        if (r100.serverIndex != (-1)) goto L157;
        r122 = false;
        goto L162
    L150:
        if (r100.localIndex != (-1)) goto L148;
        r121 = false;
        goto L153
    L141:
        if (Intrinsics.areEqual(r100.messageId, "") == false) goto L139;
        r120 = false;
        goto L144
    L132:
        if (Intrinsics.areEqual(r100.localMessageId, "") == false) goto L130;
        r119 = false;
        goto L135
    L123:
        if (r100.ext != null) goto L121;
        r118 = false;
        goto L126
    L114:
        if (r100.referenceInfo != null) goto L112;
        r117 = false;
        goto L117
    L105:
        if (r100.thinkingContent != null) goto L103;
        r116 = false;
        goto L108
    L96:
        if (r100.contentBlock != null) goto L94;
        r115 = false;
        goto L99
    L87:
        if (r100.content != null) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.brief != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.isNewBlockType == true) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.contentType != 1) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.messageStatus != MessageStatus.MessageStatus_AVAILABLE) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.messageStatusLocal != 10) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.userType != 0) goto L31;
        r107 = false;
        goto L36
    L24:
        if (Intrinsics.areEqual(r100.senderId, "") == false) goto L22;
        r106 = false;
        goto L27
    L15:
        if (Intrinsics.areEqual(r100.threadId, "") == false) goto L13;
        r105 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r100.conversationId, "") == false) goto L4;
        r104 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Message(String r100, String r101, String r102, @com.larus.im.bean.conversation.UserType int r103, @MessageStatusLocal int r104, MessageStatus r105, @MessageContentType int r110, boolean r111, String r112, String r113, List<Block> r114, String r115, ReferenceInfo r116, Map<String, String> r117, String r118, String r119, long r210, long r211, boolean r212, String r213, String r214, List<SuggestQuestion> r215, Map<String, String> r216, Integer r217, String r310, @RegenStatus int r311, boolean r312, long r313, String r314, List<Integer> r315, boolean r316, String r317, Integer r318, long r410, List<Message> r411, List<? extends List<Message>> r412, String r413) {
        this.conversationId = r100;
        this.threadId = r101;
        this.senderId = r102;
        this.userType = r103;
        this.messageStatusLocal = r104;
        this.messageStatus = r105;
        this.contentType = r110;
        this.isNewBlockType = r111;
        this.brief = r112;
        this.content = r113;
        this.contentBlock = r114;
        this.thinkingContent = r115;
        this.referenceInfo = r116;
        this.ext = r117;
        this.localMessageId = r118;
        this.messageId = r119;
        this.localIndex = r210;
        this.serverIndex = r211;
        this.sourceFromAsr = r212;
        this.sectionId = r213;
        this.sectionName = r214;
        this.suggestQuestions = r215;
        this.businessExt = r216;
        this.feedback = r217;
        this.regenRootId = r310;
        this.regenStatus = r311;
        this.regenVisible = r312;
        this.regenIndex = r313;
        this.replyId = r314;
        this.tags = r315;
        this.msgLoading = r316;
        this.bizContentType = r317;
        this.isConnectCallerName = r318;
        this.createTime = r410;
        this.subList = r411;
        this.subListGroup = r412;
        this.collectionIdCompat = r413;
    }

    public Message(int r110, int r111, String r112, String r113, String r114, int r115, int r116, MessageStatus r117, int r118, boolean r210, String r211, String r212, List r213, String r214, ReferenceInfo r215, Map r216, String r217, String r218, long r219, long r310, boolean r311, String r312, String r313, List r314, Map r315, Integer r316, String r317, int r410, boolean r411, long r412, String r413, List r414, boolean r415, String r416, Integer r417, long r418, List r510, List r511, String r512, q2 r513) {
        if ((r110 & 0) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r111 & 0) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r100 | r101) == false) goto L13;
        b2.a(new int[]{r110, r111}, new int[]{0, 0}, a.f346672b);
        throw null;
    L13:
        if ((r110 & 1) != 0) goto L15;
        this.conversationId = "";
    L17:
        if ((r110 & 2) != 0) goto L19;
        this.threadId = "";
    L21:
        if ((r110 & 4) != 0) goto L23;
        this.senderId = "";
    L25:
        if ((r110 & 8) != 0) goto L27;
        this.userType = 0;
    L29:
        if ((r110 & 16) != 0) goto L31;
        int r102 = 10;
    L32:
        this.messageStatusLocal = r102;
        if ((r110 & 32) != 0) goto L35;
        MessageStatus r103 = MessageStatus.MessageStatus_AVAILABLE;
    L36:
        this.messageStatus = r103;
        if ((r110 & 64) != 0) goto L39;
        this.contentType = 1;
    L41:
        if ((r110 & 128) != 0) goto L43;
        this.isNewBlockType = false;
    L45:
        if ((r110 & 256) != 0) goto L47;
        this.brief = null;
    L49:
        if ((r110 & 512) != 0) goto L51;
        this.content = null;
    L53:
        if ((r110 & 1024) != 0) goto L55;
        this.contentBlock = null;
    L57:
        if ((r110 & 2048) != 0) goto L59;
        this.thinkingContent = null;
    L61:
        if ((r110 & 4096) != 0) goto L63;
        this.referenceInfo = null;
    L65:
        if ((r110 & 8192) != 0) goto L67;
        this.ext = null;
    L69:
        if ((r110 & 16384) != 0) goto L71;
        this.localMessageId = "";
    L73:
        if ((32768 & r110) != 0) goto L75;
        this.messageId = "";
    L76:
        long r104 = -1;
        if ((65536 & r110) != 0) goto L79;
        this.localIndex = -1;
    L81:
        if ((131072 & r110) == 0) goto L84;
        r104 = r310;
    L84:
        this.serverIndex = r104;
        if ((262144 & r110) != 0) goto L87;
        this.sourceFromAsr = false;
    L89:
        if ((524288 & r110) != 0) goto L91;
        this.sectionId = null;
    L93:
        if ((1048576 & r110) != 0) goto L95;
        this.sectionName = null;
    L97:
        if ((2097152 & r110) != 0) goto L99;
        this.suggestQuestions = null;
    L101:
        if ((4194304 & r110) != 0) goto L103;
        Map r105 = new LinkedHashMap();
    L104:
        this.businessExt = r105;
        if ((8388608 & r110) != 0) goto L107;
        this.feedback = null;
    L109:
        if ((16777216 & r110) != 0) goto L111;
        this.regenRootId = null;
    L113:
        if ((33554432 & r110) != 0) goto L115;
        this.regenStatus = 0;
    L117:
        if ((67108864 & r110) != 0) goto L119;
        this.regenVisible = true;
    L121:
        if ((134217728 & r110) != 0) goto L123;
        this.regenIndex = 0;
    L125:
        if ((268435456 & r110) != 0) goto L127;
        this.replyId = null;
    L129:
        if ((536870912 & r110) != 0) goto L131;
        this.tags = null;
    L133:
        if ((1073741824 & r110) != 0) goto L135;
        this.msgLoading = false;
    L137:
        if ((r110 & Integer.MIN_VALUE) != 0) goto L139;
        this.bizContentType = null;
    L141:
        if ((r111 & 1) != 0) goto L143;
        Integer r106 = 0;
    L144:
        this.isConnectCallerName = r106;
        if ((r111 & 2) != 0) goto L147;
        this.createTime = 0;
    L149:
        if ((r111 & 4) != 0) goto L151;
        this.subList = null;
    L153:
        if ((r111 & 8) != 0) goto L155;
        this.subListGroup = null;
    L157:
        if ((r111 & 16) != 0) goto L159;
        this.collectionIdCompat = null;
        return;
    L159:
        this.collectionIdCompat = r512;
        return;
    L155:
        this.subListGroup = r511;
        goto L157
    L151:
        this.subList = r510;
        goto L153
    L147:
        this.createTime = r418;
        goto L149
    L143:
        r106 = r417;
        goto L144
    L139:
        this.bizContentType = r416;
        goto L141
    L135:
        this.msgLoading = r415;
        goto L137
    L131:
        this.tags = r414;
        goto L133
    L127:
        this.replyId = r413;
        goto L129
    L123:
        this.regenIndex = r412;
        goto L125
    L119:
        this.regenVisible = r411;
        goto L121
    L115:
        this.regenStatus = r410;
        goto L117
    L111:
        this.regenRootId = r317;
        goto L113
    L107:
        this.feedback = r316;
        goto L109
    L103:
        r105 = r315;
        goto L104
    L99:
        this.suggestQuestions = r314;
        goto L101
    L95:
        this.sectionName = r313;
        goto L97
    L91:
        this.sectionId = r312;
        goto L93
    L87:
        this.sourceFromAsr = r311;
        goto L89
    L79:
        this.localIndex = r219;
        goto L81
    L75:
        this.messageId = r218;
        goto L76
    L71:
        this.localMessageId = r217;
        goto L73
    L67:
        this.ext = r216;
        goto L69
    L63:
        this.referenceInfo = r215;
        goto L65
    L59:
        this.thinkingContent = r214;
        goto L61
    L55:
        this.contentBlock = r213;
        goto L57
    L51:
        this.content = r212;
        goto L53
    L47:
        this.brief = r211;
        goto L49
    L43:
        this.isNewBlockType = r210;
        goto L45
    L39:
        this.contentType = r118;
        goto L41
    L35:
        r103 = r117;
        goto L36
    L31:
        r102 = r116;
        goto L32
    L27:
        this.userType = r115;
        goto L29
    L23:
        this.senderId = r114;
        goto L25
    L19:
        this.threadId = r113;
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

    public /* synthetic */ Message(String r410, String r411, String r412, int r413, int r414, MessageStatus r415, int r416, boolean r417, String r510, String r511, List r512, String r513, ReferenceInfo r514, Map r515, String r516, String r517, long r518, long r610, boolean r611, String r612, String r613, List r614, Map r615, Integer r616, String r617, int r618, boolean r710, long r711, String r712, List r713, boolean r714, String r715, Integer r716, long r717, List r810, List r811, String r812, int r813, int r814, DefaultConstructorMarker r815) {
        if ((r813 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r813 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r813 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r813 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r813 & 16) == 0) goto L21;
        int r104 = 10;
    L23:
        if ((r813 & 32) == 0) goto L25;
        MessageStatus r105 = MessageStatus.MessageStatus_AVAILABLE;
    L27:
        if ((r813 & 64) == 0) goto L29;
        int r106 = 1;
    L31:
        if ((r813 & 128) == 0) goto L33;
        boolean r110 = false;
    L35:
        if ((r813 & 256) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r813 & 512) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r813 & 1024) == 0) goto L45;
        List r113 = null;
    L47:
        if ((r813 & 2048) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r813 & 4096) == 0) goto L53;
        ReferenceInfo r115 = null;
    L55:
        if ((r813 & 8192) == 0) goto L57;
        Map r107 = null;
    L59:
        if ((r813 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r813 & 32768) == 0) goto L65;
        String r116 = "";
    L66:
        long r117 = -1;
        if ((r813 & 65536) == 0) goto L69;
        long r210 = -1;
    L71:
        if ((r813 & 131072) != 0) goto L75;
        r117 = r610;
    L75:
        if ((r813 & 262144) == 0) goto L77;
        boolean r118 = false;
    L79:
        if ((r813 & 524288) == 0) goto L81;
        String r211 = null;
    L83:
        if ((r813 & 1048576) == 0) goto L85;
        String r212 = null;
    L87:
        if ((r813 & 2097152) == 0) goto L89;
        List r213 = null;
    L91:
        if ((r813 & 4194304) == 0) goto L93;
        Map r214 = new LinkedHashMap();
    L95:
        if ((r813 & 8388608) == 0) goto L97;
        Integer r215 = null;
    L99:
        if ((r813 & 16777216) == 0) goto L101;
        String r216 = null;
    L103:
        if ((r813 & 33554432) == 0) goto L105;
        int r217 = 0;
    L107:
        if ((r813 & 67108864) == 0) goto L109;
        boolean r218 = true;
    L110:
        long r310 = 0;
        if ((r813 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        long r311 = 0;
    L115:
        if ((r813 & 268435456) == 0) goto L117;
        String r312 = null;
    L119:
        if ((r813 & 536870912) == 0) goto L121;
        List r313 = null;
    L123:
        if ((r813 & 1073741824) == 0) goto L125;
        boolean r314 = false;
    L127:
        if ((r813 & Integer.MIN_VALUE) == 0) goto L129;
        String r109 = null;
    L131:
        if ((r814 & 1) == 0) goto L133;
        Integer r315 = 0;
    L135:
        if ((r814 & 2) != 0) goto L139;
        r310 = r717;
    L139:
        if ((r814 & 4) == 0) goto L141;
        List r316 = null;
    L143:
        if ((r814 & 8) == 0) goto L145;
        List r317 = null;
    L147:
        if ((r814 & 16) == 0) goto L149;
        String r418 = null;
    L150:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r210, r117, r118, r211, r212, r213, r214, r215, r216, r217, r218, r311, r312, r313, r314, r109, r315, r310, r316, r317, r418);
        return;
    L149:
        r418 = r812;
        goto L150
    L145:
        r317 = r811;
        goto L147
    L141:
        r316 = r810;
        goto L143
    L133:
        r315 = r716;
        goto L135
    L129:
        r109 = r715;
        goto L131
    L125:
        r314 = r714;
        goto L127
    L121:
        r313 = r713;
        goto L123
    L117:
        r312 = r712;
        goto L119
    L113:
        r311 = r711;
        goto L115
    L109:
        r218 = r710;
        goto L110
    L105:
        r217 = r618;
        goto L107
    L101:
        r216 = r617;
        goto L103
    L97:
        r215 = r616;
        goto L99
    L93:
        r214 = r615;
        goto L95
    L89:
        r213 = r614;
        goto L91
    L85:
        r212 = r613;
        goto L87
    L81:
        r211 = r612;
        goto L83
    L77:
        r118 = r611;
        goto L79
    L69:
        r210 = r518;
        goto L71
    L65:
        r116 = r517;
        goto L66
    L61:
        r108 = r516;
        goto L63
    L57:
        r107 = r515;
        goto L59
    L53:
        r115 = r514;
        goto L55
    L49:
        r114 = r513;
        goto L51
    L45:
        r113 = r512;
        goto L47
    L41:
        r112 = r511;
        goto L43
    L37:
        r111 = r510;
        goto L39
    L33:
        r110 = r417;
        goto L35
    L29:
        r106 = r416;
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
