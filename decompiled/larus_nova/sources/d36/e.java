package d36;

import android.view.View;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f466736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f466737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f466738c;

    public final String toString() {
        StringCompanionObject r100 = StringCompanionObject.INSTANCE;
        return String.format("ViewInfo @%d view %s, name %s, monitor-name %s", Arrays.copyOf(new Object[]{Integer.valueOf(hashCode()), this.f466736a.getClass().getSimpleName(), this.f466737b, this.f466738c}, 4));
    }

    public e(View r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "mView");
        Intrinsics.checkNotNullParameter(r101, "mTagName");
        Intrinsics.checkNotNullParameter(r103, "url");
        this.f466736a = r100;
        this.f466737b = r101;
        this.f466738c = r102;
    }
}
