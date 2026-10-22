package com.bytedance.ee.bear.drive.biz.preview.vc.connector;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$5 extends FunctionReferenceImpl implements Function0<e> {
    public AbsFollowableContentProvider$FOLLOWABLE_CONTENT_MAP$5(Object r8) {
        super(0, r8, AbsFollowableContentProvider.class, "initAudioVCFollowConnector", "initAudioVCFollowConnector()Lcom/bytedance/ee/bear/drive/biz/preview/vc/connector/IFollowableContentConnector;", 0);
    }

    public final e invoke() {
        return ((AbsFollowableContentProvider) ((CallableReference) this).receiver).d();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m321invoke() {
        return invoke();
    }
}
