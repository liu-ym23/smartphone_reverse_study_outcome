package com.ss.android.lark.biz.im.api;

import com.bytedance.ee.bear.document.associateddocs.service.AssociatedPreviewService$requestUrlPreview$1;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.core.keyboard.KeyboardBaseModuleDependencyImpl;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface e {
    void O(List r100, AssociatedPreviewService$requestUrlPreview$1.AnonymousClass1.AnonymousClass2 r101);

    Map<String, RecogniseSpansResult> a(List<UrlPreViewEntries> r100, String r101, String r102, Long r103);

    void b(String r100, long r101, long r102, KeyboardBaseModuleDependencyImpl.C118301 r103);

    void c(d7b.a r100);

    void d(d7b.a r100);
}
