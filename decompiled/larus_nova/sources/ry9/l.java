package ry9;

import com.larus.platform.model.creation.ResourceExt;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f539950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<ResourceExt> f539951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f539952c;

    public l() {
        this(false, 7);
    }

    public /* synthetic */ l(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r101 & 2) == 0) goto L8;
        ArrayList r102 = new ArrayList();
    L9:
        this(r100, r102, false);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public l(boolean r100, ArrayList<ResourceExt> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "dataList");
        this.f539950a = r100;
        this.f539951b = r101;
        this.f539952c = r102;
    }
}
