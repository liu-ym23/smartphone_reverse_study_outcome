package com.ss.android.lark.inline.ai.ui.view;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.job.compat.f;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes36.dex */
public final class URLRecognition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f427674a = 0;

    static {
    }

    @JvmStatic
    public static final void a(final String r100, IGetDataCallback<UrlInlinePreviewEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "callback");
        f.a(new URLRecognition$loadUrlPreviewFormMiddlePlatform$1(r100)).then(Dispatchers.getMain(), new URLRecognition$loadUrlPreviewFormMiddlePlatform$2(r101, null)).error(Dispatchers.getMain(), new URLRecognition$loadUrlPreviewFormMiddlePlatform$3(r101, null));
    }
}
