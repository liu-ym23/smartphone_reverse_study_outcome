package w;

import bytedance.io.exception.IllegalPathException;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<y.b> f557765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f557766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f557767c;

    public final y.a a(y.a r100) throws IllegalPathException {
        if (this.f557766b >= this.f557765a.size()) goto L5;
        int r101 = this.f557767c + 1;
        this.f557767c = r101;
        if (r101 > 1) goto L45;
        y.b r102 = (y.b) ListProtector.get(this.f557765a, this.f557766b);
        if (r102 == null) goto L36;
        r102.toString();
    L36:
        y.a r103 = r102.resolve();
        if (r103 != null) goto L39;
        a.C8054a.f557764a.getClass();
        throw new NullPointerException("resolver " + r102 + " returned null");
    L39:
        if (r103.f565555a == null) goto L41;
        return r103;
    L41:
        a.C8054a.f557764a.getClass();
        throw new IllegalStateException("resolver " + r102 + " returned a file with no body");
    L45:
        a.C8054a.f557764a.getClass();
        throw new IllegalStateException("FileResolver " + ListProtector.get(this.f557765a, this.f557766b - 1) + " must call handle() exactly once");
    L5:
        if (r100.f565555a == null) goto L7;
    L30:
        return r100;
    L7:
        if (r100.f565557c == null) goto L30;
        String r104 = r100.f565556b;
        if (r104 != null) goto L11;
    L29:
        r100.f565555a = r100.f565557c;
        goto L30
    L11:
        if (r104.isEmpty() == true) goto L29;
        String r105 = r100.f565556b;
        String r106 = r100.f565557c;
        if (r106.isEmpty() == false) goto L15;
    L27:
        r106 = r105;
    L28:
        r100.f565555a = r106;
        goto L30
    L15:
        if (r106.equals(HTTP.URL_DEFAULT) == true) goto L27;
        if (r106.charAt(0) != '/') goto L24;
        if (r105.equals(HTTP.URL_DEFAULT) == true) goto L28;
        r106 = r105.concat(r106);
        goto L28
    L24:
        if (r105.equals(HTTP.URL_DEFAULT) == false) goto L26;
        r106 = r105.concat(r106);
        goto L28
    L26:
        r105 = r105 + '/' + r106;
        goto L27
    }

    public b(List r100, int r101) {
        this.f557765a = r100;
        this.f557766b = r101;
    }
}
