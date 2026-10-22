package retrofit2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class Retrofit$Builder {

    @Nullable
    private HttpUrl baseUrl;
    private final List<CallAdapter.Factory> callAdapterFactories;

    @Nullable
    private Call.a callFactory;

    @Nullable
    private Executor callbackExecutor;
    private final List<g.a> converterFactories;
    private final q platform;
    private boolean validateEagerly;

    public Retrofit$Builder() {
        this(q.a);
    }

    public Retrofit build() {
        if (this.baseUrl == null) goto L13;
        OkHttpClient r0 = this.callFactory;
        if (r0 != null) goto L7;
        r0 = new OkHttpClient();
    L7:
        OkHttpClient r2 = r0;
        Executor r1 = this.callbackExecutor;
        if (r1 != null) goto L10;
        r1 = this.platform.d();
    L10:
        Executor r6 = r1;
        ArrayList r3 = new ArrayList(this.callAdapterFactories);
        r3.addAll(this.platform.b(r6));
        ArrayList r4 = new ArrayList((this.converterFactories.size() + 1) + this.platform.f());
        r4.add(new a());
        r4.addAll(this.converterFactories);
        r4.addAll(this.platform.e());
        return new Retrofit(r2, this.baseUrl, Collections.unmodifiableList(r4), Collections.unmodifiableList(r3), r6, this.validateEagerly);
    L13:
        throw new IllegalStateException("Base URL required.");
    }

    public List<CallAdapter.Factory> callAdapterFactories() {
        return this.callAdapterFactories;
    }

    public List<g.a> converterFactories() {
        return this.converterFactories;
    }

    public Retrofit$Builder(Retrofit r5) {
        this.converterFactories = new ArrayList();
        this.callAdapterFactories = new ArrayList();
        q r0 = q.a;
        this.platform = r0;
        this.callFactory = r5.callFactory;
        this.baseUrl = r5.baseUrl;
        int r1 = r5.converterFactories.size() - r0.f();
        int r2 = 1;
    L3:
        if (r2 >= r1) goto L5;
        this.converterFactories.add((g.a) ListProtector.get(r5.converterFactories, r2));
        r2 = r2 + 1;
        goto L3
    L5:
        int r3 = r5.callAdapterFactories.size() - this.platform.c();
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L8;
        this.callAdapterFactories.add((CallAdapter.Factory) ListProtector.get(r5.callAdapterFactories, r4));
        r4 = r4 + 1;
        goto L6
    L8:
        this.callbackExecutor = r5.callbackExecutor;
        this.validateEagerly = r5.validateEagerly;
    }

    public Retrofit$Builder addCallAdapterFactory(CallAdapter.Factory r3) {
        List<CallAdapter.Factory> r0 = this.callAdapterFactories;
        u.a(r3, "factory == null");
        r0.add(r3);
        return this;
    }

    public Retrofit$Builder addConverterFactory(g.a r3) {
        List<g.a> r0 = this.converterFactories;
        u.a(r3, "factory == null");
        r0.add(r3);
        return this;
    }

    public Retrofit$Builder baseUrl(HttpUrl r4) {
        u.a(r4, "baseUrl == null");
        List r0 = r4.pathSegments();
        if (XmlPullParser.NO_NAMESPACE.equals(ListProtector.get(r0, r0.size() - 1)) == false) goto L7;
        this.baseUrl = r4;
        return this;
    L7:
        throw new IllegalArgumentException("baseUrl must end in /: " + r4);
    }

    public Retrofit$Builder callFactory(Call.a r2) {
        u.a(r2, "factory == null");
        this.callFactory = r2;
        return this;
    }

    public Retrofit$Builder callbackExecutor(Executor r2) {
        u.a(r2, "executor == null");
        this.callbackExecutor = r2;
        return this;
    }

    public Retrofit$Builder client(OkHttpClient r2) {
        u.a(r2, "client == null");
        return callFactory(r2);
    }

    public Retrofit$Builder validateEagerly(boolean r1) {
        this.validateEagerly = r1;
        return this;
    }

    public Retrofit$Builder(q r2) {
        this.converterFactories = new ArrayList();
        this.callAdapterFactories = new ArrayList();
        this.platform = r2;
    }

    public Retrofit$Builder baseUrl(String r2) {
        u.a(r2, "baseUrl == null");
        return baseUrl(HttpUrl.get(r2));
    }
}
