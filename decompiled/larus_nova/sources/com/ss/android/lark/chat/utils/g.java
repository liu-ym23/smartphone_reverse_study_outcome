package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.bumptech.glide.load.DecodeFormat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.joooonho.SelectableRoundedImageView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.impl.InlineRequestCreator;
import com.ss.android.lark.image.impl.resource.ResourceGlideListener;
import com.ss.android.lark.image.utils.ChatImageSettings;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
public final class g {
    public static boolean c() {
        Context r100 = ChatCoreModule.a().getContext();
        int r101 = ChatImageSettings.getMessageImageRemote().getTarget().getThumbWidthMax();
        if (UIHelper.getWindowWidth(r100) <= r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static Image b(ImageSet r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Image r101 = r100.getOrigin();
        if (r101 != null) goto L9;
        return null;
    L9:
        if (CollectionUtils.isNotEmpty(r101.getUrls()) == false) goto L14;
        if (URLUtil.isNetworkUrl((String) ListProtector.get(r101.getUrls(), 0)) == true) goto L14;
        return r101;
    L14:
        if (c() == true) goto L16;
    L20:
        Image r102 = r100.getThumbnail();
    L21:
        if (r102 != null) goto L23;
        return r101;
    L23:
        if (r102.isEmpty() == false) goto L25;
        return r101;
    L25:
        return r102;
    L16:
        if (r100.getMiddle() == null) goto L20;
        if (r100.getMiddle().isEmpty() == true) goto L20;
        r102 = r100.getMiddle();
        goto L21
    }

    public static boolean d(y6b.a r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.P() == false) goto L6;
    L7:
        Log.e("ChatImageUtil", "msg:" + r100.getId() + " is deleted");
        return true;
    L6:
        if (r100.j() == false) goto L8;
        goto L7
    }

    public static void f(Context r100, ImageView r101) {
        int r102 = r101.getWidth();
        int r103 = r101.getHeight();
        if (r102 == 0) goto L5;
        if (r103 == 0) goto L5;
    L6:
        ImageLoader.with(r100).load(Integer.valueOf(R.drawable.common_chat_window_image_item_holder)).diskCacheStrategy(DiskCacheStrategy.NONE).override(r102, r103).into(r101);
        return;
    L5:
        LruCache<String, Boolean> r104 = ImageUtils.f444663a;
        int r105 = UIUtils.dp2px(r100, 100.0f);
        r103 = UIUtils.dp2px(r100, 100.0f);
        r102 = r105;
        goto L6
    }

    public static GradientDrawable a(Context r100, int r101, int r102, int r103) {
        GradientDrawable r104 = new GradientDrawable();
        r104.setShape(0);
        r104.setCornerRadius(r103);
        r104.setColor(UIUtils.getColor(r100, R.color.bg_body_overlay));
        r104.setSize(r101, r102);
        return r104;
    }

    public static void g(Context r110, ImageView r111, Image r112, LoadParams r113, ByteString r114, v r115) {
        String r100 = r112.getKey();
        if (CollectionUtils.isNotEmpty(r112.getUrls()) == false) goto L5;
        String r101 = (String) ListProtector.get(r112.getUrls(), 0);
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L13;
        EncryptImage r102 = new EncryptImage(r100, r112.getFsUnit(), r112.getCrypto());
        r102.setStoreToPrivatePath(r113.f426336i);
        r102.setNeedCollectTrace(true);
        r102.setContextId(com.ss.android.lark.sdk.a.a());
        if (r114 == null) goto L11;
        Log.i("ChatImageUtil", "loadImage imageKey:" + r100 + " inline size:" + r114.size());
        Object r103 = r102;
    L20:
        DiskCacheStrategy r104 = r113.f426335h;
        if (com.ss.android.lark.image.utils.a.f() == false) goto L23;
        r104 = DiskCacheStrategy.NONE;
    L23:
        if (r103 == null) goto L44;
        if (r115 == null) goto L26;
        r115.onStart();
    L26:
        IRequestCreator r116 = ImageLoader.with(r110).load(r103).override(r113.f426328a, r113.f426329b).placeholder(r113.f426330c).error(r113.f426331d).dontAnimate(false).centerCrop().setErrorScaleType(r113.f426333f);
        ListenerParams r105 = r113.f426339l;
        if (r105 == null) goto L29;
        ResourceGlideListener r106 = new ResourceGlideListener(r105, r103);
    L30:
        IRequestCreator r117 = r116.listener(r106).diskCacheStrategy(r104).transform(null).transforms(r113.f426334g).gifFileSize(r113.f426340m).gifMaxHeight(r113.f426342o).gifMaxWidth(r113.f426341n).thumbnail(0.0f);
        File r118 = r112.getThumbnailCache();
        if (r118 == null) goto L36;
        if (r118.exists() == false) goto L36;
        r117.thumbnail(ImageLoader.with(r110).load(r118)).diskCacheStrategy(DiskCacheStrategy.NONE).override(r113.f426328a, r113.f426329b).dontAnimate(false).centerCrop();
    L41:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("lark.image.config.565") == false) goto L43;
        r117.decodeFormat(DecodeFormat.PREFER_RGB_565);
    L43:
        r117.isAsync(r113.f426338k);
        r117.into(r111);
        return;
    L36:
        if (TextUtils.isEmpty(r100) == false) goto L39;
        r100 = r101;
    L39:
        r117.thumbnail(InlineRequestCreator.generate(r110, r100, r114));
        goto L41
    L29:
        r106 = null;
        goto L30
    L44:
        Log.e("ChatImageUtil", "Key and Url is all empty, data is error");
        f(r110, r111);
        return;
    L11:
        Log.i("ChatImageUtil", "loadImage imageKey:" + r100 + " inline is null.");
        r103 = r102;
        goto L20
    L13:
        if (TextUtils.isEmpty(r101) == false) goto L15;
        r103 = null;
        goto L20
    L15:
        if (r114 == null) goto L17;
        Log.i("ChatImageUtil", "loadImage imageUrl:" + r101 + " inline size:" + r114.size());
    L18:
        r103 = r101;
        goto L20
    L17:
        Log.i("ChatImageUtil", "loadImage imageUrl:" + r101 + " inline is null.");
        goto L18
    L5:
        r101 = null;
        goto L7
    }

    public static void e(Context r100, ImageView r101, String r102, String r103, int r104, int r105, Scene r106) {
        AvatarImage r107 = AvatarImage.Builder.obtain(r102, r103, r104, r105).build();
        com.ss.android.lark.image.entity.a r108 = new com.ss.android.lark.image.entity.a();
        r108.setShape(1);
        if ((r101 instanceof SelectableRoundedImageView) == false) goto L5;
        float r109 = ((SelectableRoundedImageView) r101).getCornerRadius();
    L6:
        r108.setCornerRadius(r109);
        r108.setColor(UIUtils.getColor(r100, R.color.bg_body_overlay));
        r108.setSize(r104, r105);
        IRequestCreator r110 = ImageLoader.with(r100).load(r107).placeholder(r108).override(r104, r105);
        ListenerParams.a r111 = new ListenerParams.a();
        r111.a(Biz.Messenger);
        Intrinsics.checkNotNullParameter(r106, "scene");
        r111.f426321j = r106;
        r111.c(ListenerParams.FromType.AVATAR);
        r111.f426312a = false;
        r111.f426313b = false;
        r111.f426314c = r104;
        r111.f426315d = r105;
        r110.listener(new ResourceGlideListener(r111.b(), r107)).into(r101);
        return;
    L5:
        r109 = 0.0f;
        goto L6
    }
}
