package com.bytedance.ee.bear.contract.setting;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@AppConfig(key = DocsFeedPushConfig.DOCS_FEED_PUSH_CONFIG)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/contract/setting/DocsFeedPushConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "docs_feed_push_preload_delay", "", "getDocs_feed_push_preload_delay", "()I", "setDocs_feed_push_preload_delay", "(I)V", "docs_feed_push_preload_limit", "getDocs_feed_push_preload_limit", "setDocs_feed_push_preload_limit", "Companion", "features-feature-gating-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocsFeedPushConfig implements NonProguard {
    public static final a Companion = null;
    public static final String DOCS_FEED_PUSH_CONFIG = "docs_feed_push_config";
    private int docs_feed_push_preload_delay;
    private int docs_feed_push_preload_limit;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DocsFeedPushConfig() {
        this.docs_feed_push_preload_delay = 20;
        this.docs_feed_push_preload_limit = 10;
    }

    public final int getDocs_feed_push_preload_delay() {
        return this.docs_feed_push_preload_delay;
    }

    public final int getDocs_feed_push_preload_limit() {
        return this.docs_feed_push_preload_limit;
    }

    public final void setDocs_feed_push_preload_delay(int r100) {
        this.docs_feed_push_preload_delay = r100;
    }

    public final void setDocs_feed_push_preload_limit(int r100) {
        this.docs_feed_push_preload_limit = r100;
    }
}
