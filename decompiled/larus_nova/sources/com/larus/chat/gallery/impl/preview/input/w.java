package com.larus.chat.gallery.impl.preview.input;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class w implements zs8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f324399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f324400b;

    @Override // zs8.a
    public final String Y1() {
        return null;
    }

    @Override // zs8.a
    public final String a() {
        return null;
    }

    @Override // zs8.a
    public final String b() {
        return "picture_detail";
    }

    @Override // zs8.a
    public final String c() {
        return null;
    }

    @Override // zs8.a
    public final String d() {
        return null;
    }

    @Override // zs8.a
    public final String e() {
        return null;
    }

    @Override // zs8.a
    public final String f() {
        return null;
    }

    @Override // zs8.a
    public final String g() {
        return null;
    }

    @Override // zs8.a
    public final String getBotId() {
        return null;
    }

    @Override // zs8.a
    public final String getChatType() {
        return null;
    }

    @Override // zs8.a
    public final String getClickFrom() {
        return "";
    }

    @Override // zs8.a
    public final String getTemplateType() {
        return null;
    }

    @Override // zs8.a
    public final String h() {
        return null;
    }

    @Override // zs8.a
    public final String i() {
        return null;
    }

    @Override // zs8.a
    public final String j() {
        return null;
    }

    @Override // zs8.a
    public final String k() {
        return null;
    }

    @Override // zs8.a
    public final boolean l() {
        return false;
    }

    @Override // zs8.a
    public final String m() {
        return null;
    }

    @Override // zs8.a
    public final String n() {
        return null;
    }

    @Override // zs8.a
    public final String p() {
        return null;
    }

    @Override // zs8.a
    public final String getEnterMethod() {
        if (Intrinsics.areEqual(this.f324399a, "from_icon") == false) goto L5;
        return "click_camera_confirm_image_edit_button";
    L5:
        return "photo_preview_sug";
    }

    @Override // zs8.a
    public final String o() {
        if (Intrinsics.areEqual(this.f324400b.getScheme(), "file") == false) goto L5;
        return "shoot";
    L5:
        return "album";
    }

    public w(String r100, Uri r101) {
        this.f324399a = r100;
        this.f324400b = r101;
    }
}
