package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class CommentVoiceExtraAnalyticParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CommentVoiceExtraAnalyticParams f230369a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/CommentVoiceExtraAnalyticParams$Store;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "params", "", "", "getParams", "()Ljava/util/Map;", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Store extends ViewModel {
        private final Map<String, String> params;

        public Store() {
            CommentVoiceExtraAnalyticParams r100 = CommentVoiceExtraAnalyticParams.f230369a;
            this.params = new ConcurrentHashMap();
        }

        public final Map<String, String> getParams() {
            return this.params;
        }
    }

    static {
        f230369a = new CommentVoiceExtraAnalyticParams();
    }

    public CommentVoiceExtraAnalyticParams() {
    }

    public static Map a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        return ((Store) new ViewModelProvider(r100).get(Store.class)).getParams();
    }

    public final void update(Fragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "location");
        a(r100).put("location", r101);
    }

    public static void b(Fragment r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "fileId");
        Intrinsics.checkNotNullParameter(r102, "fileType");
        Map r103 = a(r100);
        r103.put("source_type", "ccm_comment");
        r103.put("file_id", r101);
        r103.put("file_type", r102);
        r103.putIfAbsent("location", "default");
    }
}
