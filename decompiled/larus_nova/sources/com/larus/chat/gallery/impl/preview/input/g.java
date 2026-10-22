package com.larus.chat.gallery.impl.preview.input;

import com.larus.im.bean.bot.BotModel;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f324374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f324375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f324376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Function1<? super BotModel, Unit> f324377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile BotModel f324378e;

    public static final class a {
    }

    static {
    }

    public g(Function0<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "botIdProvider");
        this.f324374a = r100;
        this.f324375b = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("BotModelCacheHelper"));
        this.f324376c = new Object();
    }
}
