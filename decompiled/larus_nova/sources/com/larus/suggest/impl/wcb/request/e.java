package com.larus.suggest.impl.wcb.request;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface e {

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f370109a = null;

        static {
            f370109a = new a();
        }

        public a() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        @Override // com.larus.suggest.impl.wcb.request.e
        public final NexPulseResponseData getResponse() {
            return null;
        }

        public final int hashCode() {
            return 968727568;
        }

        public final String toString() {
            return "Empty";
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.suggest.impl.repo.a.C4499a f370110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final NexPulseResponseData f370111b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f370110a, r101.f370110a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f370111b, r101.f370111b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f370110a.hashCode() * 31;
            NexPulseResponseData r101 = this.f370111b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Failure(error=" + this.f370110a + ", response=" + this.f370111b + ')';
        }

        @Override // com.larus.suggest.impl.wcb.request.e
        public final NexPulseResponseData getResponse() {
            return this.f370111b;
        }

        public b(com.larus.suggest.impl.repo.a.C4499a r100, NexPulseResponseData r101) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f370110a = r100;
            this.f370111b = r101;
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NexPulseResponseData f370112a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f370112a, ((c) r100).f370112a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f370112a.hashCode();
        }

        public final String toString() {
            return "Success(response=" + this.f370112a + ')';
        }

        @Override // com.larus.suggest.impl.wcb.request.e
        public final NexPulseResponseData getResponse() {
            return this.f370112a;
        }

        public c(NexPulseResponseData r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f370112a = r100;
        }
    }

    NexPulseResponseData getResponse();
}
