package com.obric.assistant.state.impl.multitask.producer;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<a, String> f393166a;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f393167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f393168b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f393167a, r101.f393167a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393168b, r101.f393168b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f393167a.hashCode() * 31) + this.f393168b.hashCode();
        }

        public final String toString() {
            return "MessageIdKey(conversationId=" + this.f393167a + ", messageId=" + this.f393168b + ')';
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r101, "messageId");
            this.f393167a = r100;
            this.f393168b = r101;
        }
    }

    public g() {
        this.f393166a = new ConcurrentHashMap();
    }
}
