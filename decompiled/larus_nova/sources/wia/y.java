package wia;

import android.net.Uri;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f559910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IUriFileReceiver f559911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f559912c;

    public y(Uri r100, IUriFileReceiver r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "uriToOpen");
        Intrinsics.checkNotNullParameter(r101, "forReceiver");
        Intrinsics.checkNotNullParameter(r102, "receiverPackage");
        this.f559910a = r100;
        this.f559911b = r101;
        this.f559912c = r102;
    }
}
