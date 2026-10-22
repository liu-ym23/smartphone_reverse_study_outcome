package com.larus.dora.impl.dynamic;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0004J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J'\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0002\u0010\u0018R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/dora/impl/dynamic/BaseViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "actionHandler", "Lcom/larus/dora/impl/dynamic/event/ActionHandler;", "setActionHandler", "", "handler", "sendAction", "action", "Lcom/larus/dora/impl/dynamic/event/ViewHolderAction;", "onViewAttached", "onViewRecycled", "onViewDetached", "bind", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "(Ljava/lang/Object;Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;Lcom/larus/dora/impl/dynamic/entity/CardContext;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e59.a f335049a;

    public abstract void T3(T r100, e59.b r101, d59.b r102);

    public void U3() {
    }

    public void V3() {
    }

    public void onViewRecycled() {
    }

    public BaseViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    public final void W3(e59.e r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        e59.a r101 = this.f335049a;
        if (r101 == null) goto L6;
        r101.onAction(r100);
        return;
    }
}
