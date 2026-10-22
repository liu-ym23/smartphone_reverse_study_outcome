package com.bytedance.ee.bear.list.more.more3;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.workspace.WorkspaceAction;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WorkspaceOperationItem extends com.bytedance.ee.bear.more.protocol3.g {
    public static final /* synthetic */ int j = 0;
    public final m c;
    public final WorkspaceAction d;
    public Context e;
    public final com.bytedance.ee.bear.list.list.f.a f;
    public final Document g;
    public boolean h;
    public String i;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WorkspaceAction.values().length];
            r0[WorkspaceAction.MoveIn.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[WorkspaceAction.MoveBetween.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[WorkspaceAction.MoveOut.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements com.bytedance.ee.bear.more.protocol3.m {
        public final /* synthetic */ WorkspaceOperationItem a;

        @Override // com.bytedance.ee.bear.more.protocol3.m
        public final boolean isVisible() {
            return this.a.h;
        }

        public c(WorkspaceOperationItem r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        int r0 = b.a[this.d.ordinal()];
        if (r0 != 1) goto L5;
        com.bytedance.ee.bear.more.protocol3.f r1 = com.bytedance.ee.bear.more.protocol3.f.d.c;
    L12:
        com.bytedance.ee.bear.more.protocol3.f r4 = r1;
    L13:
        if (r4 != null) goto L15;
        return null;
    L15:
        View.OnClickListener r8 = new WorkspaceOperationItem$buildUIItem$1(this);
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r4, null, CollectionsKt.listOf(new c(this)), CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.checker.d()), r8, 2);
    L5:
        if (r0 != 2) goto L7;
        r1 = com.bytedance.ee.bear.more.protocol3.f.e.c;
        goto L12
    L7:
        if (r0 == 3) goto L9;
        r4 = null;
        goto L13
    L9:
        r1 = com.bytedance.ee.bear.more.protocol3.f.C0120f.c;
        goto L12
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g, com.bytedance.ee.bear.more.protocol3.b, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public final void create() {
        er5.b r0 = (er5.b) org.koin.java.a.c(er5.b.class, null, null, 6);
        boolean r3 = r0.j();
        boolean r6 = false;
        if (this.d != WorkspaceAction.MoveOut) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L17;
        oj5.c r5 = c();
        if (r5 == null) goto L10;
        String r7 = r5.getUrl();
    L11:
        if (r7 == null) goto L13;
        boolean r1 = !((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6)).p(r7);
    L14:
        if (r1 == false) goto L18;
        String r2 = this.c.h;
        r0.i();
        if (Intrinsics.areEqual(r2, "BitableWorkspaceView") == true) goto L17;
    L18:
        if (r3 == false) goto L24;
        if (r6 == false) goto L25;
        String r8 = k();
        if (r8 == null) goto L26;
        r0.c(this.d, r8, new WorkspaceOperationItem$create$1$1(this));
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L13:
        r1 = true;
        goto L14
    L10:
        r7 = null;
    L17:
        r6 = true;
        goto L18
    L5:
        r4 = false;
        goto L6
    }

    public final String k() {
        int r0 = t.a;
        if (t.d(this.g, new sbb.e[]{sbb.e.n}) == false) goto L5;
        String r1 = this.g.G1;
    L6:
        if (r1 != null) goto L8;
        tt5.a.d("WorkspaceOperationItem", "getToken token is null");
    L8:
        return r1;
    L5:
        r1 = this.g.d;
        goto L6
    }

    public final Context getContext() {
        return this.e;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g, com.bytedance.ee.bear.more.protocol3.b
    public final void init(com.bytedance.ee.bear.more.protocol3.h r2) {
        Intrinsics.checkNotNullParameter(r2, "hostProvider");
        Intrinsics.checkNotNullParameter(r2, "hostProvider");
        this.a = r2;
        this.e = getHost().getHostFragment().getContext();
    }

    public WorkspaceOperationItem(m r2, ce5.a r3, WorkspaceAction r4) {
        Intrinsics.checkNotNullParameter(r2, "param");
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r4, "action");
        this.c = r2;
        this.d = r4;
        this.f = r2.g;
        this.g = r2.b;
    }
}
