package com.larus.bmhome.chat.layout.holder.image;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.im.bean.message.Message;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f303855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageItem f303856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TemplateInfo$TemplateInfo f303857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f303858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f303859e;

    public m0(Message r100, ImageItem r101, TemplateInfo$TemplateInfo r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "imageItem");
        this.f303855a = r100;
        this.f303856b = r101;
        this.f303857c = r102;
        this.f303858d = r103;
        this.f303859e = r104;
    }
}
