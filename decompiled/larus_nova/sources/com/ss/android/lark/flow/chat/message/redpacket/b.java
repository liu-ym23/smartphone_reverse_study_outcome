package com.ss.android.lark.flow.chat.message.redpacket;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.larus.nova.R;
import com.ss.android.lark.flow.chat.databinding.FlowChatMessageV2BlockRedPacketContentBinding;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowRedPacketContentBlock f422667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowChatMessageV2BlockRedPacketContentBinding f422668b;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        if ((r101 instanceof BitmapDrawable) == false) goto L7;
        Bitmap r102 = ((BitmapDrawable) r101).getBitmap();
        byte[] r103 = BitmapFactory.decodeResource(this.f422667a.getContext().getResources(), R.drawable.fc_red_packet_message_cell_display_name_bg).getNinePatchChunk();
        this.f422668b.f422128c.setBackground(new NinePatchDrawable(this.f422667a.getContext().getResources(), r102, r103, new Rect(), null));
        return;
    }

    public b(FlowRedPacketContentBlock r100, FlowChatMessageV2BlockRedPacketContentBinding r101) {
        this.f422667a = r100;
        this.f422668b = r101;
    }
}
