package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.jvm.internal.Intrinsics;
import okb.i;

/* JADX INFO: loaded from: classes37.dex */
public final class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KVRepo f433311a;

    @Override // okb.i
    public final int a() {
        Intrinsics.checkNotNullParameter("key_translate_times_new", "key");
        return this.f433311a.getInt("key_translate_times_new", 0);
    }

    @Override // okb.i
    public final boolean e() {
        Intrinsics.checkNotNullParameter("android_file_upload_file_descriptor_config", "key");
        return this.f433311a.getBoolean("android_file_upload_file_descriptor_config", true);
    }

    @Override // okb.i
    public final String getString() {
        Intrinsics.checkNotNullParameter("chatter_info", "key");
        return this.f433311a.getString("chatter_info", null);
    }

    public g(com.ss.android.lark.storage.kv.repo.a r100) {
        this.f433311a = r100;
    }

    @Override // okb.i
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter("chatter_info", "key");
        this.f433311a.putString("chatter_info", r100);
    }

    @Override // okb.i
    public final void putInt(int r100) {
        Intrinsics.checkNotNullParameter("key_translate_times_new", "key");
        this.f433311a.putInt("key_translate_times_new", r100);
    }
}
