package com.ss.android.lark.widget.photo.preview.video.online;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BaseModel;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.auditsdk.v2.utils.DownloadAuthorizationEventType;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.android.lark.player.player.LarkPlayerUtils;
import com.ss.android.lark.widget.photo.preview.utils.DownloadCheckUtil;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.HashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class g extends BaseModel implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PhotoItem f447354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f447355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b.a f447356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f447357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f447358e;

    @Override // com.ss.android.lark.widget.photo.preview.video.online.b
    public final void C0(PhotoItem r100, UIGetDataCallback r101) {
        IGetDataCallback r102 = (IGetDataCallback) getCallbackManager().wrapAndAddCallback(r101);
        MediaExtra r103 = r100.getMediaExtra();
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.getKey() != null) goto L8;
        return;
    L8:
        String r104 = com.ss.android.lark.widget.photopicker.utils.g.a(r103, this.f447358e);
        Log.i("OnlineVideoGalleryModel", "getDownloadVideoWorkSpace, path:" + r104);
        boolean r105 = FileUtils.r(r104);
        if (r105 == false) goto L11;
    L14:
        if (r105 == true) goto L16;
        int r106 = DownloadCheckUtil.f447128a;
        com.ss.android.lark.widget.photopicker.f.a().o();
        throw null;
    L16:
        if (this.f447354a.getMessageIdentity() == null) goto L20;
        this.f447354a.getMessageIdentity().getMessageId();
    L20:
        if (this.f447354a.getMessageIdentity() == null) goto L23;
        this.f447354a.getMessageIdentity().getChatId();
    L23:
        com.ss.android.lark.widget.photopicker.f.d r107 = com.ss.android.lark.widget.photopicker.f.a();
        DownloadAuthorizationEventType r108 = DownloadAuthorizationEventType.IMAGE_DOWNLOAD;
        r107.u();
        return;
    L11:
        if (this.f447355b == false) goto L14;
        Log.e("OnlineVideoGalleryModel", "Downloading video");
        r102.onError(new ErrorResult(-5439));
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.online.b
    public final void n2(final PhotoItem r110, UIGetDataCallback r111) {
        final IGetDataCallback r112 = (IGetDataCallback) getCallbackManager().wrapAndAddCallback(r111);
        final String r100 = r110.getMediaExtra().getFilePath();
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L11:
        DataSource r101 = new DataSource();
        MediaExtra r102 = r110.getMediaExtra();
        MessageIdentity r103 = r110.getMessageIdentity();
        String r104 = r102.getUrl();
        String r105 = r110.getMessageId();
        if (TextUtils.isEmpty(r104) == true) goto L27;
        if (r103 == null) goto L27;
        StringBuilder r106 = new StringBuilder(r104);
        Message.SourceType r107 = r103.getSourceType();
        if (r107 != null) goto L18;
    L20:
        int r108 = -99;
    L21:
        if (r108 == (-99)) goto L27;
        if (r104.contains("?") == false) goto L25;
        r106.append("&scene=");
        r106.append(r108);
    L26:
        r104 = r106.toString();
        goto L27
    L25:
        r106.append("?scene=");
        r106.append(r108);
        goto L26
    L18:
        if (r107 != Message.SourceType.TYPE_FROM_FAVORITE) goto L20;
        r108 = 2;
    L27:
        r101.setData(UriProtector.parse(r104).buildUpon().appendQueryParameter("action", "view").build().toString());
        r101.setCacheKeyPrefix(r105);
        r101.setSize(r102.getSize());
        if (LarkPlayerUtils.d() == false) goto L30;
        HashMap<String, String> r109 = new HashMap(2);
        r109.put(BaseHttpRequestInfo.KEY_COOKIE, "session=" + com.ss.android.lark.widget.photopicker.f.a().getSession());
        r101.setExtra(r109);
    L30:
        r112.onSuccess(r101);
    L31:
        this.f447354a.getMediaExtra().getKey();
        com.ss.android.lark.widget.photopicker.f.d r113 = com.ss.android.lark.widget.photopicker.f.a();
        this.f447354a.getMessageIdentity();
        new UIGetDataCallback(new OnlineVideoGalleryModel$1(this, r100, r110, r112));
        r113.k();
        return;
    L5:
        if (FileUtils.r(r100) == false) goto L11;
        DataSource r114 = new DataSource();
        com.ss.android.lark.widget.photopicker.f.a().o();     // Catch: Exception -> L10
        new PolarisFileWrapper(r100);     // Catch: Exception -> L10
        throw null;     // Catch: Exception -> L10
    L10:
        Log.e("OnlineVideoGalleryModel", "[cipher] file decrypt failed, original path = " + r100);
        r114.setUri(Uri.fromFile(new PolarisFileWrapper(r100)));
        r114.setIsLocal(true);
        r112.onSuccess(r114);
        goto L31
    }

    public g(Context r100, PhotoItem r101, String r102, String r103) {
        this.f447357d = false;
        this.f447358e = r100;
        this.f447354a = r101;
    }
}
