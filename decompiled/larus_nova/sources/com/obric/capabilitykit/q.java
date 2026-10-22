package com.obric.capabilitykit;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class q {

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class a extends Lambda implements Function1<String, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f396263a = null;

        static {
            f396263a = new a();
        }

        public a() {
            super(1);
        }

        public final CharSequence a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(String r100) {
            return a(r100);
        }
    }

    public static final List<String> a(List<? extends AppEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "appEntityList");
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((AppEntity) r102.next()).getId());
        goto L4
    L6:
        return r101;
    }

    public static final String b(List<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "array");
        return CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, a.f396263a, 30, null);
    }
}
