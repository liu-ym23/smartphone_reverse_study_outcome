package com.bytedance.jedi.model.combine;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.jedi.model.datasource.IDataSource;
import com.bytedance.jedi.model.fetcher.AbstractFetcher;
import com.bytedance.jedi.model.fetcher.IFetcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u0005*\u0004\b\u0005\u0010\u00062\u00020\u0007:\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/jedi/model/combine/Combine;", "K", "V", "REQ", "RESP", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "", "Companion", "Mapper", "model_release"}, k = 1, mv = {1, 7, 1})
public final class Combine<K, V, REQ, RESP, K1, V1> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f251051d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IFetcher<K, V, REQ, RESP> f251052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDataSource<K1, V1> f251053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Mapper<K, RESP, K1, V1> f251054c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/combine/Combine$Companion;", "", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0006\u0010\u0001*\u0004\b\u0007\u0010\u0002*\u0004\b\b\u0010\u0003*\u0004\b\t\u0010\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/jedi/model/combine/Combine$Mapper;", "K", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
    public static final class Mapper<K, V, K1, V1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<? super K, ? extends K1> f251055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<? super V1, ? extends V> f251056b;

        public Mapper() {
            this.f251055a = Combine$Mapper$_key$1.INSTANCE;
            this.f251056b = Combine$Mapper$_map$1.INSTANCE;
        }
    }

    static {
        f251051d = new Companion(0);
    }

    public Combine(AbstractFetcher r100, IDataSource r101, Mapper r102) {
        this.f251052a = r100;
        this.f251053b = r101;
        this.f251054c = r102;
    }
}
