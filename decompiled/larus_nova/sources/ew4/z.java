package ew4;

import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.passportc.dwarf.UserScope;

/* JADX INFO: loaded from: classes16.dex */
@UserScope
public interface z extends IOfficeSDKProtocol {

    public static final class a {
        public static g a() {
            LarkAppContext.Companion.getClass();
            if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L7;
            return null;
        L7:
            return new g(Integer.valueOf(R.drawable.icon_dbx_ic_keyboard_mobile_outlined));
        }
    }

    boolean H0();

    boolean c(DialogFragment r100, CommentImageSelectorDismissReason r101);

    DialogFragment e(c r100, e r101);

    boolean f();

    boolean f1();

    g l();

    boolean o1();
}
