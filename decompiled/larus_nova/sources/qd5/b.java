package qd5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends com.bytedance.ee.bear.list.e<SimpleRequestResult> implements qd5.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f532566b;

    public static final class a implements nc5.b {
        public a() {
        }

        @Override // nc5.b
        public final void cancel() {
        }
    }

    /* JADX INFO: renamed from: qd5.b$b, reason: collision with other inner class name */
    public static final class C7313b implements nc5.b {
        public C7313b() {
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
        this.f532566b = "RenameExecutor";
    }

    @Override // com.bytedance.ee.bear.list.e
    public final String n() {
        return this.f532566b;
    }

    public final nc5.b o(String r100, String r101, nc5.a<SimpleRequestResult> r102) {
        Intrinsics.checkNotNullParameter(r100, "fileToken");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "callback");
        tt5.a.h(this.f532566b, "renameFile, fileToken: " + du5.b.k(r100) + ", name: " + r101);
        boolean r103 = false;
        if (r100.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
    L14:
        tt5.a.d(this.f532566b, "renameFile param error");
        r102.onFailure(new IllegalArgumentException("fileToken or name is empty"));
        return new a();
    L8:
        if (r101.length() != 0) goto L10;
        r103 = true;
    L10:
        if (r103 == true) goto L14;
        JSONObject r105 = new JSONObject();
        r105.put("file_token", r100);
        r105.put("name", r101);
        return l(com.bytedance.ee.bear.list.e.j("/space/api/box/file/update_info/", r105.toString()), r102);
    L5:
        r104 = false;
        goto L6
    }

    public final nc5.b p(String r100, String r101, nc5.a<SimpleRequestResult> r102) {
        Intrinsics.checkNotNullParameter(r100, "folderToken");
        Intrinsics.checkNotNullParameter(r101, "newName");
        Intrinsics.checkNotNullParameter(r102, "callback");
        tt5.a.h(this.f532566b, "renameFolder, folderToken: " + du5.b.k(r100) + ", newName: " + r101);
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L15:
        tt5.a.d(this.f532566b, "renameFolder param error");
        r102.onFailure(new IllegalArgumentException("folderToken or newName is empty"));
        return new C7313b();
    L8:
        if (r101.length() != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L15;
        return l(com.bytedance.ee.bear.list.e.k("/space/api/explorer/v2/rename/", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("token", r100), TuplesKt.to("name", r101)})), r102);
    L10:
        r104 = false;
        goto L11
    L5:
        r103 = false;
        goto L6
    }

    @Override // qd5.a
    public final nc5.b f(int r100, String r101, String r102, nc5.a<SimpleRequestResult> r103) {
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r103, "callback");
        tt5.a.h(this.f532566b, "rename, type: " + r100 + ", token: " + du5.b.k(r101) + ", name: " + r102);
        if (r100 != 0) goto L6;
        return p(r101, r102, r103);
    L6:
        return o(r101, r102, r103);
    }
}
