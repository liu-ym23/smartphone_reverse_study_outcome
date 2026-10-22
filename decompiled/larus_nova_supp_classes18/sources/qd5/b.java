package qd5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends com.bytedance.ee.bear.list.e<SimpleRequestResult> implements qd5.a {
    public final String b;

    public static final class a implements nc5.b {
        public a() {
        }

        @Override // nc5.b
        public final void cancel() {
        }
    }

    /* JADX INFO: renamed from: qd5.b$b, reason: collision with other inner class name */
    public static final class C0293b implements nc5.b {
        public C0293b() {
        }

        @Override // nc5.b
        public final void cancel() {
        }
    }

    @Override // com.bytedance.ee.bear.list.e
    public final NetService.d<SimpleRequestResult> m() {
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f());
    }

    public b() {
        this.b = "RenameExecutor";
    }

    @Override // com.bytedance.ee.bear.list.e
    public final String n() {
        return this.b;
    }

    public final nc5.b o(String r5, String r6, nc5.a<SimpleRequestResult> r7) {
        Intrinsics.checkNotNullParameter(r5, "fileToken");
        Intrinsics.checkNotNullParameter(r6, "name");
        Intrinsics.checkNotNullParameter(r7, "callback");
        tt5.a.h(this.b, "renameFile, fileToken: " + du5.b.k(r5) + ", name: " + r6);
        boolean r2 = false;
        if (r5.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L14:
        tt5.a.d(this.b, "renameFile param error");
        r7.onFailure(new IllegalArgumentException("fileToken or name is empty"));
        return new a();
    L8:
        if (r6.length() != 0) goto L10;
        r2 = true;
    L10:
        if (r2 == true) goto L14;
        JSONObject r3 = new JSONObject();
        r3.put("file_token", r5);
        r3.put("name", r6);
        return l(com.bytedance.ee.bear.list.e.j("/space/api/box/file/update_info/", r3.toString()), r7);
    L5:
        r1 = false;
        goto L6
    }

    public final nc5.b p(String r5, String r6, nc5.a<SimpleRequestResult> r7) {
        Intrinsics.checkNotNullParameter(r5, "folderToken");
        Intrinsics.checkNotNullParameter(r6, "newName");
        Intrinsics.checkNotNullParameter(r7, "callback");
        tt5.a.h(this.b, "renameFolder, folderToken: " + du5.b.k(r5) + ", newName: " + r6);
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L15:
        tt5.a.d(this.b, "renameFolder param error");
        r7.onFailure(new IllegalArgumentException("folderToken or newName is empty"));
        return new C0293b();
    L8:
        if (r6.length() != 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L15;
        return l(com.bytedance.ee.bear.list.e.k("/space/api/explorer/v2/rename/", MapsKt.hashMapOf(new Pair[]{TuplesKt.to(ResourceData.KEY_TOKEN, r5), TuplesKt.to("name", r6)})), r7);
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    @Override // qd5.a
    public final nc5.b f(int r4, String r5, String r6, nc5.a<SimpleRequestResult> r7) {
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "name");
        Intrinsics.checkNotNullParameter(r7, "callback");
        tt5.a.h(this.b, "rename, type: " + r4 + ", token: " + du5.b.k(r5) + ", name: " + r6);
        if (r4 != 0) goto L6;
        return p(r5, r6, r7);
    L6:
        return o(r5, r6, r7);
    }
}
