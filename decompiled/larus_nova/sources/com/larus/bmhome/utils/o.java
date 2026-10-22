package com.larus.bmhome.utils;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes26.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f315076a;

    public static final class a extends o {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f315077b = null;

        static {
            f315077b = new a();
        }

        @Override // com.larus.bmhome.utils.o
        public final List<String> a() {
            return CollectionsKt.listOf(new String[]{this.f315076a, "text/markdown"});
        }

        public a() {
        }
    }

    public List<String> a() {
        return CollectionsKt.listOf(this.f315076a);
    }

    public o() {
        this.f315076a = "text/plain";
    }
}
