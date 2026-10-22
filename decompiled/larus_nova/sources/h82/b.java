package h82;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.widget.EditText;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.SkinSelection;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardPortraitInputDialog;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.o;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.bytedance.android.livesdkapi.interact.IVSInputDialog;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import i40.h;
import j82.e;
import j82.f;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nq1.d;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends k82.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ VSMsgBoardPortraitInputDialog f484061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ f f484062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ j82.a f484063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ j82.c f484064k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ e f484065l;

    @Override // k82.a
    public final void v() {
    }

    @Override // k82.a
    public final void B() {
        VSInputPanelSectionContainer r100 = this.f484061h.f137201s;
        if (r100 == null) goto L5;
        VSInputPanelSectionContainer.d(r100, VSInputSectionType.PAID_LIVE_PACKAGE, null, 6);
    L5:
        f r101 = this.f484062i;
        if (r101 == null) goto L9;
        r101.l(VSInputSectionType.PAID_LIVE_PACKAGE);
        return;
    }

    @Override // k82.a
    public Activity getActivity() {
        return this.f484061h.getActivity();
    }

    @Override // k82.a
    public Context getContext() {
        return this.f484061h.getContext();
    }

    @Override // k82.a
    public final void p() {
        this.f484061h.dismissInputDialog();
    }

    @Override // k82.a
    public final VSInputSectionType q() {
        VSInputPanelSectionContainer r100 = this.f484061h.f137201s;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentSectionType();
    }

    @Override // k82.a
    public final DataCenter r() {
        return this.f484061h.f137185i;
    }

    @Override // k82.a
    public final t9 s() {
        return this.f484061h.f137180d;
    }

    @Override // k82.a
    public final int t() {
        VSInputPanelSectionContainer r100 = this.f484061h.f137201s;
        if (r100 != null) goto L5;
    L7:
        VSInputPanelSectionContainer r101 = this.f484061h.f137201s;
        if (r101 != null) goto L13;
        return 0;
    L13:
        return r101.getKeyboardHeight();
    L5:
        if (r100.getKeyboardHeight() != 0) goto L7;
        com.bytedance.android.livesdk.sharedpref.e<VideoResolutionItem> r102 = d.f520092a;
        return d.f520113v.getValue().intValue();
    }

    @Override // k82.a
    public final boolean u() {
        DataCenter r100 = this.f484061h.f137185i;
        if (r100 == null) goto L7;
        Boolean r101 = (Boolean) r100.get("data_is_anchor", Boolean.FALSE);
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return false;
    }

    @Override // k82.a
    public final void x() {
        VSMsgBoardPortraitInputDialog r100 = this.f484061h;
        k82.a r101 = r100.f137183g;
        if (r101 == null) goto L7;
        EditText r102 = r101.f502082a;
        if (r102 == null) goto L7;
        Editable r103 = r102.getText();
    L8:
        if (r103 != null) goto L10;
        h.a("V3 send click error, text null");
        return;
    L10:
        k82.a r104 = r100.f137183g;
        if (r104 == null) goto L37;
        EditText r105 = r104.f502082a;
        if (r105 == null) goto L38;
        Editable r106 = r105.getText();
        if (r106 == null) goto L41;
        String r107 = r106.toString();
        if (StringsKt.isBlank(r107) == false) goto L20;
        h.a("send click error, invalide content ");
        return;
    L20:
        IVSInputDialog.InputListener r108 = r100.f137181e;
        if (r108 != null) goto L24;
        h.a("V3 send click error, listener null");
        return;
    L24:
        if (r100.f137188l == true) goto L42;
        boolean r109 = true;
        r100.f137188l = true;
        Map<String, String> r110 = r100.W90();
        if (nq1.b.f520090a.getValue().booleanValue() == false) goto L33;
        k82.a r111 = r100.f137183g;
        if (r111 == null) goto L33;
        if (r111.m() != true) goto L33;
    L34:
        r108.onSendMessage(r107, r110, r109);
        return;
    L33:
        r109 = false;
        goto L34
    L42:
        return;
    L41:
        return;
    L38:
        return;
    L37:
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // k82.a
    public final void z() {
        VSInputPanelSectionContainer r100 = this.f484061h.f137201s;
        if (r100 == null) goto L5;
        VSInputPanelSectionContainer.d(r100, VSInputSectionType.EMOJI, null, 6);
    L5:
        f r101 = this.f484062i;
        if (r101 == null) goto L9;
        r101.l(VSInputSectionType.EMOJI);
        return;
    }

    @Override // k82.a
    public final void A() {
        k();
        VSInputPanelSectionContainer r100 = this.f484061h.f137201s;
        if (r100 == null) goto L5;
        VSInputPanelSectionContainer.d(r100, VSInputSectionType.KEYBOARD, null, 6);
    L5:
        f r101 = this.f484062i;
        if (r101 == null) goto L9;
        r101.l(VSInputSectionType.KEYBOARD);
        return;
    }

    @Override // k82.a
    public final void C(String r100) {
        VSMsgBoardPortraitInputDialog r101 = this.f484061h;
        SkinSelection r102 = r101.f137204v;
        if (r102 == null) goto L9;
        t9 r103 = r101.f137180d;
        if (r103 == null) goto L7;
        DataCenter r104 = r103.f114228l;
    L8:
        r102.f137178d = SkinSelection.DressType.BADGE;
        r102.f137176b = r100;
        r102.b(r104);
        goto L9
    L7:
        r104 = null;
    L9:
        j82.a r105 = this.f484063j;
        if (r105 == null) goto L12;
        r105.f(this.f484061h.f137204v);
    L12:
        f r106 = this.f484062i;
        if (r106 == null) goto L15;
        r106.h(this.f484061h.f137204v);
    L15:
        j82.c r107 = this.f484064k;
        if (r107 == null) goto L19;
        r107.n(this.f484061h.f137204v);
        return;
    }

    @Override // k82.a
    public final void D(String r100) {
        VSMsgBoardPortraitInputDialog r101 = this.f484061h;
        SkinSelection r102 = r101.f137204v;
        if (r102 == null) goto L9;
        t9 r103 = r101.f137180d;
        if (r103 == null) goto L7;
        DataCenter r104 = r103.f114228l;
    L8:
        r102.f137178d = SkinSelection.DressType.SKIN;
        r102.f137175a = r100;
        r102.b(r104);
        goto L9
    L7:
        r104 = null;
    L9:
        j82.a r105 = this.f484063j;
        if (r105 == null) goto L12;
        r105.f(this.f484061h.f137204v);
    L12:
        f r106 = this.f484062i;
        if (r106 == null) goto L15;
        r106.h(this.f484061h.f137204v);
    L15:
        j82.c r107 = this.f484064k;
        if (r107 == null) goto L19;
        r107.n(this.f484061h.f137204v);
        return;
    }

    @Override // k82.a
    public final void w(boolean r100) {
        if (r100 == false) goto L32;
        int r101 = n82.c.f518247a;
        t9 r102 = this.f484061h.f137180d;
        SkinSelection.DressType r103 = null;
        if (r102 == null) goto L6;
        DataCenter r104 = r102.f114228l;
    L7:
        com.bytedance.android.livesdk.chatroom.msgboard.b r105 = n82.c.i(r104);
        if (r105 == null) goto L10;
        List<VSMsgBoardDress> r106 = r105.a();
    L12:
        if (CollectionUtils.isEmpty(r106) == true) goto L19;
        if (r105 == null) goto L15;
        List<VSMsgBoardDress> r107 = r105.c();
    L17:
        if (CollectionUtils.isEmpty(r107) == true) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == false) goto L32;
        SkinSelection r109 = this.f484061h.f137204v;
        if (r109 == null) goto L25;
        r103 = r109.f137178d;
    L25:
        if (r103 != SkinSelection.DressType.BADGE) goto L29;
        e r110 = this.f484065l;
        if (r110 == null) goto L36;
        r110.j(r100);
        return;
    L36:
        return;
    L29:
        e r111 = this.f484065l;
        if (r111 == null) goto L38;
        r111.scrollToTop(r100);
        return;
    L38:
        return;
    L15:
        r107 = null;
    L19:
        r108 = false;
        goto L20
    L10:
        r106 = null;
        goto L12
    L6:
        r104 = null;
    L32:
        e r112 = this.f484065l;
        if (r112 == null) goto L40;
        r112.scrollToTop(r100);
        return;
    }

    @Override // k82.a
    public final void y(o r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        VSInputPanelSectionContainer r101 = this.f484061h.f137201s;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.f137231j.add(r100);
        return;
    }

    public b(VSMsgBoardPortraitInputDialog r100, f r101, j82.a r102, j82.c r103, e r104, j82.d r105, j82.b r106, j82.a r107, j82.d r108, j82.b r110, j82.c r111, e r112, f r113) {
        this.f484061h = r100;
        this.f484062i = r101;
        this.f484063j = r102;
        this.f484064k = r103;
        this.f484065l = r104;
        super(r107, r108, r110, r111, r112, r113);
    }
}
