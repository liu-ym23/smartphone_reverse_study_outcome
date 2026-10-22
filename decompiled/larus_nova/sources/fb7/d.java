package fb7;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f476277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f476278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f476279f;

    @Override // fb7.b
    public int getType() {
        return 2;
    }

    public d() {
    }

    public d(Bundle r100) {
        this.f476267a = r100.getInt(ParamKeyConstants.BaseParams.ERROR_CODE);
        this.f476268b = r100.getString(ParamKeyConstants.BaseParams.ERROR_MSG);
        this.f476269c = r100.getBundle(ParamKeyConstants.BaseParams.EXTRA);
        this.f476277d = r100.getString(ParamKeyConstants.AuthParams.AUTH_CODE);
        this.f476278e = r100.getString(ParamKeyConstants.AuthParams.STATE);
        this.f476279f = r100.getString(ParamKeyConstants.AuthParams.GRANTED_PERMISSION);
    }

    @Override // fb7.b
    public final void a(Bundle r100) {
        super.a(r100);
        r100.putString(ParamKeyConstants.AuthParams.AUTH_CODE, this.f476277d);
        r100.putString(ParamKeyConstants.AuthParams.STATE, this.f476278e);
        r100.putString(ParamKeyConstants.AuthParams.GRANTED_PERMISSION, this.f476279f);
    }
}
