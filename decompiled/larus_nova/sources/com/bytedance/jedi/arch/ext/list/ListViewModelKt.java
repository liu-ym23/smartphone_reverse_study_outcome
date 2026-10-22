package com.bytedance.jedi.arch.ext.list;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.jedi.arch.Async;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ISubscriber;
import com.bytedance.locallife.dito.data.DitoNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u009a\u0002\u0010\u0016\u001a\u00020\u0017\"\b\b\u0000\u0010\u0018*\u00020\u0019\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00180\u001a2$\u0010\u001b\u001a \u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u001c2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u001e2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0018\u0018\u00010 2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0018\u0018\u00010 2!\b\u0002\u0010\"\u001a\u001b\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0017\u0018\u00010#¢\u0006\u0002\b%2!\b\u0002\u0010&\u001a\u001b\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0017\u0018\u00010#¢\u0006\u0002\b%2\u001b\b\u0002\u0010'\u001a\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u0017\u0018\u00010(¢\u0006\u0002\b%2!\b\u0002\u0010)\u001a\u001b\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0017\u0018\u00010#¢\u0006\u0002\b%H\u0002\"2\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"2\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007\"8\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\">\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n0\u000e\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"2\u0010\u0011\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\">\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n0\u000e\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010¨\u0006*"}, d2 = {"hasMore", "Lcom/bytedance/jedi/arch/ext/list/DistinctBoolean;", ExifInterface.GPS_DIRECTION_TRUE, "P", "Lcom/bytedance/jedi/arch/ext/list/Payload;", "Lcom/bytedance/jedi/arch/ext/list/IListState;", "getHasMore", "(Lcom/bytedance/jedi/arch/ext/list/IListState;)Lcom/bytedance/jedi/arch/ext/list/DistinctBoolean;", "isEmpty", "list", "", "getList", "(Lcom/bytedance/jedi/arch/ext/list/IListState;)Ljava/util/List;", DitoNode.LOAD_MORE, "Lcom/bytedance/jedi/arch/Async;", "getLoadMore", "(Lcom/bytedance/jedi/arch/ext/list/IListState;)Lcom/bytedance/jedi/arch/Async;", WsConstants.KEY_PAYLOAD, "getPayload", "(Lcom/bytedance/jedi/arch/ext/list/IListState;)Lcom/bytedance/jedi/arch/ext/list/Payload;", "refresh", "getRefresh", "doListSubscribe", "", "RECEIVER", "Lcom/bytedance/jedi/arch/IReceiver;", "Lcom/bytedance/jedi/arch/ISubscriber;", "viewModel", "Lcom/bytedance/jedi/arch/ext/list/ListViewModel;", "adapter", "Lcom/bytedance/jedi/arch/ext/list/DiffableAdapter;", "refreshListener", "Lcom/bytedance/jedi/arch/ext/list/ListListener;", "loadMoreListener", "onHasMore", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "onEmpty", "onSubmitFinish", "Lkotlin/Function1;", "onPayloadChange", "ext_list_release"}, k = 2, mv = {1, 1, 16})
public final class ListViewModelKt {
    public static final <T, P extends Payload> DistinctBoolean getHasMore(IListState<T, P> r100) {
        return r100.getSubstate().getHasMore();
    }

    public static final <T, P extends Payload> List<T> getList(IListState<T, P> r100) {
        return r100.getSubstate().getList();
    }

    public static final <T, P extends Payload> Async<List<T>> getLoadMore(IListState<T, P> r100) {
        return r100.getSubstate().getLoadMore();
    }

    public static final <T, P extends Payload> P getPayload(IListState<T, P> r100) {
        return (P) r100.getSubstate().getPayload();
    }

    public static final <T, P extends Payload> Async<List<T>> getRefresh(IListState<T, P> r100) {
        return r100.getSubstate().getRefresh();
    }

    public static final <T, P extends Payload> DistinctBoolean isEmpty(IListState<T, P> r100) {
        return r100.getSubstate().isEmpty();
    }

