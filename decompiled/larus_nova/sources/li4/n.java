package li4;

import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.creativex.mediaimport.repository.api.MediaType;
import com.bytedance.creativex.mediaimport.repository.internal.main.MediaItemInternal;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class n extends m<ki4.r> {
    @Override // li4.m
    public final MediaItemInternal g(String r210, long r211) {
        Intrinsics.checkNotNullParameter(r210, "path");
        if (d().isClosed() == true) goto L8;
        long r100 = d().getLong(((Number) this.f509335f.getValue()).intValue());     // Catch: Exception -> L10
        int r101 = d().getInt(((Number) this.f509338i.getValue()).intValue());     // Catch: Exception -> L10
        int r110 = d().getInt(((Number) this.f509339j.getValue()).intValue());     // Catch: Exception -> L10
        String r111 = d().getString(((Number) this.f509341l.getValue()).intValue());     // Catch: Exception -> L10
        String r112 = d().getString(((Number) this.f509337h.getValue()).intValue());     // Catch: Exception -> L10
        String r113 = d().getString(((Number) this.f509345p.getValue()).intValue());     // Catch: Exception -> L10
        String r114 = d().getString(((Number) this.f509344o.getValue()).intValue());     // Catch: Exception -> L10
        return new MediaItemInternal(BuiltInMaterialType.IMAGE, MediaType.IMAGE, e(), r100, r210, r101, r110, r211, 0, r114, r113, r111, r112, f(r210), c(r210, r100), 16640);
    L8:
        return null;
    }

    public n(boolean r100, boolean r101, ki4.e<ki4.r> r102) {
        Intrinsics.checkNotNullParameter(r102, "cursorParseFilter");
        super(MediaType.IMAGE, r100, r101, r102);
    }
}
