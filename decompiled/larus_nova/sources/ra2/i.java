package ra2;

import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.ConfrontMsgView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.GroupMsgView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements qa2.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConfrontMsgView f536822a;

    @Override // qa2.l
    public final void a() {
        GroupMsgView r100 = this.f536822a.f140061b;
        Boolean r101 = null;
        if (r100 == null) goto L5;
        Boolean r102 = r100.getImgLoadStatus();
    L6:
        Boolean r103 = Boolean.FALSE;
        if (Intrinsics.areEqual(r102, r103) == true) goto L13;
        GroupMsgView r104 = this.f536822a.f140062c;
        if (r104 == null) goto L12;
        r101 = r104.getImgLoadStatus();
    L12:
        if (Intrinsics.areEqual(r101, r103) == true) goto L13;
        return;
    L13:
        pa2.a r105 = this.f536822a.f140063d;
        if (r105 == null) goto L18;
        r105.a();
        return;
    L18:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // qa2.l
    public final void b() {
        GroupMsgView r100 = this.f536822a.f140061b;
        Boolean r101 = null;
        if (r100 == null) goto L5;
        Boolean r102 = r100.getImgLoadStatus();
    L6:
        Boolean r103 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r103) == false) goto L17;
        GroupMsgView r104 = this.f536822a.f140062c;
        if (r104 == null) goto L12;
        r101 = r104.getImgLoadStatus();
    L12:
        if (Intrinsics.areEqual(r101, r103) == false) goto L18;
        pa2.a r105 = this.f536822a.f140063d;
        if (r105 == null) goto L19;
        r105.b();
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // qa2.l
    public final void c() {
        GroupMsgView r100 = this.f536822a.f140061b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getBattleEnd() != true) goto L40;
        GroupMsgView r101 = this.f536822a.f140062c;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.getBattleEnd() != true) goto L42;
        GroupMsgView r102 = this.f536822a.f140061b;
        if (r102 == null) goto L13;
        r102.setBattleEnd(false);
    L13:
        GroupMsgView r103 = this.f536822a.f140062c;
        if (r103 == null) goto L16;
        r103.setBattleEnd(false);
    L16:
        ConfrontMsgView r104 = this.f536822a;
        int r105 = r104.f140076q;
        if (r105 != r104.f140073n) goto L26;
        GroupMsgView r106 = r104.f140061b;
        if (r106 == null) goto L21;
        r106.n();
    L21:
        GroupMsgView r107 = this.f536822a.f140062c;
        if (r107 == null) goto L24;
        r107.n();
    L24:
        this.f536822a.getClass();
        return;
    L26:
        if (r105 != r104.f140075p) goto L33;
        GroupMsgView r108 = r104.f140061b;
        if (r108 == null) goto L30;
        r108.i();
    L30:
        GroupMsgView r109 = this.f536822a.f140062c;
        if (r109 == null) goto L44;
        r109.i();
        return;
    L44:
        return;
    L33:
        if (r105 != 0) goto L36;
        r104.post(r104.f140067h);
        return;
    L36:
        if (r105 != r104.f140074o) goto L47;
        r104.post(r104.f140068i);
        return;
    L47:
        return;
    L42:
        return;
    }

    @Override // qa2.l
    public final void d() {
        GroupMsgView r100 = this.f536822a.f140061b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getWebpEntered() != true) goto L13;
        GroupMsgView r101 = this.f536822a.f140062c;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.getWebpEntered() != true) goto L15;
        ConfrontMsgView r102 = this.f536822a;
        r102.f140076q = r102.f140074o;
        r102.post(r102.f140068i);
        return;
    L15:
        return;
    }

    @Override // qa2.l
    public final void e() {
        GroupMsgView r100 = this.f536822a.f140061b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getEntered() != true) goto L13;
        GroupMsgView r101 = this.f536822a.f140062c;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.getEntered() != true) goto L15;
        ConfrontMsgView r102 = this.f536822a;
        r102.post(r102.f140067h);
        return;
    L15:
        return;
    }

    @Override // qa2.l
    public final void onEnd() {
        ConfrontMsgView r100 = this.f536822a;
        GroupMsgView r101 = r100.f140061b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getDismissed() != true) goto L15;
        GroupMsgView r102 = r100.f140062c;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.getDismissed() != true) goto L17;
        pa2.a r103 = r100.f140063d;
        if (r103 == null) goto L18;
        r103.onDismiss();
        return;
    L18:
        return;
    L17:
        return;
    }

    public i(ConfrontMsgView r100) {
        this.f536822a = r100;
    }
}
