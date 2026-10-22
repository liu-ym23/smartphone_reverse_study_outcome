package gm5;

import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.passportc.dwarf.UserScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@UserScope
public interface a extends IOfficeSDKProtocol {
    Function1<String, Unit> getOnSelectionShowCallBack();
}
