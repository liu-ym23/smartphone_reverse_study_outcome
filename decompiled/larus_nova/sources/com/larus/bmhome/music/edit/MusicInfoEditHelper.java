package com.larus.bmhome.music.edit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.music.protocol.UpdateBigMusicMessageApi;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.ServiceType;
import com.larus.nova.R;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.ModifiedUserCreationContent;
import com.larus.platform.api.ModifiedUserCreationMusic;
import com.larus.platform.api.ModifiedUserCreationResponse;
import com.larus.platform.service.e0;
import com.larus.utils.logger.FLogger;
import com.yalantis.ucrop.UCropActivity;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class MusicInfoEditHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MusicInfoEditHelper f312799a = null;

    static {
        f312799a = new MusicInfoEditHelper();
    }

    public MusicInfoEditHelper() {
    }

    public static ActivityResultLauncher h(final Fragment r100, final a r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "callback");
        FLogger.f375446a.i("MusicInfoEditHelper", "[registerEditCoverLauncher] host:" + Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName() + '_' + r100.hashCode());
        final ActivityResultLauncher r102 = r100.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new m(r100, r101));
        return r100.registerForActivityResult(new ActivityResultContracts.GetContent(), new n(r100, r102));
    }

    public static ActivityResultLauncher i(final Fragment r100, final a r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "callback");
        FLogger.f375446a.i("MusicInfoEditHelper", "[registerEditCoverNewLauncher] host:" + Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName() + '_' + r100.hashCode());
        final ActivityResultLauncher r102 = r100.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new k(r100, r101));
        return r100.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new l(r100, r102));
    }

    public static final Object c(MusicInfoEditHelper r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof MusicInfoEditHelper$inquireIsMessageEnd$1) == false) goto L7;
        MusicInfoEditHelper$inquireIsMessageEnd$1 r103 = (MusicInfoEditHelper$inquireIsMessageEnd$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        Message r109 = (Message) r105;
        if (r109 != null) goto L20;
    L22:
        r108 = false;
    L24:
        return Boxing.boxBoolean(r108);
    L20:
        if (com.larus.bmhome.chat.bean.d.j0(r109) != true) goto L22;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        IChatRepoService r110 = RepoDispatcherDelegate.f307737b.e();
        r103.label = 1;
        r105 = r110.E1(r101, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new MusicInfoEditHelper$inquireIsMessageEnd$1(r100, r102);
        goto L8
    }

    public static void d(Uri r100, Fragment r101, ActivityResultLauncher r102) {
        if (r100 == null) goto L5;
        FLogger.f375446a.i("MusicInfoEditHelper", "[onActivityResult] called, icon_uri:" + r100);
        Uri r103 = Uri.fromFile(new PolarisFileWrapper(r101.requireActivity().getCacheDir(), "crop_image_cache.jpg"));
        Intent r104 = new Intent();
        Bundle r105 = new Bundle();
        r105.putParcelable("com.yalantis.ucrop.InputUri", r100);
        r105.putParcelable("com.yalantis.ucrop.OutputUri", r103);
        r105.putFloat("com.yalantis.ucrop.AspectRatioX", 1.0f);
        r105.putFloat("com.yalantis.ucrop.AspectRatioY", 1.0f);
        r104.setClass(r101.requireActivity(), UCropActivity.class);
        r104.putExtras(r105);
        r102.launch(r104);
        Unit r106 = Unit.INSTANCE;
        return;
    }

    public static void g(Fragment r100, Intent r101, a r110) {
        if (r101 == null) goto L5;
        Uri r102 = (Uri) r101.getParcelableExtra("com.yalantis.ucrop.OutputUri");
    L6:
        if (r102 == null) goto L8;
        r110.a(v.b.f312842a);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100.getViewLifecycleOwner()), Dispatchers.getIO().plus(kr8.t.f505892a), null, new MusicInfoEditHelper$launchImageUploader$1(r102, r100, r110, null), 2, null);
        FLogger.f375446a.i("MusicInfoEditHelper", "[onActivityResult] success");
        return;
    L8:
        r110.a(new v.a(""));
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static void e(Fragment r110, ActivityResultLauncher r111, ActivityResultLauncher r112, a r113) {
        Intrinsics.checkNotNullParameter(r110, "host");
        Intrinsics.checkNotNullParameter(r111, "editCoverLauncher");
        Intrinsics.checkNotNullParameter(r112, "editCoverNewLauncher");
        Intrinsics.checkNotNullParameter(r113, "callback");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110), null, null, new MusicInfoEditHelper$launchEditMusicCover$1$1(r113, r110, r110, r112, r111, null), 3, null);
    }

    public static void f(FragmentActivity r110, a r111, boolean r112, kr8.o r113) {
        Intrinsics.checkNotNullParameter(r110, "host");
        Intrinsics.checkNotNullParameter(r111, "callback");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110), null, null, new MusicInfoEditHelper$launchEditMusicName$1(r111, r110, r112, r113, null), 3, null);
    }

    public static final Object a(MusicInfoEditHelper r110, Fragment r111, Image r210, a r211, Continuation r212) {
        Image r100 = r210;
        r110.getClass();
        if ((r212 instanceof MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$1) == false) goto L7;
        MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$1 r101 = (MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$1 r112 = r101;
        Object r103 = r112.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r112.label;
        String r113 = null;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        MusicCreationContent r106 = (MusicCreationContent) r112.L$4;
        String r107 = (String) r112.L$3;
        a r108 = (a) r112.L$2;
        Image r109 = (Image) r112.L$1;
        Fragment r114 = (Fragment) r112.L$0;
        ResultKt.throwOnFailure(r103);
        MusicCreationContent r115 = r106;
        r100 = r109;
    L21:
        dm9.a r116 = (dm9.a) r103;
        if ((r116 instanceof dm9.a.b) == false) goto L34;
        dm9.a.b r117 = (dm9.a.b) r116;
        if (r117.f469231a.isSuccess() == false) goto L26;
        FLogger.f375446a.i("MusicInfoEditHelper", "[callUpdateBigMusicMessageApiUnify] success, messageId:" + r107 + ", image:" + r100.key);
        r108.a(v.c.f312843a);
        kr8.l.a.b(new kr8.f("music_detail", r115.getVid(), "popup_click", 1), null, 3);
    L42:
        return Unit.INSTANCE;
    L26:
        FLogger.f375446a.e("MusicInfoEditHelper", "[callUpdateBigMusicMessageApiUnify] error, messageId:" + r107 + ", code:" + r117.f469231a.getCode() + ", msg:" + r117.f469231a.getMsg());
        String r118 = r117.f469231a.getMsg();
        if (r118 != null) goto L32;
        StringBuilder r119 = new StringBuilder();
        Context r120 = r114.getContext();
        if (r120 == null) goto L31;
        r113 = r120.getString(R.string.larus_music_generate_cover_edit_toast);
    L31:
        r119.append(r113);
        r119.append(" code: ");
        r119.append(r117.f469231a.getCode());
        r118 = r119.toString();
    L32:
        r108.a(new v.a(r118));
        goto L42
    L34:
        if ((r116 instanceof dm9.a.C5690a) == false) goto L42;
        FLogger.f375446a.e("MusicInfoEditHelper", "[callUpdateBigMusicMessageApiUnify] exception, messageId:" + r107 + ", " + ((dm9.a.C5690a) r116).f469230c);
        Context r121 = r114.getContext();
        if (r121 == null) goto L39;
        String r122 = r121.getString(R.string.larus_music_generate_cover_edit_toast);
        if (r122 == null) goto L39;
    L40:
        r108.a(new v.a(r122));
    L39:
        r122 = "";
        goto L40
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        String r123 = r211.c().f312821a;
        r115 = r211.c().f312823c;
        if (r115 != null) goto L17;
        FLogger.f375446a.e("MusicInfoEditHelper", "[callUpdateBigMusicMessageApiUnify] musicContent is null");
        return Unit.INSTANCE;
    L17:
        UpdateBigMusicMessageApi.a r124 = UpdateBigMusicMessageApi.f313050a;
        MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$result$1 r125 = new MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$result$1(r123, r100, r115, null);
        r112.L$0 = r111;
        r112.L$1 = r100;
        r112.L$2 = r211;
        r112.L$3 = r123;
        r112.L$4 = r115;
        r112.label = 1;
        r124.getClass();
        FlowHttpConnection r126 = FlowHttpConnection.f359975a;
        Object r127 = FlowHttpConnection.g(ServiceType.UGC, UpdateBigMusicMessageApi.class, r125, false, null, null, null, r112, 248);
        if (r127 == r104) goto L44;
        r114 = r111;
        r107 = r123;
        r103 = r127;
        r108 = r211;
        goto L21
    L44:
        return r104;
    L7:
        r101 = new MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$1(r110, r212);
        goto L8
    }

    public static final Object b(MusicInfoEditHelper r100, Fragment r101, Image r102, a r103, Continuation r104) {
        r100.getClass();
        if ((r104 instanceof MusicInfoEditHelper$editCreationCover$1) == false) goto L7;
        MusicInfoEditHelper$editCreationCover$1 r105 = (MusicInfoEditHelper$editCreationCover$1) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        String r110 = "";
        ModifiedUserCreationMusic r111 = null;
        if (r109 == 0) goto L14;
        if (r109 != 1) goto L13;
        r103 = (a) r105.L$1;
        r101 = (Fragment) r105.L$0;
        ResultKt.throwOnFailure(r107);
    L23:
        Pair r112 = (Pair) r107;
        if (r112 == null) goto L26;
        ModifiedUserCreationResponse r113 = (ModifiedUserCreationResponse) r112.getFirst();
    L27:
        if (r113 == null) goto L33;
        ModifiedUserCreationContent r114 = r113.f364823b;
        if (r114 == null) goto L33;
        ModifiedUserCreationMusic r115 = r114.f364814a;
        if (r115 == null) goto L33;
        ImageInfo r116 = r115.f364818b;
    L34:
        if (r116 == null) goto L41;
        r103.a(v.c.f312843a);
        if (r113 == null) goto L40;
        ModifiedUserCreationContent r117 = r113.f364823b;
        if (r117 == null) goto L40;
        r111 = r117.f364814a;
    L40:
        r103.b(r111);
    L49:
        return Unit.INSTANCE;
    L41:
        Context r118 = r101.getContext();
        if (r118 == null) goto L47;
        String r119 = r118.getString(R.string.larus_music_generate_cover_edit_toast);
        if (r119 == null) goto L47;
        r110 = r119;
    L47:
        r103.a(new v.a(r110));
    L33:
        r116 = null;
        goto L34
    L26:
        r113 = null;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r107);
        String r120 = r103.c().f312822b;
        if (r103.c().f312823c != null) goto L17;
        FLogger.f375446a.e("MusicInfoEditHelper", "[callUpdateBigMusicMessageApiUnify] musicContent is null");
        return Unit.INSTANCE;
    L17:
        e0 r121 = e0.f365731a;
        if (r120 != null) goto L20;
        r120 = "";
    L20:
        String r122 = r102.key;
        r105.L$0 = r101;
        r105.L$1 = r103;
        r105.label = 1;
        r107 = r121.k(r120, null, r122, r105);
        if (r107 != r108) goto L23;
        return r108;
    L7:
        r105 = new MusicInfoEditHelper$editCreationCover$1(r100, r104);
        goto L8
    }
}
