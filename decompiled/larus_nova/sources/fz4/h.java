package fz4;

import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class h implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VFSPath f479367a;

    public /* synthetic */ h(VFSPath r100) {
        this.f479367a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Boolean r101 = (Boolean) r100;
        return this.f479367a;
    }
}
