package com.ss.android.lark.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.OnUpdateProgressListener;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImageData;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.impl.LarkImageUtil;
import com.ss.android.lark.image.impl.image_compress.Luban;
import com.ss.android.lark.utils.ImageUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.File;

/* JADX INFO: loaded from: classes36.dex */
public final class ImageModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f426214a = null;

    static {
        f426214a = (a) ClaymoreServiceLoader.loadFirstOrNull(a.class);
    }

    public ImageModule() {
    }

    public static void a(Context r100, ImageView r101, String r102, String r103, LoadParams r104) {
        LarkImageUtil.loadImage(r100, r101, AvatarImage.Builder.obtain(r102, r103, r104.f426328a, r104.f426329b).isOnlyLocal(false).build(), r104);
    }

    public final void b(Context r110, final String r111, boolean r112, final boolean r113, final boolean r114, final OnUpdateProgressListener r115, final IGetDataCallback<EncryptImageData> r116) {
        if (r115 == null) goto L4;
        r115.onUpdateProgress(100, 0, 0);
    L4:
        if (r113 == true) goto L8;
        if (r112 == true) goto L8;
        boolean r100 = false;
    L9:
        IGetDataCallback<com.ss.android.lark.image.entity.d> r101 = new AnonymousClass3(this, r111, r115, r113, r114, r116);
        long r102 = System.currentTimeMillis();
        PolarisFileWrapper r103 = new PolarisFileWrapper(r111);
        if (r100 == false) goto L12;
    L25:
        Observable<File> r104 = Observable.just(r103).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    L26:
        r104.subscribe(new g(r100, r111, r102, r101), new h(r101));
        return;
    L12:
        if (ImageUtils.e(r103) == true) goto L25;
        Luban r105 = Luban.compress(r110, r103).setMaxSize(400).putGear(4);
        if (TextUtils.isEmpty(r111) == false) goto L17;
        Bitmap.CompressFormat r106 = Bitmap.CompressFormat.JPEG;
    L24:
        r104 = r105.setCompressFormat(r106).asObservable();
        goto L26
    L17:
        String r107 = r111.toLowerCase();
        if (r107.endsWith(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT) == false) goto L21;
        r106 = Bitmap.CompressFormat.PNG;
        goto L24
    L21:
        if (r107.endsWith(".webp") == false) goto L23;
        r106 = Bitmap.CompressFormat.WEBP;
        goto L24
    L23:
        r106 = Bitmap.CompressFormat.JPEG;
    L8:
        r100 = true;
        goto L9
    }
}
