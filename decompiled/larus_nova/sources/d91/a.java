package d91;

import com.bytedance.android.livesdk.message.model.UserPrivilegeChangeMessage;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import rs0.t0;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f467614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f467615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<k, Unit> f467616c;

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if ((r100 instanceof UserPrivilegeChangeMessage) == false) goto L13;
        UserPrivilegeChangeMessage r101 = (UserPrivilegeChangeMessage) r100;
        if (r101.H() == UserPrivilegeChangeMessage.UserPrivilegeType.AvatarBorder.getValue()) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r101.getUserIdStr(), this.f467615b) == true) goto L9;
        return;
    L9:
        if (t0.f539081a.getValue().booleanValue() == false) goto L11;
        this.f467616c.invoke(r101.G());
        return;
    L11:
        this.f467616c.invoke(r101.E());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(d r100, String r101, Function1<? super k, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        Intrinsics.checkNotNullParameter(r102, "onUpdateAvatarBorder");
        this.f467614a = r100;
        this.f467615b = r101;
        this.f467616c = r102;
        r100.addMessageListener("WebcastUserPrivilegeChangeMessage", this);
    }
}
