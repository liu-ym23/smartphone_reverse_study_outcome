package zr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o f573367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m f573368b;

    @Override // zr2.a
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s findContainButtonById(int r100) {
        return this.f573368b.findContainButtonById(r100);
    }

    public d(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o r100, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r101) {
        Intrinsics.checkNotNullParameter(r100, "original1");
        Intrinsics.checkNotNullParameter(r101, "original2");
        this.f573367a = r100;
        this.f573368b = r101;
    }
}
