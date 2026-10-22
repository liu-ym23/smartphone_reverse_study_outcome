package com.bytedance.debugrouter.usb;

import com.bytedance.ttnet.utils.RetrofitUtils;
import com.lynx.debugrouter.base.usb.IUSBHijackService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/debugrouter/usb/USBHijackServiceImpl;", "Lcom/lynx/debugrouter/base/usb/IUSBHijackService;", "()V", "TAG", "", "addInterceptor", "", "DebugRouterServiceImpl_release"}, k = 1, mv = {1, 4, 2})
public final class USBHijackServiceImpl implements IUSBHijackService {
    private final String TAG;

    @Override // com.lynx.debugrouter.base.usb.IUSBHijackService
    public void addInterceptor() {
        RetrofitUtils.addInterceptor(new USBInsteadNetInterceptor());
    }

    public USBHijackServiceImpl() {
        this.TAG = "USBHijackServiceImpl";
    }
}
