package com.larus.drive.sdk.impl.view.chat;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import va8.g0;

/* JADX INFO: loaded from: classes27.dex */
public final class DriveFloatChatContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f342054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f342055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f342056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Bundle> f342057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f342058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Fragment f342059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f342060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f342061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f342062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f342063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final n f342064k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final o f342065l;

    public interface a {
        void a(boolean r100, g0 r101);

        boolean b(String r100, boolean r101);
    }

    public static final class b {
    }

    public interface c {
        va8.r a();

        g0 b();

        com.larus.bmhome.chat.component.bottom.core.speaker.l c();

        r79.a d();

        r79.b e();

        com.larus.bmhome.chat.component.cvs.y u0();

        ICoreInputAbility v0();
    }

    static {
    }

    public final void a() {
        if (this.f342059f == null) goto L6;
        FLogger.f375446a.i("DriveFloatChatContainer", "[attach] Already attached, fragmentTag=" + this.f342055b + ", containerId=" + this.f342056c);
        return;
    L6:
        int r100 = this.f342061h + 1;
        this.f342061h = r100;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f342054a.getViewLifecycleOwner()), null, null, new DriveFloatChatContainer$attach$1(this, r100, null), 3, null);
    }

    public final void b(String r100) {
        c r101 = this.f342060g;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append(", hasProvider=");
        boolean r104 = false;
        if (r101 == null) goto L5;
        boolean r105 = true;
    L6:
        r103.append(r105);
        r103.append(", hasFold=");
        r79.a r106 = null;
        if (r101 == null) goto L9;
        g0 r107 = r101.b();
    L10:
        if (r107 == null) goto L12;
        boolean r108 = true;
    L13:
        r103.append(r108);
        r103.append(", hasCoreInput=");
        if (r101 == null) goto L16;
        ICoreInputAbility r109 = r101.v0();
    L17:
        if (r109 == null) goto L19;
        boolean r110 = true;
    L20:
        r103.append(r110);
        r103.append(", hasSpeaker=");
        if (r101 == null) goto L23;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r111 = r101.c();
    L24:
        if (r111 == null) goto L26;
        boolean r112 = true;
    L27:
        r103.append(r112);
        r103.append(", hasDriveFloat=");
        if (r101 == null) goto L30;
        r79.b r113 = r101.e();
    L31:
        if (r113 == null) goto L33;
        boolean r114 = true;
    L34:
        r103.append(r114);
        r103.append(", hasReceive=");
        if (r101 == null) goto L37;
        r106 = r101.d();
    L37:
        if (r106 == null) goto L39;
        r104 = true;
    L39:
        r103.append(r104);
        r102.i("DriveFloatChatContainer", r103.toString());
        return;
    L33:
        r114 = false;
        goto L34
    L30:
        r113 = null;
        goto L31
    L26:
        r112 = false;
        goto L27
    L23:
        r111 = null;
        goto L24
    L19:
        r110 = false;
        goto L20
    L16:
        r109 = null;
        goto L17
    L12:
        r108 = false;
        goto L13
    L9:
        r107 = null;
        goto L10
    L5:
        r105 = false;
        goto L6
    }

    public DriveFloatChatContainer(Fragment r100, Function0 r101, com.larus.drive.sdk.impl.view.preview.k r102) {
        Intrinsics.checkNotNullParameter(r100, "parentFragment");
        Intrinsics.checkNotNullParameter("drive_preview_float_chat_fragment", "fragmentTag");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f342054a = r100;
        this.f342055b = "drive_preview_float_chat_fragment";
        this.f342056c = R.id.drive_preview_float_chat_container;
        this.f342057d = r101;
        this.f342058e = r102;
        this.f342062i = true;
        this.f342063j = true;
        this.f342064k = new n(this);
        this.f342065l = new o(this);
    }
}
