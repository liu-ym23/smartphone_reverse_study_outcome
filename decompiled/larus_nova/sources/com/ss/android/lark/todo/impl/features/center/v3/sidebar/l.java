package com.ss.android.lark.todo.impl.features.center.v3.sidebar;

import androidx.lifecycle.Observer;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;

/* JADX INFO: loaded from: classes38.dex */
public final class l<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoSidebarFragment f441722a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441723a = null;

        static {
            int[] r100 = new int[ContainerType.values().length];
            r100[ContainerType.OWNED_BY_ME_CONTAINER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ContainerType.FOLLOWED_BY_ME_CONTAINER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f441723a = r100;
        }
    }

    public l(TodoSidebarFragment r100) {
        this.f441722a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ContainerType r101 = (ContainerType) r100;
        if (r101 == ContainerType.UNKNOWN) goto L18;
        if (r101 != null) goto L7;
        int r102 = -1;
    L9:
        if (r102 != 1) goto L11;
        this.f441722a.V90().setSelected(true);
        this.f441722a.aa0().getPaint().setFakeBoldText(true);
        this.f441722a.U90().setSelected(false);
        this.f441722a.Z90().getPaint().setFakeBoldText(false);
        this.f441722a.T90().setSelected(false);
        this.f441722a.Y90().getPaint().setFakeBoldText(false);
        this.f441722a.W90().y2(null, null);
        return;
    L11:
        if (r102 == 2) goto L13;
        this.f441722a.V90().setSelected(false);
        this.f441722a.aa0().getPaint().setFakeBoldText(false);
        this.f441722a.U90().setSelected(false);
        this.f441722a.Z90().getPaint().setFakeBoldText(false);
        this.f441722a.T90().setSelected(false);
        this.f441722a.Y90().getPaint().setFakeBoldText(false);
        this.f441722a.W90().y2(r101, null);
        return;
    L13:
        this.f441722a.V90().setSelected(false);
        this.f441722a.aa0().getPaint().setFakeBoldText(false);
        this.f441722a.U90().setSelected(true);
        this.f441722a.Z90().getPaint().setFakeBoldText(true);
        this.f441722a.T90().setSelected(false);
        this.f441722a.Y90().getPaint().setFakeBoldText(false);
        this.f441722a.W90().y2(null, null);
        return;
    L7:
        r102 = a.f441723a[r101.ordinal()];
        goto L9
    }
}
