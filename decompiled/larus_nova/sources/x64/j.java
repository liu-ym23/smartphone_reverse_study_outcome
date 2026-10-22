package x64;

import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.utils.n;
import java.nio.charset.Charset;
import kotlin.TypeCastException;
import kotlin.UInt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public j() {
    }

    public abstract h b();

    public z64.c a(l r100) {
        BadgerCore.Companion.getClass();
        String r101 = com.bytedance.badger.j.a().getDeviceId();
        int r102 = n.f199273a;
        Charset r103 = Charsets.UTF_8;
        if (r101 == null) goto L7;
        return new z64.d(UInt.m9590toStringimpl(UInt.m9544constructorimpl(n.a(r101.getBytes(r103)))), r100.f562629b, r101, r100.f562632e, 8);
    L7:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
