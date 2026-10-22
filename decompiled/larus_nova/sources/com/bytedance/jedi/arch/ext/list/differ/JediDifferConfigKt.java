package com.bytedance.jedi.arch.ext.list.differ;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, d2 = {"asDifferConfig", "Lcom/bytedance/jedi/arch/ext/list/differ/JediDifferConfig;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "mainExecutor", "Ljava/util/concurrent/Executor;", "ext_list_release"}, k = 2, mv = {1, 1, 16})
public final class JediDifferConfigKt {
    public static final <T> JediDifferConfig<T> asDifferConfig(DiffUtil.ItemCallback<T> r100, Executor r101) {
        JediDifferConfig.Builder r102 = new JediDifferConfig.Builder(r100);
        if (r101 == null) goto L6;
        r102.setMainThreadExecutor(r101);
    L6:
        return r102.build();
    }

    public static /* synthetic */ JediDifferConfig asDifferConfig$default(DiffUtil.ItemCallback r100, Executor r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return asDifferConfig(r100, r101);
    }
}
