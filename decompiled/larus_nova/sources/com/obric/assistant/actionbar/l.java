package com.obric.assistant.actionbar;

import com.larus.bmhome.actionbar.model.AgentMode;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<com.obric.oui.dialog.v2.alert.c> f385243a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f385244a = null;

        static {
            int[] r100 = new int[AgentMode.values().length];
            r100[AgentMode.MOA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f385244a = r100;
        }
    }

    static {
    }
}
