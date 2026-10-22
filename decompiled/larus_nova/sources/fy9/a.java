package fy9;

import java.util.UUID;

/* JADX INFO: loaded from: classes31.dex */
public final class a {
    static {
    }

    public static String a() {
        StringBuilder r100 = new StringBuilder();
        r100.append(UUID.randomUUID());
        r100.append('_');
        r100.append(System.currentTimeMillis());
        return r100.toString();
    }
}
