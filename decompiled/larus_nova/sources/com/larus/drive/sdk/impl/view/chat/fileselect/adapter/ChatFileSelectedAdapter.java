package com.larus.drive.sdk.impl.view.chat.fileselect.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatFileSelectedAdapter;", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter;", "selectCallback", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatFileSelectedAdapter$IFileSelectCallback;", "<init>", "(Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatFileSelectedAdapter$IFileSelectCallback;)V", "bindFileViewHolder", "", "holder", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$FileViewHolder;", "position", "", "IFileSelectCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatFileSelectedAdapter extends BaseFileSelectAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f342146b;

    public interface a {
        void a(x79.a r100);
    }

    public ChatFileSelectedAdapter() {
        this(null);
    }

    public ChatFileSelectedAdapter(a r100) {
        this.f342146b = r100;
    }

    @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.BaseFileSelectAdapter
    public final void y2(BaseFileSelectAdapter.FileViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        x79.a r102 = getItem(r101);
        Intrinsics.checkNotNull(r102);
        r100.T3(r102, true, new e(this));
    }
}
