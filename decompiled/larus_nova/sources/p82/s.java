package p82;

import android.view.View;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.d4;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class s extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f528156e;

    @Override // p82.a
    public final int e() {
        return R.layout.ttlive_ps_panel_item_open_profile;
    }

    public s() {
        super(PanelItemSymbol.OPEN_PROFILE_SYMBOL);
        this.f528156e = d4.f121932a.getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        com.bytedance.android.live.base.model.message.t r101 = r100.f133174b;
        IBaseUser r102 = null;
        if ((r101 instanceof u3) == true) goto L5;
        r101 = null;
    L5:
        u3 r103 = (u3) r101;
        if (r103 == null) goto L8;
        r102 = r103.getUserInMessage();
    L8:
        if (r102 == null) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r100) {
        super.onClick(r100);
        com.bytedance.android.livesdk.interactivity.api.entity.l r101 = this.f528071b;
        com.bytedance.android.live.base.model.message.t r102 = null;
        if (r101 == null) goto L5;
        com.bytedance.android.live.base.model.message.t r103 = r101.f133174b;
    L7:
        if ((r103 instanceof u3) == false) goto L10;
        r102 = r103;
    L10:
        u3 r104 = (u3) r102;
        if (r104 == null) goto L27;
        IBaseUser r105 = r104.getUserInMessage();
        if (r105 != null) goto L16;
        return;
    L16:
        if (this.f528156e.booleanValue() == false) goto L22;
        com.bytedance.android.livesdk.interactivity.api.entity.l r106 = this.f528071b;
        if (r106 == null) goto L23;
        com.bytedance.android.live.base.model.message.t r107 = r106.f133174b;
        if (r107 == null) goto L23;
        xs2.b.a().post(com.bytedance.android.livesdk.interactivity.textmessage.utils.e.a(r107, r105, false));
    L23:
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r108 = this.f528072c;
        if (r108 == null) goto L28;
        r108.dismissDialog();
        return;
    L28:
        return;
    L22:
        UserProfileEvent r109 = new UserProfileEvent(r105);
        r109.mSource = "personal_profile";
        r109.setClickUserPosition("personal_profile");
        xs2.b.a().post(r109);
        goto L23
    L27:
        return;
    L5:
        r103 = null;
        goto L7
    }
}
