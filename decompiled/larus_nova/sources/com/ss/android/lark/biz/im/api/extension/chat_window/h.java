package com.ss.android.lark.biz.im.api.extension.chat_window;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.chat.entity.ComponentType;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComponentType f410101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f410102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Chat> f410103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f410104d;

    public h(ComponentType r100, String r101, MutableLiveData<Chat> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "componentType");
        Intrinsics.checkNotNullParameter(r101, "threadId");
        this.f410101a = r100;
        this.f410102b = r101;
        this.f410103c = r102;
        this.f410104d = r103;
    }
}
