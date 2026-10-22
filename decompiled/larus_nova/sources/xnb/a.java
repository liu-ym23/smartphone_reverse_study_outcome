package xnb;

import com.ss.android.lark.image.entity.Image;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T, R> f564657a = null;

    static {
        f564657a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Image r101 = (Image) r100;
        Intrinsics.checkNotNullParameter(r101, "image");
        return new com.ss.android.lark.keyboard.dtocompat.Image(r101.getUrls(), r101.getWidth(), r101.getHeight(), r101.getToken());
    }
}
