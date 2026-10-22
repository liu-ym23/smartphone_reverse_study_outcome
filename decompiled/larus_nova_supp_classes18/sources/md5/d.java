package md5;

import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.ownertype.OwnerType;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;

    public d() {
        this.a = 0;
        this.b = true;
    }

    public final Object apply(Object r4) {
        OwnerType r5 = (OwnerType) r4;
        Intrinsics.checkNotNullParameter(r5, "t");
        return new FolderVersion(r5.getOwnerType(), this.a, this.b);
    }
}
