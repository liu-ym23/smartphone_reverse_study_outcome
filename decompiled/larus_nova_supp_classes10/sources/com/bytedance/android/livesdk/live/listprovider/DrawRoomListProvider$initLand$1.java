package com.bytedance.android.livesdk.live.listprovider;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class DrawRoomListProvider$initLand$1 extends FunctionReferenceImpl implements Function1<Integer, Boolean> {
    public DrawRoomListProvider$initLand$1(DrawRoomListProvider r8) {
        super(1, r8, DrawRoomListProvider.class, "isFollowRecommend", "isFollowRecommend(I)Z", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke(((Number) r1).intValue()));
    }

    public final boolean invoke(int r3) {
        DrawRoomListProvider r0 = (DrawRoomListProvider) ((CallableReference) this).receiver;
        List<String> r1 = DrawRoomListProvider.S1;
        return r0.D(r3);
    }
}
