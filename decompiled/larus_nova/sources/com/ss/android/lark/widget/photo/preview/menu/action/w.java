package com.ss.android.lark.widget.photo.preview.menu.action;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.ImageTranslationInfo;
import com.bytedance.lark.pb.basic.v1.RichTextElement;
import com.bytedance.lark.pb.basic.v1.TranslatedImage;
import com.bytedance.lark.pb.im.v1.GetTranslateOriginImageRequest;
import com.bytedance.lark.pb.im.v1.GetTranslateOriginImageResponse;
import com.bytedance.lark.pb.im.v1.ImageKeyInfo;
import com.bytedance.lark.pb.im.v1.TranslateImageKeysRequest;
import com.bytedance.lark.pb.im.v1.TranslateImageKeysResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.lark.utils.s0;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.service.TranslateImageService;
import com.ss.android.lark.widget.richtext.Image;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class w implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f446911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PhotoItem f446912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f446913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f446914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f446915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f446916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f446917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f446918i;

    public class a implements fcc.e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f446919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f446920b;

        @Override // fcc.e.c
        public final void onClick(int r100) {
            this.f446920b.d((String) ListProtector.get(this.f446919a, r100));
        }

        public a(w r100, List r101) {
            this.f446920b = r100;
            this.f446919a = r101;
        }
    }

    public class b extends s0.c<PhotoItem> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f446921j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ w f446922k;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ss.android.lark.utils.s0.c
        public final PhotoItem c() {
            w r100 = this.f446922k;
            String r101 = this.f446921j;
            r100.getClass();
            Log.i("TranslateAction", "doTranslateStep4, targetLanguage:" + r101);
            Serializable r102 = r100.f446912c.getLoadModel();
            if (r100.f446916g == false) goto L23;
            Log.i("TranslateAction", "doTranslateStep5, targetLanguage:" + r101);
            TranslateImageKeysResponse r103 = r100.b(r101, r100.f446915f);
            if (r103 == null) goto L74;
            ImageTranslationInfo r104 = r103.images_translation_info;
            if (r104 != null) goto L10;
            Log.i("TranslateAction", "doTranslateReal: " + r100.f446915f + " -> images_translation_info is null.");
            goto L74
        L10:
            Map<String, TranslatedImage> r105 = r104.translated_images;
            if (r105 != null) goto L13;
        L22:
            Log.i("TranslateAction", "doTranslateReal: " + r100.f446915f + " -> translated_images is empty.");
            goto L74
        L13:
            if (r105.isEmpty() == true) goto L22;
            Iterator<TranslatedImage> r106 = r105.values().iterator();
            if (r106.hasNext() == false) goto L18;
            ImageSet r107 = com.ss.android.lark.widget.photopicker.utils.n.d(r106.next().translated_image_set);
            r107.setMessageIdentity(r100.f446912c.getMessageIdentity());
        L19:
            if (r107 != null) goto L21;
            Log.i("TranslateAction", "doTranslateReal: " + r100.f446915f + " -> translatedImageSet is null.");
            goto L74
        L21:
            PhotoItem r108 = com.ss.android.lark.widget.photopicker.utils.n.b(r107, false);
            r108.getTranslateProperty().setTranslated(true);
            r108.getTranslateProperty().setCanTranslate(true);
        L77:
            if (r108 != null) goto L79;
            Log.i("TranslateAction", "doTranslateSync: " + r100.f446915f + " -> null");
            return null;
        L79:
            r108.setTranslateOriginModel(r102);
            Log.i("TranslateAction", "doTranslateSync: " + r100.f446915f + " -> " + r108.getImageKey());
            ImageLoader.with(r100.f446910a).load(r108.getLoadModel()).downloadOnly(r108.getWidth(), r108.getHeight());     // Catch: Exception -> L82
        L85:
            if (r100.f446917h != null) goto L87;
        L90:
            Log.i("TranslateAction", "doTranslateSync: cancel");
            return null;
        L87:
            if (r100.f446918i == true) goto L90;
            return r108;
        L82:
            e = move-exception;
            Log.e("TranslateAction", "preDownloadImg failed:" + e);
            goto L85
        L18:
            r107 = null;
        L74:
            r108 = null;
            goto L77
        L23:
            SdkSender.d r109 = SdkSender.syncSendMayError(Command.GET_TRANSLATE_ORIGIN_IMAGE, new GetTranslateOriginImageRequest.Builder().entity_id(r100.f446912c.getMessageId()).entity_type(r100.f446912c.getEntityType()).translate_image_key(r100.f446915f), new x());
            if (r109.f439868b == null) goto L26;
            Log.e("TranslateAction", "back2Origin: " + r100.f446915f + " -> " + r109.f439868b.getDebugMsg());
            ViewUtils.showToastShort(r109.f439868b.getDisplayMsg());
            goto L74
        L26:
            GetTranslateOriginImageResponse r110 = (GetTranslateOriginImageResponse) r109.f439867a;
            Log.i("TranslateAction", "back2Origin: " + r100.f446915f + " GET_TRANSLATE_ORIGIN_IMAGE -> " + r110);
            com.bytedance.lark.pb.basic.v1.ImageSet r111 = r110.origin_image_set;
            if (r111 != null) goto L29;
        L31:
            PhotoItem r112 = null;
        L32:
            RichTextElement.ImageProperty r113 = r110.origin_image_property;
            if (r113 != null) goto L35;
            com.ss.android.lark.widget.richtext.RichTextElement.ImageProperty r114 = null;
        L48:
            if (r114 == null) goto L60;
            Image r115 = com.ss.android.lark.widget.richtext.d.h(r114, 0);
            if (r115 != null) goto L53;
            com.ss.android.lark.image.entity.Image r116 = null;
        L57:
            String r117 = r116.getKey();
            if (TextUtils.isEmpty(r117) == true) goto L60;
            ImageSet r118 = new ImageSet(r117, r116, r116);
        L61:
            if (r112 != null) goto L66;
            if (r118 != null) goto L66;
            if (TextUtils.isEmpty(r110.origin_image_key) == true) goto L66;
            r118 = new ImageSet();
            com.ss.android.lark.image.entity.Image r119 = new com.ss.android.lark.image.entity.Image();
            r119.setKey(r110.origin_image_key);
            r118.setOrigin(r119);
            Log.w("TranslateAction", "use response origin_image_key");
        L66:
            if (r118 == null) goto L68;
            r118.setMessageIdentity(r100.f446912c.getMessageIdentity());
            PhotoItem r120 = com.ss.android.lark.widget.photopicker.utils.n.b(r118, true);
        L69:
            if (r120 != null) goto L71;
            Log.i("TranslateAction", "back2Origin: photoItem is null");
            goto L74
        L71:
            String r121 = com.ss.android.lark.widget.photopicker.utils.n.a(r120);
            if (TextUtils.isEmpty(r121) == false) goto L75;
            Log.i("TranslateAction", "back2Origin: originKey of photoItem is null");
            goto L74
        L75:
            Log.i("TranslateAction", "back2Origin: originKey -> " + r121);
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new y(r100, r101, r121));
            r108 = r120;
            goto L77
        L68:
            r120 = r112;
            goto L69
        L53:
            r116 = new com.ss.android.lark.image.entity.Image();
            r116.setHeight(r115.getHeight());
            r116.setWidth(r115.getWidth());
            r116.setKey(r115.getKey());
            r116.setToken(r115.getToken());
            r116.setFsUnit(r115.getFsUnit());
            r116.setCrypto(r115.getCrypto());
            r116.setResourceCleanScene(r115.getResourceCleanScene());
            r116.setResourceIsCleaned(r115.isResourceIsCleaned());
            Image.Type r122 = r115.getType();
            if (r122 == null) goto L56;
            r116.setType(com.ss.android.lark.image.entity.Image.Type.forNumber(r122.getNumber()));
        L56:
            r116.setUrls(r115.getUrls());
        L60:
            r118 = null;
            goto L61
        L35:
            r114 = new com.ss.android.lark.widget.richtext.RichTextElement.ImageProperty();
            r114.setUrls(r113.urls);
            r114.setToken(r113.token);
            r114.setOriginKey(r113.origin_key);
            com.bytedance.lark.pb.basic.v1.Image r123 = r113.middle_webp;
            if (r123 != null) goto L38;
        L40:
            String r124 = r113.middle_key;
        L41:
            r114.setMiddleKey(r124);
            com.bytedance.lark.pb.basic.v1.Image r125 = r113.thumbnail_webp;
            if (r125 != null) goto L44;
        L46:
            String r126 = r113.thumb_key;
        L47:
            r114.setThumbKey(r126);
            r114.setOriginWidth(r113.origin_width.intValue());
            r114.setOriginHeight(r113.origin_height.intValue());
            r114.setAlt(r113.alt);
            r114.setAltI18nKey(r113.alt_i18n_key);
            r114.setImgCanPreview(r113.img_can_preview.booleanValue());
            goto L48
        L44:
            if (TextUtils.isEmpty(r125.key) == true) goto L46;
            r126 = r113.thumbnail_webp.key;
            goto L47
        L38:
            if (TextUtils.isEmpty(r123.key) == true) goto L40;
            r124 = r113.middle_webp.key;
            goto L41
        L29:
            if (TextUtils.isEmpty(r111.key) == true) goto L31;
            ImageSet r127 = com.ss.android.lark.widget.photopicker.utils.n.d(r111);
            r127.setMessageIdentity(r100.f446912c.getMessageIdentity());
            r112 = com.ss.android.lark.widget.photopicker.utils.n.b(r127, true);
            goto L32
        }

        @Override // com.ss.android.lark.utils.s0.c
        public final void d(PhotoItem r100) {
            PhotoItem r101 = r100;
            if (r101 == null) goto L16;
            e r102 = this.f446922k.f446913d;
            if (r102 == null) goto L16;
            com.ss.android.lark.widget.photo.preview.menu.p r103 = ((com.ss.android.lark.widget.photo.preview.menu.n) r102).f446972a;
            r103.getClass();
            int r104 = jdc.c.f498781a;
            jdc.c.a.b("translate", "none");
            com.ss.android.lark.widget.photo.preview.menu.p.a r105 = r103.f446977d;
            if (r105 == null) goto L10;
            r105.a(r103.f446978e, r101);
        L10:
            w r106 = this.f446922k;
            if (r106.f446916g == true) goto L13;
            return;
        L13:
            if (r106.f446912c == null) goto L20;
            com.ss.android.lark.widget.photopicker.f.a r107 = com.ss.android.lark.widget.photopicker.f.a().n();
            r106.f446912c.getMessageId();
            r107.d();
            return;
        L20:
            return;
        L16:
            this.f446922k.e("res is null");
        }

        public b(w r100, String r101) {
            this.f446922k = r100;
            this.f446921j = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f446923a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f446923a.f446918i = true;     // Catch: Throwable -> L4
            Log.i("TranslateAction", "onCancel: " + this.f446923a.f446915f + " -> translate image cancel.");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(w r100) {
            this.f446923a = r100;
        }
    }

    public class d implements SdkSender.IParser<TranslateImageKeysResponse> {
        public d() {
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final TranslateImageKeysResponse parse(byte[] r100) throws IOException {
            return TranslateImageKeysResponse.ADAPTER.decode(r100);
        }
    }

    public interface e {
    }

    public static class f extends ViewUtils.b {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ValueAnimator f446924j;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f446925a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f446926b;

            public final void a() {
                f r100 = this.f446926b;
                View r101 = this.f446925a;
                r100.getClass();
                int r102 = ((RelativeLayout) r101.getParent()).getHeight() - r101.getHeight();
                ValueAnimator r103 = r100.f446924j;
                if (r103 == null) goto L6;
                r103.setRepeatMode(1);
                r100.f446924j.setRepeatCount(-1);
                r100.f446924j.addUpdateListener(new z(r101, r102));
                r100.f446924j.start();
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(f r100, View r101) {
                this.f446926b = r100;
                this.f446925a = r101;
            }
        }

        public class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LKUIDialog f446927a;

            public b(LKUIDialog r100) {
                this.f446927a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                this.f446927a.cancel();
            }
        }

        public class c implements DialogInterface.OnDismissListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f446928a;

            public c(f r100) {
                this.f446928a = r100;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface r100) {
                ValueAnimator r101 = this.f446928a.f446924j;
                if (r101 == null) goto L6;
                r101.removeAllUpdateListeners();
                this.f446928a.f446924j.cancel();
                this.f446928a.f446924j = null;
                return;
            }
        }

        @Override // com.ss.android.lark.utils.ViewUtils.b
        public final int c() {
            return R.layout.translate_loading_dialog;
        }

        public f(Context r100) {
            super(r100);
            this.f446924j = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(2000);
            this.f444681f = 0;
        }

        @Override // com.ss.android.lark.utils.ViewUtils.b
        public final com.larksuite.component.ui.dialog.d d(com.larksuite.component.ui.dialog.d r100) {
            r100.f284132c.marginInDp(0);
            return r100;
        }

        @Override // com.ss.android.lark.utils.ViewUtils.b
        public final void g(Window r100) {
            super.g(r100);
            r100.addFlags(1024);
        }

        @Override // com.ss.android.lark.utils.ViewUtils.b
        public final void f(LKUIDialog r100, CharSequence r101) {
            View r102 = r100.findViewById(R.id.translateLoadingIv);
            View r103 = r100.findViewById(R.id.translateStopView);
            r102.post(new a(this, r102));
            r103.setOnClickListener(new b(r100));
            this.f444683h = new c(this);
        }
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String getId() {
        return "TRANSLATE";
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String a() {
        if (this.f446912c.getTranslateProperty().isTranslated() == false) goto L5;
        int r100 = R.string.Lark_Chat_ViewOriginalImage;
    L7:
        return UIHelper.getString(r100);
    L5:
        r100 = R.string.Lark_Chat_TranslateImageText;
        goto L7
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final Runnable getAction() {
        return new u(this);
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final boolean isValid() {
        rua.a r100 = (rua.a) ApiUtils.getApi(rua.a.class);
        if (this.f446911b == true) goto L5;
    L9:
        boolean r101 = false;
    L10:
        int r102 = jdc.c.f498781a;
        Intrinsics.checkNotNullParameter("picbrowser_more", "occasion");
        Statistics.sendEvent("public_image_translate_icon_view", new JSONObject().put("occasion", "picbrowser_more").put("has_translate_icon", r101));
        if (r100 != null) goto L13;
        return r101;
    L13:
        return r101 & r100.isImageTranslateEnable();
    L5:
        if (this.f446912c.getTranslateProperty().canTranslate() == false) goto L9;
        if (this.f446912c.isAnimatedImage() == true) goto L9;
        r101 = true;
        goto L10
    }

    public final String toString() {
        if (this.f446911b == true) goto L7;
        return "TranslateAction: disable";
    L7:
        return "TranslateAction: { msgId: " + this.f446912c.getMessageId() + ", imageKey: " + this.f446914e + ", originKey: " + this.f446915f + ", isOrigin: " + this.f446916g + " }";
    }

    public final void c(String r100) {
        Log.i("TranslateAction", "doTranslateStep2, targetKey:" + r100);
        List<String> r101 = this.f446912c.getTranslateProperty().getSrcLanguages();
        if (r101 != null) goto L5;
    L17:
        d(r100);
        return;
    L5:
        if (r101.size() != 1) goto L17;
        if (r101.contains(r100) == false) goto L17;
        Log.i("TranslateAction", "doTranslateStep2, image key equal target key, show select dialog");
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        List<com.ss.android.lark.widget.photopicker.entity.a> r104 = TranslateImageService.INSTANCE.getImageSupportedLanguageList();
        int r105 = 0;
    L10:
        if (r105 >= r104.size()) goto L16;
        com.ss.android.lark.widget.photopicker.entity.a r106 = (com.ss.android.lark.widget.photopicker.entity.a) ListProtector.get(r104, r105);
        if (TextUtils.isEmpty(r106.f447513c) == false) goto L14;
        String r107 = r106.f447512b;
    L15:
        r102.add(r107);
        r103.add(r106.f447511a);
        r105 = r105 + 1;
        goto L10
    L14:
        r107 = r106.f447513c;
        goto L15
    L16:
        new fcc.e(this.f446910a, UIHelper.getString(R.string.Lark_Shared_MessageTranslation_TranslateInto_Title), r102, new a(this, r103)).j();
        e("targetLang equal to sourceLang");
    }

    public final void d(String r100) {
        Log.i("TranslateAction", "doTranslateStep3, targetLanguage:" + r100);
        b r101 = new b(this, r100);
        this.f446918i = false;
        r101.f444774f = new c(this);
        f r102 = new f(this.f446910a);
        this.f446917h = r102;
        s0.a(this.f446910a, r101, r102);
        JSONObject r103 = new JSONObject().put("position", "imgviewer").put("message_type", "other");     // Catch: JSONException -> L5
    L8:
        if (this.f446916g == false) goto L10;
        Statistics.sendEvent("translate_image", r103);
        return;
    L10:
        Statistics.sendEvent("untranslate_image", r103);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        r103 = null;
        goto L8
    }

    public final void e(String r100) {
        if (this.f446916g == true) goto L5;
        return;
    L5:
        if (this.f446912c == null) goto L10;
        com.ss.android.lark.widget.photopicker.f.a r101 = com.ss.android.lark.widget.photopicker.f.a().n();
        this.f446912c.getMessageId();
        r101.b();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TranslateImageKeysResponse b(String r100, String r101) {
        TranslateImageKeysRequest.Builder r102 = new TranslateImageKeysRequest.Builder().entity_id(this.f446912c.getMessageId()).entity_type(this.f446912c.getEntityType()).scene(this.f446912c.getTranslateScene()).image_keys_info(Collections.singletonList(new ImageKeyInfo.Builder().image_key(r101).is_origin(Boolean.valueOf(this.f446916g)).build()));
        if (TextUtils.isEmpty(r100) == true) goto L5;
        r102.target_language(r100);
    L5:
        SdkSender.d r103 = SdkSender.syncSendMayError(Command.TRANSLATE_IMAGE_KEYS, r102, new d());
        if (r103.f439868b == null) goto L9;
        Log.e("TranslateAction", "doTranslateRequest: " + r101 + " -> " + r103.f439868b.getDebugMsg());
        ViewUtils.showToastShort(r103.f439868b.getDisplayMsg());
        return null;
    L9:
        TranslateImageKeysResponse r104 = (TranslateImageKeysResponse) r103.f439867a;
        Log.i("TranslateAction", "doTranslateRequest: " + r101 + " -> TranslateImageKeysResponse: " + r104);
        return r104;
    }

    public w(Context r100, boolean r101, PhotoItem r102, com.ss.android.lark.widget.photo.preview.menu.n r103) {
        this.f446910a = r100;
        this.f446911b = r101;
        this.f446912c = r102;
        this.f446913d = r103;
        this.f446914e = r102.getImageKey();
        this.f446915f = com.ss.android.lark.widget.photopicker.utils.n.a(r102);
        this.f446916g = !r102.getTranslateProperty().isTranslated();
        Log.i("TranslateAction", toString());
    }
}
