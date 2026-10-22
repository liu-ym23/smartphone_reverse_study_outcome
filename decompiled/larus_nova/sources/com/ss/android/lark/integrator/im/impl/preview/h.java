package com.ss.android.lark.integrator.im.impl.preview;

import android.view.ViewGroup;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewCardType;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewRenderResult;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public interface h extends Closeable {
    void J(List<String> r100);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    UrlPreviewRenderResult j0(String r100, UrlPreviewCardType r101, ViewGroup r102);

    void s(String r100);
}
