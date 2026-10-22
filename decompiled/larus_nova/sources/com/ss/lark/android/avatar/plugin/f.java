package com.ss.lark.android.avatar.plugin;

import android.content.DialogInterface;
import com.ss.android.lark.pb.chatters.PutResetUserAvatarResultRequest;
import com.ss.android.lark.statistics.Statistics;
import com.ss.lark.android.avatar.statistics.AvatarHit;
import com.ss.lark.android.avatar.ui.AvatarSource;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f456653a;

    public f(b r100) {
        this.f456653a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        AvatarSource r102 = this.f456653a.f456637a;
        Map<Object, s5c.e> r103 = AvatarHit.f456660a;
        Intrinsics.checkNotNullParameter(r102, "source");
        if (r102 != AvatarSource.SELF_AVATAR) goto L5;
        Statistics.sendEvent("im_avatar_confirm_click", AvatarHit.Click.CONFIRM.plus(AvatarHit.Target.NONE).toJson());
    L5:
        b r104 = this.f456653a;
        b.b(r104, r104.f456644h, PutResetUserAvatarResultRequest.Status.RESET);
    }
}
