package com.ss.android.lark.widget.photo.preview.menu.action;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;

/* JADX INFO: loaded from: classes38.dex */
public final class SaveStickerAction implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PhotoItem f446833b;

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String getId() {
        return "SAVE_STICKER";
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String a() {
        return UIUtils.getString(this.f446832a, R.string.Lark_Legacy_AddStickerForChat);
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final Runnable getAction() {
        return new AnonymousClass1(this);
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final boolean isValid() {
        PhotoItem r100 = this.f446833b;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isVideo() == true) goto L23;
        PhotoItem.TranslateProperty r101 = r100.getTranslateProperty();
        if (r101 == null) goto L9;
        boolean r102 = r101.isTranslated();
    L10:
        if (r102 == false) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r100.getImageKey()) == false) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty(r100.getMessageId()) == true) goto L26;
        MessageIdentity r103 = r100.getMessageIdentity();
        if (r103 == null) goto L18;
        boolean r104 = r103.isHideStickerSave();
    L19:
        if (r104 == true) goto L27;
        return true;
    L27:
        return false;
    L18:
        r104 = true;
        goto L19
    L26:
        return false;
    L9:
        r102 = false;
        goto L10
    L23:
        return false;
    }

    public final Context getContext() {
        return this.f446832a;
    }

    public SaveStickerAction(Context r100, PhotoItem r101) {
        this.f446832a = r100;
        this.f446833b = r101;
    }
}
