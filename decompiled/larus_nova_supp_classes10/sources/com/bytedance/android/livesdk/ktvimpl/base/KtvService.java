package com.bytedance.android.livesdk.ktvimpl.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.IComponentManager;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.soundeffect.SoundRepelContext;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.ordersong.feedback.KtvFeedbackDialog;
import com.bytedance.android.live.ktv.common.speech.CoverSpeechRecognizer;
import com.bytedance.android.live.ktv.common.speech.LinkSpeechRecognizer;
import com.bytedance.android.live.ktv.common.speech.LinkSpeechServerRecognizer;
import com.bytedance.android.live.ktv.common.speech.SpeechRecognizer;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.action.BaseActionMethod;
import com.bytedance.android.livesdk.action.instance.KtvOrderPannalAction;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.ui.AbsInteractionFragment;
import com.bytedance.android.livesdk.chatroom.ui.MiddleAbsInteractionFragment;
import com.bytedance.android.livesdk.chatroom.ui.c5;
import com.bytedance.android.livesdk.chatroom.ui.d5;
import com.bytedance.android.livesdk.chatroom.ui.e5;
import com.bytedance.android.livesdk.chatroom.ui.f5;
import com.bytedance.android.livesdk.chatroom.ui.g5;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.u70;
import com.bytedance.android.livesdk.ktvapi.AbsKtvControlWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import com.bytedance.android.livesdk.ktvapi.KtvRoomUserLabel;
import com.bytedance.android.livesdk.ktvapi.config.ScrollLyricConfigV2;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.lyricmodule.ScrollLyricService;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.view.KtvGroupListDialogFragment;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.ConcertStageDataContext;
import com.bytedance.android.livesdk.ktvimpl.crossplatform.KtvJsbDataContext;
import com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.KtvEarMonitor;
import com.bytedance.android.livesdk.ktvimpl.feed.KtvRoomFeedContainer;
import com.bytedance.android.livesdk.ktvimpl.feed.RealTimeChorusFeedContainer;
import com.bytedance.android.livesdk.ktvimpl.ksong.base.view.KtvComponentFeedView;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.card.KtvRoomCardWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvGroupViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvRoomAnchorWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvRoomGuestWidget;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.RealTimeChorusAnchorWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.ConcertWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.RealTimeChorusGuestWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.ChorusJsbDataContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.ChorusJsbService;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.pcChorus.PcAudioChorusWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusDataContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusFeedWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusWidget;
import com.bytedance.android.livesdk.ktvimpl.speech.LyricsRecognitionContext;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.message.linker.LinkmicInfoWithRtcInfoData;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.kh;
import com.bytedance.android.livesdk.message.model.za;
import com.bytedance.android.livesdk.widgetdescriptor.w;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfoKt;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedViewService;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import fd2.r;
import fd2.s;
import fd2.v;
import fd2.x;
import fd2.y;
import fd2.z;
import hh1.w0;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000®\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u0000 ø\u00022\u00020\u0001:\u0002ù\u0002B\t¢\u0006\u0006\b÷\u0002\u0010Ù\u0002J$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\u0010\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016J\u001a\u0010%\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u0006H\u0016J\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020\u001dH\u0016J\u001a\u0010-\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020\rH\u0016J*\u00101\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00152\b\u00100\u001a\u0004\u0018\u00010\rH\u0016JM\u0010:\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062#\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001d\u0018\u000106H\u0016J(\u0010?\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\rH\u0016J8\u0010C\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u00152\u0006\u0010A\u001a\u00020@2\u0006\u0010>\u001a\u00020\r2\u0006\u0010B\u001a\u00020\rH\u0016J*\u0010G\u001a\u00020\u001d2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010D2\u0006\u0010F\u001a\u00020\u00062\b\u0010>\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010H\u001a\u00020\u001dH\u0016J(\u0010N\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\r2\u0006\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020\u0015H\u0016J\u0018\u0010Q\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020\rH\u0016J\u0012\u0010S\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u00010RH\u0016J\u0010\u0010V\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020TH\u0016J\u0018\u0010Y\u001a\u00020\u001d2\u0006\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020IH\u0016J\u0012\u0010\\\u001a\u00020\u001d2\b\u0010[\u001a\u0004\u0018\u00010ZH\u0016J\u0018\u0010_\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020^H\u0016J\u0010\u0010b\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010`H\u0016J4\u0010f\u001a.\u0012\u0004\u0012\u00020\r\u0012\"\u0012 \u0012\u0004\u0012\u00020\r\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0e0d0d\u0018\u00010cH\u0016J\n\u0010g\u001a\u0004\u0018\u00010TH\u0016J\n\u0010i\u001a\u0004\u0018\u00010hH\u0016J\n\u0010j\u001a\u0004\u0018\u00010TH\u0016J\b\u0010k\u001a\u00020\u0015H\u0016J\u0010\u0010n\u001a\u00020\u001d2\u0006\u0010m\u001a\u00020lH\u0016J\n\u0010o\u001a\u0004\u0018\u00010TH\u0016J\u001e\u0010s\u001a\u0004\u0018\u00010r2\b\u0010q\u001a\u0004\u0018\u00010p2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010v\u001a\n\u0012\u0004\u0012\u00020u\u0018\u00010tH\u0016J\u0010\u0010y\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020wH\u0016J\u0016\u0010|\u001a\u00020\u001d2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020z0`H\u0016J-\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00012\b\u0010~\u001a\u0004\u0018\u00010}2\u0006\u0010\u007f\u001a\u00020\u00062\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060DH\u0016J\t\u0010\u0083\u0001\u001a\u00020\u0006H\u0016J\u001f\u0010\u0086\u0001\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010*2\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016J\u0019\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u0088\u00010`2\u0007\u0010\u0087\u0001\u001a\u00020\rH\u0016J\u001f\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00012\b\u0010+\u001a\u0004\u0018\u00010*2\u0007\u0010\u008a\u0001\u001a\u00020\u0015H\u0016J(\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u00012\b\u0010+\u001a\u0004\u0018\u00010*2\u0007\u0010\u008d\u0001\u001a\u00020\u00062\u0007\u0010\u008a\u0001\u001a\u00020\u0015H\u0016J2\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u00012\b\u0010\u0090\u0001\u001a\u00030\u008f\u00012\b\u0010+\u001a\u0004\u0018\u00010*2\u0007\u0010\u008d\u0001\u001a\u00020\u00062\u0007\u0010\u008a\u0001\u001a\u00020\u0015H\u0016J\f\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0016J\u0012\u0010\u0093\u0001\u001a\u00020\u00152\u0007\u0010\u008d\u0001\u001a\u00020\u0006H\u0016J\u001f\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00012\b\u0010+\u001a\u0004\u0018\u00010*2\u0007\u0010\u008d\u0001\u001a\u00020\u0006H\u0016J\u0014\u0010\u0097\u0001\u001a\u00030\u0096\u00012\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001H\u0016J\u0013\u0010\u009a\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u0098\u0001\u001a\u00020\rH\u0016J\u0010\u0010\u009c\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u009b\u0001H\u0016J\u0013\u0010\u009e\u0001\u001a\f\u0012\u0005\u0012\u00030\u009d\u0001\u0018\u00010\u009b\u0001H\u0016J\f\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0016J\u0010\u0010¡\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u009b\u0001H\u0016J\u0010\u0010¢\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u009b\u0001H\u0016J\u0010\u0010£\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u009b\u0001H\u0016J\u0012\u0010¥\u0001\u001a\u00020\u00062\u0007\u0010¤\u0001\u001a\u00020\u0015H\u0016J\f\u0010§\u0001\u001a\u0005\u0018\u00010¦\u0001H\u0016J\t\u0010¨\u0001\u001a\u00020\u0006H\u0016J\t\u0010©\u0001\u001a\u00020\u0006H\u0016J\t\u0010ª\u0001\u001a\u00020\u0006H\u0016J\t\u0010«\u0001\u001a\u00020\u0006H\u0016J\u001b\u0010¬\u0001\u001a\u0005\u0018\u00010\u0081\u00012\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060DH\u0016J\t\u0010\u00ad\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010¯\u0001\u001a\u00020\u001d2\u0007\u0010®\u0001\u001a\u00020\u0006H\u0016J\t\u0010°\u0001\u001a\u00020\u0006H\u0016J\u0018\u0010³\u0001\u001a\u0005\u0018\u00010±\u00012\n\u0010²\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016J\u0016\u0010´\u0001\u001a\u0005\u0018\u00010±\u00012\b\u0010²\u0001\u001a\u00030±\u0001H\u0016J*\u0010¸\u0001\u001a\u0005\u0018\u00010·\u00012\u0006\u0010+\u001a\u00020*2\b\u0010\u0085\u0001\u001a\u00030\u0084\u00012\n\u0010¶\u0001\u001a\u0005\u0018\u00010µ\u0001H\u0016J!\u0010º\u0001\u001a\u0005\u0018\u00010±\u00012\n\u0010²\u0001\u001a\u0005\u0018\u00010±\u00012\u0007\u0010¹\u0001\u001a\u00020\u0006H\u0016J\u001f\u0010»\u0001\u001a\u0005\u0018\u00010±\u00012\b\u0010²\u0001\u001a\u00030±\u00012\u0007\u0010¹\u0001\u001a\u00020\u0006H\u0016J\t\u0010¼\u0001\u001a\u00020\u0006H\u0016J\u001b\u0010¾\u0001\u001a\u00020\u001d2\u0010\u0010½\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0088\u0001\u0018\u00010eH\u0016J\t\u0010¿\u0001\u001a\u00020\u0006H\u0016J\t\u0010À\u0001\u001a\u00020\u0006H\u0016J\t\u0010Á\u0001\u001a\u00020\u001dH\u0016J+\u0010Ä\u0001\u001a$\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010Â\u0001j\u0011\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u0001`Ã\u0001H\u0016J\u0013\u0010Æ\u0001\u001a\u00030Å\u00012\u0007\u0010,\u001a\u00030Å\u0001H\u0016J\t\u0010Ç\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010È\u0001\u001a\u00020\u00062\u0007\u0010,\u001a\u00030Å\u0001H\u0016J\u0012\u0010Ê\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0015\u0018\u00010É\u0001H\u0016J\u001d\u0010Í\u0001\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0007\u0012\u0005\u0018\u00010Ì\u0001\u0018\u00010Ë\u0001H\u0016J\u001d\u0010Î\u0001\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0007\u0012\u0005\u0018\u00010Ì\u0001\u0018\u00010Ë\u0001H\u0016J\u001d\u0010Ñ\u0001\u001a\u00020\u001d2\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\b\u0010Ð\u0001\u001a\u00030Ï\u0001H\u0016J\u0012\u0010Ó\u0001\u001a\u00020\u001d2\u0007\u0010Ò\u0001\u001a\u00020\rH\u0016J\u0014\u0010Õ\u0001\u001a\u00020\u001d2\t\u0010Ô\u0001\u001a\u0004\u0018\u00010TH\u0016J\u0013\u0010Ö\u0001\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010TH\u0016J*\u0010Ü\u0001\u001a\u0005\u0018\u00010Û\u00012\u0007\u0010×\u0001\u001a\u00020\r2\n\u0010Ù\u0001\u001a\u0005\u0018\u00010Ø\u00012\u0007\u0010Ú\u0001\u001a\u00020\u0006H\u0016J\u001c\u0010Ý\u0001\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020I2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\rH\u0016J\u0011\u0010Þ\u0001\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020*H\u0016J\u0015\u0010ß\u0001\u001a\u00020\u00062\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016J\t\u0010à\u0001\u001a\u00020\u0006H\u0016J\t\u0010á\u0001\u001a\u00020\u0006H\u0016J\t\u0010â\u0001\u001a\u00020\u001dH\u0016J\u001e\u0010ã\u0001\u001a\u00020\u001d2\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\r2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010å\u0001\u001a\u00020\u001d2\u0007\u0010ä\u0001\u001a\u00020IH\u0016J\u001a\u0010ç\u0001\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020*2\u0007\u0010æ\u0001\u001a\u00020\rH\u0016J\n\u0010é\u0001\u001a\u00030è\u0001H\u0016J\u001c\u0010í\u0001\u001a\f\u0012\u0005\u0012\u00030ì\u0001\u0018\u00010ë\u00012\u0007\u0010ê\u0001\u001a\u00020\rH\u0016J\n\u0010ï\u0001\u001a\u00030î\u0001H\u0016J\u0011\u0010ð\u0001\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020IH\u0016J\u0012\u0010ò\u0001\u001a\u00020\u001d2\u0007\u0010ñ\u0001\u001a\u00020\u0006H\u0016J\f\u0010ô\u0001\u001a\u0005\u0018\u00010ó\u0001H\u0016J1\u0010ù\u0001\u001a\u000b\u0012\u0004\u0012\u00028\u0000\u0018\u00010ø\u0001\"\u0005\b\u0000\u0010õ\u00012\u0006\u0010+\u001a\u00020*2\u000e\u0010÷\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000ö\u0001H\u0016J\f\u0010û\u0001\u001a\u0005\u0018\u00010ú\u0001H\u0016J\u0012\u0010ü\u0001\u001a\u00020\u001d2\u0007\u0010ñ\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010ý\u0001\u001a\u00020\u001d2\u0007\u0010ñ\u0001\u001a\u00020\u0006H\u0016J)\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0081\u00022\u0006\u0010+\u001a\u00020*2\u0007\u0010þ\u0001\u001a\u00020\u00152\n\u0010\u0080\u0002\u001a\u0005\u0018\u00010ÿ\u0001H\u0016J\u001c\u0010\u0086\u0002\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\b0\u0085\u00022\b\u0010\u0084\u0002\u001a\u00030\u0083\u0002H\u0016J\t\u0010\u0087\u0002\u001a\u00020\u0006H\u0016J4\u0010\u008a\u0002\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010*2\t\u0010\u0088\u0002\u001a\u0004\u0018\u00010\r2\t\u0010\u0089\u0002\u001a\u0004\u0018\u00010\r2\t\u0010×\u0001\u001a\u0004\u0018\u00010\rH\u0016J-\u0010\u008e\u0002\u001a\u00020\u001d2\u0007\u0010×\u0001\u001a\u00020\r2\u0007\u0010\u008b\u0002\u001a\u00020\r2\u0007\u0010\u008c\u0002\u001a\u00020\r2\u0007\u0010\u008d\u0002\u001a\u00020\rH\u0016J-\u0010\u008f\u0002\u001a\u00020\u001d2\u0007\u0010×\u0001\u001a\u00020\r2\u0007\u0010\u008b\u0002\u001a\u00020\r2\u0007\u0010\u008c\u0002\u001a\u00020\r2\u0007\u0010\u008d\u0002\u001a\u00020\rH\u0016J\t\u0010\u0090\u0002\u001a\u00020\u0006H\u0016J\u0013\u0010\u0093\u0002\u001a\u00020\u001d2\b\u0010\u0092\u0002\u001a\u00030\u0091\u0002H\u0016J\u0015\u0010\u0093\u0002\u001a\u00020\u001d2\n\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0094\u0002H\u0016J\u0012\u0010\u0095\u0002\u001a\u00020\u001d2\u0007\u0010\u0087\u0001\u001a\u00020\rH\u0016J)\u0010\u0099\u0002\u001a\u00020\u001d2\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0096\u00022\t\u0010\u0098\u0002\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0006\b\u0099\u0002\u0010\u009a\u0002J\t\u0010\u009b\u0002\u001a\u00020\u0006H\u0016J\u0015\u0010\u009e\u0002\u001a\u0005\u0018\u00010\u009d\u00022\t\b\u0002\u0010\u009c\u0002\u001a\u00020\u0006J\u0012\u0010\u009f\u0002\u001a\u00020\u00062\u0007\u0010\u0087\u0001\u001a\u00020\rH\u0016J\f\u0010¡\u0002\u001a\u0005\u0018\u00010 \u0002H\u0016J\f\u0010£\u0002\u001a\u0005\u0018\u00010¢\u0002H\u0016J'\u0010¦\u0002\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020*2\b\u0010¥\u0002\u001a\u00030¤\u00022\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016J\f\u0010¨\u0002\u001a\u0005\u0018\u00010§\u0002H\u0016J\t\u0010©\u0002\u001a\u00020\u001dH\u0016J\u0012\u0010«\u0002\u001a\u00020\u001d2\u0007\u0010ª\u0002\u001a\u00020\rH\u0016J\t\u0010¬\u0002\u001a\u00020\rH\u0016J\u0015\u0010¯\u0002\u001a\u0005\u0018\u00010®\u00022\u0007\u0010\u00ad\u0002\u001a\u00020\u0006H\u0016J\f\u0010°\u0002\u001a\u0005\u0018\u00010®\u0002H\u0016J\t\u0010±\u0002\u001a\u00020\u0006H\u0016J\u0013\u0010´\u0002\u001a\u00020\u001d2\b\u0010³\u0002\u001a\u00030²\u0002H\u0016J\t\u0010µ\u0002\u001a\u00020\u0006H\u0016J\u0011\u0010¶\u0002\u001a\u00020\u001d2\u0006\u0010X\u001a\u00020\u0015H\u0016JU\u0010¼\u0002\u001a\u00030\u0094\u00022\t\u0010·\u0002\u001a\u0004\u0018\u00010\u00152\t\u0010¸\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\r2\t\u0010¹\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010º\u0002\u001a\u0004\u0018\u00010\r2\t\u0010»\u0002\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0006\b¼\u0002\u0010½\u0002JX\u0010Ç\u0002\u001a\u00020\u001d2\u0007\u0010¾\u0002\u001a\u00020\u00062\u000e\u0010À\u0002\u001a\t\u0012\u0005\u0012\u00030¿\u00020e2\n\u0010Â\u0002\u001a\u0005\u0018\u00010Á\u00022\u0007\u0010Ã\u0002\u001a\u00020I2\u0017\u0010Æ\u0002\u001a\u0012\u0012\u0004\u0012\u00020I\u0012\u0005\u0012\u00030Å\u0002\u0018\u00010Ä\u00022\u0006\u00100\u001a\u00020\rH\u0016J\u0015\u0010Ê\u0002\u001a\u00020\u001d2\n\u0010É\u0002\u001a\u0005\u0018\u00010È\u0002H\u0016Jc\u0010Í\u0002\u001a\u0005\u0018\u00010\u0091\u00022\t\u0010·\u0002\u001a\u0004\u0018\u00010\u00152\t\u0010¸\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\r2\n\u0010Ì\u0002\u001a\u0005\u0018\u00010Ë\u00022\t\u0010¹\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010º\u0002\u001a\u0004\u0018\u00010\r2\t\u0010»\u0002\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0006\bÍ\u0002\u0010Î\u0002J\f\u0010Ð\u0002\u001a\u0005\u0018\u00010Ï\u0002H\u0016J\t\u0010Ñ\u0002\u001a\u00020\u0006H\u0016J\t\u0010Ò\u0002\u001a\u00020\u0006H\u0016R\u0019\u0010ª\u0002\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0002\u0010Ó\u0002R+\u0010Ö\u0002\u001a\f\u0012\u0005\u0012\u00030Õ\u0002\u0018\u00010Ô\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0010\n\u0006\bÖ\u0002\u0010×\u0002\u0012\u0006\bØ\u0002\u0010Ù\u0002R+\u0010Û\u0002\u001a\f\u0012\u0005\u0012\u00030Ú\u0002\u0018\u00010Ô\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0010\n\u0006\bÛ\u0002\u0010×\u0002\u0012\u0006\bÜ\u0002\u0010Ù\u0002R \u0010à\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010Ý\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bÞ\u0002\u0010ß\u0002R \u0010ä\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0015\u0018\u00010á\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bâ\u0002\u0010ã\u0002R\u0019\u0010ç\u0002\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\b\u001a\u0006\bå\u0002\u0010æ\u0002R\u0017\u0010é\u0002\u001a\u00020\r8VX\u0096\u0004¢\u0006\b\u001a\u0006\bè\u0002\u0010æ\u0002R!\u0010ì\u0002\u001a\f\u0012\u0005\u0012\u00030\u0088\u0001\u0018\u00010É\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bê\u0002\u0010ë\u0002R!\u0010ï\u0002\u001a\f\u0012\u0005\u0012\u00030í\u0002\u0018\u00010á\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bî\u0002\u0010ã\u0002R \u0010ñ\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010Ý\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bð\u0002\u0010ß\u0002R \u0010ò\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010Ý\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bò\u0002\u0010ß\u0002R\u001e\u0010ô\u0002\u001a\t\u0012\u0004\u0012\u00020\u00150Ý\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bó\u0002\u0010ß\u0002R\u0017\u0010ö\u0002\u001a\u00020\r8VX\u0096\u0004¢\u0006\b\u001a\u0006\bõ\u0002\u0010æ\u0002¨\u0006ú\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/KtvService;", "Lcom/bytedance/android/livesdk/ktvapi/IKtvService;", "Lcom/bytedance/android/live/pushstream/d;", "liveStream", "Lhh1/w0;", "callback", "", "isFromRadio", "Lcom/bytedance/ies/sdk/widgets/Widget;", "createKtvRoomAnchorWidget", "createKtvRoomGuestWidget", "createConcertWidget", "createPcAudioWidget", "", "enterFrom", "Lfd2/g;", "createConcertFeedWidget", "createVideoChorusWidget", "createVideoChorusFeedWidget", "createRealTimeChorusRoomAnchorWidget", "createRealTimeChorusRoomGuestWidget", "", "scene", "Lcom/bytedance/android/livesdk/message/linker/h;", "infoData", "continueAnchorLinkMic", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerChangeMediaInfoContent;", LocationMonitorConst.INFO, "lastAudioBitRate", "", "onChangeMediaInfo", "Lcom/bytedance/android/live/liveinteract/plantform/base/i;", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "getLinkUserInfoCenter", "Ljava/lang/Runnable;", "runnable", "skippingToOtherRoom", "interceptCloseRoom", "isAddSong", "Ltf0/q;", "showLinkFollowDialog", "finishAudioTalk", "Landroid/content/Context;", "context", "toScene", "switchVoiceSceneWithCheck", "fromScene", "toUILayout", "reason", "switchScene", "disconnectSource", "needSureAgain", "needToastWhenSuccess", "needShowLinkResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "disconnect", "position", "applySource", "applyType", "fromSource", "checkAndApply", "Lcom/bytedance/android/live/liveinteract/api/chatroom/model/LinkMatchType;", "matchType", "taskName", "checkMatchAndApply", "Lio/reactivex/functions/Consumer;", "consumer", "needShowSuccessToast", "cancelApply", "tryAutoFastMatch", "", "roomId", "secToUserId", "toUserIdString", "replyType", "checkAndReply", "id", "secUid", "accept", "Luf0/d;", "setPermitCallback", "", "params", "invite", "toUsers", "status", "updateRealtimeChorusGuestStatus", "Luf0/c;", "inviteCallback", "setInviteCallback", "sei", "Lye1/a;", "onSei", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/s0;", "getHeadPointList", "Lkotlin/Pair;", "", "", "getRoomWrdsListenerData", "getRealTimeChorusMicManager", "Lfd2/w;", "getVideoChorusService", "getInteractAnimationService", "getSelfSilenceType", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "targetUser", "kickOut", "muteManager", "Lcom/bytedance/android/livesdk/ktvapi/AbsKtvControlWidget$a;", "loader", "Lcom/bytedance/android/livesdk/ktvapi/AbsKtvControlWidget;", "getKtvControlWidget", "Lj70/h;", "Ld90/d;", "getKtvAudioRoomWidgetDescriptor", "Lcom/bytedance/android/livesdk/chatroom/ui/g5;", "absInteractionFragment", "loadKtvControlWidget", "Lcom/bytedance/android/livesdk/chatroom/interact/model/y;", "settings", "handleSettingUpdate", "Landroidx/lifecycle/LifecycleOwner;", "owner", "needObserveOnUi", "observer", "Lio/reactivex/disposables/Disposable;", "observerCurrentIsSinger", "isCurrentUserIsSinger", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "openKtvRoomDialog", "uid", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "getKtvRoomCurSelfOrderList", "showFrom", "Lcom/bytedance/android/livesdkapi/feed/IInteractFeedView;", "getRealTimeChorusFeedView", "smallWindow", "getKtvRoomFeedView", "Landroid/view/View;", "inflatedKtvFeedView", "Lcom/bytedance/android/livesdkapi/ktv/IKtvComponentFeedViewService;", "getKtvComponentFeedViewService", "getTtliveViewKtvRoomFeedResId", "Lcom/bytedance/android/livesdkapi/ktv/IKtvComponentFeedView;", "getKtvComponentFeedView", "Landroidx/lifecycle/ViewModel;", "installKtvContext", "userId", "Lcom/bytedance/android/livesdk/ktvapi/KtvRoomUserLabel;", "getUserKtvRoomLabel", "Lcom/bytedance/live/datacontext/k;", "orderedListChangeEvent", "Lfd2/z;", "ktvComponentSingerChangedEvent", "Lcom/bytedance/android/livesdk/message/model/OrderInfo;", "ktvCurrentSingerOrderInfo", "stageChangeToIdleEvent", "ktvStageReadyEvent", "stageChangeToPreparedEvent", BaseCoreViewModel.CORE_TAG_STATE, "isInKtvState", "Lfd2/q;", "prepareMvService", "currentIsMultipleKtvMode", "isInRealTimeChorus", "isAudienceSingEnableSwitchOn", "isMultiChorusEnable", "observeMultiChorusSwitchState", "getKtvComponentLyricsViewShowStatus", "show", "updateKtvComponentLyricsViewShowStatus", "getHideLyricsWhenSubtitleOpenSwitch", "Lcom/google/gson/JsonObject;", "extraData", "handleDynamicJsbGetAction", "handleDynamicJsbUpdateAction", "Lcom/bytedance/android/livesdk/chatroom/widget/j1;", "scoreProvider", "Lfd2/e;", "loadChorusDynamicJsbService", "isFeed", "handleKtvCommonJsbGetAction", "handleKtvCommonJsbUpdateAction", "hasEnterMultiChorusQueue", "ktvMusics", "prepareDownloadSongMaterials", "currentIsMultipleKtvModeV2", "currentIsAudienceSingEnable", "removeKtvComponent", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getGiftReportParam", "Lcom/bytedance/android/livesdk/ktvapi/KtvConflictScene;", "requestConflictCheckForScene", "isEnableMvStage", "requestConflictCheck", "Lcom/bytedance/live/datacontext/n;", "ktvCardState", "Landroid/util/Pair;", "Lcom/bytedance/android/livesdk/log/filter/v;", "provideKtvBizParamInjector", "provideStageModeLogInjector", "Lid2/d;", "ktvMusicSelectedCallBack", "openEffectMusicSelect", "source", "openKsong", "vm", "setKtvCoreViewModel", "setKtvContext", "requestPage", "Lfd2/c;", "listener", "isFeedBackMode", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "getKtvFeedbackDialog", "inviteToKtvGroup", "createKtvGroup", "isMultipleKtvEnable", "inMultipleKtv", "inMultipleKtvOld", "onChallengeIconShow", "openKtvChallenge", "time", "setVoiceKtvSwitchTime", "groupdId", "openKtvGroupUserList", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "provideKtvRoomBehavior", "host", "Lcom/bytedance/android/livesdk/action/BaseActionMethod;", "Ljava/lang/Void;", "providerSchemaActionImpl", "Lfd2/y;", "getKtvRoomInfo", "moveOrderedSongToOtherRoom", "open", "enableAtmosphere", "Lfd2/r;", "getOpusPreviewDialogBuilder", "T", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/j;", "provider", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/e;", "createMvPreviewList", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/m;", "createOpusMvService", "enablePreviewSong", "enableHardwareEcho", "lyricType", "Lcom/bytedance/android/livesdk/ktvapi/config/ScrollLyricConfigV2;", "config", "Lfd2/l;", "createLyricService", "Lcom/bytedance/android/livesdk/ktvapi/AbsKtvControlWidget$WidgetType;", "widgetType", "Ljava/lang/Class;", "getWidgetClassByType", "isKtvChallengeOpened", "queryUserName", "queryUserId", "showHighScoreSongListDialog", "toUserId", "toUserType", "liveType", "logHighScoreSongLabelClick", "logHighScoreSongLabelShow", "isKtvComponentV2Enable", "Lfd2/x;", "cmd", "sendKtvComponentV2Command", "Lfd2/i;", "onPermitSuccess", "", "transY", "rightMargin", "ktvContainerPositionUpdate", "(Ljava/lang/Float;Ljava/lang/Integer;)V", "hasSelfPrivateSong", "isKtvMode", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;", "getOrderedSongDataContext", "isUserSelectMusic", "Lfd2/f;", "getChorusService", "Lgd2/f;", "getConcertStageService", "Landroid/view/ViewGroup;", "parent", "initChorusService", "Lgd2/c;", "getChorusConcertService", "destroyChorusService", "enterRoomType", "saveEnterRoomType", "getEnterRoomType", "isAIMVEnable", "Lfd2/v;", "createSpeechRecognizer", "getLyricsRecognizer", "isKtvComponentOpen", "Ljd2/g;", "model", "enableVideoChorus", "isKtvIsSingingState", "onClickToolbar", "switch", "audienceSingEnable", "showMainDialog", "showMainDialogEnterFrom", "openSource", "createKtvComponentCmd", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lfd2/i;", "isSilence", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "data", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "clientUIInfo", "version", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "linkerContentMap", "switchAudioByClient", "Lcom/bytedance/android/livesdk/link/model/bridge/z0;", "message", "onSwitchSceneMessage", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "createKtvCommand", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/android/livesdk/message/model/MusicPanel;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lfd2/x;", "Ltf0/k;", "getLinkmicReturnRoomParams", "canSilenceSelf", "isEngineOn", "Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/c;", "mRoomWidgetViewModelRef", "Ljava/lang/ref/WeakReference;", "getMRoomWidgetViewModelRef$annotations", "()V", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "mKtvContextRef", "getMKtvContextRef$annotations", "Lcom/bytedance/live/datacontext/m;", "getHasBgm", "()Lcom/bytedance/live/datacontext/m;", "hasBgm", "Lio/reactivex/Observable;", "getKtvAllStateObservable", "()Lio/reactivex/Observable;", "ktvAllStateObservable", "getRecentSongInfo", "()Ljava/lang/String;", "recentSongInfo", "getKtvRoomCurrentSingerIdString", "ktvRoomCurrentSingerIdString", "getCurrentSongOfSelf", "()Lcom/bytedance/live/datacontext/n;", "currentSongOfSelf", "Lfd2/a;", "getMusicPlayProgressObservable", "musicPlayProgressObservable", "getCurrentIsMultipleKtvModeObservable", "currentIsMultipleKtvModeObservable", "isPushingExternalVideo", "getKtvComponentStatusChangedObservable", "ktvComponentStatusChangedObservable", "getKtvRoomCurrentSingerIdStr", "ktvRoomCurrentSingerIdStr", "<init>", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class KtvService implements IKtvService {
    public static final a Companion = null;
    public static final String TAG = "KtvService";
    private String enterRoomType;
    private WeakReference<KtvContext> mKtvContextRef;
    private WeakReference<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> mRoomWidgetViewModelRef;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements rj0.c {
        public final /* synthetic */ Function1 a;

        public final void disconnectFailed() {
            this.a.invoke(Boolean.FALSE);
        }

        public final void disconnectSuccess() {
            this.a.invoke(Boolean.TRUE);
        }

        public b(Function1 r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.bytedance.android.live.ktv.common.music.download.p.a {
        public c() {
        }

        public final void c(MusicPanel r1, int r2) {
        }

        public final void a(MusicPanel r3, String r4, String r5) {
            Long r6 = null;
            if (((Boolean) KtvSettingHelper.T.getValue()).booleanValue() == false) goto L11;
            Object[] r7 = new Object[1];
            if (r3 == null) goto L9;
            KtvMusic r0 = r3.a;
            if (r0 == null) goto L9;
            String r1 = r0.getTitle();
        L10:
            r7[0] = r1;
            f2.c(s1.C(2131918504, r7), 0);
        L9:
            r1 = null;
        L11:
            StringBuilder r8 = new StringBuilder("prepareDownloadSongMaterials onSuccessed ; title:");
            if (r3 == null) goto L16;
            KtvMusic r2 = r3.a;
            if (r2 == null) goto L16;
            String r9 = r2.getTitle();
        L17:
            r8.append(r9);
            r8.append(" ; idString:");
            if (r3 == null) goto L26;
            KtvMusic r10 = r3.a;
            if (r10 == null) goto L26;
            OrderInfo r11 = r10.getOrderInfo();
            if (r11 == null) goto L26;
            InteractiveSongUserInfo r12 = r11.getTopUser();
            if (r12 == null) goto L26;
            String r13 = r12.getIdString();
        L27:
            r8.append(r13);
            r8.append(" ; musicId :");
            if (r3 == null) goto L32;
            KtvMusic r14 = r3.a;
            if (r14 == null) goto L32;
            r6 = Long.valueOf(r14.getId());
        L32:
            r8.append(r6);
            r8.append(' ');
            String r15 = r8.toString();
            ALogger.i(bb0.b.b(), r15 + ", invoke class :" + c.class.getSimpleName());
            return;
        L26:
            r13 = null;
        L16:
            r9 = null;
            goto L17
        }

        public final void b(MusicPanel r5, int r6, String r7) {
            Long r1 = null;
            if (((Boolean) KtvSettingHelper.T.getValue()).booleanValue() == false) goto L11;
            Object[] r0 = new Object[1];
            if (r5 == null) goto L9;
            KtvMusic r2 = r5.a;
            if (r2 == null) goto L9;
            String r3 = r2.getTitle();
        L10:
            r0[0] = r3;
            f2.c(s1.C(2131918503, r0), 0);
        L9:
            r3 = null;
        L11:
            StringBuilder r4 = new StringBuilder("prepareDownloadSongMaterials onFailed ; title:");
            if (r5 == null) goto L16;
            KtvMusic r8 = r5.a;
            if (r8 == null) goto L16;
            String r9 = r8.getTitle();
        L17:
            r4.append(r9);
            r4.append(" ; idString:");
            if (r5 == null) goto L26;
            KtvMusic r10 = r5.a;
            if (r10 == null) goto L26;
            OrderInfo r11 = r10.getOrderInfo();
            if (r11 == null) goto L26;
            InteractiveSongUserInfo r12 = r11.getTopUser();
            if (r12 == null) goto L26;
            String r13 = r12.getIdString();
        L27:
            r4.append(r13);
            r4.append(" ; musicId :");
            if (r5 == null) goto L32;
            KtvMusic r14 = r5.a;
            if (r14 == null) goto L32;
            r1 = Long.valueOf(r14.getId());
        L32:
            r4.append(r1);
            r4.append(" ; errorCode :");
            r4.append(r6);
            r4.append(" ; errorMsg :");
            r4.append(r7);
            String r15 = r4.toString();
            ALogger.i(bb0.b.b(), r15 + ", invoke class :" + c.class.getSimpleName());
            return;
        L26:
            r13 = null;
        L16:
            r9 = null;
            goto L17
        }
    }

    static {
        Companion = new a();
    }

    @Deprecated(message = "")
    private static /* synthetic */ void getMKtvContextRef$annotations() {
    }

    @Deprecated(message = "")
    private static /* synthetic */ void getMRoomWidgetViewModelRef$annotations() {
    }

    public int getTtliveViewKtvRoomFeedResId(boolean r1) {
        if (r1 == false) goto L4;
        return 2131567733;
    L4:
        return 2131567731;
    }

    public boolean hasSelfPrivateSong() {
        Object r2 = null;
        OrderedSongDataContext r3 = getOrderedSongDataContext$default(this, false, 1, null);
        if (r3 == null) goto L13;
        List<SongUniqueInfo> r4 = r3.getKtvPrivateSongUniqueInfoList();
        if (r4 == null) goto L13;
        Iterator<T> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((SongUniqueInfo) r6).getUserId(), jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L8;
        r2 = r6;
    L12:
        r2 = (SongUniqueInfo) r2;
    L13:
        if (r2 == null) goto L19;
        return true;
    L19:
        return false;
    }

    public boolean isEnableMvStage() {
        return true;
    }

    public Widget createConcertWidget() {
        return new ConcertWidget();
    }

    /* JADX INFO: renamed from: createOpusMvService, reason: collision with other method in class */
    public com.bytedance.android.livesdk.ktvapi.model.mv.m m10createOpusMvService() {
        return new com.bytedance.android.livesdk.ktvimpl.mv.opus.d();
    }

    public Widget createPcAudioWidget() {
        return new PcAudioChorusWidget();
    }

    public fd2.g createVideoChorusFeedWidget() {
        return new VideoChorusFeedWidget();
    }

    public Widget createVideoChorusWidget() {
        return new VideoChorusWidget();
    }

    public boolean currentIsAudienceSingEnable() {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        Object r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<Boolean> r2 = r0.isAudienceEnableSing();
        if (r2 == null) goto L7;
        Boolean r3 = (Boolean) r2.getValue();
    L9:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == true) goto L41;
        ArrayList<Integer> r4 = ke2.a.a;
        com.bytedance.android.livesdk.chatroom.o r5 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r5 == null) goto L18;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L18;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L18;
        String r8 = r7.getOwnerUserIdString();
        if (r8 == null) goto L18;
    L19:
        KtvComponentOrderedSongDataContext r9 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r9 == null) goto L31;
        List<SongUniqueInfo> r10 = r9.getKtvPublicSongUniqueInfoList();
        if (r10 == null) goto L31;
        Iterator<T> r11 = r10.iterator();
    L25:
        if (r11.hasNext() == false) goto L29;
        Object r12 = r11.next();
        if ((!Intrinsics.areEqual(((SongUniqueInfo) r12).getUserId(), r8)) == false) goto L25;
        r1 = r12;
    L29:
        r1 = (SongUniqueInfo) r1;
    L31:
        if (r1 == null) goto L33;
        boolean r13 = true;
    L34:
        if (r13 == true) goto L42;
        return false;
    L42:
        return true;
    L33:
        r13 = false;
    L18:
        r8 = "";
        goto L19
    L41:
        return true;
    L7:
        r3 = null;
        goto L9
    }

    public boolean currentIsMultipleKtvModeV2() {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<Boolean> r1 = r0.isAudienceEnableSing();
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L9:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L13;
        ArrayList<Integer> r3 = ke2.a.a;
        int r4 = jc1.k.n(IInteractService.class).getCurrentScene();
        if (ke2.a.a.contains(Integer.valueOf(r4)) == false) goto L13;
        return true;
    L13:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public void destroyChorusService() {
        com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.a r0 = com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.b.a;
        if (r0 == null) goto L5;
        r0.h();
    L5:
        com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.b.a = null;
    }

    public void finishAudioTalk() {
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L7;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r0 == null) goto L11;
        r0.finishAudioTalk();
        return;
    L11:
        return;
    L7:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.T0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.a.a();
        if (r1 == null) goto L13;
        r1.finishAudioTalk();
        return;
    }

    public fd2.f getChorusService() {
        return ChorusContext.Companion.b();
    }

    public gd2.f getConcertStageService() {
        return ConcertStageDataContext.Companion.a();
    }

    public com.bytedance.live.datacontext.m<Boolean> getCurrentIsMultipleKtvModeObservable() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurIsMultipleKtvMode();
    }

    public com.bytedance.live.datacontext.n<KtvMusic> getCurrentSongOfSelf() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentSongOfSelf();
    }

    public HashMap<String, String> getGiftReportParam() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getGiftReportParam();
    }

    public com.bytedance.live.datacontext.m<Boolean> getHasBgm() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHasBgm();
    }

    public boolean getHideLyricsWhenSubtitleOpenSwitch() {
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r1 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r0.getValue();
        if (r1 == null) goto L7;
        return r1.d;
    L7:
        return false;
    }

    public Observable<Integer> getKtvAllStateObservable() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m<Integer> r1 = r0.getKtvAllState();
        if (r1 == null) goto L7;
        return r1.a();
    L7:
        return null;
    }

    public j70.h<d90.d> getKtvAudioRoomWidgetDescriptor() {
        return new w();
    }

    public boolean getKtvComponentLyricsViewShowStatus() {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L13;
        KtvComponentUIContext r2 = (KtvComponentUIContext) r1.getValue();
        if (r2 == null) goto L13;
        NextLiveData<Boolean> r3 = r2.getShowLyricsViewAndMidi();
        if (r3 == null) goto L13;
        Boolean r4 = (Boolean) r3.getValue();
        if (r4 == null) goto L13;
        return r4.booleanValue();
    L13:
        return false;
    }

    public com.bytedance.live.datacontext.m<Integer> getKtvComponentStatusChangedObservable() {
        KtvContext.Companion.getClass();
        return KtvContext.a.g().getKtvComponentStatus();
    }

    public String getKtvRoomCurrentSingerIdString() {
        WeakReference<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r0 = this.mRoomWidgetViewModelRef;
        if (r0 == null) goto L18;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r1 = r0.get();
        if (r1 == null) goto L18;
        KtvRoomLyricsStateMachineConfig.d r2 = r1.getCurState();
        if (r2 == null) goto L18;
        MusicPanel r3 = r2.b();
        if (r3 == null) goto L18;
        KtvMusic r4 = r3.a;
        if (r4 == null) goto L18;
        OrderInfo r5 = r4.getOrderInfo();
        if (r5 == null) goto L18;
        InteractiveSongUserInfo r6 = r5.getTopUser();
        if (r6 == null) goto L18;
        String r7 = r6.getIdString();
        if (r7 == null) goto L18;
        return r7;
    L18:
        return "";
    }

    public y getKtvRoomInfo() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m<y> r1 = r0.getKtvRoomInfo();
        if (r1 == null) goto L7;
        return (y) r1.getValue();
    L7:
        return null;
    }

    public tf0.k getLinkmicReturnRoomParams() {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkmicReturnRoomParams();
    }

    public v getLyricsRecognizer() {
        LyricsRecognitionContext r0 = LyricsRecognitionContext.Companion.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return LyricsRecognitionContext.access$getLyricsRecognizer$p(r0);
    }

    public Observable<fd2.a> getMusicPlayProgressObservable() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n<i> r1 = r0.getKtvCoreController();
        if (r1 == null) goto L9;
        i r2 = (i) r1.getValue();
        if (r2 == null) goto L9;
        return r2.g;
    L9:
        return null;
    }

    /* JADX INFO: renamed from: getOpusPreviewDialogBuilder, reason: collision with other method in class */
    public r m11getOpusPreviewDialogBuilder() {
        return new com.bytedance.android.livesdk.ktvimpl.mv.opus.c();
    }

    public Object getRealTimeChorusMicManager() {
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRealTimeChorusMicManager();
    }

    public String getRecentSongInfo() {
        KtvContext.Companion.getClass();
        return KtvContext.a.h();
    }

    public Pair<String, Map<String, Map<String, List<Object>>>> getRoomWrdsListenerData() {
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoomWrdsListenerData();
    }

    public fd2.w getVideoChorusService() {
        VideoChorusDataContext r0 = VideoChorusDataContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<fd2.w> r1 = r0.getService();
        if (r1 == null) goto L7;
        return (fd2.w) r1.getValue();
    L7:
        return null;
    }

    public boolean hasEnterMultiChorusQueue() {
        return MultiChorusContext.Companion.b();
    }

    public boolean inMultipleKtv() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m<Integer> r1 = r0.getCurKtvMode();
        if (r1 == null) goto L8;
        if (((Number) r1.getValue()).intValue() != 3) goto L8;
    L16:
        return true;
    L8:
        KtvComponentContext r2 = KtvComponentContext.Companion.getContext();
        if (r2 == null) goto L13;
        com.bytedance.live.datacontext.n<Boolean> r3 = r2.isAudienceEnableSing();
        if (r3 == null) goto L13;
        Boolean r4 = (Boolean) r3.getValue();
    L15:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == true) goto L16;
        return false;
    L13:
        r4 = null;
        goto L15
    }

    public boolean inMultipleKtvOld() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Integer> r1 = r0.getCurKtvMode();
        if (r1 == null) goto L9;
        if (((Number) r1.getValue()).intValue() != 3) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isAudienceSingEnableSwitchOn() {
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

    public boolean isCurrentUserIsSinger() {
        KtvContext.Companion.getClass();
        return KtvContext.a.g().isCurrentUserIsSinger();
    }

    public boolean isInRealTimeChorus() {
        RealTimeChorusBusinessContext.Companion.getClass();
        return RealTimeChorusBusinessContext.a.g();
    }

    public boolean isKtvComponentOpen() {
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

    public boolean isKtvComponentV2Enable() {
        ArrayList<Integer> r0 = ke2.a.a;
        com.bytedance.android.live.ktv.common.util.a.c();
        return true;
    }

    public boolean isKtvIsSingingState() {
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r0 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
    L7:
        return r1 instanceof KtvRoomLyricsStateMachineConfig.d.f;
    L5:
        r1 = null;
        goto L7
    }

    public boolean isMultiChorusEnable() {
        KtvComponentContext.a r0 = KtvComponentContext.Companion;
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r1 = r0.a();
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r2 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r1.getValue();
        if (r2 == null) goto L7;
        boolean r3 = r2.b;
    L8:
        if (r3 == false) goto L21;
        KtvComponentContext r4 = r0.getContext();
        if (r4 == null) goto L14;
        com.bytedance.live.datacontext.n<Integer> r5 = r4.getKtvComponentStatus();
        if (r5 == null) goto L14;
        Integer r6 = (Integer) r5.getValue();
    L15:
        if (r6 != null) goto L18;
        return false;
    L18:
        if (r6.intValue() != 1) goto L22;
        return true;
    L22:
        return false;
    L14:
        r6 = null;
        goto L15
    L21:
        return false;
    L7:
        r3 = false;
        goto L8
    }

    public com.bytedance.live.datacontext.m<Boolean> isPushingExternalVideo() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.isPushingExternalVideo();
    }

    public com.bytedance.live.datacontext.n<Integer> ktvCardState() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvCardViewSizeChanged();
    }

    public com.bytedance.live.datacontext.k<z> ktvComponentSingerChangedEvent() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvComponentSingerUserIdChangedEvent();
    }

    public OrderInfo ktvCurrentSingerOrderInfo() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<OrderInfo> r1 = r0.getKtvCurrentSingOrderInfo();
        if (r1 == null) goto L7;
        return (OrderInfo) r1.getValue();
    L7:
        return null;
    }

    public com.bytedance.live.datacontext.k<?> ktvStageReadyEvent() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvStageReadyEvent();
    }

    public void onChallengeIconShow() {
        Long r0 = KtvLoggerHelper.a;
        KtvLoggerHelper.b0("link_interact_panel_tab");
    }

    public com.bytedance.live.datacontext.k<?> orderedListChangeEvent() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvRoomLabelChangeEvent();
    }

    public fd2.q prepareMvService() {
        return new com.bytedance.android.livesdk.ktvimpl.mv.n();
    }

    public android.util.Pair<String, com.bytedance.android.livesdk.log.filter.v> provideKtvBizParamInjector() {
        return new android.util.Pair("KtvBizParamInjectorId", KtvLoggerHelper.a.b);
    }

    public c0.b provideKtvRoomBehavior() {
        return new com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior.b();
    }

    public android.util.Pair<String, com.bytedance.android.livesdk.log.filter.v> provideStageModeLogInjector() {
        return new android.util.Pair("KtvStageModeLogInjectorId", KtvLoggerHelper.b.a);
    }

    public void removeKtvComponent() {
        ArrayList<Integer> r0 = ke2.a.a;
        com.bytedance.android.live.ktv.common.util.a.c();
        KtvComponentContext r1 = KtvComponentContext.Companion.getContext();
        if (r1 == null) goto L8;
        com.bytedance.live.datacontext.n<x> r2 = r1.getKtvComponentCmd();
        if (r2 == null) goto L9;
        r2.setValue(new x(0, null, null, null, null, null, null, null, 254));
        return;
    L9:
        return;
    }

    public com.bytedance.live.datacontext.k<?> stageChangeToIdleEvent() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvStageIdleEvent();
    }

    public com.bytedance.live.datacontext.k<?> stageChangeToPreparedEvent() {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvStagePreparedEvent();
    }

    public void tryAutoFastMatch() {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r0 == null) goto L6;
        r0.tryAutoFastMatch();
        return;
    }

    public KtvService() {
        jc1.k.l(IKtvService.class, this);
        this.enterRoomType = "";
    }

    public boolean canSilenceSelf() {
        if (jc0.a.a() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canSilenceSelf();
    L8:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 != null) goto L11;
        return false;
    L11:
        return r1.canSilenceSelf();
    }

    public boolean currentIsMultipleKtvMode() {
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.j r1 = r0.J();
        if (r1 == null) goto L13;
        LivePlayModeLogContext r2 = (LivePlayModeLogContext) r1.getValue();
        if (r2 == null) goto L13;
        com.bytedance.live.datacontext.m r3 = r2.getPlayModes();
        if (r3 == null) goto L13;
        Set r4 = (Set) r3.getValue();
        if (r4 == null) goto L13;
        return r4.contains(10);
    L13:
        return false;
    }

    public List<s0> getHeadPointList() {
        if (jc0.a.a() == false) goto L14;
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L9;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r0 != null) goto L23;
        return null;
    L23:
        return r0.getHeadPointList();
    L9:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r1 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r1 != null) goto L12;
        return null;
    L12:
        return r1.getHeadPointList();
    L14:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L18;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.T0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b r2 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.a.a();
        if (r2 != null) goto L26;
        return null;
    L26:
        return r2.getHeadPointList();
    L18:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r3 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r3 != null) goto L21;
        return null;
    L21:
        return r3.getHeadPointList();
    }

    public Object getInteractAnimationService() {
        if (jc0.a.a() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getInteractAnimationService();
    L8:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 != null) goto L11;
        return null;
    L11:
        return r1.getInteractAnimationService();
    }

    public String getKtvRoomCurrentSingerIdStr() {
        return getKtvRoomCurrentSingerIdString();
    }

    public com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter() {
        if (jc0.a.a() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkUserInfoCenter();
    L8:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 != null) goto L11;
        return null;
    L11:
        return r1.getLinkUserInfoCenter();
    }

    public int getSelfSilenceType() {
        Integer r2 = null;
        if (jc0.a.a() == false) goto L13;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r0 == null) goto L7;
        r2 = Integer.valueOf(r0.getSelfSilenceType());
    L10:
        if (r2 != null) goto L12;
        return 0;
    L12:
        return r2.intValue();
    L7:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r1 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r1 == null) goto L10;
        r2 = Integer.valueOf(r1.getSelfSilenceType());
        goto L10
    L13:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.T0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b r3 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.a.a();
        if (r3 == null) goto L16;
        r2 = Integer.valueOf(r3.getSelfSilenceType());
    L19:
        if (r2 != null) goto L21;
        return 0;
    L21:
        return r2.intValue();
    L16:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r4 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r4 == null) goto L19;
        r2 = Integer.valueOf(r4.getSelfSilenceType());
        goto L19
    }

    public boolean isEngineOn() {
        if (jc0.a.a() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isEngineOn();
    L8:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 != null) goto L11;
        return false;
    L11:
        return r1.isEngineOn();
    }

    public boolean isKtvChallengeOpened() {
        return ne2.a.a();
    }

    public Object muteManager() {
        if (jc0.a.a() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.muteManager();
    L8:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 != null) goto L11;
        return null;
    L11:
        return r1.muteManager();
    }

    public gd2.c getChorusConcertService() {
        return com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.b.a;
    }

    public String getEnterRoomType() {
        return this.enterRoomType;
    }

    public IKtvComponentFeedViewService getKtvComponentFeedViewService() {
        return com.bytedance.android.livesdk.ktvimpl.base.b.a;
    }

    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.ktvapi.model.mv.d createOpusMvService() {
        return m10createOpusMvService();
    }

    public /* bridge */ /* synthetic */ fd2.m getOpusPreviewDialogBuilder() {
        return m11getOpusPreviewDialogBuilder();
    }

    /* JADX INFO: renamed from: ktvCurrentSingerOrderInfo, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ za m12ktvCurrentSingerOrderInfo() {
        return ktvCurrentSingerOrderInfo();
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_base_KtvService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(KtvGroupListDialogFragment r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public fd2.g createConcertFeedWidget(String r2) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        return new com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.b(r2);
    }

    public void createKtvGroup(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r0 = KtvRoomContext.a.a();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.j<KtvGroupViewModel> r1 = r0.getKtvGroupViewModel();
        if (r1 == null) goto L11;
        KtvGroupViewModel r2 = (KtvGroupViewModel) r1.getValue();
        if (r2 == null) goto L12;
        r2.createGroup(r3, "sing_rank");
        return;
    L12:
        return;
    L11:
        return;
    }

    public Widget createKtvRoomGuestWidget(w0 r2) {
        return new KtvRoomGuestWidget(r2);
    }

    public Widget createRealTimeChorusRoomGuestWidget(w0 r2) {
        return new RealTimeChorusGuestWidget(r2);
    }

    public v createSpeechRecognizer(boolean r2) {
        if (tb1.c.h == true) goto L13;
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L13;
        if (((Boolean) u70.a.getValue()).booleanValue() == false) goto L13;
        if (r2 == false) goto L23;
        return new LinkSpeechServerRecognizer();
    L23:
        return new SpeechRecognizer();
    L13:
        if (KtvSettingHelper.A().i() == false) goto L18;
        if (r2 == false) goto L25;
        return new LinkSpeechServerRecognizer();
    L25:
        return new LinkSpeechRecognizer();
    L18:
        if (KtvSettingHelper.A().h() == false) goto L21;
        return new CoverSpeechRecognizer();
    L21:
        return new SpeechRecognizer();
    }

    public void enableAtmosphere(boolean r2) {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.getEnableKtvAtmosphere();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    public void enableHardwareEcho(boolean r4) {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.j;
        Boolean r1 = Boolean.valueOf(r4);
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
        if (jc0.a.c() == false) goto L12;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r2 = VideoChorusDataContext.Companion.a();
        if (r2 == null) goto L11;
        KtvEarMonitor r3 = r2.g();
        if (r3 == null) goto L30;
        if (r4 == false) goto L12;
        r3.m();
        goto L12
    L30:
        return;
    L11:
        return;
    L12:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r5 = KSongTuningPanelHelperKt.d();
        boolean r6 = isCurrentUserIsSinger();
        if (r5 == null) goto L18;
        MutableLiveData r7 = r5.F();
        if (r7 == null) goto L18;
        Boolean r8 = (Boolean) r7.getValue();
        if (r8 == null) goto L18;
    L19:
        boolean r9 = r8.booleanValue();
        if (r9 == false) goto L24;
        if (r4 == true) goto L24;
        if (r5 == null) goto L31;
        r5.Y(false);
        return;
    L31:
        return;
    L24:
        if (r9 == true) goto L33;
        if (r4 == false) goto L34;
        if (r6 == false) goto L35;
        if (r5 == null) goto L36;
        r5.b();
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L18:
        r8 = Boolean.FALSE;
        goto L19
    }

    public void enablePreviewSong(boolean r3) {
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r0 = KtvRoomContext.a.a();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r1 = r0.getPreviewViewModel();
        if (r1 == null) goto L11;
        KtvPreviewSongsViewModel r2 = (KtvPreviewSongsViewModel) r1.getValue();
        if (r2 == null) goto L12;
        r2.setShowPreviewCard(r3, "enablePreviewSong");
        return;
    L12:
        return;
    L11:
        return;
    }

    public void enableVideoChorus(jd2.g r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.n<jd2.g> r1 = r0.getEnableVideoChorus();
        if (r1 == null) goto L9;
        r1.setValue(r2);
        return;
    L9:
        return;
    }

    public List<KtvMusic> getKtvRoomCurSelfOrderList(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        KtvContext.Companion.getClass();
        KtvContext r1 = KtvContext.a.g();
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r1, "ktvContext");
        OrderedSongDataContext r0 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.d(r1.isKtvMode());
        if (r0 == null) goto L6;
        List<MusicPanel> r4 = r0.getKtvCurSelfOrderedSongList(r3);
        if (r4 == null) goto L6;
    L7:
        List<MusicPanel> r5 = r4;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        r2.add(((MusicPanel) r6.next()).a);
        goto L9
    L11:
        return r2;
    L6:
        r4 = new ArrayList();
        goto L7
    }

    public final OrderedSongDataContext getOrderedSongDataContext(boolean r1) {
        if (r1 == false) goto L5;
        return KtvModeOrderedSongDataContext.Companion.getContext();
    L5:
        return KtvComponentOrderedSongDataContext.Companion.getContext();
    }

    public KtvRoomUserLabel getUserKtvRoomLabel(String r5) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        KtvContext.Companion.getClass();
        KtvContext r1 = KtvContext.a.g();
        Intrinsics.checkNotNullParameter(r1, "ktvContext");
        Intrinsics.checkNotNullParameter(r5, "userId");
        if (KtvContext.a.g().isKtvMode() == false) goto L5;
        OrderedSongDataContext r0 = KtvModeOrderedSongDataContext.Companion.getContext();
    L6:
        if (r0 == null) goto L8;
        List<SongUniqueInfo> r2 = r0.getKtvPublicSongUniqueInfoList();
    L9:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r3 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r1.getKtvCoreViewModel().getValue();
        int r4 = 0;
        if (r3 == null) goto L23;
        KtvRoomLyricsStateMachineConfig.d r6 = r3.getState();
        if (r6 == null) goto L23;
        MusicPanel r7 = r6.b();
        if (r7 == null) goto L23;
        KtvMusic r8 = r7.a;
        if (r8 == null) goto L23;
        if (r8.isOrderedBy(r5) != true) goto L23;
        if (r2 == null) goto L23;
        if ((!r2.isEmpty()) != true) goto L23;
    L32:
        if (r4 < 0) goto L42;
        if (r4 == 0) goto L43;
        if (r4 != 1) goto L39;
        return KtvRoomUserLabel.NEXT;
    L39:
        return KtvRoomUserLabel.ORDERED;
    L43:
        return KtvRoomUserLabel.SINGER;
    L42:
        return KtvRoomUserLabel.UNKNOWN;
    L23:
        if (r2 == null) goto L31;
        Iterator<SongUniqueInfo> r9 = r2.iterator();
    L26:
        if (r9.hasNext() == false) goto L31;
        if (Intrinsics.areEqual(r9.next().getUserId().toString(), r5) == true) goto L32;
        r4 = r4 + 1;
    L31:
        r4 = -1;
        goto L32
    L8:
        r2 = null;
        goto L9
    L5:
        r0 = KtvComponentOrderedSongDataContext.Companion.getContext();
        goto L6
    }

    public Class<? extends Widget> getWidgetClassByType(AbsKtvControlWidget.WidgetType r4) {
        Intrinsics.checkNotNullParameter(r4, "widgetType");
        if (o.a[r4.ordinal()] != 1) goto L7;
        return KtvRoomCardWidget.class;
    L7:
        throw new IllegalArgumentException("type " + r4.name() + " has not implemented yet.");
    }

    public JsonObject handleDynamicJsbGetAction(JsonObject r3) {
        ChorusJsbDataContext r0 = ChorusJsbDataContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<fd2.e> r1 = r0.getService();
        if (r1 == null) goto L7;
        fd2.e r2 = (fd2.e) r1.getValue();
    L8:
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.handleDynamicJsbGetAction(r3);
    L7:
        r2 = null;
        goto L8
    }

    public JsonObject handleDynamicJsbUpdateAction(JsonObject r3) {
        Intrinsics.checkNotNullParameter(r3, "extraData");
        ChorusJsbDataContext r0 = ChorusJsbDataContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<fd2.e> r1 = r0.getService();
        if (r1 == null) goto L7;
        fd2.e r2 = (fd2.e) r1.getValue();
    L8:
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.handleDynamicJsbUpdateAction(r3);
    L7:
        r2 = null;
        goto L8
    }

    public void handleSettingUpdate(List<? extends com.bytedance.android.livesdk.chatroom.interact.model.y> r2) {
        Intrinsics.checkNotNullParameter(r2, "settings");
        KtvContext.Companion.getClass();
        KtvContext.a.g().getLinkMicSettingUpdate().post(jm2.a.a(r2));
    }

    public ViewModel installKtvContext(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        DataContext r1 = null;
        Object r5 = r4.get("ktvContext", null);
        if ((r5 instanceof KtvContext) == true) goto L5;
        r5 = null;
    L5:
        KtvContext r6 = (KtvContext) r5;
        ALogger.i("coreVm-check", "获取ktvContext:" + r6);
        if (r6 != null) goto L11;
        Companion.getClass();
        if (((Boolean) vm2.h.p1.getValue(null, vm2.h.a[118(0x76, float:1.65E-43)])).booleanValue() == false) goto L10;
        Pair r7 = com.bytedance.live.datacontext.d.a(KtvService$Companion$createKtvContext$pair$1.INSTANCE);
        KtvContext r0 = (KtvContext) r7.getFirst();
        r0.setDataContextDisposable((Disposable) r7.getSecond());
        r6 = r0;
        goto L11
    L10:
        r6 = new KtvContext();
    L11:
        com.bytedance.live.datacontext.b.a(r6, KtvContext.class);
        com.bytedance.live.datacontext.n r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().b();
        if (r2 == null) goto L14;
        r2.setValue(r6);
    L14:
        StringBuilder r3 = new StringBuilder("RoomContextInitHelper:");
        r3.append(r6);
        r3.append("---");
        com.bytedance.live.datacontext.n r8 = com.bytedance.android.live.liveinteract.api.utils.m.d().b();
        if (r8 == null) goto L17;
        r1 = (DataContext) r8.getValue();
    L17:
        r3.append(r1);
        ALogger.i("coreVm排查", r3.toString());
        return r6;
    }

    public void invite(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        if ((r2 instanceof com.bytedance.android.live.liveinteract.videolink.a) == true) goto L5;
        Object r0 = null;
    L7:
        if (((com.bytedance.android.live.liveinteract.videolink.a) r0) != null) goto L9;
        return;
    L9:
        if (jc0.a.a() == false) goto L16;
        if (com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0 == null) goto L22;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r1 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r1 == null) goto L23;
        r1.invite((com.bytedance.android.live.liveinteract.videolink.a) r2);
        return;
    L23:
        return;
    L22:
        return;
    L16:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L25;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r3 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r3 == null) goto L26;
        r3.invite((com.bytedance.android.live.liveinteract.videolink.a) r2);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        r0 = r2;
        goto L7
    }

    public boolean isInKtvState(int r2) {
        KtvContext.Companion.getClass();
        return KtvContext.a.c(r2);
    }

    public boolean isMultipleKtvEnable(DataCenter r1) {
        return ge2.a.a(r1);
    }

    public boolean isUserSelectMusic(String r7) {
        Intrinsics.checkNotNullParameter(r7, "uid");
        Object r2 = null;
        OrderedSongDataContext r3 = getOrderedSongDataContext$default(this, false, 1, null);
        if (r3 == null) goto L13;
        List<SongUniqueInfo> r4 = r3.m201getKtvSongUniqueInfoList();
        if (r4 == null) goto L13;
        Iterator<T> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((SongUniqueInfo) r6).getUserId(), r7) == false) goto L8;
        r2 = r6;
    L12:
        r2 = (SongUniqueInfo) r2;
    L13:
        if (r2 == null) goto L19;
        return true;
    L19:
        return false;
    }

    public void kickOut(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "targetUser");
        if (jc0.a.a() == false) goto L7;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 == null) goto L11;
        r0.kickOut(r2);
        return;
    L11:
        return;
    L7:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 == null) goto L13;
        r1.kickOut(r2);
        return;
    }

    public void loadKtvControlWidget(g5 r12) {
        Intrinsics.checkNotNullParameter(r12, "absInteractionFragment");
        int r1 = f5.a;
        Intrinsics.checkNotNullParameter(r12, "absInteractionFragment");
        MiddleAbsInteractionFragment r0 = (MiddleAbsInteractionFragment) r12;
        r0.getClass();
        AbsInteractionFragment r2 = (AbsInteractionFragment) r12;
        if (r2.f3 == null) goto L100;
        mg2.d r3 = r0.f;
        com.bytedance.live.datacontext.n r4 = null;
        if (r3 == null) goto L8;
        IComponentManager r5 = r3.f(mg2.e.e);
    L9:
        if (r5 == null) goto L101;
        RecyclableWidgetManager r6 = r0.e;
        if (r6 == null) goto L102;
        com.bytedance.android.live.pushstream.d r7 = r0.d;
        boolean r8 = false;
        if (KtvSettingHelper.e().a() == false) goto L25;
        com.bytedance.android.livesdk.chatroom.o r9 = o3.f();
        if (r9 == null) goto L25;
        com.bytedance.live.datacontext.m r10 = r9.getRoom();
        if (r10 == null) goto L25;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L25;
        if (r11.isMergeVSRoom() != true) goto L25;
    L52:
        boolean r13 = false;
    L64:
        if (r13 == true) goto L66;
        return;
    L66:
        if (vm2.d.j() == 0) goto L68;
        r8 = true;
    L68:
        if (r8 == true) goto L70;
    L72:
        IKtvService r14 = jc1.k.f(IKtvService.class);
        if (r14 == null) goto L75;
        AbsKtvControlWidget r15 = r14.getKtvControlWidget(new e5(r5, r6), r7);
    L77:
        if ((r15 instanceof AbsKtvControlWidget) == false) goto L79;
        r2.t4 = r15;
    L79:
        r6.load(r15);
        r0.g = true;
        RoomContext r16 = r2.X;
        if (r16 == null) goto L88;
        com.bytedance.live.datacontext.m r17 = r16.getOpenVoiceKtvRoom();
        if (r17 == null) goto L88;
        Observable r18 = r17.a();
        if (r18 == null) goto L88;
        ObservableSubscribeProxy r19 = (ObservableSubscribeProxy) r18.as(AutoDispose.bind(r0));
        if (r19 == null) goto L88;
        r19.subscribe(new c5(r12));
    L88:
        IKtvService r20 = jc1.k.f(IKtvService.class);
        if (r20 == null) goto L91;
        r4 = r20.ktvCardState();
    L91:
        if (r4 != null) goto L93;
        return;
    L93:
        if (r4.a() == null) goto L99;
        ((ObservableSubscribeProxy) r4.a().as(AutoDispose.bind(r0))).subscribe(new d5(r12));
        return;
    L99:
        return;
    L75:
        r15 = null;
        goto L77
    L70:
        if (r2.t4 == null) goto L72;
        ALogger.i("AbsInteractionFragment", "loadKtvControlWidget repeat intercept");
        return;
    L25:
        com.bytedance.android.livesdk.chatroom.o r21 = o3.f();
        if (r21 == null) goto L30;
        com.bytedance.live.datacontext.m r22 = r21.getRoom();
        if (r22 == null) goto L30;
        IRoom r23 = (IRoom) r22.getValue();
    L32:
        if (com.bytedance.android.livesdk.config.setting.d.a(r23, "KtvControl") == false) goto L41;
        com.bytedance.android.livesdk.chatroom.o r24 = o3.f();
        if (r24 == null) goto L36;
        Boolean r25 = r24.isAnchor();
    L38:
        if (Intrinsics.areEqual(r25, Boolean.FALSE) == false) goto L41;
    L36:
        r25 = null;
    L41:
        if (com.bytedance.android.livesdk.config.setting.i.a.t() == false) goto L53;
        ILiveExpOptService r26 = jc1.k.f(ILiveExpOptService.class);
        if (r26 == null) goto L53;
        com.bytedance.android.livesdk.chatroom.o r27 = o3.f();
        if (r27 == null) goto L47;
        DataCenter r28 = r27.getDataCenter();
    L48:
        l61.c r29 = r26.getSceneState(r28, l61.d.a.b0.e);
        if (r29 == null) goto L53;
        if (r29.a() != true) goto L53;
    L47:
        r28 = null;
    L53:
        com.bytedance.android.livesdk.chatroom.o r30 = o3.f();
        if (r30 == null) goto L62;
        com.bytedance.live.datacontext.m r31 = r30.getRoom();
        if (r31 == null) goto L62;
        IRoom r32 = (IRoom) r31.getValue();
        if (r32 == null) goto L62;
        IRoomSpecificSceneTypeInfo r33 = r32.getSceneTypeInfo();
        if (r33 == null) goto L62;
        boolean r34 = IRoomSpecificSceneTypeInfoKt.isLandscapeVertical(r33);
    L63:
        r13 = !r34;
    L62:
        r34 = false;
    L30:
        r23 = null;
        goto L32
    L102:
        return;
    L101:
        return;
    L8:
        r5 = null;
        goto L9
    }

    public void moveOrderedSongToOtherRoom(long r2) {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.k<Long> r1 = r0.getMoveSongToOtherRoomEvent();
        if (r1 == null) goto L9;
        r1.post(Long.valueOf(r2));
        return;
    L9:
        return;
    }

    public Disposable observeMultiChorusSwitchState(Consumer<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        return MultiChorusContext.Companion.g(r2);
    }

    public void onClickToolbar(int r2) {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r0 == null) goto L6;
        r0.onClickToolbar(r2);
        return;
    }

    public void onPermitSuccess(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L13;
        KtvComponentUIContext r3 = (KtvComponentUIContext) r1.getValue();
        if (r3 == null) goto L14;
        com.bytedance.live.datacontext.k<String> r4 = r3.getPermitUser();
        if (r4 == null) goto L15;
        r4.post(r2);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public void onSwitchSceneMessage(z0 r5) {
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L10;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r0 == null) goto L7;
        r0.onSwitchSceneMessage(r5);
    L7:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r1 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r1 == null) goto L30;
        r1.onSwitchSceneMessage(r5);
        return;
    L30:
        return;
    L10:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.T0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b r2 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.a.a();
        vh7.c r3 = null;
        if (r2 == null) goto L19;
        if (r5 == null) goto L14;
        vh7.c r4 = jm2.a.d(r5);
    L16:
        if ((r4 instanceof z0) == true) goto L18;
        r4 = null;
    L18:
        r2.onSwitchSceneMessage((z0) r4);
        goto L19
    L14:
        r4 = null;
    L19:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r6 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r6 == null) goto L32;
        if (r5 == null) goto L23;
        vh7.c r7 = jm2.a.d(r5);
    L25:
        if ((r7 instanceof z0) == false) goto L28;
        r3 = r7;
    L28:
        r6.onSwitchSceneMessage((z0) r3);
        return;
    L23:
        r7 = null;
        goto L25
    }

    public void openKsong(String r55) {
        Intrinsics.checkNotNullParameter(r55, "source");
        int r1 = com.bytedance.android.livesdk.ktvimpl.base.c.a;
        if (KtvSettingHelper.g().a() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L13;
        kh r3 = new kh(new MusicPanel(new KtvMusic(0, null, null, null, 0, null, null, 0, 0.0f, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 0, null, 0, null, null, 0, null, null, null, null, null, null, -1, 7, null), 0, null, false, null, null, null, 1073741822), r55);
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L14;
        com.bytedance.live.datacontext.k<kh> r4 = r0.getOpenKtvEvent();
        if (r4 == null) goto L15;
        r4.post(r3);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void prepareDownloadSongMaterials(List<KtvMusic> r12) {
        if (r12 == null) goto L14;
        List<KtvMusic> r13 = r12;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L5:
        if (r14.hasNext() == false) goto L15;
        KtvMusic r3 = (KtvMusic) r14.next();
        String r2 = r3.getAddSongSource();
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        String r5 = r2;
        MusicPanel.MusicPanelSource r7 = MusicPanel.MusicPanelSource.KTV;
        u r4 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r4 == null) goto L12;
        String r6 = r4.w();
    L13:
        r0.add(new MusicPanel(r3, 0, r5, false, r7, r6, null, 1073741718));
        goto L5
    L12:
        r6 = null;
    L15:
        Iterator r15 = r0.iterator();
    L17:
        if (r15.hasNext() == false) goto L19;
        MusicPanel r8 = (MusicPanel) r15.next();
        KtvMusicManager.e(KtvMusicManager.m, r8, new c(), false, null, true, 8);
        goto L17
    L19:
        return;
    L14:
        r0 = new ArrayList();
        goto L15
    }

    public BaseActionMethod<Void> providerSchemaActionImpl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        if (Intrinsics.areEqual(r2, "webcast_inroom_ktv_order_panel") == true) goto L5;
        return null;
    L5:
        return new KtvOrderPannalAction();
    }

    public boolean requestConflictCheck(KtvConflictScene r2) {
        Intrinsics.checkNotNullParameter(r2, "toScene");
        if (requestConflictCheckForScene(r2) != KtvConflictScene.SCENE_NONE) goto L5;
        return true;
    L5:
        return false;
    }

    public KtvConflictScene requestConflictCheckForScene(KtvConflictScene r7) {
        Intrinsics.checkNotNullParameter(r7, "toScene");
        Map<KtvConflictScene, List<f>> r1 = e.a;
        Intrinsics.checkNotNullParameter(r7, "toScene");
        List<f> r8 = e.a.get(r7);
        if (r8 != null) goto L5;
        r8 = CollectionsKt.emptyList();
    L5:
        Iterator<T> r9 = r8.iterator();
    L6:
        Object r2 = null;
        if (r9.hasNext() == false) goto L34;
        Object r0 = r9.next();
        f r3 = (f) r0;
        KtvConflictScene r4 = r3.a;
        int r5 = d.a[r4.ordinal()];
        if (r5 != 1) goto L11;
        DataContext r6 = com.bytedance.live.datacontext.d.d("SoundRepelContext");
        if ((r6 instanceof SoundRepelContext) == false) goto L24;
        r2 = r6;
    L24:
        SoundRepelContext r10 = (SoundRepelContext) r2;
        if (r10 == null) goto L27;
        boolean r11 = r10.getSoundEffectUsing();
    L28:
        if (r11 == false) goto L32;
        int r12 = r3.b;
        if (r12 <= 0) goto L32;
        f2.b(r12, 0);
    L32:
        if (r11 == false) goto L6;
        r2 = r0;
    L27:
        r11 = false;
        goto L28
    L11:
        if (r5 != 2) goto L13;
        KtvContext.Companion.getClass();
        r11 = KtvContext.a.c(8);
        goto L28
    L13:
        if (r5 != 3) goto L15;
        KtvContext.Companion.getClass();
        r11 = KtvContext.a.c(1);
        goto L28
    L15:
        if (r5 != 4) goto L27;
        KtvContext.Companion.getClass();
        r11 = KtvContext.a.c(32);
    L34:
        f r13 = (f) r2;
        if (r13 == null) goto L39;
        KtvConflictScene r14 = r13.a;
        if (r14 == null) goto L39;
        return r14;
    L39:
        return KtvConflictScene.SCENE_NONE;
    }

    public void saveEnterRoomType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "enterRoomType");
        this.enterRoomType = r2;
    }

    public void sendKtvComponentV2Command(x r3) {
        Intrinsics.checkNotNullParameter(r3, "cmd");
        KtvComponentContext.a r0 = KtvComponentContext.Companion;
        KtvComponentContext r1 = r0.getContext();
        if (r1 == null) goto L8;
        com.bytedance.live.datacontext.n<x> r2 = r1.getKtvComponentCmd();
        if (r2 == null) goto L8;
        r2.setValue(r3);
    L8:
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.c == true) goto L10;
        return;
    L10:
        if (r0.getContext() != null) goto L14;
        KtvContext.Companion.getClass();
        KtvContext.a.g().getKtvComponentCmdForAnchor().setValue(r3);
        return;
    }

    public void setInviteCallback(uf0.c r2) {
        if (jc0.a.a() == false) goto L7;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 == null) goto L11;
        r0.setInviteCallback(r2);
        return;
    L11:
        return;
    L7:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 == null) goto L13;
        r1.setInviteCallback(r2);
        return;
    }

    public void setKtvContext(Object r2) {
        if ((r2 instanceof KtvContext) == false) goto L6;
        this.mKtvContextRef = new WeakReference(r2);
        return;
    }

    public void setKtvCoreViewModel(Object r2) {
        if ((r2 instanceof com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) == false) goto L6;
        this.mRoomWidgetViewModelRef = new WeakReference(r2);
        return;
    }

    public void setPermitCallback(uf0.d r2) {
        if (jc0.a.a() == false) goto L7;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 == null) goto L11;
        r0.setPermitCallback(r2);
        return;
    L11:
        return;
    L7:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 == null) goto L13;
        r1.setPermitCallback(r2);
        return;
    }

    public void setVoiceKtvSwitchTime(long r2) {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m<Long> r1 = r0.getVoiceKtvSwitchTime();
        if (r1 == null) goto L9;
        r1.setValue(Long.valueOf(r2));
        return;
    L9:
        return;
    }

    public void updateKtvComponentLyricsViewShowStatus(boolean r2) {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L13;
        KtvComponentUIContext r3 = (KtvComponentUIContext) r1.getValue();
        if (r3 == null) goto L14;
        NextLiveData<Boolean> r4 = r3.getShowLyricsViewAndMidi();
        if (r4 == null) goto L15;
        r4.setValue(Boolean.valueOf(r2));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public void sendKtvComponentV2Command(fd2.i r3) {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.n<x> r1 = r0.getKtvComponentCmd();
        if (r1 != null) goto L7;
        return;
    L7:
        if ((r3 instanceof x) == true) goto L9;
        r3 = null;
    L9:
        r1.setValue((x) r3);
        return;
    }

    public void accept(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "secUid");
        if (jc0.a.a() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 == null) goto L13;
        r0.accept(r2, r3);
        return;
    L13:
        return;
    L8:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L15;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 == null) goto L16;
        r1.accept(r2, r3);
        return;
    L16:
        return;
    }

    public boolean continueAnchorLinkMic(int r5, com.bytedance.android.livesdk.message.linker.h r6) {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.T0.getClass();
        vh7.c r2 = null;
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.a.a() == null) goto L15;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.a.a();
        if (r0 == null) goto L14;
        if (r6 == null) goto L8;
        vh7.c r7 = jm2.a.d(r6);
    L10:
        if ((r7 instanceof LinkmicInfoWithRtcInfoData) == false) goto L13;
        r2 = r7;
    L13:
        r0.j2(r5, (LinkmicInfoWithRtcInfoData) r2);
        goto L14
    L8:
        r7 = null;
    L14:
        return true;
    L15:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a() == null) goto L28;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r1 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r1 == null) goto L27;
        if (r6 == null) goto L21;
        vh7.c r8 = jm2.a.d(r6);
    L23:
        if ((r8 instanceof LinkmicInfoWithRtcInfoData) == false) goto L26;
        r2 = r8;
    L26:
        r1.j2(r5, (LinkmicInfoWithRtcInfoData) r2);
        goto L27
    L21:
        r8 = null;
    L27:
        return true;
    L28:
        return false;
    }

    public <T> com.bytedance.android.livesdk.ktvapi.model.mv.e<T> createMvPreviewList(Context r3, com.bytedance.android.livesdk.ktvapi.model.mv.j<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "provider");
        return new com.bytedance.android.live.ktv.common.view.g(r3, r4, null);
    }

    public IKtvComponentFeedView getKtvComponentFeedView(Context r4, boolean r5) {
        if (r4 != null) goto L6;
        return null;
    L6:
        return new KtvComponentFeedView(r4, null, 6, 0);
    }

    public AbsKtvControlWidget getKtvControlWidget(AbsKtvControlWidget.a r1, com.bytedance.android.live.pushstream.d r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return new KtvControlWidget(r1);
    }

    public IInteractFeedView getRealTimeChorusFeedView(Context r2, int r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new RealTimeChorusFeedContainer(r3, r2);
    }

    public JsonObject handleKtvCommonJsbGetAction(JsonObject r2, boolean r3) {
        KtvJsbDataContext.a r0 = KtvJsbDataContext.Companion;
        r0.getClass();
        if (KtvJsbDataContext.a.a(r3) == null) goto L5;
        KtvJsbDataContext r4 = r0.getContext();
        if (r4 == null) goto L11;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.a> r5 = r4.getService();
        if (r5 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.a r6 = (com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.a) r5.getValue();
    L12:
        if (r6 != null) goto L14;
        return null;
    L14:
        return r6.handleDynamicJsbGetAction(r2);
    L11:
        r6 = null;
        goto L12
    L5:
        return new JsonObject();
    }

    public JsonObject handleKtvCommonJsbUpdateAction(JsonObject r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "extraData");
        KtvJsbDataContext.Companion.getClass();
        if (KtvJsbDataContext.a.a(r3) == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.a r4 = KtvJsbDataContext.a.a(r3);
        if (r4 != null) goto L11;
        return null;
    L11:
        return r4.handleDynamicJsbUpdateAction(r2);
    L5:
        return new JsonObject();
    }

    public boolean interceptCloseRoom(Runnable r2, boolean r3) {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.interceptCloseRoom(r2, r3) != true) goto L7;
        return true;
    }

    public void inviteToKtvGroup(long r2, String r4) {
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r0 = KtvRoomContext.a.a();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.j<KtvGroupViewModel> r1 = r0.getKtvGroupViewModel();
        if (r1 == null) goto L13;
        KtvGroupViewModel r3 = (KtvGroupViewModel) r1.getValue();
        if (r3 == null) goto L14;
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r3.inviteToKtvGroup(r2, r4);
        return;
    L14:
        return;
    L13:
        return;
    }

    public void ktvContainerPositionUpdate(Float r3, Integer r4) {
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.k<com.bytedance.android.livesdk.ktvimpl.base.util.i> r1 = r0.getKtvContainerPositionUpdateEvent();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.base.util.i r2 = new com.bytedance.android.livesdk.ktvimpl.base.util.i();
        r2.a = r3;
        r2.b = r4;
        Unit r5 = Unit.INSTANCE;
        r1.post(r2);
        return;
    L9:
        return;
    }

    public void onChangeMediaInfo(ILinkerChangeMediaInfoContent r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.INFO);
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r0 == null) goto L6;
        r0.onChangeMediaInfo(r2, r3);
        return;
    }

    public void onSei(String r2, ye1.a r3) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.INFO);
        if (jc0.a.a() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r0 == null) goto L13;
        r0.onSei(r2, r3);
        return;
    L13:
        return;
    L8:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0 == null) goto L15;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r1 == null) goto L16;
        r1.onSei(r2, r3);
        return;
    L16:
        return;
    }

    public void openEffectMusicSelect(String r3, id2.d r4) {
        Intrinsics.checkNotNullParameter(r4, "ktvMusicSelectedCallBack");
        xs2.b.a().post(new od2.a(r3, r4));
    }

    public void openKtvChallenge(String r2, Context r3) {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r0 = KtvChallengeDataContext.Companion.a();
        if (r0 == null) goto L6;
        r0.openChallenge(r2, r3);
        return;
    }

    public void openKtvGroupUserList(Context r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "groupdId");
        ALogger.i(TAG, "openKtvGroupUserList:" + r6);
        FragmentActivity r0 = ContextUtil.contextToFragmentActivity(r5);     // Catch: Exception -> L14
        FragmentManager r2 = null;
        if (r0 == null) goto L6;
        FragmentManager r1 = r0.getSupportFragmentManager();     // Catch: Exception -> L14
    L7:
        if (r1 != null) goto L9;
        return;
    L9:
        if ((!r1.isStateSaved()) == false) goto L11;
        r2 = r1;
    L11:
        if (r2 == null) goto L20;
        INVOKEVIRTUAL_com_bytedance_android_livesdk_ktvimpl_base_KtvService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(new KtvGroupListDialogFragment(r5, CastLongProtector.parseLong(r6)));     // Catch: Exception -> L14
        return;
    L20:
        return;
    L6:
        r1 = null;
    L14:
        e = move-exception;
        ALogger.i(TAG, "openKtvGroupUserList error:" + e.getMessage());
    }

    public void openKtvRoomDialog(Context r8, DataCenter r9) {
        if (r8 == null) goto L7;
        if (r9 == null) goto L8;
        pb0.a.a.b(KtvLoggerHelper.d, "bottom", "", null, null, null, 28);
        KtvContext.Companion.getClass();
        KtvContext r10 = KtvContext.a.g();
        r10.getOpenKtvRoomDialogEvent().post(new od2.b("bottom", r10.isCurrentUserIsSinger(), null));
        return;
    L8:
        return;
    }

    public void showLinkFollowDialog(boolean r3, tf0.q r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r0 == null) goto L13;
        r0.K2(false, r3, r4);
        return;
    L13:
        return;
    L8:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0 == null) goto L15;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r1 == null) goto L16;
        r1.showFollowGuideDialog(r3, r4);
        return;
    L16:
        return;
    }

    public void switchVoiceSceneWithCheck(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "toScene");
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.T0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.a.a();
        if (r0 == null) goto L6;
        r0.switchVoiceSceneWithCheck(r2, r3);
        return;
    }

    public void updateRealtimeChorusGuestStatus(String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "toUsers");
        s r0 = RealTimeChorusBusinessContext.Companion.c();
        if (r0 == null) goto L6;
        r0.Ch(r3, r4, null);
        return;
    }

    public void cancelApply(Consumer<Boolean> r2, boolean r3, String r4) {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r5 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r5 == null) goto L6;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.b.a(r5, null, false, 7);
        return;
    }

    public Widget createKtvRoomAnchorWidget(com.bytedance.android.live.pushstream.d r2, w0 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        return new KtvRoomAnchorWidget(r2, r3, r4);
    }

    public fd2.l createLyricService(Context r3, int r4, ScrollLyricConfigV2 r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r4 == 1) goto L5;
        return null;
    L5:
        if ((r5 instanceof ScrollLyricConfigV2) == true) goto L7;
        r5 = null;
    L7:
        if (r5 != null) goto L10;
        r5 = new ScrollLyricConfigV2();
    L10:
        return new ScrollLyricService(r3, r5, new com.bytedance.android.livesdk.ktvimpl.base.lyricmodule.b(), new com.bytedance.android.livesdk.ktvimpl.base.lyricmodule.d(r5));
    }

    public Widget createRealTimeChorusRoomAnchorWidget(com.bytedance.android.live.pushstream.d r2, w0 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        return new RealTimeChorusAnchorWidget(r2, r3, r4);
    }

    public LiveDialogFragment getKtvFeedbackDialog(String r7, fd2.c r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        int r1 = KtvFeedbackDialog.u;
        KtvContext.Companion.getClass();
        if (KtvContext.a.c(1) == false) goto L5;
        String r2 = "ksong";
    L7:
        if (KtvContext.a.c(8) == false) goto L9;
    L12:
        int r4 = 9;
    L13:
        boolean r3 = KtvContext.a.c(8);
        boolean r5 = KtvContext.a.c(32);
        boolean r6 = KtvContext.a.c(1);
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        Intrinsics.checkNotNullParameter(r2, "thirdParty");
        KtvFeedbackDialog r0 = new KtvFeedbackDialog();
        r0.h = r7;
        r0.o = r8;
        r0.k = r2;
        r0.j = r4;
        r0.r = r5;
        r0.q = r3;
        r0.p = r6;
        r0.s = r9;
        return r0;
    L9:
        if (KtvContext.a.c(32) == true) goto L12;
        r4 = 0;
        goto L13
    L5:
        r2 = "";
        goto L7
    }

    public IInteractFeedView getKtvRoomFeedView(Context r8, boolean r9, int r10) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return new KtvRoomFeedContainer(r8, null, r9, r10, 32);
    }

    public void initChorusService(Context r4, ViewGroup r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "parent");
        com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.a r2 = com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.b.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.b.a != null) goto L6;
        com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.a r0 = new com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.a();
        com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.b.a = r0;
        r0.g(r4, r5, r6);
        return;
    }

    public fd2.e loadChorusDynamicJsbService(Context r2, DataCenter r3, j1 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        ChorusJsbService r0 = new ChorusJsbService(r2, r3, r4);
        r0.f();
        return r0;
    }

    public Disposable observerCurrentIsSinger(LifecycleOwner r2, boolean r3, Consumer<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        KtvContext.Companion.getClass();
        return KtvContext.a.g().observerCurrentUserIsSinger(r2, r3, r4);
    }

    public static /* synthetic */ OrderedSongDataContext getOrderedSongDataContext$default(KtvService r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        KtvContext.Companion.getClass();
        r1 = KtvContext.a.g().isKtvMode();
    L7:
        return r0.getOrderedSongDataContext(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOrderedSongDataContext");
    }

    public void checkAndApply(int r2, String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "applySource");
        Intrinsics.checkNotNullParameter(r5, "fromSource");
        if (jc0.a.a() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r0 == null) goto L13;
        r0.checkAndApply(r2, r3, r4, r5);
        return;
    L13:
        return;
    L8:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0 == null) goto L15;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r1 == null) goto L16;
        r1.checkAndApply(r2, r3, r4, r5);
        return;
    L16:
        return;
    }

    public void checkAndReply(long r8, String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "secToUserId");
        Intrinsics.checkNotNullParameter(r11, "toUserIdString");
        if (jc0.a.a() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r1 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r1 == null) goto L13;
        r1.checkAndReply(r8, r10, r11, r12);
        return;
    L13:
        return;
    L8:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0 == null) goto L15;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r2 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r2 == null) goto L16;
        r2.checkAndReply(r8, r10, r11, r12);
        return;
    L16:
        return;
    }

    public IInteractFeedView getKtvRoomFeedView(View r7, Context r8, boolean r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "inflatedKtvFeedView");
        if (r8 != null) goto L7;
        return null;
    L7:
        return new KtvRoomFeedContainer(r8, null, r9, r10, 32);
    }

    public void logHighScoreSongLabelClick(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        Intrinsics.checkNotNullParameter(r4, "toUserType");
        Intrinsics.checkNotNullParameter(r5, "liveType");
        Long r0 = KtvLoggerHelper.a;
        KtvLoggerHelper.J(r2, r3, r4, r5);
    }

    public void logHighScoreSongLabelShow(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        Intrinsics.checkNotNullParameter(r4, "toUserType");
        Intrinsics.checkNotNullParameter(r5, "liveType");
        Long r0 = KtvLoggerHelper.a;
        KtvLoggerHelper.K(r2, r3, r4, r5);
    }

    public void showHighScoreSongListDialog(Context r3, String r4, String r5, String r6) {
        if (r3 != null) goto L4;
        return;
    L4:
        boolean r0 = isInKtvState(1);
        boolean r1 = isInKtvState(8);
        if (r0 == false) goto L7;
        String r2 = BDLocationException.ERROR_TIMEOUT;
    L10:
        int r7 = ue2.b.a;
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        ue2.b.a(r3, r4, r5, r6, r2);
        return;
    L7:
        if (r1 == false) goto L9;
        r2 = "1";
        goto L10
    L9:
        r2 = PromotionCategory.CATEGORY_TYPE_SECOND;
        goto L10
    }

    public void switchScene(int r2, int r3, int r4, String r5) {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.T0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.a.a();
        if (r0 == null) goto L6;
        r0.switchScene(r2, r3, r4, r5);
        return;
    }

    public void disconnect(int r8, boolean r9, boolean r10, boolean r11, Function1<? super Boolean, Unit> r12) {
        if (r12 == null) goto L4;
        b r0 = new b(r12);
    L5:
        b r6 = r0;
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L10;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r1 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r1 == null) goto L14;
        r1.disconnect(r8, r9, r10, r11, r6);
        return;
    L14:
        return;
    L10:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r2 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r2 == null) goto L16;
        r2.disconnect(r8, r9, r10, r11, r6);
        return;
    L16:
        return;
    L4:
        r0 = null;
        goto L5
    }

    public void checkMatchAndApply(int r9, String r10, int r11, LinkMatchType r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "applySource");
        Intrinsics.checkNotNullParameter(r12, "matchType");
        Intrinsics.checkNotNullParameter(r13, "fromSource");
        Intrinsics.checkNotNullParameter(r14, "taskName");
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0 == null) goto L8;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r1 == null) goto L9;
        r1.checkAndApply(r9, r10, r11, r12, r13, r14);
        return;
    L9:
        return;
    }

    public fd2.i createKtvComponentCmd(Integer r12, Boolean r13, String r14, Boolean r15, String r16, Integer r17) {
        return new x(r12, r13, r14, null, r15, r16, r17, null, DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE);
    }

    public void switchAudioByClient(boolean r12, List<com.bytedance.android.livesdk.link.model.bridge.k> r13, ClientUIInfo r14, long r15, Map<Long, ? extends g2> r17, String r18) {
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r18, "reason");
        if (jc0.a.a() == false) goto L10;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 == null) goto L22;
        if (r17 == null) goto L9;
        r0.switchAudioByClient(r12, r13, r14, r15, r17, r18);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.Long, com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent>");
    L22:
        return;
    L10:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.T0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.a.a();
        if (r1 == null) goto L16;
        if (r17 == null) goto L15;
        r1.switchAudioByClient(r12, r13, r14, r15, r17, r18);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.Long, com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent>");
    L16:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r2 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r2 == null) goto L24;
        if (r17 == null) goto L21;
        r2.switchAudioByClient(r12, r13, r14, r15, r17, r18);
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.Long, com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent>");
    }

    public x createKtvCommand(Integer r12, Boolean r13, String r14, MusicPanel r15, Boolean r16, String r17, Integer r18) {
        return new x(r12, r13, r14, r15, r16, r17, r18, null, DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE);
    }
}
