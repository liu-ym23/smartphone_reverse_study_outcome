package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J+\u0010\u001a\u001a\u00020\r\"\u0014\b\u0000\u0010\u001b*\u0006\u0012\u0002\b\u00030\u001c*\u0006\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001e\u001a\u0002H\u001bH\u0016¢\u0006\u0002\u0010\u001fJ+\u0010 \u001a\u00020\r\"\u0014\b\u0000\u0010\u001b*\u0006\u0012\u0002\b\u00030\u001c*\u0006\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001e\u001a\u0002H\u001bH\u0016¢\u0006\u0002\u0010\u001fJ\u0012\u0010!\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\"H\u0016J\u0010\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\"H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListConcatAdapterImpl;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Lcom/ss/android/lark/chat/chatwindow/chat/IMessageListConcatAdapter;", "concatAdapter", "Landroidx/recyclerview/widget/ConcatAdapter;", "<init>", "(Landroidx/recyclerview/widget/ConcatAdapter;)V", "allItemsInner", "", "", "innerItemsIsDirty", "", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", WsConstants.KEY_PAYLOAD, "onItemRangeInserted", "onItemRangeRemoved", "onItemRangeMoved", "fromPosition", "toPosition", "invalidateInnerItems", "resetAllItems", "addAdapter", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/chat/chatwindow/chat/IMessageListAdapter;", "adapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "removeAdapter", "getAdapters", "", "getAllItems", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageListConcatAdapterImpl extends RecyclerView.AdapterDataObserver implements s2b.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcatAdapter f413622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Object> f413623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f413624c;

    public final void b() {
        this.f413624c = true;
        ((ArrayList) this.f413623b).clear();
    }

    @Override // s2b.g
    public final List<Object> h() {
        if (this.f413624c == false) goto L10;
        ((ArrayList) this.f413623b).clear();
        Iterator<T> r100 = this.f413622a.getAdapters().iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        Object r101 = (RecyclerView.Adapter) r100.next();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.IMessageListAdapter<*>");
        List<Object> r102 = this.f413623b;
        ArrayList r103 = (ArrayList) r102;
        r103.addAll(((s2b.f) r101).h());
        goto L6
    L8:
        this.f413624c = false;
    L10:
        return this.f413623b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        b();
    }

    public MessageListConcatAdapterImpl(ConcatAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "concatAdapter");
        this.f413622a = r100;
        this.f413623b = new ArrayList();
        this.f413624c = true;
        r100.registerAdapterDataObserver(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int r100, int r101) {
        b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int r100, int r101) {
        b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int r100, int r101) {
        b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int r100, int r101, Object r102) {
        b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int r100, int r101, int r102) {
        b();
    }
}
