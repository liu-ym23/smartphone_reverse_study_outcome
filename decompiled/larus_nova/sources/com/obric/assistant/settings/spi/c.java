package com.obric.assistant.settings.spi;

import com.bytedance.applet.aibridge.p;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f392389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f392390b;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f392389a, r101.f392389a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f392390b, r101.f392390b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f392389a.hashCode() * 31) + this.f392390b.hashCode();
    }

    public final String toString() {
        return "ObricSettingGroup(id=" + this.f392389a + ", visible=" + this.f392390b + ')';
    }

    public final int a() {
        int r100 = d.f392391a;
        String r101 = this.f392389a;
        Intrinsics.checkNotNullParameter(r101, "groupId");
        switch(r101.hashCode()) {
            case -2067993225: goto L54;
            case -1600753048: goto L50;
            case -1558888761: goto L46;
            case -723643722: goto L42;
            case -248242558: goto L38;
            case -33200485: goto L34;
            case 1038025258: goto L30;
            case 1104617330: goto L26;
            case 1140764727: goto L22;
            case 1509214476: goto L18;
            case 1536425978: goto L14;
            case 1653763995: goto L10;
            case 1898139772: goto L6;
            default: goto L57;
        };
    L57:
        return 0;
    L6:
        if (r101.equals("group_desktop_icon") == false) goto L57;
        return 40;
    L10:
        if (r101.equals("group_dora_entrance") == false) goto L57;
        return 70;
    L14:
        if (r101.equals("group_continue_speak") == false) goto L57;
        return 95;
    L18:
        if (r101.equals("group_cocreation_review") == false) goto L57;
        return 45;
    L22:
        if (r101.equals("group_auto_end_conversation") == false) goto L57;
        return 75;
    L26:
        if (r101.equals("group_voice") == false) goto L57;
        return 100;
    L30:
        if (r101.equals("group_user_experience_plan") == false) goto L57;
        return 5;
    L34:
        if (r101.equals("group_preference") == false) goto L57;
        return 50;
    L38:
        if (r101.equals("group_use_locked") == false) goto L57;
        return 90;
    L42:
        if (r101.equals("group_ai_lab") == false) goto L57;
        return 55;
    L46:
        if (r101.equals("group_global_assistant_experience") == false) goto L57;
        return 110;
    L50:
        if (r101.equals("group_memory_data") == false) goto L57;
        return 60;
    L54:
        if (r101.equals("group_auto_gui_settings") == false) goto L57;
        return 80;
    }

    public c(String r100) {
        p r101 = new p();
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "visible");
        this.f392389a = r100;
        this.f392390b = r101;
    }
}
