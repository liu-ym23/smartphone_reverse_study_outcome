package com.lark.kmp.rustclient.api.model;

import com.lark.kmp.pb.basic.v1.Command;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes24.dex */
public final class c<Resp> extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message.a<?, ?> f282470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProtoAdapter<Resp> f282471f;

    public c(Message.a r110, ProtoAdapter r111, Command r210, com.lark.kmp.server.pb.improto.Command r211, int r212) {
        if ((r212 & 8) == 0) goto L9;
        int r100 = jy7.a.f500949a;
        IntRange r101 = new IntRange(1, 10);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<Integer> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        ((IntIterator) r103).nextInt();
        r102.add(Character.valueOf("abcdefghijklmnopqrstuvwxyz0123456789".charAt(Random.Default.nextInt(0, 36))));
        goto L6
    L8:
        String r104 = CollectionsKt.joinToString$default(r102, "", null, null, 0, null, null, 62, null);
    L11:
        if ((r212 & 64) == 0) goto L13;
        com.lark.kmp.server.pb.improto.Command r105 = null;
    L14:
        Intrinsics.checkNotNullParameter(r110, "requestMessageBuilder");
        Intrinsics.checkNotNullParameter(r111, "responseProtoAdapter");
        Intrinsics.checkNotNullParameter(r210, "command");
        Intrinsics.checkNotNullParameter(r104, "contextId");
        super(r210, r104, null, r105);
        this.f282470e = r110;
        this.f282471f = r111;
        return;
    L13:
        r105 = r211;
        goto L14
    L9:
        r104 = null;
        goto L11
    }
}
