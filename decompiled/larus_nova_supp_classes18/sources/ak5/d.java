package ak5;

import com.bytedance.ee.bear.net.RawServerResult;
import com.bytedance.ee.bear.net.ServerResult;
import com.bytedance.ee.bear.net.ServerResultException;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T extends ServerResult> implements Function<T, T> {
    public final List<y> a;

    public final Object apply(Object r8) throws Exception {
        ServerResult r9 = (ServerResult) r8;
        int r1 = r9.getCode();
        if (r1 != 5) goto L11;
        List<y> r0 = this.a;
        if (r0 == null) goto L11;
        Iterator<y> r2 = r0.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        r2.next().a();
    L11:
        if (r1 != 0) goto L13;
        return r9;
    L13:
        if ((r9 instanceof RawServerResult) == false) goto L17;
        String r3 = r9.getMsg();
        String r4 = r9.getData();
        RawServerResult r10 = (RawServerResult) r9;
        throw new ServerResultException(r1, r3, r4, r10.getJson(), r10.getLogId());
    L17:
        throw new ServerResultException(r1, r9.getMsg(), r9.getData(), "", "");
    }

    public d(String r1, List<y> r2) {
        this.a = r2;
    }
}
