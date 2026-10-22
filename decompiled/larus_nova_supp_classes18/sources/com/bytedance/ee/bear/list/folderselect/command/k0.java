package com.bytedance.ee.bear.list.folderselect.command;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k0 implements td5.d {
    public Context a;
    public final String b;
    public final int c;
    public final int d;
    public final ShareFolderUserPermission e;
    public td5.b f;
    public final SpaceSelectorBean g;
    public Disposable h;
    public final boolean i;

    @Override // td5.d
    public final void destroy() {
        Disposable r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        Toast.cancelLoading();
        this.a = null;
        this.f = null;
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.h.dispose();
        goto L7
    }

    @Override // td5.d
    public final void execute() {
        tt5.a.h("SpaceShortCutToSpaceCommand", "execute()...");
        if (this.g != null) goto L7;
        tt5.a.d("SpaceShortCutToSpaceCommand", "execute()...spaceSelectorBean is null.");
        return;
    L7:
        if ((!com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a()) == false) goto L11;
        tt5.a.h("SpaceShortCutToSpaceCommand", "execute()...failed, offline");
        Context r0 = this.a;
        Toast.showFailureText(r0, r0.getString(2131887951));
        return;
    L11:
        if (FolderVersion.isShareFolderV2(Integer.valueOf(this.c)) == true) goto L15;
        Context r1 = this.a;
        Toast.showText(r1, r1.getString(2131887320));
        return;
    L15:
        if (this.e != null) goto L17;
    L26:
        tt5.a.h("SpaceShortCutToSpaceCommand", "execute()...has no permission.");
        Context r2 = this.a;
        Toast.showFailureText(r2, r2.getString(2131889876));
        return;
    L17:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.e, "MOVE_TO_HERE").booleanValue() == false) goto L26;
        Disposable r3 = this.h;
        if (r3 != null) goto L22;
    L24:
        Context r4 = this.a;
        String r5 = this.b;
        SpaceSelectorBean r6 = this.g;
        this.h = DuplicateContentChecker.a(r4, r5, r6.b, r6.a, 1).flatMap(new e0(this)).doOnSubscribe(new f0(this)).subscribe(new g0(this), new h0(this));
        return;
    L22:
        if (r3.isDisposed() == true) goto L24;
        this.h.dispose();
        goto L24
    }

    public k0(Context r2, String r3, int r4, int r5, ShareFolderUserPermission r6, Bundle r7, td5.b r8) {
        this.i = false;
        this.a = r2;
        this.b = r3;
        this.d = r4;
        this.c = r5;
        this.e = r6;
        this.f = r8;
        this.g = (SpaceSelectorBean) r7.getParcelable("extra_space_bean");
        this.i = r7.getBoolean("extra_is_at_vc", false);
    }
}
