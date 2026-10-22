package sq5;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.CopyToSpacePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements td5.d {
    public final Context a;
    public final ShareFolderUserPermission b;
    public final WikiSelectorBean c;
    public final SelectorConfig d;
    public final String e;
    public final int f;
    public final int g;
    public final boolean h;
    public final int i;
    public final td5.b j;
    public final CompositeDisposable k;
    public final NetService l;

    @Override // td5.d
    public final void destroy() {
        tt5.a.h("WikiMakeCopyToSpaceCommand", "destroy()...");
        if (this.k.isDisposed() == true) goto L5;
        this.k.clear();
    L5:
        Toast.cancelLoading();
    }

    @Override // td5.d
    public final void execute() {
        tt5.a.h("WikiMakeCopyToSpaceCommand", "execute()...");
        if (this.c != null) goto L7;
        tt5.a.h("WikiMakeCopyToSpaceCommand", "mWikiSelectorBean is null.");
        return;
    L7:
        if (this.f == 4) goto L13;
        if (FolderVersion.isShareFolderV2(Integer.valueOf(this.g)) == true) goto L13;
        tt5.a.h("WikiMakeCopyToSpaceCommand", "execute()...ownerType = " + this.g);
        Context r0 = this.a;
        Toast.showFailureText(r0, r0.getString(2131887316), 0);
        return;
    L13:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L17;
        tt5.a.h("WikiMakeCopyToSpaceCommand", "execute()...failed, offline");
        Context r1 = this.a;
        Toast.showFailureText(r1, r1.getString(2131887951), 0);
        return;
    L17:
        if (this.b != null) goto L19;
    L52:
        tt5.a.h("WikiMakeCopyToSpaceCommand", "execute()...permission is null or deny");
        Context r2 = this.a;
        Toast.showFailureText(r2, r2.getString(2131889873));
        return;
    L19:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.b, "MOVE_TO_HERE").booleanValue() == false) goto L52;
        tt5.a.h("WikiMakeCopyToSpaceCommand", "copyToSpace()...");
        Context r3 = this.a;
        Map<String, Integer> r4 = q.a;
        Toast.showLoading(r3, r3.getString(q.e(WikiAction.MAKE_COPY)));
        boolean r5 = true;
        if (this.f != 4) goto L24;
        boolean r6 = true;
    L25:
        if (r6 == false) goto L27;
        String r7 = "";
    L28:
        String r8 = r7;
        if (TextUtils.isEmpty(this.c.g) == false) goto L31;
        String r9 = t0.e(this.a, this.c.j);
    L32:
        String r10 = this.a.getString(2131887720);
        if (this.c.j != sbb.e.l.b) goto L38;
        int r11 = r9.lastIndexOf(".");
        if (r11 >= 0) goto L37;
        r11 = r9.length();
    L37:
        String r12 = new StringBuilder(r9).insert(r11, " " + r10).toString();
    L39:
        String r13 = r12;
        CopyToSpacePuller r14 = new CopyToSpacePuller(this.l);
        WikiSelectorBean r15 = this.c;
        boolean r16 = r15.l;
        if (r16 == false) goto L42;
        String r17 = r15.c;
    L43:
        if (r16 == false) goto L45;
        String r18 = r15.e;
    L46:
        String r19 = r18;
        if (r15.j == sbb.e.h.b) goto L50;
        r5 = false;
    L50:
        this.k.add(r14.d(new CopyToSpacePuller.Params(r17, r19, r8, r13, r5)).subscribe(new g(this), new h(this)));
        return;
    L45:
        r18 = r15.d;
        goto L46
    L42:
        r17 = r15.a;
        goto L43
    L38:
        r12 = String.format("%s %s", new Object[]{r9, r10});
        goto L39
    L31:
        r9 = this.c.g;
        goto L32
    L27:
        r7 = this.e;
        goto L28
    L24:
        r6 = false;
        goto L25
    }

    public i(Context r2, ShareFolderUserPermission r3, String r4, int r5, int r6, boolean r7, int r8, Bundle r9, td5.b r10, ce5.a r11) {
        this.k = new CompositeDisposable();
        this.a = r2;
        this.b = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r10;
        this.l = r11.c;
        this.c = (WikiSelectorBean) r9.getParcelable("extra_wiki_bean");
        this.d = (SelectorConfig) r9.getParcelable("extra_config");
    }
}
