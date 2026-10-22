package com.bytedance.locallife.groupon.struct;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.locallife.dito.common.data.UrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\bN\n\u0002\u0010\u000b\n\u0003\b¸\u0001\b\u0087\b\u0018\u0000 Ï\u00022\u00020\u0001:\u0002Ð\u0002BÍ\u0006\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014\u0012\u0016\b\u0002\u0010_\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010t\u001a\u00020\u0004\u0012\b\b\u0002\u0010u\u001a\u00020\u0004\u0012\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010w\u001a\u00020\u0004\u0012\b\b\u0002\u0010x\u001a\u00020\u0004\u0012\b\b\u0002\u0010y\u001a\u00020\u0004\u0012\b\b\u0002\u0010z\u001a\u00020\u0004\u0012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010<\u0012\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010>\u0012\t\b\u0002\u0010\u0084\u0001\u001a\u00020\"\u0012\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0004\u0012\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u00010J\u0012\t\b\u0002\u0010\u008f\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\bÍ\u0002\u0010Î\u0002J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\t\u0010\u0006J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0006J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0006J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fHÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0006J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b!\u0010\u0006J\u0012\u0010#\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b%\u0010$J\u0012\u0010&\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b&\u0010$J\u000b\u0010(\u001a\u0004\u0018\u00010'HÆ\u0003J\u0012\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b)\u0010\u0006J\u000b\u0010*\u001a\u0004\u0018\u00010'HÆ\u0003J\u0012\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b+\u0010\u0006J\u000b\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\u0012\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b0\u0010\u0006J\t\u00101\u001a\u00020\u0004HÆ\u0003J\t\u00102\u001a\u00020\u0004HÆ\u0003J\t\u00103\u001a\u00020\u0004HÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b6\u0010\u0006J\u000b\u00107\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010;\u001a\u00020\u0004HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010<HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010>HÆ\u0003J\t\u0010@\u001a\u00020\"HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010B\u001a\u00020\u0004HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010D\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bD\u0010\u0006J\t\u0010E\u001a\u00020\u0004HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010G\u001a\u00020\u0004HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010JHÆ\u0003J\t\u0010L\u001a\u00020\u0004HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0002HÆ\u0003J×\u0006\u0010\u0094\u0001\u001a\u00020\u00002\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0016\b\u0002\u0010_\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010p\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010t\u001a\u00020\u00042\b\b\u0002\u0010u\u001a\u00020\u00042\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u00042\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00022\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010<2\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010>2\t\b\u0002\u0010\u0084\u0001\u001a\u00020\"2\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00022\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00042\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00022\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u00010J2\t\b\u0002\u0010\u008f\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\n\u0010\u0096\u0001\u001a\u00020\u0002HÖ\u0001J\n\u0010\u0097\u0001\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u009a\u0001\u001a\u00030\u0099\u00012\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003R)\u0010Q\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bQ\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R(\u0010R\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bR\u0010 \u0001\u001a\u0005\b¡\u0001\u0010\u0006\"\u0006\b¢\u0001\u0010£\u0001R(\u0010S\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bS\u0010 \u0001\u001a\u0005\b¤\u0001\u0010\u0006\"\u0006\b¥\u0001\u0010£\u0001R)\u0010T\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bT\u0010\u009b\u0001\u001a\u0006\b¦\u0001\u0010\u009d\u0001\"\u0006\b§\u0001\u0010\u009f\u0001R(\u0010U\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bU\u0010 \u0001\u001a\u0005\b¨\u0001\u0010\u0006\"\u0006\b©\u0001\u0010£\u0001R(\u0010V\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bV\u0010 \u0001\u001a\u0005\bª\u0001\u0010\u0006\"\u0006\b«\u0001\u0010£\u0001R)\u0010W\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bW\u0010\u009b\u0001\u001a\u0006\b¬\u0001\u0010\u009d\u0001\"\u0006\b\u00ad\u0001\u0010\u009f\u0001R)\u0010X\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bX\u0010\u009b\u0001\u001a\u0006\b®\u0001\u0010\u009d\u0001\"\u0006\b¯\u0001\u0010\u009f\u0001R)\u0010Y\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bY\u0010\u009b\u0001\u001a\u0006\b°\u0001\u0010\u009d\u0001\"\u0006\b±\u0001\u0010\u009f\u0001R(\u0010Z\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bZ\u0010 \u0001\u001a\u0005\b²\u0001\u0010\u0006\"\u0006\b³\u0001\u0010£\u0001R/\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b[\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R(\u0010\\\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\b\\\u0010 \u0001\u001a\u0005\b¹\u0001\u0010\u0006\"\u0006\bº\u0001\u0010£\u0001R/\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b]\u0010´\u0001\u001a\u0006\b»\u0001\u0010¶\u0001\"\u0006\b¼\u0001\u0010¸\u0001R5\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b^\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R5\u0010_\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b_\u0010½\u0001\u001a\u0006\bÂ\u0001\u0010¿\u0001\"\u0006\bÃ\u0001\u0010Á\u0001R)\u0010`\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b`\u0010\u009b\u0001\u001a\u0006\bÄ\u0001\u0010\u009d\u0001\"\u0006\bÅ\u0001\u0010\u009f\u0001R)\u0010a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\ba\u0010\u009b\u0001\u001a\u0006\bÆ\u0001\u0010\u009d\u0001\"\u0006\bÇ\u0001\u0010\u009f\u0001R(\u0010b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bb\u0010 \u0001\u001a\u0005\bÈ\u0001\u0010\u0006\"\u0006\bÉ\u0001\u0010£\u0001R)\u0010c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bc\u0010\u009b\u0001\u001a\u0006\bÊ\u0001\u0010\u009d\u0001\"\u0006\bË\u0001\u0010\u009f\u0001R)\u0010d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bd\u0010\u009b\u0001\u001a\u0006\bÌ\u0001\u0010\u009d\u0001\"\u0006\bÍ\u0001\u0010\u009f\u0001R)\u0010e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\be\u0010\u009b\u0001\u001a\u0006\bÎ\u0001\u0010\u009d\u0001\"\u0006\bÏ\u0001\u0010\u009f\u0001R)\u0010f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bf\u0010\u009b\u0001\u001a\u0006\bÐ\u0001\u0010\u009d\u0001\"\u0006\bÑ\u0001\u0010\u009f\u0001R)\u0010g\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bg\u0010\u009b\u0001\u001a\u0006\bÒ\u0001\u0010\u009d\u0001\"\u0006\bÓ\u0001\u0010\u009f\u0001R)\u0010h\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bh\u0010\u009b\u0001\u001a\u0006\bÔ\u0001\u0010\u009d\u0001\"\u0006\bÕ\u0001\u0010\u009f\u0001R)\u0010i\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bi\u0010\u009b\u0001\u001a\u0006\bÖ\u0001\u0010\u009d\u0001\"\u0006\b×\u0001\u0010\u009f\u0001R(\u0010j\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bj\u0010 \u0001\u001a\u0005\bØ\u0001\u0010\u0006\"\u0006\bÙ\u0001\u0010£\u0001R(\u0010k\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bk\u0010Ú\u0001\u001a\u0005\bÛ\u0001\u0010$\"\u0006\bÜ\u0001\u0010Ý\u0001R(\u0010l\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bl\u0010Ú\u0001\u001a\u0005\bÞ\u0001\u0010$\"\u0006\bß\u0001\u0010Ý\u0001R(\u0010m\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bm\u0010Ú\u0001\u001a\u0005\bà\u0001\u0010$\"\u0006\bá\u0001\u0010Ý\u0001R)\u0010n\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bn\u0010â\u0001\u001a\u0006\bã\u0001\u0010ä\u0001\"\u0006\bå\u0001\u0010æ\u0001R(\u0010o\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bo\u0010 \u0001\u001a\u0005\bç\u0001\u0010\u0006\"\u0006\bè\u0001\u0010£\u0001R)\u0010p\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bp\u0010â\u0001\u001a\u0006\bé\u0001\u0010ä\u0001\"\u0006\bê\u0001\u0010æ\u0001R(\u0010q\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bq\u0010 \u0001\u001a\u0005\bë\u0001\u0010\u0006\"\u0006\bì\u0001\u0010£\u0001R)\u0010r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\br\u0010\u009b\u0001\u001a\u0006\bí\u0001\u0010\u009d\u0001\"\u0006\bî\u0001\u0010\u009f\u0001R)\u0010s\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bs\u0010\u009b\u0001\u001a\u0006\bï\u0001\u0010\u009d\u0001\"\u0006\bð\u0001\u0010\u009f\u0001R'\u0010t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bt\u0010ñ\u0001\u001a\u0006\bò\u0001\u0010ó\u0001\"\u0006\bô\u0001\u0010õ\u0001R'\u0010u\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bu\u0010ñ\u0001\u001a\u0006\bö\u0001\u0010ó\u0001\"\u0006\b÷\u0001\u0010õ\u0001R(\u0010v\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bv\u0010 \u0001\u001a\u0005\bø\u0001\u0010\u0006\"\u0006\bù\u0001\u0010£\u0001R'\u0010w\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bw\u0010ñ\u0001\u001a\u0006\bú\u0001\u0010ó\u0001\"\u0006\bû\u0001\u0010õ\u0001R'\u0010x\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bx\u0010ñ\u0001\u001a\u0006\bü\u0001\u0010ó\u0001\"\u0006\bý\u0001\u0010õ\u0001R'\u0010y\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\by\u0010ñ\u0001\u001a\u0006\bþ\u0001\u0010ó\u0001\"\u0006\bÿ\u0001\u0010õ\u0001R'\u0010z\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bz\u0010ñ\u0001\u001a\u0006\b\u0080\u0002\u0010ó\u0001\"\u0006\b\u0081\u0002\u0010õ\u0001R)\u0010{\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b{\u0010\u009b\u0001\u001a\u0006\b\u0082\u0002\u0010\u009d\u0001\"\u0006\b\u0083\u0002\u0010\u009f\u0001R(\u0010|\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\b|\u0010 \u0001\u001a\u0005\b\u0084\u0002\u0010\u0006\"\u0006\b\u0085\u0002\u0010£\u0001R)\u0010}\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b}\u0010\u009b\u0001\u001a\u0006\b\u0086\u0002\u0010\u009d\u0001\"\u0006\b\u0087\u0002\u0010\u009f\u0001R)\u0010~\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b~\u0010\u009b\u0001\u001a\u0006\b\u0088\u0002\u0010\u009d\u0001\"\u0006\b\u0089\u0002\u0010\u009f\u0001R)\u0010\u007f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u009b\u0001\u001a\u0006\b\u008a\u0002\u0010\u009d\u0001\"\u0006\b\u008b\u0002\u0010\u009f\u0001R+\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u009b\u0001\u001a\u0006\b\u008c\u0002\u0010\u009d\u0001\"\u0006\b\u008d\u0002\u0010\u009f\u0001R)\u0010\u0081\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010ñ\u0001\u001a\u0006\b\u008e\u0002\u0010ó\u0001\"\u0006\b\u008f\u0002\u0010õ\u0001R+\u0010\u0082\u0001\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0090\u0002\u001a\u0006\b\u0091\u0002\u0010\u0092\u0002\"\u0006\b\u0093\u0002\u0010\u0094\u0002R+\u0010\u0083\u0001\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0095\u0002\u001a\u0006\b\u0096\u0002\u0010\u0097\u0002\"\u0006\b\u0098\u0002\u0010\u0099\u0002R)\u0010\u0084\u0001\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u009a\u0002\u001a\u0006\b\u009b\u0002\u0010\u009c\u0002\"\u0006\b\u009d\u0002\u0010\u009e\u0002R+\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u009b\u0001\u001a\u0006\b\u009f\u0002\u0010\u009d\u0001\"\u0006\b \u0002\u0010\u009f\u0001R)\u0010\u0086\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010ñ\u0001\u001a\u0006\b¡\u0002\u0010ó\u0001\"\u0006\b¢\u0002\u0010õ\u0001R+\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u009b\u0001\u001a\u0006\b£\u0002\u0010\u009d\u0001\"\u0006\b¤\u0002\u0010\u009f\u0001R*\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\b\u0088\u0001\u0010 \u0001\u001a\u0005\b¥\u0002\u0010\u0006\"\u0006\b¦\u0002\u0010£\u0001R)\u0010\u0089\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010ñ\u0001\u001a\u0006\b§\u0002\u0010ó\u0001\"\u0006\b¨\u0002\u0010õ\u0001R+\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u009b\u0001\u001a\u0006\b©\u0002\u0010\u009d\u0001\"\u0006\bª\u0002\u0010\u009f\u0001R)\u0010\u008b\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010ñ\u0001\u001a\u0006\b«\u0002\u0010ó\u0001\"\u0006\b¬\u0002\u0010õ\u0001R+\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u009b\u0001\u001a\u0006\b\u00ad\u0002\u0010\u009d\u0001\"\u0006\b®\u0002\u0010\u009f\u0001R+\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u009b\u0001\u001a\u0006\b¯\u0002\u0010\u009d\u0001\"\u0006\b°\u0002\u0010\u009f\u0001R+\u0010\u008e\u0001\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010±\u0002\u001a\u0006\b²\u0002\u0010³\u0002\"\u0006\b´\u0002\u0010µ\u0002R)\u0010\u008f\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008f\u0001\u0010ñ\u0001\u001a\u0006\b¶\u0002\u0010ó\u0001\"\u0006\b·\u0002\u0010õ\u0001R+\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u009b\u0001\u001a\u0006\b¸\u0002\u0010\u009d\u0001\"\u0006\b¹\u0002\u0010\u009f\u0001R+\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u009b\u0001\u001a\u0006\bº\u0002\u0010\u009d\u0001\"\u0006\b»\u0002\u0010\u009f\u0001R+\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u009b\u0001\u001a\u0006\b¼\u0002\u0010\u009d\u0001\"\u0006\b½\u0002\u0010\u009f\u0001R+\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u009b\u0001\u001a\u0006\b¾\u0002\u0010\u009d\u0001\"\u0006\b¿\u0002\u0010\u009f\u0001R*\u0010À\u0002\u001a\u00030\u0099\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÀ\u0002\u0010Á\u0002\u001a\u0006\bÀ\u0002\u0010Â\u0002\"\u0006\bÃ\u0002\u0010Ä\u0002R)\u0010Å\u0002\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÅ\u0002\u0010\u009a\u0002\u001a\u0006\bÆ\u0002\u0010\u009c\u0002\"\u0006\bÇ\u0002\u0010\u009e\u0002R*\u0010È\u0002\u001a\u00030\u0099\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÈ\u0002\u0010Á\u0002\u001a\u0006\bÈ\u0002\u0010Â\u0002\"\u0006\bÉ\u0002\u0010Ä\u0002R)\u0010Ê\u0002\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÊ\u0002\u0010\u009a\u0002\u001a\u0006\bË\u0002\u0010\u009c\u0002\"\u0006\bÌ\u0002\u0010\u009e\u0002¨\u0006Ñ\u0002"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/GrouponGeneralBubbleStruct;", "", "", "component1", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "", "Lcom/bytedance/locallife/groupon/struct/GrouponGeneralBubbleFrequencyBean;", "component11", "component12", "component13", "", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "", "component27", "()Ljava/lang/Long;", "component28", "component29", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "Lcom/bytedance/locallife/groupon/struct/GrouponRebootRecoverDotConfig;", "component50", "Lcom/bytedance/locallife/groupon/struct/GrouponGuideDoubleCheckConfig;", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "Lcom/bytedance/locallife/groupon/struct/GrouponBubbleDotOnShowAction;", "component62", "component63", "component64", "component65", "component66", "component67", "bubbleId", "bubbleAction", "type", "bubbleText", "style", "scene", "nearbyBubbleComponentId", "grouponBubbleComponentId", "dotText", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "freqKeyArray", "throttleTime", "commonAvoidDisable", "avoidOtherBubbleType", "avoidOtherBubbleTypeSec", "feedGidInfo", "diamondTransInfo", "firstPullScene", "commonTransInfo", "bubbleTypeCategory", "noticeCategory", "extraDiamondTrackParam", "extraFeedTrackParam", "exposeMsg", "impressionSvrData", "priority", "validTime", "redDotRemoveTimestamp", "redDotRemoveTime", "bubbleImgUrl", "bubbleImgType", "bubbleIconUrl", "bubbleShowDuration", "limitUid", "limitDid", "bubbleShowOutClick", "rebootRecoverDot", "dotStyle", "removeDotUserChange", "notDotUndertake", ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE, "dotPriority", "guideContext", "guideContextTrigger", "floatBackInfo", "diamondUpdateInfo", "forceCity", "preTipText", "clearForceCity", "rebootRecoverDotConfig", "guideDoubleCheckConfig", "dotDowngradeTime", "searchTransInfo", "exposeUploadType", "nearbySubPage", "openSubPageTrigger", "pageType", "grouponSearchParam", "substitutePageType", "nearbyDotComponentId", "grouponDotComponentId", "onShowAction", "uploadImpressionScene", "enterBubble", "resourceTransInfo", "atomicTask", "extraResourceTrackParam", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/Integer;Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;IIIILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/locallife/groupon/struct/GrouponRebootRecoverDotConfig;Lcom/bytedance/locallife/groupon/struct/GrouponGuideDoubleCheckConfig;JLjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/GrouponBubbleDotOnShowAction;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/locallife/groupon/struct/GrouponGeneralBubbleStruct;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getBubbleId", "()Ljava/lang/String;", "setBubbleId", "(Ljava/lang/String;)V", "Ljava/lang/Integer;", "getBubbleAction", "setBubbleAction", "(Ljava/lang/Integer;)V", "getType", "setType", "getBubbleText", "setBubbleText", "getStyle", "setStyle", "getScene", "setScene", "getNearbyBubbleComponentId", "setNearbyBubbleComponentId", "getGrouponBubbleComponentId", "setGrouponBubbleComponentId", "getDotText", "setDotText", "getSceneType", "setSceneType", "Ljava/util/List;", "getFreqKeyArray", "()Ljava/util/List;", "setFreqKeyArray", "(Ljava/util/List;)V", "getThrottleTime", "setThrottleTime", "getCommonAvoidDisable", "setCommonAvoidDisable", "Ljava/util/Map;", "getAvoidOtherBubbleType", "()Ljava/util/Map;", "setAvoidOtherBubbleType", "(Ljava/util/Map;)V", "getAvoidOtherBubbleTypeSec", "setAvoidOtherBubbleTypeSec", "getFeedGidInfo", "setFeedGidInfo", "getDiamondTransInfo", "setDiamondTransInfo", "getFirstPullScene", "setFirstPullScene", "getCommonTransInfo", "setCommonTransInfo", "getBubbleTypeCategory", "setBubbleTypeCategory", "getNoticeCategory", "setNoticeCategory", "getExtraDiamondTrackParam", "setExtraDiamondTrackParam", "getExtraFeedTrackParam", "setExtraFeedTrackParam", "getExposeMsg", "setExposeMsg", "getImpressionSvrData", "setImpressionSvrData", "getPriority", "setPriority", "Ljava/lang/Long;", "getValidTime", "setValidTime", "(Ljava/lang/Long;)V", "getRedDotRemoveTimestamp", "setRedDotRemoveTimestamp", "getRedDotRemoveTime", "setRedDotRemoveTime", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "getBubbleImgUrl", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "setBubbleImgUrl", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;)V", "getBubbleImgType", "setBubbleImgType", "getBubbleIconUrl", "setBubbleIconUrl", "getBubbleShowDuration", "setBubbleShowDuration", "getLimitUid", "setLimitUid", "getLimitDid", "setLimitDid", "I", "getBubbleShowOutClick", "()I", "setBubbleShowOutClick", "(I)V", "getRebootRecoverDot", "setRebootRecoverDot", "getDotStyle", "setDotStyle", "getRemoveDotUserChange", "setRemoveDotUserChange", "getNotDotUndertake", "setNotDotUndertake", "getAttribute", "setAttribute", "getDotPriority", "setDotPriority", "getGuideContext", "setGuideContext", "getGuideContextTrigger", "setGuideContextTrigger", "getFloatBackInfo", "setFloatBackInfo", "getDiamondUpdateInfo", "setDiamondUpdateInfo", "getForceCity", "setForceCity", "getPreTipText", "setPreTipText", "getClearForceCity", "setClearForceCity", "Lcom/bytedance/locallife/groupon/struct/GrouponRebootRecoverDotConfig;", "getRebootRecoverDotConfig", "()Lcom/bytedance/locallife/groupon/struct/GrouponRebootRecoverDotConfig;", "setRebootRecoverDotConfig", "(Lcom/bytedance/locallife/groupon/struct/GrouponRebootRecoverDotConfig;)V", "Lcom/bytedance/locallife/groupon/struct/GrouponGuideDoubleCheckConfig;", "getGuideDoubleCheckConfig", "()Lcom/bytedance/locallife/groupon/struct/GrouponGuideDoubleCheckConfig;", "setGuideDoubleCheckConfig", "(Lcom/bytedance/locallife/groupon/struct/GrouponGuideDoubleCheckConfig;)V", "J", "getDotDowngradeTime", "()J", "setDotDowngradeTime", "(J)V", "getSearchTransInfo", "setSearchTransInfo", "getExposeUploadType", "setExposeUploadType", "getNearbySubPage", "setNearbySubPage", "getOpenSubPageTrigger", "setOpenSubPageTrigger", "getPageType", "setPageType", "getGrouponSearchParam", "setGrouponSearchParam", "getSubstitutePageType", "setSubstitutePageType", "getNearbyDotComponentId", "setNearbyDotComponentId", "getGrouponDotComponentId", "setGrouponDotComponentId", "Lcom/bytedance/locallife/groupon/struct/GrouponBubbleDotOnShowAction;", "getOnShowAction", "()Lcom/bytedance/locallife/groupon/struct/GrouponBubbleDotOnShowAction;", "setOnShowAction", "(Lcom/bytedance/locallife/groupon/struct/GrouponBubbleDotOnShowAction;)V", "getUploadImpressionScene", "setUploadImpressionScene", "getEnterBubble", "setEnterBubble", "getResourceTransInfo", "setResourceTransInfo", "getAtomicTask", "setAtomicTask", "getExtraResourceTrackParam", "setExtraResourceTrackParam", "isRebootDot", "Z", "()Z", "setRebootDot", "(Z)V", "messageGetTime", "getMessageGetTime", "setMessageGetTime", "isCachedInMemory", "setCachedInMemory", "bubbleShowTime", "getBubbleShowTime", "setBubbleShowTime", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/Integer;Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;IIIILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/locallife/groupon/struct/GrouponRebootRecoverDotConfig;Lcom/bytedance/locallife/groupon/struct/GrouponGuideDoubleCheckConfig;JLjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/GrouponBubbleDotOnShowAction;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class GrouponGeneralBubbleStruct {
    public static final a Companion = null;
    public static final int DEFAULT_BUBBLE_SHOW_DURATION = 5;
    public static final int DEFAULT_FIRST_PULL_SCENE = 0;
    public static final int DEFAULT_PRIORITY = 0;
    public static final long DEFAULT_RED_DOT_REMAIN_TIME = 300;
    public static final long DEFAULT_RED_DOT_REMOVE_TIME = 0;
    public static final int DEFAULT_STYLE = 1;
    public static final long DEFAULT_VALID_TIME = 0;

    @SerializedName("atomic_task")
    private String atomicTask;

    @SerializedName(ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE)
    private int attribute;

    @SerializedName("avoid_other_bubble_type")
    private Map<Integer, Integer> avoidOtherBubbleType;

    @SerializedName("avoid_other_bubble_type_second")
    private Map<Integer, Integer> avoidOtherBubbleTypeSec;

    @SerializedName("bubble_action")
    private Integer bubbleAction;

    @SerializedName("bubble_icon_url")
    private UrlModel bubbleIconUrl;

    @SerializedName("bubble_id")
    private String bubbleId;

    @SerializedName("bubble_img_type")
    private Integer bubbleImgType;

    @SerializedName("bubble_img_url")
    private UrlModel bubbleImgUrl;

    @SerializedName("bubble_show_duration")
    private Integer bubbleShowDuration;

    @SerializedName("bubble_show_out_click")
    private int bubbleShowOutClick;
    private long bubbleShowTime;

    @SerializedName("bubble_text")
    private String bubbleText;

    @SerializedName("bubble_type_category")
    private String bubbleTypeCategory;

    @SerializedName("clear_force_city")
    private int clearForceCity;

    @SerializedName("common_avoid_disable")
    private List<Integer> commonAvoidDisable;

    @SerializedName("common_trans_info")
    private String commonTransInfo;

    @SerializedName("diamond_trans_info")
    private String diamondTransInfo;

    @SerializedName("diamond_update_info")
    private String diamondUpdateInfo;

    @SerializedName("dot_downgrade_time")
    private long dotDowngradeTime;

    @SerializedName("dot_priority")
    private int dotPriority;

    @SerializedName("dot_style")
    private Integer dotStyle;

    @SerializedName("dot_text")
    private String dotText;

    @SerializedName("enter_bubble")
    private String enterBubble;

    @SerializedName("expose_msg")
    private String exposeMsg;

    @SerializedName("expose_upload_type")
    private int exposeUploadType;

    @SerializedName("extra_diamond_track_param")
    private String extraDiamondTrackParam;

    @SerializedName("extra_feed_track_param")
    private String extraFeedTrackParam;

    @SerializedName("extra_resource_track_param")
    private String extraResourceTrackParam;

    @SerializedName("feed_gid_info")
    private String feedGidInfo;

    @SerializedName("first_pull_scene")
    private Integer firstPullScene;

    @SerializedName("float_back_info")
    private String floatBackInfo;

    @SerializedName("force_city")
    private String forceCity;

    @SerializedName("freq_key_array")
    private List<GrouponGeneralBubbleFrequencyBean> freqKeyArray;

    @SerializedName("groupon_bubble_component_id")
    private String grouponBubbleComponentId;

    @SerializedName("groupon_dot_component_id")
    private String grouponDotComponentId;

    @SerializedName("groupon_search_params")
    private String grouponSearchParam;

    @SerializedName("guide_context")
    private String guideContext;

    @SerializedName("guide_context_trigger")
    private Integer guideContextTrigger;

    @SerializedName("guide_double_check_config")
    private GrouponGuideDoubleCheckConfig guideDoubleCheckConfig;

    @SerializedName("impression_svr_data")
    private String impressionSvrData;
    private boolean isCachedInMemory;
    private boolean isRebootDot;

    @SerializedName("limit_did")
    private String limitDid;

    @SerializedName("limit_uid")
    private String limitUid;
    private long messageGetTime;

    @SerializedName("nearby_bubble_component_id")
    private String nearbyBubbleComponentId;

    @SerializedName("nearby_dot_component_id")
    private String nearbyDotComponentId;

    @SerializedName("open_sub_page")
    private String nearbySubPage;

    @SerializedName("not_dot_undertake")
    private int notDotUndertake;

    @SerializedName("notice_category")
    private String noticeCategory;

    @SerializedName("on_show_action")
    private GrouponBubbleDotOnShowAction onShowAction;

    @SerializedName("open_sub_page_trigger")
    private Integer openSubPageTrigger;

    @SerializedName("page_type")
    private int pageType;

    @SerializedName("pre_tip_text")
    private String preTipText;

    @SerializedName("priority")
    private Integer priority;

    @SerializedName("reboot_recover_dot")
    private int rebootRecoverDot;

    @SerializedName("reboot_recover_dot_config")
    private GrouponRebootRecoverDotConfig rebootRecoverDotConfig;

    @SerializedName("red_dot_remove_time")
    private Long redDotRemoveTime;

    @SerializedName("red_dot_remove_timestamp")
    private Long redDotRemoveTimestamp;

    @SerializedName("remove_dot_user_change")
    private int removeDotUserChange;

    @SerializedName("resource_trans_info")
    private String resourceTransInfo;

    @SerializedName("scene")
    private Integer scene;

    @SerializedName("scene_type")
    private Integer sceneType;

    @SerializedName("search_trans_info")
    private String searchTransInfo;

    @SerializedName("style")
    private Integer style;

    @SerializedName("substitute_page_type")
    private int substitutePageType;

    @SerializedName("throttle_time")
    private Integer throttleTime;

    @SerializedName("type")
    private Integer type;

    @SerializedName("upload_impression_scene")
    private int uploadImpressionScene;

    @SerializedName("valid_time")
    private Long validTime;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public GrouponGeneralBubbleStruct() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, 0, 0, 0, 0, null, null, null, null, null, null, 0, null, null, 0, null, 0, null, null, 0, null, 0, null, null, null, 0, null, null, null, null, -1, -1, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GrouponGeneralBubbleStruct copy$default(GrouponGeneralBubbleStruct r210, String r211, Integer r212, Integer r213, String r214, Integer r215, Integer r310, String r311, String r312, String r313, Integer r314, List r315, Integer r316, List r317, Map r318, Map r319, String r410, String r411, Integer r412, String r413, String r414, String r415, String r416, String r417, String r418, String r419, Integer r510, Long r511, Long r512, Long r513, UrlModel r514, Integer r515, UrlModel r516, Integer r517, String r518, String r519, int r610, int r611, Integer r612, int r613, int r614, int r615, int r616, String r617, Integer r618, String r619, String r710, String r711, String r712, int r713, GrouponRebootRecoverDotConfig r714, GrouponGuideDoubleCheckConfig r715, long r716, String r717, int r718, String r810, Integer r811, int r812, String r813, int r814, String r815, String r816, GrouponBubbleDotOnShowAction r817, int r818, String r819, String r910, String r911, String r912, int r913, int r914, int r915, Object r916) {
        if ((r913 & 1) == 0) goto L5;
        String r100 = r210.bubbleId;
    L7:
        if ((r913 & 2) == 0) goto L9;
        Integer r101 = r210.bubbleAction;
    L11:
        if ((r913 & 4) == 0) goto L13;
        Integer r102 = r210.type;
    L15:
        if ((r913 & 8) == 0) goto L17;
        String r103 = r210.bubbleText;
    L19:
        if ((r913 & 16) == 0) goto L21;
        Integer r104 = r210.style;
    L23:
        if ((r913 & 32) == 0) goto L25;
        Integer r105 = r210.scene;
    L27:
        if ((r913 & 64) == 0) goto L29;
        String r106 = r210.nearbyBubbleComponentId;
    L31:
        if ((r913 & 128) == 0) goto L33;
        String r110 = r210.grouponBubbleComponentId;
    L35:
        if ((r913 & 256) == 0) goto L37;
        String r111 = r210.dotText;
    L39:
        if ((r913 & 512) == 0) goto L41;
        Integer r112 = r210.sceneType;
    L43:
        if ((r913 & 1024) == 0) goto L45;
        List r113 = r210.freqKeyArray;
    L47:
        if ((r913 & 2048) == 0) goto L49;
        Integer r114 = r210.throttleTime;
    L51:
        if ((r913 & 4096) == 0) goto L53;
        List r115 = r210.commonAvoidDisable;
    L54:
        List r320 = r115;
        if ((r913 & 8192) == 0) goto L57;
        Map r116 = r210.avoidOtherBubbleType;
    L58:
        Map r321 = r116;
        if ((r913 & 16384) == 0) goto L61;
        Map r117 = r210.avoidOtherBubbleTypeSec;
    L62:
        Map r322 = r117;
        if ((r913 & 32768) == 0) goto L65;
        String r118 = r210.feedGidInfo;
    L66:
        String r420 = r118;
        if ((r913 & 65536) == 0) goto L69;
        String r119 = r210.diamondTransInfo;
    L70:
        String r421 = r119;
        if ((r913 & 131072) == 0) goto L73;
        Integer r120 = r210.firstPullScene;
    L74:
        Integer r422 = r120;
        if ((r913 & 262144) == 0) goto L77;
        String r121 = r210.commonTransInfo;
    L78:
        String r423 = r121;
        if ((r913 & 524288) == 0) goto L81;
        String r122 = r210.bubbleTypeCategory;
    L82:
        String r424 = r122;
        if ((r913 & 1048576) == 0) goto L85;
        String r123 = r210.noticeCategory;
    L86:
        String r425 = r123;
        if ((r913 & 2097152) == 0) goto L89;
        String r124 = r210.extraDiamondTrackParam;
    L90:
        String r426 = r124;
        if ((r913 & 4194304) == 0) goto L93;
        String r125 = r210.extraFeedTrackParam;
    L94:
        String r427 = r125;
        if ((r913 & 8388608) == 0) goto L97;
        String r126 = r210.exposeMsg;
    L98:
        String r428 = r126;
        if ((r913 & 16777216) == 0) goto L101;
        String r127 = r210.impressionSvrData;
    L102:
        String r429 = r127;
        if ((r913 & 33554432) == 0) goto L105;
        Integer r128 = r210.priority;
    L106:
        Integer r520 = r128;
        if ((r913 & 67108864) == 0) goto L109;
        Long r129 = r210.validTime;
    L110:
        Long r521 = r129;
        if ((r913 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Long r130 = r210.redDotRemoveTimestamp;
    L114:
        Long r522 = r130;
        if ((r913 & 268435456) == 0) goto L117;
        Long r131 = r210.redDotRemoveTime;
    L118:
        Long r523 = r131;
        if ((r913 & 536870912) == 0) goto L121;
        UrlModel r132 = r210.bubbleImgUrl;
    L122:
        UrlModel r524 = r132;
        if ((r913 & 1073741824) == 0) goto L125;
        Integer r133 = r210.bubbleImgType;
    L127:
        if ((r913 & Integer.MIN_VALUE) == 0) goto L129;
        UrlModel r107 = r210.bubbleIconUrl;
    L130:
        UrlModel r525 = r107;
        if ((r914 & 1) == 0) goto L133;
        Integer r108 = r210.bubbleShowDuration;
    L134:
        Integer r526 = r108;
        if ((r914 & 2) == 0) goto L137;
        String r109 = r210.limitUid;
    L138:
        String r527 = r109;
        if ((r914 & 4) == 0) goto L141;
        String r134 = r210.limitDid;
    L142:
        String r528 = r134;
        if ((r914 & 8) == 0) goto L145;
        int r135 = r210.bubbleShowOutClick;
    L146:
        int r620 = r135;
        if ((r914 & 16) == 0) goto L149;
        int r136 = r210.rebootRecoverDot;
    L150:
        int r621 = r136;
        if ((r914 & 32) == 0) goto L153;
        Integer r137 = r210.dotStyle;
    L154:
        Integer r622 = r137;
        if ((r914 & 64) == 0) goto L157;
        int r138 = r210.removeDotUserChange;
    L158:
        int r623 = r138;
        if ((r914 & 128) == 0) goto L161;
        int r139 = r210.notDotUndertake;
    L162:
        int r624 = r139;
        if ((r914 & 256) == 0) goto L165;
        int r140 = r210.attribute;
    L166:
        int r625 = r140;
        if ((r914 & 512) == 0) goto L169;
        int r141 = r210.dotPriority;
    L170:
        int r626 = r141;
        if ((r914 & 1024) == 0) goto L173;
        String r142 = r210.guideContext;
    L174:
        String r627 = r142;
        if ((r914 & 2048) == 0) goto L177;
        Integer r143 = r210.guideContextTrigger;
    L178:
        Integer r628 = r143;
        if ((r914 & 4096) == 0) goto L181;
        String r144 = r210.floatBackInfo;
    L182:
        String r629 = r144;
        if ((r914 & 8192) == 0) goto L185;
        String r145 = r210.diamondUpdateInfo;
    L186:
        String r719 = r145;
        if ((r914 & 16384) == 0) goto L189;
        String r146 = r210.forceCity;
    L190:
        String r720 = r146;
        if ((r914 & 32768) == 0) goto L193;
        String r147 = r210.preTipText;
    L194:
        String r721 = r147;
        if ((r914 & 65536) == 0) goto L197;
        int r148 = r210.clearForceCity;
    L198:
        int r722 = r148;
        if ((r914 & 131072) == 0) goto L201;
        GrouponRebootRecoverDotConfig r149 = r210.rebootRecoverDotConfig;
    L202:
        GrouponRebootRecoverDotConfig r723 = r149;
        if ((r914 & 262144) == 0) goto L205;
        GrouponGuideDoubleCheckConfig r150 = r210.guideDoubleCheckConfig;
    L206:
        Integer r323 = r114;
        Integer r529 = r133;
        if ((r914 & 524288) == 0) goto L209;
        long r151 = r210.dotDowngradeTime;
    L210:
        long r724 = r151;
        if ((r914 & 1048576) == 0) goto L213;
        String r152 = r210.searchTransInfo;
    L215:
        if ((r914 & 2097152) == 0) goto L217;
        int r153 = r210.exposeUploadType;
    L218:
        int r725 = r153;
        if ((r914 & 4194304) == 0) goto L221;
        String r154 = r210.nearbySubPage;
    L222:
        String r820 = r154;
        if ((r914 & 8388608) == 0) goto L225;
        Integer r155 = r210.openSubPageTrigger;
    L226:
        Integer r821 = r155;
        if ((r914 & 16777216) == 0) goto L229;
        int r156 = r210.pageType;
    L230:
        int r822 = r156;
        if ((r914 & 33554432) == 0) goto L233;
        String r157 = r210.grouponSearchParam;
    L234:
        String r823 = r157;
        if ((r914 & 67108864) == 0) goto L237;
        int r158 = r210.substitutePageType;
    L238:
        int r824 = r158;
        if ((r914 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        String r159 = r210.nearbyDotComponentId;
    L242:
        String r825 = r159;
        if ((r914 & 268435456) == 0) goto L245;
        String r160 = r210.grouponDotComponentId;
    L246:
        String r826 = r160;
        if ((r914 & 536870912) == 0) goto L249;
        GrouponBubbleDotOnShowAction r161 = r210.onShowAction;
    L250:
        GrouponBubbleDotOnShowAction r827 = r161;
        if ((r914 & 1073741824) == 0) goto L253;
        int r162 = r210.uploadImpressionScene;
    L255:
        if ((r914 & Integer.MIN_VALUE) == 0) goto L257;
        String r163 = r210.enterBubble;
    L258:
        String r828 = r163;
        if ((r915 & 1) == 0) goto L261;
        String r164 = r210.resourceTransInfo;
    L262:
        String r917 = r164;
        if ((r915 & 2) == 0) goto L265;
        String r165 = r210.atomicTask;
    L266:
        String r918 = r165;
        if ((r915 & 4) == 0) goto L269;
        String r166 = r210.extraResourceTrackParam;
    L271:
        return r210.copy(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r323, r320, r321, r322, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r520, r521, r522, r523, r524, r529, r525, r526, r527, r528, r620, r621, r622, r623, r624, r625, r626, r627, r628, r629, r719, r720, r721, r722, r723, r150, r724, r152, r725, r820, r821, r822, r823, r824, r825, r826, r827, r162, r828, r917, r918, r166);
    L269:
        r166 = r912;
        goto L271
    L265:
        r165 = r911;
        goto L266
    L261:
        r164 = r910;
        goto L262
    L257:
        r163 = r819;
        goto L258
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
        r153 = r718;
        goto L218
    L213:
        r152 = r717;
        goto L215
    L209:
        r151 = r716;
        goto L210
    L205:
        r150 = r715;
        goto L206
    L201:
        r149 = r714;
        goto L202
    L197:
        r148 = r713;
        goto L198
    L193:
        r147 = r712;
        goto L194
    L189:
        r146 = r711;
        goto L190
    L185:
        r145 = r710;
        goto L186
    L181:
        r144 = r619;
        goto L182
    L177:
        r143 = r618;
        goto L178
    L173:
        r142 = r617;
        goto L174
    L169:
        r141 = r616;
        goto L170
    L165:
        r140 = r615;
        goto L166
    L161:
        r139 = r614;
        goto L162
    L157:
        r138 = r613;
        goto L158
    L153:
        r137 = r612;
        goto L154
    L149:
        r136 = r611;
        goto L150
    L145:
        r135 = r610;
        goto L146
    L141:
        r134 = r519;
        goto L142
    L137:
        r109 = r518;
        goto L138
    L133:
        r108 = r517;
        goto L134
    L129:
        r107 = r516;
        goto L130
    L125:
        r133 = r515;
        goto L127
    L121:
        r132 = r514;
        goto L122
    L117:
        r131 = r513;
        goto L118
    L113:
        r130 = r512;
        goto L114
    L109:
        r129 = r511;
        goto L110
    L105:
        r128 = r510;
        goto L106
    L101:
        r127 = r419;
        goto L102
    L97:
        r126 = r418;
        goto L98
    L93:
        r125 = r417;
        goto L94
    L89:
        r124 = r416;
        goto L90
    L85:
        r123 = r415;
        goto L86
    L81:
        r122 = r414;
        goto L82
    L77:
        r121 = r413;
        goto L78
    L73:
        r120 = r412;
        goto L74
    L69:
        r119 = r411;
        goto L70
    L65:
        r118 = r410;
        goto L66
    L61:
        r117 = r319;
        goto L62
    L57:
        r116 = r318;
        goto L58
    L53:
        r115 = r317;
        goto L54
    L49:
        r114 = r316;
        goto L51
    L45:
        r113 = r315;
        goto L47
    L41:
        r112 = r314;
        goto L43
    L37:
        r111 = r313;
        goto L39
    L33:
        r110 = r312;
        goto L35
    L29:
        r106 = r311;
        goto L31
    L25:
        r105 = r310;
        goto L27
    L21:
        r104 = r215;
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
        return this.bubbleId;
    }

    public final Integer component10() {
        return this.sceneType;
    }

    public final List<GrouponGeneralBubbleFrequencyBean> component11() {
        return this.freqKeyArray;
    }

    public final Integer component12() {
        return this.throttleTime;
    }

    public final List<Integer> component13() {
        return this.commonAvoidDisable;
    }

    public final Map<Integer, Integer> component14() {
        return this.avoidOtherBubbleType;
    }

    public final Map<Integer, Integer> component15() {
        return this.avoidOtherBubbleTypeSec;
    }

    public final String component16() {
        return this.feedGidInfo;
    }

    public final String component17() {
        return this.diamondTransInfo;
    }

    public final Integer component18() {
        return this.firstPullScene;
    }

    public final String component19() {
        return this.commonTransInfo;
    }

    public final Integer component2() {
        return this.bubbleAction;
    }

    public final String component20() {
        return this.bubbleTypeCategory;
    }

    public final String component21() {
        return this.noticeCategory;
    }

    public final String component22() {
        return this.extraDiamondTrackParam;
    }

    public final String component23() {
        return this.extraFeedTrackParam;
    }

    public final String component24() {
        return this.exposeMsg;
    }

    public final String component25() {
        return this.impressionSvrData;
    }

    public final Integer component26() {
        return this.priority;
    }

    public final Long component27() {
        return this.validTime;
    }

    public final Long component28() {
        return this.redDotRemoveTimestamp;
    }

    public final Long component29() {
        return this.redDotRemoveTime;
    }

    public final Integer component3() {
        return this.type;
    }

    public final UrlModel component30() {
        return this.bubbleImgUrl;
    }

    public final Integer component31() {
        return this.bubbleImgType;
    }

    public final UrlModel component32() {
        return this.bubbleIconUrl;
    }

    public final Integer component33() {
        return this.bubbleShowDuration;
    }

    public final String component34() {
        return this.limitUid;
    }

    public final String component35() {
        return this.limitDid;
    }

    public final int component36() {
        return this.bubbleShowOutClick;
    }

    public final int component37() {
        return this.rebootRecoverDot;
    }

    public final Integer component38() {
        return this.dotStyle;
    }

    public final int component39() {
        return this.removeDotUserChange;
    }

    public final String component4() {
        return this.bubbleText;
    }

    public final int component40() {
        return this.notDotUndertake;
    }

    public final int component41() {
        return this.attribute;
    }

    public final int component42() {
        return this.dotPriority;
    }

    public final String component43() {
        return this.guideContext;
    }

    public final Integer component44() {
        return this.guideContextTrigger;
    }

    public final String component45() {
        return this.floatBackInfo;
    }

    public final String component46() {
        return this.diamondUpdateInfo;
    }

    public final String component47() {
        return this.forceCity;
    }

    public final String component48() {
        return this.preTipText;
    }

    public final int component49() {
        return this.clearForceCity;
    }

    public final Integer component5() {
        return this.style;
    }

    public final GrouponRebootRecoverDotConfig component50() {
        return this.rebootRecoverDotConfig;
    }

    public final GrouponGuideDoubleCheckConfig component51() {
        return this.guideDoubleCheckConfig;
    }

    public final long component52() {
        return this.dotDowngradeTime;
    }

    public final String component53() {
        return this.searchTransInfo;
    }

    public final int component54() {
        return this.exposeUploadType;
    }

    public final String component55() {
        return this.nearbySubPage;
    }

    public final Integer component56() {
        return this.openSubPageTrigger;
    }

    public final int component57() {
        return this.pageType;
    }

    public final String component58() {
        return this.grouponSearchParam;
    }

    public final int component59() {
        return this.substitutePageType;
    }

    public final Integer component6() {
        return this.scene;
    }

    public final String component60() {
        return this.nearbyDotComponentId;
    }

    public final String component61() {
        return this.grouponDotComponentId;
    }

    public final GrouponBubbleDotOnShowAction component62() {
        return this.onShowAction;
    }

    public final int component63() {
        return this.uploadImpressionScene;
    }

    public final String component64() {
        return this.enterBubble;
    }

    public final String component65() {
        return this.resourceTransInfo;
    }

    public final String component66() {
        return this.atomicTask;
    }

    public final String component67() {
        return this.extraResourceTrackParam;
    }

    public final String component7() {
        return this.nearbyBubbleComponentId;
    }

    public final String component8() {
        return this.grouponBubbleComponentId;
    }

    public final String component9() {
        return this.dotText;
    }

    public final GrouponGeneralBubbleStruct copy(String r710, Integer r711, Integer r712, String r713, Integer r714, Integer r715, String r716, String r717, String r718, Integer r810, List<GrouponGeneralBubbleFrequencyBean> r811, Integer r812, List<Integer> r813, Map<Integer, Integer> r814, Map<Integer, Integer> r815, String r816, String r817, Integer r818, String r819, String r910, String r911, String r912, String r913, String r914, String r915, Integer r916, Long r917, Long r918, Long r919, UrlModel r100, Integer r101, UrlModel r102, Integer r103, String r104, String r105, int r106, int r107, Integer r108, int r109, int r110, int r111, int r112, String r113, Integer r114, String r115, String r116, String r117, String r118, int r119, GrouponRebootRecoverDotConfig r120, GrouponGuideDoubleCheckConfig r121, long r122, String r124, int r125, String r126, Integer r127, int r128, String r129, int r130, String r131, String r132, GrouponBubbleDotOnShowAction r133, int r134, String r135, String r136, String r137, String r138) {
        return new GrouponGeneralBubbleStruct(r710, r711, r712, r713, r714, r715, r716, r717, r718, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GrouponGeneralBubbleStruct) == true) goto L8;
        return false;
    L8:
        GrouponGeneralBubbleStruct r101 = (GrouponGeneralBubbleStruct) r100;
        if (Intrinsics.areEqual(this.bubbleId, r101.bubbleId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bubbleAction, r101.bubbleAction) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bubbleText, r101.bubbleText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.nearbyBubbleComponentId, r101.nearbyBubbleComponentId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.grouponBubbleComponentId, r101.grouponBubbleComponentId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.dotText, r101.dotText) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sceneType, r101.sceneType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.freqKeyArray, r101.freqKeyArray) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.throttleTime, r101.throttleTime) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.commonAvoidDisable, r101.commonAvoidDisable) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.avoidOtherBubbleType, r101.avoidOtherBubbleType) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.avoidOtherBubbleTypeSec, r101.avoidOtherBubbleTypeSec) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.feedGidInfo, r101.feedGidInfo) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.diamondTransInfo, r101.diamondTransInfo) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.firstPullScene, r101.firstPullScene) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.commonTransInfo, r101.commonTransInfo) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.bubbleTypeCategory, r101.bubbleTypeCategory) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.noticeCategory, r101.noticeCategory) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.extraDiamondTrackParam, r101.extraDiamondTrackParam) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.extraFeedTrackParam, r101.extraFeedTrackParam) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.exposeMsg, r101.exposeMsg) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.impressionSvrData, r101.impressionSvrData) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.priority, r101.priority) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.validTime, r101.validTime) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.redDotRemoveTimestamp, r101.redDotRemoveTimestamp) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.redDotRemoveTime, r101.redDotRemoveTime) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.bubbleImgUrl, r101.bubbleImgUrl) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.bubbleImgType, r101.bubbleImgType) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.bubbleIconUrl, r101.bubbleIconUrl) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.bubbleShowDuration, r101.bubbleShowDuration) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.limitUid, r101.limitUid) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.limitDid, r101.limitDid) == true) goto L114;
        return false;
    L114:
        if (this.bubbleShowOutClick == r101.bubbleShowOutClick) goto L117;
        return false;
    L117:
        if (this.rebootRecoverDot == r101.rebootRecoverDot) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.dotStyle, r101.dotStyle) == true) goto L123;
        return false;
    L123:
        if (this.removeDotUserChange == r101.removeDotUserChange) goto L126;
        return false;
    L126:
        if (this.notDotUndertake == r101.notDotUndertake) goto L129;
        return false;
    L129:
        if (this.attribute == r101.attribute) goto L132;
        return false;
    L132:
        if (this.dotPriority == r101.dotPriority) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.guideContext, r101.guideContext) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.guideContextTrigger, r101.guideContextTrigger) == true) goto L141;
        return false;
    L141:
        if (Intrinsics.areEqual(this.floatBackInfo, r101.floatBackInfo) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.diamondUpdateInfo, r101.diamondUpdateInfo) == true) goto L147;
        return false;
    L147:
        if (Intrinsics.areEqual(this.forceCity, r101.forceCity) == true) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.preTipText, r101.preTipText) == true) goto L153;
        return false;
    L153:
        if (this.clearForceCity == r101.clearForceCity) goto L156;
        return false;
    L156:
        if (Intrinsics.areEqual(this.rebootRecoverDotConfig, r101.rebootRecoverDotConfig) == true) goto L159;
        return false;
    L159:
        if (Intrinsics.areEqual(this.guideDoubleCheckConfig, r101.guideDoubleCheckConfig) == true) goto L162;
        return false;
    L162:
        if (this.dotDowngradeTime == r101.dotDowngradeTime) goto L165;
        return false;
    L165:
        if (Intrinsics.areEqual(this.searchTransInfo, r101.searchTransInfo) == true) goto L168;
        return false;
    L168:
        if (this.exposeUploadType == r101.exposeUploadType) goto L171;
        return false;
    L171:
        if (Intrinsics.areEqual(this.nearbySubPage, r101.nearbySubPage) == true) goto L174;
        return false;
    L174:
        if (Intrinsics.areEqual(this.openSubPageTrigger, r101.openSubPageTrigger) == true) goto L177;
        return false;
    L177:
        if (this.pageType == r101.pageType) goto L180;
        return false;
    L180:
        if (Intrinsics.areEqual(this.grouponSearchParam, r101.grouponSearchParam) == true) goto L183;
        return false;
    L183:
        if (this.substitutePageType == r101.substitutePageType) goto L186;
        return false;
    L186:
        if (Intrinsics.areEqual(this.nearbyDotComponentId, r101.nearbyDotComponentId) == true) goto L189;
        return false;
    L189:
        if (Intrinsics.areEqual(this.grouponDotComponentId, r101.grouponDotComponentId) == true) goto L192;
        return false;
    L192:
        if (Intrinsics.areEqual(this.onShowAction, r101.onShowAction) == true) goto L195;
        return false;
    L195:
        if (this.uploadImpressionScene == r101.uploadImpressionScene) goto L198;
        return false;
    L198:
        if (Intrinsics.areEqual(this.enterBubble, r101.enterBubble) == true) goto L201;
        return false;
    L201:
        if (Intrinsics.areEqual(this.resourceTransInfo, r101.resourceTransInfo) == true) goto L204;
        return false;
    L204:
        if (Intrinsics.areEqual(this.atomicTask, r101.atomicTask) == true) goto L207;
        return false;
    L207:
        if (Intrinsics.areEqual(this.extraResourceTrackParam, r101.extraResourceTrackParam) == true) goto L209;
        return false;
    L209:
        return true;
    }

    public int hashCode() {
        String r100 = this.bubbleId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.bubbleAction;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.type;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.bubbleText;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.style;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.scene;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.nearbyBubbleComponentId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.grouponBubbleComponentId;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.dotText;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.sceneType;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        List<GrouponGeneralBubbleFrequencyBean> r131 = this.freqKeyArray;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.throttleTime;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        List<Integer> r137 = this.commonAvoidDisable;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Map<Integer, Integer> r140 = this.avoidOtherBubbleType;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Map<Integer, Integer> r143 = this.avoidOtherBubbleTypeSec;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.feedGidInfo;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.diamondTransInfo;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        Integer r152 = this.firstPullScene;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.commonTransInfo;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.bubbleTypeCategory;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        String r161 = this.noticeCategory;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        String r164 = this.extraDiamondTrackParam;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        String r167 = this.extraFeedTrackParam;
        if (r167 != null) goto L93;
        int r168 = 0;
    L94:
        int r169 = (r166 + r168) * 31;
        String r170 = this.exposeMsg;
        if (r170 != null) goto L97;
        int r171 = 0;
    L98:
        int r172 = (r169 + r171) * 31;
        String r173 = this.impressionSvrData;
        if (r173 != null) goto L101;
        int r174 = 0;
    L102:
        int r175 = (r172 + r174) * 31;
        Integer r176 = this.priority;
        if (r176 != null) goto L105;
        int r177 = 0;
    L106:
        int r178 = (r175 + r177) * 31;
        Long r179 = this.validTime;
        if (r179 != null) goto L109;
        int r180 = 0;
    L110:
        int r181 = (r178 + r180) * 31;
        Long r182 = this.redDotRemoveTimestamp;
        if (r182 != null) goto L113;
        int r183 = 0;
    L114:
        int r184 = (r181 + r183) * 31;
        Long r185 = this.redDotRemoveTime;
        if (r185 != null) goto L117;
        int r186 = 0;
    L118:
        int r187 = (r184 + r186) * 31;
        UrlModel r188 = this.bubbleImgUrl;
        if (r188 != null) goto L121;
        int r189 = 0;
    L122:
        int r190 = (r187 + r189) * 31;
        Integer r191 = this.bubbleImgType;
        if (r191 != null) goto L125;
        int r192 = 0;
    L126:
        int r193 = (r190 + r192) * 31;
        UrlModel r194 = this.bubbleIconUrl;
        if (r194 != null) goto L129;
        int r195 = 0;
    L130:
        int r196 = (r193 + r195) * 31;
        Integer r197 = this.bubbleShowDuration;
        if (r197 != null) goto L133;
        int r198 = 0;
    L134:
        int r199 = (r196 + r198) * 31;
        String r200 = this.limitUid;
        if (r200 != null) goto L137;
        int r201 = 0;
    L138:
        int r202 = (r199 + r201) * 31;
        String r203 = this.limitDid;
        if (r203 != null) goto L141;
        int r204 = 0;
    L142:
        int r205 = (((((r202 + r204) * 31) + this.bubbleShowOutClick) * 31) + this.rebootRecoverDot) * 31;
        Integer r206 = this.dotStyle;
        if (r206 != null) goto L145;
        int r207 = 0;
    L146:
        int r208 = (((((((((r205 + r207) * 31) + this.removeDotUserChange) * 31) + this.notDotUndertake) * 31) + this.attribute) * 31) + this.dotPriority) * 31;
        String r209 = this.guideContext;
        if (r209 != null) goto L149;
        int r210 = 0;
    L150:
        int r211 = (r208 + r210) * 31;
        Integer r212 = this.guideContextTrigger;
        if (r212 != null) goto L153;
        int r213 = 0;
    L154:
        int r214 = (r211 + r213) * 31;
        String r215 = this.floatBackInfo;
        if (r215 != null) goto L157;
        int r216 = 0;
    L158:
        int r217 = (r214 + r216) * 31;
        String r218 = this.diamondUpdateInfo;
        if (r218 != null) goto L161;
        int r219 = 0;
    L162:
        int r220 = (r217 + r219) * 31;
        String r221 = this.forceCity;
        if (r221 != null) goto L165;
        int r222 = 0;
    L166:
        int r223 = (r220 + r222) * 31;
        String r224 = this.preTipText;
        if (r224 != null) goto L169;
        int r225 = 0;
    L170:
        int r226 = (((r223 + r225) * 31) + this.clearForceCity) * 31;
        GrouponRebootRecoverDotConfig r227 = this.rebootRecoverDotConfig;
        if (r227 != null) goto L173;
        int r228 = 0;
    L174:
        int r229 = (r226 + r228) * 31;
        GrouponGuideDoubleCheckConfig r230 = this.guideDoubleCheckConfig;
        if (r230 != null) goto L177;
        int r231 = 0;
    L178:
        int r232 = (r229 + r231) * 31;
        long r233 = this.dotDowngradeTime;
        int r234 = (r232 + ((int) (r233 ^ (r233 >>> 32)))) * 31;
        String r235 = this.searchTransInfo;
        if (r235 != null) goto L181;
        int r236 = 0;
    L182:
        int r237 = (((r234 + r236) * 31) + this.exposeUploadType) * 31;
        String r238 = this.nearbySubPage;
        if (r238 != null) goto L185;
        int r239 = 0;
    L186:
        int r240 = (r237 + r239) * 31;
        Integer r241 = this.openSubPageTrigger;
        if (r241 != null) goto L189;
        int r242 = 0;
    L190:
        int r243 = (((r240 + r242) * 31) + this.pageType) * 31;
        String r244 = this.grouponSearchParam;
        if (r244 != null) goto L193;
        int r245 = 0;
    L194:
        int r246 = (((r243 + r245) * 31) + this.substitutePageType) * 31;
        String r247 = this.nearbyDotComponentId;
        if (r247 != null) goto L197;
        int r248 = 0;
    L198:
        int r249 = (r246 + r248) * 31;
        String r250 = this.grouponDotComponentId;
        if (r250 != null) goto L201;
        int r251 = 0;
    L202:
        int r252 = (r249 + r251) * 31;
        GrouponBubbleDotOnShowAction r253 = this.onShowAction;
        if (r253 != null) goto L205;
        int r254 = 0;
    L206:
        int r255 = (((r252 + r254) * 31) + this.uploadImpressionScene) * 31;
        String r256 = this.enterBubble;
        if (r256 != null) goto L209;
        int r257 = 0;
    L210:
        int r258 = (r255 + r257) * 31;
        String r259 = this.resourceTransInfo;
        if (r259 != null) goto L213;
        int r260 = 0;
    L214:
        int r261 = (r258 + r260) * 31;
        String r262 = this.atomicTask;
        if (r262 != null) goto L217;
        int r263 = 0;
    L218:
        int r264 = (r261 + r263) * 31;
        String r265 = this.extraResourceTrackParam;
        if (r265 == null) goto L223;
        r101 = r265.hashCode();
    L223:
        return r264 + r101;
    L217:
        r263 = r262.hashCode();
        goto L218
    L213:
        r260 = r259.hashCode();
        goto L214
    L209:
        r257 = r256.hashCode();
        goto L210
    L205:
        r254 = r253.hashCode();
        goto L206
    L201:
        r251 = r250.hashCode();
        goto L202
    L197:
        r248 = r247.hashCode();
        goto L198
    L193:
        r245 = r244.hashCode();
        goto L194
    L189:
        r242 = r241.hashCode();
        goto L190
    L185:
        r239 = r238.hashCode();
        goto L186
    L181:
        r236 = r235.hashCode();
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
    L165:
        r222 = r221.hashCode();
        goto L166
    L161:
        r219 = r218.hashCode();
        goto L162
    L157:
        r216 = r215.hashCode();
        goto L158
    L153:
        r213 = r212.hashCode();
        goto L154
    L149:
        r210 = r209.hashCode();
        goto L150
    L145:
        r207 = r206.hashCode();
        goto L146
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
    L81:
        r159 = r158.hashCode();
        goto L82
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
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
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
        return "GrouponGeneralBubbleStruct(bubbleId=" + this.bubbleId + ", bubbleAction=" + this.bubbleAction + ", type=" + this.type + ", bubbleText=" + this.bubbleText + ", style=" + this.style + ", scene=" + this.scene + ", nearbyBubbleComponentId=" + this.nearbyBubbleComponentId + ", grouponBubbleComponentId=" + this.grouponBubbleComponentId + ", dotText=" + this.dotText + ", sceneType=" + this.sceneType + ", freqKeyArray=" + this.freqKeyArray + ", throttleTime=" + this.throttleTime + ", commonAvoidDisable=" + this.commonAvoidDisable + ", avoidOtherBubbleType=" + this.avoidOtherBubbleType + ", avoidOtherBubbleTypeSec=" + this.avoidOtherBubbleTypeSec + ", feedGidInfo=" + this.feedGidInfo + ", diamondTransInfo=" + this.diamondTransInfo + ", firstPullScene=" + this.firstPullScene + ", commonTransInfo=" + this.commonTransInfo + ", bubbleTypeCategory=" + this.bubbleTypeCategory + ", noticeCategory=" + this.noticeCategory + ", extraDiamondTrackParam=" + this.extraDiamondTrackParam + ", extraFeedTrackParam=" + this.extraFeedTrackParam + ", exposeMsg=" + this.exposeMsg + ", impressionSvrData=" + this.impressionSvrData + ", priority=" + this.priority + ", validTime=" + this.validTime + ", redDotRemoveTimestamp=" + this.redDotRemoveTimestamp + ", redDotRemoveTime=" + this.redDotRemoveTime + ", bubbleImgUrl=" + this.bubbleImgUrl + ", bubbleImgType=" + this.bubbleImgType + ", bubbleIconUrl=" + this.bubbleIconUrl + ", bubbleShowDuration=" + this.bubbleShowDuration + ", limitUid=" + this.limitUid + ", limitDid=" + this.limitDid + ", bubbleShowOutClick=" + this.bubbleShowOutClick + ", rebootRecoverDot=" + this.rebootRecoverDot + ", dotStyle=" + this.dotStyle + ", removeDotUserChange=" + this.removeDotUserChange + ", notDotUndertake=" + this.notDotUndertake + ", attribute=" + this.attribute + ", dotPriority=" + this.dotPriority + ", guideContext=" + this.guideContext + ", guideContextTrigger=" + this.guideContextTrigger + ", floatBackInfo=" + this.floatBackInfo + ", diamondUpdateInfo=" + this.diamondUpdateInfo + ", forceCity=" + this.forceCity + ", preTipText=" + this.preTipText + ", clearForceCity=" + this.clearForceCity + ", rebootRecoverDotConfig=" + this.rebootRecoverDotConfig + ", guideDoubleCheckConfig=" + this.guideDoubleCheckConfig + ", dotDowngradeTime=" + this.dotDowngradeTime + ", searchTransInfo=" + this.searchTransInfo + ", exposeUploadType=" + this.exposeUploadType + ", nearbySubPage=" + this.nearbySubPage + ", openSubPageTrigger=" + this.openSubPageTrigger + ", pageType=" + this.pageType + ", grouponSearchParam=" + this.grouponSearchParam + ", substitutePageType=" + this.substitutePageType + ", nearbyDotComponentId=" + this.nearbyDotComponentId + ", grouponDotComponentId=" + this.grouponDotComponentId + ", onShowAction=" + this.onShowAction + ", uploadImpressionScene=" + this.uploadImpressionScene + ", enterBubble=" + this.enterBubble + ", resourceTransInfo=" + this.resourceTransInfo + ", atomicTask=" + this.atomicTask + ", extraResourceTrackParam=" + this.extraResourceTrackParam + ')';
    }

    public final String getAtomicTask() {
        return this.atomicTask;
    }

    public final int getAttribute() {
        return this.attribute;
    }

    public final Map<Integer, Integer> getAvoidOtherBubbleType() {
        return this.avoidOtherBubbleType;
    }

    public final Map<Integer, Integer> getAvoidOtherBubbleTypeSec() {
        return this.avoidOtherBubbleTypeSec;
    }

    public final Integer getBubbleAction() {
        return this.bubbleAction;
    }

    public final UrlModel getBubbleIconUrl() {
        return this.bubbleIconUrl;
    }

    public final String getBubbleId() {
        return this.bubbleId;
    }

    public final Integer getBubbleImgType() {
        return this.bubbleImgType;
    }

    public final UrlModel getBubbleImgUrl() {
        return this.bubbleImgUrl;
    }

    public final Integer getBubbleShowDuration() {
        return this.bubbleShowDuration;
    }

    public final int getBubbleShowOutClick() {
        return this.bubbleShowOutClick;
    }

    public final long getBubbleShowTime() {
        return this.bubbleShowTime;
    }

    public final String getBubbleText() {
        return this.bubbleText;
    }

    public final String getBubbleTypeCategory() {
        return this.bubbleTypeCategory;
    }

    public final int getClearForceCity() {
        return this.clearForceCity;
    }

    public final List<Integer> getCommonAvoidDisable() {
        return this.commonAvoidDisable;
    }

    public final String getCommonTransInfo() {
        return this.commonTransInfo;
    }

    public final String getDiamondTransInfo() {
        return this.diamondTransInfo;
    }

    public final String getDiamondUpdateInfo() {
        return this.diamondUpdateInfo;
    }

    public final long getDotDowngradeTime() {
        return this.dotDowngradeTime;
    }

    public final int getDotPriority() {
        return this.dotPriority;
    }

    public final Integer getDotStyle() {
        return this.dotStyle;
    }

    public final String getDotText() {
        return this.dotText;
    }

    public final String getEnterBubble() {
        return this.enterBubble;
    }

    public final String getExposeMsg() {
        return this.exposeMsg;
    }

    public final int getExposeUploadType() {
        return this.exposeUploadType;
    }

    public final String getExtraDiamondTrackParam() {
        return this.extraDiamondTrackParam;
    }

    public final String getExtraFeedTrackParam() {
        return this.extraFeedTrackParam;
    }

    public final String getExtraResourceTrackParam() {
        return this.extraResourceTrackParam;
    }

    public final String getFeedGidInfo() {
        return this.feedGidInfo;
    }

    public final Integer getFirstPullScene() {
        return this.firstPullScene;
    }

    public final String getFloatBackInfo() {
        return this.floatBackInfo;
    }

    public final String getForceCity() {
        return this.forceCity;
    }

    public final List<GrouponGeneralBubbleFrequencyBean> getFreqKeyArray() {
        return this.freqKeyArray;
    }

    public final String getGrouponBubbleComponentId() {
        return this.grouponBubbleComponentId;
    }

    public final String getGrouponDotComponentId() {
        return this.grouponDotComponentId;
    }

    public final String getGrouponSearchParam() {
        return this.grouponSearchParam;
    }

    public final String getGuideContext() {
        return this.guideContext;
    }

    public final Integer getGuideContextTrigger() {
        return this.guideContextTrigger;
    }

    public final GrouponGuideDoubleCheckConfig getGuideDoubleCheckConfig() {
        return this.guideDoubleCheckConfig;
    }

    public final String getImpressionSvrData() {
        return this.impressionSvrData;
    }

    public final String getLimitDid() {
        return this.limitDid;
    }

    public final String getLimitUid() {
        return this.limitUid;
    }

    public final long getMessageGetTime() {
        return this.messageGetTime;
    }

    public final String getNearbyBubbleComponentId() {
        return this.nearbyBubbleComponentId;
    }

    public final String getNearbyDotComponentId() {
        return this.nearbyDotComponentId;
    }

    public final String getNearbySubPage() {
        return this.nearbySubPage;
    }

    public final int getNotDotUndertake() {
        return this.notDotUndertake;
    }

    public final String getNoticeCategory() {
        return this.noticeCategory;
    }

    public final GrouponBubbleDotOnShowAction getOnShowAction() {
        return this.onShowAction;
    }

    public final Integer getOpenSubPageTrigger() {
        return this.openSubPageTrigger;
    }

    public final int getPageType() {
        return this.pageType;
    }

    public final String getPreTipText() {
        return this.preTipText;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final int getRebootRecoverDot() {
        return this.rebootRecoverDot;
    }

    public final GrouponRebootRecoverDotConfig getRebootRecoverDotConfig() {
        return this.rebootRecoverDotConfig;
    }

    public final Long getRedDotRemoveTime() {
        return this.redDotRemoveTime;
    }

    public final Long getRedDotRemoveTimestamp() {
        return this.redDotRemoveTimestamp;
    }

    public final int getRemoveDotUserChange() {
        return this.removeDotUserChange;
    }

    public final String getResourceTransInfo() {
        return this.resourceTransInfo;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public final Integer getSceneType() {
        return this.sceneType;
    }

    public final String getSearchTransInfo() {
        return this.searchTransInfo;
    }

    public final Integer getStyle() {
        return this.style;
    }

    public final int getSubstitutePageType() {
        return this.substitutePageType;
    }

    public final Integer getThrottleTime() {
        return this.throttleTime;
    }

    public final Integer getType() {
        return this.type;
    }

    public final int getUploadImpressionScene() {
        return this.uploadImpressionScene;
    }

    public final Long getValidTime() {
        return this.validTime;
    }

    public final boolean isCachedInMemory() {
        return this.isCachedInMemory;
    }

    public final boolean isRebootDot() {
        return this.isRebootDot;
    }

    public final void setAtomicTask(String r100) {
        this.atomicTask = r100;
    }

    public final void setAttribute(int r100) {
        this.attribute = r100;
    }

    public final void setAvoidOtherBubbleType(Map<Integer, Integer> r100) {
        this.avoidOtherBubbleType = r100;
    }

    public final void setAvoidOtherBubbleTypeSec(Map<Integer, Integer> r100) {
        this.avoidOtherBubbleTypeSec = r100;
    }

    public final void setBubbleAction(Integer r100) {
        this.bubbleAction = r100;
    }

    public final void setBubbleIconUrl(UrlModel r100) {
        this.bubbleIconUrl = r100;
    }

    public final void setBubbleId(String r100) {
        this.bubbleId = r100;
    }

    public final void setBubbleImgType(Integer r100) {
        this.bubbleImgType = r100;
    }

    public final void setBubbleImgUrl(UrlModel r100) {
        this.bubbleImgUrl = r100;
    }

    public final void setBubbleShowDuration(Integer r100) {
        this.bubbleShowDuration = r100;
    }

    public final void setBubbleShowOutClick(int r100) {
        this.bubbleShowOutClick = r100;
    }

    public final void setBubbleShowTime(long r100) {
        this.bubbleShowTime = r100;
    }

    public final void setBubbleText(String r100) {
        this.bubbleText = r100;
    }

    public final void setBubbleTypeCategory(String r100) {
        this.bubbleTypeCategory = r100;
    }

    public final void setCachedInMemory(boolean r100) {
        this.isCachedInMemory = r100;
    }

    public final void setClearForceCity(int r100) {
        this.clearForceCity = r100;
    }

    public final void setCommonAvoidDisable(List<Integer> r100) {
        this.commonAvoidDisable = r100;
    }

    public final void setCommonTransInfo(String r100) {
        this.commonTransInfo = r100;
    }

    public final void setDiamondTransInfo(String r100) {
        this.diamondTransInfo = r100;
    }

    public final void setDiamondUpdateInfo(String r100) {
        this.diamondUpdateInfo = r100;
    }

    public final void setDotDowngradeTime(long r100) {
        this.dotDowngradeTime = r100;
    }

    public final void setDotPriority(int r100) {
        this.dotPriority = r100;
    }

    public final void setDotStyle(Integer r100) {
        this.dotStyle = r100;
    }

    public final void setDotText(String r100) {
        this.dotText = r100;
    }

    public final void setEnterBubble(String r100) {
        this.enterBubble = r100;
    }

    public final void setExposeMsg(String r100) {
        this.exposeMsg = r100;
    }

    public final void setExposeUploadType(int r100) {
        this.exposeUploadType = r100;
    }

    public final void setExtraDiamondTrackParam(String r100) {
        this.extraDiamondTrackParam = r100;
    }

    public final void setExtraFeedTrackParam(String r100) {
        this.extraFeedTrackParam = r100;
    }

    public final void setExtraResourceTrackParam(String r100) {
        this.extraResourceTrackParam = r100;
    }

    public final void setFeedGidInfo(String r100) {
        this.feedGidInfo = r100;
    }

    public final void setFirstPullScene(Integer r100) {
        this.firstPullScene = r100;
    }

    public final void setFloatBackInfo(String r100) {
        this.floatBackInfo = r100;
    }

    public final void setForceCity(String r100) {
        this.forceCity = r100;
    }

    public final void setFreqKeyArray(List<GrouponGeneralBubbleFrequencyBean> r100) {
        this.freqKeyArray = r100;
    }

    public final void setGrouponBubbleComponentId(String r100) {
        this.grouponBubbleComponentId = r100;
    }

    public final void setGrouponDotComponentId(String r100) {
        this.grouponDotComponentId = r100;
    }

    public final void setGrouponSearchParam(String r100) {
        this.grouponSearchParam = r100;
    }

    public final void setGuideContext(String r100) {
        this.guideContext = r100;
    }

    public final void setGuideContextTrigger(Integer r100) {
        this.guideContextTrigger = r100;
    }

    public final void setGuideDoubleCheckConfig(GrouponGuideDoubleCheckConfig r100) {
        this.guideDoubleCheckConfig = r100;
    }

    public final void setImpressionSvrData(String r100) {
        this.impressionSvrData = r100;
    }

    public final void setLimitDid(String r100) {
        this.limitDid = r100;
    }

    public final void setLimitUid(String r100) {
        this.limitUid = r100;
    }

    public final void setMessageGetTime(long r100) {
        this.messageGetTime = r100;
    }

    public final void setNearbyBubbleComponentId(String r100) {
        this.nearbyBubbleComponentId = r100;
    }

    public final void setNearbyDotComponentId(String r100) {
        this.nearbyDotComponentId = r100;
    }

    public final void setNearbySubPage(String r100) {
        this.nearbySubPage = r100;
    }

    public final void setNotDotUndertake(int r100) {
        this.notDotUndertake = r100;
    }

    public final void setNoticeCategory(String r100) {
        this.noticeCategory = r100;
    }

    public final void setOnShowAction(GrouponBubbleDotOnShowAction r100) {
        this.onShowAction = r100;
    }

    public final void setOpenSubPageTrigger(Integer r100) {
        this.openSubPageTrigger = r100;
    }

    public final void setPageType(int r100) {
        this.pageType = r100;
    }

    public final void setPreTipText(String r100) {
        this.preTipText = r100;
    }

    public final void setPriority(Integer r100) {
        this.priority = r100;
    }

    public final void setRebootDot(boolean r100) {
        this.isRebootDot = r100;
    }

    public final void setRebootRecoverDot(int r100) {
        this.rebootRecoverDot = r100;
    }

    public final void setRebootRecoverDotConfig(GrouponRebootRecoverDotConfig r100) {
        this.rebootRecoverDotConfig = r100;
    }

    public final void setRedDotRemoveTime(Long r100) {
        this.redDotRemoveTime = r100;
    }

    public final void setRedDotRemoveTimestamp(Long r100) {
        this.redDotRemoveTimestamp = r100;
    }

    public final void setRemoveDotUserChange(int r100) {
        this.removeDotUserChange = r100;
    }

    public final void setResourceTransInfo(String r100) {
        this.resourceTransInfo = r100;
    }

    public final void setScene(Integer r100) {
        this.scene = r100;
    }

    public final void setSceneType(Integer r100) {
        this.sceneType = r100;
    }

    public final void setSearchTransInfo(String r100) {
        this.searchTransInfo = r100;
    }

    public final void setStyle(Integer r100) {
        this.style = r100;
    }

    public final void setSubstitutePageType(int r100) {
        this.substitutePageType = r100;
    }

    public final void setThrottleTime(Integer r100) {
        this.throttleTime = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }

    public final void setUploadImpressionScene(int r100) {
        this.uploadImpressionScene = r100;
    }

    public final void setValidTime(Long r100) {
        this.validTime = r100;
    }

    public GrouponGeneralBubbleStruct(String r100, Integer r101, Integer r102, String r103, Integer r104, Integer r105, String r110, String r111, String r112, Integer r113, List<GrouponGeneralBubbleFrequencyBean> r114, Integer r115, List<Integer> r116, Map<Integer, Integer> r117, Map<Integer, Integer> r118, String r119, String r210, Integer r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, Integer r219, Long r310, Long r311, Long r312, UrlModel r313, Integer r314, UrlModel r315, Integer r316, String r317, String r318, int r319, int r410, Integer r411, int r412, int r413, int r414, int r415, String r416, Integer r417, String r418, String r419, String r510, String r511, int r512, GrouponRebootRecoverDotConfig r513, GrouponGuideDoubleCheckConfig r514, long r515, String r516, int r517, String r518, Integer r610, int r611, String r612, int r613, String r614, String r615, GrouponBubbleDotOnShowAction r616, int r617, String r618, String r619, String r710, String r711) {
        this.bubbleId = r100;
        this.bubbleAction = r101;
        this.type = r102;
        this.bubbleText = r103;
        this.style = r104;
        this.scene = r105;
        this.nearbyBubbleComponentId = r110;
        this.grouponBubbleComponentId = r111;
        this.dotText = r112;
        this.sceneType = r113;
        this.freqKeyArray = r114;
        this.throttleTime = r115;
        this.commonAvoidDisable = r116;
        this.avoidOtherBubbleType = r117;
        this.avoidOtherBubbleTypeSec = r118;
        this.feedGidInfo = r119;
        this.diamondTransInfo = r210;
        this.firstPullScene = r211;
        this.commonTransInfo = r212;
        this.bubbleTypeCategory = r213;
        this.noticeCategory = r214;
        this.extraDiamondTrackParam = r215;
        this.extraFeedTrackParam = r216;
        this.exposeMsg = r217;
        this.impressionSvrData = r218;
        this.priority = r219;
        this.validTime = r310;
        this.redDotRemoveTimestamp = r311;
        this.redDotRemoveTime = r312;
        this.bubbleImgUrl = r313;
        this.bubbleImgType = r314;
        this.bubbleIconUrl = r315;
        this.bubbleShowDuration = r316;
        this.limitUid = r317;
        this.limitDid = r318;
        this.bubbleShowOutClick = r319;
        this.rebootRecoverDot = r410;
        this.dotStyle = r411;
        this.removeDotUserChange = r412;
        this.notDotUndertake = r413;
        this.attribute = r414;
        this.dotPriority = r415;
        this.guideContext = r416;
        this.guideContextTrigger = r417;
        this.floatBackInfo = r418;
        this.diamondUpdateInfo = r419;
        this.forceCity = r510;
        this.preTipText = r511;
        this.clearForceCity = r512;
        this.rebootRecoverDotConfig = r513;
        this.guideDoubleCheckConfig = r514;
        this.dotDowngradeTime = r515;
        this.searchTransInfo = r516;
        this.exposeUploadType = r517;
        this.nearbySubPage = r518;
        this.openSubPageTrigger = r610;
        this.pageType = r611;
        this.grouponSearchParam = r612;
        this.substitutePageType = r613;
        this.nearbyDotComponentId = r614;
        this.grouponDotComponentId = r615;
        this.onShowAction = r616;
        this.uploadImpressionScene = r617;
        this.enterBubble = r618;
        this.resourceTransInfo = r619;
        this.atomicTask = r710;
        this.extraResourceTrackParam = r711;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ GrouponGeneralBubbleStruct(String r610, Integer r611, Integer r710, String r711, Integer r712, Integer r713, String r714, String r715, String r716, Integer r717, List r718, Integer r719, List r810, Map r811, Map r812, String r813, String r814, Integer r815, String r816, String r817, String r818, String r819, String r910, String r911, String r912, Integer r913, Long r914, Long r915, Long r916, UrlModel r917, Integer r918, UrlModel r919, Integer r100, String r101, String r102, int r103, int r104, Integer r105, int r106, int r107, int r108, int r109, String r110, Integer r111, String r112, String r113, String r114, String r115, int r116, GrouponRebootRecoverDotConfig r117, GrouponGuideDoubleCheckConfig r118, long r119, String r121, int r122, String r123, Integer r124, int r125, String r126, int r127, String r128, String r129, GrouponBubbleDotOnShowAction r130, int r131, String r132, String r133, String r134, String r135, int r136, int r137, int r138, DefaultConstructorMarker r139) {
        if ((r136 & 1) == 0) goto L5;
        String r120 = null;
    L7:
        if ((r136 & 2) == 0) goto L9;
        Integer r140 = null;
    L11:
        if ((r136 & 4) == 0) goto L13;
        Integer r141 = null;
    L15:
        if ((r136 & 8) == 0) goto L17;
        String r142 = null;
    L19:
        if ((r136 & 16) == 0) goto L21;
        Integer r143 = null;
    L23:
        if ((r136 & 32) == 0) goto L25;
        Integer r144 = null;
    L27:
        if ((r136 & 64) == 0) goto L29;
        String r145 = null;
    L31:
        if ((r136 & 128) == 0) goto L33;
        String r146 = null;
    L35:
        if ((r136 & 256) == 0) goto L37;
        String r147 = null;
    L39:
        if ((r136 & 512) == 0) goto L41;
        Integer r148 = null;
    L43:
        if ((r136 & 1024) == 0) goto L45;
        List r149 = null;
    L47:
        if ((r136 & 2048) == 0) goto L49;
        Integer r150 = null;
    L51:
        if ((r136 & 4096) == 0) goto L53;
        List r151 = null;
    L55:
        if ((r136 & 8192) == 0) goto L57;
        Map r152 = null;
    L58:
        Map r153 = r152;
        if ((r136 & 16384) == 0) goto L61;
        Map r154 = null;
    L63:
        if ((r136 & 32768) == 0) goto L65;
        String r155 = null;
    L67:
        if ((r136 & 65536) == 0) goto L69;
        String r210 = null;
    L71:
        if ((r136 & 131072) == 0) goto L73;
        Integer r211 = null;
    L75:
        if ((r136 & 262144) == 0) goto L77;
        String r212 = null;
    L79:
        if ((r136 & 524288) == 0) goto L81;
        String r213 = null;
    L83:
        if ((r136 & 1048576) == 0) goto L85;
        String r214 = null;
    L87:
        if ((r136 & 2097152) == 0) goto L89;
        String r215 = null;
    L91:
        if ((r136 & 4194304) == 0) goto L93;
        String r216 = null;
    L95:
        if ((r136 & 8388608) == 0) goto L97;
        String r310 = null;
    L99:
        if ((r136 & 16777216) == 0) goto L101;
        String r311 = null;
    L103:
        if ((r136 & 33554432) == 0) goto L105;
        Integer r312 = null;
    L107:
        if ((r136 & 67108864) == 0) goto L109;
        Long r313 = null;
    L111:
        if ((r136 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Long r314 = null;
    L115:
        if ((r136 & 268435456) == 0) goto L117;
        Long r315 = null;
    L119:
        if ((r136 & 536870912) == 0) goto L121;
        UrlModel r316 = null;
    L123:
        if ((r136 & 1073741824) == 0) goto L125;
        Integer r317 = null;
    L127:
        if ((r136 & Integer.MIN_VALUE) == 0) goto L129;
        UrlModel r156 = null;
    L131:
        if ((r137 & 1) == 0) goto L133;
        Integer r318 = null;
    L135:
        if ((r137 & 2) == 0) goto L137;
        String r319 = null;
    L139:
        if ((r137 & 4) == 0) goto L141;
        String r410 = null;
    L142:
        UrlModel r1310 = r156;
        if ((r137 & 8) == 0) goto L145;
        int r411 = 0;
    L147:
        if ((r137 & 16) == 0) goto L149;
        int r412 = 0;
    L151:
        if ((r137 & 32) == 0) goto L153;
        Integer r413 = null;
    L155:
        if ((r137 & 64) == 0) goto L157;
        int r414 = 0;
    L159:
        if ((r137 & 128) == 0) goto L161;
        int r157 = 0;
    L162:
        int r415 = r157;
        if ((r137 & 256) == 0) goto L165;
        int r158 = 0;
    L166:
        int r416 = r158;
        if ((r137 & 512) == 0) goto L169;
        int r159 = 0;
    L170:
        int r417 = r159;
        if ((r137 & 1024) == 0) goto L173;
        String r160 = null;
    L174:
        String r418 = r160;
        if ((r137 & 2048) == 0) goto L177;
        Integer r161 = null;
    L178:
        Integer r419 = r161;
        if ((r137 & 4096) == 0) goto L181;
        String r162 = null;
    L182:
        String r510 = r162;
        if ((r137 & 8192) == 0) goto L185;
        String r163 = null;
    L186:
        String r511 = r163;
        if ((r137 & 16384) == 0) goto L189;
        String r164 = null;
    L191:
        if ((r137 & 32768) == 0) goto L193;
        String r165 = null;
    L195:
        if ((r137 & 65536) == 0) goto L197;
        int r166 = 0;
    L199:
        if ((r137 & 131072) == 0) goto L201;
        String r167 = null;
        int r168 = 0;
        GrouponRebootRecoverDotConfig r169 = new GrouponRebootRecoverDotConfig(0, 1, null);
    L203:
        if ((r137 & 262144) == 0) goto L205;
        Object r170 = r167;
    L207:
        if ((r137 & 524288) == 0) goto L209;
        long r512 = 0;
    L211:
        if ((r137 & 1048576) == 0) goto L213;
        String r217 = r167;
    L215:
        if ((r137 & 2097152) == 0) goto L217;
        int r218 = 0;
    L219:
        if ((r137 & 4194304) == 0) goto L221;
        String r513 = r167;
    L223:
        if ((r137 & 8388608) == 0) goto L225;
        Object r514 = r167;
    L227:
        if ((r137 & 16777216) == 0) goto L229;
        int r515 = 0;
    L231:
        if ((r137 & 33554432) == 0) goto L233;
        String r516 = r167;
    L235:
        if ((r137 & 67108864) == 0) goto L237;
        int r612 = 0;
    L239:
        if ((r137 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        String r613 = r167;
    L243:
        if ((r137 & 268435456) == 0) goto L245;
        String r614 = r167;
    L247:
        if ((r137 & 536870912) == 0) goto L249;
        Object r615 = r167;
    L251:
        if ((r137 & 1073741824) != 0) goto L255;
        r168 = r131;
    L255:
        if ((r137 & Integer.MIN_VALUE) == 0) goto L257;
        String r171 = r167;
    L259:
        if ((r138 & 1) == 0) goto L261;
        String r616 = r167;
    L263:
        if ((r138 & 2) == 0) goto L265;
        String r617 = r167;
    L267:
        if ((r138 & 4) != 0) goto L270;
        r167 = r135;
    L270:
        this(r120, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r153, r154, r155, r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r1310, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r164, r165, r166, r169, r170, r512, r217, r218, r513, r514, r515, r516, r612, r613, r614, r615, r168, r171, r616, r617, r167);
        return;
    L265:
        r617 = r134;
        goto L267
    L261:
        r616 = r133;
        goto L263
    L257:
        r171 = r132;
        goto L259
    L249:
        r615 = r130;
        goto L251
    L245:
        r614 = r129;
        goto L247
    L241:
        r613 = r128;
        goto L243
    L237:
        r612 = r127;
        goto L239
    L233:
        r516 = r126;
        goto L235
    L229:
        r515 = r125;
        goto L231
    L225:
        r514 = r124;
        goto L227
    L221:
        r513 = r123;
        goto L223
    L217:
        r218 = r122;
        goto L219
    L213:
        r217 = r121;
        goto L215
    L209:
        r512 = r119;
        goto L211
    L205:
        r170 = r118;
        goto L207
    L201:
        r167 = null;
        r168 = 0;
        r169 = r117;
        goto L203
    L197:
        r166 = r116;
        goto L199
    L193:
        r165 = r115;
        goto L195
    L189:
        r164 = r114;
        goto L191
    L185:
        r163 = r113;
        goto L186
    L181:
        r162 = r112;
        goto L182
    L177:
        r161 = r111;
        goto L178
    L173:
        r160 = r110;
        goto L174
    L169:
        r159 = r109;
        goto L170
    L165:
        r158 = r108;
        goto L166
    L161:
        r157 = r107;
        goto L162
    L157:
        r414 = r106;
        goto L159
    L153:
        r413 = r105;
        goto L155
    L149:
        r412 = r104;
        goto L151
    L145:
        r411 = r103;
        goto L147
    L141:
        r410 = r102;
        goto L142
    L137:
        r319 = r101;
        goto L139
    L133:
        r318 = r100;
        goto L135
    L129:
        r156 = r919;
        goto L131
    L125:
        r317 = r918;
        goto L127
    L121:
        r316 = r917;
        goto L123
    L117:
        r315 = r916;
        goto L119
    L113:
        r314 = r915;
        goto L115
    L109:
        r313 = r914;
        goto L111
    L105:
        r312 = r913;
        goto L107
    L101:
        r311 = r912;
        goto L103
    L97:
        r310 = r911;
        goto L99
    L93:
        r216 = r910;
        goto L95
    L89:
        r215 = r819;
        goto L91
    L85:
        r214 = r818;
        goto L87
    L81:
        r213 = r817;
        goto L83
    L77:
        r212 = r816;
        goto L79
    L73:
        r211 = r815;
        goto L75
    L69:
        r210 = r814;
        goto L71
    L65:
        r155 = r813;
        goto L67
    L61:
        r154 = r812;
        goto L63
    L57:
        r152 = r811;
        goto L58
    L53:
        r151 = r810;
        goto L55
    L49:
        r150 = r719;
        goto L51
    L45:
        r149 = r718;
        goto L47
    L41:
        r148 = r717;
        goto L43
    L37:
        r147 = r716;
        goto L39
    L33:
        r146 = r715;
        goto L35
    L29:
        r145 = r714;
        goto L31
    L25:
        r144 = r713;
        goto L27
    L21:
        r143 = r712;
        goto L23
    L17:
        r142 = r711;
        goto L19
    L13:
        r141 = r710;
        goto L15
    L9:
        r140 = r611;
        goto L11
    L5:
        r120 = r610;
        goto L7
    }
}
