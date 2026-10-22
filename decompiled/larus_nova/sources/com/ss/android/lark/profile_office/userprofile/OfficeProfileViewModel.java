package com.ss.android.lark.profile_office.userprofile;

import android.text.TextUtils;
import android.util.Base64;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.StatusEffectiveInterval;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileRequest;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import com.google.gson.Gson;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.NetworkUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.biz.im.api.extension.message.TaskType;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKBizConfigProvider;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.profile.core.model.TnsReportConfig;
import com.ss.android.lark.profile.dto.ProfileFinishResult;
import com.ss.android.lark.profile_office.OfficeProfileModule;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.e0;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.f0;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderLine;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.VideoRef;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 i2\u00020\u0001:\u0001iB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J&\u0010-\u001a\u00020*2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010.\u001a\u00020*H\u0002J\b\u0010/\u001a\u00020*H\u0002J\b\u00100\u001a\u00020*H\u0002J\u0016\u00101\u001a\u00020\r2\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0002J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u000204052\u0006\u00106\u001a\u00020\rH\u0082@¢\u0006\u0002\u00107J\b\u00108\u001a\u00020*H\u0002J\u0016\u00109\u001a\u00020*2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0002J\b\u0010=\u001a\u00020*H\u0002J\b\u0010>\u001a\u00020*H\u0002J\b\u0010?\u001a\u00020*H\u0002J\u0010\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020\"H\u0002J\u0018\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020\"2\u0006\u0010D\u001a\u00020\"H\u0002J\b\u0010G\u001a\u00020*H\u0002J\u0010\u0010H\u001a\u00020*2\u0006\u0010I\u001a\u00020\rH\u0002J\b\u0010J\u001a\u00020*H\u0002J\u0010\u0010K\u001a\u00020*2\u0006\u0010L\u001a\u00020\"H\u0002J\u0010\u0010M\u001a\u00020*2\u0006\u0010N\u001a\u00020\"H\u0002J!\u0010O\u001a\u00020*2\u0017\u0010P\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110Q¢\u0006\u0002\bRH\u0002J!\u0010S\u001a\u00020*2\u0017\u0010P\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170Q¢\u0006\u0002\bRH\u0002J$\u0010T\u001a\u00020\u0011*\u00020\u00112\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001052\u0006\u0010U\u001a\u00020\rH\u0002J\b\u0010V\u001a\u00020*H\u0002J\b\u0010W\u001a\u00020*H\u0002J\b\u0010X\u001a\u00020*H\u0014J\u0016\u0010Y\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010ZJ\u0010\u0010[\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\\\u001a\u00020\"2\u0006\u0010]\u001a\u00020^H\u0002J\b\u0010_\u001a\u0004\u0018\u00010`J\u0006\u0010a\u001a\u00020\"J\b\u0010b\u001a\u00020\"H\u0002J\u0018\u0010c\u001a\u00020\"2\u0006\u0010F\u001a\u00020\"2\u0006\u0010d\u001a\u00020\"H\u0002J\u0018\u0010e\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010\"H\u0082@¢\u0006\u0002\u0010hR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/ss/android/lark/profile_office/userprofile/OfficeProfileViewModel;", "Landroidx/lifecycle/ViewModel;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/ss/android/lark/profile_office/userprofile/OfficeProfileModel;", "officeProfileProtocol", "Lcom/ss/android/lark/profile_office_api/IOfficeProfileProtocol;", "officeSDKTokenProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;", "<init>", "(Lcom/ss/android/lark/profile_office/userprofile/OfficeProfileModel;Lcom/ss/android/lark/profile_office_api/IOfficeProfileProtocol;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;)V", "getOfficeProfileProtocol", "()Lcom/ss/android/lark/profile_office_api/IOfficeProfileProtocol;", "isIMEnabled", "", "isLoginBUser", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/profile_office/userprofile/OfficeProfileState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "_dialogState", "Lcom/ss/android/lark/profile_office/userprofile/OfficeProfileDialogState;", "dialogState", "getDialogState", "_effect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/profile_office/userprofile/ProfileEffect;", "effect", "Lkotlinx/coroutines/flow/SharedFlow;", "getEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "userId", "", "token", "source", "Lcom/ss/android/lark/contact/export/ContactSource;", "hasReportedEnterPage", "signUrlPreviewPushListener", "Lcom/ss/android/lark/chatpreview/ISignUrlPreviewPushListener;", "dispatch", "", "intent", "Lcom/ss/android/lark/profile_office/userprofile/ProfileIntent;", "init", "reload", "loadProfile", "updateProfile", "loadIsOnLeave", "response", "Lcom/ss/android/lark/profile/core/model/Response$Success;", "Lcom/bytedance/lark/pb/contact/v2/GetDoubaoProfileResponse;", "Lcom/ss/android/lark/profile/core/model/Response;", RenderLine.STRATEGY_SERVER, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadDescriptionSpan", "handleSignUrlPreviewPush", "entriesList", "", "Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries;", "loadDoubaoUserInfo", "loadDoubaoHomepageData", "markChatApplicationMeReadIfNeeded", "handleCtaClick", "cta", "Lcom/bytedance/lark/pb/contact/v2/GetDoubaoProfileResponse$CTAInfo;", "saveAlias", "alias", "applyFriend", "message", "acceptFriend", "blockUser", "isBlock", "deleteFriend", "reportEnterPageIfNeeded", "doubaoUserId", "reportHomePageClick", "click", "updateState", "transform", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "updateDialogState", "withProfileResponse", "isServerResponse", "registerUrlPreviewsPush", "unRegisterUrlPreviewPush", "onCleared", "emitEffect", "(Lcom/ss/android/lark/profile_office/userprofile/ProfileEffect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitEffectAsync", "getRequestFailToastMessage", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getFinishResult", "Lcom/ss/android/lark/profile/dto/ProfileFinishResult;", "getReportUrl", "getLanguageLocaleTag", LBSLightLocationTraceLogger.ENCRYPT, "key", "parseDoubaoData", "Lcom/ss/android/lark/profile_office/userprofile/model/DoubaoData;", "extraInfo", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "profile-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeProfileViewModel extends ViewModel {
    public static final int $stable = 0;
    private static final String AES_MODE = "AES/CBC/PKCS7Padding";
    private static final String CIPHER = "AES";
    public static final a Companion = null;
    private static final int KEY_LENGTH = 16;
    private static final String ON_LEAVE_STATUS_ICON_KEY = "GeneralVacation";
    private static final String PROVIDER = "BC";
    private static final String TAG = "OfficeProfileViewModel";
    private final z0<d> _dialogState;
    private final MutableSharedFlow<j> _effect;
    private final z0<OfficeProfileState> _state;
    private final i1<d> dialogState;
    private final d1<j> effect;
    private boolean hasReportedEnterPage;
    private final boolean isIMEnabled;
    private final boolean isLoginBUser;
    private final OfficeProfileModel model;
    private final x1c.d officeProfileProtocol;
    private final d7b.a signUrlPreviewPushListener;
    private ContactSource source;
    private final i1<OfficeProfileState> state;
    private String token;
    private String userId;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$acceptFriend$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$acceptFriend$1", f = "OfficeProfileViewModel.kt", i = {}, l = {450, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public AnonymousClass1(OfficeProfileViewModel r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$acceptFriend$2$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L31:
            OfficeProfileViewModel.access$updateState(this.this$0, AnonymousClass2.INSTANCE);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L25:
            q1c.b r103 = (q1c.b) r100;
            if ((!(r103 instanceof q1c.b.a)) == false) goto L28;
            OfficeProfileViewModel.access$updateProfile(this.this$0);
            goto L31
        L28:
            OfficeProfileViewModel r104 = this.this$0;
            j.k r105 = new j.k(OfficeProfileViewModel.access$getRequestFailToastMessage(r104, ((q1c.b.a) r103).f531322a));
            this.label = 2;
            if (OfficeProfileViewModel.access$emitEffect(r104, r105, this) != r101) goto L31;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            OfficeProfileViewModel.access$updateState(this.this$0, C52521.INSTANCE);
            OfficeProfileState r106 = (OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue();
            OfficeProfileModel r107 = OfficeProfileViewModel.access$getModel$p(this.this$0);
            q1c.b<GetDoubaoProfileResponse> r108 = r106.f438887a;
            if (r108 == null) goto L17;
            GetDoubaoProfileResponse r109 = r108.a();
            if (r109 == null) goto L17;
            GetDoubaoProfileResponse.UserInfo r110 = r109.user_info;
            if (r110 == null) goto L17;
            String r111 = r110.contact_application_id;
        L18:
            if (r111 != null) goto L20;
            r111 = "";
        L20:
            this.label = 1;
            r107.getClass();
            final kotlinx.coroutines.j r112 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r112.C();
            Log.i("OfficeProfileModel", "start acceptFriend, applicationId: ".concat(r111));
            OfficeProfileModule.a().getContactDependency().a(r111, new OfficeProfileModel$acceptFriend$2$1(r112));
            r100 = r112.B();
            if (r100 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
            DebugProbesKt.probeCoroutineSuspended(this);
        L23:
            if (r100 != r101) goto L25;
            return r101;
        L17:
            r111 = null;
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$applyFriend$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$applyFriend$1", f = "OfficeProfileViewModel.kt", i = {}, l = {430, 440}, m = "invokeSuspend", n = {}, s = {})
    public static final class C120991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $alias;
        final /* synthetic */ String $message;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C120991(OfficeProfileViewModel r100, String r101, String r102, Continuation<? super C120991> r103) {
            this.this$0 = r100;
            this.$message = r101;
            this.$alias = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C120991(this.this$0, this.$message, this.$alias, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C120991) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v0, types: [com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$applyFriend$2$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            ResultKt.throwOnFailure(r110);
        L21:
            OfficeProfileViewModel.access$updateDialogState(this.this$0, AnonymousClass3.INSTANCE);
        L23:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r110);
        L15:
            q1c.b r111 = (q1c.b) r110;
            if ((!(r111 instanceof q1c.b.a)) == false) goto L18;
            OfficeProfileViewModel.access$updateDialogState(this.this$0, AnonymousClass2.INSTANCE);
            OfficeProfileViewModel.access$updateProfile(this.this$0);
            goto L23
        L18:
            OfficeProfileViewModel r102 = this.this$0;
            j.k r103 = new j.k(OfficeProfileViewModel.access$getRequestFailToastMessage(r102, ((q1c.b.a) r111).f531322a));
            this.label = 2;
            if (OfficeProfileViewModel.access$emitEffect(r102, r103, this) != r100) goto L21;
            return r100;
        L10:
            ResultKt.throwOnFailure(r110);
            OfficeProfileViewModel.access$updateDialogState(this.this$0, C52531.INSTANCE);
            OfficeProfileState r112 = (OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue();
            OfficeProfileModel r104 = OfficeProfileViewModel.access$getModel$p(this.this$0);
            String r105 = r112.l();
            String r106 = this.$message;
            String r107 = this.$alias;
            ContactSource r108 = OfficeProfileViewModel.access$getSource$p(this.this$0);
            this.label = 1;
            r104.getClass();
            final kotlinx.coroutines.j r113 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r113.C();
            Log.i("OfficeProfileModel", "start applyFriend, userId: " + r105 + ", alias: " + r107);
            OfficeProfileModule.a().getContactDependency().b(r105, r106, r107, r108, new OfficeProfileModel$applyFriend$2$1(r113));
            r110 = r113.B();
            if (r110 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
            DebugProbesKt.probeCoroutineSuspended(this);
        L13:
            if (r110 != r100) goto L15;
            return r100;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f438902a = null;

        static {
            int[] r100 = new int[GetDoubaoProfileResponse.CTAType.values().length];
            r100[GetDoubaoProfileResponse.CTAType.CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f438902a = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$blockUser$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$blockUser$1", f = "OfficeProfileViewModel.kt", i = {}, l = {471, 484}, m = "invokeSuspend", n = {}, s = {})
    public static final class C121001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isBlock;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C121001(OfficeProfileViewModel r100, boolean r101, Continuation<? super C121001> r102) {
            this.this$0 = r100;
            this.$isBlock = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C121001(this.this$0, this.$isBlock, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C121001) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v3, types: [com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$blockUser$2$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L22:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L15:
            q1c.b r103 = (q1c.b) r100;
            if ((!(r103 instanceof q1c.b.a)) == false) goto L18;
            OfficeProfileViewModel r104 = this.this$0;
            final boolean r105 = this.$isBlock;
            OfficeProfileViewModel.access$updateState(r104, new AnonymousClass2(r105));
            OfficeProfileViewModel.access$updateProfile(this.this$0);
            goto L22
        L18:
            final OfficeProfileViewModel r106 = this.this$0;
            OfficeProfileViewModel.access$updateState(r106, new AnonymousClass3(r106));
            OfficeProfileViewModel r107 = this.this$0;
            j.k r108 = new j.k(OfficeProfileViewModel.access$getRequestFailToastMessage(r107, ((q1c.b.a) r103).f531322a));
            this.label = 2;
            if (OfficeProfileViewModel.access$emitEffect(r107, r108, this) != r101) goto L22;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            final OfficeProfileViewModel r109 = this.this$0;
            OfficeProfileViewModel.access$updateState(r109, new C52541(r109));
            OfficeProfileState r110 = (OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue();
            OfficeProfileModel r111 = OfficeProfileViewModel.access$getModel$p(this.this$0);
            String r112 = r110.l();
            boolean r113 = this.$isBlock;
            this.label = 1;
            r111.getClass();
            final kotlinx.coroutines.j r114 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r114.C();
            Log.i("OfficeProfileModel", "start blockUser, userId: " + r112 + ", isBlock: " + r113);
            OfficeProfileModule.a().getContactDependency().e(r112, r113, new OfficeProfileModel$blockUser$2$1(r114));
            r100 = r114.B();
            if (r100 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
            DebugProbesKt.probeCoroutineSuspended(this);
        L13:
            if (r100 != r101) goto L15;
            return r101;
        }
    }

    public static final class c implements d7b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeProfileViewModel f438903a;

        public c(OfficeProfileViewModel r100) {
            this.f438903a = r100;
        }

        @Override // d7b.a
        public final void onPushSignUrlPreview(List<UrlPreViewEntries> r100) {
            Intrinsics.checkNotNullParameter(r100, "entriesList");
            OfficeProfileViewModel.access$handleSignUrlPreviewPush(this.f438903a, r100);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$deleteFriend$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$deleteFriend$1", f = "OfficeProfileViewModel.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_USE_FALLBACK_API, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_ABR, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT}, m = "invokeSuspend", n = {}, s = {})
    public static final class C121011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C121011(OfficeProfileViewModel r100, Continuation<? super C121011> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C121011(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C121011) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v1, types: [com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$deleteFriend$2$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L12;
            if (r102 == 1) goto L11;
            if (r102 == 2) goto L10;
            if (r102 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r100);
        L26:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r100);
        L17:
            q1c.b r103 = (q1c.b) r100;
            if ((!(r103 instanceof q1c.b.a)) == false) goto L22;
            OfficeProfileViewModel r104 = this.this$0;
            j.a r105 = j.a.f438932a;
            this.label = 2;
            if (OfficeProfileViewModel.access$emitEffect(r104, r105, this) != r101) goto L26;
            return r101;
        L22:
            OfficeProfileViewModel r106 = this.this$0;
            j.k r107 = new j.k(OfficeProfileViewModel.access$getRequestFailToastMessage(r106, ((q1c.b.a) r103).f531322a));
            this.label = 3;
            if (OfficeProfileViewModel.access$emitEffect(r106, r107, this) != r101) goto L26;
            return r101;
        L12:
            ResultKt.throwOnFailure(r100);
            OfficeProfileState r108 = (OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue();
            OfficeProfileModel r109 = OfficeProfileViewModel.access$getModel$p(this.this$0);
            String r110 = r108.l();
            this.label = 1;
            r109.getClass();
            final kotlinx.coroutines.j r111 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r111.C();
            Log.i("OfficeProfileModel", "start deleteFriend, userId: ".concat(r110));
            OfficeProfileModule.a().getContactDependency().c(r110, new OfficeProfileModel$deleteFriend$2$1(r111));
            r100 = r111.B();
            if (r100 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
            DebugProbesKt.probeCoroutineSuspended(this);
        L15:
            if (r100 != r101) goto L17;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$emitEffectAsync$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$emitEffectAsync$1", f = "OfficeProfileViewModel.kt", i = {}, l = {570}, m = "invokeSuspend", n = {}, s = {})
    public static final class C121031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ j $effect;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C121031(OfficeProfileViewModel r100, j r101, Continuation<? super C121031> r102) {
            this.this$0 = r100;
            this.$effect = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C121031(this.this$0, this.$effect, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C121031) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            OfficeProfileViewModel r103 = this.this$0;
            j r104 = this.$effect;
            this.label = 1;
            if (OfficeProfileViewModel.access$emitEffect(r103, r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$handleSignUrlPreviewPush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$handleSignUrlPreviewPush$1", f = "OfficeProfileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C121041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<UrlPreViewEntries> $entriesList;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C121041(OfficeProfileViewModel r100, List<UrlPreViewEntries> r101, Continuation<? super C121041> r102) {
            this.this$0 = r100;
            this.$entriesList = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C121041(this.this$0, this.$entriesList, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C121041) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L23;
            ResultKt.throwOnFailure(r100);
            OfficeProfileState r101 = (OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue();
            String r102 = r101.g();
            final String r103 = r101.l();
            boolean r104 = false;
            if (r102.length() != 0) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L21;
            if (r103.length() != 0) goto L12;
            boolean r106 = true;
        L13:
            if (r106 == true) goto L21;
            Log.i(OfficeProfileViewModel.TAG, "handleSignUrlPreviewPush, userId=" + r103 + ", size=" + this.$entriesList.size());
            final Map<String, RecogniseSpansResult> r107 = OfficeProfileModule.a().getChatDependency().a(this.$entriesList, r102, r103, r101.f());
            StringBuilder r108 = new StringBuilder("handleSignUrlPreviewPush parsed, userId=");
            r108.append(r103);
            r108.append(", descriptionId=");
            r108.append(r101.f());
            r108.append(", hasSpans=");
            if (r107.get(r103) == null) goto L18;
            r104 = true;
        L18:
            r108.append(r104);
            Log.i(OfficeProfileViewModel.TAG, r108.toString());
            OfficeProfileViewModel.access$updateState(this.this$0, new C52551(r107, r103));
            return Unit.INSTANCE;
        L12:
            r106 = false;
        L21:
            return Unit.INSTANCE;
        L7:
            r105 = false;
            goto L8
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadDoubaoHomepageData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadDoubaoHomepageData$1", f = "OfficeProfileViewModel.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME}, m = "invokeSuspend", n = {"chatterId"}, s = {"L$0"})
    public static final class C121061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C121061(OfficeProfileViewModel r100, Continuation<? super C121061> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C121061(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C121061) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 != 1) goto L9;
            String r103 = (String) this.L$0;
            ResultKt.throwOnFailure(r100);     // Catch: Exception -> L17
        L15:
            final List<String> r104 = ((x1c.a) r100).f562153a;     // Catch: Exception -> L17
            Log.i(OfficeProfileViewModel.TAG, "loadDoubaoHomepageData success, images: " + r104 + " for chatterId: " + r103);     // Catch: Exception -> L17
            OfficeProfileViewModel.access$updateState(this.this$0, new C52571(r104));     // Catch: Exception -> L17
        L20:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r100);
            String r105 = ((OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue()).l();     // Catch: Exception -> L17
            x1c.d r106 = this.this$0.getOfficeProfileProtocol();     // Catch: Exception -> L17
            this.L$0 = r105;     // Catch: Exception -> L17
            this.label = 1;     // Catch: Exception -> L17
            Object r107 = r106.C(r105, this);     // Catch: Exception -> L17
            if (r107 != r101) goto L14;
            return r101;
        L14:
            r103 = r105;
            r100 = r107;
        L17:
            e = move-exception;
            Log.e(OfficeProfileViewModel.TAG, "loadDoubaoHomepageData error", e);
            goto L20
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadDoubaoUserInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadDoubaoUserInfo$1", f = "OfficeProfileViewModel.kt", i = {0, 1}, l = {340, 349, 352}, m = "invokeSuspend", n = {"chatterId", "chatterId"}, s = {"L$0", "L$0"})
    public static final class C121071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C121071(OfficeProfileViewModel r100, Continuation<? super C121071> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C121071(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C121071) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L19;
            if (r101 == 1) goto L16;
            if (r101 == 2) goto L13;
            if (r101 != 3) goto L12;
            ResultKt.throwOnFailure(r110);     // Catch: Exception -> L9
        L33:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            String r102 = (String) this.L$0;
            ResultKt.throwOnFailure(r110);     // Catch: Exception -> L9
        L28:
            OfficeProfileModel r103 = OfficeProfileViewModel.access$getModel$p(this.this$0);     // Catch: Exception -> L9
            this.L$0 = null;     // Catch: Exception -> L9
            this.label = 3;     // Catch: Exception -> L9
            if (r103.d(r102, (String) r110, this) != r100) goto L33;
            return r100;
        L16:
            String r104 = (String) this.L$0;
            ResultKt.throwOnFailure(r110);     // Catch: Exception -> L9
        L24:
            x1c.b r111 = (x1c.b) r110;     // Catch: Exception -> L9
            Log.i(OfficeProfileViewModel.TAG, "loadDoubaoUserInfo success: " + r111 + " for chatterId: " + r104);     // Catch: Exception -> L9
            final v1c.a r105 = new v1c.a(r111.f562154a, r111.f562155b, r111.f562157d);     // Catch: Exception -> L9
            OfficeProfileViewModel.access$updateState(this.this$0, new C52581(r105));     // Catch: Exception -> L9
            OfficeProfileViewModel.access$reportEnterPageIfNeeded(this.this$0, r105.a());     // Catch: Exception -> L9
            CoroutineDispatcher r112 = Dispatchers.getDefault();     // Catch: Exception -> L9
            OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1 r106 = new OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1(r105, null);     // Catch: Exception -> L9
            this.L$0 = r104;     // Catch: Exception -> L9
            this.label = 2;     // Catch: Exception -> L9
            r110 = BuildersKt.withContext(r112, r106, this);     // Catch: Exception -> L9
            if (r110 != r100) goto L27;
            return r100;
        L27:
            r102 = r104;
            goto L28
        L19:
            ResultKt.throwOnFailure(r110);
            String r113 = ((OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue()).l();     // Catch: Exception -> L9
            x1c.d r107 = this.this$0.getOfficeProfileProtocol();     // Catch: Exception -> L9
            this.L$0 = r113;     // Catch: Exception -> L9
            this.label = 1;     // Catch: Exception -> L9
            Object r108 = r107.n1(r113, this);     // Catch: Exception -> L9
            if (r108 != r100) goto L23;
            return r100;
        L23:
            r104 = r113;
            r110 = r108;
        L9:
            e = move-exception;
            Log.e(OfficeProfileViewModel.TAG, "loadDoubaoUserInfo error", e);
            goto L33
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadProfile$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadProfile$1", f = "OfficeProfileViewModel.kt", i = {0, 1, 1, 2}, l = {189, 193, 206}, m = "invokeSuspend", n = {"isLocalFail", "localResult", "isLocalFail", "isLocalFail"}, s = {"I$0", "L$0", "I$0", "I$0"})
    public static final class C121081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C121081(OfficeProfileViewModel r100, Continuation<? super C121081> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C121081(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C121081) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L12;
            if (r101 == 1) goto L11;
            if (r101 == 2) goto L10;
            if (r101 != 3) goto L9;
            int r102 = this.I$0;
            ResultKt.throwOnFailure(r110);
        L33:
            final q1c.b r111 = (q1c.b) r110;
            if ((r111 instanceof q1c.b.C7270b) == false) goto L37;
            final boolean r103 = OfficeProfileViewModel.access$loadIsOnLeave(this.this$0, (q1c.b.C7270b) r111);
            final OfficeProfileViewModel r104 = this.this$0;
            OfficeProfileViewModel.access$updateState(r104, new AnonymousClass2(r104, r103, r111));
            OfficeProfileViewModel.access$loadDescriptionSpan(this.this$0);
            OfficeProfileViewModel.access$loadDoubaoUserInfo(this.this$0);
            OfficeProfileViewModel.access$loadDoubaoHomepageData(this.this$0);
            OfficeProfileViewModel.access$markChatApplicationMeReadIfNeeded(this.this$0);
        L41:
            return Unit.INSTANCE;
        L37:
            if ((r111 instanceof q1c.b.a) == false) goto L41;
            if (r102 == 0) goto L41;
            final OfficeProfileViewModel r105 = this.this$0;
            OfficeProfileViewModel.access$updateState(r105, new AnonymousClass3(r105, r111));
            goto L41
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r106 = this.I$0;
            final q1c.b r107 = (q1c.b) this.L$0;
            ResultKt.throwOnFailure(r110);
        L25:
            final v1c.a r112 = (v1c.a) r110;
            final boolean r108 = OfficeProfileViewModel.access$loadIsOnLeave(this.this$0, (q1c.b.C7270b) r107);
            final OfficeProfileViewModel r109 = this.this$0;
            OfficeProfileViewModel.access$updateState(r109, new C52591(r109, r112, r108, r107));
            OfficeProfileViewModel.access$loadDescriptionSpan(this.this$0);
        L29:
            OfficeProfileViewModel r113 = this.this$0;
            this.L$0 = null;
            this.I$0 = r106;
            this.label = 3;
            r110 = OfficeProfileViewModel.access$loadProfile(r113, true, this);
            if (r110 != r100) goto L32;
            return r100;
        L32:
            r102 = r106;
            goto L33
        L11:
            r106 = this.I$0;
            ResultKt.throwOnFailure(r110);
        L15:
            q1c.b r114 = (q1c.b) r110;
            if ((r114 instanceof q1c.b.C7270b) == false) goto L27;
            GetDoubaoProfileResponse.UserInfo r115 = ((GetDoubaoProfileResponse) ((q1c.b.C7270b) r114).f531323a).user_info;
            if (r115 == null) goto L20;
            String r116 = r115.extra_info;
        L21:
            Log.i(OfficeProfileViewModel.TAG, "loadProfile local extra_info=" + r116);
            OfficeProfileViewModel r117 = this.this$0;
            this.L$0 = r114;
            this.I$0 = r106;
            this.label = 2;
            Object r118 = OfficeProfileViewModel.access$parseDoubaoData(r117, r116, this);
            if (r118 != r100) goto L24;
            return r100;
        L24:
            r107 = r114;
            r110 = r118;
            goto L25
        L20:
            r116 = null;
            goto L21
        L27:
            if ((r114 instanceof q1c.b.a) == false) goto L29;
            r106 = 1;
            goto L29
        L12:
            ResultKt.throwOnFailure(r110);
            OfficeProfileViewModel r119 = this.this$0;
            r106 = 0;
            this.I$0 = 0;
            this.label = 1;
            r110 = OfficeProfileViewModel.access$loadProfile(r119, false, this);
            if (r110 != r100) goto L15;
            return r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$markChatApplicationMeReadIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$markChatApplicationMeReadIfNeeded$1", f = "OfficeProfileViewModel.kt", i = {}, l = {384}, m = "invokeSuspend", n = {}, s = {})
    public static final class C121091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $applicationId;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C121091(OfficeProfileViewModel r100, String r101, Continuation<? super C121091> r102) {
            this.this$0 = r100;
            this.$applicationId = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C121091(this.this$0, this.$applicationId, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C121091) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v3, types: [com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$updateChatApplicationMeRead$2$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            OfficeProfileModel r103 = OfficeProfileViewModel.access$getModel$p(this.this$0);
            List r104 = CollectionsKt.listOf(this.$applicationId);
            this.label = 1;
            r103.getClass();
            final kotlinx.coroutines.j r105 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r105.C();
            Log.i("OfficeProfileModel", "start updateChatApplicationMeRead, applicationIds: " + r104);
            OfficeProfileModule.a().getContactDependency().d(r104, new OfficeProfileModel$updateChatApplicationMeRead$2$1(r105));
            Object r106 = r105.B();
            if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
            DebugProbesKt.probeCoroutineSuspended(this);
        L11:
            if (r106 != r101) goto L14;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$parseDoubaoData$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/profile_office/userprofile/model/DoubaoData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$parseDoubaoData$2", f = "OfficeProfileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C121102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super v1c.a>, Object> {
        final /* synthetic */ String $extraInfo;
        int label;

        public C121102(String r100, Continuation<? super C121102> r101) {
            this.$extraInfo = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C121102(this.$extraInfo, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super v1c.a> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super v1c.a> r101) {
            return ((C121102) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r100);
            String r101 = this.$extraInfo;
            int r102 = 0;
            if (r101 != null) goto L7;
        L10:
            boolean r103 = true;
        L11:
            if (r103 == true) goto L19;
            Gson r104 = e0.f444707a;
            v1c.a r105 = (v1c.a) e0.a(this.$extraInfo, v1c.a.class);
            if (r105 == null) goto L16;
            return r105;
        L16:
            return new v1c.a(r102);
        L19:
            return new v1c.a(r102);
        L7:
            if (r101.length() == 0) goto L10;
            r103 = false;
            goto L11
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$saveAlias$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$saveAlias$1", f = "OfficeProfileViewModel.kt", i = {}, l = {410, 420}, m = "invokeSuspend", n = {}, s = {})
    public static final class C121121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $alias;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C121121(OfficeProfileViewModel r100, String r101, Continuation<? super C121121> r102) {
            this.this$0 = r100;
            this.$alias = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C121121(this.this$0, this.$alias, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C121121) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L19:
            OfficeProfileViewModel.access$updateDialogState(this.this$0, AnonymousClass3.INSTANCE);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L13:
            q1c.b r103 = (q1c.b) r100;
            if ((!(r103 instanceof q1c.b.a)) == false) goto L16;
            OfficeProfileViewModel.access$updateDialogState(this.this$0, AnonymousClass2.INSTANCE);
            OfficeProfileViewModel.access$updateProfile(this.this$0);
            goto L21
        L16:
            OfficeProfileViewModel r104 = this.this$0;
            j.k r105 = new j.k(OfficeProfileViewModel.access$getRequestFailToastMessage(r104, ((q1c.b.a) r103).f531322a));
            this.label = 2;
            if (OfficeProfileViewModel.access$emitEffect(r104, r105, this) != r101) goto L19;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            OfficeProfileViewModel.access$updateDialogState(this.this$0, C52601.INSTANCE);
            OfficeProfileState r106 = (OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue();
            OfficeProfileModel r107 = OfficeProfileViewModel.access$getModel$p(this.this$0);
            String r108 = r106.l();
            String r109 = this.$alias;
            this.label = 1;
            r100 = r107.c(r108, r109, this);
            if (r100 != r101) goto L13;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$updateProfile$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$updateProfile$1", f = "OfficeProfileViewModel.kt", i = {}, l = {VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2}, m = "invokeSuspend", n = {}, s = {})
    public static final class C121131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C121131(OfficeProfileViewModel r100, Continuation<? super C121131> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C121131(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C121131) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            final q1c.b r103 = (q1c.b) r100;
            if ((r103 instanceof q1c.b.C7270b) == false) goto L15;
            final boolean r104 = OfficeProfileViewModel.access$loadIsOnLeave(this.this$0, (q1c.b.C7270b) r103);
            final OfficeProfileViewModel r105 = this.this$0;
            OfficeProfileViewModel.access$updateState(r105, new C52611(r105, r104, r103));
            OfficeProfileViewModel.access$loadDescriptionSpan(this.this$0);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            Log.i(OfficeProfileViewModel.TAG, "start updateProfile");
            OfficeProfileViewModel r106 = this.this$0;
            this.label = 1;
            r100 = OfficeProfileViewModel.access$loadProfile(r106, true, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadDescriptionSpan$2] */
    private final void loadDescriptionSpan() {
        final OfficeProfileState r100 = this._state.getValue();
        final String r101 = r100.g();
        final String r102 = r100.l();
        boolean r103 = false;
        if (r101.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return;
    L8:
        if (r102.length() != 0) goto L10;
        r103 = true;
    L10:
        if (r103 == true) goto L18;
        int r105 = w1c.b.f557952a;
        String r106 = k6b.c.a(r102, r101, r100.f());
        final RecogniseSpansResult r107 = f0.a.f448675a.a(r106);
        if (r107 == null) goto L15;
        updateState(new OfficeProfileViewModel$loadDescriptionSpan$1$1(r107));
    L15:
        OfficeProfileModule.a().getChatDependency().c(r101, r102, r100.f(), new C121052(this, r102, r101, r100));
        return;
    L18:
        return;
    L5:
        r104 = false;
        goto L6
    }

    private final void markChatApplicationMeReadIfNeeded() {
        q1c.b<GetDoubaoProfileResponse> r100 = this._state.getValue().f438887a;
        if (r100 == null) goto L9;
        GetDoubaoProfileResponse r101 = r100.a();
        if (r101 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r102 = r101.user_info;
        if (r102 == null) goto L9;
        String r103 = r102.contact_application_id;
    L10:
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        if (r103.length() != 0) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L18;
        return;
    L18:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C121091(this, r103, null), 3, null);
        return;
    L15:
        r104 = false;
    L9:
        r103 = null;
        goto L10
    }

    private final void reload() {
        updateState(new C121111(this));
        loadProfile();
    }

    public final ProfileFinishResult getFinishResult() {
        OfficeProfileState r100 = this._state.getValue();
        if ((r100.f438887a instanceof q1c.b.C7270b) == true) goto L6;
        return null;
    L6:
        GetDoubaoProfileResponse.ContactStatus r101 = r100.d();
        String r102 = r100.l();
        if (r102.length() != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        r102 = this.userId;
    L12:
        String r104 = r102;
        boolean r105 = r100.n();
        if (r101 != GetDoubaoProfileResponse.ContactStatus.CONTACT_DUAL) goto L15;
        boolean r106 = true;
    L17:
        if (r101 != GetDoubaoProfileResponse.ContactStatus.CONTACT_FORWARD) goto L19;
        boolean r110 = true;
    L21:
        if (r101 != GetDoubaoProfileResponse.ContactStatus.CONTACT_REVERSE) goto L23;
        boolean r111 = true;
    L25:
        return new ProfileFinishResult(r104, r105, r106, r110, r111);
    L23:
        r111 = false;
        goto L25
    L19:
        r110 = false;
        goto L21
    L15:
        r106 = false;
        goto L17
    L9:
        r103 = false;
        goto L10
    }

    public final String getReportUrl() {
        String r100 = this._state.getValue().l();
        boolean r101 = false;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        r100 = this.userId;
    L9:
        if (r100.length() != 0) goto L11;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        return "";
    L15:
        JSONObject r104 = new JSONObject().put("report_type", 10).put("report_params", new JSONObject().put("profile_params", new JSONObject().put("uid", r100)));
        TnsReportConfig r105 = (TnsReportConfig) SettingManager.getInstance().get(TnsReportConfig.class);     // Catch: Exception -> L18
    L20:
        if (r105 != null) goto L22;
        return "";
    L22:
        String r106 = encrypt(r104.toString(), r105.getToken());
        if (r106.length() != 0) goto L25;
        r101 = true;
    L25:
        if (r101 == false) goto L27;
        return "";
    L27:
        String r107 = "https://" + OfficeProfileModule.a().getReportHost() + r105.getReportPath() + "?params=" + r106 + "&v=2&lang=" + getLanguageLocaleTag();
        Log.i(TAG, "getReportUrl reportUrl=" + r107);
        return r107;
    L18:
        e = move-exception;
        Log.e(TAG, "get TnsReportConfig failed", e);
        r105 = null;
        goto L20
    L11:
        r103 = false;
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    private final void acceptFriend() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    private final void deleteFriend() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C121011(this, null), 3, null);
    }

    private final String getLanguageLocaleTag() {
        yob.e.a().getClass();
        int r100 = com.ss.android.lark.language.service.impl.a.f431092f;
        apb.b r101 = com.ss.android.lark.language.service.impl.a.b.f431098a;
        return r101.d(r101.getCacheLanguageSetting());
    }

    private final void loadDoubaoHomepageData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C121061(this, null), 3, null);
    }

    private final void loadDoubaoUserInfo() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C121071(this, null), 3, null);
    }

    private final void loadProfile() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C121081(this, null), 3, null);
    }

    private final void registerUrlPreviewsPush() {
        OfficeProfileModule.a().getPushDependency().a(this.signUrlPreviewPushListener);
    }

    private final void unRegisterUrlPreviewPush() {
        OfficeProfileModule.a().getPushDependency().b(this.signUrlPreviewPushListener);
    }

    private final void updateProfile() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C121131(this, null), 3, null);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        unRegisterUrlPreviewPush();
        super.onCleared();
    }

    public final i1<d> getDialogState() {
        return this.dialogState;
    }

    public final d1<j> getEffect() {
        return this.effect;
    }

    public final x1c.d getOfficeProfileProtocol() {
        return this.officeProfileProtocol;
    }

    public final i1<OfficeProfileState> getState() {
        return this.state;
    }

    public static final /* synthetic */ OfficeProfileModel access$getModel$p(OfficeProfileViewModel r100) {
        return r100.model;
    }

    public static final /* synthetic */ ContactSource access$getSource$p(OfficeProfileViewModel r100) {
        return r100.source;
    }

    public static final /* synthetic */ z0 access$get_state$p(OfficeProfileViewModel r100) {
        return r100._state;
    }

    public static final /* synthetic */ void access$loadDescriptionSpan(OfficeProfileViewModel r100) {
        r100.loadDescriptionSpan();
    }

    public static final /* synthetic */ void access$loadDoubaoHomepageData(OfficeProfileViewModel r100) {
        r100.loadDoubaoHomepageData();
    }

    public static final /* synthetic */ void access$loadDoubaoUserInfo(OfficeProfileViewModel r100) {
        r100.loadDoubaoUserInfo();
    }

    public static final /* synthetic */ void access$markChatApplicationMeReadIfNeeded(OfficeProfileViewModel r100) {
        r100.markChatApplicationMeReadIfNeeded();
    }

    public static final /* synthetic */ void access$updateProfile(OfficeProfileViewModel r100) {
        r100.updateProfile();
    }

    private final void blockUser(boolean r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C121001(this, r100, null), 3, null);
    }

    private final void emitEffectAsync(j r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C121031(this, r100, null), 3, null);
    }

    private final String getRequestFailToastMessage(ErrorResult r100) {
        if (NetworkUtils.d(LarkContext.getApplication()) == false) goto L5;
        String r101 = r100.getDisplayMsg();
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        if (r101.length() != 0) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == true) goto L15;
        return r101;
    L15:
        return UIHelper.getString(R.string.LarkIM_Common_NetworkErrorRetry_Toast);
    L12:
        r102 = false;
        goto L13
    L5:
        return UIHelper.getString(R.string.LarkIM_Common_NetworkErrorRetry_Toast);
    }

    private final void handleCtaClick(GetDoubaoProfileResponse.CTAInfo r100) {
        if (Intrinsics.areEqual(r100.key, "__mock_chat__") == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r100.enable, Boolean.TRUE) == true) goto L9;
        emitEffectAsync(new j.k(w1c.a.a(r100.denied_description)));
        return;
    L9:
        GetDoubaoProfileResponse.CTAType r101 = r100.cta_type;
        if (r101 != null) goto L12;
        int r102 = -1;
    L14:
        if (r102 != 1) goto L17;
        reportHomePageClick("send_message");
        emitEffectAsync(new j.d(this._state.getValue().l()));
        return;
    L17:
        return;
    L12:
        r102 = b.f438902a[r101.ordinal()];
        goto L14
    }

    private final void handleSignUrlPreviewPush(List<UrlPreViewEntries> r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C121041(this, r100, null), 3, null);
    }

    private final boolean loadIsOnLeave(q1c.b.C7270b<GetDoubaoProfileResponse> r100) {
        long r101 = cac.b.a.f22984a.a(30000) / 1000;
        GetDoubaoProfileResponse.UserInfo r102 = r100.f531323a.user_info;
        if (r102 == null) goto L5;
        List<Chatter.ChatterCustomStatus> r103 = r102.chatter_status;
    L6:
        if (r103 != null) goto L8;
        r103 = CollectionsKt.emptyList();
    L8:
        List<Chatter.ChatterCustomStatus> r104 = r103;
        if ((r104 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r105 = r104.iterator();
    L15:
        if (r105.hasNext() == false) goto L38;
        Chatter.ChatterCustomStatus r106 = (Chatter.ChatterCustomStatus) r105.next();
        StatusEffectiveInterval r107 = r106.effective_interval;
        if (r107 != null) goto L20;
    L18:
        boolean r108 = false;
    L29:
        if (r108 == false) goto L15;
        return true;
    L20:
        if (Intrinsics.areEqual(r106.icon_key, ON_LEAVE_STATUS_ICON_KEY) == false) goto L18;
        Long r109 = r107.start_time;
        if (r101 <= r107.end_time.longValue()) goto L24;
    L26:
        boolean r110 = false;
    L27:
        if (r110 == false) goto L18;
        r108 = true;
        goto L29
    L24:
        if (r109.longValue() > r101) goto L26;
        r110 = true;
        goto L27
    L38:
        return false;
    L11:
        if (r104.isEmpty() == false) goto L13;
        return false;
    L5:
        r103 = null;
        goto L6
    }

    private final void reportEnterPageIfNeeded(String r100) {
        if (this.hasReportedEnterPage == false) goto L5;
        return;
    L5:
        int r101 = f.f438928a;
        ContactSource r102 = this.source;
        Intrinsics.checkNotNullParameter(r100, "doubaoUserId");
        JSONObject r103 = new JSONObject().put("current_page", "home_page");
        if (r102 == null) goto L8;
        Integer r104 = Integer.valueOf(r102.getSourceType());
    L10:
        if (r104 != null) goto L13;
    L15:
        if (r104 != null) goto L18;
    L20:
        if (r104 != null) goto L23;
    L25:
        if (r104 != null) goto L28;
    L30:
        if (r104 != null) goto L33;
    L35:
        if (r104 != null) goto L38;
    L40:
        if (r104 != null) goto L43;
    L45:
        if (r104 != null) goto L48;
    L50:
        if (r104 != null) goto L53;
    L55:
        if (r104 != null) goto L58;
    L60:
        if (r104 != null) goto L63;
    L65:
        if (r104 != null) goto L68;
    L70:
        if (r104 != null) goto L73;
    L75:
        if (r104 != null) goto L78;
    L80:
        if (r104 != null) goto L83;
    L85:
        if (r104 != null) goto L88;
    L90:
        if (r104 != null) goto L93;
    L95:
        if (r104 != null) goto L98;
    L100:
        if (r104 != null) goto L103;
    L105:
        if (r104 != null) goto L108;
    L110:
        String r105 = "unknown";
    L111:
        Statistics.sendEvent(CheckPointType.ENTER_PAGE, r103.put("enter_method", r105).put("home_page_user_id", r100));
        this.hasReportedEnterPage = true;
        return;
    L108:
        if (r104.intValue() != 10002) goto L110;
        r105 = "push";
        goto L111
    L103:
        if (r104.intValue() != 10001) goto L105;
        r105 = TaskType.MEEGO_TASK;
        goto L111
    L98:
        if (r104.intValue() != 21) goto L100;
        r105 = "search_doubao_id";
        goto L111
    L93:
        if (r104.intValue() != 20) goto L95;
        r105 = DocumentType.MINUTES_NAME;
        goto L111
    L88:
        if (r104.intValue() != 19) goto L90;
        r105 = "special_focus";
        goto L111
    L83:
        if (r104.intValue() != 14) goto L85;
        r105 = "contactcards";
        goto L111
    L78:
        if (r104.intValue() != 18) goto L80;
        r105 = "new_contact";
        goto L111
    L73:
        if (r104.intValue() != 17) goto L75;
        r105 = "external_contact";
        goto L111
    L68:
        if (r104.intValue() != 11) goto L70;
        r105 = "community";
        goto L111
    L63:
        if (r104.intValue() != 10) goto L65;
        r105 = "search_contact";
        goto L111
    L58:
        if (r104.intValue() != 9) goto L60;
        r105 = "search_email";
        goto L111
    L53:
        if (r104.intValue() != 8) goto L55;
        r105 = "search_phone";
        goto L111
    L48:
        if (r104.intValue() != 7) goto L50;
        r105 = "name_card";
        goto L111
    L43:
        if (r104.intValue() != 6) goto L45;
        r105 = "email";
        goto L111
    L38:
        if (r104.intValue() != 5) goto L40;
        r105 = ThumbGlideUrl.SOURCE_VC;
        goto L111
    L33:
        if (r104.intValue() != 4) goto L35;
        r105 = "docs";
        goto L111
    L28:
        if (r104.intValue() != 3) goto L30;
        r105 = "calendar";
        goto L111
    L23:
        if (r104.intValue() != 2) goto L25;
        r105 = "chat";
        goto L111
    L18:
        if (r104.intValue() != 1) goto L20;
        r105 = "link";
        goto L111
    L13:
        if (r104.intValue() != 0) goto L15;
        r105 = LocationInfoConst.UNKNOWN_SOURCE;
        goto L111
    L8:
        r104 = null;
        goto L10
    }

    private final void reportHomePageClick(String r100) {
        int r101 = f.f438928a;
        String r102 = this._state.getValue().f438892f.a();
        Intrinsics.checkNotNullParameter(r102, "doubaoUserId");
        Intrinsics.checkNotNullParameter(r100, "click");
        Statistics.sendEvent("home_page_click", new JSONObject().put("current_page", "home_page").put("home_page_user_id", r102).put("click_from", r100));
    }

    private final void saveAlias(String r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C121121(this, r100, null), 3, null);
    }

    private final void updateDialogState(Function1<? super d, d> r100) {
        z0<d> r101 = this._dialogState;
        r101.setValue(r100.invoke(r101.getValue()));
    }

    private final void updateState(Function1<? super OfficeProfileState, OfficeProfileState> r100) {
        z0<OfficeProfileState> r101 = this._state;
        r101.setValue(r100.invoke(r101.getValue()));
    }

    public final void dispatch(final k r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        if ((r100 instanceof k.i) == false) goto L6;
        k.i r101 = (k.i) r100;
        init(r101.f438952a, r101.f438953b, r101.f438954c);
        return;
    L6:
        if (Intrinsics.areEqual(r100, k.m.f438958a) == false) goto L9;
        reload();
        return;
    L9:
        if (Intrinsics.areEqual(r100, k.c.f438946a) == false) goto L12;
        emitEffectAsync(j.c.f438934a);
        return;
    L12:
        if (Intrinsics.areEqual(r100, k.l.f438957a) == false) goto L15;
        emitEffectAsync(j.h.f438939a);
        return;
    L15:
        if ((r100 instanceof k.e) == false) goto L18;
        handleCtaClick(((k.e) r100).f438948a);
        return;
    L18:
        if ((r100 instanceof k.j) == false) goto L21;
        emitEffectAsync(new j.g(((k.j) r100).f438955a));
        return;
    L21:
        if ((r100 instanceof k.h) == false) goto L24;
        emitEffectAsync(new j.f(((k.h) r100).f438951a));
        return;
    L24:
        if ((r100 instanceof k.g) == false) goto L27;
        emitEffectAsync(new j.e(((k.g) r100).f438950a));
        return;
    L27:
        if (Intrinsics.areEqual(r100, k.v.f438967a) == false) goto L30;
        emitEffectAsync(j.C5262j.f438941a);
        return;
    L30:
        if (Intrinsics.areEqual(r100, k.C5263k.f438956a) == false) goto L33;
        reportHomePageClick("doubao_home_page");
        emitEffectAsync(j.b.f438933a);
        return;
    L33:
        if (Intrinsics.areEqual(r100, k.n.f438959a) == false) goto L36;
        emitEffectAsync(j.i.f438940a);
        return;
    L36:
        if (Intrinsics.areEqual(r100, k.a.f438943a) == false) goto L39;
        reportHomePageClick("accept");
        acceptFriend();
        return;
    L39:
        if ((r100 instanceof k.d) == false) goto L42;
        blockUser(((k.d) r100).f438947a);
        return;
    L42:
        if (Intrinsics.areEqual(r100, k.f.f438949a) == false) goto L45;
        deleteFriend();
        return;
    L45:
        if ((r100 instanceof k.o) == false) goto L48;
        saveAlias(((k.o) r100).f438960a);
        return;
    L48:
        if ((r100 instanceof k.b) == false) goto L51;
        int r102 = f.f438928a;
        String r103 = this._state.getValue().f438892f.a();
        Intrinsics.checkNotNullParameter(r103, "doubaoUserId");
        Statistics.sendEvent("send_add_friend_apply", new JSONObject().put("home_page_user_id", r103));
        k.b r104 = (k.b) r100;
        applyFriend(r104.f438944a, r104.f438945b);
        return;
    L51:
        if ((r100 instanceof k.t) == false) goto L54;
        updateDialogState(new C121021(r100));
        return;
    L54:
        if ((r100 instanceof k.p) == false) goto L60;
        if (((k.p) r100).f438961a == false) goto L58;
        reportHomePageClick(e1.REPLY_ACTION_APPLY);
    L58:
        updateDialogState(new AnonymousClass2(r100));
        return;
    L60:
        if ((r100 instanceof k.s) == false) goto L63;
        updateState(new AnonymousClass3(r100));
        return;
    L63:
        if ((r100 instanceof k.u) == false) goto L66;
        updateDialogState(new AnonymousClass4(r100));
        return;
    L66:
        if ((r100 instanceof k.r) == false) goto L69;
        updateDialogState(new AnonymousClass5(r100));
        return;
    L69:
        if ((r100 instanceof k.q) == false) goto L73;
        updateDialogState(new AnonymousClass6(r100));
        return;
    L73:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ String access$getRequestFailToastMessage(OfficeProfileViewModel r100, ErrorResult r101) {
        return r100.getRequestFailToastMessage(r101);
    }

    public static final /* synthetic */ void access$handleSignUrlPreviewPush(OfficeProfileViewModel r100, List r101) {
        r100.handleSignUrlPreviewPush(r101);
    }

    public static final /* synthetic */ boolean access$loadIsOnLeave(OfficeProfileViewModel r100, q1c.b.C7270b r101) {
        return r100.loadIsOnLeave(r101);
    }

    public static final /* synthetic */ void access$reportEnterPageIfNeeded(OfficeProfileViewModel r100, String r101) {
        r100.reportEnterPageIfNeeded(r101);
    }

    public static final /* synthetic */ void access$updateDialogState(OfficeProfileViewModel r100, Function1 r101) {
        r100.updateDialogState(r101);
    }

    public static final /* synthetic */ void access$updateState(OfficeProfileViewModel r100, Function1 r101) {
        r100.updateState(r101);
    }

    private final void applyFriend(String r100, String r101) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C120991(this, r100, r101, null), 3, null);
    }

    private final Object emitEffect(j r100, Continuation<? super Unit> r101) {
        Object r102 = this._effect.emit(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    private final String encrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return "";
    L7:
        if (r101.length() < 16) goto L14;
        Charset r102 = Charsets.UTF_8;
        SecretKeySpec r103 = new SecretKeySpec(r101.getBytes(r102), "AES");
        Cipher r104 = Cipher.getInstance(AES_MODE, "BC");
        r104.init(1, r103, new IvParameterSpec(r101.substring(0, 16).getBytes(r102)));
        return new String(Base64.encode(r104.doFinal(r100.getBytes(r102)), 10), r102);
    L14:
        return "";
    }

    private final Object loadProfile(boolean r100, Continuation<? super q1c.b<GetDoubaoProfileResponse>> r101) {
        boolean r102 = true;
        if (this.userId.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        return this.model.b(this.userId, r100, r101);
    L10:
        if (this.token.length() > 0) goto L13;
        r102 = false;
    L13:
        if (r102 == false) goto L17;
        return this.model.a(this.token, r100, r101);
    L17:
        return new q1c.b.a(new ErrorResult("illegal arguments"));
    L5:
        r103 = false;
        goto L6
    }

    private final Object parseDoubaoData(String r100, Continuation<? super v1c.a> r101) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new C121102(r100, null), r101);
    }

    @Inject
    public OfficeProfileViewModel(OfficeProfileModel r100, x1c.d r101, IOfficeSDKTokenProvider r102) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "officeProfileProtocol");
        Intrinsics.checkNotNullParameter(r102, "officeSDKTokenProvider");
        this.model = r100;
        this.officeProfileProtocol = r101;
        IOfficeSDKBizConfigProvider r103 = OfficeSDKManager.getBizConfigProvider();
        if (r103 == null) goto L7;
        boolean r104 = true;
        if (r103.isEnabled(IOfficeSDKBizConfigProvider.Biz.IM) != true) goto L7;
    L8:
        this.isIMEnabled = r104;
        boolean r105 = r102.isDoubaoBUser();
        this.isLoginBUser = r105;
        StateFlowImpl r106 = j1.a(new OfficeProfileState(r104, r105, 8179));
        this._state = r106;
        this.state = kotlinx.coroutines.flow.e.b(r106);
        StateFlowImpl r107 = j1.a(new d(0));
        this._dialogState = r107;
        this.dialogState = kotlinx.coroutines.flow.e.b(r107);
        MutableSharedFlow<j> r108 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._effect = r108;
        this.effect = kotlinx.coroutines.flow.e.a(r108);
        this.userId = "";
        this.token = "";
        this.signUrlPreviewPushListener = new c(this);
        registerUrlPreviewsPush();
        return;
    L7:
        r104 = false;
        goto L8
    }

    public static final /* synthetic */ Object access$emitEffect(OfficeProfileViewModel r100, j r101, Continuation r102) {
        return r100.emitEffect(r101, r102);
    }

    public static final /* synthetic */ Object access$loadProfile(OfficeProfileViewModel r100, boolean r101, Continuation r102) {
        return r100.loadProfile(r101, r102);
    }

    public static final /* synthetic */ Object access$parseDoubaoData(OfficeProfileViewModel r100, String r101, Continuation r102) {
        return r100.parseDoubaoData(r101, r102);
    }

    private final void init(String r100, String r101, ContactSource r102) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.userId = r100;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        this.token = r101;
        this.source = r102;
        Log.i(TAG, "init, isIMEnabled=" + this.isIMEnabled + ", isLoginBUser=" + this.isLoginBUser);
        loadProfile();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v28, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
    private final OfficeProfileState withProfileResponse(OfficeProfileState r210, q1c.b<GetDoubaoProfileResponse> r310, boolean r311) {
        String r100 = r210.g();
        Long r101 = r210.f();
        if (r310 == null) goto L9;
        GetDoubaoProfileResponse r102 = r310.a();
        if (r102 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r103 = r102.user_info;
        if (r103 == null) goto L9;
        Chatter.Description r104 = r103.description;
    L10:
        if (r104 == null) goto L12;
        String r105 = r104.text;
    L13:
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        boolean r110 = true;
        if (Intrinsics.areEqual(r100, r105) == false) goto L24;
        if (r104 == null) goto L19;
        Long r106 = r104.description_id;
    L21:
        if (Intrinsics.areEqual(r101, r106) == false) goto L24;
        boolean r107 = false;
    L26:
        if (r310 == null) goto L28;
        GetDoubaoProfileResponse r108 = r310.a();
    L29:
        if (r108 == null) goto L49;
        GetDoubaoProfileResponse.UserInfo r109 = r108.user_info;
        if (r109 == null) goto L49;
        GetDoubaoProfileResponse.DepartmentInfo r111 = r109.department_info;
        if (r111 == null) goto L49;
        List<GetDoubaoProfileResponse.DepartmentInfo.Department> r112 = r111.department_list;
        if (r112 == null) goto L49;
        List<GetDoubaoProfileResponse.DepartmentInfo.Department> r113 = r112;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r115 = r113.iterator();
    L38:
        if (r115.hasNext() == false) goto L40;
        r114.add(w1c.a.a(((GetDoubaoProfileResponse.DepartmentInfo.Department) r115.next()).department_name));
        goto L38
    L40:
        ?? r116 = new ArrayList();
        Iterator r117 = r114.iterator();
    L42:
        if (r117.hasNext() == false) goto L50;
        Object r118 = r117.next();
        if (((String) r118).length() <= 0) goto L46;
        boolean r119 = true;
    L47:
        if (r119 == false) goto L42;
        r116.add(r118);
        goto L42
    L46:
        r119 = false;
    L50:
        if (r116 != 0) goto L52;
        r116 = CollectionsKt.emptyList();
    L52:
        ?? r120 = r116;
        if (r310 == null) goto L55;
        GetDoubaoProfileResponse r121 = r310.a();
    L56:
        if (r121 == null) goto L60;
        GetDoubaoProfileResponse.UserInfo r122 = r121.user_info;
        if (r122 == null) goto L60;
        GetDoubaoProfileResponse.BlockStatus r123 = r122.block_status;
    L62:
        if (r123 != GetDoubaoProfileResponse.BlockStatus.BLOCK_FORWARD) goto L64;
    L67:
        boolean r124 = true;
    L68:
        com.ss.android.lark.compose.foundation.widget.a r125 = new com.ss.android.lark.compose.foundation.widget.a(r124, false);
        if (r107 == false) goto L71;
        RecogniseSpansResult r126 = null;
    L72:
        OfficeProfileState r127 = OfficeProfileState.a(r210, r310, r311, null, null, null, r120, false, false, r125, r126, false, 4988);
        l.f438968a.getClass();
        Intrinsics.checkNotNullParameter(r127, "state");
        q1c.b<GetDoubaoProfileResponse> r128 = r127.f438887a;
        if (r128 == null) goto L82;
        GetDoubaoProfileResponse r129 = r128.a();
        if (r129 == null) goto L82;
        if (r127.f438888b == true) goto L82;
        if (r129.edition != GetDoubaoProfileRequest.DoubaoProfileEdition.EDITION_UNKNOWN) goto L82;
    L83:
        if (r110 == false) goto L85;
        Set r130 = SetsKt.emptySet();
    L93:
        return OfficeProfileState.a(r127, null, false, r130, null, null, null, false, false, null, null, false, 8175);
    L85:
        Set<l> r131 = l.d.f438973b;
        LinkedHashSet r132 = new LinkedHashSet();
        Iterator r133 = r131.iterator();
    L87:
        if (r133.hasNext() == false) goto L91;
        Object r134 = r133.next();
        if (((l) r134).a(r127) == false) goto L87;
        r132.add(r134);
        goto L87
    L91:
        r130 = r132;
    L82:
        r110 = false;
        goto L83
    L71:
        r126 = r210.f438898l;
        goto L72
    L64:
        if (r123 == GetDoubaoProfileResponse.BlockStatus.BLOCK_DUAL) goto L67;
        r124 = false;
    L60:
        r123 = null;
        goto L62
    L55:
        r121 = null;
    L49:
        r116 = 0;
        goto L50
    L28:
        r108 = null;
        goto L29
    L19:
        r106 = null;
    L24:
        r107 = true;
        goto L26
    L12:
        r105 = null;
    L9:
        r104 = null;
        goto L10
    }

    public static final /* synthetic */ OfficeProfileState access$withProfileResponse(OfficeProfileViewModel r100, OfficeProfileState r101, q1c.b r102, boolean r103) {
        return r100.withProfileResponse(r101, r102, r103);
    }
}
