package zf1;

import android.util.Pair;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.a f571621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f571622b;

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onProgress(DownloadInfo r100) {
        super.onProgress(r100);
        if (r100 == null) goto L6;
        int r101 = ((ArrayList) this.f571622b.f571626c).size();
        b.a r102 = this.f571621a;
        int r103 = ((this.f571622b.f571627d * 100) / r101) + (r100.getDownloadProcess() / r101);
        ((e0) r102).f571649a.onNext(Integer.valueOf((r103 * 90) / 100));
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        super.onSuccessed(r100);
        b r101 = this.f571622b;
        boolean r102 = true;
        if (r101.f571627d == (((ArrayList) r101.f571626c).size() - 1)) goto L6;
        r102 = false;
    L6:
        if (r102 == false) goto L8;
        b r103 = this.f571622b;
        b.a r104 = r103.f571628e;
        List<Pair<String, String>> r105 = r103.f571626c;
        ((e0) r104).f571649a.onComplete();
        return;
    L8:
        this.f571622b.a();
    }

    public a(b r100, e0 r101) {
        this.f571622b = r100;
        this.f571621a = r101;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        super.onFailed(r100, r101);
        b r102 = this.f571622b;
        b.a r103 = r102.f571628e;
        List<Pair<String, String>> r104 = r102.f571626c;
        e0 r105 = (e0) r103;
        ObservableEmitter r106 = r105.f571649a;
        Throwable r107 = r101;
        if (r101 != null) goto L5;
        r105.f571650b.getClass();
        r107 = new RuntimeException("download failed.");
    L5:
        r106.onError(r107);
    }
}
