package com.larus.im.bean.bot;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.google.gson.annotations.JsonAdapter;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.internal.protocol.model.BotActionScene;
import com.larus.im.internal.protocol.model.BotCommentInfo;
import com.larus.im.internal.protocol.model.BotLoadingConfig;
import com.larus.im.internal.protocol.model.LikeInfo;
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
import muc.c;
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
import uc9.g;
import uc9.h;
import uc9.j;
import uc9.k;
import uc9.l;
import uc9.m;
import uc9.n;
import uc9.o;
import uc9.p;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0003\b\u008a\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ü\u00022\u00060\u0001j\u0002`\u0002:\u0004ü\u0002ý\u0002BÇ\u0006\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0012\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u0012\u0012\u0016\b\u0002\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000204\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\f\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A\u0012\b\b\u0002\u0010B\u001a\u00020#\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010R\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010U\u0012\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010X\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010Z\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\\\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\u0012\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010_\u0012\u0016\b\u0002\u0010`\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u000103¢\u0006\u0004\ba\u0010bBå\u0005\b\u0010\u0012\u0006\u0010c\u001a\u00020\f\u0012\u0006\u0010d\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\"\u001a\u00020#\u0012\b\u0010$\u001a\u0004\u0018\u00010\f\u0012\b\u0010%\u001a\u0004\u0018\u00010#\u0012\b\u0010&\u001a\u0004\u0018\u00010#\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010)\u001a\u0004\u0018\u00010*\u0012\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0012\u0012\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012\u0012\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0012\u0012\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0012\u0012\u000e\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u0012\u0012\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000204\u0018\u000103\u0012\u0006\u00105\u001a\u00020\f\u0012\b\u00106\u001a\u0004\u0018\u00010\u0004\u0012\b\u00107\u001a\u0004\u0018\u00010\u0004\u0012\b\u00108\u001a\u0004\u0018\u00010\u0004\u0012\b\u00109\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010:\u001a\u0004\u0018\u00010;\u0012\b\u0010<\u001a\u0004\u0018\u00010=\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010?\u001a\u0004\u0018\u00010#\u0012\b\u0010@\u001a\u0004\u0018\u00010A\u0012\u0006\u0010B\u001a\u00020#\u0012\b\u0010C\u001a\u0004\u0018\u00010D\u0012\b\u0010E\u001a\u0004\u0018\u00010F\u0012\b\u0010G\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010I\u001a\u0004\u0018\u00010J\u0012\b\u0010K\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010L\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010M\u001a\u0004\u0018\u00010N\u0012\b\u0010O\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010Q\u001a\u0004\u0018\u00010R\u0012\b\u0010S\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010T\u001a\u0004\u0018\u00010U\u0012\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010\u0012\u0012\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012\u0012\b\u0010Y\u001a\u0004\u0018\u00010Z\u0012\b\u0010[\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\u0012\u0012\b\u0010^\u001a\u0004\u0018\u00010_\u0012\u0014\u0010`\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u000103\u0012\b\u0010e\u001a\u0004\u0018\u00010f¢\u0006\u0004\ba\u0010gJ\u0012\u0010¬\u0002\u001a\u00020\u00042\t\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\u0004J\f\u0010®\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010¯\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010°\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010±\u0002\u001a\u00020\tHÆ\u0003J\u0011\u0010²\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010vJ\u0011\u0010³\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010zJ\f\u0010´\u0002\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\f\u0010µ\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0012\u0010¶\u0002\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003J\u0012\u0010·\u0002\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012HÆ\u0003J\f\u0010¸\u0002\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\f\u0010¹\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010º\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010»\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010¼\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010½\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010zJ\f\u0010¾\u0002\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\f\u0010¿\u0002\u001a\u0004\u0018\u00010 HÆ\u0003J\f\u0010À\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010Á\u0002\u001a\u00020#HÆ\u0003J\u0011\u0010Â\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010zJ\u0012\u0010Ã\u0002\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0003\u0010¥\u0001J\u0012\u0010Ä\u0002\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0003\u0010¥\u0001J\f\u0010Å\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010Æ\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010Ç\u0002\u001a\u0004\u0018\u00010*HÆ\u0003J\u0012\u0010È\u0002\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0012HÆ\u0003J\u0012\u0010É\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012HÆ\u0003J\u0012\u0010Ê\u0002\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0012HÆ\u0003J\u0012\u0010Ë\u0002\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0012HÆ\u0003J\u0012\u0010Ì\u0002\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u0012HÆ\u0003J\u0018\u0010Í\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000204\u0018\u000103HÆ\u0003J\n\u0010Î\u0002\u001a\u00020\fHÆ\u0003J\f\u0010Ï\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010Ð\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010Ñ\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010Ò\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010Ó\u0002\u001a\u0004\u0018\u00010;HÆ\u0003J\f\u0010Ô\u0002\u001a\u0004\u0018\u00010=HÆ\u0003J\f\u0010Õ\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010Ö\u0002\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0003\u0010¥\u0001J\f\u0010×\u0002\u001a\u0004\u0018\u00010AHÆ\u0003J\n\u0010Ø\u0002\u001a\u00020#HÆ\u0003J\f\u0010Ù\u0002\u001a\u0004\u0018\u00010DHÆ\u0003J\f\u0010Ú\u0002\u001a\u0004\u0018\u00010FHÆ\u0003J\f\u0010Û\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010Ü\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010Ý\u0002\u001a\u0004\u0018\u00010JHÆ\u0003J\f\u0010Þ\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010ß\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010à\u0002\u001a\u0004\u0018\u00010NHÆ\u0003J\f\u0010á\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010â\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010ã\u0002\u001a\u0004\u0018\u00010RHÆ\u0003J\f\u0010ä\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010å\u0002\u001a\u0004\u0018\u00010UHÆ\u0003J\u0012\u0010æ\u0002\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010\u0012HÆ\u0003J\u0012\u0010ç\u0002\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012HÆ\u0003J\f\u0010è\u0002\u001a\u0004\u0018\u00010ZHÆ\u0003J\f\u0010é\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010ê\u0002\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\u0012HÆ\u0003J\f\u0010ë\u0002\u001a\u0004\u0018\u00010_HÆ\u0003J\u0018\u0010ì\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u000103HÆ\u0003JÐ\u0006\u0010í\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00122\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00122\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00122\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00122\u0016\b\u0002\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000204\u0018\u0001032\b\b\u0002\u00105\u001a\u00020\f2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\b\b\u0002\u0010B\u001a\u00020#2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010R2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010T\u001a\u0004\u0018\u00010U2\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010\u00122\u0010\b\u0002\u0010X\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00122\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010Z2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\\\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\u00122\n\b\u0002\u0010^\u001a\u0004\u0018\u00010_2\u0016\b\u0002\u0010`\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u000103HÆ\u0001¢\u0006\u0003\u0010î\u0002J\u0016\u0010ï\u0002\u001a\u00020#2\n\u0010ð\u0002\u001a\u0005\u0018\u00010ñ\u0002HÖ\u0003J\n\u0010ò\u0002\u001a\u00020\fHÖ\u0001J\n\u0010ó\u0002\u001a\u00020\u0004HÖ\u0001J-\u0010ô\u0002\u001a\u00030õ\u00022\u0007\u0010ö\u0002\u001a\u00020\u00002\b\u0010÷\u0002\u001a\u00030ø\u00022\b\u0010ù\u0002\u001a\u00030ú\u0002H\u0001¢\u0006\u0003\bû\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bl\u0010i\u001a\u0004\bm\u0010kR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bn\u0010i\u001a\u0004\bo\u0010pR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bq\u0010i\u001a\u0004\br\u0010sR \u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010w\u0012\u0004\bt\u0010i\u001a\u0004\bu\u0010vR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010{\u0012\u0004\bx\u0010i\u001a\u0004\by\u0010zR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b|\u0010i\u001a\u0004\b}\u0010~R \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0004\b\u007f\u0010i\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R1\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u0082\u0001\u0010i\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R1\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u0087\u0001\u0010i\u001a\u0006\b\u0088\u0001\u0010\u0084\u0001\"\u0006\b\u0089\u0001\u0010\u0086\u0001R!\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u008a\u0001\u0010i\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u008d\u0001\u0010i\u001a\u0005\b\u008e\u0001\u0010kR \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u008f\u0001\u0010i\u001a\u0005\b\u0090\u0001\u0010kR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b\u0091\u0001\u0010zR\"\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010{\u0012\u0005\b\u0092\u0001\u0010i\u001a\u0005\b\u0093\u0001\u0010zR\"\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010{\u0012\u0005\b\u0094\u0001\u0010i\u001a\u0005\b\u0095\u0001\u0010zR!\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u0096\u0001\u0010i\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R!\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u0099\u0001\u0010i\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R \u0010!\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u009c\u0001\u0010i\u001a\u0005\b\u009d\u0001\u0010kR\u001f\u0010\"\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u009e\u0001\u0010i\u001a\u0006\b\u009f\u0001\u0010 \u0001R\"\u0010$\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010{\u0012\u0005\b¡\u0001\u0010i\u001a\u0005\b¢\u0001\u0010zR$\u0010%\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\u0014\n\u0003\u0010¦\u0001\u0012\u0005\b£\u0001\u0010i\u001a\u0006\b¤\u0001\u0010¥\u0001R$\u0010&\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\u0014\n\u0003\u0010¦\u0001\u0012\u0005\b§\u0001\u0010i\u001a\u0006\b¨\u0001\u0010¥\u0001R \u0010'\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b©\u0001\u0010i\u001a\u0005\bª\u0001\u0010kR \u0010(\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b«\u0001\u0010i\u001a\u0005\b¬\u0001\u0010kR!\u0010)\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u00ad\u0001\u0010i\u001a\u0006\b®\u0001\u0010¯\u0001R'\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b°\u0001\u0010i\u001a\u0006\b±\u0001\u0010\u0084\u0001R'\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b²\u0001\u0010i\u001a\u0006\b³\u0001\u0010\u0084\u0001R1\u0010.\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b´\u0001\u0010i\u001a\u0006\bµ\u0001\u0010\u0084\u0001\"\u0006\b¶\u0001\u0010\u0086\u0001R1\u0010/\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b·\u0001\u0010i\u001a\u0006\b¸\u0001\u0010\u0084\u0001\"\u0006\b¹\u0001\u0010\u0086\u0001R1\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\bº\u0001\u0010i\u001a\u0006\b»\u0001\u0010\u0084\u0001\"\u0006\b¼\u0001\u0010\u0086\u0001R7\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000204\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b½\u0001\u0010i\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R)\u00105\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\bÂ\u0001\u0010i\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R*\u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0000\u0012\u0005\bÇ\u0001\u0010i\u001a\u0005\bÈ\u0001\u0010k\"\u0006\bÉ\u0001\u0010Ê\u0001R*\u00107\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0000\u0012\u0005\bË\u0001\u0010i\u001a\u0005\bÌ\u0001\u0010k\"\u0006\bÍ\u0001\u0010Ê\u0001R*\u00108\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0000\u0012\u0005\bÎ\u0001\u0010i\u001a\u0005\bÏ\u0001\u0010k\"\u0006\bÐ\u0001\u0010Ê\u0001R*\u00109\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0000\u0012\u0005\bÑ\u0001\u0010i\u001a\u0005\bÒ\u0001\u0010k\"\u0006\bÓ\u0001\u0010Ê\u0001R+\u0010:\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\bÔ\u0001\u0010i\u001a\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R!\u0010<\u001a\u0004\u0018\u00010=8\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\bÙ\u0001\u0010i\u001a\u0006\bÚ\u0001\u0010Û\u0001R \u0010>\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\bÜ\u0001\u0010i\u001a\u0005\bÝ\u0001\u0010kR$\u0010?\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\u0014\n\u0003\u0010¦\u0001\u0012\u0005\bÞ\u0001\u0010i\u001a\u0006\bß\u0001\u0010¥\u0001R+\u0010@\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\bà\u0001\u0010i\u001a\u0006\bá\u0001\u0010â\u0001\"\u0006\bã\u0001\u0010ä\u0001R)\u0010B\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\bå\u0001\u0010i\u001a\u0006\bæ\u0001\u0010 \u0001\"\u0006\bç\u0001\u0010è\u0001R+\u0010C\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\bé\u0001\u0010i\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0006\bì\u0001\u0010í\u0001R!\u0010E\u001a\u0004\u0018\u00010F8\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\bî\u0001\u0010i\u001a\u0006\bï\u0001\u0010ð\u0001R*\u0010G\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0000\u0012\u0005\bñ\u0001\u0010i\u001a\u0005\bò\u0001\u0010k\"\u0006\bó\u0001\u0010Ê\u0001R*\u0010H\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0000\u0012\u0005\bô\u0001\u0010i\u001a\u0005\bõ\u0001\u0010k\"\u0006\bö\u0001\u0010Ê\u0001R+\u0010I\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b÷\u0001\u0010i\u001a\u0006\bø\u0001\u0010ù\u0001\"\u0006\bú\u0001\u0010û\u0001R*\u0010K\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0000\u0012\u0005\bü\u0001\u0010i\u001a\u0005\bý\u0001\u0010k\"\u0006\bþ\u0001\u0010Ê\u0001R*\u0010L\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0000\u0012\u0005\bÿ\u0001\u0010i\u001a\u0005\b\u0080\u0002\u0010k\"\u0006\b\u0081\u0002\u0010Ê\u0001R+\u0010M\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u0082\u0002\u0010i\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002\"\u0006\b\u0085\u0002\u0010\u0086\u0002R*\u0010O\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0000\u0012\u0005\b\u0087\u0002\u0010i\u001a\u0005\b\u0088\u0002\u0010k\"\u0006\b\u0089\u0002\u0010Ê\u0001R*\u0010P\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0000\u0012\u0005\b\u008a\u0002\u0010i\u001a\u0005\b\u008b\u0002\u0010k\"\u0006\b\u008c\u0002\u0010Ê\u0001R+\u0010Q\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u008d\u0002\u0010i\u001a\u0006\b\u008e\u0002\u0010\u008f\u0002\"\u0006\b\u0090\u0002\u0010\u0091\u0002R*\u0010S\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0000\u0012\u0005\b\u0092\u0002\u0010i\u001a\u0005\b\u0093\u0002\u0010k\"\u0006\b\u0094\u0002\u0010Ê\u0001R!\u0010T\u001a\u0004\u0018\u00010U8\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u0095\u0002\u0010i\u001a\u0006\b\u0096\u0002\u0010\u0097\u0002R1\u0010V\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u0098\u0002\u0010i\u001a\u0006\b\u0099\u0002\u0010\u0084\u0001\"\u0006\b\u009a\u0002\u0010\u0086\u0001R1\u0010X\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u009b\u0002\u0010i\u001a\u0006\b\u009c\u0002\u0010\u0084\u0001\"\u0006\b\u009d\u0002\u0010\u0086\u0001R!\u0010Y\u001a\u0004\u0018\u00010Z8\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u009e\u0002\u0010i\u001a\u0006\b\u009f\u0002\u0010 \u0002R \u0010[\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b¡\u0002\u0010i\u001a\u0005\b¢\u0002\u0010kR'\u0010\\\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b£\u0002\u0010i\u001a\u0006\b¤\u0002\u0010\u0084\u0001R!\u0010^\u001a\u0004\u0018\u00010_8\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b¥\u0002\u0010i\u001a\u0006\b¦\u0002\u0010§\u0002R-\u0010`\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001038\u0006X\u0087\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b¨\u0002\u0010i\u001a\u0006\b©\u0002\u0010¿\u0001R\u0014\u0010ª\u0002\u001a\u00020#8F¢\u0006\b\u001a\u0006\b«\u0002\u0010 \u0001¨\u0006þ\u0002"}, d2 = {"Lcom/larus/im/bean/bot/BotModel;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "botId", "", "name", "iconImage", "Lcom/larus/im/bean/bot/BotIconImage;", "createTime", "", UserInfo.UPDATE_TIME, "botType", "", "shareInfo", "Lcom/larus/im/bean/bot/ShareInfo;", "botCreatorInfo", "Lcom/larus/im/bean/bot/BotCreatorInfo;", "tagList", "", "Lcom/larus/im/bean/bot/ShowTagInfo;", "selectTextActions", "Lcom/larus/im/bean/bot/SelectTextAction;", "conversationPage", "Lcom/larus/im/bean/bot/ConversationPage;", "descriptionForModel", "descriptionForHuman", "botStatus", "botRecommendStatus", "privateStatus", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/im/bean/bot/ModelItem;", "voiceType", "Lcom/larus/im/bean/bot/SpeakerVoice;", "editPos", "muted", "", "recommendIndex", "messagePush", "showMessagePush", "bioEdit", "bio", "botStatic", "Lcom/larus/im/bean/bot/BotStatistic;", "answerActions", "Lcom/larus/im/bean/bot/AnswerAction;", "answerActionExposurePriority", "menuActions", "streamingAnswerActions", "botConf", "Lcom/larus/im/bean/bot/BotConfItem;", "cameraTabConfigMap", "", "Lcom/larus/im/bean/bot/CameraTabConfig;", "botMode", "bgImgUrl", "bgImgColor", "bgVideoModel", "iconPrompt", "switchConfInfo", "Lcom/larus/im/bean/bot/BotSwitchConfInfo;", "onBoarding", "Lcom/larus/im/bean/bot/BotOnBoarding;", "callerName", "callerNameSetting", "sceneModelList", "Lcom/larus/im/bean/bot/SceneModelList;", "disabled", "firstMet", "Lcom/larus/im/bean/bot/FirstMet;", "loadingConf", "Lcom/larus/im/internal/protocol/model/BotLoadingConfig;", "botFeatureLabel", "bgImgUri", "bgImgInfo", "Lcom/larus/im/bean/bot/BgImageInfo;", "userBotGender", "userBotType", "botMemoryConfig", "Lcom/larus/im/bean/bot/BotMemoryConfig;", "dynamicImgUri", "dynamicImgUrl", "callImgConfig", "Lcom/larus/im/bean/bot/CallImgConfig;", "botIconMappedAppIcon", "messagePushSwitchConfirmTitle", "Lcom/larus/im/bean/bot/MessagePushSwitchConfirmTitle;", "msgRegenModeList", "Lcom/larus/im/bean/bot/MsgRegenMode;", "unavailableInstructionTypeList", "likeInfo", "Lcom/larus/im/internal/protocol/model/LikeInfo;", "serviceBotConf", "actionScenes", "Lcom/larus/im/internal/protocol/model/BotActionScene;", "commentInfo", "Lcom/larus/im/internal/protocol/model/BotCommentInfo;", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotIconImage;JLjava/lang/Long;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ShareInfo;Lcom/larus/im/bean/bot/BotCreatorInfo;Ljava/util/List;Ljava/util/List;Lcom/larus/im/bean/bot/ConversationPage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotStatistic;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotSwitchConfInfo;Lcom/larus/im/bean/bot/BotOnBoarding;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/SceneModelList;ZLcom/larus/im/bean/bot/FirstMet;Lcom/larus/im/internal/protocol/model/BotLoadingConfig;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotMemoryConfig;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/CallImgConfig;Ljava/lang/String;Lcom/larus/im/bean/bot/MessagePushSwitchConfirmTitle;Ljava/util/List;Ljava/util/List;Lcom/larus/im/internal/protocol/model/LikeInfo;Ljava/lang/String;Ljava/util/List;Lcom/larus/im/internal/protocol/model/BotCommentInfo;Ljava/util/Map;)V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotIconImage;JLjava/lang/Long;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ShareInfo;Lcom/larus/im/bean/bot/BotCreatorInfo;Ljava/util/List;Ljava/util/List;Lcom/larus/im/bean/bot/ConversationPage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotStatistic;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotSwitchConfInfo;Lcom/larus/im/bean/bot/BotOnBoarding;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/SceneModelList;ZLcom/larus/im/bean/bot/FirstMet;Lcom/larus/im/internal/protocol/model/BotLoadingConfig;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotMemoryConfig;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/CallImgConfig;Ljava/lang/String;Lcom/larus/im/bean/bot/MessagePushSwitchConfirmTitle;Ljava/util/List;Ljava/util/List;Lcom/larus/im/internal/protocol/model/LikeInfo;Ljava/lang/String;Ljava/util/List;Lcom/larus/im/internal/protocol/model/BotCommentInfo;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBotId$annotations", "()V", "getBotId", "()Ljava/lang/String;", "getName$annotations", "getName", "getIconImage$annotations", "getIconImage", "()Lcom/larus/im/bean/bot/BotIconImage;", "getCreateTime$annotations", "getCreateTime", "()J", "getUpdateTime$annotations", "getUpdateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBotType$annotations", "getBotType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShareInfo$annotations", "getShareInfo", "()Lcom/larus/im/bean/bot/ShareInfo;", "getBotCreatorInfo$annotations", "getBotCreatorInfo", "()Lcom/larus/im/bean/bot/BotCreatorInfo;", "getTagList$annotations", "getTagList", "()Ljava/util/List;", "setTagList", "(Ljava/util/List;)V", "getSelectTextActions$annotations", "getSelectTextActions", "setSelectTextActions", "getConversationPage$annotations", "getConversationPage", "()Lcom/larus/im/bean/bot/ConversationPage;", "getDescriptionForModel$annotations", "getDescriptionForModel", "getDescriptionForHuman$annotations", "getDescriptionForHuman", "getBotStatus", "getBotRecommendStatus$annotations", "getBotRecommendStatus", "getPrivateStatus$annotations", "getPrivateStatus", "getModel$annotations", "getModel", "()Lcom/larus/im/bean/bot/ModelItem;", "getVoiceType$annotations", "getVoiceType", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "getEditPos$annotations", "getEditPos", "getMuted$annotations", "getMuted", "()Z", "getRecommendIndex$annotations", "getRecommendIndex", "getMessagePush$annotations", "getMessagePush", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowMessagePush$annotations", "getShowMessagePush", "getBioEdit$annotations", "getBioEdit", "getBio$annotations", "getBio", "getBotStatic$annotations", "getBotStatic", "()Lcom/larus/im/bean/bot/BotStatistic;", "getAnswerActions$annotations", "getAnswerActions", "getAnswerActionExposurePriority$annotations", "getAnswerActionExposurePriority", "getMenuActions$annotations", "getMenuActions", "setMenuActions", "getStreamingAnswerActions$annotations", "getStreamingAnswerActions", "setStreamingAnswerActions", "getBotConf$annotations", "getBotConf", "setBotConf", "getCameraTabConfigMap$annotations", "getCameraTabConfigMap", "()Ljava/util/Map;", "setCameraTabConfigMap", "(Ljava/util/Map;)V", "getBotMode$annotations", "getBotMode", "()I", "setBotMode", "(I)V", "getBgImgUrl$annotations", "getBgImgUrl", "setBgImgUrl", "(Ljava/lang/String;)V", "getBgImgColor$annotations", "getBgImgColor", "setBgImgColor", "getBgVideoModel$annotations", "getBgVideoModel", "setBgVideoModel", "getIconPrompt$annotations", "getIconPrompt", "setIconPrompt", "getSwitchConfInfo$annotations", "getSwitchConfInfo", "()Lcom/larus/im/bean/bot/BotSwitchConfInfo;", "setSwitchConfInfo", "(Lcom/larus/im/bean/bot/BotSwitchConfInfo;)V", "getOnBoarding$annotations", "getOnBoarding", "()Lcom/larus/im/bean/bot/BotOnBoarding;", "getCallerName$annotations", "getCallerName", "getCallerNameSetting$annotations", "getCallerNameSetting", "getSceneModelList$annotations", "getSceneModelList", "()Lcom/larus/im/bean/bot/SceneModelList;", "setSceneModelList", "(Lcom/larus/im/bean/bot/SceneModelList;)V", "getDisabled$annotations", "getDisabled", "setDisabled", "(Z)V", "getFirstMet$annotations", "getFirstMet", "()Lcom/larus/im/bean/bot/FirstMet;", "setFirstMet", "(Lcom/larus/im/bean/bot/FirstMet;)V", "getLoadingConf$annotations", "getLoadingConf", "()Lcom/larus/im/internal/protocol/model/BotLoadingConfig;", "getBotFeatureLabel$annotations", "getBotFeatureLabel", "setBotFeatureLabel", "getBgImgUri$annotations", "getBgImgUri", "setBgImgUri", "getBgImgInfo$annotations", "getBgImgInfo", "()Lcom/larus/im/bean/bot/BgImageInfo;", "setBgImgInfo", "(Lcom/larus/im/bean/bot/BgImageInfo;)V", "getUserBotGender$annotations", "getUserBotGender", "setUserBotGender", "getUserBotType$annotations", "getUserBotType", "setUserBotType", "getBotMemoryConfig$annotations", "getBotMemoryConfig", "()Lcom/larus/im/bean/bot/BotMemoryConfig;", "setBotMemoryConfig", "(Lcom/larus/im/bean/bot/BotMemoryConfig;)V", "getDynamicImgUri$annotations", "getDynamicImgUri", "setDynamicImgUri", "getDynamicImgUrl$annotations", "getDynamicImgUrl", "setDynamicImgUrl", "getCallImgConfig$annotations", "getCallImgConfig", "()Lcom/larus/im/bean/bot/CallImgConfig;", "setCallImgConfig", "(Lcom/larus/im/bean/bot/CallImgConfig;)V", "getBotIconMappedAppIcon$annotations", "getBotIconMappedAppIcon", "setBotIconMappedAppIcon", "getMessagePushSwitchConfirmTitle$annotations", "getMessagePushSwitchConfirmTitle", "()Lcom/larus/im/bean/bot/MessagePushSwitchConfirmTitle;", "getMsgRegenModeList$annotations", "getMsgRegenModeList", "setMsgRegenModeList", "getUnavailableInstructionTypeList$annotations", "getUnavailableInstructionTypeList", "setUnavailableInstructionTypeList", "getLikeInfo$annotations", "getLikeInfo", "()Lcom/larus/im/internal/protocol/model/LikeInfo;", "getServiceBotConf$annotations", "getServiceBotConf", "getActionScenes$annotations", "getActionScenes", "getCommentInfo$annotations", "getCommentInfo", "()Lcom/larus/im/internal/protocol/model/BotCommentInfo;", "getExtra$annotations", "getExtra", "bgImgOpen", "getBgImgOpen", "getChatType", "userId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotIconImage;JLjava/lang/Long;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ShareInfo;Lcom/larus/im/bean/bot/BotCreatorInfo;Ljava/util/List;Ljava/util/List;Lcom/larus/im/bean/bot/ConversationPage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotStatistic;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotSwitchConfInfo;Lcom/larus/im/bean/bot/BotOnBoarding;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/SceneModelList;ZLcom/larus/im/bean/bot/FirstMet;Lcom/larus/im/internal/protocol/model/BotLoadingConfig;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BotMemoryConfig;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/CallImgConfig;Ljava/lang/String;Lcom/larus/im/bean/bot/MessagePushSwitchConfirmTitle;Ljava/util/List;Ljava/util/List;Lcom/larus/im/internal/protocol/model/LikeInfo;Ljava/lang/String;Ljava/util/List;Lcom/larus/im/internal/protocol/model/BotCommentInfo;Ljava/util/Map;)Lcom/larus/im/bean/bot/BotModel;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class BotModel implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    public static final int PRIVATE_STATUS_PRIVATE = 2;
    public static final int PRIVATE_STATUS_PUBLIC = 1;
    public static final int PRIVATE_STATUS_UNLISTED = 3;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<BotActionScene> actionScenes;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> answerActionExposurePriority;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<AnswerAction> answerActions;
    private String bgImgColor;
    private BgImageInfo bgImgInfo;
    private String bgImgUri;
    private String bgImgUrl;
    private String bgVideoModel;
    private final String bio;
    private final String bioEdit;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<BotConfItem> botConf;
    private final BotCreatorInfo botCreatorInfo;
    private String botFeatureLabel;
    private String botIconMappedAppIcon;
    private final String botId;
    private BotMemoryConfig botMemoryConfig;
    private int botMode;
    private final Integer botRecommendStatus;
    private final BotStatistic botStatic;
    private final Integer botStatus;
    private final Integer botType;
    private CallImgConfig callImgConfig;
    private final String callerName;
    private final Boolean callerNameSetting;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private Map<String, CameraTabConfig> cameraTabConfigMap;
    private final BotCommentInfo commentInfo;
    private final ConversationPage conversationPage;
    private final long createTime;
    private final String descriptionForHuman;
    private final String descriptionForModel;
    private boolean disabled;
    private String dynamicImgUri;
    private String dynamicImgUrl;
    private final String editPos;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> extra;
    private FirstMet firstMet;
    private final BotIconImage iconImage;
    private String iconPrompt;
    private final LikeInfo likeInfo;
    private final BotLoadingConfig loadingConf;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<AnswerAction> menuActions;
    private final Boolean messagePush;
    private final MessagePushSwitchConfirmTitle messagePushSwitchConfirmTitle;
    private final ModelItem model;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<MsgRegenMode> msgRegenModeList;
    private final boolean muted;
    private final String name;
    private final BotOnBoarding onBoarding;
    private final Integer privateStatus;
    private final Integer recommendIndex;
    private SceneModelList sceneModelList;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<SelectTextAction> selectTextActions;
    private final String serviceBotConf;
    private final ShareInfo shareInfo;
    private final Boolean showMessagePush;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<AnswerAction> streamingAnswerActions;
    private BotSwitchConfInfo switchConfInfo;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<ShowTagInfo> tagList;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<Integer> unavailableInstructionTypeList;
    private final Long updateTime;
    private String userBotGender;
    private String userBotType;
    private final SpeakerVoice voiceType;

    /* JADX INFO: loaded from: classes29.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<BotModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346441a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346442b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346442b;
        }

        static {
            a r100 = new a();
            f346441a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.BotModel", r100, 63);
            r101.j("id", true);
            r101.j("name", true);
            r101.j("icon_image", true);
            r101.j("create_time", true);
            r101.j("update_time", true);
            r101.j("bot_type", true);
            r101.j("share_info", true);
            r101.j("creator_info", true);
            r101.j("show_tag_info_list", true);
            r101.j("select_text_actions", true);
            r101.j(CommentPublishScene.CONVERSATION_PAGE, true);
            r101.j("description_for_model", true);
            r101.j("description_for_human", true);
            r101.j("botStatus", true);
            r101.j("status", true);
            r101.j("private_status", true);
            r101.j(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, true);
            r101.j("voice_type", true);
            r101.j("edit_pos", true);
            r101.j("muted", true);
            r101.j("recommend_index", true);
            r101.j("message_push", true);
            r101.j("show_message_push", true);
            r101.j("user_edit_bio", true);
            r101.j("bio", true);
            r101.j("bot_stats", true);
            r101.j("answer_actions", true);
            r101.j("answer_action_exposure_priority", true);
            r101.j("hover_answer_actions", true);
            r101.j("streaming_answer_actions", true);
            r101.j("bot_conf", true);
            r101.j("camera_tab_config_map", true);
            r101.j("bot_mode", true);
            r101.j("bg_img_url", true);
            r101.j("bg_img_avg_hue", true);
            r101.j("bg_video_model", true);
            r101.j("icon_prompt", true);
            r101.j("switch_conf", true);
            r101.j("onboarding", true);
            r101.j(Constant.KEY_CALL_NAME, true);
            r101.j("caller_name_setting", true);
            r101.j("call_model_list", true);
            r101.j("disabled", true);
            r101.j("first_met", true);
            r101.j("loading_conf", true);
            r101.j("bot_feature_label", true);
            r101.j("bg_img_uri", true);
            r101.j("bg_img_info", true);
            r101.j("user_bot_gender_starling_key", true);
            r101.j("user_bot_type_starling_key", true);
            r101.j("bot_memory_config", true);
            r101.j("dynamic_img_uri", true);
            r101.j("dynamic_img_url", true);
            r101.j("phone_call_img", true);
            r101.j("bot_icon_mapped_app_icon", true);
            r101.j("message_push_switch_confirm_title", true);
            r101.j("msg_regen_mode_list", true);
            r101.j("unavailable_instruction_type_list", true);
            r101.j("like_info", true);
            r101.j("service_bot_conf", true);
            r101.j("action_scenes", true);
            r101.j("comment_info", true);
            r101.j("extra", true);
            f346442b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = BotModel.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            g1 r102 = g1.f520681a;
            w0 r103 = w0.f520792a;
            i r104 = i.f520705a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(BotIconImage.a.f346435a), r102, kuc.a.d(r102), kuc.a.d(r103), kuc.a.d(ShareInfo.a.f346495a), kuc.a.d(BotCreatorInfo.a.f346430a), kuc.a.d((d) r100[8].getValue()), kuc.a.d((d) r100[9].getValue()), kuc.a.d(ConversationPage.a.f346464a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r103), kuc.a.d(r103), kuc.a.d(r103), kuc.a.d(ModelItem.a.f346482a), kuc.a.d(SpeakerVoice.a.f346504a), kuc.a.d(r101), r104, kuc.a.d(r103), kuc.a.d(r104), kuc.a.d(r104), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(BotStatistic.a.f346447a), kuc.a.d((d) r100[26].getValue()), kuc.a.d((d) r100[27].getValue()), kuc.a.d((d) r100[28].getValue()), kuc.a.d((d) r100[29].getValue()), kuc.a.d((d) r100[30].getValue()), kuc.a.d((d) r100[31].getValue()), r103, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(BotSwitchConfInfo.a.f346449a), kuc.a.d(BotOnBoarding.a.f346444a), kuc.a.d(r101), kuc.a.d(r104), kuc.a.d(SceneModelList.a.f346490a), r104, kuc.a.d(FirstMet.a.f346469a), kuc.a.d(BotLoadingConfig.a.f349780a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(BgImageInfo.a.f346423a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(BotMemoryConfig.a.f346439a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(CallImgConfig.a.f346453a), kuc.a.d(r101), kuc.a.d(MessagePushSwitchConfirmTitle.a.f346478a), kuc.a.d((d) r100[56].getValue()), kuc.a.d((d) r100[57].getValue()), kuc.a.d(LikeInfo.a.f349784a), kuc.a.d(r101), kuc.a.d((d) r100[60].getValue()), kuc.a.d(BotCommentInfo.a.f349775a), kuc.a.d((d) r100[62].getValue())};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r103) {
            Intrinsics.checkNotNullParameter(r103, "decoder");
            g2 r100 = f346442b;
            c r101 = r103.beginStructure(r100);
            Lazy[] r102 = BotModel.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            BotIconImage r105 = (BotIconImage) r101.decodeNullableSerializableElement(r100, 2, BotIconImage.a.f346435a, null);
            long r210 = r101.decodeLongElement(r100, 3);
            Long r106 = (Long) r101.decodeNullableSerializableElement(r100, 4, g1.f520681a, null);
            w0 r107 = w0.f520792a;
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 5, r107, null);
            ShareInfo r112 = (ShareInfo) r101.decodeNullableSerializableElement(r100, 6, ShareInfo.a.f346495a, null);
            BotCreatorInfo r113 = (BotCreatorInfo) r101.decodeNullableSerializableElement(r100, 7, BotCreatorInfo.a.f346430a, null);
            List r109 = (List) r101.decodeNullableSerializableElement(r100, 8, (juc.c) r102[8].getValue(), null);
            List r114 = (List) r101.decodeNullableSerializableElement(r100, 9, (juc.c) r102[9].getValue(), null);
            ConversationPage r115 = (ConversationPage) r101.decodeNullableSerializableElement(r100, 10, ConversationPage.a.f346464a, null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 11, r104, null);
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 12, r104, null);
            Integer r117 = (Integer) r101.decodeNullableSerializableElement(r100, 13, r107, null);
            Integer r118 = (Integer) r101.decodeNullableSerializableElement(r100, 14, r107, null);
            Integer r119 = (Integer) r101.decodeNullableSerializableElement(r100, 15, r107, null);
            ModelItem r120 = (ModelItem) r101.decodeNullableSerializableElement(r100, 16, ModelItem.a.f346482a, null);
            SpeakerVoice r121 = (SpeakerVoice) r101.decodeNullableSerializableElement(r100, 17, SpeakerVoice.a.f346504a, null);
            String r122 = (String) r101.decodeNullableSerializableElement(r100, 18, r104, null);
            boolean r123 = r101.decodeBooleanElement(r100, 19);
            Integer r124 = (Integer) r101.decodeNullableSerializableElement(r100, 20, r107, null);
            i r125 = i.f520705a;
            Boolean r126 = (Boolean) r101.decodeNullableSerializableElement(r100, 21, r125, null);
            Boolean r127 = (Boolean) r101.decodeNullableSerializableElement(r100, 22, r125, null);
            String r128 = (String) r101.decodeNullableSerializableElement(r100, 23, r104, null);
            String r129 = (String) r101.decodeNullableSerializableElement(r100, 24, r104, null);
            BotStatistic r130 = (BotStatistic) r101.decodeNullableSerializableElement(r100, 25, BotStatistic.a.f346447a, null);
            List r131 = (List) r101.decodeNullableSerializableElement(r100, 26, (juc.c) r102[26].getValue(), null);
            List r132 = (List) r101.decodeNullableSerializableElement(r100, 27, (juc.c) r102[27].getValue(), null);
            List r133 = (List) r101.decodeNullableSerializableElement(r100, 28, (juc.c) r102[28].getValue(), null);
            List r134 = (List) r101.decodeNullableSerializableElement(r100, 29, (juc.c) r102[29].getValue(), null);
            List r135 = (List) r101.decodeNullableSerializableElement(r100, 30, (juc.c) r102[30].getValue(), null);
            Map r136 = (Map) r101.decodeNullableSerializableElement(r100, 31, (juc.c) r102[31].getValue(), null);
            int r137 = r101.decodeIntElement(r100, 32);
            String r138 = (String) r101.decodeNullableSerializableElement(r100, 33, r104, null);
            String r139 = (String) r101.decodeNullableSerializableElement(r100, 34, r104, null);
            String r140 = (String) r101.decodeNullableSerializableElement(r100, 35, r104, null);
            String r141 = (String) r101.decodeNullableSerializableElement(r100, 36, r104, null);
            BotSwitchConfInfo r142 = (BotSwitchConfInfo) r101.decodeNullableSerializableElement(r100, 37, BotSwitchConfInfo.a.f346449a, null);
            BotOnBoarding r143 = (BotOnBoarding) r101.decodeNullableSerializableElement(r100, 38, BotOnBoarding.a.f346444a, null);
            String r144 = (String) r101.decodeNullableSerializableElement(r100, 39, r104, null);
            Boolean r145 = (Boolean) r101.decodeNullableSerializableElement(r100, 40, r125, null);
            SceneModelList r146 = (SceneModelList) r101.decodeNullableSerializableElement(r100, 41, SceneModelList.a.f346490a, null);
            boolean r147 = r101.decodeBooleanElement(r100, 42);
            FirstMet r148 = (FirstMet) r101.decodeNullableSerializableElement(r100, 43, FirstMet.a.f346469a, null);
            BotLoadingConfig r149 = (BotLoadingConfig) r101.decodeNullableSerializableElement(r100, 44, BotLoadingConfig.a.f349780a, null);
            String r150 = (String) r101.decodeNullableSerializableElement(r100, 45, r104, null);
            String r151 = (String) r101.decodeNullableSerializableElement(r100, 46, r104, null);
            BgImageInfo r152 = (BgImageInfo) r101.decodeNullableSerializableElement(r100, 47, BgImageInfo.a.f346423a, null);
            String r153 = (String) r101.decodeNullableSerializableElement(r100, 48, r104, null);
            String r154 = (String) r101.decodeNullableSerializableElement(r100, 49, r104, null);
            BotMemoryConfig r155 = (BotMemoryConfig) r101.decodeNullableSerializableElement(r100, 50, BotMemoryConfig.a.f346439a, null);
            String r156 = (String) r101.decodeNullableSerializableElement(r100, 51, r104, null);
            String r157 = (String) r101.decodeNullableSerializableElement(r100, 52, r104, null);
            CallImgConfig r158 = (CallImgConfig) r101.decodeNullableSerializableElement(r100, 53, CallImgConfig.a.f346453a, null);
            String r159 = (String) r101.decodeNullableSerializableElement(r100, 54, r104, null);
            MessagePushSwitchConfirmTitle r160 = (MessagePushSwitchConfirmTitle) r101.decodeNullableSerializableElement(r100, 55, MessagePushSwitchConfirmTitle.a.f346478a, null);
            List r161 = (List) r101.decodeNullableSerializableElement(r100, 56, (juc.c) r102[56].getValue(), null);
            List r162 = (List) r101.decodeNullableSerializableElement(r100, 57, (juc.c) r102[57].getValue(), null);
            LikeInfo r163 = (LikeInfo) r101.decodeNullableSerializableElement(r100, 58, LikeInfo.a.f349784a, null);
            String r164 = (String) r101.decodeNullableSerializableElement(r100, 59, r104, null);
            List r165 = (List) r101.decodeNullableSerializableElement(r100, 60, (juc.c) r102[60].getValue(), null);
            BotCommentInfo r166 = (BotCommentInfo) r101.decodeNullableSerializableElement(r100, 61, BotCommentInfo.a.f349775a, null);
            Map r710 = (Map) r101.decodeNullableSerializableElement(r100, 62, (juc.c) r102[62].getValue(), null);
            BotCommentInfo r711 = r166;
            LikeInfo r610 = r163;
            String r167 = r111;
            String r168 = r110;
            List r611 = r162;
            List r612 = r161;
            List r712 = r165;
            String r713 = r164;
            ShareInfo r169 = r112;
            String r613 = r156;
            CallImgConfig r614 = r158;
            String r615 = r159;
            MessagePushSwitchConfirmTitle r616 = r160;
            BotIconImage r170 = r105;
            String r617 = r154;
            String r510 = r153;
            BotMemoryConfig r618 = r155;
            String r619 = r157;
            int r171 = -1;
            BotLoadingConfig r511 = r149;
            String r512 = r151;
            String r513 = r150;
            BgImageInfo r514 = r152;
            boolean r515 = r147;
            Boolean r516 = r145;
            SceneModelList r517 = r146;
            FirstMet r518 = r148;
            int r172 = Integer.MAX_VALUE;
            String r410 = r141;
            int r411 = r137;
            BotSwitchConfInfo r412 = r142;
            String r519 = r144;
            String r413 = r138;
            String r414 = r139;
            BotOnBoarding r415 = r143;
            String r310 = r128;
            List r416 = r135;
            String r417 = r140;
            Map r418 = r136;
            Integer r311 = r124;
            List r419 = r134;
            BotCreatorInfo r173 = r113;
            List r312 = r133;
            List r313 = r132;
            List r314 = r131;
            BotStatistic r315 = r130;
            String r316 = r129;
            Boolean r317 = r126;
            String r212 = r122;
            Boolean r318 = r127;
            boolean r319 = r123;
            long r174 = r210;
            ModelItem r213 = r120;
            Integer r214 = r119;
            List r215 = r114;
            List r175 = r109;
            SpeakerVoice r216 = r121;
            Integer r176 = r108;
            String r217 = r116;
            Long r177 = r106;
            Integer r218 = r118;
            ConversationPage r219 = r115;
            Integer r220 = r117;
        L118:
            r101.endStructure(r100);
            return new BotModel(r171, r172, r168, r167, r170, r174, r177, r176, r169, r173, r175, r215, r219, r217, r211, r220, r218, r214, r213, r216, r212, r319, r311, r317, r318, r310, r316, r315, r314, r313, r312, r419, r416, r418, r411, r413, r414, r417, r410, r412, r415, r519, r516, r517, r515, r518, r511, r513, r512, r514, r510, r617, r618, r613, r619, r614, r615, r616, r612, r611, r610, r713, r712, r711, r710, null);
        L5:
            List r178 = null;
            int r179 = 0;
            BotCommentInfo r180 = null;
            LikeInfo r181 = null;
            String r182 = null;
            String r183 = null;
            List r184 = null;
            String r185 = null;
            List r186 = null;
            CallImgConfig r187 = null;
            Map r188 = null;
            ShareInfo r320 = null;
            String r321 = null;
            String r420 = null;
            Integer r421 = null;
            Integer r422 = null;
            ModelItem r423 = null;
            SpeakerVoice r424 = null;
            String r425 = null;
            Integer r426 = null;
            Boolean r427 = null;
            String r428 = null;
            String r520 = null;
            BgImageInfo r521 = null;
            String r522 = null;
            BotMemoryConfig r523 = null;
            List r620 = null;
            BotCreatorInfo r621 = null;
            ConversationPage r622 = null;
            Long r714 = null;
            Integer r715 = null;
            List r716 = null;
            String r717 = null;
            BotIconImage r718 = null;
            String r719 = null;
            Integer r720 = null;
            BotStatistic r721 = null;
            String r722 = null;
            String r723 = null;
            BotOnBoarding r810 = null;
            String r811 = null;
            FirstMet r812 = null;
            BotLoadingConfig r813 = null;
            String r814 = null;
            Map r815 = null;
            List r816 = null;
            List r817 = null;
            Boolean r818 = null;
            BotSwitchConfInfo r819 = null;
            List r910 = null;
            String r911 = null;
            String r912 = null;
            String r913 = null;
            Boolean r914 = null;
            SceneModelList r915 = null;
            List r916 = null;
            List r917 = null;
            String r918 = null;
            long r524 = 0;
            int r322 = 0;
            boolean r323 = false;
            int r429 = 0;
            boolean r525 = false;
            boolean r526 = true;
            String r189 = null;
            MessagePushSwitchConfirmTitle r190 = null;
        L6:
            if (r526 == false) goto L117;
            r182 = r182;
            int r191 = r101.decodeElementIndex(r100);
            switch(r191) {
                case -1: goto L113;
                case 0: goto L111;
                case 1: goto L107;
                case 2: goto L105;
                case 3: goto L103;
                case 4: goto L102;
                case 5: goto L100;
                case 6: goto L99;
                case 7: goto L98;
                case 8: goto L97;
                case 9: goto L93;
                case 10: goto L92;
                case 11: goto L90;
                case 12: goto L88;
                case 13: goto L86;
                case 14: goto L85;
                case 15: goto L83;
                case 16: goto L82;
                case 17: goto L81;
                case 18: goto L76;
                case 19: goto L75;
                case 20: goto L73;
                case 21: goto L71;
                case 22: goto L70;
                case 23: goto L69;
                case 24: goto L68;
                case 25: goto L67;
                case 26: goto L66;
                case 27: goto L63;
                case 28: goto L62;
                case 29: goto L61;
                case 30: goto L60;
                case 31: goto L59;
                case 32: goto L58;
                case 33: goto L57;
                case 34: goto L49;
                case 35: goto L46;
                case 36: goto L45;
                case 37: goto L44;
                case 38: goto L42;
                case 39: goto L40;
                case 40: goto L39;
                case 41: goto L38;
                case 42: goto L36;
                case 43: goto L35;
                case 44: goto L34;
                case 45: goto L32;
                case 46: goto L30;
                case 47: goto L29;
                case 48: goto L28;
                case 49: goto L27;
                case 50: goto L25;
                case 51: goto L24;
                case 52: goto L23;
                case 53: goto L21;
                case 54: goto L20;
                case 55: goto L19;
                case 56: goto L17;
                case 57: goto L16;
                case 58: goto L15;
                case 59: goto L14;
                case 60: goto L13;
                case 61: goto L12;
                case 62: goto L11;
                default: goto L10;
            };
        L11:
            r188 = (Map) r101.decodeNullableSerializableElement(r100, 62, (juc.c) r102[62].getValue(), r188);
            int r192 = 1073741824;
        L18:
            int r193 = r179 | r192;
            Unit r194 = Unit.INSTANCE;
            r813 = r813;
        L37:
            r180 = r180;
            r912 = r912;
            r814 = r814;
        L51:
            r911 = r911;
        L52:
            String r195 = r185;
        L53:
            r182 = r182;
        L54:
            r813 = r813;
        L55:
            r185 = r195;
            Map r196 = r188;
            List r197 = r184;
            CallImgConfig r198 = r187;
            String r199 = r428;
            r179 = r193;
            MessagePushSwitchConfirmTitle r1100 = r190;
        L80:
            r102 = r102;
            Integer r1101 = r426;
            r189 = r189;
            r190 = r1100;
            r187 = r198;
            r188 = r196;
            r320 = r320;
            r321 = r321;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r423 = r423;
            r424 = r424;
            String r1102 = r425;
            r179 = r179;
            r620 = r620;
            BotCreatorInfo r324 = r621;
            r622 = r622;
            r714 = r714;
            r715 = r715;
            List r221 = r716;
            r718 = r718;
            String r222 = r719;
            r428 = r199;
            r184 = r197;
            r185 = r185;
        L116:
            r425 = r1102;
            r426 = r1101;
            r424 = r424;
            r423 = r423;
            r422 = r422;
            r716 = r221;
            r421 = r421;
            r420 = r420;
            r321 = r321;
            r719 = r222;
            r718 = r718;
            r714 = r714;
            r715 = r715;
            r320 = r320;
            r621 = r324;
            r620 = r620;
            r102 = r102;
            r622 = r622;
            goto L6
        L12:
            r180 = (BotCommentInfo) r101.decodeNullableSerializableElement(r100, 61, BotCommentInfo.a.f349775a, r180);
            int r200 = 536870912;
        L22:
            r193 = r179 | r200;
            Unit r201 = Unit.INSTANCE;
        L26:
            r813 = r813;
            r911 = r911;
            goto L51
        L13:
            r186 = (List) r101.decodeNullableSerializableElement(r100, 60, (juc.c) r102[60].getValue(), r186);
            r192 = 268435456;
            goto L18
        L14:
            r183 = (String) r101.decodeNullableSerializableElement(r100, 59, v2.f520790a, r183);
            r200 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
            goto L22
        L15:
            r181 = (LikeInfo) r101.decodeNullableSerializableElement(r100, 58, LikeInfo.a.f349784a, r181);
            r200 = 67108864;
            goto L22
        L16:
            r178 = (List) r101.decodeNullableSerializableElement(r100, 57, (juc.c) r102[57].getValue(), r178);
            r192 = 33554432;
            goto L18
        L17:
            r184 = (List) r101.decodeNullableSerializableElement(r100, 56, (juc.c) r102[56].getValue(), r184);
            r192 = 16777216;
            goto L18
        L19:
            r190 = (MessagePushSwitchConfirmTitle) r101.decodeNullableSerializableElement(r100, 55, MessagePushSwitchConfirmTitle.a.f346478a, r190);
            r200 = 8388608;
            goto L22
        L20:
            r189 = (String) r101.decodeNullableSerializableElement(r100, 54, v2.f520790a, r189);
            r200 = 4194304;
            goto L22
        L21:
            r187 = (CallImgConfig) r101.decodeNullableSerializableElement(r100, 53, CallImgConfig.a.f346453a, r187);
            r200 = 2097152;
            goto L22
        L23:
            r195 = (String) r101.decodeNullableSerializableElement(r100, 52, v2.f520790a, r185);
            r193 = r179 | 1048576;
            Unit r202 = Unit.INSTANCE;
            Boolean r820 = r914;
        L41:
            r180 = r180;
            r911 = r911;
            r912 = r912;
            r814 = r814;
            r915 = r915;
            r914 = r820;
            r812 = r812;
            goto L53
        L24:
            String r623 = r185;
            r182 = (String) r101.decodeNullableSerializableElement(r100, 51, v2.f520790a, r182);
            r193 = r179 | 524288;
            Unit r203 = Unit.INSTANCE;
        L43:
            r180 = r180;
            r195 = r623;
            r911 = r911;
            r912 = r912;
            r814 = r814;
            r915 = r915;
            r914 = r914;
            r812 = r812;
            goto L54
        L25:
            BotCommentInfo r527 = r180;
            r185 = r185;
            BotMemoryConfig r204 = (BotMemoryConfig) r101.decodeNullableSerializableElement(r100, 50, BotMemoryConfig.a.f346439a, r523);
            r193 = r179 | 262144;
            Unit r205 = Unit.INSTANCE;
            r523 = r204;
            r180 = r527;
            goto L26
        L27:
            BotCommentInfo r528 = r180;
            String r206 = (String) r101.decodeNullableSerializableElement(r100, 49, v2.f520790a, r522);
            r193 = r179 | 131072;
            Unit r207 = Unit.INSTANCE;
            r522 = r206;
            r182 = r182;
            r180 = r528;
            r195 = r185;
            r813 = r813;
            goto L54
        L28:
            BotCommentInfo r529 = r180;
            r185 = r185;
            r911 = (String) r101.decodeNullableSerializableElement(r100, 48, v2.f520790a, r911);
            r193 = r179 | 65536;
            Unit r208 = Unit.INSTANCE;
            r180 = r529;
            r813 = r813;
            goto L52
        L29:
            r911 = r911;
            BgImageInfo r209 = (BgImageInfo) r101.decodeNullableSerializableElement(r100, 47, BgImageInfo.a.f346423a, r521);
            r193 = r179 | 32768;
            Unit r223 = Unit.INSTANCE;
            r521 = r209;
        L31:
            r180 = r180;
        L33:
            r813 = r813;
            goto L51
        L30:
            r911 = r911;
            r912 = (String) r101.decodeNullableSerializableElement(r100, 46, v2.f520790a, r912);
            r193 = r179 | 16384;
            Unit r224 = Unit.INSTANCE;
            goto L31
        L32:
            BotCommentInfo r530 = r180;
            r185 = r185;
            r911 = r911;
            r814 = (String) r101.decodeNullableSerializableElement(r100, 45, v2.f520790a, r814);
            r193 = r179 | 8192;
            Unit r225 = Unit.INSTANCE;
            r180 = r530;
            r912 = r912;
            goto L33
        L34:
            BotCommentInfo r531 = r180;
            r813 = (BotLoadingConfig) r101.decodeNullableSerializableElement(r100, 44, BotLoadingConfig.a.f349780a, r813);
            r193 = r179 | 4096;
            Unit r226 = Unit.INSTANCE;
            r182 = r182;
            r180 = r531;
            r195 = r185;
            r814 = r814;
            goto L55
        L35:
            r185 = r185;
            r813 = r813;
            r812 = (FirstMet) r101.decodeNullableSerializableElement(r100, 43, FirstMet.a.f346469a, r812);
            r193 = r179 | 2048;
            Unit r227 = Unit.INSTANCE;
            goto L37
        L36:
            r185 = r185;
            r813 = r813;
            boolean r228 = r101.decodeBooleanElement(r100, 42);
            r193 = r179 | 1024;
            Unit r229 = Unit.INSTANCE;
            r323 = r228;
            goto L37
        L38:
            r812 = r812;
            r915 = (SceneModelList) r101.decodeNullableSerializableElement(r100, 41, SceneModelList.a.f346490a, r915);
            r193 = r179 | 512;
        L47:
            Unit r230 = Unit.INSTANCE;
        L48:
            r812 = r812;
            goto L51
        L39:
            BotCommentInfo r532 = r180;
            r185 = r185;
            r813 = r813;
            r911 = r911;
            r914 = (Boolean) r101.decodeNullableSerializableElement(r100, 40, i.f520705a, r914);
            r193 = r179 | 256;
            Unit r231 = Unit.INSTANCE;
            r180 = r532;
            r915 = r915;
            goto L51
        L40:
            r820 = r914;
            r811 = (String) r101.decodeNullableSerializableElement(r100, 39, v2.f520790a, r811);
            r193 = r179 | 128;
            Unit r232 = Unit.INSTANCE;
            r195 = r185;
            goto L41
        L42:
            r623 = r185;
            r810 = (BotOnBoarding) r101.decodeNullableSerializableElement(r100, 38, BotOnBoarding.a.f346444a, r810);
            r193 = r179 | 64;
            Unit r233 = Unit.INSTANCE;
            r182 = r182;
            goto L43
        L44:
            r812 = r812;
            r819 = (BotSwitchConfInfo) r101.decodeNullableSerializableElement(r100, 37, BotSwitchConfInfo.a.f346449a, r819);
            r193 = r179 | 32;
            goto L47
        L45:
            BotSwitchConfInfo r821 = r819;
            r193 = r179 | 16;
            r520 = (String) r101.decodeNullableSerializableElement(r100, 36, v2.f520790a, r520);
        L50:
            Unit r234 = Unit.INSTANCE;
            r912 = r912;
            r814 = r814;
            r915 = r915;
            r914 = r914;
            r819 = r821;
            goto L48
        L46:
            r812 = r812;
            r723 = (String) r101.decodeNullableSerializableElement(r100, 35, v2.f520790a, r723);
            r193 = r179 | 8;
            goto L47
        L49:
            r821 = r819;
            r913 = (String) r101.decodeNullableSerializableElement(r100, 34, v2.f520790a, r913);
            r193 = r179 | 4;
            goto L50
        L57:
            r180 = r180;
            r185 = r185;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r914 = r914;
            r915 = r915;
            r913 = r913;
            r428 = (String) r101.decodeNullableSerializableElement(r100, 33, v2.f520790a, r428);
            int r235 = r179 | 2;
            Unit r236 = Unit.INSTANCE;
        L65:
            r179 = r235;
            String r237 = r428;
            Boolean r238 = r427;
        L79:
            r427 = r238;
            r197 = r184;
            r196 = r188;
            r180 = r180;
            r911 = r911;
            r912 = r912;
            r915 = r915;
            r914 = r914;
            r819 = r819;
            r913 = r913;
            r199 = r237;
            r198 = r187;
            r182 = r182;
            r814 = r814;
            r813 = r813;
            r812 = r812;
            r1100 = r190;
            goto L80
        L58:
            r180 = r180;
            r185 = r185;
            r428 = r428;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r913 = r913;
            r914 = r914;
            r915 = r915;
            int r239 = r101.decodeIntElement(r100, 32);
            r235 = r179 | 1;
            Unit r325 = Unit.INSTANCE;
            r322 = r239;
            goto L65
        L59:
            r815 = (Map) r101.decodeNullableSerializableElement(r100, 31, (juc.c) r102[31].getValue(), r815);
            int r240 = Integer.MIN_VALUE;
        L64:
            Unit r241 = Unit.INSTANCE;
            r429 = r429 | r240;
            r235 = r179;
            goto L65
        L60:
            r917 = (List) r101.decodeNullableSerializableElement(r100, 30, (juc.c) r102[30].getValue(), r917);
            r240 = 1073741824;
            goto L64
        L61:
            r180 = r180;
            r185 = r185;
            r428 = r428;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r913 = r913;
            r914 = r914;
            r915 = r915;
            r916 = (List) r101.decodeNullableSerializableElement(r100, 29, (juc.c) r102[29].getValue(), r916);
            Unit r242 = Unit.INSTANCE;
            r429 = r429 | 536870912;
            r235 = r179;
            r917 = r917;
            goto L65
        L62:
            r180 = r180;
            r185 = r185;
            r428 = r428;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r913 = r913;
            r914 = r914;
            r915 = r915;
            r817 = (List) r101.decodeNullableSerializableElement(r100, 28, (juc.c) r102[28].getValue(), r817);
            Unit r243 = Unit.INSTANCE;
            r429 = r429 | 268435456;
            r235 = r179;
            r916 = r916;
            goto L65
        L63:
            r816 = (List) r101.decodeNullableSerializableElement(r100, 27, (juc.c) r102[27].getValue(), r816);
            r240 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
            goto L64
        L66:
            r910 = (List) r101.decodeNullableSerializableElement(r100, 26, (juc.c) r102[26].getValue(), r910);
            int r244 = 67108864;
        L72:
            int r245 = r429 | r244;
            Unit r246 = Unit.INSTANCE;
            int r247 = r245;
            String r248 = r425;
        L77:
            r425 = r248;
            int r249 = r247;
        L78:
            r429 = r249;
            r917 = r917;
            r916 = r916;
            r237 = r428;
            r238 = r427;
            goto L79
        L67:
            r721 = (BotStatistic) r101.decodeNullableSerializableElement(r100, 25, BotStatistic.a.f346447a, r721);
            r244 = 33554432;
            goto L72
        L68:
            r722 = (String) r101.decodeNullableSerializableElement(r100, 24, v2.f520790a, r722);
            r244 = 16777216;
            goto L72
        L69:
            r918 = (String) r101.decodeNullableSerializableElement(r100, 23, v2.f520790a, r918);
            r244 = 8388608;
            goto L72
        L70:
            r427 = (Boolean) r101.decodeNullableSerializableElement(r100, 22, i.f520705a, r427);
            r918 = r918;
            r244 = 4194304;
            goto L72
        L71:
            r818 = (Boolean) r101.decodeNullableSerializableElement(r100, 21, i.f520705a, r818);
            r244 = 2097152;
            goto L72
        L73:
            r426 = (Integer) r101.decodeNullableSerializableElement(r100, 20, w0.f520792a, r426);
            r244 = 1048576;
            goto L72
        L75:
            r180 = r180;
            r185 = r185;
            r428 = r428;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r913 = r913;
            r914 = r914;
            r915 = r915;
            r916 = r916;
            r917 = r917;
            r179 = r179;
            r525 = r101.decodeBooleanElement(r100, 19);
            r249 = r429 | 524288;
            Unit r1103 = Unit.INSTANCE;
            goto L78
        L76:
            r180 = r180;
            r185 = r185;
            r428 = r428;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r913 = r913;
            r914 = r914;
            r915 = r915;
            r916 = r916;
            r917 = r917;
            r179 = r179;
            r248 = (String) r101.decodeNullableSerializableElement(r100, 18, v2.f520790a, r425);
            r247 = r429 | 262144;
            Unit r430 = Unit.INSTANCE;
            r426 = r426;
            goto L77
        L81:
            r180 = r180;
            r185 = r185;
            r425 = r425;
            r426 = r426;
            String r250 = r428;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r913 = r913;
            r914 = r914;
            r915 = r915;
            r916 = r916;
            r917 = r917;
            r918 = r918;
            r179 = r179;
            r428 = r250;
            SpeakerVoice r251 = (SpeakerVoice) r101.decodeNullableSerializableElement(r100, 17, SpeakerVoice.a.f346504a, r424);
            int r252 = r429 | 131072;
            Unit r431 = Unit.INSTANCE;
            r102 = r102;
            r181 = r181;
            r320 = r320;
            r321 = r321;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r423 = r423;
            r620 = r620;
            r324 = r621;
            r622 = r622;
            r714 = r714;
            r715 = r715;
            r716 = r716;
            r718 = r718;
        L109:
            r424 = r251;
            int r253 = r252;
        L110:
            r429 = r253;
            r179 = r179;
            r180 = r180;
            r915 = r915;
            r222 = r719;
            r914 = r914;
            r913 = r913;
            r917 = r917;
            r916 = r916;
            r918 = r918;
            r428 = r428;
        L114:
            r911 = r911;
            r912 = r912;
            r814 = r814;
            r812 = r812;
            r819 = r819;
            r1101 = r426;
            r813 = r813;
        L115:
            r1102 = r425;
            r185 = r185;
            LikeInfo r919 = r181;
            r221 = r716;
            r181 = r919;
            goto L116
        L82:
            r424 = r424;
            ModelItem r254 = (ModelItem) r101.decodeNullableSerializableElement(r100, 16, ModelItem.a.f346482a, r423);
            r252 = r429 | 65536;
            Unit r432 = Unit.INSTANCE;
            ModelItem r255 = r254;
            Integer r256 = r422;
        L84:
            r422 = r256;
            r181 = r181;
            ModelItem r257 = r255;
            r321 = r321;
            r420 = r420;
            r421 = r421;
            r622 = r622;
        L96:
            r102 = r102;
            r320 = r320;
            r620 = r620;
            r324 = r621;
            r714 = r714;
            r715 = r715;
            r716 = r716;
        L106:
            r423 = r257;
            r718 = r718;
        L108:
            r251 = r424;
            goto L109
        L83:
            r424 = r424;
            r255 = r423;
            r256 = (Integer) r101.decodeNullableSerializableElement(r100, 15, w0.f520792a, r422);
            r252 = r429 | 32768;
            Unit r433 = Unit.INSTANCE;
            goto L84
        L85:
            r422 = r422;
            r720 = (Integer) r101.decodeNullableSerializableElement(r100, 14, w0.f520792a, r720);
            int r258 = r429 | 16384;
            Unit r259 = Unit.INSTANCE;
            Integer r260 = r421;
        L87:
            int r261 = r258;
        L89:
            int r262 = r261;
            r420 = r420;
        L91:
            r421 = r260;
            r252 = r262;
            r321 = r321;
            r622 = r622;
        L95:
            r257 = r423;
            goto L96
        L86:
            r422 = r422;
            r260 = (Integer) r101.decodeNullableSerializableElement(r100, 13, w0.f520792a, r421);
            r258 = r429 | 8192;
            Unit r263 = Unit.INSTANCE;
            r720 = r720;
            goto L87
        L88:
            r180 = r180;
            r181 = r181;
            r185 = r185;
            r422 = r422;
            r423 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r428 = r428;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r913 = r913;
            r914 = r914;
            r915 = r915;
            r916 = r916;
            r917 = r917;
            r918 = r918;
            r179 = r179;
            String r264 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r420);
            r261 = r429 | 4096;
            Unit r265 = Unit.INSTANCE;
            r420 = r264;
            r260 = r421;
            goto L89
        L90:
            r180 = r180;
            r181 = r181;
            r185 = r185;
            r422 = r422;
            r423 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r428 = r428;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r913 = r913;
            r914 = r914;
            r915 = r915;
            r916 = r916;
            r917 = r917;
            r918 = r918;
            r179 = r179;
            r420 = r420;
            String r266 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r321);
            r262 = r429 | 2048;
            Unit r267 = Unit.INSTANCE;
            r321 = r266;
            r260 = r421;
            goto L91
        L92:
            r321 = r321;
            ConversationPage r624 = (ConversationPage) r101.decodeNullableSerializableElement(r100, 10, ConversationPage.a.f346464a, r622);
            Unit r268 = Unit.INSTANCE;
            int r269 = r429 | 1024;
            r622 = r624;
        L94:
            r252 = r269;
            r720 = r720;
            goto L95
        L93:
            r321 = r321;
            r622 = r622;
            r716 = (List) r101.decodeNullableSerializableElement(r100, 9, (juc.c) r102[9].getValue(), r716);
            r269 = r429 | 512;
            Unit r270 = Unit.INSTANCE;
            goto L94
        L97:
            r180 = r180;
            r181 = r181;
            r185 = r185;
            r321 = r321;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r423 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r428 = r428;
            r622 = r622;
            r716 = r716;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r913 = r913;
            r914 = r914;
            r915 = r915;
            r916 = r916;
            r917 = r917;
            r918 = r918;
            r179 = r179;
            r102 = r102;
            List r625 = (List) r101.decodeNullableSerializableElement(r100, 8, (juc.c) r102[8].getValue(), r620);
            r253 = r429 | 256;
            Unit r271 = Unit.INSTANCE;
            r320 = r320;
            r620 = r625;
            r324 = r621;
            r714 = r714;
            r715 = r715;
            r718 = r718;
            goto L110
        L98:
            r620 = r620;
            BotCreatorInfo r626 = (BotCreatorInfo) r101.decodeNullableSerializableElement(r100, 7, BotCreatorInfo.a.f346430a, r621);
            int r272 = r429 | 128;
            Unit r273 = Unit.INSTANCE;
            r324 = r626;
            r222 = r719;
        L112:
            r720 = r720;
            r182 = r182;
            r180 = r180;
            r915 = r915;
            r914 = r914;
            r913 = r913;
            r917 = r917;
            r916 = r916;
            r918 = r918;
            r429 = r272;
            r179 = r179;
            r911 = r911;
            r912 = r912;
            r814 = r814;
            r812 = r812;
            r819 = r819;
            r428 = r428;
            r813 = r813;
            r1101 = r426;
            goto L115
        L99:
            r324 = r621;
            ShareInfo r274 = (ShareInfo) r101.decodeNullableSerializableElement(r100, 6, ShareInfo.a.f346495a, r320);
            Unit r275 = Unit.INSTANCE;
            r320 = r274;
            r252 = r429 | 64;
        L101:
            r257 = r423;
            r720 = r720;
            r714 = r714;
            r715 = r715;
            goto L106
        L100:
            r324 = r621;
            r320 = r320;
            r715 = (Integer) r101.decodeNullableSerializableElement(r100, 5, w0.f520792a, r715);
            Unit r276 = Unit.INSTANCE;
            r252 = r429 | 32;
            goto L101
        L102:
            r102 = r102;
            r180 = r180;
            r181 = r181;
            r185 = r185;
            r320 = r320;
            r321 = r321;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r428 = r428;
            r620 = r620;
            r324 = r621;
            r622 = r622;
            r716 = r716;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r913 = r913;
            r914 = r914;
            r915 = r915;
            r916 = r916;
            r917 = r917;
            r918 = r918;
            r179 = r179;
            r715 = r715;
            Long r724 = (Long) r101.decodeNullableSerializableElement(r100, 4, g1.f520681a, r714);
            r252 = r429 | 16;
            Unit r277 = Unit.INSTANCE;
            r257 = r423;
            r714 = r724;
            goto L106
        L103:
            r102 = r102;
            r180 = r180;
            r181 = r181;
            r185 = r185;
            r320 = r320;
            r321 = r321;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r428 = r428;
            r620 = r620;
            r324 = r621;
            r622 = r622;
            r715 = r715;
            r716 = r716;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r913 = r913;
            r914 = r914;
            r915 = r915;
            r916 = r916;
            r917 = r917;
            r918 = r918;
            r179 = r179;
            r524 = r101.decodeLongElement(r100, 3);
            r252 = r429 | 8;
            Unit r278 = Unit.INSTANCE;
            r714 = r714;
            r257 = r423;
            goto L106
        L105:
            r102 = r102;
            r180 = r180;
            r181 = r181;
            r185 = r185;
            r320 = r320;
            r321 = r321;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r428 = r428;
            r620 = r620;
            r324 = r621;
            r622 = r622;
            r715 = r715;
            r716 = r716;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r913 = r913;
            r914 = r914;
            r915 = r915;
            r916 = r916;
            r917 = r917;
            r918 = r918;
            r179 = r179;
            r714 = r714;
            BotIconImage r279 = (BotIconImage) r101.decodeNullableSerializableElement(r100, 2, BotIconImage.a.f346435a, r718);
            r252 = r429 | 4;
            Unit r280 = Unit.INSTANCE;
            r718 = r279;
            r257 = r423;
            goto L106
        L107:
            r102 = r102;
            r180 = r180;
            r181 = r181;
            r185 = r185;
            r320 = r320;
            r321 = r321;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r423 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            r428 = r428;
            r620 = r620;
            r324 = r621;
            r622 = r622;
            r714 = r714;
            r715 = r715;
            r716 = r716;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            r913 = r913;
            r914 = r914;
            r915 = r915;
            r916 = r916;
            r917 = r917;
            r918 = r918;
            r179 = r179;
            r718 = r718;
            r719 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r719);
            Unit r281 = Unit.INSTANCE;
            r252 = r429 | 2;
            goto L108
        L111:
            r620 = r620;
            r324 = r621;
            r222 = r719;
            r717 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r717);
            r272 = r429 | 1;
            Unit r282 = Unit.INSTANCE;
            goto L112
        L113:
            r102 = r102;
            r181 = r181;
            r185 = r185;
            r320 = r320;
            r321 = r321;
            r420 = r420;
            r421 = r421;
            r422 = r422;
            r423 = r423;
            r424 = r424;
            r425 = r425;
            r426 = r426;
            String r1104 = r428;
            r620 = r620;
            r324 = r621;
            r622 = r622;
            r714 = r714;
            r715 = r715;
            r716 = r716;
            r718 = r718;
            r222 = r719;
            r812 = r812;
            r813 = r813;
            r814 = r814;
            r819 = r819;
            r911 = r911;
            r912 = r912;
            int r434 = r179;
            Unit r283 = Unit.INSTANCE;
            r179 = r434;
            r180 = r180;
            r526 = false;
            r429 = r429;
            r428 = r1104;
            goto L114
        L10:
            throw new UnknownFieldException(r191);
        L117:
            BotCommentInfo r533 = r180;
            LikeInfo r284 = r181;
            String r534 = r182;
            String r627 = r185;
            ShareInfo r326 = r320;
            String r285 = r420;
            Integer r286 = r421;
            Integer r287 = r422;
            ModelItem r288 = r423;
            SpeakerVoice r1105 = r424;
            Integer r1106 = r426;
            int r289 = r429;
            List r327 = r620;
            BotCreatorInfo r328 = r621;
            ConversationPage r329 = r622;
            Long r290 = r714;
            Integer r330 = r715;
            List r291 = r716;
            String r292 = r717;
            BotLoadingConfig r628 = r813;
            r713 = r183;
            r612 = r184;
            r212 = r425;
            r712 = r186;
            r611 = r178;
            r710 = r188;
            r413 = r428;
            r610 = r284;
            r217 = r321;
            r167 = r719;
            r177 = r290;
            r176 = r330;
            r173 = r328;
            r411 = r322;
            r218 = r720;
            r172 = r179;
            r319 = r525;
            r711 = r533;
            r510 = r911;
            r512 = r912;
            r315 = r721;
            r417 = r723;
            r415 = r810;
            r519 = r811;
            r412 = r819;
            r414 = r913;
            r418 = r815;
            r313 = r816;
            r312 = r817;
            r317 = r818;
            r416 = r917;
            r419 = r916;
            r310 = r918;
            r168 = r292;
            r171 = r289;
            r216 = r1105;
            r214 = r287;
            r175 = r327;
            r219 = r329;
            r318 = r427;
            r410 = r520;
            r618 = r523;
            r613 = r534;
            r518 = r812;
            r316 = r722;
            r516 = r914;
            r615 = r189;
            r170 = r718;
            r514 = r521;
            r517 = r915;
            r616 = r190;
            r213 = r288;
            r215 = r291;
            r614 = r187;
            r174 = r524;
            r513 = r814;
            r511 = r628;
            r619 = r627;
            r617 = r522;
            r515 = r323;
            r314 = r910;
            r311 = r1106;
            r169 = r326;
            r220 = r286;
            r211 = r285;
            goto L118
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            BotModel r102 = (BotModel) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346442b;
            muc.d r104 = r100.beginStructure(r103);
            BotModel.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<BotModel> serializer() {
            return a.f346441a;
        }
    }

    public BotModel() {
        this(null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, Integer.MAX_VALUE, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(ShowTagInfo.a.f346500a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        return new nuc.f(SelectTextAction.a.f346493a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$1() {
        return new nuc.f(AnswerAction.a.f346417a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$10() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$2() {
        return new nuc.f(v2.f520790a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$3() {
        return new nuc.f(AnswerAction.a.f346417a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$4() {
        return new nuc.f(AnswerAction.a.f346417a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$5() {
        return new nuc.f(BotConfItem.a.f346427a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$6() {
        return new a1(v2.f520790a, CameraTabConfig.a.f346458a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$7() {
        return new nuc.f(MsgRegenMode.a.f346484a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$8() {
        return new nuc.f(w0.f520792a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$9() {
        return new nuc.f(BotActionScene.a.f349769a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_$1();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_$2();
    }

    public static /* synthetic */ d c() {
        return _childSerializers$_anonymous_$0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BotModel copy$default(BotModel r210, String r211, String r212, BotIconImage r213, long r214, Long r310, Integer r311, ShareInfo r312, BotCreatorInfo r313, List r314, List r315, ConversationPage r316, String r317, String r318, Integer r319, Integer r410, Integer r411, ModelItem r412, SpeakerVoice r413, String r414, boolean r415, Integer r416, Boolean r417, Boolean r418, String r419, String r510, BotStatistic r511, List r512, List r513, List r514, List r515, List r516, Map r517, int r518, String r519, String r610, String r611, String r612, BotSwitchConfInfo r613, BotOnBoarding r614, String r615, Boolean r616, SceneModelList r617, boolean r618, FirstMet r619, BotLoadingConfig r710, String r711, String r712, BgImageInfo r713, String r714, String r715, BotMemoryConfig r716, String r717, String r718, CallImgConfig r719, String r810, MessagePushSwitchConfirmTitle r811, List r812, List r813, LikeInfo r814, String r815, List r816, BotCommentInfo r817, Map r818, int r819, int r910, Object r911) {
        if ((r819 & 1) == 0) goto L5;
        String r100 = r210.botId;
    L7:
        if ((r819 & 2) == 0) goto L9;
        String r101 = r210.name;
    L11:
        if ((r819 & 4) == 0) goto L13;
        BotIconImage r102 = r210.iconImage;
    L15:
        if ((r819 & 8) == 0) goto L17;
        long r103 = r210.createTime;
    L19:
        if ((r819 & 16) == 0) goto L21;
        Long r104 = r210.updateTime;
    L23:
        if ((r819 & 32) == 0) goto L25;
        Integer r105 = r210.botType;
    L27:
        if ((r819 & 64) == 0) goto L29;
        ShareInfo r110 = r210.shareInfo;
    L31:
        if ((r819 & 128) == 0) goto L33;
        BotCreatorInfo r111 = r210.botCreatorInfo;
    L35:
        if ((r819 & 256) == 0) goto L37;
        List r112 = r210.tagList;
    L39:
        if ((r819 & 512) == 0) goto L41;
        List r113 = r210.selectTextActions;
    L43:
        if ((r819 & 1024) == 0) goto L45;
        ConversationPage r114 = r210.conversationPage;
    L47:
        if ((r819 & 2048) == 0) goto L49;
        String r115 = r210.descriptionForModel;
    L50:
        String r320 = r115;
        if ((r819 & 4096) == 0) goto L53;
        String r116 = r210.descriptionForHuman;
    L54:
        String r321 = r116;
        if ((r819 & 8192) == 0) goto L57;
        Integer r117 = r210.botStatus;
    L58:
        Integer r322 = r117;
        if ((r819 & 16384) == 0) goto L61;
        Integer r118 = r210.botRecommendStatus;
    L62:
        Integer r420 = r118;
        if ((r819 & 32768) == 0) goto L65;
        Integer r119 = r210.privateStatus;
    L66:
        Integer r421 = r119;
        if ((r819 & 65536) == 0) goto L69;
        ModelItem r120 = r210.model;
    L70:
        ModelItem r422 = r120;
        if ((r819 & 131072) == 0) goto L73;
        SpeakerVoice r121 = r210.voiceType;
    L74:
        SpeakerVoice r423 = r121;
        if ((r819 & 262144) == 0) goto L77;
        String r122 = r210.editPos;
    L78:
        String r424 = r122;
        if ((r819 & 524288) == 0) goto L81;
        boolean r123 = r210.muted;
    L82:
        boolean r425 = r123;
        if ((r819 & 1048576) == 0) goto L85;
        Integer r124 = r210.recommendIndex;
    L86:
        Integer r426 = r124;
        if ((r819 & 2097152) == 0) goto L89;
        Boolean r125 = r210.messagePush;
    L90:
        Boolean r427 = r125;
        if ((r819 & 4194304) == 0) goto L93;
        Boolean r126 = r210.showMessagePush;
    L94:
        Boolean r428 = r126;
        if ((r819 & 8388608) == 0) goto L97;
        String r127 = r210.bioEdit;
    L98:
        String r429 = r127;
        if ((r819 & 16777216) == 0) goto L101;
        String r128 = r210.bio;
    L102:
        String r520 = r128;
        if ((r819 & 33554432) == 0) goto L105;
        BotStatistic r129 = r210.botStatic;
    L106:
        BotStatistic r521 = r129;
        if ((r819 & 67108864) == 0) goto L109;
        List r130 = r210.answerActions;
    L110:
        List r522 = r130;
        if ((r819 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        List r131 = r210.answerActionExposurePriority;
    L114:
        List r523 = r131;
        if ((r819 & 268435456) == 0) goto L117;
        List r132 = r210.menuActions;
    L118:
        List r524 = r132;
        if ((r819 & 536870912) == 0) goto L121;
        List r133 = r210.streamingAnswerActions;
    L122:
        List r525 = r133;
        if ((r819 & 1073741824) == 0) goto L125;
        List r134 = r210.botConf;
    L127:
        if ((r819 & Integer.MIN_VALUE) == 0) goto L129;
        Map r106 = r210.cameraTabConfigMap;
    L130:
        Map r526 = r106;
        if ((r910 & 1) == 0) goto L133;
        int r107 = r210.botMode;
    L134:
        int r527 = r107;
        if ((r910 & 2) == 0) goto L137;
        String r108 = r210.bgImgUrl;
    L138:
        String r528 = r108;
        if ((r910 & 4) == 0) goto L141;
        String r109 = r210.bgImgColor;
    L142:
        String r620 = r109;
        if ((r910 & 8) == 0) goto L145;
        String r135 = r210.bgVideoModel;
    L146:
        String r621 = r135;
        if ((r910 & 16) == 0) goto L149;
        String r136 = r210.iconPrompt;
    L150:
        String r622 = r136;
        if ((r910 & 32) == 0) goto L153;
        BotSwitchConfInfo r137 = r210.switchConfInfo;
    L154:
        BotSwitchConfInfo r623 = r137;
        if ((r910 & 64) == 0) goto L157;
        BotOnBoarding r138 = r210.onBoarding;
    L158:
        BotOnBoarding r624 = r138;
        if ((r910 & 128) == 0) goto L161;
        String r139 = r210.callerName;
    L162:
        String r625 = r139;
        if ((r910 & 256) == 0) goto L165;
        Boolean r140 = r210.callerNameSetting;
    L166:
        Boolean r626 = r140;
        if ((r910 & 512) == 0) goto L169;
        SceneModelList r141 = r210.sceneModelList;
    L170:
        SceneModelList r627 = r141;
        if ((r910 & 1024) == 0) goto L173;
        boolean r142 = r210.disabled;
    L174:
        boolean r628 = r142;
        if ((r910 & 2048) == 0) goto L177;
        FirstMet r143 = r210.firstMet;
    L178:
        FirstMet r629 = r143;
        if ((r910 & 4096) == 0) goto L181;
        BotLoadingConfig r144 = r210.loadingConf;
    L182:
        BotLoadingConfig r720 = r144;
        if ((r910 & 8192) == 0) goto L185;
        String r145 = r210.botFeatureLabel;
    L186:
        String r721 = r145;
        if ((r910 & 16384) == 0) goto L189;
        String r146 = r210.bgImgUri;
    L190:
        String r722 = r146;
        if ((r910 & 32768) == 0) goto L193;
        BgImageInfo r147 = r210.bgImgInfo;
    L194:
        BgImageInfo r723 = r147;
        if ((r910 & 65536) == 0) goto L197;
        String r148 = r210.userBotGender;
    L198:
        String r724 = r148;
        if ((r910 & 131072) == 0) goto L201;
        String r149 = r210.userBotType;
    L202:
        String r725 = r149;
        if ((r910 & 262144) == 0) goto L205;
        BotMemoryConfig r150 = r210.botMemoryConfig;
    L206:
        BotMemoryConfig r726 = r150;
        if ((r910 & 524288) == 0) goto L209;
        String r151 = r210.dynamicImgUri;
    L210:
        String r727 = r151;
        if ((r910 & 1048576) == 0) goto L213;
        String r152 = r210.dynamicImgUrl;
    L214:
        String r728 = r152;
        if ((r910 & 2097152) == 0) goto L217;
        CallImgConfig r153 = r210.callImgConfig;
    L218:
        CallImgConfig r729 = r153;
        if ((r910 & 4194304) == 0) goto L221;
        String r154 = r210.botIconMappedAppIcon;
    L222:
        String r820 = r154;
        if ((r910 & 8388608) == 0) goto L225;
        MessagePushSwitchConfirmTitle r155 = r210.messagePushSwitchConfirmTitle;
    L226:
        MessagePushSwitchConfirmTitle r821 = r155;
        if ((r910 & 16777216) == 0) goto L229;
        List r156 = r210.msgRegenModeList;
    L230:
        List r822 = r156;
        if ((r910 & 33554432) == 0) goto L233;
        List r157 = r210.unavailableInstructionTypeList;
    L234:
        List r823 = r157;
        if ((r910 & 67108864) == 0) goto L237;
        LikeInfo r158 = r210.likeInfo;
    L238:
        LikeInfo r824 = r158;
        if ((r910 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        String r159 = r210.serviceBotConf;
    L242:
        String r825 = r159;
        if ((r910 & 268435456) == 0) goto L245;
        List r160 = r210.actionScenes;
    L246:
        List r826 = r160;
        if ((r910 & 536870912) == 0) goto L249;
        BotCommentInfo r161 = r210.commentInfo;
    L251:
        if ((r910 & 1073741824) == 0) goto L253;
        Map r162 = r210.extra;
    L255:
        return r210.copy(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r320, r321, r322, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r520, r521, r522, r523, r524, r525, r134, r526, r527, r528, r620, r621, r622, r623, r624, r625, r626, r627, r628, r629, r720, r721, r722, r723, r724, r725, r726, r727, r728, r729, r820, r821, r822, r823, r824, r825, r826, r161, r162);
    L253:
        r162 = r818;
        goto L255
    L249:
        r161 = r817;
        goto L251
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

    public static /* synthetic */ d d() {
        return _childSerializers$_anonymous_$8();
    }

    public static /* synthetic */ d e() {
        return _childSerializers$_anonymous_$6();
    }

    public static /* synthetic */ d f() {
        return _childSerializers$_anonymous_$3();
    }

    public static /* synthetic */ d g() {
        return _childSerializers$_anonymous_();
    }

    @SerialName("action_scenes")
    public static /* synthetic */ void getActionScenes$annotations() {
    }

    @SerialName("answer_action_exposure_priority")
    public static /* synthetic */ void getAnswerActionExposurePriority$annotations() {
    }

    @SerialName("answer_actions")
    public static /* synthetic */ void getAnswerActions$annotations() {
    }

    @SerialName("bg_img_avg_hue")
    public static /* synthetic */ void getBgImgColor$annotations() {
    }

    @SerialName("bg_img_info")
    public static /* synthetic */ void getBgImgInfo$annotations() {
    }

    @SerialName("bg_img_uri")
    public static /* synthetic */ void getBgImgUri$annotations() {
    }

    @SerialName("bg_img_url")
    public static /* synthetic */ void getBgImgUrl$annotations() {
    }

    @SerialName("bg_video_model")
    public static /* synthetic */ void getBgVideoModel$annotations() {
    }

    @SerialName("bio")
    public static /* synthetic */ void getBio$annotations() {
    }

    @SerialName("user_edit_bio")
    public static /* synthetic */ void getBioEdit$annotations() {
    }

    @SerialName("bot_conf")
    public static /* synthetic */ void getBotConf$annotations() {
    }

    @SerialName("creator_info")
    public static /* synthetic */ void getBotCreatorInfo$annotations() {
    }

    @SerialName("bot_feature_label")
    public static /* synthetic */ void getBotFeatureLabel$annotations() {
    }

    @SerialName("bot_icon_mapped_app_icon")
    public static /* synthetic */ void getBotIconMappedAppIcon$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getBotId$annotations() {
    }

    @SerialName("bot_memory_config")
    public static /* synthetic */ void getBotMemoryConfig$annotations() {
    }

    @SerialName("bot_mode")
    public static /* synthetic */ void getBotMode$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getBotRecommendStatus$annotations() {
    }

    @SerialName("bot_stats")
    public static /* synthetic */ void getBotStatic$annotations() {
    }

    @SerialName("bot_type")
    public static /* synthetic */ void getBotType$annotations() {
    }

    @SerialName("phone_call_img")
    public static /* synthetic */ void getCallImgConfig$annotations() {
    }

    @SerialName(Constant.KEY_CALL_NAME)
    public static /* synthetic */ void getCallerName$annotations() {
    }

    @SerialName("caller_name_setting")
    public static /* synthetic */ void getCallerNameSetting$annotations() {
    }

    @SerialName("camera_tab_config_map")
    public static /* synthetic */ void getCameraTabConfigMap$annotations() {
    }

    @SerialName("comment_info")
    public static /* synthetic */ void getCommentInfo$annotations() {
    }

    @SerialName(CommentPublishScene.CONVERSATION_PAGE)
    public static /* synthetic */ void getConversationPage$annotations() {
    }

    @SerialName("create_time")
    public static /* synthetic */ void getCreateTime$annotations() {
    }

    @SerialName("description_for_human")
    public static /* synthetic */ void getDescriptionForHuman$annotations() {
    }

    @SerialName("description_for_model")
    public static /* synthetic */ void getDescriptionForModel$annotations() {
    }

    @SerialName("disabled")
    public static /* synthetic */ void getDisabled$annotations() {
    }

    @SerialName("dynamic_img_uri")
    public static /* synthetic */ void getDynamicImgUri$annotations() {
    }

    @SerialName("dynamic_img_url")
    public static /* synthetic */ void getDynamicImgUrl$annotations() {
    }

    @SerialName("edit_pos")
    public static /* synthetic */ void getEditPos$annotations() {
    }

    @SerialName("extra")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName("first_met")
    public static /* synthetic */ void getFirstMet$annotations() {
    }

    @SerialName("icon_image")
    public static /* synthetic */ void getIconImage$annotations() {
    }

    @SerialName("icon_prompt")
    public static /* synthetic */ void getIconPrompt$annotations() {
    }

    @SerialName("like_info")
    public static /* synthetic */ void getLikeInfo$annotations() {
    }

    @SerialName("loading_conf")
    public static /* synthetic */ void getLoadingConf$annotations() {
    }

    @SerialName("hover_answer_actions")
    public static /* synthetic */ void getMenuActions$annotations() {
    }

    @SerialName("message_push")
    public static /* synthetic */ void getMessagePush$annotations() {
    }

    @SerialName("message_push_switch_confirm_title")
    public static /* synthetic */ void getMessagePushSwitchConfirmTitle$annotations() {
    }

    @SerialName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    public static /* synthetic */ void getModel$annotations() {
    }

    @SerialName("msg_regen_mode_list")
    public static /* synthetic */ void getMsgRegenModeList$annotations() {
    }

    @SerialName("muted")
    public static /* synthetic */ void getMuted$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("onboarding")
    public static /* synthetic */ void getOnBoarding$annotations() {
    }

    @SerialName("private_status")
    public static /* synthetic */ void getPrivateStatus$annotations() {
    }

    @SerialName("recommend_index")
    public static /* synthetic */ void getRecommendIndex$annotations() {
    }

    @SerialName("call_model_list")
    public static /* synthetic */ void getSceneModelList$annotations() {
    }

    @SerialName("select_text_actions")
    public static /* synthetic */ void getSelectTextActions$annotations() {
    }

    @SerialName("service_bot_conf")
    public static /* synthetic */ void getServiceBotConf$annotations() {
    }

    @SerialName("share_info")
    public static /* synthetic */ void getShareInfo$annotations() {
    }

    @SerialName("show_message_push")
    public static /* synthetic */ void getShowMessagePush$annotations() {
    }

    @SerialName("streaming_answer_actions")
    public static /* synthetic */ void getStreamingAnswerActions$annotations() {
    }

    @SerialName("switch_conf")
    public static /* synthetic */ void getSwitchConfInfo$annotations() {
    }

    @SerialName("show_tag_info_list")
    public static /* synthetic */ void getTagList$annotations() {
    }

    @SerialName("unavailable_instruction_type_list")
    public static /* synthetic */ void getUnavailableInstructionTypeList$annotations() {
    }

    @SerialName("update_time")
    public static /* synthetic */ void getUpdateTime$annotations() {
    }

    @SerialName("user_bot_gender_starling_key")
    public static /* synthetic */ void getUserBotGender$annotations() {
    }

    @SerialName("user_bot_type_starling_key")
    public static /* synthetic */ void getUserBotType$annotations() {
    }

    @SerialName("voice_type")
    public static /* synthetic */ void getVoiceType$annotations() {
    }

    public static /* synthetic */ d h() {
        return _childSerializers$_anonymous_$9();
    }

    public static /* synthetic */ d i() {
        return _childSerializers$_anonymous_$7();
    }

    public static /* synthetic */ d j() {
        return _childSerializers$_anonymous_$10();
    }

    public static /* synthetic */ d k() {
        return _childSerializers$_anonymous_$5();
    }

    public static /* synthetic */ d l() {
        return _childSerializers$_anonymous_$4();
    }

    public final String component1() {
        return this.botId;
    }

    public final List<SelectTextAction> component10() {
        return this.selectTextActions;
    }

    public final ConversationPage component11() {
        return this.conversationPage;
    }

    public final String component12() {
        return this.descriptionForModel;
    }

    public final String component13() {
        return this.descriptionForHuman;
    }

    public final Integer component14() {
        return this.botStatus;
    }

    public final Integer component15() {
        return this.botRecommendStatus;
    }

    public final Integer component16() {
        return this.privateStatus;
    }

    public final ModelItem component17() {
        return this.model;
    }

    public final SpeakerVoice component18() {
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
        return this.bioEdit;
    }

    public final String component25() {
        return this.bio;
    }

    public final BotStatistic component26() {
        return this.botStatic;
    }

    public final List<AnswerAction> component27() {
        return this.answerActions;
    }

    public final List<String> component28() {
        return this.answerActionExposurePriority;
    }

    public final List<AnswerAction> component29() {
        return this.menuActions;
    }

    public final BotIconImage component3() {
        return this.iconImage;
    }

    public final List<AnswerAction> component30() {
        return this.streamingAnswerActions;
    }

    public final List<BotConfItem> component31() {
        return this.botConf;
    }

    public final Map<String, CameraTabConfig> component32() {
        return this.cameraTabConfigMap;
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

    public final BotSwitchConfInfo component38() {
        return this.switchConfInfo;
    }

    public final BotOnBoarding component39() {
        return this.onBoarding;
    }

    public final long component4() {
        return this.createTime;
    }

    public final String component40() {
        return this.callerName;
    }

    public final Boolean component41() {
        return this.callerNameSetting;
    }

    public final SceneModelList component42() {
        return this.sceneModelList;
    }

    public final boolean component43() {
        return this.disabled;
    }

    public final FirstMet component44() {
        return this.firstMet;
    }

    public final BotLoadingConfig component45() {
        return this.loadingConf;
    }

    public final String component46() {
        return this.botFeatureLabel;
    }

    public final String component47() {
        return this.bgImgUri;
    }

    public final BgImageInfo component48() {
        return this.bgImgInfo;
    }

    public final String component49() {
        return this.userBotGender;
    }

    public final Long component5() {
        return this.updateTime;
    }

    public final String component50() {
        return this.userBotType;
    }

    public final BotMemoryConfig component51() {
        return this.botMemoryConfig;
    }

    public final String component52() {
        return this.dynamicImgUri;
    }

    public final String component53() {
        return this.dynamicImgUrl;
    }

    public final CallImgConfig component54() {
        return this.callImgConfig;
    }

    public final String component55() {
        return this.botIconMappedAppIcon;
    }

    public final MessagePushSwitchConfirmTitle component56() {
        return this.messagePushSwitchConfirmTitle;
    }

    public final List<MsgRegenMode> component57() {
        return this.msgRegenModeList;
    }

    public final List<Integer> component58() {
        return this.unavailableInstructionTypeList;
    }

    public final LikeInfo component59() {
        return this.likeInfo;
    }

    public final Integer component6() {
        return this.botType;
    }

    public final String component60() {
        return this.serviceBotConf;
    }

    public final List<BotActionScene> component61() {
        return this.actionScenes;
    }

    public final BotCommentInfo component62() {
        return this.commentInfo;
    }

    public final Map<String, String> component63() {
        return this.extra;
    }

    public final ShareInfo component7() {
        return this.shareInfo;
    }

    public final BotCreatorInfo component8() {
        return this.botCreatorInfo;
    }

    public final List<ShowTagInfo> component9() {
        return this.tagList;
    }

    public final BotModel copy(String r610, String r611, BotIconImage r612, long r710, Long r711, @BotSourceType Integer r712, ShareInfo r713, BotCreatorInfo r714, List<ShowTagInfo> r715, List<SelectTextAction> r716, ConversationPage r717, String r718, String r810, Integer r811, @Status Integer r812, Integer r813, ModelItem r814, SpeakerVoice r815, String r816, boolean r817, Integer r818, Boolean r819, Boolean r910, String r911, String r912, BotStatistic r913, List<AnswerAction> r914, List<String> r915, List<AnswerAction> r916, List<AnswerAction> r917, List<BotConfItem> r918, Map<String, CameraTabConfig> r919, int r100, String r101, String r102, String r103, String r104, BotSwitchConfInfo r105, BotOnBoarding r106, String r107, Boolean r108, SceneModelList r109, boolean r110, FirstMet r111, BotLoadingConfig r112, String r113, String r114, BgImageInfo r115, String r116, String r117, BotMemoryConfig r118, String r119, String r120, CallImgConfig r121, String r122, MessagePushSwitchConfirmTitle r123, List<MsgRegenMode> r124, List<Integer> r125, LikeInfo r126, String r127, List<BotActionScene> r128, BotCommentInfo r129, Map<String, String> r130) {
        return new BotModel(r610, r611, r612, r710, r711, r712, r713, r714, r715, r716, r717, r718, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotModel) == true) goto L8;
        return false;
    L8:
        BotModel r101 = (BotModel) r100;
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
        if (Intrinsics.areEqual(this.conversationPage, r101.conversationPage) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.descriptionForModel, r101.descriptionForModel) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.descriptionForHuman, r101.descriptionForHuman) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.botStatus, r101.botStatus) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.botRecommendStatus, r101.botRecommendStatus) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.privateStatus, r101.privateStatus) == true) goto L57;
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
        if (Intrinsics.areEqual(this.bioEdit, r101.bioEdit) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.bio, r101.bio) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.botStatic, r101.botStatic) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.answerActions, r101.answerActions) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.answerActionExposurePriority, r101.answerActionExposurePriority) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.menuActions, r101.menuActions) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.streamingAnswerActions, r101.streamingAnswerActions) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.botConf, r101.botConf) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.cameraTabConfigMap, r101.cameraTabConfigMap) == true) goto L105;
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
        if (Intrinsics.areEqual(this.onBoarding, r101.onBoarding) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.callerName, r101.callerName) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.callerNameSetting, r101.callerNameSetting) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.sceneModelList, r101.sceneModelList) == true) goto L135;
        return false;
    L135:
        if (this.disabled == r101.disabled) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.firstMet, r101.firstMet) == true) goto L141;
        return false;
    L141:
        if (Intrinsics.areEqual(this.loadingConf, r101.loadingConf) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.botFeatureLabel, r101.botFeatureLabel) == true) goto L147;
        return false;
    L147:
        if (Intrinsics.areEqual(this.bgImgUri, r101.bgImgUri) == true) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.bgImgInfo, r101.bgImgInfo) == true) goto L153;
        return false;
    L153:
        if (Intrinsics.areEqual(this.userBotGender, r101.userBotGender) == true) goto L156;
        return false;
    L156:
        if (Intrinsics.areEqual(this.userBotType, r101.userBotType) == true) goto L159;
        return false;
    L159:
        if (Intrinsics.areEqual(this.botMemoryConfig, r101.botMemoryConfig) == true) goto L162;
        return false;
    L162:
        if (Intrinsics.areEqual(this.dynamicImgUri, r101.dynamicImgUri) == true) goto L165;
        return false;
    L165:
        if (Intrinsics.areEqual(this.dynamicImgUrl, r101.dynamicImgUrl) == true) goto L168;
        return false;
    L168:
        if (Intrinsics.areEqual(this.callImgConfig, r101.callImgConfig) == true) goto L171;
        return false;
    L171:
        if (Intrinsics.areEqual(this.botIconMappedAppIcon, r101.botIconMappedAppIcon) == true) goto L174;
        return false;
    L174:
        if (Intrinsics.areEqual(this.messagePushSwitchConfirmTitle, r101.messagePushSwitchConfirmTitle) == true) goto L177;
        return false;
    L177:
        if (Intrinsics.areEqual(this.msgRegenModeList, r101.msgRegenModeList) == true) goto L180;
        return false;
    L180:
        if (Intrinsics.areEqual(this.unavailableInstructionTypeList, r101.unavailableInstructionTypeList) == true) goto L183;
        return false;
    L183:
        if (Intrinsics.areEqual(this.likeInfo, r101.likeInfo) == true) goto L186;
        return false;
    L186:
        if (Intrinsics.areEqual(this.serviceBotConf, r101.serviceBotConf) == true) goto L189;
        return false;
    L189:
        if (Intrinsics.areEqual(this.actionScenes, r101.actionScenes) == true) goto L192;
        return false;
    L192:
        if (Intrinsics.areEqual(this.commentInfo, r101.commentInfo) == true) goto L195;
        return false;
    L195:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L197;
        return false;
    L197:
        return true;
    }

    public int hashCode() {
        String r100 = this.botId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        BotIconImage r107 = this.iconImage;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.createTime;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        Long r112 = this.updateTime;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        Integer r115 = this.botType;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        ShareInfo r118 = this.shareInfo;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        BotCreatorInfo r121 = this.botCreatorInfo;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        List<ShowTagInfo> r124 = this.tagList;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        List<SelectTextAction> r127 = this.selectTextActions;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        ConversationPage r130 = this.conversationPage;
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
        Integer r142 = this.botRecommendStatus;
        if (r142 != null) goto L57;
        int r143 = 0;
    L58:
        int r144 = (r141 + r143) * 31;
        Integer r145 = this.privateStatus;
        if (r145 != null) goto L61;
        int r146 = 0;
    L62:
        int r147 = (r144 + r146) * 31;
        ModelItem r148 = this.model;
        if (r148 != null) goto L65;
        int r149 = 0;
    L66:
        int r150 = (r147 + r149) * 31;
        SpeakerVoice r151 = this.voiceType;
        if (r151 != null) goto L69;
        int r152 = 0;
    L70:
        int r153 = (r150 + r152) * 31;
        String r154 = this.editPos;
        if (r154 != null) goto L73;
        int r155 = 0;
    L74:
        int r156 = (r153 + r155) * 31;
        int r157 = 1231;
        if (this.muted == false) goto L77;
        int r158 = 1231;
    L78:
        int r159 = (r156 + r158) * 31;
        Integer r160 = this.recommendIndex;
        if (r160 != null) goto L81;
        int r161 = 0;
    L82:
        int r162 = (r159 + r161) * 31;
        Boolean r163 = this.messagePush;
        if (r163 != null) goto L85;
        int r164 = 0;
    L86:
        int r165 = (r162 + r164) * 31;
        Boolean r166 = this.showMessagePush;
        if (r166 != null) goto L89;
        int r167 = 0;
    L90:
        int r168 = (r165 + r167) * 31;
        String r169 = this.bioEdit;
        if (r169 != null) goto L93;
        int r170 = 0;
    L94:
        int r171 = (r168 + r170) * 31;
        String r172 = this.bio;
        if (r172 != null) goto L97;
        int r173 = 0;
    L98:
        int r174 = (r171 + r173) * 31;
        BotStatistic r175 = this.botStatic;
        if (r175 != null) goto L101;
        int r176 = 0;
    L102:
        int r177 = (r174 + r176) * 31;
        List<AnswerAction> r178 = this.answerActions;
        if (r178 != null) goto L105;
        int r179 = 0;
    L106:
        int r180 = (r177 + r179) * 31;
        List<String> r181 = this.answerActionExposurePriority;
        if (r181 != null) goto L109;
        int r182 = 0;
    L110:
        int r183 = (r180 + r182) * 31;
        List<AnswerAction> r184 = this.menuActions;
        if (r184 != null) goto L113;
        int r185 = 0;
    L114:
        int r186 = (r183 + r185) * 31;
        List<AnswerAction> r187 = this.streamingAnswerActions;
        if (r187 != null) goto L117;
        int r188 = 0;
    L118:
        int r189 = (r186 + r188) * 31;
        List<BotConfItem> r190 = this.botConf;
        if (r190 != null) goto L121;
        int r191 = 0;
    L122:
        int r192 = (r189 + r191) * 31;
        Map<String, CameraTabConfig> r193 = this.cameraTabConfigMap;
        if (r193 != null) goto L125;
        int r194 = 0;
    L126:
        int r195 = (((r192 + r194) * 31) + this.botMode) * 31;
        String r196 = this.bgImgUrl;
        if (r196 != null) goto L129;
        int r197 = 0;
    L130:
        int r198 = (r195 + r197) * 31;
        String r199 = this.bgImgColor;
        if (r199 != null) goto L133;
        int r200 = 0;
    L134:
        int r201 = (r198 + r200) * 31;
        String r202 = this.bgVideoModel;
        if (r202 != null) goto L137;
        int r203 = 0;
    L138:
        int r204 = (r201 + r203) * 31;
        String r205 = this.iconPrompt;
        if (r205 != null) goto L141;
        int r206 = 0;
    L142:
        int r207 = (r204 + r206) * 31;
        BotSwitchConfInfo r208 = this.switchConfInfo;
        if (r208 != null) goto L145;
        int r209 = 0;
    L146:
        int r210 = (r207 + r209) * 31;
        BotOnBoarding r211 = this.onBoarding;
        if (r211 != null) goto L149;
        int r212 = 0;
    L150:
        int r213 = (r210 + r212) * 31;
        String r214 = this.callerName;
        if (r214 != null) goto L153;
        int r215 = 0;
    L154:
        int r216 = (r213 + r215) * 31;
        Boolean r217 = this.callerNameSetting;
        if (r217 != null) goto L157;
        int r218 = 0;
    L158:
        int r219 = (r216 + r218) * 31;
        SceneModelList r220 = this.sceneModelList;
        if (r220 != null) goto L161;
        int r221 = 0;
    L162:
        int r222 = (r219 + r221) * 31;
        if (this.disabled == true) goto L166;
        r157 = 1237;
    L166:
        int r223 = (r222 + r157) * 31;
        FirstMet r224 = this.firstMet;
        if (r224 != null) goto L169;
        int r225 = 0;
    L170:
        int r226 = (r223 + r225) * 31;
        BotLoadingConfig r227 = this.loadingConf;
        if (r227 != null) goto L173;
        int r228 = 0;
    L174:
        int r229 = (r226 + r228) * 31;
        String r230 = this.botFeatureLabel;
        if (r230 != null) goto L177;
        int r231 = 0;
    L178:
        int r232 = (r229 + r231) * 31;
        String r233 = this.bgImgUri;
        if (r233 != null) goto L181;
        int r234 = 0;
    L182:
        int r235 = (r232 + r234) * 31;
        BgImageInfo r236 = this.bgImgInfo;
        if (r236 != null) goto L185;
        int r237 = 0;
    L186:
        int r238 = (r235 + r237) * 31;
        String r239 = this.userBotGender;
        if (r239 != null) goto L189;
        int r240 = 0;
    L190:
        int r241 = (r238 + r240) * 31;
        String r242 = this.userBotType;
        if (r242 != null) goto L193;
        int r243 = 0;
    L194:
        int r244 = (r241 + r243) * 31;
        BotMemoryConfig r245 = this.botMemoryConfig;
        if (r245 != null) goto L197;
        int r246 = 0;
    L198:
        int r247 = (r244 + r246) * 31;
        String r248 = this.dynamicImgUri;
        if (r248 != null) goto L201;
        int r249 = 0;
    L202:
        int r250 = (r247 + r249) * 31;
        String r251 = this.dynamicImgUrl;
        if (r251 != null) goto L205;
        int r252 = 0;
    L206:
        int r253 = (r250 + r252) * 31;
        CallImgConfig r254 = this.callImgConfig;
        if (r254 != null) goto L209;
        int r255 = 0;
    L210:
        int r256 = (r253 + r255) * 31;
        String r257 = this.botIconMappedAppIcon;
        if (r257 != null) goto L213;
        int r258 = 0;
    L214:
        int r259 = (r256 + r258) * 31;
        MessagePushSwitchConfirmTitle r260 = this.messagePushSwitchConfirmTitle;
        if (r260 != null) goto L217;
        int r261 = 0;
    L218:
        int r262 = (r259 + r261) * 31;
        List<MsgRegenMode> r263 = this.msgRegenModeList;
        if (r263 != null) goto L221;
        int r264 = 0;
    L222:
        int r265 = (r262 + r264) * 31;
        List<Integer> r266 = this.unavailableInstructionTypeList;
        if (r266 != null) goto L225;
        int r267 = 0;
    L226:
        int r268 = (r265 + r267) * 31;
        LikeInfo r269 = this.likeInfo;
        if (r269 != null) goto L229;
        int r270 = 0;
    L230:
        int r271 = (r268 + r270) * 31;
        String r272 = this.serviceBotConf;
        if (r272 != null) goto L233;
        int r273 = 0;
    L234:
        int r274 = (r271 + r273) * 31;
        List<BotActionScene> r275 = this.actionScenes;
        if (r275 != null) goto L237;
        int r276 = 0;
    L238:
        int r277 = (r274 + r276) * 31;
        BotCommentInfo r278 = this.commentInfo;
        if (r278 != null) goto L241;
        int r279 = 0;
    L242:
        int r280 = (r277 + r279) * 31;
        Map<String, String> r281 = this.extra;
        if (r281 == null) goto L247;
        r101 = r281.hashCode();
    L247:
        return r280 + r101;
    L241:
        r279 = r278.hashCode();
        goto L242
    L237:
        r276 = r275.hashCode();
        goto L238
    L233:
        r273 = r272.hashCode();
        goto L234
    L229:
        r270 = r269.hashCode();
        goto L230
    L225:
        r267 = r266.hashCode();
        goto L226
    L221:
        r264 = r263.hashCode();
        goto L222
    L217:
        r261 = r260.hashCode();
        goto L218
    L213:
        r258 = r257.hashCode();
        goto L214
    L209:
        r255 = r254.hashCode();
        goto L210
    L205:
        r252 = r251.hashCode();
        goto L206
    L201:
        r249 = r248.hashCode();
        goto L202
    L197:
        r246 = r245.hashCode();
        goto L198
    L193:
        r243 = r242.hashCode();
        goto L194
    L189:
        r240 = r239.hashCode();
        goto L190
    L185:
        r237 = r236.hashCode();
        goto L186
    L181:
        r234 = r233.hashCode();
        goto L182
    L177:
        r231 = r230.hashCode();
        goto L178
    L173:
        r228 = r227.hashCode();
        goto L174
    L169:
        r225 = r224.hashCode();
        goto L170
    L161:
        r221 = r220.hashCode();
        goto L162
    L157:
        r218 = r217.hashCode();
        goto L158
    L153:
        r215 = r214.hashCode();
        goto L154
    L149:
        r212 = r211.hashCode();
        goto L150
    L145:
        r209 = r208.hashCode();
        goto L146
    L141:
        r206 = r205.hashCode();
        goto L142
    L137:
        r203 = r202.hashCode();
        goto L138
    L133:
        r200 = r199.hashCode();
        goto L134
    L129:
        r197 = r196.hashCode();
        goto L130
    L125:
        r194 = r193.hashCode();
        goto L126
    L121:
        r191 = r190.hashCode();
        goto L122
    L117:
        r188 = r187.hashCode();
        goto L118
    L113:
        r185 = r184.hashCode();
        goto L114
    L109:
        r182 = r181.hashCode();
        goto L110
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
        r158 = 1237;
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
        return "BotModel(botId=" + this.botId + ", name=" + this.name + ", iconImage=" + this.iconImage + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", botType=" + this.botType + ", shareInfo=" + this.shareInfo + ", botCreatorInfo=" + this.botCreatorInfo + ", tagList=" + this.tagList + ", selectTextActions=" + this.selectTextActions + ", conversationPage=" + this.conversationPage + ", descriptionForModel=" + this.descriptionForModel + ", descriptionForHuman=" + this.descriptionForHuman + ", botStatus=" + this.botStatus + ", botRecommendStatus=" + this.botRecommendStatus + ", privateStatus=" + this.privateStatus + ", model=" + this.model + ", voiceType=" + this.voiceType + ", editPos=" + this.editPos + ", muted=" + this.muted + ", recommendIndex=" + this.recommendIndex + ", messagePush=" + this.messagePush + ", showMessagePush=" + this.showMessagePush + ", bioEdit=" + this.bioEdit + ", bio=" + this.bio + ", botStatic=" + this.botStatic + ", answerActions=" + this.answerActions + ", answerActionExposurePriority=" + this.answerActionExposurePriority + ", menuActions=" + this.menuActions + ", streamingAnswerActions=" + this.streamingAnswerActions + ", botConf=" + this.botConf + ", cameraTabConfigMap=" + this.cameraTabConfigMap + ", botMode=" + this.botMode + ", bgImgUrl=" + this.bgImgUrl + ", bgImgColor=" + this.bgImgColor + ", bgVideoModel=" + this.bgVideoModel + ", iconPrompt=" + this.iconPrompt + ", switchConfInfo=" + this.switchConfInfo + ", onBoarding=" + this.onBoarding + ", callerName=" + this.callerName + ", callerNameSetting=" + this.callerNameSetting + ", sceneModelList=" + this.sceneModelList + ", disabled=" + this.disabled + ", firstMet=" + this.firstMet + ", loadingConf=" + this.loadingConf + ", botFeatureLabel=" + this.botFeatureLabel + ", bgImgUri=" + this.bgImgUri + ", bgImgInfo=" + this.bgImgInfo + ", userBotGender=" + this.userBotGender + ", userBotType=" + this.userBotType + ", botMemoryConfig=" + this.botMemoryConfig + ", dynamicImgUri=" + this.dynamicImgUri + ", dynamicImgUrl=" + this.dynamicImgUrl + ", callImgConfig=" + this.callImgConfig + ", botIconMappedAppIcon=" + this.botIconMappedAppIcon + ", messagePushSwitchConfirmTitle=" + this.messagePushSwitchConfirmTitle + ", msgRegenModeList=" + this.msgRegenModeList + ", unavailableInstructionTypeList=" + this.unavailableInstructionTypeList + ", likeInfo=" + this.likeInfo + ", serviceBotConf=" + this.serviceBotConf + ", actionScenes=" + this.actionScenes + ", commentInfo=" + this.commentInfo + ", extra=" + this.extra + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, null, null, null, null, null, LazyKt.lazy(r100, new uc9.e()), LazyKt.lazy(r100, new j()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(r100, new k()), LazyKt.lazy(r100, new l()), LazyKt.lazy(r100, new m()), LazyKt.lazy(r100, new n()), LazyKt.lazy(r100, new o()), LazyKt.lazy(r100, new p()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(r100, new uc9.f()), LazyKt.lazy(r100, new g()), null, null, LazyKt.lazy(r100, new h()), null, LazyKt.lazy(r100, new uc9.i())};
    }

    public final boolean getBgImgOpen() {
        BgImageInfo r100 = this.bgImgInfo;
        if (r100 == null) goto L7;
        Boolean r101 = r100.getBgImgOpen();
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return true;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final List<BotActionScene> getActionScenes() {
        return this.actionScenes;
    }

    public final List<String> getAnswerActionExposurePriority() {
        return this.answerActionExposurePriority;
    }

    public final List<AnswerAction> getAnswerActions() {
        return this.answerActions;
    }

    public final String getBgImgColor() {
        return this.bgImgColor;
    }

    public final BgImageInfo getBgImgInfo() {
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

    public final List<BotConfItem> getBotConf() {
        return this.botConf;
    }

    public final BotCreatorInfo getBotCreatorInfo() {
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

    public final BotMemoryConfig getBotMemoryConfig() {
        return this.botMemoryConfig;
    }

    public final int getBotMode() {
        return this.botMode;
    }

    public final Integer getBotRecommendStatus() {
        return this.botRecommendStatus;
    }

    public final BotStatistic getBotStatic() {
        return this.botStatic;
    }

    public final Integer getBotStatus() {
        return this.botStatus;
    }

    public final Integer getBotType() {
        return this.botType;
    }

    public final CallImgConfig getCallImgConfig() {
        return this.callImgConfig;
    }

    public final String getCallerName() {
        return this.callerName;
    }

    public final Boolean getCallerNameSetting() {
        return this.callerNameSetting;
    }

    public final Map<String, CameraTabConfig> getCameraTabConfigMap() {
        return this.cameraTabConfigMap;
    }

    public final BotCommentInfo getCommentInfo() {
        return this.commentInfo;
    }

    public final ConversationPage getConversationPage() {
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

    public final boolean getDisabled() {
        return this.disabled;
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

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final FirstMet getFirstMet() {
        return this.firstMet;
    }

    public final BotIconImage getIconImage() {
        return this.iconImage;
    }

    public final String getIconPrompt() {
        return this.iconPrompt;
    }

    public final LikeInfo getLikeInfo() {
        return this.likeInfo;
    }

    public final BotLoadingConfig getLoadingConf() {
        return this.loadingConf;
    }

    public final List<AnswerAction> getMenuActions() {
        return this.menuActions;
    }

    public final Boolean getMessagePush() {
        return this.messagePush;
    }

    public final MessagePushSwitchConfirmTitle getMessagePushSwitchConfirmTitle() {
        return this.messagePushSwitchConfirmTitle;
    }

    public final ModelItem getModel() {
        return this.model;
    }

    public final List<MsgRegenMode> getMsgRegenModeList() {
        return this.msgRegenModeList;
    }

    public final boolean getMuted() {
        return this.muted;
    }

    public final String getName() {
        return this.name;
    }

    public final BotOnBoarding getOnBoarding() {
        return this.onBoarding;
    }

    public final Integer getPrivateStatus() {
        return this.privateStatus;
    }

    public final Integer getRecommendIndex() {
        return this.recommendIndex;
    }

    public final SceneModelList getSceneModelList() {
        return this.sceneModelList;
    }

    public final List<SelectTextAction> getSelectTextActions() {
        return this.selectTextActions;
    }

    public final String getServiceBotConf() {
        return this.serviceBotConf;
    }

    public final ShareInfo getShareInfo() {
        return this.shareInfo;
    }

    public final Boolean getShowMessagePush() {
        return this.showMessagePush;
    }

    public final List<AnswerAction> getStreamingAnswerActions() {
        return this.streamingAnswerActions;
    }

    public final BotSwitchConfInfo getSwitchConfInfo() {
        return this.switchConfInfo;
    }

    public final List<ShowTagInfo> getTagList() {
        return this.tagList;
    }

    public final List<Integer> getUnavailableInstructionTypeList() {
        return this.unavailableInstructionTypeList;
    }

    public final Long getUpdateTime() {
        return this.updateTime;
    }

    public final String getUserBotGender() {
        return this.userBotGender;
    }

    public final String getUserBotType() {
        return this.userBotType;
    }

    public final SpeakerVoice getVoiceType() {
        return this.voiceType;
    }

    public final String getChatType(String r100) {
        Integer r101 = this.botType;
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L20:
        return "other_default";
    L11:
        if (r101.intValue() != 0) goto L20;
        BotCreatorInfo r102 = this.botCreatorInfo;
        if (r102 == null) goto L15;
        String r103 = r102.getId();
    L17:
        if (Intrinsics.areEqual(r103, r100) == false) goto L19;
        return "self_created";
    L19:
        return "others_created";
    L15:
        r103 = null;
        goto L17
    L6:
        if (r101.intValue() != 1) goto L8;
        return "default";
    }

    public final void setBgImgColor(String r100) {
        this.bgImgColor = r100;
    }

    public final void setBgImgInfo(BgImageInfo r100) {
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

    public final void setBotConf(List<BotConfItem> r100) {
        this.botConf = r100;
    }

    public final void setBotFeatureLabel(String r100) {
        this.botFeatureLabel = r100;
    }

    public final void setBotIconMappedAppIcon(String r100) {
        this.botIconMappedAppIcon = r100;
    }

    public final void setBotMemoryConfig(BotMemoryConfig r100) {
        this.botMemoryConfig = r100;
    }

    public final void setBotMode(int r100) {
        this.botMode = r100;
    }

    public final void setCallImgConfig(CallImgConfig r100) {
        this.callImgConfig = r100;
    }

    public final void setCameraTabConfigMap(Map<String, CameraTabConfig> r100) {
        this.cameraTabConfigMap = r100;
    }

    public final void setDisabled(boolean r100) {
        this.disabled = r100;
    }

    public final void setDynamicImgUri(String r100) {
        this.dynamicImgUri = r100;
    }

    public final void setDynamicImgUrl(String r100) {
        this.dynamicImgUrl = r100;
    }

    public final void setFirstMet(FirstMet r100) {
        this.firstMet = r100;
    }

    public final void setIconPrompt(String r100) {
        this.iconPrompt = r100;
    }

    public final void setMenuActions(List<AnswerAction> r100) {
        this.menuActions = r100;
    }

    public final void setMsgRegenModeList(List<MsgRegenMode> r100) {
        this.msgRegenModeList = r100;
    }

    public final void setSceneModelList(SceneModelList r100) {
        this.sceneModelList = r100;
    }

    public final void setSelectTextActions(List<SelectTextAction> r100) {
        this.selectTextActions = r100;
    }

    public final void setStreamingAnswerActions(List<AnswerAction> r100) {
        this.streamingAnswerActions = r100;
    }

    public final void setSwitchConfInfo(BotSwitchConfInfo r100) {
        this.switchConfInfo = r100;
    }

    public final void setTagList(List<ShowTagInfo> r100) {
        this.tagList = r100;
    }

    public final void setUnavailableInstructionTypeList(List<Integer> r100) {
        this.unavailableInstructionTypeList = r100;
    }

    public final void setUserBotGender(String r100) {
        this.userBotGender = r100;
    }

    public final void setUserBotType(String r100) {
        this.userBotType = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(BotModel r100, muc.d r110, f r111) {
        Lazy<d<Object>>[] r101 = $childSerializers;
        boolean r102 = false;
        if (r110.shouldEncodeElementDefault(r111, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r110.encodeNullableSerializableElement(r111, 0, v2.f520790a, r100.botId);
    L12:
        if (r110.shouldEncodeElementDefault(r111, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r110.encodeNullableSerializableElement(r111, 1, v2.f520790a, r100.name);
    L21:
        if (r110.shouldEncodeElementDefault(r111, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r110.encodeNullableSerializableElement(r111, 2, BotIconImage.a.f346435a, r100.iconImage);
    L30:
        if (r110.shouldEncodeElementDefault(r111, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r110.encodeLongElement(r111, 3, r100.createTime);
    L39:
        if (r110.shouldEncodeElementDefault(r111, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r110.encodeNullableSerializableElement(r111, 4, g1.f520681a, r100.updateTime);
    L48:
        if (r110.shouldEncodeElementDefault(r111, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r110.encodeNullableSerializableElement(r111, 5, w0.f520792a, r100.botType);
    L57:
        if (r110.shouldEncodeElementDefault(r111, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r110.encodeNullableSerializableElement(r111, 6, ShareInfo.a.f346495a, r100.shareInfo);
    L66:
        if (r110.shouldEncodeElementDefault(r111, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r110.encodeNullableSerializableElement(r111, 7, BotCreatorInfo.a.f346430a, r100.botCreatorInfo);
    L75:
        if (r110.shouldEncodeElementDefault(r111, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r110.encodeNullableSerializableElement(r111, 8, r101[8].getValue(), r100.tagList);
    L84:
        if (r110.shouldEncodeElementDefault(r111, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r110.encodeNullableSerializableElement(r111, 9, r101[9].getValue(), r100.selectTextActions);
    L93:
        if (r110.shouldEncodeElementDefault(r111, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r110.encodeNullableSerializableElement(r111, 10, ConversationPage.a.f346464a, r100.conversationPage);
    L102:
        if (r110.shouldEncodeElementDefault(r111, 11) == false) goto L105;
    L103:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r110.encodeNullableSerializableElement(r111, 11, v2.f520790a, r100.descriptionForModel);
    L111:
        if (r110.shouldEncodeElementDefault(r111, 12) == false) goto L114;
    L112:
        boolean r117 = true;
    L117:
        if (r117 == false) goto L120;
        r110.encodeNullableSerializableElement(r111, 12, v2.f520790a, r100.descriptionForHuman);
    L120:
        if (r110.shouldEncodeElementDefault(r111, 13) == false) goto L123;
    L121:
        boolean r118 = true;
    L126:
        if (r118 == false) goto L129;
        r110.encodeNullableSerializableElement(r111, 13, w0.f520792a, r100.botStatus);
    L129:
        if (r110.shouldEncodeElementDefault(r111, 14) == false) goto L132;
    L130:
        boolean r119 = true;
    L135:
        if (r119 == false) goto L138;
        r110.encodeNullableSerializableElement(r111, 14, w0.f520792a, r100.botRecommendStatus);
    L138:
        if (r110.shouldEncodeElementDefault(r111, 15) == false) goto L141;
    L139:
        boolean r120 = true;
    L144:
        if (r120 == false) goto L147;
        r110.encodeNullableSerializableElement(r111, 15, w0.f520792a, r100.privateStatus);
    L147:
        if (r110.shouldEncodeElementDefault(r111, 16) == false) goto L150;
    L148:
        boolean r121 = true;
    L153:
        if (r121 == false) goto L156;
        r110.encodeNullableSerializableElement(r111, 16, ModelItem.a.f346482a, r100.model);
    L156:
        if (r110.shouldEncodeElementDefault(r111, 17) == false) goto L159;
    L157:
        boolean r122 = true;
    L162:
        if (r122 == false) goto L165;
        r110.encodeNullableSerializableElement(r111, 17, SpeakerVoice.a.f346504a, r100.voiceType);
    L165:
        if (r110.shouldEncodeElementDefault(r111, 18) == false) goto L168;
    L166:
        boolean r123 = true;
    L171:
        if (r123 == false) goto L174;
        r110.encodeNullableSerializableElement(r111, 18, v2.f520790a, r100.editPos);
    L174:
        if (r110.shouldEncodeElementDefault(r111, 19) == false) goto L177;
    L175:
        boolean r124 = true;
    L180:
        if (r124 == false) goto L183;
        r110.encodeBooleanElement(r111, 19, r100.muted);
    L183:
        if (r110.shouldEncodeElementDefault(r111, 20) == false) goto L186;
    L184:
        boolean r125 = true;
    L189:
        if (r125 == false) goto L192;
        r110.encodeNullableSerializableElement(r111, 20, w0.f520792a, r100.recommendIndex);
    L192:
        if (r110.shouldEncodeElementDefault(r111, 21) == false) goto L195;
    L193:
        boolean r126 = true;
    L198:
        if (r126 == false) goto L201;
        r110.encodeNullableSerializableElement(r111, 21, i.f520705a, r100.messagePush);
    L201:
        if (r110.shouldEncodeElementDefault(r111, 22) == false) goto L204;
    L202:
        boolean r127 = true;
    L207:
        if (r127 == false) goto L210;
        r110.encodeNullableSerializableElement(r111, 22, i.f520705a, r100.showMessagePush);
    L210:
        if (r110.shouldEncodeElementDefault(r111, 23) == false) goto L213;
    L211:
        boolean r128 = true;
    L216:
        if (r128 == false) goto L219;
        r110.encodeNullableSerializableElement(r111, 23, v2.f520790a, r100.bioEdit);
    L219:
        if (r110.shouldEncodeElementDefault(r111, 24) == false) goto L222;
    L220:
        boolean r129 = true;
    L225:
        if (r129 == false) goto L228;
        r110.encodeNullableSerializableElement(r111, 24, v2.f520790a, r100.bio);
    L228:
        if (r110.shouldEncodeElementDefault(r111, 25) == false) goto L231;
    L229:
        boolean r130 = true;
    L234:
        if (r130 == false) goto L237;
        r110.encodeNullableSerializableElement(r111, 25, BotStatistic.a.f346447a, r100.botStatic);
    L237:
        if (r110.shouldEncodeElementDefault(r111, 26) == false) goto L240;
    L238:
        boolean r131 = true;
    L243:
        if (r131 == false) goto L246;
        r110.encodeNullableSerializableElement(r111, 26, r101[26].getValue(), r100.answerActions);
    L246:
        if (r110.shouldEncodeElementDefault(r111, 27) == false) goto L249;
    L247:
        boolean r132 = true;
    L252:
        if (r132 == false) goto L255;
        r110.encodeNullableSerializableElement(r111, 27, r101[27].getValue(), r100.answerActionExposurePriority);
    L255:
        if (r110.shouldEncodeElementDefault(r111, 28) == false) goto L258;
    L256:
        boolean r133 = true;
    L261:
        if (r133 == false) goto L264;
        r110.encodeNullableSerializableElement(r111, 28, r101[28].getValue(), r100.menuActions);
    L264:
        if (r110.shouldEncodeElementDefault(r111, 29) == false) goto L267;
    L265:
        boolean r134 = true;
    L270:
        if (r134 == false) goto L273;
        r110.encodeNullableSerializableElement(r111, 29, r101[29].getValue(), r100.streamingAnswerActions);
    L273:
        if (r110.shouldEncodeElementDefault(r111, 30) == false) goto L276;
    L274:
        boolean r135 = true;
    L279:
        if (r135 == false) goto L282;
        r110.encodeNullableSerializableElement(r111, 30, r101[30].getValue(), r100.botConf);
    L282:
        if (r110.shouldEncodeElementDefault(r111, 31) == false) goto L285;
    L283:
        boolean r136 = true;
    L288:
        if (r136 == false) goto L291;
        r110.encodeNullableSerializableElement(r111, 31, r101[31].getValue(), r100.cameraTabConfigMap);
    L291:
        if (r110.shouldEncodeElementDefault(r111, 32) == false) goto L294;
    L292:
        boolean r137 = true;
    L297:
        if (r137 == false) goto L300;
        r110.encodeIntElement(r111, 32, r100.botMode);
    L300:
        if (r110.shouldEncodeElementDefault(r111, 33) == false) goto L303;
    L301:
        boolean r138 = true;
    L306:
        if (r138 == false) goto L309;
        r110.encodeNullableSerializableElement(r111, 33, v2.f520790a, r100.bgImgUrl);
    L309:
        if (r110.shouldEncodeElementDefault(r111, 34) == false) goto L312;
    L310:
        boolean r139 = true;
    L315:
        if (r139 == false) goto L318;
        r110.encodeNullableSerializableElement(r111, 34, v2.f520790a, r100.bgImgColor);
    L318:
        if (r110.shouldEncodeElementDefault(r111, 35) == false) goto L321;
    L319:
        boolean r140 = true;
    L324:
        if (r140 == false) goto L327;
        r110.encodeNullableSerializableElement(r111, 35, v2.f520790a, r100.bgVideoModel);
    L327:
        if (r110.shouldEncodeElementDefault(r111, 36) == false) goto L330;
    L328:
        boolean r141 = true;
    L333:
        if (r141 == false) goto L336;
        r110.encodeNullableSerializableElement(r111, 36, v2.f520790a, r100.iconPrompt);
    L336:
        if (r110.shouldEncodeElementDefault(r111, 37) == false) goto L339;
    L337:
        boolean r142 = true;
    L342:
        if (r142 == false) goto L345;
        r110.encodeNullableSerializableElement(r111, 37, BotSwitchConfInfo.a.f346449a, r100.switchConfInfo);
    L345:
        if (r110.shouldEncodeElementDefault(r111, 38) == false) goto L348;
    L346:
        boolean r143 = true;
    L351:
        if (r143 == false) goto L354;
        r110.encodeNullableSerializableElement(r111, 38, BotOnBoarding.a.f346444a, r100.onBoarding);
    L354:
        if (r110.shouldEncodeElementDefault(r111, 39) == false) goto L357;
    L355:
        boolean r144 = true;
    L360:
        if (r144 == false) goto L363;
        r110.encodeNullableSerializableElement(r111, 39, v2.f520790a, r100.callerName);
    L363:
        if (r110.shouldEncodeElementDefault(r111, 40) == false) goto L366;
    L364:
        boolean r145 = true;
    L369:
        if (r145 == false) goto L372;
        r110.encodeNullableSerializableElement(r111, 40, i.f520705a, r100.callerNameSetting);
    L372:
        if (r110.shouldEncodeElementDefault(r111, 41) == false) goto L375;
    L373:
        boolean r146 = true;
    L378:
        if (r146 == false) goto L381;
        r110.encodeNullableSerializableElement(r111, 41, SceneModelList.a.f346490a, r100.sceneModelList);
    L381:
        if (r110.shouldEncodeElementDefault(r111, 42) == false) goto L384;
    L382:
        boolean r147 = true;
    L387:
        if (r147 == false) goto L390;
        r110.encodeBooleanElement(r111, 42, r100.disabled);
    L390:
        if (r110.shouldEncodeElementDefault(r111, 43) == false) goto L393;
    L391:
        boolean r148 = true;
    L396:
        if (r148 == false) goto L399;
        r110.encodeNullableSerializableElement(r111, 43, FirstMet.a.f346469a, r100.firstMet);
    L399:
        if (r110.shouldEncodeElementDefault(r111, 44) == false) goto L402;
    L400:
        boolean r149 = true;
    L405:
        if (r149 == false) goto L408;
        r110.encodeNullableSerializableElement(r111, 44, BotLoadingConfig.a.f349780a, r100.loadingConf);
    L408:
        if (r110.shouldEncodeElementDefault(r111, 45) == false) goto L411;
    L409:
        boolean r150 = true;
    L414:
        if (r150 == false) goto L417;
        r110.encodeNullableSerializableElement(r111, 45, v2.f520790a, r100.botFeatureLabel);
    L417:
        if (r110.shouldEncodeElementDefault(r111, 46) == false) goto L420;
    L418:
        boolean r151 = true;
    L423:
        if (r151 == false) goto L426;
        r110.encodeNullableSerializableElement(r111, 46, v2.f520790a, r100.bgImgUri);
    L426:
        if (r110.shouldEncodeElementDefault(r111, 47) == false) goto L429;
    L427:
        boolean r152 = true;
    L432:
        if (r152 == false) goto L435;
        r110.encodeNullableSerializableElement(r111, 47, BgImageInfo.a.f346423a, r100.bgImgInfo);
    L435:
        if (r110.shouldEncodeElementDefault(r111, 48) == false) goto L438;
    L436:
        boolean r153 = true;
    L441:
        if (r153 == false) goto L444;
        r110.encodeNullableSerializableElement(r111, 48, v2.f520790a, r100.userBotGender);
    L444:
        if (r110.shouldEncodeElementDefault(r111, 49) == false) goto L447;
    L445:
        boolean r154 = true;
    L450:
        if (r154 == false) goto L453;
        r110.encodeNullableSerializableElement(r111, 49, v2.f520790a, r100.userBotType);
    L453:
        if (r110.shouldEncodeElementDefault(r111, 50) == false) goto L456;
    L454:
        boolean r155 = true;
    L459:
        if (r155 == false) goto L462;
        r110.encodeNullableSerializableElement(r111, 50, BotMemoryConfig.a.f346439a, r100.botMemoryConfig);
    L462:
        if (r110.shouldEncodeElementDefault(r111, 51) == false) goto L465;
    L463:
        boolean r156 = true;
    L468:
        if (r156 == false) goto L471;
        r110.encodeNullableSerializableElement(r111, 51, v2.f520790a, r100.dynamicImgUri);
    L471:
        if (r110.shouldEncodeElementDefault(r111, 52) == false) goto L474;
    L472:
        boolean r157 = true;
    L477:
        if (r157 == false) goto L480;
        r110.encodeNullableSerializableElement(r111, 52, v2.f520790a, r100.dynamicImgUrl);
    L480:
        if (r110.shouldEncodeElementDefault(r111, 53) == false) goto L483;
    L481:
        boolean r158 = true;
    L486:
        if (r158 == false) goto L489;
        r110.encodeNullableSerializableElement(r111, 53, CallImgConfig.a.f346453a, r100.callImgConfig);
    L489:
        if (r110.shouldEncodeElementDefault(r111, 54) == false) goto L492;
    L490:
        boolean r159 = true;
    L495:
        if (r159 == false) goto L498;
        r110.encodeNullableSerializableElement(r111, 54, v2.f520790a, r100.botIconMappedAppIcon);
    L498:
        if (r110.shouldEncodeElementDefault(r111, 55) == false) goto L501;
    L499:
        boolean r160 = true;
    L504:
        if (r160 == false) goto L507;
        r110.encodeNullableSerializableElement(r111, 55, MessagePushSwitchConfirmTitle.a.f346478a, r100.messagePushSwitchConfirmTitle);
    L507:
        if (r110.shouldEncodeElementDefault(r111, 56) == false) goto L510;
    L508:
        boolean r161 = true;
    L513:
        if (r161 == false) goto L516;
        r110.encodeNullableSerializableElement(r111, 56, r101[56].getValue(), r100.msgRegenModeList);
    L516:
        if (r110.shouldEncodeElementDefault(r111, 57) == false) goto L519;
    L517:
        boolean r162 = true;
    L522:
        if (r162 == false) goto L525;
        r110.encodeNullableSerializableElement(r111, 57, r101[57].getValue(), r100.unavailableInstructionTypeList);
    L525:
        if (r110.shouldEncodeElementDefault(r111, 58) == false) goto L528;
    L526:
        boolean r163 = true;
    L531:
        if (r163 == false) goto L534;
        r110.encodeNullableSerializableElement(r111, 58, LikeInfo.a.f349784a, r100.likeInfo);
    L534:
        if (r110.shouldEncodeElementDefault(r111, 59) == false) goto L537;
    L535:
        boolean r164 = true;
    L540:
        if (r164 == false) goto L543;
        r110.encodeNullableSerializableElement(r111, 59, v2.f520790a, r100.serviceBotConf);
    L543:
        if (r110.shouldEncodeElementDefault(r111, 60) == false) goto L546;
    L544:
        boolean r165 = true;
    L549:
        if (r165 == false) goto L552;
        r110.encodeNullableSerializableElement(r111, 60, r101[60].getValue(), r100.actionScenes);
    L552:
        if (r110.shouldEncodeElementDefault(r111, 61) == false) goto L555;
    L553:
        boolean r166 = true;
    L558:
        if (r166 == false) goto L561;
        r110.encodeNullableSerializableElement(r111, 61, BotCommentInfo.a.f349775a, r100.commentInfo);
    L561:
        if (r110.shouldEncodeElementDefault(r111, 62) == false) goto L564;
    L562:
        r102 = true;
    L566:
        if (r102 == false) goto L569;
        r110.encodeNullableSerializableElement(r111, 62, r101[62].getValue(), r100.extra);
        return;
    L569:
        return;
    L564:
        if (r100.extra == null) goto L566;
    L555:
        if (r100.commentInfo != null) goto L553;
        r166 = false;
        goto L558
    L546:
        if (r100.actionScenes != null) goto L544;
        r165 = false;
        goto L549
    L537:
        if (r100.serviceBotConf != null) goto L535;
        r164 = false;
        goto L540
    L528:
        if (r100.likeInfo != null) goto L526;
        r163 = false;
        goto L531
    L519:
        if (r100.unavailableInstructionTypeList != null) goto L517;
        r162 = false;
        goto L522
    L510:
        if (r100.msgRegenModeList != null) goto L508;
        r161 = false;
        goto L513
    L501:
        if (r100.messagePushSwitchConfirmTitle != null) goto L499;
        r160 = false;
        goto L504
    L492:
        if (r100.botIconMappedAppIcon != null) goto L490;
        r159 = false;
        goto L495
    L483:
        if (r100.callImgConfig != null) goto L481;
        r158 = false;
        goto L486
    L474:
        if (r100.dynamicImgUrl != null) goto L472;
        r157 = false;
        goto L477
    L465:
        if (r100.dynamicImgUri != null) goto L463;
        r156 = false;
        goto L468
    L456:
        if (r100.botMemoryConfig != null) goto L454;
        r155 = false;
        goto L459
    L447:
        if (r100.userBotType != null) goto L445;
        r154 = false;
        goto L450
    L438:
        if (r100.userBotGender != null) goto L436;
        r153 = false;
        goto L441
    L429:
        if (r100.bgImgInfo != null) goto L427;
        r152 = false;
        goto L432
    L420:
        if (r100.bgImgUri != null) goto L418;
        r151 = false;
        goto L423
    L411:
        if (r100.botFeatureLabel != null) goto L409;
        r150 = false;
        goto L414
    L402:
        if (r100.loadingConf != null) goto L400;
        r149 = false;
        goto L405
    L393:
        if (r100.firstMet != null) goto L391;
        r148 = false;
        goto L396
    L384:
        if (r100.disabled == true) goto L382;
        r147 = false;
        goto L387
    L375:
        if (r100.sceneModelList != null) goto L373;
        r146 = false;
        goto L378
    L366:
        if (Intrinsics.areEqual(r100.callerNameSetting, Boolean.FALSE) == false) goto L364;
        r145 = false;
        goto L369
    L357:
        if (r100.callerName != null) goto L355;
        r144 = false;
        goto L360
    L348:
        if (r100.onBoarding != null) goto L346;
        r143 = false;
        goto L351
    L339:
        if (r100.switchConfInfo != null) goto L337;
        r142 = false;
        goto L342
    L330:
        if (r100.iconPrompt != null) goto L328;
        r141 = false;
        goto L333
    L321:
        if (r100.bgVideoModel != null) goto L319;
        r140 = false;
        goto L324
    L312:
        if (r100.bgImgColor != null) goto L310;
        r139 = false;
        goto L315
    L303:
        if (r100.bgImgUrl != null) goto L301;
        r138 = false;
        goto L306
    L294:
        if (r100.botMode != (-1)) goto L292;
        r137 = false;
        goto L297
    L285:
        if (r100.cameraTabConfigMap != null) goto L283;
        r136 = false;
        goto L288
    L276:
        if (r100.botConf != null) goto L274;
        r135 = false;
        goto L279
    L267:
        if (r100.streamingAnswerActions != null) goto L265;
        r134 = false;
        goto L270
    L258:
        if (r100.menuActions != null) goto L256;
        r133 = false;
        goto L261
    L249:
        if (r100.answerActionExposurePriority != null) goto L247;
        r132 = false;
        goto L252
    L240:
        if (r100.answerActions != null) goto L238;
        r131 = false;
        goto L243
    L231:
        if (r100.botStatic != null) goto L229;
        r130 = false;
        goto L234
    L222:
        if (r100.bio != null) goto L220;
        r129 = false;
        goto L225
    L213:
        if (r100.bioEdit != null) goto L211;
        r128 = false;
        goto L216
    L204:
        if (Intrinsics.areEqual(r100.showMessagePush, Boolean.FALSE) == false) goto L202;
        r127 = false;
        goto L207
    L195:
        if (Intrinsics.areEqual(r100.messagePush, Boolean.FALSE) == false) goto L193;
        r126 = false;
        goto L198
    L186:
        if (r100.recommendIndex != null) goto L184;
        r125 = false;
        goto L189
    L177:
        if (r100.muted == true) goto L175;
        r124 = false;
        goto L180
    L168:
        if (r100.editPos != null) goto L166;
        r123 = false;
        goto L171
    L159:
        if (r100.voiceType != null) goto L157;
        r122 = false;
        goto L162
    L150:
        if (r100.model != null) goto L148;
        r121 = false;
        goto L153
    L141:
        if (r100.privateStatus != null) goto L139;
        r120 = false;
        goto L144
    L132:
        if (r100.botRecommendStatus != null) goto L130;
        r119 = false;
        goto L135
    L123:
        if (r100.botStatus != null) goto L121;
        r118 = false;
        goto L126
    L114:
        if (r100.descriptionForHuman != null) goto L112;
        r117 = false;
        goto L117
    L105:
        if (r100.descriptionForModel != null) goto L103;
        r116 = false;
        goto L108
    L96:
        if (r100.conversationPage != null) goto L94;
        r115 = false;
        goto L99
    L87:
        if (r100.selectTextActions != null) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.tagList != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.botCreatorInfo != null) goto L67;
        r112 = false;
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

    public BotModel(String r100, String r101, BotIconImage r102, long r103, Long r104, @BotSourceType Integer r110, ShareInfo r111, BotCreatorInfo r112, List<ShowTagInfo> r113, List<SelectTextAction> r114, ConversationPage r115, String r116, String r117, Integer r118, @Status Integer r119, Integer r210, ModelItem r211, SpeakerVoice r212, String r213, boolean r214, Integer r215, Boolean r216, Boolean r217, String r218, String r219, BotStatistic r310, List<AnswerAction> r311, List<String> r312, List<AnswerAction> r313, List<AnswerAction> r314, List<BotConfItem> r315, Map<String, CameraTabConfig> r316, int r317, String r318, String r319, String r410, String r411, BotSwitchConfInfo r412, BotOnBoarding r413, String r414, Boolean r415, SceneModelList r416, boolean r417, FirstMet r418, BotLoadingConfig r419, String r510, String r511, BgImageInfo r512, String r513, String r514, BotMemoryConfig r515, String r516, String r517, CallImgConfig r518, String r519, MessagePushSwitchConfirmTitle r610, List<MsgRegenMode> r611, List<Integer> r612, LikeInfo r613, String r614, List<BotActionScene> r615, BotCommentInfo r616, Map<String, String> r617) {
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
        this.conversationPage = r115;
        this.descriptionForModel = r116;
        this.descriptionForHuman = r117;
        this.botStatus = r118;
        this.botRecommendStatus = r119;
        this.privateStatus = r210;
        this.model = r211;
        this.voiceType = r212;
        this.editPos = r213;
        this.muted = r214;
        this.recommendIndex = r215;
        this.messagePush = r216;
        this.showMessagePush = r217;
        this.bioEdit = r218;
        this.bio = r219;
        this.botStatic = r310;
        this.answerActions = r311;
        this.answerActionExposurePriority = r312;
        this.menuActions = r313;
        this.streamingAnswerActions = r314;
        this.botConf = r315;
        this.cameraTabConfigMap = r316;
        this.botMode = r317;
        this.bgImgUrl = r318;
        this.bgImgColor = r319;
        this.bgVideoModel = r410;
        this.iconPrompt = r411;
        this.switchConfInfo = r412;
        this.onBoarding = r413;
        this.callerName = r414;
        this.callerNameSetting = r415;
        this.sceneModelList = r416;
        this.disabled = r417;
        this.firstMet = r418;
        this.loadingConf = r419;
        this.botFeatureLabel = r510;
        this.bgImgUri = r511;
        this.bgImgInfo = r512;
        this.userBotGender = r513;
        this.userBotType = r514;
        this.botMemoryConfig = r515;
        this.dynamicImgUri = r516;
        this.dynamicImgUrl = r517;
        this.callImgConfig = r518;
        this.botIconMappedAppIcon = r519;
        this.messagePushSwitchConfirmTitle = r610;
        this.msgRegenModeList = r611;
        this.unavailableInstructionTypeList = r612;
        this.likeInfo = r613;
        this.serviceBotConf = r614;
        this.actionScenes = r615;
        this.commentInfo = r616;
        this.extra = r617;
    }

    public BotModel(int r110, int r111, String r112, String r210, BotIconImage r211, long r212, Long r213, Integer r214, ShareInfo r215, BotCreatorInfo r216, List r217, List r218, ConversationPage r310, String r311, String r312, Integer r313, Integer r314, Integer r315, ModelItem r316, SpeakerVoice r317, String r318, boolean r319, Integer r410, Boolean r411, Boolean r412, String r413, String r414, BotStatistic r415, List r416, List r417, List r418, List r419, List r510, Map r511, int r512, String r513, String r514, String r515, String r516, BotSwitchConfInfo r517, BotOnBoarding r518, String r519, Boolean r610, SceneModelList r611, boolean r612, FirstMet r613, BotLoadingConfig r614, String r615, String r616, BgImageInfo r617, String r618, String r619, BotMemoryConfig r710, String r711, String r712, CallImgConfig r713, String r714, MessagePushSwitchConfirmTitle r715, List r716, List r717, LikeInfo r718, String r719, List r810, BotCommentInfo r811, Map r812, q2 r813) {
        if ((r110 & 0) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r111 & 0) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r100 | r101) == false) goto L13;
        b2.a(new int[]{r110, r111}, new int[]{0, 0}, a.f346442b);
        throw null;
    L13:
        if ((r110 & 1) != 0) goto L15;
        String r102 = "";
    L16:
        this.botId = r102;
        if ((r110 & 2) != 0) goto L19;
        this.name = null;
    L21:
        if ((r110 & 4) != 0) goto L23;
        this.iconImage = null;
    L25:
        if ((r110 & 8) != 0) goto L27;
        long r103 = com.larus.im.internal.delegate.c.f348197a.currentTimeMillis();
    L28:
        this.createTime = r103;
        if ((r110 & 16) != 0) goto L31;
        this.updateTime = null;
    L33:
        if ((r110 & 32) != 0) goto L35;
        this.botType = null;
    L37:
        if ((r110 & 64) != 0) goto L39;
        this.shareInfo = null;
    L41:
        if ((r110 & 128) != 0) goto L43;
        this.botCreatorInfo = null;
    L45:
        if ((r110 & 256) != 0) goto L47;
        this.tagList = null;
    L49:
        if ((r110 & 512) != 0) goto L51;
        this.selectTextActions = null;
    L53:
        if ((r110 & 1024) != 0) goto L55;
        this.conversationPage = null;
    L57:
        if ((r110 & 2048) != 0) goto L59;
        this.descriptionForModel = null;
    L61:
        if ((r110 & 4096) != 0) goto L63;
        this.descriptionForHuman = null;
    L65:
        if ((r110 & 8192) != 0) goto L67;
        this.botStatus = null;
    L69:
        if ((r110 & 16384) != 0) goto L71;
        this.botRecommendStatus = null;
    L73:
        if ((r110 & 32768) != 0) goto L75;
        this.privateStatus = null;
    L77:
        if ((r110 & 65536) != 0) goto L79;
        this.model = null;
    L81:
        if ((r110 & 131072) != 0) goto L83;
        this.voiceType = null;
    L85:
        if ((r110 & 262144) != 0) goto L87;
        this.editPos = null;
    L89:
        if ((r110 & 524288) != 0) goto L91;
        this.muted = false;
    L93:
        if ((r110 & 1048576) != 0) goto L95;
        this.recommendIndex = null;
    L97:
        if ((r110 & 2097152) != 0) goto L99;
        Boolean r113 = Boolean.FALSE;
    L100:
        this.messagePush = r113;
        if ((r110 & 4194304) != 0) goto L103;
        Boolean r114 = Boolean.FALSE;
    L104:
        this.showMessagePush = r114;
        if ((r110 & 8388608) != 0) goto L107;
        this.bioEdit = null;
    L109:
        if ((r110 & 16777216) != 0) goto L111;
        this.bio = null;
    L113:
        if ((33554432 & r110) != 0) goto L115;
        this.botStatic = null;
    L117:
        if ((67108864 & r110) != 0) goto L119;
        this.answerActions = null;
    L121:
        if ((134217728 & r110) != 0) goto L123;
        this.answerActionExposurePriority = null;
    L125:
        if ((268435456 & r110) != 0) goto L127;
        this.menuActions = null;
    L129:
        if ((536870912 & r110) != 0) goto L131;
        this.streamingAnswerActions = null;
    L133:
        if ((1073741824 & r110) != 0) goto L135;
        this.botConf = null;
    L137:
        if ((r110 & Integer.MIN_VALUE) != 0) goto L139;
        this.cameraTabConfigMap = null;
    L141:
        if ((r111 & 1) != 0) goto L143;
        int r104 = -1;
    L144:
        this.botMode = r104;
        if ((r111 & 2) != 0) goto L147;
        this.bgImgUrl = null;
    L149:
        if ((r111 & 4) != 0) goto L151;
        this.bgImgColor = null;
    L153:
        if ((r111 & 8) != 0) goto L155;
        this.bgVideoModel = null;
    L157:
        if ((r111 & 16) != 0) goto L159;
        this.iconPrompt = null;
    L161:
        if ((r111 & 32) != 0) goto L163;
        this.switchConfInfo = null;
    L165:
        if ((r111 & 64) != 0) goto L167;
        this.onBoarding = null;
    L169:
        if ((r111 & 128) != 0) goto L171;
        this.callerName = null;
    L173:
        if ((r111 & 256) != 0) goto L175;
        Boolean r105 = Boolean.FALSE;
    L176:
        this.callerNameSetting = r105;
        if ((r111 & 512) != 0) goto L179;
        this.sceneModelList = null;
    L181:
        if ((r111 & 1024) != 0) goto L183;
        this.disabled = false;
    L185:
        if ((r111 & 2048) != 0) goto L187;
        this.firstMet = null;
    L189:
        if ((r111 & 4096) != 0) goto L191;
        this.loadingConf = null;
    L193:
        if ((r111 & 8192) != 0) goto L195;
        this.botFeatureLabel = null;
    L197:
        if ((r111 & 16384) != 0) goto L199;
        this.bgImgUri = null;
    L201:
        if ((r111 & 32768) != 0) goto L203;
        this.bgImgInfo = null;
    L205:
        if ((r111 & 65536) != 0) goto L207;
        this.userBotGender = null;
    L209:
        if ((r111 & 131072) != 0) goto L211;
        this.userBotType = null;
    L213:
        if ((r111 & 262144) != 0) goto L215;
        this.botMemoryConfig = null;
    L217:
        if ((r111 & 524288) != 0) goto L219;
        this.dynamicImgUri = null;
    L221:
        if ((r111 & 1048576) != 0) goto L223;
        this.dynamicImgUrl = null;
    L225:
        if ((r111 & 2097152) != 0) goto L227;
        this.callImgConfig = null;
    L229:
        if ((r111 & 4194304) != 0) goto L231;
        this.botIconMappedAppIcon = null;
    L233:
        if ((r111 & 8388608) != 0) goto L235;
        this.messagePushSwitchConfirmTitle = null;
    L237:
        if ((r111 & 16777216) != 0) goto L239;
        this.msgRegenModeList = null;
    L241:
        if ((33554432 & r111) != 0) goto L243;
        this.unavailableInstructionTypeList = null;
    L245:
        if ((67108864 & r111) != 0) goto L247;
        this.likeInfo = null;
    L249:
        if ((134217728 & r111) != 0) goto L251;
        this.serviceBotConf = null;
    L253:
        if ((268435456 & r111) != 0) goto L255;
        this.actionScenes = null;
    L257:
        if ((536870912 & r111) != 0) goto L259;
        this.commentInfo = null;
    L261:
        if ((1073741824 & r111) != 0) goto L263;
        this.extra = null;
        return;
    L263:
        this.extra = r812;
        return;
    L259:
        this.commentInfo = r811;
        goto L261
    L255:
        this.actionScenes = r810;
        goto L257
    L251:
        this.serviceBotConf = r719;
        goto L253
    L247:
        this.likeInfo = r718;
        goto L249
    L243:
        this.unavailableInstructionTypeList = r717;
        goto L245
    L239:
        this.msgRegenModeList = r716;
        goto L241
    L235:
        this.messagePushSwitchConfirmTitle = r715;
        goto L237
    L231:
        this.botIconMappedAppIcon = r714;
        goto L233
    L227:
        this.callImgConfig = r713;
        goto L229
    L223:
        this.dynamicImgUrl = r712;
        goto L225
    L219:
        this.dynamicImgUri = r711;
        goto L221
    L215:
        this.botMemoryConfig = r710;
        goto L217
    L211:
        this.userBotType = r619;
        goto L213
    L207:
        this.userBotGender = r618;
        goto L209
    L203:
        this.bgImgInfo = r617;
        goto L205
    L199:
        this.bgImgUri = r616;
        goto L201
    L195:
        this.botFeatureLabel = r615;
        goto L197
    L191:
        this.loadingConf = r614;
        goto L193
    L187:
        this.firstMet = r613;
        goto L189
    L183:
        this.disabled = r612;
        goto L185
    L179:
        this.sceneModelList = r611;
        goto L181
    L175:
        r105 = r610;
        goto L176
    L171:
        this.callerName = r519;
        goto L173
    L167:
        this.onBoarding = r518;
        goto L169
    L163:
        this.switchConfInfo = r517;
        goto L165
    L159:
        this.iconPrompt = r516;
        goto L161
    L155:
        this.bgVideoModel = r515;
        goto L157
    L151:
        this.bgImgColor = r514;
        goto L153
    L147:
        this.bgImgUrl = r513;
        goto L149
    L143:
        r104 = r512;
        goto L144
    L139:
        this.cameraTabConfigMap = r511;
        goto L141
    L135:
        this.botConf = r510;
        goto L137
    L131:
        this.streamingAnswerActions = r419;
        goto L133
    L127:
        this.menuActions = r418;
        goto L129
    L123:
        this.answerActionExposurePriority = r417;
        goto L125
    L119:
        this.answerActions = r416;
        goto L121
    L115:
        this.botStatic = r415;
        goto L117
    L111:
        this.bio = r414;
        goto L113
    L107:
        this.bioEdit = r413;
        goto L109
    L103:
        r114 = r412;
        goto L104
    L99:
        r113 = r411;
        goto L100
    L95:
        this.recommendIndex = r410;
        goto L97
    L91:
        this.muted = r319;
        goto L93
    L87:
        this.editPos = r318;
        goto L89
    L83:
        this.voiceType = r317;
        goto L85
    L79:
        this.model = r316;
        goto L81
    L75:
        this.privateStatus = r315;
        goto L77
    L71:
        this.botRecommendStatus = r314;
        goto L73
    L67:
        this.botStatus = r313;
        goto L69
    L63:
        this.descriptionForHuman = r312;
        goto L65
    L59:
        this.descriptionForModel = r311;
        goto L61
    L55:
        this.conversationPage = r310;
        goto L57
    L51:
        this.selectTextActions = r218;
        goto L53
    L47:
        this.tagList = r217;
        goto L49
    L43:
        this.botCreatorInfo = r216;
        goto L45
    L39:
        this.shareInfo = r215;
        goto L41
    L35:
        this.botType = r214;
        goto L37
    L31:
        this.updateTime = r213;
        goto L33
    L27:
        r103 = r212;
        goto L28
    L23:
        this.iconImage = r211;
        goto L25
    L19:
        this.name = r210;
        goto L21
    L15:
        r102 = r112;
        goto L16
    L9:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public /* synthetic */ BotModel(String r610, String r611, BotIconImage r612, long r613, Long r614, Integer r710, ShareInfo r711, BotCreatorInfo r712, List r713, List r714, ConversationPage r715, String r716, String r717, Integer r718, Integer r719, Integer r810, ModelItem r811, SpeakerVoice r812, String r813, boolean r814, Integer r815, Boolean r816, Boolean r817, String r818, String r819, BotStatistic r910, List r911, List r912, List r913, List r914, List r915, Map r916, int r917, String r918, String r919, String r100, String r101, BotSwitchConfInfo r102, BotOnBoarding r103, String r104, Boolean r105, SceneModelList r106, boolean r107, FirstMet r108, BotLoadingConfig r109, String r110, String r111, BgImageInfo r112, String r113, String r114, BotMemoryConfig r115, String r116, String r117, CallImgConfig r118, String r119, MessagePushSwitchConfirmTitle r120, List r121, List r122, LikeInfo r123, String r124, List r125, BotCommentInfo r126, Map r127, int r128, int r129, DefaultConstructorMarker r130) {
        if ((r128 & 1) == 0) goto L5;
        String r131 = "";
    L7:
        if ((r128 & 2) == 0) goto L9;
        String r132 = null;
    L11:
        if ((r128 & 4) == 0) goto L13;
        BotIconImage r133 = null;
    L15:
        if ((r128 & 8) == 0) goto L17;
        long r134 = com.larus.im.internal.delegate.c.f348197a.currentTimeMillis();
    L19:
        if ((r128 & 16) == 0) goto L21;
        Long r135 = null;
    L23:
        if ((r128 & 32) == 0) goto L25;
        Integer r136 = null;
    L27:
        if ((r128 & 64) == 0) goto L29;
        ShareInfo r137 = null;
    L31:
        if ((r128 & 128) == 0) goto L33;
        BotCreatorInfo r138 = null;
    L35:
        if ((r128 & 256) == 0) goto L37;
        List r139 = null;
    L39:
        if ((r128 & 512) == 0) goto L41;
        List r140 = null;
    L43:
        if ((r128 & 1024) == 0) goto L45;
        ConversationPage r141 = null;
    L47:
        if ((r128 & 2048) == 0) goto L49;
        String r142 = null;
    L51:
        if ((r128 & 4096) == 0) goto L53;
        String r143 = null;
    L54:
        String r1310 = r143;
        if ((r128 & 8192) == 0) goto L57;
        Integer r144 = null;
    L58:
        Integer r145 = r144;
        if ((r128 & 16384) == 0) goto L61;
        Integer r146 = null;
    L63:
        if ((r128 & 32768) == 0) goto L65;
        Integer r147 = null;
    L67:
        if ((r128 & 65536) == 0) goto L69;
        ModelItem r210 = null;
    L71:
        if ((r128 & 131072) == 0) goto L73;
        SpeakerVoice r211 = null;
    L75:
        if ((r128 & 262144) == 0) goto L77;
        String r212 = null;
    L79:
        if ((r128 & 524288) == 0) goto L81;
        boolean r213 = false;
    L83:
        if ((r128 & 1048576) == 0) goto L85;
        Integer r214 = null;
    L87:
        if ((r128 & 2097152) == 0) goto L89;
        Boolean r215 = Boolean.FALSE;
    L91:
        if ((r128 & 4194304) == 0) goto L93;
        Boolean r310 = Boolean.FALSE;
    L95:
        if ((r128 & 8388608) == 0) goto L97;
        String r311 = null;
    L99:
        if ((r128 & 16777216) == 0) goto L101;
        String r312 = null;
    L103:
        if ((r128 & 33554432) == 0) goto L105;
        BotStatistic r313 = null;
    L107:
        if ((r128 & 67108864) == 0) goto L109;
        List r314 = null;
    L111:
        if ((r128 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        List r315 = null;
    L115:
        if ((r128 & 268435456) == 0) goto L117;
        List r316 = null;
    L119:
        if ((r128 & 536870912) == 0) goto L121;
        List r317 = null;
    L123:
        if ((r128 & 1073741824) == 0) goto L125;
        List r318 = null;
    L127:
        if ((r128 & Integer.MIN_VALUE) == 0) goto L129;
        Map r148 = null;
    L131:
        if ((r129 & 1) == 0) goto L133;
        int r319 = -1;
    L135:
        if ((r129 & 2) == 0) goto L137;
        String r410 = null;
    L139:
        if ((r129 & 4) == 0) goto L141;
        String r411 = null;
    L143:
        if ((r129 & 8) == 0) goto L145;
        String r412 = null;
    L147:
        if ((r129 & 16) == 0) goto L149;
        String r413 = null;
    L151:
        if ((r129 & 32) == 0) goto L153;
        BotSwitchConfInfo r414 = null;
    L155:
        if ((r129 & 64) == 0) goto L157;
        BotOnBoarding r415 = null;
    L158:
        Map r1210 = r148;
        if ((r129 & 128) == 0) goto L161;
        String r149 = null;
    L162:
        String r416 = r149;
        if ((r129 & 256) == 0) goto L165;
        Boolean r150 = Boolean.FALSE;
    L166:
        Boolean r417 = r150;
        if ((r129 & 512) == 0) goto L169;
        SceneModelList r151 = null;
    L170:
        SceneModelList r418 = r151;
        if ((r129 & 1024) == 0) goto L173;
        boolean r152 = false;
    L174:
        boolean r419 = r152;
        if ((r129 & 2048) == 0) goto L177;
        FirstMet r153 = null;
    L178:
        FirstMet r510 = r153;
        if ((r129 & 4096) == 0) goto L181;
        BotLoadingConfig r154 = null;
    L182:
        BotLoadingConfig r511 = r154;
        if ((r129 & 8192) == 0) goto L185;
        String r155 = null;
    L186:
        String r512 = r155;
        if ((r129 & 16384) == 0) goto L189;
        String r156 = null;
    L191:
        if ((r129 & 32768) == 0) goto L193;
        BgImageInfo r157 = null;
    L195:
        if ((r129 & 65536) == 0) goto L197;
        String r158 = null;
    L199:
        if ((r129 & 131072) == 0) goto L201;
        String r216 = null;
    L203:
        if ((r129 & 262144) == 0) goto L205;
        BotMemoryConfig r217 = null;
    L207:
        if ((r129 & 524288) == 0) goto L209;
        String r218 = null;
    L211:
        if ((r129 & 1048576) == 0) goto L213;
        String r219 = null;
    L215:
        if ((r129 & 2097152) == 0) goto L217;
        CallImgConfig r513 = null;
    L219:
        if ((r129 & 4194304) == 0) goto L221;
        String r514 = null;
    L223:
        if ((r129 & 8388608) == 0) goto L225;
        MessagePushSwitchConfirmTitle r515 = null;
    L227:
        if ((r129 & 16777216) == 0) goto L229;
        List r516 = null;
    L231:
        if ((r129 & 33554432) == 0) goto L233;
        List r517 = null;
    L235:
        if ((r129 & 67108864) == 0) goto L237;
        LikeInfo r518 = null;
    L239:
        if ((r129 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        String r519 = null;
    L243:
        if ((r129 & 268435456) == 0) goto L245;
        List r615 = null;
    L247:
        if ((r129 & 536870912) == 0) goto L249;
        BotCommentInfo r616 = null;
    L251:
        if ((r129 & 1073741824) == 0) goto L253;
        Map r159 = null;
    L254:
        this(r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r1310, r145, r146, r147, r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r1210, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r156, r157, r158, r216, r217, r218, r219, r513, r514, r515, r516, r517, r518, r519, r615, r616, r159);
        return;
    L253:
        r159 = r127;
        goto L254
    L249:
        r616 = r126;
        goto L251
    L245:
        r615 = r125;
        goto L247
    L241:
        r519 = r124;
        goto L243
    L237:
        r518 = r123;
        goto L239
    L233:
        r517 = r122;
        goto L235
    L229:
        r516 = r121;
        goto L231
    L225:
        r515 = r120;
        goto L227
    L221:
        r514 = r119;
        goto L223
    L217:
        r513 = r118;
        goto L219
    L213:
        r219 = r117;
        goto L215
    L209:
        r218 = r116;
        goto L211
    L205:
        r217 = r115;
        goto L207
    L201:
        r216 = r114;
        goto L203
    L197:
        r158 = r113;
        goto L199
    L193:
        r157 = r112;
        goto L195
    L189:
        r156 = r111;
        goto L191
    L185:
        r155 = r110;
        goto L186
    L181:
        r154 = r109;
        goto L182
    L177:
        r153 = r108;
        goto L178
    L173:
        r152 = r107;
        goto L174
    L169:
        r151 = r106;
        goto L170
    L165:
        r150 = r105;
        goto L166
    L161:
        r149 = r104;
        goto L162
    L157:
        r415 = r103;
        goto L158
    L153:
        r414 = r102;
        goto L155
    L149:
        r413 = r101;
        goto L151
    L145:
        r412 = r100;
        goto L147
    L141:
        r411 = r919;
        goto L143
    L137:
        r410 = r918;
        goto L139
    L133:
        r319 = r917;
        goto L135
    L129:
        r148 = r916;
        goto L131
    L125:
        r318 = r915;
        goto L127
    L121:
        r317 = r914;
        goto L123
    L117:
        r316 = r913;
        goto L119
    L113:
        r315 = r912;
        goto L115
    L109:
        r314 = r911;
        goto L111
    L105:
        r313 = r910;
        goto L107
    L101:
        r312 = r819;
        goto L103
    L97:
        r311 = r818;
        goto L99
    L93:
        r310 = r817;
        goto L95
    L89:
        r215 = r816;
        goto L91
    L85:
        r214 = r815;
        goto L87
    L81:
        r213 = r814;
        goto L83
    L77:
        r212 = r813;
        goto L79
    L73:
        r211 = r812;
        goto L75
    L69:
        r210 = r811;
        goto L71
    L65:
        r147 = r810;
        goto L67
    L61:
        r146 = r719;
        goto L63
    L57:
        r144 = r718;
        goto L58
    L53:
        r143 = r717;
        goto L54
    L49:
        r142 = r716;
        goto L51
    L45:
        r141 = r715;
        goto L47
    L41:
        r140 = r714;
        goto L43
    L37:
        r139 = r713;
        goto L39
    L33:
        r138 = r712;
        goto L35
    L29:
        r137 = r711;
        goto L31
    L25:
        r136 = r710;
        goto L27
    L21:
        r135 = r614;
        goto L23
    L17:
        r134 = r613;
        goto L19
    L13:
        r133 = r612;
        goto L15
    L9:
        r132 = r611;
        goto L11
    L5:
        r131 = r610;
        goto L7
    }
}
