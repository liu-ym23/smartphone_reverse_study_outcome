package com.larus.bmhome.bot.dialog;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.common_ui.image.CustomPhotoViewerDialog;
import com.larus.nova.R;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u001f\u001a\u00020\fH\u0002J\u0016\u0010 \u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\r\u0010\"\u001a\u00020#H\u0016¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/bmhome/bot/dialog/BotAvatarViewerDialog;", "Lcom/larus/bmhome/common_ui/image/CustomPhotoViewerDialog;", "activity", "Landroidx/fragment/app/FragmentActivity;", "avatarUrl", "", "canEditAvatar", "", "autoLogEnterPage", "from", "uploadPicClickListener", "Lkotlin/Function0;", "", "autoGenBtnClickListener", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;ZZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getAvatarUrl", "()Ljava/lang/String;", "getCanEditAvatar", "()Z", "getAutoLogEnterPage", "getFrom", "getUploadPicClickListener", "()Lkotlin/jvm/functions/Function0;", "getAutoGenBtnClickListener", "changeAvatarBtn", "Landroid/widget/TextView;", "actionSheet", "Landroid/view/ViewGroup;", "autoGenBtn", "uploadPicBtn", "showAvatarPromptInput", "checkRecordPermission", "doNext", "getExtraViewLayout", "", "()Ljava/lang/Integer;", "show", "logEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotAvatarViewerDialog extends CustomPhotoViewerDialog {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f296549y = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final FragmentActivity f296550q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f296551r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f296552s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function0<Unit> f296553t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function0<Unit> f296554u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f296555v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ViewGroup f296556w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ViewGroup f296557x;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.common_ui.image.CustomPhotoViewerDialog
    public final Integer g() {
        if (z2.f365865a.createBotAutoFillEnable() == false) goto L5;
        int r100 = R.layout.larus_layout_gen_avatar_action_black;
    L7:
        return Integer.valueOf(r100);
    L5:
        r100 = R.layout.larus_layout_bot_avatar_upload;
        goto L7
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (this.f296551r == false) goto L17;
        o r100 = o.f365780a;
        JSONObject r101 = new JSONObject();
        r101.put("page", "bot_photo");
        if (o0.d(this.f296552s) == false) goto L12;
        r101.put("enter_from", this.f296552s);
    L12:
        Unit r102 = Unit.INSTANCE;
        r100.reportEvent(CheckPointType.ENTER_PAGE, r101);
        return;
    L17:
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }

    public static void i(BotAvatarViewerDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public BotAvatarViewerDialog(FragmentActivity r100, String r101, boolean r102, boolean r103, String r104, Function0<Unit> r105, Function0<Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "avatarUrl");
        int r107 = 0;
        if (r101.length() <= 0) goto L5;
        boolean r108 = true;
    L6:
        if (r108 == false) goto L8;
        List r109 = CollectionsKt.listOf(new n1(r101));
    L9:
        super(r100, r109);
        this.f296550q = r100;
        this.f296551r = r103;
        this.f296552s = r104;
        this.f296553t = r105;
        this.f296554u = r106;
        if (z2.f365865a.createBotAutoFillEnable() == false) goto L21;
        ViewGroup r110 = (ViewGroup) this.f327628c.findViewById(R.id.gen_avatar_action);
        this.f296555v = r110;
        ViewGroup r111 = (ViewGroup) this.f327628c.findViewById(R.id.auto_gen_btn);
        this.f296556w = r111;
        ViewGroup r112 = (ViewGroup) this.f327628c.findViewById(R.id.upload_pic_btn);
        this.f296557x = r112;
        if (r110 == null) goto L17;
        if (r102 == true) goto L16;
        r107 = 8;
    L16:
        r110.setVisibility(r107);
    L17:
        if (r111 == null) goto L19;
        e1.d(r111, new b(this));
    L19:
        if (r112 == null) goto L29;
        e1.d(r112, new c(this));
    L29:
        if (r102 == true) goto L39;
        View r113 = this.f310676p;
        if (r113 == null) goto L40;
        this.f327628c.removeView(r113);     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        FLogger.f375446a.i("BotAvatarViewerDialog", "remove extraView error=" + e.getMessage());
        return;
    L40:
        return;
    L39:
        return;
    L21:
        TextView r114 = (TextView) this.f327628c.findViewById(R.id.upload_avatar_btn);
        if (r114 == null) goto L24;
        r114.setOnClickListener(new d(this));
    L24:
        if (r114 == null) goto L29;
        if (r102 == true) goto L28;
        r107 = 8;
    L28:
        r114.setVisibility(r107);
        goto L29
    L8:
        r109 = CollectionsKt.listOf(new n1(new Uri.Builder().scheme("res").path(String.valueOf(R.drawable.larus_common_ui_avatar_placeholder)).build().toString()));
        goto L9
    L5:
        r108 = false;
        goto L6
    }
}
