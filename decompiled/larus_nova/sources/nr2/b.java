package nr2;

import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.lang.reflect.Type;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements a {
    public b() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // nr2.a
    public final void G2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (f.getContext() == null) goto L7;
        ((HashMap) f.f158360b).remove(r100);
        f.f158359a.edit().remove(r100).apply();
        return;
    }

    @Override // nr2.a
    public final <T> T G0(String r100, Type r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        if (f.getContext() != null) goto L6;
        Boolean r102 = Boolean.FALSE;
    L14:
        if (r102.booleanValue() == true) goto L25;
        return null;
    L25:
        T r103 = (T) f.b(new Property(r100, r101));
        if ((r103 instanceof String) == true) goto L18;
        return r103;
    L18:
        if ((true ^ Intrinsics.areEqual(r101, String.class)) == false) goto L28;
        String r104 = (String) f.b(new Property(r100, String.class));     // Catch: ClassCastException -> L21
        return (T) GsonProtectorUtils.fromJson(x60.b.f562576a, r104, r101);
    L28:
        return r103;
    L21:
        String r105 = (String) f.b(new Property(r100, String.class));
        return (T) GsonProtectorUtils.fromJson(x60.b.f562576a, r105, r101);
    L6:
        if (((HashMap) f.f158360b).containsKey(r100) == false) goto L8;
    L11:
        boolean r106 = true;
    L12:
        r102 = Boolean.valueOf(r106);
        goto L14
    L8:
        if (f.f158359a.contains(r100) == true) goto L11;
        r106 = false;
        goto L12
    }

    @Override // nr2.a
    public final <T> void Va(String r100, T r101, Type r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "type");
        f.d(new Property(r100, r102), r101);     // Catch: Exception -> L5
        return;
    L6:
        if (f.getContext() == null) goto L9;
        ((HashMap) f.f158360b).remove(r100);
        f.f158359a.edit().remove(r100).apply();
    L9:
        f.d(new Property(r100, r102), r101);
    }
}
