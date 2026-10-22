package k66;

import com.alipay.sdk.m.p.e;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f501959f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f501960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f501961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f501962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public XReadableMap f501963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public XReadableMap f501964e;

    /* JADX INFO: renamed from: k66.a$a, reason: collision with other inner class name */
    public static final class C6512a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"url", "addCommonParams", e.f25671s, ContainerPosition.BODY, "params", "header", "bodyType"});
    }

    public a() {
    }
}
