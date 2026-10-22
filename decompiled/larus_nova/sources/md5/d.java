package md5;

import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.ownertype.OwnerType;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f513281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f513282b;

    public d() {
        this.f513281a = 0;
        this.f513282b = true;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        OwnerType r101 = (OwnerType) r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        return new FolderVersion(r101.getOwnerType(), this.f513281a, this.f513282b);
    }
}
