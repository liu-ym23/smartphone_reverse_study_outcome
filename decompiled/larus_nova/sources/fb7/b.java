package fb7;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* JADX INFO: loaded from: classes22.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f476267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f476268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f476269c;

    public abstract int getType();

    public b() {
    }

    public void a(Bundle r100) {
        r100.putInt(ParamKeyConstants.BaseParams.ERROR_CODE, this.f476267a);
        r100.putString(ParamKeyConstants.BaseParams.ERROR_MSG, this.f476268b);
        r100.putInt(ParamKeyConstants.BaseParams.TYPE, getType());
        r100.putBundle(ParamKeyConstants.BaseParams.EXTRA, this.f476269c);
    }
}
