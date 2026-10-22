package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/tasks/TaskResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TaskResult<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f450737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f450738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Exception f450739c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/tasks/TaskResult$Companion;", "", "()V", "STATUS_ERROR", "", "STATUS_MISS", "STATUS_SUCCESS", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public /* synthetic */ TaskResult(RecyclerView.ViewHolder r100, int r101, Exception r102, int r103) {
        String r104 = null;
        if ((r103 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r103 & 16) == 0) goto L8;
        r104 = "";
    L8:
        this(r100, r101, r102, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TaskResult(Object r100, int r101, Exception r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "taskGroup");
        this.f450737a = r100;
        this.f450738b = r101;
        this.f450739c = r102;
    }
}
