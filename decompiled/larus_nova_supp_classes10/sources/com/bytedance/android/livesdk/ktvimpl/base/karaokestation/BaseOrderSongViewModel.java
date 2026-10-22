package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.api.KtvCommonApi;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.q;
import com.bytedance.android.live.ktv.common.karaokestation.model.v;
import com.bytedance.android.live.ktv.common.model.api.k0;
import com.bytedance.android.live.ktv.common.model.api.l0;
import com.bytedance.android.live.ktv.common.model.api.o0;
import com.bytedance.android.live.ktv.common.music.control.IMusicControlNode;
import com.bytedance.android.live.ktv.common.music.control.KtvMusicControlManager;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.music.download.p;
import com.bytedance.android.live.ktv.common.music.download.t;
import com.bytedance.android.live.ktv.common.music.download.u;
import com.bytedance.android.live.ktv.common.music.download.y;
import com.bytedance.android.live.ktv.common.music.download.z;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.liveinteract.banner.BannerApi;
import com.bytedance.android.live.liveinteract.banner.KtvActivityLinkResponse;
import com.bytedance.android.live.liveinteract.banner.LabelBannerUrl;
import com.bytedance.android.live.liveinteract.floatwindow.applywindow.LinkmicApplyFloatWindowManager;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.soloktv.model.EnterRtChorusRoomSource;
import com.bytedance.android.live.soloktv.model.JumpRealTimeChorusRoomParams;
import com.bytedance.android.live.soloktv.model.JumpRoomInfo;
import com.bytedance.android.live.soloktv.model.JumpScene;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KSongAnchorApi;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.base.controlnode.AddMusicControlNode;
import com.bytedance.android.livesdk.ktvimpl.base.controlnode.CutMusicControlNode;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.PersonalSongInfo;
import com.bytedance.android.livesdk.message.model.RTChorusOperateType;
import com.bytedance.android.livesdk.message.model.RealTimeChorusInfo;
import com.bytedance.android.livesdk.message.model.RecommendRealTimeChorusInfo;
import com.bytedance.android.livesdk.message.model.WantListenInfo;
import com.bytedance.android.livesdk.message.model.de;
import com.bytedance.android.livesdk.message.model.ig;
import com.bytedance.android.livesdk.message.model.t8;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.MultiLinkSettingHelper;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000¬\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 À\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\nÁ\u0002Â\u0002Ã\u0002Ä\u0002Å\u0002B,\u0012\n\u0010\u00ad\u0002\u001a\u0005\u0018\u00010¬\u0002\u0012\n\u0010²\u0002\u001a\u0005\u0018\u00010±\u0002\u0012\t\u0010¶\u0002\u001a\u0004\u0018\u00010J¢\u0006\u0006\b¾\u0002\u0010¿\u0002J\u0018\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0016\u0010\u0012\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0013H\u0002J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0002J&\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0#2\b\u0010*\u001a\u0004\u0018\u00010)H\u0002J*\u0010.\u001a\u00020\b2\u0006\u0010,\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010-\u001a\u00020\u0015H\u0002J\u0016\u00100\u001a\u00020\b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0010\u00101\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u00102\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u00103\u001a\u00020\bH\u0002J\u0010\u00105\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u0013H\u0002J\u0010\u00106\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J(\u0010;\u001a\u00020\b2\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u00132\u000e\u0010:\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010#H\u0002J\b\u0010<\u001a\u00020\bH\u0016J\u0010\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u0015H\u0016J\u0010\u0010?\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\u0015H\u0016J\n\u0010A\u001a\u0004\u0018\u00010@H\u0004J\u0010\u0010D\u001a\u00020\b2\u0006\u0010C\u001a\u00020BH\u0016J\u0010\u0010E\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0014J)\u0010H\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00132\b\u0010G\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\bH\u0010IJ\n\u0010K\u001a\u0004\u0018\u00010JH\u0016J\u0016\u0010L\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0014J*\u0010S\u001a\u00020\b2\u0006\u0010N\u001a\u00020M2\u0018\u0010R\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020Q0P0OH\u0016J\u0016\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020Q\u0018\u00010TH\u0016J\u0010\u0010X\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016J\u0010\u0010Z\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\u0013H\u0016J\u0010\u0010[\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0004J\u0010\u0010\\\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0006H\u0014J\b\u0010]\u001a\u00020\bH\u0016J\u0010\u0010^\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J \u0010`\u001a\u00020\b2\u0006\u0010_\u001a\u00020M2\u000e\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060OH\u0016J \u0010a\u001a\u00020\b2\u0006\u0010_\u001a\u00020M2\u000e\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060OH\u0016J\u0010\u0010c\u001a\u00020\b2\u0006\u0010b\u001a\u00020\u0013H\u0016J\b\u0010d\u001a\u00020\bH\u0016J\u0010\u0010e\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010f\u001a\u00020\bH\u0016J\u0012\u0010g\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J,\u0010n\u001a\u00020\b2\u0006\u0010i\u001a\u00020h2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010k\u001a\u0004\u0018\u00010j2\b\u0010m\u001a\u0004\u0018\u00010lH\u0016J\u0010\u0010q\u001a\u00020\b2\u0006\u0010p\u001a\u00020oH\u0016J\b\u0010r\u001a\u00020\u0013H\u0016J\u0010\u0010t\u001a\u00020\b2\u0006\u0010s\u001a\u00020\u0013H\u0016JH\u0010|\u001a\u00020\b2\u0006\u0010u\u001a\u00020\u00132\u0006\u0010v\u001a\u00020\u00132\u0006\u0010x\u001a\u00020w2\u0006\u0010y\u001a\u00020\u00152\u000e\b\u0002\u0010{\u001a\b\u0012\u0004\u0012\u00020z0#2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060#H\u0004J\u0010\u0010}\u001a\u00020\b2\u0006\u0010p\u001a\u00020oH\u0004J\u0010\u0010~\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0013\u0010\u0080\u0001\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u007fH\u0016J\u0007\u0010\u0081\u0001\u001a\u00020\u0013J\u001b\u0010\u0084\u0001\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0016J\u001b\u0010\u0085\u0001\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0016J;\u0010\u008b\u0001\u001a\u00020\b2\u0006\u0010v\u001a\u00020\u00132(\u0010\u008a\u0001\u001a#\u0012\u0016\u0012\u00140\u0013¢\u0006\u000f\b\u0087\u0001\u0012\n\b\u0088\u0001\u0012\u0005\b\b(\u0089\u0001\u0012\u0004\u0012\u00020\b\u0018\u00010\u0086\u0001H\u0016J#\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\t\u0012\u0005\u0012\u00030\u008c\u00010\u00052\u0007\u0010\u008d\u0001\u001a\u00020\u0015H\u0004J\t\u0010\u008f\u0001\u001a\u00020\bH\u0014J\n\u0010\u0091\u0001\u001a\u00030\u0090\u0001H\u0016J\u0012\u0010\u0093\u0001\u001a\u00020\b2\u0007\u0010\u0092\u0001\u001a\u00020\u0013H\u0016J\u0013\u0010\u0096\u0001\u001a\f\u0012\u0005\u0012\u00030\u0095\u0001\u0018\u00010\u0094\u0001H\u0016J\t\u0010\u0097\u0001\u001a\u00020\u0013H\u0016J\u001b\u0010\u009a\u0001\u001a\u000b \u0099\u0001*\u0004\u0018\u00010\u00150\u00152\u0007\u0010\u0098\u0001\u001a\u00020VH\u0014J\t\u0010\u009b\u0001\u001a\u00020VH\u0014J\u0013\u0010\u009c\u0001\u001a\u00020\u00132\b\u0010C\u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010\u009d\u0001\u001a\u00020\u0013H\u0016J\"\u0010\u009f\u0001\u001a\u00020\b2\r\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010¡\u0001\u001a\u00020\b2\u0007\u0010 \u0001\u001a\u000207H\u0016J!\u0010¢\u0001\u001a\u00020\b2\u0006\u0010_\u001a\u00020M2\u000e\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010V0OH\u0016J\u0014\u0010£\u0001\u001a\u0004\u0018\u00010VH\u0016¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u000b\u0010¥\u0001\u001a\u0004\u0018\u00010BH\u0016J\t\u0010¦\u0001\u001a\u00020VH\u0016J\t\u0010§\u0001\u001a\u00020\u0015H\u0016J\u001a\u0010©\u0001\u001a\u00020\b2\u0007\u0010¨\u0001\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u001aH\u0016J\u0013\u0010ª\u0001\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010¬\u0001\u001a\u00030«\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R#\u0010®\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150T8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R#\u0010µ\u0001\u001a\u0005\u0018\u00010°\u00018DX\u0084\u0084\u0002¢\u0006\u0010\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001R\u001e\u0010¶\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0094\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u001e\u0010¸\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0094\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010·\u0001R\u001d\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R)\u0010»\u0001\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b»\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R\u0019\u0010À\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010¼\u0001R\u0019\u0010\u0081\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010¼\u0001R\u001c\u0010Â\u0001\u001a\u00070Á\u0001R\u00020\u00008\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001c\u0010Å\u0001\u001a\u00070Ä\u0001R\u00020\u00008\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u0019\u0010Ç\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010¼\u0001R/\u0010È\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÈ\u0001\u0010º\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R)\u0010Í\u0001\u001a\u00020\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÍ\u0001\u0010Î\u0001\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R'\u0010Ó\u0001\u001a\n\u0012\u0005\u0012\u00030\u0095\u00010\u0094\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bÓ\u0001\u0010·\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001R!\u0010Ú\u0001\u001a\u00030Ö\u00018DX\u0084\u0084\u0002¢\u0006\u0010\n\u0006\b×\u0001\u0010²\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001R2\u0010Û\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020Q0T0\u0094\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bÛ\u0001\u0010·\u0001\u001a\u0006\bÜ\u0001\u0010Õ\u0001R+\u0010Ý\u0001\u001a\u0004\u0018\u00010B8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÝ\u0001\u0010Þ\u0001\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R%\u0010ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bã\u0001\u0010º\u0001\u001a\u0006\bä\u0001\u0010Ê\u0001R%\u0010å\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bå\u0001\u0010º\u0001\u001a\u0006\bæ\u0001\u0010Ê\u0001R2\u0010è\u0001\u001a\u000b\u0012\u0004\u0012\u00020h\u0018\u00010ç\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bè\u0001\u0010é\u0001\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0006\bì\u0001\u0010í\u0001R&\u0010ï\u0001\u001a\t\u0012\u0004\u0012\u0002070î\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bï\u0001\u0010ð\u0001\u001a\u0006\bñ\u0001\u0010ò\u0001R+\u0010ó\u0001\u001a\u0004\u0018\u00010\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bó\u0001\u0010Î\u0001\u001a\u0006\bô\u0001\u0010Ð\u0001\"\u0006\bõ\u0001\u0010Ò\u0001R\u001e\u00104\u001a\u00020\u00138DX\u0084\u0084\u0002¢\u0006\u000f\n\u0006\bö\u0001\u0010²\u0001\u001a\u0005\b4\u0010½\u0001R \u0010ø\u0001\u001a\u00030÷\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bø\u0001\u0010ù\u0001\u001a\u0006\bú\u0001\u0010û\u0001R\u001b\u0010ü\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010ý\u0001R\u001f\u0010þ\u0001\u001a\u0002078\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bþ\u0001\u0010ÿ\u0001\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002R!\u0010\u0086\u0002\u001a\u00030\u0082\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0083\u0002\u0010²\u0001\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002R!\u0010\u008b\u0002\u001a\u00030\u0087\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0088\u0002\u0010²\u0001\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002R!\u0010\u0090\u0002\u001a\u00030\u008c\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008d\u0002\u0010²\u0001\u001a\u0006\b\u008e\u0002\u0010\u008f\u0002R!\u0010\u0095\u0002\u001a\u00030\u0091\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0092\u0002\u0010²\u0001\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002R!\u0010\u009a\u0002\u001a\u00030\u0096\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0097\u0002\u0010²\u0001\u001a\u0006\b\u0098\u0002\u0010\u0099\u0002R!\u0010\u009d\u0002\u001a\u00030\u0091\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009b\u0002\u0010²\u0001\u001a\u0006\b\u009c\u0002\u0010\u0094\u0002R!\u0010¢\u0002\u001a\u00030\u009e\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009f\u0002\u0010²\u0001\u001a\u0006\b \u0002\u0010¡\u0002R\u001c\u0010¤\u0002\u001a\u00070£\u0002R\u00020\u00008\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0002\u0010¥\u0002R\u001e\u0010§\u0002\u001a\t\u0012\u0004\u0012\u00020V0¦\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0002\u0010¨\u0002R\u001e\u0010©\u0002\u001a\t\u0012\u0004\u0012\u00020\u00130¦\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0002\u0010¨\u0002R\u0019\u0010ª\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0002\u0010¼\u0001R\u0019\u0010«\u0002\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0002\u0010ÿ\u0001R\"\u0010\u00ad\u0002\u001a\u0005\u0018\u00010¬\u00028\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b\u00ad\u0002\u0010®\u0002\u001a\u0006\b¯\u0002\u0010°\u0002R\"\u0010²\u0002\u001a\u0005\u0018\u00010±\u00028\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b²\u0002\u0010³\u0002\u001a\u0006\b´\u0002\u0010µ\u0002R!\u0010¶\u0002\u001a\u0004\u0018\u00010J8\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b¶\u0002\u0010·\u0002\u001a\u0006\b¸\u0002\u0010¹\u0002R\u0018\u0010½\u0002\u001a\u00030º\u00028DX\u0084\u0004¢\u0006\b\u001a\u0006\b»\u0002\u0010¼\u0002¨\u0006Æ\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseOrderSongViewModel;", "Landroidx/lifecycle/ViewModel;", "Lvlc/l;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/d;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "songList", "", "handleSongListChange", "addMessageListenerIfNeed", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "obtainSingState", "cancelLinkWaitingStateSubscribleIfNeed", "musicPanel", "Lio/reactivex/disposables/Disposable;", "createLinkWaitingStateObserver", "list", "updateKtvOrderedSongList", "", "isAdmin", "", "addSongSource", "getFromRequestTypeByAddSongSource", "panel", "handlePlayAllSource", "Lcom/bytedance/android/live/ktv/common/karaokestation/model/y;", "secondLevelTabData", "updateTabData", "firstSelectedMusicOrNull", "showFrequencyControlPrompt", "Lcom/bytedance/android/livesdk/message/model/de;", "message", "handleSongListChangeMini", "hasSelectedPlayList", "", "Lcom/bytedance/android/livesdk/message/model/de$a;", "musicInfoList", "getUpdatedOrderedListByMessage", "Lcom/bytedance/android/live/ktv/common/model/api/h$a;", "orderedListInfo", "Lcom/bytedance/android/live/ktv/common/model/api/k0;", "userInfoBase", "getUpdatedOrderedListByApi", LocationMonitorConst.INFO, "curUserId", "updateMultiChorusInfo", "musicList", "handlePreDownloadMusicList", "updateSelected", "updateFavorite", "updateSearchListState", "isAnchor", "isLinkModeGuest", "logPlayAllSongSuccess", "", "roomId", "joinChorus", "slideRooms", "realJumpToChorusRoom", "initData", "mId", "deleteSelfDownloadMusicById", "inSelfDownloadMusicById", "Lvlc/d;", "getMsgManager", "Ltd2/b;", "data", "updateOrderSongExtraInfo", "tryApplyLink", "needToast", "fromTurnNext", "removeMusic", "(Lcom/bytedance/android/livesdk/message/model/MusicPanel;ZLjava/lang/Boolean;)V", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;", "getOrderedSongDataContext", "getAddSongSource", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/android/live/liveinteract/banner/LabelBannerUrl;", "observer", "observeSecondLevelTabBanner", "", "getLabelBannerMap", "", "firstLevelTabDataValue", "syncSecondLevelTabBanner", "fromRoomCreate", "getOrderedSongList", "findLocalPath", "shouldFillLocalPath", "updateCurrentTabData", "updateMusicPanelState", "owner", "observeCurFavoriteMusic", "observeCurOrderedMusic", "paused", "togglePause", "cutMusic", "pinMusic", "stopWifiDownload", "beginWifiDownload", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "Lcom/bytedance/android/live/ktv/common/music/control/b;", "addNode", "addSong", "Lcom/bytedance/android/live/ktv/common/karaokestation/model/d;", "firstLevelTabData", "postSyncTabListData", "getForceUpdateBannerState", BaseCoreViewModel.CORE_TAG_STATE, "setForceUpdateBannerState", "hasMore", "isLoadMore", "Lcom/bytedance/android/live/ktv/common/karaokestation/model/FirstLevelTab;", "firstLevelTab", "tabName", "", "businessList", "updateSecondLevelTabDataList", "updateSecondTabInfoMap", "postSyncSongListData", "Ltlc/d;", "onMessage", "hasReceiveSongListChangeMessage", "Lic0/a;", "favoriteCallback", "addFavorite", "delFavorite", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "requestCallback", "syncSungSongList", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "tabDescription", "trans2MusicPanel", "onCleared", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "onLoad", "syncHighScoreSongList", "Landroidx/lifecycle/MutableLiveData;", "Lvb0/a;", "getOrderSongUiState", "canSelectMore", "addSongLimitNum", "kotlin.jvm.PlatformType", "getCantSelectMoreToast", "getAddSongLimitNum", "checkMidiDataInRecentlyLabel", "isAudienceEnableSing", "unSelectedMusicList", "orderPlayAllSong", "newRoomId", "moveOrderedSongToOtherRoom", "observeSungOrderCount", "getSungOrderCount", "()Ljava/lang/Integer;", "getOrderSongExtraInfo", "getWantSingSongThreshold", "getCurSortType", "sortType", "sortSecondLevelTabByType", "jumpToChorusRoom", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "secondTabInfoMap", "Ljava/util/Map;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter$delegate", "Lkotlin/Lazy;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "curFavoriteMusic", "Landroidx/lifecycle/MutableLiveData;", "curOrderedMusic", "linkWaitingOrderedSongList", "Ljava/util/List;", "isApplying", "Z", "()Z", "setApplying", "(Z)V", "isOpenLinkmic", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseOrderSongViewModel$c;", "sungSongData", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseOrderSongViewModel$c;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseOrderSongViewModel$d;", "wantSingData", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseOrderSongViewModel$d;", "isRequestOrderedSongList", "recentlyMusicListBySingTime", "getRecentlyMusicListBySingTime", "()Ljava/util/List;", "setRecentlyMusicListBySingTime", "(Ljava/util/List;)V", "currentSortType", "Ljava/lang/String;", "getCurrentSortType", "()Ljava/lang/String;", "setCurrentSortType", "(Ljava/lang/String;)V", "mOrderSongUiState", "getMOrderSongUiState", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room$delegate", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "labelBanner", "getLabelBanner", "mOrderSongExtraInfo", "Ltd2/b;", "getMOrderSongExtraInfo", "()Ltd2/b;", "setMOrderSongExtraInfo", "(Ltd2/b;)V", "selfDownloadList", "getSelfDownloadList", "selfSelectedList", "getSelfSelectedList", "Ljava/lang/ref/WeakReference;", "contextForCheckPermission", "Ljava/lang/ref/WeakReference;", "getContextForCheckPermission", "()Ljava/lang/ref/WeakReference;", "setContextForCheckPermission", "(Ljava/lang/ref/WeakReference;)V", "", "downloadedInWifi", "Ljava/util/Set;", "getDownloadedInWifi", "()Ljava/util/Set;", "selectSongFromRecord", "getSelectSongFromRecord", "setSelectSongFromRecord", "isAnchor$delegate", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "linkPlayerWaitingDisposable", "Lio/reactivex/disposables/Disposable;", "linkPlayerWaitingObserverTime", "J", "getLinkPlayerWaitingObserverTime", "()J", "Lcom/bytedance/android/live/ktv/common/music/download/t;", "lrcCacheFactory$delegate", "getLrcCacheFactory", "()Lcom/bytedance/android/live/ktv/common/music/download/t;", "lrcCacheFactory", "Lcom/bytedance/android/live/ktv/common/music/download/a;", "accompanimentTrackFactory$delegate", "getAccompanimentTrackFactory", "()Lcom/bytedance/android/live/ktv/common/music/download/a;", "accompanimentTrackFactory", "Lcom/bytedance/android/live/ktv/common/music/download/d;", "fullTrackCacheFactory$delegate", "getFullTrackCacheFactory", "()Lcom/bytedance/android/live/ktv/common/music/download/d;", "fullTrackCacheFactory", "Lcom/bytedance/android/live/ktv/common/music/download/u;", "midiCacheFactory$delegate", "getMidiCacheFactory", "()Lcom/bytedance/android/live/ktv/common/music/download/u;", "midiCacheFactory", "Lcom/bytedance/android/live/ktv/common/music/download/y;", "videoFactory$delegate", "getVideoFactory", "()Lcom/bytedance/android/live/ktv/common/music/download/y;", "videoFactory", "midiFactory$delegate", "getMidiFactory", "midiFactory", "Lcom/bytedance/android/live/ktv/common/music/download/z;", "vocalCacheFactory$delegate", "getVocalCacheFactory", "()Lcom/bytedance/android/live/ktv/common/music/download/z;", "vocalCacheFactory", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseOrderSongViewModel$KSongNodeProcessCallback;", "nodeProcessCallback", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseOrderSongViewModel$KSongNodeProcessCallback;", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "linkStateObserver", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "linkInRoomObserver", "forceUpdateBanner", "lastOperationTime", "Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/b;", "commonOrderSongViewModel", "Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/b;", "getCommonOrderSongViewModel", "()Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/b;", "Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "commonSearchViewModel", "Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "getCommonSearchViewModel", "()Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "mOrderedSongDataContext", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;", "getMOrderedSongDataContext", "()Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;", "Lcom/bytedance/android/livesdk/ktvimpl/base/util/e;", "getKtvRoomStrategy", "()Lcom/bytedance/android/livesdk/ktvimpl/base/util/e;", "ktvRoomStrategy", "<init>", "(Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/b;Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;)V", "Companion", "a", "b", "KSongNodeProcessCallback", "c", "d", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseOrderSongViewModel extends ViewModel implements vlc.l, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d, LifecycleOwnerCompat {
    public static final a Companion = null;
    public static final String LIVE_KTV_PROCESS_RESUME_MESSAGE_ROOM_ID = "live_ktv_process_resume_message_room_id";
    public static final String TAG = "BaseOrderSongViewModel";
    private final Lazy accompanimentTrackFactory$delegate;
    private final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b commonOrderSongViewModel;
    private final com.bytedance.android.live.ktv.common.search.viewmodel.a commonSearchViewModel;
    private final CompositeDisposable compositeDisposable;
    private WeakReference<Context> contextForCheckPermission;
    private final MutableLiveData<MusicPanel> curFavoriteMusic;
    private final MutableLiveData<MusicPanel> curOrderedMusic;
    private String currentSortType;
    private final Lazy dataCenter$delegate;
    private final Set<Long> downloadedInWifi;
    private boolean forceUpdateBanner;
    private final Lazy fullTrackCacheFactory$delegate;
    private boolean hasReceiveSongListChangeMessage;
    private final Lazy isAnchor$delegate;
    private boolean isApplying;
    private boolean isOpenLinkmic;
    private boolean isRequestOrderedSongList;
    private final MutableLiveData<Map<String, LabelBannerUrl>> labelBanner;
    private long lastOperationTime;
    private final LifecycleRegistry lifecycleRegistry;
    private final Observer<Boolean> linkInRoomObserver;
    private Disposable linkPlayerWaitingDisposable;
    private final long linkPlayerWaitingObserverTime;
    private final Observer<Integer> linkStateObserver;
    private final List<MusicPanel> linkWaitingOrderedSongList;
    private final Lazy lrcCacheFactory$delegate;
    private td2.b mOrderSongExtraInfo;
    private final MutableLiveData<vb0.a> mOrderSongUiState;
    private final OrderedSongDataContext mOrderedSongDataContext;
    private final Lazy midiCacheFactory$delegate;
    private final Lazy midiFactory$delegate;
    private final KSongNodeProcessCallback nodeProcessCallback;
    private List<MusicPanel> recentlyMusicListBySingTime;
    private final Lazy room$delegate;
    private final Map<String, String> secondTabInfoMap;
    private String selectSongFromRecord;
    private final List<MusicPanel> selfDownloadList;
    private final List<MusicPanel> selfSelectedList;
    private final c sungSongData;
    private final Lazy videoFactory$delegate;
    private final Lazy vocalCacheFactory$delegate;
    private final d wantSingData;

    public final class KSongNodeProcessCallback implements IMusicControlNode.a {
        public final /* synthetic */ BaseOrderSongViewModel a;

        public KSongNodeProcessCallback(BaseOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void a(IMusicControlNode.b r28) {
            Intrinsics.checkNotNullParameter(r28, "result");
            if (com.bytedance.android.livesdk.ktvimpl.base.karaokestation.b.b[r28.getType().ordinal()] != 1) goto L143;
            MusicPanel r1 = r28.b;
            this.a.tryApplyLink(r1);
            IBaseUser r2 = jc1.k.n(IMiddlewareUserService.class).user().b();
            KtvMusic r4 = r1.a;
            OrderInfo r5 = new OrderInfo();
            InteractiveSongUserInfo r6 = new InteractiveSongUserInfo();
            r6.setIdString(r2.getIdString());
            r6.setNickNameFlex(r2.getNickName());
            r6.setAvatarThumbFlex(r2.getAvatarThumbKt());
            Unit r3 = Unit.INSTANCE;
            r5.setTopUser(r6);
            r4.setOrderInfo(r5);
            String r7 = r1.a.getAddSongSource();
            if (r7 != null) goto L8;
        L11:
            boolean r8 = true;
        L12:
            if (r8 == false) goto L14;
            r1.a.setAddSongSource(this.a.getAddSongSource(r1));
        L14:
            String r9 = "onMusicControlProcessSuccess, panel=" + r1 + ", selfDownloadList=" + this.a.getSelfDownloadList();
            ALogger.i(bb0.b.b(), r9 + ", invoke class :" + KSongNodeProcessCallback.class.getSimpleName());
            this.a.getSelfSelectedList().add(r1);
            CollectionsKt.removeAll(this.a.getSelfDownloadList(), BaseOrderSongViewModel$KSongNodeProcessCallback$onMusicControlProcessSuccess$2.INSTANCE);
            BaseOrderSongViewModel.access$getCurOrderedMusic$p(this.a).setValue(r1);
            String r10 = com.bytedance.android.live.ktv.common.util.a.b(r1.a);
            if (r10.length() != 0) goto L17;
            boolean r11 = true;
        L18:
            if (r11 == false) goto L20;
            HashMap r12 = null;
        L21:
            Map r13 = r1.j;
            if (r13 == null) goto L24;
            Object r14 = r13.get("to_user_id");
        L26:
            if ((r14 instanceof String) == true) goto L28;
            r14 = null;
        L28:
            String r15 = (String) r14;
            Map r16 = r1.j;
            if (r16 == null) goto L31;
            Object r17 = r16.get("request_type");
        L33:
            if ((r17 instanceof String) == true) goto L35;
            r17 = null;
        L35:
            String r18 = (String) r17;
            Map r19 = r1.j;
            if (r19 == null) goto L38;
            Object r110 = r19.get("enter_from");
        L40:
            if ((r110 instanceof String) == true) goto L42;
            r110 = null;
        L42:
            String r111 = (String) r110;
            if (Intrinsics.areEqual(jc1.k.n(IMiddlewareUserService.class).user().n().toString().toString(), r15) == false) goto L45;
            String r112 = "oneself";
        L46:
            Long r113 = KtvLoggerHelper.a;
            String r114 = r1.d;
            if (r111 != null) goto L49;
            r111 = this.a.getSelectSongFromRecord();
        L49:
            if (r111 != null) goto L55;
            td2.b r115 = this.a.getMOrderSongExtraInfo();
            if (r115 == null) goto L53;
            r111 = r115.a;
            goto L55
        L53:
            r111 = null;
        L55:
            if (r111 != null) goto L57;
            r111 = "";
        L57:
            String r116 = com.bytedance.android.live.ktv.common.util.j.g();
            String r20 = r1.a.getMTitle();
            if (r20 != null) goto L60;
            r20 = "";
        L60:
            long r117 = r1.a.getMId();
            boolean r21 = r1.t;
            String r22 = r1.b();
            String r0 = r1.a.getMAuthor();
            if (r0 != null) goto L63;
            r0 = "";
            String r118 = r0;
        L64:
            List r119 = r1.a.getTags();
            if (r119 != null) goto L67;
        L69:
            boolean r23 = false;
        L70:
            KtvContext.Companion.getClass();
            oe2.b r120 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
            if (r120 == null) goto L73;
            String r121 = r120.c();
        L74:
            oe2.b r24 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
            if (r24 == null) goto L77;
            String r25 = r24.a();
        L79:
            if (Intrinsics.areEqual(r1.d, "search") == false) goto L81;
            Integer r26 = r1.x;
        L82:
            KtvMusic r27 = r1.a;
            if (r27 == null) goto L91;
            String r29 = r27.getMidiUrl();
            if (r29 == null) goto L91;
            if (r29.length() <= 0) goto L89;
            boolean r30 = true;
        L90:
            Boolean r31 = Boolean.valueOf(r30);
        L92:
            PersonalSongInfo r122 = r1.a.getPersonalSongInfo();
            Boolean r210 = r31;
            String r211 = r25;
            if (r122 == null) goto L95;
            Integer r32 = Integer.valueOf((int) r122.getMidiScore());
        L96:
            Intrinsics.checkNotNullParameter(r114, "fromRequestType");
            Intrinsics.checkNotNullParameter(r111, "enterFrom");
            Intrinsics.checkNotNullParameter(r116, "userType");
            Intrinsics.checkNotNullParameter(r20, "songName");
            Intrinsics.checkNotNullParameter(r22, "artistId");
            Intrinsics.checkNotNullParameter(r0, "artistName");
            if (r12 != null) goto L99;
            r12 = new HashMap();
        L99:
            r12.put("from_request_type", r114);
            r12.put("enter_from", r111);
            r12.put("user_type", r116);
            r12.put("song_name", r20);
            r12.put("function_type", KtvLoggerHelper.H(com.bytedance.android.live.ktv.common.util.j.c()));
            r12.put("song_id", String.valueOf(r117));
            String r33 = BDLocationException.ERROR_TIMEOUT;
            r12.put("is_priority_sing", BDLocationException.ERROR_TIMEOUT);
            if (r21 == false) goto L102;
            Object r34 = "1";
        L103:
            r12.put("is_original", r34);
            if (r23 == false) goto L106;
            Object r35 = "1";
        L107:
            r12.put("is_original_flag", r35);
            r12.put("is_play_all", BDLocationException.ERROR_TIMEOUT);
            r12.put("artist_id", r22);
            r12.put("artist_name", r0);
            r12.put("is_sing_match", BDLocationException.ERROR_TIMEOUT);
            KtvLoggerHelper.m0(r12);
            KtvLoggerHelper.o0(r12);
            r12.put("function_type2", jc1.k.n(IInteractService.class).getFunctionType2());
            if (r121 == null) goto L110;
            r12.put("ksong_element_source", r121);
        L110:
            if (r211 == null) goto L112;
            r12.put("element_open_method", r211);
        L112:
            if (r26 == null) goto L114;
            r12.put("song_top_n", String.valueOf(r26.intValue()));
        L114:
            if (r210 != null) goto L116;
        L119:
            if (r32 == null) goto L121;
            r12.put("song_score", String.valueOf(r32.intValue()));
        L121:
            r12.put("to_user_type", r112);
            if (r15 == null) goto L124;
            r12.put("to_user_id", r15);
        L124:
            if (r18 == 0) goto L126;
            r12.put("request_type", r18);
        L126:
            com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r12);
            String r36 = r1.g();
            if (r36 != null) goto L129;
            r36 = r118;
        L129:
            com.bytedance.android.livesdk.ktvimpl.chorus.c.c(r12, r36);
            r12.put("midi_score", r118);
            KtvMusic r37 = r1.a;
            if (r37 == null) goto L136;
            PersonalSongInfo r38 = r37.getPersonalSongInfo();
            if (r38 == null) goto L136;
            double r39 = r38.getMidiScore();
            if (r39 <= 0) goto L136;
            r12.put("midi_score", String.valueOf(r39));
        L136:
            KtvLoggerHelper.n0(r12, r1);
            if (Intrinsics.areEqual(r114, "recommend") == false) goto L139;
        L140:
            ke2.d.a(r1, r12, true);
        L141:
            xe2.h.b(r12);
            r12.put("order_limit", xe2.h.f(xe2.h.c));
            r12.put("join_limit", xe2.h.f(xe2.h.d));
            j0.l().sendLog("livesdk_ksong_request_song_success", r12, new Object[]{IRoom.class, x.class});
            return;
        L139:
            if (Intrinsics.areEqual(r114, "推荐") == false) goto L141;
        L116:
            if (r210.booleanValue() == false) goto L118;
            r33 = "1";
        L118:
            r12.put("is_midi", r33);
            goto L119
        L106:
            r35 = BDLocationException.ERROR_TIMEOUT;
            goto L107
        L102:
            r34 = BDLocationException.ERROR_TIMEOUT;
            goto L103
        L95:
            r32 = null;
            goto L96
        L89:
            r30 = false;
        L91:
            r31 = null;
            goto L92
        L81:
            r26 = null;
            goto L82
        L77:
            r25 = null;
            goto L79
        L73:
            r121 = null;
            goto L74
        L67:
            if (r119.contains("原唱") != true) goto L69;
            r23 = true;
            goto L70
        L63:
            r118 = "";
            goto L64
        L45:
            r112 = "others";
            goto L46
        L38:
            r110 = null;
            goto L40
        L31:
            r17 = null;
            goto L33
        L24:
            r14 = null;
            goto L26
        L20:
            r12 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("song_type", r10)});
            goto L21
        L17:
            r11 = false;
            goto L18
        L8:
            if (r7.length() == 0) goto L11;
            r8 = false;
            goto L12
        }

        public final void b(IMusicControlNode.b r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            IMusicControlNode.OperationType r0 = r4.getType();
            if (com.bytedance.android.livesdk.ktvimpl.base.karaokestation.b.a[r0.ordinal()] != 1) goto L6;
            ALogger.i(bb0.b.b(), "onMusicControlProcessFail, invoke class :".concat(KSongNodeProcessCallback.class.getSimpleName()));
            CollectionsKt.removeAll(this.a.getSelfDownloadList(), BaseOrderSongViewModel$KSongNodeProcessCallback$onMusicControlProcessFail$1.INSTANCE);
            this.a.updateCurrentTabData();
        L6:
            KtvRoomContext.Companion.getClass();
            KtvRoomContext r1 = KtvRoomContext.a.a();
            if (r1 == null) goto L12;
            com.bytedance.live.datacontext.k<com.bytedance.android.live.ktv.common.model.bean.b> r2 = r1.getDownloadProcess();
            if (r2 == null) goto L13;
            r2.post(new com.bytedance.android.live.ktv.common.model.bean.b.a(r4.b));
            return;
        L13:
            return;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b implements p.a {
        public final void c(MusicPanel r1, int r2) {
        }

        public b() {
        }

        public final void a(MusicPanel r3, String r4, String r5) {
            StringBuilder r6 = new StringBuilder("wifiDownloadCallback ;; onSuccessed ;; musicId == ");
            if (r3 == null) goto L7;
            KtvMusic r7 = r3.a;
            if (r7 == null) goto L7;
            Long r8 = Long.valueOf(r7.getMId());
        L8:
            r6.append(r8);
            ALogger.i(BaseOrderSongViewModel.TAG, r6.toString());
            return;
        L7:
            r8 = null;
            goto L8
        }

        public final void b(MusicPanel r4, int r5, String r6) {
            Intrinsics.checkNotNullParameter(r6, "errorMsg");
            StringBuilder r0 = new StringBuilder("wifiDownloadCallback ;; onFailed ;; musicId == ");
            if (r4 == null) goto L7;
            KtvMusic r7 = r4.a;
            if (r7 == null) goto L7;
            Long r8 = Long.valueOf(r7.getMId());
        L8:
            r0.append(r8);
            r0.append(" ;; errorCode ;; ");
            r0.append(r5);
            r0.append(" ;; errorMsg == ");
            r0.append(r6);
            ALogger.i(BaseOrderSongViewModel.TAG, r0.toString());
            return;
        L7:
            r8 = null;
            goto L8
        }
    }

    public final class c {
        public boolean a;
        public String b;
        public final MutableLiveData<Integer> c;

        public c() {
            this.c = new MutableLiveData();
        }
    }

    public final class d {
        public long a;

        public d() {
            this.a = -1;
        }
    }

    public static final class e implements rj0.b {
        public final /* synthetic */ BaseOrderSongViewModel a;
        public final /* synthetic */ com.bytedance.android.live.ktv.common.music.control.b b;
        public final /* synthetic */ MusicPanel c;
        public final /* synthetic */ Context d;

        public final void onSuccess() {
            BaseOrderSongViewModel r0 = this.a;
            td2.b r1 = r0.getMOrderSongExtraInfo();
            String r2 = null;
            if (r1 == null) goto L5;
            String r3 = r1.a;
        L6:
            r0.setSelectSongFromRecord(r3);
            MusicPanel r4 = ((com.bytedance.android.live.ktv.common.music.control.d) this.b).d;
            Iterator<MusicPanel> r5 = this.a.getSelfDownloadList().iterator();
        L7:
            boolean r6 = true;
            if (r5.hasNext() == false) goto L12;
            if (r5.next().a.getMId() != r4.a.getMId()) goto L7;
            boolean r7 = true;
        L13:
            Iterator<MusicPanel> r8 = this.a.getSelfSelectedList().iterator();
        L15:
            if (r8.hasNext() == false) goto L19;
            if (r8.next().a.getMId() != r4.a.getMId()) goto L15;
        L20:
            StringBuilder r9 = new StringBuilder("addSong ;; isSameMusic: ");
            r9.append(r6);
            r9.append(", songId: ");
            r9.append(r4.a.getMId());
            r9.append(", title: ");
            KtvMusic r10 = r4.a;
            if (r10 == null) goto L23;
            r2 = r10.getMTitle();
        L23:
            r9.append(r2);
            ALogger.i(BaseOrderSongViewModel.TAG, r9.toString());
            if (r6 == false) goto L28;
            pd2.d r11 = pd2.d.n;
            MusicPanel r12 = this.c;
            r11.getClass();
            pd2.d.s(r12, pd2.d.h);
            return;
        L28:
            if (this.a.canSelectMore() == true) goto L30;
            return;
        L30:
            this.a.getSelfDownloadList().add(r4);
            this.a.setContextForCheckPermission(new WeakReference(this.d));
            com.bytedance.android.live.ktv.common.music.control.b r13 = this.b;
            Context r14 = this.d;
            td2.b r15 = this.a.getMOrderSongExtraInfo();
            if (r15 == null) goto L34;
            String r16 = r15.a;
            if (r16 == null) goto L34;
        L35:
            com.bytedance.android.live.ktv.common.music.control.b.e(r13, r14, r16, this.a.getAddSongSource(((com.bytedance.android.live.ktv.common.music.control.d) this.b).d), false, 20);
            mb0.d.g("permission_go", this.c);
            Lazy r17 = KtvMusicControlManager.d;
            KtvMusicControlManager r18 = KtvMusicControlManager.a.a();
            com.bytedance.android.live.ktv.common.music.control.b r19 = this.b;
            KSongNodeProcessCallback r20 = BaseOrderSongViewModel.access$getNodeProcessCallback$p(this.a);
            r18.getClass();
            Intrinsics.checkNotNullParameter(r19, "node");
            if (r20 == null) goto L38;
            r18.g(r19, r20);
        L38:
            r18.b.b(r19);
            Function1 r21 = r18.c;
            if (r21 == null) goto L48;
            Unit r22 = (Unit) r21.invoke(r19);
            return;
        L48:
            return;
        L34:
            r16 = "bottom";
            goto L35
        L19:
            r6 = r7;
            goto L20
        L12:
            r7 = false;
            goto L13
        L5:
            r3 = null;
            goto L6
        }

        public final void onFailed(Exception r5) {
            StringBuilder r6 = new StringBuilder("addSong ;; onFailed, songId: ");
            com.bytedance.android.live.ktv.common.music.control.b r0 = this.b;
            if (r0 == null) goto L9;
            MusicPanel r1 = ((com.bytedance.android.live.ktv.common.music.control.d) r0).d;
            if (r1 == null) goto L9;
            KtvMusic r2 = r1.a;
            if (r2 == null) goto L9;
            Long r3 = Long.valueOf(r2.getMId());
        L10:
            r6.append(r3.longValue());
            r6.append(", title: ");
            com.bytedance.android.live.ktv.common.music.control.b r4 = this.b;
            if (r4 == null) goto L17;
            MusicPanel r7 = ((com.bytedance.android.live.ktv.common.music.control.d) r4).d;
            if (r7 == null) goto L17;
            KtvMusic r8 = r7.a;
            if (r8 == null) goto L17;
            String r9 = r8.getMTitle();
        L18:
            r6.append(r9);
            ALogger.i(BaseOrderSongViewModel.TAG, r6.toString());
            MusicPanel r10 = ((com.bytedance.android.live.ktv.common.music.control.d) this.b).d;
            pd2.d.n.b("choose_check_permission_fail", r10, null);
            r10.b = 1;
            this.a.updateCurrentTabData();
            KtvRoomContext.Companion.getClass();
            KtvRoomContext r11 = KtvRoomContext.a.a();
            if (r11 == null) goto L23;
            com.bytedance.live.datacontext.k<com.bytedance.android.live.ktv.common.model.bean.b> r12 = r11.getDownloadProcess();
            if (r12 == null) goto L23;
            r12.post(new com.bytedance.android.live.ktv.common.model.bean.b.a(((com.bytedance.android.live.ktv.common.music.control.d) this.b).d));
        L23:
            this.a.setSelectSongFromRecord(null);
            return;
        L17:
            r9 = null;
        L9:
            r3 = null;
            goto L10
        }

        public e(BaseOrderSongViewModel r1, com.bytedance.android.live.ktv.common.music.control.b r2, MusicPanel r3, Context r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ BaseOrderSongViewModel a;

        public f(BaseOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r13) {
            Long r14 = (Long) r13;
            if (hd0.c.f().g() == false) goto L32;
            OrderedSongDataContext r15 = this.a.getMOrderedSongDataContext();
            if (r15 == null) goto L7;
            List<SongUniqueInfo> r16 = r15.m201getKtvSongUniqueInfoList();
        L8:
            Iterator<T> r2 = BaseOrderSongViewModel.access$getLinkWaitingOrderedSongList$p(this.a).iterator();
        L10:
            if (r2.hasNext() == false) goto L30;
            MusicPanel r3 = (MusicPanel) r2.next();
            boolean r4 = true;
            if (r16 == null) goto L24;
            Iterator<T> r5 = r16.iterator();
        L15:
            if (r5.hasNext() == false) goto L22;
            T r6 = r5.next();
            if (((SongUniqueInfo) r6).getSongId() != r3.a.getMId()) goto L19;
            boolean r7 = true;
        L20:
            if (r7 == false) goto L15;
        L23:
            SongUniqueInfo r8 = (SongUniqueInfo) r6;
        L25:
            if (r8 != null) goto L28;
            r4 = false;
        L28:
            if (r4 == false) goto L10;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d.a.b(this.a, r3, null, 4);
            goto L10
        L19:
            r7 = false;
            goto L20
        L22:
            r6 = null;
            goto L23
        L24:
            r8 = null;
            goto L25
        L30:
            BaseOrderSongViewModel.access$getLinkWaitingOrderedSongList$p(this.a).clear();
            return;
        L7:
            r16 = null;
            goto L8
        L32:
            if (this.a.isAnchor() == true) goto L37;
            if (hd0.c.f().j() == false) goto L37;
            this.a.getOrderedSongList(false);
            return;
        L37:
            if (this.a.isAnchor() == false) goto L39;
            return;
        L39:
            if (hd0.c.f().h() == false) goto L55;
            BaseOrderSongViewModel.access$getLinkWaitingOrderedSongList$p(this.a).clear();
            return;
        }
    }

    public static final class g implements p.a {
        public final /* synthetic */ BaseOrderSongViewModel a;

        public final void c(MusicPanel r1, int r2) {
        }

        public g(BaseOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void a(MusicPanel r1, String r2, String r3) {
            ALogger.i(BaseOrderSongViewModel.TAG, "handleDownloadMusicList download onSuccessed.");
            if (r1 != null) goto L5;
            return;
        L5:
            BaseOrderSongViewModel.access$logPlayAllSongSuccess(this.a, r1);
        }

        public final void b(MusicPanel r8, int r9, String r10) {
            ALogger.i(BaseOrderSongViewModel.TAG, "handleDownloadMusicList download onFailed.");
            if (r8 != null) goto L5;
            return;
        L5:
            String r11 = r8.d;
            if (r11 != null) goto L8;
            r11 = "hot";
        L8:
            Long r12 = KtvLoggerHelper.a;
            String r13 = this.a.getRoom().getOwnerUserIdString();
            long r0 = this.a.getRoom().getId();
            String r2 = String.valueOf(r8.a.getMId());
            String r14 = r8.a.getMTitle();
            if (r14 != null) goto L11;
            r14 = "";
        L11:
            Intrinsics.checkNotNullParameter(r13, "anchorId");
            Intrinsics.checkNotNullParameter("music", "playMode");
            Intrinsics.checkNotNullParameter(r11, "fromRequestType");
            Intrinsics.checkNotNullParameter(r2, "songId");
            Intrinsics.checkNotNullParameter(r14, "songName");
            HashMap r4 = new HashMap(2);
            KtvLoggerHelper.A(r4);
            r4.put("user_type", KtvLoggerHelper.I());
            r4.put("live_type", KtvLoggerHelper.F());
            r4.put("anchor_id", r13);
            r4.put("room_id", String.valueOf(r0));
            r4.put("play_mode", "music");
            r4.put("song_id", r2);
            r4.put("song_name", r14);
            r4.put("from_request_type", r11);
            r4.put("is_play_all", "1");
            j0.l().sendLog("livesdk_ksong_request_song_failed", r4, new Object[]{IRoom.class});
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ BaseOrderSongViewModel a;

        public h(BaseOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BaseOrderSongViewModel r0 = this.a;
            BaseOrderSongViewModel.access$handleSongListChange(r0, (List) r2);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ BaseOrderSongViewModel a;

        public i(BaseOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            List r12 = (List) r11;
            Iterator<MusicPanel> r0 = this.a.getSelfSelectedList().iterator();
        L4:
            if (r0.hasNext() == false) goto L19;
            KtvMusic r1 = r0.next().a;
            Iterator<T> r2 = r12.iterator();
        L7:
            if (r2.hasNext() == false) goto L16;
            T r3 = r2.next();
            SongUniqueInfo r4 = (SongUniqueInfo) r3;
            if (r1.getMId() == r4.getSongId()) goto L11;
        L13:
            boolean r5 = false;
        L14:
            if (r5 == false) goto L7;
        L17:
            if (r3 != null) goto L4;
            r0.remove();
            goto L4
        L11:
            if (Intrinsics.areEqual(r1.getOrderUserIdString(), r4.getUserId()) == false) goto L13;
            r5 = true;
            goto L14
        L16:
            r3 = null;
            goto L17
        L19:
            this.a.updateCurrentTabData();
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ BaseOrderSongViewModel a;

        public j(BaseOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            v r6 = (v) r5;
            BaseOrderSongViewModel r0 = this.a;
            Context r1 = r6.getContext();
            com.bytedance.android.live.ktv.common.music.control.b r7 = r6.b;
            r0.addSong(r1, ((com.bytedance.android.live.ktv.common.music.control.d) r7).d, null, r7);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel$jumpToChorusRoom$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        final /* synthetic */ MusicPanel $musicPanel;
        final /* synthetic */ BaseOrderSongViewModel this$0;

        public AnonymousClass4(BaseOrderSongViewModel r1, MusicPanel r2) {
            this.this$0 = r1;
            this.$musicPanel = r2;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m38invoke() {
            BaseOrderSongViewModel$jumpToChorusRoom$4$disconnectCallback$1 r0 = new BaseOrderSongViewModel$jumpToChorusRoom$4$disconnectCallback$1(this);
            IInteractService r1 = jc1.k.f(IInteractService.class);
            if (r1 == null) goto L6;
            r1.guestDisconnect(200, r0);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m38invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ BaseOrderSongViewModel a;

        public k(BaseOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            ALogger.i(BaseOrderSongViewModel.TAG, "link in room change, state == " + r4);
            BaseOrderSongViewModel.access$setOpenLinkmic$p(this.a, Intrinsics.areEqual(r4, Boolean.TRUE));
        }
    }

    public static final class l<T> implements Observer {
        public final /* synthetic */ BaseOrderSongViewModel a;

        public l(BaseOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 != null) goto L6;
        L7:
            if (r5 != null) goto L10;
        L12:
            this.a.setApplying(true);
            return;
        L10:
            if (r5.intValue() != 0) goto L12;
        L13:
            ALogger.i(BaseOrderSongViewModel.TAG, "linkState change. state=" + r5);
            if (((Boolean) vm2.h.J0.getValue(null, vm2.h.a[86])).booleanValue() == false) goto L17;
            BaseOrderSongViewModel.access$setForceUpdateBanner$p(this.a, true);
            this.a.syncSecondLevelTabBanner(FirstLevelTab.OrderSongTab.getValue());
        L17:
            if (BaseOrderSongViewModel.access$isOpenLinkmic$p(this.a) == false) goto L19;
            BaseOrderSongViewModel.access$setOpenLinkmic$p(this.a, false);
            return;
        L19:
            this.a.setApplying(false);
            return;
        L6:
            if (r5.intValue() == 2) goto L13;
            goto L7
        }
    }

    public static final class m<T> implements Comparator {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r4, Object r5) {
            MusicPanel r6 = (MusicPanel) r4;
            PersonalSongInfo r7 = ((MusicPanel) r5).a.getPersonalSongInfo();
            if (r7 == null) goto L5;
            Number r8 = Double.valueOf(r7.getMidiScore());
        L6:
            double r1 = r8.doubleValue();
            PersonalSongInfo r9 = r6.a.getPersonalSongInfo();
            if (r9 == null) goto L9;
            Number r10 = Double.valueOf(r9.getMidiScore());
        L10:
            double r2 = r1 - r10.doubleValue();
            double r11 = 0.0f;
            if (r2 <= r11) goto L14;
            return 1;
        L14:
            if (r2 >= r11) goto L16;
            return -1;
        L16:
            return 0;
        L9:
            r10 = Float.valueOf(0.0f);
            goto L10
        L5:
            r8 = Float.valueOf(0.0f);
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    private final com.bytedance.android.live.ktv.common.music.download.a getAccompanimentTrackFactory() {
        return (com.bytedance.android.live.ktv.common.music.download.a) this.accompanimentTrackFactory$delegate.getValue();
    }

    private final com.bytedance.android.live.ktv.common.music.download.d getFullTrackCacheFactory() {
        return (com.bytedance.android.live.ktv.common.music.download.d) this.fullTrackCacheFactory$delegate.getValue();
    }

    private final t getLrcCacheFactory() {
        return (t) this.lrcCacheFactory$delegate.getValue();
    }

    private final u getMidiCacheFactory() {
        return (u) this.midiCacheFactory$delegate.getValue();
    }

    private final u getMidiFactory() {
        return (u) this.midiFactory$delegate.getValue();
    }

    private final y getVideoFactory() {
        return (y) this.videoFactory$delegate.getValue();
    }

    private final z getVocalCacheFactory() {
        return (z) this.vocalCacheFactory$delegate.getValue();
    }

    private final void showFrequencyControlPrompt() {
        f2.b(2131918474, 0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void clearSelectedSongList() {
    }

    public final DataCenter getDataCenter() {
        return (DataCenter) this.dataCenter$delegate.getValue();
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public abstract /* synthetic */ ModeType getModeType();

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public String getRequiredSongInfo() {
        return "";
    }

    public final IRoom getRoom() {
        return (IRoom) this.room$delegate.getValue();
    }

    public final boolean isAnchor() {
        return ((Boolean) this.isAnchor$delegate.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public boolean isOnlyAcceptFollowerApply() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void onDialogDismiss() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void onSearchEnter() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void onSearchExit() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void onSearchReset() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void removeWantSingSong(KtvMusic r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void syncMineWantSingSongList(boolean r1, Function1<? super Boolean, Unit> r2) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void syncMultiChorusWaitingList(boolean r1, Function1<? super Boolean, Unit> r2) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void syncSongWaitingList(boolean r1, Function1<? super Boolean, Unit> r2) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void syncWantListenSongList(boolean r1, Function1<? super Boolean, Unit> r2) {
    }

    private final void cancelLinkWaitingStateSubscribleIfNeed() {
        Disposable r0 = this.linkPlayerWaitingDisposable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        r0.dispose();
        return;
    }

    private final MusicPanel firstSelectedMusicOrNull() {
        ChorusContext.a r0 = ChorusContext.Companion;
        Object r2 = null;
        if (r0.c() == false) goto L17;
        ChorusContext r1 = r0.getContext();
        if (r1 == null) goto L24;
        n<List<MusicPanel>> r3 = r1.getChorusSelectedSongList();
        if (r3 == null) goto L25;
        List r4 = (List) r3.getValue();
        if (r4 == null) goto L26;
        Iterator r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L27;
        Object r6 = r5.next();
        if ((!((MusicPanel) r6).e) == false) goto L12;
        r2 = r6;
    L27:
        return (MusicPanel) r2;
    L26:
        return null;
    L25:
        return null;
    L24:
        return null;
    L17:
        OrderedSongDataContext r7 = this.mOrderedSongDataContext;
        if (r7 != null) goto L20;
        return null;
    L20:
        return r7.getKtvPublicFirstOrderedSong();
    }

    private final boolean hasSelectedPlayList() {
        td2.b r0 = this.mOrderSongExtraInfo;
        String r1 = null;
        if (r0 == null) goto L7;
        WeakReference<Context> r2 = r0.b;
        if (r2 == null) goto L7;
        Context r3 = r2.get();
    L8:
        int r4 = KSongOrderSongUtilKt.a;
        Intrinsics.checkNotNullParameter("KSongOrderSongDialog", "dialogTag");
        FragmentActivity r5 = ContextUtil.contextToFragmentActivity(r3);
        if (r5 == null) goto L21;
        FragmentManager r6 = r5.getSupportFragmentManager();
        if (r6 == null) goto L21;
        Fragment r7 = r6.findFragmentByTag("KSongOrderSongDialog");
        if ((r7 instanceof DialogFragment) == true) goto L16;
        r7 = null;
    L16:
        DialogFragment r8 = (DialogFragment) r7;
        if (r8 == null) goto L21;
        if (r8.isVisible() != true) goto L21;
        boolean r9 = true;
    L22:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r10 = this.commonOrderSongViewModel;
        if (r10 == null) goto L29;
        Pair r11 = r10.getSelectedFirstLevelTabValue();
        if (r11 == null) goto L29;
        Integer r12 = (Integer) r11.getFirst();
        if (r12 == null) goto L29;
        int r13 = r12.intValue();
    L30:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r14 = this.commonOrderSongViewModel;
        if (r14 == null) goto L35;
        com.bytedance.android.live.ktv.common.karaokestation.model.y r15 = r14.getSelectedSecondLevelTabData(r13);
        if (r15 == null) goto L35;
        r1 = r15.c;
    L35:
        boolean r16 = Intrinsics.areEqual(r1, "play_list");
        ALogger.i(TAG, "hasSelectedPlayList ;; isDialogOpen == " + r9 + " ;; isSelectedPlayList == " + r16);
        if (r9 == false) goto L40;
        if (r16 == false) goto L41;
        return true;
    L41:
        return false;
    L40:
        return false;
    L29:
        r13 = FirstLevelTab.Unknown.getValue();
    L21:
        r9 = false;
    L7:
        r3 = null;
        goto L8
    }

    private final boolean isAdmin() {
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L9;
        if (r1.c() != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final KtvRoomLyricsStateMachineConfig.d obtainSingState() {
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurState();
    }

    private final void updateSearchListState() {
        com.bytedance.android.live.ktv.common.search.viewmodel.a r0 = this.commonSearchViewModel;
        if (r0 == null) goto L42;
        List r1 = r0.getSearchedMusicList();
        if (r1 == null) goto L54;
        HashMap r2 = new HashMap();
        OrderedSongDataContext r3 = this.mOrderedSongDataContext;
        if (r3 == null) goto L11;
        List<SongUniqueInfo> r4 = r3.getSelfKtvSongUniqueInfoList();
        if (r4 == null) goto L11;
    L12:
        Iterator<T> r5 = r4.iterator();
        int r6 = 0;
    L14:
        if (r5.hasNext() == false) goto L33;
        Object r7 = r5.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        SongUniqueInfo r9 = (SongUniqueInfo) r7;
        if (r6 != 0) goto L31;
        OrderedSongDataContext r10 = this.mOrderedSongDataContext;
        if (r10 == null) goto L27;
        MusicPanel r11 = r10.getKtvPublicFirstOrderedSong();
        if (r11 == null) goto L27;
        KtvMusic r12 = r11.a;
        if (r12 == null) goto L27;
        long r13 = r12.getMId();
    L29:
        if (r13 != r9.getSongId()) goto L31;
        r2.put(Long.valueOf(r9.getSongId()), 5);
    L32:
        r6 = r8;
    L27:
        r13 = -1;
    L31:
        r2.put(Long.valueOf(r9.getSongId()), 4);
        goto L32
    L33:
        Iterator r14 = r1.iterator();
    L35:
        if (r14.hasNext() == false) goto L55;
        MusicPanel r15 = (MusicPanel) r14.next();
        if (r2.containsKey(Long.valueOf(r15.a.getMId())) == true) goto L38;
        if (r15.b == 2) goto L35;
        r15.b = 1;
        goto L35
    L38:
        Object r16 = r2.get(Long.valueOf(r15.a.getMId()));
        Intrinsics.checkNotNull(r16);
        r15.b = ((Number) r16).intValue();
        goto L35
    L55:
        return;
    L11:
        r4 = new ArrayList();
        goto L12
    L54:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void cutMusic() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L7;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) KtvContext.a.g().getKtvSingerViewModel().getValue();
        if (r0 == null) goto L11;
        r0.cutMusic();
        return;
    L11:
        return;
    L7:
        MusicPanel r1 = firstSelectedMusicOrNull();
        if (r1 == null) goto L13;
        Lazy r2 = KtvMusicControlManager.d;
        KtvMusicControlManager.a.a().d(new CutMusicControlNode(r1, false, getModeType()), this.nodeProcessCallback);
        return;
    }

    public final com.bytedance.android.livesdk.ktvimpl.base.util.e getKtvRoomStrategy() {
        KtvContext.Companion.getClass();
        return (com.bytedance.android.livesdk.ktvimpl.base.util.e) KtvContext.a.g().getKtvRoomStrategy().getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public Map<String, LabelBannerUrl> getLabelBannerMap() {
        return (Map) this.labelBanner.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public Integer getSungOrderCount() {
        return (Integer) this.sungSongData.c.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public int getWantSingSongThreshold() {
        return (int) this.wantSingData.a;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void initData() {
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.STARTED);
        addMessageListenerIfNeed();
        OrderedSongDataContext r0 = this.mOrderedSongDataContext;
        if (r0 == null) goto L7;
        Disposable r1 = r0.observerKtvOrderedSongListChange(null, false, new h(this));
        if (r1 == null) goto L7;
        RxUtilKt.c(r1, this.compositeDisposable);
    L7:
        OrderedSongDataContext r2 = this.mOrderedSongDataContext;
        if (r2 == null) goto L12;
        Disposable r3 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r2, null, new i(this), 3);
        if (r3 == null) goto L12;
        RxUtilKt.c(r3, this.compositeDisposable);
    L12:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r4 = KtvRoomContext.a.a();
        if (r4 == null) goto L21;
        com.bytedance.live.datacontext.k<v> r5 = r4.getRequestDownloadMusic();
        if (r5 == null) goto L21;
        PublishSubject r6 = r5.onEvent();
        if (r6 == null) goto L21;
        Disposable r7 = r6.subscribe(new j(this));
        if (r7 == null) goto L21;
        RxUtilKt.c(r7, this.compositeDisposable);
    L21:
        hd0.c.f().c(this.linkStateObserver);
        tc0.c.h().c(this.linkInRoomObserver);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public boolean isAudienceEnableSing() {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L7;
        n<Boolean> r1 = r0.isAudienceEnableSing();
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L9:
        return Intrinsics.areEqual(r2, Boolean.TRUE);
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void stopWifiDownload() {
        com.bytedance.android.live.ktv.common.music.download.m r0 = KtvMusicManager.a;
        KtvMusicManager.h.f();
        KtvMusicManager.i.clear();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void updateCurrentTabData() {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.commonOrderSongViewModel;
        if (r0 == null) goto L16;
        Pair r1 = r0.getSelectedFirstLevelTabValue();
        if (r1 == null) goto L19;
        int r2 = ((Number) r1.component1()).intValue();
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3 = this.commonOrderSongViewModel;
        if (r3 == null) goto L17;
        com.bytedance.android.live.ktv.common.karaokestation.model.y r4 = r3.getSelectedSecondLevelTabData(r2);
        if (r4 == null) goto L20;
        updateTabData(r4);
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r5 = this.commonOrderSongViewModel;
        if (r5 == null) goto L18;
        r5.updateSongListData(r4);
        return;
    L18:
        return;
    L20:
        return;
    L17:
        return;
    L19:
        return;
    }

    private final void addMessageListenerIfNeed() {
        vlc.d r0 = getMsgManager();
        if (r0 == null) goto L5;
        r0.removeMessageListener(MessageType.LINK_MIC_AUDIENCE_KTV_MESSAGE.getIntType(), this);
    L5:
        if (r0 == null) goto L7;
        r0.addMessageListener(MessageType.LINK_MIC_AUDIENCE_KTV_MESSAGE.getIntType(), this);
    L7:
        boolean r1 = getRoom().getLinkMap().containsKey(String.valueOf(9));
        z5 r2 = getRoom().getLinkerDetail();
        if (r2 == null) goto L14;
        List<Long> r3 = r2.getPlayModes();
        if (r3 == null) goto L14;
        if (r3.contains(Long.valueOf(21)) != true) goto L14;
        boolean r4 = true;
    L16:
        if (isAnchor() == false) goto L36;
        if (r1 == true) goto L19;
        if (r4 == true) goto L19;
        return;
    L19:
        Boolean r5 = null;
        if ((r0 instanceof xlc.a) == true) goto L22;
        r0 = null;
    L22:
        xlc.a r6 = (xlc.a) r0;
        if (r6 == null) goto L38;
        DataCenter r7 = getDataCenter();
        if (r7 == null) goto L27;
        r5 = (Boolean) r7.get(LIVE_KTV_PROCESS_RESUME_MESSAGE_ROOM_ID, Boolean.FALSE);
    L27:
        Boolean r8 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r5, r8)) == false) goto L39;
        MessageType r9 = MessageType.LINK_MIC_AUDIENCE_KTV_MESSAGE;
        r6.y(r9.getIntType(), this);
        tlc.d r10 = r6.u(r9.getIntType());
        if (r10 == null) goto L32;
        onMessage(r10);
    L32:
        DataCenter r11 = getDataCenter();
        if (r11 == null) goto L40;
        r11.put(LIVE_KTV_PROCESS_RESUME_MESSAGE_ROOM_ID, r8);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L36:
        return;
    L14:
        r4 = false;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public boolean canSelectMore() {
        int r0 = getAddSongLimitNum();
        if ((this.selfSelectedList.size() + this.selfDownloadList.size()) >= r0) goto L13;
        OrderedSongDataContext r1 = this.mOrderedSongDataContext;
        if (r1 == null) goto L9;
        List<SongUniqueInfo> r2 = r1.getSelfKtvSongUniqueInfoList();
        if (r2 == null) goto L9;
        int r3 = r2.size();
    L10:
        if (r3 >= r0) goto L13;
        boolean r4 = false;
    L14:
        if (r4 == false) goto L17;
        f2.c(getCantSelectMoreToast(r0), 0);
        return false;
    L17:
        return true;
    L9:
        r3 = 0;
    L13:
        r4 = true;
        goto L14
    }

    public int getAddSongLimitNum() {
        return getKtvRoomStrategy().ktvAddSongLimitNum();
    }

    public final vlc.d getMsgManager() {
        o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L7;
        return (vlc.d) r1.getValue();
    L7:
        return null;
    }

    public void onCleared() {
        if (MultiLinkSettingHelper.a() == false) goto L29;
        IInteractService r0 = jc1.k.f(IInteractService.class);
        boolean r2 = true;
        if (r0 == null) goto L11;
        com.bytedance.android.live.liveinteract.service.g r1 = r0.getInteractFloatWindowService();
        if (r1 == null) goto L11;
        if (r1.b() != true) goto L11;
        boolean r3 = true;
    L12:
        IInteractService r4 = jc1.k.f(IInteractService.class);
        if (r4 != null) goto L15;
    L19:
        r2 = false;
    L20:
        ALogger.i(TAG, "onCleared ;; isLinkmicFloatWindowShowing == " + r3 + " ;; isLinkmicApplyFloatWindowShowing == " + r2 + " ;; isApplying == " + this.isApplying + " ;; isOpenLinkmic == " + this.isOpenLinkmic);
        if (this.isOpenLinkmic == false) goto L29;
        if (this.isApplying == false) goto L29;
        if (r3 == true) goto L29;
        if (r2 == true) goto L29;
        this.isApplying = false;
        com.bytedance.android.livesdk.ktvimpl.base.util.e r5 = getKtvRoomStrategy();
        if (r5 == null) goto L29;
        r5.cancelApply(null);
        goto L29
    L15:
        if (r4.getInteractFloatWindowService() == null) goto L19;
        LinkmicApplyFloatWindowManager.d r6 = LinkmicApplyFloatWindowManager.y;
        if (LinkmicApplyFloatWindowManager.e.a().floatWindowIsShowing() != true) goto L19;
    L11:
        r3 = false;
    L29:
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
        cancelLinkWaitingStateSubscribleIfNeed();
        vlc.d r7 = getMsgManager();
        if (r7 == null) goto L32;
        r7.removeMessageListener(this);
    L32:
        this.compositeDisposable.clear();
        updateKtvOrderedSongList(new ArrayList());
        this.selfDownloadList.clear();
        this.selfSelectedList.clear();
        hd0.c.f().e(this.linkStateObserver);
        tc0.c.h().e(this.linkInRoomObserver);
        this.hasReceiveSongListChangeMessage = false;
        super.onCleared();
    }

    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b getCommonOrderSongViewModel() {
        return this.commonOrderSongViewModel;
    }

    public final com.bytedance.android.live.ktv.common.search.viewmodel.a getCommonSearchViewModel() {
        return this.commonSearchViewModel;
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final WeakReference<Context> getContextForCheckPermission() {
        return this.contextForCheckPermission;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public String getCurSortType() {
        return this.currentSortType;
    }

    public final String getCurrentSortType() {
        return this.currentSortType;
    }

    public final Set<Long> getDownloadedInWifi() {
        return this.downloadedInWifi;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public boolean getForceUpdateBannerState() {
        return this.forceUpdateBanner;
    }

    public final MutableLiveData<Map<String, LabelBannerUrl>> getLabelBanner() {
        return this.labelBanner;
    }

    public Lifecycle getLifecycleCompat() {
        return this.lifecycleRegistry;
    }

    public final long getLinkPlayerWaitingObserverTime() {
        return this.linkPlayerWaitingObserverTime;
    }

    public final td2.b getMOrderSongExtraInfo() {
        return this.mOrderSongExtraInfo;
    }

    public final MutableLiveData<vb0.a> getMOrderSongUiState() {
        return this.mOrderSongUiState;
    }

    public final OrderedSongDataContext getMOrderedSongDataContext() {
        return this.mOrderedSongDataContext;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public td2.b getOrderSongExtraInfo() {
        return this.mOrderSongExtraInfo;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public MutableLiveData<vb0.a> getOrderSongUiState() {
        return this.mOrderSongUiState;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public OrderedSongDataContext getOrderedSongDataContext() {
        return this.mOrderedSongDataContext;
    }

    public final List<MusicPanel> getRecentlyMusicListBySingTime() {
        return this.recentlyMusicListBySingTime;
    }

    public final String getSelectSongFromRecord() {
        return this.selectSongFromRecord;
    }

    public final List<MusicPanel> getSelfDownloadList() {
        return this.selfDownloadList;
    }

    public final List<MusicPanel> getSelfSelectedList() {
        return this.selfSelectedList;
    }

    public final boolean hasReceiveSongListChangeMessage() {
        return this.hasReceiveSongListChangeMessage;
    }

    public final boolean isApplying() {
        return this.isApplying;
    }

    public static final /* synthetic */ MutableLiveData access$getCurFavoriteMusic$p(BaseOrderSongViewModel r0) {
        return r0.curFavoriteMusic;
    }

    public static final /* synthetic */ MutableLiveData access$getCurOrderedMusic$p(BaseOrderSongViewModel r0) {
        return r0.curOrderedMusic;
    }

    public static final /* synthetic */ boolean access$getForceUpdateBanner$p(BaseOrderSongViewModel r0) {
        return r0.forceUpdateBanner;
    }

    public static final /* synthetic */ List access$getLinkWaitingOrderedSongList$p(BaseOrderSongViewModel r0) {
        return r0.linkWaitingOrderedSongList;
    }

    public static final /* synthetic */ KSongNodeProcessCallback access$getNodeProcessCallback$p(BaseOrderSongViewModel r0) {
        return r0.nodeProcessCallback;
    }

    public static final /* synthetic */ c access$getSungSongData$p(BaseOrderSongViewModel r0) {
        return r0.sungSongData;
    }

    public static final /* synthetic */ d access$getWantSingData$p(BaseOrderSongViewModel r0) {
        return r0.wantSingData;
    }

    public static final /* synthetic */ boolean access$isOpenLinkmic$p(BaseOrderSongViewModel r0) {
        return r0.isOpenLinkmic;
    }

    public static final /* synthetic */ boolean access$isRequestOrderedSongList$p(BaseOrderSongViewModel r0) {
        return r0.isRequestOrderedSongList;
    }

    private final Disposable createLinkWaitingStateObserver(MusicPanel r3) {
        this.linkWaitingOrderedSongList.add(r3);
        return Observable.timer(this.linkPlayerWaitingObserverTime, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this));
    }

    private final String getFromRequestTypeByAddSongSource(String r5) {
        if (r5 != null) goto L4;
    L6:
        String r0 = r5;
    L8:
        if (Intrinsics.areEqual("want_to_listen", r0) == false) goto L11;
        return s1.B(2131918324);
    L11:
        if (Intrinsics.areEqual(r0, "search") == false) goto L14;
        return s1.B(2131918615);
    L14:
        if (Intrinsics.areEqual(r5, "冷启推荐") == true) goto L22;
        String r6 = this.secondTabInfoMap.get(r0);
        if (r6 != null) goto L23;
        return "推荐";
    L23:
        return r6;
    L22:
        return "冷启推荐";
    L4:
        if (StringsKt.contains$default(r5, "_multi", false, 2, null) != true) goto L6;
        r0 = StringsKt.removeSuffix(r5, "_multi");
        goto L8
    }

    private final List<MusicPanel> getUpdatedOrderedListByMessage(List<? extends de.a> r18) {
        ArrayList r1 = new ArrayList();
        if (r18 == null) goto L88;
        Iterator<T> r2 = r18.iterator();
    L6:
        if (r2.hasNext() == false) goto L88;
        de.a r3 = (de.a) r2.next();
        if (r3.a() == null) goto L6;
        Iterator<T> r4 = this.selfSelectedList.iterator();
    L11:
        RealTimeChorusInfo r6 = null;
        if (r4.hasNext() == false) goto L20;
        Object r5 = r4.next();
        MusicPanel r7 = (MusicPanel) r5;
        KtvMusic r8 = r3.a();
        if (r8 == null) goto L16;
        Boolean r9 = Boolean.valueOf(KtvUtilsKt.t(r8, r7.a));
    L18:
        if (r9.booleanValue() == false) goto L11;
    L21:
        MusicPanel r10 = (MusicPanel) r5;
        if (r10 == null) goto L79;
        KtvMusic r11 = r10.a;
        KtvMusic r12 = r3.a();
        if (r12 == null) goto L26;
        OrderInfo r13 = r12.getOrderInfo();
    L27:
        r11.setOrderInfo(r13);
        KtvMusic.a r14 = KtvMusic.Companion;
        KtvMusic r15 = r10.a;
        KtvMusic r16 = r3.a();
        r14.getClass();
        KtvMusic.a.e(r15, r16);
        r10.e = r3.b();
        KtvMusic r17 = r10.a;
        KtvMusic r19 = r3.a();
        if (r19 == null) goto L30;
        Integer r20 = Integer.valueOf(r19.getSongType());
    L31:
        r17.setSongType(r20.intValue());
        String r21 = r10.a.getMidiUrl();
        boolean r22 = true;
        if (r21 != null) goto L34;
    L37:
        boolean r23 = true;
    L38:
        if (r23 == false) goto L54;
        KtvMusic r24 = r3.a();
        if (r24 == null) goto L42;
        String r25 = r24.getMidiUrl();
    L43:
        if (r25 != null) goto L45;
    L48:
        if (r22 == true) goto L54;
        KtvMusic r26 = r10.a;
        KtvMusic r27 = r3.a();
        if (r27 == null) goto L52;
        String r28 = r27.getMidiUrl();
    L53:
        r26.setMidiUrl(r28);
        goto L54
    L52:
        r28 = null;
        goto L53
    L45:
        if (r25.length() == 0) goto L48;
        r22 = false;
        goto L48
    L42:
        r25 = null;
    L54:
        KtvMusic r29 = r10.a;
        KtvMusic r30 = r3.a();
        if (r30 == null) goto L57;
        String r31 = r30.getAddSongSource();
    L58:
        r29.setAddSongSource(r31);
        KtvMusic r32 = r10.a;
        KtvMusic r33 = r3.a();
        if (r33 == null) goto L61;
        WantListenInfo r34 = r33.getWantListenInfo();
    L62:
        r32.setWantListenInfo(r34);
        KtvMusic r35 = r10.a;
        KtvMusic r36 = r3.a();
        if (r36 == null) goto L65;
        RealTimeChorusInfo r37 = r36.getRealTimeChorusInfo();
    L66:
        r35.setRealTimeChorusInfo(r37);
        KtvMusic r38 = r10.a;
        KtvMusic r39 = r3.a();
        if (r39 == null) goto L69;
        List r40 = r39.getCopyrightedAppIds();
    L70:
        r38.setCopyrightedAppIds(r40);
        KtvMusic r41 = r10.a;
        KtvMusic r42 = r3.a();
        if (r42 == null) goto L73;
        Map r43 = r42.getGlobalCopyrightRegionInfo();
    L74:
        r41.setGlobalCopyrightRegionInfo(r43);
        KtvMusic r44 = r3.a();
        if (r44 == null) goto L77;
        String r45 = r44.getAddSongSource();
    L78:
        String r46 = getFromRequestTypeByAddSongSource(r45);
        Intrinsics.checkNotNullParameter(r46, "<set-?>");
        r10.d = r46;
    L84:
        KtvMusic r47 = r3.a();
        if (r47 == null) goto L87;
        r6 = r47.getRealTimeChorusInfo();
    L87:
        r10.C = r6;
        handlePlayAllSource(r10);
        r1.add(findLocalPath(r10));
        goto L6
    L77:
        r45 = null;
        goto L78
    L73:
        r43 = null;
        goto L74
    L69:
        r40 = null;
        goto L70
    L65:
        r37 = null;
        goto L66
    L61:
        r34 = null;
        goto L62
    L57:
        r31 = null;
        goto L58
    L34:
        if (r21.length() == 0) goto L37;
        r23 = false;
        goto L38
    L30:
        r20 = null;
        goto L31
    L26:
        r13 = null;
        goto L27
    L79:
        KtvMusic r48 = r3.a();
        boolean r110 = r3.b();
        KtvMusic r49 = r3.a();
        if (r49 == null) goto L82;
        String r50 = r49.getAddSongSource();
    L83:
        r10 = new MusicPanel(r48, 0, getFromRequestTypeByAddSongSource(r50), r110, MusicPanel.MusicPanelSource.KTV, com.bytedance.android.live.liveinteract.api.utils.m.d().w(), null, 1073741702);
        goto L84
    L82:
        r50 = null;
        goto L83
    L16:
        r9 = null;
        goto L18
    L20:
        r5 = null;
    L88:
        return r1;
    }

    private final void handlePlayAllSource(MusicPanel r8) {
        String r0 = r8.a.getAddSongSource();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        List r1 = StringsKt.split$default(r0, new String[]{"_"}, false, 0, 6, null);
        if (r1.size() == 2) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual((String) ListProtector.get(r1, 1), "multi") == false) goto L12;
        r8.A = Boolean.TRUE;
        r8.a.setAddSongSource((String) ListProtector.get(r1, 0));
        return;
    }

    private final void handlePreDownloadMusicList(List<MusicPanel> r12) {
        int r0 = KtvOrderSongThemeManager.a;
        bb0.a r1 = bb0.b.a;
        int r2 = 0;
        if (r1 == null) goto L5;
        boolean r3 = r1.b();
    L6:
        if (r3 == true) goto L13;
        bb0.a r4 = bb0.b.a;
        if (r4 == null) goto L10;
        boolean r5 = r4.l();
    L11:
        if (r5 == false) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == true) goto L16;
        return;
    L16:
        ArrayList r7 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L18:
        if (r13.hasNext() == false) goto L32;
        MusicPanel r8 = (MusicPanel) r13.next();
        String r9 = jc1.k.n(IMiddlewareUserService.class).user().n().toString();
        if (isAnchor() == false) goto L18;
        if (r2 >= 5) goto L18;
        if (Intrinsics.areEqual(r8.g(), r9) == false) goto L18;
        com.bytedance.android.live.ktv.common.music.download.m r10 = KtvMusicManager.a;
        Intrinsics.checkNotNullParameter(r8, "panel");
        if (KtvUtilsKt.m(r8) == false) goto L28;
    L30:
        r2 = r2 + 1;
        goto L18
    L28:
        if (KtvMusicManager.h(r8) == true) goto L30;
        r7.add(r8);
        goto L30
    L32:
        if (r7.isEmpty() == false) goto L34;
        return;
    L34:
        com.bytedance.android.live.ktv.common.music.download.m r14 = KtvMusicManager.a;
        g r15 = new g(this);
        Intrinsics.checkNotNullParameter(r7, "panel");
        Intrinsics.checkNotNullParameter(r15, "callback");
        Iterator r11 = r7.iterator();
    L36:
        if (r11.hasNext() == false) goto L38;
        MusicPanel r16 = (MusicPanel) r11.next();
        KtvMusicManager.e(KtvMusicManager.m, r16, r15, false, null, false, 24);
        goto L36
    L38:
        return;
    L10:
        r5 = false;
    L13:
        r6 = false;
        goto L14
    L5:
        r3 = false;
        goto L6
    }

    private final void handleSongListChange(List<MusicPanel> r4) {
        if (r4 != null) goto L4;
        r4 = new ArrayList();
    L4:
        this.selfSelectedList.clear();
        if ((!r4.isEmpty()) == false) goto L18;
        Iterator<T> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L24;
        MusicPanel r0 = (MusicPanel) r5.next();
        OrderInfo r1 = r0.a.getOrderInfo();
        if (r1 == null) goto L14;
        InteractiveSongUserInfo r2 = r1.getTopUser();
        if (r2 == null) goto L14;
        String r3 = r2.getIdString();
    L16:
        if (Intrinsics.areEqual(r3, jc1.k.n(IMiddlewareUserService.class).user().n().toString()) == false) goto L8;
        r0.b = 4;
        this.selfSelectedList.add(r0);
    L14:
        r3 = null;
        goto L16
    L24:
        return;
    }

    private final void handleSongListChangeMini(de r11) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.commonOrderSongViewModel;
        String r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.android.live.ktv.common.karaokestation.model.y r2 = r0.getSelectedSecondLevelTabData(FirstLevelTab.OrderedSongTab.getValue());
        if (r2 == null) goto L7;
        String r3 = r2.c;
    L9:
        if ((!Intrinsics.areEqual(r3, "sung")) == false) goto L11;
        this.sungSongData.c.setValue(Integer.valueOf((int) r11.getSungSongCount()));
    L11:
        com.bytedance.android.livesdk.ktvimpl.base.util.j r4 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        List r5 = r11.getMMusicInfoList();
        r4.getClass();
        if (r5 == null) goto L16;
        de.a r6 = (de.a) CollectionsKt.getOrNull(r5, 0);
        if (r6 == null) goto L16;
        KtvMusic r7 = r6.a();
    L17:
        if (r7 != null) goto L19;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.k = false;
    L20:
        String r8 = com.bytedance.android.livesdk.ktvimpl.base.util.j.a;
        StringBuilder r9 = new StringBuilder("updateFirstSongCopyright ");
        if (r7 == null) goto L23;
        String r10 = r7.getTitle();
    L24:
        r9.append(r10);
        r9.append('_');
        r9.append(com.bytedance.android.livesdk.ktvimpl.base.util.j.k);
        String r12 = r9.toString();
        ALogger.i(bb0.b.b(), r8 + " :" + r12 + ", invoke class :" + com.bytedance.android.livesdk.ktvimpl.base.util.j.class.getSimpleName());
        this.wantSingData.a = r11.getWantSingSongThreshold();
        d r13 = this.wantSingData;
        r11.getWantSingCount();
        r13.getClass();
        List<MusicPanel> r14 = getUpdatedOrderedListByMessage(r11.getMMusicInfoList());
        StringBuilder r15 = new StringBuilder("handleSongListChangeMini，");
        MusicPanel r16 = (MusicPanel) CollectionsKt.lastOrNull(r14);
        if (r16 == null) goto L29;
        KtvMusic r17 = r16.a;
        if (r17 == null) goto L29;
        String r18 = r17.getMTitle();
    L30:
        r15.append(r18);
        r15.append(",song count:");
        List r19 = r11.getMusicInfoList();
        if (r19 == null) goto L33;
        int r20 = r19.size();
    L34:
        r15.append(r20);
        String r21 = r15.toString();
        ALogger.i(bb0.b.b(), r21 + ", invoke class :BaseOrderSongViewModel");
        StringBuilder r22 = new StringBuilder("handleSongListChangeMini，");
        MusicPanel r23 = (MusicPanel) CollectionsKt.lastOrNull(r14);
        if (r23 == null) goto L39;
        KtvMusic r24 = r23.a;
        if (r24 == null) goto L39;
        r1 = r24.getMTitle();
    L39:
        r22.append(r1);
        r22.append(",song count:");
        List r25 = r11.getMusicInfoList();
        if (r25 == null) goto L42;
        int r26 = r25.size();
    L43:
        r22.append(r26);
        ALogger.i("logKtvMainPath", r22.toString() + ", invoke class :BaseOrderSongViewModel");
        KtvContext.Companion.getClass();
        KtvContext.a.g().getKtvRoomLabelChangeEvent().post(new Object());
        OrderedSongDataContext r27 = this.mOrderedSongDataContext;
        if (r27 == null) goto L46;
        r27.updateKtvSongUniqueInfoList(r11.getAllSongUniqueList());
    L46:
        OrderedSongDataContext r28 = this.mOrderedSongDataContext;
        if (r28 == null) goto L50;
        r28.updateKtvSingSongList(r14);
    L50:
        if (isAnchor() == true) goto L64;
        IInteractService r29 = jc1.k.f(IInteractService.class);
        if (r29 == null) goto L56;
        if (r29.isAudienceLinkEngineOn() == true) goto L64;
    L56:
        if (isAdmin() == true) goto L64;
        if (r11.isDowngrade() == false) goto L61;
    L68:
        pd2.d r30 = pd2.d.n;
        r30.getClass();
        long r31 = pd2.d.d;
        if (r31 <= 0) goto L71;
        pd2.d.y(r31, "cut_music_list_change");
    L71:
        r30.E(LinkMonitorData.MsgLinkmicAudienceKtvMessage, r11, new JSONObject());
        return;
    L61:
        if (hasSelectedPlayList() == false) goto L68;
        getOrderedSongList(false);
    L64:
        if (isAnchor() == false) goto L66;
    L67:
        getOrderedSongList(false);
        goto L68
    L66:
        if (hasSelectedPlayList() == false) goto L68;
    L42:
        r26 = 0;
        goto L43
    L33:
        r20 = 0;
    L29:
        r18 = null;
        goto L30
    L23:
        r10 = null;
        goto L24
    L19:
        com.bytedance.android.livesdk.ktvimpl.base.util.j.k = !com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r7);
    L16:
        r7 = null;
    L7:
        r3 = null;
        goto L9
    }

    private final boolean isLinkModeGuest(boolean r6) {
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        IBaseUser r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.user.e r2 = r0.user();
        if (r2 == null) goto L7;
        IBaseUser r3 = r2.b();
    L9:
        if ((r3 instanceof IBaseUser) == false) goto L13;
        r1 = r3;
    L13:
        if (r1 != null) goto L15;
        return false;
    L15:
        IInteractService r4 = jc1.k.f(IInteractService.class);
        if (r4 == null) goto L21;
        rj0.m r5 = r4.getVideoTalkService();
        if (r5 == null) goto L21;
        if (r5.C(r6, r1.getIdString()) != true) goto L21;
    L33:
        return true;
    L21:
        IInteractService r7 = jc1.k.f(IInteractService.class);
        if (r7 == null) goto L27;
        qd0.a r8 = r7.getAudioTalkService();
        if (r8 == null) goto L27;
        if (r8.q(r6, r1.getIdString()) == true) goto L33;
    L27:
        IInteractService r9 = jc1.k.f(IInteractService.class);
        if (r9 == null) goto L35;
        com.bytedance.android.live.liveinteract.service.f r10 = r9.getInteractAudienceService();
        if (r10 != null) goto L32;
        return false;
    L32:
        if (r10.S(r6, r1) == true) goto L33;
        return false;
    L35:
        return false;
    L7:
        r3 = null;
        goto L9
    }

    private final void logPlayAllSongSuccess(MusicPanel r20) {
        KtvContext.Companion.getClass();
        n<oe2.b> r2 = KtvContext.a.g().getKtvRoomProvider();
        if (r2 == null) goto L5;
        oe2.b r3 = (oe2.b) r2.getValue();
    L6:
        Long r4 = KtvLoggerHelper.a;
        String r5 = r20.d;
        String r6 = com.bytedance.android.live.ktv.common.util.j.g();
        String r7 = r20.a.getMTitle();
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        long r8 = r20.a.getMId();
        String r10 = r20.a.getMAuthor();
        if (r10 != null) goto L12;
        r10 = "";
    L12:
        String r11 = r20.b();
        if (jc1.k.n(IInteractService.class).getCurrentScene() != 0) goto L15;
        String r12 = "normal";
    L16:
        String r13 = this.selectSongFromRecord;
        if (r13 != null) goto L23;
        td2.b r14 = this.mOrderSongExtraInfo;
        if (r14 == null) goto L21;
        r13 = r14.a;
        goto L23
    L21:
        r13 = null;
    L23:
        if (r13 != null) goto L25;
        r13 = "bottom";
    L25:
        List r15 = r20.a.getTags();
        if (r15 == null) goto L28;
        boolean r9 = r15.contains("原唱");
    L29:
        if (r3 == null) goto L31;
        String r16 = r3.c();
    L32:
        if (r3 == null) goto L34;
        String r17 = r3.a();
    L35:
        Intrinsics.checkNotNullParameter(r5, "fromRequestType");
        Intrinsics.checkNotNullParameter(r6, "userType");
        Intrinsics.checkNotNullParameter(r7, "songName");
        Intrinsics.checkNotNullParameter(r11, "artistId");
        Intrinsics.checkNotNullParameter(r10, "artistName");
        Intrinsics.checkNotNullParameter(r12, "functionType");
        Intrinsics.checkNotNullParameter(r13, "enterFrom");
        Pair[] r0 = new Pair[14];
        r0[0] = TuplesKt.to("from_request_type", r5);
        r0[1] = TuplesKt.to("artist_id", r11);
        r0[2] = TuplesKt.to("artist_name", r10);
        r0[3] = TuplesKt.to("function_type", KtvLoggerHelper.H(r12));
        r0[4] = TuplesKt.to("enter_from", "bottom");
        r0[5] = TuplesKt.to("is_original", "1");
        if (r9 == false) goto L38;
        Object r18 = "1";
    L39:
        r0[6] = TuplesKt.to("is_original_flag", r18);
        r0[7] = TuplesKt.to("is_play_all", "1");
        r0[8] = TuplesKt.to("user_type", r6);
        r0[9] = TuplesKt.to("song_name", r7);
        r0[10] = TuplesKt.to("song_id", String.valueOf(r8));
        r0[11] = TuplesKt.to("is_priority_sing", BDLocationException.ERROR_TIMEOUT);
        r0[12] = TuplesKt.to("live_type", KtvLoggerHelper.F());
        r0[13] = TuplesKt.to("enter_from", r13);
        HashMap r1 = MapsKt.hashMapOf(r0);
        KtvLoggerHelper.o0(r1);
        r1.put("function_type2", jc1.k.n(IInteractService.class).getFunctionType2());
        if (r16 == null) goto L42;
        r1.put("ksong_element_source", r16);
    L42:
        if (r17 == null) goto L44;
        r1.put("element_open_method", r17);
    L44:
        KtvLoggerHelper.n0(r1, r20);
        r1.put("midi_score", "");
        KtvMusic r19 = r20.a;
        if (r19 == null) goto L51;
        PersonalSongInfo r21 = r19.getPersonalSongInfo();
        if (r21 == null) goto L51;
        double r22 = r21.getMidiScore();
        if (r22 <= 0) goto L51;
        r1.put("midi_score", String.valueOf(r22));
    L51:
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r1);
        String r23 = r20.g();
        if (r23 != null) goto L54;
        String r24 = "";
    L55:
        com.bytedance.android.livesdk.ktvimpl.chorus.c.c(r1, r24);
        if (Intrinsics.areEqual(r5, "recommend") == false) goto L58;
    L59:
        ke2.d.a(r20, r1, true);
    L60:
        xe2.h.b(r1);
        j0.l().sendLog("livesdk_ksong_request_song_success", r1, new Object[]{IRoom.class, x.class});
        return;
    L58:
        if (Intrinsics.areEqual(r5, "推荐") == false) goto L60;
    L54:
        r24 = r23;
        goto L55
    L38:
        r18 = BDLocationException.ERROR_TIMEOUT;
        goto L39
    L34:
        r17 = null;
        goto L35
    L31:
        r16 = null;
        goto L32
    L28:
        r9 = false;
        goto L29
    L15:
        r12 = "radio";
        goto L16
    L5:
        r3 = null;
        goto L6
    }

    private final MusicPanel updateFavorite(MusicPanel r10) {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.commonOrderSongViewModel;
        if (r0 == null) goto L7;
        com.bytedance.android.live.ktv.common.karaokestation.model.y r1 = r0.getSecondLevelTabDataByParams(FirstLevelTab.MySongTab.getValue(), "favorite");
        if (r1 == null) goto L7;
        List r2 = r1.h;
    L8:
        List r3 = r2;
        boolean r4 = true;
        if (r3 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == true) goto L25;
        Iterator r6 = r2.iterator();
    L18:
        if (r6.hasNext() == false) goto L22;
        MusicPanel r7 = (MusicPanel) r6.next();
        if (r7.a.getMId() != r10.a.getMId()) goto L18;
        r10.a.setFavorite(r7.a.isFavorite());
    L23:
        if (r4 == true) goto L25;
        r10.a.setFavorite(false);
        goto L25
    L22:
        r4 = false;
    L25:
        return r10;
    L11:
        if (r3.isEmpty() == true) goto L14;
        r5 = false;
    L7:
        r2 = null;
        goto L8
    }

    private final void updateKtvOrderedSongList(List<MusicPanel> r3) {
        if (r3.isEmpty() == false) goto L7;
        OrderedSongDataContext r0 = this.mOrderedSongDataContext;
        if (r0 == null) goto L7;
        r0.updateKtvSongUniqueInfoList(new ArrayList());
    L7:
        OrderedSongDataContext r1 = this.mOrderedSongDataContext;
        if (r1 == null) goto L10;
        r1.updateKtvOrderedSongList(r3);
    L10:
        CollectionsKt.removeAll(this.selfDownloadList, C02121.INSTANCE);
    }

    private final MusicPanel updateSelected(MusicPanel r13) {
        OrderedSongDataContext r0 = this.mOrderedSongDataContext;
        if (r0 == null) goto L6;
        List<SongUniqueInfo> r1 = r0.getSelfKtvSongUniqueInfoList();
        if (r1 == null) goto L6;
    L8:
        if (r1.isEmpty() == true) goto L10;
        Iterator<T> r2 = r1.iterator();
        boolean r3 = false;
        int r4 = 0;
    L15:
        if (r2.hasNext() == false) goto L36;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        SongUniqueInfo r7 = (SongUniqueInfo) r5;
        if (r7.getSongId() != r13.a.getMId()) goto L35;
        if (r4 != 0) goto L33;
        OrderedSongDataContext r8 = this.mOrderedSongDataContext;
        if (r8 == null) goto L29;
        MusicPanel r9 = r8.getKtvPublicFirstOrderedSong();
        if (r9 == null) goto L29;
        KtvMusic r10 = r9.a;
        if (r10 == null) goto L29;
        long r11 = r10.getMId();
    L31:
        if (r11 != r7.getSongId()) goto L33;
        r13.b = 5;
    L34:
        r3 = true;
    L29:
        r11 = -1;
    L33:
        r13.b = 4;
    L35:
        r4 = r6;
        goto L15
    L36:
        if (r3 == false) goto L38;
    L40:
        return r13;
    L38:
        if (r13.b == 2) goto L40;
        r13.b = 1;
        goto L40
    L10:
        if (r13.b == 2) goto L12;
        r13.b = 1;
    L12:
        return r13;
    L6:
        r1 = new ArrayList();
        goto L8
    }

    private final void updateTabData(com.bytedance.android.live.ktv.common.karaokestation.model.y r2) {
        Iterator r3 = r2.h.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        updateMusicPanelState((MusicPanel) r3.next());
        goto L4
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void beginWifiDownload(com.bytedance.android.live.ktv.common.karaokestation.model.y r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r10.c, "room_hot") == false) goto L16;
        List r11 = CollectionsKt.take(r10.h, 5);
        ArrayList r0 = new ArrayList();
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        Object r1 = r12.next();
        if ((!this.downloadedInWifi.contains(Long.valueOf(((MusicPanel) r1).a.getMId()))) == false) goto L8;
        r0.add(r1);
        goto L8
    L12:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L14:
        if (r2.hasNext() == false) goto L23;
        MusicPanel r3 = (MusicPanel) r2.next();
        this.downloadedInWifi.add(Long.valueOf(r3.a.getMId()));
        KtvMusicManager.e(KtvMusicManager.m, r3, new b(), true, null, false, 24);
        r13.add(Unit.INSTANCE);
        goto L14
    L23:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public boolean checkMidiDataInRecentlyLabel(com.bytedance.android.live.ktv.common.karaokestation.model.y r7) {
        Object r1 = null;
        if (r7 == null) goto L19;
        List r8 = r7.h;
        if (r8 == null) goto L19;
        Iterator r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L18;
        Object r3 = r9.next();
        PersonalSongInfo r4 = ((MusicPanel) r3).a.getPersonalSongInfo();
        if (r4 == null) goto L12;
        int r5 = (int) r4.getMidiScore();
    L13:
        if (r5 <= 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L8;
        r1 = r3;
        goto L18
    L15:
        r6 = false;
        goto L16
    L12:
        r5 = 0;
    L18:
        r1 = (MusicPanel) r1;
    L19:
        if (r1 != null) goto L28;
        return false;
    L28:
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void deleteSelfDownloadMusicById(String r3) {
        Intrinsics.checkNotNullParameter(r3, "mId");
        Iterator<MusicPanel> r0 = this.selfDownloadList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(r0.next().a.getMIdStr(), r3) == false) goto L4;
        r0.remove();
        goto L4
    }

    public final MusicPanel findLocalPath(MusicPanel r10) {
        Intrinsics.checkNotNullParameter(r10, "musicPanel");
        if (shouldFillLocalPath(r10) == false) goto L124;
        boolean r1 = false;
        if (r10.l.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
    L15:
        boolean r2 = false;
    L16:
        MusicPanel r3 = null;
        if (r2 == false) goto L19;
        MusicPanel r4 = r10;
    L20:
        if (r4 == null) goto L23;
        r4.i(getLrcCacheFactory().b(r10.a) + getLrcCacheFactory().a(r10.a));
    L23:
        if (r10.n.length() != 0) goto L25;
        boolean r5 = true;
    L26:
        if (r5 == true) goto L28;
    L33:
        boolean r6 = false;
    L34:
        if (r6 == false) goto L36;
        MusicPanel r7 = r10;
    L38:
        if (r7 == null) goto L41;
        String r8 = getFullTrackCacheFactory().b(r10.a) + getFullTrackCacheFactory().a(r10.a);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r7.n = r8;
    L41:
        if (r10.q.length() != 0) goto L43;
        boolean r9 = true;
    L44:
        if (r9 == true) goto L46;
    L51:
        boolean r11 = false;
    L52:
        if (r11 == false) goto L54;
        MusicPanel r12 = r10;
    L55:
        if (r12 == null) goto L58;
        r12.j(getMidiCacheFactory().b(r10.a) + getMidiCacheFactory().a(r10.a));
    L58:
        if (r10.o.length() != 0) goto L60;
        boolean r13 = true;
    L61:
        if (r13 == true) goto L63;
    L68:
        boolean r14 = false;
    L69:
        if (r14 == false) goto L71;
        MusicPanel r15 = r10;
    L72:
        if (r15 == null) goto L75;
        String r16 = getAccompanimentTrackFactory().b(r10.a) + getAccompanimentTrackFactory().a(r10.a);
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r15.o = r16;
    L75:
        if (r10.r.length() != 0) goto L77;
        boolean r17 = true;
    L79:
        if (r17 == false) goto L86;
        getVideoFactory().c(r10.a);
        if ("".length() <= 0) goto L83;
        boolean r18 = true;
    L84:
        if (r18 == false) goto L86;
        boolean r19 = true;
    L87:
        if (r19 == false) goto L89;
        MusicPanel r20 = r10;
    L90:
        if (r20 == null) goto L93;
        StringBuilder r21 = new StringBuilder();
        r21.append(getVideoFactory().b(r10.a));
        getVideoFactory().a(r10.a);
        r21.append("");
        String r22 = r21.toString();
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r20.r = r22;
    L93:
        if (r10.q.length() != 0) goto L95;
        boolean r23 = true;
    L96:
        if (r23 == true) goto L98;
    L103:
        boolean r24 = false;
    L104:
        if (r24 == false) goto L106;
        MusicPanel r25 = r10;
    L107:
        if (r25 == null) goto L110;
        r25.j(getMidiFactory().b(r10.a) + getMidiFactory().a(r10.a));
    L110:
        if (r10.p.length() != 0) goto L112;
        boolean r26 = true;
    L113:
        if (r26 == true) goto L115;
    L120:
        if (r1 == false) goto L122;
        r3 = r10;
    L122:
        if (r3 == null) goto L124;
        String r27 = getVocalCacheFactory().b(r10.a) + getVocalCacheFactory().a(r10.a);
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r3.p = r27;
        goto L124
    L115:
        if (getVocalCacheFactory().c(r10.a).length() <= 0) goto L117;
        boolean r28 = true;
    L118:
        if (r28 == false) goto L120;
        r1 = true;
        goto L120
    L117:
        r28 = false;
        goto L118
    L112:
        r26 = false;
        goto L113
    L106:
        r25 = null;
        goto L107
    L98:
        if (getMidiFactory().c(r10.a).length() <= 0) goto L100;
        boolean r29 = true;
    L101:
        if (r29 == false) goto L103;
        r24 = true;
        goto L104
    L100:
        r29 = false;
        goto L101
    L95:
        r23 = false;
        goto L96
    L89:
        r20 = null;
        goto L90
    L83:
        r18 = false;
    L86:
        r19 = false;
        goto L87
    L77:
        r17 = false;
        goto L79
    L71:
        r15 = null;
        goto L72
    L63:
        if (getAccompanimentTrackFactory().c(r10.a).length() <= 0) goto L65;
        boolean r30 = true;
    L66:
        if (r30 == false) goto L68;
        r14 = true;
        goto L69
    L65:
        r30 = false;
        goto L66
    L60:
        r13 = false;
        goto L61
    L54:
        r12 = null;
        goto L55
    L46:
        if (getMidiCacheFactory().c(r10.a).length() <= 0) goto L48;
        boolean r31 = true;
    L49:
        if (r31 == false) goto L51;
        r11 = true;
        goto L52
    L48:
        r31 = false;
        goto L49
    L43:
        r9 = false;
        goto L44
    L36:
        r7 = null;
        goto L38
    L28:
        if (getFullTrackCacheFactory().c(r10.a).length() <= 0) goto L30;
        boolean r32 = true;
    L31:
        if (r32 == false) goto L33;
        r6 = true;
        goto L34
    L30:
        r32 = false;
        goto L31
    L25:
        r5 = false;
        goto L26
    L19:
        r4 = null;
        goto L20
    L10:
        if (getLrcCacheFactory().c(r10.a).length() <= 0) goto L12;
        boolean r33 = true;
    L13:
        if (r33 == false) goto L15;
        r2 = true;
        goto L16
    L12:
        r33 = false;
        goto L13
    L7:
        r0 = false;
    L124:
        return r10;
    }

    public String getAddSongSource(MusicPanel r7) {
        boolean r1 = false;
        if (isAnchor() == true) goto L5;
    L15:
        if (r1 == false) goto L18;
        return "permit_want_to_listen";
    L18:
        String r0 = null;
        if (r7 == null) goto L21;
        String r2 = r7.d;
    L23:
        if (Intrinsics.areEqual(r2, "冷启推荐") == false) goto L25;
        return "冷启推荐";
    L25:
        if (r7 == null) goto L27;
        String r3 = r7.y;
    L29:
        if (TextUtils.isEmpty(r3) == true) goto L36;
        if (r7 == null) goto L33;
        r0 = r7.z;
    L33:
        if (TextUtils.isEmpty(r0) == true) goto L36;
        return "search";
    L36:
        com.bytedance.android.live.ktv.common.karaokestation.model.y r8 = KSongOrderSongUtilKt.c(this.commonOrderSongViewModel);
        if (r8 == null) goto L40;
        String r9 = r8.c;
        if (r9 == null) goto L40;
        return r9;
    L40:
        return "recommend";
    L27:
        r3 = null;
        goto L29
    L21:
        r2 = null;
        goto L23
    L5:
        if (r7 == null) goto L11;
        KtvMusic r4 = r7.a;
        if (r4 == null) goto L11;
        WantListenInfo r5 = r4.getWantListenInfo();
        if (r5 == null) goto L11;
        long r6 = r5.getWantListenCount().longValue();
    L13:
        if (r6 <= 0) goto L15;
        r1 = true;
    L11:
        r6 = 0;
        goto L13
    }

    public String getCantSelectMoreToast(int r3) {
        return s1.C(2131918226, new Object[]{Integer.valueOf(r3)});
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void getOrderedSongList(final boolean r10) {
        long r0 = System.currentTimeMillis();
        t61 r2 = com.bytedance.android.livesdk.ktvimpl.base.util.f.a();
        if (r2 != null) goto L5;
    L14:
        this.isRequestOrderedSongList = true;
        int r3 = sd2.a.a;
        sd2.a r4 = sd2.a.b.a;
        long r5 = getRoom().getId();
        long r6 = getRoom().getId();
        Function1<com.bytedance.android.live.network.response.e<com.bytedance.android.live.ktv.common.model.api.h>, Unit> r7 = new C01941(this, r10);
        Function1<Throwable, Unit> r11 = new C01952(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "successCallback");
        Intrinsics.checkNotNullParameter(r11, "failCallback");
        Disposable r12 = ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getOrderSongList(r5, r6).retryWhen(RxUtil.rxRetryHelper(3, 1000)).compose(RxUtil.rxSchedulerHelper()).subscribe(new sd2.f(r0, r7), new sd2.g(r0, r11));
        if (r12 == null) goto L18;
        RxUtilKt.c(r12, this.compositeDisposable);
        return;
    L18:
        return;
    L5:
        if (u61.b(r2) != true) goto L14;
        if (this.isRequestOrderedSongList == false) goto L14;
        if (((Boolean) KtvSettingHelper.S.getValue()).booleanValue() == false) goto L13;
        if (r10 == true) goto L12;
        return;
    L12:
        ALogger.i(bb0.b.b(), "BaseOrderSongViewModel ;; is from room create not return, invoke class :BaseOrderSongViewModel");
        goto L14
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public boolean inSelfDownloadMusicById(String r4) {
        Intrinsics.checkNotNullParameter(r4, "mId");
        Iterator<T> r0 = this.selfDownloadList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((MusicPanel) r1).a.getMIdStr(), r4) == false) goto L4;
    L9:
        if (r1 == null) goto L11;
        return true;
    L11:
        return false;
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void jumpToChorusRoom(final MusicPanel r15) {
        KtvLoggerHelper.d.Q("request_song", "chorus_join", getDataCenter(), r15);
        String r1 = null;
        Activity r2 = null;
        Activity r3 = null;
        if (isAnchor() == false) goto L8;
        IMiddlewareHostApp r0 = jc1.k.f(IMiddlewareHostApp.class);
        if (r0 == null) goto L7;
        r2 = r0.getTopActivity();
    L7:
        com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt.j(r2, s1.B(2131918177), C01971.INSTANCE, new C01982(this, r15));
        return;
    L8:
        IInteractService r4 = jc1.k.f(IInteractService.class);
        if (r4 != null) goto L11;
    L16:
        int r5 = sd2.a.a;
        sd2.a r6 = sd2.a.b.a;
        long r7 = System.currentTimeMillis();
        Integer r8 = Integer.valueOf(JumpScene.KTV.getValue());
        Gson r9 = GsonHelper.getDefault();
        if (r15 == null) goto L27;
        KtvMusic r10 = r15.a;
        if (r10 == null) goto L27;
        List r11 = r10.getRecommendRealTimeChorusInfos();
        if (r11 == null) goto L27;
        RecommendRealTimeChorusInfo r12 = (RecommendRealTimeChorusInfo) CollectionsKt.getOrNull(r11, 0);
        if (r12 == null) goto L27;
        Long r13 = r12.getRoomId();
        if (r13 == null) goto L27;
        String r14 = String.valueOf(r13.longValue());
    L28:
        if (r15 == null) goto L30;
        r1 = String.valueOf(r15.c());
    L30:
        Disposable r16 = r6.a(r7, new JumpRealTimeChorusRoomParams(r8, GsonProtectorUtils.toJson(r9, CollectionsKt.listOf(new JumpRoomInfo(r14, r1, null, 4, null)))), new AnonymousClass5(this), AnonymousClass6.INSTANCE);
        if (r16 == null) goto L36;
        RxUtilKt.c(r16, this.compositeDisposable);
        return;
    L36:
        return;
    L27:
        r14 = null;
        goto L28
    L11:
        if (r4.isAudienceLinkEngineOn() != true) goto L16;
        IMiddlewareHostApp r17 = jc1.k.f(IMiddlewareHostApp.class);
        if (r17 == null) goto L15;
        r3 = r17.getTopActivity();
    L15:
        com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt.j(r3, s1.B(2131918178), AnonymousClass3.INSTANCE, new AnonymousClass4(this, r15));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void moveOrderedSongToOtherRoom(final long r21) {
        WeakReference<Context> r1 = this.contextForCheckPermission;
        if (r1 == null) goto L5;
        Context r2 = r1.get();
    L6:
        if (r2 != null) goto L8;
    L18:
        String r3 = bb0.b.b();
        ALogger.i(r3, ("moveOrderedSongToOtherRoom, context: " + r2) + ", invoke class :BaseOrderSongViewModel");
        return;
    L8:
        if ((r2 instanceof LifecycleOwner) == false) goto L18;
        final List<MusicPanel> r4 = this.selfSelectedList;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        r5.add(Long.valueOf(((MusicPanel) r6.next()).a.getMId()));
        goto L12
    L14:
        String r17 = new JSONArray(r5).toString();
        String r7 = "moveOrderedSongToOtherRoom, song list size: " + r5.size();
        ALogger.i(bb0.b.b(), r7 + ", invoke class :" + List.class.getSimpleName());
        long r8 = System.currentTimeMillis();
        int r9 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
        Disposable r10 = com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a.b(r8, r21, r21, 0, 0, "recommend", "", "", r17, new BaseOrderSongViewModel$moveOrderedSongToOtherRoom$$inlined$apply$lambda$1(r4, this, r21), new BaseOrderSongViewModel$moveOrderedSongToOtherRoom$1$3(r4));
        if (r10 == null) goto L21;
        RxUtilKt.c(r10, this.compositeDisposable);
        return;
    L21:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void onDialogShow(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "tmpArray");
        Intrinsics.checkNotNullParameter(r2, "tmpArray");
    }

    public void onMessage(tlc.d r4) {
        Integer r1 = null;
        if ((r4 instanceof de) == true) goto L5;
        r4 = null;
    L5:
        de r5 = (de) r4;
        if (r5 == null) goto L14;
        StringBuilder r0 = new StringBuilder("onMessage ;; messageType == ");
        r0.append(r5.getMessageType());
        r0.append(" ;; list_size == ");
        List r2 = r5.getMMusicInfoList();
        if (r2 == null) goto L10;
        r1 = Integer.valueOf(r2.size());
    L10:
        r0.append(r1);
        ALogger.i(TAG, r0.toString());
        this.hasReceiveSongListChangeMessage = true;
        int r3 = r5.getMessageType();
        t8.Companion.getClass();
        if (r3 != 3) goto L15;
        handleSongListChangeMini(r5);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void pinMusic(final MusicPanel r19) {
        Intrinsics.checkNotNullParameter(r19, "musicPanel");
        pd2.d.n.getClass();
        Intrinsics.checkNotNullParameter(r19, "musicPanel");
        JSONObject r2 = mb0.b.p(new JSONObject(), r19.a.getMId());
        String r3 = r19.a.getMTitle();
        String r4 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        JSONObject r5 = mb0.b.q(r2, r3);
        pd2.d.w(LinkMonitorData.BusinessPinSong, r5);
        long r6 = System.currentTimeMillis();
        int r7 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
        com.bytedance.android.live.ktv.common.karaokestation.model.g r8 = com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a;
        long r9 = getRoom().getId();
        long r10 = getRoom().getId();
        long r12 = r19.a.getMId();
        OrderInfo r11 = r19.a.getOrderInfo();
        if (r11 == null) goto L13;
        InteractiveSongUserInfo r13 = r11.getTopUser();
        if (r13 == null) goto L13;
        String r14 = r13.getIdString();
        if (r14 == null) goto L13;
        r4 = r14;
    L13:
        int r17 = r19.a.getSongType();
        Function1<com.bytedance.android.live.network.response.a, Unit> r15 = new C02011(this, r19);
        C02022 r1 = C02022.INSTANCE;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r4, "toUserId");
        Intrinsics.checkNotNullParameter(r15, "successCallback");
        Intrinsics.checkNotNullParameter(r1, "failCallback");
        KtvCommonApi r16 = (KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class);
        if (r16 == null) goto L20;
        Observable r18 = r16.pinSong(r9, r10, r12, d5.c(r4), r4, r17);
        if (r18 == null) goto L20;
        Observable r20 = r18.compose(RxUtil.rxSchedulerHelper());
        if (r20 == null) goto L20;
        Disposable r21 = r20.subscribe(new com.bytedance.android.live.ktv.common.karaokestation.model.p(r6, r15), new q(r6, r1));
    L21:
        if (r21 == null) goto L24;
        RxUtilKt.c(r21, this.compositeDisposable);
        return;
    L24:
        return;
    L20:
        r21 = null;
        goto L21
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void postSyncSongListData(com.bytedance.android.live.ktv.common.karaokestation.model.y r3) {
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabData");
        if (r3.k != FirstLevelTab.OrderSongTab.getValue()) goto L5;
        syncSecondLevelTabBanner(r3.k);
    L5:
        updateTabData(r3);
        if (Intrinsics.areEqual(r3.c, "recently") == false) goto L9;
        this.recentlyMusicListBySingTime.clear();
        this.recentlyMusicListBySingTime.addAll(r3.h);
        sortSecondLevelTabByType(getCurSortType(), r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void postSyncTabListData(com.bytedance.android.live.ktv.common.karaokestation.model.d r3) {
        Intrinsics.checkNotNullParameter(r3, "firstLevelTabData");
        if (r3.d != FirstLevelTab.OrderSongTab.getValue()) goto L5;
        syncSecondLevelTabBanner(r3.d);
    L5:
        updateSecondTabInfoMap(r3);
    }

    public final void setApplying(boolean r1) {
        this.isApplying = r1;
    }

    public final void setContextForCheckPermission(WeakReference<Context> r1) {
        this.contextForCheckPermission = r1;
    }

    public final void setCurrentSortType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.currentSortType = r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void setForceUpdateBannerState(boolean r1) {
        this.forceUpdateBanner = r1;
    }

    public final void setMOrderSongExtraInfo(td2.b r1) {
        this.mOrderSongExtraInfo = r1;
    }

    public final void setRecentlyMusicListBySingTime(List<MusicPanel> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.recentlyMusicListBySingTime = r2;
    }

    public final void setSelectSongFromRecord(String r1) {
        this.selectSongFromRecord = r1;
    }

    public boolean shouldFillLocalPath(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        OrderInfo r3 = r2.a.getOrderInfo();
        if (r3 == null) goto L7;
        InteractiveSongUserInfo r4 = r3.getTopUser();
        if (r4 == null) goto L7;
        String r5 = r4.getIdString();
    L9:
        return Intrinsics.areEqual(r5, jc1.k.n(IMiddlewareUserService.class).user().n().toString());
    L7:
        r5 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void syncHighScoreSongList(final boolean r19) {
        long r1 = System.currentTimeMillis();
        IMiddlewareUserService r3 = jc1.k.f(IMiddlewareUserService.class);
        if (r3 == null) goto L10;
        com.bytedance.android.livesdk.user.e r4 = r3.user();
        if (r4 == null) goto L10;
        IBaseUser r5 = r4.b();
        if (r5 == null) goto L10;
        String r6 = r5.getIdString();
        if (r6 == null) goto L10;
    L11:
        String r7 = r6;
        long r9 = getRoom().getId();
        int r8 = sd2.a.a;
        sd2.a r10 = sd2.a.b.a;
        Function1<com.bytedance.android.live.network.response.e<com.bytedance.android.live.ktv.common.model.api.d>, Unit> r15 = new C02051(this, r19);
        C02062 r11 = C02062.INSTANCE;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r7, "toUserId");
        Intrinsics.checkNotNullParameter(r15, "successCallback");
        Intrinsics.checkNotNullParameter(r11, "failCallback");
        Disposable r2 = ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getHighScoreSongList(d5.c(r7), r7, 0, r9, 0, 10).compose(RxUtil.rxSchedulerHelper()).subscribe(new sd2.d(r1, r15), new sd2.e(r1, r11));
        if (r2 == null) goto L15;
        RxUtilKt.c(r2, this.compositeDisposable);
        return;
    L15:
        return;
    L10:
        r6 = "";
        goto L11
    }

    public void syncSecondLevelTabBanner(int r9) {
        long r0 = System.currentTimeMillis();
        long r2 = getRoom().getId();
        ArrayList r4 = new ArrayList();
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r5 = this.commonOrderSongViewModel;
        if (r5 == null) goto L15;
        List r10 = r5.getSecondLevelTabDataList(r9);
        if (r10 == null) goto L15;
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L15;
        Map r6 = ((com.bytedance.android.live.ktv.common.karaokestation.model.y) r11.next()).e;
        if (r6 == null) goto L8;
        int r7 = o0.a;
        String r8 = (String) r6.get("activity_id");
        if (r8 == null) goto L8;
        r4.add(Long.valueOf(CastLongProtector.parseLong(r8)));
    L15:
        if (r4.isEmpty() == false) goto L17;
        return;
    L17:
        String r12 = Arrays.toString(CollectionsKt.toLongArray(r4));
        String r13 = r12.substring(1, r12.length() - 1);
        int r14 = sd2.a.a;
        sd2.a r15 = sd2.a.b.a;
        Function1<com.bytedance.android.live.network.response.e<KtvActivityLinkResponse>, Unit> r16 = new C02072(this);
        C02083 r17 = C02083.INSTANCE;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r13, "activityIds");
        Intrinsics.checkNotNullParameter(r16, "successCallback");
        Intrinsics.checkNotNullParameter(r17, "failCallback");
        Disposable r18 = ((BannerApi) com.bytedance.android.live.network.c.b().e(BannerApi.class)).getActivityLinks(r2, r13, "ktv_banner").compose(RxUtil.rxSchedulerHelper()).subscribe(new sd2.b(r0, r16), new sd2.c(r0, r17));
        if (r18 == null) goto L28;
        RxUtilKt.c(r18, this.compositeDisposable);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void togglePause(final boolean r8) {
        if (jc0.a.c() == false) goto L10;
        long r0 = System.currentTimeMillis();
        if ((r0 - this.lastOperationTime) >= 2000) goto L8;
        showFrequencyControlPrompt();
        return;
    L8:
        this.lastOperationTime = r0;
        UtilityKotlinExtentionsKt.b(this, new C02111(r8));
        return;
    L10:
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L15;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r1 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) KtvContext.a.g().getKtvSingerViewModel().getValue();
        if (r1 == null) goto L24;
        r1.togglePause(r8);
        return;
    L24:
        return;
    L15:
        MusicPanel r2 = firstSelectedMusicOrNull();
        if (r2 == null) goto L26;
        Lazy r3 = KtvMusicControlManager.d;
        KtvMusicControlManager r4 = KtvMusicControlManager.a.a();
        com.bytedance.android.livesdk.ktvimpl.base.controlnode.d r5 = new com.bytedance.android.livesdk.ktvimpl.base.controlnode.d(r2, r8, getModeType());
        KSongNodeProcessCallback r9 = this.nodeProcessCallback;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "node");
        if (r9 == null) goto L20;
        r4.g(r5, r9);
    L20:
        r4.b.b(r5);
        Function1 r10 = r4.c;
        if (r10 == null) goto L27;
        Unit r11 = (Unit) r10.invoke(r5);
        return;
    L27:
        return;
    }

    public void tryApplyLink(MusicPanel r7) {
        Intrinsics.checkNotNullParameter(r7, "panel");
        int r0 = jc1.k.n(IInteractService.class).getCurrentScene();
        if (isAnchor() == true) goto L29;
        Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r1 != null) goto L8;
    L9:
        if (r0 != 0) goto L35;
    L11:
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L14;
        return;
    L14:
        if (jc0.a.c() == true) goto L36;
        this.isApplying = true;
        com.bytedance.android.livesdk.ktvimpl.base.util.e r2 = getKtvRoomStrategy();
        if (r2 == null) goto L20;
        r2.ktvApply(r7.a, r7.d, LinkApplyType.SONG, null);
    L20:
        if (isAnchor() == true) goto L31;
        KtvContext.Companion.getClass();
        n<oe2.b> r3 = KtvContext.a.g().getKtvRoomProvider();
        if (r3 == null) goto L32;
        oe2.b r4 = (oe2.b) r3.getValue();
        if (r4 != null) goto L26;
        return;
    L26:
        if (r4.m() != true) goto L34;
        cancelLinkWaitingStateSubscribleIfNeed();
        this.linkPlayerWaitingDisposable = createLinkWaitingStateObserver(r7);
        return;
    L34:
        return;
    L32:
        return;
    L31:
        return;
    L36:
        return;
    L35:
        return;
    L8:
        if (r1.intValue() == 0) goto L11;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void updateMusicPanelState(MusicPanel r3) {
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
        List r0 = r3.a.getTags();
        if (r0 == null) goto L5;
        r0.remove(s1.B(2131918383));
    L5:
        updateSelected(r3);
        updateFavorite(r3);
        updateSearchListState();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void updateOrderSongExtraInfo(td2.b r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.mOrderSongExtraInfo = r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void updateRequiredSongInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "requiredSongInfo");
        Intrinsics.checkNotNullParameter(r2, "requiredSongInfo");
    }

    public final void updateSecondTabInfoMap(com.bytedance.android.live.ktv.common.karaokestation.model.d r4) {
        Intrinsics.checkNotNullParameter(r4, "firstLevelTabData");
        Iterator r5 = r4.a.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L21;
        com.bytedance.android.live.ktv.common.karaokestation.model.y r0 = (com.bytedance.android.live.ktv.common.karaokestation.model.y) r5.next();
        if (Intrinsics.areEqual(r0.c, "sung") == true) goto L7;
        if (Intrinsics.areEqual(r0.c, "want_listen") == true) goto L10;
        if (Intrinsics.areEqual(r0.c, "mine_want_sing") == true) goto L13;
        if (Intrinsics.areEqual(r0.c, "multi_chorus") == true) goto L16;
        if (Intrinsics.areEqual(r0.c, "single_sing") == true) goto L19;
        this.secondTabInfoMap.put(r0.c, r0.d);
        goto L4
    L19:
        this.secondTabInfoMap.put(r0.c, "单人唱");
        goto L4
    L16:
        this.secondTabInfoMap.put(r0.c, "一起唱");
        goto L4
    L13:
        this.secondTabInfoMap.put(r0.c, "我的想唱");
        goto L4
    L10:
        this.secondTabInfoMap.put(r0.c, "听歌");
        goto L4
    L7:
        this.secondTabInfoMap.put(r0.c, "已唱");
        goto L4
    }

    public static final /* synthetic */ void access$handlePreDownloadMusicList(BaseOrderSongViewModel r0, List r1) {
        r0.handlePreDownloadMusicList(r1);
    }

    public static final /* synthetic */ void access$handleSongListChange(BaseOrderSongViewModel r0, List r1) {
        r0.handleSongListChange(r1);
    }

    public static final /* synthetic */ boolean access$isLinkModeGuest(BaseOrderSongViewModel r0, boolean r1) {
        return r0.isLinkModeGuest(r1);
    }

    public static final /* synthetic */ void access$logPlayAllSongSuccess(BaseOrderSongViewModel r0, MusicPanel r1) {
        r0.logPlayAllSongSuccess(r1);
    }

    public static final /* synthetic */ void access$setForceUpdateBanner$p(BaseOrderSongViewModel r0, boolean r1) {
        r0.forceUpdateBanner = r1;
    }

    public static final /* synthetic */ void access$setOpenLinkmic$p(BaseOrderSongViewModel r0, boolean r1) {
        r0.isOpenLinkmic = r1;
    }

    public static final /* synthetic */ void access$setRequestOrderedSongList$p(BaseOrderSongViewModel r0, boolean r1) {
        r0.isRequestOrderedSongList = r1;
    }

    public static final /* synthetic */ void access$updateKtvOrderedSongList(BaseOrderSongViewModel r0, List r1) {
        r0.updateKtvOrderedSongList(r1);
    }

    private final List<MusicPanel> getUpdatedOrderedListByApi(List<com.bytedance.android.live.ktv.common.model.api.h.a> r17, k0 r18) {
        ArrayList r1 = new ArrayList();
        String r2 = jc1.k.n(IMiddlewareUserService.class).user().n().toString();
        Iterator<T> r3 = r17.iterator();
    L4:
        if (r3.hasNext() == false) goto L43;
        com.bytedance.android.live.ktv.common.model.api.h.a r4 = (com.bytedance.android.live.ktv.common.model.api.h.a) r3.next();
        if (r4.b() == null) goto L4;
        Iterator<T> r5 = this.selfSelectedList.iterator();
    L9:
        String r7 = null;
        if (r5.hasNext() == false) goto L14;
        Object r6 = r5.next();
        KtvMusic r9 = r4.b();
        Intrinsics.checkNotNull(r9);
        if (KtvUtilsKt.t(r9, ((MusicPanel) r6).a) == false) goto L9;
    L15:
        MusicPanel r8 = (MusicPanel) r6;
        if (r8 == null) goto L34;
        KtvMusic r10 = r8.a;
        KtvMusic r11 = r4.b();
        Intrinsics.checkNotNull(r11);
        r10.setOrderInfo(r11.getOrderInfo());
        KtvMusic.a r12 = KtvMusic.Companion;
        KtvMusic r13 = r8.a;
        KtvMusic r14 = r4.b();
        Intrinsics.checkNotNull(r14);
        r12.getClass();
        KtvMusic.a.e(r13, r14);
        r8.e = r4.c();
        KtvMusic r15 = r8.a;
        KtvMusic r16 = r4.b();
        Intrinsics.checkNotNull(r16);
        r15.setSongType(r16.getSongType());
        String r19 = r8.a.getMidiUrl();
        boolean r20 = true;
        if (r19 != null) goto L20;
    L23:
        boolean r21 = true;
    L24:
        if (r21 == false) goto L33;
        KtvMusic r22 = r4.b();
        Intrinsics.checkNotNull(r22);
        String r23 = r22.getMidiUrl();
        if (r23 != null) goto L28;
    L31:
        if (r20 == true) goto L33;
        KtvMusic r24 = r8.a;
        KtvMusic r25 = r4.b();
        Intrinsics.checkNotNull(r25);
        r24.setMidiUrl(r25.getMidiUrl());
        goto L33
    L28:
        if (r23.length() == 0) goto L31;
        r20 = false;
    L33:
        KtvMusic r26 = r8.a;
        KtvMusic r27 = r4.b();
        Intrinsics.checkNotNull(r27);
        r26.setAddSongSource(r27.getAddSongSource());
        KtvMusic r28 = r8.a;
        KtvMusic r29 = r4.b();
        Intrinsics.checkNotNull(r29);
        r28.setWantListenInfo(r29.getWantListenInfo());
        KtvMusic r30 = r4.b();
        Intrinsics.checkNotNull(r30);
        String r31 = getFromRequestTypeByAddSongSource(r30.getAddSongSource());
        Intrinsics.checkNotNullParameter(r31, "<set-?>");
        r8.d = r31;
        r8.b = 4;
    L42:
        updateMultiChorusInfo(r4, r8, r18, r2);
        handlePlayAllSource(r8);
        r1.add(findLocalPath(r8));
        goto L4
    L20:
        if (r19.length() == 0) goto L23;
        r21 = false;
        goto L24
    L34:
        KtvMusic r32 = r4.b();
        Intrinsics.checkNotNull(r32);
        KtvMusic r33 = r4.b();
        if (r33 == null) goto L37;
        String r34 = r33.getAddSongSource();
    L38:
        String r110 = getFromRequestTypeByAddSongSource(r34);
        boolean r111 = r4.c();
        MusicPanel.MusicPanelSource r112 = MusicPanel.MusicPanelSource.KTV;
        com.bytedance.android.livesdk.chatroom.u r35 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r35 == null) goto L41;
        r7 = r35.w();
    L41:
        r8 = new MusicPanel(r32, 4, r110, r111, r112, r7, null, 1073741700);
        goto L42
    L37:
        r34 = null;
        goto L38
    L14:
        r6 = null;
        goto L15
    L43:
        return r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void addFavorite(final MusicPanel r14, final ic0.a r15) {
        Intrinsics.checkNotNullParameter(r14, "musicPanel");
        Intrinsics.checkNotNullParameter(r15, "favoriteCallback");
        mb0.d.e(r14);
        long r2 = System.currentTimeMillis();
        final long r10 = r14.a.getMId();
        int r0 = r14.a.getSongType();
        int r1 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
        Disposable r16 = com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a.a(r2, r10, r0, new AnonymousClass1(this, r10, r14, r15), AnonymousClass2.INSTANCE);
        if (r16 == null) goto L6;
        RxUtilKt.c(r16, this.compositeDisposable);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void delFavorite(final MusicPanel r14, final ic0.a r15) {
        Intrinsics.checkNotNullParameter(r14, "musicPanel");
        Intrinsics.checkNotNullParameter(r15, "favoriteCallback");
        mb0.d.e(r14);
        long r2 = System.currentTimeMillis();
        final long r10 = r14.a.getMId();
        int r0 = r14.a.getSongType();
        int r1 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
        Disposable r16 = com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a.c(r2, r10, r0, new C01921(this, r10, r14, r15), C01932.INSTANCE);
        if (r16 == null) goto L6;
        RxUtilKt.c(r16, this.compositeDisposable);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void observeCurFavoriteMusic(LifecycleOwner r2, com.ss.android.ugc.aweme.compat.nullable.Observer<MusicPanel> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.curFavoriteMusic.observe(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void observeCurOrderedMusic(LifecycleOwner r2, com.ss.android.ugc.aweme.compat.nullable.Observer<MusicPanel> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.curOrderedMusic.observe(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void observeMusicPlayerState(LifecycleOwner r3, com.ss.android.ugc.aweme.compat.nullable.Observer<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "observer");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void observeSecondLevelTabBanner(LifecycleOwner r2, com.ss.android.ugc.aweme.compat.nullable.Observer<Map<String, LabelBannerUrl>> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.labelBanner.observe(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void observeSungOrderCount(LifecycleOwner r2, com.ss.android.ugc.aweme.compat.nullable.Observer<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.sungSongData.c.observe(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void orderPlayAllSong(final List<MusicPanel> r22, final com.bytedance.android.live.ktv.common.karaokestation.model.y r23) {
        Intrinsics.checkNotNullParameter(r22, "unSelectedMusicList");
        if ((obtainSingState() instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L6;
        ALogger.i(bb0.b.b(), "orderPlayAllSong, ktv has closed!, invoke class :BaseOrderSongViewModel");
        return;
    L6:
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r22.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r3.add(Long.valueOf(((MusicPanel) r4.next()).a.getMId()));
        goto L8
    L10:
        String r18 = new JSONArray(r3).toString();
        String r5 = "orderPlayAllSong, song list size: " + r3.size();
        ALogger.i(bb0.b.b(), r5 + ", invoke class :BaseOrderSongViewModel");
        int r6 = mb0.f.a;
        int r7 = r3.size();
        if (r23 == null) goto L13;
        String r8 = r23.c;
    L14:
        JSONObject r11 = new JSONObject();
        r11.put("size", r7);
        if (r8 == null) goto L17;
        r11.put("source", r8);
    L17:
        int r9 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.AddSongChain, "addSongAll", 0, null, r11, 88);
        long r10 = System.currentTimeMillis();
        int r12 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
        Disposable r1 = com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a.b(r10, getRoom().getId(), getRoom().getId(), 0, 0, Intrinsics.stringPlus(getAddSongSource$default(this, null, 1, null), "_multi"), "", "", r18, new C01992(this, r22, r23), new C02003(this));
        if (r1 == null) goto L22;
        RxUtilKt.c(r1, this.compositeDisposable);
        return;
    L22:
        return;
    L13:
        r8 = null;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void permitWaitingSongUser(com.bytedance.android.live.ktv.common.model.bean.d r3, com.bytedance.android.live.ktv.common.karaokestation.model.y r4) {
        Intrinsics.checkNotNullParameter(r3, "waitingUser");
        Intrinsics.checkNotNullParameter(r4, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r3, "waitingUser");
        Intrinsics.checkNotNullParameter(r4, "secondLevelTabData");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void removeWaitingSongUser(com.bytedance.android.live.ktv.common.model.bean.d r3, com.bytedance.android.live.ktv.common.karaokestation.model.y r4) {
        Intrinsics.checkNotNullParameter(r3, "waitingUser");
        Intrinsics.checkNotNullParameter(r4, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r3, "waitingUser");
        Intrinsics.checkNotNullParameter(r4, "secondLevelTabData");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void sortSecondLevelTabByType(String r3, com.bytedance.android.live.ktv.common.karaokestation.model.y r4) {
        Intrinsics.checkNotNullParameter(r3, "sortType");
        Intrinsics.checkNotNullParameter(r4, "data");
        this.currentSortType = r3;
        if (this.recentlyMusicListBySingTime.isEmpty() == false) goto L8;
        if ((!r4.h.isEmpty()) == false) goto L8;
        this.recentlyMusicListBySingTime.addAll(r4.h);
    L8:
        if (Intrinsics.areEqual(r3, com.bytedance.android.live.ktv.common.util.f.a) == false) goto L12;
        CollectionsKt.sortWith(r4.h, m.a);
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r5 = this.commonOrderSongViewModel;
        if (r5 == null) goto L21;
        r5.updateSongListData(r4);
        return;
    L21:
        return;
    L12:
        List<MusicPanel> r6 = this.recentlyMusicListBySingTime;
        if ((!r6.isEmpty()) == true) goto L16;
        r6 = null;
    L16:
        if (r6 == null) goto L23;
        r4.h.clear();
        r4.h.addAll(r6);
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r7 = this.commonOrderSongViewModel;
        if (r7 == null) goto L24;
        r7.updateSongListData(r4);
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void syncSungSongList(final boolean r8, final Function1<? super Boolean, Unit> r9) {
        c r0 = this.sungSongData;
        if (r0.a == false) goto L5;
        return;
    L5:
        r0.a = true;
        long r1 = System.currentTimeMillis();
        long r2 = getRoom().getId();
        if (r8 == true) goto L8;
        this.sungSongData.b = null;
    L8:
        final String r4 = this.sungSongData.b;
        int r5 = sd2.a.a;
        sd2.a r6 = sd2.a.b.a;
        Function1<com.bytedance.android.live.network.response.e<com.bytedance.android.live.ktv.common.model.api.l>, Unit> r7 = new C02091(this, r8, r4, r9);
        Function1<Throwable, Unit> r10 = new C02102(this, r9);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "successCallback");
        Intrinsics.checkNotNullParameter(r10, "failCallback");
        Disposable r11 = ((KSongAnchorApi) com.bytedance.android.live.network.c.b().e(KSongAnchorApi.class)).getSungSongList(r2, r4).compose(RxUtil.rxSchedulerHelper()).subscribe(new sd2.h(r1, r7), new sd2.i(r1, r10));
        if (r11 == null) goto L12;
        RxUtilKt.c(r11, this.compositeDisposable);
        return;
    }

    public final List<MusicPanel> trans2MusicPanel(List<KtvMusic> r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "$this$trans2MusicPanel");
        Intrinsics.checkNotNullParameter(r13, "tabDescription");
        ArrayList r0 = new ArrayList();
        Iterator<KtvMusic> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        KtvMusic r3 = r14.next();
        KtvUtilsKt.c(r3);
        MusicPanel r1 = new MusicPanel(r3, 1, r13, false, MusicPanel.MusicPanelSource.KTV, null, null, 1073741780);
        updateMusicPanelState(r1);
        r0.add(r1);
        goto L4
    L6:
        return r0;
    }

    public BaseOrderSongViewModel(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r1, com.bytedance.android.live.ktv.common.search.viewmodel.a r2, OrderedSongDataContext r3) {
        this.commonOrderSongViewModel = r1;
        this.commonSearchViewModel = r2;
        this.mOrderedSongDataContext = r3;
        this.lifecycleRegistry = new LifecycleRegistry(this);
        this.secondTabInfoMap = new LinkedHashMap();
        this.dataCenter$delegate = LazyKt.lazy(BaseOrderSongViewModel$dataCenter$2.INSTANCE);
        this.curFavoriteMusic = new MutableLiveData();
        this.curOrderedMusic = new MutableLiveData();
        this.linkWaitingOrderedSongList = new ArrayList();
        this.sungSongData = new c();
        this.wantSingData = new d();
        this.recentlyMusicListBySingTime = new ArrayList();
        this.currentSortType = com.bytedance.android.live.ktv.common.util.f.b;
        MutableLiveData<vb0.a> r4 = new MutableLiveData();
        r4.setValue(new vb0.a(0));
        Unit r5 = Unit.INSTANCE;
        this.mOrderSongUiState = r4;
        this.room$delegate = LazyKt.lazy(BaseOrderSongViewModel$room$2.INSTANCE);
        this.labelBanner = new MutableLiveData();
        this.selfDownloadList = new ArrayList();
        this.selfSelectedList = new ArrayList();
        this.downloadedInWifi = new LinkedHashSet();
        this.isAnchor$delegate = LazyKt.lazy(C01962.INSTANCE);
        this.compositeDisposable = new CompositeDisposable();
        this.linkPlayerWaitingObserverTime = ((Number) vm2.h.H0.getValue(null, vm2.h.a[84])).longValue();
        this.lrcCacheFactory$delegate = LazyKt.lazy(BaseOrderSongViewModel$lrcCacheFactory$2.INSTANCE);
        this.accompanimentTrackFactory$delegate = LazyKt.lazy(BaseOrderSongViewModel$accompanimentTrackFactory$2.INSTANCE);
        this.fullTrackCacheFactory$delegate = LazyKt.lazy(BaseOrderSongViewModel$fullTrackCacheFactory$2.INSTANCE);
        this.midiCacheFactory$delegate = LazyKt.lazy(BaseOrderSongViewModel$midiCacheFactory$2.INSTANCE);
        this.videoFactory$delegate = LazyKt.lazy(BaseOrderSongViewModel$videoFactory$2.INSTANCE);
        this.midiFactory$delegate = LazyKt.lazy(BaseOrderSongViewModel$midiFactory$2.INSTANCE);
        this.vocalCacheFactory$delegate = LazyKt.lazy(BaseOrderSongViewModel$vocalCacheFactory$2.INSTANCE);
        this.nodeProcessCallback = new KSongNodeProcessCallback(this);
        this.linkStateObserver = new l(this);
        this.linkInRoomObserver = new k(this);
    }

    public static final /* synthetic */ List access$getUpdatedOrderedListByApi(BaseOrderSongViewModel r0, List r1, k0 r2) {
        return r0.getUpdatedOrderedListByApi(r1, r2);
    }

    private final void realJumpToChorusRoom(long r4, boolean r6, List<Long> r7) {
        StringBuilder r0 = new StringBuilder("sslocal://webcast_room?room_id=");
        r0.append(r4);
        r0.append("&enter_from_merge=");
        EnterRtChorusRoomSource r1 = EnterRtChorusRoomSource.ANCHOR_KSONG;
        r0.append((String) r1.getPair().getFirst());
        r0.append("&enter_method=");
        r0.append((String) r1.getPair().getSecond());
        String r2 = r0.toString();
        if (r6 == false) goto L5;
        r2 = r2 + "&auto_link_mic=" + r6 + "&action=join_chorus";
    L5:
        JSONArray r8 = new JSONArray();
        r8.put(r4);
        if (Lists.notEmpty(r7) == false) goto L12;
        if (r7 == null) goto L12;
        Iterator<T> r5 = r7.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r8.put(((Number) r5.next()).longValue());
    L12:
        String r9 = r2 + "&enable_feed_drawer=1&room_id_list=" + r8.toString();
        IMiddlewareHostApp r10 = jc1.k.f(IMiddlewareHostApp.class);
        if (r10 == null) goto L15;
        Activity r11 = r10.getTopActivity();
    L16:
        if (r11 == null) goto L22;
        IMiddlewareLiveService r12 = TTLiveServiceMiddleware.getLiveService();
        if (r12 == null) goto L23;
        r12.handleSchema(r11, UriProtector.parse(r9));
        return;
    L23:
        return;
    L22:
        return;
    L15:
        r11 = null;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void applyWantListen(Context r4, MusicPanel r5, RecyclerView.ViewHolder r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "musicPanel");
        Intrinsics.checkNotNullParameter(r6, "viewHolder");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "musicPanel");
        Intrinsics.checkNotNullParameter(r6, "viewHolder");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void observeSingUserChange(LifecycleOwner r1, boolean r2, Consumer<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        Intrinsics.checkNotNullParameter(r3, "observer");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void onItemClick(Context r2, MusicPanel r3, RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void removeMusic(final MusicPanel r23, final boolean r24, final Boolean r25) {
        Intrinsics.checkNotNullParameter(r23, "musicPanel");
        OrderedSongDataContext r0 = this.mOrderedSongDataContext;
        if (r0 == null) goto L5;
        MusicPanel r1 = r0.getKtvPublicFirstOrderedSong();
    L6:
        if (r1 != null) goto L8;
        final boolean r4 = false;
    L9:
        pd2.d.y(r23.a.getMId(), "start_cut");
        long r8 = System.currentTimeMillis();
        int r2 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
        com.bytedance.android.live.ktv.common.karaokestation.model.g r10 = com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a;
        long r11 = getRoom().getId();
        long r13 = getRoom().getId();
        long r15 = r23.a.getMId();
        OrderInfo r3 = r23.a.getOrderInfo();
        if (r3 == null) goto L15;
        InteractiveSongUserInfo r5 = r3.getTopUser();
        if (r5 == null) goto L15;
        String r6 = r5.getIdString();
        if (r6 == null) goto L15;
    L16:
        Disposable r7 = r10.e(r8, r11, r13, r15, r6, false, r23.a.getSongType(), KtvUtilsKt.i(r23), new C02031(this, r23, r24, r4, r25), new C02042(r23));
        if (r7 == null) goto L20;
        RxUtilKt.c(r7, this.compositeDisposable);
        return;
    L20:
        return;
    L15:
        r6 = "";
        goto L16
    L8:
        r4 = r23.a.isSameKtvMusic(r1.a);
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public static final /* synthetic */ void access$realJumpToChorusRoom(BaseOrderSongViewModel r0, long r1, boolean r3, List r4) {
        r0.realJumpToChorusRoom(r1, r3, r4);
    }

    public static /* synthetic */ String getAddSongSource$default(BaseOrderSongViewModel r0, MusicPanel r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = null;
    L7:
        return r0.getAddSongSource(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAddSongSource");
    }

    private final void updateMultiChorusInfo(com.bytedance.android.live.ktv.common.model.api.h.a r9, MusicPanel r10, k0 r11, String r12) {
        KtvMusic r0 = r9.b();
        RealTimeChorusInfo r1 = null;
        if (r0 == null) goto L27;
        OrderInfo r2 = r0.getOrderInfo();
        if (r2 == null) goto L27;
        InteractiveSongUserInfo r3 = r2.getTopUser();
        if (r3 == null) goto L27;
        String r4 = r3.getIdString();
        if (r4 == null) goto L27;
        ig r5 = r9.a();
        if (r5 == null) goto L16;
        List r6 = r5.b();
        if (r6 == null) goto L16;
        if (r6.contains(r4) == true) goto L27;
    L16:
        ig r7 = r9.a();
        if (r7 == null) goto L27;
        ig r8 = r9.a();
        if (r8 == null) goto L25;
        List r13 = r8.b();
        if (r13 == null) goto L25;
        List r14 = CollectionsKt.toMutableList(r13);
        if (r14 == null) goto L25;
        r14.add(r4);
        Unit r15 = Unit.INSTANCE;
    L26:
        r7.c(r14);
    L25:
        r14 = null;
    L27:
        ig r16 = r9.a();
        if (r16 == null) goto L30;
        boolean r17 = r16.a();
    L31:
        r10.D = r17;
        int r18 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.a;
        ig r19 = r9.a();
        if (r19 == null) goto L35;
        List r20 = r19.b();
        if (r20 == null) goto L35;
    L36:
        KtvMusic r21 = r9.b();
        if (r21 == null) goto L44;
        OrderInfo r22 = r21.getOrderInfo();
        if (r22 == null) goto L44;
        InteractiveSongUserInfo r23 = r22.getTopUser();
        if (r23 == null) goto L44;
        String r24 = r23.getIdString();
        if (r24 == null) goto L44;
    L45:
        Intrinsics.checkNotNullParameter(r20, "uids");
        Intrinsics.checkNotNullParameter(r24, "orderUid");
        Intrinsics.checkNotNullParameter(r12, "curUserId");
        if (r11 != null) goto L48;
        HashMap r110 = new HashMap();
    L79:
        Intrinsics.checkNotNullParameter(TAG, LocationMonitorConst.TAG);
        r10.B = r110;
        KtvMusic r25 = r9.b();
        if (r25 == null) goto L82;
        r1 = r25.getRealTimeChorusInfo();
    L82:
        r10.C = r1;
        return;
    L48:
        HashMap r26 = new HashMap();
        Map r111 = r11.a();
        Iterator r27 = r20.iterator();
    L50:
        if (r27.hasNext() == false) goto L63;
        String r28 = (String) r27.next();
        if (Intrinsics.areEqual(r28, r12) == true) goto L50;
        if (Intrinsics.areEqual(r28, r24) == true) goto L50;
        if (r111 == null) goto L50;
        if (r111.containsKey(r28) != true) goto L50;
        Object r29 = r111.get(r28);
        Intrinsics.checkNotNull(r29);
        if (((l0) r29).a() == null) goto L50;
        Object r30 = r111.get(r28);
        Intrinsics.checkNotNull(r30);
        py.k r31 = ((l0) r30).a();
        Intrinsics.checkNotNull(r31);
        r26.put(r28, r31);
        goto L50
    L63:
        if (r20.contains(r12) == false) goto L71;
        if (r111 == null) goto L71;
        if (r111.containsKey(r12) != true) goto L71;
        Object r32 = r111.get(r12);
        Intrinsics.checkNotNull(r32);
        if (((l0) r32).a() == null) goto L71;
        Object r33 = r111.get(r12);
        Intrinsics.checkNotNull(r33);
        py.k r34 = ((l0) r33).a();
        Intrinsics.checkNotNull(r34);
        r26.put(r12, r34);
    L71:
        if (r20.contains(r24) == false) goto L78;
        if (r111 == null) goto L78;
        if (r111.containsKey(r24) != true) goto L78;
        Object r112 = r111.get(r24);
        Intrinsics.checkNotNull(r112);
        if (((l0) r112).a() == null) goto L78;
        Object r113 = r111.get(r24);
        Intrinsics.checkNotNull(r113);
        py.k r114 = ((l0) r113).a();
        Intrinsics.checkNotNull(r114);
        r26.put(r24, r114);
    L78:
        r110 = r26;
    L44:
        r24 = "";
    L35:
        r20 = CollectionsKt.emptyList();
        goto L36
    L30:
        r17 = false;
        goto L31
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void addSong(Context r11, MusicPanel r12, RecyclerView.ViewHolder r13, com.bytedance.android.live.ktv.common.music.control.b r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "musicPanel");
        if (KtvSettingHelper.n().booleanValue() == true) goto L6;
        f2.b(2131918463, 0);
        return;
    L6:
        if (r14 == null) goto L8;
        ModeType r15 = getModeType();
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        ((com.bytedance.android.live.ktv.common.music.control.d) r14).e = r15;
    L10:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(getDataCenter()).isPaidLive() == true) goto L12;
    L15:
        StringBuilder r16 = new StringBuilder("addSong ;; songId: ");
        MusicPanel r1 = ((com.bytedance.android.live.ktv.common.music.control.d) r14).d;
        Long r2 = null;
        if (r1 == null) goto L20;
        KtvMusic r3 = r1.a;
        if (r3 == null) goto L20;
        Long r4 = Long.valueOf(r3.getMId());
    L21:
        r16.append(r4.longValue());
        r16.append(", title: ");
        MusicPanel r5 = ((com.bytedance.android.live.ktv.common.music.control.d) r14).d;
        if (r5 == null) goto L26;
        KtvMusic r6 = r5.a;
        if (r6 == null) goto L26;
        String r7 = r6.getMTitle();
    L27:
        r16.append(r7);
        ALogger.i(TAG, r16.toString());
        int r17 = mb0.f.a;
        String r18 = getAddSongSource(((com.bytedance.android.live.ktv.common.music.control.d) r14).d);
        Intrinsics.checkNotNullParameter(r12, "musicPanel");
        JSONObject r8 = new JSONObject();
        mb0.f.b(r12, r8);
        if (r18 == null) goto L30;
        r8.put("source", r18);
    L30:
        int r19 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.AddSongChain, "addSongAction", 0, null, r8, 88);
        com.bytedance.android.livesdk.ktvimpl.base.util.e r110 = getKtvRoomStrategy();
        if (r110 == null) goto L39;
        MusicPanel r0 = ((com.bytedance.android.live.ktv.common.music.control.d) r14).d;
        if (r0 == null) goto L37;
        KtvMusic r9 = r0.a;
        if (r9 == null) goto L37;
        Long r10 = Long.valueOf(r9.getMId());
    L38:
        r110.checkAudienceSingEnablePermission(r10, new e(this, r14, r12, r11));
    L37:
        r10 = null;
    L39:
        pd2.d r111 = pd2.d.n;
        MusicPanel r112 = ((com.bytedance.android.live.ktv.common.music.control.d) r14).d;
        r111.getClass();
        if (r112 == null) goto L57;
        JSONObject r113 = new JSONObject();
        KtvMusic r114 = r112.a;
        if (r114 == null) goto L44;
        r2 = Long.valueOf(r114.getMId());
    L44:
        JSONObject r115 = mb0.b.p(r113, r2.longValue());
        int r116 = r112.a.getMLyricType();
        Intrinsics.checkNotNullParameter(r115, "$this$putLyricsType");
        JSONObject r117 = r115.put("lyrics_type", r116);
        String r118 = r112.a.getMTitle();
        String r119 = "";
        if (r118 != null) goto L47;
        r118 = "";
    L47:
        JSONObject r120 = mb0.b.q(r117, r118);
        mb0.b.l(r120, r112);
        KtvMusic r121 = r112.a;
        if (r121 == null) goto L55;
        List r122 = r121.getMLyricUrlList();
        if (r122 == null) goto L55;
        String r123 = (String) CollectionsKt.firstOrNull(r122);
        if (r123 == null) goto L55;
        r119 = r123;
    L55:
        pd2.d.w(LinkMonitorData.BusinessOrderSongAction, mb0.b.o(r120, r119));
        return;
    L57:
        return;
    L26:
        r7 = null;
    L20:
        r4 = null;
        goto L21
    L12:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(getDataCenter()).e1(PaidSceneEnum.PAID_ROOM) == true) goto L15;
        pd2.d.n.getClass();
        pd2.d.s(r12, pd2.d.g);
        f2.b(2131921182, 0);
        return;
    L8:
        r14 = new AddMusicControlNode(r12, r13, getModeType());
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void checkRTChorusPermissionInfoIfNeed(Throwable r1, int r2, RTChorusOperateType r3, MusicPanel r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TYPE);
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TYPE);
    }

    public final void updateSecondLevelTabDataList(boolean r3, boolean r4, FirstLevelTab r5, String r6, List<? extends Object> r7, List<MusicPanel> r8) {
        Intrinsics.checkNotNullParameter(r5, "firstLevelTab");
        Intrinsics.checkNotNullParameter(r6, "tabName");
        Intrinsics.checkNotNullParameter(r7, "businessList");
        Intrinsics.checkNotNullParameter(r8, "musicList");
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.commonOrderSongViewModel;
        if (r0 == null) goto L5;
        com.bytedance.android.live.ktv.common.karaokestation.model.y r9 = r0.getSecondLevelTabDataByParams(r5.getValue(), r6);
    L6:
        if (r9 == null) goto L11;
        r9.l = r3;
        if (r4 == true) goto L10;
        r9.i.clear();
        r9.h.clear();
    L10:
        r9.i.addAll(r7);
        r9.h.addAll(r8);
    L11:
        if (r9 == null) goto L21;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r10 = this.commonOrderSongViewModel;
        if (r10 == null) goto L15;
        r10.updateSongListData(r9);
    L15:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r11 = this.commonOrderSongViewModel;
        if (r11 == null) goto L22;
        com.bytedance.android.live.ktv.common.karaokestation.model.d r12 = r11.getFirstLevelTabDataByTopValue(r5.getValue());
        if (r12 == null) goto L23;
        updateSecondTabInfoMap(r12);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r9 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateSecondLevelTabDataList$default(BaseOrderSongViewModel r7, boolean r8, boolean r9, FirstLevelTab r10, String r11, List r12, List r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 16) == 0) goto L6;
        r12 = new ArrayList();
    L6:
        List r5 = r12;
        if ((r14 & 32) == 0) goto L9;
        r13 = new ArrayList();
    L9:
        r7.updateSecondLevelTabDataList(r8, r9, r10, r11, r5, r13);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSecondLevelTabDataList");
    }
}
