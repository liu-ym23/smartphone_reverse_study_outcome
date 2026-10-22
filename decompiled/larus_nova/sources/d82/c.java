package d82;

import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;
import s32.f;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements ImageRecognitionButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<Boolean> f467391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f467392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f467393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f467394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageRecognitionEntry f467395e;

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
    public final String getBtmToken(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
    public final boolean canShowRedDot() {
        if (this.f467395e == ImageRecognitionEntry.LongPressPanel) goto L5;
    L7:
        return false;
    L5:
        if (this.f467391a.getValue().booleanValue() == true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
    public final void onHide() {
        int r100 = f.f540454a;
        f.b("SimilarAnchorButton onDismiss entry=" + this.f467395e);
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
    public final void onShow() {
        int r100 = f.f540454a;
        f.b("SimilarAnchorButton onShow entry=" + this.f467395e);
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
    public final boolean canShow() {
        Boolean r100 = null;
        boolean r101 = true;
        if (jc1.a.c() == false) goto L18;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L17;
        m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L17;
        Room r104 = r103.getValue();
        if (r104 == null) goto L17;
        if (r104.isHasCommerceGoods() == true) goto L17;
        User r105 = r104.mo8271getOwner();
        if (r105 == null) goto L18;
        if (r105.isWithCommercePermission() != true) goto L18;
    L17:
        return false;
    L18:
        RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r106 == null) goto L23;
        j<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m> r107 = r106.getCompactTbLoader();
        if (r107 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r108 = r107.getValue();
    L25:
        if ((r108 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == true) goto L27;
        r108 = null;
    L27:
        if (r108 != null) goto L29;
        f.a("toolbarLoader is null");
    L36:
        return Intrinsics.areEqual(r100, Boolean.FALSE);
    L29:
        int r109 = r108.getComponentByGroupId(0);
        int r110 = r108.getComponentByGroupId(19);
        int r111 = f.f540454a;
        f.b("commonSlotComponentId=" + r109 + " microAppSlotComponentId=" + r110);
        if (r109 != (-1)) goto L34;
        if (r110 != (-1)) goto L34;
        r101 = false;
    L34:
        r100 = Boolean.valueOf(r101);
    L23:
        r108 = null;
        goto L25
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
    public final int getDescRes() {
        return this.f467393c;
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
    public final int getIconRes() {
        return this.f467394d;
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
    public final int getScene() {
        return this.f467392b;
    }

    public c(ImageRecognitionEntry r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        this.f467395e = r100;
        this.f467391a = new e("live_reg_similar_anchor_red_dot", Boolean.FALSE);
        this.f467392b = 1;
        this.f467393c = R.string.ttlive_reg_similar_anchor;
        int r101 = b.f467390a[r100.ordinal()];
        if (r101 != 1) goto L5;
        int r102 = R.drawable.ttlive_ic_reg_similar_anchor;
    L9:
        this.f467394d = r102;
        return;
    L5:
        if (r101 == 2) goto L7;
        r102 = 0;
        goto L9
    L7:
        r102 = R.drawable.ttlive_ic_image_recognition_search;
        goto L9
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        int r101 = f.f540454a;
        f.b("SimilarAnchorButton onClick entry=" + this.f467395e);
        if (canShowRedDot() == false) goto L6;
        e<Boolean> r102 = this.f467391a;
        Boolean r103 = Boolean.TRUE;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        return;
    }
}
