package lr;

import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;
import com.bytedance.android.shopping.api.address.AddressUpdateDialogConfig;
import com.bytedance.android.shopping.api.address.IAddressService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class b implements IAddressService {
    public b() {
    }

    @Override // com.bytedance.android.shopping.api.address.IAddressService
    public final o83.a getAddress(Object r100, String r101, int r102) {
        return null;
    }

    @Override // com.bytedance.android.shopping.api.address.IAddressService
    public final AddressUpdateDialogConfig getAddressUpdateDialogConfig() {
        return null;
    }

    @Override // com.bytedance.android.shopping.api.address.IAddressService
    public final String getBtmCodeInSaas(String r100) {
        return "";
    }

    @Override // com.bytedance.android.shopping.api.address.IAddressService
    public final void setAddress(JSONObject r100, int r101, boolean r102, o83.e r103, o83.d r104) {
    }

    @Override // com.bytedance.android.shopping.api.address.IAddressService
    public final void showAddressUpdateDialog(String r100) {
    }
}
