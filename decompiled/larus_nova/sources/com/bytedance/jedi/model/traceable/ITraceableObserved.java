package com.bytedance.jedi.model.traceable;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/jedi/model/traceable/ITraceableObserved;", ExifInterface.GPS_DIRECTION_TRUE, "", "model_release"}, k = 1, mv = {1, 7, 1})
public interface ITraceableObserved<T> {
    void b(ITraceable<T> r100);
}
