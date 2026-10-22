package com.bytedance.ee.bear.contract.setting;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = WikiPreloadConfig.WIKI_PRELOAD_CONFIG)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR6\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/contract/setting/WikiPreloadConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "searchWaitTime", "", "getSearchWaitTime", "()I", "setSearchWaitTime", "(I)V", "preloadContent", "Ljava/util/HashMap;", "", "Lcom/bytedance/ee/bear/contract/setting/PreloadStrategy;", "Lkotlin/collections/HashMap;", "getPreloadContent", "()Ljava/util/HashMap;", "setPreloadContent", "(Ljava/util/HashMap;)V", "Companion", "features-feature-gating-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiPreloadConfig implements NonProguard {
    public static final a Companion = null;
    public static final String WIKI_PRELOAD_CONFIG = "ccm_wiki_preload_strategy";
    private HashMap<String, PreloadStrategy> preloadContent;
    private int searchWaitTime;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public WikiPreloadConfig() {
        this.searchWaitTime = 20;
        this.preloadContent = new HashMap();
    }

    public final HashMap<String, PreloadStrategy> getPreloadContent() {
        return this.preloadContent;
    }

    public final int getSearchWaitTime() {
        return this.searchWaitTime;
    }

    public final void setPreloadContent(HashMap<String, PreloadStrategy> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.preloadContent = r2;
    }

    public final void setSearchWaitTime(int r1) {
        this.searchWaitTime = r1;
    }
}
