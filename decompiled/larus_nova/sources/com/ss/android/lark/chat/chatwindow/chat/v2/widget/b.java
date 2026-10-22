package com.ss.android.lark.chat.chatwindow.chat.v2.widget;

import com.larksuite.framework.utils.AndroidThrottle;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b<T> implements AndroidThrottle.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c<T> f414670a;

    public b(c<T> r100) {
        this.f414670a = r100;
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.e
    public final void a(Collection<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "tasks");
        this.f414670a.b(r100);
    }
}
