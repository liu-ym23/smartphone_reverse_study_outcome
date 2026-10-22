package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.creationmenu.SelectIndex;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.create.g0;
import com.bytedance.ee.bear.list.create.q0;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.utils.ContextsKt;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements td5.d {
    public final Context a;
    public final ShareFolderUserPermission b;
    public final WikiSelectorBean c;
    public final String d;
    public final int e;
    public final td5.b f;
    public final CompositeDisposable g;

    @Override // td5.d
    public final void destroy() {
        tt5.a.h("WikiCreateToSpaceCommand", "destroy()...");
        if (this.g.isDisposed() == true) goto L5;
        this.g.clear();
    L5:
        Toast.cancelLoading();
    }

    @Override // td5.d
    public final void execute() {
        tt5.a.h("WikiCreateToSpaceCommand", "execute()...");
        if (this.c != null) goto L7;
        tt5.a.h("WikiCreateToSpaceCommand", "mWikiSelectorBean is null.");
        return;
    L7:
        if (this.b != null) goto L9;
    L40:
        tt5.a.h("WikiCreateToSpaceCommand", "execute()...permission is null or deny");
        Context r1 = this.a;
        Toast.showFailureText(r1, r1.getString(2131889875));
        return;
    L9:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.b, "MOVE_TO_HERE").booleanValue() == false) goto L40;
        SelectIndex.a r2 = SelectIndex.Companion;
        int r3 = this.c.m;
        r2.getClass();
        SelectIndex r4 = SelectIndex.a.a(r3);
        final int r12 = r4.getDocumentType();
        if (r12 == sbb.e.l.b) goto L26;
        if (com.bytedance.ee.bear.list.create.a.a(r12) == false) goto L17;
        Context r5 = this.a;
        Toast.showLoading(r5, r5.getString(2131888318));
        Disposable r6 = q0.a(r12, this.d, FolderVersion.isShareFolderV2(Integer.valueOf(this.e)), false).observeOn(fo5.d.d()).subscribe(new s(this, r12), new t(this));
        this.g.add(r6);
        return;
    L17:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L20;
        tt5.a.h("WikiCreateToSpaceCommand", "execute()...failed, offline");
        Context r7 = this.a;
        Toast.showFailureText(r7, r7.getString(2131887951), 0);
        return;
    L20:
        Context r8 = this.a;
        Toast.showLoading(r8, r8.getString(2131888318));
        if (r4 != SelectIndex.SURVEY) goto L23;
        com.bytedance.ee.bear.list.create.l r9 = new com.bytedance.ee.bear.list.create.l("", 8, DocumentType.WIKI_NAME, false, "", true, com.bytedance.ee.bear.templates.a.a(), "wiki_home_create_form", CreateSelectResult.a(this.d));
        Flowable<DocumentCreateInfo> r10 = new g0().b(r9);
    L24:
        Disposable r11 = r10.observeOn(fo5.d.d()).subscribe(new u(this, r12), new v(this));
        this.g.add(r11);
        return;
    L23:
        r10 = q0.b(r12, this.d, DocumentType.WIKI_NAME, FolderVersion.isShareFolderV2(Integer.valueOf(this.e)), false, null, 0, null, null);
        goto L24
    L26:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L30;
        tt5.a.h("WikiCreateToSpaceCommand", "execute()...failed, offline");
        Context r13 = this.a;
        Toast.showFailureText(r13, r13.getString(2131887951), 0);
        return;
    L30:
        if (this.c.m != SelectIndex.MEDIA.ordinal()) goto L35;
        if (ContextsKt.findActivity(this.a) == null) goto L44;
        com.bytedance.ee.bear.h r14 = (com.bytedance.ee.bear.h) org.koin.java.a.a(com.bytedance.ee.bear.h.class);
        Activity r15 = ContextsKt.findActivity(this.a);
        String r16 = this.d;
        Bundle r17 = new Bundle();
        r17.putString("module", DocumentType.WIKI_NAME);
        r17.putString("parent_token", this.d);
        r14.u(r15, r16, "explorer", r17, 1033);
        return;
    L44:
        return;
    L35:
        if (this.c.m == SelectIndex.FILE.ordinal()) goto L37;
        return;
    L37:
        if (ContextsKt.findActivity(this.a) == null) goto L47;
        com.bytedance.ee.bear.h r18 = (com.bytedance.ee.bear.h) org.koin.java.a.a(com.bytedance.ee.bear.h.class);
        Activity r19 = ContextsKt.findActivity(this.a);
        String r20 = this.d;
        Bundle r110 = new Bundle();
        r110.putString("module", DocumentType.WIKI_NAME);
        r110.putString("parent_token", this.d);
        r18.E(r19, r20, "explorer", r110, 1033);
        return;
    }

    public w(Context r2, ShareFolderUserPermission r3, String r4, int r5, Bundle r6, td5.b r7) {
        this.g = new CompositeDisposable();
        this.a = r2;
        this.b = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.c = (WikiSelectorBean) r6.getParcelable("extra_wiki_bean");
    }
}
