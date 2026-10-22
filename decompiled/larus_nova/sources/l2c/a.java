package l2c;

import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.d;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.vfs.VFSFiles;
import com.suite.lark.component.protocol.Biz;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.InputStream;
import qpc.e;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements rkb.a<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f507193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InputStream f507194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f507195c;

    @Override // rkb.a
    public final void cancel() {
        this.f507195c = true;
    }

    @Override // rkb.a
    public final void cleanup() {
        InputStream r100 = this.f507194b;
        if (r100 == null) goto L12;
        r100.close();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Log.d("ReactionResourceFetcher", th.toString());
        return;
    }

    @Override // rkb.a
    public final Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // rkb.a
    public final DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public a(String r100) {
        this.f507193a = r100;
    }

    @Override // rkb.a
    public final void loadData(Priority r100, rkb.a.InterfaceC7498a<? super InputStream> r101) {
        Log.d("ReactionResourceFetcher", "load reaction：" + this.f507193a);
        if (this.f507195c == false) goto L15;
        r101.onLoadFailed(new Exception("request is canceled：" + this.f507193a));
        return;
    L15:
        int r102 = wsb.a.f561113a;     // Catch: Exception -> L12
        String r103 = ((e) ApiUtils.getApi(e.class)).getImageService().getReactionImage(LarkFileStorage.b().b(f.f440961h, new d(j6c.a.a(Biz.IM), "/emoji/picture/rust/")).getAbsolutePath(), this.f507193a);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r103) == false) goto L10;
        Log.e("ReactionResourceFetcher", "load reaction failed, key is:" + this.f507193a);     // Catch: Exception -> L12
        r101.onLoadFailed(new Exception("load reaction failed, key is:" + this.f507193a));     // Catch: Exception -> L12
        return;
    L10:
        InputStream r104 = VFSFiles.f444819b.k(r103);     // Catch: Exception -> L12
        this.f507194b = r104;     // Catch: Exception -> L12
        r101.onDataReady(r104);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        r101.onLoadFailed(e);
        e.printStackTrace();
    }
}
