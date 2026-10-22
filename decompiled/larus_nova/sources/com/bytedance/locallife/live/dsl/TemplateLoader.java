package com.bytedance.locallife.live.dsl;

import androidx.lifecycle.MutableLiveData;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class TemplateLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f259411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile MutableLiveData<List<a>> f259412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static j f259413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f259414d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f259415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f259416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f259417c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f259415a, r101.f259415a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f259416b, r101.f259416b) == true) goto L15;
            return false;
        L15:
            if (this.f259417c == r101.f259417c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f259415a.hashCode() * 31) + this.f259416b.hashCode()) * 31;
            if (this.f259417c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "TemplateLoadState(templateId=" + this.f259415a + ", geckoVersion=" + this.f259416b + ", loadState=" + this.f259417c + ')';
        }

        public a(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TEMPLATE_ID);
            Intrinsics.checkNotNullParameter(r101, "geckoVersion");
            this.f259415a = r100;
            this.f259416b = r101;
            this.f259417c = r102;
        }
    }

    static {
        f259414d = LazyKt.lazy(TemplateLoader$loaderHandler$2.INSTANCE);
    }
}
