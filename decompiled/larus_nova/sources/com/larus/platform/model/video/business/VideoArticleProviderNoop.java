package com.larus.platform.model.video.business;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.platform.uimodel.ArticleParam;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pr9.f;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/platform/model/video/business/VideoArticleProviderNoop;", "Lcom/larus/platform/model/video/business/IVideoArticleProvider;", "<init>", "()V", "openArticleFragment", "Lcom/larus/platform/model/video/sdkwrapper/feed/IArticleFragmentHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "articleParam", "Lcom/larus/platform/uimodel/ArticleParam;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoArticleProviderNoop implements IVideoArticleProvider {

    public static final class a implements f {
        public a() {
        }

        @Override // pr9.f
        public final Fragment f() {
            return null;
        }

        @Override // pr9.f
        public final Boolean onBackPressed() {
            return Boolean.FALSE;
        }
    }

    public VideoArticleProviderNoop() {
    }

    @Override // com.larus.platform.model.video.business.IVideoArticleProvider
    public final f a(Context r100, ArticleParam r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "articleParam");
        return new a();
    }
}
