package com.ss.android.lark.widget.photo.preview.menu.action;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes38.dex */
public final class MediaDownloadAction {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, Boolean> f446807i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PhotoItem f446809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DownloadCallback f446810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleOwner f446811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorCoroutineDispatcher f446812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f446813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineScope f446814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MediaExtra f446815h;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/menu/action/MediaDownloadAction$DownloadCallback;", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "onDownloadProgress", "", "progress", "", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DownloadCallback extends IGetDataCallback<String> {
        void onDownloadProgress(float r100);
    }

    public static final class a {
    }

    public interface b {

        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ErrorResult f446816a;

            public a(ErrorResult r100) {
                Intrinsics.checkNotNullParameter(r100, "errorResult");
                this.f446816a = r100;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.widget.photo.preview.menu.action.MediaDownloadAction$b$b, reason: collision with other inner class name */
        public static final class C5412b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f446817a;

            public C5412b(String r100) {
                Intrinsics.checkNotNullParameter(r100, "path");
                this.f446817a = r100;
            }
        }
    }

    static {
        f446807i = new ConcurrentHashMap(4);
    }

    public final void a() {
        BuildersKt.launch$default(this.f446814g, null, null, new MediaDownloadAction$downloadItem$1(this, null), 3, null);
    }

    public final void b() {
        Boolean r100 = Boolean.FALSE;
        f446807i.put(Integer.valueOf(this.f446809b.hashCode()), r100);
    }

    public MediaDownloadAction(Context r100, PhotoItem r101, DownloadCallback r102, Fragment r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "photoItem");
        this.f446808a = r100;
        this.f446809b = r101;
        this.f446810c = r102;
        this.f446811d = r103;
        this.f446812e = ExecutorsKt.from(CoreThreadPool.getDefault().getCachedThreadPool());
        final CoroutineScope r104 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        if (r103 == null) goto L7;
        Lifecycle r105 = r103.getLifecycle();
        if (r105 == null) goto L7;
        r105.addObserver(new MediaDownloadAction$scope$1$1(r104));
    L7:
        this.f446814g = r104;
        this.f446815h = r101.getMediaExtra();
    }
}
