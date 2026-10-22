package com.bytedance.ee.bear.container;

import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.render.node.EditionRenderNode;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q implements com.bytedance.ee.bear.document.render.node.m {

    public static final class a implements com.bytedance.ee.bear.document.render.node.l {
        public a() {
        }

        @Override // com.bytedance.ee.bear.document.render.node.l
        public final void c(DocumentLoaderV3 r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
        }

        @Override // com.bytedance.ee.bear.document.render.node.l
        public final Object b(DocumentLoaderV3 r1, Continuation r2) {
            return new com.bytedance.ee.bear.document.render.node.q.c();
        }
    }

    public q() {
    }

    @Override // com.bytedance.ee.bear.document.render.node.m
    public final com.bytedance.ee.bear.document.render.node.l a() {
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L6;
        return new EditionRenderNode();
    L6:
        return new a();
    }
}
