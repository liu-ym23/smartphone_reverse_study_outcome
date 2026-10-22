package wq5;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.folderselect.command.DuplicateContentChecker;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements td5.d {
    public final Context a;
    public final String b;
    public final int c;
    public final int d;
    public final boolean e;
    public final int f;
    public final ShareFolderUserPermission g;
    public final WikiSelectorBean h;
    public final SelectorConfig i;
    public final td5.b j;
    public final CompositeDisposable k;
    public final NetService l;

    @Override // td5.d
    public final void destroy() {
        if (this.k.isDisposed() == true) goto L5;
        this.k.clear();
    L5:
        Toast.cancelLoading();
    }

    @Override // td5.d
    public final void execute() {
        tt5.a.h("WikiShortcutToSpaceCommand", "execute()...");
        if (this.h != null) goto L7;
        tt5.a.h("WikiShortcutToSpaceCommand", "mWikiSelectorBean is null.");
        return;
    L7:
        if (this.c == 4) goto L13;
        if (FolderVersion.isShareFolderV2(Integer.valueOf(this.d)) == true) goto L13;
        tt5.a.h("WikiShortcutToSpaceCommand", "execute()...ownerType = " + this.d);
        Context r0 = this.a;
        Toast.showFailureText(r0, r0.getString(2131887320), 0);
        return;
    L13:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L17;
        tt5.a.h("WikiShortcutToSpaceCommand", "execute()...failed, offline");
        Context r1 = this.a;
        Toast.showFailureText(r1, r1.getString(2131887951), 0);
        return;
    L17:
        if (this.g != null) goto L19;
    L23:
        tt5.a.h("WikiShortcutToSpaceCommand", "execute()...permission is null or deny");
        Context r2 = this.a;
        Toast.showFailureText(r2, r2.getString(2131889876));
        return;
    L19:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.g, "MOVE_TO_HERE").booleanValue() == false) goto L23;
        Context r3 = this.a;
        String r4 = this.b;
        WikiSelectorBean r5 = this.h;
        this.k.add(DuplicateContentChecker.a(r3, r4, r5.i, r5.j, 1).flatMap(new d(this)).doOnSubscribe(new e(this)).subscribe(new f(this), new g(this)));
    }

    public i(Context r2, String r3, int r4, int r5, boolean r6, int r7, ShareFolderUserPermission r8, Bundle r9, td5.b r10, ce5.a r11) {
        this.k = new CompositeDisposable();
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.j = r10;
        this.l = r11.c;
        this.h = (WikiSelectorBean) r9.getParcelable("extra_wiki_bean");
        this.i = (SelectorConfig) r9.getParcelable("extra_config");
    }
}
