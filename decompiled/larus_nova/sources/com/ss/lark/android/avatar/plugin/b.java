package com.ss.lark.android.avatar.plugin;

import android.content.Context;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.l0;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.pb.chatters.PutResetUserAvatarResultRequest;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.lark.android.avatar.ui.AvatarSource;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class b extends com.ss.lark.android.avatar.plugin.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f456640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<PhotoItem, Unit> f456641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f456642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f456643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f456644h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C5464b f456645i;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.lark.android.avatar.plugin.b$b, reason: collision with other inner class name */
    public static final class C5464b implements l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f456646a;

        public C5464b(b r100) {
            this.f456646a = r100;
        }

        @Override // com.ss.android.lark.biz.im.api.l0
        public final void a(Chatter r100) {
            if (r100 == null) goto L5;
            int r101 = gkc.a.f481578a;
            Intrinsics.checkNotNullParameter(r100, "chatter");
            Intrinsics.checkNotNullParameter(r100, "chatter");
            PhotoItem r102 = gkc.c.a(r100.getAvatarKey(), r100.getId(), AvatarSource.SELF_AVATAR);
            r102.setType(4);
            r102.setEntityId(r100.getId());
            Intrinsics.checkNotNull(r102);
            String r103 = r100.getId();
            boolean r104 = r100.isDefaultAvatar();
            Intrinsics.checkNotNullParameter(r103, "userId");
            Intrinsics.checkNotNullParameter(r102, "photoItem");
            b r105 = this.f456646a;
            r105.f456640d = r104;
            r105.f456641e.invoke(r102);
            return;
        }
    }

    static {
    }

    @Override // com.ss.lark.android.avatar.plugin.i
    public final void unRegister() {
        this.f456638b.cancelCallbacks();
        ImSdkService.c().A5(this.f456645i);
    }

    public static final void a(b r100, View r101) {
        Context r102 = r100.f456639c.get();
        if (r102 == null) goto L6;
        new UDDialogBuilder(r102).title(UIHelper.getString(R.string.Lark_Profile_UseDefaultProfilePhotoConfirmTitle)).contentLayout(r101).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_Legacy_Confirm, new f(r100)).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Lark_Profile_Cancel, new g(r100)).show();
        return;
    }

    public static final void b(final b r100, String r101, final PutResetUserAvatarResultRequest.Status r102) {
        r100.getClass();
        IGetDataCallback<Boolean> r103 = new DefaultAvatarPlugin$toggleDefaultAvatar$1(r102, r100);
        PutResetUserAvatarResultRequest.Builder r104 = new PutResetUserAvatarResultRequest.Builder().reset_token(r101).status(r102);
        SdkSender.sendPassThroughRequest(Command.PUT_RESET_USER_AVATAR_RESULT, r104, (IGetDataCallback) r100.f456638b.wrapAndAddCallback(r103), h.f456655a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context r100, AvatarSource r101, boolean r102, Function1<? super PhotoItem, Unit> r103, Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r103, "onAvatarChatterPush");
        Intrinsics.checkNotNullParameter(r104, "onAvatarChanged");
        super(r100, r101);
        this.f456640d = r102;
        this.f456641e = r103;
        this.f456642f = r104;
        this.f456643g = UIHelper.dp2px(90.0f);
        this.f456644h = "";
        C5464b r105 = new C5464b(this);
        this.f456645i = r105;
        ImSdkService.c().r8(r105);
    }
}
