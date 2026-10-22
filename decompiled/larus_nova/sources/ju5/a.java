package ju5;

import androidx.room.RoomDatabase;
import com.commonsware.cwac.saferoom.SafeHelperFactory;
import java.util.HashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Integer, String> f500491a = null;

    static {
        HashMap<Integer, String> r100 = new HashMap();
        f500491a = r100;
        r100.put(0, SafeHelperFactory.POST_KEY_SQL_V3);
        r100.put(1, "PRAGMA cipher_compatibility = 4;");
        r100.put(2, "PRAGMA cipher_compatibility = 3;PRAGMA cipher_use_hmac = OFF;PRAGMA kdf_iter = 4000;PRAGMA cipher_page_size = 1024;");
    }

    public static void a(RoomDatabase.Builder r100, String r101, int r102) {
        tt5.a.h("CipherDBUtils", "insertAfterKeyingSql... cipherConfig = " + r102);
        HashMap<Integer, String> r103 = f500491a;
        if (r103.containsKey(Integer.valueOf(r102)) == false) goto L7;
        r100.openHelperFactory(new SafeHelperFactory(r101.toCharArray(), SafeHelperFactory.Options.builder().setClearPassphrase(false).setPostKeySql(r103.get(Integer.valueOf(r102))).build()));
        return;
    L7:
        throw new RuntimeException("After keying cipher config is illegal : " + r102);
    }
}
