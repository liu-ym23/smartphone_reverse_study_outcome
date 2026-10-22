package com.ss.android.lark.officesdk.minutes.service.foundation.utils.user;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmParticipantType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmSubtitleSpeakerType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.i;
import com.ss.android.lark.pb.minutes.v1.MinutesChatter;
import com.ss.android.lark.pb.minutes.v1.MinutesMgetChattersResponse;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes37.dex */
public final class MmUserInfoHelper implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, i> f434083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LruCache<String, String> f434084d;

    public MmUserInfoHelper(MinutesUCCImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "mmUccApi");
        this.f434081a = r100;
        this.f434082b = "MmUserInfoHelper";
        this.f434083c = new ConcurrentHashMap();
        this.f434084d = new LruCache(100);
    }

    public final i f(i r110) {
        Intrinsics.checkNotNullParameter(r110, MmEndWindowAvatar.TYPE_SPEAKER);
        boolean r100 = false;
        if (r110.f435244f.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return r110;
    L8:
        i r102 = this.f434083c.get(r110.f435239a);
        if (r102 != null) goto L12;
        return null;
    L12:
        if (r102.f435244f.length() != 0) goto L14;
        r100 = true;
    L14:
        if (r100 == false) goto L17;
        return null;
    L17:
        return i.a(r102, MmParticipantType.LARK_USER, MmSubtitleSpeakerType.VOICE_PRINT_SPEAKER, null, null, 115);
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a
    public final void a(LKUIRoundedImageView r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        Intrinsics.checkNotNullParameter(r101, "config");
        if (r101.f434093b > 0) goto L5;
    L22:
        lvb.a.b(this.f434082b, "loadAvatarViewWithUrl skip, invalid size: " + r101.f434093b + Permission.EXECUTE + r101.f434094c);
        return;
    L5:
        if (r101.f434094c <= 0) goto L22;
        if (r101.f434092a.length() != 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L14;
        lvb.a.b(this.f434082b, "loadAvatarViewWithUrl skip, url is empty");
        return;
    L14:
        RequestBuilder r103 = Glide.with(r100.getContext()).load(r101.f434092a).centerCrop();
        int r104 = r101.f434096e;
        if (r104 == 0) goto L17;
        r103 = (RequestBuilder) r103.error(r104);
    L17:
        int r105 = r101.f434095d;
        if (r105 == 0) goto L20;
        r103 = (RequestBuilder) r103.placeholder(r105);
    L20:
        r103.override(r101.f434093b, r101.f434094c).into(r100);
        return;
    L10:
        r102 = false;
        goto L11
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a
    public final void b(LKUIRoundedImageView r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        Intrinsics.checkNotNullParameter(r101, "config");
        if (r101.f434088c > 0) goto L5;
    L9:
        lvb.a.b(this.f434082b, "loadAvatarViewWithKey skip, invalid size: " + r101.f434088c + Permission.EXECUTE + r101.f434089d);
        return;
    L5:
        if (r101.f434089d <= 0) goto L9;
        BuildersKt.launch$default(this.f434081a.B(), null, null, new MmUserInfoHelper$loadAvatarViewWithKey$1(this, r101, r100, null), 3, null);
    }

    public final Object d(b r110, Continuation<? super Bitmap> r111) {
        if ((r111 instanceof MmUserInfoHelper$getAvatarWithKey$1) == false) goto L7;
        MmUserInfoHelper$getAvatarWithKey$1 r100 = (MmUserInfoHelper$getAvatarWithKey$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MmUserInfoHelper$getAvatarWithKey$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        boolean r112 = true;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L46:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r106 = (String) r102.L$1;
        b r107 = (b) r102.L$0;
        ResultKt.throwOnFailure(r103);
        Object r108 = ((Result) r103).m9458unboximpl();
    L28:
        if (Result.m9455isFailureimpl(r108) == false) goto L30;
        r108 = null;
    L30:
        String r109 = (String) r108;
        if (r109 == null) goto L33;
        this.f434084d.put(r106, r109);
    L35:
        if (r109 != null) goto L37;
    L40:
        if (r112 == false) goto L43;
        lvb.a.b(this.f434082b, "entityId:" + r107.f434087b + ", avatarKey: " + r107.f434086a + ", avatarPath is empty ");
        return null;
    L43:
        CoroutineDispatcher r113 = Dispatchers.getIO();
        MmUserInfoHelper$getAvatarWithKey$2 r114 = new MmUserInfoHelper$getAvatarWithKey$2(r109, r107, this, null);
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        r103 = BuildersKt.withContext(r113, r114, r102);
        if (r103 != r104) goto L46;
        return r104;
    L37:
        if (r109.length() == 0) goto L40;
        r112 = false;
        goto L40
    L33:
        r109 = null;
        goto L35
    L16:
        ResultKt.throwOnFailure(r103);
        if (r110.f434088c > 0) goto L19;
    L47:
        lvb.a.b(this.f434082b, "getAvatarWithKey skip, invalid size: " + r110.f434088c + Permission.EXECUTE + r110.f434089d);
        return null;
    L19:
        if (r110.f434089d <= 0) goto L47;
        Resources r115 = UIHelper.getResources();
        float r116 = WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).density;
        int r117 = (int) Math.max(r110.f434088c, r110.f434089d);
        String r118 = r110.f434087b + '_' + r110.f434086a + '_' + r110.f434088c + Permission.EXECUTE + r110.f434089d;
        lvb.a.e(this.f434082b, "pathKey --> " + r118);
        r109 = this.f434084d.get(r118);
        if (r109 != null) goto L34;
        String r119 = r110.f434087b;
        String r120 = r110.f434086a;
        r102.L$0 = r110;
        r102.L$1 = r118;
        r102.label = 1;
        r108 = g(r119, r120, r117, r116, r102);
        if (r108 != r104) goto L26;
        return r104;
    L26:
        r107 = r110;
        r106 = r118;
        goto L28
    L34:
        r107 = r110;
    L7:
        r100 = new MmUserInfoHelper$getAvatarWithKey$1(this, r111);
        goto L8
    }

    public final Object e(c r100, Continuation<? super Bitmap> r101) {
        if (r100.f434093b > 0) goto L5;
    L16:
        lvb.a.b(this.f434082b, "getAvatarWithUrl skip, invalid size: " + r100.f434093b + Permission.EXECUTE + r100.f434094c);
        return null;
    L5:
        if (r100.f434094c <= 0) goto L16;
        if (r100.f434092a.length() != 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L15;
        lvb.a.b(this.f434082b, "getAvatarWithUrl skip, url is empty");
        return null;
    L15:
        return BuildersKt.withContext(Dispatchers.getIO(), new MmUserInfoHelper$getAvatarWithUrl$2(r100, this, null), r101);
    L10:
        r102 = false;
        goto L11
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.a
    public final Object c(String r110, i r111, Continuation<? super Result<i>> r112) {
        if ((r112 instanceof MmUserInfoHelper$getUserInfo$1) == false) goto L7;
        MmUserInfoHelper$getUserInfo$1 r100 = (MmUserInfoHelper$getUserInfo$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        r111 = (i) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L14
        Object r114 = ((Result) r113).m9458unboximpl();     // Catch: Throwable -> L14
    L52:
        if (Result.m9455isFailureimpl(r114) == false) goto L54;
        Object r105 = null;
    L55:
        MinutesMgetChattersResponse r106 = (MinutesMgetChattersResponse) r105;     // Catch: Throwable -> L14
        if (Result.m9456isSuccessimpl(r114) == false) goto L69;
        if (r106 == null) goto L69;
        MinutesChatter r115 = (MinutesChatter) CollectionsKt.firstOrNull(r106.chatters);     // Catch: Throwable -> L14
        if (r115 == null) goto L67;
        String r116 = r115.name;     // Catch: Throwable -> L14
        if (r116.length() != 0) goto L63;
        r104 = true;
    L63:
        if (r104 == false) goto L65;
        r116 = "";
    L65:
        String r107 = r116;
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L14
        i r117 = i.a(r111, null, null, r107, r115.avatar_key, 31);     // Catch: Throwable -> L14
        this.f434083c.put(r111.f435239a, r117);     // Catch: Throwable -> L14
        return Result.m9449constructorimpl(r117);
    L67:
        lvb.a.b(this.f434082b, "getUserInfo failed empty user info");     // Catch: Throwable -> L14
        return Result.m9449constructorimpl(ResultKt.createFailure(new Exception("empty user info")));
    L69:
        lvb.a.b(this.f434082b, "getUserInfo failed or empty result exception:" + Result.m9452exceptionOrNullimpl(r114));     // Catch: Throwable -> L14
        Throwable r118 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L14
        if (r118 != null) goto L73;
        r118 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);     // Catch: Throwable -> L14
    L73:
        return Result.m9449constructorimpl(ResultKt.createFailure(r118));
    L54:
        r105 = r114;
        goto L55
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r113);
        if (r111.f435244f.length() <= 0) goto L21;
        boolean r119 = true;
    L22:
        if (r119 == true) goto L24;
    L30:
        i r108 = this.f434083c.get(r111.f435239a);
        if (r108 == null) goto L45;
        if (r108.f435244f.length() <= 0) goto L35;
        boolean r120 = true;
    L36:
        if (r120 == false) goto L45;
        if (r108.f435245g.length() <= 0) goto L40;
        boolean r121 = true;
    L41:
        if (r121 == false) goto L45;
        Result.Companion r122 = Result.Companion;
        return Result.m9449constructorimpl(i.a(r108, MmParticipantType.LARK_USER, MmSubtitleSpeakerType.VOICE_PRINT_SPEAKER, null, null, 115));
    L40:
        r121 = false;
        goto L41
    L35:
        r120 = false;
    L45:
        if (r111.f435242d.isLarkUser() == false) goto L47;
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L14
        MmRecordingNetHelper r124 = this.f434081a.G();     // Catch: Throwable -> L14
        List r109 = CollectionsKt.listOf(r111.f435239a);     // Catch: Throwable -> L14
        r100.L$0 = r111;     // Catch: Throwable -> L14
        r100.label = 1;     // Catch: Throwable -> L14
        r114 = r124.t(r109, r100);     // Catch: Throwable -> L14
        if (r114 != r102) goto L52;
        return r102;
    L47:
        return Result.m9449constructorimpl(r111);
    L24:
        if (r111.f435245g.length() <= 0) goto L26;
        boolean r125 = true;
    L27:
        if (r125 == false) goto L30;
        this.f434083c.put(r111.f435239a, r111);
        return Result.m9449constructorimpl(r111);
    L26:
        r125 = false;
        goto L27
    L21:
        r119 = false;
    L14:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new MmUserInfoHelper$getUserInfo$1(this, r112);
        goto L8
    }

    public final Object g(String r110, String r111, int r112, float r113, Continuation<? super Result<String>> r114) {
        if ((r114 instanceof MmUserInfoHelper$syncGetAvatarPath$1) == false) goto L7;
        MmUserInfoHelper$syncGetAvatarPath$1 r100 = (MmUserInfoHelper$syncGetAvatarPath$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r115 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r115);
    L18:
        return ((Result) r115).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r115);
        ExecutorCoroutineDispatcher r116 = MMCoroutines.a();
        MmUserInfoHelper$syncGetAvatarPath$2 r104 = new MmUserInfoHelper$syncGetAvatarPath$2(r110, r111, r112, r113, null);
        r100.label = 1;
        r115 = BuildersKt.withContext(r116, r104, r100);
        if (r115 != r102) goto L18;
        return r102;
    L7:
        r100 = new MmUserInfoHelper$syncGetAvatarPath$1(this, r114);
        goto L8
    }
}
