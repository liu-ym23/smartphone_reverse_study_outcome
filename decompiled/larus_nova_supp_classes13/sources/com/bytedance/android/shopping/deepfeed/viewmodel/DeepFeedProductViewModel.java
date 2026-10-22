package com.bytedance.android.shopping.deepfeed.viewmodel;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3Api;
import com.bytedance.android.shopping.buynow.data.model.PageScrollStatus;
import com.bytedance.android.shopping.deepfeed.action.DeepFeedCouponInterrupt;
import com.bytedance.android.shopping.deepfeed.action.h;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedProductDataCenter;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.deepfeed.data.repo.AbsDeepFeedRequest;
import com.bytedance.android.shopping.deepfeed.data.repo.DeepFeedAbValues;
import com.bytedance.android.shopping.deepfeed.data.repo.DeepFeedRepHelpKt;
import com.bytedance.android.shopping.deepfeed.data.repo.i;
import com.bytedance.android.shopping.deepfeed.data.repo.m;
import com.bytedance.android.shopping.deepfeed.data.repo.n;
import com.bytedance.android.shopping.deepfeed.data.repo.o;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.bytedance.android.shopping.deepfeed.event.f;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.inflow.common.base.LoadStatus;
import com.bytedance.android.shopping.inflow.common.viewmodel.UselessJediViewModel;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import he3.e1;
import he3.e2;
import he3.i1;
import he3.l;
import he3.m1;
import he3.m2;
import he3.n0;
import he3.p0;
import he3.r;
import he3.u0;
import he3.v;
import he3.z0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\t¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J&\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00032\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rH\u0002J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0014J\u001c\u0010\u0017\u001a\u00020\t2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010\u001e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020 J\u0016\u0010'\u001a\u00020\t2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%J\u0010\u0010*\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010(J\u0006\u0010+\u001a\u00020\tJ\u0006\u0010,\u001a\u00020\tJ\u000e\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0005J\u000e\u00101\u001a\u00020\t2\u0006\u00100\u001a\u00020/J\u0006\u00102\u001a\u00020\tJ\u0010\u00104\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u0003J\u0019\u00105\u001a\u0004\u0018\u00010\u001b2\b\u00103\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b5\u00106J\u0019\u00107\u001a\u0004\u0018\u00010\u001b2\b\u00103\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b7\u00106J\u0010\u00108\u001a\u00020\u001b2\b\u00103\u001a\u0004\u0018\u00010\u0003J\u0010\u0010:\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u00010#J\u001e\u0010>\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000eJ\u000e\u0010?\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u001bJ\u0010\u0010@\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u0003J(\u0010D\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u00052\u0018\b\u0002\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010BJ\"\u0010F\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u00010\u0003J2\u0010J\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u0010G\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020(2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010HJ^\u0010O\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\u0006\u0010K\u001a\u00020\u000e2\b\u0010L\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0H2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u000e2\u0018\b\u0002\u0010N\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\rJR\u0010P\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\u0006\u0010K\u001a\u00020\u000e2\b\u0010E\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0H2\u0018\b\u0002\u0010N\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\rJ&\u0010R\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\u0006\u0010Q\u001a\u00020\u00052\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0HJ\u001e\u0010S\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0HJ*\u0010T\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\u0006\u0010K\u001a\u00020\u000e2\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010HJ\u001e\u0010U\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0HJ:\u0010W\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u0010K\u001a\u0004\u0018\u00010\u000e2\b\u0010V\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0HJ:\u0010X\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\u0006\u0010K\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0H2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u000eJ0\u0010Z\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u0010Y\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0HJ0\u0010[\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u0010Y\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0HJ0\u0010]\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u0010\\\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0HJ0\u0010_\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u0010^\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0HJ\u000e\u0010`\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u000eJ.\u0010c\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u0010a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020(2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u000eJ,\u0010f\u001a\u00020\t2\u0006\u0010d\u001a\u00020\u001b2\u0006\u0010e\u001a\u00020\u001b2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rJY\u0010i\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u0010g\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0H2\b\u0010h\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015¢\u0006\u0004\bi\u0010jJK\u0010p\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020(2\b\u0010l\u001a\u0004\u0018\u00010k2\b\u0010n\u001a\u0004\u0018\u00010m2\b\u0010o\u001a\u0004\u0018\u00010\u000e2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0H¢\u0006\u0004\bp\u0010qJU\u0010t\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u0010l\u001a\u0004\u0018\u00010k2\b\u0010n\u001a\u0004\u0018\u00010m2\b\u0010r\u001a\u0004\u0018\u00010\u000e2\b\u0010s\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0H¢\u0006\u0004\bt\u0010uJ<\u0010w\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010L\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020(2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0H2\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u000eJD\u0010|\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\u0006\u0010x\u001a\u00020\u001b2\u0006\u0010y\u001a\u00020m2\u0006\u0010z\u001a\u00020\u000e2\u0006\u0010{\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010\u000e2\b\u0010)\u001a\u0004\u0018\u00010(JL\u0010\u0081\u0001\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\u0006\u0010}\u001a\u00020m2\u0006\u0010~\u001a\u00020m2\u0006\u0010\u007f\u001a\u00020\u00052\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(J\u0013\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u000e2\b\u00103\u001a\u0004\u0018\u00010\u0003J\u001a\u0010\u0084\u0001\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u00032\u0007\u0010\u0083\u0001\u001a\u00020\u0005J\u0011\u0010\u0085\u0001\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u0003J\u0011\u0010\u0088\u0001\u001a\u00020\t2\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001J\u0011\u0010\u0089\u0001\u001a\u00020\t2\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001J)\u0010\u008c\u0001\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u008b\u0001\u001a\u0011\u0012\u0007\u0012\u0005\u0018\u00010\u008a\u0001\u0012\u0004\u0012\u00020\t0\u0015J\u0007\u0010\u008d\u0001\u001a\u00020\tJ\u0007\u0010\u008e\u0001\u001a\u00020\u001bR.\u0010\u0090\u0001\u001a\u0004\u0018\u00010#2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010#8\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R,\u0010&\u001a\u0004\u0018\u00010%2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010%8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\b&\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R0\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u00012\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R,\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R$\u0010¥\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010£\u00018\u0006¢\u0006\u0010\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001R&\u0010«\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010ª\u00010©\u00018\u0006¢\u0006\u0010\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001R\u0018\u0010°\u0001\u001a\u00030¯\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R!\u0010²\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u008a\u00010©\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b²\u0001\u0010¬\u0001R&\u0010³\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u008a\u00010£\u00018\u0006¢\u0006\u0010\n\u0006\b³\u0001\u0010¦\u0001\u001a\u0006\b´\u0001\u0010¨\u0001R!\u0010¶\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010µ\u00010©\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010¬\u0001R&\u0010·\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010µ\u00010£\u00018\u0006¢\u0006\u0010\n\u0006\b·\u0001\u0010¦\u0001\u001a\u0006\b¸\u0001\u0010¨\u0001R7\u0010»\u0001\u001a\u001d\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030H\u0012\u0005\u0012\u00030º\u00010¹\u00010£\u00018\u0006¢\u0006\u0010\n\u0006\b»\u0001\u0010¦\u0001\u001a\u0006\b¼\u0001\u0010¨\u0001R$\u0010¾\u0001\u001a\n\u0012\u0005\u0012\u00030½\u00010©\u00018\u0006¢\u0006\u0010\n\u0006\b¾\u0001\u0010¬\u0001\u001a\u0006\b¿\u0001\u0010®\u0001R\u001b\u0010À\u0001\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001b\u0010Â\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u0019\u0010Ä\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u0019\u0010Æ\u0001\u001a\u00020m8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\u0019\u0010È\u0001\u001a\u00020m8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010Ç\u0001R!\u0010Î\u0001\u001a\u00030É\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001R\u001e\u0010Ð\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0Ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R\u001f\u0010Ô\u0001\u001a\n\u0012\u0005\u0012\u00030Ó\u00010Ò\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u0019\u0010Ö\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010Å\u0001R\u0019\u0010×\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R)\u0010Ù\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001¨\u0006Ý\u0001"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/viewmodel/DeepFeedProductViewModel;", "Lcom/bytedance/android/shopping/inflow/common/viewmodel/UselessJediViewModel;", "Lcom/bytedance/android/shopping/deepfeed/viewmodel/c;", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductV2;", "packCard", "", "shouldSkipCouponWaistRefresh", "Lcom/bytedance/android/shopping/deepfeed/data/repo/i;", "result", "", "applyCouponWaistRefresh", "consumeNextCardSlideDownIsAuto", "card", "", "", "", "data", "mergeModel", "feedProduct", "onEnterDetail", "onCleared", "Lkotlin/Function1;", "callback", "loadProductPack", "Lcom/bytedance/android/shopping/deepfeed/data/repo/n;", "extra", "loadProductFeed", "", "productId", "message", "dispatchPitayaAutoSlideEvent", "consumePitayaAutoSlideEvent", "Lcom/bytedance/android/shopping/deepfeed/action/h;", "context", "injectDeepFeedContext", "Lcom/bytedance/android/shopping/deepfeed/data/DeepFeedQueryParam;", "param", "Lcom/bytedance/android/shopping/deepfeed/action/d;", "actionHelper", "setup", "Landroid/view/View;", FreqActions.ACTION_VIEW, "logPageView", "onResume", "onStop", "isLoadViewVisible", "loadFeed", "Lcom/bytedance/android/shopping/deepfeed/viewmodel/b;", "status", "refreshAfterCouponWaistReturn", "invalidateCouponWaistRefresh", "inFeedProduct", "loadCouponInfo", "findCardIndex", "(Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductV2;)Ljava/lang/Integer;", "findReportCardIndex", "requireReportCardIndex", "feedQueryParam", "initOnRebuild", "position", "text", "uuid", "insertCard", "removeCardAt", "onFocusInFeedProductChange", "auto", "", "params", "markNextCardSlideDown", "btm", "logShowCartEntrance", "btmCart", "", "productTagsList", "clickCart", "clickArea", "btmEnterProductDetail", "areaBtm", "commonData", "clickProductCard", "reportClickProduct", "isPlaying", "clickVideoChange", "screenShot", "longPress", "seekVideoProgress", "btmEnterLive", "clickLiveInteraction", "reportClickSmallImage", "btmEnterStore", "reportClickStoreEntrance", "clickStore", "btmEnterSearch", "clickSearch", "btmComment", "clickComment", "clickCommentTab", "btmEnterComment", "originLink", "enterComment", "start", "end", "updateModelRange", "btmCollect", "isCollect", "clickCollect", "(Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductV2;Ljava/lang/String;Landroid/view/View;Ljava/util/List;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)V", "Lorg/json/JSONArray;", "selectSpecIds", "", "skuSelectedNum", "btmAddToCard", "clickAddCart", "(Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductV2;Landroid/view/View;Lorg/json/JSONArray;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;)V", "skuSessionId", "btmBuy", "clickBuy", "(Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductV2;Lorg/json/JSONArray;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Ljava/util/List;)V", "link", "enterProductDetail", "cardIndex", "duration", "reportReason", "durationIncludeSubpage", "reportCardStayTime", "playDuration", "videoDuration", "isPlayFinish", "finishMethod", "reportCardVideoProgress", "productIdOf", "success", "reportVideoPlay", "onCardShow", "Lcom/bytedance/android/shopping/deepfeed/action/c;", "listener", "addCouponListener", "removeCouponListener", "Lhe3/l;", "action", "actionAfterCouponRequest", "addNoFullScreenCount", "curNoFullScreenCount", "<set-?>", "feedParam", "Lcom/bytedance/android/shopping/deepfeed/data/DeepFeedQueryParam;", "getFeedParam", "()Lcom/bytedance/android/shopping/deepfeed/data/DeepFeedQueryParam;", "Lcom/bytedance/android/shopping/deepfeed/action/d;", "getActionHelper", "()Lcom/bytedance/android/shopping/deepfeed/action/d;", "Lcom/bytedance/android/shopping/deepfeed/event/DeepFeedProductEventTracker;", "eventTracker", "Lcom/bytedance/android/shopping/deepfeed/event/DeepFeedProductEventTracker;", "getEventTracker", "()Lcom/bytedance/android/shopping/deepfeed/event/DeepFeedProductEventTracker;", "Lcom/bytedance/android/shopping/deepfeed/data/repo/l;", "resp", "Lcom/bytedance/android/shopping/deepfeed/data/repo/l;", "getResp", "()Lcom/bytedance/android/shopping/deepfeed/data/repo/l;", "setResp", "(Lcom/bytedance/android/shopping/deepfeed/data/repo/l;)V", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/shopping/inflow/common/base/LoadStatus;", "inFeedLoadStatus", "Landroidx/lifecycle/LiveData;", "getInFeedLoadStatus", "()Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/MutableLiveData;", "Lhe3/m2;", "showCouponTipsStatus", "Landroidx/lifecycle/MutableLiveData;", "getShowCouponTipsStatus", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/shopping/deepfeed/action/DeepFeedCouponInterrupt;", "couponInterrupt", "Lcom/bytedance/android/shopping/deepfeed/action/DeepFeedCouponInterrupt;", "_firstCardPopup", "firstCardPopup", "getFirstCardPopup", "Lcom/bytedance/android/shopping/deepfeed/viewmodel/d;", "_pitayaAutoSlideEvent", "pitayaAutoSlideEvent", "getPitayaAutoSlideEvent", "Lkotlin/Pair;", "Lcom/bytedance/android/shopping/deepfeed/data/a;", "inFeedCardList", "getInFeedCardList", "Luc3/c;", "couponStatus", "getCouponStatus", "deepFeedContext", "Lcom/bytedance/android/shopping/deepfeed/action/h;", "activeCouponWaistRefreshSessionId", "Ljava/lang/String;", "noFullScreenCount", "I", "pageResumeTimestamp", "J", "pageResumeDuration", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "Lkotlin/Lazy;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "", "finishedVideoProgressProducts", "Ljava/util/Set;", "Lio/reactivex/functions/Consumer;", "Lcom/bytedance/android/shopping/deepfeed/data/repo/m;", "requestStateConsumer", "Lio/reactivex/functions/Consumer;", "lastFocusCardIndex", "nextCardSlideDownIsAuto", "Z", "slideDownParams", "Ljava/util/Map;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductViewModel extends UselessJediViewModel implements c {
    private final MutableLiveData<l> _firstCardPopup;
    private final MutableLiveData<d> _pitayaAutoSlideEvent;
    private com.bytedance.android.shopping.deepfeed.action.d actionHelper;
    private String activeCouponWaistRefreshSessionId;
    private final Lazy compositeDisposable$delegate;
    private final DeepFeedCouponInterrupt couponInterrupt;
    private final MutableLiveData<uc3.c> couponStatus;
    private h deepFeedContext;
    private DeepFeedProductEventTracker eventTracker;
    private DeepFeedQueryParam feedParam;
    private final Set<String> finishedVideoProgressProducts;
    private final LiveData<l> firstCardPopup;
    private final LiveData<Pair<List<InFeedProductV2>, com.bytedance.android.shopping.deepfeed.data.a>> inFeedCardList;
    private final LiveData<LoadStatus> inFeedLoadStatus;
    private int lastFocusCardIndex;
    private boolean nextCardSlideDownIsAuto;
    private int noFullScreenCount;
    private long pageResumeDuration;
    private long pageResumeTimestamp;
    private final LiveData<d> pitayaAutoSlideEvent;
    private final Consumer<m> requestStateConsumer;
    private com.bytedance.android.shopping.deepfeed.data.repo.l resp;
    private final MutableLiveData<m2> showCouponTipsStatus;
    private Map<String, Object> slideDownParams;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ DeepFeedProductViewModel a;

        public a(DeepFeedProductViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            m r6 = (m) r5;
            if (Intrinsics.areEqual(r6.a, Boolean.FALSE) == false) goto L9;
            if (r6.e != 0) goto L7;
            com.bytedance.android.shopping.extensions.e.a(this.a.getInFeedLoadStatus()).setValue(LoadStatus.PACK_ERROR);
        L15:
            List<InFeedProductV2> r0 = r6.b;
            if (r0 != null) goto L18;
        L21:
            boolean r1 = true;
        L22:
            if (r1 == true) goto L28;
            ArrayList r2 = new ArrayList();
            r2.addAll(r6.b);
            MutableLiveData r3 = com.bytedance.android.shopping.extensions.e.a(this.a.getInFeedCardList());
            com.bytedance.android.shopping.deepfeed.data.a r7 = r6.f;
            if (r7 != null) goto L26;
            r7 = new com.bytedance.android.shopping.deepfeed.data.a(false, 0, false, 6);
        L26:
            r3.setValue(TuplesKt.to(r2, r7));
            return;
        L28:
            return;
        L18:
            if (r0.isEmpty() == true) goto L21;
            r1 = false;
            goto L22
        L7:
            com.bytedance.android.shopping.extensions.e.a(this.a.getInFeedLoadStatus()).setValue(LoadStatus.FINISH_ERROR);
            goto L15
        L9:
            if (r6.d == false) goto L12;
            com.bytedance.android.shopping.extensions.e.a(this.a.getInFeedLoadStatus()).setValue(LoadStatus.LOADING);
            goto L15
        L12:
            if (r6.c == false) goto L14;
            com.bytedance.android.shopping.extensions.e.a(this.a.getInFeedLoadStatus()).setValue(LoadStatus.FINISH_HAS_MORE);
            goto L15
        L14:
            com.bytedance.android.shopping.extensions.e.a(this.a.getInFeedLoadStatus()).setValue(LoadStatus.FINISH_NO_MORE);
            goto L15
        }
    }

    public final CompositeDisposable getCompositeDisposable() {
        return (CompositeDisposable) this.compositeDisposable$delegate.getValue();
    }

    public final void invalidateCouponWaistRefresh() {
        this.activeCouponWaistRefreshSessionId = null;
    }

    private final boolean consumeNextCardSlideDownIsAuto() {
        boolean r0 = this.nextCardSlideDownIsAuto;
        this.nextCardSlideDownIsAuto = false;
        return r0;
    }

    public final void addNoFullScreenCount() {
        this.noFullScreenCount++;
    }

    public final void consumePitayaAutoSlideEvent() {
        this._pitayaAutoSlideEvent.setValue(null);
    }

    public DeepFeedProductViewModel() {
        this.inFeedLoadStatus = new MutableLiveData(LoadStatus.IDLE);
        MutableLiveData<m2> r0 = new MutableLiveData(null);
        this.showCouponTipsStatus = r0;
        this.couponInterrupt = new DeepFeedCouponInterrupt(r0);
        MutableLiveData<l> r1 = new MutableLiveData();
        this._firstCardPopup = r1;
        this.firstCardPopup = r1;
        MutableLiveData<d> r2 = new MutableLiveData();
        this._pitayaAutoSlideEvent = r2;
        this.pitayaAutoSlideEvent = r2;
        this.inFeedCardList = new MutableLiveData(new Pair(new ArrayList(), new com.bytedance.android.shopping.deepfeed.data.a(false, 0, false, 6)));
        this.couponStatus = new MutableLiveData();
        this.noFullScreenCount = 3;
        this.compositeDisposable$delegate = LazyKt.lazy(DeepFeedProductViewModel$compositeDisposable$2.INSTANCE);
        this.finishedVideoProgressProducts = new LinkedHashSet();
        this.requestStateConsumer = new a(this);
        this.lastFocusCardIndex = -1;
    }

    public void onCleared() {
        super.onCleared();
        DeepFeedQueryParam r0 = this.feedParam;
        if (r0 == null) goto L33;
        HashMap<String, com.bytedance.android.shopping.deepfeed.data.repo.l> r2 = DeepFeedProductDataCenter.a;
        Intrinsics.checkNotNullParameter(r0, "param");
        com.bytedance.android.shopping.deepfeed.data.repo.l r1 = DeepFeedProductDataCenter.a.remove(String.valueOf(r0.getUid()));
        if (r1 == null) goto L33;
        r1.i = true;
        if (r1.j.isEmpty() == true) goto L29;
        Set<String> r3 = r1.j;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L11:
        if (r5.hasNext() == false) goto L23;
        Object r6 = r5.next();
        if ((r6 instanceof String) == true) goto L15;
        r6 = null;
    L15:
        String r7 = (String) r6;
        if (r7 != null) goto L18;
    L20:
        r7 = null;
    L21:
        if (r7 == null) goto L11;
        r4.add(r7);
        goto L11
    L18:
        if ((!StringsKt.isBlank(r7)) == false) goto L20;
    L23:
        List r8 = CollectionsKt.distinct(r4);
        r1.j.clear();
        if (r8.isEmpty() == true) goto L29;
        int r9 = ECSdk.a;
        g r10 = (g) ECSdk.a(g.class);
        if (r10 == null) goto L29;
        r10.w(r8, r1.k);
    L29:
        o r11 = r1.b();
        if (r11 == null) goto L32;
        ((AbsDeepFeedRequest) r11).k();
    L32:
        r1.n = null;
        r1.f = null;
        r1.e = null;
        r1.release();
        r1.p.a();
    L33:
        DeepFeedProductEventTracker r12 = this.eventTracker;
        if (r12 == null) goto L36;
        r12.doEventAction("ecom_deep_feed_stay_time", new Pair[]{TuplesKt.to("duration", Long.valueOf(this.pageResumeDuration))});
    L36:
        getCompositeDisposable().dispose();
        getCompositeDisposable().clear();
    }

    public final void onResume() {
        this.pageResumeTimestamp = SystemClock.uptimeMillis();
    }

    public final void onStop() {
        long r0 = SystemClock.uptimeMillis();
        this.pageResumeDuration += r0 - this.pageResumeTimestamp;
        this.pageResumeTimestamp = r0;
    }

    public final int curNoFullScreenCount() {
        return this.noFullScreenCount;
    }

    public final com.bytedance.android.shopping.deepfeed.action.d getActionHelper() {
        return this.actionHelper;
    }

    public final MutableLiveData<uc3.c> getCouponStatus() {
        return this.couponStatus;
    }

    public final DeepFeedProductEventTracker getEventTracker() {
        return this.eventTracker;
    }

    public final DeepFeedQueryParam getFeedParam() {
        return this.feedParam;
    }

    public final LiveData<l> getFirstCardPopup() {
        return this.firstCardPopup;
    }

    public final LiveData<Pair<List<InFeedProductV2>, com.bytedance.android.shopping.deepfeed.data.a>> getInFeedCardList() {
        return this.inFeedCardList;
    }

    public final LiveData<LoadStatus> getInFeedLoadStatus() {
        return this.inFeedLoadStatus;
    }

    public final LiveData<d> getPitayaAutoSlideEvent() {
        return this.pitayaAutoSlideEvent;
    }

    public final com.bytedance.android.shopping.deepfeed.data.repo.l getResp() {
        return this.resp;
    }

    public final MutableLiveData<m2> getShowCouponTipsStatus() {
        return this.showCouponTipsStatus;
    }

    public static final /* synthetic */ com.bytedance.android.shopping.deepfeed.action.d access$getActionHelper$p(DeepFeedProductViewModel r0) {
        return r0.actionHelper;
    }

    public static final /* synthetic */ String access$getActiveCouponWaistRefreshSessionId$p(DeepFeedProductViewModel r0) {
        return r0.activeCouponWaistRefreshSessionId;
    }

    public static final /* synthetic */ DeepFeedProductEventTracker access$getEventTracker$p(DeepFeedProductViewModel r0) {
        return r0.eventTracker;
    }

    public static final /* synthetic */ DeepFeedQueryParam access$getFeedParam$p(DeepFeedProductViewModel r0) {
        return r0.feedParam;
    }

    private final void applyCouponWaistRefresh(i r11) {
        com.bytedance.android.shopping.deepfeed.data.repo.l r0 = this.resp;
        if (r0 == null) goto L30;
        Intrinsics.checkNotNullParameter(r11, "result");
        InFeedProductV2 r1 = r11.b;
        if (r1 == null) goto L7;
        boolean r2 = r0.a(0, r1);
    L8:
        Iterator r12 = CollectionsKt.take(r11.c, 4).iterator();
        int r3 = 0;
    L10:
        if (r12.hasNext() == false) goto L21;
        Object r4 = r12.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        if (r0.a(r5, (InFeedProductV2) r4) == true) goto L19;
        if (r2 == true) goto L19;
        r2 = false;
    L20:
        r3 = r5;
    L19:
        r2 = true;
        goto L20
    L21:
        if (r2 == false) goto L32;
        Consumer<m> r13 = r0.f;
        if (r13 == null) goto L31;
        r13.accept(new m(Boolean.TRUE, CollectionsKt.toList(r0.c), true, false, new com.bytedance.android.shopping.deepfeed.data.a(false, 0, false, 6), 16));
        return;
    L31:
        return;
    L32:
        return;
    L7:
        r2 = false;
        goto L8
    }

    private final void onEnterDetail(InFeedProductV2 r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        h r0 = this.deepFeedContext;
        if (r0 == null) goto L8;
        r0.u(new com.bytedance.android.shopping.deepfeed.viewmodel.a(r3.getDynamicData().b));
        return;
    }

    private final boolean shouldSkipCouponWaistRefresh(InFeedProductV2 r3) {
        Object r0 = null;
        if (r3 == null) goto L9;
        n0 r4 = r3.slcCard();
        if (r4 == null) goto L9;
        Map<String, Map<String, Object>> r5 = r4.f();
        if (r5 == null) goto L9;
        Map<String, Object> r6 = r5.get("product_card");
    L11:
        if ((r6 instanceof Map) == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L15;
        Object r7 = r6.get("waist_info");
    L17:
        if ((r7 instanceof Map) == true) goto L19;
        r7 = null;
    L19:
        Map r8 = (Map) r7;
        if (r8 == null) goto L23;
        r0 = r8.get("type_name");
    L23:
        return Intrinsics.areEqual(r0, "coupon");
    L15:
        r7 = null;
    L9:
        r6 = null;
        goto L11
    }

    public final void addCouponListener(com.bytedance.android.shopping.deepfeed.action.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        DeepFeedCouponInterrupt r1 = this.couponInterrupt;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) r1.c).add(r3);
    }

    public final void clickCommentTab(String r4) {
        Intrinsics.checkNotNullParameter(r4, "clickArea");
        DeepFeedProductEventTracker r0 = this.eventTracker;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "clickType");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("click_type", r4);
        r0.doEventAction("deep_feed_evaluation_click", r1);
        return;
    }

    public final Integer findCardIndex(InFeedProductV2 r3) {
        Pair r0 = (Pair) this.inFeedCardList.getValue();
        if (r0 == null) goto L7;
        List r1 = (List) r0.getFirst();
        if (r1 == null) goto L7;
        Integer r4 = Integer.valueOf(CollectionsKt.indexOf(r1, r3));
    L8:
        int r5 = k.g(r4, -1);
        if (r5 >= 0) goto L12;
        return null;
    L12:
        return Integer.valueOf(r5);
    L7:
        r4 = null;
        goto L8
    }

    public final Integer findReportCardIndex(InFeedProductV2 r3) {
        if (r3 == null) goto L13;
        v r4 = r3.getDynamicData();
        if (r4 == null) goto L14;
        Integer r5 = Integer.valueOf(r4.c);
        if (r5.intValue() < 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        return null;
    L12:
        return r5;
    L9:
        r1 = false;
        goto L10
    L14:
        return null;
    L13:
        return null;
    }

    public final void initOnRebuild(DeepFeedQueryParam r20) {
        DeepFeedQueryParam r1 = r20;
        this.feedParam = r1;
        this.finishedVideoProgressProducts.clear();
        HashMap<String, com.bytedance.android.shopping.deepfeed.data.repo.l> r2 = DeepFeedProductDataCenter.a;
        if (r1 != null) goto L5;
        r1 = new DeepFeedQueryParam(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    L5:
        this.resp = DeepFeedProductDataCenter.a(r1);
    }

    public final void injectDeepFeedContext(h r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.deepFeedContext = r2;
    }

    public final void loadCouponInfo(final InFeedProductV2 r3) {
        com.bytedance.android.shopping.deepfeed.data.repo.l r0 = this.resp;
        if (r0 == null) goto L6;
        r0.c(r3, new C02641(this, r3));
        return;
    }

    public final void loadFeed(boolean r3) {
        LoadStatus r0 = (LoadStatus) this.inFeedLoadStatus.getValue();
        if (r0 != LoadStatus.LOADING) goto L5;
    L14:
        DeepFeedProductEventTracker r1 = this.eventTracker;
        if (r1 == null) goto L19;
        r1.t(r3);
        return;
    L19:
        return;
    L5:
        if (r0 == LoadStatus.FINISH_NO_MORE) goto L14;
        com.bytedance.android.shopping.deepfeed.data.repo.l r2 = this.resp;
        if (r2 == null) goto L10;
        com.bytedance.android.shopping.deepfeed.data.repo.l.d(r2, null);
    L10:
        DeepFeedProductEventTracker r4 = this.eventTracker;
        if (r4 == null) goto L18;
        r4.t(r3);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.viewmodel.c
    public void loadProductFeed(n r2) {
        com.bytedance.android.shopping.deepfeed.data.repo.l r0 = this.resp;
        if (r0 == null) goto L6;
        com.bytedance.android.shopping.deepfeed.data.repo.l.d(r0, r2);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.viewmodel.c
    public void loadProductPack(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        com.bytedance.android.shopping.deepfeed.data.repo.l r0 = this.resp;
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    public final void logPageView(View r5) {
        DeepFeedProductEventTracker r0 = this.eventTracker;
        if (r0 == null) goto L6;
        Map<String, ? extends Object> r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "deep_feed")});
        le3.b.a(r1, "a1.b811296.c0.d0", r5);
        r0.doEventAction("page_view", r1);
        return;
    }

    public final void onCardShow(InFeedProductV2 r3) {
        com.bytedance.android.shopping.deepfeed.data.repo.l r0 = this.resp;
        if (r0 == null) goto L13;
        r0.g = true;
        Runnable r1 = r0.h;
        if (r1 == null) goto L7;
        r1.run();
    L7:
        r0.h = null;
        if (r3 == null) goto L14;
        String r4 = DeepFeedRepHelpKt.a(r3);
        if (r4 == null) goto L15;
        r0.o.appendFilters(r4);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void onFocusInFeedProductChange(InFeedProductV2 r18) {
        Integer r1 = findCardIndex(r18);
        if (r1 == null) goto L76;
        int r2 = r1.intValue();
        if (this.lastFocusCardIndex != (-1)) goto L8;
        this.lastFocusCardIndex = r2;
        return;
    L8:
        Pair r3 = (Pair) this.inFeedCardList.getValue();
        if (r3 == null) goto L13;
        List r4 = (List) r3.getFirst();
        if (r4 == null) goto L13;
        InFeedProductV2 r5 = (InFeedProductV2) CollectionsKt.getOrNull(r4, this.lastFocusCardIndex);
    L14:
        if (r5 == null) goto L19;
        u0 r6 = r5.getCustom();
        if (r6 == null) goto L19;
        String r7 = r6.a();
        if (r7 == null) goto L19;
    L20:
        if (r5 == null) goto L26;
        InFeedProductPackData r8 = r5.getPackData();
        if (r8 == null) goto L26;
        InFeedProductPackDataElements r9 = r8.getElements();
        if (r9 == null) goto L26;
        ie3.a r10 = r9.getAd();
    L28:
        if (r10 == null) goto L30;
        boolean r11 = true;
    L31:
        if (r5 != null) goto L33;
    L34:
        if (r5 != null) goto L36;
    L38:
        Integer r12 = findReportCardIndex(r5);
        if (r12 == null) goto L41;
        int r13 = r12.intValue();
    L43:
        if (r2 <= this.lastFocusCardIndex) goto L63;
        if (r5 == null) goto L48;
        e1 r14 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r5);
        if (r14 == null) goto L48;
        String r15 = r14.a();
    L49:
        DeepFeedProductEventTracker r16 = this.eventTracker;
        if (r16 == null) goto L62;
        if (r5 == null) goto L55;
        v r17 = r5.getDynamicData();
        if (r17 == null) goto L55;
        Map<? extends String, ? extends Object> r19 = r17.a;
    L56:
        boolean r110 = consumeNextCardSlideDownIsAuto();
        Map<? extends String, ? extends Object> r20 = this.slideDownParams;
        Map<String, ? extends Object> r21 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("inflow_order", Integer.valueOf(r13)), TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r15), TuplesKt.to("recommend_info", r7), TuplesKt.to("is_ad", Boolean.valueOf(r11)), TuplesKt.to("is_auto_slide", Integer.valueOf(r110 ? 1 : 0))});
        if (r19 == null) goto L59;
        r21.putAll(r19);
    L59:
        if (r20 == null) goto L61;
        r21.putAll(r20);
    L61:
        r16.doEventAction("ecom_card_slide_down", r21);
    L55:
        r19 = null;
    L62:
        this.slideDownParams = null;
    L73:
        this.lastFocusCardIndex = r2;
        return;
    L48:
        r15 = null;
        goto L49
    L63:
        Map<String, Object> r22 = null;
        this.nextCardSlideDownIsAuto = false;
        this.slideDownParams = null;
        DeepFeedProductEventTracker r23 = this.eventTracker;
        if (r23 == null) goto L73;
        if (r5 == null) goto L69;
        v r24 = r5.getDynamicData();
        if (r24 == null) goto L69;
        r22 = r24.a;
    L69:
        Map<String, ? extends Object> r25 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("inflow_order", Integer.valueOf(r13)), TuplesKt.to("recommend_info", r7), TuplesKt.to("is_ad", Boolean.valueOf(r11))});
        if (r22 == null) goto L72;
        r25.putAll(r22);
    L72:
        r23.doEventAction("ecom_card_slide_up", r25);
        goto L73
    L41:
        r13 = this.lastFocusCardIndex;
        goto L43
    L36:
        if (r5.isCacheData() != true) goto L38;
        return;
    L33:
        if (r5.isSkeletonData() != true) goto L34;
        return;
    L30:
        r11 = false;
    L26:
        r10 = null;
    L19:
        r7 = "";
    L13:
        r5 = null;
        goto L14
    }

    public final String productIdOf(InFeedProductV2 r1) {
        return f.b(r1);
    }

    public final void refreshAfterCouponWaistReturn(b r3) {
        Intrinsics.checkNotNullParameter(r3, "status");
        if (r3.a == 0) goto L5;
        return;
    L5:
        final String r4 = UUID.randomUUID().toString();
        this.activeCouponWaistRefreshSessionId = r4;
        com.bytedance.android.shopping.deepfeed.data.repo.l r0 = this.resp;
        if (r0 == null) goto L9;
        r0.h(r4, new C02651(this, r4));
        return;
    }

    public final boolean removeCardAt(int r12) {
        com.bytedance.android.shopping.deepfeed.data.repo.l r0 = this.resp;
        if (r0 == null) goto L16;
        int r2 = ((ArrayList) r0.c).size();
        if (r12 < 0) goto L12;
        if (r2 <= r12) goto L12;
        ListProtector.remove(r0.c, r12);
        Consumer<m> r13 = r0.f;
        if (r13 == null) goto L11;
        r13.accept(new m(Boolean.TRUE, CollectionsKt.toList(r0.c), true, false, null, 48));
    L11:
        boolean r14 = true;
    L13:
        if (r14 != true) goto L17;
        return true;
    L17:
        return false;
    L12:
        r14 = false;
        goto L13
    L16:
        return false;
    }

    public final void removeCouponListener(com.bytedance.android.shopping.deepfeed.action.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        DeepFeedCouponInterrupt r1 = this.couponInterrupt;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) r1.c).remove(r3);
    }

    public final int requireReportCardIndex(InFeedProductV2 r1) {
        Integer r2 = findReportCardIndex(r1);
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.intValue();
    }

    public final void setResp(com.bytedance.android.shopping.deepfeed.data.repo.l r1) {
        this.resp = r1;
    }

    public static final /* synthetic */ void access$applyCouponWaistRefresh(DeepFeedProductViewModel r0, i r1) {
        r0.applyCouponWaistRefresh(r1);
    }

    public static final /* synthetic */ void access$setActionHelper$p(DeepFeedProductViewModel r0, com.bytedance.android.shopping.deepfeed.action.d r1) {
        r0.actionHelper = r1;
    }

    public static final /* synthetic */ void access$setActiveCouponWaistRefreshSessionId$p(DeepFeedProductViewModel r0, String r1) {
        r0.activeCouponWaistRefreshSessionId = r1;
    }

    public static final /* synthetic */ void access$setEventTracker$p(DeepFeedProductViewModel r0, DeepFeedProductEventTracker r1) {
        r0.eventTracker = r1;
    }

    public static final /* synthetic */ void access$setFeedParam$p(DeepFeedProductViewModel r0, DeepFeedQueryParam r1) {
        r0.feedParam = r1;
    }

    public static final /* synthetic */ boolean access$shouldSkipCouponWaistRefresh(DeepFeedProductViewModel r0, InFeedProductV2 r1) {
        return r0.shouldSkipCouponWaistRefresh(r1);
    }

    private final void mergeModel(InFeedProductV2 r1, Map<String, ? extends Object> r2) {
        n0 r3 = r1.slcCard();
        if (r3 != null) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.deepfeed.slice.c r4 = r3.d;
        if (r4 != null) goto L8;
        return;
    L8:
        xc3.a.b(r4, r2);
    }

    public final void actionAfterCouponRequest(InFeedProductV2 r3, final Function1<? super l, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        this.couponInterrupt.b(r3, new AnonymousClass1(r4));
    }

    public final void markNextCardSlideDown(boolean r1, Map<String, Object> r2) {
        this.nextCardSlideDownIsAuto = r1;
        this.slideDownParams = r2;
    }

    public final void reportVideoPlay(InFeedProductV2 r8, boolean r9) {
        Integer r0 = findReportCardIndex(r8);
        if (r0 == null) goto L32;
        int r1 = r0.intValue();
        DeepFeedProductEventTracker r2 = this.eventTracker;
        if (r2 == null) goto L33;
        if (r8 == null) goto L35;
        e1 r3 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r8);
        if (r3 == null) goto L34;
        String r4 = r3.a();
        if (r4 == null) goto L36;
        List<e2> r5 = com.bytedance.android.shopping.deepfeed.utlis.a.m(r8);
        String r6 = null;
        if (r5 == null) goto L18;
        e2 r7 = (e2) CollectionsKt.firstOrNull(r5);
        if (r7 == null) goto L18;
        String r10 = r7.e();
    L19:
        Pair<String, ? extends Object>[] r11 = new Pair[7];
        r11[0] = TuplesKt.to("inflow_order", Integer.valueOf(r1));
        r11[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r4);
        z0 r12 = r8.getRespExtra();
        if (r12 == null) goto L22;
        Integer r13 = r12.b();
    L23:
        r11[2] = TuplesKt.to("inflow_page_number", r13);
        u0 r14 = r8.getCustom();
        if (r14 == null) goto L26;
        String r15 = r14.a();
    L27:
        r11[3] = TuplesKt.to("recommend_info", r15);
        z0 r16 = r8.getRespExtra();
        if (r16 == null) goto L30;
        r6 = r16.c();
    L30:
        r11[4] = TuplesKt.to("request_id", r6);
        r11[5] = TuplesKt.to("video_id", r10);
        r11[6] = TuplesKt.to("is_play_success", Integer.valueOf(r9 ? 1 : 0));
        r2.doEventAction("live_playback_play_start", r11);
        return;
    L26:
        r15 = null;
        goto L27
    L22:
        r13 = null;
    L18:
        r10 = null;
        goto L19
    L36:
        return;
    L34:
        return;
    L35:
        return;
    L33:
        return;
    }

    public final void screenShot(InFeedProductV2 r4, List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "productTagsList");
        Integer r0 = findReportCardIndex(r4);
        if (r0 == null) goto L8;
        int r1 = r0.intValue();
        DeepFeedProductEventTracker r2 = this.eventTracker;
        if (r2 == null) goto L9;
        r2.doEventAction("deep_feed_take_screenshot", r2.g(r1, r4, r5));
        return;
    L9:
        return;
    }

    public final void seekVideoProgress(InFeedProductV2 r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "productTagsList");
        int r0 = requireReportCardIndex(r3);
        DeepFeedProductEventTracker r1 = this.eventTracker;
        if (r1 == null) goto L6;
        r1.doEventAction("slide_deep_feed_video", r1.g(r0, r3, r4));
        return;
    }

    public final void setup(DeepFeedQueryParam r5, com.bytedance.android.shopping.deepfeed.action.d r6) {
        Intrinsics.checkNotNullParameter(r5, "param");
        Intrinsics.checkNotNullParameter(r6, "actionHelper");
        this.feedParam = r5;
        this.finishedVideoProgressProducts.clear();
        DeepFeedQueryParam r0 = this.feedParam;
        if (r0 == null) goto L9;
        DeepFeedAbValues r1 = r0.getAbValues();
        if (r1 == null) goto L9;
        Integer r2 = r1.getNotFullScreenCount();
        if (r2 == null) goto L9;
        this.noFullScreenCount = r2.intValue();
    L9:
        this.actionHelper = r6;
        if (k.c(r5.getEcomEntranceForm()) == false) goto L12;
        String r7 = r5.getEcomEntranceForm();
    L13:
        DeepFeedProductEventTracker r3 = new DeepFeedProductEventTracker();
        Map<String, ? extends Object> r4 = r5.getTracker();
        if (r4 != null) goto L16;
        r4 = new LinkedHashMap();
    L16:
        r3.initEventContext(r4);
        r3.initEventContext(new Pair[]{TuplesKt.to("module_label", "guess_you_like_product"), TuplesKt.to("ecom_entrance_form", r7), TuplesKt.to("previous_page", r5.getEnterFrom()), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, r5.getPageName()), TuplesKt.to("outflow_order", r5.getOutflowRank()), TuplesKt.to("outflow_ecom_type", "product"), TuplesKt.to("outer_reqid", r5.getRequestID())});
        Unit r8 = Unit.INSTANCE;
        this.eventTracker = r3;
        com.bytedance.android.shopping.deepfeed.data.repo.l r9 = DeepFeedProductDataCenter.a(r5);
        this.resp = r9;
        Consumer<m> r10 = this.requestStateConsumer;
        r9.f = r10;
        o r11 = r9.b();
        if (r11 == null) goto L19;
        ((AbsDeepFeedRequest) r11).J(r10);
    L19:
        com.bytedance.android.shopping.deepfeed.data.repo.l r12 = this.resp;
        if (r12 == null) goto L25;
        MutableLiveData<l> r13 = this._firstCardPopup;
        Intrinsics.checkNotNullParameter(r13, "liveData");
        r12.e = r13;
        o r14 = r12.b();
        if (r14 == null) goto L26;
        ((AbsDeepFeedRequest) r14).I(r13);
        return;
    L26:
        return;
    L25:
        return;
    L12:
        r7 = "guess_you_like";
        goto L13
    }

    public final void clickVideoChange(InFeedProductV2 r3, boolean r4, List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "productTagsList");
        Integer r0 = findReportCardIndex(r3);
        if (r0 == null) goto L12;
        int r1 = r0.intValue();
        DeepFeedProductEventTracker r2 = this.eventTracker;
        if (r2 == null) goto L13;
        Map<String, Object> r6 = r2.g(r1, r3, r5);
        if (r4 == false) goto L9;
        String r7 = "1";
    L10:
        r6.put("state", r7);
        r2.doEventAction("deep_feed_video_state_change", r6);
        return;
    L9:
        r7 = "0";
        goto L10
    L13:
        return;
    }

    public final void dispatchPitayaAutoSlideEvent(int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        this._pitayaAutoSlideEvent.postValue(new d(r3, r4, r5));
    }

    public final void insertCard(int r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "text");
        Intrinsics.checkNotNullParameter(r7, "uuid");
        com.bytedance.android.shopping.deepfeed.data.repo.l r2 = this.resp;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r5 <= curNoFullScreenCount()) goto L7;
        boolean r3 = true;
    L8:
        Intrinsics.checkNotNullParameter(r6, "text");
        Intrinsics.checkNotNullParameter(r7, "uuid");
        o r0 = r2.b();
        if (r0 == null) goto L13;
        r0.d(r5, r6, r7, r3);
        return;
    L13:
        return;
    L7:
        r3 = false;
        goto L8
    }

    public final void logShowCartEntrance(String r8, View r9, InFeedProductV2 r10) {
        Intrinsics.checkNotNullParameter(r9, FreqActions.ACTION_VIEW);
        DeepFeedProductEventTracker r1 = this.eventTracker;
        if (r1 == null) goto L6;
        int r0 = DeepFeedProductEventTracker.d;
        r1.x(r8, r9, r10, null, null);
        return;
    }

    public final void longPress(InFeedProductV2 r4, String r5, List<String> r6) {
        Intrinsics.checkNotNullParameter(r5, "clickArea");
        Integer r1 = findReportCardIndex(r4);
        if (r1 == null) goto L8;
        int r2 = r1.intValue();
        DeepFeedProductEventTracker r3 = this.eventTracker;
        if (r3 == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "clickArea");
        Map<String, Object> r7 = r3.g(r2, r4, r6);
        r7.put("area", r5);
        r3.doEventAction("deep_feed_long_press", r7);
        return;
    L9:
        return;
    }

    public final void updateModelRange(int r3, int r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Pair r0 = (Pair) this.inFeedCardList.getValue();
        if (r0 == null) goto L15;
        List r1 = (List) r0.getFirst();
        if (r1 == null) goto L18;
        int r6 = RangesKt.coerceAtLeast(r3, 0);
        int r7 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r4, r1.size() - 1), r6);
        if (r6 > r7) goto L17;
    L9:
        InFeedProductV2 r2 = (InFeedProductV2) CollectionsKt.getOrNull(r1, r6);
        if (r2 == null) goto L13;
        mergeModel(r2, r5);
    L13:
        if (r6 == r7) goto L19;
        r6 = r6 + 1;
        goto L9
    L19:
        return;
    L17:
        return;
    L18:
        return;
    }

    public final void clickCart(InFeedProductV2 r9, String r10, View r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r11, FreqActions.ACTION_VIEW);
        com.bytedance.android.shopping.deepfeed.data.repo.l r0 = this.resp;
        if (r0 == null) goto L5;
        String r1 = r0.d;
    L6:
        if (r1 == null) goto L24;
        String r2 = le3.b.d(r10, r11, null);
        Uri r3 = UriProtector.parse(r1);
        Intrinsics.checkNotNullParameter(r3, "$this$addSourceBtmTokenTOSchema");
        if (r2 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L16;
        r3 = r3.buildUpon().appendQueryParameter("source_btm_token", r2).build();
    L16:
        com.bytedance.android.shopping.deepfeed.action.d r5 = this.actionHelper;
        if (r5 == null) goto L19;
        r5.j("cart", r3.toString());
    L19:
        p r6 = p.a;
        com.bytedance.android.shopping.deepfeed.action.d r7 = this.actionHelper;
        if (r7 == null) goto L22;
        Context r8 = r7.getContext();
    L23:
        r6.openSchema(r8, r3.toString());
        goto L24
    L22:
        r8 = null;
        goto L23
    L10:
        if (r2.length() == 0) goto L13;
        r4 = false;
    L24:
        DeepFeedProductEventTracker r13 = this.eventTracker;
        if (r13 == null) goto L27;
        int r14 = DeepFeedProductEventTracker.d;
        r13.l(r10, r11, r9, null);
    L27:
        Integer r15 = findReportCardIndex(r9);
        if (r15 == null) goto L33;
        int r16 = r15.intValue();
        DeepFeedProductEventTracker r17 = this.eventTracker;
        if (r17 == null) goto L34;
        DeepFeedProductEventTracker.o(r17, r16, r9, "购物车", r10, r11, r12);
        return;
    L34:
        return;
    L33:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void clickComment(InFeedProductV2 r9, String r10, View r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r11, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r12, "productTagsList");
        Integer r0 = findReportCardIndex(r9);
        if (r0 == null) goto L14;
        int r1 = r0.intValue();
        String r2 = le3.b.d(r10, r11, null);
        com.bytedance.android.shopping.deepfeed.action.d r3 = this.actionHelper;
        if (r3 == null) goto L7;
        int r4 = com.bytedance.android.shopping.deepfeed.action.d.h;
        r3.d(r9, r2, null);
    L7:
        DeepFeedProductEventTracker r5 = this.eventTracker;
        if (r5 == null) goto L10;
        int r6 = DeepFeedProductEventTracker.d;
        r5.m(r1, r9, r10, r11, null, null);
    L10:
        DeepFeedProductEventTracker r7 = this.eventTracker;
        if (r7 == null) goto L15;
        DeepFeedProductEventTracker.o(r7, r1, r9, "评价", r10, r11, r12);
        return;
    L15:
        return;
    }

    public final void clickSearch(InFeedProductV2 r10, String r11, View r12, List<String> r13) {
        Intrinsics.checkNotNullParameter(r12, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r13, "productTagsList");
        Integer r1 = findReportCardIndex(r10);
        if (r1 == null) goto L17;
        int r3 = r1.intValue();
        String r2 = le3.b.d(r11, r12, null);
        com.bytedance.android.shopping.deepfeed.action.d r4 = this.actionHelper;
        if (r4 == null) goto L7;
        int r5 = com.bytedance.android.shopping.deepfeed.action.d.h;
        r4.g(r10, r2, null);
    L7:
        DeepFeedProductEventTracker r6 = this.eventTracker;
        if (r6 == null) goto L13;
        DeepFeedQueryParam r7 = this.feedParam;
        int r8 = DeepFeedProductEventTracker.d;
        Intrinsics.checkNotNullParameter(r12, FreqActions.ACTION_VIEW);
        Map<String, ? extends Object> r0 = DeepFeedProductEventTracker.e(r3, r10, r7);
        if (r0 == null) goto L13;
        DeepFeedProductEventTracker.c(r0, null);
        le3.b.a(r0, r11, r12);
        r6.doEventAction("trending_words_click", r0);
    L13:
        DeepFeedProductEventTracker r9 = this.eventTracker;
        if (r9 == null) goto L18;
        DeepFeedProductEventTracker.o(r9, r3, r10, "猜搜", r11, r12, r13);
        return;
    L18:
        return;
    }

    public final void clickStore(final InFeedProductV2 r9, String r10, View r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r11, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r12, "productTagsList");
        Integer r0 = findReportCardIndex(r9);
        if (r0 == null) goto L11;
        int r2 = r0.intValue();
        final String r1 = le3.b.d(r10, r11, null);
        this.couponInterrupt.a(r9, new C02621(this, r9, r1));
        DeepFeedProductEventTracker r3 = this.eventTracker;
        if (r3 == null) goto L7;
        DeepFeedProductEventTracker.q(r3, r2, r9, r10, r11);
    L7:
        DeepFeedProductEventTracker r4 = this.eventTracker;
        if (r4 == null) goto L12;
        DeepFeedProductEventTracker.o(r4, r2, r9, "进店", r10, r11, r12);
        return;
    L12:
        return;
    }

    public final void enterComment(InFeedProductV2 r2, String r3, View r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        String r6 = le3.b.d(r3, r4, null);
        com.bytedance.android.shopping.deepfeed.action.d r7 = this.actionHelper;
        if (r7 == null) goto L6;
        r7.d(r2, r6, r5);
        return;
    }

    public final void reportClickStoreEntrance(InFeedProductV2 r2, String r3, View r4, List<String> r5) {
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r5, "productTagsList");
        Integer r6 = findReportCardIndex(r2);
        if (r6 == null) goto L8;
        int r7 = r6.intValue();
        DeepFeedProductEventTracker r0 = this.eventTracker;
        if (r0 == null) goto L9;
        DeepFeedProductEventTracker.q(r0, r7, r2, r3, r4);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void markNextCardSlideDown$default(DeepFeedProductViewModel r0, boolean r1, Map r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.markNextCardSlideDown(r1, r2);
    }

    public final void clickLiveInteraction(InFeedProductV2 r12, String r13, String r14, View r15, List<String> r16) {
        Intrinsics.checkNotNullParameter(r15, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r16, "productTagsList");
        if (r12 == null) goto L30;
        Intrinsics.checkNotNullParameter(r12, "$this$liveLink");
        p0 r1 = r12.cardData();
        if (r1 == null) goto L13;
        m1 r2 = r1.i();
        if (r2 == null) goto L13;
        he3.m r3 = r2.a();
        if (r3 == null) goto L13;
        r r4 = r3.b();
        if (r4 == null) goto L13;
        String r5 = r4.e();
    L14:
        String r6 = r5;
        if (r6 == null) goto L32;
        int r10 = requireReportCardIndex(r12);
        com.bytedance.android.shopping.deepfeed.action.d r7 = this.actionHelper;
        if (r7 == null) goto L23;
        if (r14 != null) goto L21;
        String r8 = "";
    L22:
        r7.e(r12, r6, r10, r8, r15);
        goto L23
    L21:
        r8 = r14;
    L23:
        DeepFeedProductEventTracker r9 = this.eventTracker;
        if (r9 == null) goto L31;
        if (r13 != null) goto L27;
        String r11 = "进直播";
    L28:
        DeepFeedProductEventTracker.o(r9, r10, r12, r11, r14, r15, r16);
        return;
    L27:
        r11 = r13;
        goto L28
    L31:
        return;
    L32:
        return;
    L13:
        r5 = null;
        goto L14
    }

    public final boolean enterProductDetail(final InFeedProductV2 r11, String r12, View r13, List<String> r14, final String r15) {
        Intrinsics.checkNotNullParameter(r13, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r14, "productTagsList");
        Integer r0 = findReportCardIndex(r11);
        if (r0 == null) goto L31;
        final int r1 = r0.intValue();
        com.bytedance.android.shopping.deepfeed.action.d r2 = this.actionHelper;
        if (r2 == null) goto L31;
        if (r2.l(r11, r15) != true) goto L31;
        String r3 = null;
        if (r11 == null) goto L20;
        InFeedProductPackData r4 = r11.getPackData();
        if (r4 == null) goto L20;
        InFeedProductPackDataElements r5 = r4.getElements();
        if (r5 == null) goto L20;
        List<p0> r6 = r5.getProducts();
        if (r6 == null) goto L20;
        p0 r7 = (p0) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L20;
        Map<String, Object> r8 = r7.s();
    L21:
        BcmParams r9 = new BcmParams();
        r9.put("bst_group_type", "product");
        int r10 = vd3.a.a;
        if (r8 == null) goto L28;
        String r16 = r8.toString();
        if (r16 == null) goto L28;
        JSONObject r17 = com.bytedance.android.ec.hybrid.list.util.k.c(r16);
        if (r17 == null) goto L28;
        r3 = r17.optString("standard_chain_param");
    L28:
        vd3.a.a(r9, r3);
        final String r18 = le3.b.d(r12, r13, r9);
        this.couponInterrupt.a(r11, new C02631(this, r11, r1, r18, r15));
        onEnterDetail(r11);
        DeepFeedProductEventTracker r19 = this.eventTracker;
        if (r19 == null) goto L33;
        DeepFeedProductEventTracker.o(r19, r1, r11, "滑动", r12, r13, r14);
        return true;
    L33:
        return true;
    L20:
        r8 = null;
    L31:
        return false;
    }

    public final void reportClickSmallImage(InFeedProductV2 r10, String r11, View r12, List<String> r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "clickArea");
        Intrinsics.checkNotNullParameter(r12, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r13, "productTagsList");
        int r3 = requireReportCardIndex(r10);
        DeepFeedProductEventTracker r1 = this.eventTracker;
        if (r1 == null) goto L6;
        DeepFeedProductEventTracker.i(r1, "click_content_small_pic", r3, r10, r11, r14, r12, r13);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void longPress$default(DeepFeedProductViewModel r0, InFeedProductV2 r1, String r2, List r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.longPress(r1, r2, r3);
    }

    public final void clickAddCart(final InFeedProductV2 r18, View r19, final JSONArray r20, final Long r21, String r22, List<String> r23) {
        Intrinsics.checkNotNullParameter(r19, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r23, "productTagsList");
        Integer r0 = findReportCardIndex(r18);
        if (r0 == null) goto L31;
        final int r16 = r0.intValue();
        String r8 = null;
        if (r18 == null) goto L9;
        InFeedProductPackDataElements r1 = com.bytedance.android.shopping.deepfeed.utlis.a.d(r18);
        if (r1 == null) goto L9;
        Map<String, Object> r2 = com.bytedance.android.shopping.deepfeed.utlis.a.l(r1);
    L10:
        BcmParams r3 = new BcmParams();
        r3.put("bst_group_type", "product");
        int r4 = vd3.a.a;
        if (r2 == null) goto L17;
        String r5 = r2.toString();
        if (r5 == null) goto L17;
        JSONObject r6 = com.bytedance.android.ec.hybrid.list.util.k.c(r5);
        if (r6 == null) goto L17;
        String r7 = r6.optString("standard_chain_param");
    L18:
        vd3.a.a(r3, r7);
        final String r9 = le3.b.d(r22, r19, r3);
        this.couponInterrupt.a(r18, new C02581(this, r18, r16, r20, r21, r9));
        int r10 = le3.a.a;
        if (r18 == null) goto L23;
        e1 r11 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r18);
        if (r11 == null) goto L23;
        r8 = r11.b();
    L23:
        JSONObject r12 = le3.a.a(r19, r8);
        DeepFeedProductEventTracker r13 = this.eventTracker;
        if (r13 == null) goto L26;
        int r14 = DeepFeedProductEventTracker.d;
        r13.j(r16, r18, r22, r19, r12, null, null);
    L26:
        DeepFeedProductEventTracker r15 = this.eventTracker;
        if (r15 == null) goto L29;
        DeepFeedProductEventTracker.o(r15, r16, r18, "加购", r22, r19, r23);
    L29:
        ie3.b.a("realtime_click", "cart");
        return;
    L17:
        r7 = null;
    L9:
        r2 = null;
        goto L10
    }

    public final void clickCollect(final InFeedProductV2 r23, final String r24, final View r25, final List<String> r26, Boolean r27, final Function1<? super Boolean, Unit> r28) {
        Intrinsics.checkNotNullParameter(r25, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r26, "productTagsList");
        Integer r0 = findReportCardIndex(r23);
        if (r0 == null) goto L44;
        final int r3 = r0.intValue();
        com.bytedance.android.shopping.deepfeed.action.d r9 = this.actionHelper;
        if (r9 == null) goto L45;
        DeepFeedQueryParam r10 = this.feedParam;
        Function1<Boolean, Unit> r11 = new C02601(this, r28, r3, r23, r24, r25, r26);
        String r1 = null;
        if (r23 == null) goto L15;
        InFeedProductPackData r2 = r23.getPackData();
        if (r2 == null) goto L15;
        InFeedProductPackDataElements r4 = r2.getElements();
        if (r4 == null) goto L15;
        List<p0> r5 = r4.getProducts();
        if (r5 == null) goto L15;
        p0 r6 = (p0) CollectionsKt.firstOrNull(r5);
    L16:
        if (r23 == null) goto L46;
        e1 r7 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r23);
        if (r7 == null) goto L47;
        if (r27 == null) goto L22;
        boolean r8 = r27.booleanValue();
    L28:
        AnchorV3Api.a r12 = AnchorV3Api.a;
        if (r8 == false) goto L31;
        int r16 = 2;
    L32:
        String r13 = r7.a();
        if (r13 != null) goto L35;
        String r19 = "";
    L36:
        if (r10 == null) goto L38;
        r1 = r10.getPageName();
    L38:
        String r20 = r1;
        String r14 = r7.a();
        if (r14 != null) goto L41;
        String r21 = "";
    L42:
        r12.getClass();
        fa3.c.a(bg4.b.b(AnchorV3Api.a.a("", "", "", "", r16, "", 1, r19, r20, r21)).subscribe(new com.bytedance.android.shopping.deepfeed.action.e(r9, r8, r6, r11), com.bytedance.android.shopping.deepfeed.action.f.a), r9);
        return;
    L41:
        r21 = r14;
        goto L42
    L35:
        r19 = r13;
        goto L36
    L31:
        r16 = 1;
        goto L32
    L22:
        if (r6 == null) goto L26;
        i1 r15 = r6.e();
        if (r15 == null) goto L26;
        Boolean r17 = r15.b();
    L27:
        r8 = Intrinsics.areEqual(r17, Boolean.TRUE);
    L26:
        r17 = null;
        goto L27
    L47:
        return;
    L46:
        return;
    L15:
        r6 = null;
        goto L16
    L45:
        return;
    }

    public final void reportClickProduct(InFeedProductV2 r10, String r11, String r12, View r13, List<String> r14, Map<String, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r11, "clickArea");
        Intrinsics.checkNotNullParameter(r13, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r14, "productTagsList");
        Integer r0 = findReportCardIndex(r10);
        if (r0 == null) goto L8;
        int r2 = r0.intValue();
        DeepFeedProductEventTracker r1 = this.eventTracker;
        if (r1 == null) goto L9;
        r1.n(r2, r10, r11, r12, r13, r14, r15);
        return;
    L9:
        return;
    }

    public static /* synthetic */ void enterComment$default(DeepFeedProductViewModel r0, InFeedProductV2 r1, String r2, View r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.enterComment(r1, r2, r3, r4);
    }

    public final void clickBuy(final InFeedProductV2 r17, final JSONArray r18, final Long r19, final String r20, String r21, View r22, List<String> r23) {
        Intrinsics.checkNotNullParameter(r22, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r23, "productTagsList");
        Integer r0 = findReportCardIndex(r17);
        if (r0 == null) goto L46;
        final int r12 = r0.intValue();
        if (r17 == null) goto L15;
        InFeedProductPackData r1 = r17.getPackData();
        if (r1 == null) goto L15;
        InFeedProductPackDataElements r2 = r1.getElements();
        if (r2 == null) goto L15;
        List<p0> r3 = r2.getProducts();
        if (r3 == null) goto L15;
        p0 r4 = (p0) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L15;
        Map<String, Object> r5 = r4.s();
    L16:
        BcmParams r6 = new BcmParams();
        r6.put("bst_group_type", "product");
        int r7 = vd3.a.a;
        if (r5 == null) goto L23;
        String r8 = r5.toString();
        if (r8 == null) goto L23;
        JSONObject r9 = com.bytedance.android.ec.hybrid.list.util.k.c(r8);
        if (r9 == null) goto L23;
        String r10 = r9.optString("standard_chain_param");
    L24:
        vd3.a.a(r6, r10);
        final String r11 = le3.b.d(r21, r22, r6);
        this.couponInterrupt.a(r17, new C02591(this, r17, r12, r18, r19, r20, r11));
        int r13 = le3.a.a;
        if (r17 == null) goto L37;
        InFeedProductPackData r14 = r17.getPackData();
        if (r14 == null) goto L37;
        InFeedProductPackDataElements r15 = r14.getElements();
        if (r15 == null) goto L37;
        List<p0> r16 = r15.getProducts();
        if (r16 == null) goto L37;
        p0 r24 = (p0) CollectionsKt.firstOrNull(r16);
        if (r24 == null) goto L37;
        e1 r25 = r24.b();
        if (r25 == null) goto L37;
        String r110 = r25.b();
    L38:
        JSONObject r26 = le3.a.a(r22, r110);
        DeepFeedProductEventTracker r27 = this.eventTracker;
        if (r27 == null) goto L41;
        int r28 = DeepFeedProductEventTracker.d;
        r27.k(r12, r17, r21, r22, r26, null, null);
    L41:
        DeepFeedProductEventTracker r29 = this.eventTracker;
        if (r29 == null) goto L44;
        DeepFeedProductEventTracker.o(r29, r12, r17, "立即购买", r21, r22, r23);
    L44:
        ie3.b.a("realtime_click", "button");
        return;
    L37:
        r110 = null;
    L23:
        r10 = null;
    L15:
        r5 = null;
        goto L16
    }

    public final void clickProductCard(final InFeedProductV2 r16, String r17, String r18, View r19, List<String> r20, String r21, Map<String, ? extends Object> r22) {
        Intrinsics.checkNotNullParameter(r17, "clickArea");
        Intrinsics.checkNotNullParameter(r19, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r20, "productTagsList");
        Integer r1 = findReportCardIndex(r16);
        if (r1 == null) goto L46;
        final int r13 = r1.intValue();
        com.bytedance.android.shopping.deepfeed.action.d r2 = this.actionHelper;
        if (r2 == null) goto L47;
        int r3 = com.bytedance.android.shopping.deepfeed.action.d.h;
        if (r2.l(r16, null) != true) goto L48;
        if (r18 != null) goto L11;
        String r4 = "";
    L12:
        final String r5 = com.bytedance.android.shopping.deepfeed.utlis.a.c(r16, r4, r19);
        this.couponInterrupt.a(r16, new C02611(this, r16, r13, r5));
        onEnterDetail(r16);
        DeepFeedProductEventTracker r6 = this.eventTracker;
        if (r6 == null) goto L15;
        r6.n(r13, r16, r17, r18, r19, r20, r22);
    L15:
        int r7 = r17.hashCode();
        if (r7 == 864625) goto L33;
        if (r7 == 1135007) goto L28;
        if (r7 == 32237346) goto L23;
    L37:
        int r8 = ie3.b.a;
        if (Intrinsics.areEqual(r17, "头图") == false) goto L40;
    L43:
        String r9 = "image";
    L44:
        ie3.b.a("realtime_click", r9);
        return;
    L40:
        if (Intrinsics.areEqual(r17, "缩略图") == true) goto L43;
        r9 = "card";
        goto L44
    L23:
        if (r17.equals("缩略图") == false) goto L37;
        DeepFeedProductEventTracker r10 = this.eventTracker;
        if (r10 == null) goto L37;
        DeepFeedProductEventTracker.i(r10, "click_content_small_pic", r13, r16, r17, r21, r19, r20);
        goto L37
    L28:
        if (r17.equals("详情") == false) goto L37;
        DeepFeedProductEventTracker r11 = this.eventTracker;
        if (r11 == null) goto L37;
        DeepFeedProductEventTracker.i(r11, "click_content_desc", r13, r16, r17, r21, r19, r20);
        goto L37
    L33:
        if (r17.equals("标题") == false) goto L37;
        DeepFeedProductEventTracker r12 = this.eventTracker;
        if (r12 == null) goto L37;
        DeepFeedProductEventTracker.i(r12, "click_content_title", r13, r16, r17, r21, r19, r20);
        goto L37
    L11:
        r4 = r18;
        goto L12
    L48:
        return;
    L47:
        return;
    }

    public final void reportCardStayTime(InFeedProductV2 r5, int r6, long r7, String r9, boolean r10, String r11, View r12) {
        Intrinsics.checkNotNullParameter(r9, "reportReason");
        DeepFeedProductEventTracker r1 = this.eventTracker;
        if (r1 == null) goto L19;
        Intrinsics.checkNotNullParameter(r9, "reportReason");
        String r0 = null;
        Map<String, Object> r8 = r1.g(r6, r5, null);
        Object r13 = r8.get(PdpOpenThirdParam.KEY_PRODUCT_ID);
        if (r13 == null) goto L7;
        r0 = r13.toString();
    L7:
        if (r0 != null) goto L9;
    L12:
        boolean r14 = true;
    L13:
        if (r14 == false) goto L15;
        return;
    L15:
        if (r7 < 0) goto L21;
        r8.put("duration", String.valueOf(r7));
        r8.put("duration_include_subpage", String.valueOf(r10 ? 1 : 0));
        r8.put("report_reason", r9);
        le3.b.a(r8, r11, r12);
        r1.doEventAction("ecom_deep_feed_card_stay_time", r8);
        return;
    L21:
        return;
    L9:
        if (r0.length() == 0) goto L12;
        r14 = false;
        goto L13
    }

    public final void reportCardVideoProgress(InFeedProductV2 r17, long r18, long r20, boolean r22, String r23, String r24, View r25) {
        String r6 = r23;
        Integer r7 = findReportCardIndex(r17);
        if (r7 == null) goto L95;
        int r8 = r7.intValue();
        String r9 = productIdOf(r17);
        if (r9 != null) goto L7;
        return;
    L7:
        boolean r10 = true;
        if (r22 == true) goto L12;
        if (r6 != null) goto L12;
        boolean r11 = false;
    L14:
        if (this.finishedVideoProgressProducts.contains(r9) == false) goto L16;
        return;
    L16:
        DeepFeedProductEventTracker r12 = this.eventTracker;
        if (r12 == null) goto L92;
        String r13 = f.b(r17);
        Pair[] r14 = new Pair[5];
        r14[0] = TuplesKt.to("inflow_order", Integer.valueOf(r8));
        if (r17 == null) goto L23;
        z0 r15 = r17.getRespExtra();
        if (r15 == null) goto L23;
        Integer r16 = r15.b();
    L24:
        r14[1] = TuplesKt.to("inflow_page_number", r16);
        r14[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r13);
        if (r17 == null) goto L29;
        z0 r19 = r17.getRespExtra();
        if (r19 == null) goto L29;
        String r110 = r19.c();
    L30:
        r14[3] = TuplesKt.to("request_id", r110);
        if (r17 == null) goto L34;
        String r111 = r17.getCardType();
        if (r111 == null) goto L34;
    L37:
        if (r111 != null) goto L41;
        if (r17 == null) goto L40;
        r111 = r17.getCardSubtype();
        goto L41
    L40:
        r111 = null;
    L41:
        r14[4] = TuplesKt.to("card_type", r111);
        Map<String, ? extends Object> r112 = MapsKt.mutableMapOf(r14);
        Intrinsics.checkNotNullParameter(r112, "$this$appendDeepFeedFlags");
        r112.put("is_instant_rec_card", Integer.valueOf(f.c(r17, "is_instant_rec_card")));
        r112.put("is_frame_card", Integer.valueOf(f.c(r17, "is_frame_card")));
        if (r17 == null) goto L46;
        u0 r113 = r17.getCustom();
        if (r113 == null) goto L46;
        String r114 = r113.a();
    L47:
        r112.put("recommend_info", r114);
        if (r17 == null) goto L54;
        List<e2> r1 = com.bytedance.android.shopping.deepfeed.utlis.a.m(r17);
        if (r1 == null) goto L54;
        e2 r2 = (e2) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L54;
        String r3 = r2.e();
    L55:
        r112.put("video_id", r3);
        r112.put("main_pic_type", "video");
        r112.put("is_play_success", "1");
        Object r4 = r112.get(PdpOpenThirdParam.KEY_PRODUCT_ID);
        if (r4 == null) goto L58;
        String r5 = r4.toString();
    L59:
        if (r5 != null) goto L61;
    L64:
        if (r10 == true) goto L92;
        if (r18 < 0) goto L92;
        if (r20 <= 0) goto L92;
        r112.put("play_duration", String.valueOf(r18));
        r112.put("video_duration", String.valueOf(r20));
        r112.put("play_progress", String.valueOf(RangesKt.coerceIn(MathKt.roundToInt((r18 / r20) * 100), 0, 100)));
        r112.put("is_play_finish", String.valueOf(r22 ? 1 : 0));
        if (r6 != null) goto L74;
    L88:
        r6 = null;
    L89:
        if (r6 == null) goto L91;
        r112.put("finish_method", r6);
    L91:
        r112.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        le3.b.a(r112, r24, r25);
        r12.doEventAction("ecom_deep_feed_card_video_progress", r112);
        goto L92
    L74:
        switch(r23.hashCode()) {
            case -1332194002: goto L86;
            case 3127582: goto L83;
            case 109526449: goto L80;
            case 1728911401: goto L77;
            default: goto L88;
        };
    L77:
        if (r6.equals("natural") == false) goto L88;
    L80:
        if (r6.equals(PageScrollStatus.slide) == false) goto L88;
    L83:
        if (r6.equals("exit") == false) goto L88;
    L86:
        if (r6.equals("background") == false) goto L88;
    L61:
        if (r5.length() == 0) goto L64;
        r10 = false;
        goto L64
    L58:
        r5 = null;
    L54:
        r3 = null;
    L46:
        r114 = null;
    L34:
        if (r17 == null) goto L36;
        r111 = r17.getCardName();
        goto L37
    L36:
        r111 = null;
    L29:
        r110 = null;
    L23:
        r16 = null;
    L92:
        if (r11 == false) goto L96;
        this.finishedVideoProgressProducts.add(r9);
        return;
    L96:
        return;
    L12:
        r11 = true;
        goto L14
    }

    public static /* synthetic */ boolean enterProductDetail$default(DeepFeedProductViewModel r6, InFeedProductV2 r7, String r8, View r9, List r10, String r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = null;
    L6:
        return r6.enterProductDetail(r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ void reportClickSmallImage$default(DeepFeedProductViewModel r6, InFeedProductV2 r7, String r8, View r9, List r10, String r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        r6.reportClickSmallImage(r7, r8, r9, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void clickCollect$default(DeepFeedProductViewModel r7, InFeedProductV2 r8, String r9, View r10, List r11, Boolean r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = null;
    L5:
        r7.clickCollect(r8, r9, r10, r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportClickProduct$default(DeepFeedProductViewModel r7, InFeedProductV2 r8, String r9, String r10, View r11, List r12, Map r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = null;
    L5:
        r7.reportClickProduct(r8, r9, r10, r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void clickProductCard$default(DeepFeedProductViewModel r10, InFeedProductV2 r11, String r12, String r13, View r14, List r15, String r16, Map r17, int r18, Object r19) {
        if ((r18 & 32) == 0) goto L5;
        String r8 = null;
    L7:
        if ((r18 & 64) == 0) goto L9;
        Map r9 = null;
    L10:
        r10.clickProductCard(r11, r12, r13, r14, r15, r8, r9);
        return;
    L9:
        r9 = r17;
        goto L10
    L5:
        r8 = r16;
        goto L7
    }

    public static /* synthetic */ void reportCardVideoProgress$default(DeepFeedProductViewModel r12, InFeedProductV2 r13, long r14, long r16, boolean r18, String r19, String r20, View r21, int r22, Object r23) {
        if ((r22 & 32) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r22 & 64) == 0) goto L9;
        View r11 = null;
    L10:
        r12.reportCardVideoProgress(r13, r14, r16, r18, r19, r10, r11);
        return;
    L9:
        r11 = r21;
        goto L10
    L5:
        r10 = r20;
        goto L7
    }
}
