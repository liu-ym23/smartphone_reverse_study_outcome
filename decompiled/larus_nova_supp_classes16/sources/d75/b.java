package d75;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import com.bytedance.ee.bear.drive.biz.versions.Hilt_VersionOperationRecordV2Activity;
import com.bytedance.ee.bear.drive.biz.versions.VersionOperationRecordV2Activity;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_VersionOperationRecordV2Activity a;

    public b(Hilt_VersionOperationRecordV2Activity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_VersionOperationRecordV2Activity r3 = this.a;
        if (r3.e == true) goto L6;
        r3.e = true;
        ((o) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent()).E0((VersionOperationRecordV2Activity) UnsafeCasts.unsafeCast(r3));
        return;
    }
}
