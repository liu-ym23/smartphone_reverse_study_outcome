package iq5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.share.j2;
import com.bytedance.ee.bear.list.share.s2;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.mvp.BaseModel;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import uc5.e1;
import uc5.f1;
import uc5.t1;
import uc5.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends BaseModel implements m {
    public final Context a;
    public final int b;
    public final String c;
    public int d;
    public final boolean e;
    public Disposable f;
    public NetService g;

    public static final class a {
    }

    static {
    }

    public final void create() {
        super.create();
        tt5.a.h("FolderSelectModel", "create()...");
        this.g = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
    }

    public final void destroy() {
        super.destroy();
        tt5.a.h("FolderSelectModel", "destroy()...");
        Disposable r0 = this.f;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L11;
        Disposable r2 = this.f;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        Toast.cancelLoading();
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // iq5.m
    public final Flowable<DocumentListInfo> o8() {
        qc5.a.j();
        boolean r0 = qc5.a.d();
        NetService.e r1 = new NetService.e();
        int r2 = this.b;
        if (r2 != 4) goto L6;
        r1.b("shortcut_filter", "-1");
        r1.b("obj_type", String.valueOf(sbb.e.f.b));
        NetService.c r3 = new e1(this.c);
        String r4 = "/space/api/explorer/v3/my_space/list/";
    L16:
        r1.b = r4;
        r1.c = 2;
        r1.b("need_total", "1");
        r1.b("length", "100");
        NetService r5 = this.g;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("netService");
        r5 = null;
    L20:
        return r5.Vc(r3).a(r1).flatMap(new t1()).flatMap(new w1());
    L6:
        if (r2 != 6) goto L11;
        if (r0 == false) goto L9;
        r3 = new s2();
        r4 = "/space/api/explorer/v2/share/folder/list/";
    L10:
        r1.b("rank", String.valueOf(FolderSort.MODIFIED_TIME.getRank()));
        r1.b("asc", "false");
        goto L16
    L9:
        r1.b("obj_type", String.valueOf(sbb.e.f.b));
        r3 = new j2();
        r4 = "/space/api/explorer/v2/share/list/";
        goto L10
    L11:
        FolderVersion.a r6 = FolderVersion.Companion;
        Integer r7 = Integer.valueOf(this.d);
        r6.getClass();
        if (FolderVersion.a.c(r7) == false) goto L14;
        r1.b("shortcut_filter", "-1");
        r1.b("obj_type", String.valueOf(sbb.e.f.b));
        r3 = new f1(this.c);
        r4 = "/space/api/explorer/v3/children/list/";
    L15:
        r1.b(ResourceData.KEY_TOKEN, this.c);
        goto L16
    L14:
        r1.b(ResourceData.KEY_TYPE, String.valueOf(sbb.e.f.b));
        r1.b("need_path", "1");
        r3 = new e1(this.c);
        r4 = "/api/explorer/folder/children/";
        goto L15
    }

    public final Context getContext() {
        return this.a;
    }

    @Override // iq5.m
    public final void C3(int r1) {
        this.d = r1;
    }

    @Override // iq5.m
    public final Flowable Y5(FragmentActivity r4) {
        Disposable r0 = this.f;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L13;
        Disposable r3 = this.f;
        if (r3 == null) goto L13;
        r3.dispose();
    L13:
        if (this.b != 4) goto L15;
        qc5.a.j();
    L17:
        return Flowable.create(new e(r4, this, r1), BackpressureStrategy.BUFFER);
    L15:
        FolderVersion.a r5 = FolderVersion.Companion;
        Integer r6 = Integer.valueOf(this.d);
        r5.getClass();
        r1 = FolderVersion.a.c(r6);
        goto L17
    L5:
        if (r0.isDisposed() == true) goto L7;
        r2 = true;
        goto L8
    }

    public d(Context r2, int r3, String r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "destToken");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
