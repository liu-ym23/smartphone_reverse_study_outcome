package tsb;

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

/* JADX INFO: loaded from: classes36.dex */
public final class a implements rkb.a<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InputStream f547430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f547431c;

    @Override // rkb.a
    public final void cancel() {
        this.f547431c = true;
    }

    @Override // rkb.a
    public final void cleanup() {
        InputStream r100 = this.f547430b;
        if (r100 == null) goto L12;
        r100.close();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Log.d("EmojiResourceDataFetcher", th.toString());
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
        this.f547429a = r100;
    }

    @Override // rkb.a
    public final void loadData(Priority r100, rkb.a.InterfaceC7498a<? super InputStream> r101) {
        Log.d("EmojiResourceDataFetcher", "load emoji image：" + this.f547429a);
        if (this.f547431c == false) goto L15;
        r101.onLoadFailed(new Exception("request is canceled：" + this.f547429a));
        return;
    L15:
        int r102 = wsb.a.f561113a;     // Catch: Exception -> L12
        String r103 = ((e) ApiUtils.getApi(e.class)).getImageService().getEmojiImage(LarkFileStorage.b().b(f.f440961h, new d(j6c.a.a(Biz.IM), "/emoji/picture/rust/")).getAbsolutePath(), this.f547429a);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r103) == false) goto L10;
        Log.e("EmojiResourceDataFetcher", "load emoji image failed, key is:" + this.f547429a);     // Catch: Exception -> L12
        r101.onLoadFailed(new Exception("load emoji image failed, key is:" + this.f547429a));     // Catch: Exception -> L12
        return;
    L10:
        InputStream r104 = VFSFiles.f444819b.k(r103);     // Catch: Exception -> L12
        this.f547430b = r104;     // Catch: Exception -> L12
        r101.onDataReady(r104);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        r101.onLoadFailed(e);
        e.printStackTrace();
    }
}
