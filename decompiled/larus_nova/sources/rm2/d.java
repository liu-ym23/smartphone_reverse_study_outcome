package rm2;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.microom.api.GrabOnOffStatus;
import com.bytedance.android.livesdk.microom.dialog.OChannelGrabMicShowDialog;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OChannelGrabMicShowDialog f538531a;

    public d(OChannelGrabMicShowDialog r100) {
        this.f538531a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        GrabOnOffStatus r101 = this.f538531a.f153816a;
        int r102 = a.f538526a[r101.ordinal()];
        if (r102 != 1) goto L5;
        OChannelGrabMicShowDialog r103 = this.f538531a;
        r103.f153816a = GrabOnOffStatus.CLOSE_ON_OFF;
        ImageView r104 = (ImageView) r103.findViewById(R.id.mic_room_never_notice);
        if (r104 == null) goto L16;
        r104.setBackground(s1.m(R.drawable.ttlive_bg_official_channel_grab_mic_show_never_notice_selected));
        return;
    L16:
        return;
    L5:
        if (r102 != 2) goto L17;
        OChannelGrabMicShowDialog r105 = this.f538531a;
        r105.f153816a = GrabOnOffStatus.OPEN_ON_OFF;
        ImageView r106 = (ImageView) r105.findViewById(R.id.mic_room_never_notice);
        if (r106 == null) goto L14;
        r106.setBackground(s1.m(R.drawable.ttlive_bg_official_channel_grab_mic_show_never_notice_unselected));
        return;
    L14:
        return;
    }
}
