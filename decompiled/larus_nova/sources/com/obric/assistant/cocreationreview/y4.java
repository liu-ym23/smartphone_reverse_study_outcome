package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public abstract class y4 {

    public static final class a extends y4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f387801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f387802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<Context, View> f387803c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f387801a, r101.f387801a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f387802b, r101.f387802b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f387803c, r101.f387803c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f387801a.hashCode() * 31;
            String r101 = this.f387802b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f387803c.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Custom(label=" + this.f387801a + ", anchor=" + this.f387802b + ", contentBuilder=" + this.f387803c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r100, String r101, Function1<? super Context, ? extends View> r102) {
            Intrinsics.checkNotNullParameter(r100, "label");
            Intrinsics.checkNotNullParameter(r102, "contentBuilder");
            this.f387801a = r100;
            this.f387802b = r101;
            this.f387803c = r102;
        }
    }

    public static final class b extends y4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f387804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.obric.assistant.cocreationreview.c> f387805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f387806c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f387804a, r101.f387804a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f387805b, r101.f387805b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f387806c, r101.f387806c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f387804a.hashCode() * 31) + this.f387805b.hashCode()) * 31) + this.f387806c.hashCode();
        }

        public final String toString() {
            return "History(label=" + this.f387804a + ", tags=" + this.f387805b + ", steps=" + this.f387806c + ')';
        }

        public b(List r100, List r101) {
            Intrinsics.checkNotNullParameter("执行历史", "label");
            Intrinsics.checkNotNullParameter(r100, PromotionProductPrivilegesStruct.TAGS);
            Intrinsics.checkNotNullParameter(r101, "steps");
            this.f387804a = "执行历史";
            this.f387805b = r100;
            this.f387806c = r101;
        }
    }

    public static final class c extends y4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f387807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f387808b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f387807a, r101.f387807a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f387808b, r101.f387808b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f387807a.hashCode() * 31) + this.f387808b.hashCode();
        }

        public final String toString() {
            return "Message(label=" + this.f387807a + ", text=" + this.f387808b + ')';
        }

        public c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "label");
            Intrinsics.checkNotNullParameter(r101, "text");
            this.f387807a = r100;
            this.f387808b = r101;
        }
    }

    public y4() {
    }
}
