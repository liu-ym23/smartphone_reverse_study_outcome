package com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget;

import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/ktvimpl/base/datacontext/KtvRoomContext;", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class KtvRoomContainerWidget$loadKtvRoomContext$1 extends FunctionReferenceImpl implements Function0<KtvRoomContext> {
    public static final KtvRoomContainerWidget$loadKtvRoomContext$1 INSTANCE = null;

    static {
        INSTANCE = new KtvRoomContainerWidget$loadKtvRoomContext$1();
    }

    public KtvRoomContainerWidget$loadKtvRoomContext$1() {
        super(0, KtvRoomContext.class, "<init>", "<init>()V", 0);
    }

    public final KtvRoomContext invoke() {
        return new KtvRoomContext();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m356invoke() {
        return invoke();
    }
}
