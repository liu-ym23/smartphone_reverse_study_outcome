package com.ss.android.lark.widget.photopicker.utils;

import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f447678a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(PhotoItem r100, File r101, boolean r102) {
        if (r100 == null) goto L21;
        if (r101 == null) goto L22;
        if (r102 == false) goto L23;
        MessageIdentity r103 = r100.getMessageIdentity();
        if (r103 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L14;
        return false;
    L14:
        if (r100.isVideo() == false) goto L16;
        return false;
    L16:
        if (ImageUtils.e(r101) == false) goto L18;
        return false;
    L18:
        if (r100.getType() == 4) goto L27;
        return true;
    L27:
        return false;
    L9:
        if (r103.isHideEditor() != true) goto L11;
        r104 = true;
        goto L12
    L23:
        return false;
    L22:
        return false;
    L21:
        return false;
    }
}
