package oe5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f522999g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f523000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f523001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f523002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f523003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, Serializable> f523004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap<String, Serializable> f523005f;

    /* JADX INFO: renamed from: oe5.a$a, reason: collision with other inner class name */
    public static final class C7040a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"schema", "replace", "useSysBrowser", "shareContextID", "initialProperties", "panelParam"});
    }

    public a() {
    }
}
