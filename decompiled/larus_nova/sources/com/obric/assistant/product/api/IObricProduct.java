package com.obric.assistant.product.api;

import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/obric/assistant/product/api/IObricProduct;", "", "initProductSdk", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricProduct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f391167a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f391168a = null;

        static {
            f391168a = new a();
        }

        public a() {
        }

        public static IObricProduct a() {
            if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L7;
            return null;
        L7:
            return (IObricProduct) ServiceManager.get().getService(IObricProduct.class);
        }
    }

    static {
        f391167a = a.f391168a;
    }

    void a();
}
