package li4;

import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.creativex.mediaimport.repository.api.MediaType;
import com.bytedance.creativex.mediaimport.repository.internal.main.MediaItemInternal;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class u extends m<ki4.r> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f509355u;

    @Override // li4.m
    public final MediaItemInternal g(String r210, long r211) {
        Intrinsics.checkNotNullParameter(r210, "path");
        if (StringsKt.endsWith$default(r210.toLowerCase(Locale.getDefault()), ".ts", false, 2, null) == true) goto L10;
        long r110 = d().getLong(((Number) this.f509355u.getValue()).intValue());
        if (r110 <= 0) goto L11;
        long r100 = d().getLong(((Number) this.f509335f.getValue()).intValue());
        int r101 = d().getInt(((Number) this.f509338i.getValue()).intValue());
        int r111 = d().getInt(((Number) this.f509339j.getValue()).intValue());
        String r112 = d().getString(((Number) this.f509341l.getValue()).intValue());
        String r113 = d().getString(((Number) this.f509337h.getValue()).intValue());
        String r114 = d().getString(((Number) this.f509345p.getValue()).intValue());
        String r115 = d().getString(((Number) this.f509344o.getValue()).intValue());
        return new MediaItemInternal(BuiltInMaterialType.VIDEO, MediaType.VIDEO, e(), r100, r210, r101, r111, r211, r110, r115, r114, r112, r113, f(r210), c(r210, r100), 16384);
    L11:
        return null;
    L10:
        return null;
    }

    public u(boolean r100, boolean r101, ki4.e<ki4.r> r102) {
        Intrinsics.checkNotNullParameter(r102, "cursorParseFilter");
        super(MediaType.VIDEO, r100, r101, r102);
        this.f509355u = LazyKt.lazy(new t(this));
    }
}
