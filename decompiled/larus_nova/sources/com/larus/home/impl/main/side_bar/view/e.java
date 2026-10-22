package com.larus.home.impl.main.side_bar.view;

import com.larus.home.impl.main.side_bar.data.SideBarItemType;

/* JADX INFO: loaded from: classes29.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f345081a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f345082a = null;

        static {
            int[] r100 = new int[SideBarItemType.values().length];
            r100[SideBarItemType.CONVERSATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SideBarItemType.COMPONENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f345082a = r100;
        }
    }

    static {
    }
}
