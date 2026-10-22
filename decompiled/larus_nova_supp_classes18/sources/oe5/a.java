package oe5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends com.bytedance.ies.xbridge.model.params.a {
    public static final /* synthetic */ int g = 0;
    public String a;
    public boolean b;
    public boolean c;
    public String d;
    public HashMap<String, Serializable> e;
    public HashMap<String, Serializable> f;

    /* JADX INFO: renamed from: oe5.a$a, reason: collision with other inner class name */
    public static final class C0281a {
    }

    static {
    }

    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"schema", "replace", "useSysBrowser", "shareContextID", "initialProperties", "panelParam"});
    }

    public a() {
    }
}
