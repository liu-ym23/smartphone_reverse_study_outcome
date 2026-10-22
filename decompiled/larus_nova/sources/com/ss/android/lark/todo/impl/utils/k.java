package com.ss.android.lark.todo.impl.utils;

import com.ss.android.lark.image.entity.Image;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f444293a = 0;

    static {
    }

    public static Image a(com.ss.android.lark.widget.richtext.Image r100) {
        Intrinsics.checkNotNullParameter(r100, "richtextImage");
        Image r101 = new Image();
        r101.setHeight(r100.getHeight());
        r101.setWidth(r100.getWidth());
        r101.setKey(r100.getKey());
        r101.setToken(r100.getToken());
        r101.setResourceCleanScene(r100.getResourceCleanScene());
        r101.setResourceIsCleaned(r100.isResourceIsCleaned());
        com.ss.android.lark.widget.richtext.Image.Type r102 = r100.getType();
        if (r102 == null) goto L5;
        r101.setType(Image.Type.forNumber(r102.getNumber()));
    L5:
        r101.setUrls(r100.getUrls());
        return r101;
    }
}
