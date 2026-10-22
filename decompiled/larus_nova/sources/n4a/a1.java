package n4a;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* JADX INFO: loaded from: classes32.dex */
public final class a1 extends b1 {
    public a1(c1 r100) {
        super(r100);
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r100) {
        StringBuffer r101 = new StringBuffer();
        r101.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        r101.append(" ");
        r101.append(UUID.randomUUID().toString());
        r101.append(" ");
        if (r101.length() != 53) goto L5;
        byte[] r102 = f5.j(r101.toString());
        byte[] r103 = new byte[r102.length + r100.length];
        System.arraycopy(r102, 0, r103, 0, r102.length);
        System.arraycopy(r100, 0, r103, r102.length, r100.length);
        return r103;
    L5:
        return new byte[0];
    }
}
