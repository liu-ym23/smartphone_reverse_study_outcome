package com.larus.office.plugins.preview;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.office.preview.OfficeDrivePreviewAiInputState;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f363223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f363224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f363225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Bundle> f363226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OfficeDrivePreviewChatSessionAbility f363227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f363228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f363229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Fragment f363230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f363231i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f363232j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f363233k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f363234l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f363235m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f363236n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f363237o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f363238p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public OfficeDrivePreviewAiInputState f363239q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f363240r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f0 f363241s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final g0 f363242t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final n f363243u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v f363244v;

    public interface a {
        void a(boolean r100, va8.g0 r101);

        boolean b(String r100, boolean r101);

        void c(OfficeDrivePreviewAiInputState r100);
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f363245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f363246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f363247c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f363245a, r101.f363245a) == true) goto L12;
            return false;
        L12:
            if (this.f363246b == r101.f363246b) goto L15;
            return false;
        L15:
            if (this.f363247c == r101.f363247c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f363245a.hashCode() * 31) + this.f363246b) * 31;
            long r101 = this.f363247c;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "PendingUnreadAutoOpen(conversationId=" + this.f363245a + ", attachVersion=" + this.f363246b + ", readMessageIndex=" + this.f363247c + ')';
        }

        public c(String r100, int r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            this.f363245a = r100;
            this.f363246b = r101;
            this.f363247c = r102;
        }
    }

    public interface d {
        va8.r a();

        va8.g0 b();

        com.larus.bmhome.chat.component.bottom.core.speaker.l c();

        va8.p d();

        com.larus.bmhome.chat.component.bottom.reference.a g5();

        ICoreInputAbility v0();

        va8.o w0();
    }

    static {
    }

    public final void a() {
        d r100 = this.f363231i;
        if (r100 == null) goto L7;
        ICoreInputAbility r101 = r100.v0();
        if (r101 == null) goto L7;
        r101.setEnabled(this.f363234l);
    L7:
        d r102 = this.f363231i;
        if (r102 == null) goto L13;
        va8.g0 r103 = r102.b();
        if (r103 == null) goto L13;
        r103.Iq(this.f363234l);
    L13:
        if (this.f363234l == true) goto L21;
        d r104 = this.f363231i;
        if (r104 == null) goto L19;
        va8.g0 r105 = r104.b();
        if (r105 == null) goto L19;
        r105.km("drive_input_disabled");
    L19:
        this.f363236n = false;
        c(false);
        return;
    }

    public final void b() {
        d r100 = this.f363231i;
        if (r100 == null) goto L15;
        com.larus.bmhome.chat.component.bottom.reference.a r101 = r100.g5();
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f363240r.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        r101.Dk(this.f363240r);
        return;
    L13:
        r101.NR();
        return;
    L10:
        r102 = false;
        goto L11
    }

    public final String d() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        FragmentManager r101 = this.f363223a.getChildFragmentManager();     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl("stateSaved=" + r101.isStateSaved() + ", managedFragment=" + f(r101.findFragmentByTag(this.f363224b)));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        r102 = "unavailable=".concat(r103.getClass().getSimpleName());
    L12:
        return (String) r102;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void e() {
        c r100 = this.f363233k;
        if (r100 != null) goto L5;
        return;
    L5:
        l r101 = this.f363227e.f363151e;
        if (r101 == null) goto L8;
        wc9.e r102 = r101.f363211a;
    L9:
        if (r102 == null) goto L11;
        String r103 = r102.f559198a;
    L13:
        if (r100.f363246b == this.f363232j) goto L15;
    L42:
        FLogger.f375446a.i("OfficeDrivePreviewFloatChat", "[openPendingUnreadConversationIfNeeded] clear stale request, pendingVersion=" + r100.f363246b + ", currentVersion=" + this.f363232j + ", conversationMatched=" + Intrinsics.areEqual(r103, r100.f363245a));
        this.f363233k = null;
        return;
    L15:
        if (Intrinsics.areEqual(r103, r100.f363245a) == false) goto L42;
        Fragment r104 = this.f363230h;
        boolean r105 = false;
        if (r104 != null) goto L20;
    L22:
        boolean r106 = false;
    L23:
        d r107 = this.f363231i;
        if (r107 == null) goto L26;
        va8.g0 r108 = r107.b();
    L28:
        if (this.f363234l == false) goto L37;
        if (r106 == false) goto L37;
        if (r108 == null) goto L37;
        boolean r109 = r108.YC();
        if (r109 == true) goto L35;
        r108.expand("office_conversation_red_dot");
    L35:
        this.f363233k = null;
        FLogger.f375446a.i("OfficeDrivePreviewFloatChat", "[openPendingUnreadConversationIfNeeded] consumed, expandedBefore=" + r109 + ", readMessageIndex=" + r100.f363247c + ", conversationHash=" + r100.f363245a.hashCode() + ", version=" + this.f363232j);
        return;
    L37:
        FLogger r110 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder("[openPendingUnreadConversationIfNeeded] deferred, inputEnabled=");
        r111.append(this.f363234l);
        r111.append(", fragmentReady=");
        r111.append(r106);
        r111.append(", hasFoldAbility=");
        if (r108 == null) goto L40;
        r105 = true;
    L40:
        r111.append(r105);
        r111.append(", version=");
        r111.append(this.f363232j);
        r110.i("OfficeDrivePreviewFloatChat", r111.toString());
        return;
    L26:
        r108 = null;
        goto L28
    L20:
        if (r104.isAdded() != true) goto L22;
        r106 = true;
        goto L23
    L11:
        r103 = null;
        goto L13
    L8:
        r102 = null;
        goto L9
    }

    public final void g() {
        d r100 = this.f363231i;
        if (r100 == null) goto L5;
        va8.o r101 = r100.w0();
    L6:
        boolean r102 = true;
        if (r101 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == true) goto L21;
        if (r101 != null) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == true) goto L21;
        r102 = false;
        goto L21
    L15:
        if (r101.n5() != true) goto L17;
        r104 = true;
    L21:
        this.f363238p = r102;
        c(false);
        return;
    L9:
        if (r101.w() != true) goto L11;
        r103 = true;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public static String f(Fragment r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        StringBuilder r101 = new StringBuilder("identity=");
        r101.append(System.identityHashCode(r100));
        r101.append(", added=");
        r101.append(r100.isAdded());
        r101.append(", detached=");
        r101.append(r100.isDetached());
        r101.append(", removing=");
        r101.append(r100.isRemoving());
        r101.append(", viewCreated=");
        boolean r102 = false;
        if (r100.getView() == null) goto L8;
        boolean r103 = true;
    L9:
        r101.append(r103);
        r101.append(", viewShown=");
        View r104 = r100.getView();
        if (r104 != null) goto L12;
    L14:
        r101.append(r102);
        return r101.toString();
    L12:
        if (r104.isShown() != true) goto L14;
        r102 = true;
        goto L14
    L8:
        r103 = false;
        goto L9
    }

    public final void c(boolean r100) {
        if (this.f363230h != null) goto L5;
    L17:
        OfficeDrivePreviewAiInputState r101 = OfficeDrivePreviewAiInputState.Hidden;
    L18:
        if (r100 == false) goto L20;
    L22:
        this.f363239q = r101;
        FLogger.f375446a.i("OfficeDrivePreviewFloatChat", "[dispatchInputState] state=" + r101 + ", active=" + r101.getInteractionActive());
        this.f363229g.c(r101);
        return;
    L20:
        if (r101 != this.f363239q) goto L22;
        return;
    L5:
        if (this.f363231i == null) goto L17;
        if (this.f363237o == false) goto L11;
        r101 = OfficeDrivePreviewAiInputState.Voice;
        goto L18
    L11:
        if (this.f363238p == false) goto L14;
        r101 = OfficeDrivePreviewAiInputState.Keyboard;
        goto L18
    L14:
        if (this.f363236n == false) goto L16;
        r101 = OfficeDrivePreviewAiInputState.Expanded;
        goto L18
    L16:
        r101 = OfficeDrivePreviewAiInputState.Collapsed;
        goto L18
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedText");
        this.f363240r = r100;
        b();
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("[updateSelectionReference] selectedTextLength=");
        r102.append(r100.length());
        r102.append(", hasReferenceAbility=");
        d r103 = this.f363231i;
        if (r103 == null) goto L5;
        com.larus.bmhome.chat.component.bottom.reference.a r104 = r103.g5();
    L6:
        if (r104 == null) goto L8;
        boolean r105 = true;
    L9:
        r102.append(r105);
        r101.i("OfficeDrivePreviewFloatChat", r102.toString());
        return;
    L8:
        r105 = false;
        goto L9
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.office.plugins.preview.n] */
    public s(Fragment r100, int r101, Function0 r102, OfficeDrivePreviewChatSessionAbility r103, boolean r104, j0 r105) {
        Intrinsics.checkNotNullParameter(r100, "parentFragment");
        Intrinsics.checkNotNullParameter("office_drive_preview_float_chat", "fragmentTag");
        Intrinsics.checkNotNullParameter(r102, "bundleCreator");
        Intrinsics.checkNotNullParameter(r103, "sessionAbility");
        Intrinsics.checkNotNullParameter(r105, "callback");
        this.f363223a = r100;
        this.f363224b = "office_drive_preview_float_chat";
        this.f363225c = r101;
        this.f363226d = r102;
        this.f363227e = r103;
        this.f363228f = r104;
        this.f363229g = r105;
        this.f363234l = true;
        this.f363235m = true;
        this.f363239q = OfficeDrivePreviewAiInputState.Hidden;
        this.f363240r = "";
        this.f363241s = new f0(this);
        this.f363242t = new g0(this);
        this.f363243u = new n(this);
        this.f363244v = new v(this);
    }
}
