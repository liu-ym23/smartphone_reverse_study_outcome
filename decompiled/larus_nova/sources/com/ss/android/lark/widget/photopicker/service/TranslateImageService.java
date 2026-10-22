package com.ss.android.lark.widget.photopicker.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.ImageTranslationAbility;
import com.bytedance.lark.pb.im.v1.DetectImagesLanguageRequest;
import com.bytedance.lark.pb.im.v1.DetectImagesLanguageResponse;
import com.bytedance.lark.pb.im.v1.SrcLanguageConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.utils.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final enum TranslateImageService extends Enum<TranslateImageService> {
    public static final TranslateImageService INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TranslateImageService[] f447608a = null;
    private Map<String, ImageTranslationAbility> imageKeyCanTranslateMap;
    private List<com.ss.android.lark.widget.photopicker.entity.a> imageSupportedLanguageList;
    private String targetLanguageKey;

    public class a implements SdkSender.IParser<List<ImageTranslationAbility>> {
        public a() {
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final List<ImageTranslationAbility> parse(byte[] r100) throws IOException {
            return DetectImagesLanguageResponse.ADAPTER.decode(r100).images_translation_ability;
        }
    }

    static {
        TranslateImageService r100 = new TranslateImageService();
        INSTANCE = r100;
        f447608a = new TranslateImageService[]{r100};
    }

    public TranslateImageService() {
        super("INSTANCE", 0);
        this.imageKeyCanTranslateMap = new ConcurrentHashMap();
    }

    public static TranslateImageService[] values() {
        return (TranslateImageService[]) f447608a.clone();
    }

    public List<com.ss.android.lark.widget.photopicker.entity.a> getImageSupportedLanguageList() {
        List<com.ss.android.lark.widget.photopicker.entity.a> r100 = this.imageSupportedLanguageList;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return Collections.emptyList();
    }

    public String getTargetLanguageKey() {
        return this.targetLanguageKey;
    }

    public static TranslateImageService valueOf(String r100) {
        return (TranslateImageService) r27.a.a(TranslateImageService.class, r100);
    }

    public final void a(PhotoItem r100) {
        ImageTranslationAbility r101 = this.imageKeyCanTranslateMap.get(n.a(r100));
        if (r101 != null) goto L5;
        return;
    L5:
        PhotoItem.TranslateProperty r102 = r100.getTranslateProperty();
        List<String> r103 = r101.src_language;
        if (r103 != null) goto L8;
        r103 = new ArrayList();
    L8:
        r102.setSrcLanguages(r103);
        PhotoItem.TranslateProperty r104 = r100.getTranslateProperty();
        Boolean r105 = r101.can_translate;
        if (r105 != null) goto L11;
    L13:
        boolean r106 = false;
    L14:
        r104.setCanTranslate(r106);
        return;
    L11:
        if (r105.booleanValue() == false) goto L13;
        r106 = true;
        goto L14
    }

    public void detectCanTranslate(List<PhotoItem> r100) {
        rua.a r101 = (rua.a) ApiUtils.getApi(rua.a.class);
        if (r101 != null) goto L5;
    L7:
        final ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        Iterator<PhotoItem> r104 = r100.iterator();
    L9:
        if (r104.hasNext() == false) goto L28;
        PhotoItem r105 = r104.next();
        if (r105.getTranslateProperty().isTranslated() == true) goto L12;
        if (r105.getType() != 2) goto L15;
        if (r105.isVideo() == true) goto L18;
        if (r105.getMessageIdentity() != null) goto L22;
    L24:
        boolean r106 = false;
    L25:
        if (r106 == true) goto L26;
        r102.add(r105);
        r103.add(r105.getImageKey() + " : originKey: " + r105.getOriginPicInfo().key);
        goto L9
    L26:
        Log.i("TranslateImage", r105.getImageKey() + " is from PreMessage");
        goto L9
    L22:
        if (r105.getMessageIdentity().isHideEditor() == false) goto L24;
        r106 = true;
        goto L25
    L18:
        Log.i("TranslateImage", r105.getImageKey() + " is video");
        goto L9
    L15:
        Log.i("TranslateImage", r105.getImageKey() + " is " + r105.getType());
        goto L9
    L12:
        Log.i("TranslateImage", r105.getImageKey() + " is translated");
        goto L9
    L28:
        Log.i("TranslateImage", r103.toString());
        final ArrayList r107 = new ArrayList();
        Iterator r108 = r102.iterator();
    L30:
        if (r108.hasNext() == false) goto L39;
        PhotoItem r109 = (PhotoItem) r108.next();
        String r110 = n.a(r109);
        if (TextUtils.isEmpty(r110) == true) goto L30;
        if (this.imageKeyCanTranslateMap.containsKey(r110) == true) goto L36;
        r107.add(r110);
        goto L30
    L36:
        a(r109);
        goto L30
    L39:
        if (r107.isEmpty() == false) goto L41;
        return;
    L41:
        SdkSender.asynSendRequestNonWrap(Command.DETECT_IMAGE_LANGUAGE, new DetectImagesLanguageRequest.Builder().image_keys(r107), new AnonymousClass1(this, r107, r102), new a());
        return;
    L5:
        if (r101.isImageTranslateEnable() == true) goto L7;
    }

    public void detectCanTranslate(PhotoItem r100) {
        detectCanTranslate(Collections.singletonList(r100));
    }

    public static void access$000(TranslateImageService r100, List r101, List r102, List r103) {
        r100.getClass();
        Log.i("TranslateImage", r102.toString() + "\n" + r101.toString());
        if (r101.size() == r102.size()) goto L5;
        Log.w("TranslateImage", "detectKeysSize: " + r102.size() + ", imageTranslationAbilitiesSize: " + r101.size());
        return;
    L5:
        int r104 = 0;
    L7:
        if (r104 >= r102.size()) goto L9;
        r100.imageKeyCanTranslateMap.put((String) ListProtector.get(r102, r104), (ImageTranslationAbility) ListProtector.get(r101, r104));
        r104 = r104 + 1;
        goto L7
    L9:
        Iterator r105 = r103.iterator();
    L11:
        if (r105.hasNext() == false) goto L16;
        r100.a((PhotoItem) r105.next());
        goto L11
    }

    public void setImageSupportedLanguageList(String r100, List<String> r101, Map<String, String> r102, Map<String, SrcLanguageConfig> r103) {
        Log.i("TranslateImage", "TranslateImageService: " + r100);
        this.targetLanguageKey = r100;
        if (r101 == null) goto L14;
        if (r102 == null) goto L20;
        this.imageSupportedLanguageList = new ArrayList();
        Iterator<String> r104 = r101.iterator();
    L7:
        if (r104.hasNext() == false) goto L21;
        String r105 = r104.next();
        if (r102.containsKey(r105) == false) goto L7;
        com.ss.android.lark.widget.photopicker.entity.a r106 = new com.ss.android.lark.widget.photopicker.entity.a(r105, r102.get(r105));
        SrcLanguageConfig r107 = r103.get(r105);
        if (r107 == null) goto L13;
        Locale r108 = LarkContext.getApplication().getApplicationContext().getResources().getConfiguration().locale;
        r106.f447513c = r107.i18n_language.get((r108.getLanguage() + "_" + r108.getCountry()).toLowerCase());
    L13:
        this.imageSupportedLanguageList.add(r106);
        goto L7
    L21:
        return;
    L20:
        return;
    }
}
