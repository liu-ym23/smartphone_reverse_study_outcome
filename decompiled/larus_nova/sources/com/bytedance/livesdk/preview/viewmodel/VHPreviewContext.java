package com.bytedance.livesdk.preview.viewmodel;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.data.IPkExposeData;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.bytedance.livesdk.preview.merge.MergeDataContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b°\u0001\u0010±\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR!\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u001d\u0010'\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010*\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010\u0013R\u001d\u0010/\u001a\u0004\u0018\u00010+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010$\u001a\u0004\b-\u0010.R$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0012\u001a\u0004\b>\u0010\u0013\"\u0004\b?\u0010\u0015R\"\u0010@\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0012\u001a\u0004\b@\u0010\u0013\"\u0004\bA\u0010\u0015R$\u0010B\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u00109\u001a\u0004\bC\u0010;\"\u0004\bD\u0010=R\"\u0010E\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0012\u001a\u0004\bE\u0010\u0013\"\u0004\bF\u0010\u0015R!\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00100G8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u001b\u001a\u0004\bI\u0010JR!\u0010M\u001a\b\u0012\u0004\u0012\u00020\t0G8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u001b\u001a\u0004\bL\u0010JR!\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00100G8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u001b\u001a\u0004\bO\u0010JR!\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00100G8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u001b\u001a\u0004\bR\u0010JR\"\u0010T\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010\u0012\u001a\u0004\bT\u0010\u0013\"\u0004\bU\u0010\u0015R!\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00100G8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u001b\u001a\u0004\bW\u0010JR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010`\u001a\u00020Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010[\u001a\u0004\ba\u0010]\"\u0004\bb\u0010_R\"\u0010c\u001a\u00020Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010[\u001a\u0004\bd\u0010]\"\u0004\be\u0010_R*\u0010g\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0017\u0010n\u001a\u00020m8\u0006¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\"\u0010r\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u00109\u001a\u0004\bs\u0010;\"\u0004\bt\u0010=R\"\u0010u\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010\u0012\u001a\u0004\bv\u0010\u0013\"\u0004\bw\u0010\u0015R$\u0010y\u001a\u0004\u0018\u00010x8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R$\u0010\u007f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010\u000b\u001a\u0005\b\u0080\u0001\u0010\r\"\u0005\b\u0081\u0001\u0010\u000fR&\u0010\u0082\u0001\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010\u0012\u001a\u0005\b\u0082\u0001\u0010\u0013\"\u0005\b\u0083\u0001\u0010\u0015R&\u0010\u0084\u0001\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010\u0012\u001a\u0005\b\u0084\u0001\u0010\u0013\"\u0005\b\u0085\u0001\u0010\u0015R%\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010\u00188FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010\u001b\u001a\u0005\b\u0088\u0001\u0010\u001dR&\u0010\u008a\u0001\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\u0012\u001a\u0005\b\u008b\u0001\u0010\u0013\"\u0005\b\u008c\u0001\u0010\u0015R$\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100\u00188FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008d\u0001\u0010\u001b\u001a\u0005\b\u008e\u0001\u0010\u001dR&\u0010\u0090\u0001\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u00109\u001a\u0005\b\u0091\u0001\u0010;\"\u0005\b\u0092\u0001\u0010=R&\u0010\u0093\u0001\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u00109\u001a\u0005\b\u0094\u0001\u0010;\"\u0005\b\u0095\u0001\u0010=R&\u0010\u0096\u0001\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u00109\u001a\u0005\b\u0097\u0001\u0010;\"\u0005\b\u0098\u0001\u0010=R&\u0010\u0099\u0001\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u00109\u001a\u0005\b\u009a\u0001\u0010;\"\u0005\b\u009b\u0001\u0010=R*\u0010\u009d\u0001\u001a\u00030\u009c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R&\u0010£\u0001\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b£\u0001\u0010\u0012\u001a\u0005\b£\u0001\u0010\u0013\"\u0005\b¤\u0001\u0010\u0015R$\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020\t0G8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¥\u0001\u0010\u001b\u001a\u0005\b¦\u0001\u0010JR'\u0010\u00ad\u0001\u001a\n\u0012\u0005\u0012\u00030©\u00010¨\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\bª\u0001\u0010\u001b\u001a\u0006\b«\u0001\u0010¬\u0001R\u0013\u0010¯\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\b®\u0001\u0010\r¨\u0006²\u0001"}, d2 = {"Lcom/bytedance/livesdk/preview/viewmodel/VHPreviewContext;", "Lcom/bytedance/livesdk/preview/merge/MergeDataContext;", "Landroidx/fragment/app/Fragment;", "mFragment", "Landroidx/fragment/app/Fragment;", "getMFragment", "()Landroidx/fragment/app/Fragment;", "setMFragment", "(Landroidx/fragment/app/Fragment;)V", "", "adSourceType", "I", "getAdSourceType", "()I", "setAdSourceType", "(I)V", "", "isHardAd", "Z", "()Z", "setHardAd", "(Z)V", "isAd", "setAd", "Lcom/bytedance/live/datacontext/k;", "", "doAdapterEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "getDoAdapterEvent", "()Lcom/bytedance/live/datacontext/k;", "doAdapterEvent", "updateLeftAreaGroupPadding$delegate", "getUpdateLeftAreaGroupPadding", "updateLeftAreaGroupPadding", "Lxk6/b;", "liveVHEventOpt$delegate", "Lkotlin/Lazy;", "getLiveVHEventOpt", "()Lxk6/b;", "liveVHEventOpt", "alogOpt$delegate", "getAlogOpt", "alogOpt", "Lxk6/a;", "livePlayerOpt$delegate", "getLivePlayerOpt", "()Lxk6/a;", "livePlayerOpt", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "mRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getMRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "setMRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;)V", "", "mOwnerNickname", "Ljava/lang/String;", "getMOwnerNickname", "()Ljava/lang/String;", "setMOwnerNickname", "(Ljava/lang/String;)V", "isFromOutflowClick", "setFromOutflowClick", "isHighLightShowed", "setHighLightShowed", "resumeType", "getResumeType", "setResumeType", "isInPreviewMixMode", "setInPreviewMixMode", "Lcom/bytedance/live/datacontext/m;", "isAlive$delegate", "isAlive", "()Lcom/bytedance/live/datacontext/m;", "widgetStreamState$delegate", "getWidgetStreamState", "widgetStreamState", "hasFilterReason$delegate", "getHasFilterReason", "hasFilterReason", "micRoomChange$delegate", "getMicRoomChange", "micRoomChange", "isClickWhenPluginInstall", "setClickWhenPluginInstall", "pluginInstallSuccess$delegate", "getPluginInstallSuccess", "pluginInstallSuccess", "", "mStartShowTime", "J", "getMStartShowTime", "()J", "setMStartShowTime", "(J)V", "mStartPlayTime", "getMStartPlayTime", "setMStartPlayTime", "mTempWatchEndTime", "getMTempWatchEndTime", "setMTempWatchEndTime", "Lkotlin/Function0;", "previewClickAction", "Lkotlin/jvm/functions/Function0;", "getPreviewClickAction", "()Lkotlin/jvm/functions/Function0;", "setPreviewClickAction", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/os/Handler;", "mMainHandler", "Landroid/os/Handler;", "getMMainHandler", "()Landroid/os/Handler;", "enterFromMergeWormhole", "getEnterFromMergeWormhole", "setEnterFromMergeWormhole", "resumePlay", "getResumePlay", "setResumePlay", "Lcom/bytedance/livesdk/preview/msg/a;", "mMessageManager", "Lcom/bytedance/livesdk/preview/msg/a;", "getMMessageManager", "()Lcom/bytedance/livesdk/preview/msg/a;", "setMMessageManager", "(Lcom/bytedance/livesdk/preview/msg/a;)V", "awemeFromPage", "getAwemeFromPage", "setAwemeFromPage", "isLandeScapeActionShowing", "setLandeScapeActionShowing", "isCleanScreenActionShowing", "setCleanScreenActionShowing", "Lcom/bytedance/android/livesdkapi/feed/data/IPkExposeData;", "pkStatusChange$delegate", "getPkStatusChange", "pkStatusChange", "searchPreviewGeneralMobControl", "getSearchPreviewGeneralMobControl", "setSearchPreviewGeneralMobControl", "showTab$delegate", "getShowTab", "showTab", "backgroundSource", "getBackgroundSource", "setBackgroundSource", "tabLabel", "getTabLabel", "setTabLabel", "sourceUniqueId", "getSourceUniqueId", "setSourceUniqueId", "enterMethodValue", "getEnterMethodValue", "setEnterMethodValue", "Lcom/bytedance/livesdk/preview/viewmodel/PreviewViewHolderType;", "fromViewHolderName", "Lcom/bytedance/livesdk/preview/viewmodel/PreviewViewHolderType;", "getFromViewHolderName", "()Lcom/bytedance/livesdk/preview/viewmodel/PreviewViewHolderType;", "setFromViewHolderName", "(Lcom/bytedance/livesdk/preview/viewmodel/PreviewViewHolderType;)V", "isEnterFromPluginPreview", "setEnterFromPluginPreview", "backPreviewCountDownForAutoScroll$delegate", "getBackPreviewCountDownForAutoScroll", "backPreviewCountDownForAutoScroll", "Lcom/bytedance/live/datacontext/i;", "Landroid/os/Bundle;", "customArgs$delegate", "getCustomArgs", "()Lcom/bytedance/live/datacontext/i;", "customArgs", "getFeedType", "feedType", "<init>", "()V", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VHPreviewContext extends MergeDataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private int adSourceType;
    private final Lazy alogOpt$delegate;
    private int awemeFromPage;
    private final p backPreviewCountDownForAutoScroll$delegate;
    private String backgroundSource;
    private final p customArgs$delegate;
    private final p doAdapterEvent$delegate;
    private String enterFromMergeWormhole;
    private String enterMethodValue;
    private PreviewViewHolderType fromViewHolderName;
    private final p hasFilterReason$delegate;
    private boolean isAd;
    private final p isAlive$delegate;
    private boolean isCleanScreenActionShowing;
    private boolean isClickWhenPluginInstall;
    private boolean isEnterFromPluginPreview;
    private boolean isFromOutflowClick;
    private boolean isHardAd;
    private boolean isHighLightShowed;
    private boolean isInPreviewMixMode;
    private boolean isLandeScapeActionShowing;
    private final Lazy livePlayerOpt$delegate;
    private final Lazy liveVHEventOpt$delegate;
    private Fragment mFragment;
    private final Handler mMainHandler;
    private com.bytedance.livesdk.preview.msg.a mMessageManager;
    private String mOwnerNickname;
    private Room mRoom;
    private long mStartPlayTime;
    private long mStartShowTime;
    private long mTempWatchEndTime;
    private final p micRoomChange$delegate;
    private final p pkStatusChange$delegate;
    private final p pluginInstallSuccess$delegate;
    private Function0<Unit> previewClickAction;
    private boolean resumePlay;
    private String resumeType;
    private boolean searchPreviewGeneralMobControl;
    private final p showTab$delegate;
    private String sourceUniqueId;
    private String tabLabel;
    private final p updateLeftAreaGroupPadding$delegate;
    private final p widgetStreamState$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(VHPreviewContext.class, "doAdapterEvent", "getDoAdapterEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(VHPreviewContext.class, "updateLeftAreaGroupPadding", "getUpdateLeftAreaGroupPadding()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(VHPreviewContext.class, "isAlive", "isAlive()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VHPreviewContext.class, "widgetStreamState", "getWidgetStreamState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VHPreviewContext.class, "hasFilterReason", "getHasFilterReason()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VHPreviewContext.class, "micRoomChange", "getMicRoomChange()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VHPreviewContext.class, "pluginInstallSuccess", "getPluginInstallSuccess()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VHPreviewContext.class, "pkStatusChange", "getPkStatusChange()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(VHPreviewContext.class, "showTab", "getShowTab()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(VHPreviewContext.class, "backPreviewCountDownForAutoScroll", "getBackPreviewCountDownForAutoScroll()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VHPreviewContext.class, "customArgs", "getCustomArgs()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0))};
    }

    private final xk6.b getLiveVHEventOpt() {
        return (xk6.b) this.liveVHEventOpt$delegate.getValue();
    }

    public final boolean getAlogOpt() {
        return ((Boolean) this.alogOpt$delegate.getValue()).booleanValue();
    }

    public final m<Integer> getBackPreviewCountDownForAutoScroll() {
        return (m) this.backPreviewCountDownForAutoScroll$delegate.a(this, $$delegatedProperties[9]);
    }

    public final i<Bundle> getCustomArgs() {
        return (i) this.customArgs$delegate.a(this, $$delegatedProperties[10]);
    }

    public final k<Unit> getDoAdapterEvent() {
        return (k) this.doAdapterEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Boolean> getHasFilterReason() {
        return (m) this.hasFilterReason$delegate.a(this, $$delegatedProperties[4]);
    }

    public final xk6.a getLivePlayerOpt() {
        return (xk6.a) this.livePlayerOpt$delegate.getValue();
    }

    public final com.bytedance.livesdk.preview.msg.a getMMessageManager() {
        return null;
    }

    public final m<Boolean> getMicRoomChange() {
        return (m) this.micRoomChange$delegate.a(this, $$delegatedProperties[5]);
    }

    public final k<IPkExposeData> getPkStatusChange() {
        return (k) this.pkStatusChange$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<Boolean> getPluginInstallSuccess() {
        return (m) this.pluginInstallSuccess$delegate.a(this, $$delegatedProperties[6]);
    }

    public final k<Boolean> getShowTab() {
        return (k) this.showTab$delegate.a(this, $$delegatedProperties[8]);
    }

    public final k<Integer> getUpdateLeftAreaGroupPadding() {
        return (k) this.updateLeftAreaGroupPadding$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Integer> getWidgetStreamState() {
        return (m) this.widgetStreamState$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Boolean> isAlive() {
        return (m) this.isAlive$delegate.a(this, $$delegatedProperties[2]);
    }

    public final void setMMessageManager(com.bytedance.livesdk.preview.msg.a r100) {
    }

    public VHPreviewContext() {
        this.doAdapterEvent$delegate = e.b(this);
        this.updateLeftAreaGroupPadding$delegate = e.b(this);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        this.liveVHEventOpt$delegate = LazyKt.lazy(r100, VHPreviewContext$liveVHEventOpt$2.INSTANCE);
        this.alogOpt$delegate = LazyKt.lazy(r100, new VHPreviewContext$alogOpt$2(this));
        this.livePlayerOpt$delegate = LazyKt.lazy(r100, VHPreviewContext$livePlayerOpt$2.INSTANCE);
        Boolean r101 = Boolean.TRUE;
        this.isAlive$delegate = q.d(this, r101);
        this.widgetStreamState$delegate = q.d(this, 0);
        Boolean r102 = Boolean.FALSE;
        this.hasFilterReason$delegate = q.d(this, r102);
        this.micRoomChange$delegate = q.d(this, r102);
        this.pluginInstallSuccess$delegate = q.d(this, r101);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.enterFromMergeWormhole = "";
        this.awemeFromPage = -1;
        this.pkStatusChange$delegate = e.b(this);
        this.showTab$delegate = e.b(this);
        this.backgroundSource = "";
        this.tabLabel = "";
        this.sourceUniqueId = "";
        this.enterMethodValue = "click";
        this.fromViewHolderName = PreviewViewHolderType.DEFAUT;
        this.backPreviewCountDownForAutoScroll$delegate = q.d(this, 0);
        this.customArgs$delegate = ConstantKt.d(this, new Bundle());
    }

    public final int getFeedType() {
        String r100 = getEnterFromMerge();
        int r101 = r100.hashCode();
        if (r101 == (-1842036323)) goto L16;
        if (r101 == (-1271119582)) goto L13;
        if (r101 == 1691937916) goto L10;
    L18:
        return -1;
    L10:
        if (r100.equals(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT) == false) goto L18;
        return 2;
    L13:
        if (r100.equals("homepage_follow") == false) goto L18;
        return 1;
    L16:
        if (r100.equals("homepage_fresh") == false) goto L18;
        return 0;
    }

    public final int getAdSourceType() {
        return this.adSourceType;
    }

    public final int getAwemeFromPage() {
        return this.awemeFromPage;
    }

    public final String getBackgroundSource() {
        return this.backgroundSource;
    }

    public final String getEnterFromMergeWormhole() {
        return this.enterFromMergeWormhole;
    }

    public final String getEnterMethodValue() {
        return this.enterMethodValue;
    }

    public final PreviewViewHolderType getFromViewHolderName() {
        return this.fromViewHolderName;
    }

    public final Fragment getMFragment() {
        return this.mFragment;
    }

    public final Handler getMMainHandler() {
        return this.mMainHandler;
    }

    public final String getMOwnerNickname() {
        return this.mOwnerNickname;
    }

    public final Room getMRoom() {
        return this.mRoom;
    }

    public final long getMStartPlayTime() {
        return this.mStartPlayTime;
    }

    public final long getMStartShowTime() {
        return this.mStartShowTime;
    }

    public final long getMTempWatchEndTime() {
        return this.mTempWatchEndTime;
    }

    public final Function0<Unit> getPreviewClickAction() {
        return this.previewClickAction;
    }

    public final boolean getResumePlay() {
        return this.resumePlay;
    }

    public final String getResumeType() {
        return this.resumeType;
    }

    public final boolean getSearchPreviewGeneralMobControl() {
        return this.searchPreviewGeneralMobControl;
    }

    public final String getSourceUniqueId() {
        return this.sourceUniqueId;
    }

    public final String getTabLabel() {
        return this.tabLabel;
    }

    public final boolean isAd() {
        return this.isAd;
    }

    public final boolean isCleanScreenActionShowing() {
        return this.isCleanScreenActionShowing;
    }

    public final boolean isClickWhenPluginInstall() {
        return this.isClickWhenPluginInstall;
    }

    public final boolean isEnterFromPluginPreview() {
        return this.isEnterFromPluginPreview;
    }

    public final boolean isFromOutflowClick() {
        return this.isFromOutflowClick;
    }

    public final boolean isHardAd() {
        return this.isHardAd;
    }

    public final boolean isHighLightShowed() {
        return this.isHighLightShowed;
    }

    public final boolean isInPreviewMixMode() {
        return this.isInPreviewMixMode;
    }

    public final boolean isLandeScapeActionShowing() {
        return this.isLandeScapeActionShowing;
    }

    public static final /* synthetic */ xk6.b access$getLiveVHEventOpt$p(VHPreviewContext r100) {
        return r100.getLiveVHEventOpt();
    }

    public final void setAd(boolean r100) {
        this.isAd = r100;
    }

    public final void setAdSourceType(int r100) {
        this.adSourceType = r100;
    }

    public final void setAwemeFromPage(int r100) {
        this.awemeFromPage = r100;
    }

    public final void setBackgroundSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.backgroundSource = r100;
    }

    public final void setCleanScreenActionShowing(boolean r100) {
        this.isCleanScreenActionShowing = r100;
    }

    public final void setClickWhenPluginInstall(boolean r100) {
        this.isClickWhenPluginInstall = r100;
    }

    public final void setEnterFromMergeWormhole(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFromMergeWormhole = r100;
    }

    public final void setEnterFromPluginPreview(boolean r100) {
        this.isEnterFromPluginPreview = r100;
    }

    public final void setEnterMethodValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethodValue = r100;
    }

    public final void setFromOutflowClick(boolean r100) {
        this.isFromOutflowClick = r100;
    }

    public final void setFromViewHolderName(PreviewViewHolderType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fromViewHolderName = r100;
    }

    public final void setHardAd(boolean r100) {
        this.isHardAd = r100;
    }

    public final void setHighLightShowed(boolean r100) {
        this.isHighLightShowed = r100;
    }

    public final void setInPreviewMixMode(boolean r100) {
        this.isInPreviewMixMode = r100;
    }

    public final void setLandeScapeActionShowing(boolean r100) {
        this.isLandeScapeActionShowing = r100;
    }

    public final void setMFragment(Fragment r100) {
        this.mFragment = r100;
    }

    public final void setMOwnerNickname(String r100) {
        this.mOwnerNickname = r100;
    }

    public final void setMRoom(Room r100) {
        this.mRoom = r100;
    }

    public final void setMStartPlayTime(long r100) {
        this.mStartPlayTime = r100;
    }

    public final void setMStartShowTime(long r100) {
        this.mStartShowTime = r100;
    }

    public final void setMTempWatchEndTime(long r100) {
        this.mTempWatchEndTime = r100;
    }

    public final void setPreviewClickAction(Function0<Unit> r100) {
        this.previewClickAction = r100;
    }

    public final void setResumePlay(boolean r100) {
        this.resumePlay = r100;
    }

    public final void setResumeType(String r100) {
        this.resumeType = r100;
    }

    public final void setSearchPreviewGeneralMobControl(boolean r100) {
        this.searchPreviewGeneralMobControl = r100;
    }

    public final void setSourceUniqueId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sourceUniqueId = r100;
    }

    public final void setTabLabel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabLabel = r100;
    }
}
