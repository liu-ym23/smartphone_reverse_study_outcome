package com.ss.android.lark.inline.ai.api.knowledgeai;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IKnowledgeAIControlInfo f426831a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f426831a, ((a) r100).f426831a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f426831a.hashCode();
        }

        public final String toString() {
            return "AIControlEvent(control=" + this.f426831a + ')';
        }

        public a(KnowledgeAIControlInfoBean r100) {
            Intrinsics.checkNotNullParameter(r100, "control");
            this.f426831a = r100;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KnowledgeAIMessage<Serializable> f426832a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f426832a, ((b) r100).f426832a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f426832a.hashCode();
        }

        public final String toString() {
            return "AIMessageEvent(message=" + this.f426832a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(KnowledgeAIMessage<? extends Serializable> r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f426832a = r100;
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IKnowledgeAIRecommend f426833a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f426833a, ((c) r100).f426833a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f426833a.hashCode();
        }

        public final String toString() {
            return "AIRecommendEvent(recommend=" + this.f426833a + ')';
        }

        public c(IKnowledgeAIRecommend r100) {
            Intrinsics.checkNotNullParameter(r100, "recommend");
            this.f426833a = r100;
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f426834a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f426834a, ((d) r100).f426834a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f426834a.hashCode();
        }

        public final String toString() {
            return "AIScopeEvent(scope=" + this.f426834a + ')';
        }

        public d(f r100) {
            Intrinsics.checkNotNullParameter(r100, "scope");
            this.f426834a = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.api.knowledgeai.e$e, reason: collision with other inner class name */
    public static final class C5050e extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IKnowledgeAIShow f426835a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5050e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f426835a, ((C5050e) r100).f426835a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f426835a.hashCode();
        }

        public final String toString() {
            return "AIShowEvent(show=" + this.f426835a + ')';
        }

        public C5050e(IKnowledgeAIShow r100) {
            Intrinsics.checkNotNullParameter(r100, "show");
            this.f426835a = r100;
        }
    }

    public e() {
    }
}
