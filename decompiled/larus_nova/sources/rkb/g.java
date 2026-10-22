package rkb;

import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;

/* JADX INFO: loaded from: classes36.dex */
public interface g<T, R> {
    boolean onLoadFailed(Exception r100, T r101, Target<R> r102, boolean r103);

    boolean onResourceReady(R r100, T r101, Target<R> r102, DataSource r103, boolean r104);
}
