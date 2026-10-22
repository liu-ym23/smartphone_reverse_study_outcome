package com.bytedance.ugc.glue.http;

import android.util.Pair;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public interface UGCCallbackWithHeader<T> {
    void onResponse(int r100, T r101, List<Pair<String, String>> r102);
}
