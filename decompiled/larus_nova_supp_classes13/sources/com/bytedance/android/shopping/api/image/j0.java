package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R>\u0010\u000e\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\r8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/image/j0;", "Lcom/bytedance/android/shopping/api/image/x;", "", "Lcom/bytedance/android/shopping/api/image/f0;", "targetTemplate", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "customParams", "a", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "finalParams", "Ljava/util/HashMap;", "f", "()Ljava/util/HashMap;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class j0 implements x {

    @SerializedName("custom_params")
    private final List<String> customParams;

    @SerializedName("final_params")
    private final HashMap<String, Object> finalParams;

    @SerializedName("target_template")
    private final List<f0> targetTemplate;

    public static final class a implements x, w {
        public final /* synthetic */ j0 a;
        public final /* synthetic */ f0 b;

        @Override // com.bytedance.android.shopping.api.image.x
        public final List<String> a() {
            return this.a.a();
        }

        @Override // com.bytedance.android.shopping.api.image.w
        public final String b() {
            return this.b.b();
        }

        @Override // com.bytedance.android.shopping.api.image.w
        public final String d() {
            return this.b.d();
        }

        @Override // com.bytedance.android.shopping.api.image.x
        public final HashMap<String, Object> f() {
            return this.a.f();
        }

        public a(j0 r2, f0 r3) {
            Intrinsics.checkNotNullParameter(r2, "tmplModel");
            Intrinsics.checkNotNullParameter(r3, "target");
            this.a = r2;
            this.b = r3;
        }
    }

    public final int hashCode() {
        List<f0> r0 = this.targetTemplate;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.customParams;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        HashMap<String, Object> r7 = this.finalParams;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ReplaceOldTmplModel(targetTemplate=" + this.targetTemplate + ", customParams=" + this.customParams + ", finalParams=" + this.finalParams + ")";
    }

    public j0() {
        this.targetTemplate = null;
        this.customParams = null;
        this.finalParams = null;
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final List<String> a() {
        return this.customParams;
    }

    public final List<f0> b() {
        return this.targetTemplate;
    }

    @Override // com.bytedance.android.shopping.api.image.x
    public final HashMap<String, Object> f() {
        return this.finalParams;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j0) == false) goto L12;
        j0 r4 = (j0) r3;
        if (Intrinsics.areEqual(this.targetTemplate, r4.targetTemplate) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.customParams, r4.customParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.finalParams, r4.finalParams) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }
}
