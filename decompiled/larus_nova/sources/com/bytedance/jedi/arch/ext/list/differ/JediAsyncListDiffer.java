package com.bytedance.jedi.arch.ext.list.differ;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\b\u0016\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB'\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\u001f\u0010\u0018\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0016J.\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010!\u001a\u00020\"2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010$H\u0002J&\u0010%\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010$R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/differ/JediAsyncListDiffer;", ExifInterface.GPS_DIRECTION_TRUE, "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "fetcher", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/support/v7/util/DiffUtil$ItemCallback;Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;)V", "mUpdateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "mConfig", "Lcom/bytedance/jedi/arch/ext/list/differ/JediDifferConfig;", "mPrefetcher", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher;", "(Landroid/support/v7/util/ListUpdateCallback;Lcom/bytedance/jedi/arch/ext/list/differ/JediDifferConfig;Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher;)V", "mList", "", "mMainThreadExecutor", "Ljava/util/concurrent/Executor;", "mMaxScheduledGeneration", "", "getCurrentList", "getItem", "position", "withPrefetch", "", "(IZ)Ljava/lang/Object;", "getItemCount", "latchList", "", "newList", "diffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "callback", "Lkotlin/Function0;", "submitList", "ext_list_release"}, k = 1, mv = {1, 1, 16})
public final class JediAsyncListDiffer<T> {
    private final JediDifferConfig<T> mConfig;
    private List<? extends T> mList;
    private final Executor mMainThreadExecutor;
    private int mMaxScheduledGeneration;
    private final JediListPrefetcher mPrefetcher;
    private final ListUpdateCallback mUpdateCallback;

    /* JADX INFO: renamed from: com.bytedance.jedi.arch.ext.list.differ.JediAsyncListDiffer$submitList$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run"}, k = 3, mv = {1, 1, 16})
    public static final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Function0 $callback;
        final /* synthetic */ List $newList;
        final /* synthetic */ List $oldList;
        final /* synthetic */ int $runGeneration;
        final /* synthetic */ JediAsyncListDiffer this$0;

        public AnonymousClass1(JediAsyncListDiffer r100, List r101, List r102, int r103, Function0 r104) {
            this.this$0 = r100;
            this.$oldList = r101;
            this.$newList = r102;
            this.$runGeneration = r103;
            this.$callback = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com_bytedance_jedi_arch_ext_list_differ_JediAsyncListDiffer$submitList$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public final void com_bytedance_jedi_arch_ext_list_differ_JediAsyncListDiffer$submitList$1__run$___twin___() {
            final DiffUtil.DiffResult r100 = DiffUtil.calculateDiff(new JediAsyncListDiffer$submitList$1$result$1(this));
            JediAsyncListDiffer.access$getMMainThreadExecutor$p(this.this$0).execute(new RunnableC35811(this, r100));
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_jedi_arch_ext_list_differ_JediAsyncListDiffer$submitList$1_com_larus_apm_impl_protector_RunnableLancet_run(AnonymousClass1 r100) {
            r100.com_bytedance_jedi_arch_ext_list_differ_JediAsyncListDiffer$submitList$1__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final int getItemCount() {
        return this.mList.size();
    }

    public final List<T> getCurrentList() {
        return this.mList;
    }

    public static final /* synthetic */ JediDifferConfig access$getMConfig$p(JediAsyncListDiffer r100) {
        return r100.mConfig;
    }

    public static final /* synthetic */ Executor access$getMMainThreadExecutor$p(JediAsyncListDiffer r100) {
        return r100.mMainThreadExecutor;
    }

    public static final /* synthetic */ int access$getMMaxScheduledGeneration$p(JediAsyncListDiffer r100) {
        return r100.mMaxScheduledGeneration;
    }

    public static final /* synthetic */ void access$setMMaxScheduledGeneration$p(JediAsyncListDiffer r100, int r101) {
        r100.mMaxScheduledGeneration = r101;
    }

    public final T getItem(int r100, boolean r101) {
        List<? extends T> r102 = this.mList;
        if (r100 >= r102.size()) goto L12;
        if (r100 < 0) goto L14;
        if (r101 == false) goto L11;
        JediListPrefetcher r103 = this.mPrefetcher;
        if (r103 == null) goto L11;
        r103.loadAround$ext_list_release(r100);
    L11:
        return (T) ListProtector.get(r102, r100);
    L14:
        return null;
    L12:
        return null;
    }

    public final void submitList(List<? extends T> r100, Function0<Unit> r110) {
        int r101 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = r101;
        List<? extends T> r102 = this.mList;
        if (r100 != r102) goto L5;
        return;
    L5:
        if (r100.isEmpty() == false) goto L10;
        int r103 = r102.size();
        this.mList = CollectionsKt.emptyList();
        this.mUpdateCallback.onRemoved(0, r103);
        if (r110 == null) goto L17;
        Unit r104 = r110.invoke();
        return;
    L17:
        return;
    L10:
        if (r102.isEmpty() == false) goto L14;
        this.mList = r100;
        this.mUpdateCallback.onInserted(0, r100.size());
        if (r110 == null) goto L19;
        Unit r105 = r110.invoke();
        return;
    L19:
        return;
    L14:
        this.mConfig.getBackgroundThreadExecutor$ext_list_release().execute(new AnonymousClass1(this, r102, r100, r101, r110));
    }

    public JediAsyncListDiffer(ListUpdateCallback r100, JediDifferConfig<T> r101, JediListPrefetcher r102) {
        this.mUpdateCallback = r100;
        this.mConfig = r101;
        this.mPrefetcher = r102;
        Executor r103 = r101.getMainThreadExecutor$ext_list_release();
        if (r103 != null) goto L6;
        r103 = new MainThreadExecutor();
    L6:
        this.mMainThreadExecutor = r103;
        this.mList = CollectionsKt.emptyList();
    }

    private final void latchList(List<? extends T> r100, DiffUtil.DiffResult r101, Function0<Unit> r102) {
        this.mList = r100;
        r101.dispatchUpdatesTo(this.mUpdateCallback);
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke();
        return;
    }

    public JediAsyncListDiffer(RecyclerView.Adapter<?> r100, DiffUtil.ItemCallback<T> r101, JediListPrefetcher.Fetcher r102) {
        AdapterListUpdateCallback r103 = new AdapterListUpdateCallback(r100);
        JediDifferConfig<T> r104 = new JediDifferConfig.Builder(r101).build();
        JediListPrefetcher r105 = null;
        if (r102 == null) goto L5;
        r105 = JediListPrefetcherKt.asPrefetcher$default(r102, false, 0, 3, null);
    L5:
        this(r103, r104, r105);
    }

    public static final /* synthetic */ void access$latchList(JediAsyncListDiffer r100, List r101, DiffUtil.DiffResult r102, Function0 r103) {
        r100.latchList(r101, r102, r103);
    }

    public /* synthetic */ JediAsyncListDiffer(ListUpdateCallback r100, JediDifferConfig r101, JediListPrefetcher r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }

    public static /* synthetic */ Object getItem$default(JediAsyncListDiffer r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.getItem(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void submitList$default(JediAsyncListDiffer r100, List r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.submitList(r101, r102);
    }

    public /* synthetic */ JediAsyncListDiffer(RecyclerView.Adapter r100, DiffUtil.ItemCallback r101, JediListPrefetcher.Fetcher r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
