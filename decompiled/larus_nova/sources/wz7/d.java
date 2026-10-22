package wz7;

import android.graphics.drawable.Drawable;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.AvatarType;

/* JADX INFO: loaded from: classes24.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AvatarType f561963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f561964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f561965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AvatarModel.Size f561966d;

    public d() {
        this(null, 3);
    }

    public d(AvatarType r100, Drawable r101) {
        this.f561963a = r100;
        this.f561964b = r101;
        this.f561966d = AvatarModel.Size.MINI;
    }

    public /* synthetic */ d(AvatarType r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = AvatarType.UNKNOWN;
    L5:
        this(r100, null);
    }
}
