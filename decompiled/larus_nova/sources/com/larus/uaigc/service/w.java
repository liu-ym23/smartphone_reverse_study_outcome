package com.larus.uaigc.service;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageShareClickMethod;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class w implements ky9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f373994a = null;

    static {
        f373994a = new w();
    }

    public w() {
    }

    @Override // ky9.b
    public final void a(ImageShareClickMethod r100, df8.a r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "clickMethod");
        Intrinsics.checkNotNullParameter(r101, "imageItemInfo");
    }

    @Override // ky9.b
    public final void b(ImageShareClickMethod r100, df8.a r101, String r102, Integer r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "clickMethod");
        Intrinsics.checkNotNullParameter(r101, "imageItemInfo");
    }

    @Override // ky9.b
    public final com.larus.bmhome.share.panel.h c(ImageShareClickMethod r100, df8.a r101, Integer r102, JSONObject r103, Message r104) {
        Intrinsics.checkNotNullParameter(r100, "clickMethod");
        Intrinsics.checkNotNullParameter(r101, "imageItemInfo");
        return null;
    }
}
