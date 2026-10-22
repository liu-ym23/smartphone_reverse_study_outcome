package p94;

import com.bytedance.bdp.appbase.context.service.operate.sync.ResultType;
import com.bytedance.bdp.bdpbase.util.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f528295d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResultType f528296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f528298c;

    /* JADX INFO: renamed from: p94.a$a, reason: collision with other inner class name */
    public static final class C7168a {
        public static a a(Integer r100, String r101) {
            ResultType r102 = ResultType.ERROR_PLATFORM_SERVER;
            if (r100 == null) goto L6;
            r100.intValue();
        L6:
            if (r101 != null) goto L9;
            r101 = null;
        L9:
            a r103 = new a(r102, r101, null);
            r103.b();
            return r103;
        }
    }

    static {
    }

    public String a() {
        ResultType r100 = this.f528296a;
        boolean r101 = true;
        if (r100 != ResultType.OK) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        return r100.getDesc();
    L10:
        if (r100 != ResultType.ERROR_NATIVE_EXCEPTION) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L20;
        StringBuilder r104 = new StringBuilder();
        r104.append(this.f528296a.getDesc());
        r104.append(" stacktrace: ");
        Throwable r105 = this.f528298c;
        if (r105 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        r104.append(l.a(r105, 5));
        return r104.toString();
    L20:
        if (r100 == ResultType.ERROR_CUSTOM) goto L23;
        r101 = false;
    L23:
        String r106 = "";
        if (r101 == true) goto L31;
        StringBuilder r107 = new StringBuilder();
        r107.append(this.f528296a.getDesc());
        r107.append(" errMsg: ");
        String r108 = this.f528297b;
        if (r108 == null) goto L29;
        r106 = r108;
    L29:
        r107.append(r106);
        return r107.toString();
    L31:
        return "";
    L12:
        r103 = false;
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    public final void b() {
        if (this.f528296a != ResultType.OK) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L9;
        g94.b.b("BaseOperateResult", new Object[]{a()});
        return;
    L9:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public a(ResultType r100, String r101, Throwable r102) {
        this.f528296a = r100;
        this.f528297b = r101;
        this.f528298c = r102;
    }
}