    public static final /* synthetic */ void access$doListSubscribe(ISubscriber r100, ListViewModel r101, DiffableAdapter r102, ListListener r103, ListListener r104, Function2 r105, Function2 r106, Function1 r107, Function2 r108) {
        doListSubscribe(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    private static final <RECEIVER extends IReceiver, T, P extends Payload> void doListSubscribe(final ISubscriber<? extends RECEIVER> r210, final ListViewModel<T, P, IListState<T, P>> r211, final DiffableAdapter<T> r212, final ListListener<T, RECEIVER> r213, final ListListener<T, RECEIVER> r214, final Function2<? super RECEIVER, ? super Boolean, Unit> r215, final Function2<? super RECEIVER, ? super Boolean, Unit> r216, final Function1<? super RECEIVER, Unit> r217, final Function2<? super RECEIVER, ? super P, Unit> r310) {
        if (r310 == null) goto L5;
        ISubscriber.DefaultImpls.selectSubscribe$default(r210, r211, ListViewModelKt$doListSubscribe$1$1.INSTANCE, null, new ListViewModelKt$doListSubscribe$1$2(r310), 2, null);
    L5:
        if (r215 == null) goto L7;
        ISubscriber.DefaultImpls.selectSubscribe$default(r210, r211, ListViewModelKt$doListSubscribe$2$1.INSTANCE, null, new ListViewModelKt$doListSubscribe$2$2(r215), 2, null);
    L7:
        if (r216 == null) goto L9;
        ISubscriber.DefaultImpls.selectSubscribe$default(r210, r211, ListViewModelKt$doListSubscribe$3$1.INSTANCE, null, new ListViewModelKt$doListSubscribe$3$2(r216), 2, null);
    L9:
        if (r213 == null) goto L11;
        ISubscriber.DefaultImpls.asyncSubscribe$default(r210, r211, ListViewModelKt$doListSubscribe$4$1.INSTANCE, null, new ListViewModelKt$doListSubscribe$4$2(r213), new ListViewModelKt$doListSubscribe$4$3(r213), new ListViewModelKt$doListSubscribe$4$4(r213), 2, null);
    L11:
        if (r214 == null) goto L13;
        ISubscriber.DefaultImpls.asyncSubscribe$default(r210, r211, ListViewModelKt$doListSubscribe$5$1.INSTANCE, null, new ListViewModelKt$doListSubscribe$5$2(r214), new ListViewModelKt$doListSubscribe$5$3(r214), new ListViewModelKt$doListSubscribe$5$4(r214), 2, null);
    L13:
        if (r212 == null) goto L16;
        ISubscriber.DefaultImpls.selectSubscribe$default(r210, r211, ListViewModelKt$doListSubscribe$6$1.INSTANCE, null, new ListViewModelKt$doListSubscribe$$inlined$also$lambda$1(r212, r210, r211, r217), 2, null);
        return;
    }

    public static /* synthetic */ void doListSubscribe$default(ISubscriber r100, ListViewModel r101, DiffableAdapter r110, ListListener r111, ListListener r112, Function2 r113, Function2 r114, Function1 r115, Function2 r116, int r117, Object r118) {
        Function2 r102 = null;
        if ((r117 & 2) == 0) goto L5;
        DiffableAdapter r103 = null;
    L7:
        if ((r117 & 4) == 0) goto L9;
        ListListener r104 = null;
    L11:
        if ((r117 & 8) == 0) goto L13;
        ListListener r105 = null;
    L15:
        if ((r117 & 16) == 0) goto L17;
        Function2 r106 = null;
    L19:
        if ((r117 & 32) == 0) goto L21;
        Function2 r107 = null;
    L23:
        if ((r117 & 64) == 0) goto L25;
        Function1 r108 = null;
    L27:
        if ((r117 & 128) != 0) goto L30;
        r102 = r116;
    L30:
        doListSubscribe(r100, r101, r103, r104, r105, r106, r107, r108, r102);
        return;
    L25:
        r108 = r115;
        goto L27
    L21:
        r107 = r114;
        goto L23
    L17:
        r106 = r113;
        goto L19
    L13:
        r105 = r112;
        goto L15
    L9:
        r104 = r111;
        goto L11
    L5:
        r103 = r110;
        goto L7
    }
}
