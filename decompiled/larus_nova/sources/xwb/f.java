package xwb;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;

/* JADX INFO: loaded from: classes37.dex */
public interface f<T, D> {
    void a(Object r100, d r101, String r102, OfficeWebView r103);

    BridgeAuthType authType();

    boolean shouldRunInUIThread();
}
