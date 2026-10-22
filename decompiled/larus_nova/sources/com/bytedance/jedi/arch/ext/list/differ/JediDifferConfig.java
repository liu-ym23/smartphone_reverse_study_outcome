package com.bytedance.jedi.arch.ext.list.differ;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.jedi.arch.JediArchPlugins;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000eB\u001f\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/differ/JediDifferConfig;", ExifInterface.GPS_DIRECTION_TRUE, "", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "mainThreadExecutor", "Ljava/util/concurrent/Executor;", "(Landroid/support/v7/util/DiffUtil$ItemCallback;Ljava/util/concurrent/Executor;)V", "backgroundThreadExecutor", "getBackgroundThreadExecutor$ext_list_release", "()Ljava/util/concurrent/Executor;", "getDiffCallback$ext_list_release", "()Landroid/support/v7/util/DiffUtil$ItemCallback;", "getMainThreadExecutor$ext_list_release", "Builder", "ext_list_release"}, k = 1, mv = {1, 1, 16})
public final class JediDifferConfig<T> {
    private final Executor backgroundThreadExecutor;
    private final DiffUtil.ItemCallback<T> diffCallback;
    private final Executor mainThreadExecutor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000b\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/differ/JediDifferConfig$Builder;", ExifInterface.GPS_DIRECTION_TRUE, "", "mDiffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "(Landroid/support/v7/util/DiffUtil$ItemCallback;)V", "mMainThreadExecutor", "Ljava/util/concurrent/Executor;", "build", "Lcom/bytedance/jedi/arch/ext/list/differ/JediDifferConfig;", "setMainThreadExecutor", "executor", "ext_list_release"}, k = 1, mv = {1, 1, 16})
    public static final class Builder<T> {
        private final DiffUtil.ItemCallback<T> mDiffCallback;
        private Executor mMainThreadExecutor;

        public final JediDifferConfig<T> build() {
            return new JediDifferConfig(this.mDiffCallback, this.mMainThreadExecutor, null);
        }

        public Builder(DiffUtil.ItemCallback<T> r100) {
            this.mDiffCallback = r100;
        }

        public final Builder<T> setMainThreadExecutor(Executor r100) {
            this.mMainThreadExecutor = r100;
            return this;
        }
    }

    public final Executor getBackgroundThreadExecutor$ext_list_release() {
        return this.backgroundThreadExecutor;
    }

    public final DiffUtil.ItemCallback<T> getDiffCallback$ext_list_release() {
        return this.diffCallback;
    }

    public final Executor getMainThreadExecutor$ext_list_release() {
        return this.mainThreadExecutor;
    }

    private JediDifferConfig(DiffUtil.ItemCallback<T> r100, Executor r101) {
        this.diffCallback = r100;
        this.mainThreadExecutor = r101;
        this.backgroundThreadExecutor = JediArchPlugins.INSTANCE.getStoreExecutorFactory().invoke();
    }

    public /* synthetic */ JediDifferConfig(DiffUtil.ItemCallback r100, Executor r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }
}
