package com.larus.platform.model.video.business;

import android.content.Context;
import com.larus.platform.uimodel.ArticleParam;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pr9.f;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/larus/platform/model/video/business/VideoArticleProviderDelegate;", "Lcom/larus/platform/model/video/business/IVideoArticleProvider;", "<init>", "()V", "openArticleFragment", "Lcom/larus/platform/model/video/sdkwrapper/feed/IArticleFragmentHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "articleParam", "Lcom/larus/platform/uimodel/ArticleParam;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoArticleProviderDelegate implements IVideoArticleProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final VideoArticleProviderDelegate f365667b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IVideoArticleProvider f365668a;

    static {
        f365667b = new VideoArticleProviderDelegate();
    }

    @Override // com.larus.platform.model.video.business.IVideoArticleProvider
    public final f a(Context r100, ArticleParam r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "articleParam");
        return this.f365668a.a(r100, r101);
    }

    private VideoArticleProviderDelegate() {
        IVideoArticleProvider r100 = (IVideoArticleProvider) ServiceManager.get().getService(IVideoArticleProvider.class);
        if (r100 != null) goto L5;
        r100 = new VideoArticleProviderNoop();
    L5:
        this.f365668a = r100;
    }
}
