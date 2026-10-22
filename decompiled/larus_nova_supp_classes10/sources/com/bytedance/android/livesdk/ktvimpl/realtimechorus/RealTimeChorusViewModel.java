package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.music.control.KtvMusicControlManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.s2;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.nf1;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.base.controlnode.CutMusicControlNode;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.api.RealTimeChorusApi;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.RealTimeChorusInfo;
import com.bytedance.android.livesdk.message.model.jd;
import com.bytedance.android.livesdk.message.model.kd;
import com.bytedance.android.livesdk.message.model.l2;
import com.bytedance.android.livesdk.message.model.z2;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.RealTimeChorusUIInfo;
import com.bytedance.android.livesdkapi.depend.message.RealTimeChorusUIInfoKt;
import com.bytedance.android.livesdkapi.depend.message.UserChorusInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002®\u0001\u0018\u0000 Ä\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002Å\u0001B\u001d\u0012\b\u0010·\u0001\u001a\u00030¶\u0001\u0012\b\u0010¼\u0001\u001a\u00030»\u0001¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\rH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u0010!\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\"\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\nH\u0002J?\u0010,\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020%2#\u0010+\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0004\u0018\u00010'H\u0002J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0010\u0010/\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\rH\u0002J\u0010\u00101\u001a\u00020\u00102\u0006\u00100\u001a\u00020\nH\u0002J\u0010\u00102\u001a\u00020\u00102\u0006\u00100\u001a\u00020\nH\u0002J\b\u00103\u001a\u00020\u0004H\u0002J\u0010\u00105\u001a\u00020\r2\u0006\u00104\u001a\u00020\rH\u0002J\u0010\u00106\u001a\u00020\u00102\u0006\u00104\u001a\u00020\rH\u0002J\u0006\u00107\u001a\u00020\u0010J\u000e\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208J\u0006\u0010;\u001a\u00020\u0004J\u0012\u0010=\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010?\u001a\u00020\u00042\u0006\u00109\u001a\u0002082\f\u0010>\u001a\b\u0012\u0004\u0012\u00020#0\u0002J>\u0010E\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\n2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u00040'2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u00040'2\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010F\u001a\u00020\u0010J\u0006\u0010G\u001a\u00020\u0010J\b\u0010I\u001a\u0004\u0018\u00010HJ\u0006\u0010J\u001a\u00020#J\u0006\u0010K\u001a\u00020#J$\u0010N\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010L\u001a\u0004\u0018\u00010\r2\b\u0010M\u001a\u0004\u0018\u00010\rJ\u0006\u0010O\u001a\u00020\u0010J\u0006\u0010P\u001a\u00020\u0010J\u0016\u0010R\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\rJ\u0016\u0010T\u001a\u00020\u00042\u0006\u0010S\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010U\u001a\u00020\rJE\u0010X\u001a\u00020\u00042\u0006\u0010W\u001a\u00020V2\u0006\u0010$\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020%2#\u0010+\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0004\u0018\u00010'J$\u0010_\u001a\u00020\u00042\u001c\u0010^\u001a\u0018\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\\0Yj\u0002`]J\u0006\u0010`\u001a\u00020#J\u0006\u0010a\u001a\u00020\u0010J\u0006\u0010b\u001a\u00020#J\u0006\u0010c\u001a\u00020\u0004J\b\u0010d\u001a\u00020\u0004H\u0014J&\u0010h\u001a\u00020\u00042\u0006\u0010e\u001a\u00020\r2\u0006\u0010f\u001a\u00020%2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010gR\u0016\u0010i\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010jR\u0014\u0010m\u001a\u00020l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\"\u0010o\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001d\u0010v\u001a\b\u0012\u0004\u0012\u00020\r0u8\u0006¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bU\u0010xR\"\u0010y\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010p\u001a\u0004\bz\u0010r\"\u0004\b{\u0010tR\u001d\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00100u8\u0006¢\u0006\f\n\u0004\b|\u0010w\u001a\u0004\b|\u0010xR\u001d\u0010}\u001a\b\u0012\u0004\u0012\u00020\r0u8\u0006¢\u0006\f\n\u0004\b}\u0010w\u001a\u0004\b~\u0010xR'\u0010\u007f\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R*\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R*\u0010\u008c\u0001\u001a\u00030\u0085\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u0087\u0001\u001a\u0006\b\u008d\u0001\u0010\u0089\u0001\"\u0006\b\u008e\u0001\u0010\u008b\u0001R-\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100u8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u008f\u0001\u0010w\u001a\u0005\b\u008f\u0001\u0010x\"\u0006\b\u0090\u0001\u0010\u0091\u0001R-\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020#0u8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0092\u0001\u0010w\u001a\u0005\b\u0093\u0001\u0010x\"\u0006\b\u0094\u0001\u0010\u0091\u0001R?\u0010\u0097\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r0\u0095\u0001j\t\u0012\u0004\u0012\u00020\r`\u0096\u00010u8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0097\u0001\u0010w\u001a\u0005\b\u0098\u0001\u0010x\"\u0006\b\u0099\u0001\u0010\u0091\u0001R-\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020#0u8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u009a\u0001\u0010w\u001a\u0005\b\u009b\u0001\u0010x\"\u0006\b\u009c\u0001\u0010\u0091\u0001R\u0018\u0010\u009d\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010jR\u001c\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020#0u8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010wR \u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100u8\u0006¢\u0006\u000e\n\u0005\b\u009f\u0001\u0010w\u001a\u0005\b\u009f\u0001\u0010xR\u0016\u0010G\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010jR\u001b\u0010 \u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001b\u0010¤\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010£\u0001R\u0018\u0010¥\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¥\u0001\u0010jR\u0018\u0010¦\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¦\u0001\u0010jR\u0019\u0010§\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u0018\u0010©\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b©\u0001\u0010jR\u0018\u0010ª\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bª\u0001\u0010jR\u001e\u0010L\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0005\b\u00ad\u0001\u0010rR\u001a\u0010¯\u0001\u001a\u00030®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u001a\u0010²\u0001\u001a\u00030±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u0018\u0010´\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b´\u0001\u0010pR\u001b\u0010µ\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010£\u0001R\u001d\u0010·\u0001\u001a\u00030¶\u00018\u0006¢\u0006\u0010\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001R*\u0010¼\u0001\u001a\u00030»\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001¨\u0006Æ\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "", "handleLinkSuccessEvent", "Lcom/bytedance/android/livesdk/message/model/l2;", "finishContent", "onReceiverFinish", "updateChorusMode", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "topMusic", "handleJoinLeaveChorusLog", "", "leaderId", "updateLeaderSingerId", "", "isEngineOn", "liveCoreExtInfo", "rtcExtInfo", "isNeedAutoPublish", "applySilenceLink", "source", "initLiveClient", "stopLiveClient", "updateRealTimeChorusInfo", "updateAssignLead", "isLeader", "checkDuplicate", "updateChorusLeader", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/KtvModeOrderedSongDataContext;", "getOrderedSongDataContext", "musicPanel", "isLocalJoined", "isPreJoined", "", "leaveType", "", "chorusId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "callback", "realLeave", "checkAutoJoin", "chorusIdStr", "shouldReturnDueToChorusId", "topMusicPanel", "shouldReturnDueToSongList", "shouldAutoJoin", "cdnSingerLeave", "uid", "getInteractIdByUid", "isUserOnLine", "isPermanentLinkGuest", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "observerKtvOrderedSongList", "handleSongListChange", "t", "onChanged", "observer", "observerCurUserRealTimeChorusRole", "panel", "", "successCallback", "", "failCallback", "joinRealTimeChorus", "isJoinUnPublish", "curUserIsLead", "Lcom/bytedance/android/livesdkapi/depend/message/RealTimeChorusUIInfo;", "getLastChorusInfo", "getCurrentUserChorusRole", "getUserChorusRole", "curUserId", "topUserId", "isNeedCheckOrder", "isCDNViceSinger", "isSilenceViceSinger", "role", "updateRole", "userType", "updateChorusUserType", "getLeadSingerUid", "", "segmentAvgScore", "leaveRealTimeChorus", "Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/ValidLyricsStateTransition;", "valid", "handleStateChanged", "getCurrentChorusMode", "isAssignLead", "getCurChorusUserCount", "clearInfo", "onCleared", "toUsers", "status", "Lkotlin/Function0;", "updateRealtimeChorusGuestStatus", "isLinkGuest", "Z", "shouldRestoreSilenceStatus", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "lastLeaderSingerID", "Ljava/lang/String;", "getLastLeaderSingerID", "()Ljava/lang/String;", "setLastLeaderSingerID", "(Ljava/lang/String;)V", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "leadSingerUid", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "lastLeaderInteractId", "getLastLeaderInteractId", "setLastLeaderInteractId", "isNeedPush", "subToken", "getSubToken", "lastRole", "I", "getLastRole", "()I", "setLastRole", "(I)V", "Lfd2/b0;", "localChorusJoinStatus", "Lfd2/b0;", "getLocalChorusJoinStatus", "()Lfd2/b0;", "setLocalChorusJoinStatus", "(Lfd2/b0;)V", "localPreChorusJoinStatus", "getLocalPreChorusJoinStatus", "setLocalPreChorusJoinStatus", "isChorusAssignLeader", "setChorusAssignLeader", "(Lcom/bytedance/ies/sdk/widgets/NextLiveData;)V", "chorusUserType", "getChorusUserType", "setChorusUserType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "chorusSpatialList", "getChorusSpatialList", "setChorusSpatialList", "chorusMode", "getChorusMode", "setChorusMode", "isLeaving", "curUserRealTimeChorusRole", "isPlayingMusic", "lastChorusInfo", "Lcom/bytedance/android/livesdkapi/depend/message/RealTimeChorusUIInfo;", "singMusic", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "lastTopMusicForLog", "isAutoJoin", "isJoining", "maxChorusNumber", "J", "hasJoined", "waitJoinUntilSingMusicChange", "curUserId$delegate", "Lkotlin/Lazy;", "getCurUserId", "com/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusViewModel$g", "handler", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusViewModel$g;", "Lvlc/l;", "msgListener", "Lvlc/l;", "lastChorusId", "lastTopMusicPanel", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "f", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusViewModel extends ViewModel implements Observer<KVData> {
    public static final f Companion = null;
    public static final long DELAY_DURATION = 100;
    public static final int MSG_UPDATE_REAL_TIME_CHORUS_INFO_LIST = 1;
    public static final String TAG = "RealTimeChorusViewModel";
    private NextLiveData<Integer> chorusMode;
    private NextLiveData<ArrayList<String>> chorusSpatialList;
    private NextLiveData<Integer> chorusUserType;
    private final CompositeDisposable compositeDisposable;
    private final Context context;
    private final Lazy curUserId$delegate;
    private boolean curUserIsLead;
    private final NextLiveData<Integer> curUserRealTimeChorusRole;
    private DataCenter dataCenter;
    private g handler;
    private boolean hasJoined;
    private boolean isAutoJoin;
    private NextLiveData<Boolean> isChorusAssignLeader;
    private boolean isJoining;
    private boolean isLeaving;
    private boolean isLinkGuest;
    private final NextLiveData<Boolean> isNeedPush;
    private final NextLiveData<Boolean> isPlayingMusic;
    private String lastChorusId;
    private RealTimeChorusUIInfo lastChorusInfo;
    private String lastLeaderInteractId;
    private String lastLeaderSingerID;
    private int lastRole;
    private MusicPanel lastTopMusicForLog;
    private MusicPanel lastTopMusicPanel;
    private final NextLiveData<String> leadSingerUid;
    private fd2.b0 localChorusJoinStatus;
    private fd2.b0 localPreChorusJoinStatus;
    private long maxChorusNumber;
    private vlc.l msgListener;
    private boolean shouldRestoreSilenceStatus;
    private MusicPanel singMusic;
    private final NextLiveData<String> subToken;
    private boolean waitJoinUntilSingMusicChange;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusViewModel a;

        public a(RealTimeChorusViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            dc2.c.b r13 = (dc2.c.b) r12;
            w.a(RealTimeChorusViewModel.TAG, "receive talkRoomListUserInfoPb");
            ClientUIInfo r0 = ((IRoomLinkMicSyncData) r13.b).getClientUIInfo();
            Map r2 = null;
            if (r0 == null) goto L5;
            RealTimeChorusUIInfo r1 = r0.getRealTimeChorusInfo();
        L6:
            if (r1 != null) goto L8;
            w.a(RealTimeChorusViewModel.TAG, "chorusInfo == null");
            return;
        L8:
            Iterator<T> r14 = ((IRoomLinkMicSyncData) r13.b).getMLinkUsers().iterator();
        L10:
            if (r14.hasNext() == false) goto L18;
            T r3 = r14.next();
            IBaseUser r4 = ((com.bytedance.android.livesdk.link.model.bridge.k) r3).getUser();
            if (r4 == null) goto L14;
            String r5 = r4.getIdString();
        L16:
            if (Intrinsics.areEqual(r5, RealTimeChorusViewModel.access$getCurUserId$p(this.a)) == false) goto L10;
        L19:
            com.bytedance.android.livesdk.link.model.bridge.k r6 = (com.bytedance.android.livesdk.link.model.bridge.k) r3;
            RealTimeChorusViewModel r15 = this.a;
            if (r6 == null) goto L26;
            com.bytedance.android.livesdk.link.model.bridge.k1 r7 = r6.getContent();
            if (r7 == null) goto L26;
            com.bytedance.android.livesdk.link.model.bridge.l1 r8 = r7.getLinkMicAudienceContent();
            if (r8 == null) goto L26;
            long r9 = r8.getChorusGuestStatus();
        L27:
            boolean r10 = false;
            if (r9 <= 0) goto L30;
            boolean r11 = true;
        L31:
            RealTimeChorusViewModel.access$setLinkGuest$p(r15, r11);
            KtvModeOrderedSongDataContext r16 = RealTimeChorusViewModel.access$getOrderedSongDataContext(this.a);
            if (r16 == null) goto L34;
            MusicPanel r17 = r16.getKtvPublicFirstOrderedSong();
        L36:
            if (((Boolean) KtvSettingHelper.u1.getValue()).booleanValue() == false) goto L45;
            if (r17 == null) goto L45;
            if (RealTimeChorusViewModel.access$getLastChorusInfo$p(this.a) != null) goto L45;
            if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L45;
            if (Intrinsics.areEqual(r1.isAnchorJoined(), Boolean.TRUE) == false) goto L45;
            this.a.joinRealTimeChorus(r17, RealTimeChorusViewModel$1$3$1.INSTANCE, RealTimeChorusViewModel$1$3$2.INSTANCE, "Anchor resume live");
        L45:
            RealTimeChorusViewModel.access$setLastChorusInfo$p(this.a, r1);
            KtvModeOrderedSongDataContext r18 = RealTimeChorusViewModel.access$getOrderedSongDataContext(this.a);
            if (r18 == null) goto L59;
            MusicPanel r19 = r18.getKtvPublicFirstOrderedSong();
            if (r19 == null) goto L59;
            KtvMusic r110 = r19.a;
            if (r110 == null) goto L59;
            MusicPanel r20 = RealTimeChorusViewModel.access$getSingMusic$p(this.a);
            if (r20 == null) goto L54;
            KtvMusic r21 = r20.a;
        L56:
            if (r110.isSameKtvMusic(r21) != true) goto L59;
            if (RealTimeChorusViewModel.access$getCurUserIsLead$p(this.a) == false) goto L59;
        L70:
            RealTimeChorusViewModel.access$updateChorusMode(this.a);
            RealTimeChorusViewModel.access$checkAutoJoin(this.a, "chorusInfo changed");
            RealTimeChorusViewModel.access$getHandler$p(this.a).removeMessages(1);
            RealTimeChorusViewModel.access$getHandler$p(this.a).sendEmptyMessageDelayed(1, 100);
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r111 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
            if (r111 == null) goto L97;
            if (r111.isEngineOn() != true) goto L97;
            if (((Boolean) KtvSettingHelper.V.getValue()).booleanValue() == false) goto L88;
            Map r112 = RealTimeChorusUIInfoKt.getUserInfoString(r1);
            if (r112 == null) goto L82;
            if (r112.containsKey(RealTimeChorusViewModel.access$getCurUserId$p(this.a)) != true) goto L82;
            this.a.updateChorusUserType(1, "wrds update");
        L82:
            if (RealTimeChorusViewModel.access$isLinkGuest$p(this.a) == false) goto L86;
            this.a.updateChorusUserType(1, "set link guest");
            Boolean r113 = (Boolean) this.a.isNeedPush().getValue();
            Boolean r22 = Boolean.TRUE;
            if ((!Intrinsics.areEqual(r113, r22)) == false) goto L97;
            this.a.isNeedPush().setValue(r22);
            goto L97
        L86:
            this.a.updateChorusUserType(2, "wrds update");
            goto L97
        L88:
            if (RealTimeChorusViewModel.access$isLinkGuest$p(this.a) == false) goto L90;
            this.a.updateChorusUserType(1, "set link guest");
            this.a.isNeedPush().setValue(Boolean.TRUE);
            goto L97
        L90:
            Map r114 = RealTimeChorusUIInfoKt.getUserInfoString(r1);
            if (r114 != null) goto L93;
        L95:
            this.a.updateChorusUserType(2, "wrds update");
            goto L97
        L93:
            if (r114.containsKey(RealTimeChorusViewModel.access$getCurUserId$p(this.a)) != true) goto L95;
            this.a.updateChorusUserType(1, "wrds update");
        L97:
            if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L123;
            RealTimeChorusBusinessContext.Companion.getClass();
            if (RealTimeChorusBusinessContext.a.h() == false) goto L123;
            ArrayList r115 = new ArrayList();
            Map r23 = RealTimeChorusUIInfoKt.getUserInfoString(r1);
            if (r23 == null) goto L103;
            Collection r24 = r23.values();
        L104:
            if (r24 != null) goto L106;
        L109:
            boolean r25 = true;
        L110:
            if (r25 == true) goto L121;
            Map r26 = RealTimeChorusUIInfoKt.getUserInfoString(r1);
            if (r26 == null) goto L114;
            Collection r27 = r26.values();
        L115:
            Intrinsics.checkNotNull(r27);
            Iterator r28 = r27.iterator();
        L117:
            if (r28.hasNext() == false) goto L121;
            UserChorusInfo r29 = (UserChorusInfo) r28.next();
            if (Intrinsics.areEqual(r29.isNeedPushRtc(), Boolean.TRUE) == false) goto L117;
            r115.add(RealTimeChorusViewModel.access$getInteractIdByUid(this.a, String.valueOf(r29.getUserId())));
            goto L117
        L114:
            r27 = null;
        L121:
            this.a.getChorusSpatialList().setValue(r115);
            goto L123
        L106:
            if (r24.isEmpty() == true) goto L109;
            r25 = false;
            goto L110
        L103:
            r24 = null;
        L123:
            if (RealTimeChorusViewModel.access$isEngineOn(this.a) == true) goto L125;
            return;
        L125:
            if (((nf1) KtvSettingHelper.c0.getValue()).b() == true) goto L158;
            Map r116 = RealTimeChorusUIInfoKt.getUserInfoString(r1);
            Intrinsics.checkNotNull(r116);
            UserChorusInfo r117 = (UserChorusInfo) r116.get(RealTimeChorusViewModel.access$getCurUserId$p(this.a));
            StringBuilder r30 = new StringBuilder("curUserId : ");
            r30.append(RealTimeChorusViewModel.access$getCurUserId$p(this.a));
            r30.append(" segment : ");
            r30.append(r1.getSegment());
            r30.append(" isNeedPush: ");
            if (r117 == null) goto L129;
            Boolean r118 = r117.isNeedPushRtc();
        L130:
            r30.append(r118);
            r30.append(' ');
            w.a(RealTimeChorusViewModel.TAG, r30.toString());
            RealTimeChorusUIInfo r119 = RealTimeChorusViewModel.access$getLastChorusInfo$p(this.a);
            if (r119 == null) goto L159;
            Map r120 = RealTimeChorusUIInfoKt.getUserInfoString(r119);
            if (r120 != null) goto L135;
            return;
        L135:
            if (r120.containsKey(RealTimeChorusViewModel.access$getCurUserId$p(this.a)) != true) goto L161;
            RealTimeChorusUIInfo r121 = RealTimeChorusViewModel.access$getLastChorusInfo$p(this.a);
            if (r121 == null) goto L139;
            r2 = RealTimeChorusUIInfoKt.getUserInfoString(r121);
        L139:
            Intrinsics.checkNotNull(r2);
            UserChorusInfo r122 = (UserChorusInfo) r2.get(RealTimeChorusViewModel.access$getCurUserId$p(this.a));
            if (r122 == null) goto L145;
            Boolean r123 = r122.isNeedPushRtc();
            if (r123 == null) goto L145;
            r10 = r123.booleanValue();
        L145:
            if ((!Intrinsics.areEqual((Boolean) this.a.isNeedPush().getValue(), Boolean.valueOf(r10))) == false) goto L162;
            this.a.isNeedPush().setValue(Boolean.valueOf(r10));
            return;
        L162:
            return;
        L161:
            return;
        L159:
            return;
        L129:
            r118 = null;
            goto L130
        L158:
            return;
        L54:
            r21 = null;
        L59:
            RealTimeChorusViewModel r124 = this.a;
            RealTimeChorusUIInfo r31 = RealTimeChorusViewModel.access$getLastChorusInfo$p(r124);
            if (r31 == null) goto L68;
            Map r32 = RealTimeChorusUIInfoKt.getUserInfoString(r31);
            if (r32 == null) goto L68;
            UserChorusInfo r33 = (UserChorusInfo) r32.get(gh0.a.c());
            if (r33 == null) goto L68;
            if (r33.isLead() != true) goto L68;
            boolean r34 = true;
        L69:
            RealTimeChorusViewModel.access$setCurUserIsLead$p(r124, r34);
        L68:
            r34 = false;
            goto L69
        L34:
            r17 = null;
            goto L36
        L30:
            r11 = false;
        L26:
            r9 = 0;
            goto L27
        L14:
            r5 = null;
            goto L16
        L18:
            r3 = null;
            goto L19
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusViewModel a;

        public b(RealTimeChorusViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            jd0.j r9 = (jd0.j) r8;
            if (RealTimeChorusViewModel.access$isEngineOn(this.a) == true) goto L5;
            return;
        L5:
            if (((nf1) KtvSettingHelper.c0.getValue()).b() == false) goto L48;
            int r10 = r9.a;
            RealTimeChorusUIInfo r0 = RealTimeChorusViewModel.access$getLastChorusInfo$p(this.a);
            if (r0 == null) goto L41;
            Long r1 = r0.getSegment();
            if (r1 == null) goto L42;
            long r2 = r1.longValue();
            w.a(RealTimeChorusViewModel.TAG, "index : " + r10 + "  segment : " + r2);
            if (r10 < (((int) ((r2 - 1) * KtvSettingHelper.q().j())) + 2)) goto L43;
            RealTimeChorusUIInfo r3 = RealTimeChorusViewModel.access$getLastChorusInfo$p(this.a);
            if (r3 == null) goto L44;
            Map r4 = RealTimeChorusUIInfoKt.getUserInfoString(r3);
            if (r4 != null) goto L18;
            return;
        L18:
            if (r4.containsKey(RealTimeChorusViewModel.access$getCurUserId$p(this.a)) != true) goto L46;
            RealTimeChorusUIInfo r5 = RealTimeChorusViewModel.access$getLastChorusInfo$p(this.a);
            Boolean r6 = null;
            if (r5 == null) goto L22;
            Map r7 = RealTimeChorusUIInfoKt.getUserInfoString(r5);
        L23:
            Intrinsics.checkNotNull(r7);
            UserChorusInfo r11 = (UserChorusInfo) r7.get(RealTimeChorusViewModel.access$getCurUserId$p(this.a));
            StringBuilder r12 = new StringBuilder("index : ");
            r12.append(r10);
            r12.append(" curUid : ");
            r12.append(RealTimeChorusViewModel.access$getCurUserId$p(this.a));
            r12.append(" segment : ");
            RealTimeChorusUIInfo r13 = RealTimeChorusViewModel.access$getLastChorusInfo$p(this.a);
            if (r13 == null) goto L26;
            Long r14 = r13.getSegment();
        L27:
            r12.append(r14);
            r12.append(" isNeedPush: ");
            if (r11 == null) goto L30;
            r6 = r11.isNeedPushRtc();
        L30:
            r12.append(r6);
            r12.append(' ');
            w.a(RealTimeChorusViewModel.TAG, r12.toString());
            if (r11 == null) goto L35;
            Boolean r15 = r11.isNeedPushRtc();
            if (r15 == null) goto L35;
            boolean r16 = r15.booleanValue();
        L37:
            if ((!Intrinsics.areEqual((Boolean) this.a.isNeedPush().getValue(), Boolean.valueOf(r16))) == false) goto L47;
            this.a.isNeedPush().setValue(Boolean.valueOf(r16));
            return;
        L47:
            return;
        L35:
            r16 = false;
            goto L37
        L26:
            r14 = null;
            goto L27
        L22:
            r7 = null;
            goto L23
        L46:
            return;
        L44:
            return;
        L43:
            return;
        L42:
            return;
        L41:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusViewModel a;

        public c(RealTimeChorusViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            jd0.r r2 = (jd0.r) r1;
            RealTimeChorusViewModel.access$handleLinkSuccessEvent(this.a);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusViewModel a;

        public d(RealTimeChorusViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            jd0.p r2 = (jd0.p) r1;
            RealTimeChorusViewModel.access$handleLinkSuccessEvent(this.a);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusViewModel a;

        public e(RealTimeChorusViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            jd0.o r3 = (jd0.o) r2;
            Integer r4 = (Integer) this.a.getChorusUserType().getValue();
            if (r4 != null) goto L6;
        L7:
            Integer r5 = (Integer) this.a.getChorusUserType().getValue();
            if (r5 != null) goto L11;
            return;
        L11:
            if (r5.intValue() != 4) goto L14;
        L12:
            w.a(RealTimeChorusViewModel.TAG, "cdn singer LiveClientInitSuccess so update join status ");
            RealTimeChorusViewModel.access$handleLinkSuccessEvent(this.a);
            return;
        L14:
            return;
        L6:
            if (r4.intValue() == 3) goto L12;
            goto L7
        }
    }

    public static final class f {
        public f() {
        }
    }

    public static final class g extends Handler {
        public final /* synthetic */ RealTimeChorusViewModel a;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            super.handleMessage(r2);
            if (r2.what != 1) goto L7;
            RealTimeChorusViewModel.access$updateRealTimeChorusInfo(this.a);
            return;
        }

        public g(RealTimeChorusViewModel r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusViewModel a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ MusicPanel c;
        public final /* synthetic */ String d;

        public h(RealTimeChorusViewModel r1, Function1 r2, MusicPanel r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r14) {
            com.bytedance.android.live.network.response.e r15 = (com.bytedance.android.live.network.response.e) r14;
            this.b.invoke(r15);
            NextLiveData<String> r0 = this.a.getSubToken();
            String r1 = ((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).d();
            String r2 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r0.setValue(r1);
            RealTimeChorusViewModel.access$setJoining$p(this.a, false);
            RealTimeChorusViewModel.access$setHasJoined$p(this.a, true);
            RealTimeChorusViewModel r3 = this.a;
            KtvModeOrderedSongDataContext r4 = RealTimeChorusViewModel.access$getOrderedSongDataContext(r3);
            Long r5 = null;
            if (r4 == null) goto L8;
            MusicPanel r6 = r4.getKtvPublicFirstOrderedSong();
        L9:
            RealTimeChorusViewModel.access$handleJoinLeaveChorusLog(r3, r6);
            StringBuilder r7 = new StringBuilder("joinChorus success type ");
            r7.append(((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).e());
            r7.append(" cdnStream ");
            com.bytedance.android.livesdk.chatroom.model.v r8 = ((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).a();
            if (r8 == null) goto L14;
            s2 r9 = r8.getPlayInfo();
            if (r9 == null) goto L14;
            String r10 = r9.getStreamData();
        L15:
            r7.append(r10);
            r7.append(" token ");
            r7.append(((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).c());
            r7.append(" isEngineOn ");
            r7.append(RealTimeChorusViewModel.access$isEngineOn(this.a));
            w.a(RealTimeChorusViewModel.TAG, r7.toString());
            int r11 = ((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).e();
            if (r11 == 1) goto L61;
            if (r11 == 2) goto L51;
            if (r11 != 3) goto L22;
        L24:
            RealTimeChorusViewModel r12 = this.a;
            fd2.b0 r13 = new fd2.b0();
            r13.a = this.c;
            r13.b = true;
            Unit r16 = Unit.INSTANCE;
            r12.setLocalPreChorusJoinStatus(r13);
            RealTimeChorusViewModel r17 = this.a;
            String r18 = ((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).b();
            if (r18 != null) goto L27;
            r18 = "";
        L27:
            RealTimeChorusViewModel.access$initLiveClient(r17, r18, "joinChorus");
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r19 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
            if (r19 == null) goto L37;
            com.bytedance.android.livesdk.chatroom.model.v r20 = ((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).a();
            if (r20 == null) goto L35;
            s2 r21 = r20.getPlayInfo();
            if (r21 == null) goto L35;
            String r22 = r21.getStreamData();
            if (r22 == null) goto L35;
        L36:
            r19.bm(r22);
        L35:
            r22 = "";
        L37:
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r23 = KSongTuningPanelHelperKt.d();
            if (r23 == null) goto L42;
            w.a("KSongTuningCore", "setPlayerVolume " + (r23.V() / r23.D()));
            ILivePlayerClient r24 = hs0.a.b.getCurrentClient();
            if (r24 == null) goto L42;
            r24.setPlayerVolume(r23.V() / r23.D());
        L42:
            int r25 = xe2.g.a;
            com.bytedance.android.livesdk.chatroom.model.v r26 = ((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).a();
            if (r26 == null) goto L48;
            s2 r27 = r26.getPlayInfo();
            if (r27 == null) goto L48;
            String r28 = r27.getStreamData();
            if (r28 == null) goto L48;
        L49:
            xe2.g.h(r28, "JoinChorus");
        L119:
            this.a.updateChorusUserType(((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).e(), "joinRealTimeChorus");
            int r29 = xe2.g.a;
            MusicPanel r30 = this.c;
            String r31 = ((ExtraResponse) r15).logId;
            com.bytedance.android.livesdk.chatroom.model.v r110 = ((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).a();
            if (r110 == null) goto L127;
            s2 r111 = r110.getPlayInfo();
            if (r111 == null) goto L127;
            String r112 = r111.getStreamData();
            if (r112 == null) goto L127;
            r2 = r112;
        L127:
            String r113 = this.d;
            Intrinsics.checkNotNullParameter(r30, "musicPanel");
            Intrinsics.checkNotNullParameter(r31, "logId");
            Intrinsics.checkNotNullParameter(r2, "streamData");
            Intrinsics.checkNotNullParameter(r113, "source");
            JSONObject r114 = new JSONObject();
            r114.put("music_name", r30.a.getTitle());
            r114.put("music_id", r30.a.getMId());
            InteractiveSongUserInfo r32 = r30.f();
            if (r32 == null) goto L130;
            r5 = Long.valueOf(r32.getId());
        L130:
            r114.put("order_user_id", String.valueOf(r5));
            r114.put("streamData", r2);
            r114.put("source", r113);
            r114.put("log_id", r31);
            xe2.g.f(r114);
            int r115 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.JoinChorus, "JoinChorusSuccess", 0, null, r114, 88);
            return;
        L48:
            r28 = "";
            goto L49
        L22:
            if (r11 == 4) goto L24;
        L51:
            if (RealTimeChorusViewModel.access$isEngineOn(this.a) == false) goto L53;
            RealTimeChorusViewModel r33 = this.a;
            fd2.b0 r34 = new fd2.b0();
            r34.a = this.c;
            r34.b = true;
            Unit r35 = Unit.INSTANCE;
            r33.setLocalChorusJoinStatus(r34);
            RealTimeChorusViewModel.access$getHandler$p(this.a).removeMessages(1);
            RealTimeChorusViewModel.access$getHandler$p(this.a).sendEmptyMessageDelayed(1, 100);
            goto L119
        L53:
            RealTimeChorusViewModel r36 = this.a;
            fd2.b0 r37 = new fd2.b0();
            r37.a = this.c;
            r37.b = true;
            Unit r38 = Unit.INSTANCE;
            r36.setLocalPreChorusJoinStatus(r37);
            RealTimeChorusViewModel r39 = this.a;
            String r40 = ((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).b();
            if (r40 != null) goto L56;
            r40 = "";
        L56:
            String r41 = ((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).c();
            if (r41 != null) goto L59;
            r41 = "";
        L59:
            RealTimeChorusViewModel.access$applySilenceLink(r39, r40, r41, false);
            goto L119
        L61:
            if (RealTimeChorusViewModel.access$isEngineOn(this.a) == false) goto L112;
            RealTimeChorusViewModel r42 = this.a;
            fd2.b0 r43 = new fd2.b0();
            r43.a = this.c;
            r43.b = true;
            Unit r44 = Unit.INSTANCE;
            r42.setLocalChorusJoinStatus(r43);
            RealTimeChorusViewModel.access$getHandler$p(this.a).removeMessages(1);
            RealTimeChorusViewModel.access$getHandler$p(this.a).sendEmptyMessageDelayed(1, 100);
            if (this.a.isPermanentLinkGuest() == false) goto L65;
        L66:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r45 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
            if (r45 == null) goto L69;
            com.bytedance.android.live.liveinteract.voicechat.b r46 = r45.muteManager();
        L70:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r47 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
            if (r47 == null) goto L77;
            com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r48 = r47.getLinkUserInfoCenter();
            if (r48 == null) goto L77;
            if (r48.b5(je0.d.b0()) != true) goto L77;
            boolean r49 = true;
        L78:
            ALogger.i(RealTimeChorusViewModel.TAG, "joinChorus success, isMute: " + r49);
            if (r46 != null) goto L81;
        L82:
            if (r49 == true) goto L84;
        L91:
            if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L119;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r50 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
            if (r50 == null) goto L95;
            com.bytedance.android.live.liveinteract.voicechat.b r51 = r50.muteManager();
        L96:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r52 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
            if (r52 == null) goto L103;
            com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r53 = r52.getLinkUserInfoCenter();
            if (r53 == null) goto L103;
            if (r53.b5(je0.d.b0()) != true) goto L103;
            boolean r54 = true;
        L104:
            if (r51 != null) goto L106;
        L107:
            if (r54 == false) goto L119;
        L109:
            if (this.c.a.isOrderedBy(RealTimeChorusViewModel.access$getCurUserId$p(this.a)) == false) goto L111;
            f2.b(2131918608, 0);
            goto L119
        L111:
            f2.b(2131918400, 0);
            goto L119
        L106:
            if (r51.isMute() == true) goto L109;
        L103:
            r54 = false;
            goto L104
        L95:
            r51 = null;
        L84:
            if (this.c.a.isOrderedBy(RealTimeChorusViewModel.access$getCurUserId$p(this.a)) == false) goto L86;
            f2.b(2131918611, 0);
        L87:
            if (r46 == null) goto L89;
            r46.d("force UnSilence", true, null, false);
        L89:
            RealTimeChorusViewModel.access$setShouldRestoreSilenceStatus$p(this.a, true);
            goto L91
        L86:
            f2.b(2131918401, 0);
            goto L87
        L81:
            if (r46.isMute() == true) goto L84;
        L77:
            r49 = false;
            goto L78
        L69:
            r46 = null;
            goto L70
        L65:
            if (this.a.isAssignLead() == false) goto L91;
        L112:
            RealTimeChorusViewModel r55 = this.a;
            fd2.b0 r56 = new fd2.b0();
            r56.a = this.c;
            r56.b = true;
            Unit r57 = Unit.INSTANCE;
            r55.setLocalPreChorusJoinStatus(r56);
            RealTimeChorusViewModel r58 = this.a;
            String r59 = ((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).b();
            if (r59 != null) goto L115;
            r59 = "";
        L115:
            String r60 = ((com.bytedance.android.live.ktv.common.model.api.w) ((ExtraResponse) r15).data).c();
            if (r60 != null) goto L118;
            r60 = "";
        L118:
            RealTimeChorusViewModel.access$applySilenceLink(r58, r59, r60, false);
        L14:
            r10 = null;
            goto L15
        L8:
            r6 = null;
            goto L9
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusViewModel a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ MusicPanel c;
        public final /* synthetic */ String d;

        public i(RealTimeChorusViewModel r1, Function1 r2, MusicPanel r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r12) {
            Throwable r13 = (Throwable) r12;
            RealTimeChorusViewModel.access$setJoining$p(this.a, false);
            this.b.invoke(r13);
            Long r2 = null;
            if (this.c.a.isOrderedBy(RealTimeChorusViewModel.access$getCurUserId$p(this.a)) == false) goto L5;
            Lazy r0 = KtvMusicControlManager.d;
            KtvMusicControlManager.a.a().d(new CutMusicControlNode(this.c, false, ModeType.KTV_MODE), null);
        L5:
            int r1 = xe2.g.a;
            MusicPanel r3 = this.c;
            String r4 = this.d;
            Intrinsics.checkNotNullParameter(r3, "musicPanel");
            Intrinsics.checkNotNullParameter(r13, "throwable");
            Intrinsics.checkNotNullParameter(r4, "source");
            JSONObject r9 = new JSONObject();
            r9.put("music_name", r3.a.getTitle());
            r9.put("music_id", r3.a.getMId());
            InteractiveSongUserInfo r5 = r3.f();
            if (r5 == null) goto L8;
            r2 = Long.valueOf(r5.getId());
        L8:
            r9.put("order_user_id", String.valueOf(r2));
            nd0.c.a.getClass();
            nd0.c.t(r13, r9);
            int r14 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.JoinChorus, "JoinChorusFailed", 0, null, r9, 88);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusViewModel a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Function1 d;
        public final /* synthetic */ Ref.ObjectRef e;

        public j(RealTimeChorusViewModel r1, int r2, long r3, Function1 r5, Ref.ObjectRef r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r13) {
            RealTimeChorusViewModel.access$realLeave(this.a, this.b, this.c, this.d);
            int r0 = xe2.g.a;
            int r1 = this.b;
            long r2 = this.c;
            String r14 = ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r13)).logId;
            MusicPanel r3 = (MusicPanel) this.e.element;
            Intrinsics.checkNotNullParameter(r14, "logId");
            JSONObject r10 = new JSONObject();
            if (r3 == null) goto L9;
            r10.put("music_name", r3.a.getTitle());
            r10.put("music_id", r3.a.getMId());
            InteractiveSongUserInfo r4 = r3.f();
            if (r4 == null) goto L7;
            Long r5 = Long.valueOf(r4.getId());
        L8:
            r10.put("order_user_id", String.valueOf(r5));
            goto L9
        L7:
            r5 = null;
        L9:
            r10.put("leaveType", String.valueOf(r1));
            r10.put("chorusId", String.valueOf(r2));
            r10.put("log_id", r14);
            xe2.g.f(r10);
            int r15 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.LeaveChorus, "LeaveChorusSuccess", 0, null, r10, 88);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusViewModel a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Ref.ObjectRef d;

        public k(RealTimeChorusViewModel r1, int r2, long r3, Ref.ObjectRef r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r14) {
            Throwable r15 = (Throwable) r14;
            f2.c(com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r15), 0);
            int r0 = xe2.g.a;
            int r1 = this.b;
            long r2 = this.c;
            MusicPanel r4 = (MusicPanel) this.d.element;
            Intrinsics.checkNotNullParameter(r15, "throwable");
            JSONObject r11 = new JSONObject();
            r11.put("leaveType", String.valueOf(r1));
            r11.put("chorusId", String.valueOf(r2));
            if (r4 == null) goto L9;
            r11.put("music_name", r4.a.getTitle());
            r11.put("music_id", r4.a.getMId());
            InteractiveSongUserInfo r3 = r4.f();
            if (r3 == null) goto L7;
            Long r5 = Long.valueOf(r3.getId());
        L8:
            r11.put("order_user_id", String.valueOf(r5));
            goto L9
        L7:
            r5 = null;
        L9:
            nd0.c.a.getClass();
            nd0.c.t(r15, r11);
            xe2.g.f(r11);
            int r16 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.LeaveChorus, "LeaveChorusFailed", 0, null, r11, 88);
            RealTimeChorusViewModel.access$setLeaving$p(this.a, false);
        }
    }

    public static final class l implements vlc.l {
        public final /* synthetic */ RealTimeChorusViewModel a;

        public l(RealTimeChorusViewModel r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r6) {
            if ((r6 instanceof kd) == false) goto L16;
            kd r7 = (kd) r6;
            if (r7.getMsgType() == 3) goto L7;
            return;
        L7:
            if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L25;
            z2 r8 = r7.G();
            if (r8 == null) goto L11;
            long r0 = r8.c();
        L13:
            if (r0 <= RealTimeChorusViewModel.access$getMaxChorusNumber$p(this.a)) goto L26;
            RealTimeChorusViewModel.access$setMaxChorusNumber$p(this.a, r0);
            return;
        L26:
            return;
        L11:
            r0 = 0;
            goto L13
        L25:
            return;
        L16:
            if ((r6 instanceof jd) == false) goto L28;
            jd r9 = (jd) r6;
            Integer r1 = r9.getMsgType();
            if (r1 != null) goto L21;
            return;
        L21:
            if (r1.intValue() != 7) goto L29;
            RealTimeChorusViewModel.access$onReceiverFinish(this.a, r9.getFinishContent());
            return;
        L29:
            return;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusViewModel a;

        public m(RealTimeChorusViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            List r2 = (List) r1;
            this.a.handleSongListChange();
        }
    }

    public static final class n implements MediaOperation.a {
        public n() {
        }

        public final void onError(Throwable r1) {
        }

        public final void onSuccess() {
            f2.b(2131918404, 0);
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public o(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            ALogger.i(RealTimeChorusViewModel.TAG, "updateRealtimeChorusGuestStatus success");
            Function0 r4 = this.a;
            if (r4 == null) goto L6;
            Unit r5 = (Unit) r4.invoke();
            return;
        }
    }

    public static final class p<T> implements Consumer {
        public static final p a = null;

        static {
            a = new p();
        }

        public p() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            ExceptionUtils.handleException(s1.getContext(), r4);
            ALogger.i(RealTimeChorusViewModel.TAG, "updateRealtimeChorusGuestStatus exception: " + r4.getMessage());
        }
    }

    static {
        Companion = new f();
    }

    private final String getCurUserId() {
        return (String) this.curUserId$delegate.getValue();
    }

    public final void clearInfo() {
        this.lastChorusInfo = null;
    }

    private final void cdnSingerLeave() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r1 = r0.getKtvCoreViewModel();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r2 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r1.getValue();
        if (r2 == null) goto L11;
        KtvRoomLyricsStateMachineConfig.d r3 = r2.getCurState();
        if (r3 == null) goto L11;
        MusicPanel r4 = r3.b();
    L12:
        fd2.b0 r5 = new fd2.b0();
        r5.a = r4;
        r5.b = false;
        Unit r6 = Unit.INSTANCE;
        this.localChorusJoinStatus = r5;
        updateRole(4, "leaveRealTimeChorus");
        hs0.a r7 = hs0.a.b;
        ILivePlayerClient r8 = r7.getCurrentClient();
        String r9 = "";
        if (r8 == null) goto L22;
        com.bytedance.live.datacontext.m r10 = o3.f().getRoom();
        if (r10 == null) goto L20;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L20;
        String r12 = r11.getMultiStreamData();
        if (r12 == null) goto L20;
    L21:
        r8.switchStreamData(r12);
    L20:
        r12 = "";
    L22:
        ILivePlayerClient r13 = r7.getCurrentClient();
        if (r13 == null) goto L25;
        r13.setPlayerVolume(1.0f);
    L25:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r14 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r14 == null) goto L28;
        r14.Re();
    L28:
        stopLiveClient("leaveRealTimeChorus");
        updateChorusUserType(0, "leaveRealTimeChorus");
        int r15 = xe2.g.a;
        com.bytedance.live.datacontext.m r16 = o3.f().getRoom();
        if (r16 == null) goto L36;
        IRoom r17 = (IRoom) r16.getValue();
        if (r17 == null) goto L36;
        String r18 = r17.getMultiStreamData();
        if (r18 == null) goto L36;
        r9 = r18;
    L36:
        xe2.g.h(r9, "cdnSingerLeave");
        return;
    L11:
        r4 = null;
        goto L12
    }

    private final KtvModeOrderedSongDataContext getOrderedSongDataContext() {
        return KtvModeOrderedSongDataContext.Companion.getContext();
    }

    private final boolean isEngineOn() {
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 == null) goto L5;
        boolean r1 = r0.isEngineOn();
    L6:
        if (r1 == false) goto L8;
    L9:
        return true;
    L8:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L9;
        return false;
    L5:
        r1 = false;
        goto L6
    }

    private final void updateChorusMode() {
        RealTimeChorusUIInfo r0 = this.lastChorusInfo;
        if (r0 != null) goto L5;
        return;
    L5:
        Integer r1 = (Integer) this.chorusMode.getValue();
        int r3 = (int) r0.getChorusMode();
        Map r2 = RealTimeChorusUIInfoKt.getUserInfoString(r0);
        Boolean r4 = null;
        if (r2 == null) goto L8;
        UserChorusInfo r5 = (UserChorusInfo) r2.get(getCurUserId());
    L9:
        boolean r7 = true;
        if (r1 != null) goto L13;
    L14:
        w.a(TAG, "updateChorusMode from " + r1 + " to " + r3);
        if (r5 != null) goto L17;
    L19:
        r7 = false;
    L20:
        updateChorusLeader(r7, false, "mode changed");
        this.chorusMode.setValue(Integer.valueOf(r3));
        return;
    L17:
        if (r5.isLead() != true) goto L19;
    L13:
        if (r3 != r1.intValue()) goto L14;
        if (r5 == null) goto L23;
        Boolean r6 = Boolean.valueOf(r5.isLead());
    L25:
        if ((!Intrinsics.areEqual(r6, (Boolean) this.isChorusAssignLeader.getValue())) == false) goto L38;
        StringBuilder r8 = new StringBuilder("update lead singer from ");
        r8.append((Boolean) this.isChorusAssignLeader.getValue());
        r8.append(" to ");
        if (r5 == null) goto L29;
        r4 = Boolean.valueOf(r5.isLead());
    L29:
        r8.append(r4);
        w.a(TAG, r8.toString());
        if (r5 != null) goto L32;
    L34:
        r7 = false;
    L35:
        updateChorusLeader(r7, false, "lead changed");
        return;
    L32:
        if (r5.isLead() != true) goto L34;
    L38:
        return;
    L23:
        r6 = null;
        goto L25
    L8:
        r5 = null;
        goto L9
    }

    private final void updateRealTimeChorusInfo() {
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == true) goto L6;
        w.a(TAG, "updateRealTimeChorusInfo but not in real time chorus");
        return;
    L6:
        updateAssignLead();
        int r0 = getUserChorusRole();
        w.a(TAG, "updateRealTimeChorusInfo getUserChorusRole curRole " + r0);
        KtvModeOrderedSongDataContext r1 = getOrderedSongDataContext();
        if (r1 == null) goto L11;
        List<MusicPanel> r2 = r1.m200getKtvSingSongList();
        if (r2 == null) goto L11;
        MusicPanel r3 = (MusicPanel) KtvUtilsKt.K(r2, 0);
    L12:
        updateRole(r0, "updateRealTimeChorusInfo");
        if (r3 != null) goto L15;
        updateLeaderSingerId("");
        return;
    L15:
        if (TextUtils.isEmpty(r3.g()) == true) goto L21;
        String r4 = r3.g();
        Intrinsics.checkNotNull(r4);
        if (isUserOnLine(r4) == false) goto L22;
        String r5 = r3.g();
        Intrinsics.checkNotNull(r5);
        updateLeaderSingerId(r5);
        return;
    L22:
        return;
    L21:
        return;
    L11:
        r3 = null;
        goto L12
    }

    public final int getCurChorusUserCount() {
        RealTimeChorusUIInfo r0 = this.lastChorusInfo;
        if (r0 == null) goto L7;
        Map r1 = RealTimeChorusUIInfoKt.getUserInfoString(r0);
        if (r1 == null) goto L7;
        return r1.size();
    L7:
        return 0;
    }

    public final int getCurrentChorusMode() {
        Integer r0 = (Integer) this.chorusMode.getValue();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final int getCurrentUserChorusRole() {
        Integer r0 = (Integer) this.curUserRealTimeChorusRole.getValue();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    /* JADX INFO: renamed from: getLeadSingerUid, reason: collision with other method in class */
    public final String m469getLeadSingerUid() {
        String r0 = (String) this.leadSingerUid.getValue();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final void handleSongListChange() {
        KtvModeOrderedSongDataContext r0 = getOrderedSongDataContext();
        String r1 = null;
        if (r0 == null) goto L5;
        MusicPanel r8 = r0.getKtvPublicFirstOrderedSong();
    L6:
        handleJoinLeaveChorusLog(r8);
        if (r8 == null) goto L18;
        KtvMusic r2 = r8.a;
        if (r2 == null) goto L18;
        MusicPanel r3 = this.singMusic;
        if (r3 == null) goto L13;
        KtvMusic r4 = r3.a;
    L15:
        if (r2.isSameKtvMusic(r4) != true) goto L18;
        return;
    L13:
        r4 = null;
    L18:
        if (getCurrentUserChorusRole() != 2) goto L20;
    L23:
        boolean r11 = true;
    L24:
        this.singMusic = r8;
        StringBuilder r5 = new StringBuilder("handleSongListChange topMusic : ");
        if (r8 == null) goto L29;
        KtvMusic r6 = r8.a;
        if (r6 == null) goto L29;
        String r7 = r6.getMTitle();
    L30:
        r5.append(r7);
        w.a(TAG, r5.toString());
        RealTimeChorusUIInfo r9 = this.lastChorusInfo;
        if (r9 == null) goto L35;
        Long r10 = r9.getChorusID();
        if (r10 == null) goto L35;
        long r12 = r10.longValue();
    L36:
        long r13 = r12;
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L43;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r14 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r14 == null) goto L48;
        RealTimeChorusMainViewWidget r15 = r14.u2();
        if (r15 == null) goto L48;
        double r16 = r15.Uc();
    L49:
        double r17 = r16;
        if (r8 != null) goto L52;
    L73:
        if (r8 != null) goto L77;
        if (r11 == false) goto L76;
        leaveRealTimeChorus(r17, 2, r13, C02602.INSTANCE);
        goto L77
    L76:
        this.localChorusJoinStatus = new fd2.b0();
        this.localPreChorusJoinStatus = new fd2.b0();
    L77:
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, 100);
        if (this.waitJoinUntilSingMusicChange == false) goto L87;
        MusicPanel r18 = this.singMusic;
        if (r18 == null) goto L88;
        KtvMusic r19 = r18.a;
        if (r19 != null) goto L84;
        return;
    L84:
        if (r19.isOrderedBy(getCurUserId()) != true) goto L90;
        this.waitJoinUntilSingMusicChange = false;
        MusicPanel r20 = this.singMusic;
        Intrinsics.checkNotNull(r20);
        joinRealTimeChorus(r20, AnonymousClass3.INSTANCE, AnonymousClass4.INSTANCE, "auto join after singMusic changed");
        return;
    L90:
        return;
    L88:
        return;
    L87:
        return;
    L52:
        if (getUserChorusRole() != 1) goto L54;
        boolean r21 = true;
    L55:
        jc0.a.a = r21;
        if (r8.a.isOrderedBy(getCurUserId()) == false) goto L58;
    L66:
        StringBuilder r22 = new StringBuilder("handleSongListChange  ");
        KtvMusic r23 = r8.a;
        if (r23 == null) goto L69;
        r1 = r23.getMTitle();
    L69:
        r22.append(r1);
        r22.append(" is ordered by me  so join");
        w.a(TAG, r22.toString());
        if (r11 == false) goto L72;
        leaveRealTimeChorus(r17, 2, r13, RealTimeChorusViewModel$handleSongListChange$1$1.INSTANCE);
        goto L73
    L72:
        joinRealTimeChorus(r8, RealTimeChorusViewModel$handleSongListChange$1$2.INSTANCE, RealTimeChorusViewModel$handleSongListChange$1$3.INSTANCE, "ordered by me  so join");
        goto L73
    L58:
        if (isAssignLead() == false) goto L64;
        RealTimeChorusUIInfo r24 = this.lastChorusInfo;
        if (r24 == null) goto L64;
        if (((int) r24.getChorusMode()) == 2) goto L66;
    L64:
        if (r11 == true) goto L73;
        fd2.b0 r25 = new fd2.b0();
        r25.a = r8;
        r25.b = false;
        Unit r26 = Unit.INSTANCE;
        this.localChorusJoinStatus = r25;
        goto L73
    L54:
        r21 = false;
    L48:
        r16 = 0.0d;
        goto L49
    L43:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r27 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r27 == null) goto L48;
        RealTimeChorusMainViewWidget r28 = r27.u2();
        if (r28 == null) goto L48;
        r16 = r28.Uc();
    L35:
        r12 = 0;
    L29:
        r7 = null;
        goto L30
    L20:
        if (getCurrentUserChorusRole() == 1) goto L23;
        r11 = false;
        goto L24
    L5:
        r8 = null;
        goto L6
    }

    public final boolean isAssignLead() {
        Boolean r0 = (Boolean) this.isChorusAssignLeader.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    private final void handleLinkSuccessEvent() {
        KtvModeOrderedSongDataContext r0 = getOrderedSongDataContext();
        if (r0 == null) goto L5;
        MusicPanel r1 = r0.getKtvPublicFirstOrderedSong();
    L7:
        if (isPreJoined(r1) == false) goto L10;
        w.a(TAG, "handleLinkSuccessEvent isPreJoined so update role now");
        fd2.b0 r2 = new fd2.b0();
        r2.a = r1;
        r2.b = true;
        Unit r3 = Unit.INSTANCE;
        this.localChorusJoinStatus = r2;
        fd2.b0 r4 = new fd2.b0();
        r4.a = r1;
        r4.b = false;
        this.localPreChorusJoinStatus = r4;
    L10:
        if (isPermanentLinkGuest() == false) goto L12;
        updateChorusUserType(1, "set link guest");
    L12:
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, 100);
        return;
    L5:
        r1 = null;
        goto L7
    }

    private final void updateAssignLead() {
        boolean r1 = false;
        if (isEngineOn() == false) goto L42;
        RealTimeChorusUIInfo r0 = this.lastChorusInfo;
        if (r0 != null) goto L7;
    L9:
        KtvModeOrderedSongDataContext r2 = getOrderedSongDataContext();
        Long r3 = null;
        if (r2 == null) goto L18;
        MusicPanel r4 = r2.getKtvPublicFirstOrderedSong();
        if (r4 == null) goto L18;
        KtvMusic r5 = r4.a;
        if (r5 == null) goto L18;
        RealTimeChorusInfo r6 = r5.getRealTimeChorusInfo();
        if (r6 == null) goto L18;
        Long r7 = Long.valueOf(r6.getChorusID());
    L19:
        StringBuilder r8 = new StringBuilder("updateAssignLead lastChorusId:");
        RealTimeChorusUIInfo r9 = this.lastChorusInfo;
        if (r9 == null) goto L22;
        Long r10 = r9.getChorusID();
    L23:
        r8.append(r10);
        r8.append(", topMusicChorusId:");
        r8.append(r7);
        w.a(TAG, r8.toString());
        if (r7 == null) goto L44;
        RealTimeChorusUIInfo r11 = this.lastChorusInfo;
        if (r11 == null) goto L29;
        r3 = r11.getChorusID();
    L29:
        if ((!Intrinsics.areEqual(r7, r3)) == true) goto L45;
        w.a(TAG, "updateAssignLead lastChorusId is new, start updateAssignLead");
        RealTimeChorusUIInfo r12 = this.lastChorusInfo;
        if (r12 == null) goto L40;
        Map r13 = RealTimeChorusUIInfoKt.getUserInfoString(r12);
        if (r13 == null) goto L40;
        UserChorusInfo r14 = (UserChorusInfo) r13.get(getCurUserId());
        if (r14 == null) goto L40;
        if (r14.isLead() != true) goto L40;
        r1 = true;
    L40:
        updateChorusLeader(r1, true, "updateAssignLead");
        return;
    L45:
        return;
    L44:
        return;
    L22:
        r10 = null;
    L18:
        r7 = null;
        goto L19
    L7:
        if (((int) r0.getChorusMode()) != 0) goto L9;
    L42:
        updateChorusLeader(false, true, "isEngineOn false or mode is normal");
    }

    public final int getUserChorusRole() {
        if (isEngineOn() == true) goto L15;
        Integer r0 = (Integer) this.chorusUserType.getValue();
        if (r0 != null) goto L8;
    L9:
        Integer r1 = (Integer) this.chorusUserType.getValue();
        if (r1 != null) goto L13;
    L14:
        return 4;
    L13:
        if (r1.intValue() == 4) goto L15;
    L8:
        if (r0.intValue() != 3) goto L9;
    L15:
        KtvModeOrderedSongDataContext r2 = getOrderedSongDataContext();
        String r3 = null;
        if (r2 == null) goto L18;
        List<MusicPanel> r4 = r2.m200getKtvSingSongList();
    L19:
        if (r4 == null) goto L21;
        MusicPanel r5 = (MusicPanel) KtvUtilsKt.K(r4, 0);
    L22:
        if (r5 == null) goto L24;
        String r6 = r5.g();
    L25:
        StringBuilder r7 = new StringBuilder("getUserChorusRole orderSongList : ");
        if (r4 == null) goto L28;
        Integer r8 = Integer.valueOf(r4.size());
    L29:
        r7.append(r8);
        r7.append(" topMusic : ");
        if (r5 == null) goto L34;
        KtvMusic r9 = r5.a;
        if (r9 == null) goto L34;
        r3 = r9.getMTitle();
    L34:
        r7.append(r3);
        r7.append(" topUserId ");
        r7.append(r6);
        r7.append(" curUserId ");
        r7.append(getCurUserId());
        r7.append(' ');
        w.a(TAG, r7.toString());
        if (r5 != null) goto L40;
        if (((Boolean) KtvSettingHelper.U.getValue()).booleanValue() == false) goto L40;
        return 3;
    L40:
        if (Intrinsics.areEqual(getCurUserId(), r6) == false) goto L49;
        if (isEngineOn() == false) goto L49;
        if (((Boolean) KtvSettingHelper.U.getValue()).booleanValue() == false) goto L46;
    L47:
        return 1;
    L46:
        if (isLocalJoined(r5) == true) goto L47;
    L49:
        if (isLocalJoined(r5) == false) goto L51;
    L54:
        this.isAutoJoin = isAssignLead();
        return 2;
    L51:
        if (isAssignLead() == true) goto L53;
        return 3;
    L53:
        if (isNeedCheckOrder(r5, getCurUserId(), r6) == true) goto L54;
        return 3;
    L28:
        r8 = null;
        goto L29
    L24:
        r6 = null;
        goto L25
    L21:
        r5 = null;
        goto L22
    L18:
        r4 = null;
        goto L19
    }

    public final boolean isCDNViceSinger() {
        if (getCurrentUserChorusRole() != 2) goto L15;
        Integer r0 = (Integer) this.chorusUserType.getValue();
        if (r0 != null) goto L8;
    L9:
        Integer r1 = (Integer) this.chorusUserType.getValue();
        if (r1 == null) goto L15;
        if (r1.intValue() != 4) goto L15;
    L14:
        return true;
    L8:
        if (r0.intValue() == 3) goto L14;
    L15:
        return false;
    }

    public final boolean isJoinUnPublish() {
        return KtvSettingHelper.q().q();
    }

    public final boolean isSilenceViceSinger() {
        if (getCurrentUserChorusRole() != 2) goto L10;
        Integer r0 = (Integer) this.chorusUserType.getValue();
        if (r0 == null) goto L10;
        if (r0.intValue() != 2) goto L10;
        return true;
    L10:
        return false;
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
        xe2.h.j();
        jc0.a.a = false;
        jc0.a.b = false;
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L9;
        vlc.d r2 = (vlc.d) r1.getValue();
        if (r2 == null) goto L9;
        r2.removeMessageListener(MessageType.REAL_TIME_CHORUS_MESSAGE.getIntType(), this.msgListener);
    L9:
        com.bytedance.android.livesdk.chatroom.o r3 = o3.f();
        if (r3 == null) goto L17;
        com.bytedance.live.datacontext.j r4 = r3.getMessageManager();
        if (r4 == null) goto L18;
        vlc.d r5 = (vlc.d) r4.getValue();
        if (r5 == null) goto L19;
        r5.removeMessageListener(MessageType.KTV_CHORUS_ACTION_MESSAGE.getIntType(), this.msgListener);
        return;
    L19:
        return;
    L18:
        return;
    }

    public final boolean curUserIsLead() {
        return this.curUserIsLead;
    }

    public final NextLiveData<Integer> getChorusMode() {
        return this.chorusMode;
    }

    public final NextLiveData<ArrayList<String>> getChorusSpatialList() {
        return this.chorusSpatialList;
    }

    public final NextLiveData<Integer> getChorusUserType() {
        return this.chorusUserType;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final RealTimeChorusUIInfo getLastChorusInfo() {
        return this.lastChorusInfo;
    }

    public final String getLastLeaderInteractId() {
        return this.lastLeaderInteractId;
    }

    public final String getLastLeaderSingerID() {
        return this.lastLeaderSingerID;
    }

    public final int getLastRole() {
        return this.lastRole;
    }

    public final fd2.b0 getLocalChorusJoinStatus() {
        return this.localChorusJoinStatus;
    }

    public final fd2.b0 getLocalPreChorusJoinStatus() {
        return this.localPreChorusJoinStatus;
    }

    public final NextLiveData<String> getSubToken() {
        return this.subToken;
    }

    public final NextLiveData<Boolean> isChorusAssignLeader() {
        return this.isChorusAssignLeader;
    }

    public final NextLiveData<Boolean> isNeedPush() {
        return this.isNeedPush;
    }

    public final boolean isPermanentLinkGuest() {
        return this.isLinkGuest;
    }

    public final NextLiveData<Boolean> isPlayingMusic() {
        return this.isPlayingMusic;
    }

    public final NextLiveData<String> getLeadSingerUid() {
        return this.leadSingerUid;
    }

    public static final /* synthetic */ String access$getCurUserId$p(RealTimeChorusViewModel r0) {
        return r0.getCurUserId();
    }

    public static final /* synthetic */ boolean access$getCurUserIsLead$p(RealTimeChorusViewModel r0) {
        return r0.curUserIsLead;
    }

    public static final /* synthetic */ g access$getHandler$p(RealTimeChorusViewModel r0) {
        return r0.handler;
    }

    public static final /* synthetic */ boolean access$getHasJoined$p(RealTimeChorusViewModel r0) {
        return r0.hasJoined;
    }

    public static final /* synthetic */ RealTimeChorusUIInfo access$getLastChorusInfo$p(RealTimeChorusViewModel r0) {
        return r0.lastChorusInfo;
    }

    public static final /* synthetic */ long access$getMaxChorusNumber$p(RealTimeChorusViewModel r2) {
        return r2.maxChorusNumber;
    }

    public static final /* synthetic */ KtvModeOrderedSongDataContext access$getOrderedSongDataContext(RealTimeChorusViewModel r0) {
        return r0.getOrderedSongDataContext();
    }

    public static final /* synthetic */ boolean access$getShouldRestoreSilenceStatus$p(RealTimeChorusViewModel r0) {
        return r0.shouldRestoreSilenceStatus;
    }

    public static final /* synthetic */ MusicPanel access$getSingMusic$p(RealTimeChorusViewModel r0) {
        return r0.singMusic;
    }

    public static final /* synthetic */ void access$handleLinkSuccessEvent(RealTimeChorusViewModel r0) {
        r0.handleLinkSuccessEvent();
    }

    public static final /* synthetic */ boolean access$isEngineOn(RealTimeChorusViewModel r0) {
        return r0.isEngineOn();
    }

    public static final /* synthetic */ boolean access$isJoining$p(RealTimeChorusViewModel r0) {
        return r0.isJoining;
    }

    public static final /* synthetic */ boolean access$isLeaving$p(RealTimeChorusViewModel r0) {
        return r0.isLeaving;
    }

    public static final /* synthetic */ boolean access$isLinkGuest$p(RealTimeChorusViewModel r0) {
        return r0.isLinkGuest;
    }

    public static final /* synthetic */ void access$updateChorusMode(RealTimeChorusViewModel r0) {
        r0.updateChorusMode();
    }

    public static final /* synthetic */ void access$updateRealTimeChorusInfo(RealTimeChorusViewModel r0) {
        r0.updateRealTimeChorusInfo();
    }

    private final void checkAutoJoin(String r6) {
        RealTimeChorusUIInfo r7 = this.lastChorusInfo;
        if (r7 == null) goto L30;
        String r8 = r7.getChorusIdStr();
        if (r8 != null) goto L8;
        return;
    L8:
        if (shouldReturnDueToChorusId(r8) == false) goto L11;
        w.a(TAG, "checkAutoJoin chorusIdStr not change");
        return;
    L11:
        KtvModeOrderedSongDataContext r0 = getOrderedSongDataContext();
        if (r0 == null) goto L31;
        MusicPanel r1 = r0.getKtvPublicFirstOrderedSong();
        if (r1 != null) goto L17;
        return;
    L17:
        if (shouldReturnDueToSongList(r1) == false) goto L21;
        w.a(TAG, "checkAutoJoin song list not change");
        return;
    L21:
        if (isLocalJoined(r1) == false) goto L25;
        w.a(TAG, "checkAutoJoin local joined");
        return;
    L25:
        if (shouldAutoJoin(r1) == false) goto L27;
        w.a(TAG, "checkAutoJoin lead singer auto join");
        joinRealTimeChorus(r1, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, "Next song lead singer auto join by checkAutoJoin");
    L28:
        w.a(TAG, "checkAutoJoin update lastChorusId: " + this.lastChorusId + ", lastTopMusicPanel: " + this.lastTopMusicPanel + ", chorusIdStr: " + r8 + ", topMusicPanel: " + r1);
        this.lastTopMusicPanel = r1;
        this.lastChorusId = r8;
        return;
    L27:
        w.a(TAG, "checkAutoJoin not lead singer: ");
        goto L28
    L31:
        return;
    }

    private final String getInteractIdByUid(String r5) {
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        ILinkPlayerInfoBridge r1 = null;
        Object r2 = null;
        r1 = null;
        if (com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a() == null) goto L7;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r0 == null) goto L15;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r3 = r0.getLinkUserInfoCenter();
    L16:
        if (r3 == null) goto L30;
        List r4 = r3.getOnlineUserList();
        if (r4 == null) goto L30;
        Iterator r6 = r4.iterator();
    L21:
        if (r6.hasNext() == false) goto L29;
        Object r7 = r6.next();
        IBaseUser r8 = ((ILinkPlayerInfoBridge) r7).getUser();
        if (r8 == null) goto L25;
        String r9 = r8.getIdString();
    L27:
        if (Intrinsics.areEqual(r9, r5) == false) goto L21;
        r2 = r7;
        goto L29
    L25:
        r9 = null;
    L29:
        r1 = (ILinkPlayerInfoBridge) r2;
    L30:
        if (r1 == null) goto L33;
        String r10 = r1.getInteractId();
        if (r10 == null) goto L33;
        return r10;
    L33:
        return "";
    L15:
        r3 = null;
        goto L16
    L7:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a() == null) goto L12;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r11 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r11 == null) goto L15;
        r3 = r11.getLinkUserInfoCenter();
        goto L16
    L12:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r12 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r12 == null) goto L15;
        r3 = r12.getLinkUserInfoCenter();
        goto L16
    }

    private final void handleJoinLeaveChorusLog(MusicPanel r9) {
        if (this.hasJoined == false) goto L25;
        MusicPanel r0 = this.lastTopMusicForLog;
        if (r0 == null) goto L13;
        KtvMusic r1 = r0.a;
        if (r1 == null) goto L13;
        if (r9 == null) goto L10;
        KtvMusic r2 = r9.a;
    L12:
        if (r1.isSameKtvMusic(r2) == true) goto L25;
    L10:
        r2 = null;
    L13:
        this.hasJoined = false;
        this.lastTopMusicForLog = r9;
        xe2.h.j();
        boolean r3 = this.isAutoJoin;
        if (xe2.h.a != 0) goto L25;
        xe2.h.a = System.currentTimeMillis();
        HashMap r4 = new HashMap();
        String r5 = "1";
        if (r3 == false) goto L19;
        Object r6 = "1";
    L20:
        r4.put("is_auto_join", r6);
        xe2.h.a(r4);
        xe2.h.c(r4);
        xe2.h.b(r4);
        if (xe2.h.h() == true) goto L24;
        r5 = BDLocationException.ERROR_TIMEOUT;
    L24:
        r4.put("is_fixed_guest", r5);
        r4.put("order_limit", xe2.h.f(xe2.h.c));
        r4.put("join_limit", xe2.h.f(xe2.h.d));
        r4.put("stage_level", xe2.h.g());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chorus_join_success", r4, new Object[]{IRoom.class, am2.x.class});
        goto L25
    L19:
        r6 = BDLocationException.ERROR_TIMEOUT;
    L25:
        if (r9 != null) goto L28;
        xe2.h.j();
        return;
    }

    private final boolean isLocalJoined(MusicPanel r4) {
        MusicPanel r0 = this.localChorusJoinStatus.a;
        if (r0 == null) goto L10;
        KtvMusic r1 = r0.a;
        if (r1 == null) goto L10;
        if (r4 == null) goto L8;
        KtvMusic r5 = r4.a;
    L9:
        boolean r6 = KtvUtilsKt.t(r1, r5);
    L11:
        Integer r2 = (Integer) this.chorusUserType.getValue();
        if (r2 == null) goto L17;
        if (r2.intValue() != 1) goto L17;
    L20:
        if (r6 == false) goto L23;
        w.a(TAG, "isLocalJoined " + this.localChorusJoinStatus.b);
        return this.localChorusJoinStatus.b;
    L23:
        return false;
    L17:
        if (((Boolean) KtvSettingHelper.U.getValue()).booleanValue() == true) goto L20;
        return this.localChorusJoinStatus.b;
    L8:
        r5 = null;
    L10:
        r6 = false;
        goto L11
    }

    private final boolean isPreJoined(MusicPanel r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        MusicPanel r1 = this.localPreChorusJoinStatus.a;
        if (r1 == null) goto L10;
        KtvMusic r2 = r1.a;
        if (r2 == null) goto L10;
        boolean r4 = KtvUtilsKt.t(r2, r3.a);
    L11:
        if (r4 == false) goto L14;
        w.a(TAG, "isPreJoined " + this.localPreChorusJoinStatus.b);
        return this.localPreChorusJoinStatus.b;
    L14:
        return false;
    L10:
        r4 = false;
        goto L11
    }

    private final boolean isUserOnLine(String r6) {
        com.bytedance.live.datacontext.m r0 = o3.f().getRoom();
        Object r1 = null;
        if (r0 == null) goto L7;
        IRoom r2 = (IRoom) r0.getValue();
        if (r2 == null) goto L7;
        String r3 = r2.getAnchorId();
    L9:
        if (Intrinsics.areEqual(r3, r6) == false) goto L11;
        return true;
    L11:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a() == null) goto L16;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r4 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r4 == null) goto L24;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r5 = r4.getLinkUserInfoCenter();
    L25:
        if (r5 == null) goto L39;
        List r7 = r5.getOnlineUserList();
        if (r7 == null) goto L39;
        Iterator r8 = r7.iterator();
    L30:
        if (r8.hasNext() == false) goto L38;
        Object r9 = r8.next();
        IBaseUser r10 = ((ILinkPlayerInfoBridge) r9).getUser();
        if (r10 == null) goto L34;
        String r11 = r10.getIdString();
    L36:
        if (Intrinsics.areEqual(r11, r6) == false) goto L30;
        r1 = r9;
        goto L38
    L34:
        r11 = null;
    L38:
        r1 = (ILinkPlayerInfoBridge) r1;
    L39:
        if (r1 != null) goto L46;
        return false;
    L46:
        return true;
    L24:
        r5 = null;
        goto L25
    L16:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a() == null) goto L21;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r12 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r12 == null) goto L24;
        r5 = r12.getLinkUserInfoCenter();
        goto L25
    L21:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r13 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r13 == null) goto L24;
        r5 = r13.getLinkUserInfoCenter();
    L7:
        r3 = null;
        goto L9
    }

    private final void onReceiverFinish(l2 r14) {
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L9;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r0 == null) goto L14;
        RealTimeChorusMainViewWidget r1 = r0.u2();
        if (r1 == null) goto L14;
        double r2 = r1.Uc();
    L15:
        double r3 = r2;
        if (getCurrentUserChorusRole() != 2) goto L18;
    L21:
        boolean r4 = true;
    L22:
        w.a(TAG, "receiver finish wrds so leave isNeedLeave " + r4);
        if (r14 == null) goto L25;
        long r6 = r14.a();
    L26:
        if (r4 == false) goto L35;
        Integer r15 = (Integer) this.chorusUserType.getValue();
        if (r15 != null) goto L31;
    L33:
        leaveRealTimeChorus(r3, 2, r6, C02621.INSTANCE);
        goto L35
    L31:
        if (r15.intValue() != 4) goto L33;
        w.a(TAG, "receiver finish IM but is fall back type so leave without api call");
        cdnSingerLeave();
    L35:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L44;
        String r16 = String.valueOf(this.maxChorusNumber);
        Intrinsics.checkNotNullParameter(r16, "joinUv");
        if (Intrinsics.areEqual(xe2.h.d(), "") == false) goto L39;
    L42:
        this.maxChorusNumber = 0;
        return;
    L39:
        if (Intrinsics.areEqual(xe2.h.e(), "") == true) goto L42;
        HashMap r5 = new HashMap();
        xe2.h.a(r5);
        xe2.h.c(r5);
        r5.put("join_uv", r16);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chorus_ksong_info_show", r5, new Object[]{IRoom.class, am2.x.class});
        goto L42
    L44:
        return;
    L25:
        r6 = 0;
        goto L26
    L18:
        if (getCurrentUserChorusRole() == 1) goto L21;
        r4 = false;
    L14:
        r2 = 0.0d;
        goto L15
    L9:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r7 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r7 == null) goto L14;
        RealTimeChorusMainViewWidget r8 = r7.u2();
        if (r8 == null) goto L14;
        r2 = r8.Uc();
        goto L15
    }

    private final boolean shouldAutoJoin(MusicPanel r3) {
        RealTimeChorusUIInfo r0 = this.lastChorusInfo;
        if (r0 == null) goto L9;
        if (((int) r0.getChorusMode()) != 2) goto L9;
        if (isAssignLead() == false) goto L9;
    L10:
        return true;
    L9:
        if (r3.a.isOrderedBy(getCurUserId()) == true) goto L10;
        return false;
    }

    private final boolean shouldReturnDueToChorusId(String r4) {
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (Intrinsics.areEqual(r4, this.lastChorusId) == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private final boolean shouldReturnDueToSongList(MusicPanel r2) {
        return KtvUtilsKt.u(r2, this.lastTopMusicPanel);
    }

    private final void stopLiveClient(String r2) {
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r0 == null) goto L9;
        r0.E0(r2);
        return;
    L9:
        return;
    }

    private final void updateLeaderSingerId(String r2) {
        if ((!Intrinsics.areEqual(r2, (String) this.leadSingerUid.getValue())) == true) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r2)) == false) goto L12;
        String r0 = (String) this.leadSingerUid.getValue();
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        this.lastLeaderSingerID = r0;
        this.leadSingerUid.setValue(r2);
        return;
    }

    public final void handleStateChanged(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r9) {
        Intrinsics.checkNotNullParameter(r9, "valid");
        if ((((KtvRoomLyricsStateMachineConfig.d) r9.c) instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L30;
        w.a(TAG, "handleSingingState need check local leave status ");
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        KtvMusic r1 = null;
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r2 = r0.getKtvCoreViewModel();
        if (r2 == null) goto L13;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r3 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r2.getValue();
        if (r3 == null) goto L13;
        KtvRoomLyricsStateMachineConfig.d r4 = r3.getCurState();
        if (r4 == null) goto L13;
        MusicPanel r5 = r4.b();
    L14:
        fd2.b0 r6 = this.localChorusJoinStatus;
        if (r6.b == false) goto L31;
        MusicPanel r7 = r6.a;
        if (r7 == null) goto L25;
        KtvMusic r8 = r7.a;
        if (r8 == null) goto L25;
        if (r5 == null) goto L23;
        r1 = r5.a;
    L23:
        if (KtvUtilsKt.t(r8, r1) != true) goto L25;
        return;
    L25:
        if (isCDNViceSinger() == false) goto L27;
    L28:
        w.a(TAG, "handleSingingState music not match so need leave");
        leaveRealTimeChorus(0.0d, 2, -1, C02611.INSTANCE);
        return;
    L27:
        if (isSilenceViceSinger() == true) goto L28;
        return;
    L31:
        return;
    L13:
        r5 = null;
        goto L14
    }

    public final void observerKtvOrderedSongList(LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        handleSongListChange();
        KtvModeOrderedSongDataContext r0 = getOrderedSongDataContext();
        if (r0 == null) goto L6;
        r0.observerKtvSingSongListChange(r4, true, new m(this));
        return;
    }

    public void onChanged(KVData r4) {
        if (r4 == null) goto L4;
        String r5 = r4.getKey();
    L5:
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.hashCode() == (-1093702240)) goto L11;
        return;
    L11:
        if (r5.equals("data_online_changed_list") == false) goto L14;
        w.a(TAG, "DATA_ONLINE_CHANGED_LIST");
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, 100);
        return;
    L14:
        return;
    L4:
        r5 = null;
        goto L5
    }

    public final void setChorusAssignLeader(NextLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isChorusAssignLeader = r2;
    }

    public final void setChorusMode(NextLiveData<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.chorusMode = r2;
    }

    public final void setChorusSpatialList(NextLiveData<ArrayList<String>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.chorusSpatialList = r2;
    }

    public final void setChorusUserType(NextLiveData<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.chorusUserType = r2;
    }

    public final void setDataCenter(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dataCenter = r2;
    }

    public final void setLastLeaderInteractId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.lastLeaderInteractId = r2;
    }

    public final void setLastLeaderSingerID(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.lastLeaderSingerID = r2;
    }

    public final void setLastRole(int r1) {
        this.lastRole = r1;
    }

    public final void setLocalChorusJoinStatus(fd2.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.localChorusJoinStatus = r2;
    }

    public final void setLocalPreChorusJoinStatus(fd2.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.localPreChorusJoinStatus = r2;
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }

    public RealTimeChorusViewModel(Context r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.context = r4;
        this.dataCenter = r5;
        CompositeDisposable r6 = new CompositeDisposable();
        this.compositeDisposable = r6;
        this.lastLeaderSingerID = "";
        this.leadSingerUid = new NextLiveData();
        this.lastLeaderInteractId = "";
        this.isNeedPush = new NextLiveData();
        this.subToken = new NextLiveData();
        this.localChorusJoinStatus = new fd2.b0();
        this.localPreChorusJoinStatus = new fd2.b0();
        this.isChorusAssignLeader = new NextLiveData();
        this.chorusUserType = new NextLiveData();
        this.chorusSpatialList = new NextLiveData();
        this.chorusMode = new NextLiveData();
        this.curUserRealTimeChorusRole = new NextLiveData();
        NextLiveData<Boolean> r0 = new NextLiveData();
        r0.setValue(Boolean.FALSE);
        Unit r1 = Unit.INSTANCE;
        this.isPlayingMusic = r0;
        this.curUserId$delegate = LazyKt.lazy(RealTimeChorusViewModel$curUserId$2.INSTANCE);
        this.handler = new g(this, Looper.getMainLooper());
        this.msgListener = new l(this);
        this.dataCenter.observe("data_online_changed_list", this);
        com.bytedance.android.livesdk.chatroom.o r2 = o3.f();
        com.bytedance.live.datacontext.j r3 = com.bytedance.android.live.liveinteract.api.utils.m.d().D();
        vlc.d r7 = null;
        if (r3 == null) goto L5;
        LinkMicRoomDataSyncModel r8 = (LinkMicRoomDataSyncModel) r3.getValue();
    L6:
        if (r8 != null) goto L16;
        com.bytedance.live.datacontext.j r9 = r2.w1();
        if (r9 == null) goto L12;
        ylc.e r10 = (ylc.e) r9.getValue();
        if (r10 == null) goto L12;
        r8 = (LinkMicRoomDataSyncModel) dc2.b.a(r10, RealTimeChorusViewModel$1$1.INSTANCE);
    L13:
        com.bytedance.live.datacontext.j r11 = com.bytedance.android.live.liveinteract.api.utils.m.d().D();
        if (r11 == null) goto L16;
        r11.d(r8);
    L12:
        r8 = null;
    L16:
        if (r8 == null) goto L24;
        dc2.c r12 = r8.getTalkRoomListUserInfoPb();
        if (r12 == null) goto L24;
        Observable r13 = r12.e;
        if (r13 == null) goto L24;
        Disposable r14 = r13.subscribe(new a(this));
        if (r14 == null) goto L24;
        RxUtilKt.c(r14, r6);
    L24:
        com.bytedance.android.livesdk.chatroom.o r15 = o3.f();
        if (r15 == null) goto L29;
        com.bytedance.live.datacontext.j r16 = r15.getMessageManager();
        if (r16 == null) goto L29;
        vlc.d r17 = (vlc.d) r16.getValue();
    L31:
        if ((r17 instanceof xlc.a) == false) goto L34;
        r7 = r17;
    L34:
        xlc.a r18 = (xlc.a) r7;
        if (r18 == null) goto L37;
        r18.y(MessageType.REAL_TIME_CHORUS_MESSAGE.getIntType(), this.msgListener);
    L37:
        com.bytedance.android.livesdk.chatroom.o r19 = o3.f();
        if (r19 == null) goto L44;
        com.bytedance.live.datacontext.j r20 = r19.getMessageManager();
        if (r20 == null) goto L44;
        vlc.d r21 = (vlc.d) r20.getValue();
        if (r21 == null) goto L44;
        r21.addMessageListener(MessageType.KTV_CHORUS_ACTION_MESSAGE.getIntType(), this.msgListener);
    L44:
        RxUtilKt.c(xs2.b.a().b(jd0.j.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)), r6);
        RxUtilKt.c(xs2.b.a().b(jd0.r.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this)), r6);
        RxUtilKt.c(xs2.b.a().b(jd0.p.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)), r6);
        RxUtilKt.c(xs2.b.a().b(jd0.o.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this)), r6);
        this.lastChorusId = "";
        return;
    L29:
        r17 = null;
        goto L31
    L5:
        r8 = null;
        goto L6
    }

    public static final /* synthetic */ void access$checkAutoJoin(RealTimeChorusViewModel r0, String r1) {
        r0.checkAutoJoin(r1);
    }

    public static final /* synthetic */ String access$getInteractIdByUid(RealTimeChorusViewModel r0, String r1) {
        return r0.getInteractIdByUid(r1);
    }

    public static final /* synthetic */ void access$handleJoinLeaveChorusLog(RealTimeChorusViewModel r0, MusicPanel r1) {
        r0.handleJoinLeaveChorusLog(r1);
    }

    public static final /* synthetic */ void access$onReceiverFinish(RealTimeChorusViewModel r0, l2 r1) {
        r0.onReceiverFinish(r1);
    }

    public static final /* synthetic */ void access$setCurUserIsLead$p(RealTimeChorusViewModel r0, boolean r1) {
        r0.curUserIsLead = r1;
    }

    public static final /* synthetic */ void access$setHandler$p(RealTimeChorusViewModel r0, g r1) {
        r0.handler = r1;
    }

    public static final /* synthetic */ void access$setHasJoined$p(RealTimeChorusViewModel r0, boolean r1) {
        r0.hasJoined = r1;
    }

    public static final /* synthetic */ void access$setJoining$p(RealTimeChorusViewModel r0, boolean r1) {
        r0.isJoining = r1;
    }

    public static final /* synthetic */ void access$setLastChorusInfo$p(RealTimeChorusViewModel r0, RealTimeChorusUIInfo r1) {
        r0.lastChorusInfo = r1;
    }

    public static final /* synthetic */ void access$setLeaving$p(RealTimeChorusViewModel r0, boolean r1) {
        r0.isLeaving = r1;
    }

    public static final /* synthetic */ void access$setLinkGuest$p(RealTimeChorusViewModel r0, boolean r1) {
        r0.isLinkGuest = r1;
    }

    public static final /* synthetic */ void access$setMaxChorusNumber$p(RealTimeChorusViewModel r0, long r1) {
        r0.maxChorusNumber = r1;
    }

    public static final /* synthetic */ void access$setShouldRestoreSilenceStatus$p(RealTimeChorusViewModel r0, boolean r1) {
        r0.shouldRestoreSilenceStatus = r1;
    }

    public static final /* synthetic */ void access$setSingMusic$p(RealTimeChorusViewModel r0, MusicPanel r1) {
        r0.singMusic = r1;
    }

    private final void initLiveClient(String r2, String r3) {
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r0 == null) goto L9;
        r0.W0(r2, r3);
        return;
    L9:
        return;
    }

    public final void observerCurUserRealTimeChorusRole(LifecycleOwner r2, Observer<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.curUserRealTimeChorusRole.observe(r2, r3);
    }

    public final void updateChorusUserType(int r21, String r22) {
        Intrinsics.checkNotNullParameter(r22, "source");
        Integer r4 = (Integer) this.chorusUserType.getValue();
        if (r4 != null) goto L6;
    L7:
        w.a(TAG, "updateChorusUserType " + r21 + ' ' + r22);
        KtvContext.Companion.getClass();
        KtvContext r5 = KtvContext.a.g();
        Long r6 = null;
        if (r5 == null) goto L16;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r7 = r5.getKtvCoreViewModel();
        if (r7 == null) goto L16;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r8 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r7.getValue();
        if (r8 == null) goto L16;
        KtvRoomLyricsStateMachineConfig.d r9 = r8.getCurState();
        if (r9 == null) goto L16;
        MusicPanel r10 = r9.b();
    L17:
        int r11 = xe2.g.a;
        int r12 = getCurrentUserChorusRole();
        Intrinsics.checkNotNullParameter(r22, "source");
        JSONObject r13 = new JSONObject();
        if (r10 == null) goto L22;
        KtvMusic r14 = r10.a;
        if (r14 == null) goto L22;
        Object r15 = Long.valueOf(r14.getMId());
    L23:
        r13.put("music_id", r15);
        if (r10 == null) goto L29;
        KtvMusic r16 = r10.a;
        if (r16 == null) goto L29;
        String r17 = r16.getMTitle();
        if (r17 == null) goto L29;
    L30:
        r13.put("music_name", r17);
        r13.put("is_visible", String.valueOf(true));
        r13.put("cur_chorus_role", String.valueOf(r12));
        r13.put("source", r22);
        xe2.g.f(r13);
        int r18 = rd0.a.a;
        MultiTraceData.TraceBusiness r19 = MultiTraceData.TraceBusiness.RTChorus;
        rd0.a.b(r19, MultiTraceData.TraceEvent.ChorusFlow, "SetUserVisibility", 0, null, r13, 88);
        this.chorusUserType.setValue(Integer.valueOf(r21));
        RealTimeChorusUIInfo r1 = this.lastChorusInfo;
        if (r1 == null) goto L33;
        r6 = r1.getChorusID();
    L33:
        String r2 = String.valueOf(r6);
        Intrinsics.checkNotNullParameter(r2, "chorusId");
        Intrinsics.checkNotNullParameter(r22, "source");
        JSONObject r20 = new JSONObject();
        r20.put("chorusId", r2);
        r20.put("source", r22);
        xe2.g.f(r20);
        rd0.a.b(r19, MultiTraceData.TraceEvent.ChorusInfoUpdate, "UpdateUserType", 0, null, r20, 88);
        return;
    L29:
        r17 = "";
    L22:
        r15 = BDLocationException.ERROR_TIMEOUT;
    L16:
        r10 = null;
        goto L17
    L6:
        if (r21 != r4.intValue()) goto L7;
    }

    public final void updateRole(int r22, String r23) {
        Intrinsics.checkNotNullParameter(r23, "source");
        Integer r4 = (Integer) this.curUserRealTimeChorusRole.getValue();
        if (r4 != null) goto L6;
    L7:
        w.a(TAG, "updateRole " + r22 + ' ' + r23);
        Integer r5 = (Integer) this.curUserRealTimeChorusRole.getValue();
        if (r5 == null) goto L10;
        int r6 = r5.intValue();
    L11:
        this.lastRole = r6;
        this.curUserRealTimeChorusRole.setValue(Integer.valueOf(r22));
        int r7 = xe2.g.a;
        RealTimeChorusUIInfo r8 = this.lastChorusInfo;
        MusicPanel r9 = null;
        if (r8 == null) goto L14;
        Long r10 = r8.getChorusID();
    L15:
        String r11 = String.valueOf(r10);
        String r12 = m469getLeadSingerUid();
        String r13 = getInteractIdByUid(m469getLeadSingerUid());
        boolean r14 = isEngineOn();
        String r15 = (String) this.subToken.getValue();
        String r16 = KtvSettingHelper.B();
        Intrinsics.checkNotNullParameter(r11, "chorusId");
        Intrinsics.checkNotNullParameter(r12, "leaderSingerId");
        Intrinsics.checkNotNullParameter(r13, "leaderSingerInteractId");
        Intrinsics.checkNotNullParameter(r16, "rtcEncodeConfig");
        Intrinsics.checkNotNullParameter(r23, "source");
        JSONObject r17 = new JSONObject();
        r17.put("chorusId", r11);
        r17.put("lead_singer_uid", r12);
        r17.put("lead_singer_interactId", r13);
        if (r14 == false) goto L18;
        String r18 = "1";
    L19:
        r17.put("is_engine_on", r18);
        r17.put("sub_rtc_token", r15);
        r17.put("rtc_encode_config", r16);
        r17.put("source", r23);
        xe2.g.f(r17);
        int r2 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusInfoUpdate, "updateRole", 0, null, r17, 88);
        if (r22 != 4) goto L27;
        KtvModeOrderedSongDataContext r1 = getOrderedSongDataContext();
        if (r1 == null) goto L24;
        r9 = r1.getKtvPublicFirstOrderedSong();
    L24:
        fd2.b0 r3 = new fd2.b0();
        r3.a = r9;
        r3.b = false;
        Unit r19 = Unit.INSTANCE;
        this.localChorusJoinStatus = r3;
        return;
    L27:
        return;
    L18:
        r18 = BDLocationException.ERROR_TIMEOUT;
        goto L19
    L14:
        r10 = null;
        goto L15
    L10:
        r6 = 0;
        goto L11
    L6:
        if (r22 != r4.intValue()) goto L7;
    }

    public static final /* synthetic */ void access$initLiveClient(RealTimeChorusViewModel r0, String r1, String r2) {
        r0.initLiveClient(r1, r2);
    }

    private final void applySilenceLink(String r2, String r3, boolean r4) {
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r0 == null) goto L9;
        r0.O0(r2, r3, r4);
        return;
    L9:
        return;
    }

    private final void realLeave(int r17, long r18, Function1<? super Boolean, Unit> r20) {
        KtvContext.Companion.getClass();
        KtvContext r3 = KtvContext.a.g();
        if (r3 == null) goto L11;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r4 = r3.getKtvCoreViewModel();
        if (r4 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r5 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r4.getValue();
        if (r5 == null) goto L11;
        KtvRoomLyricsStateMachineConfig.d r6 = r5.getCurState();
        if (r6 == null) goto L11;
        MusicPanel r7 = r6.b();
    L12:
        fd2.b0 r8 = new fd2.b0();
        r8.a = r7;
        r8.b = false;
        Unit r9 = Unit.INSTANCE;
        this.localChorusJoinStatus = r8;
        fd2.b0 r10 = new fd2.b0();
        r10.a = r7;
        r10.b = false;
        this.localPreChorusJoinStatus = r10;
        Integer r11 = (Integer) this.chorusUserType.getValue();
        if (r11 != null) goto L16;
    L17:
        Integer r12 = (Integer) this.chorusUserType.getValue();
        if (r12 != null) goto L21;
    L23:
        updateRole(3, "leaveRealTimeChorus");
    L53:
        Integer r13 = (Integer) this.chorusUserType.getValue();
        if (r13 != null) goto L57;
    L62:
        if (r20 == null) goto L64;
        Unit r2 = (Unit) r20.invoke(Boolean.TRUE);
    L64:
        updateChorusUserType(0, "leaveRealTimeChorus");
        if (isAssignLead() == false) goto L70;
        if (r17 == 1) goto L68;
        if (r17 != 2) goto L70;
    L68:
        updateChorusLeader(false, true, "leaveRealTimeChorus");
    L70:
        if (isPermanentLinkGuest() == false) goto L72;
    L75:
        updateChorusUserType(1, "leaveRealTimeChorus");
        this.isNeedPush.setValue(Boolean.TRUE);
        if (this.shouldRestoreSilenceStatus == false) goto L83;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r1 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r1 == null) goto L82;
        com.bytedance.android.live.liveinteract.voicechat.b r14 = r1.muteManager();
        if (r14 == null) goto L82;
        r14.b("reset last silence", new n());
    L82:
        this.shouldRestoreSilenceStatus = false;
    L83:
        this.isLeaving = false;
        MusicPanel r15 = this.singMusic;
        if (r15 == null) goto L91;
        KtvMusic r16 = r15.a;
        if (r16 != null) goto L88;
        return;
    L88:
        if (r16.isOrderedBy(getCurUserId()) != true) goto L93;
        this.waitJoinUntilSingMusicChange = true;
        return;
    L93:
        return;
    L91:
        return;
    L72:
        if (isAssignLead() == true) goto L75;
        updateChorusUserType(0, "leaveRealTimeChorus");
        goto L83
    L57:
        if (r13.intValue() != 2) goto L62;
        w.a(TAG, " need silenceCloseLink");
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r19 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r19 == null) goto L61;
        r19.A7();
    L61:
        int r21 = xe2.g.a;
        JSONObject r110 = new JSONObject();
        r110.put("leaveType", String.valueOf(r17));
        r110.put("chorusId", String.valueOf(r18));
        xe2.g.f(r110);
        int r22 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusFlow, "SilenceLeave", 0, null, r110, 88);
        goto L62
    L21:
        if (r12.intValue() != 4) goto L23;
    L24:
        com.bytedance.live.datacontext.m r23 = o3.f().getRoom();
        String r24 = "";
        if (r23 == null) goto L30;
        IRoom r25 = (IRoom) r23.getValue();
        if (r25 == null) goto L30;
        String r26 = r25.getMultiStreamData();
        if (r26 == null) goto L30;
    L31:
        w.a(TAG, " isCDNViceSinger switchStream ".concat(r26));
        updateRole(4, "leaveRealTimeChorus");
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r27 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r27 == null) goto L41;
        com.bytedance.live.datacontext.m r28 = o3.f().getRoom();
        if (r28 == null) goto L39;
        IRoom r29 = (IRoom) r28.getValue();
        if (r29 == null) goto L39;
        String r30 = r29.getMultiStreamData();
        if (r30 == null) goto L39;
    L40:
        r27.bm(r30);
    L39:
        r30 = "";
    L41:
        ILivePlayerClient r31 = hs0.a.b.getCurrentClient();
        if (r31 == null) goto L44;
        r31.setPlayerVolume(1.0f);
    L44:
        int r32 = xe2.g.a;
        com.bytedance.live.datacontext.m r33 = o3.f().getRoom();
        if (r33 == null) goto L52;
        IRoom r34 = (IRoom) r33.getValue();
        if (r34 == null) goto L52;
        String r35 = r34.getMultiStreamData();
        if (r35 == null) goto L52;
        r24 = r35;
    L52:
        xe2.g.h(r24, "leaveChorus");
        stopLiveClient("leaveRealTimeChorus");
    L30:
        r26 = "";
        goto L31
    L16:
        if (r11.intValue() == 3) goto L24;
    L11:
        r7 = null;
        goto L12
    }

    private final void updateChorusLeader(boolean r2, boolean r3, String r4) {
        if (r3 == true) goto L4;
    L5:
        w.a(TAG, "updateAssignLead " + r2 + " ;; source " + r4);
        this.isChorusAssignLeader.setValue(Boolean.valueOf(r2));
        return;
    L4:
        if ((!Intrinsics.areEqual((Boolean) this.isChorusAssignLeader.getValue(), Boolean.valueOf(r2))) == true) goto L5;
    }

    public final boolean isNeedCheckOrder(MusicPanel r3, String r4, String r5) {
        Lazy r0 = KtvSettingHelper.a;
        if (((Boolean) KtvSettingHelper.X.getValue()).booleanValue() == false) goto L10;
        if (r3 != null) goto L6;
    L8:
        return false;
    L6:
        if ((!Intrinsics.areEqual(r4, r5)) == false) goto L8;
        return true;
    L10:
        return true;
    }

    public final void updateRealtimeChorusGuestStatus(String r9, long r10, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "toUsers");
        ALogger.i(TAG, "updateRealtimeChorusGuestStatus toUsers: " + r9 + ", status: " + r10);
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L9;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L9;
        long r3 = r2.getId();
    L10:
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).updateRealtimeChorusGuestStatus(r3, r9, r10).compose(RxUtil.rxSchedulerHelper()).subscribe(new o(r12), p.a), this.compositeDisposable);
        return;
    L9:
        r3 = 0;
        goto L10
    }

    public static final /* synthetic */ void access$applySilenceLink(RealTimeChorusViewModel r0, String r1, String r2, boolean r3) {
        r0.applySilenceLink(r1, r2, r3);
    }

    public static final /* synthetic */ void access$realLeave(RealTimeChorusViewModel r0, int r1, long r2, Function1 r4) {
        r0.realLeave(r1, r2, r4);
    }

    public final void joinRealTimeChorus(MusicPanel r18, Function1<Object, Unit> r19, Function1<? super Throwable, Unit> r20, String r21) {
        Intrinsics.checkNotNullParameter(r18, "panel");
        Intrinsics.checkNotNullParameter(r19, "successCallback");
        Intrinsics.checkNotNullParameter(r20, "failCallback");
        Intrinsics.checkNotNullParameter(r21, "source");
        if (this.isJoining == true) goto L30;
        Integer r5 = (Integer) this.curUserRealTimeChorusRole.getValue();
        if (r5 != null) goto L8;
    L9:
        Integer r6 = (Integer) this.curUserRealTimeChorusRole.getValue();
        if (r6 != null) goto L13;
    L17:
        w.a(TAG, "joinRealTimeChorus -----------");
        this.isAutoJoin = false;
        this.isJoining = true;
        com.bytedance.android.livesdk.chatroom.o r7 = o3.f();
        long r8 = 0;
        if (r7 == null) goto L24;
        com.bytedance.live.datacontext.m r9 = r7.getRoom();
        if (r9 == null) goto L24;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L24;
        long r11 = r10.getId();
    L25:
        RealTimeChorusInfo r12 = r18.C;
        if (r12 == null) goto L28;
        r8 = r12.getChorusID();
    L28:
        long r15 = r18.a.getMId();
        RxUtilKt.c(((RealTimeChorusApi) com.bytedance.android.live.network.c.b().e(RealTimeChorusApi.class)).joinChorus(r11, r8, r15).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this, r19, r18, r21), new i(this, r20, r18, r21)), this.compositeDisposable);
        return;
    L24:
        r11 = 0;
        goto L25
    L13:
        if (r6.intValue() != 2) goto L17;
        if (isCDNViceSinger() == true) goto L17;
    L8:
        if (r5.intValue() != 1) goto L9;
    L30:
        w.a(TAG, "joinRealTimeChorus " + ((Integer) this.curUserRealTimeChorusRole.getValue()) + "  isCDNViceSinger " + isCDNViceSinger());
        r19.invoke("");
    }

    public final void leaveRealTimeChorus(double r20, int r22, long r23, Function1<? super Boolean, Unit> r25) {
        if (this.isLeaving == false) goto L5;
        return;
    L5:
        this.isLeaving = true;
        w.a(TAG, "leaveRealTimeChorus ----------- leaveType " + r22 + ' ' + ((Integer) this.chorusUserType.getValue()));
        Integer r0 = (Integer) this.chorusUserType.getValue();
        if (r0 == null) goto L20;
        if (r0.intValue() != 4) goto L20;
        com.bytedance.live.datacontext.m r1 = o3.f().getRoom();
        if (r1 == null) goto L16;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L16;
        String r3 = r2.getMultiStreamData();
        if (r3 == null) goto L16;
    L17:
        w.a(TAG, " isCDNViceSinger FALL_BACK switchStream ".concat(r3));
        this.isLeaving = false;
        cdnSingerLeave();
        return;
    L16:
        r3 = "";
    L20:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L26;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r4 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r4 == null) goto L31;
        RealTimeChorusMainViewWidget r5 = r4.u2();
        if (r5 == null) goto L31;
        double r6 = r5.Gq();
    L32:
        double r17 = r6;
        com.bytedance.android.livesdk.chatroom.o r7 = o3.f();
        long r8 = 0;
        if (r7 == null) goto L39;
        com.bytedance.live.datacontext.m r9 = r7.getRoom();
        if (r9 == null) goto L39;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L39;
        long r11 = r10.getId();
    L41:
        if (r23 != 0) goto L52;
        KtvModeOrderedSongDataContext r12 = getOrderedSongDataContext();
        if (r12 == null) goto L51;
        List<MusicPanel> r13 = r12.m200getKtvSingSongList();
        if (r13 == null) goto L51;
        MusicPanel r14 = (MusicPanel) KtvUtilsKt.K(r13, 0);
        if (r14 == null) goto L51;
        RealTimeChorusInfo r15 = r14.C;
        if (r15 == null) goto L51;
        r8 = r15.getChorusID();
    L51:
        long r16 = r8;
    L53:
        Ref.ObjectRef r18 = new Ref.ObjectRef();
        KtvContext.Companion.getClass();
        KtvContext r19 = KtvContext.a.g();
        if (r19 == null) goto L62;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r21 = r19.getKtvCoreViewModel();
        if (r21 == null) goto L62;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r24 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r21.getValue();
        if (r24 == null) goto L62;
        KtvRoomLyricsStateMachineConfig.d r26 = r24.getCurState();
        if (r26 == null) goto L62;
        MusicPanel r27 = r26.b();
    L63:
        r18.element = r27;
        Integer r28 = (Integer) this.chorusUserType.getValue();
        if (r28 != null) goto L66;
        r28 = 0;
    L66:
        int r110 = r28.intValue();
        if (r22 != 2) goto L70;
        realLeave(r22, r23, r25);
    L70:
        RxUtilKt.c(((RealTimeChorusApi) com.bytedance.android.live.network.c.b().e(RealTimeChorusApi.class)).leaveChorus(r11, r16, r20, r22, r110, r17).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(this, r22, r23, r25, r18), new k(this, r22, r23, r18)), this.compositeDisposable);
        return;
    L62:
        r27 = null;
        goto L63
    L52:
        r16 = r23;
    L39:
        r11 = 0;
    L31:
        r6 = 0.0d;
        goto L32
    L26:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r29 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r29 == null) goto L31;
        RealTimeChorusMainViewWidget r30 = r29.u2();
        if (r30 == null) goto L31;
        r6 = r30.Gq();
        goto L32
    }

    public static /* synthetic */ void realLeave$default(RealTimeChorusViewModel r0, int r1, long r2, Function1 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.realLeave(r1, r2, r4);
    }

    public static /* synthetic */ void leaveRealTimeChorus$default(RealTimeChorusViewModel r7, double r8, int r10, long r11, Function1 r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r11 = 0;
    L5:
        r7.leaveRealTimeChorus(r8, r10, r11, r13);
    }
}
