package com.bytedance.awemeopen.domain.feed.preload.framework;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import r34.f;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J/\u0010\b\u001a\u00020\u00072\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\"\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\f"}, d2 = {"Lcom/bytedance/awemeopen/domain/feed/preload/framework/IAosDataPreload;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "data", "Lr34/f;", "callback", "", "preload", "([Ljava/lang/Object;Lr34/f;)V", "", "list", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public interface IAosDataPreload<T> {
    void preload(List<? extends T> r100, f r101);

    void preload(T[] r100, f r101);
}
