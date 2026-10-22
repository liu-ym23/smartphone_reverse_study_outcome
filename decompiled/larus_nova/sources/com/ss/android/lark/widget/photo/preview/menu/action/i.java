package com.ss.android.lark.widget.photo.preview.menu.action;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.share.ShareItem;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f446879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PhotoItem f446880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f446881d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f446882a;

        public final void a() {
            i r100 = this.f446882a;
            PhotoItem r101 = r100.f446880c;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.getMessageIdentity() != null) goto L8;
            Message r102 = null;
        L9:
            PhotoItem r103 = r100.f446880c;
            ImageContent r104 = new ImageContent();
            ImageSet r105 = new ImageSet();
            r105.setOrigin(com.ss.android.lark.widget.photopicker.utils.m.a(r103.getOriginPicInfo()));
            r105.setMiddle(com.ss.android.lark.widget.photopicker.utils.m.a(r103.getMiddlePicInfo()));
            r105.setThumbnail(com.ss.android.lark.widget.photopicker.utils.m.a(r103.getThumbnailPicInfo()));
            r105.setInlinePreview(r103.getInlinePreview());
            r105.setKey(r103.getImageKey());
            r105.setMessageIdentity(r103.getMessageIdentity());
            r105.setOriginSource(r103.isOriginSource());
            r105.setOriginSize(r103.getOriginSize());
            r104.setImageSet(r105);
            if (r100.f446880c.getMessageIdentity() != null) goto L12;
        L22:
            boolean r106 = true;
        L23:
            Log.i("ForwardAction", "shareImage:" + r106 + ", photoItem.getMessageIdentity:" + r100.f446880c.getMessageIdentity());
            com.ss.android.lark.widget.photopicker.f.a().getForwardDependency();
            com.ss.android.lark.widget.photopicker.f.a().getChatDependency();
            if (r106 == false) goto L27;
            Log.i("ForwardAction", ShareItem.SHARE_IMAGE);
            RxScheduledExecutor.execInIO(new j(r100), new k(r100, r104, r102));
            return;
        L27:
            if (r102 != null) goto L29;
            throw null;
        L29:
            if (r102.getType() != Message.Type.STICKER) goto L33;
            throw null;
        L33:
            throw null;
        L12:
            if (r100.f446880c.getMessageIdentity().getSourceType() == Message.SourceType.TYPE_FROM_MERGEFORWARD) goto L22;
            if (TextUtils.isEmpty(r100.f446880c.getToken()) == false) goto L22;
            if (r102 == null) goto L19;
            if (r102.getType() == Message.Type.POST) goto L22;
        L19:
            if (r100.f446881d != null) goto L22;
            r106 = false;
            goto L23
        L8:
            r100.f446880c.getMessageIdentity().getMessageId();
            r102 = com.ss.android.lark.widget.photopicker.f.a().d();
            goto L9
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

        public a(i r100) {
            this.f446882a = r100;
        }
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String getId() {
        return "FORWARD";
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String a() {
        PhotoItem r100 = this.f446880c;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L12;
        return UIUtils.getString(this.f446878a, R.string.Lark_IM_ForwardOriginalImage_Button);
    L12:
        return UIUtils.getString(this.f446878a, R.string.Lark_Legacy_MenuForward);
    L5:
        if (r100.getTranslateProperty().isTranslated() == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final Runnable getAction() {
        return new a(this);
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final boolean isValid() {
        PhotoItem r100 = this.f446880c;
        if (r100 == null) goto L9;
        MessageIdentity r101 = r100.getMessageIdentity();
        if (r101 == null) goto L9;
        if (r101.isHideForward() == false) goto L9;
        boolean r102 = true;
    L11:
        if (this.f446879b == true) goto L13;
    L16:
        return false;
    L13:
        if (this.f446880c == null) goto L16;
        if (r102 == true) goto L16;
        return true;
    L9:
        r102 = false;
        goto L11
    }

    public i(Context r100, boolean r101, PhotoItem r102, String r103) {
        this.f446878a = r100;
        this.f446879b = r101;
        this.f446880c = r102;
        this.f446881d = r103;
    }
}
