package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.camera.api.params.OutputParam;
import com.larus.chat.gallery.api.PreviewSelectionLimit;
import com.larus.chat.gallery.impl.preview.OriginalImagePreloader;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.gallery.api.GalleryType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.nova.R;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.model.preview.AttachmentEditType;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import yc9.l1;

/* JADX INFO: loaded from: classes26.dex */
public final class MarkAction implements o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f324686h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PreviewCameraParamProvider f324687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.chat.gallery.impl.preview.input.e0 f324688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.chat.gallery.api.q f324689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AttachmentEditType f324690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ToolbarButtonType f324691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<xy8.d, Boolean> f324692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f324693g;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324694a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f324695b = null;

        static {
            int[] r100 = new int[GalleryType.values().length];
            r100[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            f324694a = r100;
            int[] r101 = new int[PreviewSelectionLimit.MediaScope.values().length];
            r101[PreviewSelectionLimit.MediaScope.IMAGE_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r101[PreviewSelectionLimit.MediaScope.IMAGE_AND_VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            f324695b = r101;
        }
    }

    static {
    }

    public static String f(xy8.d r100) {
        xy8.f r101 = r100.f565437l;
        boolean r102 = false;
        if (r101 == null) goto L21;
        List<UplinkFileEntity> r103 = r101.f565459f;
        if (r103 == null) goto L21;
        UplinkFileEntity r104 = (UplinkFileEntity) CollectionsKt.firstOrNull(r103);
        if (r104 == null) goto L21;
        Image r105 = l1.c(r104);
        if (r105 == null) goto L21;
        String r106 = r105.key;
        if (r106 == null) goto L21;
        if (r106.length() <= 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == true) goto L19;
        r106 = null;
    L19:
        if (r106 == null) goto L21;
        return r106;
    L15:
        r107 = false;
    L21:
        UserCreation r108 = r100.f565439n;
        if (r108 != null) goto L24;
        return null;
    L24:
        int r109 = r108.f364988b;
        if (r109 != 3) goto L27;
        UserCreationContent r110 = r108.f364991e;
        if (r110 == null) goto L43;
        UserCreationUserAvatar r111 = r110.f365008c;
        if (r111 == null) goto L43;
        ImageInfo r112 = r111.f365050a;
    L44:
        if (r112 == null) goto L53;
        String r113 = r112.f364802e;
        if (r113 != null) goto L48;
        return null;
    L48:
        if (r113.length() <= 0) goto L50;
        r102 = true;
    L50:
        if (r102 == true) goto L52;
        return null;
    L52:
        return r113;
    L53:
        return null;
    L43:
        r112 = null;
        goto L44
    L27:
        if (r109 == 4) goto L33;
        UserCreationContent r114 = r108.f364991e;
        if (r114 == null) goto L43;
        UserCreationImage r115 = r114.f365006a;
        if (r115 == null) goto L43;
        r112 = r115.f365014a;
        goto L44
    L33:
        UserCreationContent r116 = r108.f364991e;
        if (r116 == null) goto L43;
        AiBeautifyUserContent r117 = r116.f365009d;
        if (r117 == null) goto L43;
        r112 = r117.f364882a;
        goto L44
    }

    public static void d(l0 r100, xy8.d r101) {
        if (r100.f324774i == false) goto L5;
        String r102 = "more_panel_click";
    L6:
        xy8.e r103 = r101.f565438m;
        String r104 = null;
        if (r103 == null) goto L10;
        String r105 = r103.f565447e;
        if (r105 == null) goto L10;
    L13:
        if (r103 == null) goto L18;
        String r106 = r103.f565445c;
        if (r106 == null) goto L18;
        r104 = r106;
    L21:
        int r107 = r101.f565442q;
        if (r101.f565426a != SourceType.USER_SEND) goto L24;
        String r108 = "user";
    L26:
        if (b.f324694a[r101.f565430e.ordinal()] != 2) goto L28;
        String r109 = "video_detail";
    L29:
        JSONObject r110 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r111 = r101.f565431f.entrySet().iterator();
    L31:
        if (r111.hasNext() == false) goto L33;
        Map.Entry<String, Object> r112 = r111.next();
        r110.put(r112.getKey(), r112.getValue());
        goto L31
    L33:
        boolean r113 = true;
        if (r105 != null) goto L36;
    L39:
        boolean r114 = true;
    L40:
        if (r114 == true) goto L42;
        r110.put("creation_task_id", r105);
    L42:
        if (r104 != null) goto L44;
    L47:
        if (r113 == true) goto L49;
        r110.put(MusicAppletPage.KEY_MESSAGE_ID, r104);
    L49:
        r110.put("position", r107);
        r110.put("user_type", r108);
        r110.put("click_from", r102);
        r110.put("current_page", r109);
        com.larus.platform.service.o.f365780a.reportEvent("click_mark_button", r110);
        return;
    L44:
        if (r104.length() == 0) goto L47;
        r113 = false;
        goto L47
    L36:
        if (r105.length() == 0) goto L39;
        r114 = false;
        goto L40
    L28:
        r109 = "picture_detail";
        goto L29
    L24:
        r108 = "bot";
    L18:
        xy8.f r115 = r101.f565437l;
        if (r115 == null) goto L21;
        r104 = r115.f565454a;
    L10:
        if (r103 == null) goto L12;
        r105 = r103.f565443a;
        goto L13
    L12:
        r105 = null;
        goto L13
    L5:
        r102 = "detail_click";
        goto L6
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r210, Continuation<? super Unit> r211) {
        l0 r100 = r210;
        String r101 = "execute: fetchBitmap result=";
        if ((r211 instanceof MarkAction$execute$1) == false) goto L7;
        MarkAction$execute$1 r102 = (MarkAction$execute$1) r211;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L29;
        if (r106 == 1) goto L23;
        if (r106 == 2) goto L18;
        if (r106 != 3) goto L17;
        String r107 = (String) r102.L$7;
        IFlowCamera r108 = (IFlowCamera) r102.L$6;
        FragmentActivity r109 = (FragmentActivity) r102.L$5;
        String r110 = (String) r102.L$4;
        String r111 = (String) r102.L$3;
        xy8.d r112 = (xy8.d) r102.L$2;
        Job r113 = (Job) r102.L$1;
        l0 r114 = (l0) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L345
        r101 = "execute: fetchBitmap result=";
    L195:
        Bitmap r115 = (Bitmap) r104;     // Catch: Throwable -> L345
        FLogger r116 = FLogger.f375446a;     // Catch: Throwable -> L345
        StringBuilder r117 = new StringBuilder(r101);     // Catch: Throwable -> L345
        if (r115 == null) goto L198;
        boolean r118 = true;
    L199:
        r117.append(r118);     // Catch: Throwable -> L345
        r117.append(", size=");     // Catch: Throwable -> L345
        if (r115 == null) goto L202;
        Integer r119 = Boxing.boxInt(r115.getWidth());     // Catch: Throwable -> L345
    L203:
        r117.append(r119);     // Catch: Throwable -> L345
        r117.append(Permission.EXECUTE);     // Catch: Throwable -> L345
        if (r115 == null) goto L206;
        Integer r120 = Boxing.boxInt(r115.getHeight());     // Catch: Throwable -> L345
    L207:
        r117.append(r120);     // Catch: Throwable -> L345
        r116.i("MarkAction", r117.toString());     // Catch: Throwable -> L345
        if (r115 != null) goto L228;
        if (r110 != null) goto L211;
    L217:
        boolean r121 = false;
    L218:
        if (r121 == false) goto L228;
        t19.s r122 = t19.s.f544207a;     // Catch: Throwable -> L345
        OriginalImagePreloader r123 = OriginalImagePreloader.f324211a;     // Catch: Throwable -> L345
        r122.getClass();     // Catch: Throwable -> L345
        t19.s.b(r109, R.string.larus_aiCreation_imageDetailsPage_toast_loadFail, false);     // Catch: Throwable -> L345
        Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L345
        if (r113 == null) goto L222;
        Job.DefaultImpls.cancel$default(r113, null, 1, null);
    L222:
        PreviewToolbarView r125 = r114.f324771f;
        if (r125 == null) goto L225;
        r125.a(this.f324691e, false);
    L225:
        this.f324693g = false;
        return r124;
    L211:
        if (r110.length() <= 0) goto L213;
        boolean r126 = true;
    L215:
        if (r126 != true) goto L217;
        r121 = true;
        goto L218
    L213:
        r126 = false;
    L228:
        if (b(r109, r112) == true) goto L238;
        Unit r127 = Unit.INSTANCE;     // Catch: Throwable -> L345
        if (r113 == null) goto L232;
        Job.DefaultImpls.cancel$default(r113, null, 1, null);
    L232:
        PreviewToolbarView r128 = r114.f324771f;
        if (r128 == null) goto L235;
        boolean r129 = false;
        r128.a(this.f324691e, false);
    L236:
        this.f324693g = r129;
        return r127;
    L235:
        r129 = false;
        goto L236
    L238:
        PreviewCameraParamProvider r130 = this.f324687a;     // Catch: Throwable -> L345
        if (r112 == null) goto L243;
        r130.getClass();     // Catch: Throwable -> L345
        xy8.b r131 = r112.f565428c;     // Catch: Throwable -> L345
        if (r131 == null) goto L243;
        boolean r132 = Intrinsics.areEqual(r131.f565417e, Boolean.TRUE);     // Catch: Throwable -> L345
    L244:
        r130.f324320i = r132;     // Catch: Throwable -> L345
        PreviewCameraParamProvider r133 = this.f324687a;     // Catch: Throwable -> L345
        AttachmentEditType r134 = this.f324690d;     // Catch: Throwable -> L345
        AttachmentEditType r135 = AttachmentEditType.MARK;     // Catch: Throwable -> L345
        if (r134 != r135) goto L247;
        AttachmentEditType r136 = AttachmentEditType.OTHER;     // Catch: Throwable -> L345
    L248:
        if (r134 != r135) goto L250;
    L253:
        boolean r137 = true;
    L254:
        com.larus.chat.gallery.api.q r138 = this.f324689c;     // Catch: Throwable -> L345
        if (r138 == null) goto L257;
        String r139 = r138.j();     // Catch: Throwable -> L345
    L258:
        InputParam r140 = r133.e(r136, r137, r139);     // Catch: Throwable -> L345
        PreviewCameraParamProvider r141 = this.f324687a;     // Catch: Throwable -> L345
        com.larus.chat.gallery.api.q r142 = this.f324689c;     // Catch: Throwable -> L345
        String r143 = r112.f565434i;     // Catch: Throwable -> L345
        if (r143 != null) goto L261;
        r143 = r112.f565427b;     // Catch: Throwable -> L345
    L261:
        r141.b(r140, r142, r112, SetsKt.setOf(r143));     // Catch: Throwable -> L345
        if (r111 != null) goto L264;
    L267:
        boolean r144 = true;
    L268:
        if (r144 == true) goto L273;
        InputParamExtra r145 = r140.getExtra();     // Catch: Throwable -> L345
        if (r145 != null) goto L272;
        r145 = new InputParamExtra();     // Catch: Throwable -> L345
        r140.setExtra(r145);     // Catch: Throwable -> L345
    L272:
        r145.put(InputParamExtra.KEY_RAW_IMAGE_URI, r111);     // Catch: Throwable -> L345
        r140.setEnableOriginalImageDeferredEdit(true);     // Catch: Throwable -> L345
    L273:
        if (r107 != null) goto L275;
    L278:
        boolean r146 = true;
    L279:
        if (r146 == true) goto L284;
        InputParamExtra r147 = r140.getExtra();     // Catch: Throwable -> L345
        if (r147 != null) goto L283;
        r147 = new InputParamExtra();     // Catch: Throwable -> L345
        r140.setExtra(r147);     // Catch: Throwable -> L345
    L283:
        r147.put(InputParamExtra.KEY_DOWNLOAD_WATERMARK_URL, r107);     // Catch: Throwable -> L345
    L284:
        OutputParam r148 = new OutputParam();     // Catch: Throwable -> L345
        r148.setResultType(OutputParam.ResultType.PHOTO);     // Catch: Throwable -> L345
        ImageParam r149 = new ImageParam();     // Catch: Throwable -> L345
        if (r110 != null) goto L287;
        r110 = "";
    L287:
        r149.setPath(r110);     // Catch: Throwable -> L345
        r149.setBitmap(r115);     // Catch: Throwable -> L345
        xy8.b r150 = r112.f565428c;     // Catch: Throwable -> L345
        if (r150 == null) goto L290;
        boolean r151 = Intrinsics.areEqual(r150.f565417e, Boxing.boxBoolean(true));     // Catch: Throwable -> L345
    L291:
        r149.setAiCreation(r151);     // Catch: Throwable -> L345
        r148.setImageParam(r149);     // Catch: Throwable -> L345
        r148.setSelected(true);     // Catch: Throwable -> L345
        r148.setFromAlbum(false);     // Catch: Throwable -> L345
        CameraOutputContext r152 = new CameraOutputContext();     // Catch: Throwable -> L345
        r152.setOutputParamList(CollectionsKt.mutableListOf(new OutputParam[]{r148}));     // Catch: Throwable -> L345
        PreviewCameraParamProvider r153 = this.f324687a;     // Catch: Throwable -> L345
        AttachmentEditType r154 = this.f324690d;     // Catch: Throwable -> L345
        r153.getClass();     // Catch: Throwable -> L345
        Intrinsics.checkNotNullParameter(r154, "editType");     // Catch: Throwable -> L345
        r153.f324324m = r154;     // Catch: Throwable -> L345
        Function0<Boolean> r155 = this.f324687a.f324322k;     // Catch: Throwable -> L345
        if (r155 == null) goto L294;
        boolean r156 = r155.invoke().booleanValue();     // Catch: Throwable -> L345
    L295:
        if (r156 == true) goto L305;
        this.f324687a.k();     // Catch: Throwable -> L345
        r116.e("MarkAction", "execute: pending result unavailable, abort");     // Catch: Throwable -> L345
        Unit r157 = Unit.INSTANCE;     // Catch: Throwable -> L345
        if (r113 == null) goto L299;
        Job.DefaultImpls.cancel$default(r113, null, 1, null);
    L299:
        PreviewToolbarView r158 = r114.f324771f;
        if (r158 == null) goto L302;
        boolean r159 = false;
        r158.a(this.f324691e, false);
    L303:
        this.f324693g = r159;
        return r157;
    L302:
        r159 = false;
        goto L303
    L305:
        com.larus.chat.gallery.impl.preview.input.e0 r160 = this.f324688b;     // Catch: Throwable -> L345
        if (r160 == null) goto L375;
        r160.c(false);     // Catch: Throwable -> L345
        Unit r161 = Unit.INSTANCE;     // Catch: Throwable -> L345
    L375:
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L314
        if (this.f324690d != r135) goto L311;
        r108.j(r109, r140, r152);     // Catch: Throwable -> L314
        boolean r163 = true;
    L312:
        Object r164 = Result.m9449constructorimpl(Boxing.boxBoolean(r163));     // Catch: Throwable -> L314
    L316:
        Throwable r165 = Result.m9452exceptionOrNullimpl(r164);     // Catch: Throwable -> L345
        if (r165 == null) goto L321;
        FLogger.f375446a.e("MarkAction", "execute: image editor launch failed", r165);     // Catch: Throwable -> L345
        r164 = Boxing.boxBoolean(false);     // Catch: Throwable -> L345
    L321:
        if (((Boolean) r164).booleanValue() == true) goto L337;
        com.larus.chat.gallery.impl.preview.input.e0 r166 = this.f324688b;     // Catch: Throwable -> L345
        if (r166 == null) goto L325;
        r166.c(true);     // Catch: Throwable -> L345
        Unit r167 = Unit.INSTANCE;     // Catch: Throwable -> L345
    L325:
        this.f324687a.k();     // Catch: Throwable -> L345
        Function0<Unit> r168 = this.f324687a.f324323l;     // Catch: Throwable -> L345
        if (r168 == null) goto L328;
        r168.invoke();     // Catch: Throwable -> L345
    L328:
        FLogger.f375446a.e("MarkAction", "execute: image editor was not launched");     // Catch: Throwable -> L345
        Unit r169 = Unit.INSTANCE;     // Catch: Throwable -> L345
        if (r113 == null) goto L331;
        Job.DefaultImpls.cancel$default(r113, null, 1, null);
    L331:
        PreviewToolbarView r170 = r114.f324771f;
        if (r170 == null) goto L334;
        boolean r171 = false;
        r170.a(this.f324691e, false);
    L335:
        this.f324693g = r171;
        return r169;
    L334:
        r171 = false;
        goto L335
    L337:
        if (r113 == null) goto L339;
        Job.DefaultImpls.cancel$default(r113, null, 1, null);
        Unit r172 = Unit.INSTANCE;
    L339:
        PreviewToolbarView r173 = r114.f324771f;
        if (r173 == null) goto L342;
        boolean r174 = false;
        r173.a(this.f324691e, false);
        Unit r175 = Unit.INSTANCE;
    L343:
        this.f324693g = r174;
        return Unit.INSTANCE;
    L342:
        r174 = false;
        goto L343
    L311:
        r163 = r108.n(r109, r140, r152);     // Catch: Throwable -> L314
    L314:
        th = move-exception;
        Result.Companion r176 = Result.Companion;     // Catch: Throwable -> L345
        r164 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L345
        goto L316
    L294:
        r156 = true;
        goto L295
    L290:
        r151 = false;
        goto L291
    L275:
        if (r107.length() == 0) goto L278;
        r146 = false;
        goto L279
    L264:
        if (r111.length() == 0) goto L267;
        r144 = false;
        goto L268
    L257:
        r139 = null;
        goto L258
    L250:
        if (this.f324692f.invoke(r112).booleanValue() == true) goto L253;
        r137 = false;
        goto L254
    L247:
        r136 = r134;
    L243:
        r132 = false;
        goto L244
    L206:
        r120 = null;
        goto L207
    L202:
        r119 = null;
        goto L203
    L198:
        r118 = false;
    L345:
        th = th;
    L349:
        r100 = r114;
    L352:
        if (r113 == null) goto L354;
        Job.DefaultImpls.cancel$default(r113, null, 1, null);
        Unit r177 = Unit.INSTANCE;
    L354:
        PreviewToolbarView r178 = r100.f324771f;
        if (r178 == null) goto L357;
        boolean r179 = false;
        r178.a(this.f324691e, false);
        Unit r180 = Unit.INSTANCE;
    L358:
        this.f324693g = r179;
        throw th;
    L357:
        r179 = false;
        goto L358
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r107 = (String) r102.L$7;
        r108 = (IFlowCamera) r102.L$6;
        FragmentActivity r181 = (FragmentActivity) r102.L$5;
        String r182 = (String) r102.L$4;
        String r183 = (String) r102.L$3;
        r112 = (xy8.d) r102.L$2;
        Job r184 = (Job) r102.L$1;
        l0 r185 = (l0) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L21
        r101 = "execute: fetchBitmap result=";
    L371:
    L186:
        th = th;
        r113 = r184;
    L188:
        r114 = r185;
        goto L349
    L176:
        if (((Boolean) r104).booleanValue() == true) goto L185;
        FLogger.f375446a.e("MarkAction", "execute: raw image load failed or timeout");     // Catch: Throwable -> L186
        t19.s r186 = t19.s.f544207a;     // Catch: Throwable -> L186
        OriginalImagePreloader r187 = OriginalImagePreloader.f324211a;     // Catch: Throwable -> L186
        r186.getClass();     // Catch: Throwable -> L186
        t19.s.b(r181, R.string.larus_aiCreation_imageDetailsPage_toast_loadFail, false);     // Catch: Throwable -> L186
        Unit r188 = Unit.INSTANCE;     // Catch: Throwable -> L186
        if (r184 == null) goto L180;
        Job.DefaultImpls.cancel$default(r184, null, 1, null);
    L180:
        PreviewToolbarView r189 = r185.f324771f;
        if (r189 == null) goto L183;
        r189.a(this.f324691e, false);
    L183:
        this.f324693g = false;
        return r188;
    L185:
        Job r190 = r184;
    L369:
        r102.L$0 = r185;     // Catch: Throwable -> L347
        r102.L$1 = r190;     // Catch: Throwable -> L347
        r102.L$2 = r112;     // Catch: Throwable -> L347
        r102.L$3 = r183;     // Catch: Throwable -> L347
        r102.L$4 = r182;     // Catch: Throwable -> L347
        r102.L$5 = r181;     // Catch: Throwable -> L347
        r102.L$6 = r108;     // Catch: Throwable -> L347
        r102.L$7 = r107;     // Catch: Throwable -> L347
        r102.label = 3;     // Catch: Throwable -> L347
        r104 = c(r108, r182, r102);     // Catch: Throwable -> L347
        if (r104 != r105) goto L194;
        return r105;
    L194:
        r109 = r181;
        r110 = r182;
        r114 = r185;
        r111 = r183;
        r113 = r190;
    L347:
        th = th;
        r113 = r190;
    L21:
        th = th;
        l0 r191 = r185;
    L28:
        r100 = r191;
        r113 = r184;
        goto L352
    L23:
        IFlowCamera r192 = (IFlowCamera) r102.L$6;
        FragmentActivity r193 = (FragmentActivity) r102.L$5;
        String r194 = (String) r102.L$4;
        String r195 = (String) r102.L$3;
        r112 = (xy8.d) r102.L$2;
        Job r196 = (Job) r102.L$1;
        r191 = (l0) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L26
        r101 = "execute: fetchBitmap result=";
    L366:
        String r197 = (String) r104;     // Catch: Throwable -> L158
        r182 = r194;
        r190 = r196;
        r181 = r193;
        r108 = r192;
        r100 = r191;
        r183 = r195;
    L162:
        if (r183 != null) goto L360;
    L169:
        boolean r198 = true;
    L170:
        if (r198 == true) goto L190;
        OriginalImagePreloader r199 = OriginalImagePreloader.f324211a;     // Catch: Throwable -> L167
        r102.L$0 = r100;     // Catch: Throwable -> L167
        r102.L$1 = r190;     // Catch: Throwable -> L167
        r102.L$2 = r112;     // Catch: Throwable -> L167
        r102.L$3 = r183;     // Catch: Throwable -> L167
        r102.L$4 = r182;     // Catch: Throwable -> L167
        r102.L$5 = r181;     // Catch: Throwable -> L167
        r102.L$6 = r108;     // Catch: Throwable -> L167
        r102.L$7 = r197;     // Catch: Throwable -> L167
        r102.label = 2;     // Catch: Throwable -> L167
        Object r200 = r199.b(r183, "MarkAction#raw", r102);     // Catch: Throwable -> L167
        if (r200 != r105) goto L174;
        return r105;
    L174:
        r185 = r100;
        r107 = r197;
        r104 = r200;
        r184 = r190;
    L167:
        th = th;
        r113 = r190;
        goto L352
    L190:
        r185 = r100;
        r107 = r197;
        goto L369
    L360:
        if (r183.length() == 0) goto L169;
        r198 = false;
    L158:
        th = th;
        r114 = r191;
        r113 = r196;
    L26:
        th = th;
        r184 = r196;
        goto L28
    L29:
        ResultKt.throwOnFailure(r104);
        if (this.f324693g == false) goto L33;
        FLogger.f375446a.i("MarkAction", "execute ignored: mark page is launching");
        return Unit.INSTANCE;
    L33:
        this.f324693g = true;
        r112 = r100.f324766a;     // Catch: Throwable -> L350
        d(r100, r112);     // Catch: Throwable -> L350
        int r201 = b.f324694a[r112.f565430e.ordinal()];     // Catch: Throwable -> L350
        if (r201 == 1) goto L41;
        if (r201 != 2) goto L44;
        xy8.g r202 = r112.f565429d;     // Catch: Throwable -> L350
        if (r202 == null) goto L44;
        String r203 = r202.f565463d;     // Catch: Throwable -> L350
    L46:
        if (r112.f565430e != GalleryType.Image) goto L57;
        xy8.b r204 = r112.f565428c;     // Catch: Throwable -> L350
        if (r204 == null) goto L57;
        String r205 = r204.f565416d;     // Catch: Throwable -> L350
        if (r205 == null) goto L57;
        if (r205.length() <= 0) goto L54;
        boolean r206 = true;
    L55:
        if (r206 == false) goto L57;
    L58:
        if (r203 != null) goto L60;
        String r207 = r205;
    L61:
        FLogger r1100 = FLogger.f375446a;     // Catch: Throwable -> L350
        StringBuilder r1101 = new StringBuilder("execute: resourceType=");     // Catch: Throwable -> L350
        r1101.append(r112.f565430e);     // Catch: Throwable -> L350
        r1101.append(", hasImage=");     // Catch: Throwable -> L350
        if (r203 != null) goto L64;
    L67:
        boolean r208 = true;
    L68:
        if (r208 == true) goto L70;
        boolean r209 = true;
    L71:
        r1101.append(r209);     // Catch: Throwable -> L350
        r1101.append(", hasRawImage=");     // Catch: Throwable -> L350
        if (r205 == null) goto L74;
        boolean r212 = true;
    L75:
        r1101.append(r212);     // Catch: Throwable -> L350
        r1100.i("MarkAction", r1101.toString());     // Catch: Throwable -> L350
        Context r213 = r210.getContext();     // Catch: Throwable -> L350
        if ((r213 instanceof FragmentActivity) == false) goto L78;
        FragmentActivity r214 = (FragmentActivity) r213;     // Catch: Throwable -> L350
    L79:
        if (r214 != null) goto L86;
        r1100.e("MarkAction", "context is not FragmentActivity, abort");     // Catch: Throwable -> L350
        Unit r215 = Unit.INSTANCE;     // Catch: Throwable -> L350
        PreviewToolbarView r216 = r100.f324771f;
        if (r216 == null) goto L84;
        r216.a(this.f324691e, false);
    L84:
        this.f324693g = false;
        return r215;
    L86:
        r108 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);     // Catch: Throwable -> L350
        if (r108 != null) goto L94;
        r1100.e("MarkAction", "IFlowCamera service not found, abort");     // Catch: Throwable -> L350
        Unit r217 = Unit.INSTANCE;     // Catch: Throwable -> L350
        PreviewToolbarView r218 = r100.f324771f;
        if (r218 == null) goto L92;
        r218.a(this.f324691e, false);
    L92:
        this.f324693g = false;
        return r217;
    L94:
        String r1102 = f(r112);     // Catch: Throwable -> L350
        xy8.b r1103 = r112.f565428c;     // Catch: Throwable -> L350
        if (r1103 != null) goto L97;
    L114:
        String r219 = null;
    L115:
        xy8.b r1104 = r112.f565428c;     // Catch: Throwable -> L350
        if (r1104 == null) goto L118;
        boolean r1105 = Intrinsics.areEqual(r1104.f565417e, Boxing.boxBoolean(true));     // Catch: Throwable -> L350
    L119:
        if (r1105 == false) goto L129;
        if (r219 != null) goto L129;
        if (r1102 != null) goto L123;
    L126:
        boolean r1106 = true;
    L127:
        if (r1106 == true) goto L129;
        boolean r1107 = true;
    L130:
        if (r1107 == true) goto L140;
        if (r205 != null) goto L133;
    L136:
        boolean r1108 = true;
    L137:
        if (r1108 == false) goto L140;
        r190 = null;
    L141:
        if (r219 != null) goto L161;
        if (r1107 == false) goto L160;
        if (r1102 != null) goto L362;
    L150:
        boolean r220 = true;
    L151:
        if (r220 == true) goto L160;
        r102.L$0 = r100;     // Catch: Throwable -> L148
        r102.L$1 = r190;     // Catch: Throwable -> L148
        r102.L$2 = r112;     // Catch: Throwable -> L148
        r102.L$3 = r205;     // Catch: Throwable -> L148
        r102.L$4 = r207;     // Catch: Throwable -> L148
        r102.L$5 = r214;     // Catch: Throwable -> L148
        r102.L$6 = r108;     // Catch: Throwable -> L148
        r102.label = 1;     // Catch: Throwable -> L148
        Object r221 = e(r1102, r102);     // Catch: Throwable -> L148
        if (r221 != r105) goto L155;
        return r105;
    L155:
        r191 = r100;
        r192 = r108;
        r196 = r190;
        r193 = r214;
        r104 = r221;
        String r222 = r207;
        r195 = r205;
        r194 = r222;
    L148:
        th = th;
        r114 = r100;
        r113 = r190;
        goto L349
    L362:
        if (r1102.length() == 0) goto L150;
        r220 = false;
    L160:
        r183 = r205;
        r182 = r207;
        r181 = r214;
        r197 = null;
        goto L162
    L161:
        r183 = r205;
        r181 = r214;
        r197 = r219;
        r182 = r207;
        goto L162
    L133:
        if (r205.length() == 0) goto L136;
        r1108 = false;
    L140:
        r190 = BuildersKt.launch$default(r100.f324767b, null, null, new MarkAction$startLoadingJob$1(r100, this, null), 3, null);     // Catch: Throwable -> L350
        goto L141
    L123:
        if (r1102.length() == 0) goto L126;
        r1106 = false;
    L129:
        r1107 = false;
        goto L130
    L118:
        r1105 = false;
        goto L119
    L97:
        if (Intrinsics.areEqual(r1103.f565417e, Boxing.boxBoolean(true)) == true) goto L99;
    L101:
        boolean r223 = false;
    L102:
        if (r223 == true) goto L105;
        r1103 = null;
    L105:
        if (r1103 == null) goto L114;
        r219 = r1103.f565419g;     // Catch: Throwable -> L350
        if (r219 == null) goto L114;
        if (r219.length() <= 0) goto L111;
        boolean r1109 = true;
    L112:
        if (r1109 == false) goto L114;
    L111:
        r1109 = false;
        goto L112
    L99:
        if (CreationNoWatermarkManager.f373832a.D() == false) goto L101;
        r223 = true;
        goto L102
    L78:
        r214 = null;
        goto L79
    L74:
        r212 = false;
        goto L75
    L70:
        r209 = false;
        goto L71
    L64:
        if (StringsKt.isBlank(r203) == true) goto L67;
        r208 = false;
        goto L68
    L60:
        r207 = r203;
        goto L61
    L54:
        r206 = false;
    L57:
        r205 = null;
    L44:
        r203 = null;
        goto L46
    L41:
        xy8.b r224 = r112.f565428c;     // Catch: Throwable -> L350
        if (r224 == null) goto L44;
        r203 = r224.f565413a;     // Catch: Throwable -> L350
    L350:
        th = th;
        r113 = null;
    L7:
        r102 = new MarkAction$execute$1(this, r211);
        goto L8
    }

    public final boolean b(FragmentActivity r100, xy8.d r101) {
        com.larus.chat.gallery.api.q r102 = this.f324689c;
        if (r102 != null) goto L6;
        return true;
    L6:
        if (r102.Oa(r101.f565427b) == false) goto L8;
        return true;
    L8:
        PreviewSelectionLimit r103 = r102.e(r101.f565427b);
        if (r103 == null) goto L21;
        int r104 = b.f324695b[r103.f324115b.ordinal()];
        if (r104 != 1) goto L13;
        int r105 = R.string.larus_multi_photo_uploading_toast_maximum_number;
    L18:
        t19.s r106 = t19.s.f544207a;
        String r107 = r100.getString(r105, new Object[]{String.valueOf(r103.f324114a)});
        r106.getClass();
        t19.s.t(r100, r107);
        return false;
    L13:
        if (r104 != 2) goto L16;
        r105 = R.string.larus_videoSum_select_errToast_limit;
        goto L18
    L16:
        throw new NoWhenBranchMatchedException();
    L21:
        return r102.w(r101.f565427b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object e(String r100, Continuation<? super String> r101) {
        if ((r101 instanceof MarkAction$resolveDownloadWatermarkUrl$1) == false) goto L7;
        MarkAction$resolveDownloadWatermarkUrl$1 r102 = (MarkAction$resolveDownloadWatermarkUrl$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L22 CancellationException -> L54
    L20:
        com.larus.network.http.a r108 = (com.larus.network.http.a) r104;     // Catch: Throwable -> L22 CancellationException -> L54
    L24:
        if (r108 == null) goto L28;
        SignImgWmData r109 = (SignImgWmData) r108.f360135b;
        if (r109 == null) goto L28;
        Map<String, SignImgWmImageData> r110 = r109.getImages();
    L29:
        if (r110 == null) goto L36;
        SignImgWmImageData r111 = r110.get(r100);
        if (r111 == null) goto L36;
        SignImgWmImageObj r112 = r111.getImageOri();
        if (r112 == null) goto L36;
        String r113 = r112.getUrl();
        if (r113 == null) goto L36;
    L45:
        if (r113 != null) goto L47;
    L50:
        if (r107 == false) goto L53;
        FLogger.f375446a.w("MarkAction", "resolveDownloadWatermarkUrl: empty watermark url");
        return null;
    L53:
        return r113;
    L47:
        if (r113.length() == 0) goto L50;
        r107 = false;
    L36:
        if (r110 == null) goto L44;
        Collection<SignImgWmImageData> r114 = r110.values();
        if (r114 == null) goto L44;
        SignImgWmImageData r115 = (SignImgWmImageData) CollectionsKt.firstOrNull(r114);
        if (r115 == null) goto L44;
        SignImgWmImageObj r116 = r115.getImageOri();
        if (r116 == null) goto L44;
        r113 = r116.getUrl();
    L44:
        r113 = null;
    L28:
        r110 = null;
        goto L29
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        List r117 = CollectionsKt.listOf(r100);     // Catch: Throwable -> L22 CancellationException -> L54
        r102.L$0 = r100;     // Catch: Throwable -> L22 CancellationException -> L54
        r102.label = 1;     // Catch: Throwable -> L22 CancellationException -> L54
        r104 = j0.a(r117, r102);     // Catch: Throwable -> L22 CancellationException -> L54
        if (r104 != r105) goto L20;
        return r105;
    L54:
        e = move-exception;
        throw e;
    L22:
        th = move-exception;
        FLogger.f375446a.e("MarkAction", "resolveDownloadWatermarkUrl: sign_img_wm failed", th);
        r108 = null;
    L7:
        r102 = new MarkAction$resolveDownloadWatermarkUrl$1(this, r101);
        goto L8
    }

    public final Object c(IFlowCamera r100, String r101, Continuation<? super Bitmap> r110) {
        if ((r110 instanceof MarkAction$fetchMarkBitmap$1) == false) goto L7;
        MarkAction$fetchMarkBitmap$1 r102 = (MarkAction$fetchMarkBitmap$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L21;
        if (r105 == 1) goto L20;
        if (r105 != 2) goto L19;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14 CancellationException -> L16
    L59:
    L66:
        return (Bitmap) r111;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        String r106 = (String) r102.L$0;
        ResultKt.throwOnFailure(r111);
        r101 = r106;
    L53:
        Bitmap r112 = (Bitmap) r111;
        if (r112 == null) goto L56;
        return r112;
    L56:
        CoroutineDispatcher r107 = Dispatchers.getIO();     // Catch: Throwable -> L14 CancellationException -> L16
        MarkAction$fetchMarkBitmap$6 r113 = new MarkAction$fetchMarkBitmap$6(r101, null);     // Catch: Throwable -> L14 CancellationException -> L16
        r102.L$0 = null;     // Catch: Throwable -> L14 CancellationException -> L16
        r102.label = 2;     // Catch: Throwable -> L14 CancellationException -> L16
        r111 = BuildersKt.withContext(r107, r113, r102);     // Catch: Throwable -> L14 CancellationException -> L16
        if (r111 != r104) goto L59;
        return r104;
    L21:
        ResultKt.throwOnFailure(r111);
        if (r101 != null) goto L24;
    L27:
        boolean r114 = true;
    L28:
        if (r114 == false) goto L30;
        return null;
    L30:
        com.larus.chat.gallery.impl.preview.datasource.n.f324277a.getClass();
        String r115 = com.larus.chat.gallery.impl.preview.datasource.n.c(r101);
        Bitmap r108 = r100.q(r101);
        if (r108 != null) goto L33;
    L38:
        if (r115 != null) goto L40;
    L49:
        if (r115 == null) goto L56;
        CoroutineDispatcher r109 = Dispatchers.getIO();
        MarkAction$fetchMarkBitmap$localBitmap$1 r116 = new MarkAction$fetchMarkBitmap$localBitmap$1(r115, null);
        r102.L$0 = r101;
        r102.label = 1;
        r111 = BuildersKt.withContext(r109, r116, r102);
        if (r111 != r104) goto L53;
        return r104;
    L40:
        if (Intrinsics.areEqual(r115, r101) == true) goto L49;
        Bitmap r117 = r100.q(r115);
        if (r117 == null) goto L49;
        if (r117.isRecycled() == false) goto L47;
        r117 = null;
    L47:
        if (r117 == null) goto L49;
        return r117;
    L33:
        if (r108.isRecycled() == false) goto L36;
        r108 = null;
    L36:
        if (r108 == null) goto L38;
        return r108;
    L24:
        if (r101.length() == 0) goto L27;
        r114 = false;
    L16:
        e = move-exception;
        throw e;
    L14:
        th = move-exception;
        FLogger.f375446a.e("MarkAction", "fetchMarkBitmap: fetch bitmap failed", th);
        return null;
    L7:
        r102 = new MarkAction$fetchMarkBitmap$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MarkAction(PreviewCameraParamProvider r100, com.larus.chat.gallery.impl.preview.input.e0 r101, com.larus.chat.gallery.api.q r102, AttachmentEditType r103, ToolbarButtonType r104, Function1<? super xy8.d, Boolean> r105) {
        Intrinsics.checkNotNullParameter(r100, "paramProvider");
        Intrinsics.checkNotNullParameter(r103, "editType");
        Intrinsics.checkNotNullParameter(r104, "buttonType");
        Intrinsics.checkNotNullParameter(r105, "supportsCrop");
        this.f324687a = r100;
        this.f324688b = r101;
        this.f324689c = r102;
        this.f324690d = r103;
        this.f324691e = r104;
        this.f324692f = r105;
    }
}
