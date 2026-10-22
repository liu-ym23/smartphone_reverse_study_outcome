package com.ss.android.lark.widget.photo.preview.menu.action;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;

/* JADX INFO: loaded from: classes38.dex */
public final class t implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f446904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PhotoItem f446905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f446906d;

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String getId() {
        return "JUMP_TO_CHAT";
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String a() {
        if (TextUtils.isEmpty(this.f446906d) == false) goto L6;
        return UIUtils.getString(this.f446903a, R.string.Lark_Legacy_JumpToChat);
    L6:
        return this.f446906d;
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final Runnable getAction() {
        return new s();
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final boolean isValid() {
        PhotoItem r100 = this.f446905c;
        if (r100 == null) goto L9;
        MessageIdentity r101 = r100.getMessageIdentity();
        if (r101 == null) goto L9;
        if (r101.isHideJumpChat() == false) goto L9;
        boolean r102 = true;
    L11:
        if (this.f446904b == false) goto L14;
        if (r102 == true) goto L14;
        return true;
    L14:
        return false;
    L9:
        r102 = false;
        goto L11
    }

    public t(Context r100, boolean r101, PhotoItem r102, String r103) {
        this.f446903a = r100;
        this.f446904b = r101;
        this.f446905c = r102;
        this.f446906d = r103;
    }
}
