package com.larus.bot.impl.feature.botmaker;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.bean.BotGenBgImageResponse;
import com.larus.bot.impl.bean.GenBotImageRequest;
import com.larus.bot.impl.common.util.BitmapHelperKt;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.message.Message;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.y;
import com.larus.platform.model.bot.BotMakerDataModel;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.o0;
import com.ss.ttvideoengine.DataLoaderHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f317981a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f317982b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final UgcBotRepo f317983c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f317984d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f317985e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Job> f317986f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<String, Job> f317987g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, String> f317988h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<String, String> f317989i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map<String, BgImage> f317990j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<String, String> f317991k = null;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bot/impl/feature/botmaker/BotMakerModel$getBotMakerDataFromJson$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/platform/model/bot/BotMakerDataModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<BotMakerDataModel> {
        public a() {
        }
    }

    public k() {
    }

    static {
        f317981a = new k();
        f317982b = new Gson();
        Lazy<UgcBotRepo> r100 = UgcBotRepo.f319353d;
        f317983c = UgcBotRepo.a.a();
        f317984d = LazyKt.lazy(new g());
        f317985e = LazyKt.lazy(new h());
        f317986f = new LinkedHashMap();
        f317987g = new LinkedHashMap();
        f317988h = new LinkedHashMap();
        f317989i = new LinkedHashMap();
        f317990j = new LinkedHashMap();
        f317991k = new LinkedHashMap();
    }

    public static BotLanguage e() {
        e0 r100 = AuthModelDelegate.f297134b.e().getValue();
        if (r100 == null) goto L12;
        LaunchInfo r101 = r100.f297186a;
        if (r101 == null) goto L12;
        List<com.larus.im.bean.bot.BotLanguage> r102 = r101.j();
        if (r102 == null) goto L12;
        List<com.larus.im.bean.bot.BotLanguage> r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L10:
        if (r105.hasNext() == false) goto L14;
        com.larus.im.bean.bot.BotLanguage r106 = (com.larus.im.bean.bot.BotLanguage) r105.next();
        r104.add(new BotLanguage(r106.getLanguageCode(), r106.getLanguage(), r106.getLanguageLocal()));
    L14:
        if (AppHost.f326268a.isOversea() == false) goto L39;
        if (r104 == null) goto L25;
        Iterator r107 = r104.iterator();
    L18:
        if (r107.hasNext() == false) goto L22;
        Object r108 = r107.next();
        String r109 = ((BotLanguage) r108).c();
        AppLocaleUtils.f375332a.getClass();
        if (Intrinsics.areEqual(r109, AppLocaleUtils.c().getLanguage()) == false) goto L18;
    L23:
        BotLanguage r110 = (BotLanguage) r108;
        if (r110 == null) goto L25;
    L64:
        return r110;
    L22:
        r108 = null;
    L25:
        if (r104 == null) goto L34;
        Iterator r111 = r104.iterator();
    L28:
        if (r111.hasNext() == false) goto L32;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((BotLanguage) r112).c(), "en") == false) goto L28;
    L33:
        r110 = (BotLanguage) r112;
    L35:
        if (r110 != null) goto L64;
        if (r104 != null) goto L63;
        return null;
    L63:
        return (BotLanguage) ListProtector.get(r104, 0);
    L32:
        r112 = null;
        goto L33
    L34:
        r110 = null;
        goto L35
    L39:
        if (r104 == null) goto L49;
        Iterator r113 = r104.iterator();
    L42:
        if (r113.hasNext() == false) goto L46;
        Object r114 = r113.next();
        if (Intrinsics.areEqual(((BotLanguage) r114).c(), "zh") == false) goto L42;
    L47:
        r110 = (BotLanguage) r114;
        if (r110 != null) goto L64;
    L46:
        r114 = null;
    L49:
        if (r104 != null) goto L51;
        return null;
    L51:
        return (BotLanguage) ListProtector.get(r104, 0);
    L12:
        r104 = null;
        goto L14
    }

    public static void b(Message r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        final String r100 = r110.getMessageId();
        String r101 = r110.getConversationId();
        long r102 = r110.getServerIndex();
        String r103 = r110.getContent();
        boolean r104 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L32;
        Map<String, Job> r106 = f317986f;
        if (r106.containsKey(r100) == false) goto L14;
        Job r107 = (Job) ((LinkedHashMap) r106).get(r100);
        return;
    L14:
        if (r101 != null) goto L16;
    L17:
        r104 = true;
    L18:
        if (r104 == false) goto L20;
        return;
    L20:
        if (r102 == (-1)) goto L33;
        IChatRepoService r108 = RepoDispatcherDelegate.f307737b.e();
        BotMakerDataModel r111 = d(r103);
        if (r111 == null) goto L31;
        BotMakerDataModel r109 = BotMakerDataModel.copy$default(r111, null, null, null, null, null, 31, null);
        if (r109 == null) goto L34;
        Job r112 = BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BotMakerModel$generateImageUrl$job$1(r108, r101, r102, r109, r100, null), 3, null);
        r112.invokeOnCompletion(new i(r100));
        r106.put(r100, r112);
        return;
    L34:
        return;
    L31:
        return;
    L33:
        return;
    L16:
        if (r101.length() != 0) goto L18;
    L32:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r105 = false;
        goto L9
    }

    public static BotMakerDataModel d(String r100) {
        return (BotMakerDataModel) f317982b.fromJson(r100, new a().getType());
    L4:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(final String r110, String r111) {
        boolean r100 = true;
        if (r111 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L35;
        if (r110 != null) goto L12;
    L15:
        if (r100 == true) goto L36;
        Map<String, Job> r102 = f317987g;
        if (r102.containsKey(r110) == true) goto L37;
        LinkedHashMap r103 = (LinkedHashMap) f317991k;
        if (o0.d((String) r103.get(r110)) == false) goto L23;
        String r112 = (String) r103.get(r110);
        return;
    L23:
        BotLanguage r104 = e();
        if (r104 == null) goto L29;
        String r105 = r104.c();
        if (r105 == null) goto L29;
        String r106 = r105;
    L30:
        Ref.ObjectRef r107 = new Ref.ObjectRef();
        r107.element = "";
        Job r113 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new BotMakerModel$generateVoice$job$1(r111, r106, r107, r110, null), 2, null);
        if (r113 == null) goto L33;
        r113.invokeOnCompletion(new j(r110));
    L33:
        r102.put(r110, r113);
        String r114 = (String) r107.element;
        return;
    L29:
        r106 = "";
        goto L30
    L37:
        return;
    L36:
        return;
    L12:
        if (r110.length() == 0) goto L15;
        r100 = false;
        goto L15
    L35:
        return;
    L5:
        if (r111.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(k r210, String r310, String r311, Continuation r312) {
        r210.getClass();
        if ((r312 instanceof BotMakerModel$requestBotBgImage$1) == false) goto L7;
        BotMakerModel$requestBotBgImage$1 r100 = (BotMakerModel$requestBotBgImage$1) r312;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L25;
        if (r103 == 1) goto L24;
        if (r103 == 2) goto L23;
        if (r103 == 3) goto L21;
        if (r103 != 4) goto L20;
        BotAvatarIconData r104 = (BotAvatarIconData) r100.L$1;
        com.larus.network.http.a r105 = (com.larus.network.http.a) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L17
    L67:
        Object r106 = Result.m9449constructorimpl((ImageUploadResult) ((com.larus.network.http.a) r102).f360135b);     // Catch: Throwable -> L17
    L73:
        if (Result.m9455isFailureimpl(r106) == false) goto L75;
        r106 = null;
    L75:
        ImageUploadResult r107 = (ImageUploadResult) r106;
    L79:
        if (r107 == null) goto L81;
        String r108 = r107.getUploadUrl();
    L83:
        if (o0.d(r108) == false) goto L97;
        if (r107 == null) goto L86;
        String r109 = r107.getUploadUri();
    L88:
        if (o0.d(r109) == false) goto L97;
        if (r107 == null) goto L92;
        String r111 = r107.getUploadUri();
    L93:
        if (r107 == null) goto L95;
        String r112 = r107.getUploadUrl();
    L96:
        BotAvatarIconData r113 = new BotAvatarIconData(r111, r112, null, null, null, 28, null);
    L99:
        if (r104 == null) goto L101;
        String r114 = r104.getIconUri();
    L102:
        if (r104 == null) goto L104;
        String r115 = r104.getIconUrl();
    L105:
        BotGenBgImageResponse r116 = (BotGenBgImageResponse) r105.f360135b;
        if (r116 == null) goto L108;
        String r117 = r116.getBgImgPrompt();
    L109:
        BotGenBgImageResponse r118 = (BotGenBgImageResponse) r105.f360135b;
        if (r118 == null) goto L112;
        String r119 = r118.getBgImgPromptEn();
    L113:
        BotGenBgImageResponse r120 = (BotGenBgImageResponse) r105.f360135b;
        if (r120 == null) goto L116;
        Boolean r211 = r120.getBgImgOpen();
    L125:
        return new y(new wu8.d(r113, new BgImage(r114, r115, null, new BgImageInfo(r117, r119, Boxing.boxBoolean(true), null, r211, null, null, null, null, null, null, DataLoaderHelper.DATALOADER_KEY_INT_NET_LOG_MAX_SIZE, null))), null, 14);
    L116:
        r211 = null;
        goto L125
    L112:
        r119 = null;
        goto L113
    L108:
        r117 = null;
        goto L109
    L104:
        r115 = null;
        goto L105
    L101:
        r114 = null;
        goto L102
    L95:
        r112 = null;
        goto L96
    L92:
        r111 = null;
        goto L93
    L86:
        r109 = null;
    L97:
        r113 = r104;
        goto L99
    L81:
        r108 = null;
    L17:
        th = th;
        com.larus.network.http.a r121 = r105;
        BotAvatarIconData r122 = r104;
    L71:
        Result.Companion r123 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r104 = r122;
        r105 = r121;
        goto L73
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r104 = (BotAvatarIconData) r100.L$1;
        com.larus.network.http.a r124 = (com.larus.network.http.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L22:
        r122 = r104;
        r121 = r124;
        File r125 = (File) r102;
        if (r125 != null) goto L122;
        r104 = r122;
        r124 = r121;
    L77:
        r105 = r124;
        r107 = null;
        goto L79
    L122:
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L70
        BotImageUploadViewModel r127 = (BotImageUploadViewModel) f317985e.getValue();     // Catch: Throwable -> L70
        Uri r128 = Uri.fromFile(r125);     // Catch: Throwable -> L70
        r100.L$0 = r121;     // Catch: Throwable -> L70
        r100.L$1 = r122;     // Catch: Throwable -> L70
        r100.label = 4;     // Catch: Throwable -> L70
        r102 = BotImageUploadViewModel.syncUpload$default(r127, r128, 0, null, false, r100, 14, null);     // Catch: Throwable -> L70
        if (r102 == r110) goto L129;
        r104 = r122;
        r105 = r121;
        goto L67
    L129:
        return r110;
    L70:
        th = th;
        goto L71
    L23:
        r104 = (BotAvatarIconData) r100.L$1;
        r124 = (com.larus.network.http.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L55:
        Bitmap r129 = (Bitmap) r102;
    L57:
        if (r129 == null) goto L77;
        r100.L$0 = r124;
        r100.L$1 = r104;
        r100.label = 3;
        r102 = BitmapHelperKt.g(null, r129, BgSelectViewModel.AVATAR_BITMAP_CACHE_FILE_NAME, r100);
        if (r102 != r110) goto L22;
        return r110;
    L24:
        ResultKt.throwOnFailure(r102);
    L28:
        r124 = (com.larus.network.http.a) r102;
        if ((r124 instanceof com.larus.network.http.f) == true) goto L124;
        BotGenBgImageResponse r130 = (BotGenBgImageResponse) r124.f360135b;
        if (r130 == null) goto L36;
        List<BotAvatarIconData> r131 = r130.getBgImgList();
        if (r131 == null) goto L36;
        r104 = (BotAvatarIconData) CollectionsKt.firstOrNull(r131);
    L37:
        if (r104 == null) goto L39;
        String r132 = r104.getIconUri();
    L41:
        if (o0.d(r132) == false) goto L118;
        if (r104 == null) goto L44;
        String r133 = r104.getIconUrl();
    L46:
        if (o0.d(r133) == false) goto L118;
        if (r104 == null) goto L77;
        String r134 = r104.getIconUrl();
        if (r134 == null) goto L77;
        String r135 = r104.getIconUri();
        if (r135 == null) goto L56;
        AIGenBgImageRepository r136 = (AIGenBgImageRepository) f317984d.getValue();
        r100.L$0 = r124;
        r100.L$1 = r104;
        r100.label = 2;
        r102 = r136.a(r135, r134, new com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.a(), r100);
        if (r102 != r110) goto L55;
        return r110;
    L56:
        r129 = null;
        goto L57
    L44:
        r133 = null;
    L118:
        AsyncThrowable.Companion.getClass();
        return new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null);
    L39:
        r132 = null;
    L36:
        r104 = null;
        goto L37
    L124:
        return new com.larus.network.http.f(((com.larus.network.http.f) r124).f360157d, null);
    L25:
        ResultKt.throwOnFailure(r102);
        AIGenBgImageRepository r137 = (AIGenBgImageRepository) f317984d.getValue();
        GenBotImageRequest r138 = new GenBotImageRequest(r310, r311, null, null, null, null, null, null, null, Boxing.boxBoolean(false), 508, null);
        r100.label = 1;
        r102 = r137.b("", 1, r138, "bot_maker", null, r100);
        if (r102 != r110) goto L28;
        return r110;
    L7:
        r100 = new BotMakerModel$requestBotBgImage$1(r210, r312);
        goto L8
    }
}
