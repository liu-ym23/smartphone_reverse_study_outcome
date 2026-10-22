package com.ss.android.lark.contact.customized.externalcontact.data;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class DoubaoContactSyncStateStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f419109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f419110b;

    public static final class a {
    }

    static {
    }

    public DoubaoContactSyncStateStore(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        this.f419110b = LazyKt.lazy(new DoubaoContactSyncStateStore$repo$2(this));
        this.f419109a = r100;
    }
}
