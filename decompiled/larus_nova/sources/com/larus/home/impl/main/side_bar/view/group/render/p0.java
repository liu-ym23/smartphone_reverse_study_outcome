package com.larus.home.impl.main.side_bar.view.group.render;

import com.larus.home.impl.main.side_bar.view.group.policy.ConversationGroupPolicy;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f345701a = null;

    static {
        int[] r100 = new int[ConversationGroupPolicy.values().length];
        r100[ConversationGroupPolicy.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r100[ConversationGroupPolicy.Project.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r100[ConversationGroupPolicy.Time.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r100[ConversationGroupPolicy.Device.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        f345701a = r100;
    }
}
