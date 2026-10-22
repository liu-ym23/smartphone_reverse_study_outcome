package com.bytedance.jedi.arch.ext.list;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.arch.ext.list.differ.JediAsyncListDiffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J!\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J(\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0016R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/DiffableAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "mDiffer", "Lcom/bytedance/jedi/arch/ext/list/differ/JediAsyncListDiffer;", "getMDiffer", "()Lcom/bytedance/jedi/arch/ext/list/differ/JediAsyncListDiffer;", "getCurrentList", "", "getItem", "position", "", "withPrefetch", "", "(IZ)Ljava/lang/Object;", "getItemCount", "submitList", "", "list", "callback", "Lkotlin/Function0;", "ext_list_release"}, k = 1, mv = {1, 1, 16})
public interface DiffableAdapter<T> {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        public static <T> List<T> getCurrentList(DiffableAdapter<T> r100) {
            return r100.getMDiffer().getCurrentList();
        }

        public static <T> int getItemCount(DiffableAdapter<T> r100) {
            return r100.getMDiffer().getItemCount();
        }

        public static <T> void submitList(DiffableAdapter<T> r100, List<? extends T> r101) {
            r100.submitList(r101, null);
        }

        public static <T> T getItem(DiffableAdapter<T> r100, int r101, boolean r102) {
            return r100.getMDiffer().getItem(r101, r102);
        }

        public static <T> void submitList(DiffableAdapter<T> r100, List<? extends T> r101, Function0<Unit> r102) {
            r100.getMDiffer().submitList(r101, r102);
        }

        public static /* synthetic */ Object getItem$default(DiffableAdapter r100, int r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = false;
        L7:
            return r100.getItem(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getItem");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void submitList$default(DiffableAdapter r100, List r101, Function0 r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.submitList(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: submitList");
        }
    }

    List<T> getCurrentList();

    T getItem(int r100, boolean r101);

    int getItemCount();

    JediAsyncListDiffer<T> getMDiffer();

    void submitList(List<? extends T> r100);

    void submitList(List<? extends T> r100, Function0<Unit> r101);
}
