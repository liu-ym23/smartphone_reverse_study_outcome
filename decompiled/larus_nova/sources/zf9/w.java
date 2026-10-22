package zf9;

import android.net.Uri;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<v> f571782a = null;

    static {
        f571782a = CollectionsKt.listOf(new v[]{b0.f571768a, a.f571763a});
    }

    public static final void a(String r100, Uri r101, int r102, int r103, int r104, int r105) {
        FLogger.f375446a.i(r100, "use strategy for " + r101 + ", img=" + r102 + Permission.EXECUTE + r103 + ", view=" + r104 + Permission.EXECUTE + r105);
    }
}
