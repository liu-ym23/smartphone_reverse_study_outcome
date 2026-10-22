package mtc;

import io.opentelemetry.api.internal.i;
import itc.d;
import itc.g;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f515703a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f515704b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f515705c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f515706d = null;

    public c() {
    }

    public abstract g b();

    @Nullable
    public abstract String c();

    static {
        f515703a = Logger.getLogger(c.class.getName());
        itc.b r100 = itc.b.f495767d;
        f515704b = a(r100, null);
        i r101 = ptc.a.f530688a;
        if (r101 != null) goto L5;
    L7:
        f515705c = a(r100, null);
        d r102 = new d();
        r102.b(ptc.a.f530689b, "opentelemetry");
        r102.b(ptc.a.f530690c, "java");
        i r103 = ptc.a.f530691d;
        String r104 = "unknown";
        Properties r105 = new Properties();
        r105.load(c.class.getResourceAsStream("/io/opentelemetry/sdk/common/version.properties"));     // Catch: Exception -> L10
        r104 = r105.getProperty("sdk.version", "unknown");
    L11:
        r102.b(r103, r104);
        a r106 = a(r102.a(), null);
        a r107 = f515705c;
        r107.getClass();
        if (r106 == f515704b) goto L32;
        d r108 = new d();
        g r109 = r107.f515702f;
        if (r109 == null) goto L18;
        r109.forEach(new itc.c(r108));
    L18:
        g r110 = r106.f515702f;
        if (r110 == null) goto L22;
        r110.forEach(new itc.c(r108));
    L22:
        String r111 = r106.f515701e;
        if (r111 != null) goto L25;
        r107 = a(r108.a(), r107.f515701e);
        goto L32
    L25:
        String r112 = r107.f515701e;
        if (r112 != null) goto L29;
        r107 = a(r108.a(), r106.f515701e);
        goto L32
    L29:
        if (r111.equals(r112) == true) goto L31;
        f515703a.info("Attempting to merge Resources with different schemaUrls. The resulting Resource will have no schemaUrl assigned. Schema 1: " + r107.f515701e + " Schema 2: " + r106.f515701e);
        r107 = a(r108.a(), null);
        goto L32
    L31:
        r107 = a(r108.a(), r107.f515701e);
    L32:
        f515706d = r107;
        return;
    L5:
        if (r101.f492676b.isEmpty() == true) goto L7;
        r100 = new itc.b(new Object[]{r101, "unknown_service:java"});
        goto L7
    }

    public static a a(itc.b r100, @Nullable String r101) {
        Objects.requireNonNull(r100, "attributes");
        r100.forEach(new b());
        return new a(r101, r100);
    }
}
