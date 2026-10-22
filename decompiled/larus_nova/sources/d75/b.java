package d75;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import com.bytedance.ee.bear.drive.biz.versions.Hilt_VersionOperationRecordV2Activity;
import com.bytedance.ee.bear.drive.biz.versions.VersionOperationRecordV2Activity;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_VersionOperationRecordV2Activity f467236a;

    public b(Hilt_VersionOperationRecordV2Activity r100) {
        this.f467236a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_VersionOperationRecordV2Activity r101 = this.f467236a;
        if (r101.f223961e == true) goto L6;
        r101.f223961e = true;
        ((o) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent()).E0((VersionOperationRecordV2Activity) UnsafeCasts.unsafeCast(r101));
        return;
    }
}
