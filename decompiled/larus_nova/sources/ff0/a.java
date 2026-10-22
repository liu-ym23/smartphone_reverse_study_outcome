package ff0;

import com.ss.android.socialbase.downloader.model.DownloadTask;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadTask f476643a;

    public a(DownloadTask r100) {
        this.f476643a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r100) {
        this.f476643a.download();
    }
}
