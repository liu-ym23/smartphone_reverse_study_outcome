package jua;

import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends AbstractBaseSettingHandler.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f500504i;

    /* JADX INFO: renamed from: jua.a$a, reason: collision with other inner class name */
    public static class C6487a implements npb.a {
        public C6487a() {
        }

        @Override // npb.a
        public final void a() {
        }

        @Override // npb.a
        public final String getTag() {
            return "AbTestHandler";
        }

        @Override // npb.a
        public final Collection<AbstractBaseSettingHandler> b() {
            return new HashSet(((ConcurrentHashMap) b.f500505a).values());
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, a> f500505a = null;

        static {
            f500505a = new ConcurrentHashMap();
            Iterator<String> r100 = ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAllAbTestKeys().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            String r101 = r100.next();
            Map<String, a> r102 = f500505a;
            ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
            r103.put(r101, new a(r101));
            goto L4
        }
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
    public final String f() {
        return "AbTestHandler";
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.a
    public final String a() {
        return this.f500504i;
    }

    public a(String r100) {
        this.f500504i = r100;
        AbstractBaseSettingHandler.a r101 = this.f431106e;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f431107f = r101;
    }
}
