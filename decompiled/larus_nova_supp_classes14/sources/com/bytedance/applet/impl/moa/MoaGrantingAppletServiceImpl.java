package com.bytedance.applet.impl.moa;

import android.content.Context;
import android.os.Looper;
import com.bytedance.applet.block.permissionapplycard.view.PermissionApplyCardView;
import com.larus.bmhome.chat.quickreply.IMoaGrantingAppletService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import mi8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/impl/moa/MoaGrantingAppletServiceImpl;", "Lcom/larus/bmhome/chat/quickreply/IMoaGrantingAppletService;", "<init>", "()V", "createCardView", "Lcom/larus/bmhome/chat/quickreply/IMoaGrantingCardView;", "context", "Landroid/content/Context;", "prepare", "", "request", "Lcom/larus/bmhome/chat/quickreply/MoaGrantingPrepareRequest;", "operate", "Lcom/larus/bmhome/chat/quickreply/MoaGrantingOperateRequest;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoaGrantingAppletServiceImpl implements IMoaGrantingAppletService {
    public MoaGrantingAppletServiceImpl() {
    }

    public final void a(mi8.g r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        d.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "request");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        BuildersKt.launch$default(d.b, null, null, new MoaGrantingAppletAdapter$operate$1(r8, null), 3, null);
        return;
    L5:
        d.a(r8);
    }

    public final PermissionApplyCardView b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new PermissionApplyCardView(r3, null);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.applet.impl.moa.b, kotlin.jvm.functions.Function0] */
    public final void c(final h r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        d.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "request");
        ?? r0 = new b(r8);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r0.invoke();
        return;
    L5:
        BuildersKt.launch$default(d.b, null, null, new MoaGrantingAppletAdapter$runOnMain$1(r0, null), 3, null);
    }
}
