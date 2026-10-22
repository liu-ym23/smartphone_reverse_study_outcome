package com.larus.bmhome.video.save_share;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.tipoff.BaseTipOffDialog;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.bmhome.utils.c4;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.ttm.player.MediaPlayer;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tx9.a4;

/* JADX INFO: loaded from: classes26.dex */
public final class VideoGenerateShareHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final VideoGenerateShareHelper f315329a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f315330b = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/video/save_share/VideoGenerateShareHelper$SaveBigVideoShareInfoData;", "Landroid/os/Parcelable;", "shareId", "", "<init>", "(Ljava/lang/String;)V", "getShareId", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SaveBigVideoShareInfoData implements Parcelable {
        public static final Parcelable.Creator<SaveBigVideoShareInfoData> CREATOR = null;

        @SerializedName(BdpAppEventConstant.SHARE_ID)
        private final String shareId;

        public static final class a implements Parcelable.Creator<SaveBigVideoShareInfoData> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SaveBigVideoShareInfoData createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                return new SaveBigVideoShareInfoData(r100.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final SaveBigVideoShareInfoData[] newArray(int r100) {
                return new SaveBigVideoShareInfoData[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeString(this.shareId);
        }

        public SaveBigVideoShareInfoData() {
            this("");
        }

        public final String a() {
            return this.shareId;
        }

        public SaveBigVideoShareInfoData(String r100) {
            this.shareId = r100;
        }
    }

    public static final class VideoShareCallback implements com.larus.bmhome.share.panel.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f315331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f315332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ShareScene f315333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CoroutineScope f315334d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final l0 f315335e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c4 f315336f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final nr9.g f315337g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Integer f315338h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f315339i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Map<String, String> f315340j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f315341k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public DialogFragment f315342l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Function0<Unit> f315343m;

        /* JADX INFO: renamed from: com.larus.bmhome.video.save_share.VideoGenerateShareHelper$VideoShareCallback$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.video.save_share.VideoGenerateShareHelper$VideoShareCallback$1", f = "VideoGenerateShareHelper.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            Object L$0;
            int label;
            final /* synthetic */ VideoShareCallback this$0;

            public AnonymousClass1(VideoShareCallback r100, Continuation<? super AnonymousClass1> r101) {
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

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r110) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r101 = this.label;
                if (r101 == 0) goto L8;
                if (r101 != 1) goto L7;
                VideoShareCallback r102 = (VideoShareCallback) this.L$0;
                ResultKt.throwOnFailure(r110);
            L17:
                r102.f315341k = (String) r110;
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r110);
                VideoShareCallback r111 = this.this$0;
                VideoGenerateShareHelper r103 = VideoGenerateShareHelper.f315329a;
                View r104 = r111.f315332b;
                ShareScene r105 = r111.f315333c;
                String r106 = r111.f315331a;
                nr9.g r107 = r111.f315337g;
                if (r107 == null) goto L12;
                String r108 = r107.f520257a;
                if (r108 == null) goto L12;
            L13:
                String r109 = r111.f315339i;
                this.L$0 = r111;
                this.label = 1;
                Object r112 = r103.g(r104, r105, r106, r108, false, r109, this);
                if (r112 != r100) goto L16;
                return r100;
            L16:
                r102 = r111;
                r110 = r112;
            L12:
                r108 = "";
                goto L13
            }
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void f() {
            nr9.g r100 = this.f315337g;
            if (r100 == null) goto L5;
            String r101 = r100.f520257a;
        L6:
            String r102 = r101;
            String r103 = this.f315331a;
            c4 r104 = this.f315336f;
            String r105 = r104.f314984a;
            String r106 = r104.f314986c;
            String r107 = r104.f314990g;
            String r108 = r104.f314993j;
            Integer r109 = r104.f314992i;
            String r110 = r104.f314991h;
            String r111 = this.f315339i;
            JSONObject r112 = r104.f314996m;
            if (r112 != null) goto L9;
            r112 = new JSONObject();
        L9:
            a4.j(r102, r103, r105, "share_panel_click", r106, r107, r108, r109, r110, r111, r112, 2048);
            return;
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void onDismiss() {
            Function0<Unit> r100 = this.f315343m;
            if (r100 == null) goto L6;
            r100.invoke();
            return;
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void e(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            this.f315343m = r100;
        }

        @Override // com.larus.bmhome.share.panel.d
        public final boolean d(String r100, String r101, Boolean r102) {
            if (z2.f365865a.getCreationShareSettings().b() == true) goto L5;
            return true;
        L5:
            if (Intrinsics.areEqual(r100, "video") == true) goto L7;
        L9:
            boolean r103 = false;
        L11:
            return !r103;
        L7:
            if (Intrinsics.areEqual(r101, ShareChannel.SAVE_VIDEO) == false) goto L9;
            r103 = true;
            goto L11
        }

        @Override // com.larus.bmhome.share.panel.d
        public final boolean b(Context r110, DialogFragment r111, View r210, jr9.a r211) {
            Intrinsics.checkNotNullParameter(r211, "shareItemConfig");
            VideoGenerateShareHelper r100 = VideoGenerateShareHelper.f315329a;
            DialogFragment r101 = this.f315342l;
            String r102 = this.f315331a;
            View r103 = this.f315332b;
            ShareScene r104 = this.f315333c;
            CoroutineScope r105 = this.f315334d;
            l0 r106 = this.f315335e;
            c4 r112 = this.f315336f;
            nr9.g r113 = this.f315337g;
            String r114 = this.f315341k;
            Integer r115 = this.f315338h;
            String r116 = this.f315339i;
            Map<String, String> r107 = this.f315340j;
            r100.getClass();
            VideoGenerateShareHelper.h(r110, r111, r211, r101, r102, r103, r104, r105, r106, r112, r113, r114, r115, r116, r107);
            jr9.b r108 = r211.f500141a;
            if (r108 != null) goto L5;
        L7:
            boolean r109 = false;
        L8:
            if (r109 == false) goto L10;
            onDismiss();
        L10:
            return true;
        L5:
            if (r108.f500149g != true) goto L7;
            r109 = true;
            goto L8
        }

        public VideoShareCallback(String r100, View r101, ShareScene r102, CoroutineScope r103, l0 r104, c4 r105, nr9.g r106, Integer r107, String r110, Map<String, String> r111) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            Intrinsics.checkNotNullParameter(r101, "shareContainer");
            Intrinsics.checkNotNullParameter(r102, "shareScene");
            Intrinsics.checkNotNullParameter(r103, "scope");
            Intrinsics.checkNotNullParameter(r105, "eventParams");
            this.f315331a = r100;
            this.f315332b = r101;
            this.f315333c = r102;
            this.f315334d = r103;
            this.f315335e = r104;
            this.f315336f = r105;
            this.f315337g = r106;
            this.f315338h = r107;
            this.f315339i = r110;
            this.f315340j = r111;
            CoroutineDispatcher r108 = Dispatchers.getIO();
            VideoGenerateShareHelper.f315329a.getClass();
            BuildersKt.launch$default(r103, r108.plus(VideoGenerateShareHelper.f315330b), null, new AnonymousClass1(this, null), 2, null);
            this.f315341k = "";
        }
    }

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            FLogger.f375446a.e("Video Edit Error", "sql execute err! msg=" + r101);
        }
    }

    public VideoGenerateShareHelper() {
    }

    static {
        f315329a = new VideoGenerateShareHelper();
        f315330b = new a(CoroutineExceptionHandler.Key);
    }

    public static void b(l0 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void c(l0 r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static void a(BaseTipOffDialog r100, FragmentManager r101) {
        if ((r100 instanceof Fragment) == false) goto L5;
        BaseTipOffDialog r102 = r100;
    L6:
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r102, null, r103);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r102, r103) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r100.show(r101, null);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static final String d(VideoGenerateShareHelper r100, Context r101) {
        r100.getClass();
        if (r101 != null) goto L5;
        return "";
    L5:
        String r102 = AppHost.f326268a.getAppStringName();
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        return String.format(r101.getString(R.string.larus_videoGen_result_share_desc), Arrays.copyOf(new Object[]{r102}, 1));
    }

    public static final String e(VideoGenerateShareHelper r100, Context r101) {
        r100.getClass();
        if (r101 != null) goto L5;
        return "";
    L5:
        String r102 = AppHost.f326268a.getAppStringName();
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        return String.format(r101.getString(R.string.larus_videoGen_result_share_header), Arrays.copyOf(new Object[]{r102}, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object g(View r210, ShareScene r211, String r212, String r213, boolean r214, String r215, Continuation<? super String> r216) {
        final View r100 = r210;
        ShareScene r101 = r211;
        if ((r216 instanceof VideoGenerateShareHelper$getShareVideoUrlAsMessage$1) == false) goto L7;
        VideoGenerateShareHelper$getShareVideoUrlAsMessage$1 r102 = (VideoGenerateShareHelper$getShareVideoUrlAsMessage$1) r216;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        Ref.ObjectRef r106 = (Ref.ObjectRef) r102.L$3;
        String r107 = (String) r102.L$2;
        ShareScene r108 = (ShareScene) r102.L$1;
        View r109 = (View) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: NetworkErrorException -> L14
        Object r111 = r104;
        final Ref.ObjectRef r112 = r106;
        r100 = r109;
        String r113 = r107;
        r101 = r108;
        String r114 = "VideoGenerateShareHelper";
    L27:
        com.larus.network.http.a r115 = (com.larus.network.http.a) r111;     // Catch: NetworkErrorException -> L47
        if ((r115 instanceof y) == false) goto L33;
        SaveBigVideoShareInfoData r116 = (SaveBigVideoShareInfoData) ((y) r115).f360135b;     // Catch: NetworkErrorException -> L47
        if (r116 == null) goto L33;
        String r117 = r116.a();     // Catch: NetworkErrorException -> L47
        if (r117 == null) goto L33;
    L35:
        if (r117.length() <= 0) goto L37;
        boolean r118 = true;
    L38:
        if (r118 == false) goto L52;
        Uri.Builder r119 = UriProtector.parse(z2.f365865a.videoGenerateShareHost()).buildUpon();     // Catch: NetworkErrorException -> L47
        r119.appendQueryParameter("source_type", "mobile");     // Catch: NetworkErrorException -> L47
        r119.appendQueryParameter(BdpAppEventConstant.SHARE_ID, r117);     // Catch: NetworkErrorException -> L47
        r119.appendQueryParameter("video_id", r113);     // Catch: NetworkErrorException -> L47
        if (r101 != ShareScene.VIDEO_COMPREHEND) goto L42;
        r119.appendQueryParameter("share_scene", "share_video");     // Catch: NetworkErrorException -> L47
    L42:
        Uri r120 = r119.build();     // Catch: NetworkErrorException -> L47
        l0 r121 = (l0) r112.element;     // Catch: NetworkErrorException -> L47
        if (r121 == null) goto L45;
        b(r121);     // Catch: NetworkErrorException -> L47
    L45:
        return r120.toString();
    L47:
        e = e;
    L51:
        FLogger.f375446a.i(r114, "share failed " + e);
    L52:
        r100.post(new e(r112));
        return "";
    L37:
        r118 = false;
    L33:
        r117 = "";
    L14:
        e = e;
        r112 = r106;
        r100 = r109;
    L50:
        r114 = "VideoGenerateShareHelper";
        goto L51
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        FLogger.f375446a.i("VideoGenerateShareHelper", "getShareVideoUrlAsMessage shareScene:" + r101 + " messageId:" + r212 + " creationId:" + r215);
        r112 = new Ref.ObjectRef();
        if (r214 == false) goto L56;
        r100.post(new d(r112, r100));
    L56:
        r102.L$0 = r100;     // Catch: NetworkErrorException -> L49
        r102.L$1 = r101;     // Catch: NetworkErrorException -> L49
        r102.L$2 = r213;     // Catch: NetworkErrorException -> L49
        r102.L$3 = r112;     // Catch: NetworkErrorException -> L49
        r102.label = 1;     // Catch: NetworkErrorException -> L49
        JSONObject r122 = new JSONObject();     // Catch: NetworkErrorException -> L49
        r122.put(MusicAppletPage.KEY_MESSAGE_ID, r212);     // Catch: NetworkErrorException -> L49
        r122.put("creation_id", r215);     // Catch: NetworkErrorException -> L49
        Unit r123 = Unit.INSTANCE;     // Catch: NetworkErrorException -> L49
        r114 = "VideoGenerateShareHelper";
        r111 = HttpExtKt.k(ServiceType.UGC, SaveBigVideoShareInfoData.class, "/alice/media/bigmusic/share_save", r122, null, null, false, null, null, null, r102, 1008);     // Catch: NetworkErrorException -> L47
        if (r111 != r110) goto L26;
        return r110;
    L26:
        r113 = r213;
    L49:
        e = e;
    L7:
        r102 = new VideoGenerateShareHelper$getShareVideoUrlAsMessage$1(this, r216);
        goto L8
    }

    public static VideoShareCallback f(VideoGenerateShareHelper r210, View r310, CoroutineScope r311, l0 r312, nr9.g r313, String r314, ShareScene r315, c4 r316, Integer r317, String r318, Map r319, int r410) {
        if ((r410 & 32) == 0) goto L5;
        ShareScene r100 = ShareScene.VIDEO_VIEWER;
    L7:
        if ((r410 & 128) == 0) goto L9;
        c4 r101 = null;
    L11:
        if ((r410 & 512) == 0) goto L13;
        Integer r110 = null;
    L15:
        if ((r410 & 2048) == 0) goto L17;
        Map r111 = null;
    L18:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r310, "shareContainer");
        Intrinsics.checkNotNullParameter(r311, "scope");
        Intrinsics.checkNotNullParameter(r314, "messageId");
        Intrinsics.checkNotNullParameter(r100, "shareScene");
        if (r101 != null) goto L22;
        r101 = new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);
    L22:
        return new VideoShareCallback(r314, r310, r100, r311, r312, r101, r313, r110, r318, r111);
    L17:
        r111 = r319;
        goto L18
    L13:
        r110 = r317;
        goto L15
    L9:
        r101 = r316;
        goto L11
    L5:
        r100 = r315;
        goto L7
    }

    public static void i(View r110, CoroutineScope r210, l0 r211, nr9.g r212, String r213, ShareScene r214, com.larus.bmhome.share.panel.h r215, c4 r216, boolean r217, Integer r218, String r219, Map r310, Integer r311) {
        Intrinsics.checkNotNullParameter(r110, "shareContainer");
        Intrinsics.checkNotNullParameter(r210, "scope");
        Intrinsics.checkNotNullParameter(r213, "messageId");
        Intrinsics.checkNotNullParameter(r214, "shareScene");
        BuildersKt.launch$default(r210, Dispatchers.getIO(), null, new VideoGenerateShareHelper$shareWithShareService$1(r213, r110, r214, r210, r211, r216, r212, r218, r219, r310, r311, r215, r217, null), 2, null);
    }

    public static /* synthetic */ void j(VideoGenerateShareHelper r110, View r111, CoroutineScope r112, l0 r113, nr9.g r114, String r210, ShareScene r211, com.larus.bmhome.share.panel.h r212, c4 r213, Integer r214, String r215, Map r216, Integer r217, int r218) {
        if ((r218 & 32) == 0) goto L5;
        ShareScene r100 = ShareScene.VIDEO_VIEWER;
    L7:
        if ((r218 & 64) == 0) goto L9;
        com.larus.bmhome.share.panel.h r101 = null;
    L11:
        if ((r218 & 128) == 0) goto L13;
        c4 r102 = null;
    L15:
        if ((r218 & 256) == 0) goto L17;
        boolean r115 = true;
    L19:
        if ((r218 & 512) == 0) goto L21;
        Integer r116 = null;
    L23:
        if ((r218 & 2048) == 0) goto L25;
        Map r117 = null;
    L27:
        if ((r218 & 4096) == 0) goto L29;
        Integer r118 = null;
    L30:
        r110.getClass();
        i(r111, r112, r113, r114, r210, r100, r101, r102, r115, r116, r215, r117, r118);
        return;
    L29:
        r118 = r217;
        goto L30
    L25:
        r117 = r216;
        goto L27
    L21:
        r116 = r214;
        goto L23
    L17:
        r115 = false;
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

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(final Context r310, DialogFragment r311, final jr9.a r312, DialogFragment r313, final String r314, View r315, ShareScene r410, CoroutineScope r411, l0 r412, c4 r413, final nr9.g r414, String r415, Integer r416, final String r417, Map r418) {
        String r110 = "VideoGenerateShareHelper";
        Intrinsics.checkNotNullParameter(r312, "shareItemConfig");
        Intrinsics.checkNotNullParameter(r314, "messageId");
        Intrinsics.checkNotNullParameter(r315, "shareContainer");
        Intrinsics.checkNotNullParameter(r410, "shareScene");
        Intrinsics.checkNotNullParameter(r411, "scope");
        Intrinsics.checkNotNullParameter(r413, "eventParams");
        if (r412 != null) goto L5;
        final l0 r111 = new l0(r315.getContext(), 0.0f, false, 6);
    L6:
        r111.setCancelable(true);
        if (r311 != null) goto L80;
    L14:
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = r415;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L71
        FLogger.f375446a.i("VideoGenerateShareHelper", "Save video start type video , channel aweme currentType = " + r312.c());     // Catch: Throwable -> L71
        if (Intrinsics.areEqual(r312.b(), "report") == false) goto L79;
        IAIChatService.Companion r101 = IAIChatService.f365899a;     // Catch: Throwable -> L71
        if (r416 == null) goto L20;
        int r113 = r416.intValue();     // Catch: Throwable -> L71
    L21:
        if (r416 != null) goto L24;
    L28:
        String r102 = r314;
    L29:
        Intrinsics.checkNotNullParameter(r102, "entityId");     // Catch: Throwable -> L71
        TipOffDialogParams r103 = new TipOffDialogParams(r113, r102, null, null, "", "", 0, null, null, null, null, null, null, null, null);     // Catch: Throwable -> L71
        r103.f314700g = 0;     // Catch: Throwable -> L71
        BaseTipOffDialog r104 = r101.g8(r103);     // Catch: Throwable -> L71
        if (r313 == null) goto L32;
        a(r104, r313.getParentFragmentManager());     // Catch: Throwable -> L71
        return;
    L32:
        Context r105 = r315.getContext();     // Catch: Throwable -> L71
        if ((r105 instanceof FragmentActivity) == false) goto L35;
        FragmentActivity r106 = (FragmentActivity) r105;     // Catch: Throwable -> L71
    L36:
        if (r106 == null) goto L85;
        FragmentManager r107 = r106.getSupportFragmentManager();     // Catch: Throwable -> L71
        if (r107 == null) goto L86;
        a(r104, r107);     // Catch: Throwable -> L71
        return;
    L86:
        return;
    L85:
        return;
    L35:
        r106 = null;
        goto L36
    L24:
        if (r416.intValue() != 8) goto L28;
        if (r417 != null) goto L27;
        r102 = "";
        goto L29
    L27:
        r102 = r417;
        goto L29
    L20:
        r113 = 2;
        goto L21
    L79:
        if (Intrinsics.areEqual(r312.b(), ShareChannel.SAVE_VIDEO) == false) goto L65;
        c(r111);     // Catch: Throwable -> L71
        VideoGenerateSaver r108 = VideoGenerateSaver.f315328a;     // Catch: Throwable -> L71
        JSONObject r109 = r413.f314996m;     // Catch: Throwable -> L71
        if (r109 == null) goto L47;
        String r114 = r109.toString();     // Catch: Throwable -> L71
        if (r114 == null) goto L47;
    L48:
        JSONObject r115 = new JSONObject(r114);     // Catch: Throwable -> L71
        String r116 = r312.f500142b.get("_mixed_richmedia_download_trace");     // Catch: Throwable -> L71
        if (r116 == null) goto L51;
        r115.put("_mixed_richmedia_download_trace", r116);     // Catch: Throwable -> L71
    L51:
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L71
        com.larus.bmhome.video.save_share.a.C4112a.a(r108, r310, r414, c4.a(r413, r115), "share_panel_click", r411, false, z2.f365865a.Q3(), r413.f314996m, r418, null, true, new f(r310, r111, r314, r417), 544);     // Catch: Throwable -> L62
        if (r313 != null) goto L82;
        return;
    L82:
        r313.dismiss();     // Catch: Exception -> L57 Throwable -> L62
    L89:
        return;
    L57:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L62
        Throwable r118 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L62
        if (r118 == null) goto L87;
        com.bytedance.crash.d.d(r118, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L62
        return;
    L87:
        return;
    L47:
        r114 = SliceInitService.DEFAULT_SWITCH;
        goto L48
    L65:
        r110 = "VideoGenerateShareHelper";
        if (Intrinsics.areEqual(r312.b(), ShareChannel.DOUYIN) == false) goto L69;
        c(r111);     // Catch: Throwable -> L62
        com.larus.bmhome.video.save_share.a.C4112a.a(VideoGenerateSaver.f315328a, r310, r414, new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383), "", r411, false, false, null, r418, null, true, new g(r310, r312, r414, r111), 704);     // Catch: Throwable -> L62
        return;
    L69:
        Object r119 = Result.m9449constructorimpl(BuildersKt.launch$default(r411, Dispatchers.getIO(), null, new VideoGenerateShareHelper$shareVideo$1$6(r100, r315, r410, r314, r414, r417, r310, r312, null), 2, null));     // Catch: Throwable -> L62
    L74:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L90;
        FLogger.f375446a.e(r110, "Save video error state ", r120);
        return;
    L90:
        return;
    L62:
        th = th;
    L73:
        Result.Companion r121 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L71:
        th = th;
        goto L73
    L80:
        r311.dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r122 = DialogFragmentLancet.sLastShowStack;
        if (r122 == null) goto L14;
        com.bytedance.crash.d.d(r122, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    L5:
        r111 = r412;
        goto L6
    }
}
