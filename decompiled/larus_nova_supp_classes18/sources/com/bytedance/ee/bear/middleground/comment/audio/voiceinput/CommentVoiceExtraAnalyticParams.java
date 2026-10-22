package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentVoiceExtraAnalyticParams {
    public static final CommentVoiceExtraAnalyticParams a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/CommentVoiceExtraAnalyticParams$Store;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "params", "", "", "getParams", "()Ljava/util/Map;", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Store extends ViewModel {
        private final Map<String, String> params;

        public Store() {
            CommentVoiceExtraAnalyticParams r0 = CommentVoiceExtraAnalyticParams.a;
            this.params = new ConcurrentHashMap();
        }

        public final Map<String, String> getParams() {
            return this.params;
        }
    }

    static {
        a = new CommentVoiceExtraAnalyticParams();
    }

    public CommentVoiceExtraAnalyticParams() {
    }

    public static Map a(Fragment r1) {
        Intrinsics.checkNotNullParameter(r1, "fragment");
        return ((Store) new ViewModelProvider(r1).get(Store.class)).getParams();
    }

    public final void update(Fragment r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "location");
        a(r2).put("location", r3);
    }

    public static void b(Fragment r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "fileId");
        Intrinsics.checkNotNullParameter(r4, "fileType");
        Map r5 = a(r2);
        r5.put("source_type", "ccm_comment");
        r5.put("file_id", r3);
        r5.put("file_type", r4);
        r5.putIfAbsent("location", "default");
    }
}
