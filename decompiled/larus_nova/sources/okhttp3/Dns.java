package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface Dns {
    public static final Dns SYSTEM = null;

    public static class a implements Dns {
        public a() {
        }

        @Override // okhttp3.Dns
        public final List<InetAddress> lookup(String r100) throws UnknownHostException {
            if (r100 == null) goto L9;
            return Arrays.asList(InetAddress.getAllByName(r100));
        L5:
            e = move-exception;
            UnknownHostException r101 = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(r100));
            r101.initCause(e);
            throw r101;
        L9:
            throw new UnknownHostException("hostname == null");
        }
    }

    List<InetAddress> lookup(String r100) throws UnknownHostException;

    static {
        SYSTEM = new a();
    }
}
