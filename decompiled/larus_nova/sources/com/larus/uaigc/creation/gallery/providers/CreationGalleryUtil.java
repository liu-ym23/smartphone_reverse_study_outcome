package com.larus.uaigc.creation.gallery.providers;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.bigimg.AwemeImageFilter;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.search.SourceFrom;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.utils.IVideoShareService;
import com.larus.bmhome.utils.c4;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.a5;
import hq9.v1;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class CreationGalleryUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CreationGalleryUtil f372883a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f372884b = null;

    public CreationGalleryUtil() {
    }

    static {
        f372883a = new CreationGalleryUtil();
        f372884b = LazyKt.lazy(new l());
    }

    public static String d(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 != null) goto L15;
    L17:
        return "";
    L15:
        if (r100.intValue() != 3) goto L17;
        return "1";
    L10:
        if (r100.intValue() != 2) goto L12;
        return "0";
    L5:
        if (r100.intValue() != 1) goto L7;
        return "-1";
    }

    public static boolean j(Integer r100) {
        z2 r101 = z2.f365865a;
        v1 r102 = r101.getCreationShareSettings().a();
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L26;
        v1 r104 = r101.getCreationShareSettings().a();
        if (r104 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == true) goto L21;
        if (r100 == null) goto L21;
        if (r100.intValue() != 2) goto L21;
        boolean r106 = false;
    L23:
        if (r106 == false) goto L27;
        return true;
    L27:
        return false;
    L21:
        r106 = true;
        goto L23
    L12:
        if (r104.f() != true) goto L14;
        r105 = true;
        goto L15
    L26:
        return false;
    L5:
        if (r102.e() != true) goto L7;
        r103 = true;
        goto L8
    }

    public static final com.larus.bmhome.share.panel.h b(String r710, sz9.c r711) {
        JSONObject r100 = r711.f544096f;
        Integer r101 = r711.f544093c;
        if (r101 != null) goto L6;
    L8:
        boolean r110 = false;
    L9:
        Message r102 = r711.f544102l;
        if (r102 == null) goto L12;
        String r103 = r102.getMessageId();
    L13:
        Integer r111 = r711.f544093c;
        String r210 = AccountService.f365697a.getUserId();
        Message r112 = r711.f544102l;
        String r104 = r711.f544100j;
        String r113 = f(r100, "template_rec_req_id");
        String r114 = f(r100, "template_rec_extra");
        String r115 = f(r100, "from_template_id");
        String r310 = f(r100, "recommend_from");
        Message r105 = r711.f544102l;
        if (r105 == null) goto L16;
        String r610 = com.larus.im.bean.message.a.r(r105);
    L17:
        Message r106 = r711.f544102l;
        if (r106 == null) goto L20;
        String r611 = com.larus.im.bean.message.a.s(r106);
    L22:
        return new com.larus.bmhome.share.panel.h(null, null, null, r710, null, null, r103, r100, null, r110, r111, null, null, null, r113, r114, r115, r310, null, null, null, null, null, null, r210, null, null, null, null, null, null, null, null, null, null, null, null, null, r112, null, null, r104, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r610, r611, null, null, false, null, null, null, null, -68098449, -4353, 1017);
    L20:
        r611 = null;
        goto L22
    L16:
        r610 = null;
        goto L17
    L12:
        r103 = null;
        goto L13
    L6:
        if (r101.intValue() != 3) goto L8;
        r110 = true;
        goto L9
    }

    public static String f(JSONObject r100, String r101) {
        if (r100 == null) goto L13;
        String r102 = r100.optString(r101);
        if (r102 == null) goto L13;
        boolean r103 = true;
        if ((!StringsKt.isBlank(r102)) == true) goto L8;
    L10:
        r103 = false;
    L11:
        if (r103 == false) goto L13;
        return r102;
    L8:
        if (Intrinsics.areEqual(r102, "null") == true) goto L10;
    L13:
        return null;
    }

    public static void i(sz9.c r110, View r111, l0 r210) {
        Intrinsics.checkNotNullParameter(r110, "params");
        a5 r100 = z2.f365865a.getCreationShareSettings().c();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.a() != true) goto L7;
    L8:
        c4 r102 = r110.f544104n;
        String r103 = null;
        if (r102 == null) goto L11;
        String r104 = r102.f314990g;
    L12:
        boolean r105 = Intrinsics.areEqual(r104, "1");
        if (r105 == false) goto L15;
        ShareScene r106 = ShareScene.VIDEO_COMPREHEND;
    L16:
        ShareScene r112 = r106;
        nr9.g r107 = r110.f544098h;
        if (r101 == false) goto L22;
        if (r105 == true) goto L22;
        CoroutineScope r108 = r110.f544101k;
        if (r108 == null) goto L32;
        BuildersKt.launch$default(r108, null, null, new CreationGalleryUtil$shareVideo$1(r111, r107, r110, r210, r112, null), 3, null);
        return;
    L32:
        return;
    L22:
        IVideoShareService r109 = (IVideoShareService) ServiceManager.get().getService(IVideoShareService.class);
        if (r109 == null) goto L34;
        CoroutineScope r113 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        Message r114 = r110.f544102l;
        if (r114 == null) goto L27;
        r103 = r114.getMessageId();
    L27:
        if (r103 != null) goto L29;
        String r115 = "";
    L30:
        IVideoShareService.a.b(r109, r111, r113, r210, r107, r115, r112, r110.f544103m, r110.f544104n, null, null, r110.f544107q, 1280);
        return;
    L29:
        r115 = r103;
        goto L30
    L34:
        return;
    L15:
        r106 = ShareScene.VIDEO_VIEWER;
        goto L16
    L11:
        r104 = null;
    L7:
        r101 = false;
        goto L8
    }

    public final Object e(String r100, String r101, Continuation<? super UserCreationFromIM> r102) {
        if ((r102 instanceof CreationGalleryUtil$getLatestUserCreation$1) == false) goto L7;
        CreationGalleryUtil$getLatestUserCreation$1 r103 = (CreationGalleryUtil$getLatestUserCreation$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        String r108 = "";
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        String r109 = (String) r103.L$1;
        String r110 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
        r101 = r109;
        r100 = r110;
    L32:
        String r111 = (String) r105;
    L33:
        if (r111 == null) goto L37;
        r108 = r111;
    L37:
        return ((LinkedHashMap) DataConverterKt.c(r108, r100)).get(r101);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (r100 != null) goto L17;
    L20:
        boolean r112 = true;
    L21:
        r111 = null;
        if (r112 == false) goto L24;
        return null;
    L24:
        IChatRepoService r113 = RepoDispatcherDelegate.f307737b.e();
        if (r113 == null) goto L33;
        if (r100 != null) goto L28;
        String r114 = "";
    L29:
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        r105 = r113.w1(r114, r103);
        if (r105 != r106) goto L32;
        return r106;
    L28:
        r114 = r100;
        goto L29
    L17:
        if (r100.length() == 0) goto L20;
        r112 = false;
    L7:
        r103 = new CreationGalleryUtil$getLatestUserCreation$1(this, r102);
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void c(final Context r110, final sz9.c r111, View r112, final Function2 r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "rootView");
        Integer r100 = r111.f544093c;
        z2 r101 = z2.f365865a;
        v1 r102 = r101.getCreationShareSettings().a();
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L34;
        v1 r104 = r101.getCreationShareSettings().a();
        if (r104 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L22;
        if (r100 != null) goto L20;
    L30:
        boolean r106 = true;
    L32:
        if (r106 == false) goto L34;
        boolean r107 = true;
    L35:
        FragmentActivity r108 = null;
        if (r107 == false) goto L40;
        CoroutineScope r109 = r111.f544101k;
        if (r109 == null) goto L97;
        BuildersKt.launch$default(r109, null, null, new CreationGalleryUtil$showCreationShare$1(r112, r111, "download", null), 3, null);
        return;
    L97:
        return;
    L40:
        com.larus.platform.service.o r114 = com.larus.platform.service.o.f365780a;
        JSONObject r115 = r111.f544096f;
        if (r115 == null) goto L81;
        Integer r116 = r111.f544093c;
        if (r116 != null) goto L46;
    L48:
        int r117 = 0;
    L49:
        r115.put("is_image_edit", r117);
        r115.put("click_from", "click_download");
        r115.put("click_method", "detail_click");
        Integer r118 = r111.f544093c;
        if (r118 != null) goto L53;
    L55:
        int r119 = 0;
    L56:
        r115.put("is_replica_gen", r119);
        com.larus.bmhome.share.panel.h r120 = r111.f544103m;
        if (r120 == null) goto L63;
        String r121 = r120.f313932n0;
        if (r121 == null) goto L63;
        if (o0.d(r121) == false) goto L63;
        r115.put("is_general_agent", r121);
    L63:
        com.larus.bmhome.share.panel.h r122 = r111.f544103m;
        if (r122 == null) goto L70;
        String r123 = r122.f313934o0;
        if (r123 == null) goto L70;
        if (o0.d(r123) == false) goto L70;
        r115.put("chat_id", r123);
    L70:
        r115.put("is_ai_creation", 1);
        n1 r124 = r111.f544091a;
        if (r124 == null) goto L73;
        String r125 = r124.f296034e;
    L74:
        if (r125 != null) goto L76;
    L79:
        int r126 = 1;
    L80:
        r115.put("has_original_image", r126 ^ 1);
        r115.put("download_method", "click_icon");
        r115.put("is_search_card", 0);
        r115.put("creation_id", r111.f544100j);
        Unit r127 = Unit.INSTANCE;
    L82:
        r114.reportEvent("picture_download", r115);
        Uri r128 = r111.f544092b;
        if (r128 != null) goto L85;
        return;
    L85:
        final String r129 = r128.toString();
        if (Build.VERSION.SDK_INT <= 29) goto L88;
    L95:
        h(r129, false, r111, r110, "saveBitmapWithCheckWatermark", r113);
        return;
    L88:
        if (ContextCompat.checkSelfPermission(r110, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L95;
        if ((r110 instanceof FragmentActivity) == false) goto L92;
        r108 = (FragmentActivity) r110;
    L92:
        if (r108 != null) goto L94;
        return;
    L94:
        i2.f365748b.a(r108, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new o(r129, r111, r110, r113));
        return;
    L76:
        if (StringsKt.isBlank(r125) == true) goto L79;
        r126 = 0;
        goto L80
    L73:
        r125 = null;
        goto L74
    L53:
        if (r118.intValue() != 3) goto L55;
        r119 = 1;
        goto L56
    L46:
        if (r116.intValue() != 4) goto L48;
        r117 = 1;
        goto L49
    L81:
        r115 = null;
        goto L82
    L20:
        if (r100.intValue() != 3) goto L30;
    L31:
        r106 = false;
        goto L32
    L22:
        if (r100 != null) goto L25;
    L26:
        if (r100 == null) goto L30;
        if (r100.intValue() == 2) goto L31;
    L25:
        if (r100.intValue() == 3) goto L31;
    L13:
        if (r104.f() != true) goto L15;
        r105 = true;
    L34:
        r107 = false;
        goto L35
    L5:
        if (r102.b() != true) goto L7;
        r103 = true;
        goto L9
    }

    public static final Object a(CreationGalleryUtil r100, String r101, String r102, String r103, Continuation r104) {
        r100.getClass();
        if ((r104 instanceof CreationGalleryUtil$getMetaDataMap$1) == false) goto L7;
        CreationGalleryUtil$getMetaDataMap$1 r105 = (CreationGalleryUtil$getMetaDataMap$1) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        if (r109 == 0) goto L14;
        if (r109 != 1) goto L13;
        r103 = (String) r105.L$0;
        ResultKt.throwOnFailure(r107);
    L17:
        ICreationMetadataService.Companion r110 = ICreationMetadataService.f373916a;
        return r110.s((UserCreationFromIM) r107, r103);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r107);
        r105.L$0 = r103;
        r105.label = 1;
        r107 = r100.e(r101, r102, r105);
        if (r107 != r108) goto L17;
        return r108;
    L7:
        r105 = new CreationGalleryUtil$getMetaDataMap$1(r100, r104);
        goto L8
    }

    public static void g(String r110, boolean r111, sz9.c r112, Context r113, Function2 r114) {
        CoroutineScope r100 = r112.f544101k;
        if (r100 == null) goto L6;
        BuildersKt.launch$default(r100, null, null, new CreationGalleryUtil$saveBitmap$1(r111, r112, r113, r110, r114, null), 3, null);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.uaigc.creation.gallery.providers.m] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.uaigc.creation.gallery.providers.n] */
    public static void h(String r100, final boolean r101, final sz9.c r110, final Context r111, final String r112, final Function2 r113) {
        if (r110.f544106p == false) goto L6;
        g(r100, r101, r110, r111, r113);
        return;
    L6:
        final ?? r102 = new m(r101, r110, r111, r113);
        final ?? r103 = new n(r112);
        com.larus.bmhome.bigimg.l r114 = r110.f544094d;
        if (r114 == null) goto L14;
        Integer r104 = r114.f296013h;
        int r105 = SourceFrom.DouYin.value;
        if (r104 == null) goto L14;
        if (r104.intValue() != r105) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == true) goto L17;
        g(r100, r101, r110, r111, r113);
        Unit r107 = Unit.INSTANCE;
        return;
    L17:
        AwemeImageFilter r108 = (AwemeImageFilter) f372884b.getValue();
        String r109 = null;
        if (r114 == null) goto L20;
        String r115 = r114.f296006a;
    L21:
        if (r114 == null) goto L23;
        String r116 = r114.f296008c;
    L24:
        if (r114 == null) goto L26;
        r109 = r114.f296010e;
    L26:
        r108.a(r115, r116, r109, new p(r102), new q(r103));
        return;
    L23:
        r116 = null;
        goto L24
    L20:
        r115 = null;
    L14:
        r106 = false;
        goto L15
    }
}
