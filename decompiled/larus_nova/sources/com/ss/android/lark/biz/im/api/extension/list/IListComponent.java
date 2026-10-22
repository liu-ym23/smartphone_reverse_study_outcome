package com.ss.android.lark.biz.im.api.extension.list;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.scaffold.IComponent;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u001e\u001f J-\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H&¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH&J\u0016\u0010\r\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\nH&J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0014H&J\f\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H&J\b\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u001cH&¨\u0006!"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/list/IListComponent;", "VO", "Lcom/ss/android/lark/scaffold/IComponent;", "getListViewModel", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/lark/biz/im/api/extension/list/IListViewModel;", "key", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/ss/android/lark/biz/im/api/extension/list/IListViewModel;", "addItemDetectedListener", "", "listener", "Lcom/ss/android/lark/biz/im/api/extension/list/IListComponent$ItemDetectedListener;", "removeItemDetectedListener", "addItemDecoration", "decoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "removeItemDecoration", "invalidateItemDecorations", "addOnScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "removeOnScrollListener", "getActionHandlerManager", "Lcom/ss/android/lark/scaffold/action/ActionManager;", "Lcom/ss/android/lark/biz/im/api/extension/list/action/ActionHandlerManager;", "getScrollDispatcher", "Lcom/ss/android/lark/biz/im/api/extension/scroll/ScrollDispatcher;", "addListCommitListener", "Lcom/ss/android/lark/biz/im/api/extension/list/IListComponent$ListCommitListener;", "removeListCommitListener", "ListCommitListener", "ListKeyEventListener", "ItemDetectedListener", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IListComponent<VO> extends IComponent {

    public interface a<VO> {
        void a(List<? extends VO> r100);
    }

    public interface b {
        void a(List<Object> r100);
    }

    void Q60(b r100);

    void uj(IListComponentKt$listCommitFlow$1.a r100);
}
