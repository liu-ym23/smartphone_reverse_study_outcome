package com.larus.im.internal.delegate;

import com.larus.im.bean.message.MessageContentType;
import com.larus.im.bean.message.block.Block;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d0 implements gd9.m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0 f348204b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gd9.m f348205a;

    static {
        f348204b = new d0();
    }

    @Override // gd9.m
    public final String a(@MessageContentType int r100, String r101, String r110, String r111, List<Block> r112) {
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r110, "content");
        Intrinsics.checkNotNullParameter(r111, "thinkingContent");
        return this.f348205a.a(r100, r101, r110, r111, r112);
    }

    @Override // gd9.m
    public final boolean isWCDBEnable() {
        return this.f348205a.isWCDBEnable();
    }

    public d0() {
        com.larus.im.service.s.f350887a.getClass();
        this.f348205a = com.larus.im.service.s.a.a().getFlowIMDepend().b();
    }
}
