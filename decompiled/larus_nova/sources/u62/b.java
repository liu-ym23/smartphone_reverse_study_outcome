package u62;

import android.app.Activity;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.comment.input.LiveCommonInputDialog;
import kotlin.jvm.internal.Intrinsics;
import v62.d;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b implements v62.a.InterfaceC7966a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v62.a.InterfaceC7966a f548919a;

    @Override // v62.a.InterfaceC7966a
    public final void a() {
        this.f548919a.a();
    }

    public abstract void b();

    @Override // v62.a.InterfaceC7966a
    public final void c(BaseEmoji r100, String r101) {
        this.f548919a.c(r100, r101);
    }

    public abstract int d();

    @Override // v62.a.InterfaceC7966a
    public final void dismissDialog() {
        this.f548919a.dismissDialog();
    }

    public abstract void e();

    public abstract Activity getActivity();

    public b(LiveCommonInputDialog.c r100) {
        d.a r101 = d.f553390a;
        Intrinsics.checkNotNullParameter(r100, "emojiPanelBridge");
        Intrinsics.checkNotNullParameter(r101, "screenChatPanelBridge");
        this.f548919a = r100;
    }
}
