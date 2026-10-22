package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.live.ktv.common.model.api.r0;
import com.bytedance.android.live.ktv.common.model.api.s0;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.yb1;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.t;
import com.bytedance.android.livesdk.ktvimpl.base.sei.v;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KtvSingerViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.KtvDressSyncData;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002¿\u0001\u0018\u0000 É\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Ê\u0001B\u001d\u0012\b\u0010Ã\u0001\u001a\u00030Â\u0001\u0012\b\u0010Å\u0001\u001a\u00030Ä\u0001¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001B\u0015\b\u0016\u0012\b\u0010Å\u0001\u001a\u00030Ä\u0001¢\u0006\u0006\bÆ\u0001\u0010È\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J>\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0002J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J \u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\nH\u0002Jz\u00103\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\n2\b\u0010'\u001a\u0004\u0018\u00010\n2\b\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010)\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0002J\u0010\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u000204H\u0002J\u0010\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207H\u0002J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:H\u0002J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010;\u001a\u000207H\u0002J\u0010\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u000207H\u0002J\b\u0010@\u001a\u00020\u0004H\u0002J\b\u0010A\u001a\u00020\u0004H\u0002J\u0010\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020BH\u0014J\u0010\u0010E\u001a\u00020\u00042\u0006\u0010C\u001a\u00020BH\u0014J\b\u0010F\u001a\u00020\u0004H\u0014J\u0010\u0010I\u001a\u00020\u00042\u0006\u0010H\u001a\u00020GH\u0016J\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010J\u001a\u00020\bH\u0016J\u0012\u0010N\u001a\u0004\u0018\u00010L2\u0006\u0010J\u001a\u00020\bH\u0016J \u0010R\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010Q2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\bH\u0016J&\u0010T\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0Q\u0018\u00010S2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\bH\u0016J \u0010U\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010Q2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010W\u001a\u00020VH\u0016J\u0017\u0010X\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bX\u0010YJ\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0ZJ\u001a\u0010^\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010]\u001a\u0004\u0018\u00010\\H\u0014J\u000e\u0010_\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\nJ\u0006\u0010`\u001a\u00020\u0004J\u0006\u0010a\u001a\u00020\u0004J\u0018\u0010c\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\\2\b\b\u0002\u0010b\u001a\u00020\nJ\b\u0010d\u001a\u00020\u0004H\u0016J\b\u0010e\u001a\u00020\u0004H\u0014J\u0010\u0010f\u001a\u00020\u00042\u0006\u00105\u001a\u000204H\u0016J\u0010\u0010g\u001a\u00020\u00062\u0006\u00105\u001a\u000204H\u0016J\u000e\u0010h\u001a\u00020\u00042\u0006\u0010;\u001a\u000207R\u0019\u0010j\u001a\u0004\u0018\u00010i8\u0006¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\"\u0010n\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010\u001a\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010o\u001a\u0004\bt\u0010q\"\u0004\bu\u0010sR\"\u0010v\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0014\u0010}\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0019\u0010\u007f\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0080\u0001R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0080\u0001R\u0019\u0010\u0083\u0001\u001a\u00020V8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0085\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R&\u0010\u0089\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010w\u001a\u0005\b\u0089\u0001\u0010y\"\u0005\b\u008a\u0001\u0010{R\u0019\u0010\u008b\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0088\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010oR\u0018\u0010\u008e\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010wR\u0018\u0010\u008f\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010wR\u0019\u0010\u0090\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0086\u0001R\u001a\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R+\u0010\u0094\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001b\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0080\u0001R)\u0010\u0098\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0Q0\u0097\u00018\u0006¢\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R&\u0010\u009c\u0001\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010o\u001a\u0005\b\u009d\u0001\u0010q\"\u0005\b\u009e\u0001\u0010sR&\u0010\u009f\u0001\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010o\u001a\u0005\b \u0001\u0010q\"\u0005\b¡\u0001\u0010sR2\u0010£\u0001\u001a\u000b\u0012\u0004\u0012\u00020L\u0018\u00010¢\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R&\u0010©\u0001\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b©\u0001\u0010o\u001a\u0005\bª\u0001\u0010q\"\u0005\b«\u0001\u0010sR1\u0010\u00ad\u0001\u001a\n\u0012\u0005\u0012\u00030¬\u00010\u0097\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u00ad\u0001\u0010\u0099\u0001\u001a\u0006\b®\u0001\u0010\u009b\u0001\"\u0006\b¯\u0001\u0010°\u0001R0\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0097\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b±\u0001\u0010\u0099\u0001\u001a\u0006\b²\u0001\u0010\u009b\u0001\"\u0006\b³\u0001\u0010°\u0001R.\u0010W\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00150Z0\u0097\u00018\u0006¢\u0006\u000e\n\u0005\bW\u0010\u0099\u0001\u001a\u0005\b\u0016\u0010\u009b\u0001R#\u0010´\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0097\u00018\u0006¢\u0006\u0010\n\u0006\b´\u0001\u0010\u0099\u0001\u001a\u0006\bµ\u0001\u0010\u009b\u0001R#\u0010·\u0001\u001a\t\u0012\u0004\u0012\u00020\u001c0¶\u00018\u0006¢\u0006\u0010\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001R\u0017\u0010»\u0001\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0001\u0010\u0086\u0001R\u0017\u0010¼\u0001\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010\u0088\u0001R\u0016\u0010½\u0001\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b½\u0001\u0010oR\u0016\u0010¾\u0001\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b¾\u0001\u0010wR\u0018\u0010À\u0001\u001a\u00030¿\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001¨\u0006Ë\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/stage/KtvMidiStageViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/stage/KtvStageViewModel;", "Ldb0/a;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/c;", "", "fetchMidiConfig", "", "isSinger", "", "id", "", "midiPath", "lyricsPath", "vocalFilePath", "isLrcLyric", "initMidiRes", "Lio/reactivex/disposables/Disposable;", "disposable", "isDisposed", "progress", "seekMidiScoreProgress", "Lcom/bytedance/android/live/ktv/common/midi/k;", "getScoreInfo", "", "calTotalScore", "calSentenceScore", "totalScore", "sentenceScore", "", "index", "calScore", "tone", "isNeedSendMidiSei", "tryHideFeedback", "canReportScore", "from", "clearScore", "avatarThumb", "userId", "secUid", "nickName", LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, "songTitle", "score", "isHighScoreSong", "tips", "hitMidiRecordABTest", "songId", "anchorId", "", "threshold", "sendMidiFeedbackSei", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/w;", "result", "handleMidiSkinSei", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/k;", "ktvSeiModel", "isMidiSkinNotChanged", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/i;", "sei", "onMidiSeiModel", "onKtvSeiModelCompat", "ktvSeiModelCompat", "isMusicStopped", "resetMidiData", "disposeMidiDisposable", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/d;", "ktvCoreDataModel", "onPreparing", "onSinging", "onPaused", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "onCreate", "curPlayTime", "Lio/reactivex/Observable;", "Lcb0/c;", "findMidiSegment", "findMidiSegmentOpt", "startTime", "endTime", "", "findMidiSegmentsNew", "Lio/reactivex/Single;", "findMidiSegments", "findMidiSegmentsOpt", "", "scoreInfo", "tryStartGetScoreInfoTimer", "(Ljava/lang/Long;)V", "Lkotlin/Pair;", "calcToneRange", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "onSingFinish", "resetMidiRecord", "resetCurrentMidiList", "startFeedBackShowTimer", "isFrom", "reportScore", "onDetach", "onCleared", "onSeiResult", "accept", "initAudienceMidi", "Lsb0/b;", "dataEntity", "Lsb0/b;", "getDataEntity", "()Lsb0/b;", "curTotalScore", "I", "getCurTotalScore", "()I", "setCurTotalScore", "(I)V", "getTotalScore", "setTotalScore", "userOpenScore", "Z", "getUserOpenScore", "()Z", "setUserOpenScore", "(Z)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDispose", "Lio/reactivex/disposables/CompositeDisposable;", "midiDisposable", "Lio/reactivex/disposables/Disposable;", "scoreDisposable", "feebackDisposable", "scoreInfoArr", "[D", "curScore", "F", "curMusicId", "J", "isReported", "setReported", "curMidiProgress", "lastMidiScoreGetTime", "lastMidiIndex", "lastMidiHitFlag", "needHideFeedback", "lastTone", "Lcom/bytedance/android/live/ktv/common/midi/b;", "mHitComboCalculator", "Lcom/bytedance/android/live/ktv/common/midi/b;", "currentMidiSkinInfo", "Lkotlin/Pair;", "reportMidiDisposable", "Landroidx/lifecycle/MutableLiveData;", "midiData", "Landroidx/lifecycle/MutableLiveData;", "getMidiData", "()Landroidx/lifecycle/MutableLiveData;", "lastMidiSegmentStartIndex", "getLastMidiSegmentStartIndex", "setLastMidiSegmentStartIndex", "lastMidiSegmentEndIndex", "getLastMidiSegmentEndIndex", "setLastMidiSegmentEndIndex", "", "curMidiSegmentList", "Ljava/util/List;", "getCurMidiSegmentList", "()Ljava/util/List;", "setCurMidiSegmentList", "(Ljava/util/List;)V", "curMidiSegmentIndex", "getCurMidiSegmentIndex", "setCurMidiSegmentIndex", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "midiConfig", "getMidiConfig", "setMidiConfig", "(Landroidx/lifecycle/MutableLiveData;)V", "showNoMidiHint", "getShowNoMidiHint", "setShowNoMidiHint", "hideFeedback", "getHideFeedback", "", "midiDownloadingTask", "Ljava/util/Set;", "getMidiDownloadingTask", "()Ljava/util/Set;", "calFactorSetting", "scoreTimeSetting", "scoreRangeSetting", "currentIsAnchor", "com/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/stage/KtvMidiStageViewModel$n", "midiDownloadCallback", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/stage/KtvMidiStageViewModel$n;", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "ktvContext", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;", "vm", "<init>", "(Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;)V", "(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;)V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMidiStageViewModel extends KtvStageViewModel implements db0.a, com.bytedance.android.livesdk.ktvimpl.base.sei.c {
    public static final a Companion = null;
    public static final float DEFAULT_SCORE_REPORT_PERCENT = 0.3f;
    public static final String FLAG_ON_DETACH = "onDetach";
    public static final String FLAG_ON_SING_FINISH = "onSingFinish";
    public static final String FLAG_REPORT_SCORE = "reportScore";
    public static final String TAG = "KtvMidiStageViewModel";
    private final float calFactorSetting;
    private final CompositeDisposable compositeDispose;
    private long curMidiProgress;
    private int curMidiSegmentIndex;
    private List<cb0.c> curMidiSegmentList;
    private long curMusicId;
    private float curScore;
    private int curTotalScore;
    private final boolean currentIsAnchor;
    private Pair<Long, String> currentMidiSkinInfo;
    private final sb0.b dataEntity;
    private Disposable feebackDisposable;
    private final MutableLiveData<Boolean> hideFeedback;
    private boolean isReported;
    private boolean lastMidiHitFlag;
    private int lastMidiIndex;
    private long lastMidiScoreGetTime;
    private int lastMidiSegmentEndIndex;
    private int lastMidiSegmentStartIndex;
    private float lastTone;
    private com.bytedance.android.live.ktv.common.midi.b mHitComboCalculator;
    private MutableLiveData<g0> midiConfig;
    private final MutableLiveData<List<cb0.c>> midiData;
    private Disposable midiDisposable;
    private final n midiDownloadCallback;
    private final Set<Integer> midiDownloadingTask;
    private boolean needHideFeedback;
    private Disposable reportMidiDisposable;
    private Disposable scoreDisposable;
    private final MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> scoreInfo;
    private double[] scoreInfoArr;
    private final int scoreRangeSetting;
    private final long scoreTimeSetting;
    private MutableLiveData<Boolean> showNoMidiHint;
    private int totalScore;
    private boolean userOpenScore;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvMidiStageViewModel a;

        public b(KtvMidiStageViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MutableLiveData<g0> r0 = this.a.getMidiConfig();
            com.bytedance.android.live.ktv.common.model.api.g r3 = (com.bytedance.android.live.ktv.common.model.api.g) ((BaseResponse) ((Response) r2)).data;
            if (r3 == null) goto L5;
            g0 r4 = r3.a();
        L6:
            r0.setValue(r4);
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public c(KtvMidiStageViewModel r1) {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            ALogger.i(bb0.b.b(), "fetchMidiConfig fail, invoke class :KtvMidiStageViewModel");
        }
    }

    public static final class d<T> implements Predicate {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final boolean test(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return !r3.isEmpty();
        }
    }

    public static final class e<T, R> implements Function {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return Observable.fromIterable(r3);
        }
    }

    public static final class f<T> implements Predicate {
        public final /* synthetic */ long a;

        public f(long r1) {
            this.a = r1;
        }

        public final boolean test(Object r6) {
            cb0.c r7 = (cb0.c) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            cb0.a r8 = r7.a;
            long r0 = r8.a;
            long r2 = this.a;
            if (r0 < r2) goto L5;
        L7:
            return false;
        L5:
            if (r8.b < r2) goto L7;
            return true;
        }
    }

    public static final class g<T> implements Predicate {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final boolean test(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return !r3.isEmpty();
        }
    }

    public static final class h<T, R> implements Function {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final Object apply(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return Observable.fromIterable(r3);
        }
    }

    public static final class i<T> implements Predicate {
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;

        public i(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }

        public final boolean test(Object r6) {
            cb0.c r7 = (cb0.c) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            cb0.a r8 = r7.a;
            if (r8.a < this.a) goto L5;
        L7:
            return false;
        L5:
            if (r8.b <= this.b) goto L7;
            return true;
        }
    }

    public static final class j<T> implements SingleOnSubscribe {
        public final /* synthetic */ KtvMidiStageViewModel a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public j(KtvMidiStageViewModel r1, boolean r2, String r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void subscribe(SingleEmitter<Integer> r5) {
            Intrinsics.checkNotNullParameter(r5, "it");
            if (this.b == true) goto L5;
        L10:
            Integer r0 = 0;
        L12:
            if (r5.isDisposed() == false) goto L14;
            return;
        L14:
            if (r0 != null) goto L17;
        L18:
            r5.onError(new Exception("init midi error"));
            return;
        L17:
            if (r0.intValue() != 0) goto L18;
            r5.onSuccess(r0);
            return;
        L5:
            if (this.c == null) goto L10;
            com.bytedance.android.livesdk.ktvimpl.base.i r1 = (com.bytedance.android.livesdk.ktvimpl.base.i) this.a.getKtvContext().getKtvCoreController().getValue();
            if (r1 == null) goto L9;
            String r2 = this.d;
            String r3 = this.c;
            Intrinsics.checkNotNullParameter(r2, "midiFilePath");
            Intrinsics.checkNotNullParameter(r3, "lyricFilesPath");
            r1.d();
        L9:
            r0 = null;
            goto L12
        }
    }

    public static final class k<T, R> implements Function {
        public final /* synthetic */ KtvMidiStageViewModel a;
        public final /* synthetic */ boolean b;

        public k(KtvMidiStageViewModel r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Integer) r2, "it");
            if (vm2.h.d() == true) goto L5;
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r3 = ILiveWrappedLivePusher.a.b();
            if (r3 == null) goto L21;
            r3.getLiveCoreKaraokFilter();
            return null;
        L21:
            return null;
        L5:
            if (this.b == false) goto L9;
            com.bytedance.android.livesdk.ktvimpl.base.i r4 = (com.bytedance.android.livesdk.ktvimpl.base.i) this.a.getKtvContext().getKtvCoreController().getValue();
            if (r4 == null) goto L17;
            r4.d();
            return null;
        L17:
            return null;
        L9:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r5 = ILiveWrappedLivePusher.a.b();
            if (r5 == null) goto L19;
            r5.getLiveCoreKaraokFilter();
            return null;
        L19:
            return null;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ KtvMidiStageViewModel a;

        public l(KtvMidiStageViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ALogger.i(bb0.b.b(), "initMidiRes success, invoke class :KtvMidiStageViewModel");
            MutableLiveData<List<cb0.c>> r0 = this.a.getMidiData();
            r0.setValue((List) r3);
            this.a.getShowNoMidiHint().setValue(Boolean.FALSE);
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ KtvMidiStageViewModel a;
        public final /* synthetic */ long b;

        public m(KtvMidiStageViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            ALogger.i(bb0.b.b(), "initMidiRes fail, invoke class :KtvMidiStageViewModel");
            ((Throwable) r3).printStackTrace();
            pd2.d.n.F(this.b);
            this.a.getShowNoMidiHint().setValue(Boolean.TRUE);
        }
    }

    public static final class n implements com.bytedance.android.live.ktv.common.music.download.k.b {
        public final /* synthetic */ KtvMidiStageViewModel a;

        public n(KtvMidiStageViewModel r1) {
            this.a = r1;
        }

        public final void onFailed(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "errorMsg");
            if (r3 == (-1)) goto L5;
            this.a.getMidiDownloadingTask().remove(Integer.valueOf(r3));
        L5:
            ALogger.i(bb0.b.b(), "midiDownloadCallback onFailed, invoke class :".concat(n.class.getSimpleName()));
        }

        public final void a(long r11, String r13, int r14) {
            Intrinsics.checkNotNullParameter(r13, "midiSavePath");
            if (r14 == (-1)) goto L5;
            this.a.getMidiDownloadingTask().remove(Integer.valueOf(r14));
        L5:
            ALogger.i(bb0.b.b(), "midiDownloadCallback onSuccess, invoke class :".concat(n.class.getSimpleName()));
            if (KtvMidiStageViewModel.access$getCurMusicId$p(this.a) != r11) goto L9;
            KtvMidiStageViewModel.initMidiRes$default(this.a, false, r11, r13, null, null, false, 32, null);
            return;
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ KtvMidiStageViewModel a;
        public final /* synthetic */ MusicPanel b;
        public final /* synthetic */ float c;

        public o(KtvMidiStageViewModel r1, MusicPanel r2, float r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r28) {
            com.bytedance.android.live.network.response.e r1 = (com.bytedance.android.live.network.response.e) r28;
            int r2 = mb0.f.a;
            MusicPanel r3 = this.b;
            Boolean r4 = ((r0) ((ExtraResponse) r1).data).d();
            Boolean r5 = Boolean.TRUE;
            mb0.f.n(r3, Intrinsics.areEqual(r4, r5), Intrinsics.areEqual(((r0) ((ExtraResponse) r1).data).h(), r5), ((r0) ((ExtraResponse) r1).data).f(), this.c);
            pd2.d r6 = pd2.d.n;
            r6.getClass();
            pd2.d.I(this.b, "Ktv reportScore: api back success.  result: " + r1);
            ALogger.i(bb0.b.b(), "KtvMidiStageViewModel :reportScore: api back success, invoke class :KtvMidiStageViewModel");
            ALogger.i("webcast_start_ktv_selected_order_tab", "reportScore: api back success:" + ((r0) ((ExtraResponse) r1).data).d());
            boolean r7 = true;
            if ((!Intrinsics.areEqual(((r0) ((ExtraResponse) r1).data).d(), r5)) == true) goto L50;
            Long r8 = ((r0) ((ExtraResponse) r1).data).f();
            s0 r9 = ((r0) ((ExtraResponse) r1).data).g();
            ALogger.i("midi-check", "reportScore: api back success:" + r8 + "---" + r9);
            if (r8 == null) goto L48;
            if (r9 == null) goto L49;
            boolean r10 = Intrinsics.areEqual(((r0) ((ExtraResponse) r1).data).h(), r5);
            r0 r11 = (r0) ((ExtraResponse) r1).data;
            if (r10 == false) goto L11;
            String r12 = r11.b();
        L13:
            if (r12 != null) goto L15;
            r12 = "";
        L15:
            OrderInfo r13 = this.b.a.getOrderInfo();
            if (r13 == null) goto L22;
            InteractiveSongUserInfo r14 = r13.getTopUser();
            if (r14 == null) goto L22;
            if (r14.getHitMidiRecordABTest() != 1) goto L22;
        L23:
            com.bytedance.android.livesdk.chatroom.o r15 = com.bytedance.android.live.liveinteract.api.utils.m.i();
            if (r15 == null) goto L33;
            com.bytedance.live.datacontext.m r16 = r15.getRoom();
            if (r16 == null) goto L33;
            IRoom r17 = (IRoom) r16.getValue();
            if (r17 == null) goto L33;
            String r18 = r17.getOwnerUserIdString();
            if (r18 == null) goto L33;
            String r25 = r18;
        L34:
            py.k r19 = r9.a();
            if (r19 == null) goto L37;
            String r110 = r19.getUri();
        L38:
            this.a.getKtvContext().updateSingEndedFeedback(new com.bytedance.android.livesdk.ktvimpl.base.sei.h(r110, Long.valueOf(t.h(r9.d())), r9.c(), r9.b(), r8.longValue(), this.b.a.getMTitle(), this.c, r10, r12, r7, Long.valueOf(this.b.a.getMId()), t.h(r25), 0.0d, 12288));
            KtvMidiStageViewModel r20 = this.a;
            py.k r21 = r9.a();
            if (r21 == null) goto L41;
            String r22 = r21.getUri();
        L42:
            String r23 = r9.d();
            String r111 = r9.c();
            String r112 = r9.b();
            long r113 = r8.longValue();
            String r114 = this.b.a.getMTitle();
            float r115 = this.c;
            long r116 = this.b.a.getMId();
            Double r24 = ((r0) ((ExtraResponse) r1).data).c();
            if (r24 == null) goto L45;
            double r26 = r24.doubleValue();
        L46:
            KtvMidiStageViewModel.access$sendMidiFeedbackSei(r20, r22, r23, r111, r112, r113, r114, r115, r10, r12, r7, r116, r25, r26);
            return;
        L45:
            r26 = 0.0d;
            goto L46
        L41:
            r22 = null;
            goto L42
        L37:
            r110 = null;
        L33:
            r25 = "";
        L22:
            r7 = false;
            goto L23
        L11:
            r12 = r11.e();
            goto L13
        L49:
            return;
        L48:
            return;
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ MusicPanel a;
        public final /* synthetic */ float b;

        public p(KtvMidiStageViewModel r1, MusicPanel r2, float r3) {
            this.a = r2;
            this.b = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            int r0 = mb0.f.a;
            mb0.f.m(this.a, this.b, r7);
            pd2.d r1 = pd2.d.n;
            MusicPanel r2 = this.a;
            String r3 = "Ktv reportScore: api back error, message: " + r7.getMessage();
            r1.getClass();
            pd2.d.I(r2, r3);
            String r4 = "reportScore: api back error, message: " + r7.getMessage();
            ALogger.i(bb0.b.b(), "KtvMidiStageViewModel :" + r4 + ", invoke class :KtvMidiStageViewModel");
            StringBuilder r5 = new StringBuilder("reportScore: api back error, message: ");
            r5.append(r7.getMessage());
            ALogger.i("midi-check", r5.toString());
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ KtvMidiStageViewModel a;

        public q(KtvMidiStageViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            BaseCoreViewModel r4 = this.a.getCoreViewModel();
            if (r4 == null) goto L5;
            KtvRoomLyricsStateMachineConfig.d r5 = r4.getCurState();
        L7:
            if ((r5 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L9;
            this.a.getHideFeedback().setValue(Boolean.TRUE);
            return;
        L9:
            KtvMidiStageViewModel.access$setNeedHideFeedback$p(this.a, true);
            return;
        L5:
            r5 = null;
            goto L7
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ KtvMidiStageViewModel a;

        public r(KtvMidiStageViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            this.a.m420getScoreInfo().setValue(new Pair(Long.valueOf(KtvMidiStageViewModel.access$getCurMidiProgress$p(this.a)), KtvMidiStageViewModel.access$getScoreInfo(this.a)));
            KtvMidiStageViewModel r7 = this.a;
            KtvMidiStageViewModel.access$setCurMidiProgress$p(r7, KtvMidiStageViewModel.access$getCurMidiProgress$p(r7) + KtvMidiStageViewModel.access$getScoreTimeSetting$p(this.a));
        }
    }

    static {
        Companion = new a();
    }

    public void getScoreInfo(double[] r2) {
        Intrinsics.checkNotNullParameter(r2, "scoreInfo");
    }

    public final void resetCurrentMidiList() {
        this.lastMidiSegmentStartIndex = -1;
        this.lastMidiSegmentEndIndex = -1;
        this.curMidiSegmentList = null;
    }

    private final void disposeMidiDisposable() {
        Disposable r0 = this.midiDisposable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
    L7:
        this.midiDisposable = null;
    }

    private final void fetchMidiConfig() {
        sb0.b r0 = this.dataEntity;
        if (r0 == null) goto L7;
        sb0.e r1 = r0.b();
        if (r1 == null) goto L7;
        long r2 = r1.getRoomId();
    L8:
        Disposable r3 = ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getMidiConfig(r2).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), new c(this));
        if (r3 == null) goto L12;
        RxUtilKt.c(r3, this.compositeDispose);
        return;
    L12:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    private final com.bytedance.android.live.ktv.common.midi.k getScoreInfo() {
        com.bytedance.android.livesdk.ktvimpl.base.i r1 = (com.bytedance.android.livesdk.ktvimpl.base.i) getKtvContext().getKtvCoreController().getValue();
        if (r1 == null) goto L5;
        r1.g(this.scoreInfoArr);
    L5:
        double[] r2 = this.scoreInfoArr;
        float r3 = (float) r2[3];
        float r4 = (float) r2[7];
        int r5 = (int) r2[11];
        float r6 = calSentenceScore() * this.calFactorSetting;
        if (r6 <= 100.0f) goto L8;
        r6 = 100.0f;
    L8:
        boolean r7 = ((Boolean) KtvSettingHelper.J0.getValue()).booleanValue();
        if (r7 == false) goto L11;
        r3 = r4;
        r6 = 90.0f;
    L11:
        this.curScore = calScore(calTotalScore(), r6, r5);
        setTotalScore((int) calTotalScore());
        if (canReportScore() == false) goto L18;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r8 = KtvRoomContext.a.a();
        if (r8 == null) goto L18;
        com.bytedance.live.datacontext.n<Float> r9 = r8.getReportMidiScore();
        if (r9 == null) goto L18;
        r9.setValue(Float.valueOf(this.curScore));
    L18:
        sb0.b r10 = this.dataEntity;
        if (r10 == null) goto L24;
        sb0.e r11 = r10.b();
        if (r11 == null) goto L24;
        String r12 = r11.a();
        if (r12 == null) goto L24;
    L25:
        String r13 = r12;
        if (r5 > this.lastMidiIndex) goto L32;
        if (r5 == 0) goto L29;
    L31:
        boolean r14 = false;
    L33:
        Map r15 = null;
        if (r14 == false) goto L36;
        com.bytedance.android.live.ktv.common.midi.b r16 = this.mHitComboCalculator;
        int r17 = com.bytedance.android.live.ktv.common.midi.b.e;
        int r18 = r16.b(r6, r5, null);
    L37:
        int r19 = -1;
        if (r14 == false) goto L69;
        if (KtvSettingHelper.z() == false) goto L42;
        int r20 = KtvSettingHelper.l();
    L43:
        g0 r21 = (g0) this.midiConfig.getValue();
        if (r21 == null) goto L46;
        Map r22 = r21.b();
    L47:
        int r23 = com.bytedance.android.live.ktv.common.util.p.a(r22, r6);
        if (r23 != 1) goto L50;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a.b++;
        goto L69
    L50:
        if (r23 == 2) goto L66;
        if (r23 != 3) goto L69;
        if (r18 != 1) goto L55;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.b(1);
        goto L69
    L55:
        if (2 > r18) goto L61;
        if (r20 <= r18) goto L61;
        if (r18 != 2) goto L60;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.b(-1);
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a();
    L60:
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a();
    L61:
        if (r20 > r18) goto L69;
        if (Integer.MAX_VALUE < r18) goto L69;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a.d++;
        goto L69
    L66:
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a.c++;
        goto L69
    L46:
        r22 = null;
        goto L47
    L42:
        r20 = vm2.h.x();
    L69:
        if (isNeedSendMidiSei(Math.abs(r3 - r4), r5) == true) goto L75;
        if (r7 == true) goto L72;
    L74:
        r18 = r18;
    L95:
        float r110 = this.curScore;
        if (r5 < 0) goto L103;
        if (r14 == false) goto L103;
        g0 r24 = (g0) this.midiConfig.getValue();
        if (r24 == null) goto L101;
        r15 = r24.b();
    L101:
        r19 = com.bytedance.android.live.ktv.common.util.p.a(r15, r6);
    L103:
        return new com.bytedance.android.live.ktv.common.midi.k(r3, r4, r6, r110, r5, Integer.valueOf(r19), r18, false, DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE);
    L72:
        if (r3 == this.lastTone) goto L74;
    L75:
        KtvContext r25 = getKtvContext();
        if (r25 == null) goto L80;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r26 = r25.getKtvSingerViewModel();
        if (r26 == null) goto L80;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r27 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r26.getValue();
    L81:
        KtvSingerViewModel r28 = (KtvSingerViewModel) r27;
        if (r28 == null) goto L94;
        float r29 = this.curScore;
        if (r5 < 0) goto L91;
        if (r14 == false) goto L91;
        g0 r30 = (g0) this.midiConfig.getValue();
        if (r30 == null) goto L89;
        Map r31 = r30.b();
    L90:
        int r111 = com.bytedance.android.live.ktv.common.util.p.a(r31, r6);
    L92:
        r28.sendMidiSei(r3, r4, r29, r5, r111, r13, r18);
        goto L94
    L89:
        r31 = null;
    L91:
        r111 = -1;
    L94:
        this.lastTone = r3;
    L80:
        r27 = null;
        goto L81
    L36:
        r18 = 0;
        goto L37
    L29:
        if (r6 <= 0) goto L31;
    L32:
        r14 = true;
    L24:
        r12 = "";
        goto L25
    }

    private final void tryHideFeedback() {
        if (this.needHideFeedback == false) goto L6;
        ALogger.i(bb0.b.b(), "tryHideFeedback, invoke class :KtvMidiStageViewModel");
        this.hideFeedback.setValue(Boolean.TRUE);
        this.needHideFeedback = false;
        return;
    }

    public final Pair<Integer, Integer> calcToneRange() {
        List r0 = (List) this.midiData.getValue();
        int r1 = 0;
        int r2 = 100;
        if (r0 == null) goto L9;
        Iterator r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L9;
        cb0.c r4 = (cb0.c) r3.next();
        r2 = Math.min(r2, r4.b);
        r1 = Math.max(r1, r4.b);
    L9:
        return TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r1));
    }

    public final void startFeedBackShowTimer() {
        Disposable r0 = this.feebackDisposable;
        if (r0 != null) goto L5;
    L6:
        ALogger.i(bb0.b.b(), "startFeedBackShowTimer, invoke class :KtvMidiStageViewModel");
        this.feebackDisposable = Observable.timer(vm2.d.Y(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(this));
        return;
    L5:
        if (r0.isDisposed() == true) goto L6;
    }

    private final float calSentenceScore() {
        Double r0 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 0);
        if (r0 == null) goto L5;
        float r1 = (float) r0.doubleValue();
    L6:
        Double r2 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 1);
        float r3 = 0.1f;
        if (r2 == null) goto L9;
        float r4 = (float) r2.doubleValue();
    L10:
        Double r5 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 2);
        if (r5 == null) goto L13;
        r3 = (float) r5.doubleValue();
    L13:
        double[] r6 = this.scoreInfoArr;
        return ((((float) r6[0]) * r1) + (((float) r6[13]) * r4)) + (((float) r6[15]) * r3);
    L9:
        r4 = 0.1f;
        goto L10
    L5:
        r1 = 0.8f;
        goto L6
    }

    private final float calTotalScore() {
        Double r0 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 0);
        if (r0 == null) goto L5;
        float r1 = (float) r0.doubleValue();
    L6:
        Double r2 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 1);
        float r3 = 0.1f;
        if (r2 == null) goto L9;
        float r4 = (float) r2.doubleValue();
    L10:
        Double r5 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 2);
        if (r5 == null) goto L13;
        r3 = (float) r5.doubleValue();
    L13:
        double[] r6 = this.scoreInfoArr;
        return ((((float) r6[1]) * r1) + (((float) r6[14]) * r4)) + (((float) r6[16]) * r3);
    L9:
        r4 = 0.1f;
        goto L10
    L5:
        r1 = 0.8f;
        goto L6
    }

    private final boolean canReportScore() {
        NextLiveData<ub0.a> r0 = getKtvContext().getLyricsChangeLiveData();
        if (r0 == null) goto L9;
        ub0.a r1 = (ub0.a) r0.getValue();
        if (r1 == null) goto L9;
        List r2 = r1.a();
        if (r2 == null) goto L9;
        int r3 = r2.size();
    L10:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r4 = KtvRoomContext.a.a();
        Integer r5 = null;
        if (r4 == null) goto L15;
        com.bytedance.live.datacontext.m<Integer> r6 = r4.getMidiSingLyricsLineCount();
        if (r6 == null) goto L15;
        Integer r7 = (Integer) r6.getValue();
    L16:
        g0 r8 = (g0) this.midiConfig.getValue();
        if (r8 == null) goto L19;
        Integer r9 = r8.a();
    L20:
        if (r9 == null) goto L25;
        g0 r10 = (g0) this.midiConfig.getValue();
        if (r10 == null) goto L24;
        r5 = r10.a();
    L24:
        Intrinsics.checkNotNull(r5);
        float r11 = r5.intValue() / 100.0f;
    L26:
        if (r7 != null) goto L28;
        return false;
    L28:
        if (r7.intValue() < (r3 * r11)) goto L32;
        return true;
    L32:
        return false;
    L25:
        r11 = 0.3f;
        goto L26
    L19:
        r9 = null;
    L15:
        r7 = null;
    L9:
        r3 = 0;
        goto L10
    }

    private final void resetMidiData() {
        disposeMidiDisposable();
        this.midiData.setValue(null);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvStageViewModel
    public void onCleared() {
        super.onCleared();
        onDetach();
        ALogger.i(bb0.b.b(), "reportScore: onCleared, compositeDispose.dispose(), invoke class :KtvMidiStageViewModel");
        this.compositeDispose.dispose();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvStageViewModel
    public void onDetach() {
        super.onDetach();
        Disposable r0 = this.reportMidiDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.scoreDisposable;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        Disposable r2 = this.feebackDisposable;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        Disposable r3 = this.midiDisposable;
        if (r3 == null) goto L14;
        r3.dispose();
    L14:
        this.curMusicId = 0;
        resetMidiRecord("onDetach");
        this.curMidiProgress = 0;
        this.lastMidiScoreGetTime = 0;
        this.lastMidiIndex = -1;
        this.mHitComboCalculator.a();
        this.lastMidiHitFlag = false;
        this.needHideFeedback = false;
        this.midiData.setValue(null);
        resetCurrentMidiList();
        KtvContext r4 = getKtvContext();
        if (r4 == null) goto L22;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.ktvimpl.base.sei.m> r5 = r4.getSeiProcessor();
        if (r5 == null) goto L22;
        com.bytedance.android.livesdk.ktvimpl.base.sei.m r6 = (com.bytedance.android.livesdk.ktvimpl.base.sei.m) r5.getValue();
        if (r6 == null) goto L22;
        r6.g(this);
    L22:
        if (yb1.a() == false) goto L30;
        Iterator<T> r7 = this.midiDownloadingTask.iterator();
    L25:
        if (r7.hasNext() == false) goto L27;
        int r8 = ((Number) r7.next()).intValue();
        com.bytedance.android.live.ktv.common.music.download.k.a.getClass();
        Downloader.getInstance(s1.getContext()).cancel(r8);
        goto L25
    L27:
        this.midiDownloadingTask.clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvStageViewModel
    public void onPaused() {
        super.onPaused();
        Disposable r0 = this.scoreDisposable;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final int getCurMidiSegmentIndex() {
        return this.curMidiSegmentIndex;
    }

    public final List<cb0.c> getCurMidiSegmentList() {
        return this.curMidiSegmentList;
    }

    public int getCurTotalScore() {
        return this.curTotalScore;
    }

    public final sb0.b getDataEntity() {
        return this.dataEntity;
    }

    public final MutableLiveData<Boolean> getHideFeedback() {
        return this.hideFeedback;
    }

    public final int getLastMidiSegmentEndIndex() {
        return this.lastMidiSegmentEndIndex;
    }

    public final int getLastMidiSegmentStartIndex() {
        return this.lastMidiSegmentStartIndex;
    }

    public final MutableLiveData<g0> getMidiConfig() {
        return this.midiConfig;
    }

    public final MutableLiveData<List<cb0.c>> getMidiData() {
        return this.midiData;
    }

    public final Set<Integer> getMidiDownloadingTask() {
        return this.midiDownloadingTask;
    }

    public final MutableLiveData<Boolean> getShowNoMidiHint() {
        return this.showNoMidiHint;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public boolean getUserOpenScore() {
        return this.userOpenScore;
    }

    public final boolean isReported() {
        return this.isReported;
    }

    /* JADX INFO: renamed from: getScoreInfo, reason: collision with other method in class */
    public final MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> m420getScoreInfo() {
        return this.scoreInfo;
    }

    public KtvMidiStageViewModel(KtvRoomViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        KtvContext.Companion.getClass();
        this(KtvContext.a.g(), r2);
    }

    public static final /* synthetic */ long access$getCurMidiProgress$p(KtvMidiStageViewModel r2) {
        return r2.curMidiProgress;
    }

    public static final /* synthetic */ long access$getCurMusicId$p(KtvMidiStageViewModel r2) {
        return r2.curMusicId;
    }

    public static final /* synthetic */ boolean access$getNeedHideFeedback$p(KtvMidiStageViewModel r0) {
        return r0.needHideFeedback;
    }

    public static final /* synthetic */ com.bytedance.android.live.ktv.common.midi.k access$getScoreInfo(KtvMidiStageViewModel r0) {
        return r0.getScoreInfo();
    }

    public static final /* synthetic */ long access$getScoreTimeSetting$p(KtvMidiStageViewModel r2) {
        return r2.scoreTimeSetting;
    }

    private final void clearScore(String r6) {
        Integer r2 = null;
        if (this.currentIsAnchor == true) goto L5;
    L21:
        this.curScore = 0.0f;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r7 = KtvRoomContext.a.a();
        if (r7 == null) goto L26;
        com.bytedance.live.datacontext.m<Integer> r8 = r7.getMidiSingLyricsLineCount();
        if (r8 == null) goto L26;
        r8.setValue(0);
    L26:
        StringBuilder r9 = new StringBuilder("Ktv clearScore, real lyric count: ");
        KtvRoomContext r0 = KtvRoomContext.a.a();
        if (r0 == null) goto L31;
        com.bytedance.live.datacontext.m<Integer> r1 = r0.getMidiSingLyricsLineCount();
        if (r1 == null) goto L31;
        r2 = (Integer) r1.getValue();
    L31:
        r9.append(r2);
        r9.append(' ');
        String r10 = r9.toString();
        ALogger.i(bb0.b.b(), r10 + ", invoke class :KtvMidiStageViewModel");
        return;
    L5:
        if (this.isReported == true) goto L21;
        if (this.curScore == 0.0f) goto L21;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r3 = KtvRoomContext.a.a();
        if (r3 == null) goto L14;
        com.bytedance.live.datacontext.m<Integer> r4 = r3.getMidiSingLyricsLineCount();
        if (r4 == null) goto L14;
        if (((Number) r4.getValue()).intValue() == 0) goto L21;
    L14:
        pd2.d r5 = pd2.d.n;
        StringBuilder r11 = new StringBuilder("Ktv clearScore, is from: ");
        r11.append(r6);
        r11.append("; curScore: ");
        r11.append(this.curScore);
        r11.append(", real lyric count: ");
        KtvRoomContext r12 = KtvRoomContext.a.a();
        if (r12 == null) goto L19;
        com.bytedance.live.datacontext.m<Integer> r13 = r12.getMidiSingLyricsLineCount();
        if (r13 == null) goto L19;
        Integer r14 = (Integer) r13.getValue();
    L20:
        r11.append(r14);
        String r15 = r11.toString();
        r5.getClass();
        pd2.d.I(null, r15);
    L19:
        r14 = null;
        goto L20
    }

    private final void handleMidiSkinSei(w r8) {
        if ((r8.b instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L5;
        return;
    L5:
        if (getKtvContext().isCurrentUserIsSinger() == false) goto L7;
        return;
    L7:
        KtvRoomViewModel r0 = getVm();
        MidiSkinDressInfo r1 = null;
        if (r0 == null) goto L10;
        KtvDressSyncData r2 = r0.getKtvMidiSkinDress();
    L11:
        String r3 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r8.b).r();
        if (r2 == null) goto L16;
        MidiSkinDressInfo r4 = r2.getDressInfo();
        if (r4 == null) goto L16;
        String r5 = r4.getDressId();
    L18:
        if (Intrinsics.areEqual(r3, r5) == false) goto L65;
        long r6 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r8.b).j();
        if (r2 == null) goto L22;
        Long r7 = r2.getSongId();
    L23:
        if (r7 == null) goto L65;
        if (r6 != r7.longValue()) goto L65;
        String r9 = r8.b.a();
        if (r2 == null) goto L30;
        String r10 = r2.getSingerIdString();
    L32:
        if (Intrinsics.areEqual(r9, r10) == false) goto L65;
        MidiSkinDressInfo r11 = (MidiSkinDressInfo) getKtvContext().getMidiSkinContext().getValue();
        if (r11 == null) goto L36;
        String r12 = r11.getDressId();
    L37:
        if (r2 == null) goto L41;
        MidiSkinDressInfo r13 = r2.getDressInfo();
        if (r13 == null) goto L41;
        String r14 = r13.getDressId();
    L43:
        if ((!Intrinsics.areEqual(r12, r14)) == true) goto L54;
        Pair<Long, String> r15 = this.currentMidiSkinInfo;
        if (r15 == null) goto L47;
        Long r16 = (Long) r15.getFirst();
    L48:
        long r17 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r8.b).j();
        if (r16 == null) goto L54;
        if (r16.longValue() == r17) goto L65;
    L47:
        r16 = null;
    L54:
        if (r2 == null) goto L56;
        Long r18 = r2.getSongId();
    L57:
        if (r2 == null) goto L59;
        String r19 = r2.getSingerIdString();
    L60:
        this.currentMidiSkinInfo = new Pair(r18, r19);
        com.bytedance.live.datacontext.n<MidiSkinDressInfo> r20 = getKtvContext().getMidiSkinContext();
        if (r2 == null) goto L63;
        r1 = r2.getDressInfo();
    L63:
        r20.setValue(r1);
        return;
    L59:
        r19 = null;
        goto L60
    L56:
        r18 = null;
    L41:
        r14 = null;
        goto L43
    L36:
        r12 = null;
        goto L37
    L30:
        r10 = null;
        goto L32
    L22:
        r7 = null;
    L65:
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r8.b).r(), BDLocationException.ERROR_TIMEOUT) == true) goto L69;
        if (((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r8.b).r() == null) goto L69;
        return;
    L69:
        if (getKtvContext().getMidiSkinContext().getValue() != null) goto L71;
        return;
    L71:
        if (isMidiSkinNotChanged((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r8.b) == true) goto L78;
        getKtvContext().getMidiSkinContext().setValue(null);
        return;
    L78:
        return;
    L16:
        r5 = null;
        goto L18
    L10:
        r2 = null;
        goto L11
    }

    private final boolean isDisposed(Disposable r1) {
        if (r1 != null) goto L4;
    L7:
        return true;
    L4:
        if (r1.isDisposed() == true) goto L7;
        return false;
    }

    private final boolean isMidiSkinNotChanged(com.bytedance.android.livesdk.ktvimpl.base.sei.k r7) {
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r0 = r7.w();
        if (r0 == null) goto L6;
        String r1 = r0.h();
        if (r1 == null) goto L6;
    L7:
        long r2 = r7.j();
        Pair<Long, String> r8 = this.currentMidiSkinInfo;
        String r3 = null;
        if (r8 == null) goto L10;
        Long r9 = (Long) r8.getFirst();
    L11:
        if (r9 != null) goto L14;
    L21:
        return false;
    L14:
        if (r2 != r9.longValue()) goto L21;
        Pair<Long, String> r10 = this.currentMidiSkinInfo;
        if (r10 == null) goto L19;
        r3 = (String) r10.getSecond();
    L19:
        if (Intrinsics.areEqual(r1, r3) == false) goto L21;
        return true;
    L10:
        r9 = null;
    L6:
        r1 = r7.a();
        goto L7
    }

    private final boolean isMusicStopped(com.bytedance.android.livesdk.ktvimpl.base.sei.k r4) {
        if (r4.d() != 1) goto L8;
        if (r4.C() != 0) goto L8;
        return true;
    L8:
        if (r4.d() != 2) goto L10;
    L14:
        return true;
    L10:
        if (r4.d() == 6) goto L14;
        return false;
    }

    private final void onKtvSeiModelCompat(com.bytedance.android.livesdk.ktvimpl.base.sei.k r7) {
        int r0 = r7.d();
        if (r0 != 0) goto L5;
        initAudienceMidi(r7);
    L29:
        if (KtvSettingHelper.w() == true) goto L31;
        return;
    L31:
        if (this.needHideFeedback == true) goto L33;
        return;
    L33:
        if (isMusicStopped(r7) == false) goto L44;
        BaseCoreViewModel r8 = getCoreViewModel();
        if (r8 == null) goto L37;
        KtvRoomLyricsStateMachineConfig.d r9 = r8.getCurState();
    L39:
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L45;
        onSingFinish(false, null);
        return;
    L45:
        return;
    L37:
        r9 = null;
        goto L39
    L44:
        return;
    L5:
        if (r0 != 3) goto L29;
        if (r7.j() <= 0) goto L29;
        boolean r2 = true;
        if (r7.z() != 1) goto L29;
        List<v> r1 = r7.l();
        if (r1 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == false) goto L29;
        String r4 = r7.t();
        if (r4 != null) goto L22;
    L25:
        if (r2 == false) goto L29;
        this.showNoMidiHint.setValue(Boolean.TRUE);
        goto L29
    L22:
        if (r4.length() == 0) goto L25;
        r2 = false;
        goto L25
    L14:
        if (r1.isEmpty() == true) goto L17;
        r3 = false;
        goto L18
    }

    private final void onMidiSeiModel(com.bytedance.android.livesdk.ktvimpl.base.sei.i r18) {
        Collection r1 = (Collection) this.midiData.getValue();
        int r2 = 0;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return;
    L11:
        boolean r4 = getKtvContext().isCurrentUserIsSinger();
        boolean r5 = jc1.k.n(IInteractService.class).isAudienceLinkEngineOn();
        if (r4 == false) goto L14;
        return;
    L14:
        if (this.currentIsAnchor == false) goto L16;
    L19:
        this.curScore = r18.g();
        if (r18.f() != (-1)) goto L23;
        clearScore("onMidiSeiModel sei.index: " + r18.f());
    L23:
        if (this.lastMidiIndex >= r18.f()) goto L43;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r6 = KtvRoomContext.a.a();
        if (r6 == null) goto L31;
        com.bytedance.live.datacontext.m<Integer> r7 = r6.getMidiSingLyricsLineCount();
        if (r7 == null) goto L31;
        Integer r8 = (Integer) r7.getValue();
        if (r8 == null) goto L31;
        r2 = r8.intValue();
    L31:
        KtvRoomContext r9 = KtvRoomContext.a.a();
        if (r9 == null) goto L36;
        com.bytedance.live.datacontext.m<Integer> r10 = r9.getMidiSingLyricsLineCount();
        if (r10 == null) goto L36;
        r10.setValue(Integer.valueOf(r2 + 1));
    L36:
        StringBuilder r11 = new StringBuilder("Ktv onMidiSeiModel, real lyric count: ");
        KtvRoomContext r12 = KtvRoomContext.a.a();
        if (r12 == null) goto L41;
        com.bytedance.live.datacontext.m<Integer> r13 = r12.getMidiSingLyricsLineCount();
        if (r13 == null) goto L41;
        Integer r14 = (Integer) r13.getValue();
    L42:
        r11.append(r14);
        r11.append(' ');
        String r15 = r11.toString();
        ALogger.i(bb0.b.b(), r15 + ", invoke class :KtvMidiStageViewModel");
        this.lastMidiIndex = r18.f();
    L41:
        r14 = null;
    L43:
        int r16 = r18.c();
        if (r18.c() == (-1)) goto L46;
    L60:
        this.scoreInfo.setValue(new Pair(null, new com.bytedance.android.live.ktv.common.midi.k(r18.j(), r18.i(), 0.0f, r18.g(), r18.f(), Integer.valueOf(r18.e()), r16, false, DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE)));
        return;
    L46:
        if (this.currentIsAnchor == false) goto L60;
        MidiContext.a r17 = MidiContext.Companion;
        sb0.b r19 = (sb0.b) getKtvContext().getDataEntity().getValue();
        if (r19 == null) goto L52;
        sb0.e r20 = r19.b();
        if (r20 == null) goto L52;
        Map r21 = r20.getAnchorAbMap();
    L53:
        r17.getClass();
        if (MidiContext.a.e(r21) == false) goto L60;
        com.bytedance.android.live.ktv.common.midi.b r22 = this.mHitComboCalculator;
        float r23 = r18.g();
        int r24 = r18.f();
        g0 r25 = (g0) this.midiConfig.getValue();
        if (r25 == null) goto L58;
        Map r26 = r25.b();
    L59:
        r16 = r22.b(r23, r24, r26);
        goto L60
    L58:
        r26 = null;
    L52:
        r21 = null;
        goto L53
    L16:
        if (r18.d() != 0) goto L18;
        if (r5 == true) goto L19;
    L18:
        if (r5 == false) goto L19;
        return;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    private final void seekMidiScoreProgress(long r2) {
        com.bytedance.android.livesdk.ktvimpl.base.i r0 = (com.bytedance.android.livesdk.ktvimpl.base.i) getKtvContext().getKtvCoreController().getValue();
        if (r0 == null) goto L6;
        r0.n(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public boolean accept(w r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r0 = r4.b;
        if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == true) goto L5;
    L6:
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r5 = r4.b;
        if ((r5 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L9;
    L11:
        return false;
    L9:
        if ((!Intrinsics.areEqual(r5.a(), jc1.k.n(IMiddlewareUserService.class).user().n().toString().toString())) == false) goto L11;
        return true;
    L5:
        if ((!Intrinsics.areEqual(r0.a(), jc1.k.n(IMiddlewareUserService.class).user().n().toString().toString())) == false) goto L6;
        return true;
    }

    public Observable<cb0.c> findMidiSegment(long r3) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        ALogger.i(bb0.b.b(), "findMidiSegment midiData is null, invoke class :KtvMidiStageViewModel");
        return Observable.empty();
    L13:
        return Observable.just(this.midiData.getValue()).filter(d.a).flatMap(e.a).filter(new f(r3));
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public cb0.c findMidiSegmentOpt(long r10) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L14;
        ALogger.i(bb0.b.b(), "findMidiSegmentOpt midiData is null, invoke class :KtvMidiStageViewModel");
        return null;
    L14:
        if (this.curMidiSegmentIndex < 0) goto L36;
        List r2 = (List) this.midiData.getValue();
        if (r2 == null) goto L18;
        cb0.c r3 = (cb0.c) CollectionsKt.getOrNull(r2, this.curMidiSegmentIndex);
    L19:
        if (r3 == null) goto L25;
        cb0.a r4 = r3.a;
        if (r4.a >= r10) goto L25;
        if (r4.b < r10) goto L25;
        return r3;
    L25:
        List r5 = (List) this.midiData.getValue();
        if (r5 == null) goto L28;
        cb0.c r6 = (cb0.c) CollectionsKt.getOrNull(r5, this.curMidiSegmentIndex + 1);
    L29:
        if (r6 == null) goto L36;
        cb0.a r7 = r6.a;
        if (r7.a >= r10) goto L36;
        if (r7.b < r10) goto L36;
        this.curMidiSegmentIndex++;
        return r6;
    L28:
        r6 = null;
        goto L29
    L18:
        r3 = null;
    L36:
        List r8 = (List) this.midiData.getValue();
        if (r8 == null) goto L52;
        Iterator r9 = r8.iterator();
        int r11 = 0;
    L40:
        if (r9.hasNext() == false) goto L50;
        cb0.a r12 = ((cb0.c) r9.next()).a;
        if (r12.a < r10) goto L44;
    L46:
        boolean r13 = false;
    L47:
        if (r13 == true) goto L51;
        r11 = r11 + 1;
    L51:
        this.curMidiSegmentIndex = r11;
        goto L52
    L44:
        if (r12.b < r10) goto L46;
        r13 = true;
        goto L47
    L50:
        r11 = -1;
    L52:
        List r14 = (List) this.midiData.getValue();
        if (r14 != null) goto L55;
        return null;
    L55:
        return (cb0.c) CollectionsKt.getOrNull(r14, this.curMidiSegmentIndex);
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }

    public final void initAudienceMidi(com.bytedance.android.livesdk.ktvimpl.base.sei.k r14) {
        Intrinsics.checkNotNullParameter(r14, "sei");
        if (r14.j() > 0) goto L5;
        return;
    L5:
        if (getKtvContext().isCurrentUserIsSinger() == false) goto L7;
        return;
    L7:
        if (r14.j() == this.curMusicId) goto L27;
        boolean r1 = true;
        if (r14.z() == 1) goto L11;
        return;
    L11:
        if (r14.n() == 2) goto L29;
        String r0 = r14.t();
        if (r0 != null) goto L15;
    L18:
        if (r1 == true) goto L23;
        ALogger.i(bb0.b.b(), "onKtvSeiModelCompat sei.midiUrl is not null, invoke class :KtvMidiStageViewModel");
        this.curMusicId = r14.j();
        com.bytedance.android.live.ktv.common.music.download.h r2 = com.bytedance.android.live.ktv.common.music.download.h.a;
        String r7 = com.bytedance.android.live.ktv.common.music.download.h.e(r14.t(), this.curMusicId);
        if (new PolarisFileWrapper(r7).exists() == false) goto L22;
        initMidiRes$default(this, false, this.curMusicId, r7, null, null, false, 32, null);
        return;
    L22:
        com.bytedance.android.live.ktv.common.music.download.k.a r3 = com.bytedance.android.live.ktv.common.music.download.k.a;
        long r4 = this.curMusicId;
        String r15 = r14.t();
        Intrinsics.checkNotNull(r15);
        com.bytedance.android.live.ktv.common.music.download.k.c r5 = new com.bytedance.android.live.ktv.common.music.download.k.c(r4, r15, r7);
        WeakReference r16 = new WeakReference(this.midiDownloadCallback);
        r3.getClass();
        com.bytedance.android.live.ktv.common.music.download.k.a.b(r5, r16);
        return;
    L23:
        this.showNoMidiHint.setValue(Boolean.TRUE);
        return;
    L15:
        if (r0.length() == 0) goto L18;
        r1 = false;
        goto L18
    L29:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvStageViewModel
    public void onCreate(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        super.onCreate(r2);
        ke2.c.b(null);     // Catch: Throwable -> L5
    L6:
        fetchMidiConfig();
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a((com.bytedance.android.livesdk.ktvimpl.base.sei.d) getKtvContext().getSeiProcessor().getValue(), this);
        return;
    L5:
        ALogger.i(bb0.b.b(), "MediaEngineFactory.loadLibrary fail, invoke class :KtvMidiStageViewModel");
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvStageViewModel
    public void onPreparing(com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r10) {
        Intrinsics.checkNotNullParameter(r10, "ktvCoreDataModel");
        MusicPanel r11 = r10.a;
        if (r11 != null) goto L5;
        return;
    L5:
        resetMidiData();
        resetCurrentMidiList();
        if (KtvUtilsKt.w(r11.a) == false) goto L12;
        long r3 = r11.a.getMId();
        String r5 = r11.q;
        String r6 = r11.l;
        String r7 = r11.p;
        if (r11.a.getMLyricType() != 2) goto L10;
        boolean r8 = true;
    L11:
        initMidiRes(true, r3, r5, r6, r7, r8);
    L15:
        this.scoreInfo.setValue(null);
        tryHideFeedback();
        return;
    L10:
        r8 = false;
        goto L11
    L12:
        Disposable r12 = this.scoreDisposable;
        if (r12 == null) goto L15;
        r12.dispose();
        goto L15
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public void onSeiResult(w r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r0 = r3.b;
        if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L6;
        onKtvSeiModelCompat((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r0);
        handleMidiSkinSei(r3);
        return;
    L6:
        if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == false) goto L10;
        onMidiSeiModel((com.bytedance.android.livesdk.ktvimpl.base.sei.i) r0);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvStageViewModel
    public void onSinging(com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r10) {
        Intrinsics.checkNotNullParameter(r10, "ktvCoreDataModel");
        super.onSinging(r10);
        MusicPanel r11 = r10.a;
        if (r11 != null) goto L6;
        return;
    L6:
        if (KtvUtilsKt.w(r11.a) == true) goto L8;
        return;
    L8:
        if (this.midiData.getValue() == null) goto L10;
        return;
    L10:
        if (KtvUtilsKt.B(r11) == false) goto L19;
        long r3 = r11.a.getMId();
        String r5 = r11.q;
        String r6 = r11.l;
        String r7 = r11.p;
        if (r11.a.getMLyricType() != 2) goto L14;
        boolean r8 = true;
    L15:
        initMidiRes(true, r3, r5, r6, r7, r8);
        return;
    L14:
        r8 = false;
        goto L15
    }

    public final void resetMidiRecord(String r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        if (this.currentIsAnchor == true) goto L5;
    L7:
        this.isReported = false;
        return;
    L5:
        if (this.isReported == true) goto L7;
        pd2.d.n.getClass();
        pd2.d.I(null, "Ktv resetMidiRecord, is from: " + r4);
        goto L7
    }

    public final void setCurMidiSegmentIndex(int r1) {
        this.curMidiSegmentIndex = r1;
    }

    public final void setCurMidiSegmentList(List<cb0.c> r1) {
        this.curMidiSegmentList = r1;
    }

    public void setCurTotalScore(int r1) {
        this.curTotalScore = r1;
    }

    public final void setLastMidiSegmentEndIndex(int r1) {
        this.lastMidiSegmentEndIndex = r1;
    }

    public final void setLastMidiSegmentStartIndex(int r1) {
        this.lastMidiSegmentStartIndex = r1;
    }

    public final void setMidiConfig(MutableLiveData<g0> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.midiConfig = r2;
    }

    public final void setReported(boolean r1) {
        this.isReported = r1;
    }

    public final void setShowNoMidiHint(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.showNoMidiHint = r2;
    }

    public void setTotalScore(int r1) {
        this.totalScore = r1;
    }

    public void setUserOpenScore(boolean r1) {
        this.userOpenScore = r1;
    }

    public final void tryStartGetScoreInfoTimer(Long r6) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        ALogger.i(bb0.b.b(), "KtvMidiStageViewModel :tryStartGetScoreInfoTimer midiData is null, invoke class :KtvMidiStageViewModel");
        return;
    L13:
        if (isDisposed(this.scoreDisposable) == true) goto L20;
        if (r6 != null) goto L16;
        return;
    L16:
        if (Math.abs(this.curMidiProgress - r6.longValue()) <= 1000) goto L34;
        this.curMidiProgress = r6.longValue();
        seekMidiScoreProgress(r6.longValue());
        return;
    L34:
        return;
    L20:
        if (isDisposed(this.scoreDisposable) == false) goto L35;
        if (r6 == null) goto L36;
        BaseCoreViewModel r2 = getCoreViewModel();
        if (r2 == null) goto L25;
        KtvRoomLyricsStateMachineConfig.d r3 = r2.getCurState();
    L27:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L37;
        String r4 = bb0.b.b();
        ALogger.i(r4, "KtvMidiStageViewModel :" + ("tryStartGetScoreInfoTimer, progress = " + r6) + ", invoke class :KtvMidiStageViewModel");
        this.curMidiProgress = r6.longValue();
        if (r6.longValue() <= 1000) goto L31;
        seekMidiScoreProgress(r6.longValue());
    L31:
        this.scoreDisposable = du2.a.d(this.scoreTimeSetting, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(this));
        return;
    L37:
        return;
    L25:
        r3 = null;
        goto L27
    L36:
        return;
    L35:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public KtvMidiStageViewModel(KtvContext r3, KtvRoomViewModel r4) {
        Intrinsics.checkNotNullParameter(r3, "ktvContext");
        Intrinsics.checkNotNullParameter(r4, "vm");
        super(r3, r4);
        sb0.b r5 = (sb0.b) r3.getDataEntity().getValue();
        this.dataEntity = r5;
        this.userOpenScore = true;
        this.compositeDispose = new CompositeDisposable();
        this.scoreInfoArr = new double[21];
        this.lastMidiIndex = -1;
        this.lastTone = -1.0f;
        this.mHitComboCalculator = new com.bytedance.android.live.ktv.common.midi.b();
        this.midiData = new MutableLiveData();
        this.lastMidiSegmentStartIndex = -1;
        this.lastMidiSegmentEndIndex = -1;
        this.curMidiSegmentIndex = -1;
        this.midiConfig = new MutableLiveData();
        this.showNoMidiHint = new MutableLiveData();
        this.scoreInfo = new MutableLiveData();
        this.hideFeedback = new MutableLiveData();
        this.midiDownloadingTask = new LinkedHashSet();
        this.calFactorSetting = ((Number) KtvSettingHelper.x0.getValue()).floatValue();
        this.scoreTimeSetting = KtvSettingHelper.s();
        this.scoreRangeSetting = ((Number) KtvSettingHelper.C0.getValue()).intValue();
        Lazy r6 = KtvCommonSettingHelper.a;
        if (r5 == null) goto L5;
        boolean r7 = r5.isAnchor();
    L6:
        this.currentIsAnchor = r7;
        this.midiDownloadCallback = new n(this);
        return;
    L5:
        r7 = false;
        goto L6
    }

    public static final /* synthetic */ void access$setCurMidiProgress$p(KtvMidiStageViewModel r0, long r1) {
        r0.curMidiProgress = r1;
    }

    public static final /* synthetic */ void access$setCurMusicId$p(KtvMidiStageViewModel r0, long r1) {
        r0.curMusicId = r1;
    }

    public static final /* synthetic */ void access$setNeedHideFeedback$p(KtvMidiStageViewModel r0, boolean r1) {
        r0.needHideFeedback = r1;
    }

    private final boolean isNeedSendMidiSei(float r6, int r7) {
        if (r6 >= this.scoreRangeSetting) goto L5;
        boolean r8 = true;
    L7:
        if (r8 == this.lastMidiHitFlag) goto L9;
        this.lastMidiHitFlag = r8;
        boolean r9 = true;
    L11:
        if (r7 <= this.lastMidiIndex) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L29;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r3 = KtvRoomContext.a.a();
        if (r3 == null) goto L22;
        com.bytedance.live.datacontext.m<Integer> r4 = r3.getMidiSingLyricsLineCount();
        if (r4 == null) goto L22;
        Integer r5 = (Integer) r4.getValue();
        if (r5 == null) goto L22;
        int r10 = r5.intValue();
    L23:
        KtvRoomContext r11 = KtvRoomContext.a.a();
        if (r11 == null) goto L28;
        com.bytedance.live.datacontext.m<Integer> r12 = r11.getMidiSingLyricsLineCount();
        if (r12 == null) goto L28;
        r12.setValue(Integer.valueOf(r10 + 1));
    L28:
        this.lastMidiIndex = r7;
    L22:
        r10 = 0;
    L29:
        if (r9 == true) goto L31;
        if (r0 == true) goto L31;
        return false;
    L31:
        return true;
    L13:
        r0 = false;
        goto L14
    L9:
        r9 = false;
        goto L11
    L5:
        r8 = false;
        goto L7
    }

    public Single<List<cb0.c>> findMidiSegments(long r3, long r5) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        ALogger.i(bb0.b.b(), "findMidiSegments midiData is null, invoke class :KtvMidiStageViewModel");
        return null;
    L13:
        return Observable.just(this.midiData.getValue()).filter(g.a).flatMap(h.a).filter(new i(r5, r3)).toList();
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public List<cb0.c> findMidiSegmentsNew(long r10, long r12) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        ArrayList r3 = null;
        if (r1 == false) goto L13;
        ALogger.i(bb0.b.b(), "findMidiSegmentsNew midiData is null, invoke class :KtvMidiStageViewModel");
        return null;
    L13:
        List r2 = (List) this.midiData.getValue();
        if (r2 == null) goto L26;
        r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L17:
        if (r4.hasNext() == false) goto L26;
        Object r5 = r4.next();
        cb0.a r6 = ((cb0.c) r5).a;
        if (r6.a < r12) goto L21;
    L23:
        boolean r7 = false;
    L24:
        if (r7 == false) goto L17;
        r3.add(r5);
        goto L17
    L21:
        if (r6.b <= r10) goto L23;
        r7 = true;
    L26:
        return r3;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public List<cb0.c> findMidiSegmentsOpt(long r12, long r14) {
        List r0 = (List) this.midiData.getValue();
        List r1 = r0;
        int r2 = 0;
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L13;
        ALogger.i(bb0.b.b(), "findMidiSegmentsOpt midiData is null, invoke class :KtvMidiStageViewModel");
        return null;
    L13:
        int r5 = this.lastMidiSegmentEndIndex;
        if (r5 < this.lastMidiSegmentStartIndex) goto L36;
        if (r5 < 0) goto L36;
        List<cb0.c> r3 = this.curMidiSegmentList;
        if (r3 == null) goto L25;
        cb0.c r6 = (cb0.c) CollectionsKt.getOrNull(r3, 0);
        if (r6 == null) goto L25;
        if (r6.a.b >= r12) goto L25;
        List<cb0.c> r13 = this.curMidiSegmentList;
        if (r13 == null) goto L25;
        r13.remove(r6);
    L25:
        int r15 = this.lastMidiSegmentEndIndex + 1;
        if (r15 < 0) goto L35;
        if (r15 >= r0.size()) goto L35;
        if (((cb0.c) ListProtector.get(r0, r15)).a.a > r14) goto L35;
        this.lastMidiSegmentEndIndex = r15;
        List<cb0.c> r16 = this.curMidiSegmentList;
        if (r16 == null) goto L35;
        r16.add((cb0.c) ListProtector.get(r0, r15));
    L35:
        return this.curMidiSegmentList;
    L36:
        cb0.c r7 = (cb0.c) CollectionsKt.getOrNull(r0, 0);
        if (r7 != null) goto L39;
    L41:
        List r8 = r0;
        Iterator r9 = r8.iterator();
        int r10 = 0;
    L43:
        if (r9.hasNext() == false) goto L51;
        Object r11 = r9.next();
        int r17 = r10 + 1;
        if (r10 >= 0) goto L48;
        CollectionsKt.throwIndexOverflow();
    L48:
        if (((cb0.c) r11).a.b >= r12) goto L49;
        r10 = r17;
        goto L43
    L49:
        this.lastMidiSegmentStartIndex = r10;
    L51:
        Iterator r18 = r8.iterator();
    L53:
        if (r18.hasNext() == false) goto L61;
        Object r19 = r18.next();
        int r20 = r2 + 1;
        if (r2 >= 0) goto L58;
        CollectionsKt.throwIndexOverflow();
    L58:
        if (((cb0.c) r19).a.a >= r14) goto L59;
        r2 = r20;
        goto L53
    L59:
        this.lastMidiSegmentEndIndex = r2;
    L61:
        ArrayList r110 = new ArrayList();
        int r111 = this.lastMidiSegmentStartIndex;
        int r112 = this.lastMidiSegmentEndIndex;
        if (r112 <= r111) goto L69;
        if (r111 < 0) goto L69;
        if ((!r1.isEmpty()) == false) goto L69;
        if (r112 >= r0.size()) goto L69;
        r110.addAll(r0.subList(r111, r112));
    L69:
        Unit r113 = Unit.INSTANCE;
        this.curMidiSegmentList = r110;
        return r110;
    L39:
        if (r14 > r7.a.a) goto L41;
        return null;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r4 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvStageViewModel
    public void onSingFinish(boolean r5, MusicPanel r6) {
        String r1 = bb0.b.b();
        ALogger.i(r1, "KtvMidiStageViewModel :" + ("onSingFinish: musicPanel：" + r6) + ", invoke class :KtvMidiStageViewModel");
        if (r6 == null) goto L16;
        if (r5 == false) goto L10;
        Disposable r7 = this.scoreDisposable;
        if (r7 == null) goto L8;
        r7.dispose();
    L8:
        disposeMidiDisposable();
        this.curMidiProgress = 0;
        this.lastMidiScoreGetTime = 0;
    L10:
        if (this.currentIsAnchor == true) goto L12;
    L15:
        clearScore("onSingFinish");
        goto L16
    L12:
        if (this.isReported == true) goto L14;
        reportScore(r6, "onSingFinish");
    L14:
        resetMidiRecord("onSingFinish");
    L16:
        this.midiData.setValue(null);
        resetCurrentMidiList();
        this.lastMidiHitFlag = false;
        this.lastMidiIndex = -1;
        this.mHitComboCalculator.a();
        this.curMusicId = 0;
        tryHideFeedback();
    }

    public final void reportScore(MusicPanel r24, String r25) {
        Intrinsics.checkNotNullParameter(r24, "musicPanel");
        Intrinsics.checkNotNullParameter(r25, "isFrom");
        StringBuilder r3 = new StringBuilder("reportScore: isReported: ");
        r3.append(this.isReported);
        r3.append(" userId: ");
        InteractiveSongUserInfo r4 = r24.f();
        String r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.getIdString();
    L6:
        r3.append(r6);
        r3.append(" isFrom: ");
        r3.append(r25);
        String r7 = r3.toString();
        ALogger.i(bb0.b.b(), "KtvMidiStageViewModel :" + r7 + ", invoke class :KtvMidiStageViewModel");
        if (this.isReported == true) goto L70;
        InteractiveSongUserInfo r8 = r24.f();
        if (r8 == null) goto L11;
        String r9 = r8.getIdString();
    L13:
        if (TextUtils.isEmpty(r9) == true) goto L71;
        float r10 = this.curScore;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r11 = KtvRoomContext.a.a();
        if (r11 == null) goto L21;
        com.bytedance.live.datacontext.m<Integer> r12 = r11.getMidiTotalLyricsLineCount();
        if (r12 == null) goto L21;
        Integer r13 = (Integer) r12.getValue();
        if (r13 == null) goto L21;
    L27:
        int r14 = 0;
        if (r13 == null) goto L30;
        int r15 = r13.intValue();
    L31:
        KtvRoomContext r16 = KtvRoomContext.a.a();
        if (r16 == null) goto L38;
        com.bytedance.live.datacontext.m<Integer> r17 = r16.getMidiSingLyricsLineCount();
        if (r17 == null) goto L38;
        Integer r18 = (Integer) r17.getValue();
        if (r18 == null) goto L38;
        r14 = r18.intValue();
    L38:
        com.bytedance.android.livesdk.chatroom.o r19 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r19 == null) goto L45;
        com.bytedance.live.datacontext.m r20 = r19.getRoom();
        if (r20 == null) goto L45;
        IRoom r21 = (IRoom) r20.getValue();
        if (r21 == null) goto L45;
        long r22 = r21.getRoomId();
    L46:
        long r110 = r22;
        if (this.isReported == true) goto L61;
        pd2.d r23 = pd2.d.n;
        StringBuilder r26 = new StringBuilder("Ktv reportScore api start. isFrom: ");
        r26.append(r25);
        r26.append(", score: ");
        r26.append(r10);
        r26.append("  realLyricsCount: ");
        r26.append(r14);
        r26.append("  totalLyricCount: ");
        r26.append(r15);
        r26.append(" (midiTotalLyricsSize: ");
        KtvRoomContext r2 = KtvRoomContext.a.a();
        if (r2 == null) goto L53;
        com.bytedance.live.datacontext.m<Integer> r27 = r2.getMidiTotalLyricsLineCount();
        if (r27 == null) goto L53;
        Integer r28 = (Integer) r27.getValue();
    L54:
        r26.append(r28);
        r26.append("  lyricsChangeLiveData#LyricsSize: ");
        ub0.a r29 = (ub0.a) getKtvContext().getLyricsChangeLiveData().getValue();
        if (r29 == null) goto L59;
        List r30 = r29.a();
        if (r30 == null) goto L59;
        Integer r31 = Integer.valueOf(r30.size());
    L60:
        r26.append(r31);
        String r32 = r26.toString();
        r23.getClass();
        pd2.d.I(r24, r32);
    L59:
        r31 = null;
    L53:
        r28 = null;
    L61:
        this.isReported = true;
        ALogger.i("midi-check", "reportScore api start：" + r10 + "---totalLyricCount:" + r15 + "--realLyricsCount:" + r14);
        KtvRoomApi r33 = (KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class);
        long r111 = r24.a.getMId();
        double r112 = (double) r10;
        InteractiveSongUserInfo r34 = r24.f();
        if (r34 == null) goto L64;
        String r35 = r34.getIdString();
    L65:
        long r113 = d5.c(r35);
        InteractiveSongUserInfo r36 = r24.f();
        if (r36 == null) goto L68;
        r5 = r36.getIdString();
    L68:
        this.reportMidiDisposable = r33.reportMidiScore(r111, r110, r112, r113, r5, r15, r14).compose(RxUtil.rxSchedulerHelper()).subscribe(new o(this, r24, r10), new p(this, r24, r10));
        clearScore("reportScore");
        return;
    L64:
        r35 = null;
    L45:
        r22 = 0;
        goto L46
    L30:
        r15 = 0;
    L21:
        ub0.a r37 = (ub0.a) getKtvContext().getLyricsChangeLiveData().getValue();
        if (r37 == null) goto L26;
        List r38 = r37.a();
        if (r38 == null) goto L26;
        r13 = Integer.valueOf(r38.size());
    L26:
        r13 = null;
        goto L27
    L71:
        return;
    L11:
        r9 = null;
        goto L13
    L70:
        return;
    L5:
        r6 = null;
        goto L6
    }

    private final float calScore(float r3, float r4, int r5) {
        if (r5 >= 0) goto L4;
        return r4;
    L4:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r0 = KtvRoomContext.a.a();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Map<Integer, Float>> r1 = r0.getScoreMap();
        if (r1 == null) goto L9;
        Map r2 = (Map) r1.getValue();
    L10:
        int r6 = 1;
        if (r2 == null) goto L21;
        r2.put(Integer.valueOf(r5), Float.valueOf(r4));
        Iterator r7 = r2.values().iterator();
        float r8 = 0.0f;
    L14:
        if (r7.hasNext() == false) goto L17;
        r8 = r8 + ((Number) r7.next()).floatValue();
        goto L14
    L17:
        if (r2.isEmpty() == true) goto L20;
        r6 = r2.size();
    L20:
        float r9 = r8 / r6;
    L23:
        if (r9 <= 100.0f) goto L25;
        r9 = 100.0f;
    L25:
        this.curScore = r9;
        return r9;
    L21:
        r9 = r3 / (r5 + 1);
    L9:
        r2 = null;
        goto L10
    }

    public static /* synthetic */ void reportScore$default(KtvMidiStageViewModel r0, MusicPanel r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        r0.reportScore(r1, r2);
    }

    private final void initMidiRes(boolean r7, long r8, String r10, String r11, String r12, boolean r13) {
        ALogger.i(bb0.b.b(), "initMidiRes, invoke class :KtvMidiStageViewModel");
        if (TextUtils.isEmpty(r10) == true) goto L18;
        if (r13 == true) goto L18;
        if (isDisposed(this.midiDisposable) == false) goto L20;
        Collection r14 = (Collection) this.midiData.getValue();
        if (r14 != null) goto L11;
    L14:
        boolean r15 = true;
    L15:
        if (r15 == false) goto L21;
        this.midiDisposable = Single.create(new j(this, r7, r11, r10, r12)).map(new k(this, r7, r10)).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this), new m(this, r8));
        return;
    L21:
        return;
    L11:
        if (r14.isEmpty() == true) goto L14;
        r15 = false;
        goto L15
    L20:
        return;
    L18:
        ALogger.i(bb0.b.b(), "initMidiRes fail, midiPath == null || isLrcLyric, invoke class :KtvMidiStageViewModel");
        this.showNoMidiHint.setValue(Boolean.TRUE);
    }

    public static /* synthetic */ void initMidiRes$default(KtvMidiStageViewModel r9, boolean r10, long r11, String r13, String r14, String r15, boolean r16, int r17, Object r18) {
        if ((r17 & 32) == 0) goto L5;
        boolean r8 = false;
    L6:
        r9.initMidiRes(r10, r11, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    private final void sendMidiFeedbackSei(String r4, String r5, String r6, String r7, long r8, String r10, float r11, boolean r12, String r13, boolean r14, long r15, String r17, double r18) {
        ALogger.i(bb0.b.b(), "sendMidiFeedbackSei, invoke class :KtvMidiStageViewModel");
        ALogger.i("midi-check", "sendMidiFeedbackSei");
        JSONObject r0 = t.b(r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r17, r18);
        BaseCoreViewModel r1 = getCoreViewModel();
        if (r1 == null) goto L6;
        r1.sendSei("ktv_midi_feedback_sei", r0);
        return;
    }

    public static final /* synthetic */ void access$sendMidiFeedbackSei(KtvMidiStageViewModel r0, String r1, String r2, String r3, String r4, long r5, String r7, float r8, boolean r9, String r10, boolean r11, long r12, String r14, double r15) {
        r0.sendMidiFeedbackSei(r1, r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r14, r15);
    }
}
