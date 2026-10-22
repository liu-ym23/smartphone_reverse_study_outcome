package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LongSparseArray;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.broadcast.api.model.z0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.api.c0;
import com.bytedance.android.live.ktv.common.model.bean.ChallengeChangeType;
import com.bytedance.android.live.ktv.common.model.bean.SwitchStatus;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.api.KtvComponentApi;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.CloseChallengeType;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.KtvChallengeStatusMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KTVChallengeStatusMessage;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.cd;
import com.bytedance.android.livesdk.message.model.hd;
import com.bytedance.android.livesdk.model.KtvChallengeProperty;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.bdlocation.sensor.SensorBatchGpsCollector;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0002Á\u0001\u0018\u0000 Ð\u00012\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0002Ñ\u0001B\u0013\u0012\b\u0010Å\u0001\u001a\u00030Ä\u0001¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\u001e\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\"\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001cH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002Jp\u0010\u001e\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u00102\b\b\u0002\u0010,\u001a\u00020+2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001cH\u0002J\u0010\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020#H\u0002J\u0010\u00101\u001a\u00020\b2\u0006\u00100\u001a\u00020\u0010H\u0002J3\u00104\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010#2\b\u00102\u001a\u0004\u0018\u00010#2\u0006\u0010)\u001a\u00020\r2\u0006\u00103\u001a\u00020\u0010H\u0002¢\u0006\u0004\b4\u00105J\u0014\u00106\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u00107\u001a\u00020\bH\u0002J\b\u00108\u001a\u00020\bH\u0002J\b\u00109\u001a\u00020\u0010H\u0002J\u0010\u0010<\u001a\u00020\b2\u0006\u0010;\u001a\u00020:H\u0002J\u0018\u0010?\u001a\u00020\b2\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020#H\u0002J\"\u0010E\u001a\u00020\b2\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C0@H\u0002J\b\u0010F\u001a\u00020\bH\u0002J\b\u0010G\u001a\u00020\bH\u0002J\"\u0010L\u001a\u00020\b2\b\u0010I\u001a\u0004\u0018\u00010H2\u0006\u0010J\u001a\u00020\u00102\u0006\u0010K\u001a\u00020\u0010H\u0002J\b\u0010M\u001a\u00020\bH\u0002J\b\u0010N\u001a\u00020\bH\u0002J\b\u0010O\u001a\u00020\bH\u0002J\u0010\u0010Q\u001a\u00020\b2\u0006\u0010P\u001a\u00020\rH\u0002J\u0010\u0010R\u001a\u00020\b2\u0006\u0010P\u001a\u00020\rH\u0002J\u0018\u0010S\u001a\u00020\b2\u0006\u00102\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0002J\u0018\u0010U\u001a\u00020\b2\u0006\u0010.\u001a\u00020#2\u0006\u0010T\u001a\u00020#H\u0002J\u0012\u0010X\u001a\u00020\u00102\b\u0010W\u001a\u0004\u0018\u00010VH\u0002J\b\u0010Y\u001a\u00020\u0010H\u0002J\b\u0010Z\u001a\u00020\bH\u0002J\u0010\u0010[\u001a\u00020\b2\u0006\u0010T\u001a\u00020#H\u0002J\b\u0010\\\u001a\u00020\bH\u0002J\b\u0010^\u001a\u00020]H\u0002J\b\u0010_\u001a\u00020\bH\u0002J&\u0010d\u001a\u00020\b2\u001c\u0010D\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020b0`j\u0002`cH\u0002J\b\u0010e\u001a\u00020\u0010H\u0002J&\u0010f\u001a\u00020\b2\u001c\u0010D\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020b0`j\u0002`cH\u0002J\u0018\u0010g\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0002J\b\u0010h\u001a\u00020\u0010H\u0002J\u001c\u0010j\u001a\u00020\b2\u0006\u0010i\u001a\u00020\r2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010HH\u0002J\b\u0010k\u001a\u00020\u0016H\u0002J\b\u0010l\u001a\u00020\u0010H\u0002J\b\u0010m\u001a\u00020\u0010H\u0002J\b\u0010n\u001a\u00020\u0010H\u0002J\b\u0010o\u001a\u00020\u0016H\u0002J\u0010\u0010q\u001a\u00020\u00162\u0006\u0010p\u001a\u00020\u0016H\u0002J\u0010\u0010t\u001a\n s*\u0004\u0018\u00010r0rH\u0002J\b\u0010u\u001a\u00020\bH\u0002J\u0010\u0010v\u001a\u00020\b2\u0006\u0010)\u001a\u00020\rH\u0002J\u0010\u0010w\u001a\u00020\b2\u0006\u0010P\u001a\u00020\rH\u0002J\u0010\u0010y\u001a\u00020\b2\u0006\u0010x\u001a\u00020\rH\u0002J\u0010\u0010{\u001a\u00020\b2\u0006\u0010z\u001a\u00020#H\u0002J&\u0010}\u001a\u00020\b2\u001c\u0010|\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020b0`j\u0002`cH\u0002J\u000e\u0010~\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aJ\u001d\u0010\u0015\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007fH\u0016J\u0014\u0010\u0082\u0001\u001a\u00020\b2\t\u0010;\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J\u0007\u0010\u0083\u0001\u001a\u00020\u0010J\u0007\u0010\u0084\u0001\u001a\u00020\bJ\t\u0010\u0085\u0001\u001a\u00020\bH\u0016J\t\u0010\u0086\u0001\u001a\u00020\bH\u0016J\t\u0010\u0087\u0001\u001a\u00020\bH\u0016J'\u0010\u0088\u0001\u001a\u00020\b2\u001c\u0010|\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020b0`j\u0002`cH\u0016J\u0014\u0010\u008a\u0001\u001a\u00020\b2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\t\u0010\u008b\u0001\u001a\u00020\bH\u0014J\t\u0010\u008c\u0001\u001a\u00020\u0010H\u0016J\t\u0010\u008d\u0001\u001a\u00020\rH\u0016J\t\u0010\u008e\u0001\u001a\u00020\rH\u0016J\t\u0010\u008f\u0001\u001a\u00020]H\u0016J\t\u0010\u0090\u0001\u001a\u00020\u0010H\u0016J\u0013\u0010\u0093\u0001\u001a\u00020\b2\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001H\u0016J\u0013\u0010\u0096\u0001\u001a\u00020\b2\b\u0010\u0095\u0001\u001a\u00030\u0094\u0001H\u0016J\u0013\u0010\u0097\u0001\u001a\u00020\b2\b\u0010\u0095\u0001\u001a\u00030\u0094\u0001H\u0016R\u001a\u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009d\u0001R\u001c\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010\u009d\u0001R\u0017\u0010 \u0001\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0019\u0010¢\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0019\u0010¤\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u0019\u0010.\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b.\u0010¦\u0001R\u0019\u0010§\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010£\u0001R\u0019\u0010¨\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010£\u0001R\u0019\u0010©\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010¥\u0001R\u0019\u0010ª\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010£\u0001R\u0019\u0010«\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010£\u0001R\u001e\u0010\u00ad\u0001\u001a\t\u0012\u0004\u0012\u00020#0¬\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u0019\u0010¯\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010£\u0001R\u0019\u0010°\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010¥\u0001R\u0019\u0010±\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010¥\u0001R7\u0010´\u0001\u001a \u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160²\u0001j\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016`³\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R+\u0010¸\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0094\u00010¶\u0001j\n\u0012\u0005\u0012\u00030\u0094\u0001`·\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0019\u0010º\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u0019\u0010(\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b(\u0010¼\u0001R\u0019\u0010½\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010»\u0001R*\u0010¿\u0001\u001a\u0015\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C0¾\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u0018\u0010Â\u0001\u001a\u00030Á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001d\u0010Å\u0001\u001a\u00030Ä\u00018\u0006¢\u0006\u0010\n\u0006\bÅ\u0001\u0010Æ\u0001\u001a\u0006\bÇ\u0001\u0010È\u0001R\u0017\u0010É\u0001\u001a\u00020\u00108BX\u0082\u0004¢\u0006\b\u001a\u0006\bÉ\u0001\u0010Ê\u0001R\u0019\u0010Í\u0001\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\b\u001a\u0006\bË\u0001\u0010Ì\u0001¨\u0006Ò\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/vm/KtvSingChallengeViewModel;", "Landroidx/lifecycle/ViewModel;", "Lvlc/l;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/c;", "model", "", "registerKtvCoreListenerAndQueryStatus", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "getCurrentSingStatus", "initData", "", "scene", "onSubSceneChange", "", "isVideoMultiLinkScene", "isKtvComponentOpened", "logChallengeWatchIfNeed", "logChallengeWatchDurationIfNeed", "openChallenge", "", "source", "getKtvChallengeSettingPanelData", "queryCurrentRoomChallengeStatus", "Lme2/b;", "order", "Lkotlin/Function0;", "action", "singingChallengeConfigChanged", "open", "onChallengeStateChange", "Lcom/bytedance/android/live/ktv/common/model/bean/ChallengeChangeType;", "changeType", "", "score", "duration", "switchStatus", "fromPage", "openSource", "challengeType", "isAuto", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/CloseChallengeType;", "closeChallengeType", "successAction", "currentScore", "reportChallengeMidiResult", "enable", "enableAudienceSing", "target", "challengeStatus", "trySaveLocalConfig", "(Ljava/lang/Long;Ljava/lang/Long;IZ)V", "transSourceToPlayMode", "checkAutoOpen", "checkAndStartKtvChallengeBySwitchScene", "canAutoOpenChallenge", "Lcom/bytedance/android/livesdk/message/model/KTVChallengeStatusMessage;", "message", "onStatusMessage", "oldTargetDuration", "oldTargetScore", "applyNewConfigWhenMessageStartIfNeed", "Lcom/bytedance/android/live/core/utils/StateMachine$c;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/f;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/c;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/e;", "transition", "onChallengeStatusChange", "challengePrepare", "challengeSuccess", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "needShowProgressTips", "needSkipSong", "challengeFailure", "checkCountdown", "challengeEnd", "skipCurrentSong", "resultType", "onChallengeResultChanged", "handleChallengeResultChange", "config", "countDownSecond", "start", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "music", "supportMidiChallenge", "isMidiChallengeType", "notifyServerToStart", "startCountDown", "challengeClose", "Lme2/a;", "getConfig", "transChallengeStatusWithSingState", "Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/ValidLyricsStateTransition;", "onSingPreparing", "confirmChallengeClosed", "onSinging", "saveSelectedScoreAndDuration", "isCurrentUserIsSinger", "success", "logSuccessOrFailure", "getToastContentWhenOpenChallenge", "isAudienceSingEnable", "isAudioKtv", "isSinging", "getUserType", "challengeUid", "getChallengeUserType", "Lcom/bytedance/android/livesdk/model/KtvChallengeProperty;", "kotlin.jvm.PlatformType", "ktvChallengeLocalConfig", "clearMidiScoreInfo", "notifyChallengeStatusChanged", "notifyChallengeResultChanged", "currentValue", "notifyChallengeProgressChanged", "time", "notifyChallengeCountDownChanged", "valid", "notifyKtvStateChange", "prepareVideoktvChallenge", "Landroid/content/Context;", "context", "Ltlc/d;", "onMessage", "isChallengeOpen", "stopCountDown", "onComponentClose", "checkAutoOpenChallenge", "openGiftDialog", "onSingIdle", "t", "onChanged", "onCleared", "isKtvChallengeOpen", "challengeTargetValue", "currentScoreValue", "getChallengeConfig", "needHideMidi", "Lcom/bytedance/android/live/ktv/common/midi/k;", "scoreInfo", "onMidiScoreChanged", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/b;", "listener", "addKtvChallengeStatusChangedListener", "removeKtvChallengeStatusChangedListener", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDispose", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/Disposable;", "countDownDisposable", "Lio/reactivex/disposables/Disposable;", "resultIntervalDisposable", "challengingDisposable", "challengeConfig", "Lme2/a;", "currentSongIsChallenging", "Z", "pendingChallengeId", "J", "Ljava/lang/Long;", "isChallengeSuccess", "isChallengeHasBeenStart", "currentCountDownTime", "isChallenging", "hasCheckAutoOpen", "Landroid/util/LongSparseArray;", "pendingChallengeScore", "Landroid/util/LongSparseArray;", "openingChallengeByFastStart", "recordStartTime", "playModeWatchRecordStartTime", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "challengeGiftReportParam", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "challengeStatusListenerList", "Ljava/util/ArrayList;", "curSentenceIndex", "I", "Ljava/lang/String;", "currentChallengeResultType", "Lcom/bytedance/android/live/core/utils/StateMachine;", "statusMachine", "Lcom/bytedance/android/live/core/utils/StateMachine;", "com/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/vm/KtvSingChallengeViewModel$l", "mCoreListener", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/vm/KtvSingChallengeViewModel$l;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "isAnchor", "()Z", "getMCoreViewModel", "()Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/c;", "mCoreViewModel", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvSingChallengeViewModel extends ViewModel implements vlc.l, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a, Observer<KVData> {
    public static final int CHALLENGE_END = 5;
    public static final int CHALLENGE_FAILURE = 3;
    public static final int CHALLENGE_ONGOING = 4;
    public static final int CHALLENGE_ONGOING_SHOW = 6;
    public static final long CHALLENGE_ON_GOING_INTERVAL = 8000;
    public static final long CHALLENGE_RESULT_SHOW_DURATION = 3000;
    public static final int CHALLENGE_START = 1;
    public static final int CHALLENGE_SUCCESS = 2;
    public static final b Companion = null;
    public static final long DEFAULT_DURATION = 90;
    public static final String TAG = "KtvSingChallengeViewModel";
    private final me2.a challengeConfig;
    private HashMap<String, String> challengeGiftReportParam;
    private final ArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b> challengeStatusListenerList;
    private Disposable challengingDisposable;
    private CompositeDisposable compositeDispose;
    private Disposable countDownDisposable;
    private int curSentenceIndex;
    private int currentChallengeResultType;
    private long currentCountDownTime;
    private Long currentScore;
    private boolean currentSongIsChallenging;
    private final DataCenter dataCenter;
    private boolean hasCheckAutoOpen;
    private boolean isChallengeHasBeenStart;
    private boolean isChallengeSuccess;
    private boolean isChallenging;
    private final l mCoreListener;
    private String openSource;
    private boolean openingChallengeByFastStart;
    private long pendingChallengeId;
    private final LongSparseArray<Long> pendingChallengeScore;
    private long playModeWatchRecordStartTime;
    private long recordStartTime;
    private Disposable resultIntervalDisposable;
    private final StateMachine<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e> statusMachine;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ KtvSingChallengeViewModel a;

        public a(KtvSingChallengeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r3 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) sh6.c.b((sh6.b) r2);
            if (r3 == null) goto L6;
            KtvSingChallengeViewModel.access$registerKtvCoreListenerAndQueryStatus(this.a, r3);
            return;
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvSingChallengeViewModel a;
        public final /* synthetic */ boolean b;

        public c(KtvSingChallengeViewModel r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            if (KtvSingChallengeViewModel.access$isAnchor$p(this.a) == true) goto L5;
        L7:
            KtvSingChallengeViewModel.access$transChallengeStatusWithSingState(this.a);
            return;
        L5:
            if (this.b == false) goto L7;
            KtvSingChallengeViewModel.access$skipCurrentSong(this.a);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ long b;

        public d(boolean r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.n<Boolean> r1 = r0.isAudienceEnableSing();
            if (r1 == null) goto L7;
            r1.setValue(Boolean.valueOf(this.a));
        L7:
            mb0.c.a.b(pd2.d.n, LinkMonitorData.APIUpdateKtvComponentSetting, System.currentTimeMillis() - this.b, ((ExtraResponse) r8).logId);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ long a;

        public e(long r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            ALogger.e(KtvSingChallengeViewModel.TAG, "updateAudienceSingEnableSetting fail, logId=" + ke2.a.c(r8));
            mb0.c.a.a(pd2.d.n, LinkMonitorData.APIUpdateKtvComponentSetting, System.currentTimeMillis() - this.a, r8);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ KtvSingChallengeViewModel a;
        public final /* synthetic */ long b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;

        public f(KtvSingChallengeViewModel r1, long r2, boolean r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            c0 r0 = (c0) ((ExtraResponse) r9).data;
            KtvContext.Companion.getClass();
            KtvContext r1 = KtvContext.a.g();
            if (r1 == null) goto L7;
            com.bytedance.live.datacontext.n<c0> r2 = r1.getKtvChallengeSettingPanelData();
            if (r2 == null) goto L7;
            r2.setValue(r0);
        L7:
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiGetSingingChallengeOption, System.currentTimeMillis() - this.b, ((ExtraResponse) r9).logId);
            if (this.c == false) goto L14;
            Long r10 = r0.d();
            Long r3 = r0.c();
            if (r10 == null) goto L15;
            if (r3 == null) goto L16;
            r3.longValue();
            r10.longValue();
            this.a.openChallenge(this.d, null);
            return;
        L16:
            return;
        L15:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ long a;

        public g(long r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            pd2.d r0 = pd2.d.n;
            LinkMonitorData r1 = LinkMonitorData.ApiGetSingingChallengeOption;
            long r2 = System.currentTimeMillis() - this.a;
            mb0.c.a.a(r0, r1, r2, (Throwable) r7);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ KtvSingChallengeViewModel a;

        public h(KtvSingChallengeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            if (KtvSingChallengeViewModel.access$getCurrentChallengeResultType$p(this.a) != 4) goto L6;
            KtvSingChallengeViewModel.access$onChallengeResultChanged(this.a, 6);
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ KtvSingChallengeViewModel a;

        public i(KtvSingChallengeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 != null) goto L6;
            return;
        L6:
            if (r3.intValue() != 6) goto L9;
            KtvSingChallengeViewModel.access$logChallengeWatchIfNeed(this.a);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel$initData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lme2/b;", "p1", "", "invoke", "(Lme2/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<me2.b, Unit> {
        public AnonymousClass1(KtvSingChallengeViewModel r8) {
            super(1, r8, KtvSingChallengeViewModel.class, "prepareVideoktvChallenge", "prepareVideoktvChallenge(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/model/OpenVideoChallengeOrder;)V", 0);
        }

        public final void invoke(me2.b r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ((KtvSingChallengeViewModel) ((CallableReference) this).receiver).prepareVideoktvChallenge(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((me2.b) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ KtvSingChallengeViewModel a;

        public j(KtvSingChallengeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r2;
            if (r3.d == true) goto L6;
            KtvSingChallengeViewModel.access$onSubSceneChange(this.a, r3.a);
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ KtvSingChallengeViewModel a;

        public k(KtvSingChallengeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            KtvSingChallengeViewModel.access$onSubSceneChange(this.a, ((com.bytedance.android.livesdk.chatroom.viewmodel.j) r2).a);
        }
    }

    public static final class l extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b {
        public final /* synthetic */ KtvSingChallengeViewModel a;

        public l(KtvSingChallengeViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r3) {
            Intrinsics.checkNotNullParameter(r3, "valid");
            ALogger.i(KtvSingChallengeViewModel.TAG, "onKtvStateChange, state: " + ((KtvRoomLyricsStateMachineConfig.d) r3.c) + ", event: " + ((KtvRoomLyricsStateMachineConfig.a) r3.b));
            KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r3.c;
            if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L6;
            KtvSingChallengeViewModel.access$onSingPreparing(this.a, r3);
        L11:
            KtvSingChallengeViewModel.access$notifyKtvStateChange(this.a, r3);
            return;
        L6:
            if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L9;
            KtvSingChallengeViewModel.access$onSinging(this.a, r3);
            goto L11
        L9:
            if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L11;
            this.a.onSingIdle(r3);
            goto L11
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ long a;

        public m(long r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiStartSingingChallengeNotice, System.currentTimeMillis() - this.a, ((ExtraResponse) ((com.bytedance.android.live.network.response.a) r7)).logId);
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ long a;

        public n(long r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            pd2.d r0 = pd2.d.n;
            LinkMonitorData r1 = LinkMonitorData.ApiStartSingingChallengeNotice;
            long r2 = System.currentTimeMillis() - this.a;
            mb0.c.a.a(r0, r1, r2, (Throwable) r7);
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ KtvSingChallengeViewModel a;
        public final /* synthetic */ int b;

        public o(KtvSingChallengeViewModel r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            KtvSingChallengeViewModel.access$handleChallengeResultChange(this.a, this.b);
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ KtvSingChallengeViewModel a;
        public final /* synthetic */ long b;

        public p(KtvSingChallengeViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiGetSingingChallengeStatus, System.currentTimeMillis() - this.b, ((ExtraResponse) r10).logId);
            ALogger.i(KtvSingChallengeViewModel.TAG, "getSingingChallengeStatus success，switch:" + ((int) ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).e()));
            KtvSingChallengeViewModel.access$getChallengeConfig$p(this.a).b = (int) ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).e();
            me2.a r0 = KtvSingChallengeViewModel.access$getChallengeConfig$p(this.a);
            Integer r2 = ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).b();
            if (r2 == null) goto L5;
            int r3 = r2.intValue();
        L6:
            r0.f = r3;
            KtvSingChallengeViewModel.access$getChallengeConfig$p(this.a).c = ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).g();
            KtvSingChallengeViewModel r1 = this.a;
            KtvSingChallengeViewModel.access$notifyChallengeStatusChanged(r1, KtvSingChallengeViewModel.access$getChallengeConfig$p(r1).f);
            boolean r4 = true;
            if (KtvSingChallengeViewModel.access$getChallengeConfig$p(this.a).b != 1) goto L16;
            KtvSingChallengeViewModel.access$config(this.a, ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).g(), ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).f());
            com.bytedance.android.livesdk.chatroom.u r5 = o3.d();
            if (r5 == null) goto L15;
            com.bytedance.live.datacontext.j r6 = r5.J();
            if (r6 == null) goto L15;
            LivePlayModeLogContext r7 = (LivePlayModeLogContext) r6.getValue();
            if (r7 == null) goto L15;
            r7.addPlayMode(6);
        L15:
            KtvSingChallengeViewModel.access$logChallengeWatchIfNeed(this.a);
        L25:
            if (((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).h() == false) goto L28;
            KtvSingChallengeViewModel.access$getChallengeConfig$p(this.a).a = ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).a();
        L28:
            if (((int) ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).e()) != 1) goto L55;
            me2.a r8 = KtvSingChallengeViewModel.access$getChallengeConfig$p(this.a);
            ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).getClass();
            r8.getClass();
            me2.a r11 = KtvSingChallengeViewModel.access$getChallengeConfig$p(this.a);
            ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).getClass();
            r11.getClass();
            if (((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).h() == false) goto L54;
            KtvSingChallengeViewModel.access$setCurrentSongIsChallenging$p(this.a, true);
            KtvSingChallengeViewModel.access$setPendingChallengeId$p(this.a, ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).a());
            if (KtvSingChallengeViewModel.access$isAnchor$p(this.a) == false) goto L34;
            long r12 = KtvSingChallengeViewModel.access$getChallengeConfig$p(this.a).d;
        L35:
            KtvSingChallengeViewModel.access$getChallengeConfig$p(this.a).e = r12;
            KtvSingChallengeViewModel.access$setChallenging$p(this.a, true);
            KtvRoomLyricsStateMachineConfig.d r13 = KtvSingChallengeViewModel.access$getCurrentSingStatus(this.a);
            ALogger.i(KtvSingChallengeViewModel.TAG, "getStatusSuccess, currentSingingState=" + r13 + ", challengeState=" + ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f) KtvSingChallengeViewModel.access$getStatusMachine$p(this.a).b()) + ", isInSingingChallenge=true, currentSingingState=" + ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f) KtvSingChallengeViewModel.access$getStatusMachine$p(this.a).b()));
            if ((r13 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L43;
            if (KtvSingChallengeViewModel.access$isAnchor$p(this.a) == false) goto L40;
            long r14 = 0;
        L41:
            KtvSingChallengeViewModel.access$getStatusMachine$p(this.a).d(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.e(r14, r12), null);
        L64:
            KtvSingChallengeViewModel r15 = this.a;
            if (((int) ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).e()) == 1) goto L68;
            r4 = false;
        L68:
            KtvSingChallengeViewModel.access$onChallengeStateChange(r15, r4);
            int r16 = com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.d.a;
            com.bytedance.android.live.ktv.common.model.api.x r17 = (com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data;
            Intrinsics.checkNotNullParameter(r17, "response");
            ALogger.i("KtvChallengeLogMonitor", "getSingingChallengeStatus: response=" + r17);
            return;
        L40:
            r14 = ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).d();
            goto L41
        L43:
            if ((r13 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L49;
            if (KtvSingChallengeViewModel.access$isAnchor$p(this.a) == true) goto L47;
            KtvSingChallengeViewModel.access$getPendingChallengeScore$p(this.a).put(((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).a(), Long.valueOf(((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).d()));
        L47:
            KtvSingChallengeViewModel.access$getStatusMachine$p(this.a).d(com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.d.b, null);
            goto L64
        L49:
            if ((r13 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L52;
            if (r13 != null) goto L64;
        L52:
            if (KtvSingChallengeViewModel.access$isAnchor$p(this.a) == true) goto L64;
            KtvSingChallengeViewModel.access$getPendingChallengeScore$p(this.a).put(((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).a(), Long.valueOf(((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).d()));
            goto L64
        L34:
            r12 = ((com.bytedance.android.live.ktv.common.model.api.x) ((ExtraResponse) r10).data).c();
            goto L35
        L54:
            ALogger.i(KtvSingChallengeViewModel.TAG, "getStatusSuccess, isInSingingChallenge=false, Event.OnEnd, currentStatus=" + ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f) KtvSingChallengeViewModel.access$getStatusMachine$p(this.a).b()));
            KtvSingChallengeViewModel.access$getStatusMachine$p(this.a).d(com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.b.b, null);
            goto L64
        L55:
            com.bytedance.android.livesdk.chatroom.o r18 = o3.f();
            if (r18 == null) goto L60;
            com.bytedance.live.datacontext.j r19 = r18.s2();
            if (r19 == null) goto L60;
            z0 r20 = (z0) r19.getValue();
        L60:
            boolean r21 = KtvSingChallengeViewModel.access$isAudioKtv(this.a);
            if (KtvSingChallengeViewModel.access$isAnchor$p(this.a) == false) goto L64;
            if (r21 == false) goto L64;
            KtvSingChallengeViewModel.access$checkAutoOpen(this.a);
            goto L64
        L16:
            com.bytedance.android.livesdk.chatroom.u r22 = o3.d();
            if (r22 == null) goto L23;
            com.bytedance.live.datacontext.j r23 = r22.J();
            if (r23 == null) goto L23;
            LivePlayModeLogContext r24 = (LivePlayModeLogContext) r23.getValue();
            if (r24 == null) goto L23;
            r24.removePlayMode(6);
        L23:
            KtvSingChallengeViewModel.access$logChallengeWatchDurationIfNeed(this.a);
            goto L25
        L5:
            r3 = KtvChallengeType.KTV_CHALLENGE_TYPE_UNKNOWN.getValue();
            goto L6
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ long a;

        public q(long r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            pd2.d r0 = pd2.d.n;
            LinkMonitorData r1 = LinkMonitorData.ApiGetSingingChallengeStatus;
            long r2 = System.currentTimeMillis() - this.a;
            mb0.c.a.a(r0, r1, r2, (Throwable) r7);
        }
    }

    public static final class r<T> implements Consumer {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            com.bytedance.android.live.network.response.a r2 = (com.bytedance.android.live.network.response.a) r1;
        }
    }

    public static final class s<T> implements Consumer {
        public static final s a = null;

        static {
            a = new s();
        }

        public s() {
        }

        public final void accept(Object r3) {
            ALogger.e(KtvSingChallengeViewModel.TAG, "reportChallengeMidiResult, exception: " + ((Throwable) r3).getMessage());
        }
    }

    public static final class u<T> implements Consumer {
        public final /* synthetic */ KtvSingChallengeViewModel a;
        public final /* synthetic */ long b;
        public final /* synthetic */ ChallengeChangeType c;
        public final /* synthetic */ long d;
        public final /* synthetic */ int e;
        public final /* synthetic */ long f;
        public final /* synthetic */ IRoom g;
        public final /* synthetic */ long h;
        public final /* synthetic */ String i;
        public final /* synthetic */ Function0 j;
        public final /* synthetic */ CloseChallengeType k;
        public final /* synthetic */ String l;
        public final /* synthetic */ boolean m;

        public u(KtvSingChallengeViewModel r4, long r5, ChallengeChangeType r7, long r8, int r10, long r11, IRoom r13, long r14, String r16, Function0 r17, CloseChallengeType r18, String r19, boolean r20) {
            this.a = r4;
            this.b = r5;
            this.c = r7;
            this.d = r8;
            this.e = r10;
            this.f = r11;
            this.g = r13;
            this.h = r14;
            this.i = r16;
            this.j = r17;
            this.k = r18;
            this.l = r19;
            this.m = r20;
        }

        public final void accept(Object r30) {
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiSingingChallengeConfigChangedNotice, System.currentTimeMillis() - this.b, ((ExtraResponse) ((com.bytedance.android.live.network.response.a) r30)).logId);
            if (this.c == ChallengeChangeType.SWITCH_TURN_OFF) goto L5;
            KtvSingChallengeViewModel.access$getChallengeConfig$p(this.a).d = this.d;
        L5:
            KtvSingChallengeViewModel.access$getChallengeConfig$p(this.a).f = this.e;
            long r1 = this.f;
            if (r1 != SwitchStatus.OPEN.getValue()) goto L85;
            Long r2 = KtvLoggerHelper.a;
            String r3 = this.g.getOwnerUserIdString();
            long r4 = this.g.getRoomId();
            String r5 = com.bytedance.android.live.ktv.common.util.j.c();
            long r13 = this.d;
            long r6 = this.h;
            String r15 = this.i;
            int r16 = this.e;
            Intrinsics.checkNotNullParameter(r3, "anchorId");
            Intrinsics.checkNotNullParameter(r5, "functionType");
            HashMap r10 = new HashMap();
            r10.put("anchor_id", r3.toString());
            r10.put("room_id", String.valueOf(r4));
            r10.put("function_type", KtvLoggerHelper.H(r5));
            r10.put("live_type", KtvLoggerHelper.F());
            r10.put("play_time", String.valueOf(r13));
            r10.put("goal", String.valueOf(r6));
            r10.put("goal_type", KtvLoggerHelper.C(Integer.valueOf(r16)));
            if (r15 == null) goto L10;
            r10.put("open_source", r15);
        L10:
            KtvContext.Companion.getClass();
            KtvContext r7 = KtvContext.a.g();
            String r8 = null;
            if (r7 == null) goto L29;
            com.bytedance.live.datacontext.n<c0> r9 = r7.getKtvChallengeSettingPanelData();
            if (r9 == null) goto L29;
            c0 r11 = (c0) r9.getValue();
            if (r11 == null) goto L29;
            List r12 = r11.e();
            if (r12 == null) goto L29;
            Iterator<T> r14 = r12.iterator();
        L20:
            if (r14.hasNext() == false) goto L27;
            T r17 = r14.next();
            if (((Number) r17).longValue() != r6) goto L24;
            boolean r18 = true;
        L25:
            if (r18 == false) goto L20;
        L28:
            Long r19 = r17;
        L30:
            if (r19 != null) goto L32;
            String r20 = "1";
        L33:
            r10.put("is_diy_goal", r20);
            com.bytedance.android.livesdk.log.filter.o r21 = j0.l().c(am2.x.class);
            if ((r21 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L43;
            Map<String, String> r22 = ((com.bytedance.android.livesdk.log.filter.t) r21).getMap();
            if (r22 == null) goto L43;
            String r23 = r22.get("enter_from_merge");
            if (r23 == null) goto L40;
            r10.put("enter_from_merge", r23);
        L40:
            Object r24 = "enter_method";
            String r25 = r22.get(r24);
            if (r25 == null) goto L44;
            r10.put(r24, r25);
        L44:
            KtvLoggerHelper.o0(r10);
            j0.l().sendLog("livesdk_ktv_sing_challenge_open_success", r10, new Object[]{am2.x.class});
            KtvSingChallengeViewModel.access$setOpenSource$p(this.a, this.i);
            int r26 = jc1.k.n(IInteractService.class).getCurrentScene();
            Long r27 = KtvLoggerHelper.a;
            Integer r28 = KtvLoggerHelper.y();
            KtvSingChallengeViewModel.access$setRecordStartTime$p(this.a, System.currentTimeMillis());
            String r29 = KtvLoggerHelper.p0(6);
            String r31 = this.g.getOwnerUserIdString().toString();
            String r110 = String.valueOf(this.g.getRoomId());
            String r32 = KtvLoggerHelper.D(Integer.valueOf(r26), r28);
            String r33 = KtvLoggerHelper.j0(r28);
            String r111 = KtvSingChallengeViewModel.access$transSourceToPlayMode(this.a, this.i);
            Intrinsics.checkNotNullParameter(r29, "toPlayMode");
            Intrinsics.checkNotNullParameter(r31, "anchorId");
            Intrinsics.checkNotNullParameter(r110, "roomId");
            HashMap r112 = new HashMap();
            r112.put("anchor_id", r31);
            r112.put("room_id", r110);
            r112.put("live_type", com.bytedance.android.live.ktv.common.util.j.d());
            if (r32 == null) goto L47;
            r112.put("function_type", r32);
            r112.put("function_type2", r32);
        L48:
            if (r33 == null) goto L50;
            r112.put("layout_type", r33);
        L50:
            com.bytedance.android.livesdk.chatroom.o r34 = com.bytedance.android.live.liveinteract.api.utils.m.i();
            if (r34 == null) goto L55;
            DataCenter r35 = r34.getDataCenter();
            if (r35 == null) goto L55;
            Object r113 = "";
            r8 = (String) r35.get("cmd_func_type_when_open_ktv_by_schema", r113);
        L56:
            if (r8 != null) goto L58;
        L61:
            boolean r36 = true;
        L62:
            if (r36 == true) goto L69;
            com.bytedance.android.livesdk.chatroom.o r37 = com.bytedance.android.live.liveinteract.api.utils.m.i();
            if (r37 == null) goto L68;
            DataCenter r38 = r37.getDataCenter();
            if (r38 == null) goto L68;
            r38.put("cmd_func_type_when_open_ktv_by_schema", r113);
        L68:
            r112.put("function_type", r8);
        L69:
            r112.put("enter_from_mode", "null");
            r112.put("play_mode", r29);
            if (r111 == null) goto L72;
            r112.put("source", r111);
        L72:
            KtvLoggerHelper.o0(r112);
            com.bytedance.android.livesdk.log.filter.o r39 = j0.l().c(am2.x.class);
            if ((r39 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L81;
            Map<String, String> r40 = ((com.bytedance.android.livesdk.log.filter.t) r39).getMap();
            if (r40 == null) goto L81;
            String r41 = r40.get(r24);
            if (r41 == null) goto L81;
            if (Intrinsics.areEqual(r41, "linkmic_ktv_feed") == false) goto L81;
            r112.put("source", "ksong_convenient");
            r112.put("ksong_element_source：string", "ksong_convenient");
        L81:
            j0.l().sendLog("anchor_playmode_open_success", r112, new Object[]{IRoom.class, am2.x.class});
            pd2.d.n.getClass();
            Intrinsics.checkNotNullParameter("ktv_challenge", "playMode");
            JSONObject r42 = new JSONObject();
            Intrinsics.checkNotNullParameter(r42, "$this$putPlayMode");
            Intrinsics.checkNotNullParameter("ktv_challenge", "playMode");
            pd2.d.w(LinkMonitorData.BusinessOpenPlayMode, r42.put("play_mode", "ktv_challenge"));
            Function0 r43 = this.j;
            if (r43 == null) goto L104;
            Unit r44 = (Unit) r43.invoke();
        L104:
            u<T> r45 = this;
        L106:
            if (r45.m == true) goto L118;
            KtvSingChallengeViewModel r0 = r45.a;
            Long r46 = Long.valueOf(r45.d);
            Long r47 = Long.valueOf(r45.h);
            int r48 = r45.e;
            if (r45.f != SwitchStatus.OPEN.getValue()) goto L110;
            boolean r49 = true;
        L111:
            KtvSingChallengeViewModel.access$trySaveLocalConfig(r0, r46, r47, r48, r49);
            return;
        L110:
            r49 = false;
            goto L111
        L118:
            return;
        L58:
            if (r8.length() == 0) goto L61;
            r36 = false;
        L55:
            r113 = "";
            goto L56
        L47:
            r112.put("function_type", KtvLoggerHelper.H(com.bytedance.android.live.ktv.common.util.j.c()));
        L43:
            r24 = "enter_method";
            goto L44
        L32:
            r20 = BDLocationException.ERROR_TIMEOUT;
            goto L33
        L24:
            r18 = false;
            goto L25
        L27:
            r17 = (T) null;
        L29:
            r19 = null;
            goto L30
        L85:
            if (r1 != SwitchStatus.CLOSE.getValue()) goto L104;
            KtvSingChallengeViewModel.access$getChallengeConfig$p(this.a).b = (int) this.f;
            xs2.b.a().post(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.a(this.k, true));
            KtvSingChallengeViewModel.access$notifyChallengeStatusChanged(this.a, this.e);
            Long r50 = KtvLoggerHelper.a;
            String r51 = com.bytedance.android.live.ktv.common.util.j.d();
            String r52 = this.g.getOwnerUserIdString();
            long r114 = this.g.getRoomId();
            String r53 = com.bytedance.android.live.ktv.common.util.j.c();
            long r54 = this.d;
            long r55 = this.h;
            String r56 = this.l;
            String r115 = KtvSingChallengeViewModel.access$getOpenSource$p(this.a);
            int r116 = this.e;
            Intrinsics.checkNotNullParameter(r51, "liveType");
            Intrinsics.checkNotNullParameter(r52, "anchorId");
            Intrinsics.checkNotNullParameter(r53, "functionType");
            HashMap r57 = new HashMap();
            r57.put("anchor_id", r52.toString());
            r57.put("room_id", String.valueOf(r114));
            KtvLoggerHelper.A(r57);
            r57.put("live_type", KtvLoggerHelper.F());
            r57.put("play_time", String.valueOf(r54));
            r57.put("goal", String.valueOf(r55));
            r57.put("goal_type", KtvLoggerHelper.C(Integer.valueOf(r116)));
            if (r56 != null) goto L89;
            String r117 = "";
        L90:
            r57.put("from_page", r117);
            if (r115 == null) goto L93;
            r57.put("open_source", r115);
        L93:
            com.bytedance.android.livesdk.log.filter.o r58 = j0.l().c(am2.x.class);
            if ((r58 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L103;
            Map<String, String> r59 = ((com.bytedance.android.livesdk.log.filter.t) r58).getMap();
            if (r59 == null) goto L103;
            String r60 = r59.get("enter_from_merge");
            if (r60 == null) goto L100;
            r57.put("enter_from_merge", r60);
        L100:
            String r61 = r59.get("enter_method");
            if (r61 == null) goto L103;
            r57.put("enter_method", r61);
            r57.put("open_source", r61);
        L103:
            KtvLoggerHelper.o0(r57);
            j0.l().sendLog("livesdk_ktv_sing_challenge_over", r57, new Object[]{am2.x.class});
            r45 = this;
            long r62 = (long) ((System.currentTimeMillis() - KtvSingChallengeViewModel.access$getRecordStartTime$p(r45.a)) / 1000.0f);
            int r63 = jc1.k.n(IInteractService.class).getCurrentScene();
            Integer r64 = KtvLoggerHelper.y();
            KtvLoggerHelper.N(KtvLoggerHelper.p0(6), r45.g.getOwnerUserIdString().toString(), String.valueOf(r45.g.getRoomId()), KtvLoggerHelper.D(Integer.valueOf(r63), r64), KtvLoggerHelper.j0(r64), KtvSingChallengeViewModel.access$transSourceToPlayMode(r45.a, r45.i), Long.valueOf(r62));
            Intrinsics.checkNotNullParameter("ktv_challenge", "playMode");
            JSONObject r65 = new JSONObject();
            Intrinsics.checkNotNullParameter(r65, "$this$putPlayMode");
            Intrinsics.checkNotNullParameter("ktv_challenge", "playMode");
            JSONObject r66 = r65.put("play_mode", "ktv_challenge");
            Intrinsics.checkNotNullParameter(r66, "$this$putDuration");
            pd2.d.w(LinkMonitorData.BusinessClosePlayMode, r66.put("duration", r62));
            goto L106
        L89:
            r117 = r56;
            goto L90
        }
    }

    public static final class v<T> implements Consumer {
        public final /* synthetic */ CloseChallengeType a;
        public final /* synthetic */ long b;

        public v(CloseChallengeType r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            CustomApiServerException r8 = (Throwable) r7;
            xs2.b.a().post(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.a(this.a, false));
            if ((r8 instanceof CustomApiServerException) == false) goto L8;
            String r0 = r8.getPrompt();
            if (r0 != null) goto L7;
            r0 = s1.B(2131918513);
        L7:
            f2.c(r0, 0);
        L9:
            mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiSingingChallengeConfigChangedNotice, System.currentTimeMillis() - this.b, r8);
            return;
        L8:
            f2.c(s1.B(2131918513), 0);
            goto L9
        }
    }

    public static final class w<T, R> implements Function {
        public final /* synthetic */ long a;

        public w(long r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Long r6 = (Long) r5;
            Intrinsics.checkNotNullParameter(r6, "t");
            return Long.valueOf(this.a - r6.longValue());
        }
    }

    public static final class x<T> implements Consumer {
        public final /* synthetic */ KtvSingChallengeViewModel a;

        public x(KtvSingChallengeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            KtvSingChallengeViewModel.access$notifyChallengeCountDownChanged(this.a, r5.longValue());
            KtvSingChallengeViewModel.access$setCurrentCountDownTime$p(this.a, r5.longValue());
        }
    }

    static {
        Companion = new b();
    }

    private final void clearMidiScoreInfo() {
        this.curSentenceIndex = -1;
    }

    private final boolean isVideoMultiLinkScene(int r2) {
        if (r2 != 5) goto L5;
    L12:
        return true;
    L5:
        if (r2 == 8) goto L12;
        if (r2 == 12) goto L12;
        if (r2 == 16) goto L12;
        return false;
    }

    private final void challengeClose() {
        ALogger.i(TAG, "challengeClose");
        Disposable r0 = this.countDownDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.resultIntervalDisposable;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        Disposable r2 = this.challengingDisposable;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.isChallenging = false;
        this.currentSongIsChallenging = false;
        this.pendingChallengeScore.clear();
        this.isChallengeHasBeenStart = false;
        this.challengeGiftReportParam.put("is_sing_challenge", BDLocationException.ERROR_TIMEOUT);
        KtvContext.Companion.getClass();
        KtvContext r3 = KtvContext.a.g();
        if (r3 == null) goto L16;
        HashMap<String, String> r4 = r3.getGiftReportParam();
        if (r4 == null) goto L16;
        r4.putAll(this.challengeGiftReportParam);
    L16:
        this.hasCheckAutoOpen = false;
    }

    private final void challengeEnd() {
        ALogger.i(TAG, "challengeEnd");
        if (this.isChallengeHasBeenStart == false) goto L5;
        this.challengeConfig.a = 0;
        this.pendingChallengeId = 0;
        this.isChallengeHasBeenStart = false;
    L5:
        Disposable r0 = this.countDownDisposable;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        Disposable r1 = this.resultIntervalDisposable;
        if (r1 == null) goto L11;
        r1.dispose();
    L11:
        Disposable r2 = this.challengingDisposable;
        if (r2 == null) goto L14;
        r2.dispose();
    L14:
        this.currentScore = 0L;
        confirmChallengeClosed();
    }

    private final void challengePrepare() {
        StringBuilder r0 = new StringBuilder("challengePrepare: isOpen=");
        if (this.challengeConfig.b != 1) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(", songStatus=");
        r0.append(getCurrentSingStatus());
        ALogger.i(TAG, r0.toString());
        this.isChallenging = true;
        checkCountdown();
        this.currentScore = 0L;
        confirmChallengeClosed();
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final void challengeSuccess() {
        ALogger.i(TAG, "challengeSuccess: songStatus=" + getCurrentSingStatus());
        this.isChallengeSuccess = true;
        stopCountDown();
        logSuccessOrFailure$default(this, 1, null, 2, null);
    }

    private final void checkCountdown() {
        ALogger.i(TAG, "checkCountdown:" + this.currentCountDownTime);
        if (this.currentCountDownTime == 0) goto L9;
        Disposable r0 = this.countDownDisposable;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        this.currentCountDownTime = 0;
        notifyChallengeCountDownChanged(this.challengeConfig.d);
        return;
    }

    private final com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c getMCoreViewModel() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r1 = r0.getKtvCoreViewModel();
        if (r1 == null) goto L7;
        return (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r1.getValue();
    L7:
        return null;
    }

    private final String getUserType() {
        Long r0 = KtvLoggerHelper.a;
        return KtvLoggerHelper.I();
    }

    private final void initData() {
        vlc.d r0 = (vlc.d) this.dataCenter.get("data_message_manager", null);
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.KTV_CHALLENGE_CONFIG_MESSAGE.getIntType(), this);
    L5:
        if (r0 == null) goto L7;
        r0.addMessageListener(MessageType.KTV_CHALLENGE_STATUS_MESSAGE.getIntType(), this);
    L7:
        if (r0 == null) goto L9;
        r0.addMessageListener(MessageType.KTV_CHALLENGE_RANK_MESSAGE.getIntType(), this);
    L9:
        this.dataCenter.observe("cmd_anchor_broadcast_end", this);
        KtvContext.Companion.getClass();
        PublishSubject r1 = KtvContext.a.g().getPrepareChallengeEvent().onEvent();
        final AnonymousClass1 r2 = new AnonymousClass1(this);
        this.compositeDispose.add(r1.subscribe(new t(r2)));
        if (isAnchor() == false) goto L25;
        getKtvChallengeSettingPanelData$default(this, false, null, 3, null);
        com.bytedance.android.livesdk.chatroom.t r3 = o3.a();
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.n r4 = r3.a();
        if (r4 == null) goto L16;
        ArrayList r5 = (ArrayList) r4.getValue();
    L18:
        if (d0.g(r5) == false) goto L25;
        com.bytedance.android.livesdk.chatroom.t r6 = o3.a();
        if (r6 == null) goto L24;
        com.bytedance.live.datacontext.n r7 = r6.a();
        if (r7 == null) goto L24;
        r7.setValue(null);
    L24:
        this.openingChallengeByFastStart = true;
        openChallenge("convenient_page", null);
    L16:
        r5 = null;
    L25:
        com.bytedance.android.livesdk.chatroom.u r8 = o3.d();
        if (r8 == null) goto L39;
        com.bytedance.live.datacontext.j r9 = r8.J();
        if (r9 == null) goto L39;
        LivePlayModeLogContext r10 = (LivePlayModeLogContext) r9.getValue();
        if (r10 == null) goto L39;
        com.bytedance.live.datacontext.k r11 = r10.getAddPlayModeEvent();
        if (r11 == null) goto L39;
        PublishSubject r12 = r11.onEvent();
        if (r12 == null) goto L39;
        Disposable r13 = r12.subscribe(new i(this));
        if (r13 == null) goto L39;
        this.compositeDispose.add(r13);
    L39:
        if (isAnchor() == false) goto L71;
        com.bytedance.android.livesdk.chatroom.o r14 = o3.f();
        if (r14 == null) goto L59;
        com.bytedance.live.datacontext.m r15 = r14.getRoom();
        if (r15 == null) goto L59;
        IRoom r16 = (IRoom) r15.getValue();
        if (r16 == null) goto L59;
        if (r16.isLiveTypeAudio() != true) goto L59;
        com.bytedance.android.livesdk.chatroom.u r17 = o3.d();
        if (r17 == null) goto L72;
        com.bytedance.live.datacontext.j r18 = r17.s();
        if (r18 == null) goto L73;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r19 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r18.getValue();
        if (r19 == null) goto L74;
        BehaviorSubject r20 = r19.a();
        if (r20 == null) goto L75;
        Disposable r21 = r20.subscribe(new j(this));
        if (r21 == null) goto L76;
        this.compositeDispose.add(r21);
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L72:
        return;
    L59:
        com.bytedance.android.livesdk.chatroom.u r22 = o3.d();
        if (r22 == null) goto L78;
        com.bytedance.live.datacontext.j r23 = r22.getVideoTalkRoomSubScene();
        if (r23 == null) goto L79;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r24 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r23.getValue();
        if (r24 == null) goto L80;
        BehaviorSubject r25 = r24.a();
        if (r25 == null) goto L81;
        Disposable r26 = r25.subscribe(new k(this));
        if (r26 == null) goto L82;
        this.compositeDispose.add(r26);
        return;
    L82:
        return;
    L81:
        return;
    L80:
        return;
    L79:
        return;
    L78:
        return;
    }

    private final boolean isAudienceSingEnable() {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<Boolean> r1 = r0.isAudienceEnableSing();
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L9:
        return Intrinsics.areEqual(r2, Boolean.TRUE);
    L7:
        r2 = null;
        goto L9
    }

    private final boolean isCurrentUserIsSinger() {
        KtvContext.Companion.getClass();
        return KtvContext.a.g().isCurrentUserIsSinger();
    }

    private final boolean isKtvComponentOpened() {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<Integer> r1 = r0.getKtvComponentStatus();
        if (r1 == null) goto L7;
        Integer r2 = (Integer) r1.getValue();
    L8:
        if (r2 != null) goto L11;
    L13:
        return false;
    L11:
        if (r2.intValue() != 1) goto L13;
        return true;
    L7:
        r2 = null;
        goto L8
    }

    private final boolean isMidiChallengeType() {
        if (this.challengeConfig.f != KtvChallengeType.KTV_CHALLENGE_TYPE_MIDI.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    private final KtvChallengeProperty ktvChallengeLocalConfig() {
        return (KtvChallengeProperty) com.bytedance.android.livesdk.sharedpref.c.n0.getValue();
    }

    private final void notifyServerToStart() {
        ALogger.i(TAG, "notifyServerToStart");
        long r0 = System.currentTimeMillis();
        this.compositeDispose.add(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).startSingingChallenge(com.bytedance.android.live.ktv.common.util.a.c().getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(r0), new n(r0)));
    }

    private final void skipCurrentSong() {
        ALogger.i(TAG, "skipCurrentSong");
        KtvRoomLyricsStateMachineConfig.d r1 = getCurrentSingStatus();
        if (r1 == null) goto L24;
        final MusicPanel r2 = r1.b();
        if (r2 == null) goto L25;
        pd2.d.y(r2.a.getMId(), "start_cut");
        final long r6 = System.currentTimeMillis();
        com.bytedance.android.livesdk.chatroom.o r3 = o3.f();
        if (r3 == null) goto L11;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L11;
        IRoom r5 = (IRoom) r4.getValue();
    L12:
        if (r5 == null) goto L26;
        int r7 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
        com.bytedance.android.live.ktv.common.karaokestation.model.g r8 = com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a;
        long r9 = r5.getId();
        long r10 = r5.getId();
        long r12 = r2.a.getMId();
        OrderInfo r11 = r2.a.getOrderInfo();
        if (r11 == null) goto L19;
        InteractiveSongUserInfo r13 = r11.getTopUser();
        if (r13 == null) goto L19;
        String r14 = r13.getIdString();
        if (r14 == null) goto L19;
    L20:
        Disposable r15 = r8.e(r6, r9, r10, r12, r14, true, r2.a.getSongType(), KtvUtilsKt.i(r2), new KtvSingChallengeViewModel$skipCurrentSong$$inlined$let$lambda$1(r6, r2, this), new KtvSingChallengeViewModel$skipCurrentSong$$inlined$let$lambda$2(r6, r2, this));
        if (r15 == null) goto L27;
        RxUtilKt.c(r15, this.compositeDispose);
        return;
    L27:
        return;
    L19:
        r14 = "";
        goto L20
    L26:
        return;
    L11:
        r5 = null;
        goto L12
    L25:
        return;
    }

    private final void transChallengeStatusWithSingState() {
        ALogger.i(TAG, "transChallengeStatusWithSingState songState=" + getCurrentSingStatus() + ", challengeState=" + ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f) this.statusMachine.b()));
        KtvRoomLyricsStateMachineConfig.d r0 = getCurrentSingStatus();
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L6;
        this.currentSongIsChallenging = true;
        this.statusMachine.d(com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.d.b, null);
        return;
    L6:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L8;
        this.statusMachine.d(com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.b.b, null);
        return;
    L8:
        if (r0 != null) goto L13;
        this.statusMachine.d(com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.b.b, null);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a
    public int challengeTargetValue() {
        return (int) this.challengeConfig.c;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a
    public int currentScoreValue() {
        Long r0 = this.currentScore;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return (int) r0.longValue();
    }

    public final boolean isChallengeOpen() {
        if (this.challengeConfig.b == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a
    public void openGiftDialog() {
        if (this.challengeConfig.f == KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue()) goto L5;
        return;
    L5:
        KtvRoomLyricsStateMachineConfig.d r1 = getCurrentSingStatus();
        MusicPanel r2 = null;
        if (r1 == null) goto L14;
        MusicPanel r3 = r1.b();
        if (r3 == null) goto L14;
        KtvMusic r4 = r3.a;
        if (r4 == null) goto L14;
        OrderInfo r5 = r4.getOrderInfo();
        if (r5 == null) goto L14;
        InteractiveSongUserInfo r6 = r5.getTopUser();
    L15:
        if (r6 == null) goto L51;
        Bundle r7 = new Bundle();
        r7.putString("gift_show_from", "sing_challenge_bar");
        KtvContext.Companion.getClass();
        if (KtvContext.a.m() == false) goto L19;
        String r8 = "radio";
    L20:
        r7.putString("function_type", r8);
        r7.putInt("is_sing_challenge", isKtvChallengeOpen() ? 1 : 0);
        r7.putLong("challenge_id", this.challengeConfig.a);
        com.bytedance.android.livesdk.chatroom.o r9 = o3.f();
        if (r9 == null) goto L27;
        com.bytedance.live.datacontext.m r10 = r9.getRoom();
        if (r10 == null) goto L27;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L27;
        jc1.k.n(g50.c.class).openGiftDialog(r11.getOwner(), r7);
    L27:
        KtvRoomLyricsStateMachineConfig.d r12 = getCurrentSingStatus();
        if (r12 == null) goto L30;
        r2 = r12.b();
    L30:
        IRoom r13 = com.bytedance.android.live.ktv.common.util.a.c();
        if (r2 == null) goto L52;
        String r14 = getUserType();
        KtvMusic r15 = r2.a;
        String r16 = "";
        if (r15 == null) goto L40;
        OrderInfo r17 = r15.getOrderInfo();
        if (r17 == null) goto L40;
        InteractiveSongUserInfo r18 = r17.getTopUser();
        if (r18 == null) goto L40;
        String r19 = r18.getIdString();
        if (r19 == null) goto L40;
    L41:
        String r20 = getChallengeUserType(r19);
        Long r21 = KtvLoggerHelper.a;
        String r22 = r13.getOwnerUserIdString();
        long r23 = r13.getId();
        String r24 = com.bytedance.android.live.ktv.common.util.j.c();
        long r110 = r2.a.getMId();
        String r25 = r2.a.getMTitle();
        if (r25 == null) goto L45;
        r16 = r25;
    L45:
        long r111 = getConfig().c;
        Long r26 = this.currentScore;
        if (r26 == null) goto L48;
        long r112 = r26.longValue();
    L49:
        long r113 = getConfig().a;
        Intrinsics.checkNotNullParameter(r22, "anchorId");
        Intrinsics.checkNotNullParameter(r24, "functionType");
        Intrinsics.checkNotNullParameter(r14, "user_type");
        Intrinsics.checkNotNullParameter(r19, "to_user_id");
        Intrinsics.checkNotNullParameter(r20, "to_user_type");
        Intrinsics.checkNotNullParameter(r16, "song_name");
        HashMap r114 = new HashMap();
        r114.put("anchor_id", r22.toString());
        r114.put("room_id", String.valueOf(r23));
        KtvLoggerHelper.A(r114);
        r114.put("live_type", KtvLoggerHelper.F());
        r114.put("user_type", r14);
        r114.put("to_user_id", r19);
        r114.put("to_user_type", r20);
        r114.put("song_id", String.valueOf(r110));
        r114.put("song_name", r16);
        r114.put("goal", String.valueOf(r111));
        r114.put("current_score", String.valueOf(r112));
        r114.put("challenge_id", String.valueOf(r113));
        j0.l().sendLog("livesdk_ktv_sing_challenge_bar_click", r114, new Object[0]);
        return;
    L48:
        r112 = 0;
    L40:
        r19 = "";
        goto L41
    L52:
        return;
    L19:
        r8 = com.bytedance.android.live.ktv.common.util.j.c();
        goto L20
    L51:
        return;
    L14:
        r6 = null;
        goto L15
    }

    public final void stopCountDown() {
        Disposable r0 = this.countDownDisposable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L12;
        ALogger.i(TAG, "stopCountDown");
        Disposable r1 = this.countDownDisposable;
        if (r1 == null) goto L9;
        r1.dispose();
    L9:
        this.currentCountDownTime = 0;
        return;
    }

    private final boolean canAutoOpenChallenge() {
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.j r1 = r0.s2();
        if (r1 == null) goto L8;
        z0 r2 = (z0) r1.getValue();
    L8:
        if (isAudioKtv() == false) goto L20;
        com.bytedance.android.livesdk.chatroom.u r3 = o3.d();
        if (r3 == null) goto L19;
        com.bytedance.live.datacontext.j r4 = r3.s();
        if (r4 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r4.getValue();
        if (r5 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r6 = r5.t();
        if (r6 == null) goto L19;
        if (r6.a == 5) goto L20;
    L19:
        boolean r7 = true;
    L21:
        if (r7 == true) goto L23;
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r8 = KtvComponentContext.Companion.a();
        if (r8 == null) goto L32;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r9 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r8.getValue();
        if (r9 != null) goto L29;
        return false;
    L29:
        if (r9.c != true) goto L34;
        return true;
    L34:
        return false;
    L32:
        return false;
    L23:
        return ktvChallengeLocalConfig().getChallengeStatus();
    L20:
        r7 = false;
        goto L21
    }

    private final void checkAndStartKtvChallengeBySwitchScene() {
        if (ktvChallengeLocalConfig().getChallengeStatus() == false) goto L10;
        KtvChallengeProperty r0 = ktvChallengeLocalConfig();
        long r4 = r0.getChallengeDuration();
        long r2 = r0.getChallengeTarget();
        if (r2 > 0) goto L7;
        return;
    L7:
        if (r4 <= 0) goto L12;
        ALogger.i(TAG, "checkAndStartKtvChallengeBySwitchScene, auto openChallenge");
        openChallenge(new me2.b(r2, r4, ChallengeChangeType.AUTO_TURN_ON, SwitchStatus.OPEN.getValue(), "sing_challenge_setting_panel", "auto", r0.getChallengeType(), 384));
        return;
    L12:
        return;
    }

    private final void checkAutoOpen() {
        if (isChallengeOpen() == false) goto L5;
    L38:
        ALogger.w(TAG, "checkAutoOpen:false,hasCheckAutoOpen：" + this.hasCheckAutoOpen + ", isChallengeOpen:" + isChallengeOpen() + ", isMultiLinkScene: " + ne2.a.c());
        return;
    L5:
        if (this.hasCheckAutoOpen == true) goto L38;
        if (ne2.a.c() == false) goto L38;
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == true) goto L38;
        if (isAnchor() == false) goto L40;
        this.hasCheckAutoOpen = true;
        com.bytedance.android.livesdk.chatroom.t r2 = o3.a();
        if (r2 == null) goto L18;
        com.bytedance.live.datacontext.n r3 = r2.a();
        if (r3 == null) goto L18;
        ArrayList r4 = (ArrayList) r3.getValue();
    L20:
        if (d0.g(r4) == false) goto L28;
        com.bytedance.android.livesdk.chatroom.t r1 = o3.a();
        if (r1 == null) goto L26;
        com.bytedance.live.datacontext.n r5 = r1.a();
        if (r5 == null) goto L26;
        r5.setValue(null);
    L26:
        this.openingChallengeByFastStart = true;
        openChallenge("convenient_page", null);
        return;
    L28:
        if (this.openingChallengeByFastStart == false) goto L30;
        return;
    L30:
        if (canAutoOpenChallenge() == false) goto L43;
        KtvChallengeProperty r0 = ktvChallengeLocalConfig();
        long r6 = r0.getChallengeDuration();
        long r7 = r0.getChallengeTarget();
        ALogger.i(TAG, "checkAutoOpen, auto openChallenge, score: " + r7 + ", duration: " + r6);
        if (r7 > 0) goto L34;
    L36:
        ALogger.e(TAG, "auto openChallenge fail ,score:" + r7 + ",duration:" + r6);
        return;
    L34:
        if (r6 <= 0) goto L36;
        openChallenge(new me2.b(r7, r6, ChallengeChangeType.AUTO_TURN_ON, SwitchStatus.OPEN.getValue(), "sing_challenge_setting_panel", "auto", r0.getChallengeType(), 384));
        return;
    L43:
        return;
    L18:
        r4 = null;
        goto L20
    }

    private final boolean confirmChallengeClosed() {
        if (isChallengeOpen() == true) goto L6;
        this.isChallenging = false;
        StateMachine<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e> r0 = this.statusMachine;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.a.b;
        StateMachine.a r2 = StateMachine.c;
        r0.d(r1, null);
        return true;
    L6:
        return false;
    }

    private final KtvRoomLyricsStateMachineConfig.d getCurrentSingStatus() {
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = getMCoreViewModel();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurState();
    }

    private final String getToastContentWhenOpenChallenge() {
        if (isAnchor() == false) goto L5;
    L11:
        boolean r0 = isAudienceSingEnable();
        if (isAudioKtv() == false) goto L18;
        if (isSinging() == false) goto L29;
        return s1.B(2131918246);
    L29:
        return s1.B(2131918248);
    L18:
        if (isSinging() == false) goto L22;
        if (r0 == false) goto L31;
        return s1.B(2131918246);
    L31:
        return s1.B(2131918245);
    L22:
        if (r0 == false) goto L25;
        return s1.B(2131918248);
    L25:
        return s1.B(2131918243);
    L5:
        if (com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt.d() == true) goto L11;
        if (isCurrentUserIsSinger() == false) goto L27;
        return s1.B(2131918246);
    L27:
        return s1.B(2131918248);
    }

    private final boolean isAnchor() {
        return Intrinsics.areEqual(o3.f().isAnchor(), Boolean.TRUE);
    }

    private final boolean isAudioKtv() {
        com.bytedance.android.livesdk.chatroom.u r0 = o3.d();
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.j r1 = r0.s();
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r2 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = r2.t();
        if (r3 == null) goto L13;
        if (r3.a != 9) goto L13;
        return true;
    L13:
        return false;
    }

    private final boolean isSinging() {
        KtvRoomLyricsStateMachineConfig.d r0 = getCurrentSingStatus();
        if (r0 == null) goto L5;
        MusicPanel r1 = r0.b();
    L6:
        if (r1 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    private final void logChallengeWatchDurationIfNeed() {
        if (isAnchor() == false) goto L5;
        return;
    L5:
        if (this.playModeWatchRecordStartTime == 0) goto L16;
        long r0 = (System.currentTimeMillis() - this.playModeWatchRecordStartTime) / 1000;
        com.bytedance.android.livesdk.chatroom.o r4 = o3.f();
        if (r4 == null) goto L13;
        com.bytedance.live.datacontext.m r5 = r4.getRoom();
        if (r5 == null) goto L13;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L13;
        Long r7 = KtvLoggerHelper.a;
        String r8 = KtvLoggerHelper.p0(6);
        String r9 = r6.getOwnerUserIdString();
        long r10 = r6.getId();
        String r11 = com.bytedance.android.live.ktv.common.util.j.c();
        Intrinsics.checkNotNullParameter(r8, "playMode");
        Intrinsics.checkNotNullParameter(r9, "anchorId");
        Intrinsics.checkNotNullParameter(r11, "functionType");
        HashMap r12 = new HashMap();
        r12.put("anchor_id", r9.toString());
        r12.put("room_id", String.valueOf(r10));
        r12.put("function_type", KtvLoggerHelper.H(r11));
        r12.put("live_type", KtvLoggerHelper.F());
        r12.put("play_mode", r8);
        r12.put("duration", String.valueOf(r0));
        KtvLoggerHelper.o0(r12);
        KtvLoggerHelper.k0(r12);
        zi0.d.b(r12, false);
        j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r12, new Object[]{am2.x.class});
    L13:
        this.playModeWatchRecordStartTime = 0;
        return;
    }

    private final void logChallengeWatchIfNeed() {
        if (isAnchor() == false) goto L5;
        return;
    L5:
        if (this.playModeWatchRecordStartTime != 0) goto L15;
        this.playModeWatchRecordStartTime = System.currentTimeMillis();
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        if (r0 == null) goto L16;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L17;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L18;
        Long r3 = KtvLoggerHelper.a;
        String r4 = KtvLoggerHelper.p0(6);
        String r5 = r2.getOwnerUserIdString();
        long r6 = r2.getId();
        String r7 = com.bytedance.android.live.ktv.common.util.j.c();
        Intrinsics.checkNotNullParameter(r4, "playMode");
        Intrinsics.checkNotNullParameter(r5, "anchorId");
        Intrinsics.checkNotNullParameter(r7, "functionType");
        HashMap r8 = new HashMap();
        r8.put("anchor_id", r5.toString());
        r8.put("room_id", String.valueOf(r6));
        KtvLoggerHelper.A(r8);
        r8.put("live_type", KtvLoggerHelper.F());
        r8.put("play_mode", r4);
        KtvLoggerHelper.o0(r8);
        KtvLoggerHelper.k0(r8);
        i0 r9 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.c1(r8);
        zi0.d.b(r8, false);
        j0.l().sendLog("livesdk_audience_playmode_room_watch", r8, new Object[]{am2.x.class});
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    private final void queryCurrentRoomChallengeStatus() {
        long r0 = System.currentTimeMillis();
        CompositeDisposable r2 = this.compositeDispose;
        Disposable r1 = ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getSingingChallengeStatus(com.bytedance.android.live.ktv.common.util.a.c().getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new p(this, r0), new q(r0));
        RxUtilKt.c(r1, this.compositeDispose);
        r2.add(r1);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a
    public me2.a getChallengeConfig() {
        return getConfig();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a
    public boolean isKtvChallengeOpen() {
        return isChallengeOpen();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a
    public boolean needHideMidi() {
        if (isChallengeOpen() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.challengeConfig.f != KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue()) goto L7;
    L8:
        return true;
    L7:
        if (this.challengeConfig.f != KtvChallengeType.KTV_CHALLENGE_TYPE_LIKE.getValue()) goto L9;
        goto L8
    }

    public void onCleared() {
        super.onCleared();
        ALogger.i(TAG, "onCleared");
        vlc.d r0 = (vlc.d) this.dataCenter.get("data_message_manager", null);
        Disposable r1 = this.countDownDisposable;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        Disposable r2 = this.resultIntervalDisposable;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        Disposable r3 = this.challengingDisposable;
        if (r3 == null) goto L11;
        r3.dispose();
    L11:
        this.compositeDispose.dispose();
        this.isChallenging = false;
        me2.a r4 = this.challengeConfig;
        int r5 = r4.b;
        r4.b = 2;
        if (isAudioKtv() == false) goto L14;
        notifyChallengeStatusChanged(this.challengeConfig.f);
    L14:
        com.bytedance.android.livesdk.chatroom.u r6 = o3.d();
        if (r6 == null) goto L21;
        com.bytedance.live.datacontext.j r7 = r6.J();
        if (r7 == null) goto L21;
        LivePlayModeLogContext r8 = (LivePlayModeLogContext) r7.getValue();
        if (r8 == null) goto L21;
        r8.removePlayMode(6);
    L21:
        logChallengeWatchDurationIfNeed();
        KtvContext.Companion.getClass();
        KtvContext r9 = KtvContext.a.g();
        if (r9 == null) goto L26;
        HashMap<String, String> r10 = r9.getGiftReportParam();
        if (r10 == null) goto L26;
        r10.clear();
    L26:
        if (r0 == null) goto L28;
        r0.removeMessageListener(this);
    L28:
        this.dataCenter.removeObserver(this);
        this.challengeStatusListenerList.clear();
        clearMidiScoreInfo();
        logChallengeWatchDurationIfNeed();
        if (isAnchor() == true) goto L31;
        return;
    L31:
        if (KtvContext.a.k() == true) goto L33;
        return;
    L33:
        if (r5 != 1) goto L38;
        IRoom r11 = com.bytedance.android.live.ktv.common.util.a.c();
        long r12 = (long) ((System.currentTimeMillis() - this.recordStartTime) / 1000.0f);
        int r13 = jc1.k.n(IInteractService.class).getCurrentScene();
        Long r14 = KtvLoggerHelper.a;
        Integer r15 = KtvLoggerHelper.y();
        KtvLoggerHelper.N(KtvLoggerHelper.p0(6), r11.getOwnerUserIdString().toString(), String.valueOf(r11.getRoomId()), KtvLoggerHelper.D(Integer.valueOf(r13), r15), KtvLoggerHelper.j0(r15), null, Long.valueOf(r12));
        return;
    }

    private final me2.a getConfig() {
        return this.challengeConfig;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a
    public void checkAutoOpenChallenge() {
        checkAutoOpen();
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a
    public void onComponentClose() {
        challengeClose();
    }

    public KtvSingChallengeViewModel(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.dataCenter = r4;
        this.compositeDispose = new CompositeDisposable();
        me2.a r5 = new me2.a();
        KtvChallengeProperty r0 = ktvChallengeLocalConfig();
        r5.d = r0.getChallengeDuration();
        r5.c = r0.getChallengeTarget();
        r5.f = r0.getChallengeType();
        Unit r1 = Unit.INSTANCE;
        this.challengeConfig = r5;
        this.currentScore = 0L;
        this.pendingChallengeScore = new LongSparseArray();
        this.challengeGiftReportParam = new HashMap();
        this.challengeStatusListenerList = new ArrayList();
        this.curSentenceIndex = -1;
        this.currentChallengeResultType = 5;
        int r6 = KtvChallengeStatusMachine.a;
        this.statusMachine = KtvChallengeStatusMachine.a(new KtvSingChallengeViewModel$statusMachine$1(this));
        this.mCoreListener = new l(this);
        this.challengeGiftReportParam.put("is_sing_challenge", BDLocationException.ERROR_TIMEOUT);
        KtvContext.Companion.getClass();
        KtvContext r7 = KtvContext.a.g();
        if (r7 == null) goto L7;
        HashMap<String, String> r8 = r7.getGiftReportParam();
        if (r8 == null) goto L7;
        r8.putAll(this.challengeGiftReportParam);
    L7:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r9 = getMCoreViewModel();
        if (r9 == null) goto L10;
        registerKtvCoreListenerAndQueryStatus(r9);
    L10:
        KtvContext r10 = KtvContext.a.g();
        if (r10 == null) goto L19;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r11 = r10.getKtvCoreViewModel();
        if (r11 == null) goto L19;
        Observable r12 = r11.a();
        if (r12 == null) goto L19;
        Disposable r13 = r12.subscribe(new a(this));
        if (r13 == null) goto L19;
        this.compositeDispose.add(r13);
    L19:
        initData();
    }

    public static final /* synthetic */ void access$checkAutoOpen(KtvSingChallengeViewModel r0) {
        r0.checkAutoOpen();
    }

    public static final /* synthetic */ me2.a access$getChallengeConfig$p(KtvSingChallengeViewModel r0) {
        return r0.challengeConfig;
    }

    public static final /* synthetic */ int access$getCurrentChallengeResultType$p(KtvSingChallengeViewModel r0) {
        return r0.currentChallengeResultType;
    }

    public static final /* synthetic */ long access$getCurrentCountDownTime$p(KtvSingChallengeViewModel r2) {
        return r2.currentCountDownTime;
    }

    public static final /* synthetic */ KtvRoomLyricsStateMachineConfig.d access$getCurrentSingStatus(KtvSingChallengeViewModel r0) {
        return r0.getCurrentSingStatus();
    }

    public static final /* synthetic */ boolean access$getCurrentSongIsChallenging$p(KtvSingChallengeViewModel r0) {
        return r0.currentSongIsChallenging;
    }

    public static final /* synthetic */ String access$getOpenSource$p(KtvSingChallengeViewModel r0) {
        return r0.openSource;
    }

    public static final /* synthetic */ long access$getPendingChallengeId$p(KtvSingChallengeViewModel r2) {
        return r2.pendingChallengeId;
    }

    public static final /* synthetic */ LongSparseArray access$getPendingChallengeScore$p(KtvSingChallengeViewModel r0) {
        return r0.pendingChallengeScore;
    }

    public static final /* synthetic */ long access$getRecordStartTime$p(KtvSingChallengeViewModel r2) {
        return r2.recordStartTime;
    }

    public static final /* synthetic */ StateMachine access$getStatusMachine$p(KtvSingChallengeViewModel r0) {
        return r0.statusMachine;
    }

    public static final /* synthetic */ boolean access$isAnchor$p(KtvSingChallengeViewModel r0) {
        return r0.isAnchor();
    }

    public static final /* synthetic */ boolean access$isAudioKtv(KtvSingChallengeViewModel r0) {
        return r0.isAudioKtv();
    }

    public static final /* synthetic */ boolean access$isChallenging$p(KtvSingChallengeViewModel r0) {
        return r0.isChallenging;
    }

    public static final /* synthetic */ void access$logChallengeWatchDurationIfNeed(KtvSingChallengeViewModel r0) {
        r0.logChallengeWatchDurationIfNeed();
    }

    public static final /* synthetic */ void access$logChallengeWatchIfNeed(KtvSingChallengeViewModel r0) {
        r0.logChallengeWatchIfNeed();
    }

    public static final /* synthetic */ void access$skipCurrentSong(KtvSingChallengeViewModel r0) {
        r0.skipCurrentSong();
    }

    public static final /* synthetic */ void access$transChallengeStatusWithSingState(KtvSingChallengeViewModel r0) {
        r0.transChallengeStatusWithSingState();
    }

    private final void enableAudienceSing(boolean r7) {
        long r0 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        long r2 = System.currentTimeMillis();
        Disposable r8 = ((KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class)).updateAudienceSingEnableSetting(r0, r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(r7, r2), new e(r2));
        if (r8 == null) goto L6;
        RxUtilKt.c(r8, this.compositeDispose);
        return;
    }

    private final String getChallengeUserType(String r2) {
        if (Intrinsics.areEqual(com.bytedance.android.live.ktv.common.util.a.c().getOwnerUserIdString(), r2) == false) goto L5;
        return "anchor";
    L5:
        return "guest";
    }

    private final void handleChallengeResultChange(int r3) {
        notifyChallengeResultChanged(4);
        if (r3 != 2) goto L9;
        Disposable r4 = this.challengingDisposable;
        if (r4 == null) goto L14;
        r4.dispose();
        return;
    L14:
        return;
    L9:
        if (isAudioKtv() == true) goto L15;
        Disposable r5 = Observable.timer(CHALLENGE_ON_GOING_INTERVAL, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this));
        this.challengingDisposable = r5;
        if (r5 == null) goto L16;
        RxUtilKt.c(r5, this.compositeDispose);
        return;
    L16:
        return;
    }

    private final void notifyChallengeCountDownChanged(long r3) {
        Iterator<T> r0 = this.challengeStatusListenerList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b) r0.next()).i(r3);
        goto L4
    }

    private final void notifyChallengeProgressChanged(int r3) {
        Iterator<T> r0 = this.challengeStatusListenerList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b) r0.next()).b(r3);
        goto L4
    }

    private final void notifyChallengeResultChanged(int r4) {
        Iterator<T> r0 = this.challengeStatusListenerList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b) r0.next()).j(r4, currentScoreValue());
        goto L4
    L6:
        this.currentChallengeResultType = r4;
    }

    private final void notifyChallengeStatusChanged(int r5) {
        Iterator<T> r0 = this.challengeStatusListenerList.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b r1 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b) r0.next();
        boolean r3 = true;
        if (this.challengeConfig.b == 1) goto L9;
        r3 = false;
    L9:
        r1.f(r3, r5);
        goto L4
    }

    private final void notifyKtvStateChange(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r3) {
        Iterator<T> r0 = this.challengeStatusListenerList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b) r0.next()).a(r3);
        goto L4
    }

    private final void onChallengeResultChanged(int r4) {
        notifyChallengeResultChanged(r4);
        if (r4 == 5) goto L11;
        Disposable r0 = this.resultIntervalDisposable;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        Disposable r5 = Observable.timer(CHALLENGE_RESULT_SHOW_DURATION, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this, r4));
        this.resultIntervalDisposable = r5;
        if (r5 == null) goto L12;
        RxUtilKt.c(r5, this.compositeDispose);
        return;
    L12:
        return;
    }

    private final void onChallengeStateChange(boolean r3) {
        HashMap<String, String> r0 = this.challengeGiftReportParam;
        if (r3 == false) goto L5;
        String r4 = "1";
    L6:
        r0.put("is_sing_challenge", r4);
        KtvContext.Companion.getClass();
        KtvContext r5 = KtvContext.a.g();
        if (r5 == null) goto L12;
        HashMap<String, String> r6 = r5.getGiftReportParam();
        if (r6 == null) goto L13;
        r6.putAll(this.challengeGiftReportParam);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r4 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    private final void onChallengeStatusChange(StateMachine.c<? extends com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f, ? extends com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c, ? extends com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e> r10) {
        if ((r10 instanceof StateMachine.c.b) == true) goto L5;
        r10 = null;
    L5:
        StateMachine.c.b r11 = (StateMachine.c.b) r10;
        if (r11 == null) goto L51;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e r12 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e) r11.d;
        if (r12 != null) goto L11;
        return;
    L11:
        if ((r12 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e.d) == false) goto L13;
        challengePrepare();
        return;
    L13:
        int r1 = 0;
        if ((r12 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e.C0026e) == false) goto L33;
        me2.a r0 = this.challengeConfig;
        if (r0.c > 0) goto L18;
    L19:
        r1 = 1;
    L21:
        if (isCurrentUserIsSinger() == false) goto L24;
        if (r1 == 0) goto L24;
        return;
    L24:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e.C0026e r13 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e.C0026e) r12;
        this.currentScore = Long.valueOf(r13.a);
        start(r13.a, r13.b);
        if (isAnchor() == false) goto L27;
    L31:
        onChallengeResultChanged(1);
        return;
    L27:
        if (isCurrentUserIsSinger() == true) goto L31;
        if (r13.a < this.challengeConfig.c) goto L31;
        onChallengeResultChanged(2);
        return;
    L18:
        if (r0.d > 0) goto L21;
    L33:
        if ((r12 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e.f) == false) goto L36;
        this.currentScore = Long.valueOf(((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e.f) r12).a);
        challengeSuccess();
        onChallengeResultChanged(2);
        return;
    L36:
        if ((r12 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e.c) == false) goto L39;
        onChallengeResultChanged(3);
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e.c r14 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e.c) r12;
        challengeFailure(r14.a, r14.b, r14.c);
        return;
    L39:
        if ((r12 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e.a) == false) goto L42;
        challengeClose();
        onChallengeResultChanged(5);
        return;
    L42:
        if ((r12 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e.b) == false) goto L45;
        challengeEnd();
        onChallengeResultChanged(5);
        return;
    L45:
        if ((r12 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e.g) == false) goto L59;
        Long r15 = Long.valueOf(((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e.g) r12).a);
        this.currentScore = r15;
        if (r15 == null) goto L49;
        r1 = (int) r15.longValue();
    L49:
        notifyChallengeProgressChanged(r1);
        return;
    L59:
        return;
    }

    private final void onSingPreparing(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r8) {
        this.currentScore = 0L;
        clearMidiScoreInfo();
        Object r2 = r8.b;
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.a.i) == false) goto L5;
    L6:
        StateMachine<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e> r3 = this.statusMachine;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.b r4 = com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.b.b;
        StateMachine.a r5 = StateMachine.c;
        r3.d(r4, null);
    L7:
        KtvRoomLyricsStateMachineConfig.d r6 = (KtvRoomLyricsStateMachineConfig.d) r8.a;
        if ((r6 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L11;
    L55:
        boolean r9 = false;
    L57:
        if (r9 == false) goto L62;
        ALogger.i(TAG, "onSingPreparing isRealPrepare: " + r9);
        if (confirmChallengeClosed() == true) goto L63;
        this.currentSongIsChallenging = true;
        StateMachine<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e> r10 = this.statusMachine;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.d r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.d.b;
        StateMachine.a r1 = StateMachine.c;
        r10.d(r0, null);
        return;
    L63:
        return;
    L62:
        return;
    L11:
        if ((r6 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L56;
        MusicPanel r7 = ((KtvRoomLyricsStateMachineConfig.d) r8.c).b();
        if (r7 == null) goto L18;
        KtvMusic r11 = r7.a;
        if (r11 == null) goto L18;
        if (r11.getMId() == 0) goto L55;
    L18:
        MusicPanel r12 = ((KtvRoomLyricsStateMachineConfig.d) r8.a).b();
        if (r12 == null) goto L23;
        KtvMusic r13 = r12.a;
        if (r13 == null) goto L23;
        Long r14 = Long.valueOf(r13.getMId());
    L24:
        MusicPanel r15 = ((KtvRoomLyricsStateMachineConfig.d) r8.c).b();
        if (r15 == null) goto L29;
        KtvMusic r16 = r15.a;
        if (r16 == null) goto L29;
        Long r17 = Long.valueOf(r16.getMId());
    L31:
        if ((!Intrinsics.areEqual(r14, r17)) == true) goto L56;
        MusicPanel r18 = ((KtvRoomLyricsStateMachineConfig.d) r8.a).b();
        if (r18 == null) goto L41;
        KtvMusic r19 = r18.a;
        if (r19 == null) goto L41;
        OrderInfo r20 = r19.getOrderInfo();
        if (r20 == null) goto L41;
        InteractiveSongUserInfo r21 = r20.getTopUser();
        if (r21 == null) goto L41;
        String r22 = r21.getIdString();
    L42:
        MusicPanel r23 = ((KtvRoomLyricsStateMachineConfig.d) r8.c).b();
        if (r23 == null) goto L51;
        KtvMusic r24 = r23.a;
        if (r24 == null) goto L51;
        OrderInfo r25 = r24.getOrderInfo();
        if (r25 == null) goto L51;
        InteractiveSongUserInfo r26 = r25.getTopUser();
        if (r26 == null) goto L51;
        String r27 = r26.getIdString();
    L53:
        if ((!Intrinsics.areEqual(r22, r27)) == false) goto L55;
    L51:
        r27 = null;
    L41:
        r22 = null;
    L29:
        r17 = null;
    L23:
        r14 = null;
    L56:
        r9 = true;
        goto L57
    L5:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.a.c) == false) goto L7;
        goto L6
    }

    private final void onSinging(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r12) {
        if ((r12.a instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L6;
        ALogger.i(TAG, "onSinging: currentSongIsChallenging=" + this.currentSongIsChallenging + ", state=" + ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f) this.statusMachine.b()));
    L6:
        if (this.currentSongIsChallenging == true) goto L8;
        return;
    L8:
        if ((r12.a instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L10;
        return;
    L10:
        if (isAnchor() == true) goto L14;
        long r4 = this.pendingChallengeId;
        if (r4 == 0) goto L14;
        this.challengeConfig.a = r4;
        this.pendingChallengeId = 0;
    L14:
        Object r13 = r12.b;
        if ((r13 instanceof KtvRoomLyricsStateMachineConfig.a.e) == true) goto L17;
        r13 = null;
    L17:
        KtvRoomLyricsStateMachineConfig.a.e r14 = (KtvRoomLyricsStateMachineConfig.a.e) r13;
        if (r14 == null) goto L24;
        KtvMusic.a r0 = KtvMusic.Companion;
        MusicPanel r5 = r14.c;
        if (r5 == null) goto L22;
        KtvMusic r6 = r5.a;
    L23:
        long r7 = r14.e;
        r0.getClass();
        long r8 = KtvMusic.a.b(r6, r7);
    L25:
        ALogger.i(TAG, "onSinging: currentProgress=" + r8 + ", challengeId=" + this.challengeConfig.a + ", pendingChallengeId=" + this.pendingChallengeId + ", pendingChallengeScore=" + this.pendingChallengeScore);
        if (r8 == 0) goto L31;
        Long r1 = this.pendingChallengeScore.get(this.challengeConfig.a);
        if (r1 == null) goto L31;
        long r2 = r1.longValue();
    L32:
        this.pendingChallengeScore.clear();
        if (isAnchor() == false) goto L35;
        long r9 = this.challengeConfig.d;
    L44:
        me2.a r15 = this.challengeConfig;
        if (r15.c > 0) goto L47;
        return;
    L47:
        if (r15.d <= 0) goto L53;
        StateMachine<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e> r16 = this.statusMachine;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.e r3 = new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.e(r2, r9);
        StateMachine.a r10 = StateMachine.c;
        r16.d(r3, null);
        return;
    L53:
        return;
    L35:
        me2.a r11 = this.challengeConfig;
        if (r11.e < 0) goto L43;
        if (r8 <= 0) goto L42;
        r9 = r11.d - (r8 / 1000);
        if (r9 > 0) goto L44;
        r9 = 0;
        goto L44
    L42:
        r9 = r11.d;
        goto L44
    L43:
        r9 = r11.d;
    L31:
        r2 = 0;
        goto L32
    L22:
        r6 = null;
        goto L23
    L24:
        r8 = 0;
        goto L25
    }

    private final void onStatusMessage(KTVChallengeStatusMessage r23) {
        me2.a r1 = this.challengeConfig;
        r23.getDurationIncrement();
        r1.getClass();
        int r2 = (int) r23.getStatus();
        if (r2 != 1) goto L5;
        KtvRoomLyricsStateMachineConfig.d r3 = getCurrentSingStatus();
        if (r3 == null) goto L17;
        MusicPanel r4 = r3.b();
    L18:
        String r5 = "";
        if (r4 == null) goto L28;
        KtvMusic r6 = r4.a;
        if (r6 == null) goto L28;
        OrderInfo r7 = r6.getOrderInfo();
        if (r7 == null) goto L28;
        InteractiveSongUserInfo r8 = r7.getTopUser();
        if (r8 == null) goto L28;
        String r9 = r8.getIdString();
        if (r9 == null) goto L28;
    L29:
        String r10 = getChallengeUserType(r9);
        me2.a r11 = this.challengeConfig;
        long r12 = r11.d;
        long r13 = r11.c;
        ALogger.i(TAG, "STATUS_START_message.targetScore : " + r23.getTargetScore() + ", STATUS_START_message.targetDuration : " + r23.getTargetDuration());
        config(r23.getTargetScore(), r23.getTargetDuration());
        Integer r14 = r23.getKtvChallengeType();
        if (r14 == null) goto L32;
        this.challengeConfig.f = r14.intValue();
    L32:
        this.challengeConfig.a = r23.getChallengeId();
        applyNewConfigWhenMessageStartIfNeed(r12, r13);
        if (isAnchor() == true) goto L35;
        StateMachine<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e> r15 = this.statusMachine;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.e r16 = new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.e(r23.getCurrentScore(), r23.getTargetDuration());
        StateMachine.a r17 = StateMachine.c;
        r15.d(r16, null);
    L35:
        IRoom r18 = com.bytedance.android.live.ktv.common.util.a.c();
        Long r19 = KtvLoggerHelper.a;
        String r20 = r18.getOwnerUserIdString();
        long r21 = r18.getId();
        String r22 = com.bytedance.android.live.ktv.common.util.j.c();
        String r24 = getUserType();
        long r110 = 0;
        if (r4 == null) goto L40;
        KtvMusic r111 = r4.a;
        if (r111 == null) goto L40;
        long r112 = r111.getMId();
    L41:
        if (r4 == null) goto L48;
        KtvMusic r25 = r4.a;
        if (r25 == null) goto L48;
        String r26 = r25.getMTitle();
        if (r26 == null) goto L48;
        r5 = r26;
    L48:
        long r113 = getConfig().c;
        Long r27 = this.currentScore;
        if (r27 == null) goto L51;
        r110 = r27.longValue();
    L51:
        long r0 = getConfig().a;
        Intrinsics.checkNotNullParameter(r20, "anchorId");
        Intrinsics.checkNotNullParameter(r22, "functionType");
        Intrinsics.checkNotNullParameter(r24, "user_type");
        Intrinsics.checkNotNullParameter(r9, "to_user_id");
        Intrinsics.checkNotNullParameter(r10, "to_user_type");
        Intrinsics.checkNotNullParameter(r5, "song_name");
        HashMap r114 = new HashMap();
        r114.put("anchor_id", r20.toString());
        r114.put("room_id", String.valueOf(r21));
        KtvLoggerHelper.A(r114);
        r114.put("live_type", KtvLoggerHelper.F());
        r114.put("user_type", r24);
        r114.put("to_user_id", r9);
        r114.put("to_user_type", r10.toString());
        r114.put("song_id", String.valueOf(r112));
        r114.put("song_name", r5);
        r114.put("goal", String.valueOf(r113));
        r114.put("current_score", String.valueOf(r110));
        r114.put("challenge_id", String.valueOf(r0));
        j0.l().sendLog("livesdk_ktv_sing_challenge_bar_show", r114, new Object[0]);
        return;
    L40:
        r112 = 0;
    L28:
        r9 = "";
        goto L29
    L17:
        r4 = null;
        goto L18
    L5:
        if (r2 != 2) goto L7;
        me2.a r28 = this.challengeConfig;
        r23.getEmoji_location();
        r28.getClass();
        me2.a r29 = this.challengeConfig;
        r23.getGift_type();
        r29.getClass();
        ALogger.i(TAG, "score update: Event.OnUpdateScore status=" + ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f) this.statusMachine.b()));
        this.statusMachine.d(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.g(r23.getCurrentScore(), r23.getTargetScore(), r23.getGift_type(), r23.getEmoji_location()), null);
        return;
    L7:
        if (r2 != 3) goto L9;
        ALogger.i(TAG, "success: Event.OnSuccess status=" + ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f) this.statusMachine.b()));
        this.statusMachine.d(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.f(r23.getCurrentScore(), r23.getTargetScore()), null);
        return;
    L9:
        if (r2 != 4) goto L56;
        ALogger.i(TAG, "failure: Event.OnFailure status=" + ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f) this.statusMachine.b()));
        this.statusMachine.d(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.C0025c(), null);
        return;
    }

    private final void onSubSceneChange(int r3) {
        ALogger.i(TAG, "scene: " + r3 + ", isMultiLinkMic: " + isVideoMultiLinkScene(r3) + "， isKtvComponentOpened: " + isKtvComponentOpened());
        if (r3 != 9) goto L10;
        if (isChallengeOpen() == false) goto L7;
        return;
    L7:
        if (isAnchor() == false) goto L20;
        checkAndStartKtvChallengeBySwitchScene();
        return;
    L20:
        return;
    L10:
        if (isVideoMultiLinkScene(r3) == true) goto L12;
        return;
    L12:
        if (isKtvComponentOpened() == true) goto L14;
        return;
    L14:
        if (isChallengeOpen() == false) goto L16;
        return;
    L16:
        if (isAnchor() == false) goto L25;
        checkAndStartKtvChallengeBySwitchScene();
        return;
    }

    private final void openChallenge(me2.b r3) {
        singingChallengeConfigChanged$default(this, r3, null, 2, null);
    }

    private final void registerKtvCoreListenerAndQueryStatus(com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r4) {
        ALogger.i(TAG, "registerKtvCoreListener, model: " + r4);
        r4.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE, BaseCoreViewModel.CORE_TAG_PROGRESS}), this.mCoreListener, false);
        queryCurrentRoomChallengeStatus();
    }

    private final void reportChallengeMidiResult(long r4) {
        Disposable r5 = ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).reportChallengeMidiResult(com.bytedance.android.live.ktv.common.util.a.c().getRoomId(), r4).compose(RxUtil.rxSchedulerHelper()).subscribe(r.a, s.a);
        if (r5 == null) goto L6;
        RxUtilKt.c(r5, this.compositeDispose);
        return;
    }

    private final void startCountDown(long r6) {
        ALogger.i(TAG, "startCountDown, duration: " + r6 + ", compositeDispose:" + this.compositeDispose.isDisposed());
        Disposable r0 = this.countDownDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.currentCountDownTime = r6;
        com.bytedance.android.live.core.utils.rxutils.j.a r1 = com.bytedance.android.live.core.utils.rxutils.j.a;
        Disposable r7 = com.bytedance.android.live.core.utils.rxutils.j.a(0, 1, TimeUnit.SECONDS).take(1 + r6).map(new w(r6)).compose(RxUtil.rxSchedulerHelper()).subscribe(new x(this));
        this.countDownDisposable = r7;
        if (r7 == null) goto L9;
        RxUtilKt.c(r7, this.compositeDispose);
        return;
    }

    private final boolean supportMidiChallenge(KtvMusic r3) {
        if (isMidiChallengeType() == false) goto L9;
        if (r3 == null) goto L6;
        String r4 = r3.getMidiUrl();
    L8:
        return !TextUtils.isEmpty(r4);
    L6:
        r4 = null;
        goto L8
    L9:
        return true;
    }

    private final String transSourceToPlayMode(String r3) {
        if (r3 == null) goto L19;
        int r0 = r3.hashCode();
        if (r0 == (-657953591)) goto L13;
        if (r0 == 106006350) goto L10;
        return r3;
    L10:
        if (r3.equals("order") == false) goto L16;
        return "song_order_panel";
    L16:
        return r3;
    L13:
        if (r3.equals("func_panel") == false) goto L18;
        return "interaction_button";
    L18:
        return r3;
    L19:
        return r3;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a
    public void addKtvChallengeStatusChangedListener(com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.challengeStatusListenerList.add(r2);
    }

    public void onChanged(KVData r1) {
        if (r1 == null) goto L5;
        r1.getKey();
        return;
    }

    public void onMessage(tlc.d r12) {
        StringBuilder r0 = new StringBuilder("onMessage, ");
        if (r12 == null) goto L5;
        Integer r2 = Integer.valueOf(r12.getIntType());
    L6:
        r0.append(r2);
        ALogger.i(TAG, r0.toString());
        int r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.d.a;
        boolean r3 = r12 instanceof KTVChallengeStatusMessage;
        if (r3 == false) goto L10;
        ALogger.i("KtvChallengeLogMonitor", "KTVChallengeStatusMessage: " + r12);
    L15:
        if (r3 == false) goto L18;
        onStatusMessage((KTVChallengeStatusMessage) r12);
        return;
    L18:
        if ((r12 instanceof hd) == false) goto L78;
        StringBuilder r4 = new StringBuilder("onMessage, KtvChallengeConfigMessage: duration: ");
        hd r13 = (hd) r12;
        r4.append(r13.getTargetDurationSecond());
        r4.append("， target:");
        r4.append(r13.getTargetScore());
        ALogger.i(TAG, r4.toString());
        if (((int) r13.getSwitchStatus()) != 1) goto L22;
        boolean r5 = true;
    L23:
        if (r5 == false) goto L25;
        f2.c(getToastContentWhenOpenChallenge(), 0);
    L26:
        me2.a r6 = this.challengeConfig;
        int r7 = r6.b;
        r6.b = (int) r13.getSwitchStatus();
        Integer r8 = r13.getKtvChallengeType();
        if (r8 == null) goto L29;
        this.challengeConfig.f = r8.intValue();
    L29:
        config(r13.getTargetScore(), r13.getTargetDurationSecond());
        KtvRoomLyricsStateMachineConfig.d r9 = getCurrentSingStatus();
        if (this.challengeConfig.b == 1) goto L32;
        com.bytedance.android.livesdk.chatroom.u r10 = o3.d();
        if (r10 == null) goto L57;
        com.bytedance.live.datacontext.j r11 = r10.J();
        if (r11 == null) goto L57;
        LivePlayModeLogContext r14 = (LivePlayModeLogContext) r11.getValue();
        if (r14 == null) goto L57;
        r14.removePlayMode(6);
    L57:
        logChallengeWatchIfNeed();
        ALogger.i(TAG, "config change: close, currentSingStatus=" + r9 + ", challengeStatus=" + ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f) this.statusMachine.b()));
        this.statusMachine.d(com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.a.b, null);
    L58:
        int r15 = this.challengeConfig.b;
        if (r7 == r15) goto L63;
        if (r15 != 1) goto L62;
        logChallengeWatchIfNeed();
        goto L63
    L62:
        logChallengeWatchDurationIfNeed();
    L63:
        notifyChallengeStatusChanged(this.challengeConfig.f);
        onChallengeStateChange(r5);
        if (((int) r13.getSwitchStatus()) != r7) goto L66;
        return;
    L66:
        if (((int) r13.getSwitchStatus()) != 1) goto L83;
        ALogger.i(TAG, "onMessage, config change: open, currentSingStatus=" + r9);
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L70;
    L76:
        this.currentSongIsChallenging = false;
        return;
    L70:
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L76;
        if (r9 != null) goto L74;
    L75:
        this.currentSongIsChallenging = true;
        return;
    L74:
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L75;
        return;
    L83:
        return;
    L32:
        if (isSinging() == true) goto L34;
    L36:
        com.bytedance.android.livesdk.chatroom.u r16 = o3.d();
        if (r16 == null) goto L43;
        com.bytedance.live.datacontext.j r17 = r16.J();
        if (r17 == null) goto L43;
        LivePlayModeLogContext r18 = (LivePlayModeLogContext) r17.getValue();
        if (r18 == null) goto L43;
        r18.addPlayMode(6);
    L43:
        logChallengeWatchIfNeed();
        if (isAnchor() == false) goto L58;
        if (isAudioKtv() == true) goto L58;
        if (isAudienceSingEnable() == true) goto L58;
        enableAudienceSing(true);
        goto L58
    L34:
        if (isAnchor() == false) goto L36;
        skipCurrentSong();
        goto L36
    L25:
        f2.b(2131918237, 0);
        goto L26
    L22:
        r5 = false;
        goto L23
    L78:
        if ((r12 instanceof cd) == false) goto L87;
        ALogger.i(TAG, "KTVChallengeRankMessage");
        return;
    L87:
        return;
    L10:
        if ((r12 instanceof hd) == false) goto L13;
        ALogger.i("KtvChallengeLogMonitor", "KtvChallengeConfigMessage: " + r12);
        goto L15
    L13:
        if ((r12 instanceof cd) == false) goto L15;
        ALogger.i("KtvChallengeLogMonitor", "KTVChallengeRankMessage: " + r12);
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a
    public void onMidiScoreChanged(com.bytedance.android.live.ktv.common.midi.k r4) {
        Intrinsics.checkNotNullParameter(r4, "scoreInfo");
        if (isChallengeOpen() == true) goto L5;
        return;
    L5:
        if (this.challengeConfig.f != KtvChallengeType.KTV_CHALLENGE_TYPE_MIDI.getValue()) goto L29;
        int r0 = this.curSentenceIndex;
        int r1 = r4.e;
        if (r0 == r1) goto L30;
        float r2 = r4.d;
        if (r2 <= 0) goto L31;
        if (r1 < 0) goto L32;
        Long r3 = this.currentScore;
        if (r3 == null) goto L14;
        long r5 = r3.longValue();
    L16:
        if (r2 <= r5) goto L24;
        if (isAudioKtv() == false) goto L21;
        this.currentScore = Long.valueOf((long) r4.d);
    L21:
        if (isAnchor() == false) goto L24;
        reportChallengeMidiResult((long) r4.d);
    L24:
        if (isAudioKtv() == true) goto L26;
        this.currentScore = Long.valueOf((long) r4.d);
        notifyChallengeProgressChanged((int) r4.d);
    L26:
        this.curSentenceIndex = r4.e;
        return;
    L14:
        r5 = 0;
        goto L16
    L32:
        return;
    L31:
        return;
    L30:
        return;
    }

    public void onSingIdle(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "valid");
        ALogger.i(TAG, "onSingIdle, fromSongState=" + ((KtvRoomLyricsStateMachineConfig.d) r3.a));
        StateMachine<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.e> r4 = this.statusMachine;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.b r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.b.b;
        StateMachine.a r1 = StateMachine.c;
        r4.d(r0, null);
        clearMidiScoreInfo();
    }

    public final void prepareVideoktvChallenge(me2.b r3) {
        Intrinsics.checkNotNullParameter(r3, "order");
        singingChallengeConfigChanged$default(this, r3, null, 2, null);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a
    public void removeKtvChallengeStatusChangedListener(com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.challengeStatusListenerList.remove(r2);
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }

    public static final /* synthetic */ void access$handleChallengeResultChange(KtvSingChallengeViewModel r0, int r1) {
        r0.handleChallengeResultChange(r1);
    }

    public static final /* synthetic */ void access$notifyChallengeCountDownChanged(KtvSingChallengeViewModel r0, long r1) {
        r0.notifyChallengeCountDownChanged(r1);
    }

    public static final /* synthetic */ void access$notifyChallengeStatusChanged(KtvSingChallengeViewModel r0, int r1) {
        r0.notifyChallengeStatusChanged(r1);
    }

    public static final /* synthetic */ void access$notifyKtvStateChange(KtvSingChallengeViewModel r0, StateMachine.c.b r1) {
        r0.notifyKtvStateChange(r1);
    }

    public static final /* synthetic */ void access$onChallengeResultChanged(KtvSingChallengeViewModel r0, int r1) {
        r0.onChallengeResultChanged(r1);
    }

    public static final /* synthetic */ void access$onChallengeStateChange(KtvSingChallengeViewModel r0, boolean r1) {
        r0.onChallengeStateChange(r1);
    }

    public static final /* synthetic */ void access$onChallengeStatusChange(KtvSingChallengeViewModel r0, StateMachine.c r1) {
        r0.onChallengeStatusChange(r1);
    }

    public static final /* synthetic */ void access$onSingPreparing(KtvSingChallengeViewModel r0, StateMachine.c.b r1) {
        r0.onSingPreparing(r1);
    }

    public static final /* synthetic */ void access$onSinging(KtvSingChallengeViewModel r0, StateMachine.c.b r1) {
        r0.onSinging(r1);
    }

    public static final /* synthetic */ void access$onSubSceneChange(KtvSingChallengeViewModel r0, int r1) {
        r0.onSubSceneChange(r1);
    }

    public static final /* synthetic */ void access$registerKtvCoreListenerAndQueryStatus(KtvSingChallengeViewModel r0, com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r1) {
        r0.registerKtvCoreListenerAndQueryStatus(r1);
    }

    public static final /* synthetic */ void access$setChallenging$p(KtvSingChallengeViewModel r0, boolean r1) {
        r0.isChallenging = r1;
    }

    public static final /* synthetic */ void access$setCurrentChallengeResultType$p(KtvSingChallengeViewModel r0, int r1) {
        r0.currentChallengeResultType = r1;
    }

    public static final /* synthetic */ void access$setCurrentCountDownTime$p(KtvSingChallengeViewModel r0, long r1) {
        r0.currentCountDownTime = r1;
    }

    public static final /* synthetic */ void access$setCurrentSongIsChallenging$p(KtvSingChallengeViewModel r0, boolean r1) {
        r0.currentSongIsChallenging = r1;
    }

    public static final /* synthetic */ void access$setOpenSource$p(KtvSingChallengeViewModel r0, String r1) {
        r0.openSource = r1;
    }

    public static final /* synthetic */ void access$setPendingChallengeId$p(KtvSingChallengeViewModel r0, long r1) {
        r0.pendingChallengeId = r1;
    }

    public static final /* synthetic */ void access$setRecordStartTime$p(KtvSingChallengeViewModel r0, long r1) {
        r0.recordStartTime = r1;
    }

    public static final /* synthetic */ String access$transSourceToPlayMode(KtvSingChallengeViewModel r0, String r1) {
        return r0.transSourceToPlayMode(r1);
    }

    private final void applyNewConfigWhenMessageStartIfNeed(long r6, long r8) {
        boolean r0 = isCurrentUserIsSinger();
        ALogger.i(TAG, "applyConfigIfNeed, isCurrentUserIsSinger=" + r0 + ", isAnchor=" + isAnchor() + ", oldDuration=" + r6 + ", oldScore=" + r8);
        if (r6 > 0) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r0 == false) goto L29;
        if (r7 == false) goto L30;
        KtvRoomLyricsStateMachineConfig.d r9 = getCurrentSingStatus();
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L14;
        r9 = null;
    L14:
        KtvRoomLyricsStateMachineConfig.d.f r10 = (KtvRoomLyricsStateMachineConfig.d.f) r9;
        if (r10 == null) goto L19;
        KtvRoomLyricsStateMachineConfig.c r11 = r10.d;
        if (r11 == null) goto L19;
        long r12 = r11.a;
    L20:
        ALogger.i(TAG, "applyConfigIfNeed, musicProgress=" + r12);
        if (r12 <= 0) goto L26;
        long r13 = r12 / 1000;
        long r14 = this.challengeConfig.d;
        if ((r14 - r13) <= 0) goto L25;
        long r15 = r14 - r13;
    L27:
        start(0, r15);
        return;
    L25:
        r15 = 0;
        goto L27
    L26:
        r15 = this.challengeConfig.d;
    L19:
        r12 = 0;
        goto L20
    L30:
        return;
    L29:
        return;
    L5:
        if (r8 <= 0) goto L8;
        r7 = false;
        goto L9
    }

    private final void config(long r3, long r5) {
        ALogger.i(TAG, "update config, target：" + r3 + ", duration:" + r5);
        me2.a r0 = this.challengeConfig;
        r0.c = r3;
        r0.d = r5;
    }

    private final void getKtvChallengeSettingPanelData(boolean r11, String r12) {
        long r6 = System.currentTimeMillis();
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L11;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L12;
        long r3 = r2.getRoomId();
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getSingingChallengeOptionParams(r3).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this, r6, r11, r12), new g(r6)), this.compositeDispose);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void logSuccessOrFailure(int r24, MusicPanel r25) {
        KtvRoomLyricsStateMachineConfig.d r1 = getCurrentSingStatus();
        if (r1 == null) goto L6;
        MusicPanel r2 = r1.b();
        if (r2 == null) goto L6;
    L7:
        IRoom r3 = com.bytedance.android.live.ktv.common.util.a.c();
        if (r2 == null) goto L32;
        KtvMusic r4 = r2.a;
        String r5 = "";
        if (r4 == null) goto L17;
        OrderInfo r6 = r4.getOrderInfo();
        if (r6 == null) goto L17;
        InteractiveSongUserInfo r7 = r6.getTopUser();
        if (r7 == null) goto L17;
        String r8 = r7.getIdString();
        if (r8 == null) goto L17;
    L18:
        String r9 = getChallengeUserType(r8);
        Long r10 = KtvLoggerHelper.a;
        String r11 = r3.getOwnerUserIdString();
        long r12 = r3.getRoomId();
        String r13 = com.bytedance.android.live.ktv.common.util.j.c();
        String r14 = getUserType();
        Long r15 = this.currentScore;
        if (r15 == null) goto L21;
        long r16 = r15.longValue();
    L22:
        long r17 = r2.a.getMId();
        String r18 = r2.a.getMTitle();
        if (r18 == null) goto L26;
        r5 = r18;
    L26:
        long r19 = getConfig().c;
        Long r20 = this.currentScore;
        if (r20 == null) goto L29;
        long r110 = r20.longValue();
    L30:
        long r0 = getConfig().a;
        Intrinsics.checkNotNullParameter(r11, "anchorId");
        Intrinsics.checkNotNullParameter(r13, "functionType");
        Intrinsics.checkNotNullParameter(r14, "user_type");
        Intrinsics.checkNotNullParameter(r8, "to_user_id");
        Intrinsics.checkNotNullParameter(r9, "to_user_type");
        Intrinsics.checkNotNullParameter(r5, "song_name");
        HashMap r111 = new HashMap();
        r111.put("anchor_id", r11.toString());
        r111.put("room_id", String.valueOf(r12));
        KtvLoggerHelper.A(r111);
        r111.put("live_type", KtvLoggerHelper.F());
        r111.put("user_type", r14);
        r111.put("to_user_id", r8);
        r111.put("to_user_type", r9);
        r111.put("song_id", String.valueOf(r17));
        r111.put("if_success", String.valueOf(r24));
        r111.put("gift_num", String.valueOf(r16));
        r111.put("song_name", r5);
        r111.put("goal", String.valueOf(r19));
        r111.put("current_score", String.valueOf(r110));
        r111.put("challenge_id", String.valueOf(r0));
        j0.l().sendLog("livesdk_ktv_sing_challenge_result_show", r111, new Object[0]);
        return;
    L29:
        r110 = 0;
        goto L30
    L21:
        r16 = 0;
    L17:
        r8 = "";
        goto L18
    L32:
        return;
    L6:
        r2 = r25;
        goto L7
    }

    private final void saveSelectedScoreAndDuration(long r2, long r4) {
        KtvContext.Companion.getClass();
        KtvContext.a.g().setTargetScoreSelected(Long.valueOf(r2));
        KtvContext.a.g().setTargetDurationSelected(Long.valueOf(r4));
    }

    private final void singingChallengeConfigChanged(me2.b r15, Function0<Unit> r16) {
        singingChallengeConfigChanged(r15.c, r15.a, r15.b, r15.d, r15.e, r15.f, r15.g, r15.h, r15.i, r16);
    }

    private final void start(long r11, long r13) {
        this.isChallengeHasBeenStart = true;
        this.isChallengeSuccess = false;
        this.challengeConfig.e = -1;
        this.isChallenging = true;
        KtvRoomLyricsStateMachineConfig.d r0 = getCurrentSingStatus();
        if (r0 == null) goto L5;
        MusicPanel r1 = r0.b();
    L6:
        KtvMusic.a r3 = KtvMusic.Companion;
        if (r1 == null) goto L9;
        KtvMusic r4 = r1.a;
    L10:
        r3.getClass();
        long r5 = KtvMusic.a.a(r4);
        if (r5 != 0) goto L13;
    L15:
        long r6 = r13;
    L16:
        ALogger.i(TAG, "start: currentScore=" + r11 + ", countDownSecond=" + r13 + ", songStatus=" + getCurrentSingStatus() + ", realCountDownSecond=" + r6);
        KtvContext.Companion.getClass();
        MusicPanel r14 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        if (r14 == null) goto L19;
        me2.a r15 = this.challengeConfig;
        r14.a.getMTitle();
        r15.getClass();
    L19:
        if (r1 == null) goto L21;
        KtvMusic r16 = r1.a;
    L22:
        boolean r17 = supportMidiChallenge(r16);
        if (isAnchor() == false) goto L26;
        if (r17 == false) goto L26;
        notifyServerToStart();
    L26:
        if (r17 == false) goto L28;
    L34:
        if (r17 == false) goto L37;
        startCountDown(r6);
    L37:
        if (r11 >= this.challengeConfig.c) goto L39;
        return;
    L39:
        if (r11 <= 0) goto L43;
        ALogger.i(TAG, "start success, state=" + ((com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.f) this.statusMachine.b()));
        this.statusMachine.d(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c.f(r11, this.challengeConfig.c), null);
        return;
    L43:
        return;
    L28:
        if (isAnchor() == false) goto L30;
    L33:
        f2.b(2131918270, 0);
        goto L34
    L30:
        if (com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt.d() == true) goto L33;
        if (isCurrentUserIsSinger() == false) goto L34;
    L21:
        r16 = null;
        goto L22
    L13:
        if (r13 <= r5) goto L15;
        ALogger.i(TAG, "start:musicDuration=" + r5);
        r6 = r5 - (this.challengeConfig.d - r13);
        goto L16
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a
    public void openChallenge(String r20, Context r21) {
        KtvChallengeProperty r2 = ktvChallengeLocalConfig();
        long r4 = r2.getChallengeDuration();
        long r6 = r2.getChallengeTarget();
        com.bytedance.android.livesdk.chatroom.o r3 = o3.f();
        if (r3 == null) goto L8;
        com.bytedance.live.datacontext.j r5 = r3.s2();
        if (r5 == null) goto L8;
        z0 r7 = (z0) r5.getValue();
    L8:
        if (isAudioKtv() == false) goto L20;
        com.bytedance.android.livesdk.chatroom.u r8 = o3.d();
        if (r8 == null) goto L19;
        com.bytedance.live.datacontext.j r9 = r8.s();
        if (r9 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r10 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r9.getValue();
        if (r10 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r11 = r10.t();
        if (r11 == null) goto L19;
        if (r11.a == 5) goto L20;
    L19:
        boolean r12 = true;
    L21:
        ALogger.i(TAG, "auto openChallenge, score: " + r6 + ", duration: " + r4 + ", source: " + r20);
        if (r6 > 0) goto L24;
    L28:
        if (r21 == null) goto L43;
        int r13 = ne2.a.a;
        if (r20 != null) goto L32;
        String r14 = "convenient_page";
    L33:
        ne2.a.e(r21, r14);
        if (r12 == true) goto L44;
        KtvComponentContext r1 = KtvComponentContext.Companion.getContext();
        if (r1 == null) goto L45;
        com.bytedance.live.datacontext.n<fd2.x> r15 = r1.getKtvComponentCmd();
        if (r15 == null) goto L46;
        r15.setValue(new fd2.x(1, Boolean.TRUE, "interaction_button", null, Boolean.FALSE, "interact", null, null, 200));
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L32:
        r14 = r20;
        goto L33
    L43:
        return;
    L24:
        if (r4 <= 0) goto L28;
        if (r12 == false) goto L27;
        openChallenge(new me2.b(r6, r4, ChallengeChangeType.AUTO_TURN_ON, SwitchStatus.OPEN.getValue(), null, r20, r2.getChallengeType(), 384));
        return;
    L27:
        singingChallengeConfigChanged(new me2.b(r6, r4, ChallengeChangeType.AUTO_TURN_ON, SwitchStatus.OPEN.getValue(), null, r20, r2.getChallengeType(), 384), C02371.INSTANCE);
        return;
    L20:
        r12 = false;
        goto L21
    }

    public static final /* synthetic */ void access$config(KtvSingChallengeViewModel r0, long r1, long r3) {
        r0.config(r1, r3);
    }

    private final void challengeFailure(MusicPanel r2, boolean r3, boolean r4) {
        ALogger.i(TAG, "challengeFailure: songStatus=" + getCurrentSingStatus());
        checkCountdown();
        if (isCurrentUserIsSinger() == false) goto L6;
        if (r4 == false) goto L6;
        f2.b(2131918235, 0);
    L6:
        logSuccessOrFailure(0, r2);
        if (isCurrentUserIsSinger() == false) goto L16;
        if (r2 != null) goto L16;
        KtvContext.Companion.getClass();
        KtvContext r5 = KtvContext.a.g();
        if (r5 == null) goto L16;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r6 = r5.getKtvSingerViewModel();
        if (r6 == null) goto L16;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r7 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r6.getValue();
        if (r7 == null) goto L16;
        r7.cutFromChallenge(null);
    L16:
        KtvContext.Companion.getClass();
        if (KtvContext.a.l() == false) goto L19;
        long r8 = SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS;
    L20:
        RxUtilKt.c(Observable.timer(r8, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r4)), this.compositeDispose);
        return;
    L19:
        r8 = CHALLENGE_RESULT_SHOW_DURATION;
        goto L20
    }

    private final void trySaveLocalConfig(Long r10, Long r11, int r12, boolean r13) {
        if (isAnchor() == false) goto L27;
        KtvChallengeProperty r0 = ktvChallengeLocalConfig();
        boolean r2 = true;
        if (r10 != null) goto L7;
    L15:
        if (r11 != null) goto L17;
    L25:
        r0.setChallengeType(r12);
        r0.setChallengeStatus(r13);
        com.bytedance.android.livesdk.sharedpref.e r14 = com.bytedance.android.livesdk.sharedpref.c.n0;
        r14.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r14, r0);
        return;
    L17:
        if (r11.longValue() > 0) goto L20;
        r2 = false;
    L20:
        if (r2 == true) goto L23;
        r11 = null;
    L23:
        if (r11 == null) goto L25;
        r0.setChallengeTarget(r11.longValue());
        goto L25
    L7:
        if (r10.longValue() <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L13;
        r10 = null;
    L13:
        if (r10 == null) goto L15;
        r0.setChallengeDuration(r10.longValue());
        goto L15
    L9:
        r6 = false;
        goto L10
    }

    public static final /* synthetic */ void access$trySaveLocalConfig(KtvSingChallengeViewModel r0, Long r1, Long r2, int r3, boolean r4) {
        r0.trySaveLocalConfig(r1, r2, r3, r4);
    }

    public static /* synthetic */ void getKtvChallengeSettingPanelData$default(KtvSingChallengeViewModel r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        r0.getKtvChallengeSettingPanelData(r1, r2);
    }

    public static /* synthetic */ void logSuccessOrFailure$default(KtvSingChallengeViewModel r0, int r1, MusicPanel r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.logSuccessOrFailure(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void singingChallengeConfigChanged$default(KtvSingChallengeViewModel r0, me2.b r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.singingChallengeConfigChanged(r1, r2);
    }

    private final void singingChallengeConfigChanged(ChallengeChangeType r32, long r33, long r35, long r37, String r39, String r40, int r41, boolean r42, CloseChallengeType r43, Function0<Unit> r44) {
        ChallengeChangeType r0 = ChallengeChangeType.SWITCH_TURN_OFF;
        if (r32 == r0) goto L6;
        saveSelectedScoreAndDuration(r33, r35);
    L6:
        if (r33 > 0) goto L8;
    L9:
        if (r32 == r0) goto L12;
        ALogger.e(TAG, "singingChallengeConfigChanged param error , score : " + r33 + " , duration : " + r35 + ' ');
        return;
    L12:
        ALogger.i(TAG, "singingChallengeConfigChanged : duration == " + r35 + ", score == " + r33 + " , changeType: " + r32.getValue() + ", challengeType: " + r41);
        IRoom r1 = com.bytedance.android.live.ktv.common.util.a.c();
        long r13 = System.currentTimeMillis();
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).singingChallengeConfigChangedNotice(r1.getRoomId(), r32.getValue(), r37, r33, r35, r41).compose(RxUtil.rxSchedulerHelper()).subscribe(new u(this, r13, r32, r35, r41, r37, r1, r33, r40, r44, r43, r39, r42), new v(r43, r13)), this.compositeDispose);
        return;
    L8:
        if (r35 > 0) goto L12;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void singingChallengeConfigChanged$default(KtvSingChallengeViewModel r17, ChallengeChangeType r18, long r19, long r21, long r23, String r25, String r26, int r27, boolean r28, CloseChallengeType r29, Function0 r30, int r31, Object r32) {
        if ((r31 & 16) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r31 & 32) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r31 & 64) == 0) goto L13;
        int r13 = KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue();
    L15:
        if ((r31 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L17;
        boolean r14 = true;
    L19:
        if ((r31 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L21;
        CloseChallengeType r15 = CloseChallengeType.UNKNOWN;
    L23:
        if ((r31 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L25;
        Function0 r16 = null;
    L26:
        r17.singingChallengeConfigChanged(r18, r19, r21, r23, r11, r12, r13, r14, r15, r16);
        return;
    L25:
        r16 = r30;
        goto L26
    L21:
        r15 = r29;
        goto L23
    L17:
        r14 = r28;
        goto L19
    L13:
        r13 = r27;
        goto L15
    L9:
        r12 = r26;
        goto L11
    L5:
        r11 = r25;
        goto L7
    }
}
