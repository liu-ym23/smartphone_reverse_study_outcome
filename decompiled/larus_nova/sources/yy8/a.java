package yy8;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.share.panel.d;
import com.larus.chat.gallery.impl.preview.toolbar.action.y;
import com.larus.chat.gallery.impl.preview.toolbar.action.z;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xy8.a f569494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f569495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f569496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f569497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f569498e;

    @Override // com.larus.bmhome.share.panel.d
    public final boolean d(String r100, String r101, Boolean r102) {
        return true;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void f() {
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void onDismiss() {
        FLogger.f375446a.d("PreviewSharePanelIntegration", "分享面板关闭");
        b.a(this.f569496c, this.f569497d, this.f569498e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.share.panel.d
    public final void e(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f569497d.element = r100;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final boolean b(Context r100, DialogFragment r101, View r102, jr9.a r103) {
        Intrinsics.checkNotNullParameter(r103, "shareItemConfig");
        String r104 = r103.b();
        if (Intrinsics.areEqual(r104, "publish") == false) goto L14;
        FLogger.f375446a.i("PreviewSharePanelIntegration", "拦截 PUBLISH 点击");
        if (r101 != null) goto L29;
    L12:
        b.a(this.f569496c, this.f569497d, this.f569498e);
        this.f569494a.k();
    L24:
        return true;
    L29:
        r101.dismissAllowingStateLoss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L12;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    L14:
        if (Intrinsics.areEqual(r104, ShareChannel.SET_PRIVATE) == false) goto L25;
        FLogger.f375446a.i("PreviewSharePanelIntegration", "拦截 SET_PRIVATE 点击");
        if (r101 != null) goto L27;
    L23:
        b.a(this.f569496c, this.f569497d, this.f569498e);
        this.f569494a.g();
        this.f569495b.invoke();
        goto L24
    L27:
        r101.dismissAllowingStateLoss();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r106 = DialogFragmentLancet.sLastShowStack;
        if (r106 == null) goto L23;
        com.bytedance.crash.d.d(r106, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L23
    L25:
        return false;
    }

    public a(xy8.a r100, z r101, Ref.BooleanRef r102, Ref.ObjectRef r103, y r104) {
        this.f569494a = r100;
        this.f569495b = r101;
        this.f569496c = r102;
        this.f569497d = r103;
        this.f569498e = r104;
    }
}
