package com.bytedance.ee.bear.drive.biz.preview.vc.connector;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$6 extends FunctionReferenceImpl implements Function0<e> {
    public AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$6(Object r100) {
        super(0, r100, AbsFollowableContentProvider.class, "initImageVCFollowConnector", "initImageVCFollowConnector()Lcom/bytedance/ee/bear/drive/biz/preview/vc/connector/IFollowableContentConnector;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final e invoke() {
        return ((AbsFollowableContentProvider) this.receiver).g();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ e invoke() {
        return invoke();
    }
}
