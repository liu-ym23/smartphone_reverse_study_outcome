package nlb;

import android.graphics.drawable.Drawable;
import com.larksuite.framework.utils.LogSafetyTools;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: classes36.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VFSPath f519575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f519576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f519577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.lark.imagewidget.largeimage.transform.b f519578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f519579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f519580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageUtils.ImageType f519581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f519582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f519583i;

    public g() {
    }

    public final String toString() {
        return "path=" + LogSafetyTools.a(this.f519575a.getRealPath()) + ",width=" + this.f519579e + ",height=" + this.f519580f + ",imageType=" + this.f519581g + ",isAnimatedImage=" + this.f519582h + ",isSecret=" + this.f519577c + ",option=" + this.f519578d;
    }
}
