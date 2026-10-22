package com.bytedance.applet.impl;

import com.bytedance.ai.applet.components.input.AppletChatActionBarCapability;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.business.floatchat.api.AIChatActionBarCapability;
import com.larus.business.floatchat.api.AIChatActionBarItemLocation;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[FloatChatWindowState.values().length];
            r0[FloatChatWindowState.Collapsed.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[FloatChatWindowState.Preview.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L37:
            r0[FloatChatWindowState.Expanded.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L8:
            a = r0;
            int[] r1 = new int[AIChatActionBarItemLocation.values().length];
            r1[AIChatActionBarItemLocation.PRIMARY_BAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L31:
            r1[AIChatActionBarItemLocation.DETAIL_PANEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L11:
            b = r1;
            int[] r2 = new int[AppletChatActionBarCapability.values().length];
            r2[AppletChatActionBarCapability.OPEN_CAMERA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L33:
            r2[AppletChatActionBarCapability.MUSIC_GENERATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L25:
            r2[AppletChatActionBarCapability.IMAGE_GENERATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L15:
            c = r2;
        }
    }

    public static final dw8.b a(r2.a r2) {
        if ((r2 instanceof r2.a.c) == false) goto L6;
        return new dw8.b.c(((r2.a.c) r2).a);
    L6:
        if ((r2 instanceof r2.a.b) == false) goto L9;
        return new dw8.b.b(((r2.a.b) r2).a);
    L9:
        if ((r2 instanceof r2.a.a) == false) goto L24;
        AppletChatActionBarCapability r3 = ((r2.a.a) r2).a;
        int r4 = a.c[r3.ordinal()];
        if (r4 != 1) goto L13;
        AIChatActionBarCapability r5 = AIChatActionBarCapability.OPEN_CAMERA;
    L22:
        return new dw8.b.a(r5);
    L13:
        if (r4 != 2) goto L15;
        r5 = AIChatActionBarCapability.MUSIC_GENERATION;
        goto L22
    L15:
        if (r4 != 3) goto L18;
        r5 = AIChatActionBarCapability.IMAGE_GENERATION;
        goto L22
    L18:
        throw new NoWhenBranchMatchedException();
    L24:
        throw new NoWhenBranchMatchedException();
    }
}
