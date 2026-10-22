package com.bytedance.ee.bear.list.more.more3;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.folder.MyRootFolderDeleteItemV2;
import com.bytedance.ee.bear.list.folder.MyRootFolderMoveItemV2;
import com.bytedance.ee.bear.list.folder.SubFolderDeleteItemV2;
import com.bytedance.ee.bear.list.folder.SubFolderMoveItemV2;
import com.bytedance.ee.bear.list.more.itemv2.DeleteItemV2;
import com.bytedance.ee.bear.list.more.itemv2.MoveItemV2;
import com.bytedance.ee.bear.list.more.itemv2.OpenFileItemV2;
import com.bytedance.ee.bear.list.more.itemv2.SetHiddenItemV2;
import com.bytedance.ee.bear.list.more.itemv2.ShareItemV2;
import com.bytedance.ee.bear.list.rename.RenameItemV2;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem;
import com.bytedance.ee.util.info.AppInfoUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SpaceMoreItemFactory {
    public final m a;
    public final ce5.a b;
    public final FragmentActivity c;
    public final Document d;
    public final boolean e;
    public final String f;
    public final com.bytedance.ee.bear.list.list.f.a g;
    public final AccountService.Account h;
    public final String i;
    public final ShareFolderUserPermission j;
    public final Fragment k;
    public final String l;
    public final Boolean m;
    public final int n;
    public final Lazy o;

    public static IBaseMoreItem m() {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).N();
    }

    public static boolean u() {
        return com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
    }

    public final IBaseMoreItem b() {
        com.bytedance.ee.bear.more.b r0 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        FragmentActivity r1 = this.c;
        CommonMoreItemId r2 = CommonMoreItemId.ADD_SHORT_CUT;
        ce5.a r3 = this.b;
        return r0.q(r1, r2, r3.d, r3.f);
    }

    public final IBaseMoreItem c() {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).A(t0.o(this.e), this.i);
    }

    public final DeleteItemV2 d() {
        String r0 = this.f;
        int r1 = 2131887958;
        if (r0 != null) goto L5;
    L56:
        Document r4 = this.d;
        String r5 = this.f;
        if (r5 == null) goto L106;
        switch(r5.hashCode()) {
            case -1463729724: goto L100;
            case -1263485614: goto L94;
            case 38791932: goto L86;
            case 163501532: goto L83;
            case 209222858: goto L80;
            case 689938049: goto L77;
            case 1096164794: goto L74;
            case 1190550482: goto L71;
            case 1570801228: goto L65;
            case 1705855756: goto L62;
            default: goto L106;
        };
    L62:
        if (r5.equals("HistorySharedFolderView") == false) goto L106;
    L97:
        if (TextUtils.equals(this.d.e, ((b0) org.koin.java.a.c(b0.class, null, null, 6)).getUid()) == false) goto L108;
    L98:
        r1 = 2131887736;
    L109:
        DeleteItemV2 r2 = new DeleteItemV2(r4, r1, p(), this.g);
    L110:
        return r2;
    L108:
        r1 = Integer.MAX_VALUE;
        goto L109
    L65:
        if (r5.equals("MyDocumentView") == false) goto L106;
        if (this.e == false) goto L108;
    L71:
        if (r5.equals("NewShareFolderView") == true) goto L97;
    L74:
        if (r5.equals("PinView") == true) goto L108;
    L77:
        if (r5.equals("FavoriteView") == false) goto L106;
    L80:
        if (r5.equals("SharedView") == true) goto L108;
    L83:
        if (r5.equals("NewShareHiddenFolderView") == true) goto L97;
    L86:
        if (r5.equals("AINotesListView") == false) goto L106;
        if (this.e == false) goto L108;
        if (Intrinsics.areEqual(this.i, "ai_note_owned_by_me") == false) goto L108;
    L94:
        if (r5.equals("ShareFolderView") == true) goto L97;
    L100:
        if (r5.equals("FolderDetailView") == false) goto L106;
        if (q() == false) goto L108;
    L106:
        if (this.e == false) goto L108;
    L5:
        switch(r0.hashCode()) {
            case -458371555: goto L32;
            case 498065011: goto L21;
            case 680447905: goto L11;
            case 1264656507: goto L8;
            default: goto L56;
        };
    L8:
        if (r0.equals("RecentDocumentView") == false) goto L56;
    L34:
        Document r10 = this.d;
        if (this.e == false) goto L45;
        String r3 = this.b.b.b;
        String r6 = this.f;
        if (Intrinsics.areEqual(r6, "ManualOfflineDocumentView") == false) goto L40;
    L44:
        int r11 = r1;
    L46:
        String r7 = this.b.b.b;
        String r8 = this.f;
        if (Intrinsics.areEqual(r8, "ManualOfflineDocumentView") == false) goto L50;
    L54:
        int r12 = 2131255224;
    L55:
        r2 = new DeleteItemV2(r10, r11, r12, p(), this.g);
        goto L110
    L50:
        if (Intrinsics.areEqual(r8, "RecentDocumentView") == false) goto L54;
        if (a(r7) == false) goto L54;
        r12 = 2131254201;
        goto L55
    L40:
        if (Intrinsics.areEqual(r6, "RecentDocumentView") == false) goto L44;
        if (a(r3) == false) goto L44;
        r1 = 2131887736;
        goto L44
    L45:
        r11 = Integer.MAX_VALUE;
        goto L46
    L11:
        if (r0.equals("MyRootFolderView") == false) goto L56;
        Document r9 = this.d;
        boolean r13 = this.e;
        if (NodeType.isShortcut(r9.M1) == true) goto L15;
        int r14 = 2131887736;
    L19:
        r2 = new MyRootFolderDeleteItemV2(r9, r13, r14, p(), this.g);
        goto L110
    L15:
        if (AppInfoUtils.f().booleanValue() == false) goto L17;
        r14 = 2131889420;
        goto L19
    L17:
        r14 = 2131887529;
        goto L19
    L21:
        if (r0.equals("SubFolderView") == false) goto L56;
        Document r15 = this.d;
        if (NodeType.isShortcut(r15.M1) == true) goto L26;
        int r16 = 2131887736;
    L30:
        r2 = new SubFolderDeleteItemV2(r15, r16, this.e, this.l, this.j, p(), this.g);
        goto L110
    L26:
        if (AppInfoUtils.f().booleanValue() == false) goto L28;
        r16 = 2131889420;
        goto L30
    L28:
        r16 = 2131887529;
        goto L30
    L32:
        if (r0.equals("ManualOfflineDocumentView") == true) goto L34;
        goto L34
    }

    public final IBaseMoreItem e() {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).a(this.c);
    }

    public final SetHiddenItemV2 f() {
        FragmentActivity r1 = this.c;
        Document r2 = this.d;
        String r3 = t0.o(this.e);
        String r4 = this.i;
        if (Intrinsics.areEqual(this.f, "NewShareFolderView") == false) goto L5;
    L8:
        boolean r5 = true;
    L10:
        return new SetHiddenItemV2(r1, r2, r3, r4, r5);
    L5:
        if (Intrinsics.areEqual(this.f, "NewShareHiddenFolderView") == true) goto L8;
        r5 = false;
        goto L10
    }

    public final IBaseMoreItem g() {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).w(this.c, this.i);
    }

    public final com.bytedance.ee.bear.more.protocol3.b h() {
        String r0 = this.f;
        if (Intrinsics.areEqual(r0, "MyRootFolderView") == false) goto L6;
        return new MyRootFolderMoveItemV2(this.k.getContext(), this.d, this.h, u(), this.i, t0.o(this.e));
    L6:
        if (Intrinsics.areEqual(r0, "SubFolderView") == false) goto L13;
        Context r2 = this.k.getContext();
        Document r3 = this.d;
        AccountService.Account r4 = this.h;
        boolean r5 = u();
        String r6 = this.l;
        ShareFolderUserPermission r7 = this.j;
        Boolean r1 = this.m;
        if (r1 == null) goto L10;
        boolean r8 = r1.booleanValue();
    L18:
        return new SubFolderMoveItemV2(r2, r3, r4, r5, r6, r7, r8, this.i, t0.o(this.e));
    L10:
        r8 = false;
        goto L18
    L13:
        if (this.d.getType() != 16) goto L16;
        return ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).u(this.c, this.d);
    L16:
        return new MoveItemV2(this.c, this.d, this.h, u(), this.l, this.i, t0.o(this.e));
    }

    public final OpenFileItemV2 i() {
        return new OpenFileItemV2(this.c, this.d, u(), this.h, t0.o(this.e), this.i);
    }

    public final IBaseMoreItem j() {
        com.bytedance.ee.bear.more.b r0 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        FragmentActivity r1 = this.c;
        CommonMoreItemId r2 = CommonMoreItemId.PIN;
        ce5.a r3 = this.b;
        return r0.q(r1, r2, r3.d, r3.f);
    }

    public final RenameItemV2 k() {
        return new RenameItemV2(this.k, this.d, u(), this.h, t0.o(this.e), this.i, this.b);
    }

    public final IBaseMoreItem l() {
        com.bytedance.ee.bear.more.b r0 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        FragmentActivity r1 = this.c;
        CommonMoreItemId r2 = CommonMoreItemId.REPORT;
        ce5.a r3 = this.b;
        return r0.q(r1, r2, r3.d, r3.f);
    }

    public final ShareItemV2 n() {
        FragmentActivity r1 = this.c;
        Document r2 = this.d;
        AccountService.Account r3 = this.h;
        boolean r4 = this.e;
        String r5 = this.i;
        m r0 = this.a;
        return new ShareItemV2(r1, r2, r3, r4, r5, r0.e, r0.a);
    }

    public final IBaseMoreItem o() {
        com.bytedance.ee.bear.more.b r0 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        FragmentActivity r1 = this.c;
        CommonMoreItemId r2 = CommonMoreItemId.STAR;
        ce5.a r3 = this.b;
        return r0.q(r1, r2, r3.d, r3.f);
    }

    public final boolean p() {
        return ((Boolean) this.o.getValue()).booleanValue();
    }

    public final boolean q() {
        Document r0 = this.d;
        if (r0.n == false) goto L8;
        if (TextUtils.equals(r0.e, ((b0) org.koin.java.a.c(b0.class, null, null, 6)).getUid()) == true) goto L8;
        return false;
    L8:
        if (this.e == false) goto L21;
        Document r1 = this.d;
        String[] r2 = t0.a;
        if (FolderVersion.isShareFolderV1(r1.L1) == true) goto L12;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == false) goto L22;
        return true;
    L22:
        return false;
    L12:
        if (qc5.a.b(r1.L1) == true) goto L17;
        if (r1.U > 1) goto L17;
        r3 = false;
        goto L18
    L21:
        return false;
    }

    public final boolean r() {
        if (Intrinsics.areEqual(this.f, "RecentDocumentView") == false) goto L5;
    L14:
        return true;
    L5:
        if (Intrinsics.areEqual(this.f, "FavoriteView") == true) goto L14;
        if (Intrinsics.areEqual(this.f, "PinView") == true) goto L14;
        if (Intrinsics.areEqual(this.f, "SubordinateRecentView") == true) goto L14;
        if (Intrinsics.areEqual(this.f, "AINotesListView") == true) goto L14;
        return false;
    }

    public final boolean s() {
        if (Intrinsics.areEqual(this.f, "MyRootFolderView") == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(this.f, "SubFolderView") == true) goto L10;
        if (Intrinsics.areEqual(this.f, "FolderDetailView") == true) goto L10;
        return false;
    }

    public final boolean t() {
        if (Intrinsics.areEqual(this.f, "NewShareFolderView") == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(this.f, "NewShareHiddenFolderView") == true) goto L10;
        if (Intrinsics.areEqual(this.f, "ShareFolderView") == true) goto L10;
        return false;
    }

    public final FragmentActivity getContext() {
        return this.c;
    }

    public final boolean a(String r3) {
        if (this.b.d.isCurrentEnable("ccm.workspace.recent_delete_enable") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.d.e, r3) == false) goto L7;
        return true;
    }

    public SpaceMoreItemFactory(m r2, ce5.a r3) {
        Intrinsics.checkNotNullParameter(r2, "param");
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        this.a = r2;
        this.b = r3;
        this.c = r2.a.getActivity();
        this.d = r2.b;
        this.e = r2.f;
        this.f = r2.h;
        this.g = r2.g;
        this.h = r2.c;
        this.i = r2.d;
        this.j = r2.j;
        this.k = r2.a;
        this.l = r2.i;
        this.m = r2.k;
        this.n = r2.l;
        this.o = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SpaceMoreItemFactory$isDeleteSource$2(this));
    }
}
