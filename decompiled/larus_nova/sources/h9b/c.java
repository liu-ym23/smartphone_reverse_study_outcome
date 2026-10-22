package h9b;

import com.larus.nova.R;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {
    static {
    }

    public static String a() {
        if (ContactBaseModuleDependency.f418857b.isSmallB() == false) goto L5;
        String r100 = UIHelper.getString(R.string.Lark_NewContacts_AddContactsb);
        Intrinsics.checkNotNull(r100);
        return r100;
    L5:
        String r101 = UIHelper.getString(R.string.Lark_NewContacts_AddExternalContactsB);
        Intrinsics.checkNotNull(r101);
        return r101;
    }
}
