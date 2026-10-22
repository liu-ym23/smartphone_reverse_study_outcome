package com.ss.ugc.effectplatform.model;

import com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bytekn.foundation.utils.d<String, a> f457413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z.b<String, ModelInfo> f457414b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ModelInfo f457415a;

        public final int hashCode() {
            return this.f457415a.hashCode();
        }

        public a(ModelInfo r100) {
            this.f457415a = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
            return true;
        L5:
            if (r100 == null) goto L9;
            return Intrinsics.areEqual(this.f457415a, ((a) r100).f457415a);
        L9:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.LoadedModelList.ModelInfoState");
        }
    }

    public final z.b b() {
        if (this.f457414b.isEmpty() == false) goto L9;
        Iterator r100 = ((ArrayList) this.f457413a.b()).iterator();
    L6:
        if (r100.hasNext() == false) goto L9;
        a r101 = (a) r100.next();
        this.f457414b.put(r101.f457415a.getName(), r101.f457415a);
    L9:
        return this.f457414b;
    }

    public c() {
        this.f457413a = new bytekn.foundation.utils.d();
        this.f457414b = new z.b(false);
    }

    public final ExtendedUrlModel a(String r100) {
        Iterator r101 = ((ArrayList) this.f457413a.b()).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        a r102 = (a) r101.next();
        if (Intrinsics.areEqual(r102.f457415a.getName(), r100) == false) goto L4;
        return r102.f457415a.getFile_url();
    L10:
        throw new IllegalArgumentException("modelName " + r100 + " doesn't exist");
    }
}
